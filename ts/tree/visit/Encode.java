/**
 * Traverse an AST to generate Java code.
 *
 */

package ts.tree.visit;

import ts.Message;
import ts.support.TSException;
import ts.support.TSNull;
import ts.support.TSObject;
import ts.support.TSString;
import ts.support.TSUndefined;
import ts.support.TSValue;
import ts.Main;
import ts.tree.*;
import ts.tree.type.*;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Does a traversal of the AST to generate Java code to execute the program
 * represented by the AST.
 * <p>
 * Uses a static nested class, Encode.ReturnValue, for the type parameter. This
 * class contains two String fields: one for the temporary variable containing
 * the result of executing code for an AST node; one for the code generated for
 * the AST node.
 * <p>
 * The "visit" method is overloaded for each tree node type.
 */
public final class Encode extends TreeVisitorBase<Encode.ReturnValue> {
	/**
	 * Static nested class to represent the return value of the Encode methods.
	 * Contains the following fields:
	 * <ul>
	 * <li>a String containing the result operand name
	 * <li>a String containing the code to be generated
	 * </ul>
	 * Only expressions generate results, so the result operand name will be
	 * null in other cases, such as statements.
	 */
	public static boolean flag = false;
	
	int formalCounter = 0;
	
	LinkedList<FuncBodyData> funcList = new LinkedList<FuncBodyData>(); // List
																		// of
																		// Function
																		// Data

	static public class ReturnValue {
		/** the result operand name. */
		public String result;

		/** the code to be generated. */
		public String code;

		// initialize both fields
		private ReturnValue() {
			result = null;
			code = null;
		}

		/**
		 * Construct an encode return value for non-expressions.
		 *
		 * @param code
		 *            the code to be placed in the return value
		 */
		public ReturnValue(final String code) {
			this();
			this.code = code;
		}

		/**
		 * Construct an encode return value for most expressions.
		 *
		 * @param result
		 *            the result operand code.
		 * @param code
		 *            the code to be generated.
		 */
		public ReturnValue(final String result, final String code) {
			this();
			this.result = result;
			this.code = code;
		}
	}

	// simple counter for expression temps
	private int nextTemp = 0;

	/**
	 * Initiate an encode traversal with the output indented two spaces and the
	 * increment indentation amount set to two spaces.
	 */
	public Encode() {
		this(2, 2);
	}

	// initial indentation value
	private final int initialIndentation;

	// current indentation amount
	private int indentation;

	// how much to increment the indentation by at each level
	// using an increment of zero would mean no indentation
	private final int increment;

	// increase indentation by one level
	private void increaseIndentation() {
		indentation += increment;
	}

	// decrease indentation by one level
	private void decreaseIndentation() {
		indentation -= increment;
	}

	/**
	 * Initiate an encode traversal with the output indented by a specific
	 * amount and the increment indentation amount set to a specific amount.
	 *
	 * @param initialIndentation
	 *            the initial indentation amount.
	 * @param increment
	 *            the increment indentation amount.
	 */
	public Encode(final int initialIndentation, final int increment) {
		// setup indentation
		this.initialIndentation = initialIndentation;
		this.indentation = initialIndentation;
		this.increment = increment;
	}

	// generate a string of spaces for current indentation level
	private String indent() {
		String ret = "";
		for (int i = 0; i < indentation; i++) {
			ret += " ";
		}
		return ret;
	}

	/**
	 * Generate the main method signature.
	 * 
	 * @return the main method signature.
	 */
	public String mainMethodSignature() {
		return "public static void main(String args[])";
	}

	/**
	 * Generate and return prologue code for the main method body.
	 *
	 * @param filename
	 *            source filename.
	 * @return the prologue code for the main method body.
	 */
	public String mainPrologue(String filename) {
		String ret = "";
		ret += indent() + "{\n";
		ret += indent() + indent() + "TSValue " + "undefined " + "=TSUndefined.value;\n";
		ret += indent() + indent() + "TSObject " + "globalObject" + "=" + "TSObject.field;\n";

		ret += indent() + indent() + "TSObject local =" + "globalObject;";
		String read = getTemp();
		ret += indent() + indent() + "Readln " + read + "=" + "Readln.create(); \n";
		String readobj = getTemp();
		ret += indent() + indent() + "TSFunctionObject " + readobj + "=" + "TSFunctionObject.create(" + read + ","
				+ null + ");\n";
		ret += indent() + indent() + "globalObject.put(\"readln\"" + "," + readobj + ");\n";
		
		
		String spl = getTemp();
		
		ret += indent() + indent() + "Split " + spl + "=" + "Split.create(); \n";
		String splitobj = getTemp();
		ret += indent() + indent() + "TSFunctionObject " + splitobj + "=" + "TSFunctionObject.create(" + spl + ","
				+ null + ");\n";
		ret += indent() + indent() + "globalObject.put(\"split\"" + "," + splitobj + ");\n";
		
		
		String contai = getTemp();
		
		ret += indent() + indent() + "Contains " + contai + "=" + "Contains.create(); \n";
		String containsobj = getTemp();
		ret += indent() + indent() + "TSFunctionObject " + containsobj + "=" + "TSFunctionObject.create(" + contai + ","
				+ null + ");\n";
		ret += indent() + indent() + "globalObject.put(\"contains\"" + "," + containsobj + ");\n";
		
		String tri = getTemp();
		
		ret += indent() + indent() + "Trim " + tri + "=" + "Trim.create(); \n";
		String trimobj = getTemp();
		ret += indent() + indent() + "TSFunctionObject " + trimobj + "=" + "TSFunctionObject.create(" + tri + ","
				+ null + ");\n";
		ret += indent() + indent() + "globalObject.put(\"trim\"" + "," + trimobj + ");\n";
		
		
		String ind = getTemp();
		
		ret += indent() + indent() + "index " + ind + "=" + "index.create(); \n";
		String indobj = getTemp();
		ret += indent() + indent() + "TSFunctionObject " + indobj + "=" + "TSFunctionObject.create(" + ind + ","
				+ null + ");\n";
		ret += indent() + indent() + "globalObject.put(\"indexOf\"" + "," + indobj + ");\n";
		
		
		String eq = getTemp();
		
		ret += indent() + indent() + "equals " + eq + "=" + "equals.create(); \n";
		String eqobj = getTemp();
		ret += indent() + indent() + "TSFunctionObject " + eqobj + "=" + "TSFunctionObject.create(" + eq + ","
				+ null + ");\n";
		ret += indent() + indent() + "globalObject.put(\"equals\"" + "," + eqobj + ");\n";
		
		
		
		ret += indent() + "try" + "{" + "\n";
		increaseIndentation();
		return ret;
	}

	/**
	 * Generate and return epilogue code for the main method body.
	 *
	 * @return the epilogue code for the main method body.
	 */
	public String mainEpilogue() {
		decreaseIndentation();
		String ret = "";
		ret += indent() + "}";
		ret += "catch(TSException e) {" + "\n";
		// ret += "Message.executionError(\"Uncaught
		// Exception:\"+e.value.toStr().getInternal());" + "\n";
		ret += "Message.executionError(\"\"+e.value.toStr().getInternal());" + "\n";
		ret += indent() + "}";
		ret += indent() + "}";
		return ret;
	}

	// return string for name of next expression temp
	private String getTemp() {
		String ret = "temp" + nextTemp;
		nextTemp += 1;
		return ret;
	}

	// given AST Type, return for the matching Java type
	private String getJavaType(Type type) {
		if (type.isNumberType()) {
			return "double";
		} else if (type.isStringType()) {
			return "String";
		}
		return "TSValue";
	}

	/**
	 * Visit a list of ASTs and generate code for each of them in order. Uses a
	 * wildcard for generality: list of Statements, list of Expressions, etc.
	 * Returns a list containing the generated code for each element of the
	 * input list.
	 */
	@Override
	public List<Encode.ReturnValue> visitEach(final Iterable<?> nodes) {
		List<Encode.ReturnValue> ret = new ArrayList<Encode.ReturnValue>();

		for (final Object node : nodes) {

			ret.add(visitNode((Tree) node));
		}
		return ret;
	}

	public Encode.ReturnValue visit(final UnaryOperator unaryOperator) {
		Expression ab = unaryOperator.getAb();
		Encode.ReturnValue absReturnValue = visitNode(ab);
		String code = absReturnValue.code;
		String absResult = absReturnValue.result;

		String result = getTemp();

		final Unop op = unaryOperator.getOp();

		switch (op) {

		case SUB:
			if (ab.getType().isNumberType()) {
				code += indent() + "double " + result + " = " + "-" + absResult + ";\n";
				return new Encode.ReturnValue(result, code);

			}
			if (ab.getType().isStringType()) {

				code += indent() + "double " + result + " = " + "-(TSValue.make(" + absResult
						+ ").toNumber().getInternal());\n";
				return new Encode.ReturnValue(result, code);
			}
			if (ab.getType().isUnknownType()) {

				code += indent() + "double " + result + " = " + "-(TSValue.make(" + absResult
						+ ").toNumber().getInternal());\n";
				return new Encode.ReturnValue(result, code);
			}

		case NOT:

			code += indent() + "TSValue " + result + " = " + "TSValue.make(" + absResult + ").notlogical();\n";
			return new Encode.ReturnValue(result, code);

		}

		return new Encode.ReturnValue(result, code);
	}

	/** Generate and return code for a binary operator. */
	@Override
	public Encode.ReturnValue visit(final BinaryOperator binaryOperator) {
		// generate code to evaluate left subtree
		Expression left = binaryOperator.getLeft();
		Encode.ReturnValue leftReturnValue = visitNode(left);
		String code = leftReturnValue.code;
		String leftResult = leftReturnValue.result;

		// generate code to evaluate right subtree
		Expression right = binaryOperator.getRight();
		Encode.ReturnValue rightReturnValue = visitNode(right);
		code += rightReturnValue.code;
		String rightResult = rightReturnValue.result;

		//
		// now generate code to do the binary operator itself
		//

		// name of Java variable to receive the result value
		String result = getTemp();

		// try to do optimized code generation first
		final Binop op = binaryOperator.getOp();
		final Type type = binaryOperator.getType();
		final String opString = binaryOperator.getOpString();
		final boolean LeftFirst = true;
		switch (op) {

		case ADD:

			// if result type is Number then both operands are Numbers
			// so just perform Java add and leave result as a Java double
			if (type.isNumberType()) {
				code += indent() + "double " + result + " = " + leftResult + " + " + rightResult + ";\n";
				return new Encode.ReturnValue(result, code);
			}

			// if result type is String, then one of the operands is a String
			// but the other might not be a String, and might even be Unknown
			if (type.isStringType()) {
				// if the type of the subtree is known now to be Number, then
				// need to convert it to a TSString in order to get the
				// Javascript conversion of Number to String because the
				// conversion is different than the Java conversion of double
				// to String.
				if (left.getType().isNumberType()) {
					leftResult = "TSNumber.create(" + leftResult + ")";
				}
				if (right.getType().isNumberType()) {
					rightResult = "TSNumber.create(" + rightResult + ")";
				}

				// if the type of a subtree is not known now to be String, then
				// need to make sure it will be converted to String if necessary
				if (!left.getType().isStringType()) {
					leftResult += ".toStr().getInternal()";
				}
				if (!right.getType().isStringType()) {
					rightResult += ".toStr().getInternal()";
				}

				// generate code to do Java string concatentation
				code += indent() + "String " + result + " = " + leftResult + " + " + rightResult + ";\n";
				return new Encode.ReturnValue(result, code);
			}

			// otherwise need to do unoptimized code generation
			break;

		case SUB:
			if (!left.getType().isNumberType()) {
				leftResult = "TSValue.make(" + leftResult + ").toNumber().getInternal()";
			}
			if (!right.getType().isNumberType()) {
				rightResult = "TSValue.make(" + rightResult + ").toNumber().getInternal()";
			}

			// now generate a Java multiply
			code += indent() + "double " + result + " = " + leftResult + " - " + rightResult + ";\n";
			return new Encode.ReturnValue(result, code);

		case ASSIGN:
			String rightResult2 = "";
			// Need to handle assignment of Number or String to a variable
			// of ambiguous type. Need to check type of right child against
			// type of left child.
			if (left.getType().isUnknownType() && !right.getType().isUnknownType()) {

				// need to generate code to make a TSValue and then assign
				rightResult2 = getTemp();
				code += indent() + "TSValue " + rightResult2 + " = TSValue.make(" + rightResult + ");\n";
				code += indent() + leftResult + " = " + rightResult2 + ";\n";
			} else {
				// otherwise types match so just do the assignment
				code += indent() + leftResult + " = " + rightResult + ";\n";
			}

			if (left instanceof PropAccessor) {
				PropAccessor prop = (PropAccessor) left;
				if (prop.getValue() != null) {
					Encode.ReturnValue accessNew = visitNode(prop.getKey());
					String s3 = getTemp();
					// code += accessNew.code;
					code += indent() + "String " + s3 + "=" + "\"" + prop.getValue() + "\"" + ";\n";
					// code += indent() + accessNew.result + ".put(" + s3 + ","
					// + "TSValue.make(" + rightResult + "))"
					// + ";\n";

					if (prop.getKey() instanceof This) {
						code += indent() + "localref.put(" + s3 + "," + "TSValue.make(" + rightResult + "))" + ";\n";
					} else {
						code += accessNew.code;
						code += indent() + accessNew.result + ".put(" + s3 + "," + "TSValue.make(" + rightResult + "))"
								+ ";\n";
					}

				} else {
					Encode.ReturnValue exp = visitNode(prop.getKey());
					Encode.ReturnValue exp1 = visitNode(prop.getExp());

					code += exp.code;
					code += exp1.code;
					code += rightReturnValue.code;
					code += exp.result + ".put(TSValue.make(" + exp1.result + ").toStr().getInternal()" + ","
							+ "TSValue.make(" + rightReturnValue.result + "))" + ";\n";
				}
			}
			if (left instanceof Identifier) {
				String a = ((Identifier) left).getName();
				// Identifier var1 = ((Identifier)left).getVarNode();
				if (((Identifier) left).getVarNode() == null) {
					if (rightResult2.equals("")) {
						code += indent() + "globalObject.put(" + "\"" + a + "\"" + "," + rightResult + ");\n";
					} else {

						code += indent() + "globalObject.put(" + "\"" + a + "\"" + "," + rightResult2 + ");\n";
					}
				}
			}

			if (left instanceof Identifier) {
				Identifier id = (Identifier) left;
				if ((id.getVarNode() != null) && (id.getVarNode().getFunctionDepth() == 0)) {
					code += "if(globalObject.get(\"" + id.getName() + "\"" + ")==null){" + "\n";
					code += "globalObject.put(\"" + id.getName() + "\"" + "," + "TSValue.make(" + rightResult + "));";
					code += "}\n";
				}
			}

			// and in either case return the value from the right child
			// which can be a Java type
			return new Encode.ReturnValue(rightResult, code);

		case MULTIPLY:

			// if the type of a subtree is not known now to be Number, then
			// need to make sure it will be converted to Number if necessary
			if (!left.getType().isNumberType()) {
				leftResult = "TSValue.make(" + leftResult + ").toNumber().getInternal()";
			}
			if (!right.getType().isNumberType()) {
				rightResult = "TSValue.make(" + rightResult + ").toNumber().getInternal()";
			}

			// now generate a Java multiply
			code += indent() + "double " + result + " = " + leftResult + " * " + rightResult + ";\n";
			return new Encode.ReturnValue(result, code);

		case DIVIDE:

			// if the type of a subtree is not known now to be Number, then
			// need to make sure it will be converted to Number if necessary
			if (!left.getType().isNumberType()) {
				leftResult = "TSValue.make(" + leftResult + ").toNumber().getInternal()";
			}
			if (!right.getType().isNumberType()) {
				rightResult = "TSValue.make(" + rightResult + ").toNumber().getInternal()";
			}

			// now generate a Java multiply
			code += indent() + "double " + result + " = " + leftResult + " / " + rightResult + ";\n";
			return new Encode.ReturnValue(result, code);

		case LESS:

			code += indent() + "TSValue " + result + " = TSValue.make(" + leftResult + ").lessthan" + "(TSValue.make("
					+ rightResult + "));\n";

			return new Encode.ReturnValue(result, code);

		case GREAT:

			code += indent() + "TSValue " + result + " = TSValue.make(" + leftResult + ").greaterthan"
					+ "(TSValue.make(" + rightResult + "));\n";

			return new Encode.ReturnValue(result, code);

		case EQUAL:

			code += indent() + "TSValue " + result + " = TSValue.make(" + leftResult + ").isequal" + "(TSValue.make("
					+ rightResult + "));\n";

			return new Encode.ReturnValue(result, code);

		default:
			Message.bug("unexpected operator: " + opString);
		}

		//
		// if control reaches here then do unoptimized code generation
		//

		// one of the subtrees might be a Java value at run-time so
		// need to generate code that will convert it to a TSValue if necessary
		String methodName = getMethodNameForBinaryOperator(binaryOperator);
		code += indent() + "TSValue " + result + " = TSValue.make(" + leftResult + ")." + methodName + "(TSValue.make("
				+ rightResult + "));\n";

		return new Encode.ReturnValue(result, code);
	}

	// support routine for handling binary operators
	private static String getMethodNameForBinaryOperator(final BinaryOperator opNode) {
		final Binop op = opNode.getOp();

		switch (op) {
		case ADD:
			return "add";
		case MULTIPLY:
			return "multiply";
		case SUB:
			return "subtract";
		case DIVIDE:
			return "divide";
		case LESS:
			return "lessthan";
		case GREAT:
			return "greaterthan";
		case EQUAL:
			return "isequal";
		default:
			Message.bug("unexpected operator: " + opNode.getOpString());
		}
		// cannot reach
		return null;
	}

	/** Generate and return code for an expression statement. */
	@Override
	public Encode.ReturnValue visit(final ExpressionStatement expressionStatement) {
		Encode.ReturnValue exp = visitNode(expressionStatement.getExp());
		String code = indent() + "Message.setLineNumber(" + expressionStatement.getLineNumber() + ");\n";
		code += exp.code;
		return new Encode.ReturnValue(code);
	}

	@Override
	public Encode.ReturnValue visit(final NewExpression expression) {
		String code = "";
		Encode.ReturnValue exp = visit((Identifier) expression.getKey());
		String temp = getTemp();
		code += exp.code;

		code += indent() + "TSValue " + temp + "=" + exp.result + ".callConstructor();" + "\n";
		return new Encode.ReturnValue(temp, code);
	}

	/** Generate and return code for an Function Expression. */
	@Override
	public Encode.ReturnValue visit(final FunctionExpression expressionStatement) {

		String temp1 = getTemp();
		String func = "Func_" + getTemp();

		String code = "TSCode " + temp1 + "=" + "new " + func + "();";

		String temp2 = getTemp();
		code += "TSValue " + temp2 + "=" + "TSFunctionObject.create(" + temp1 + ",null);";

		funcList.add(new FuncBodyData(func, visit((BlockStatement) expressionStatement.getB1()).code));

		formalCounter =0;
		return new Encode.ReturnValue(temp2, code);
	}

	/** Generate and return code for Call Expression. */
	@Override
	public Encode.ReturnValue visit(final CallExpression expressionCall) {
		
		Encode.ReturnValue code1 = visit((Identifier) expressionCall.getE1());

		String code = " ";
		
		String result = getTemp();

		code += indent() + code1.code;

		String args1 = "args1_"+getTemp();
		
		code += "\n" + "TSValue[] "+args1 + "=" + "new TSValue[" + expressionCall.getArgs1().size()+ "];" +"\n" ;
		
		int count =0 ;
		
		for(Expression arg : expressionCall.getArgs1()){
			Encode.ReturnValue argCode = visitNode(arg);
			code += indent() + argCode.code;
			
			String formalArgs = "formal_"+getTemp();
			
			code += "TSValue " + formalArgs + "=" + "TSValue.make(" +argCode.result + ");" + "\n" ;
			
			code += args1 + "[" +count+ "] = " + formalArgs +";\n" ;
			
			count++;
		}
		
		code += "\n" + "TSValue " + result +"=" +code1.result + ".functionCall(null , "+args1 +")" + ";\n";
		
		return new Encode.ReturnValue(result, code);
	}
	

	/** Generate and return code for an identifier. */
	@Override
	public Encode.ReturnValue visit(final Identifier identifier) {
		String result = null;
		String code = "";

		// info about the variable is stored in the VarStatement node
		// that declared it
		VarStatement varNode = identifier.getVarNode();

		// if there is no link back to the Var declaration then
		// the identifier is not declared
		if (varNode == null) {
			// if identifier is an lval then eventually we will need to insert
			// a property into the global object, but since we are not yet
			// implementing the global object, we need to treat this case as
			// an error, same as rval
			// System.out.println(code);
			// String temp= "Message.executionError(\"undefined identifier: " +
			// identifier.getName() + "\");\n";
			// code += indent() + "Message.executionError(\"undefined
			// identifier: " + identifier.getName() + "\");\n";
			String temp = getTemp();

			if (identifier.getName().equals("NaN")) {
				code += indent() + "TSValue getNanVal = globalObject.get(\"NaN\");" + "\n";
				result = "getNanVal";
			}

			else if (identifier.getName().equals("undefined")) {
				code += indent() + "TSValue getUndefined = globalObject.get(\"undefined\");" + "\n";
				result = "getUndefined";
			}

			else if (identifier.getName().equals("Infinity")) {
				code += indent() + "TSValue getInfinity = globalObject.get(\"Infinity\");" + "\n";
				result = "getInfinity";
			} else {

				// code += "TSValue " + "gotUndefinedVal_"+identifier.getName()
				// + "=" + "globalObject.get(\"" + identifier.getName() + "\");"
				// + "\n";
				// result = getTemp();
				// code += indent() + "TSValue " + result + " =
				// gotUndefinedVal_"+identifier.getName()+ ";\n";

				code += "TSValue " + "gotUndefinedVal_" + identifier.getName() + "=" + "globalObject.get(\""
						+ identifier.getName() + "\");" + "\n";
				result = getTemp();
				code += "TSValue " + result + "= TSUndefined.value;";
				code += "if( ((gotUndefinedVal_" + identifier.getName() + ")== null) && (!(" + identifier.isLval()
						+ ")))" + "{";
				code += indent() + "throw new TSException(TSValue.make(TSString.create(\"undefined identifier:"
						+ identifier.getName() + "\").toStr().getInternal()));";
				code += "}" + "\n";
				code += "else{";
				code += indent() + result + " = gotUndefinedVal_" + identifier.getName() + ";}\n";
			}

			// code += indent() +
			//
			// "if(true)" + indent() + "throw new
			// TSException(TSValue.make(TSString.create(\"undefined identifier:"
			// + identifier.getName() + "\").toStr().getInternal()))"

			// + ";\n";

			// so that the Java code will compile, need to build a dummy result
			// result = getTemp();
			// code += indent() + "TSValue " + result + " = gotUndefinedVal;\n";
		}
		// otherwise identifier is declared
		else {
			String codegenName = varNode.getTempName();
			
			if(varNode.getFunctionDepth() > 0)
			{
				codegenName = "arg[" + formalCounter +"]";
				formalCounter++;
			}
			Type type = varNode.getType();

			// does the identifier denote the address of a variable or its
			// value?
			if (identifier.isLval()) {
				// just need the variable's address (so no code needs to be
				// generated)
				result = codegenName;
			} else {
				// need to deref the variable to get its value
				String jType = getJavaType(type);
				result = getTemp();
				code += indent() + jType + " " + result + " = " + codegenName + ";\n";
			}
		}

		return new Encode.ReturnValue(result, code);
	}

	/** Generate and return code for a numeric literal. */
	@Override
	public Encode.ReturnValue visit(final NumericLiteral numericLiteral) {
		String result = getTemp();
		String code = indent() + "double " + result + " = " + numericLiteral.getValue() + ";\n";

		return new Encode.ReturnValue(result, code);
	}

	@Override
	public Encode.ReturnValue visit(final ObjLiteral objliteral) {

		String a = getTemp();
		String code = indent() + "TSObject " + a + " = " + "TSObject.create()" + ";\n";

		if (objliteral.getValue() != null) {
			for (Expression val : objliteral.getValue()) {
				propAssignment val1 = (propAssignment) val;

				Encode.ReturnValue fiel = null;

				if (val1.getName() instanceof StringLiteral) {
					fiel = visit(val1.getName());
				}

				Encode.ReturnValue va = null;
				if (val1.getValue() instanceof NumericLiteral) {
					va = visit((NumericLiteral) val1.getValue());
				} else if (val1.getValue() instanceof StringLiteral) {
					va = visit((StringLiteral) val1.getValue());
				} else if (val1.getValue() instanceof BinaryOperator) {
					va = visit((BinaryOperator) val1.getValue());
				} else if (val1.getValue() instanceof Identifier) {
					va = visit((Identifier) val1.getValue());
				}

				code += indent() + fiel.code;

				code += indent() + va.code;

				code += indent() + a + ".put(" + fiel.result + "," + "TSValue.make(" + va.result + "));" + "\n";
			}
		}

		return new Encode.ReturnValue(a, code);
	}

	@Override
	public Encode.ReturnValue visit(final PropAccessor propertyAccessor) {
		String s1 = getTemp();

		String code = " ";

		String s2 = getTemp();

		if (propertyAccessor.getExp() != null) {

			Encode.ReturnValue accessor1 = visitNode(propertyAccessor.getKey());
			Encode.ReturnValue accessor2 = visitNode(propertyAccessor.getExp());
			code += indent() + accessor1.code;

			code += indent() + accessor2.code;

			if (propertyAccessor.getExp() instanceof PropAccessor) {
				code += indent() + "TSValue " + s2 + "=" + accessor1.result + ".get(" + accessor2.result
						+ ".toPrimitive().toStr().getInternal()" + ");\n";
			} else {
				if ((propertyAccessor.getExp() instanceof BinaryOperator)
						|| (propertyAccessor.getExp() instanceof Identifier)
						|| (propertyAccessor.getExp() instanceof NumericLiteral)
						|| (propertyAccessor.getExp() instanceof NullLiteral)) {
					String temp = getTemp();

					code += indent() + "TSValue " + temp + "=" + "TSValue.make(" + accessor2.result + ")" + ";\n";
					code += indent() + "TSValue " + s2 + "=" + accessor1.result + ".get(" + temp
							+ ".toPrimitive().toStr().getInternal()" + ");\n";

				} else {
					code += indent() + "TSValue " + s2 + "=" + accessor1.result + ".get(" + accessor2.result + ");\n";
				}
			}
		}

		else {

			if (propertyAccessor.getKey() instanceof This) {

				Encode.ReturnValue accessor = visitNode(propertyAccessor.getKey());

				code += indent() + accessor.code;

				code += indent() + "String " + s1 + "=" + "\"" + propertyAccessor.getValue() + "\"" + ";\n";

				code += indent() + "TSValue " + s2 + "=" + "localref" + ".get(" + s1 + ");\n";

				code += "if(" + s2 + " instanceof TSObject){" + "\n";

				code += indent() + "throw new TSException(TSValue.make(TSString.create(\"TSObject type error"
						+ "\").toStr().getInternal()));";
				code += "}";

			}
			// Encode.ReturnValue accessor =
			// visitNode(propertyAccessor.getKey());
			//
			// code += indent() + accessor.code;
			//
			// code += indent() + "String "+ s1 + "=" + "\"" +
			// propertyAccessor.getValue() + "\"" + ";\n" ;
			//
			// code += indent() + "TSValue " + s2 + "=" + accessor.result +
			// ".get(" + s1 + ");\n" ;
			else {
				Encode.ReturnValue accessor = visitNode(propertyAccessor.getKey());

				String obj = getTemp();

				String obj1 = getTemp();

				code += accessor.code;
				code += indent() + "String " + s1 + "=" + "\"" + propertyAccessor.getValue() + "\"" + ";\n";
				code += indent() + "TSValue " + s2 + "=" + "TSUndefined.value" + ";\n";
				code += indent() + "TSObject " + obj + "=" + "(TSObject)" + accessor.result + ";\n";
				code += indent() + indent() + "double i = 0.0;";
				code += indent() + "while(true) {" + "\n";

				code += indent() + indent() + "if(" + obj + ".get(" + s1 + ")" + "!= " + "null) { " + "\n";
				code += indent() + indent() + indent() + s2 + "=" + obj + ".get(" + s1 + ");\n";

				code += indent() + indent() + indent() + "break;" + "\n";
				code += indent() + indent() + "}" + "\n";
				code += indent() + indent() + "else { " + "\n";
				String la = getTemp();
				code += indent() + indent() + indent() + "TSObject " + la + " = " + "(TSObject)" + obj + ".get("
						+ "\"prototype\"" + ");\n";
				code += indent() + indent() + indent() + "if((" + la + "!=" + "null" + ")&& i<10)" + "{ \n";
				code += "i++;";
				code += indent() + indent() + indent() + indent() + obj + "=" + la + ";\n";
				code += indent() + indent() + "} \n";
				code += indent() + indent() + indent() + "else {" + "\n";

				code += indent() + indent() + "if(i==10){TSValue " + obj1 + "=" + " TSValue.make(1066.00); ";
				code += s2 + "=" + obj1 + ";";
				code += "}";
				code += indent() + indent() + indent() + indent() + "break;\n";
				code += indent() + indent() + "} \n";
				code += indent() + indent() + "} \n";
				code += indent() + "} \n";
			}
		}

		return new Encode.ReturnValue(s2, code);
	}

	/** Generate and return code for a Null literal. */
	@Override
	public Encode.ReturnValue visit(final NullLiteral nullLiteral) {
		String result = getTemp();
		String code = indent() + "TSValue " + result + " = " + "TSNull.value" + ";\n";

		return new Encode.ReturnValue(result, code);
	}

	/** Generate and return code for Empty Statement. */
	public Encode.ReturnValue visit(final EmptyStatement emptyStatement) {
		String result = getTemp();
		String code = indent() + "TSValue " + result + " = " + "TSUndefined.value" + ";\n";

		return new Encode.ReturnValue(result, code);
	}

	/** Generate and return code for a boolean literal. */
	@Override
	public Encode.ReturnValue visit(final BooleanLiteral booleanLiteral) {
		String result = getTemp();

		String code = indent() + "TSValue " + result + " = " + "TSBoolean.create(" + booleanLiteral.getValue() + ")"
				+ ";\n";

		return new Encode.ReturnValue(result, code);
	}

	/** Generate and return code for a print statement. */
	@Override
	public Encode.ReturnValue visit(final PrintStatement printStatement) {
		Type type = printStatement.getExp().getType();
		Encode.ReturnValue exp = visitNode(printStatement.getExp());
		String code = indent() + "Message.setLineNumber(" + printStatement.getLineNumber() + ");\n";
		code += exp.code;
		if (type.isNumberType()) {
			// need to apply Javascript Number -> String conversion
			code += indent() + "System.out.println(TSNumber.create(" + exp.result + ").toStr().getInternal());\n";
		} else if (type.isStringType()) {
			code += indent() + "System.out.println(" + exp.result + ");\n";
		} else {
			code += indent() + "System.out.println(" + exp.result + ".toPrimitive().toStr().getInternal());\n";
		}
		return new Encode.ReturnValue(code);
	}

	/** Generate and return code for a program. */
	@Override
	public Encode.ReturnValue visit(final Program program) {

		String code = "";

		if (Analyze.flag) {
			for (Encode.ReturnValue value : visitEach(program.getList())) {

				code += value.code;
			}
		} else {
			for (Encode.ReturnValue value : visitEach(program.getSc())) {

				code += value.code;
			}

			List<Statement> li = new LinkedList<Statement>();
			for (Statement s : program.getList()) {
				if (!(s instanceof VarStatement)) {
					li.add(s);
				}
			}

			for (Encode.ReturnValue value : visitEach(li)) {

				code += value.code;

			}
		}

		return new Encode.ReturnValue(code);
	}

	/** Generate and return code for a Block Statement. */
	@Override
	public Encode.ReturnValue visit(final BlockStatement statement) {
		String code = "";
		if (Analyze.flag) {
			for (Encode.ReturnValue value : visitEach(statement.getList())) {
				code += value.code;
			}
		} else {
			List<Statement> li = new LinkedList<Statement>();
			for (Statement s : statement.getList()) {
				if (!(s instanceof VarStatement)) {
					li.add(s);
				}
			}
			for (Encode.ReturnValue value : visitEach(li)) {
				code += value.code;
			}
		}

		return new Encode.ReturnValue("{" + code + "}");
	}

	/** Generate and return code for a While Statement. */
	@Override
	public Encode.ReturnValue visit(final WhileStatement statement) {

		Encode.ReturnValue value = visitNode(statement.getExp());
		String code = "";
		if (statement.getS() instanceof BlockStatement) {
			code += indent() + "while(true)\n" + indent() + "{\n" + value.code + "\n" + indent() + "if(!TSValue.make("
					+ value.result + ").toBoolean().getInternal())" + indent() + "break;\n" + indent()
					+ visit((BlockStatement) statement.getS()).code + "}";
		} else if (statement.getS() instanceof ExpressionStatement) {
			code += indent() + "while(true)\n" + indent() + "{\n" + value.code + "\n" + indent() + "if(!TSValue.make("
					+ value.result + ").toBoolean().getInternal())" + indent() + "break;\n" + indent()
					+ visit((ExpressionStatement) statement.getS()).code + "}";
		} else if (statement.getS() instanceof BreakStatement) {
			code += indent() + "while(true)\n" + indent() + "{\n" + value.code + "\n" + indent() + "if(!TSValue.make("
					+ value.result + ").toBoolean().getInternal())" + indent() + "break;\n" + indent()
					+ visit((BreakStatement) statement.getS()).code + "}";
		} else if (statement.getS() instanceof ContinueStatement) {
			code += indent() + "while(true)\n" + indent() + "{\n" + value.code + "\n" + indent() + "if(!TSValue.make("
					+ value.result + ").toBoolean().getInternal())" + indent() + "break;\n" + indent()
					+ visit((ContinueStatement) statement.getS()).code + "}";
		} else if (statement.getS() instanceof PrintStatement) {
			code += indent() + "while(true)\n" + indent() + "{\n" + value.code + "\n" + indent() + "if(!TSValue.make("
					+ value.result + ").toBoolean().getInternal())" + indent() + "break;\n" + indent()
					+ visit((PrintStatement) statement.getS()).code + "}";
		}

		return new Encode.ReturnValue(code);
	}

	/** Generate and return code for a If Statement. */
	@Override
	public Encode.ReturnValue visit(final IfStatement statement) {

		Encode.ReturnValue value = visitNode(statement.getExp());
		String code = "";

		if (statement.getS2() == null) {

			code += value.code + "\n" + indent() + "if(TSValue.make(" + value.result + ").toBoolean().getInternal())"
					+ indent() + "{" + checkInstance(code, statement.getS1()) + "}" + "\n";

		} else {
			code += value.code + "\n" + indent() + "if(TSValue.make(" + value.result

					+ ").toBoolean().getInternal())" + indent() + "{" +

			checkInstance(code, statement.getS1()) + "}" +

			"else \n" +

			indent() + "{" + checkInstance(code, statement.getS2()) + "}";
		}

		return new Encode.ReturnValue(code);
	}

	/** Check the instance of Statement. */
	private String checkInstance(String code, Statement genStatement) {
		if (genStatement instanceof ExpressionStatement) {
			code += visit((ExpressionStatement) genStatement).code;
		}
		if (genStatement instanceof BlockStatement) {
			code += visit((BlockStatement) genStatement).code;
		}
		if (genStatement instanceof ContinueStatement) {
			code += visit((ContinueStatement) genStatement).code;
		}
		if (genStatement instanceof BreakStatement) {
			code += visit((BreakStatement) genStatement).code;
		}
		if (genStatement instanceof PrintStatement) {
			code += visit((PrintStatement) genStatement).code;
		}
		return code;
	}

	/** Generate and return code for a Continue Statement. */
	@Override
	public Encode.ReturnValue visit(final ContinueStatement statement) {
		String code = "";
		if (statement.getCounter() == 0) {
			code += indent() +

			"if(true)" + indent()
					+ "throw new TSException(TSValue.make(TSString.create(\"Illegal Continue Statement\").toStr().getInternal()))"

					+ ";\n";
		} else {
			code += "if(true)" + indent() + "continue;" + ";\n";
		}
		return new Encode.ReturnValue(code);
	}

	/** Generate and return code for a Return Statement. */
	@Override
	public Encode.ReturnValue visit(final ReturnStatement statement) {
		String code = "";
		Encode.ReturnValue result = visitNode(statement.getE());

		if (statement.getE() != null) {
			code = "if(true) " + ";\n";
			code += result.code;
			code += "return " + "TSValue.make(" + result.result + ");";
		} else {
			code = "if(true) " + ";\n";
			code += "return " + "TSUndefined.value;";
		}
		return new Encode.ReturnValue(code);
	}

	/** Generate and return code for a Break Statement. */
	@Override
	public Encode.ReturnValue visit(final BreakStatement statement) {
		String code = "";
		if (statement.getCounter() == 0) {
			code += indent() + "if(true)" + indent()
					+ "throw new TSException(TSValue.make(TSString.create(\"Illegal Break Statement\").toStr().getInternal()))"

					+ ";\n";
		} else {

			code += "if(true)" + indent() + "break;" + ";\n";
		}
		return new Encode.ReturnValue(code);
	}

	@Override
	public Encode.ReturnValue visit(final This statement) {
		String code = "";
		code += "TSObject localref = local;\n";
		return new Encode.ReturnValue(code);
	}

	/** Generate and return code for a Try Statement. */
	@Override
	public Encode.ReturnValue visit(final TryStatement statement) {
		String code = "";
		if (statement.getF() == null) {
			code += "try " + visit((BlockStatement) statement.getB()).code
					+ visit((CatchStatement) statement.getC()).code;
		}
		if (statement.getC() == null) {
			code += "try " + visit((BlockStatement) statement.getB()).code
					+ visit((FinallyStatement) statement.getF()).code;
		}
		if (statement.getC() != null && statement.getF() != null) {
			code += "try " + visit((BlockStatement) statement.getB()).code
					+ visit((CatchStatement) statement.getC()).code + visit((FinallyStatement) statement.getF()).code;
		}
		return new Encode.ReturnValue(code);
	}

	public LinkedList<FuncBodyData> getFuncList() {
		return funcList;
	}

	/** Generate and return code for a Finally Statement. */
	@Override
	public Encode.ReturnValue visit(final FinallyStatement statement) {
		String code = "finally " + visit((BlockStatement) statement.getS()).code + "\n";
		return new Encode.ReturnValue(code);
	}

	/** Generate and return code for a Catch Statement. */
	@Override
	public Encode.ReturnValue visit(final CatchStatement statement) {
		String code = "catch(TSException " + statement.getName() + "){" + "TSValue " + "catch_e_0" + "="
				+ statement.getName() + ".value;" + visit((BlockStatement) statement.getB()).code + "}" + "\n";
		return new Encode.ReturnValue(code);
	}

	/** Generate and return code for a Throw Statement. */
	@Override
	public Encode.ReturnValue visit(final ThrowStatement statement) {
		Encode.ReturnValue value = visitNode(statement.getE());

		String code = indent() + indent() + value.code + indent() +

		"if(true)" + indent() + "throw new TSException(TSValue.make(" + value.result + "))"

				+ ";\n";

		return new Encode.ReturnValue(code);
	}

	/** Generate and return code for a string literal. */
	@Override
	public Encode.ReturnValue visit(final StringLiteral stringLiteral) {
		String result = getTemp();
		String code = indent() + "String " + result + " = \"" + stringLiteral.getValue() + "\";\n";

		return new Encode.ReturnValue(result, code);
	}

	/** Generate and return code for a var statement. */
	@Override
	public Encode.ReturnValue visit(final VarStatement varStatement) {
		// if this var node is redundant, then skip it
		if (varStatement.isRedundant()) {
			return new Encode.ReturnValue("");
		}

		String code = indent() + "Message.setLineNumber(" + varStatement.getLineNumber() + ");\n";

		// if this variable was never used, then Type will be null.
		// in that case treat as if the type is unknown
		Type type = varStatement.getType();
		if (type == null || type.isUnknownType()) {
			code += indent() + "TSValue " + varStatement.getTempName() + " = TSUndefined.value;\n";
		} else {
			String jType = getJavaType(type);
			code += indent() + jType + " " + varStatement.getTempName() + ";\n";
		}

		return new Encode.ReturnValue(code);
	}

}
