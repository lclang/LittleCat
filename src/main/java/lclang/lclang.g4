grammar lclang;
WS : ('//'(.+?)[\n\r]|'/*'(.+?)'*/'|([ \t\r\n])+) -> skip;
METHOD: 'm'|'method';
BOOL: 'true'|'false';
ID: [A-Za-z]+;
STRING: '"'(.+?)?'"';
CHAR: '\''.'\'';
HEX_LONG: '#'[1-9ABCDEF]+;
LONG: [0-9]+ 'L';
DOUBLE: [0-9]*'.'[0-9]+;
INTEGER: [0-9]+;

file: use* global* (stmt|method|component|classExpr)*;
type:
    | methodType
    | baseType;
methodType: ('(' type (',' type)* ')')? '->' returnType=type;
baseType: ID ('\\' baseType)?;

expression:
      expression or='||' expression
    | expression and='&&' expression
    | expression equals='==' expression
    | expression notEquals='!=' expression
    | expression less='<' expression
    | expression larger='>' expression
    | expression largerEquals='>=' expression
    | expression lessEquals='<=' expression
    | expression multiplication='*' expression
    | expression div='/' expression
    | expression add='+' expression
    | expression minus='-' expression
    | expression pow='^' expression
    | primitive;

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
                access*
                (call='(' expression (',' expression)* ')'|call='()')?
                operation?;

value: HEX_LONG|BOOL|STRING|CHAR|DOUBLE|LONG|INTEGER;
parentnesesExpr: '(' expression ')';
returnExpr: 'return' expression?;
typeGet: '*' expression;
access: '.' variable;
array: '[]'|'[' expression (',' expression)* ']';
arrayAccess: '[]'|'[' expression ']';
stop: 'stop';
variable: ID;
lambda: '->' args expression;
container: '{' stmt* '}';
ifExpr: 'if ' condition=expression ':' ifT=expression 'else' ifF=expression;
newClass: ':' className=baseType;

operation: set;
set: '=' expression;

stmt:
          block
        | whileStmt
        | ifStmt
        | expression ';'?

;

whileStmt: 'while ' condition=expression ':' stmt;
ifStmt: 'if ' condition=expression ':' ifT=stmt ('else' ifF=stmt)?;
block: '{' stmt* '}';

component: 'component' type '{' global* classExpr* '}';
classExpr: 'class' ID '{' (method|field)* '}';
field: ID ('=' expression)?;

arg: ID (':' type)?;
args: '(' arg (',' arg)*')'|'()';
attribute: '@' ID;
method: attribute* METHOD ID args (':' type)? block;

//File expressions
use: 'use' useGlobal='global' baseType 'from' STRING ';'?;
global: 'global' ID '=' value ';'?;