package ts.support;

public class TSException extends RuntimeException {

	public TSValue value;
	public TSString st;

	public TSException(TSValue value) {
		super();
		this.value = value;
	}

	public TSValue getValue() {
		return value;
	}

	public void setValue(TSValue value) {
		this.value = value;
	}

}
