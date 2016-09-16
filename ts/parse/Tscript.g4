//
// an ANTLR parser specification for a Tscript subset
//

grammar Tscript;

@header {
  import ts.Location;
  import ts.tree.*;
  import static ts.parse.TreeBuilder.*;
  import java.util.List;
  import java.util.ArrayList;
}

@members {
  // grab location info (filename/line/column) from token
  // in order to stick into AST nodes for later error reporting
  public Location loc(final Token token)
  {
    return new Location(getSourceName(), token.getLine(),
      token.getCharPositionInLine());
  }

  // root of AST is stored here
  // set by the action for the start symbol
  private Program semanticValue;
  public Program getSemanticValue()
  {
    return semanticValue;
  }
}

// grammar proper

program
  : sl=statementList EOF
    { semanticValue = buildProgram(loc($start), $sl.lval); }
  ;

statementList
  returns [ List<Statement> lval ]
  : // empty rule
    { $lval = new ArrayList<Statement>(); }
  | sl=statementList s=statement
    { $sl.lval.add($s.lval);
      $lval = $sl.lval; }
  ;

statement
  returns [ Statement lval ]
  : v=varStatement
    { $lval = $v.lval; }
  | e=expressionStatement
    { $lval = $e.lval; }
  | p=printStatement
    { $lval = $p.lval; }
  | es=emptyStatement
  	{ $lval = $es.lval; }
  | bs=blockStatement
    { $lval = $bs.lval; }
  | ws=whileStatement
  	{ $lval = $ws.lval; }
  | b = breakStatement
  	{ $lval = $b.lval; }
  | c = continueStatement
  	{ $lval = $c.lval; }
  | i = ifStatement
  	{ $lval = $i.lval; }
  | th = throwStatement
    { $lval = $th.lval; }
  | tr = tryStatement
  	{ $lval = $tr.lval; }
  | re=returnStatement
    { $lval = $re.lval;}
  ;
  


emptyStatement
  returns [ Statement lval ]
  : SEMICOLON
    { $lval = buildEmptyStatement(loc($start)); }
  ;

ifStatement
	returns [Statement lval]
	: IF LPAREN e=expression RPAREN s=statement
	{ $lval = buildIfStatement(loc($start),$e.lval,$s.lval,null) ;}
	| IF LPAREN e=expression RPAREN s=statement ELSE s1=statement
	{ $lval = buildIfStatement(loc($start),$e.lval,$s.lval,$s1.lval); }
	;
	
breakStatement
	returns [Statement lval]
	: BREAK SEMICOLON
	{ $lval = buildBreakStatement(loc($start),null); }
	;
	
continueStatement
	returns [Statement lval]
	: CONTINUE SEMICOLON
	{ $lval = buildContinueStatement(loc($start),null); }
	;

		
varStatement
  returns [ Statement lval ]
  : VAR IDENTIFIER SEMICOLON
    { $lval = buildVarStatement(loc($start), $IDENTIFIER.text); }
  ;

whileStatement
	returns [ Statement lval ]
	: WHILE LPAREN e=expression RPAREN s=statement
	{ $lval = buildWhileStatement(loc($start),$e.lval,$s.lval);}
	;

blockStatement
	returns [ Statement lval ]
	: LBRACE s=statementList RBRACE
	{ $lval = buildBlockStatement(loc($start), $s.lval);}
	;

returnStatement
	returns [Statement lval]
	:RETURN e=expression SEMICOLON
	{ $lval = buildReturnStatement(loc($start),$e.lval); }
	|RETURN SEMICOLON
	{ $lval = buildReturnStatement(loc($start),null);}
	;
	
expressionStatement
  returns [ Statement lval ]
  : e=expression SEMICOLON
    { $lval = buildExpressionStatement(loc($start), $e.lval); }
  ;

printStatement
  returns [ Statement lval ]
  : PRINT LPAREN e=expression RPAREN SEMICOLON
    { $lval = buildPrintStatement(loc($start), $e.lval); }
  ;

expression
  returns [ Expression lval ]
  : a=assignmentExpression
    { $lval = $a.lval; }
  ;

assignmentExpression
  returns [ Expression lval ]
  : a=equalityExpression
    { $lval = $a.lval; }
  | f=functionExpression
  	{ $lval = $f.lval; }
  |m = memberExpression
  	{ $lval = $m.lval; }
  | c=callExpression
  	{ $lval = $c.lval; }
  | l=leftHandSideExpression EQUAL r=assignmentExpression
    { checkAssignmentDestination(loc($start), $l.lval);
      $lval = buildBinaryOperator(loc($start), Binop.ASSIGN,
        $l.lval, $r.lval); }
  ;
  
functionExpression
	returns [Expression lval ]
	: FUNCTION LPAREN RPAREN b=blockStatement
	{ $lval = buildFunctionExpression(loc($start),null,null,$b.lval); }
	
	|FUNCTION LPAREN f=formalParameterList RPAREN b=blockStatement
	{ $lval = buildFunctionExpression(loc($start),null,$f.lval,$b.lval); }
	
	|FUNCTION IDENTIFIER LPAREN RPAREN b=blockStatement
	{ $lval = buildFunctionExpression(loc($start),$IDENTIFIER.text,null,$b.lval);}
	
	|FUNCTION IDENTIFIER LPAREN f1=formalParameterList RPAREN b=blockStatement
	{ $lval = buildFunctionExpression(loc($start),$IDENTIFIER.text,$f1.lval,$b.lval);}
	;

memberExpression
	returns [Expression lval]
	:p= primaryExpression
	{ $lval = $p.lval; }
	| f= functionExpression
	{ $lval = $f.lval;}
	| me=memberExpression '[' e=expression ']'
	{ $lval = buildpropAccessor(loc($start),$me.lval,$e.lval,null); }
	| m=memberExpression '.' IDENTIFIER
	{ $lval = buildpropAccessor(loc($start),$m.lval,null,$IDENTIFIER.text); }
	|NEW m=memberExpression LPAREN RPAREN
	{ $lval = buildNewExpression(loc($start),$m.lval); }
	;

	

callExpression
	returns [Expression lval]
	:m = memberExpression a=arguments
	{ $lval = buildCallExpression(loc($start),$m.lval,$a.lval);}
	
	| c1=callExpression a1=arguments
	{ $lval = buildCallExpression(loc($start),$c1.lval,$a1.lval); }
	
	| ce=callExpression '[' e=expression ']'
	{ $lval = buildpropAccessor(loc($start),$ce.lval,$e.lval,null); }
	
	| c=callExpression '.' IDENTIFIER
	{ $lval = buildpropAccessor(loc($start),$c.lval,null,$IDENTIFIER.text); }
	;


arguments
	returns [ List<Expression> lval ]
	: LPAREN RPAREN
	{ $lval = new ArrayList<Expression>(); }
	| LPAREN a=argumentList RPAREN
	{ $lval = $a.lval;}
	;
	
	
argumentList
	returns [ List<Expression> lval ]
	: a=assignmentExpression
	{
		if($lval == null){
		$lval = new ArrayList<Expression>();
		}
		$lval.add($a.lval);
	}
	| pl=argumentList ',' p=assignmentExpression
	{	if($pl.lval == null) {
		$pl.lval = new ArrayList<Expression>();
		}
		$pl.lval.add($p.lval);
		$lval = $pl.lval;
	}
	;
	
formalParameterList
	returns [ List<Expression> lval ]
	: IDENTIFIER
	{
		if($lval == null){
		$lval = new ArrayList<Expression>();
		}
		$lval.add(buildIdentifier(loc($start),$IDENTIFIER.text));
	}
	| pl=formalParameterList ',' IDENTIFIER
	{	if($pl.lval == null) {
		$pl.lval = new ArrayList<Expression>();
		}
		$pl.lval.add(buildIdentifier(loc($start),$IDENTIFIER.text));
		$lval = $pl.lval;
	}
	;
	
	
equalityExpression
	returns [Expression lval ]
	:a=relationalExpression
	{ $lval = $a.lval; }
	|l=equalityExpression EQUALTO r=relationalExpression
	{$lval = buildBinaryOperator(loc($start), Binop.EQUAL,
        $l.lval, $r.lval);}
    ;

leftHandSideExpression
  returns [ Expression lval ]
  : p=primaryExpression
    { $lval = $p.lval; }
  |	c=callExpression
  	{ $lval = $c.lval; }
  | m=memberExpression
  	{ $lval = $m.lval; }
  | n=newExpression
 	{ $lval = $n.lval; }
  ;
  
newExpression
	returns [Expression lval]
	:m = memberExpression
	{ $lval = $m.lval; }
	| NEW m1=newExpression
	{ $lval = buildNewExpression(loc($start),$m1.lval); }
	;
  
relationalExpression
	returns [ Expression lval ]
	: a=additiveExpression
	{ $lval = $a.lval;}
	|l=relationalExpression LESSTHAN r=additiveExpression
	{$lval = buildBinaryOperator(loc($start), Binop.LESS,
        $l.lval, $r.lval);}
    |l=relationalExpression GREATERTHAN r=additiveExpression
	{$lval = buildBinaryOperator(loc($start), Binop.GREAT,
        $l.lval, $r.lval);}
    ;
    
    	
additiveExpression
  returns [ Expression lval ]
  : m=multiplicativeExpression
    { $lval = $m.lval; }
  | l=additiveExpression PLUS r=multiplicativeExpression
    { $lval = buildBinaryOperator(loc($start), Binop.ADD,
        $l.lval, $r.lval); }
  | l=additiveExpression MINUS r=multiplicativeExpression
    { $lval = buildBinaryOperator(loc($start), Binop.SUB,
    	$l.lval, $r.lval); }
  ;

multiplicativeExpression
  returns [ Expression lval ]
  : p=unaryExpression
    { $lval = $p.lval; }
  | l=multiplicativeExpression ASTERISK r=unaryExpression
    { $lval = buildBinaryOperator(loc($start), Binop.MULTIPLY,
        $l.lval, $r.lval); }
  | l=multiplicativeExpression SLASH r=unaryExpression
  	{ $lval = buildBinaryOperator(loc($start),Binop.DIVIDE,
  	    $l.lval,$r.lval); }
  ;
  
unaryExpression
	returns [ Expression lval ]
	: p=primaryExpression
	 { $lval = $p.lval; }
	| MINUS r=unaryExpression
	 { $lval = buildUnaryOperator(loc($start),Unop.SUB,$r.lval); }
	| NOT r=unaryExpression
	 { $lval = buildUnaryOperator(loc($start),Unop.NOT,$r.lval); }
	| me=memberExpression
	 { $lval = $me.lval; }
;

tryStatement
  returns [ Statement lval ]
  : TRY b1 = blockStatement c1 = catchStatement
    { $lval = buildTryStatement(loc($start), $b1.lval, $c1.lval, null); }    
  | TRY b2 = blockStatement f1 = finallyStatement
    { $lval = buildTryStatement(loc($start), $b2.lval,null, $f1.lval ); }
  | TRY b3 = blockStatement c2 = catchStatement f2 = finallyStatement
    { $lval = buildTryStatement(loc($start), $b3.lval, $c2.lval, $f2.lval); }
  ;

objLiteral
	returns [ Expression lval ]
	: LBRACE RBRACE
	{ $lval = buildObjLiteral(loc($start),null); }
	| LBRACE p=propertyNameAndValueList RBRACE
	{ $lval = buildObjLiteral(loc($start),$p.lval); }
	;

propertyNameAndValueList
	returns [ List<Expression> lval ]
	: p=propertyAssignment
	{
		if($lval == null){
		$lval = new ArrayList<Expression>();
		}
		$lval.add($p.lval);
	}
	| pl=propertyNameAndValueList ',' p=propertyAssignment
	{	if($pl.lval == null) {
		$pl.lval = new ArrayList<Expression>();
		}
		$pl.lval.add($p.lval);
		$lval = $pl.lval;
	}
	;
	
propertyAssignment
	returns [ Expression lval ]
	: p=propertyName ':' a=assignmentExpression
	{ $lval = buildPropertyAssignment(loc($start),$p.lval,$a.lval); }
	;
	
propertyName
	returns [ StringLiteral lval ]
	: IDENTIFIER
	{$lval = buildPropertyName(loc($start),$IDENTIFIER.text); }
	| STRING_LITERAL
    { $lval = buildPropertyName(loc($start), $STRING_LITERAL.text); }
    | NUMERIC_LITERAL
    { $lval = buildPropertyName(loc($start), $NUMERIC_LITERAL.text); }
    ;
    
catchStatement
  returns [ Statement lval ]
  : CATCH LPAREN IDENTIFIER RPAREN b = blockStatement
    { $lval = buildCatchStatement(loc($start), $IDENTIFIER.text, $b.lval); }
  ;
  
finallyStatement
  returns [ Statement lval ]
  : FINALLY b = blockStatement
    { $lval = buildFinallyStatement(loc($start), $b.lval); }
  ;

throwStatement
  returns [ Statement lval ]
  : THROW e = expression SEMICOLON
    { $lval = buildThrowStatement(loc($start), $e.lval); }
  ;

primaryExpression
  returns [ Expression lval ]
  : IDENTIFIER
    { $lval = buildIdentifier(loc($start), $IDENTIFIER.text); }
  | NUMERIC_LITERAL
    { $lval = buildNumericLiteral(loc($start), $NUMERIC_LITERAL.text); }
  | STRING_LITERAL
    { $lval = buildStringLiteral(loc($start), $STRING_LITERAL.text); }
  |BOOLEAN_LITERAL
    { $lval = buildBooleanLiteral(loc($start),$BOOLEAN_LITERAL.text); }
  |NULL_LITERAL
    { $lval = buildNullLiteral(loc($start)); }
  | o=objLiteral
	{ $lval = $o.lval; }
  | LPAREN e=expression RPAREN
    { $lval = $e.lval; }
   | THIS
   {$lval = buildThis(loc($start)); }
  ;

// fragments to support the lexer rules

fragment Digit : [0-9];

fragment IdentifierCharacters : [a-zA-Z_$] [a-zA-Z0-9_$]*;

fragment SpaceTokens : SpaceChars | LineTerminator | EndOfLineComment;

fragment SpaceChars : ' ' | '\t' | '\f';

fragment EndOfLineComment : '//' ( ~[\n\r] )* (LineTerminator | EOF);

fragment LineTerminator : '\r' '\n' | '\r' | '\n';

fragment Letter : [a-zA-Z];

// lexer rules
//   keywords must appear before IDENTIFIER

// THIS WILL NEED TO BE IMPROVED
// cannot have a leading 0 unless the literal is just 0


fragment StringLiteral : ["] DoubleStringCharacters?["]
					   | ['] SingleStringCharacters? [']
					   ;
					   
fragment DoubleStringCharacters : DoubleStringCharacter DoubleStringCharacters?
								;
								
fragment SingleStringCharacters : SingleStringCharacter SingleStringCharacters?
								;
								
fragment DoubleStringCharacter : ~["\\] | LineTerminator | [\\] EscapeSequence
							;
							
fragment SingleStringCharacter : ~['\\] | LineTerminator | [\\] EscapeSequence
							;


fragment EscapeSequence : CharacterEscapeSequence ;

fragment CharacterEscapeSequence : SingleEscapeCharacter ;

fragment SingleEscapeCharacter : [\\n];




fragment NumericLiteral : DecimalLiteral | HexIntegerLiteral;

fragment DecimalLiteral : DecimalIntegerLiteral '.' DecimalDigits? ExponentPart?
                |'.' DecimalDigits ExponentPart?
 				|DecimalIntegerLiteral ExponentPart? ;


fragment DecimalIntegerLiteral : [0]
					  |NonZeroDigit DecimalDigits? ;
			 	

fragment DecimalDigit :  [0-9] ;

fragment DecimalDigits : [0-9]* ;

fragment NonZeroDigit : [1-9] ;

fragment ExponentPart : ExponentIndicator SignedInteger;

fragment ExponentIndicator : [eE] ;

fragment SignedInteger : DecimalDigits
			   | '+' DecimalDigits
			   | '-' DecimalDigits;

fragment HexIntegerLiteral : [0][x] HexDigit+
				  |[0][X] HexDigit+
				  ;
				  
fragment HexDigit : [0-9a-fA-F];


// THIS WILL NEED TO BE IMPROVED
// just a hack to allow numeric literals to be represented in strings
// as well as simple strings
//STRING_LITERAL : '"' (Digit | Letter | [+-.])* '"';

STRING_LITERAL : StringLiteral;

BOOLEAN_LITERAL : TRUE | FALSE;

NULL_LITERAL : NULL;

NUMERIC_LITERAL : NumericLiteral;

LPAREN : [(];
RPAREN : [)];
SEMICOLON : [;];
EQUAL : [=];
PLUS : [+];
ASTERISK : [*];
MINUS : [-];
NOT : [!];
LESSTHAN : [<];
SLASH : [/];
GREATERTHAN : [>];
EQUALTO : [=][=];
LBRACE : [{];
RBRACE : [}];

// keywords start here
PRINT : 'console.log';
VAR : 'var';
TRUE : 'true';
FALSE : 'false';
NULL : 'null';
WHILE : 'while';
CONTINUE : 'continue';
BREAK : 'break';
IF : 'if';
ELSE : 'else';
THROW : 'throw';
FINALLY : 'finally';
TRY : 'try';
CATCH:'catch';
NEW : 'new';
FUNCTION : 'function';
RETURN : 'return';
THIS : 'this';

IDENTIFIER : IdentifierCharacters;

// skip whitespace and comments

WhiteSpace : SpaceTokens+ -> skip;

