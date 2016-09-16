
package ts.support;

/**
 * Represents the single Undefined value (
 * <a href="http://www.ecma-international.org/ecma-262/5.1/#sec-8.1">ELS 8.1</a>
 * ).
 */
public final class TSNull extends TSPrimitive {
	/** Single value for this singleton class. */
	public static final TSNull value = new TSNull();

	// hide the constructor
	private TSNull() {
	}

	/** Convert to Number. Undefined gets mapped to NaN. */
	public TSNumber toNumber() {
		return TSNumber.create(0.0);
	}

	/** Convert to String ("undefined"). */
	public TSString toStr() {
		return TSString.create("null");
	}

	public TSBoolean toBoolean() {
		return TSBoolean.create(false);
	}

	public boolean isNull() {
		return true;
	}

	/** Always returns true. */
}
