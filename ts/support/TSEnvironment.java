package ts.support;

import ts.support.TSValue;

public class TSEnvironment {

	public TSEnvironment outer;
	public TSValue[] vars;

	public TSEnvironment(TSEnvironment outer, TSValue[] vars) {
		super();
		this.outer = outer;
		this.vars = vars;
	}

}
