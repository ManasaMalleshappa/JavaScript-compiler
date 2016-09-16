// Generated from Tscript.g4 by ANTLR 4.5.1
package ts.parse;

  import ts.Location;
  import ts.tree.*;
  import static ts.parse.TreeBuilder.*;
  import java.util.List;
  import java.util.ArrayList;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TscriptLexer extends Lexer {
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
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "Digit", "IdentifierCharacters", 
		"SpaceTokens", "SpaceChars", "EndOfLineComment", "LineTerminator", "Letter", 
		"StringLiteral", "DoubleStringCharacters", "SingleStringCharacters", "DoubleStringCharacter", 
		"SingleStringCharacter", "EscapeSequence", "CharacterEscapeSequence", 
		"SingleEscapeCharacter", "NumericLiteral", "DecimalLiteral", "DecimalIntegerLiteral", 
		"DecimalDigit", "DecimalDigits", "NonZeroDigit", "ExponentPart", "ExponentIndicator", 
		"SignedInteger", "HexIntegerLiteral", "HexDigit", "STRING_LITERAL", "BOOLEAN_LITERAL", 
		"NULL_LITERAL", "NUMERIC_LITERAL", "LPAREN", "RPAREN", "SEMICOLON", "EQUAL", 
		"PLUS", "ASTERISK", "MINUS", "NOT", "LESSTHAN", "SLASH", "GREATERTHAN", 
		"EQUALTO", "LBRACE", "RBRACE", "PRINT", "VAR", "TRUE", "FALSE", "NULL", 
		"WHILE", "CONTINUE", "BREAK", "IF", "ELSE", "THROW", "FINALLY", "TRY", 
		"CATCH", "NEW", "FUNCTION", "RETURN", "THIS", "IDENTIFIER", "WhiteSpace"
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


	public TscriptLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Tscript.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2-\u01c5\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\3\2\3\2\3\3\3\3"+
		"\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\7\b\u009c\n\b\f\b\16\b\u009f"+
		"\13\b\3\t\3\t\3\t\5\t\u00a4\n\t\3\n\3\n\3\13\3\13\3\13\3\13\7\13\u00ac"+
		"\n\13\f\13\16\13\u00af\13\13\3\13\3\13\5\13\u00b3\n\13\3\f\3\f\3\f\5\f"+
		"\u00b8\n\f\3\r\3\r\3\16\3\16\5\16\u00be\n\16\3\16\3\16\3\16\5\16\u00c3"+
		"\n\16\3\16\5\16\u00c6\n\16\3\17\3\17\5\17\u00ca\n\17\3\20\3\20\5\20\u00ce"+
		"\n\20\3\21\3\21\3\21\3\21\5\21\u00d4\n\21\3\22\3\22\3\22\3\22\5\22\u00da"+
		"\n\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\5\26\u00e4\n\26\3\27\3\27"+
		"\3\27\5\27\u00e9\n\27\3\27\5\27\u00ec\n\27\3\27\3\27\3\27\5\27\u00f1\n"+
		"\27\3\27\3\27\5\27\u00f5\n\27\5\27\u00f7\n\27\3\30\3\30\3\30\5\30\u00fc"+
		"\n\30\5\30\u00fe\n\30\3\31\3\31\3\32\7\32\u0103\n\32\f\32\16\32\u0106"+
		"\13\32\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\36\3\36\3\36\3\36\3\36\5\36"+
		"\u0114\n\36\3\37\3\37\3\37\6\37\u0119\n\37\r\37\16\37\u011a\3\37\3\37"+
		"\3\37\6\37\u0120\n\37\r\37\16\37\u0121\5\37\u0124\n\37\3 \3 \3!\3!\3\""+
		"\3\"\5\"\u012c\n\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3"+
		"+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3"+
		"\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3"+
		"\64\3\65\3\65\3\65\3\65\3\65\3\66\3\66\3\66\3\66\3\66\3\66\3\67\3\67\3"+
		"\67\3\67\3\67\38\38\38\38\38\38\39\39\39\39\39\39\39\39\39\3:\3:\3:\3"+
		":\3:\3:\3;\3;\3;\3<\3<\3<\3<\3<\3=\3=\3=\3=\3=\3=\3>\3>\3>\3>\3>\3>\3"+
		">\3>\3?\3?\3?\3?\3@\3@\3@\3@\3@\3@\3A\3A\3A\3A\3B\3B\3B\3B\3B\3B\3B\3"+
		"B\3B\3C\3C\3C\3C\3C\3C\3C\3D\3D\3D\3D\3D\3E\3E\3F\6F\u01c0\nF\rF\16F\u01c1"+
		"\3F\3F\2\2G\3\3\5\4\7\5\t\6\13\7\r\2\17\2\21\2\23\2\25\2\27\2\31\2\33"+
		"\2\35\2\37\2!\2#\2%\2\'\2)\2+\2-\2/\2\61\2\63\2\65\2\67\29\2;\2=\2?\2"+
		"A\bC\tE\nG\13I\fK\rM\16O\17Q\20S\21U\22W\23Y\24[\25]\26_\27a\30c\31e\32"+
		"g\33i\34k\35m\36o\37q s!u\"w#y${%}&\177\'\u0081(\u0083)\u0085*\u0087+"+
		"\u0089,\u008b-\3\2!\3\2\62;\6\2&&C\\aac|\7\2&&\62;C\\aac|\5\2\13\13\16"+
		"\16\"\"\4\2\f\f\17\17\4\2C\\c|\3\2$$\3\2))\4\2$$^^\3\2^^\4\2))^^\4\2^"+
		"^pp\3\2\62\62\3\2\63;\4\2GGgg\3\2zz\3\2ZZ\5\2\62;CHch\3\2**\3\2++\3\2"+
		"==\3\2??\3\2--\3\2,,\3\2//\3\2##\3\2>>\3\2\61\61\3\2@@\3\2}}\3\2\177\177"+
		"\u01ca\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3"+
		"\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2"+
		"\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2"+
		"g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3"+
		"\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3"+
		"\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085\3\2\2\2\2\u0087\3\2\2\2"+
		"\2\u0089\3\2\2\2\2\u008b\3\2\2\2\3\u008d\3\2\2\2\5\u008f\3\2\2\2\7\u0091"+
		"\3\2\2\2\t\u0093\3\2\2\2\13\u0095\3\2\2\2\r\u0097\3\2\2\2\17\u0099\3\2"+
		"\2\2\21\u00a3\3\2\2\2\23\u00a5\3\2\2\2\25\u00a7\3\2\2\2\27\u00b7\3\2\2"+
		"\2\31\u00b9\3\2\2\2\33\u00c5\3\2\2\2\35\u00c7\3\2\2\2\37\u00cb\3\2\2\2"+
		"!\u00d3\3\2\2\2#\u00d9\3\2\2\2%\u00db\3\2\2\2\'\u00dd\3\2\2\2)\u00df\3"+
		"\2\2\2+\u00e3\3\2\2\2-\u00f6\3\2\2\2/\u00fd\3\2\2\2\61\u00ff\3\2\2\2\63"+
		"\u0104\3\2\2\2\65\u0107\3\2\2\2\67\u0109\3\2\2\29\u010c\3\2\2\2;\u0113"+
		"\3\2\2\2=\u0123\3\2\2\2?\u0125\3\2\2\2A\u0127\3\2\2\2C\u012b\3\2\2\2E"+
		"\u012d\3\2\2\2G\u012f\3\2\2\2I\u0131\3\2\2\2K\u0133\3\2\2\2M\u0135\3\2"+
		"\2\2O\u0137\3\2\2\2Q\u0139\3\2\2\2S\u013b\3\2\2\2U\u013d\3\2\2\2W\u013f"+
		"\3\2\2\2Y\u0141\3\2\2\2[\u0143\3\2\2\2]\u0145\3\2\2\2_\u0147\3\2\2\2a"+
		"\u014a\3\2\2\2c\u014c\3\2\2\2e\u014e\3\2\2\2g\u015a\3\2\2\2i\u015e\3\2"+
		"\2\2k\u0163\3\2\2\2m\u0169\3\2\2\2o\u016e\3\2\2\2q\u0174\3\2\2\2s\u017d"+
		"\3\2\2\2u\u0183\3\2\2\2w\u0186\3\2\2\2y\u018b\3\2\2\2{\u0191\3\2\2\2}"+
		"\u0199\3\2\2\2\177\u019d\3\2\2\2\u0081\u01a3\3\2\2\2\u0083\u01a7\3\2\2"+
		"\2\u0085\u01b0\3\2\2\2\u0087\u01b7\3\2\2\2\u0089\u01bc\3\2\2\2\u008b\u01bf"+
		"\3\2\2\2\u008d\u008e\7]\2\2\u008e\4\3\2\2\2\u008f\u0090\7_\2\2\u0090\6"+
		"\3\2\2\2\u0091\u0092\7\60\2\2\u0092\b\3\2\2\2\u0093\u0094\7.\2\2\u0094"+
		"\n\3\2\2\2\u0095\u0096\7<\2\2\u0096\f\3\2\2\2\u0097\u0098\t\2\2\2\u0098"+
		"\16\3\2\2\2\u0099\u009d\t\3\2\2\u009a\u009c\t\4\2\2\u009b\u009a\3\2\2"+
		"\2\u009c\u009f\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\20"+
		"\3\2\2\2\u009f\u009d\3\2\2\2\u00a0\u00a4\5\23\n\2\u00a1\u00a4\5\27\f\2"+
		"\u00a2\u00a4\5\25\13\2\u00a3\u00a0\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a2"+
		"\3\2\2\2\u00a4\22\3\2\2\2\u00a5\u00a6\t\5\2\2\u00a6\24\3\2\2\2\u00a7\u00a8"+
		"\7\61\2\2\u00a8\u00a9\7\61\2\2\u00a9\u00ad\3\2\2\2\u00aa\u00ac\n\6\2\2"+
		"\u00ab\u00aa\3\2\2\2\u00ac\u00af\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae"+
		"\3\2\2\2\u00ae\u00b2\3\2\2\2\u00af\u00ad\3\2\2\2\u00b0\u00b3\5\27\f\2"+
		"\u00b1\u00b3\7\2\2\3\u00b2\u00b0\3\2\2\2\u00b2\u00b1\3\2\2\2\u00b3\26"+
		"\3\2\2\2\u00b4\u00b5\7\17\2\2\u00b5\u00b8\7\f\2\2\u00b6\u00b8\t\6\2\2"+
		"\u00b7\u00b4\3\2\2\2\u00b7\u00b6\3\2\2\2\u00b8\30\3\2\2\2\u00b9\u00ba"+
		"\t\7\2\2\u00ba\32\3\2\2\2\u00bb\u00bd\t\b\2\2\u00bc\u00be\5\35\17\2\u00bd"+
		"\u00bc\3\2\2\2\u00bd\u00be\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c6\t\b"+
		"\2\2\u00c0\u00c2\t\t\2\2\u00c1\u00c3\5\37\20\2\u00c2\u00c1\3\2\2\2\u00c2"+
		"\u00c3\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c6\t\t\2\2\u00c5\u00bb\3\2"+
		"\2\2\u00c5\u00c0\3\2\2\2\u00c6\34\3\2\2\2\u00c7\u00c9\5!\21\2\u00c8\u00ca"+
		"\5\35\17\2\u00c9\u00c8\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\36\3\2\2\2\u00cb"+
		"\u00cd\5#\22\2\u00cc\u00ce\5\37\20\2\u00cd\u00cc\3\2\2\2\u00cd\u00ce\3"+
		"\2\2\2\u00ce \3\2\2\2\u00cf\u00d4\n\n\2\2\u00d0\u00d4\5\27\f\2\u00d1\u00d2"+
		"\t\13\2\2\u00d2\u00d4\5%\23\2\u00d3\u00cf\3\2\2\2\u00d3\u00d0\3\2\2\2"+
		"\u00d3\u00d1\3\2\2\2\u00d4\"\3\2\2\2\u00d5\u00da\n\f\2\2\u00d6\u00da\5"+
		"\27\f\2\u00d7\u00d8\t\13\2\2\u00d8\u00da\5%\23\2\u00d9\u00d5\3\2\2\2\u00d9"+
		"\u00d6\3\2\2\2\u00d9\u00d7\3\2\2\2\u00da$\3\2\2\2\u00db\u00dc\5\'\24\2"+
		"\u00dc&\3\2\2\2\u00dd\u00de\5)\25\2\u00de(\3\2\2\2\u00df\u00e0\t\r\2\2"+
		"\u00e0*\3\2\2\2\u00e1\u00e4\5-\27\2\u00e2\u00e4\5=\37\2\u00e3\u00e1\3"+
		"\2\2\2\u00e3\u00e2\3\2\2\2\u00e4,\3\2\2\2\u00e5\u00e6\5/\30\2\u00e6\u00e8"+
		"\7\60\2\2\u00e7\u00e9\5\63\32\2\u00e8\u00e7\3\2\2\2\u00e8\u00e9\3\2\2"+
		"\2\u00e9\u00eb\3\2\2\2\u00ea\u00ec\5\67\34\2\u00eb\u00ea\3\2\2\2\u00eb"+
		"\u00ec\3\2\2\2\u00ec\u00f7\3\2\2\2\u00ed\u00ee\7\60\2\2\u00ee\u00f0\5"+
		"\63\32\2\u00ef\u00f1\5\67\34\2\u00f0\u00ef\3\2\2\2\u00f0\u00f1\3\2\2\2"+
		"\u00f1\u00f7\3\2\2\2\u00f2\u00f4\5/\30\2\u00f3\u00f5\5\67\34\2\u00f4\u00f3"+
		"\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f7\3\2\2\2\u00f6\u00e5\3\2\2\2\u00f6"+
		"\u00ed\3\2\2\2\u00f6\u00f2\3\2\2\2\u00f7.\3\2\2\2\u00f8\u00fe\t\16\2\2"+
		"\u00f9\u00fb\5\65\33\2\u00fa\u00fc\5\63\32\2\u00fb\u00fa\3\2\2\2\u00fb"+
		"\u00fc\3\2\2\2\u00fc\u00fe\3\2\2\2\u00fd\u00f8\3\2\2\2\u00fd\u00f9\3\2"+
		"\2\2\u00fe\60\3\2\2\2\u00ff\u0100\t\2\2\2\u0100\62\3\2\2\2\u0101\u0103"+
		"\t\2\2\2\u0102\u0101\3\2\2\2\u0103\u0106\3\2\2\2\u0104\u0102\3\2\2\2\u0104"+
		"\u0105\3\2\2\2\u0105\64\3\2\2\2\u0106\u0104\3\2\2\2\u0107\u0108\t\17\2"+
		"\2\u0108\66\3\2\2\2\u0109\u010a\59\35\2\u010a\u010b\5;\36\2\u010b8\3\2"+
		"\2\2\u010c\u010d\t\20\2\2\u010d:\3\2\2\2\u010e\u0114\5\63\32\2\u010f\u0110"+
		"\7-\2\2\u0110\u0114\5\63\32\2\u0111\u0112\7/\2\2\u0112\u0114\5\63\32\2"+
		"\u0113\u010e\3\2\2\2\u0113\u010f\3\2\2\2\u0113\u0111\3\2\2\2\u0114<\3"+
		"\2\2\2\u0115\u0116\t\16\2\2\u0116\u0118\t\21\2\2\u0117\u0119\5? \2\u0118"+
		"\u0117\3\2\2\2\u0119\u011a\3\2\2\2\u011a\u0118\3\2\2\2\u011a\u011b\3\2"+
		"\2\2\u011b\u0124\3\2\2\2\u011c\u011d\t\16\2\2\u011d\u011f\t\22\2\2\u011e"+
		"\u0120\5? \2\u011f\u011e\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u011f\3\2\2"+
		"\2\u0121\u0122\3\2\2\2\u0122\u0124\3\2\2\2\u0123\u0115\3\2\2\2\u0123\u011c"+
		"\3\2\2\2\u0124>\3\2\2\2\u0125\u0126\t\23\2\2\u0126@\3\2\2\2\u0127\u0128"+
		"\5\33\16\2\u0128B\3\2\2\2\u0129\u012c\5i\65\2\u012a\u012c\5k\66\2\u012b"+
		"\u0129\3\2\2\2\u012b\u012a\3\2\2\2\u012cD\3\2\2\2\u012d\u012e\5m\67\2"+
		"\u012eF\3\2\2\2\u012f\u0130\5+\26\2\u0130H\3\2\2\2\u0131\u0132\t\24\2"+
		"\2\u0132J\3\2\2\2\u0133\u0134\t\25\2\2\u0134L\3\2\2\2\u0135\u0136\t\26"+
		"\2\2\u0136N\3\2\2\2\u0137\u0138\t\27\2\2\u0138P\3\2\2\2\u0139\u013a\t"+
		"\30\2\2\u013aR\3\2\2\2\u013b\u013c\t\31\2\2\u013cT\3\2\2\2\u013d\u013e"+
		"\t\32\2\2\u013eV\3\2\2\2\u013f\u0140\t\33\2\2\u0140X\3\2\2\2\u0141\u0142"+
		"\t\34\2\2\u0142Z\3\2\2\2\u0143\u0144\t\35\2\2\u0144\\\3\2\2\2\u0145\u0146"+
		"\t\36\2\2\u0146^\3\2\2\2\u0147\u0148\t\27\2\2\u0148\u0149\t\27\2\2\u0149"+
		"`\3\2\2\2\u014a\u014b\t\37\2\2\u014bb\3\2\2\2\u014c\u014d\t \2\2\u014d"+
		"d\3\2\2\2\u014e\u014f\7e\2\2\u014f\u0150\7q\2\2\u0150\u0151\7p\2\2\u0151"+
		"\u0152\7u\2\2\u0152\u0153\7q\2\2\u0153\u0154\7n\2\2\u0154\u0155\7g\2\2"+
		"\u0155\u0156\7\60\2\2\u0156\u0157\7n\2\2\u0157\u0158\7q\2\2\u0158\u0159"+
		"\7i\2\2\u0159f\3\2\2\2\u015a\u015b\7x\2\2\u015b\u015c\7c\2\2\u015c\u015d"+
		"\7t\2\2\u015dh\3\2\2\2\u015e\u015f\7v\2\2\u015f\u0160\7t\2\2\u0160\u0161"+
		"\7w\2\2\u0161\u0162\7g\2\2\u0162j\3\2\2\2\u0163\u0164\7h\2\2\u0164\u0165"+
		"\7c\2\2\u0165\u0166\7n\2\2\u0166\u0167\7u\2\2\u0167\u0168\7g\2\2\u0168"+
		"l\3\2\2\2\u0169\u016a\7p\2\2\u016a\u016b\7w\2\2\u016b\u016c\7n\2\2\u016c"+
		"\u016d\7n\2\2\u016dn\3\2\2\2\u016e\u016f\7y\2\2\u016f\u0170\7j\2\2\u0170"+
		"\u0171\7k\2\2\u0171\u0172\7n\2\2\u0172\u0173\7g\2\2\u0173p\3\2\2\2\u0174"+
		"\u0175\7e\2\2\u0175\u0176\7q\2\2\u0176\u0177\7p\2\2\u0177\u0178\7v\2\2"+
		"\u0178\u0179\7k\2\2\u0179\u017a\7p\2\2\u017a\u017b\7w\2\2\u017b\u017c"+
		"\7g\2\2\u017cr\3\2\2\2\u017d\u017e\7d\2\2\u017e\u017f\7t\2\2\u017f\u0180"+
		"\7g\2\2\u0180\u0181\7c\2\2\u0181\u0182\7m\2\2\u0182t\3\2\2\2\u0183\u0184"+
		"\7k\2\2\u0184\u0185\7h\2\2\u0185v\3\2\2\2\u0186\u0187\7g\2\2\u0187\u0188"+
		"\7n\2\2\u0188\u0189\7u\2\2\u0189\u018a\7g\2\2\u018ax\3\2\2\2\u018b\u018c"+
		"\7v\2\2\u018c\u018d\7j\2\2\u018d\u018e\7t\2\2\u018e\u018f\7q\2\2\u018f"+
		"\u0190\7y\2\2\u0190z\3\2\2\2\u0191\u0192\7h\2\2\u0192\u0193\7k\2\2\u0193"+
		"\u0194\7p\2\2\u0194\u0195\7c\2\2\u0195\u0196\7n\2\2\u0196\u0197\7n\2\2"+
		"\u0197\u0198\7{\2\2\u0198|\3\2\2\2\u0199\u019a\7v\2\2\u019a\u019b\7t\2"+
		"\2\u019b\u019c\7{\2\2\u019c~\3\2\2\2\u019d\u019e\7e\2\2\u019e\u019f\7"+
		"c\2\2\u019f\u01a0\7v\2\2\u01a0\u01a1\7e\2\2\u01a1\u01a2\7j\2\2\u01a2\u0080"+
		"\3\2\2\2\u01a3\u01a4\7p\2\2\u01a4\u01a5\7g\2\2\u01a5\u01a6\7y\2\2\u01a6"+
		"\u0082\3\2\2\2\u01a7\u01a8\7h\2\2\u01a8\u01a9\7w\2\2\u01a9\u01aa\7p\2"+
		"\2\u01aa\u01ab\7e\2\2\u01ab\u01ac\7v\2\2\u01ac\u01ad\7k\2\2\u01ad\u01ae"+
		"\7q\2\2\u01ae\u01af\7p\2\2\u01af\u0084\3\2\2\2\u01b0\u01b1\7t\2\2\u01b1"+
		"\u01b2\7g\2\2\u01b2\u01b3\7v\2\2\u01b3\u01b4\7w\2\2\u01b4\u01b5\7t\2\2"+
		"\u01b5\u01b6\7p\2\2\u01b6\u0086\3\2\2\2\u01b7\u01b8\7v\2\2\u01b8\u01b9"+
		"\7j\2\2\u01b9\u01ba\7k\2\2\u01ba\u01bb\7u\2\2\u01bb\u0088\3\2\2\2\u01bc"+
		"\u01bd\5\17\b\2\u01bd\u008a\3\2\2\2\u01be\u01c0\5\21\t\2\u01bf\u01be\3"+
		"\2\2\2\u01c0\u01c1\3\2\2\2\u01c1\u01bf\3\2\2\2\u01c1\u01c2\3\2\2\2\u01c2"+
		"\u01c3\3\2\2\2\u01c3\u01c4\bF\2\2\u01c4\u008c\3\2\2\2\36\2\u009d\u00a3"+
		"\u00ad\u00b2\u00b7\u00bd\u00c2\u00c5\u00c9\u00cd\u00d3\u00d9\u00e3\u00e8"+
		"\u00eb\u00f0\u00f4\u00f6\u00fb\u00fd\u0104\u0113\u011a\u0121\u0123\u012b"+
		"\u01c1\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}