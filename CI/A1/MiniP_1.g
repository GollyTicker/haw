grammar MiniP_1;

main 	: PROGRAM declaration+ BEGIN END
	;

declaration 
	:	TYPE ids END_EXPR
	;

ids 	:	ID  (COMMA ID)*;

val_dec : ID DEF expression
	;

expression : ar_exp | BOOL | STRING | cmp
	;

DEF : ':='
    ;
    
ar_exp	:	NUMBERCONST ar_exp_ | ID ar_exp_ | '(' ar_exp ')'
	;
	
ar_exp_	:	PUNKT_OP ar_exp
	| 	STRICH_OP ar_exp
	| 
	;

cmp	:	'cmp'
	;

BOOL	:	'true' | 'false'
	;

CONST	:	NUMBERCONST | STRING | BOOL
	;

NUMBERCONST
	:	INT | FLOAT
	;

PUNKT_OP : ('*' | '/')
    ;
    
STRICH_OP : ('+' | '-')
    ;

AR_PRE : ('+' | '-')
    ;

RELOP : ('=' | '<>' | '<' | '<=' | '>' | '>=')
    ;

PROGRAM 	:	'program'
;

BEGIN 	:	'begin'
;

END 	:	'end'
;

TYPE 	:	('integer' | 'string' | 'real' | 'boolean')
	;

END_EXPR 	:     ';'
    ;

COMMA    :     ','
    ;

INT :	('0'..'9')+
    ;

FLOAT
    :   ('0'..'9')+ '.' ('0'..'9')*
    ;

STRING
    :  '\'' ( ESC_SEQ | ~('\\'|'\'') )* '\''
    ;

ID  :	('a'..'z' | 'A'..'Z') ('0'..'9' | ('a'..'z' | 'A'..'Z') |'_')*
    ;

COMMENT
    :   '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
    ;

WS  :   ( ' '
        | '\t'
        | '\r'
        | '\n'
        ) {$channel=HIDDEN;}
    ;

fragment
DIGIT	:	('0'..'9')
	;

fragment
LETTER :    ('a'..'z' | 'A'..'Z')
    ;

fragment
EXPONENT : ('e'|'E') ('+'|'-')? ('0'..'9')+ 
;

fragment
HEX_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F') 
;

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
