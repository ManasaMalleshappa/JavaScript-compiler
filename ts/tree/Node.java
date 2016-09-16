
package ts.tree;

import ts.Location;

/**
 * Superclass for all AST nodes.
 *
 */
public abstract class Node implements Tree {
	/** Location in source code (file, line, column). */
	protected final Location loc;

	/**
	 * Initialize the location field, which stores the source code location for
	 * all tree nodes.
	 *
	 * @param loc
	 *            the source code location corresponding to the node.
	 */
	protected Node(final Location loc) {
		this.loc = loc;
	}

	/**
	 * Get the location of the node.
	 *
	 * @return the location of the node.
	 */
	public Location getLoc() {
		return loc;
	}

	/**
	 * Get the line number of the identifier.
	 *
	 * @return the line number of the identifier.
	 */
	public int getLineNumber() {
		return loc.getLine();
	}
}
