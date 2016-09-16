package ts.support;

public class TSFunctionObject extends TSObject {

	public TSCode code;

	public TSEnvironment env;
	
	public TSValue value;
	
	public TSValue arg;

	public TSFunctionObject(TSCode code, TSEnvironment env) {

		this.code = code;
		this.env = env;
		this.value = null;
	}

	public static TSFunctionObject create(TSCode code, TSEnvironment env) {
		return new TSFunctionObject(code, env);
	}

	@Override
	public TSValue functionCall(TSValue value,TSValue[] arg) {
		this.value = value;
		return code.execute(false, value, arg, env);
	}

}
