package ts.tree;

import ts.Location;
import ts.tree.type.UnknownType;
import ts.tree.visit.TreeVisitor;

public class This extends Expression {

	private String value;

	public This(final Location loc) {
		super(loc);
		this.setType(UnknownType.getInstance());

	}

	public String getValue() {
		return value;
	}

	public <T> T apply(TreeVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
