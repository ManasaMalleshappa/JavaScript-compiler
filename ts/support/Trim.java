package ts.support;

import java.util.LinkedList;
import java.util.List;

public class Trim implements TSCode {
	
	public Trim()
	{
		super();
	}
	
	public static Trim create()
	{
		return new Trim();
	}

	@Override
	public TSValue execute(boolean isConstructorCall, TSValue ths, TSValue[] args, TSEnvironment env) {
		// TODO Auto-generated method stub
		String source= args[0].toStr().getInternal();
		source = source.trim();
		return(TSValue.make(source));
		}
}
