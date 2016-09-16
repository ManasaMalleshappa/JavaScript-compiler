
package ts.tree;

import ts.Location;

/**
 * superclass for all AST statement nodes
 *
 */
public abstract class Statement extends Node {
	/**
	 * Construct a statement tree node.
	 *
	 * @param loc
	 *            the source code location of the identifier.
	 */
	public Statement(final Location loc) {
		super(loc);
	}
}
