
package ts.tree.visit;

import ts.Location;
import ts.Message;
import ts.parse.TreeBuilder;
import ts.tree.*;
import ts.tree.type.*;
import static ts.tree.Binop.*;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Map;
import java.util.Map.Entry;

import javassist.bytecode.Descriptor.Iterator;

import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;

/**
 * Analyze an AST. The goal is to do simple type inferencing and to identify
 * where variables will be stored at run-time. For now, they they will be stored
 * in a Java local, but later this code will need to be updated to support
 * variables captured by a closure, and global variables stored as properties of
 * the global object.
 * <p>
 * When the analyzer is created, a pass number is provided to the constructor,
 * which must be either 1 (first pass) or 2 (second pass). The first pass
 * connects Identifier nodes to the VarStatement nodes where the identifier was
 * declared. Information is accumulated in the VarStatement node about the
 * variable, including its function depth (how deeply nested is the function
 * that contains the declaration) and its type. A second pass is needed because
 * if the type is ambiguous for a variable, then its initial uses may not
 * reflect the ambiguous type that was found later. The expression trees
 * containing these Identifier nodes need to have their types updated in the
 * second pass.
 * <p>
 * Using Tree for the type parameter to allow subtrees to be altered by visiting
 * them. The return type can be assigned to the fields of a node as the
 * traversal returns back to it. This capability is actually not being used, but
 * it might be useful later.
 * <p>
 * The "visit" method is overloaded for each tree node type.
 */
public final class Analyze extends TreeVisitorBase<Tree> {

	/**
	 * The symbol table. It is a map of variable names to stacks of VarStatement
	 * nodes.
	 */
	private Map<String, Deque<VarStatement>> symbolTable;

	public static int counter = 0;

	/** The current function declaration depth. Always zero now. */
	private int functionDepth = 0;

	public static boolean flag = false;

	/**
	 * The pass being implemented by this instance of the analyze visitor. Must
	 * be either 1 (first pass) or 2 (second pass).
	 */
	private int pass;

	/**
	 * Create an AST analyzer.
	 *
	 * @param pass
	 *            pass number to be implemented by this analyze visitor, which
	 *            must be either 1 (first pass) or 2 (second pass).
	 * 
	 *            Undefined Parameter defined and added to symbol table (Phase
	 *            1)
	 * 
	 */
	public Analyze(int pass) {
		if (pass < 1 || pass > 2) {
			throw new IllegalArgumentException("illegal pass number");
		}
		this.pass = pass;
		symbolTable = new HashMap<String, Deque<VarStatement>>();
		Location loc = new Location("", 0, 0);
		VarStatement var12 = (VarStatement) TreeBuilder.buildVarStatement(loc, "undefined");
		Deque<VarStatement> s = new LinkedList<VarStatement>();
		symbolTable.put(var12.getName(), s);
		s.addFirst(var12);
		var12.setTempName("undefined");
		var12.setType(UnknownType.getInstance());
	}

	/**
	 * Visit a list of ASTs and dump them in order.
	 */
	@Override
	public List<Tree> visitEach(final Iterable<?> nodes) {
		for (final Object node : nodes) {
			visitNode((Tree) node);
		}
		return null;
	}

	/**
	 * Analyze a Unary operator. Unary Minus,Unary Not (Phase1)
	 * 
	 */
	@Override
	public Tree visit(final UnaryOperator unaryOperator) {
		unaryOperator.setAb((Expression) visitNode(unaryOperator.getAb()));
		Unop op = unaryOperator.getOp();
		Type absType = unaryOperator.getAb().getType();

		switch (op) {
		case SUB:
			unaryOperator.setType(NumberType.getInstance());
			break;
		case NOT:
			unaryOperator.setType(UnknownType.getInstance());
		}
		return unaryOperator;
	}

	/**
	 * Analyze a binary operator. Subtract,Divide,Less,Great,Equal (Phase1)
	 * 
	 */
	@Override
	public Tree visit(final BinaryOperator binaryOperator) {
		// recurse left and then right
		binaryOperator.setLeft((Expression) visitNode(binaryOperator.getLeft()));
		binaryOperator.setRight((Expression) visitNode(binaryOperator.getRight()));

		// now do type analysis
		Binop op = binaryOperator.getOp();
		Type leftType = binaryOperator.getLeft().getType();
		Type rightType = binaryOperator.getRight().getType();

		switch (op) {
		case ADD:
			// if either operand is a string, then result is a string
			if (leftType.isStringType() || rightType.isStringType()) {
				binaryOperator.setType(StringType.getInstance());
			}
			// if both are numbers, then result is number
			else if (leftType.isNumberType() && rightType.isNumberType()) {
				binaryOperator.setType(NumberType.getInstance());
			}
			// otherwise can't tell now what result type will be
			else {
				binaryOperator.setType(UnknownType.getInstance());
			}
			break;
		case ASSIGN:
			// type of the result is the type of the right-hand side
			binaryOperator.setType(rightType);
			// if the left-hand side is an identifier, then on pass 1
			// update its declaring VarStatement node (if there is one)
			if ((pass == 1) && (binaryOperator.getLeft() instanceof Identifier)) {
				Identifier id = (Identifier) binaryOperator.getLeft();
				VarStatement node = id.getVarNode();
				// might not be declared
				if (node != null) {
					// update the type information recorded so far for variable
					Type oldType = node.getType();
					if (oldType == null) {
						// no type seen before
						node.setType(rightType);
					} else {
						// if old type does not match the current type, then
						// the type is ambigous
						if (!oldType.isSameType(rightType)) {
							// so label the variable as having unknown type
							node.setType(UnknownType.getInstance());
						}
					}
				}
			}
			break;
		case MULTIPLY:
			// always produces a number
			binaryOperator.setType(NumberType.getInstance());
			break;
		case DIVIDE:
			// always produces a number
			binaryOperator.setType(NumberType.getInstance());
			break;
		case SUB:
			binaryOperator.setType(NumberType.getInstance());
			break;
		case LESS:
			binaryOperator.setType(UnknownType.getInstance());
			break;
		case GREAT:
			binaryOperator.setType(UnknownType.getInstance());
			break;
		case EQUAL:
			binaryOperator.setType(UnknownType.getInstance());
			break;
		default:
			Message.bug("unexpected binary operator");
		}

		// return this node so it can be re-assigned by its parent
		return binaryOperator;
	}

	/** Analyze an expression statement. */
	@Override
	public Tree visit(final ExpressionStatement expressionStatement) {
		visitNode(expressionStatement.getExp());
		return null;
	}

	/** Analyze a Return statement. */
	@Override
	public Tree visit(final ReturnStatement returnStatement) {

		if (returnStatement.getE() != null) {
			visitNode(returnStatement.getE());
		}
		return returnStatement;
	}

	/** Analyze a Break statement. */
	@Override
	public Tree visit(final BreakStatement breakStatement) {
		breakStatement.setCounter(counter);
		return breakStatement;
	}

	/** Analyze a Continue statement. */
	@Override
	public Tree visit(final ContinueStatement continueStatement) {
		continueStatement.setCounter(counter);
		return continueStatement;
	}

	/** Analyze an identifier. */
	@Override
	public Tree visit(final Identifier identifier) {
		// if it is the second pass then only need to copy the type from
		// the Var node.
		if (pass == 2) {
			VarStatement varNode = identifier.getVarNode();
			if (varNode == null) {
				// identifier is not defined, so set its type to unknown
				identifier.setType(UnknownType.getInstance());
			} else {
				Type type = varNode.getType();
				if (type == null) {
					// variable was never assigned so set the type to unknown
					identifier.setType(UnknownType.getInstance());
				} else {
					// otherwise use the type in the var node
					identifier.setType(type);
				}
			}
			// that is all we need to do for pass 2
			return identifier;
		}

		//
		// all the following code is only executed on pass 1
		//
		Deque<VarStatement> stack;
		// lookup the name in the symbol table,check the depth of the variable.
		if (functionDepth > 0) {
			stack = symbolTable.get("var_" + identifier.getName() + "_" + functionDepth);
		} else {
			stack = symbolTable.get(identifier.getName());
		}
		if (stack != null) {
			VarStatement varNode = stack.peekFirst();
			if (varNode != null) {
				// record the declaration tree node into the identifier tree
				// node so
				// that code generator has access to what is learned about this
				// variable
				identifier.setVarNode(varNode);

				// check the type field of the Var node
				// if it is null, and the identifier represents an Rval, then
				// this is a use of the variable before it is assigned to,
				// meaning
				// that it will contain the undefined value, so its type needs
				// to be set to Unknown, since the variable lifetime is not
				// always Number or always String
				if (varNode.getType() == null && !identifier.isLval()) {
					varNode.setType(UnknownType.getInstance());
					identifier.setType(UnknownType.getInstance());
				} else {
					// otherwise set this type to be the type from the var node
					identifier.setType(varNode.getType());
				}
			} else {
				// identifier is not defined, so set its type to Unknown
				identifier.setType(UnknownType.getInstance());
			}
		} else {
			// identifier is not defined, so set its type to Unknown
			identifier.setType(UnknownType.getInstance());
		}

		// return the node so that it can be re-assigned by its parent
		return identifier;
	}

	/** Analyze a numeric literal. */
	@Override
	public Tree visit(final NumericLiteral numericLiteral) {
		// always has Number type
		numericLiteral.setType(NumberType.getInstance());

		// return the node so that it can be re-assigned by its parent
		return numericLiteral;
	}

	/** Analyze a Boolean literal. */
	@Override
	public Tree visit(final BooleanLiteral booleanLiteral) {
		// always has Number type
		booleanLiteral.setType(UnknownType.getInstance());

		// return the node so that it can be re-assigned by its parent
		return booleanLiteral;
	}

	/** Analyze a Null literal. */
	@Override
	public Tree visit(final NullLiteral nullLiteral) {
		// always has Number type
		nullLiteral.setType(UnknownType.getInstance());

		// return the node so that it can be re-assigned by its parent
		return nullLiteral;
	}

	/** Analyze a print statement. */
	@Override
	public Tree visit(final PrintStatement printStatement) {
		visitNode(printStatement.getExp());
		return null;
	}

	/** Analyze an Empty Statement. */
	@Override
	public Tree visit(final EmptyStatement emptyStatement) {
		emptyStatement.setType(UnknownType.getInstance());
		return emptyStatement;
	}

	/** Analyze a program. */
	@Override
	public Tree visit(final Program program) {

		visitEach(program.getList());

		if (flag) {

		} else {
			Deque<VarStatement> s = new LinkedList<VarStatement>();
			Deque<VarStatement> s1 = new LinkedList<VarStatement>();

			if (pass == 1) {

				for (Map.Entry<String, Deque<VarStatement>> entry : symbolTable.entrySet()) {

					s = symbolTable.get(entry.getValue());
					if (entry.getValue().isEmpty()) {
						continue;
					} else {
						s = symbolTable.get(entry.getValue().getFirst().getName());
						s1.addFirst(entry.getValue().getFirst());
					}
				}
				program.setSc(s1);
			}
		}
		return program;
	}

	/** Analyze a string literal. */
	@Override
	public Tree visit(final StringLiteral stringLiteral) {
		// always has String type
		stringLiteral.setType(StringType.getInstance());

		// return the node so that it can be re-assigned by its parent
		return stringLiteral;
	}

	/** Analyze a While Statement. */
	@Override
	public Tree visit(final WhileStatement statement) {
		counter++;
		for (Map.Entry<String, Deque<VarStatement>> entry : symbolTable.entrySet()) {
			Deque<VarStatement> listWhile = entry.getValue();
			if (listWhile != null) {
				VarStatement v1 = listWhile.peekFirst();
				if (v1 != null) {
					if (v1.getType() == null) {
						v1.setType(UnknownType.getInstance());
					}
				}
			}
		}
		visitNode(statement.getExp());
		visitNode(statement.getS());
		counter--;
		return statement;
	}

	/** Analyze a Block Statement. */
	@Override
	public Tree visit(final BlockStatement blockStatement) {

		if (flag) {
			visitEach(blockStatement.getList());
		} else {
			List<Statement> vars = new LinkedList<Statement>();

			List<Statement> li = new LinkedList<Statement>();

			for (Statement s : blockStatement.getList()) {
				if (!(s instanceof VarStatement)) {
					li.add(s);
				} else {
					vars.add(s);
				}
			}

			visitEach(vars);
			for (Map.Entry<String, Deque<VarStatement>> entry : symbolTable.entrySet()) {
				Deque<VarStatement> listWhile = entry.getValue();
				if (listWhile != null) {
					VarStatement v1 = listWhile.peekFirst();
					if (v1 != null) {
						if (v1.getType() == null) {
							v1.setType(UnknownType.getInstance());
						}
					}
				}
			}
			visitEach(li);

		}
		return null;
	}

	/** Analyze a If Statement. */
	@Override
	public Tree visit(final IfStatement statement) {
		visitNode(statement.getExp());
		visitNode(statement.getS1());
		if (statement.getS2() != null) {
			visitNode(statement.getS2());
		}
		for (Map.Entry<String, Deque<VarStatement>> entry : symbolTable.entrySet()) {
			Deque<VarStatement> listIf = entry.getValue();
			if (listIf != null) {
				VarStatement v1 = listIf.peekFirst();
				if (v1 != null) {
					if (v1.getType() == null) {
						v1.setType(UnknownType.getInstance());
					}
				}
			}
		}
		return statement;
	}

	/** Analyze a Try Statement. */
	@Override
	public Tree visit(final TryStatement statement) {
		for (Map.Entry<String, Deque<VarStatement>> entry : symbolTable.entrySet()) {
			Deque<VarStatement> listIf = entry.getValue();
			if (listIf != null) {
				VarStatement v1 = listIf.peekFirst();
				if (v1 != null) {
					if (v1.getType() == null) {
						v1.setType(UnknownType.getInstance());
					}
				}
			}
		}

		if (statement.getC() == null) {
			visitNode(statement.getB());
			visitNode(statement.getF());
		}
		if (statement.getF() == null) {
			visitNode(statement.getB());
			visitNode(statement.getC());
		}
		if (statement.getC() != null && statement.getF() != null) {
			visitNode(statement.getB());

			visitNode(statement.getF());
			visitNode(statement.getC());
		}

		return statement;
	}

	/** Analyze a Finally Statement. */
	@Override
	public Tree visit(final FinallyStatement statement) {

		visitNode(statement.getS());

		for (Map.Entry<String, Deque<VarStatement>> entry : symbolTable.entrySet()) {
			Deque<VarStatement> listIf = entry.getValue();
			if (listIf != null) {
				VarStatement v1 = listIf.peekFirst();
				if (v1 != null) {
					if (v1.getType() == null) {
						v1.setType(UnknownType.getInstance());
					}
				}
			}
		}
		return statement;
	}

	/** Analyze a Throw Statement. */
	@Override
	public Tree visit(final ThrowStatement statement) {

		visitNode(statement.getE());

		for (Map.Entry<String, Deque<VarStatement>> entry : symbolTable.entrySet()) {
			Deque<VarStatement> listIf = entry.getValue();
			if (listIf != null) {
				VarStatement v1 = listIf.peekFirst();
				if (v1 != null) {
					if (v1.getType() == null) {
						v1.setType(UnknownType.getInstance());
					}
				}
			}
		}
		return statement;
	}

	/** Analyze a Catch Statement. */
	@Override
	public Tree visit(final CatchStatement statement) {
		if (pass == 2) {
			return null;
		}

		Location loc = new Location("", 0, 0);
		Deque<VarStatement> catchSt = symbolTable.get(statement.getName());
		if (catchSt == null) {
			VarStatement var12 = (VarStatement) TreeBuilder.buildVarStatement(loc, statement.getName());
			catchSt = new LinkedList<VarStatement>();
			symbolTable.put(var12.getName(), catchSt);
			catchSt.addFirst(var12);
			var12.setTempName("catch_e_0");
			var12.setType(UnknownType.getInstance());
		} else {
			VarStatement var12 = (VarStatement) TreeBuilder.buildVarStatement(loc, statement.getName());
			catchSt.addFirst(var12);
			var12.setTempName("catch_e_0");
			var12.setType(UnknownType.getInstance());
		}

		visitNode(statement.getB());

		for (Map.Entry<String, Deque<VarStatement>> entry : symbolTable.entrySet()) {
			Deque<VarStatement> listIf = entry.getValue();
			if (listIf != null) {
				VarStatement v1 = listIf.peekFirst();
				if (v1 != null) {
					if (v1.getType() == null) {
						v1.setType(UnknownType.getInstance());
					}
				}
			}
		}

		catchSt.pop();

		return statement;
	}

	/** Analyze a var statement. */
	@Override
	public Tree visit(final VarStatement varStatement) {
		// there is nothing to do if this is pass 2
		if (pass == 2) {
			return null;
		}

		//
		// the following code is only executed on pass 1
		//

		// record the current function depth
		varStatement.setFunctionDepth(functionDepth);

		// generate a temp name to use at codegen time
		varStatement.setTempName("var_" + varStatement.getName() + "_" + functionDepth);

		// is there a stack for this name already in the symbol table?
		Deque<VarStatement> stack;

		if (functionDepth > 0) {
			stack = symbolTable.get(varStatement.getTempName());
		} else {
			stack = symbolTable.get(varStatement.getName());
		}
		if (stack == null) {
			// need to create the stack and insert it into the map
			stack = new LinkedList<VarStatement>();
			if (functionDepth > 0) {
				symbolTable.put(varStatement.getTempName(), stack);
			} else {
				symbolTable.put(varStatement.getName(), stack);
			}
		}

		// is there a declaration for this variable at the same function depth?
		// if so, then mark this declaration as redundant.
		VarStatement top = stack.peekFirst();
		if ((top != null) && (top.getFunctionDepth() == functionDepth)) {
			varStatement.setIsRedundant();
		}
		// else push the current VarStatment onto the stack
		else {
			stack.addFirst(varStatement);
		}

		return null;
	}

	/** Analyze a Function Expression. */
	@Override
	public Tree visit(final FunctionExpression funcexp) {
		functionDepth++;
		
		if(funcexp.getFormalList() != null)
		{
			for(Expression x: funcexp.getFormalList()) {
				Identifier id = (Identifier)x;
				ts.Location l = new ts.Location("", 0, 0);
				Deque<VarStatement> stack = new LinkedList<VarStatement>();
				VarStatement formalArg = (VarStatement)TreeBuilder.buildVarStatement(l, id.getName());
				formalArg.setTempName("var_"+id.getName()+"_"+functionDepth);
				formalArg.setFunctionDepth(functionDepth);
				formalArg.setType(UnknownType.getInstance());
				stack.addFirst(formalArg);
				
				symbolTable.put(formalArg.getTempName(), stack);
			}
		}
		
		flag = true;
		
		visitNode(funcexp.getB1());
		funcexp.setType(UnknownType.getInstance());

		List<String> clearSymbolTable = new LinkedList<String>();

		for (Map.Entry<String, Deque<VarStatement>> entry : symbolTable.entrySet()) {
			// Deque<VarStatement> listIf = entry.getValue();
			if (entry.getValue().getFirst().getFunctionDepth() == functionDepth) {
				clearSymbolTable.add(entry.getKey());

			}
		}

		for (String key : clearSymbolTable) {
			symbolTable.remove(key);
		}

		functionDepth--;
		return funcexp;
	}

	/** Analyze a Call Expression. */
	@Override
	public Tree visit(final CallExpression callExp) {
		visitNode(callExp.getE1());
		if(callExp.getArgs1() != null)
		{
			visitEach(callExp.getArgs1());
		}
		callExp.setType(UnknownType.getInstance());
		return callExp;
	}

	@Override
	public Tree visit(final PropAccessor propertyAccessor) {
		if (propertyAccessor.getExp() != null) {
			visitNode(propertyAccessor.getKey());
			visitNode(propertyAccessor.getExp());
		} else {
			visitNode(propertyAccessor.getKey());
		}
		propertyAccessor.setType(UnknownType.getInstance());
		return propertyAccessor;
	}

	@Override
	public Tree visit(final ObjLiteral objliteral) {
		if (objliteral.getValue() != null) {
			visitEach(objliteral.getValue());
		}
		objliteral.setType(UnknownType.getInstance());

		return objliteral;
	}

	@Override
	public Tree visit(final propAssignment propAssign) {
		visitNode(propAssign.getValue());
		propAssign.setType(UnknownType.getInstance());
		return propAssign;
	}

	@Override
	public Tree visit(final NewExpression newExpression) {
		visitNode(newExpression.getKey());
		newExpression.setType(UnknownType.getInstance());
		return newExpression;
	}

	@Override
	public Tree visit(final This expression) {
		expression.setType(UnknownType.getInstance());
		return expression;
	}

}
