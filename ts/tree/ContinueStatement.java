package ts.tree;

import ts.Location;
import ts.tree.visit.TreeVisitor;

public class ContinueStatement extends Statement {
	
	public String name;
	
	public int counter=0;
	
	
	
	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public ContinueStatement(final Location loc,final String name)
	{
		super(loc);
		this.name=name;
	}

	@Override
	public <T> T apply(TreeVisitor<T> visitor) {
		// TODO Auto-generated method stub
		return visitor.visit(this);
	}

}
