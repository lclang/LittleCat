grammar lclang;
WS : ([ \t\r\n])+ -> skip;
FUNCTION: ':'|'method';
ID: [A-z]+;
STRING: '"'(.+?)'"';
LONG: [0-9]+ 'L';
INTEGER: [0-9]+;

file: use* global* (stmt|method|component|classExpr)*;
type: ID ('\\' type)*;

expression: (returnExpr|call|variable|value) arrayAccess* operation?;
value: STRING|LONG|INTEGER;
call: type ('(' expression (',' expression)* ')'|'()');
returnExpr: 'return' expression?;
arrayAccess: '[' expression ']';
variable: ID;

operation: access|set;
set: '=' expression;
access: '.' expression;

stmt: (block|expression ';');
block: '{' stmt* '}';

component: 'component' type '{' (method|classExpr)* '}';
classExpr: 'class' ID '{' (method|field)* '}';
field: ID '=' expression;

arg: type? ID;
args: '(' arg (',' arg)*')'|'()';
attribute: '@' ID;
method: attribute* FUNCTION ID args (':' type)? block;

//File expressions
use: 'use' type ('from' STRING)? ';';
global: 'global' ID '=' value;