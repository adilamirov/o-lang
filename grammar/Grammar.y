//Identifier
%token IDENTIFIER


//Variables
%token INTEGERLITERAL
%token REALLITERAL
%token BOOLEANLITERAL

// Keywords
%token CLASS
%token EXTENDS
%token IS
%token END
%token VAR
%token METHOD
%token THIS
%token WHILE
%token LOOP
%token IF
%token THEN
%token ELSE
%token RETURN

// Delimiters
%token LPAREN          //  (
%token RPAREN          //  )
%token LBRACKET        //  [
%token RBRACKET        //  ]
%token COMMA           //  ,
%token DOT             //  .
%token COLON           //  :

// Operator signs
%token ASSIGN           //  :=


%%
//PROGRAM
Program
: ClassDeclaration Program
|
;

//CLASS 
ClassDeclaration
: CLASS ClassName EXTENDS ClassName IS MemberDeclarations
  END
| CLASS ClassName IS MemberDeclarations 
  END
;

ClassName
: LBRACKET IDENTIFIER RBRACKET 
|
;


//MEMBER 
MemberDeclarations
: MemberDeclarations MemberDeclaration
|
;

MemberDeclaration
: VariableDeclaration
| MethodDeclaration
| ConstructorDeclaration
;


//VARIABLE

VariableDeclaration : VAR IDENTIFIER COLON Expression ;


//METHOD

MethodDeclaration
: METHOD IDENTIFIER Parameters COLON IDENTIFIER
    IS Body END
| METHOD IDENTIFIER COLON IDENTIFIER
    IS Body END
| METHOD IDENTIFIER Parameters
    IS Body END
;


//PARAMETER

Parameters
: LPAREN ParameterDeclaration ParameterDeclarations RPAREN
;

ParameterDeclarations
: ParameterDeclarations COLON ParameterDeclaration
|
;

ParameterDeclaration: IDENTIFIER COLON ClassName ;


//BODY

Body
: Body VariableDeclaration
| Body Statement
|
;

//CONSTRUCTOR

ConstructorDeclaration
: THIS Parameters IS Body END 
|THIS IS Body END 
;


Assignment: IDENTIFIER ASSIGN Expression ;

WhileLoop: WHILE Expression LOOP Body END ;


Statement
: Assignment
| WhileLoop
| IfStatement
| ReturnStatement
;

IfStatement
: IF Expression THEN Body ELSE Body END 
| IF Expression THEN Body END ;

ReturnStatement
: RETURN ReturnExpression
;

ReturnExpression
: Expression
|
;

//EXPRESSION
Expression
: Primary ExpressionBody
;

ExpressionBody
: ExpressionBody DOT IDENTIFIER Arguments
| ExpressionBody DOT IDENTIFIER
|
;


//ARGUMENT
Arguments: LPAREN Expression ArgumentExpression RPAREN ;

ArgumentExpression
: ArgumentExpression COMMA Expression
|
;

Primary
: INTEGERLITERAL
| REALLITERAL
| BOOLEANLITERAL
| THIS
| ClassName
;



