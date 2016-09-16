
package ts.tree.type;

/**
 * Represents an unknown type, meaning either the type is unknown or it is
 * ambiguous.
 *
 */
public final class UnknownType extends Type {

	private static final UnknownType INSTANCE = new UnknownType();

	// private constructor
	private UnknownType() {
	}

	/**
	 * Return an Unknown type.
	 * 
	 * @return an Unknown type.
	 */
	public static UnknownType getInstance() {
		return INSTANCE;
	}

	/**
	 * Always returns true.
	 * 
	 * @return true.
	 */
	@Override
	public boolean isUnknownType() {
		return true;
	}

	/** Generate a String representation for dumping. */
	@Override
	public String toString() {
		return "Unknown";
	}
}
