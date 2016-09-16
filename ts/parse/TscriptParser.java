// Generated from Tscript.g4 by ANTLR 4.5.1
package ts.parse;

  import ts.Location;
  import ts.tree.*;
  import static ts.parse.TreeBuilder.*;
  import java.util.List;
  import java.util.ArrayList;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TscriptParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, STRING_LITERAL=6, BOOLEAN_LITERAL=7, 
		NULL_LITERAL=8, NUMERIC_LITERAL=9, LPAREN=10, RPAREN=11, SEMICOLON=12, 
		EQUAL=13, PLUS=14, ASTERISK=15, MINUS=16, NOT=17, LESSTHAN=18, SLASH=19, 
		GREATERTHAN=20, EQUALTO=21, LBRACE=22, RBRACE=23, PRINT=24, VAR=25, TRUE=26, 
		FALSE=27, NULL=28, WHILE=29, CONTINUE=30, BREAK=31, IF=32, ELSE=33, THROW=34, 
		FINALLY=35, TRY=36, CATCH=37, NEW=38, FUNCTION=39, RETURN=40, THIS=41, 
		IDENTIFIER=42, WhiteSpace=43;
	public static final int
		RULE_program = 0, RULE_statementList = 1, RULE_statement = 2, RULE_emptyStatement = 3, 
		RULE_ifStatement = 4, RULE_breakStatement = 5, RULE_continueStatement = 6, 
		RULE_varStatement = 7, RULE_whileStatement = 8, RULE_blockStatement = 9, 
		RULE_returnStatement = 10, RULE_expressionStatement = 11, RULE_printStatement = 12, 
		RULE_expression = 13, RULE_assignmentExpression = 14, RULE_functionExpression = 15, 
		RULE_memberExpression = 16, RULE_callExpression = 17, RULE_arguments = 18, 
		RULE_argumentList = 19, RULE_formalParameterList = 20, RULE_equalityExpression = 21, 
		RULE_leftHandSideExpression = 22, RULE_newExpression = 23, RULE_relationalExpression = 24, 
		RULE_additiveExpression = 25, RULE_multiplicativeExpression = 26, RULE_unaryExpression = 27, 
		RULE_tryStatement = 28, RULE_objLiteral = 29, RULE_propertyNameAndValueList = 30, 
		RULE_propertyAssignment = 31, RULE_propertyName = 32, RULE_catchStatement = 33, 
		RULE_finallyStatement = 34, RULE_throwStatement = 35, RULE_primaryExpression = 36;
	public static final String[] ruleNames = {
		"program", "statementList", "statement", "emptyStatement", "ifStatement", 
		"breakStatement", "continueStatement", "varStatement", "whileStatement", 
		"blockStatement", "returnStatement", "expressionStatement", "printStatement", 
		"expression", "assignmentExpression", "functionExpression", "memberExpression", 
		"callExpression", "arguments", "argumentList", "formalParameterList", 
		"equalityExpression", "leftHandSideExpression", "newExpression", "relationalExpression", 
		"additiveExpression", "multiplicativeExpression", "unaryExpression", "tryStatement", 
		"objLiteral", "propertyNameAndValueList", "propertyAssignment", "propertyName", 
		"catchStatement", "finallyStatement", "throwStatement", "primaryExpression"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'['", "']'", "'.'", "','", "':'", null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, "'console.log'", "'var'", "'true'", "'false'", "'null'", "'while'", 
		"'continue'", "'break'", "'if'", "'else'", "'throw'", "'finally'", "'try'", 
		"'catch'", "'new'", "'function'", "'return'", "'this'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, "STRING_LITERAL", "BOOLEAN_LITERAL", 
		"NULL_LITERAL", "NUMERIC_LITERAL", "LPAREN", "RPAREN", "SEMICOLON", "EQUAL", 
		"PLUS", "ASTERISK", "MINUS", "NOT", "LESSTHAN", "SLASH", "GREATERTHAN", 
		"EQUALTO", "LBRACE", "RBRACE", "PRINT", "VAR", "TRUE", "FALSE", "NULL", 
		"WHILE", "CONTINUE", "BREAK", "IF", "ELSE", "THROW", "FINALLY", "TRY", 
		"CATCH", "NEW", "FUNCTION", "RETURN", "THIS", "IDENTIFIER", "WhiteSpace"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Tscript.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	  // grab location info (filename/line/column) from token
	  // in order to stick into AST nodes for later error reporting
	  public Location loc(final Token token)
	  {
	    return new Location(getSourceName(), token.getLine(),
	      token.getCharPositionInLine());
	  }

	  // root of AST is stored here
	  // set by the action for the start symbol
	  private Program semanticValue;
	  public Program getSemanticValue()
	  {
	    return semanticValue;
	  }

	public TscriptParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public StatementListContext sl;
		public TerminalNode EOF() { return getToken(TscriptParser.EOF, 0); }
		public StatementListContext statementList() {
			return getRuleContext(StatementListContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			((ProgramContext)_localctx).sl = statementList(0);
			setState(75);
			match(EOF);
			 semanticValue = buildProgram(loc(_localctx.start), ((ProgramContext)_localctx).sl.lval); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementListContext extends ParserRuleContext {
		public List<Statement> lval;
		public StatementListContext sl;
		public StatementContext s;
		public StatementListContext statementList() {
			return getRuleContext(StatementListContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public StatementListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementList; }
	}

	public final StatementListContext statementList() throws RecognitionException {
		return statementList(0);
	}

	private StatementListContext statementList(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		StatementListContext _localctx = new StatementListContext(_ctx, _parentState);
		StatementListContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_statementList, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			 ((StatementListContext)_localctx).lval =  new ArrayList<Statement>(); 
			}
			_ctx.stop = _input.LT(-1);
			setState(87);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new StatementListContext(_parentctx, _parentState);
					_localctx.sl = _prevctx;
					_localctx.sl = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_statementList);
					setState(81);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(82);
					((StatementListContext)_localctx).s = statement();
					 ((StatementListContext)_localctx).sl.lval.add(((StatementListContext)_localctx).s.lval);
					                ((StatementListContext)_localctx).lval =  ((StatementListContext)_localctx).sl.lval; 
					}
					} 
				}
				setState(89);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public Statement lval;
		public VarStatementContext v;
		public ExpressionStatementContext e;
		public PrintStatementContext p;
		public EmptyStatementContext es;
		public BlockStatementContext bs;
		public WhileStatementContext ws;
		public BreakStatementContext b;
		public ContinueStatementContext c;
		public IfStatementContext i;
		public ThrowStatementContext th;
		public TryStatementContext tr;
		public ReturnStatementContext re;
		public VarStatementContext varStatement() {
			return getRuleContext(VarStatementContext.class,0);
		}
		public ExpressionStatementContext expressionStatement() {
			return getRuleContext(ExpressionStatementContext.class,0);
		}
		public PrintStatementContext printStatement() {
			return getRuleContext(PrintStatementContext.class,0);
		}
		public EmptyStatementContext emptyStatement() {
			return getRuleContext(EmptyStatementContext.class,0);
		}
		public BlockStatementContext blockStatement() {
			return getRuleContext(BlockStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public BreakStatementContext breakStatement() {
			return getRuleContext(BreakStatementContext.class,0);
		}
		public ContinueStatementContext continueStatement() {
			return getRuleContext(ContinueStatementContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public ThrowStatementContext throwStatement() {
			return getRuleContext(ThrowStatementContext.class,0);
		}
		public TryStatementContext tryStatement() {
			return getRuleContext(TryStatementContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			setState(126);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(90);
				((StatementContext)_localctx).v = varStatement();
				 ((StatementContext)_localctx).lval =  ((StatementContext)_localctx).v.lval; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(93);
				((StatementContext)_localctx).e = expressionStatement();
				 ((StatementContext)_localctx).lval =  ((StatementContext)_localctx).e.lval; 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(96);
				((StatementContext)_localctx).p = printStatement();
				 ((StatementContext)_localctx).lval =  ((StatementContext)_localctx).p.lval; 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(99);
				((StatementContext)_localctx).es = emptyStatement();
				 ((StatementContext)_localctx).lval =  ((StatementContext)_localctx).es.lval; 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(102);
				((StatementContext)_localctx).bs = blockStatement();
				 ((StatementContext)_localctx).lval =  ((StatementContext)_localctx).bs.lval; 
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(105);
				((StatementContext)_localctx).ws = whileStatement();
				 ((StatementContext)_localctx).lval =  ((StatementContext)_localctx).ws.lval; 
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(108);
				((StatementContext)_localctx).b = breakStatement();
				 ((StatementContext)_localctx).lval =  ((StatementContext)_localctx).b.lval; 
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(111);
				((StatementContext)_localctx).c = continueStatement();
				 ((StatementContext)_localctx).lval =  ((StatementContext)_localctx).c.lval; 
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(114);
				((StatementContext)_localctx).i = ifStatement();
				 ((StatementContext)_localctx).lval =  ((StatementContext)_localctx).i.lval; 
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(117);
				((StatementContext)_localctx).th = throwStatement();
				 ((StatementContext)_localctx).lval =  ((StatementContext)_localctx).th.lval; 
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(120);
				((StatementContext)_localctx).tr = tryStatement();
				 ((StatementContext)_localctx).lval =  ((StatementContext)_localctx).tr.lval; 
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(123);
				((StatementContext)_localctx).re = returnStatement();
				 ((StatementContext)_localctx).lval =  ((StatementContext)_localctx).re.lval;
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EmptyStatementContext extends ParserRuleContext {
		public Statement lval;
		public TerminalNode SEMICOLON() { return getToken(TscriptParser.SEMICOLON, 0); }
		public EmptyStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_emptyStatement; }
	}

	public final EmptyStatementContext emptyStatement() throws RecognitionException {
		EmptyStatementContext _localctx = new EmptyStatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_emptyStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			match(SEMICOLON);
			 ((EmptyStatementContext)_localctx).lval =  buildEmptyStatement(loc(_localctx.start)); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfStatementContext extends ParserRuleContext {
		public Statement lval;
		public ExpressionContext e;
		public StatementContext s;
		public StatementContext s1;
		public TerminalNode IF() { return getToken(TscriptParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(TscriptParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(TscriptParser.RPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(TscriptParser.ELSE, 0); }
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_ifStatement);
		try {
			setState(147);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(131);
				match(IF);
				setState(132);
				match(LPAREN);
				setState(133);
				((IfStatementContext)_localctx).e = expression();
				setState(134);
				match(RPAREN);
				setState(135);
				((IfStatementContext)_localctx).s = statement();
				 ((IfStatementContext)_localctx).lval =  buildIfStatement(loc(_localctx.start),((IfStatementContext)_localctx).e.lval,((IfStatementContext)_localctx).s.lval,null) ;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(138);
				match(IF);
				setState(139);
				match(LPAREN);
				setState(140);
				((IfStatementContext)_localctx).e = expression();
				setState(141);
				match(RPAREN);
				setState(142);
				((IfStatementContext)_localctx).s = statement();
				setState(143);
				match(ELSE);
				setState(144);
				((IfStatementContext)_localctx).s1 = statement();
				 ((IfStatementContext)_localctx).lval =  buildIfStatement(loc(_localctx.start),((IfStatementContext)_localctx).e.lval,((IfStatementContext)_localctx).s.lval,((IfStatementContext)_localctx).s1.lval); 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BreakStatementContext extends ParserRuleContext {
		public Statement lval;
		public TerminalNode BREAK() { return getToken(TscriptParser.BREAK, 0); }
		public TerminalNode SEMICOLON() { return getToken(TscriptParser.SEMICOLON, 0); }
		public BreakStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakStatement; }
	}

	public final BreakStatementContext breakStatement() throws RecognitionException {
		BreakStatementContext _localctx = new BreakStatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_breakStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			match(BREAK);
			setState(150);
			match(SEMICOLON);
			 ((BreakStatementContext)_localctx).lval =  buildBreakStatement(loc(_localctx.start),null); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ContinueStatementContext extends ParserRuleContext {
		public Statement lval;
		public TerminalNode CONTINUE() { return getToken(TscriptParser.CONTINUE, 0); }
		public TerminalNode SEMICOLON() { return getToken(TscriptParser.SEMICOLON, 0); }
		public ContinueStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continueStatement; }
	}

	public final ContinueStatementContext continueStatement() throws RecognitionException {
		ContinueStatementContext _localctx = new ContinueStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_continueStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			match(CONTINUE);
			setState(154);
			match(SEMICOLON);
			 ((ContinueStatementContext)_localctx).lval =  buildContinueStatement(loc(_localctx.start),null); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarStatementContext extends ParserRuleContext {
		public Statement lval;
		public Token IDENTIFIER;
		public TerminalNode VAR() { return getToken(TscriptParser.VAR, 0); }
		public TerminalNode IDENTIFIER() { return getToken(TscriptParser.IDENTIFIER, 0); }
		public TerminalNode SEMICOLON() { return getToken(TscriptParser.SEMICOLON, 0); }
		public VarStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varStatement; }
	}

	public final VarStatementContext varStatement() throws RecognitionException {
		VarStatementContext _localctx = new VarStatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_varStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			match(VAR);
			setState(158);
			((VarStatementContext)_localctx).IDENTIFIER = match(IDENTIFIER);
			setState(159);
			match(SEMICOLON);
			 ((VarStatementContext)_localctx).lval =  buildVarStatement(loc(_localctx.start), (((VarStatementContext)_localctx).IDENTIFIER!=null?((VarStatementContext)_localctx).IDENTIFIER.getText():null)); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileStatementContext extends ParserRuleContext {
		public Statement lval;
		public ExpressionContext e;
		public StatementContext s;
		public TerminalNode WHILE() { return getToken(TscriptParser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(TscriptParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(TscriptParser.RPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			match(WHILE);
			setState(163);
			match(LPAREN);
			setState(164);
			((WhileStatementContext)_localctx).e = expression();
			setState(165);
			match(RPAREN);
			setState(166);
			((WhileStatementContext)_localctx).s = statement();
			 ((WhileStatementContext)_localctx).lval =  buildWhileStatement(loc(_localctx.start),((WhileStatementContext)_localctx).e.lval,((WhileStatementContext)_localctx).s.lval);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockStatementContext extends ParserRuleContext {
		public Statement lval;
		public StatementListContext s;
		public TerminalNode LBRACE() { return getToken(TscriptParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(TscriptParser.RBRACE, 0); }
		public StatementListContext statementList() {
			return getRuleContext(StatementListContext.class,0);
		}
		public BlockStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStatement; }
	}

	public final BlockStatementContext blockStatement() throws RecognitionException {
		BlockStatementContext _localctx = new BlockStatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_blockStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			match(LBRACE);
			setState(170);
			((BlockStatementContext)_localctx).s = statementList(0);
			setState(171);
			match(RBRACE);
			 ((BlockStatementContext)_localctx).lval =  buildBlockStatement(loc(_localctx.start), ((BlockStatementContext)_localctx).s.lval);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnStatementContext extends ParserRuleContext {
		public Statement lval;
		public ExpressionContext e;
		public TerminalNode RETURN() { return getToken(TscriptParser.RETURN, 0); }
		public TerminalNode SEMICOLON() { return getToken(TscriptParser.SEMICOLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_returnStatement);
		try {
			setState(182);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(174);
				match(RETURN);
				setState(175);
				((ReturnStatementContext)_localctx).e = expression();
				setState(176);
				match(SEMICOLON);
				 ((ReturnStatementContext)_localctx).lval =  buildReturnStatement(loc(_localctx.start),((ReturnStatementContext)_localctx).e.lval); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(179);
				match(RETURN);
				setState(180);
				match(SEMICOLON);
				 ((ReturnStatementContext)_localctx).lval =  buildReturnStatement(loc(_localctx.start),null);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionStatementContext extends ParserRuleContext {
		public Statement lval;
		public ExpressionContext e;
		public TerminalNode SEMICOLON() { return getToken(TscriptParser.SEMICOLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionStatement; }
	}

	public final ExpressionStatementContext expressionStatement() throws RecognitionException {
		ExpressionStatementContext _localctx = new ExpressionStatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_expressionStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			((ExpressionStatementContext)_localctx).e = expression();
			setState(185);
			match(SEMICOLON);
			 ((ExpressionStatementContext)_localctx).lval =  buildExpressionStatement(loc(_localctx.start), ((ExpressionStatementContext)_localctx).e.lval); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrintStatementContext extends ParserRuleContext {
		public Statement lval;
		public ExpressionContext e;
		public TerminalNode PRINT() { return getToken(TscriptParser.PRINT, 0); }
		public TerminalNode LPAREN() { return getToken(TscriptParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(TscriptParser.RPAREN, 0); }
		public TerminalNode SEMICOLON() { return getToken(TscriptParser.SEMICOLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrintStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printStatement; }
	}

	public final PrintStatementContext printStatement() throws RecognitionException {
		PrintStatementContext _localctx = new PrintStatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_printStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			match(PRINT);
			setState(189);
			match(LPAREN);
			setState(190);
			((PrintStatementContext)_localctx).e = expression();
			setState(191);
			match(RPAREN);
			setState(192);
			match(SEMICOLON);
			 ((PrintStatementContext)_localctx).lval =  buildPrintStatement(loc(_localctx.start), ((PrintStatementContext)_localctx).e.lval); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public Expression lval;
		public AssignmentExpressionContext a;
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			((ExpressionContext)_localctx).a = assignmentExpression();
			 ((ExpressionContext)_localctx).lval =  ((ExpressionContext)_localctx).a.lval; 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AssignmentExpressionContext extends ParserRuleContext {
		public Expression lval;
		public EqualityExpressionContext a;
		public FunctionExpressionContext f;
		public MemberExpressionContext m;
		public CallExpressionContext c;
		public LeftHandSideExpressionContext l;
		public AssignmentExpressionContext r;
		public EqualityExpressionContext equalityExpression() {
			return getRuleContext(EqualityExpressionContext.class,0);
		}
		public FunctionExpressionContext functionExpression() {
			return getRuleContext(FunctionExpressionContext.class,0);
		}
		public MemberExpressionContext memberExpression() {
			return getRuleContext(MemberExpressionContext.class,0);
		}
		public CallExpressionContext callExpression() {
			return getRuleContext(CallExpressionContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(TscriptParser.EQUAL, 0); }
		public LeftHandSideExpressionContext leftHandSideExpression() {
			return getRuleContext(LeftHandSideExpressionContext.class,0);
		}
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public AssignmentExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentExpression; }
	}

	public final AssignmentExpressionContext assignmentExpression() throws RecognitionException {
		AssignmentExpressionContext _localctx = new AssignmentExpressionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_assignmentExpression);
		try {
			setState(215);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(198);
				((AssignmentExpressionContext)_localctx).a = equalityExpression(0);
				 ((AssignmentExpressionContext)_localctx).lval =  ((AssignmentExpressionContext)_localctx).a.lval; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(201);
				((AssignmentExpressionContext)_localctx).f = functionExpression();
				 ((AssignmentExpressionContext)_localctx).lval =  ((AssignmentExpressionContext)_localctx).f.lval; 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(204);
				((AssignmentExpressionContext)_localctx).m = memberExpression(0);
				 ((AssignmentExpressionContext)_localctx).lval =  ((AssignmentExpressionContext)_localctx).m.lval; 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(207);
				((AssignmentExpressionContext)_localctx).c = callExpression(0);
				 ((AssignmentExpressionContext)_localctx).lval =  ((AssignmentExpressionContext)_localctx).c.lval; 
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(210);
				((AssignmentExpressionContext)_localctx).l = leftHandSideExpression();
				setState(211);
				match(EQUAL);
				setState(212);
				((AssignmentExpressionContext)_localctx).r = assignmentExpression();
				 checkAssignmentDestination(loc(_localctx.start), ((AssignmentExpressionContext)_localctx).l.lval);
				      ((AssignmentExpressionContext)_localctx).lval =  buildBinaryOperator(loc(_localctx.start), Binop.ASSIGN,
				        ((AssignmentExpressionContext)_localctx).l.lval, ((AssignmentExpressionContext)_localctx).r.lval); 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionExpressionContext extends ParserRuleContext {
		public Expression lval;
		public BlockStatementContext b;
		public FormalParameterListContext f;
		public Token IDENTIFIER;
		public FormalParameterListContext f1;
		public TerminalNode FUNCTION() { return getToken(TscriptParser.FUNCTION, 0); }
		public TerminalNode LPAREN() { return getToken(TscriptParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(TscriptParser.RPAREN, 0); }
		public BlockStatementContext blockStatement() {
			return getRuleContext(BlockStatementContext.class,0);
		}
		public FormalParameterListContext formalParameterList() {
			return getRuleContext(FormalParameterListContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(TscriptParser.IDENTIFIER, 0); }
		public FunctionExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionExpression; }
	}

	public final FunctionExpressionContext functionExpression() throws RecognitionException {
		FunctionExpressionContext _localctx = new FunctionExpressionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_functionExpression);
		try {
			setState(245);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(217);
				match(FUNCTION);
				setState(218);
				match(LPAREN);
				setState(219);
				match(RPAREN);
				setState(220);
				((FunctionExpressionContext)_localctx).b = blockStatement();
				 ((FunctionExpressionContext)_localctx).lval =  buildFunctionExpression(loc(_localctx.start),null,null,((FunctionExpressionContext)_localctx).b.lval); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(223);
				match(FUNCTION);
				setState(224);
				match(LPAREN);
				setState(225);
				((FunctionExpressionContext)_localctx).f = formalParameterList(0);
				setState(226);
				match(RPAREN);
				setState(227);
				((FunctionExpressionContext)_localctx).b = blockStatement();
				 ((FunctionExpressionContext)_localctx).lval =  buildFunctionExpression(loc(_localctx.start),null,((FunctionExpressionContext)_localctx).f.lval,((FunctionExpressionContext)_localctx).b.lval); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(230);
				match(FUNCTION);
				setState(231);
				((FunctionExpressionContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				setState(232);
				match(LPAREN);
				setState(233);
				match(RPAREN);
				setState(234);
				((FunctionExpressionContext)_localctx).b = blockStatement();
				 ((FunctionExpressionContext)_localctx).lval =  buildFunctionExpression(loc(_localctx.start),(((FunctionExpressionContext)_localctx).IDENTIFIER!=null?((FunctionExpressionContext)_localctx).IDENTIFIER.getText():null),null,((FunctionExpressionContext)_localctx).b.lval);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(237);
				match(FUNCTION);
				setState(238);
				((FunctionExpressionContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				setState(239);
				match(LPAREN);
				setState(240);
				((FunctionExpressionContext)_localctx).f1 = formalParameterList(0);
				setState(241);
				match(RPAREN);
				setState(242);
				((FunctionExpressionContext)_localctx).b = blockStatement();
				 ((FunctionExpressionContext)_localctx).lval =  buildFunctionExpression(loc(_localctx.start),(((FunctionExpressionContext)_localctx).IDENTIFIER!=null?((FunctionExpressionContext)_localctx).IDENTIFIER.getText():null),((FunctionExpressionContext)_localctx).f1.lval,((FunctionExpressionContext)_localctx).b.lval);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MemberExpressionContext extends ParserRuleContext {
		public Expression lval;
		public MemberExpressionContext me;
		public MemberExpressionContext m;
		public PrimaryExpressionContext p;
		public FunctionExpressionContext f;
		public ExpressionContext e;
		public Token IDENTIFIER;
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public FunctionExpressionContext functionExpression() {
			return getRuleContext(FunctionExpressionContext.class,0);
		}
		public TerminalNode NEW() { return getToken(TscriptParser.NEW, 0); }
		public TerminalNode LPAREN() { return getToken(TscriptParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(TscriptParser.RPAREN, 0); }
		public MemberExpressionContext memberExpression() {
			return getRuleContext(MemberExpressionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(TscriptParser.IDENTIFIER, 0); }
		public MemberExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memberExpression; }
	}

	public final MemberExpressionContext memberExpression() throws RecognitionException {
		return memberExpression(0);
	}

	private MemberExpressionContext memberExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MemberExpressionContext _localctx = new MemberExpressionContext(_ctx, _parentState);
		MemberExpressionContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_memberExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			switch (_input.LA(1)) {
			case STRING_LITERAL:
			case BOOLEAN_LITERAL:
			case NULL_LITERAL:
			case NUMERIC_LITERAL:
			case LPAREN:
			case LBRACE:
			case THIS:
			case IDENTIFIER:
				{
				setState(248);
				((MemberExpressionContext)_localctx).p = primaryExpression();
				 ((MemberExpressionContext)_localctx).lval =  ((MemberExpressionContext)_localctx).p.lval; 
				}
				break;
			case FUNCTION:
				{
				setState(251);
				((MemberExpressionContext)_localctx).f = functionExpression();
				 ((MemberExpressionContext)_localctx).lval =  ((MemberExpressionContext)_localctx).f.lval;
				}
				break;
			case NEW:
				{
				setState(254);
				match(NEW);
				setState(255);
				((MemberExpressionContext)_localctx).m = memberExpression(0);
				setState(256);
				match(LPAREN);
				setState(257);
				match(RPAREN);
				 ((MemberExpressionContext)_localctx).lval =  buildNewExpression(loc(_localctx.start),((MemberExpressionContext)_localctx).m.lval); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(274);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(272);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new MemberExpressionContext(_parentctx, _parentState);
						_localctx.me = _prevctx;
						_localctx.me = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_memberExpression);
						setState(262);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(263);
						match(T__0);
						setState(264);
						((MemberExpressionContext)_localctx).e = expression();
						setState(265);
						match(T__1);
						 ((MemberExpressionContext)_localctx).lval =  buildpropAccessor(loc(_localctx.start),((MemberExpressionContext)_localctx).me.lval,((MemberExpressionContext)_localctx).e.lval,null); 
						}
						break;
					case 2:
						{
						_localctx = new MemberExpressionContext(_parentctx, _parentState);
						_localctx.m = _prevctx;
						_localctx.m = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_memberExpression);
						setState(268);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(269);
						match(T__2);
						setState(270);
						((MemberExpressionContext)_localctx).IDENTIFIER = match(IDENTIFIER);
						 ((MemberExpressionContext)_localctx).lval =  buildpropAccessor(loc(_localctx.start),((MemberExpressionContext)_localctx).m.lval,null,(((MemberExpressionContext)_localctx).IDENTIFIER!=null?((MemberExpressionContext)_localctx).IDENTIFIER.getText():null)); 
						}
						break;
					}
					} 
				}
				setState(276);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class CallExpressionContext extends ParserRuleContext {
		public Expression lval;
		public CallExpressionContext c1;
		public CallExpressionContext ce;
		public CallExpressionContext c;
		public MemberExpressionContext m;
		public ArgumentsContext a;
		public ArgumentsContext a1;
		public ExpressionContext e;
		public Token IDENTIFIER;
		public MemberExpressionContext memberExpression() {
			return getRuleContext(MemberExpressionContext.class,0);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public CallExpressionContext callExpression() {
			return getRuleContext(CallExpressionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(TscriptParser.IDENTIFIER, 0); }
		public CallExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callExpression; }
	}

	public final CallExpressionContext callExpression() throws RecognitionException {
		return callExpression(0);
	}

	private CallExpressionContext callExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		CallExpressionContext _localctx = new CallExpressionContext(_ctx, _parentState);
		CallExpressionContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_callExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(278);
			((CallExpressionContext)_localctx).m = memberExpression(0);
			setState(279);
			((CallExpressionContext)_localctx).a = arguments();
			 ((CallExpressionContext)_localctx).lval =  buildCallExpression(loc(_localctx.start),((CallExpressionContext)_localctx).m.lval,((CallExpressionContext)_localctx).a.lval);
			}
			_ctx.stop = _input.LT(-1);
			setState(298);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(296);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new CallExpressionContext(_parentctx, _parentState);
						_localctx.c1 = _prevctx;
						_localctx.c1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_callExpression);
						setState(282);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(283);
						((CallExpressionContext)_localctx).a1 = arguments();
						 ((CallExpressionContext)_localctx).lval =  buildCallExpression(loc(_localctx.start),((CallExpressionContext)_localctx).c1.lval,((CallExpressionContext)_localctx).a1.lval); 
						}
						break;
					case 2:
						{
						_localctx = new CallExpressionContext(_parentctx, _parentState);
						_localctx.ce = _prevctx;
						_localctx.ce = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_callExpression);
						setState(286);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(287);
						match(T__0);
						setState(288);
						((CallExpressionContext)_localctx).e = expression();
						setState(289);
						match(T__1);
						 ((CallExpressionContext)_localctx).lval =  buildpropAccessor(loc(_localctx.start),((CallExpressionContext)_localctx).ce.lval,((CallExpressionContext)_localctx).e.lval,null); 
						}
						break;
					case 3:
						{
						_localctx = new CallExpressionContext(_parentctx, _parentState);
						_localctx.c = _prevctx;
						_localctx.c = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_callExpression);
						setState(292);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(293);
						match(T__2);
						setState(294);
						((CallExpressionContext)_localctx).IDENTIFIER = match(IDENTIFIER);
						 ((CallExpressionContext)_localctx).lval =  buildpropAccessor(loc(_localctx.start),((CallExpressionContext)_localctx).c.lval,null,(((CallExpressionContext)_localctx).IDENTIFIER!=null?((CallExpressionContext)_localctx).IDENTIFIER.getText():null)); 
						}
						break;
					}
					} 
				}
				setState(300);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ArgumentsContext extends ParserRuleContext {
		public List<Expression> lval;
		public ArgumentListContext a;
		public TerminalNode LPAREN() { return getToken(TscriptParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(TscriptParser.RPAREN, 0); }
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_arguments);
		try {
			setState(309);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(301);
				match(LPAREN);
				setState(302);
				match(RPAREN);
				 ((ArgumentsContext)_localctx).lval =  new ArrayList<Expression>(); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(304);
				match(LPAREN);
				setState(305);
				((ArgumentsContext)_localctx).a = argumentList(0);
				setState(306);
				match(RPAREN);
				 ((ArgumentsContext)_localctx).lval =  ((ArgumentsContext)_localctx).a.lval;
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentListContext extends ParserRuleContext {
		public List<Expression> lval;
		public ArgumentListContext pl;
		public AssignmentExpressionContext a;
		public AssignmentExpressionContext p;
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public ArgumentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentList; }
	}

	public final ArgumentListContext argumentList() throws RecognitionException {
		return argumentList(0);
	}

	private ArgumentListContext argumentList(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ArgumentListContext _localctx = new ArgumentListContext(_ctx, _parentState);
		ArgumentListContext _prevctx = _localctx;
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_argumentList, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(312);
			((ArgumentListContext)_localctx).a = assignmentExpression();

					if(_localctx.lval == null){
					((ArgumentListContext)_localctx).lval =  new ArrayList<Expression>();
					}
					_localctx.lval.add(((ArgumentListContext)_localctx).a.lval);
				
			}
			_ctx.stop = _input.LT(-1);
			setState(322);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ArgumentListContext(_parentctx, _parentState);
					_localctx.pl = _prevctx;
					_localctx.pl = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_argumentList);
					setState(315);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(316);
					match(T__3);
					setState(317);
					((ArgumentListContext)_localctx).p = assignmentExpression();
						if(((ArgumentListContext)_localctx).pl.lval == null) {
					          		((ArgumentListContext)_localctx).pl.lval = new ArrayList<Expression>();
					          		}
					          		((ArgumentListContext)_localctx).pl.lval.add(((ArgumentListContext)_localctx).p.lval);
					          		((ArgumentListContext)_localctx).lval =  ((ArgumentListContext)_localctx).pl.lval;
					          	
					}
					} 
				}
				setState(324);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class FormalParameterListContext extends ParserRuleContext {
		public List<Expression> lval;
		public FormalParameterListContext pl;
		public Token IDENTIFIER;
		public TerminalNode IDENTIFIER() { return getToken(TscriptParser.IDENTIFIER, 0); }
		public FormalParameterListContext formalParameterList() {
			return getRuleContext(FormalParameterListContext.class,0);
		}
		public FormalParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameterList; }
	}

	public final FormalParameterListContext formalParameterList() throws RecognitionException {
		return formalParameterList(0);
	}

	private FormalParameterListContext formalParameterList(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		FormalParameterListContext _localctx = new FormalParameterListContext(_ctx, _parentState);
		FormalParameterListContext _prevctx = _localctx;
		int _startState = 40;
		enterRecursionRule(_localctx, 40, RULE_formalParameterList, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(326);
			((FormalParameterListContext)_localctx).IDENTIFIER = match(IDENTIFIER);

					if(_localctx.lval == null){
					((FormalParameterListContext)_localctx).lval =  new ArrayList<Expression>();
					}
					_localctx.lval.add(buildIdentifier(loc(_localctx.start),(((FormalParameterListContext)_localctx).IDENTIFIER!=null?((FormalParameterListContext)_localctx).IDENTIFIER.getText():null)));
				
			}
			_ctx.stop = _input.LT(-1);
			setState(335);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new FormalParameterListContext(_parentctx, _parentState);
					_localctx.pl = _prevctx;
					_localctx.pl = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_formalParameterList);
					setState(329);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(330);
					match(T__3);
					setState(331);
					((FormalParameterListContext)_localctx).IDENTIFIER = match(IDENTIFIER);
						if(((FormalParameterListContext)_localctx).pl.lval == null) {
					          		((FormalParameterListContext)_localctx).pl.lval = new ArrayList<Expression>();
					          		}
					          		((FormalParameterListContext)_localctx).pl.lval.add(buildIdentifier(loc(_localctx.start),(((FormalParameterListContext)_localctx).IDENTIFIER!=null?((FormalParameterListContext)_localctx).IDENTIFIER.getText():null)));
					          		((FormalParameterListContext)_localctx).lval =  ((FormalParameterListContext)_localctx).pl.lval;
					          	
					}
					} 
				}
				setState(337);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class EqualityExpressionContext extends ParserRuleContext {
		public Expression lval;
		public EqualityExpressionContext l;
		public RelationalExpressionContext a;
		public RelationalExpressionContext r;
		public RelationalExpressionContext relationalExpression() {
			return getRuleContext(RelationalExpressionContext.class,0);
		}
		public TerminalNode EQUALTO() { return getToken(TscriptParser.EQUALTO, 0); }
		public EqualityExpressionContext equalityExpression() {
			return getRuleContext(EqualityExpressionContext.class,0);
		}
		public EqualityExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalityExpression; }
	}

	public final EqualityExpressionContext equalityExpression() throws RecognitionException {
		return equalityExpression(0);
	}

	private EqualityExpressionContext equalityExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		EqualityExpressionContext _localctx = new EqualityExpressionContext(_ctx, _parentState);
		EqualityExpressionContext _prevctx = _localctx;
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_equalityExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(339);
			((EqualityExpressionContext)_localctx).a = relationalExpression(0);
			 ((EqualityExpressionContext)_localctx).lval =  ((EqualityExpressionContext)_localctx).a.lval; 
			}
			_ctx.stop = _input.LT(-1);
			setState(349);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new EqualityExpressionContext(_parentctx, _parentState);
					_localctx.l = _prevctx;
					_localctx.l = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_equalityExpression);
					setState(342);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(343);
					match(EQUALTO);
					setState(344);
					((EqualityExpressionContext)_localctx).r = relationalExpression(0);
					((EqualityExpressionContext)_localctx).lval =  buildBinaryOperator(loc(_localctx.start), Binop.EQUAL,
					                  ((EqualityExpressionContext)_localctx).l.lval, ((EqualityExpressionContext)_localctx).r.lval);
					}
					} 
				}
				setState(351);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class LeftHandSideExpressionContext extends ParserRuleContext {
		public Expression lval;
		public PrimaryExpressionContext p;
		public CallExpressionContext c;
		public MemberExpressionContext m;
		public NewExpressionContext n;
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public CallExpressionContext callExpression() {
			return getRuleContext(CallExpressionContext.class,0);
		}
		public MemberExpressionContext memberExpression() {
			return getRuleContext(MemberExpressionContext.class,0);
		}
		public NewExpressionContext newExpression() {
			return getRuleContext(NewExpressionContext.class,0);
		}
		public LeftHandSideExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_leftHandSideExpression; }
	}

	public final LeftHandSideExpressionContext leftHandSideExpression() throws RecognitionException {
		LeftHandSideExpressionContext _localctx = new LeftHandSideExpressionContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_leftHandSideExpression);
		try {
			setState(364);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(352);
				((LeftHandSideExpressionContext)_localctx).p = primaryExpression();
				 ((LeftHandSideExpressionContext)_localctx).lval =  ((LeftHandSideExpressionContext)_localctx).p.lval; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(355);
				((LeftHandSideExpressionContext)_localctx).c = callExpression(0);
				 ((LeftHandSideExpressionContext)_localctx).lval =  ((LeftHandSideExpressionContext)_localctx).c.lval; 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(358);
				((LeftHandSideExpressionContext)_localctx).m = memberExpression(0);
				 ((LeftHandSideExpressionContext)_localctx).lval =  ((LeftHandSideExpressionContext)_localctx).m.lval; 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(361);
				((LeftHandSideExpressionContext)_localctx).n = newExpression();
				 ((LeftHandSideExpressionContext)_localctx).lval =  ((LeftHandSideExpressionContext)_localctx).n.lval; 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NewExpressionContext extends ParserRuleContext {
		public Expression lval;
		public MemberExpressionContext m;
		public NewExpressionContext m1;
		public MemberExpressionContext memberExpression() {
			return getRuleContext(MemberExpressionContext.class,0);
		}
		public TerminalNode NEW() { return getToken(TscriptParser.NEW, 0); }
		public NewExpressionContext newExpression() {
			return getRuleContext(NewExpressionContext.class,0);
		}
		public NewExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newExpression; }
	}

	public final NewExpressionContext newExpression() throws RecognitionException {
		NewExpressionContext _localctx = new NewExpressionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_newExpression);
		try {
			setState(373);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(366);
				((NewExpressionContext)_localctx).m = memberExpression(0);
				 ((NewExpressionContext)_localctx).lval =  ((NewExpressionContext)_localctx).m.lval; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(369);
				match(NEW);
				setState(370);
				((NewExpressionContext)_localctx).m1 = newExpression();
				 ((NewExpressionContext)_localctx).lval =  buildNewExpression(loc(_localctx.start),((NewExpressionContext)_localctx).m1.lval); 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelationalExpressionContext extends ParserRuleContext {
		public Expression lval;
		public RelationalExpressionContext l;
		public AdditiveExpressionContext a;
		public AdditiveExpressionContext r;
		public AdditiveExpressionContext additiveExpression() {
			return getRuleContext(AdditiveExpressionContext.class,0);
		}
		public TerminalNode LESSTHAN() { return getToken(TscriptParser.LESSTHAN, 0); }
		public RelationalExpressionContext relationalExpression() {
			return getRuleContext(RelationalExpressionContext.class,0);
		}
		public TerminalNode GREATERTHAN() { return getToken(TscriptParser.GREATERTHAN, 0); }
		public RelationalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationalExpression; }
	}

	public final RelationalExpressionContext relationalExpression() throws RecognitionException {
		return relationalExpression(0);
	}

	private RelationalExpressionContext relationalExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RelationalExpressionContext _localctx = new RelationalExpressionContext(_ctx, _parentState);
		RelationalExpressionContext _prevctx = _localctx;
		int _startState = 48;
		enterRecursionRule(_localctx, 48, RULE_relationalExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(376);
			((RelationalExpressionContext)_localctx).a = additiveExpression(0);
			 ((RelationalExpressionContext)_localctx).lval =  ((RelationalExpressionContext)_localctx).a.lval;
			}
			_ctx.stop = _input.LT(-1);
			setState(391);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(389);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						_localctx = new RelationalExpressionContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_relationalExpression);
						setState(379);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(380);
						match(LESSTHAN);
						setState(381);
						((RelationalExpressionContext)_localctx).r = additiveExpression(0);
						((RelationalExpressionContext)_localctx).lval =  buildBinaryOperator(loc(_localctx.start), Binop.LESS,
						                  ((RelationalExpressionContext)_localctx).l.lval, ((RelationalExpressionContext)_localctx).r.lval);
						}
						break;
					case 2:
						{
						_localctx = new RelationalExpressionContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_relationalExpression);
						setState(384);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(385);
						match(GREATERTHAN);
						setState(386);
						((RelationalExpressionContext)_localctx).r = additiveExpression(0);
						((RelationalExpressionContext)_localctx).lval =  buildBinaryOperator(loc(_localctx.start), Binop.GREAT,
						                  ((RelationalExpressionContext)_localctx).l.lval, ((RelationalExpressionContext)_localctx).r.lval);
						}
						break;
					}
					} 
				}
				setState(393);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AdditiveExpressionContext extends ParserRuleContext {
		public Expression lval;
		public AdditiveExpressionContext l;
		public MultiplicativeExpressionContext m;
		public MultiplicativeExpressionContext r;
		public MultiplicativeExpressionContext multiplicativeExpression() {
			return getRuleContext(MultiplicativeExpressionContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(TscriptParser.PLUS, 0); }
		public AdditiveExpressionContext additiveExpression() {
			return getRuleContext(AdditiveExpressionContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(TscriptParser.MINUS, 0); }
		public AdditiveExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveExpression; }
	}

	public final AdditiveExpressionContext additiveExpression() throws RecognitionException {
		return additiveExpression(0);
	}

	private AdditiveExpressionContext additiveExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AdditiveExpressionContext _localctx = new AdditiveExpressionContext(_ctx, _parentState);
		AdditiveExpressionContext _prevctx = _localctx;
		int _startState = 50;
		enterRecursionRule(_localctx, 50, RULE_additiveExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(395);
			((AdditiveExpressionContext)_localctx).m = multiplicativeExpression(0);
			 ((AdditiveExpressionContext)_localctx).lval =  ((AdditiveExpressionContext)_localctx).m.lval; 
			}
			_ctx.stop = _input.LT(-1);
			setState(410);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(408);
					switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
					case 1:
						{
						_localctx = new AdditiveExpressionContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_additiveExpression);
						setState(398);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(399);
						match(PLUS);
						setState(400);
						((AdditiveExpressionContext)_localctx).r = multiplicativeExpression(0);
						 ((AdditiveExpressionContext)_localctx).lval =  buildBinaryOperator(loc(_localctx.start), Binop.ADD,
						                  ((AdditiveExpressionContext)_localctx).l.lval, ((AdditiveExpressionContext)_localctx).r.lval); 
						}
						break;
					case 2:
						{
						_localctx = new AdditiveExpressionContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_additiveExpression);
						setState(403);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(404);
						match(MINUS);
						setState(405);
						((AdditiveExpressionContext)_localctx).r = multiplicativeExpression(0);
						 ((AdditiveExpressionContext)_localctx).lval =  buildBinaryOperator(loc(_localctx.start), Binop.SUB,
						              	((AdditiveExpressionContext)_localctx).l.lval, ((AdditiveExpressionContext)_localctx).r.lval); 
						}
						break;
					}
					} 
				}
				setState(412);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class MultiplicativeExpressionContext extends ParserRuleContext {
		public Expression lval;
		public MultiplicativeExpressionContext l;
		public UnaryExpressionContext p;
		public UnaryExpressionContext r;
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public TerminalNode ASTERISK() { return getToken(TscriptParser.ASTERISK, 0); }
		public MultiplicativeExpressionContext multiplicativeExpression() {
			return getRuleContext(MultiplicativeExpressionContext.class,0);
		}
		public TerminalNode SLASH() { return getToken(TscriptParser.SLASH, 0); }
		public MultiplicativeExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicativeExpression; }
	}

	public final MultiplicativeExpressionContext multiplicativeExpression() throws RecognitionException {
		return multiplicativeExpression(0);
	}

	private MultiplicativeExpressionContext multiplicativeExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MultiplicativeExpressionContext _localctx = new MultiplicativeExpressionContext(_ctx, _parentState);
		MultiplicativeExpressionContext _prevctx = _localctx;
		int _startState = 52;
		enterRecursionRule(_localctx, 52, RULE_multiplicativeExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(414);
			((MultiplicativeExpressionContext)_localctx).p = unaryExpression();
			 ((MultiplicativeExpressionContext)_localctx).lval =  ((MultiplicativeExpressionContext)_localctx).p.lval; 
			}
			_ctx.stop = _input.LT(-1);
			setState(429);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(427);
					switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicativeExpressionContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_multiplicativeExpression);
						setState(417);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(418);
						match(ASTERISK);
						setState(419);
						((MultiplicativeExpressionContext)_localctx).r = unaryExpression();
						 ((MultiplicativeExpressionContext)_localctx).lval =  buildBinaryOperator(loc(_localctx.start), Binop.MULTIPLY,
						                  ((MultiplicativeExpressionContext)_localctx).l.lval, ((MultiplicativeExpressionContext)_localctx).r.lval); 
						}
						break;
					case 2:
						{
						_localctx = new MultiplicativeExpressionContext(_parentctx, _parentState);
						_localctx.l = _prevctx;
						_localctx.l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_multiplicativeExpression);
						setState(422);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(423);
						match(SLASH);
						setState(424);
						((MultiplicativeExpressionContext)_localctx).r = unaryExpression();
						 ((MultiplicativeExpressionContext)_localctx).lval =  buildBinaryOperator(loc(_localctx.start),Binop.DIVIDE,
						            	    ((MultiplicativeExpressionContext)_localctx).l.lval,((MultiplicativeExpressionContext)_localctx).r.lval); 
						}
						break;
					}
					} 
				}
				setState(431);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class UnaryExpressionContext extends ParserRuleContext {
		public Expression lval;
		public PrimaryExpressionContext p;
		public UnaryExpressionContext r;
		public MemberExpressionContext me;
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(TscriptParser.MINUS, 0); }
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public TerminalNode NOT() { return getToken(TscriptParser.NOT, 0); }
		public MemberExpressionContext memberExpression() {
			return getRuleContext(MemberExpressionContext.class,0);
		}
		public UnaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpression; }
	}

	public final UnaryExpressionContext unaryExpression() throws RecognitionException {
		UnaryExpressionContext _localctx = new UnaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_unaryExpression);
		try {
			setState(446);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(432);
				((UnaryExpressionContext)_localctx).p = primaryExpression();
				 ((UnaryExpressionContext)_localctx).lval =  ((UnaryExpressionContext)_localctx).p.lval; 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(435);
				match(MINUS);
				setState(436);
				((UnaryExpressionContext)_localctx).r = unaryExpression();
				 ((UnaryExpressionContext)_localctx).lval =  buildUnaryOperator(loc(_localctx.start),Unop.SUB,((UnaryExpressionContext)_localctx).r.lval); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(439);
				match(NOT);
				setState(440);
				((UnaryExpressionContext)_localctx).r = unaryExpression();
				 ((UnaryExpressionContext)_localctx).lval =  buildUnaryOperator(loc(_localctx.start),Unop.NOT,((UnaryExpressionContext)_localctx).r.lval); 
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(443);
				((UnaryExpressionContext)_localctx).me = memberExpression(0);
				 ((UnaryExpressionContext)_localctx).lval =  ((UnaryExpressionContext)_localctx).me.lval; 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TryStatementContext extends ParserRuleContext {
		public Statement lval;
		public BlockStatementContext b1;
		public CatchStatementContext c1;
		public BlockStatementContext b2;
		public FinallyStatementContext f1;
		public BlockStatementContext b3;
		public CatchStatementContext c2;
		public FinallyStatementContext f2;
		public TerminalNode TRY() { return getToken(TscriptParser.TRY, 0); }
		public BlockStatementContext blockStatement() {
			return getRuleContext(BlockStatementContext.class,0);
		}
		public CatchStatementContext catchStatement() {
			return getRuleContext(CatchStatementContext.class,0);
		}
		public FinallyStatementContext finallyStatement() {
			return getRuleContext(FinallyStatementContext.class,0);
		}
		public TryStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tryStatement; }
	}

	public final TryStatementContext tryStatement() throws RecognitionException {
		TryStatementContext _localctx = new TryStatementContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_tryStatement);
		try {
			setState(464);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(448);
				match(TRY);
				setState(449);
				((TryStatementContext)_localctx).b1 = blockStatement();
				setState(450);
				((TryStatementContext)_localctx).c1 = catchStatement();
				 ((TryStatementContext)_localctx).lval =  buildTryStatement(loc(_localctx.start), ((TryStatementContext)_localctx).b1.lval, ((TryStatementContext)_localctx).c1.lval, null); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(453);
				match(TRY);
				setState(454);
				((TryStatementContext)_localctx).b2 = blockStatement();
				setState(455);
				((TryStatementContext)_localctx).f1 = finallyStatement();
				 ((TryStatementContext)_localctx).lval =  buildTryStatement(loc(_localctx.start), ((TryStatementContext)_localctx).b2.lval,null, ((TryStatementContext)_localctx).f1.lval ); 
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(458);
				match(TRY);
				setState(459);
				((TryStatementContext)_localctx).b3 = blockStatement();
				setState(460);
				((TryStatementContext)_localctx).c2 = catchStatement();
				setState(461);
				((TryStatementContext)_localctx).f2 = finallyStatement();
				 ((TryStatementContext)_localctx).lval =  buildTryStatement(loc(_localctx.start), ((TryStatementContext)_localctx).b3.lval, ((TryStatementContext)_localctx).c2.lval, ((TryStatementContext)_localctx).f2.lval); 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObjLiteralContext extends ParserRuleContext {
		public Expression lval;
		public PropertyNameAndValueListContext p;
		public TerminalNode LBRACE() { return getToken(TscriptParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(TscriptParser.RBRACE, 0); }
		public PropertyNameAndValueListContext propertyNameAndValueList() {
			return getRuleContext(PropertyNameAndValueListContext.class,0);
		}
		public ObjLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objLiteral; }
	}

	public final ObjLiteralContext objLiteral() throws RecognitionException {
		ObjLiteralContext _localctx = new ObjLiteralContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_objLiteral);
		try {
			setState(474);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(466);
				match(LBRACE);
				setState(467);
				match(RBRACE);
				 ((ObjLiteralContext)_localctx).lval =  buildObjLiteral(loc(_localctx.start),null); 
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(469);
				match(LBRACE);
				setState(470);
				((ObjLiteralContext)_localctx).p = propertyNameAndValueList(0);
				setState(471);
				match(RBRACE);
				 ((ObjLiteralContext)_localctx).lval =  buildObjLiteral(loc(_localctx.start),((ObjLiteralContext)_localctx).p.lval); 
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PropertyNameAndValueListContext extends ParserRuleContext {
		public List<Expression> lval;
		public PropertyNameAndValueListContext pl;
		public PropertyAssignmentContext p;
		public PropertyAssignmentContext propertyAssignment() {
			return getRuleContext(PropertyAssignmentContext.class,0);
		}
		public PropertyNameAndValueListContext propertyNameAndValueList() {
			return getRuleContext(PropertyNameAndValueListContext.class,0);
		}
		public PropertyNameAndValueListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertyNameAndValueList; }
	}

	public final PropertyNameAndValueListContext propertyNameAndValueList() throws RecognitionException {
		return propertyNameAndValueList(0);
	}

	private PropertyNameAndValueListContext propertyNameAndValueList(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PropertyNameAndValueListContext _localctx = new PropertyNameAndValueListContext(_ctx, _parentState);
		PropertyNameAndValueListContext _prevctx = _localctx;
		int _startState = 60;
		enterRecursionRule(_localctx, 60, RULE_propertyNameAndValueList, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(477);
			((PropertyNameAndValueListContext)_localctx).p = propertyAssignment();

					if(_localctx.lval == null){
					((PropertyNameAndValueListContext)_localctx).lval =  new ArrayList<Expression>();
					}
					_localctx.lval.add(((PropertyNameAndValueListContext)_localctx).p.lval);
				
			}
			_ctx.stop = _input.LT(-1);
			setState(487);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new PropertyNameAndValueListContext(_parentctx, _parentState);
					_localctx.pl = _prevctx;
					_localctx.pl = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_propertyNameAndValueList);
					setState(480);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(481);
					match(T__3);
					setState(482);
					((PropertyNameAndValueListContext)_localctx).p = propertyAssignment();
						if(((PropertyNameAndValueListContext)_localctx).pl.lval == null) {
					          		((PropertyNameAndValueListContext)_localctx).pl.lval = new ArrayList<Expression>();
					          		}
					          		((PropertyNameAndValueListContext)_localctx).pl.lval.add(((PropertyNameAndValueListContext)_localctx).p.lval);
					          		((PropertyNameAndValueListContext)_localctx).lval =  ((PropertyNameAndValueListContext)_localctx).pl.lval;
					          	
					}
					} 
				}
				setState(489);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PropertyAssignmentContext extends ParserRuleContext {
		public Expression lval;
		public PropertyNameContext p;
		public AssignmentExpressionContext a;
		public PropertyNameContext propertyName() {
			return getRuleContext(PropertyNameContext.class,0);
		}
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public PropertyAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertyAssignment; }
	}

	public final PropertyAssignmentContext propertyAssignment() throws RecognitionException {
		PropertyAssignmentContext _localctx = new PropertyAssignmentContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_propertyAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(490);
			((PropertyAssignmentContext)_localctx).p = propertyName();
			setState(491);
			match(T__4);
			setState(492);
			((PropertyAssignmentContext)_localctx).a = assignmentExpression();
			 ((PropertyAssignmentContext)_localctx).lval =  buildPropertyAssignment(loc(_localctx.start),((PropertyAssignmentContext)_localctx).p.lval,((PropertyAssignmentContext)_localctx).a.lval); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PropertyNameContext extends ParserRuleContext {
		public StringLiteral lval;
		public Token IDENTIFIER;
		public Token STRING_LITERAL;
		public Token NUMERIC_LITERAL;
		public TerminalNode IDENTIFIER() { return getToken(TscriptParser.IDENTIFIER, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(TscriptParser.STRING_LITERAL, 0); }
		public TerminalNode NUMERIC_LITERAL() { return getToken(TscriptParser.NUMERIC_LITERAL, 0); }
		public PropertyNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertyName; }
	}

	public final PropertyNameContext propertyName() throws RecognitionException {
		PropertyNameContext _localctx = new PropertyNameContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_propertyName);
		try {
			setState(501);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(495);
				((PropertyNameContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				((PropertyNameContext)_localctx).lval =  buildPropertyName(loc(_localctx.start),(((PropertyNameContext)_localctx).IDENTIFIER!=null?((PropertyNameContext)_localctx).IDENTIFIER.getText():null)); 
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(497);
				((PropertyNameContext)_localctx).STRING_LITERAL = match(STRING_LITERAL);
				 ((PropertyNameContext)_localctx).lval =  buildPropertyName(loc(_localctx.start), (((PropertyNameContext)_localctx).STRING_LITERAL!=null?((PropertyNameContext)_localctx).STRING_LITERAL.getText():null)); 
				}
				break;
			case NUMERIC_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(499);
				((PropertyNameContext)_localctx).NUMERIC_LITERAL = match(NUMERIC_LITERAL);
				 ((PropertyNameContext)_localctx).lval =  buildPropertyName(loc(_localctx.start), (((PropertyNameContext)_localctx).NUMERIC_LITERAL!=null?((PropertyNameContext)_localctx).NUMERIC_LITERAL.getText():null)); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CatchStatementContext extends ParserRuleContext {
		public Statement lval;
		public Token IDENTIFIER;
		public BlockStatementContext b;
		public TerminalNode CATCH() { return getToken(TscriptParser.CATCH, 0); }
		public TerminalNode LPAREN() { return getToken(TscriptParser.LPAREN, 0); }
		public TerminalNode IDENTIFIER() { return getToken(TscriptParser.IDENTIFIER, 0); }
		public TerminalNode RPAREN() { return getToken(TscriptParser.RPAREN, 0); }
		public BlockStatementContext blockStatement() {
			return getRuleContext(BlockStatementContext.class,0);
		}
		public CatchStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_catchStatement; }
	}

	public final CatchStatementContext catchStatement() throws RecognitionException {
		CatchStatementContext _localctx = new CatchStatementContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_catchStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(503);
			match(CATCH);
			setState(504);
			match(LPAREN);
			setState(505);
			((CatchStatementContext)_localctx).IDENTIFIER = match(IDENTIFIER);
			setState(506);
			match(RPAREN);
			setState(507);
			((CatchStatementContext)_localctx).b = blockStatement();
			 ((CatchStatementContext)_localctx).lval =  buildCatchStatement(loc(_localctx.start), (((CatchStatementContext)_localctx).IDENTIFIER!=null?((CatchStatementContext)_localctx).IDENTIFIER.getText():null), ((CatchStatementContext)_localctx).b.lval); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FinallyStatementContext extends ParserRuleContext {
		public Statement lval;
		public BlockStatementContext b;
		public TerminalNode FINALLY() { return getToken(TscriptParser.FINALLY, 0); }
		public BlockStatementContext blockStatement() {
			return getRuleContext(BlockStatementContext.class,0);
		}
		public FinallyStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finallyStatement; }
	}

	public final FinallyStatementContext finallyStatement() throws RecognitionException {
		FinallyStatementContext _localctx = new FinallyStatementContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_finallyStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(510);
			match(FINALLY);
			setState(511);
			((FinallyStatementContext)_localctx).b = blockStatement();
			 ((FinallyStatementContext)_localctx).lval =  buildFinallyStatement(loc(_localctx.start), ((FinallyStatementContext)_localctx).b.lval); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ThrowStatementContext extends ParserRuleContext {
		public Statement lval;
		public ExpressionContext e;
		public TerminalNode THROW() { return getToken(TscriptParser.THROW, 0); }
		public TerminalNode SEMICOLON() { return getToken(TscriptParser.SEMICOLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ThrowStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_throwStatement; }
	}

	public final ThrowStatementContext throwStatement() throws RecognitionException {
		ThrowStatementContext _localctx = new ThrowStatementContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_throwStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(514);
			match(THROW);
			setState(515);
			((ThrowStatementContext)_localctx).e = expression();
			setState(516);
			match(SEMICOLON);
			 ((ThrowStatementContext)_localctx).lval =  buildThrowStatement(loc(_localctx.start), ((ThrowStatementContext)_localctx).e.lval); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimaryExpressionContext extends ParserRuleContext {
		public Expression lval;
		public Token IDENTIFIER;
		public Token NUMERIC_LITERAL;
		public Token STRING_LITERAL;
		public Token BOOLEAN_LITERAL;
		public ObjLiteralContext o;
		public ExpressionContext e;
		public TerminalNode IDENTIFIER() { return getToken(TscriptParser.IDENTIFIER, 0); }
		public TerminalNode NUMERIC_LITERAL() { return getToken(TscriptParser.NUMERIC_LITERAL, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(TscriptParser.STRING_LITERAL, 0); }
		public TerminalNode BOOLEAN_LITERAL() { return getToken(TscriptParser.BOOLEAN_LITERAL, 0); }
		public TerminalNode NULL_LITERAL() { return getToken(TscriptParser.NULL_LITERAL, 0); }
		public ObjLiteralContext objLiteral() {
			return getRuleContext(ObjLiteralContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(TscriptParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(TscriptParser.RPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode THIS() { return getToken(TscriptParser.THIS, 0); }
		public PrimaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExpression; }
	}

	public final PrimaryExpressionContext primaryExpression() throws RecognitionException {
		PrimaryExpressionContext _localctx = new PrimaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_primaryExpression);
		try {
			setState(539);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(519);
				((PrimaryExpressionContext)_localctx).IDENTIFIER = match(IDENTIFIER);
				 ((PrimaryExpressionContext)_localctx).lval =  buildIdentifier(loc(_localctx.start), (((PrimaryExpressionContext)_localctx).IDENTIFIER!=null?((PrimaryExpressionContext)_localctx).IDENTIFIER.getText():null)); 
				}
				break;
			case NUMERIC_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(521);
				((PrimaryExpressionContext)_localctx).NUMERIC_LITERAL = match(NUMERIC_LITERAL);
				 ((PrimaryExpressionContext)_localctx).lval =  buildNumericLiteral(loc(_localctx.start), (((PrimaryExpressionContext)_localctx).NUMERIC_LITERAL!=null?((PrimaryExpressionContext)_localctx).NUMERIC_LITERAL.getText():null)); 
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(523);
				((PrimaryExpressionContext)_localctx).STRING_LITERAL = match(STRING_LITERAL);
				 ((PrimaryExpressionContext)_localctx).lval =  buildStringLiteral(loc(_localctx.start), (((PrimaryExpressionContext)_localctx).STRING_LITERAL!=null?((PrimaryExpressionContext)_localctx).STRING_LITERAL.getText():null)); 
				}
				break;
			case BOOLEAN_LITERAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(525);
				((PrimaryExpressionContext)_localctx).BOOLEAN_LITERAL = match(BOOLEAN_LITERAL);
				 ((PrimaryExpressionContext)_localctx).lval =  buildBooleanLiteral(loc(_localctx.start),(((PrimaryExpressionContext)_localctx).BOOLEAN_LITERAL!=null?((PrimaryExpressionContext)_localctx).BOOLEAN_LITERAL.getText():null)); 
				}
				break;
			case NULL_LITERAL:
				enterOuterAlt(_localctx, 5);
				{
				setState(527);
				match(NULL_LITERAL);
				 ((PrimaryExpressionContext)_localctx).lval =  buildNullLiteral(loc(_localctx.start)); 
				}
				break;
			case LBRACE:
				enterOuterAlt(_localctx, 6);
				{
				setState(529);
				((PrimaryExpressionContext)_localctx).o = objLiteral();
				 ((PrimaryExpressionContext)_localctx).lval =  ((PrimaryExpressionContext)_localctx).o.lval; 
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 7);
				{
				setState(532);
				match(LPAREN);
				setState(533);
				((PrimaryExpressionContext)_localctx).e = expression();
				setState(534);
				match(RPAREN);
				 ((PrimaryExpressionContext)_localctx).lval =  ((PrimaryExpressionContext)_localctx).e.lval; 
				}
				break;
			case THIS:
				enterOuterAlt(_localctx, 8);
				{
				setState(537);
				match(THIS);
				((PrimaryExpressionContext)_localctx).lval =  buildThis(loc(_localctx.start)); 
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return statementList_sempred((StatementListContext)_localctx, predIndex);
		case 16:
			return memberExpression_sempred((MemberExpressionContext)_localctx, predIndex);
		case 17:
			return callExpression_sempred((CallExpressionContext)_localctx, predIndex);
		case 19:
			return argumentList_sempred((ArgumentListContext)_localctx, predIndex);
		case 20:
			return formalParameterList_sempred((FormalParameterListContext)_localctx, predIndex);
		case 21:
			return equalityExpression_sempred((EqualityExpressionContext)_localctx, predIndex);
		case 24:
			return relationalExpression_sempred((RelationalExpressionContext)_localctx, predIndex);
		case 25:
			return additiveExpression_sempred((AdditiveExpressionContext)_localctx, predIndex);
		case 26:
			return multiplicativeExpression_sempred((MultiplicativeExpressionContext)_localctx, predIndex);
		case 30:
			return propertyNameAndValueList_sempred((PropertyNameAndValueListContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean statementList_sempred(StatementListContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean memberExpression_sempred(MemberExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 3);
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean callExpression_sempred(CallExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 3);
		case 4:
			return precpred(_ctx, 2);
		case 5:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean argumentList_sempred(ArgumentListContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean formalParameterList_sempred(FormalParameterListContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean equalityExpression_sempred(EqualityExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean relationalExpression_sempred(RelationalExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 9:
			return precpred(_ctx, 2);
		case 10:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean additiveExpression_sempred(AdditiveExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 11:
			return precpred(_ctx, 2);
		case 12:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean multiplicativeExpression_sempred(MultiplicativeExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 13:
			return precpred(_ctx, 2);
		case 14:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean propertyNameAndValueList_sempred(PropertyNameAndValueListContext _localctx, int predIndex) {
		switch (predIndex) {
		case 15:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3-\u0220\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\7\3X\n\3\f\3\16\3[\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u0081\n\4\3\5\3\5\3\5\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u0096\n"+
		"\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\5\f\u00b9\n\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17"+
		"\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\5\20\u00da\n\20\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00f8\n\21\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u0107\n\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\7\22\u0113\n\22\f\22\16"+
		"\22\u0116\13\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\7\23\u012b\n\23\f\23\16\23\u012e"+
		"\13\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u0138\n\24\3\25\3"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\7\25\u0143\n\25\f\25\16\25\u0146"+
		"\13\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\7\26\u0150\n\26\f\26\16"+
		"\26\u0153\13\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\7\27\u015e"+
		"\n\27\f\27\16\27\u0161\13\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3"+
		"\30\3\30\3\30\3\30\5\30\u016f\n\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\5\31\u0178\n\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\7\32\u0188\n\32\f\32\16\32\u018b\13\32\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\7\33\u019b\n\33"+
		"\f\33\16\33\u019e\13\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3"+
		"\34\3\34\3\34\3\34\3\34\7\34\u01ae\n\34\f\34\16\34\u01b1\13\34\3\35\3"+
		"\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u01c1"+
		"\n\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\5\36\u01d3\n\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\5\37\u01dd\n\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \7 \u01e8\n \f \16 \u01eb\13"+
		" \3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u01f8\n\"\3#\3#\3#\3#\3#"+
		"\3#\3#\3$\3$\3$\3$\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&\3&"+
		"\3&\3&\3&\3&\3&\3&\3&\3&\5&\u021e\n&\3&\2\f\4\"$(*,\62\64\66>\'\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJ\2\2\u0234"+
		"\2L\3\2\2\2\4P\3\2\2\2\6\u0080\3\2\2\2\b\u0082\3\2\2\2\n\u0095\3\2\2\2"+
		"\f\u0097\3\2\2\2\16\u009b\3\2\2\2\20\u009f\3\2\2\2\22\u00a4\3\2\2\2\24"+
		"\u00ab\3\2\2\2\26\u00b8\3\2\2\2\30\u00ba\3\2\2\2\32\u00be\3\2\2\2\34\u00c5"+
		"\3\2\2\2\36\u00d9\3\2\2\2 \u00f7\3\2\2\2\"\u0106\3\2\2\2$\u0117\3\2\2"+
		"\2&\u0137\3\2\2\2(\u0139\3\2\2\2*\u0147\3\2\2\2,\u0154\3\2\2\2.\u016e"+
		"\3\2\2\2\60\u0177\3\2\2\2\62\u0179\3\2\2\2\64\u018c\3\2\2\2\66\u019f\3"+
		"\2\2\28\u01c0\3\2\2\2:\u01d2\3\2\2\2<\u01dc\3\2\2\2>\u01de\3\2\2\2@\u01ec"+
		"\3\2\2\2B\u01f7\3\2\2\2D\u01f9\3\2\2\2F\u0200\3\2\2\2H\u0204\3\2\2\2J"+
		"\u021d\3\2\2\2LM\5\4\3\2MN\7\2\2\3NO\b\2\1\2O\3\3\2\2\2PQ\b\3\1\2QR\b"+
		"\3\1\2RY\3\2\2\2ST\f\3\2\2TU\5\6\4\2UV\b\3\1\2VX\3\2\2\2WS\3\2\2\2X[\3"+
		"\2\2\2YW\3\2\2\2YZ\3\2\2\2Z\5\3\2\2\2[Y\3\2\2\2\\]\5\20\t\2]^\b\4\1\2"+
		"^\u0081\3\2\2\2_`\5\30\r\2`a\b\4\1\2a\u0081\3\2\2\2bc\5\32\16\2cd\b\4"+
		"\1\2d\u0081\3\2\2\2ef\5\b\5\2fg\b\4\1\2g\u0081\3\2\2\2hi\5\24\13\2ij\b"+
		"\4\1\2j\u0081\3\2\2\2kl\5\22\n\2lm\b\4\1\2m\u0081\3\2\2\2no\5\f\7\2op"+
		"\b\4\1\2p\u0081\3\2\2\2qr\5\16\b\2rs\b\4\1\2s\u0081\3\2\2\2tu\5\n\6\2"+
		"uv\b\4\1\2v\u0081\3\2\2\2wx\5H%\2xy\b\4\1\2y\u0081\3\2\2\2z{\5:\36\2{"+
		"|\b\4\1\2|\u0081\3\2\2\2}~\5\26\f\2~\177\b\4\1\2\177\u0081\3\2\2\2\u0080"+
		"\\\3\2\2\2\u0080_\3\2\2\2\u0080b\3\2\2\2\u0080e\3\2\2\2\u0080h\3\2\2\2"+
		"\u0080k\3\2\2\2\u0080n\3\2\2\2\u0080q\3\2\2\2\u0080t\3\2\2\2\u0080w\3"+
		"\2\2\2\u0080z\3\2\2\2\u0080}\3\2\2\2\u0081\7\3\2\2\2\u0082\u0083\7\16"+
		"\2\2\u0083\u0084\b\5\1\2\u0084\t\3\2\2\2\u0085\u0086\7\"\2\2\u0086\u0087"+
		"\7\f\2\2\u0087\u0088\5\34\17\2\u0088\u0089\7\r\2\2\u0089\u008a\5\6\4\2"+
		"\u008a\u008b\b\6\1\2\u008b\u0096\3\2\2\2\u008c\u008d\7\"\2\2\u008d\u008e"+
		"\7\f\2\2\u008e\u008f\5\34\17\2\u008f\u0090\7\r\2\2\u0090\u0091\5\6\4\2"+
		"\u0091\u0092\7#\2\2\u0092\u0093\5\6\4\2\u0093\u0094\b\6\1\2\u0094\u0096"+
		"\3\2\2\2\u0095\u0085\3\2\2\2\u0095\u008c\3\2\2\2\u0096\13\3\2\2\2\u0097"+
		"\u0098\7!\2\2\u0098\u0099\7\16\2\2\u0099\u009a\b\7\1\2\u009a\r\3\2\2\2"+
		"\u009b\u009c\7 \2\2\u009c\u009d\7\16\2\2\u009d\u009e\b\b\1\2\u009e\17"+
		"\3\2\2\2\u009f\u00a0\7\33\2\2\u00a0\u00a1\7,\2\2\u00a1\u00a2\7\16\2\2"+
		"\u00a2\u00a3\b\t\1\2\u00a3\21\3\2\2\2\u00a4\u00a5\7\37\2\2\u00a5\u00a6"+
		"\7\f\2\2\u00a6\u00a7\5\34\17\2\u00a7\u00a8\7\r\2\2\u00a8\u00a9\5\6\4\2"+
		"\u00a9\u00aa\b\n\1\2\u00aa\23\3\2\2\2\u00ab\u00ac\7\30\2\2\u00ac\u00ad"+
		"\5\4\3\2\u00ad\u00ae\7\31\2\2\u00ae\u00af\b\13\1\2\u00af\25\3\2\2\2\u00b0"+
		"\u00b1\7*\2\2\u00b1\u00b2\5\34\17\2\u00b2\u00b3\7\16\2\2\u00b3\u00b4\b"+
		"\f\1\2\u00b4\u00b9\3\2\2\2\u00b5\u00b6\7*\2\2\u00b6\u00b7\7\16\2\2\u00b7"+
		"\u00b9\b\f\1\2\u00b8\u00b0\3\2\2\2\u00b8\u00b5\3\2\2\2\u00b9\27\3\2\2"+
		"\2\u00ba\u00bb\5\34\17\2\u00bb\u00bc\7\16\2\2\u00bc\u00bd\b\r\1\2\u00bd"+
		"\31\3\2\2\2\u00be\u00bf\7\32\2\2\u00bf\u00c0\7\f\2\2\u00c0\u00c1\5\34"+
		"\17\2\u00c1\u00c2\7\r\2\2\u00c2\u00c3\7\16\2\2\u00c3\u00c4\b\16\1\2\u00c4"+
		"\33\3\2\2\2\u00c5\u00c6\5\36\20\2\u00c6\u00c7\b\17\1\2\u00c7\35\3\2\2"+
		"\2\u00c8\u00c9\5,\27\2\u00c9\u00ca\b\20\1\2\u00ca\u00da\3\2\2\2\u00cb"+
		"\u00cc\5 \21\2\u00cc\u00cd\b\20\1\2\u00cd\u00da\3\2\2\2\u00ce\u00cf\5"+
		"\"\22\2\u00cf\u00d0\b\20\1\2\u00d0\u00da\3\2\2\2\u00d1\u00d2\5$\23\2\u00d2"+
		"\u00d3\b\20\1\2\u00d3\u00da\3\2\2\2\u00d4\u00d5\5.\30\2\u00d5\u00d6\7"+
		"\17\2\2\u00d6\u00d7\5\36\20\2\u00d7\u00d8\b\20\1\2\u00d8\u00da\3\2\2\2"+
		"\u00d9\u00c8\3\2\2\2\u00d9\u00cb\3\2\2\2\u00d9\u00ce\3\2\2\2\u00d9\u00d1"+
		"\3\2\2\2\u00d9\u00d4\3\2\2\2\u00da\37\3\2\2\2\u00db\u00dc\7)\2\2\u00dc"+
		"\u00dd\7\f\2\2\u00dd\u00de\7\r\2\2\u00de\u00df\5\24\13\2\u00df\u00e0\b"+
		"\21\1\2\u00e0\u00f8\3\2\2\2\u00e1\u00e2\7)\2\2\u00e2\u00e3\7\f\2\2\u00e3"+
		"\u00e4\5*\26\2\u00e4\u00e5\7\r\2\2\u00e5\u00e6\5\24\13\2\u00e6\u00e7\b"+
		"\21\1\2\u00e7\u00f8\3\2\2\2\u00e8\u00e9\7)\2\2\u00e9\u00ea\7,\2\2\u00ea"+
		"\u00eb\7\f\2\2\u00eb\u00ec\7\r\2\2\u00ec\u00ed\5\24\13\2\u00ed\u00ee\b"+
		"\21\1\2\u00ee\u00f8\3\2\2\2\u00ef\u00f0\7)\2\2\u00f0\u00f1\7,\2\2\u00f1"+
		"\u00f2\7\f\2\2\u00f2\u00f3\5*\26\2\u00f3\u00f4\7\r\2\2\u00f4\u00f5\5\24"+
		"\13\2\u00f5\u00f6\b\21\1\2\u00f6\u00f8\3\2\2\2\u00f7\u00db\3\2\2\2\u00f7"+
		"\u00e1\3\2\2\2\u00f7\u00e8\3\2\2\2\u00f7\u00ef\3\2\2\2\u00f8!\3\2\2\2"+
		"\u00f9\u00fa\b\22\1\2\u00fa\u00fb\5J&\2\u00fb\u00fc\b\22\1\2\u00fc\u0107"+
		"\3\2\2\2\u00fd\u00fe\5 \21\2\u00fe\u00ff\b\22\1\2\u00ff\u0107\3\2\2\2"+
		"\u0100\u0101\7(\2\2\u0101\u0102\5\"\22\2\u0102\u0103\7\f\2\2\u0103\u0104"+
		"\7\r\2\2\u0104\u0105\b\22\1\2\u0105\u0107\3\2\2\2\u0106\u00f9\3\2\2\2"+
		"\u0106\u00fd\3\2\2\2\u0106\u0100\3\2\2\2\u0107\u0114\3\2\2\2\u0108\u0109"+
		"\f\5\2\2\u0109\u010a\7\3\2\2\u010a\u010b\5\34\17\2\u010b\u010c\7\4\2\2"+
		"\u010c\u010d\b\22\1\2\u010d\u0113\3\2\2\2\u010e\u010f\f\4\2\2\u010f\u0110"+
		"\7\5\2\2\u0110\u0111\7,\2\2\u0111\u0113\b\22\1\2\u0112\u0108\3\2\2\2\u0112"+
		"\u010e\3\2\2\2\u0113\u0116\3\2\2\2\u0114\u0112\3\2\2\2\u0114\u0115\3\2"+
		"\2\2\u0115#\3\2\2\2\u0116\u0114\3\2\2\2\u0117\u0118\b\23\1\2\u0118\u0119"+
		"\5\"\22\2\u0119\u011a\5&\24\2\u011a\u011b\b\23\1\2\u011b\u012c\3\2\2\2"+
		"\u011c\u011d\f\5\2\2\u011d\u011e\5&\24\2\u011e\u011f\b\23\1\2\u011f\u012b"+
		"\3\2\2\2\u0120\u0121\f\4\2\2\u0121\u0122\7\3\2\2\u0122\u0123\5\34\17\2"+
		"\u0123\u0124\7\4\2\2\u0124\u0125\b\23\1\2\u0125\u012b\3\2\2\2\u0126\u0127"+
		"\f\3\2\2\u0127\u0128\7\5\2\2\u0128\u0129\7,\2\2\u0129\u012b\b\23\1\2\u012a"+
		"\u011c\3\2\2\2\u012a\u0120\3\2\2\2\u012a\u0126\3\2\2\2\u012b\u012e\3\2"+
		"\2\2\u012c\u012a\3\2\2\2\u012c\u012d\3\2\2\2\u012d%\3\2\2\2\u012e\u012c"+
		"\3\2\2\2\u012f\u0130\7\f\2\2\u0130\u0131\7\r\2\2\u0131\u0138\b\24\1\2"+
		"\u0132\u0133\7\f\2\2\u0133\u0134\5(\25\2\u0134\u0135\7\r\2\2\u0135\u0136"+
		"\b\24\1\2\u0136\u0138\3\2\2\2\u0137\u012f\3\2\2\2\u0137\u0132\3\2\2\2"+
		"\u0138\'\3\2\2\2\u0139\u013a\b\25\1\2\u013a\u013b\5\36\20\2\u013b\u013c"+
		"\b\25\1\2\u013c\u0144\3\2\2\2\u013d\u013e\f\3\2\2\u013e\u013f\7\6\2\2"+
		"\u013f\u0140\5\36\20\2\u0140\u0141\b\25\1\2\u0141\u0143\3\2\2\2\u0142"+
		"\u013d\3\2\2\2\u0143\u0146\3\2\2\2\u0144\u0142\3\2\2\2\u0144\u0145\3\2"+
		"\2\2\u0145)\3\2\2\2\u0146\u0144\3\2\2\2\u0147\u0148\b\26\1\2\u0148\u0149"+
		"\7,\2\2\u0149\u014a\b\26\1\2\u014a\u0151\3\2\2\2\u014b\u014c\f\3\2\2\u014c"+
		"\u014d\7\6\2\2\u014d\u014e\7,\2\2\u014e\u0150\b\26\1\2\u014f\u014b\3\2"+
		"\2\2\u0150\u0153\3\2\2\2\u0151\u014f\3\2\2\2\u0151\u0152\3\2\2\2\u0152"+
		"+\3\2\2\2\u0153\u0151\3\2\2\2\u0154\u0155\b\27\1\2\u0155\u0156\5\62\32"+
		"\2\u0156\u0157\b\27\1\2\u0157\u015f\3\2\2\2\u0158\u0159\f\3\2\2\u0159"+
		"\u015a\7\27\2\2\u015a\u015b\5\62\32\2\u015b\u015c\b\27\1\2\u015c\u015e"+
		"\3\2\2\2\u015d\u0158\3\2\2\2\u015e\u0161\3\2\2\2\u015f\u015d\3\2\2\2\u015f"+
		"\u0160\3\2\2\2\u0160-\3\2\2\2\u0161\u015f\3\2\2\2\u0162\u0163\5J&\2\u0163"+
		"\u0164\b\30\1\2\u0164\u016f\3\2\2\2\u0165\u0166\5$\23\2\u0166\u0167\b"+
		"\30\1\2\u0167\u016f\3\2\2\2\u0168\u0169\5\"\22\2\u0169\u016a\b\30\1\2"+
		"\u016a\u016f\3\2\2\2\u016b\u016c\5\60\31\2\u016c\u016d\b\30\1\2\u016d"+
		"\u016f\3\2\2\2\u016e\u0162\3\2\2\2\u016e\u0165\3\2\2\2\u016e\u0168\3\2"+
		"\2\2\u016e\u016b\3\2\2\2\u016f/\3\2\2\2\u0170\u0171\5\"\22\2\u0171\u0172"+
		"\b\31\1\2\u0172\u0178\3\2\2\2\u0173\u0174\7(\2\2\u0174\u0175\5\60\31\2"+
		"\u0175\u0176\b\31\1\2\u0176\u0178\3\2\2\2\u0177\u0170\3\2\2\2\u0177\u0173"+
		"\3\2\2\2\u0178\61\3\2\2\2\u0179\u017a\b\32\1\2\u017a\u017b\5\64\33\2\u017b"+
		"\u017c\b\32\1\2\u017c\u0189\3\2\2\2\u017d\u017e\f\4\2\2\u017e\u017f\7"+
		"\24\2\2\u017f\u0180\5\64\33\2\u0180\u0181\b\32\1\2\u0181\u0188\3\2\2\2"+
		"\u0182\u0183\f\3\2\2\u0183\u0184\7\26\2\2\u0184\u0185\5\64\33\2\u0185"+
		"\u0186\b\32\1\2\u0186\u0188\3\2\2\2\u0187\u017d\3\2\2\2\u0187\u0182\3"+
		"\2\2\2\u0188\u018b\3\2\2\2\u0189\u0187\3\2\2\2\u0189\u018a\3\2\2\2\u018a"+
		"\63\3\2\2\2\u018b\u0189\3\2\2\2\u018c\u018d\b\33\1\2\u018d\u018e\5\66"+
		"\34\2\u018e\u018f\b\33\1\2\u018f\u019c\3\2\2\2\u0190\u0191\f\4\2\2\u0191"+
		"\u0192\7\20\2\2\u0192\u0193\5\66\34\2\u0193\u0194\b\33\1\2\u0194\u019b"+
		"\3\2\2\2\u0195\u0196\f\3\2\2\u0196\u0197\7\22\2\2\u0197\u0198\5\66\34"+
		"\2\u0198\u0199\b\33\1\2\u0199\u019b\3\2\2\2\u019a\u0190\3\2\2\2\u019a"+
		"\u0195\3\2\2\2\u019b\u019e\3\2\2\2\u019c\u019a\3\2\2\2\u019c\u019d\3\2"+
		"\2\2\u019d\65\3\2\2\2\u019e\u019c\3\2\2\2\u019f\u01a0\b\34\1\2\u01a0\u01a1"+
		"\58\35\2\u01a1\u01a2\b\34\1\2\u01a2\u01af\3\2\2\2\u01a3\u01a4\f\4\2\2"+
		"\u01a4\u01a5\7\21\2\2\u01a5\u01a6\58\35\2\u01a6\u01a7\b\34\1\2\u01a7\u01ae"+
		"\3\2\2\2\u01a8\u01a9\f\3\2\2\u01a9\u01aa\7\25\2\2\u01aa\u01ab\58\35\2"+
		"\u01ab\u01ac\b\34\1\2\u01ac\u01ae\3\2\2\2\u01ad\u01a3\3\2\2\2\u01ad\u01a8"+
		"\3\2\2\2\u01ae\u01b1\3\2\2\2\u01af\u01ad\3\2\2\2\u01af\u01b0\3\2\2\2\u01b0"+
		"\67\3\2\2\2\u01b1\u01af\3\2\2\2\u01b2\u01b3\5J&\2\u01b3\u01b4\b\35\1\2"+
		"\u01b4\u01c1\3\2\2\2\u01b5\u01b6\7\22\2\2\u01b6\u01b7\58\35\2\u01b7\u01b8"+
		"\b\35\1\2\u01b8\u01c1\3\2\2\2\u01b9\u01ba\7\23\2\2\u01ba\u01bb\58\35\2"+
		"\u01bb\u01bc\b\35\1\2\u01bc\u01c1\3\2\2\2\u01bd\u01be\5\"\22\2\u01be\u01bf"+
		"\b\35\1\2\u01bf\u01c1\3\2\2\2\u01c0\u01b2\3\2\2\2\u01c0\u01b5\3\2\2\2"+
		"\u01c0\u01b9\3\2\2\2\u01c0\u01bd\3\2\2\2\u01c19\3\2\2\2\u01c2\u01c3\7"+
		"&\2\2\u01c3\u01c4\5\24\13\2\u01c4\u01c5\5D#\2\u01c5\u01c6\b\36\1\2\u01c6"+
		"\u01d3\3\2\2\2\u01c7\u01c8\7&\2\2\u01c8\u01c9\5\24\13\2\u01c9\u01ca\5"+
		"F$\2\u01ca\u01cb\b\36\1\2\u01cb\u01d3\3\2\2\2\u01cc\u01cd\7&\2\2\u01cd"+
		"\u01ce\5\24\13\2\u01ce\u01cf\5D#\2\u01cf\u01d0\5F$\2\u01d0\u01d1\b\36"+
		"\1\2\u01d1\u01d3\3\2\2\2\u01d2\u01c2\3\2\2\2\u01d2\u01c7\3\2\2\2\u01d2"+
		"\u01cc\3\2\2\2\u01d3;\3\2\2\2\u01d4\u01d5\7\30\2\2\u01d5\u01d6\7\31\2"+
		"\2\u01d6\u01dd\b\37\1\2\u01d7\u01d8\7\30\2\2\u01d8\u01d9\5> \2\u01d9\u01da"+
		"\7\31\2\2\u01da\u01db\b\37\1\2\u01db\u01dd\3\2\2\2\u01dc\u01d4\3\2\2\2"+
		"\u01dc\u01d7\3\2\2\2\u01dd=\3\2\2\2\u01de\u01df\b \1\2\u01df\u01e0\5@"+
		"!\2\u01e0\u01e1\b \1\2\u01e1\u01e9\3\2\2\2\u01e2\u01e3\f\3\2\2\u01e3\u01e4"+
		"\7\6\2\2\u01e4\u01e5\5@!\2\u01e5\u01e6\b \1\2\u01e6\u01e8\3\2\2\2\u01e7"+
		"\u01e2\3\2\2\2\u01e8\u01eb\3\2\2\2\u01e9\u01e7\3\2\2\2\u01e9\u01ea\3\2"+
		"\2\2\u01ea?\3\2\2\2\u01eb\u01e9\3\2\2\2\u01ec\u01ed\5B\"\2\u01ed\u01ee"+
		"\7\7\2\2\u01ee\u01ef\5\36\20\2\u01ef\u01f0\b!\1\2\u01f0A\3\2\2\2\u01f1"+
		"\u01f2\7,\2\2\u01f2\u01f8\b\"\1\2\u01f3\u01f4\7\b\2\2\u01f4\u01f8\b\""+
		"\1\2\u01f5\u01f6\7\13\2\2\u01f6\u01f8\b\"\1\2\u01f7\u01f1\3\2\2\2\u01f7"+
		"\u01f3\3\2\2\2\u01f7\u01f5\3\2\2\2\u01f8C\3\2\2\2\u01f9\u01fa\7\'\2\2"+
		"\u01fa\u01fb\7\f\2\2\u01fb\u01fc\7,\2\2\u01fc\u01fd\7\r\2\2\u01fd\u01fe"+
		"\5\24\13\2\u01fe\u01ff\b#\1\2\u01ffE\3\2\2\2\u0200\u0201\7%\2\2\u0201"+
		"\u0202\5\24\13\2\u0202\u0203\b$\1\2\u0203G\3\2\2\2\u0204\u0205\7$\2\2"+
		"\u0205\u0206\5\34\17\2\u0206\u0207\7\16\2\2\u0207\u0208\b%\1\2\u0208I"+
		"\3\2\2\2\u0209\u020a\7,\2\2\u020a\u021e\b&\1\2\u020b\u020c\7\13\2\2\u020c"+
		"\u021e\b&\1\2\u020d\u020e\7\b\2\2\u020e\u021e\b&\1\2\u020f\u0210\7\t\2"+
		"\2\u0210\u021e\b&\1\2\u0211\u0212\7\n\2\2\u0212\u021e\b&\1\2\u0213\u0214"+
		"\5<\37\2\u0214\u0215\b&\1\2\u0215\u021e\3\2\2\2\u0216\u0217\7\f\2\2\u0217"+
		"\u0218\5\34\17\2\u0218\u0219\7\r\2\2\u0219\u021a\b&\1\2\u021a\u021e\3"+
		"\2\2\2\u021b\u021c\7+\2\2\u021c\u021e\b&\1\2\u021d\u0209\3\2\2\2\u021d"+
		"\u020b\3\2\2\2\u021d\u020d\3\2\2\2\u021d\u020f\3\2\2\2\u021d\u0211\3\2"+
		"\2\2\u021d\u0213\3\2\2\2\u021d\u0216\3\2\2\2\u021d\u021b\3\2\2\2\u021e"+
		"K\3\2\2\2\37Y\u0080\u0095\u00b8\u00d9\u00f7\u0106\u0112\u0114\u012a\u012c"+
		"\u0137\u0144\u0151\u015f\u016e\u0177\u0187\u0189\u019a\u019c\u01ad\u01af"+
		"\u01c0\u01d2\u01dc\u01e9\u01f7\u021d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}