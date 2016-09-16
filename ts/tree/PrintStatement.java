
package ts.tree;

import ts.Location;
import ts.tree.visit.TreeVisitor;

/**
 * AST print statement node
 *
 */
public final class PrintStatement extends Statement {
	private Expression exp;

	/**
	 * Construct a print statement tree node.
	 *
	 * @param loc
	 *            the source code location of the print statement.
	 * @param exp
	 *            the expression subtree of the statement.
	 */
	public PrintStatement(final Location loc, final Expression exp) {
		super(loc);
		this.exp = exp;
	}

	/**
	 * Get the expression subtree of the print statement.
	 *
	 * @return the expression subtree of the print statement.
	 */
	public Expression getExp() {
		return exp;
	}

	/**
	 * Apply a visitor to the node.
	 *
	 * @param visitor
	 *            the visitor to apply.
	 *
	 * @return the value generated by the visitor.
	 */
	@Override
	public <T> T apply(TreeVisitor<T> visitor) {
		return visitor.visit(this);
	}
}