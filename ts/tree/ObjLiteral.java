package ts.tree;

import java.util.List;

import ts.Location;
import ts.tree.type.UnknownType;
import ts.tree.visit.TreeVisitor;

public class ObjLiteral extends Expression {

	private List<Expression> value;

	public ObjLiteral(final Location loc, final List<Expression> value) {
		super(loc);
		this.setType(UnknownType.getInstance());
		this.value = value;
	}

	public List<Expression> getValue() {
		return value;
	}

	public <T> T apply(TreeVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
