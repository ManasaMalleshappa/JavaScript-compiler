package ts;

// test Javassist with multiple classes
import ts.support.*;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtMethod;
import javassist.CtNewConstructor;
import javassist.CtNewMethod;
import javassist.Loader;
import javassist.NotFoundException;
import javassist.Modifier;

public class jA {
	public static void fatal(String message) {
		System.err.println(message);
		System.exit(-1);
	}

	public static void main(String[] args) {
		// to get generated classes dumped
		// CtClass.debugDump = "./dump";

		// get the class pool
		ClassPool pool = ClassPool.getDefault();
		pool.importPackage("ts.Message");
		pool.importPackage("ts.support");

		// create an empty class in the default class pool for the Func1 class
		CtClass theClass = pool.makeClass("Func1");

		// class will implement support.TSCode interface
		try {
			theClass.addInterface(pool.get(TSCode.class.getName()));
		} catch (NotFoundException ex) {
			fatal("cannot add TSCode interface to Func1 class");
		}

		// add a default constructor to the class
		try {
			theClass.addConstructor(CtNewConstructor.defaultConstructor(theClass));
		} catch (CannotCompileException ex) {
			fatal("cannot add a default constructor to the Func1 class: " + ex.getReason());
		}

		// now make a execute method
		String theMethodBody = "public TSValue execute(boolean isConstructorCall, TSValue ths, "
				+ "TSValue args[], TSLexicalEnvironment env)\n";
		theMethodBody += "{ System.out.println(\"execute called\");\n" + "return args[0].add(args[1]); }\n";
		CtMethod theMethod = null;
		try {
			theMethod = CtNewMethod.make(theMethodBody, theClass);
		} catch (CannotCompileException ex) {
			fatal("cannot compile the generated Func1 method body: " + ex.getReason());
		}

		// now add the execute method to the Func1 class
		try {
			theClass.addMethod(theMethod);
		} catch (CannotCompileException ex) {
			fatal("cannot add the execute method into the Func1 class: " + ex.getReason());
		}

		// create an empty class in the default class pool for the main class
		theClass = pool.makeClass("test1");

		// now make a main method with an empty body
		String theSignature = "public static void main(String args[])" + "{}";
		theMethod = null;
		try {
			theMethod = CtNewMethod.make(theSignature, theClass);
		} catch (CannotCompileException ex) {
			fatal("cannot compile the generated main method signature: " + ex.getReason());
		}

		// now set the body using the generated code
		theMethodBody = "";
		theMethodBody += "{\n";
		theMethodBody += "System.out.println(\"the main man\");\n";
		theMethodBody += "TSCode temp1 = new Func1();\n";
		theMethodBody += "System.out.println(\"Func1 created\");\n";
		theMethodBody += "TSValue temp2 = TSNumber.create(14.0);\n";
		theMethodBody += "TSValue temp3 = TSNumber.create(28.0);\n";
		theMethodBody += "TSValue temp4[] = {temp2, temp3};\n";
		theMethodBody += "System.out.println(\"args created\");\n";
		theMethodBody += "TSValue temp5 = temp1.execute(false, null, " + "temp4, null);\n";
		theMethodBody += "System.out.println(\"execute returned\");\n";
		theMethodBody += "System.out.println(temp5.toStr().getInternal());\n";
		theMethodBody += "}\n";
		try {
			theMethod.setBody(theMethodBody);
		} catch (CannotCompileException ex) {
			fatal("cannot compile the generated main method body: " + ex.getReason());
		}

		// now add the main method to the class
		try {
			theClass.addMethod(theMethod);
		} catch (CannotCompileException ex) {
			fatal("cannot add the main method into the main class: " + ex.getReason());
		}

		// add a default constructor to the class
		try {
			theClass.addConstructor(CtNewConstructor.defaultConstructor(theClass));
		} catch (CannotCompileException ex) {
			fatal("cannot add a default constructor to the main class: " + ex.getReason());
		}

		// load the main class and execute it
		Loader classLoader = new Loader(pool);
		try {
			classLoader.run("test1", new String[0]);
		} catch (Throwable ex) {
			fatal("uncaught Java exception in execution of generated code");
			ex.printStackTrace();
		}
	}
}
