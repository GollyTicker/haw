grammar PuzzleSolver;

options {
	output=AST;
	ASTLabelType=CommonTree;
}

tokens {
	BLOCK;
	CONDS;
	OPS;
}

@header {
import org.antlr.tool.*;
import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import org.antlr.stringtemplate.*;
}

// mit ^ kann man den root des Unterbaums festlegen.
// mit ! sagt man, was fuer den AST ignoriert werden soll
// mit -> kann man Tree Rewrites machen und die Stuktur ganz selber vorgeben

// Siehe Folien:
// https://pub.informatik.haw-hamburg.de/home/pub/prof/neitzke/Compiler%20und%20Interpreter/Vorlesungsfolien/CI04%20-%20Zwischencode%20alt.pdf#page=65&zoom=page-fit,0,540

prog    :   c1=row NL opRow=op_row  NL c2=row  NL eq_row  NL c3=row
	{
	//System.out.println("Ops:" + $opRow.tree.toStringTree());
	System.out.println("OpLeft:" + $opRow.opLeft + "; OpMid:" + $opRow.opMid + "; OpRight:" + $opRow.opRight);
	System.out.println("c1.first: " + $c1.first.toStringTree());
	System.out.println("c2.first: " + $c2.first.toStringTree());
	System.out.println("c3.first: " + $c3.first.toStringTree());
	CommonTree myTree = new CommonTree(new CommonToken(OP, opRow.opLeft)); 
	myTree.addChild(c1.first);
	myTree.addChild(c2.first);
	myTree.addChild(c3.first);
	System.out.println("myTree: " + myTree.toStringTree());
	}
			-> ^(CONDS row row row)// it is also possible to insert java code here, to create the AST. See. Antlr Reference p.170
    ;

row	returns[Tree first, Tree second, Tree third]
	:
	fst=grouped_ids op=OP snd=grouped_ids EQ thr=grouped_ids
	{$first=$fst.tree;}
	{$second=$snd.tree;}
	{$third=$thr.tree;}
	-> ^($op $fst $snd $thr)
;


op_row	returns[String opLeft, String opMid, String opRight]
	:   opl=OP opm=OP opr=OP
	{$opLeft=$opl.text;}
	{$opMid=$opm.text; }
	{$opRight=$opr.text;}
    	-> ^(OPS OP OP OP)
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

