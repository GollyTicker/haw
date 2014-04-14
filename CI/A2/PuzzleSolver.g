grammar PuzzleSolver;
options {
	output=AST;
	ASTLabelType=CommonTree;
}

// mit ^ kann man den root des Unterbaums festlegen.
// mit ! sagt man, was fuer den AST ignoriert werden soll
// mit -> kann man Tree Rewrites machen und die Stuktur ganz selber vorgeben

// Siehe Folien:
// https://pub.informatik.haw-hamburg.de/home/pub/prof/neitzke/Compiler%20und%20Interpreter/Vorlesungsfolien/CI04%20-%20Zwischencode%20alt.pdf#page=65&zoom=page-fit,0,540

prog    :   row NL! op_row  NL! row  NL! eq_row  NL! row
    ;

row     :   fst=grouped_ids op=OP^ snd=grouped_ids EQ! thr=grouped_ids
		{
			int minLen = 1;
			for(int i=0; i<=minLen; i++) {
				System.out.println($op.text + $fst.ids.get(i).text + $snd.ids.get(i).text + " = " + $thr.ids.get(i).text);
			}
		}
    ;

op_row
    :   OP! OP! OP!
    ;

eq_row
    :    EQ! EQ! EQ!
    ;

grouped_ids returns[List ids]
	:	(myIds+=ID)+
	{$ids=$myIds;}
	;
    
NL	:	('\n' 
        | 	'\r')
	;

OP 	: ('+'|'-')	
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

