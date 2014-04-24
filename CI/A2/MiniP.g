grammar MiniP;

options {
	output=AST;
	ASTLabelType=CommonTree;
}

tokens {
	SLIST;
	IDLIST;
	MAIN;
	DECLS;
}

main : PROGRAM decls=declaration+ BEGIN statements END -> ^(MAIN ^(DECLS $decls) statements)
;

declaration: TYPE^ ids SEMICOL!
;

ids : ID (COMMA ID)*	-> ^(IDLIST ID*)
;

var_def : ID DEF expression -> ^(DEF ID expression)
;

expression
	: BOOL -> BOOL
	| STRING -> STRING
	| ar_exp -> ar_exp
;


BOOL : 'true' | 'false'
;


ifStmt : 'if'^ (BOOL | cmp ) 'then'! statements ('else'! statements)? 'fi'!
;

whileStmt
: 'while'^ (BOOL | cmp) 'do'! statements 'od'!
;

io_stmt : ('print' | 'println' | 'read')^ '('! expression ')'!
;
ar_exp
: product (STRICH_OP^ product)* 
;

product : ar_term (PUNKT_OP^ ar_term)*
;

ar_term : ID | numberconst | '('! ar_exp ')'!
;

cmp : ar_exp RELOP^ ar_exp
;

statement
: ifStmt
| whileStmt
| io_stmt
| var_def
;

statements
	: (statement SEMICOL)+
	-> ^(SLIST statement+)
;

numberconst
	: INT -> INT
	| FLOAT -> FLOAT
;

DEF : ':='
    ;

PUNKT_OP : ('*' | '/')
    ;
    
STRICH_OP : ('+' | '-')
    ;

RELOP : ('=' | '<>' | '<' | '<=' | '>' | '>=')
    ;

PROGRAM : 'program'
;

BEGIN : 'begin'
;

END : 'end'
;

TYPE : ('integer' | 'string' | 'real' | 'boolean')
;

SEMICOL : ';'
    ;

COMMA : ','
    ;

FLOAT
    : ('0'..'9')+ '.' ('0'..'9')*
    ;
    
INT : ('0'..'9')+
    ;

STRING
    : '"' ('a'..'z'|'A'..'Z' | ' ' | '0'..'9')* '"'
    ;

ID : ('a'..'z' | 'A'..'Z') ('0'..'9' | ('a'..'z' | 'A'..'Z') |'_')*
    ;

COMMENT
    : '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
    ;

WS : ( ' '
        | '\t'
        | '\r'
        | '\n'
        ) {$channel=HIDDEN;}
    ;

fragment
DIGIT : ('0'..'9')
;

fragment
LETTER : ('a'..'z' | 'A'..'Z')
    ;

fragment
HEX_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F')
;

fragment
ESC_SEQ
    : '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
    | UNICODE_ESC
    | OCTAL_ESC
    ;

fragment
OCTAL_ESC
    : '\\' ('0'..'3') ('0'..'7') ('0'..'7')
    | '\\' ('0'..'7') ('0'..'7')
    | '\\' ('0'..'7')
    ;

fragment
UNICODE_ESC
    : '\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
    ;
