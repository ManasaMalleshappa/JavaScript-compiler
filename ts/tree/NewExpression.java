package ts.tree;

import ts.Location;
import ts.tree.visit.TreeVisitor;

public class NewExpression extends Expression {

	private Expression key;

	public NewExpression(final Location loc, final Expression key) {
		super(loc);
		this.key = key;
	}

	public Expression getKey() {
		return key;
	}

	public <T> T apply(TreeVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
