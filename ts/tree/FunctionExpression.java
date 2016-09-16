package ts.tree;

import java.util.List;

import ts.Location;
import ts.tree.visit.TreeVisitor;

public final class FunctionExpression extends Expression{
	
	public final Statement b1;
	public final String s1;
	public List<Expression> formalList;
	
	public FunctionExpression(Location loc,String s1,final List<Expression> fList,Statement b) {
		super(loc);
		this.b1=b;
		this.s1=s1;
		this.formalList=fList;
		// TODO Auto-generated constructor stub
	}

	public Statement getB1() {
		return b1;
	}
	
	public String getS1() {
		return s1;
	}
	
	
	public void setFormalList(List<Expression> formalList) {
		this.formalList = formalList;
	}

	public List<Expression> getFormalList() {
		return formalList;
	}

	public <T> T apply(TreeVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
