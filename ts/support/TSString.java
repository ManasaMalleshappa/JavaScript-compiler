package ts.support;

import java.math.BigInteger;

/**
 * Represents (Tscript) String values (
 * <a href="http://www.ecma-international.org/ecma-262/5.1/#sec-8.4">ELS 8.4</a>
 * ).
 * <p>
 * This class only currently allows String values to be created and does not yet
 * support operations on them.
 */
public final class TSString extends TSPrimitive {

	private final String value;

	// use the "create" method instead
	private TSString(final String value) {
		this.value = value;
	}

	/**
	 * Get the value of the String.
	 *
	 * @return the Java string value of the TSString
	 */
	public String getInternal() {
		return value;
	}

	/** Overrides Object.equals because TSString used as key for Map */
	public boolean equals(Object anObject) {
		if (anObject instanceof TSString) {
			return value.equals(((TSString) anObject).getInternal());
		}
		return false;
	}

	/** Need to override Object.hashcode() when overriding Object.equals() */
	public int hashCode() {
		return value.hashCode();
	}

	/**
	 * Create a Tscript String from a Java String.
	 *
	 * @param value
	 *            Java string
	 * @return TSString encapsulating the Java string passed in
	 */
	public static TSString create(final String value) {
		// could use hashmap to screen for common strings?
		return new TSString(value);
	}

	/** Convert String to Number. */
	public TSNumber toNumber() {
		double dvalue = 0.0;

		// look for hex constants first
		if (value.startsWith("0x") || value.startsWith("0X")) {
			dvalue = new BigInteger(value.substring(2), 16).doubleValue();
		} else {
			try {
				dvalue = Double.valueOf(value);
			} catch (NumberFormatException ex) {
				dvalue = Double.NaN;
			}
		}
		return TSNumber.create(dvalue);
	}

	/** Override in TSValue */
	public TSString toStr() {
		return this;
	}

	@Override
	public TSBoolean toBoolean() {
		// TODO Auto-generated method stub
		if (value.length() == 0) {
			return TSBoolean.create(false);
		}
		return TSBoolean.create(true);
	}
}
