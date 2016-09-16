package ts.tree;

import ts.Location;
import ts.tree.visit.TreeVisitor;

public class CatchStatement extends Statement{
	
	public Statement b;
	public String name;

	public CatchStatement(Location loc,final String name,final Statement b) {
		super(loc);
		this.b = b;
		this.name=name;
		// TODO Auto-generated constructor stub
	}

	
	public Statement getB() {
		return b;
	}


	public String getName()
	{
		return name;
	}


	@Override
	public <T> T apply(TreeVisitor<T> visitor) {
		// TODO Auto-generated method stub
		return visitor.visit(this);
	}

}
