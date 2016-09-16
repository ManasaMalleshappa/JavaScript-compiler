package ts.parse;

import ts.Location;
import ts.Message;
import ts.tree.*;

import java.math.BigInteger;
import java.util.List;

/**
 * Provides static methods for building AST nodes.
 */
public class TreeBuilder {

	/**
	 * Build a binary operator.
	 *
	 * @param loc
	 *            location in source code (file, line, column).
	 * @param op
	 *            the binary operator.
	 * @param left
	 *            the left subtree.
	 * @param right
	 *            the right subtree.
	 * @return tree node for a binary operator.
	 * @see Binop
	 */
	public static Expression buildBinaryOperator(final Location loc, final Binop op, final Expression left,
			final Expression right) {

		Message.log("TreeBuilder: Binop " + op.toString());

		return new BinaryOperator(loc, op, left, right);
	}

	public static Expression buildUnaryOperator(final Location loc, final Unop op, final Expression ab) {
		Message.log("TreeBuilder: Unop " + op.toString());
		return new UnaryOperator(loc, op, ab);
	}

	/**
	 * Build an expression statement.
	 *
	 * @param loc
	 *            location in source code (file, line, column).
	 * @param exp
	 *            expression subtree.
	 * @return tree node for an expression statement.
	 */
	public static Statement buildExpressionStatement(final Location loc, final Expression exp) {
		Message.log("TreeBuilder: ExpressionStatement");
		return new ExpressionStatement(loc, exp);
	}

	public static Statement buildReturnStatement(final Location loc, final Expression exp) {
		if (exp == null) {
			return new ReturnStatement(loc, new NullLiteral(loc));
		}
		Message.log("TreeBuilder: ExpressionStatement");
		return new ReturnStatement(loc, exp);
	}

	/**
	 * Build an identifier expression.
	 *
	 * @param loc
	 *            location in source code (file, line, column).
	 * @param name
	 *            name of the identifier.
	 * @return tree node for an identififier.
	 */
	public static Expression buildIdentifier(final Location loc, final String name) {
		Message.log("TreeBuilder: Identifier (" + name + ")");
		return new Identifier(loc, name);
	}

	public static Expression buildFunctionExpression(final Location loc, final String s,
			  final List<Expression> formalList,final Statement e) {
		Message.log("TreeBuilder: Identifier (" + e + ")");
		return new FunctionExpression(loc, s,formalList,e);
	}

	public static Expression buildCallExpression(final Location loc, final Expression e1,
			final List<Expression> args1) {
		Message.log("TreeBuilder: Identifier (" + e1 + ")");
		return new CallExpression(loc, e1, args1);
	}

	public static Statement buildIfStatement(final Location loc, final Expression e, final Statement s,
			final Statement s1) {
		Message.log("TreeBuilder : If Statement");
		return new IfStatement(loc, e, s, s1);
	}

	public static Expression buildThis(final Location loc) {
		Message.log("TreeBuilder : If Statement");
		return new This(loc);
	}

	public static Expression buildObjLiteral(final Location loc, final List<Expression> e) {
		Message.log("TreeBuilder : Object Literal");
		return new ObjLiteral(loc, e);
	}

	public static Expression buildPropertyAssignment(final Location loc, final StringLiteral key,
			final Expression value) {
		Message.log("TreeBuilder : Property Assignment");
		return new propAssignment(loc, key, value);
	}

	public static StringLiteral buildPropertyName(final Location loc, final String name) {
		Message.log("TreeBuilder : Property Name");
		return new StringLiteral(loc, name);
	}

	public static Expression buildpropAccessor(final Location loc, final Expression key, final Expression exp,
			final String name) {
		Message.log("TreeBuilder : Property Accessor");
		return new PropAccessor(loc, key, exp, name);
	}

	public static Expression buildNewExpression(final Location loc, final Expression memb) {
		Message.log("TreeBuilder : New Expression");
		return new NewExpression(loc, memb);
	}

	public static Statement buildBreakStatement(final Location loc, final String name) {
		Message.log("TreeBuilder: BreakStatement");
		return new BreakStatement(loc, name);
	}

	public static Statement buildContinueStatement(final Location loc, final String name) {
		Message.log("TreeBuilder: ContinueStatement");
		return new ContinueStatement(loc, name);
	}

	/**
	 * Build a numeric literal expression. Converts the String for the value to
	 * a double.
	 *
	 * @param loc
	 *            location in source code (file, line, column).
	 * @param value
	 *            value of the literal as a String.
	 * @return tree node for a numeric literal.
	 */

	public static Expression buildBooleanLiteral(final Location loc, final String value) {
		boolean b = false;

		b = Boolean.parseBoolean(value);
		Message.log("TreeBuilder: BooleanLiteral " + b);
		return new BooleanLiteral(loc, b);
	}

	public static Expression buildNullLiteral(final Location loc) {

		Message.log("TreeBuilder: NullLiteral");
		return new NullLiteral(loc);
	}

	public static Expression buildNumericLiteral(final Location loc, final String value) {
		double d = 0.0;

		// try
		// {
		// d = Double.parseDouble(value);
		// }
		// catch(NumberFormatException nfe)
		// {
		// Message.bug(loc, "numeric literal not parsable");
		// }

		if (value.startsWith("0x") || value.startsWith("0X")) {
			d = new BigInteger(value.substring(2), 16).doubleValue();
		} else {
			try {
				d = Double.valueOf(value);
			} catch (NumberFormatException ex) {
				d = Double.NaN;
			}
		}
		Message.log("TreeBuilder: NumericLiteral " + d);
		return new NumericLiteral(loc, d);
	}

	/**
	 * Build a print statement.
	 * 
	 * @param loc
	 *            location in source code (file, line, column).
	 * @param exp
	 *            expression subtree.
	 * @return tree node for a print statement.
	 */
	public static Statement buildPrintStatement(final Location loc, final Expression exp) {
		Message.log("TreeBuilder: PrintStatement");
		return new PrintStatement(loc, exp);
	}

	public static Statement buildEmptyStatement(final Location loc) {
		Message.log("TreeBuilder: EmptyStatement");
		return new EmptyStatement(loc);
	}

	/**
	 * Build the root node of the AST.
	 *
	 * @param loc
	 *            location in source code (file, line, column).
	 * @param list
	 *            list of statements for the program.
	 * @return tree node for the root of the AST.
	 */
	public static Program buildProgram(final Location loc, final List<Statement> list) {
		Message.log("TreeBuilder: Program");
		return new Program(loc, list);
	}

	public static BlockStatement buildBlockStatement(final Location loc, final List<Statement> list) {
		Message.log("TreeBuilder : Block Statement");
		return new BlockStatement(loc, list);
	}

	/**
	 * Build a string literal expression.
	 *
	 * @param loc
	 *            location in source code (file, line, column).
	 * @param value
	 *            value of the literal as a String.
	 * @return tree node for a numeric literal.
	 */
	public static Expression buildStringLiteral(final Location loc, final String value) {
		// need to strip off the doublequotes
		String v = value.substring(1, value.length() - 1);

		Message.log("TreeBuilder: StringLiteral " + v);
		return new StringLiteral(loc, v);
	}

	public static Statement buildWhileStatement(final Location loc, final Expression e, final Statement s) {
		Message.log("TreeBuilder: While Statement");
		return new WhileStatement(loc, e, s);
	}

	/**
	 * Build a "var" statement.
	 *
	 * @param loc
	 *            location in source code (file, line, column).
	 * @param name
	 *            name of variable being declared.
	 * @return tree node for a var statement.
	 */
	public static Statement buildVarStatement(final Location loc, final String name) {
		Message.log("TreeBuilder: VarStatement (" + name + ")");
		return new VarStatement(loc, name);
	}

	public static Statement buildTryStatement(final Location loc, final Statement s1, final Statement s2,
			final Statement s3) {
		Message.log("TreeBuilder: TryStatement (" + s1 + ")");
		return new TryStatement(loc, s1, s2, s3);
	}

	public static Statement buildThrowStatement(final Location loc, final Expression exp) {
		Message.log("TreeBuilder: ThrowStatement");
		return new ThrowStatement(loc, exp);
	}

	public static Statement buildCatchStatement(final Location loc, final String name, final Statement s1) {
		Message.log("TreeBuilder: ThrowStatement");
		return new CatchStatement(loc, name, s1);
	}

	public static Statement buildFinallyStatement(final Location loc, final Statement statement) {
		Message.log("TreeBuilder : FinallyStatement");
		return new FinallyStatement(loc, statement);
	}

	//
	// methods to detect "early" (i.e. semantic) errors
	//

	// helper function to detect "reference expected" errors and to
	// mark nodes that denote references as Lvals
	private static boolean producesReference(Node node) {
		if (node instanceof Identifier) {
			Identifier id = (Identifier) node;
			id.setIsLval();
			return true;
		}
		if (node instanceof PropAccessor) {
			PropAccessor id = (PropAccessor) node;
			id.setIsLval();
			return true;
		}
		return false;
	}

	/**
	 * Used to detect non-references on left-hand-side of assignment and also to
	 * mark identifier nodes as denoting Lvals (location rather than value).
	 *
	 * @param loc
	 *            location in source code (file, line, column).
	 * @param node
	 *            tree to be checked.
	 */
	public static void checkAssignmentDestination(Location loc, Node node) {
		if (!producesReference(node)) {
			Message.error(loc, "invalid left-hand side in assignment");
		}
	}

}
