package ts.support;

import java.util.LinkedList;
import java.util.List;

public class Contains implements TSCode {
	
	public Contains()
	{
		super();
	}
	
	public static Contains create()
	{
		return new Contains();
	}

	@Override
	public TSValue execute(boolean isConstructorCall, TSValue ths, TSValue[] args, TSEnvironment env) {
		// TODO Auto-generated method stub
		boolean flag=false;
		String source= args[0].toStr().getInternal();
		String testStr=args[1].toStr().getInternal();
		String[] a = source.split(" ");
		for(int i=0;i<a.length;i++)
		{
			if(a[i].equals(testStr))
			{
				flag=true;
			}
		}
		return TSBoolean.make(flag);
		
	}
	
	

}
