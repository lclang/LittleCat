// Generated from C:/IdeaProjects/LittleCat/src/main/java/lclang\lclang.g4 by ANTLR 4.9.1
package lclang;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

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
		NULLABLE=18, TYPE_PREFIX=19, COMMA=20, SEMICOLON=21, ASSIGN=22, OR=23, 
		AND=24, NOT=25, LESS=26, LARGER=27, MULTYPLICATION=28, DIVISION=29, ADD=30, 
		MINUS=31, COLON=32, DOT=33, AS_ATTR=34, GLOBAL=35, METHOD=36, USE=37, 
		CLASS=38, FROM=39, COMPONENT=40, STOP=41, RETURN=42, WHILE=43, IF=44, 
		ELSE=45, NULL=46, BOOL=47, ID=48, STRING=49, CHAR=50, HEX_LONG=51, LONG=52, 
		DOUBLE=53, INTEGER=54, WS=55;
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
			"NULLABLE", "TYPE_PREFIX", "COMMA", "SEMICOLON", "ASSIGN", "OR", "AND", 
			"NOT", "LESS", "LARGER", "MULTYPLICATION", "DIVISION", "ADD", "MINUS", 
			"COLON", "DOT", "AS_ATTR", "GLOBAL", "METHOD", "USE", "CLASS", "FROM", 
			"COMPONENT", "STOP", "RETURN", "WHILE", "IF", "ELSE", "NULL", "BOOL", 
			"ID", "STRING", "CHAR", "HEX_LONG", "LONG", "DOUBLE", "INTEGER", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'('", "')'", "'{'", "'}'", "'['", "']'", "'**'", "'=='", 
			"'!='", "'&&'", "'||'", "'<='", "'>='", "'++'", "'--'", "'?'", "'\\'", 
			"','", "';'", "'='", "'|'", "'&'", "'!'", "'<'", "'>'", "'*'", "'/'", 
			"'+'", "'-'", "':'", "'.'", "'@'", "'global'", "'method'", "'use'", "'class'", 
			"'from'", "'component'", "'stop'", "'return'", "'while'", "'if'", "'else'", 
			"'null'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COMMENT", "LINE_COMMENT", "OPEN", "CLOSE", "OPEN_BRACE", "CLOSE_BRACE", 
			"OPEN_BRACKET", "CLOSE_BRACKET", "POW", "EQUALS", "NOT_EQUALS", "AND_BOOL", 
			"OR_BOOL", "LESS_EQUALS", "LARGER_EQUALS", "UNARY_ADD", "UNARY_MINUS", 
			"NULLABLE", "TYPE_PREFIX", "COMMA", "SEMICOLON", "ASSIGN", "OR", "AND", 
			"NOT", "LESS", "LARGER", "MULTYPLICATION", "DIVISION", "ADD", "MINUS", 
			"COLON", "DOT", "AS_ATTR", "GLOBAL", "METHOD", "USE", "CLASS", "FROM", 
			"COMPONENT", "STOP", "RETURN", "WHILE", "IF", "ELSE", "NULL", "BOOL", 
			"ID", "STRING", "CHAR", "HEX_LONG", "LONG", "DOUBLE", "INTEGER", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\29\u015d\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\3\2\3\2\3\2\3\2\6\2v\n\2\r\2\16"+
		"\2w\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\6\3\u0083\n\3\r\3\16\3\u0084\3"+
		"\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n"+
		"\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3"+
		"\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\24\3\24\3"+
		"\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3"+
		"\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3"+
		"$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'"+
		"\3\'\3(\3(\3(\3(\3(\3)\3)\3)\3)\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3+\3"+
		"+\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3,\3-\3-\3-\3.\3.\3.\3.\3.\3/\3/\3/\3"+
		"/\3/\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\5\60\u0123\n\60\3\61"+
		"\6\61\u0126\n\61\r\61\16\61\u0127\3\62\3\62\3\62\3\62\6\62\u012e\n\62"+
		"\r\62\16\62\u012f\3\62\5\62\u0133\n\62\3\63\3\63\3\63\3\63\3\64\3\64\6"+
		"\64\u013b\n\64\r\64\16\64\u013c\3\65\6\65\u0140\n\65\r\65\16\65\u0141"+
		"\3\65\3\65\3\66\7\66\u0147\n\66\f\66\16\66\u014a\13\66\3\66\3\66\6\66"+
		"\u014e\n\66\r\66\16\66\u014f\3\67\6\67\u0153\n\67\r\67\16\67\u0154\38"+
		"\68\u0158\n8\r8\168\u0159\38\38\5w\u0084\u012f\29\3\3\5\4\7\5\t\6\13\7"+
		"\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		")\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O"+
		")Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9\3\2\7\4\2\f\f\17\17"+
		"\5\2C\\aac|\4\2\63;CH\3\2\62;\5\2\13\f\17\17\"\"\2\u0168\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2"+
		"\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2"+
		"\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2"+
		"\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2"+
		"\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2"+
		"\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2"+
		"K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3"+
		"\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2"+
		"\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\3"+
		"q\3\2\2\2\5~\3\2\2\2\7\u008a\3\2\2\2\t\u008c\3\2\2\2\13\u008e\3\2\2\2"+
		"\r\u0090\3\2\2\2\17\u0092\3\2\2\2\21\u0094\3\2\2\2\23\u0096\3\2\2\2\25"+
		"\u0099\3\2\2\2\27\u009c\3\2\2\2\31\u009f\3\2\2\2\33\u00a2\3\2\2\2\35\u00a5"+
		"\3\2\2\2\37\u00a8\3\2\2\2!\u00ab\3\2\2\2#\u00ae\3\2\2\2%\u00b1\3\2\2\2"+
		"\'\u00b3\3\2\2\2)\u00b5\3\2\2\2+\u00b7\3\2\2\2-\u00b9\3\2\2\2/\u00bb\3"+
		"\2\2\2\61\u00bd\3\2\2\2\63\u00bf\3\2\2\2\65\u00c1\3\2\2\2\67\u00c3\3\2"+
		"\2\29\u00c5\3\2\2\2;\u00c7\3\2\2\2=\u00c9\3\2\2\2?\u00cb\3\2\2\2A\u00cd"+
		"\3\2\2\2C\u00cf\3\2\2\2E\u00d1\3\2\2\2G\u00d3\3\2\2\2I\u00da\3\2\2\2K"+
		"\u00e1\3\2\2\2M\u00e5\3\2\2\2O\u00eb\3\2\2\2Q\u00f0\3\2\2\2S\u00fa\3\2"+
		"\2\2U\u00ff\3\2\2\2W\u0106\3\2\2\2Y\u010c\3\2\2\2[\u010f\3\2\2\2]\u0114"+
		"\3\2\2\2_\u0122\3\2\2\2a\u0125\3\2\2\2c\u0132\3\2\2\2e\u0134\3\2\2\2g"+
		"\u0138\3\2\2\2i\u013f\3\2\2\2k\u0148\3\2\2\2m\u0152\3\2\2\2o\u0157\3\2"+
		"\2\2qr\7\61\2\2rs\7,\2\2su\3\2\2\2tv\13\2\2\2ut\3\2\2\2vw\3\2\2\2wx\3"+
		"\2\2\2wu\3\2\2\2xy\3\2\2\2yz\7,\2\2z{\7\61\2\2{|\3\2\2\2|}\b\2\2\2}\4"+
		"\3\2\2\2~\177\7\61\2\2\177\u0080\7\61\2\2\u0080\u0082\3\2\2\2\u0081\u0083"+
		"\13\2\2\2\u0082\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0085\3\2\2\2"+
		"\u0084\u0082\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0087\t\2\2\2\u0087\u0088"+
		"\3\2\2\2\u0088\u0089\b\3\2\2\u0089\6\3\2\2\2\u008a\u008b\7*\2\2\u008b"+
		"\b\3\2\2\2\u008c\u008d\7+\2\2\u008d\n\3\2\2\2\u008e\u008f\7}\2\2\u008f"+
		"\f\3\2\2\2\u0090\u0091\7\177\2\2\u0091\16\3\2\2\2\u0092\u0093\7]\2\2\u0093"+
		"\20\3\2\2\2\u0094\u0095\7_\2\2\u0095\22\3\2\2\2\u0096\u0097\7,\2\2\u0097"+
		"\u0098\7,\2\2\u0098\24\3\2\2\2\u0099\u009a\7?\2\2\u009a\u009b\7?\2\2\u009b"+
		"\26\3\2\2\2\u009c\u009d\7#\2\2\u009d\u009e\7?\2\2\u009e\30\3\2\2\2\u009f"+
		"\u00a0\7(\2\2\u00a0\u00a1\7(\2\2\u00a1\32\3\2\2\2\u00a2\u00a3\7~\2\2\u00a3"+
		"\u00a4\7~\2\2\u00a4\34\3\2\2\2\u00a5\u00a6\7>\2\2\u00a6\u00a7\7?\2\2\u00a7"+
		"\36\3\2\2\2\u00a8\u00a9\7@\2\2\u00a9\u00aa\7?\2\2\u00aa \3\2\2\2\u00ab"+
		"\u00ac\7-\2\2\u00ac\u00ad\7-\2\2\u00ad\"\3\2\2\2\u00ae\u00af\7/\2\2\u00af"+
		"\u00b0\7/\2\2\u00b0$\3\2\2\2\u00b1\u00b2\7A\2\2\u00b2&\3\2\2\2\u00b3\u00b4"+
		"\7^\2\2\u00b4(\3\2\2\2\u00b5\u00b6\7.\2\2\u00b6*\3\2\2\2\u00b7\u00b8\7"+
		"=\2\2\u00b8,\3\2\2\2\u00b9\u00ba\7?\2\2\u00ba.\3\2\2\2\u00bb\u00bc\7~"+
		"\2\2\u00bc\60\3\2\2\2\u00bd\u00be\7(\2\2\u00be\62\3\2\2\2\u00bf\u00c0"+
		"\7#\2\2\u00c0\64\3\2\2\2\u00c1\u00c2\7>\2\2\u00c2\66\3\2\2\2\u00c3\u00c4"+
		"\7@\2\2\u00c48\3\2\2\2\u00c5\u00c6\7,\2\2\u00c6:\3\2\2\2\u00c7\u00c8\7"+
		"\61\2\2\u00c8<\3\2\2\2\u00c9\u00ca\7-\2\2\u00ca>\3\2\2\2\u00cb\u00cc\7"+
		"/\2\2\u00cc@\3\2\2\2\u00cd\u00ce\7<\2\2\u00ceB\3\2\2\2\u00cf\u00d0\7\60"+
		"\2\2\u00d0D\3\2\2\2\u00d1\u00d2\7B\2\2\u00d2F\3\2\2\2\u00d3\u00d4\7i\2"+
		"\2\u00d4\u00d5\7n\2\2\u00d5\u00d6\7q\2\2\u00d6\u00d7\7d\2\2\u00d7\u00d8"+
		"\7c\2\2\u00d8\u00d9\7n\2\2\u00d9H\3\2\2\2\u00da\u00db\7o\2\2\u00db\u00dc"+
		"\7g\2\2\u00dc\u00dd\7v\2\2\u00dd\u00de\7j\2\2\u00de\u00df\7q\2\2\u00df"+
		"\u00e0\7f\2\2\u00e0J\3\2\2\2\u00e1\u00e2\7w\2\2\u00e2\u00e3\7u\2\2\u00e3"+
		"\u00e4\7g\2\2\u00e4L\3\2\2\2\u00e5\u00e6\7e\2\2\u00e6\u00e7\7n\2\2\u00e7"+
		"\u00e8\7c\2\2\u00e8\u00e9\7u\2\2\u00e9\u00ea\7u\2\2\u00eaN\3\2\2\2\u00eb"+
		"\u00ec\7h\2\2\u00ec\u00ed\7t\2\2\u00ed\u00ee\7q\2\2\u00ee\u00ef\7o\2\2"+
		"\u00efP\3\2\2\2\u00f0\u00f1\7e\2\2\u00f1\u00f2\7q\2\2\u00f2\u00f3\7o\2"+
		"\2\u00f3\u00f4\7r\2\2\u00f4\u00f5\7q\2\2\u00f5\u00f6\7p\2\2\u00f6\u00f7"+
		"\7g\2\2\u00f7\u00f8\7p\2\2\u00f8\u00f9\7v\2\2\u00f9R\3\2\2\2\u00fa\u00fb"+
		"\7u\2\2\u00fb\u00fc\7v\2\2\u00fc\u00fd\7q\2\2\u00fd\u00fe\7r\2\2\u00fe"+
		"T\3\2\2\2\u00ff\u0100\7t\2\2\u0100\u0101\7g\2\2\u0101\u0102\7v\2\2\u0102"+
		"\u0103\7w\2\2\u0103\u0104\7t\2\2\u0104\u0105\7p\2\2\u0105V\3\2\2\2\u0106"+
		"\u0107\7y\2\2\u0107\u0108\7j\2\2\u0108\u0109\7k\2\2\u0109\u010a\7n\2\2"+
		"\u010a\u010b\7g\2\2\u010bX\3\2\2\2\u010c\u010d\7k\2\2\u010d\u010e\7h\2"+
		"\2\u010eZ\3\2\2\2\u010f\u0110\7g\2\2\u0110\u0111\7n\2\2\u0111\u0112\7"+
		"u\2\2\u0112\u0113\7g\2\2\u0113\\\3\2\2\2\u0114\u0115\7p\2\2\u0115\u0116"+
		"\7w\2\2\u0116\u0117\7n\2\2\u0117\u0118\7n\2\2\u0118^\3\2\2\2\u0119\u011a"+
		"\7v\2\2\u011a\u011b\7t\2\2\u011b\u011c\7w\2\2\u011c\u0123\7g\2\2\u011d"+
		"\u011e\7h\2\2\u011e\u011f\7c\2\2\u011f\u0120\7n\2\2\u0120\u0121\7u\2\2"+
		"\u0121\u0123\7g\2\2\u0122\u0119\3\2\2\2\u0122\u011d\3\2\2\2\u0123`\3\2"+
		"\2\2\u0124\u0126\t\3\2\2\u0125\u0124\3\2\2\2\u0126\u0127\3\2\2\2\u0127"+
		"\u0125\3\2\2\2\u0127\u0128\3\2\2\2\u0128b\3\2\2\2\u0129\u012a\7$\2\2\u012a"+
		"\u0133\7$\2\2\u012b\u012d\7$\2\2\u012c\u012e\13\2\2\2\u012d\u012c\3\2"+
		"\2\2\u012e\u012f\3\2\2\2\u012f\u0130\3\2\2\2\u012f\u012d\3\2\2\2\u0130"+
		"\u0131\3\2\2\2\u0131\u0133\7$\2\2\u0132\u0129\3\2\2\2\u0132\u012b\3\2"+
		"\2\2\u0133d\3\2\2\2\u0134\u0135\7)\2\2\u0135\u0136\13\2\2\2\u0136\u0137"+
		"\7)\2\2\u0137f\3\2\2\2\u0138\u013a\7%\2\2\u0139\u013b\t\4\2\2\u013a\u0139"+
		"\3\2\2\2\u013b\u013c\3\2\2\2\u013c\u013a\3\2\2\2\u013c\u013d\3\2\2\2\u013d"+
		"h\3\2\2\2\u013e\u0140\t\5\2\2\u013f\u013e\3\2\2\2\u0140\u0141\3\2\2\2"+
		"\u0141\u013f\3\2\2\2\u0141\u0142\3\2\2\2\u0142\u0143\3\2\2\2\u0143\u0144"+
		"\7N\2\2\u0144j\3\2\2\2\u0145\u0147\t\5\2\2\u0146\u0145\3\2\2\2\u0147\u014a"+
		"\3\2\2\2\u0148\u0146\3\2\2\2\u0148\u0149\3\2\2\2\u0149\u014b\3\2\2\2\u014a"+
		"\u0148\3\2\2\2\u014b\u014d\7\60\2\2\u014c\u014e\t\5\2\2\u014d\u014c\3"+
		"\2\2\2\u014e\u014f\3\2\2\2\u014f\u014d\3\2\2\2\u014f\u0150\3\2\2\2\u0150"+
		"l\3\2\2\2\u0151\u0153\t\5\2\2\u0152\u0151\3\2\2\2\u0153\u0154\3\2\2\2"+
		"\u0154\u0152\3\2\2\2\u0154\u0155\3\2\2\2\u0155n\3\2\2\2\u0156\u0158\t"+
		"\6\2\2\u0157\u0156\3\2\2\2\u0158\u0159\3\2\2\2\u0159\u0157\3\2\2\2\u0159"+
		"\u015a\3\2\2\2\u015a\u015b\3\2\2\2\u015b\u015c\b8\2\2\u015cp\3\2\2\2\17"+
		"\2w\u0084\u0122\u0127\u012f\u0132\u013c\u0141\u0148\u014f\u0154\u0159"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}