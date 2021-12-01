grammar lclang;

COMMENT : '/*'(.+?)'*/' -> skip;
LINE_COMMENT : '//'(.+?)([\n\r]|EOF) -> skip;

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
MULTIPLICATION : '*';
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
EXTENDS: 'extends';
COMPONENT: 'component';
STOP: 'stop';
RETURN: 'return';
WHILE: 'while';
AS: 'as';
IF: 'if';
IS: 'is';
ELSE: 'else';

BOOL: 'true'|'false';
ID: [A-Za-z_]+;
STRING: '"' (ESC| ~["\\])* '"';
CHAR: '\''(ESC | ~['\\])'\'';
HEX_LONG: '#'HEX+;
LONG: ([0-9]|[1-9][0-9]+) 'L';
DOUBLE: ([0-9]|[1-9][0-9]*)'.'[0-9]+;
INTEGER: [0-9]|[1-9][0-9]+;
WS : [ \t\r\n]+ -> skip;

fragment ESC: '\\' (["'\\/bnrt] | UNICODE);
fragment UNICODE: 'u' HEX HEX HEX HEX;
fragment HEX: [0-9A-f];
/** FILE STRUCTURE **/
file:
      use*
      global*           // Globals
      (                 // Body:
        stmt        |       // Statements
        method      |       // Methods
        component   |       // Components
        classExpr           // Classes
      )*

      EOF;


/** TYPE STRUCTURE **/
type:
    nullable=NULLABLE?   // Nullable prefix
    (
      magicType  |
      methodType |       // Lambda method type
      namedType          // Named type
    );


methodType: OPEN (args=type COMMA)* args=type? CLOSE LAMBDA_PREFIX returnType=type;
magicType: 'any'|'void'|'callable';
namedType: ID (TYPE_PREFIX namedType)?;

expression:
      expression arrayAccess=OPEN_BRACKET expression? CLOSE_BRACKET
    | expression is=IS type
    | expression access=DOT variable
    | expression call=OPEN (expression COMMA)* expression? CLOSE
    | expression or=OR_BOOL expression
    | expression and=AND_BOOL expression
    | expression equals=EQUALS expression
    | expression notEquals=NOT_EQUALS expression
    | expression less=LESS expression
    | expression larger=LARGER expression
    | expression largerEquals=LARGER_EQUALS expression
    | expression lessEquals=LESS_EQUALS expression
    | expression multiplication=MULTIPLICATION expression
    | expression div=DIVISION expression
    | expression add=ADD expression
    | expression minus=MINUS expression
    | expression pow=POW expression
    | expression assign=ASSIGN expression
    | expression add=ADD assign=ASSIGN expression
    | expression minus=ADD assign=ASSIGN expression
    | expression div=DIVISION assign=ASSIGN expression
    | expression multiplication=MULTIPLICATION assign=ASSIGN expression
    | expression pow=POW assign=ASSIGN expression
    | expression nullableOr=NULLABLE_OR expression
    | expression throwNull=NOT NOT
    | expression unaryPlus=UNARY_ADD
    | expression unaryMinus=UNARY_MINUS
    | not=NOT expression
    | primitive;

primitive: (
                  parentnesesExpr   |
                  value             |
                  stop              |
                  ifExpr            |
                  returnExpr        |
                  newClass          |
                  variable          |
                  array             |
                  typeGet           |
                  lambda            |
                  container
           );

value: HEX_LONG|BOOL|STRING|CHAR|DOUBLE|LONG|INTEGER;
parentnesesExpr: OPEN expression CLOSE;
returnExpr: RETURN expression?;
typeGet: MULTIPLICATION expression;
array: OPEN_BRACKET (expression COMMA)* expression? CLOSE_BRACKET;
stop: STOP;
variable: ID;
lambda: LAMBDA_PREFIX (OPEN (arg COMMA)* arg? CLOSE)? (COLON type)? expression;
container: OPEN_BRACE stmt* CLOSE_BRACE;
ifExpr: IF condition=expression COLON ifT=expression ELSE ifF=expression;
newClass: COLON className=namedType;

stmt:
        block       |
        whileStmt   |
        ifStmt      |
        expression SEMICOLON?
;

whileStmt: WHILE condition=expression (COLON stmt)?;
ifStmt: IF condition=expression COLON ifT=stmt (ELSE ifF=stmt)?;
block: OPEN_BRACE stmt* CLOSE_BRACE;

component: COMPONENT type OPEN_BRACE global* classExpr* CLOSE_BRACE;
classExpr: CLASS name=ID (OPEN (arg COMMA)* arg? CLOSE)? (EXTENDS classExtends=namedType (OPEN extendsArgs CLOSE)?)?
 (OPEN_BRACE (method|stmt)* CLOSE_BRACE)?;

extendsArgs: (expression COMMA)* expression?;

arg: ID (COLON type)?;
attribute: AS_ATTR ID;
method: attribute* METHOD ID OPEN (arg COMMA)* arg? CLOSE (COLON returnType=type)? (block|ASSIGN expression);

use: USE GLOBAL? name=ID (AS alias=ID) FROM (fromPackage=ID|fromFile=STRING) SEMICOLON?;

//File expressions
global: GLOBAL ID ASSIGN value SEMICOLON?;