package ts.support;

import java.util.Scanner;

public class Readln implements TSCode {
	
	static Scanner readline = new Scanner(System.in);

	public Readln() {
		super();
	}

	public static Readln create() {
		return new Readln();
	}

	@Override
	public TSValue execute(boolean isConstructorCall, TSValue ths, TSValue[] args, TSEnvironment env) {
		// TODO Auto-generated method stub
		String d = null;
		TSValue input = TSNull.value;
		if(readline.hasNextLine())
		{
			d = readline.nextLine();
			input = TSValue.make(d);
		}
		return input;
	}
}
