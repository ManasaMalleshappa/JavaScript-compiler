
package ts.support;

import ts.Message;

/**
 * The super class for all Tscript values.
 */
public abstract class TSValue {
	//
	// conversions (section 9)
	//

	/**
	 * Convert to Primitive. Override only in TSObject. Otherwise just return
	 * "this". Note: type hint is not implemented.
	 *
	 * @return the "this" value
	 */
	public TSPrimitive toPrimitive() {
		return (TSPrimitive) this;
	}

	abstract public TSNumber toNumber();

	abstract public TSBoolean toBoolean();

	/**
	 * Convert to String. Override for all primitive types. It can't be called
	 * toString because of Object.toString.
	 *
	 * @return produced TSString value
	 */
	public TSString toStr() {
		TSPrimitive prim = this.toPrimitive();
		return prim.toStr();
	}

	//
	// binary operators (sections 11.5-11.11)
	//

	/**
	 * Perform a multiply. "this" is the left operand and the right operand is
	 * given by the parameter. Both operands are converted to Number before the
	 * multiply.
	 *
	 * @param right
	 *            value to be multiplied
	 * @return the result of the multiplication
	 */
	public final TSNumber multiply(final TSValue right) {
		TSNumber leftValue = this.toNumber();
		TSNumber rightValue = right.toNumber();
		return TSNumber.create(leftValue.getInternal() * rightValue.getInternal());
	}

	/**
	 * Perform an addition. "this" is the left operand and the right operand is
	 * given by the parameter. Both operands are converted to Number before the
	 * addition.
	 *
	 * @param right
	 *            value to be added
	 * @return the result of the addition
	 */

	public final TSPrimitive add(final TSValue right) {
		TSPrimitive leftValue = this.toPrimitive();
		TSPrimitive rightValue = right.toPrimitive();

		// if one of the operands is a string, then the operation is string
		// concatentation and the other operand must first be converted to
		// a string
		if (leftValue instanceof TSString) {
			return TSString.create(((TSString) leftValue).getInternal() + rightValue.toStr().getInternal());
		} else if (rightValue instanceof TSString) {
			return TSString.create(leftValue.toStr().getInternal() + ((TSString) rightValue).getInternal());
		}

		// othewise the operation is numeric addition
		return TSNumber.create(leftValue.toNumber().getInternal() + rightValue.toNumber().getInternal());
	}

	//
	// test for undefined
	//

	/**
	 * Is this value Undefined? Override only in TSUndefined.
	 *
	 * @return true or false, is this value the undefined value?
	 */
	public boolean isUndefined() {
		return false;
	}

	public boolean isNull() {
		return false;
	}

	public final TSPrimitive lessthan(final TSValue right) {

		TSPrimitive leftValue = this.toPrimitive();
		TSPrimitive rightValue = right.toPrimitive();
		int min = 0;
		if (!(leftValue instanceof TSString) && !(rightValue instanceof TSString)) {
			if (leftValue.toNumber().getInternal() < rightValue.toNumber().getInternal()) {
				return TSBoolean.create(true);
			}
		}
		if ((leftValue instanceof TSString) && (rightValue instanceof TSString)) {
			String s1 = leftValue.toStr().getInternal();
			String s2 = rightValue.toStr().getInternal();
			if (s1.length() < s2.length()) {
				if (s2.startsWith(s1)) {
					return TSBoolean.create(true);
				}
			}
			if (s1.length() < s2.length())
				min = s1.length();
			else
				min = s2.length();
			for (int i = 0; i < min; i++) {
				int a = (int) s1.charAt(i);
				int b = (int) s2.charAt(i);
				if (a < b) {
					return TSBoolean.create(true);
				}
			}
		}
		return TSBoolean.create(false);
	}

	public final TSPrimitive greaterthan(final TSValue right) {
		// boolean flag=false;
		int min = 0;
		TSPrimitive leftValue = this.toPrimitive();
		TSPrimitive rightValue = right.toPrimitive();
		if (!(leftValue instanceof TSString) && !(rightValue instanceof TSString)) {
			if (leftValue.toNumber().getInternal() > rightValue.toNumber().getInternal()) {
				return TSBoolean.create(true);
			}
		}

		if ((leftValue instanceof TSString) && (rightValue instanceof TSString)) {
			String s1 = leftValue.toStr().getInternal();
			String s2 = rightValue.toStr().getInternal();
			if (s1.length() > s2.length()) {
				if (s1.startsWith(s2)) {
					return TSBoolean.create(true);
				}
			}
			if (s1.length() < s2.length())
				min = s1.length();
			else
				min = s2.length();
			for (int i = 0; i < min; i++) {
				int a = (int) s1.charAt(i);
				int b = (int) s2.charAt(i);
				if (a > b) {
					return TSBoolean.create(true);
				}
			}
		}
		return TSBoolean.create(false);
	}

	public final TSPrimitive isequal(final TSValue right) {
		
		TSPrimitive rightValue = right.toPrimitive();
		
		if(this instanceof TSObject && rightValue.toPrimitive().isNull())
		{
			return TSBoolean.create(false);
		}
		
		TSPrimitive leftValue = this.toPrimitive();

		if ((leftValue instanceof TSString) && (rightValue instanceof TSString)) {
			String x = leftValue.toStr().getInternal();
			String y = rightValue.toStr().getInternal();
			if (x.length() == y.length() && x.equals(y)) {
				return TSBoolean.create(true);
			}
			return TSBoolean.create(false);
		}

		if ((leftValue.toPrimitive().isUndefined() && (rightValue.toPrimitive().isNull()))
				|| (rightValue.toPrimitive().isUndefined() && (leftValue.toPrimitive().isNull()))) {
			return TSBoolean.create(true);
		}

		if ((leftValue instanceof TSNumber) && (rightValue instanceof TSString)) {
			TSNumber res = TSNumber.create(rightValue.toNumber().getInternal());
			if (((TSNumber) leftValue).getInternal() == res.toNumber().getInternal()) {
				return TSBoolean.create(true);
			}
		}

		if (((leftValue instanceof TSBoolean) && (rightValue instanceof TSNumber))
				|| ((leftValue instanceof TSNumber) && (rightValue instanceof TSBoolean))) {
			double res1 = leftValue.toNumber().getInternal();
			double res2 = rightValue.toNumber().getInternal();
			if (res1 == res2) {
				return TSBoolean.create(true);
			}
		}

		if ((leftValue.toPrimitive().isUndefined()) && (rightValue.toPrimitive().isUndefined())) {
			return TSBoolean.create(true);
		}

		if ((leftValue instanceof TSBoolean) && (rightValue instanceof TSBoolean)) {
			boolean b = leftValue.toBoolean().getInternal();
			boolean c = rightValue.toBoolean().getInternal();
			if (b == c) {
				return TSBoolean.create(true);
			}
		}

		if ((leftValue.toPrimitive().isNull()) && (rightValue.toPrimitive().isNull())) {
			return TSBoolean.create(true);
		}

		if ((leftValue instanceof TSBoolean) || (rightValue instanceof TSBoolean)) {
			double res1 = leftValue.toNumber().getInternal();
			double res2 = rightValue.toNumber().getInternal();
			if (res1 == res2) {
				return TSBoolean.create(true);
			}
		}

		if ((leftValue instanceof TSString) && (rightValue instanceof TSNumber)) {
			TSNumber res = TSNumber.create(leftValue.toNumber().getInternal());
			if (((TSNumber) rightValue).getInternal() == res.toNumber().getInternal()) {
				return TSBoolean.create(true);
			}
		}

		if (!(leftValue instanceof TSString) && !(rightValue instanceof TSString)) {
			if (leftValue.toNumber().getInternal() == rightValue.toNumber().getInternal()) {
				return TSBoolean.create(true);
			}
		}

		return TSBoolean.create(false);
	}

	public final TSPrimitive notlogical() {
		TSPrimitive leftValue = this.toPrimitive();
		if (leftValue.toBoolean().getInternal() == true)
			return TSBoolean.create(false);
		else
			return TSBoolean.create(true);
	}

	//
	// conversions to support optimized code generation
	//

	/**
	 * Convert a Java String to a TSString. Supports optimized code generation.
	 *
	 * @param value
	 *            Java String to be converted
	 * @return result of conversion
	 */
	public static TSValue make(String value) {
		return TSString.create(value);
	}

	/**
	 * Convert a Java double to a TSNumber. Supports optimized code generation.
	 *
	 * @param value
	 *            Java double to be converted
	 * @return result of conversion
	 */
	public static TSValue make(double value) {
		return TSNumber.create(value);
	}

	public static TSValue make(boolean value) {
		return TSBoolean.create(value);
	}

	/**
	 * Do nothing, since value already a TSValue. Supports optimized code
	 * generation.
	 *
	 * @param value
	 *            a TSValue already
	 * @return the argument unchanged
	 */
	public static TSValue make(TSValue value) {
		return value;
	}

	public TSValue functionCall(TSValue value,TSValue[] arg) {
		System.err.println("Error calling TSFunction");
		return null;
	}

	public void put(String key, TSValue value) {

	}

	public TSValue get(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	public TSValue callConstructor() {
		return null;
	}
}
