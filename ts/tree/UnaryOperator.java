package ts.tree;

import ts.Location;
import ts.tree.visit.TreeVisitor;

public class UnaryOperator extends Expression {

	private Expression ab;
	private Unop op;

	public UnaryOperator(final Location loc, final Unop op, final Expression ab) {
		super(loc);
		this.op = op;
		this.ab = ab;
	}

	public Unop getOp() {
		return op;
	}

	public String getOpString() {
		return op.toString();
	}

	public Expression getAb() {
		return ab;
	}

	public void setAb(Expression ab) {
		this.ab = ab;
	}

	public <T> T apply(TreeVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
