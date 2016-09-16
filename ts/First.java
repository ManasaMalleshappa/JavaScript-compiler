//package ts;
//
//import ts.Message;
//import ts.support.*;
//
//class First {
//	public static void main(String args[]) {
//		TSValue undefined = TSUndefined.value;
//		TSObject globalObject = TSObject.field;
//		TSObject local = globalObject;
//		Readln temp0 = Readln.create();
//		TSFunctionObject temp1 = TSFunctionObject.create(temp0, null);
//		globalObject.put("readln", temp1);
//		try {
//			Message.setLineNumber(0);
//			//TSValue undefined = TSUndefined.value;
//			Message.setLineNumber(1);
//			TSObject localref = local;
//			String temp2 = "x";
//			TSValue temp3 = localref.get(temp2);
//			double temp4 = 42.0;
//			TSValue temp6 = TSValue.make(temp4);
//			temp3 = temp6;
//			TSObject localref = local;
//			String temp7 = "x";
//			null.put(temp7, TSValue.make(temp4));
//			Message.setLineNumber(2);
//			TSValue gotUndefinedVal_x = globalObject.get("x");
//			TSValue temp9 = TSUndefined.value;
//			if (((gotUndefinedVal_x) == null) && (!(false))) {
//				throw new TSException(TSValue.make(TSString.create("undefined identifier:x").toStr().getInternal()));
//			} else {
//				temp9 = gotUndefinedVal_x;
//			}
//			System.out.println(temp9.toPrimitive().toStr().getInternal());
//		} catch (TSException e) {
//			Message.executionError("Uncaught Exception:" + e.value.toStr().getInternal());
//		}
//	}
//}
