package ts.support;

public class index implements TSCode {
	
	public index()
	{
		super();
	}
	
	public static index create()
	{
		return new index();
	}

	@Override
	public TSValue execute(boolean isConstructorCall, TSValue ths, TSValue[] args, TSEnvironment env) {
		// TODO Auto-generated method stub
		String source= args[0].toStr().getInternal();
		String testStr=args[1].toStr().getInternal();
		
		double res = source.indexOf(testStr);
		
		return TSNumber.make(res);
		
	}
	
	

}
