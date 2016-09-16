package ts.tree;

import ts.Location;
import ts.tree.visit.TreeVisitor;

public class PropAccessor extends Expression {

	private Expression key;
	private Expression exp;
	private String value;

	private boolean isLval;

	public PropAccessor(final Location loc, final Expression key, final Expression exp, final String value) {
		super(loc);
		this.key = key;
		this.exp = exp;
		this.value = value;
	}

	public Expression getKey() {
		return key;
	}

	public Expression getExp() {
		return exp;
	}

	public String getValue() {
		return value;
	}

	public boolean isLval() {
		return isLval;
	}

	public void setIsLval() {
		this.isLval = isLval;
	}

	public <T> T apply(TreeVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
