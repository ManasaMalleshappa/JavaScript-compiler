
package ts.tree.visit;

import ts.tree.*;
import ts.tree.type.*;

import java.io.PrintWriter;
import java.util.List;

/**
 * Dump an AST to a stream. Uses prefix order with indentation.
 * <p>
 * Using Object for the type parameter but there is really no return type.
 * <p>
 * The "visit" method is overloaded for each tree node type.
 */
public final class Dump extends TreeVisitorBase<Object> {
	// where to write the dump to
	private PrintWriter writer;

	// current indentation amount
	private int indentation;

	// how much to increment the indentation by at each level
	// using an increment of zero would mean no indentation
	private int increment;

	/**
	 * Initiate the dump even to the left margin and set the increment
	 * indentation amount to two spaces.
	 *
	 * @param writer
	 *            where to write the dump to.
	 */
	public Dump(final PrintWriter writer) {
		this(writer, 0, 2);
	}

	/**
	 * Initiate the dump at a specific distance from the left margin and set the
	 * increment indentation amount to a specific value.
	 *
	 * @param writer
	 *            where to write the dump to.
	 * @param indentation
	 *            initial indentation amount.
	 * @param increment
	 *            increment indentation amount.
	 */
	public Dump(final PrintWriter writer, final int indentation, final int increment) {
		this.writer = writer;
		this.indentation = indentation;
		this.increment = increment;
	}

	// generate a string of spaces for current indentation level
	private void indent() {
		for (int i = 0; i < indentation; i++) {
			writer.print(" ");
		}
	}

	/**
	 * Visit a list of ASTs and dump them in order. Uses a wildcard for
	 * generality: list of Statements, list of Expressions, etc.
	 */
	@Override
	public List<Object> visitEach(final Iterable<?> nodes) {
		for (final Object node : nodes) {
			visitNode((Tree) node);
		}
		return null;
	}

	/** Dump a binary operator. */
	@Override
	public Object visit(final BinaryOperator binaryOperator) {
		indent();
		writer.println(binaryOperator.getOpString() + " (" + binaryOperator.getType() + ") ");
		indentation += increment;
		visitNode(binaryOperator.getLeft());
		visitNode(binaryOperator.getRight());
		indentation -= increment;
		return null;
	}

	/** Dump a While Statement */

	public Object visit(final WhileStatement statement) {
		indent();
		writer.println(statement.getExp() + " (" + statement.getS() + ") ");
		indentation += increment;
		visitNode(statement.getExp());
		visitNode(statement.getS());
		indentation -= increment;
		return null;
	}

	/** Dump a Unary operator. */
	@Override
	public Object visit(final UnaryOperator unaryOperator) {
		indent();
		writer.println(unaryOperator.getOpString() + " (" + unaryOperator.getType() + ") ");
		indentation += increment;
		visitNode(unaryOperator.getAb());
		indentation -= increment;
		return null;
	}

	/** Dump an expression statement. */
	@Override
	public Object visit(final ExpressionStatement expressionStatement) {
		indent();
		writer.println("ExpressionStatement");
		indentation += increment;
		visitNode(expressionStatement.getExp());
		indentation -= increment;
		return null;
	}

	/** Continue Statement **/

	public Object visit(final ContinueStatement continueStatement) {
		indent();
		writer.println("ContinueStatement");
		return null;
	}

	/** Break Statement **/

	public Object visit(final BreakStatement breakStatement) {
		indent();
		writer.println("BreakStatement");
		return null;
	}

	/** Dump an identifier. */
	@Override
	public Object visit(final Identifier identifier) {
		// get the Type from the declaration tree node (if not null)
		VarStatement node = identifier.getVarNode();
		String typeString = null;
		if (node == null) {
			typeString = "<var is null>";
		} else {
			Type type = node.getType();
			if (type == null) {
				typeString = "<type is null>";
			} else {
				typeString = type.toString();
			}
		}

		// is it a lval or a rval?
		String valKind = null;
		if (identifier.isLval()) {
			valKind = "lval";
		} else {
			valKind = "rval";
		}

		// also a "local" type in the identifier node itself
		String locTypeString = null;
		Type locType = identifier.getType();
		if (locType == null) {
			locTypeString = "<null>";
		} else {
			locTypeString = locType.toString();
		}

		indent();
		writer.println("Identifier (" + typeString + " " + valKind + ") " + identifier.getName() + " " + locTypeString);
		return null;
	}

	/** Dump a numeric literal. */
	@Override
	public Object visit(final NumericLiteral numericLiteral) {
		indent();
		writer.println("NumericLiteral (" + numericLiteral.getType() + ") " + numericLiteral.getValue());
		return null;
	}

	/** Dump a boolean literal. */
	@Override
	public Object visit(final BooleanLiteral booleanLiteral) {
		indent();
		writer.println("BooleanLiteral (" + booleanLiteral.getType() + ") " + booleanLiteral.getValue());
		return null;
	}

	/** Dump a Null Literal. */
	@Override
	public Object visit(final NullLiteral nullLiteral) {
		indent();
		writer.println("NullLiteral (" + nullLiteral.getType() + ") " + nullLiteral.getValue());
		return null;
	}

	/** Dump a Empty Statement */
	public Object visit(final EmptyStatement emptyStatement) {
		indent();
		writer.println("EmptyStatement (" + emptyStatement.getType() + ") ");
		return null;
	}

	/** Dump a print statement. */
	@Override
	public Object visit(final PrintStatement printStatement) {
		indent();
		writer.println("PrintStatement");
		indentation += increment;
		visitNode(printStatement.getExp());
		indentation -= increment;
		return null;
	}

	/** Dump a program. */
	@Override
	public Object visit(final Program program) {
		indent();
		writer.println("Program");
		indentation += increment;
		visitEach(program.getList());
		indentation -= increment;
		return null;
	}

	/** Dump a string literal. */
	@Override
	public Object visit(final StringLiteral stringLiteral) {
		indent();
		writer.println("StringLiteral (" + stringLiteral.getType() + ") " + stringLiteral.getValue());
		return null;
	}

	/** Dump a var statement. */
	@Override
	public Object visit(final VarStatement varStatement) {
		Type type = varStatement.getType();
		String typeStr = null;
		if (type == null) {
			typeStr = "<null>";
		} else {
			typeStr = type.toString();
		}
		String capturedStr = null;
		if (varStatement.isCaptured()) {
			capturedStr = "captured";
		} else {
			capturedStr = "not-captured";
		}
		String redundantStr = null;
		if (varStatement.isCaptured()) {
			redundantStr = "redundant";
		} else {
			redundantStr = "not-redundant";
		}
		indent();
		writer.println("Var (" + typeStr + " " + varStatement.getFunctionDepth() + " " + varStatement.getTempName()
				+ " " + capturedStr + " " + redundantStr + ") " + varStatement.getName());
		return null;
	}

	/** Dump a Return statement. */
	@Override
	public Object visit(final ReturnStatement returnStatement) {
		indent();
		writer.println("ReturnStatement");
		indentation += increment;
		visitNode(returnStatement.getE());
		indentation -= increment;
		return null;
	}

	/** Dump a Block statement. */
	@Override
	public Object visit(final BlockStatement blockStatement) {
		indent();
		writer.println("BlockStatement");
		indentation += increment;
		visitEach(blockStatement.getList());
		indentation -= increment;
		return null;
	}

	/** Dump a IF statement. */
	@Override
	public Object visit(final IfStatement ifStatement) {
		indent();
		writer.println("IFStatement");
		indentation += increment;
		visitNode(ifStatement.getExp());
		visitNode(ifStatement.getS1());
		if (ifStatement.getS2() != null) {
			visitNode(ifStatement.getS2());
		}
		indentation -= increment;
		return null;
	}

	/** Dump a TRY statement. */
	@Override
	public Object visit(final TryStatement tryStatement) {
		indent();
		writer.println("TryStatement");
		indentation += increment;
		visitNode(tryStatement.getB());
		if (tryStatement.getC() != null) {
			visitNode(tryStatement.getC());
		}
		if (tryStatement.getF() != null) {
			visitNode(tryStatement.getF());
		}
		indentation -= increment;
		return null;
	}

	/** Dump a FINALLY statement. */
	@Override
	public Object visit(final FinallyStatement finallyStatement) {
		indent();
		writer.println("FinallyStatement");
		indentation += increment;
		visitNode(finallyStatement.getS());
		indentation -= increment;
		return null;
	}

	/** Dump a THROW statement. */
	@Override
	public Object visit(final ThrowStatement throwStatement) {
		indent();
		writer.println("ThrowStatement");
		indentation += increment;
		visitNode(throwStatement.getE());
		indentation -= increment;
		return null;
	}

	/** Dump a CATCH statement. */
	@Override
	public Object visit(final CatchStatement catchStatement) {
		indent();
		writer.println("CatchStatement");
		indentation += increment;
		visitNode(catchStatement.getB());
		indentation -= increment;
		return null;
	}

	/** Dump a Function Expression. */
	@Override
	public Object visit(final FunctionExpression funcExp) {
		indent();
		writer.println("FunctionExpression");
		indentation += increment;
		visitNode(funcExp.getB1());
		indentation -= increment;
		return null;
	}

	/** Dump a Call Expression. */
	@Override
	public Object visit(final CallExpression callExp) {
		indent();
		writer.println("CallExpression");
		indentation += increment;
		visitNode(callExp.getE1());
		indentation -= increment;
		return null;
	}

	@Override
	public Object visit(final This ths) {
		indent();
		writer.println("This " + ths.getValue());
		indentation += increment;
		indentation -= increment;
		return null;
	}

	@Override
	public Object visit(final ObjLiteral objLiteral) {
		indent();
		writer.println("Object Literal");
		indentation += increment;
		if (objLiteral.getValue() != null) {
			visitEach(objLiteral.getValue());
		}
		indentation -= increment;
		return null;
	}

	@Override
	public Object visit(final PropAccessor propAccessor) {
		indent();
		writer.println("Property Accessor " + propAccessor.getValue());
		indentation += increment;
		if (propAccessor.getExp() != null) {
			visitNode(propAccessor.getExp());
		}
		if (propAccessor.getKey() != null) {
			visitNode(propAccessor.getKey());
		}
		indentation -= increment;
		return null;
	}

	@Override
	public Object visit(final NewExpression newExpression) {
		indent();
		writer.println("New Expression");
		indentation += increment;
		visitNode(newExpression.getKey());
		indentation -= increment;
		return null;
	}
}
