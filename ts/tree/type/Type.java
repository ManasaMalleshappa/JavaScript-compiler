
package ts.tree.type;

/**
 * Superclass for all types.
 *
 */
public abstract class Type {
	/**
	 * Returns true only if the type is the Number type.
	 * 
	 * @return true only if the type is the Number type.
	 */
	public boolean isNumberType() {
		// by default return false; NumberType should override to return true
		return false;
	}

	/**
	 * Returns true only if the type is the String type.
	 * 
	 * @return true only if the type is the String type.
	 */
	public boolean isStringType() {
		// by default return false; StringType should override to return true
		return false;
	}

	/**
	 * Returns true only if the type is the unknown type.
	 * 
	 * @return true only if the type is the unknown type.
	 */
	public boolean isUnknownType() {
		// by default return false; UnknownType should override to return true
		return false;
	}

	/**
	 * Returns true only if the type is the same as the parameter type.
	 * 
	 * @param type
	 *            type to compare to.
	 * @return true only if the type is the same as the parameter type.
	 */
	public boolean isSameType(Type type) {
		// by default types are implemented as singletons so can use
		// Object.equals
		return this.equals(type);
	}

}
