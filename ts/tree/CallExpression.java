package ts.tree;

import java.util.List;

import ts.Location;
import ts.tree.visit.TreeVisitor;

public final class CallExpression extends Expression{
	
	public final Expression e1;
	public List<Expression> args1;
	
	public CallExpression(Location loc,Expression e,final List<Expression> ar1) {
		super(loc);
		this.e1=e;
		this.args1=ar1;
		// TODO Auto-generated constructor stub
	}

	public Expression getE1() {
		return e1;
	}


	public List<Expression> getArgs1() {
		return args1;
	}

	public void setArgs1(List<Expression> args1) {
		this.args1 = args1;
	}

	public <T> T apply(TreeVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
