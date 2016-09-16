package ts.tree;

import ts.Location;
import ts.tree.visit.TreeVisitor;

public class ReturnStatement extends Statement {

	public Expression e;

	public ReturnStatement(Location loc, final Expression e1) {
		super(loc);
		// TODO Auto-generated constructor stub
		this.e = e1;
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
