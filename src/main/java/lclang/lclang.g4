grammar lclang;
WS : ('//'(.+?)[\n\r]|'/*'(.+?)'*/'|([ \t\r\n])+) -> skip;
METHOD: 'method';
BOOL: 'true'|'false';
ID: [A-Za-z-]+;
STRING: '"'(.+?)'"';
LONG: [0-9]+ 'L';
INTEGER: [0-9]+;

file: use* global* (stmt|method|component|classExpr)*;
type: ID ('\\' type)*;

expression:
    expression multiplication='*' expression
    | expression add='+' expression
    | primitive;

primitive: (returnExpr|call|fixedVariable
               |value|variable|array|typeGet) arrayAccess* operation?;

value: BOOL|STRING|LONG|INTEGER;
call: type ('(' expression (',' expression)* ')'|'()');
returnExpr: 'return' expression?;
typeGet: '*' expression;
array: '[' expression (',' expression)* ']'|'[]';
arrayAccess: '[' expression ']'|'[]';
variable: ID;
fixedVariable: 'fixed' ID;

operation: access|set;
set: '=' expression;
access: '.' expression;

stmt: block|ifStmt|expression ';';
ifStmt: 'if ' condition=expression ':' ifT=stmt ('else' ifF=stmt)?;
block: '{' stmt* '}';

component: 'component' type '{' (method|classExpr)* '}';
classExpr: 'class' ID '{' (method|field)* '}';
field: ID '=' expression;

arg: type? ID;
args: '(' arg (',' arg)*')'|'()';
attribute: '@' ID;
method: attribute* METHOD ID args (':' type)? block;

//File expressions
use: 'use' type ('from' STRING)? ';';
global: 'global' ID '=' value ';';