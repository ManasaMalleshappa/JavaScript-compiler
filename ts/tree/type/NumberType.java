
package ts.tree.type;

/**
 * Represents Number type.
 *
 */
public final class NumberType extends Type {
	// singleton
	private static final NumberType INSTANCE = new NumberType();

	// private constructor
	private NumberType() {
	}

	/**
	 * Return a Number type.
	 * 
	 * @return a Number type.
	 */
	public static NumberType getInstance() {
		return INSTANCE;
	}

	/**
	 * Always returns true.
	 * 
	 * @return true.
	 */
	@Override
	public boolean isNumberType() {
		return true;
	}

	/** Generate a String representation for dumping. */
	@Override
	public String toString() {
		return "Number";
	}
}
