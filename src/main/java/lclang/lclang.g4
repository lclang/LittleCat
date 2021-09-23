grammar lclang;

COMMENT : '/*'(.+?)'*/' -> skip;
LINE_COMMENT : '//'(.+?)[\n\r] -> skip;

OPEN : '(';
CLOSE : ')';
OPEN_BRACE : '{';
CLOSE_BRACE : '}';
OPEN_BRACKET : '[';
CLOSE_BRACKET : ']';

POW : '**';
EQUALS : '==';
NOT_EQUALS : '!=';
AND_BOOL : '&&';
OR_BOOL : '||';
LESS_EQUALS : '<=';
LARGER_EQUALS : '>=';
UNARY_ADD : '++';
UNARY_MINUS : '--';
NULLABLE_OR : '?:';
NULLABLE : '?';
LAMBDA_PREFIX : '->';

TYPE_PREFIX : '\\';
COMMA : ',';
SEMICOLON : ';';
ASSIGN : '=';
OR : '|';
AND : '&';
NOT : '!';
LESS : '<';
LARGER : '>';
MULTYPLICATION : '*';
DIVISION : '/';
ADD : '+';
MINUS : '-';
COLON : ':';
DOT : '.';
AS_ATTR: '@';

GLOBAL: 'global';
METHOD: 'method';
USE: 'use';
CLASS: 'class';
FROM: 'from';
COMPONENT: 'component';
STOP: 'stop';
RETURN: 'return';
WHILE: 'while';
IF: 'if';
ELSE: 'else';

NULL: 'null';
BOOL: 'true'|'false';
ID: [A-Za-z_]+;
STRING: '""'|'"'(.+?)'"';
CHAR: '\''.'\'';
HEX_LONG: '#'[1-9ABCDEF]+;
LONG: ([0-9]|[1-9][0-9]+) 'L';
DOUBLE: ([0-9]|[1-9][0-9]*)'.'[0-9]+;
INTEGER: [0-9]|[1-9][0-9]+;

WS : [ \t\r\n]+ -> skip;

file: use* global* (stmt|method|component|classExpr)* EOF;
type:
    nullable=NULLABLE?
    (
      methodType
    | baseType
    );
methodType: OPEN (type COMMA)* type? CLOSE LAMBDA_PREFIX returnType=type;
baseType: ID (TYPE_PREFIX baseType)?;

expression:
      expression or=OR_BOOL expression
    | expression and=AND_BOOL expression
    | expression equals=EQUALS expression
    | expression notEquals=NOT_EQUALS expression
    | expression less=LESS expression
    | expression larger=LARGER expression
    | expression largerEquals=LARGER_EQUALS expression
    | expression lessEquals=LESS_EQUALS expression
    | expression multiplication=MULTYPLICATION expression
    | expression div=DIVISION expression
    | expression add=ADD expression
    | expression minus=MINUS expression
    | expression pow=POW expression
    | expression assign=ASSIGN expression
    | expression nullableOr=NULLABLE_OR expression
    | expression unaryPlus=UNARY_ADD
    | expression unaryMinus=UNARY_MINUS
    | not=NOT expression
    | primitive access*;

primitive: (
                  parentnesesExpr
                | value
                | stop
                | ifExpr
                | returnExpr
                | newClass
                | variable
                | array
                | typeGet
                | lambda
                | container
           )

                arrayAccess*
                (call=OPEN (expression COMMA)* expression? CLOSE)?;

value: HEX_LONG|BOOL|STRING|CHAR|DOUBLE|LONG|INTEGER|NULL;
parentnesesExpr: OPEN expression CLOSE;
returnExpr: RETURN expression?;
typeGet: MULTYPLICATION expression;
access: DOT primitive;
array: OPEN_BRACKET (expression COMMA)* expression? CLOSE_BRACKET;
arrayAccess: OPEN_BRACKET expression CLOSE_BRACKET;
stop: STOP;
variable: ID;
lambda: LAMBDA_PREFIX args? (COLON type)? expression;
container: OPEN_BRACE stmt* CLOSE_BRACE;
ifExpr: IF condition=expression COLON ifT=expression ELSE ifF=expression;
newClass: COLON className=baseType;

stmt:
          block
        | whileStmt
        | ifStmt
        | expression SEMICOLON?

;

whileStmt: WHILE condition=expression (COLON stmt)?;
ifStmt: IF condition=expression COLON ifT=stmt (ELSE ifF=stmt)?;
block: OPEN_BRACE stmt* CLOSE_BRACE;

component: COMPONENT type OPEN_BRACE global* classExpr* CLOSE_BRACE;
classExpr: CLASS ID OPEN_BRACE (method|field)* CLOSE_BRACE;
field: ID (ASSIGN expression)?;

arg: ID (COLON type)?;
args: OPEN (arg COMMA)* arg? CLOSE;
attribute: AS_ATTR ID;
method: attribute* METHOD ID args (COLON type)? block;

//File expressions
use: USE useGlobal=GLOBAL baseType FROM STRING SEMICOLON?;
global: GLOBAL ID ASSIGN value SEMICOLON?;