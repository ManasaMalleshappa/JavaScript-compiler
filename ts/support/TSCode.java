package ts.support;

import ts.support.TSValue;

public interface TSCode {

	TSValue execute(boolean isConstructorCall, TSValue ths, TSValue args[], TSEnvironment env);
}
