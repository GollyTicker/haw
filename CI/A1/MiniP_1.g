grammar MiniP_1;

main 	: PROGRAM declaration+ BEGIN END
	;

declaration 
	:	TYPE ids ';'
	;

ids 	:	ID  (',' ID)*;

PROGRAM 	:	'program'
;

BEGIN 	:	'begin'
;

END 	:	'end'
;

TYPE 	:	('integer' | 'string' | 'real' | 'boolean')
	;

OP 	:	('+' | '-' | '*' | '/' | ',' | ';' | ':=' | '=' | '<>' | '<' | '<=' | '>' | '>=' | '(' | ')')
    ;
    
INT :	('0'..'9')+
    ;

FLOAT
    :   ('0'..'9')+ '.' ('0'..'9')* EXPONENT?
    |   '.' ('0'..'9')+ EXPONENT?
    |   ('0'..'9')+ EXPONENT
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
