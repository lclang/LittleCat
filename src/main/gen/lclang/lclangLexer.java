// Generated from C:/IdeaProjects/LittleCat/src/main/java/lclang\lclang.g4 by ANTLR 4.9.1
package lclang;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class lclangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMMENT=1, LINE_COMMENT=2, OPEN=3, CLOSE=4, OPEN_BRACE=5, CLOSE_BRACE=6, 
		OPEN_BRACKET=7, CLOSE_BRACKET=8, POW=9, EQUALS=10, NOT_EQUALS=11, AND_BOOL=12, 
		OR_BOOL=13, LESS_EQUALS=14, LARGER_EQUALS=15, UNARY_ADD=16, UNARY_MINUS=17, 
		NULLABLE_OR=18, NULLABLE=19, LAMBDA_PREFIX=20, TYPE_PREFIX=21, COMMA=22, 
		SEMICOLON=23, ASSIGN=24, OR=25, AND=26, NOT=27, LESS=28, LARGER=29, MULTYPLICATION=30, 
		DIVISION=31, ADD=32, MINUS=33, COLON=34, DOT=35, AS_ATTR=36, GLOBAL=37, 
		METHOD=38, USE=39, CLASS=40, FROM=41, COMPONENT=42, STOP=43, RETURN=44, 
		WHILE=45, IF=46, ELSE=47, NULL=48, BOOL=49, ID=50, STRING=51, CHAR=52, 
		HEX_LONG=53, LONG=54, DOUBLE=55, INTEGER=56, WS=57;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"COMMENT", "LINE_COMMENT", "OPEN", "CLOSE", "OPEN_BRACE", "CLOSE_BRACE", 
			"OPEN_BRACKET", "CLOSE_BRACKET", "POW", "EQUALS", "NOT_EQUALS", "AND_BOOL", 
			"OR_BOOL", "LESS_EQUALS", "LARGER_EQUALS", "UNARY_ADD", "UNARY_MINUS", 
			"NULLABLE_OR", "NULLABLE", "LAMBDA_PREFIX", "TYPE_PREFIX", "COMMA", "SEMICOLON", 
			"ASSIGN", "OR", "AND", "NOT", "LESS", "LARGER", "MULTYPLICATION", "DIVISION", 
			"ADD", "MINUS", "COLON", "DOT", "AS_ATTR", "GLOBAL", "METHOD", "USE", 
			"CLASS", "FROM", "COMPONENT", "STOP", "RETURN", "WHILE", "IF", "ELSE", 
			"NULL", "BOOL", "ID", "STRING", "CHAR", "HEX_LONG", "LONG", "DOUBLE", 
			"INTEGER", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'('", "')'", "'{'", "'}'", "'['", "']'", "'**'", "'=='", 
			"'!='", "'&&'", "'||'", "'<='", "'>='", "'++'", "'--'", "'?:'", "'?'", 
			"'->'", "'\\'", "','", "';'", "'='", "'|'", "'&'", "'!'", "'<'", "'>'", 
			"'*'", "'/'", "'+'", "'-'", "':'", "'.'", "'@'", "'global'", "'method'", 
			"'use'", "'class'", "'from'", "'component'", "'stop'", "'return'", "'while'", 
			"'if'", "'else'", "'null'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COMMENT", "LINE_COMMENT", "OPEN", "CLOSE", "OPEN_BRACE", "CLOSE_BRACE", 
			"OPEN_BRACKET", "CLOSE_BRACKET", "POW", "EQUALS", "NOT_EQUALS", "AND_BOOL", 
			"OR_BOOL", "LESS_EQUALS", "LARGER_EQUALS", "UNARY_ADD", "UNARY_MINUS", 
			"NULLABLE_OR", "NULLABLE", "LAMBDA_PREFIX", "TYPE_PREFIX", "COMMA", "SEMICOLON", 
			"ASSIGN", "OR", "AND", "NOT", "LESS", "LARGER", "MULTYPLICATION", "DIVISION", 
			"ADD", "MINUS", "COLON", "DOT", "AS_ATTR", "GLOBAL", "METHOD", "USE", 
			"CLASS", "FROM", "COMPONENT", "STOP", "RETURN", "WHILE", "IF", "ELSE", 
			"NULL", "BOOL", "ID", "STRING", "CHAR", "HEX_LONG", "LONG", "DOUBLE", 
			"INTEGER", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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


	public lclangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "lclang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2;\u0172\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\3\2\3\2\3\2\3\2\6"+
		"\2z\n\2\r\2\16\2{\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\6\3\u0087\n\3\r"+
		"\3\16\3\u0088\3\3\5\3\u008c\n\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3"+
		"\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r"+
		"\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22"+
		"\3\22\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\30"+
		"\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37"+
		"\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3&\3&\3&\3&\3&\3\'\3"+
		"\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3"+
		"+\3+\3+\3+\3+\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3-\3-\3-\3-\3-\3-\3-\3.\3"+
		".\3.\3.\3.\3.\3/\3/\3/\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\61\3"+
		"\61\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\3\62\5\62\u012e\n\62\3\63"+
		"\6\63\u0131\n\63\r\63\16\63\u0132\3\64\3\64\7\64\u0137\n\64\f\64\16\64"+
		"\u013a\13\64\3\64\3\64\3\65\3\65\3\65\3\65\3\66\3\66\6\66\u0144\n\66\r"+
		"\66\16\66\u0145\3\67\3\67\3\67\6\67\u014b\n\67\r\67\16\67\u014c\5\67\u014f"+
		"\n\67\3\67\3\67\38\38\38\78\u0156\n8\f8\168\u0159\138\58\u015b\n8\38\3"+
		"8\68\u015f\n8\r8\168\u0160\39\39\39\69\u0166\n9\r9\169\u0167\59\u016a"+
		"\n9\3:\6:\u016d\n:\r:\16:\u016e\3:\3:\4{\u0088\2;\3\3\5\4\7\5\t\6\13\7"+
		"\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		")\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O"+
		")Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;\3\2\t\4\3\f\f\17"+
		"\17\5\2C\\aac|\3\2$$\4\2\63;CH\3\2\62;\3\2\63;\5\2\13\f\17\17\"\"\2\u017f"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2"+
		"\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2"+
		"U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3"+
		"\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2"+
		"\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\3u\3\2\2\2\5\u0082\3\2\2\2\7\u008f"+
		"\3\2\2\2\t\u0091\3\2\2\2\13\u0093\3\2\2\2\r\u0095\3\2\2\2\17\u0097\3\2"+
		"\2\2\21\u0099\3\2\2\2\23\u009b\3\2\2\2\25\u009e\3\2\2\2\27\u00a1\3\2\2"+
		"\2\31\u00a4\3\2\2\2\33\u00a7\3\2\2\2\35\u00aa\3\2\2\2\37\u00ad\3\2\2\2"+
		"!\u00b0\3\2\2\2#\u00b3\3\2\2\2%\u00b6\3\2\2\2\'\u00b9\3\2\2\2)\u00bb\3"+
		"\2\2\2+\u00be\3\2\2\2-\u00c0\3\2\2\2/\u00c2\3\2\2\2\61\u00c4\3\2\2\2\63"+
		"\u00c6\3\2\2\2\65\u00c8\3\2\2\2\67\u00ca\3\2\2\29\u00cc\3\2\2\2;\u00ce"+
		"\3\2\2\2=\u00d0\3\2\2\2?\u00d2\3\2\2\2A\u00d4\3\2\2\2C\u00d6\3\2\2\2E"+
		"\u00d8\3\2\2\2G\u00da\3\2\2\2I\u00dc\3\2\2\2K\u00de\3\2\2\2M\u00e5\3\2"+
		"\2\2O\u00ec\3\2\2\2Q\u00f0\3\2\2\2S\u00f6\3\2\2\2U\u00fb\3\2\2\2W\u0105"+
		"\3\2\2\2Y\u010a\3\2\2\2[\u0111\3\2\2\2]\u0117\3\2\2\2_\u011a\3\2\2\2a"+
		"\u011f\3\2\2\2c\u012d\3\2\2\2e\u0130\3\2\2\2g\u0134\3\2\2\2i\u013d\3\2"+
		"\2\2k\u0141\3\2\2\2m\u014e\3\2\2\2o\u015a\3\2\2\2q\u0169\3\2\2\2s\u016c"+
		"\3\2\2\2uv\7\61\2\2vw\7,\2\2wy\3\2\2\2xz\13\2\2\2yx\3\2\2\2z{\3\2\2\2"+
		"{|\3\2\2\2{y\3\2\2\2|}\3\2\2\2}~\7,\2\2~\177\7\61\2\2\177\u0080\3\2\2"+
		"\2\u0080\u0081\b\2\2\2\u0081\4\3\2\2\2\u0082\u0083\7\61\2\2\u0083\u0084"+
		"\7\61\2\2\u0084\u0086\3\2\2\2\u0085\u0087\13\2\2\2\u0086\u0085\3\2\2\2"+
		"\u0087\u0088\3\2\2\2\u0088\u0089\3\2\2\2\u0088\u0086\3\2\2\2\u0089\u008b"+
		"\3\2\2\2\u008a\u008c\t\2\2\2\u008b\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d"+
		"\u008e\b\3\2\2\u008e\6\3\2\2\2\u008f\u0090\7*\2\2\u0090\b\3\2\2\2\u0091"+
		"\u0092\7+\2\2\u0092\n\3\2\2\2\u0093\u0094\7}\2\2\u0094\f\3\2\2\2\u0095"+
		"\u0096\7\177\2\2\u0096\16\3\2\2\2\u0097\u0098\7]\2\2\u0098\20\3\2\2\2"+
		"\u0099\u009a\7_\2\2\u009a\22\3\2\2\2\u009b\u009c\7,\2\2\u009c\u009d\7"+
		",\2\2\u009d\24\3\2\2\2\u009e\u009f\7?\2\2\u009f\u00a0\7?\2\2\u00a0\26"+
		"\3\2\2\2\u00a1\u00a2\7#\2\2\u00a2\u00a3\7?\2\2\u00a3\30\3\2\2\2\u00a4"+
		"\u00a5\7(\2\2\u00a5\u00a6\7(\2\2\u00a6\32\3\2\2\2\u00a7\u00a8\7~\2\2\u00a8"+
		"\u00a9\7~\2\2\u00a9\34\3\2\2\2\u00aa\u00ab\7>\2\2\u00ab\u00ac\7?\2\2\u00ac"+
		"\36\3\2\2\2\u00ad\u00ae\7@\2\2\u00ae\u00af\7?\2\2\u00af \3\2\2\2\u00b0"+
		"\u00b1\7-\2\2\u00b1\u00b2\7-\2\2\u00b2\"\3\2\2\2\u00b3\u00b4\7/\2\2\u00b4"+
		"\u00b5\7/\2\2\u00b5$\3\2\2\2\u00b6\u00b7\7A\2\2\u00b7\u00b8\7<\2\2\u00b8"+
		"&\3\2\2\2\u00b9\u00ba\7A\2\2\u00ba(\3\2\2\2\u00bb\u00bc\7/\2\2\u00bc\u00bd"+
		"\7@\2\2\u00bd*\3\2\2\2\u00be\u00bf\7^\2\2\u00bf,\3\2\2\2\u00c0\u00c1\7"+
		".\2\2\u00c1.\3\2\2\2\u00c2\u00c3\7=\2\2\u00c3\60\3\2\2\2\u00c4\u00c5\7"+
		"?\2\2\u00c5\62\3\2\2\2\u00c6\u00c7\7~\2\2\u00c7\64\3\2\2\2\u00c8\u00c9"+
		"\7(\2\2\u00c9\66\3\2\2\2\u00ca\u00cb\7#\2\2\u00cb8\3\2\2\2\u00cc\u00cd"+
		"\7>\2\2\u00cd:\3\2\2\2\u00ce\u00cf\7@\2\2\u00cf<\3\2\2\2\u00d0\u00d1\7"+
		",\2\2\u00d1>\3\2\2\2\u00d2\u00d3\7\61\2\2\u00d3@\3\2\2\2\u00d4\u00d5\7"+
		"-\2\2\u00d5B\3\2\2\2\u00d6\u00d7\7/\2\2\u00d7D\3\2\2\2\u00d8\u00d9\7<"+
		"\2\2\u00d9F\3\2\2\2\u00da\u00db\7\60\2\2\u00dbH\3\2\2\2\u00dc\u00dd\7"+
		"B\2\2\u00ddJ\3\2\2\2\u00de\u00df\7i\2\2\u00df\u00e0\7n\2\2\u00e0\u00e1"+
		"\7q\2\2\u00e1\u00e2\7d\2\2\u00e2\u00e3\7c\2\2\u00e3\u00e4\7n\2\2\u00e4"+
		"L\3\2\2\2\u00e5\u00e6\7o\2\2\u00e6\u00e7\7g\2\2\u00e7\u00e8\7v\2\2\u00e8"+
		"\u00e9\7j\2\2\u00e9\u00ea\7q\2\2\u00ea\u00eb\7f\2\2\u00ebN\3\2\2\2\u00ec"+
		"\u00ed\7w\2\2\u00ed\u00ee\7u\2\2\u00ee\u00ef\7g\2\2\u00efP\3\2\2\2\u00f0"+
		"\u00f1\7e\2\2\u00f1\u00f2\7n\2\2\u00f2\u00f3\7c\2\2\u00f3\u00f4\7u\2\2"+
		"\u00f4\u00f5\7u\2\2\u00f5R\3\2\2\2\u00f6\u00f7\7h\2\2\u00f7\u00f8\7t\2"+
		"\2\u00f8\u00f9\7q\2\2\u00f9\u00fa\7o\2\2\u00faT\3\2\2\2\u00fb\u00fc\7"+
		"e\2\2\u00fc\u00fd\7q\2\2\u00fd\u00fe\7o\2\2\u00fe\u00ff\7r\2\2\u00ff\u0100"+
		"\7q\2\2\u0100\u0101\7p\2\2\u0101\u0102\7g\2\2\u0102\u0103\7p\2\2\u0103"+
		"\u0104\7v\2\2\u0104V\3\2\2\2\u0105\u0106\7u\2\2\u0106\u0107\7v\2\2\u0107"+
		"\u0108\7q\2\2\u0108\u0109\7r\2\2\u0109X\3\2\2\2\u010a\u010b\7t\2\2\u010b"+
		"\u010c\7g\2\2\u010c\u010d\7v\2\2\u010d\u010e\7w\2\2\u010e\u010f\7t\2\2"+
		"\u010f\u0110\7p\2\2\u0110Z\3\2\2\2\u0111\u0112\7y\2\2\u0112\u0113\7j\2"+
		"\2\u0113\u0114\7k\2\2\u0114\u0115\7n\2\2\u0115\u0116\7g\2\2\u0116\\\3"+
		"\2\2\2\u0117\u0118\7k\2\2\u0118\u0119\7h\2\2\u0119^\3\2\2\2\u011a\u011b"+
		"\7g\2\2\u011b\u011c\7n\2\2\u011c\u011d\7u\2\2\u011d\u011e\7g\2\2\u011e"+
		"`\3\2\2\2\u011f\u0120\7p\2\2\u0120\u0121\7w\2\2\u0121\u0122\7n\2\2\u0122"+
		"\u0123\7n\2\2\u0123b\3\2\2\2\u0124\u0125\7v\2\2\u0125\u0126\7t\2\2\u0126"+
		"\u0127\7w\2\2\u0127\u012e\7g\2\2\u0128\u0129\7h\2\2\u0129\u012a\7c\2\2"+
		"\u012a\u012b\7n\2\2\u012b\u012c\7u\2\2\u012c\u012e\7g\2\2\u012d\u0124"+
		"\3\2\2\2\u012d\u0128\3\2\2\2\u012ed\3\2\2\2\u012f\u0131\t\3\2\2\u0130"+
		"\u012f\3\2\2\2\u0131\u0132\3\2\2\2\u0132\u0130\3\2\2\2\u0132\u0133\3\2"+
		"\2\2\u0133f\3\2\2\2\u0134\u0138\7$\2\2\u0135\u0137\n\4\2\2\u0136\u0135"+
		"\3\2\2\2\u0137\u013a\3\2\2\2\u0138\u0136\3\2\2\2\u0138\u0139\3\2\2\2\u0139"+
		"\u013b\3\2\2\2\u013a\u0138\3\2\2\2\u013b\u013c\7$\2\2\u013ch\3\2\2\2\u013d"+
		"\u013e\7)\2\2\u013e\u013f\13\2\2\2\u013f\u0140\7)\2\2\u0140j\3\2\2\2\u0141"+
		"\u0143\7%\2\2\u0142\u0144\t\5\2\2\u0143\u0142\3\2\2\2\u0144\u0145\3\2"+
		"\2\2\u0145\u0143\3\2\2\2\u0145\u0146\3\2\2\2\u0146l\3\2\2\2\u0147\u014f"+
		"\t\6\2\2\u0148\u014a\t\7\2\2\u0149\u014b\t\6\2\2\u014a\u0149\3\2\2\2\u014b"+
		"\u014c\3\2\2\2\u014c\u014a\3\2\2\2\u014c\u014d\3\2\2\2\u014d\u014f\3\2"+
		"\2\2\u014e\u0147\3\2\2\2\u014e\u0148\3\2\2\2\u014f\u0150\3\2\2\2\u0150"+
		"\u0151\7N\2\2\u0151n\3\2\2\2\u0152\u015b\t\6\2\2\u0153\u0157\t\7\2\2\u0154"+
		"\u0156\t\6\2\2\u0155\u0154\3\2\2\2\u0156\u0159\3\2\2\2\u0157\u0155\3\2"+
		"\2\2\u0157\u0158\3\2\2\2\u0158\u015b\3\2\2\2\u0159\u0157\3\2\2\2\u015a"+
		"\u0152\3\2\2\2\u015a\u0153\3\2\2\2\u015b\u015c\3\2\2\2\u015c\u015e\7\60"+
		"\2\2\u015d\u015f\t\6\2\2\u015e\u015d\3\2\2\2\u015f\u0160\3\2\2\2\u0160"+
		"\u015e\3\2\2\2\u0160\u0161\3\2\2\2\u0161p\3\2\2\2\u0162\u016a\t\6\2\2"+
		"\u0163\u0165\t\7\2\2\u0164\u0166\t\6\2\2\u0165\u0164\3\2\2\2\u0166\u0167"+
		"\3\2\2\2\u0167\u0165\3\2\2\2\u0167\u0168\3\2\2\2\u0168\u016a\3\2\2\2\u0169"+
		"\u0162\3\2\2\2\u0169\u0163\3\2\2\2\u016ar\3\2\2\2\u016b\u016d\t\b\2\2"+
		"\u016c\u016b\3\2\2\2\u016d\u016e\3\2\2\2\u016e\u016c\3\2\2\2\u016e\u016f"+
		"\3\2\2\2\u016f\u0170\3\2\2\2\u0170\u0171\b:\2\2\u0171t\3\2\2\2\22\2{\u0088"+
		"\u008b\u012d\u0132\u0138\u0145\u014c\u014e\u0157\u015a\u0160\u0167\u0169"+
		"\u016e\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}