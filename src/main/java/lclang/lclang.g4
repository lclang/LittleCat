grammar lclang;
WS : ('//'(.+?)[\n\r]|'/*'(.+?)'*/'|([ \t\r\n])+) -> skip;
METHOD: 'method';
BOOL: 'true'|'false';
ID: [A-Za-z-]+;
STRING: '"'(.+?)?'"';
CHAR: '\''.'\'';
HEX_LONG: '#'[1-9ABCDEF]+;
LONG: [0-9]+ 'L';
DOUBLE: [0-9]*'.'[0-9]+;
INTEGER: [0-9]+;

file: use* global* (stmt|method|component|classExpr)*;
type: ID ('\\' ID)*;

expression: '('expression')'
    | expression or='||' expression
    | expression and='&&' expression
    | expression equals='==' expression
    | expression notEquals='!=' expression
    | expression less='<' expression
    | expression larger='>' expression
    | expression lessEquals='>=' expression
    | expression largerEquals='<=' expression
    | expression multiplication='*' expression
    | expression div='/' expression
    | expression add='+' expression
    | expression minus='-' expression
    | expression pow='^' expression
    | primitive;

primitive: (ifExpr|returnExpr|call|fixedVariable
               |stop|value|variable|array|typeGet) arrayAccess* operation?;

value: HEX_LONG|BOOL|STRING|CHAR|DOUBLE|LONG|INTEGER;
call: type ('(' expression (',' expression)* ')'|'()');
returnExpr: 'return' expression?;
typeGet: '*' expression;
array: '[' expression (',' expression)* ']'|'[]';
arrayAccess: '[' expression ']'|'[]';
stop: 'stop';
variable: ID;
fixedVariable: 'fixed' ID;
ifExpr: 'if ' condition=expression ':' ifT=expression 'else' ifF=expression;

operation: access|set;
set: '=' expression;
access: '.' expression;

stmt: block|whileStmt|ifStmt|expression ';';
whileStmt: 'while ' condition=expression ':' stmt;
ifStmt: 'if ' condition=expression ':' ifT=stmt ('else' ifF=stmt)?;
block: '{' stmt* '}';

component: 'component' type '{' (method|classExpr)* '}';
classExpr: 'class' ID '{' (method|field)* '}';
field: ID ('=' expression)?;

arg: type? ID;
args: '(' arg (',' arg)*')'|'()';
attribute: '@' ID;
method: attribute* METHOD ID args (':' type)? block;

//File expressions
use: 'use' type ('from' STRING)? ';';
global: 'global' ID '=' value ';';