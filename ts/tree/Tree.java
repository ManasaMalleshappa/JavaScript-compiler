
package ts.tree;

import ts.tree.visit.TreeVisitor;

/**
 * Interface for all AST classes. The only requirement is that a visitor can be
 * applied to the tree.
 *
 */
public interface Tree {
	public <T> T apply(TreeVisitor<T> visitor);
}
