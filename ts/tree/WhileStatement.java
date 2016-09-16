package ts.tree;

import ts.Location;
import ts.tree.visit.TreeVisitor;

public class WhileStatement extends Statement {

	private Expression exp;
	private Statement s;

	public WhileStatement(Location loc, Expression exp, Statement s) {
		super(loc);
		this.exp = exp;
		this.s = s;
	}

	public Expression getExp() {
		return exp;
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
