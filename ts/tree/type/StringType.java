
package ts.tree.type;

/**
 * Represents String type.
 *
 */
public final class StringType extends Type {
	// singleton
	private static final StringType INSTANCE = new StringType();

	// private constructor
	private StringType() {
	}

	/**
	 * Return a String type.
	 * 
	 * @return a String type.
	 */
	public static StringType getInstance() {
		return INSTANCE;
	}

	/** Always returns true. */
	@Override
	public boolean isStringType() {
		return true;
	}

	/** Generate a String representation for dumping. */
	@Override
	public String toString() {
		return "String";
	}
}
