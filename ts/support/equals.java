package ts.support;

import java.util.LinkedList;
import java.util.List;

public class equals implements TSCode {
	
	public equals()
	{
		super();
	}
	
	public static equals create()
	{
		return new equals();
	}

	@Override
	public TSValue execute(boolean isConstructorCall, TSValue ths, TSValue[] args, TSEnvironment env) {
		// TODO Auto-generated method stub
		String source= args[0].toStr().getInternal();
		String testStr=args[1].toStr().getInternal();
		
		if(source.equals(testStr)){
			return TSBoolean.make(true);
		}else{
			return TSBoolean.make(false);
		}
		
	}
	
	

}
