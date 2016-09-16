package ts.tree;

import java.util.List;

import ts.Location;
import ts.tree.visit.TreeVisitor;

public final class BlockStatement extends Statement {
	private List<Statement> list;

	public BlockStatement(final Location loc, final List<Statement> list) {
		super(loc);
		this.list = list;
	}

	public List<Statement> getList() {
		return list;
	}

	public <T> T apply(TreeVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
