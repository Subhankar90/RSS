grammar RSSGrammar;

parse : container EOF
 ;

container : (statement | functionDeclaration | classDeclaration)* ;

statement
 : assignment 
 | functionCall
 | ifStatement 
 | forStatement
 | variableDeclaration
 | returnDeclaration
 ;


assignment
 : Scope? Identifier ('[' (Number | Identifier)?  ']')? Assign expression
 ;
 
 functionCall
 : Identifier '(' exprList? ')' 	#identifierFunctionCall
 | Print '(' expression ')'			#printFunctionCall     
 ;
 
 ifStatement
 : ifStat elseIfStat* elseStat? End
 ;

ifStat
 : If expression  container
 ;

elseIfStat
 : Else If expression container
 ;

elseStat
 : Else container
 ;
 
 functionDeclaration
 : Func Identifier '(' argList? ')' (Returns Identifier)? container (returnDeclaration)? End
 ;
 
 returnDeclaration
 : Return expression
 ;
 
 argList
 : variableDeclaration (variableDeclaration)* ;
 
 classDeclaration
 : Class Identifier container End
 ;
 forStatement
 : For Identifier Assign expression Till expression container End
 ;

variableDeclaration
 : Identifier Identifier ('[' Number? ']')?
 ;


 exprList
 : expression (',' expression)*
 ;

expression :
   expression '*' expression                #multiplyExpression
 | expression '/' expression                #divideExpression
 | expression '%' expression                #modulusExpression
 | expression '+' expression                #addExpression
 | expression '-' expression                #subtractExpression
 | expression '>=' expression               #gtEqExpression
 | expression '<=' expression               #ltEqExpression
 | expression '>' expression                #gtExpression
 | expression '<' expression                #ltExpression
 | expression '==' expression               #eqExpression
 | expression '!=' expression               #notEqExpression
 | expression '&&' expression				#andExpression
 | expression '||' expression				#orExpression
 | Number                                   #numberExpression
 | Scope? Identifier ('[' (Number | Identifier)? ']')?      #identifierExpression
 | String 		                            #stringExpression
 | functionCall                  			#functionCallExpression
 | '(' expression ')' 		                #expressionExpression
 ;

Print    : 'print';
If		 : 'if';
Else	 : 'else';
End		 : 'end';
For 	 : 'for';
Till 	 : 'till';
While	 : 'while';
Func	 : 'func';
Class 	 : 'class' ;
Return   : 'return';
Returns  : 'returns';
Scope	 : '::';
Equals   : '==';
NEquals  : '!=';
GTEquals : '>=';
LTEquals : '<=';
GT       : '>';
LT       : '<';
Add      : '+';
Subtract : '-';
Multiply : '*';
Divide   : '/';
Assign   : '=';
 
Number
 : Int
 ;

Identifier
 : [a-zA-Z_] [a-zA-Z_0-9]*
 ;

String
 : ["] (~["\r\n] | '\\\\' | '\\"')* ["]
 | ['] (~["\r\n] | '\\\\' | '\\"')* [']
 ;

Comment
 : ('//' ~[\r\n]* | '/*' .*? '*/') -> skip
 ;

Space
 : [ \t\r\n\u000C] -> skip
 ;

fragment Int
 : [1-9] Digit*
 | '0'
 ;
  
fragment Digit 
 : [0-9]
 ;