grammar lclang;
WS : ([ \t\r\n])+ -> skip;
FUNCTION: ':'|'method';
ID: [A-z]+;
STRING: '"'(.+?)'"';
NUMBER: [0-9]+;

file: use* global* (stmt|method|component|classExpr)*;
type: ID ('\\' type)*;

expression: (returnExpr|call|ID|value) arrayAccess* operation?;
value: STRING|NUMBER;
call: type '(' expression (',' expression)* ')'|'()';
returnExpr: 'return' expression?;
arrayAccess: '[' expression ']';

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