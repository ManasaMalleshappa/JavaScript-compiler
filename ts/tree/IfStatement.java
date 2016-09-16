package ts.tree;

import ts.Location;
import ts.tree.visit.TreeVisitor;

public class IfStatement extends Statement {
	
	private Expression exp;
	private Statement s1,s2;
	
	public IfStatement(final Location loc, final Expression exp,final Statement s, final Statement s1) {
		super(loc);
		this.exp = exp;
		this.s1=s;
		this.s2=s1;
	}
	
	
	
	public Expression getExp() {
		return exp;
	}



	public Statement getS1() {
		return s1;
	}



	public Statement getS2() {
		return s2;
	}



	@Override
	public <T> T apply(TreeVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
