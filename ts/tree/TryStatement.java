package ts.tree;

import ts.Location;
import ts.tree.visit.TreeVisitor;

public class TryStatement extends Statement {

	public Statement b;
	public Statement c;
	public Statement f;

	public TryStatement(Location loc, final Statement b, final Statement c, final Statement f) {
		super(loc);
		this.b = b;
		this.c = c;
		this.f = f;

		// TODO Auto-generated constructor stub
	}

	public Statement getB() {
		return b;
	}

	public Statement getC() {
		return c;
	}

	public Statement getF() {
		return f;
	}

	@Override
	public <T> T apply(TreeVisitor<T> visitor) {
		// TODO Auto-generated method stub
		return visitor.visit(this);
	}

}
