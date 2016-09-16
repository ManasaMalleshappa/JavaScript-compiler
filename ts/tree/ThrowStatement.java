package ts.tree;

import ts.Location;
import ts.tree.visit.TreeVisitor;

public class ThrowStatement extends Statement {

	public Expression e;

	public ThrowStatement(final Location loc, final Expression e) {
		super(loc);
		this.e = e;
		// TODO Auto-generated constructor stub
	}

	public Expression getE() {
		return e;
	}

	@Override
	public <T> T apply(TreeVisitor<T> visitor) {
		// TODO Auto-generated method stub
		return visitor.visit(this);
	}
}
