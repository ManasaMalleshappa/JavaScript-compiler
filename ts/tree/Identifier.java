
package ts.tree;

import ts.Location;
import ts.tree.visit.TreeVisitor;

/**
 * AST identifier expression leaf node
 *
 */
public final class Identifier extends Expression {
	private String name;

	// indicates whether location (Lval) or value (Rval) of variable
	// is denoted by this identifier
	private boolean isLval;

	// VarStatement node where variable was declared. Will be null if identifier
	// was not declared.
	private VarStatement varNode;

	/**
	 * Construct an identifier tree node.
	 *
	 * @param loc
	 *            the source code location of the identifier.
	 * @param name
	 *            the name of the identifier.
	 */
	public Identifier(final Location loc, final String name) {
		super(loc);
		this.name = name;
		this.isLval = false;
		this.varNode = null;
	}

	/**
	 * Get the name of the identifier.
	 *
	 * @return the name of the identifier.
	 */
	public String getName() {
		return name;
	}

	/** Record that identifier represents an Lval. */
	public void setIsLval() {
		this.isLval = true;
	}

	/**
	 * Does the identifier represent an Lval?
	 *
	 * @return true only if identifier represents the address of its variable.
	 */
	public boolean isLval() {
		return this.isLval;
	}

	/**
	 * Get the tree node where the identifier was declared.
	 *
	 * @return the tree node where the identifier was declared.
	 */
	public VarStatement getVarNode() {
		return varNode;
	}

	/**
	 * Record the tree node where the identifier was declared.
	 *
	 * @param varNode
	 *            the tree node where the identifier was declared.
	 */
	public void setVarNode(VarStatement varNode) {
		this.varNode = varNode;
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
