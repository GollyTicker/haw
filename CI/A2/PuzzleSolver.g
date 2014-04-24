grammar PuzzleSolver;

options {
	output=AST;
	ASTLabelType=CommonTree;
}

tokens {
	BLOCK;
	CONDS;
	OPS;
	PLUS;
}

@header {
import org.antlr.tool.*;
import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import org.antlr.stringtemplate.*;
}

@members {

public static CommonTree buildFromBILD(String operator, Tree first, Tree second, Tree third) {
	CommonTree vertical = new CommonTree(new CommonToken(PLUS,"PLUS"));
	if(operator.trim().equals("-")) {
		vertical.addChild(second);
		vertical.addChild(third);
		vertical.addChild(first);
	}
	else {
		vertical.addChild(first);
		vertical.addChild(second);
		vertical.addChild(third);
	}
	return vertical;
}

}

// mit ^ kann man den root des Unterbaums festlegen.
// mit ! sagt man, was fuer den AST ignoriert werden soll
// mit -> kann man Tree Rewrites machen und die Stuktur ganz selber vorgeben

// Siehe Folien:
// https://pub.informatik.haw-hamburg.de/home/pub/prof/neitzke/Compiler%20und%20Interpreter/Vorlesungsfolien/CI04%20-%20Zwischencode%20alt.pdf#page=65&zoom=page-fit,0,540	

prog	:   	c1=row NL
		opRow=op_row NL
		c2=row NL
		eq_row NL
		c3=row
	{
	// First Vertical Condition
	CommonTree leftVertical = buildFromBILD(opRow.left, c1.left, c2.left, c3.left);
	
	// Second Vertical Condition
	CommonTree midVertical = buildFromBILD(opRow.mid, c1.mid, c2.mid, c3.mid);
	
	// Third Vertical Condition
	CommonTree rightVertical = buildFromBILD(opRow.right, c1.right, c2.right, c3.right);
	
        System.out.println("leftVertical: " + leftVertical.toStringTree());	// demonstration
        System.out.println("midVertical: " + midVertical.toStringTree());	// demonstration
        System.out.println(c2.tree.toStringTree());
	
	// http://www.docjar.com/docs/api/org/antlr/runtime/tree/Tree.html
	}
		-> ^(CONDS row row row {leftVertical})  // merging simply wont work....
		// it is also possible to insert java code here, to create the AST. See. Antlr Reference p.170
    ;

row	returns[Tree left, Tree mid, Tree right]
	:
	l=grouped_ids op=OP m=grouped_ids EQ r=grouped_ids
	{$left=$l.tree;}
	{$mid=$m.tree;}
	{$right=$r.tree;}
	-> { $op.text.trim().equals("-") }? ^(PLUS $m $r $l)	// case "-"
	->  ^(PLUS grouped_ids grouped_ids grouped_ids)	// general case "+"
;


op_row	returns[String left, String mid, String right]
	:   l=OP m=OP r=OP
	{$left=$l.text;}
	{$mid=$m.text; }
	{$right=$r.text;} 
	;

eq_row
    :    EQ! EQ! EQ!	// ignorieren aller '='
    ;

// die einzellnen Ids nach oben delegieren
grouped_ids
	:	ID+ -> ^(BLOCK ID+)
	;
    
NL	:	('\n' 
        | 	'\r')
	;

OP 	: 	('+'|'-')
	;

ID  	:	('A'..'Z')
    	;
    
EQ 	:	'='
	;

// Automated Stubs	
WS  :   ( ' '
        | '\t'
        ) {$channel=HIDDEN;}
    ;

CHAR:  '\'' ( ESC_SEQ | ~('\''|'\\') ) '\''
    ;

fragment
HEX_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F') ;

fragment
ESC_SEQ
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
    |   UNICODE_ESC
    |   OCTAL_ESC
    ;

fragment
OCTAL_ESC
    :   '\\' ('0'..'3') ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7')
    ;

fragment
UNICODE_ESC
    :   '\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
    ;

