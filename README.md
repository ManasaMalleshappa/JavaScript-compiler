# JavaScript-compiler

Generation of Javascript compiler following EcmaScript 5.1(http://www.ecma-international.org/ecma-262/5.1/#sec-8.3) in Java, using 
libraries like Javassist and ANTLR parser generator. 

Functionalities added to javascript compiler are

1.Boolean type and literals, Undefined type, Null type and literals, logical operators(not,equals,less than,greater than),String type and literals,arithmetic operators(+,-,*,/),unary minus,
 numeric literals and variable statement.
2.Block statement,Empty statement,While statement,If statement, Break and Continue statement,Throw and Try statement,Function expression and Function calls,Return statement,Function arguments.
3.Object initializers and Property accessors, new operator, global environment and global object, Built-in functions, this keyword
4.To check if the compiler built is performing as expected by implementing LL(1) grammar analysis
 Input : Grammar
 Output : non terminals,terminals,first set,follow set,predict set as output 
	        Determining if the grammar is LL(1) or not.
