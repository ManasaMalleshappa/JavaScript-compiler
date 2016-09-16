package ts.support;

import java.util.HashMap;
import java.util.Map;

import ts.support.TSBoolean;
import ts.support.TSNumber;
import ts.support.TSValue;

public class TSObject extends TSValue {

	public Map<String, TSValue> hashm;

	public static TSObject field = new TSObject();

	public TSObject prototype;

	public TSObject() {
		super();
		hashm = new HashMap<String, TSValue>();
		hashm.put("prototype", null);

	}

	static {
		field.put("NaN", TSNumber.make(Double.NaN));
		field.put("undefined", TSUndefined.value);
		field.put("Infinity", TSValue.make(Double.POSITIVE_INFINITY));
	}

	public static TSObject create() {
		return new TSObject();
	}

	@Override
	public void put(String key, TSValue value) {
		hashm.put(key, value);
	}

	@Override
	public TSValue get(String key) {
		TSValue value = hashm.get(key);
		return value;
	}

	public Map<String, TSValue> getHashm() {
		return hashm;
	}

	public void setHashm(Map<String, TSValue> hashm) {
		this.hashm = hashm;
	}

	@Override
	public TSNumber toNumber() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TSBoolean toBoolean() {
		// TODO Auto-generated method stub
		return null;
	}

	public TSObject getPrototype() {
		return prototype;
	}

	public void setPrototype(TSObject prototype) {
		this.prototype = prototype;
	}

	@Override
	public TSValue callConstructor() {
		TSObject newObject = TSObject.create();
		newObject.setPrototype(this);
		newObject.put("prototype", newObject.getPrototype());
		return newObject;
	}

}
