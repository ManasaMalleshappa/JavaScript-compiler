package ts.support;

public final class TSBoolean extends TSPrimitive {

	private final boolean value;

	private TSBoolean(final boolean value) {
		this.value = value;
	}

	public static TSBoolean create(final boolean value) {
		return new TSBoolean(value);
	}

	public boolean getInternal() {
		return value;
	}

	public TSBoolean toBoolean() {
		return this;
	}

	public TSString toStr() {
		if (value) {
			return TSString.create("true");
		} else {
			return TSString.create("false");
		}
	}

	public TSNumber toNumber() {
		if (value) {
			return TSNumber.create(1.0);
		} else {
			return TSNumber.create(0.0);
		}
	}

}
