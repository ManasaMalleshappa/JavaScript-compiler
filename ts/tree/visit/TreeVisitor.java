
package ts.tree.visit;

import ts.tree.*;

/**
 * All visitor classes for ASTs will implement this interface, which is
 * parameterized by return type.
 *
 */
public interface TreeVisitor<T> {
	T visit(BinaryOperator binaryOperator);

	T visit(ExpressionStatement expressionStatement);

	T visit(Identifier identifier);

	T visit(NumericLiteral numericLiteral);

	T visit(PrintStatement printStatement);

	T visit(Program programStatement);

	T visit(StringLiteral stringLiteral);

	T visit(VarStatement varStatement);

	T visit(UnaryOperator unaryOperator);

	T visit(BooleanLiteral booleanLiteral);

	T visit(NullLiteral nullLiteral);

	T visit(EmptyStatement emptyStatement);

	T visit(BlockStatement blockStatement);

	T visit(WhileStatement whileStatement);

	T visit(BreakStatement breakStatement);

	T visit(ContinueStatement continueStatement);

	T visit(IfStatement ifStatement);

	T visit(ThrowStatement throwStatement);

	T visit(FinallyStatement finallyStatement);

	T visit(TryStatement tryStatement);

	T visit(CatchStatement catchStatement);

	T visit(FunctionExpression functionExpression);

	T visit(CallExpression callExpression);

	T visit(ReturnStatement returnStatement);

	T visit(ObjLiteral objLiteral);

	T visit(PropAccessor propAccessor);

	T visit(propAssignment propAssignment);

	T visit(NewExpression newExpression);

	T visit(This this1);

}
