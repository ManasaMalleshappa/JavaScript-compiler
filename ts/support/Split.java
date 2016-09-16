package ts.support;

import java.util.LinkedList;
import java.util.List;

public class Split implements TSCode {
	
	public Split()
	{
		super();
	}
	
	public static Split create()
	{
		return new Split();
	}

	@Override
	public TSValue execute(boolean isConstructorCall, TSValue ths, TSValue[] args, TSEnvironment env) {
		// TODO Auto-generated method stub
		String[] value = null;
		List<String> listValues = new LinkedList<String>();
		TSObject result = new TSObject();
		if(args[0] instanceof TSString){
			TSString argV = (TSString)args[0];
			TSString argDelimiter = (TSString)args[1];
			
			String argValue = argV.getInternal();
			value = argValue.split(argDelimiter.getInternal());
			
			
			int counter =0;
			
			for(int i=0;i<value.length;i++)
			{
					if(!(listValues.contains(value[i])))
					{	
					listValues.add(value[i]);
					TSValue val1 = TSValue.make(value[i]);
					result.put(Integer.toString(counter), val1);
					counter++;
					}
			}
			
			result.put("length", TSValue.make(counter));
		}
	
		return TSValue.make(result);
	}
	
	

}
