package ts.tree;

import java.util.List;

import ts.Location;
import ts.tree.type.UnknownType;
import ts.tree.visit.TreeVisitor;

public class propAssignment extends Expression {

	private StringLiteral name;
	private Expression value;

	public propAssignment(final Location loc, final StringLiteral name, final Expression value) {
		super(loc);
		this.name = name;
		this.value = value;
	}

	public StringLiteral getName() {
		return name;
	}

	public Expression getValue() {
		return value;
	}

	public <T> T apply(TreeVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
