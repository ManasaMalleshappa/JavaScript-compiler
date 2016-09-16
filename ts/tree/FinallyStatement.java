package ts.tree;

import ts.Location;
import ts.tree.visit.TreeVisitor;

public class FinallyStatement extends Statement {
	
	private Statement s;

	public FinallyStatement(final Location loc, final Statement s) {
		super(loc);
		this.s = s;
	}

	public Statement getS() {
		return s;
	}

	@Override
	public <T> T apply(TreeVisitor<T> visitor) {
		// TODO Auto-generated method stub
		return visitor.visit(this);
	}

	
	

}
