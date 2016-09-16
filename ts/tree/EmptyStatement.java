package ts.tree;

import ts.Location;
import ts.tree.type.Type;
import ts.tree.visit.TreeVisitor;

public class EmptyStatement extends Statement {
	
	private Type type;
	
	
	

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public EmptyStatement(Location loc) {
		super(loc);
		
	}

	@Override
	public <T> T apply(TreeVisitor<T> visitor) {
		// TODO Auto-generated method stub
		return visitor.visit(this);
	}
	

}
