// Generated from C:/IdeaProjects/LittleCat/lclang/src/main/java/lclang\lclang.g4 by ANTLR 4.9.1
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
		T__0=1, T__1=2, T__2=3, COMMENT=4, LINE_COMMENT=5, OPEN=6, CLOSE=7, OPEN_BRACE=8, 
		CLOSE_BRACE=9, OPEN_BRACKET=10, CLOSE_BRACKET=11, POW=12, EQUALS=13, NOT_EQUALS=14, 
		AND_BOOL=15, OR_BOOL=16, LESS_EQUALS=17, LARGER_EQUALS=18, UNARY_ADD=19, 
		UNARY_MINUS=20, NULLABLE_OR=21, NULLABLE=22, LAMBDA_PREFIX=23, TYPE_PREFIX=24, 
		COMMA=25, SEMICOLON=26, ASSIGN=27, OR=28, AND=29, NOT=30, LESS=31, LARGER=32, 
		MULTIPLICATION=33, DIVISION=34, ADD=35, MINUS=36, COLON=37, DOT=38, AS_ATTR=39, 
		GLOBAL=40, METHOD=41, USE=42, CLASS=43, FROM=44, EXTENDS=45, COMPONENT=46, 
		STOP=47, RETURN=48, WHILE=49, AS=50, IF=51, IS=52, ELSE=53, BOOL=54, ID=55, 
		STRING=56, CHAR=57, HEX_LONG=58, LONG=59, DOUBLE=60, INTEGER=61, WS=62;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "COMMENT", "LINE_COMMENT", "OPEN", "CLOSE", "OPEN_BRACE", 
			"CLOSE_BRACE", "OPEN_BRACKET", "CLOSE_BRACKET", "POW", "EQUALS", "NOT_EQUALS", 
			"AND_BOOL", "OR_BOOL", "LESS_EQUALS", "LARGER_EQUALS", "UNARY_ADD", "UNARY_MINUS", 
			"NULLABLE_OR", "NULLABLE", "LAMBDA_PREFIX", "TYPE_PREFIX", "COMMA", "SEMICOLON", 
			"ASSIGN", "OR", "AND", "NOT", "LESS", "LARGER", "MULTIPLICATION", "DIVISION", 
			"ADD", "MINUS", "COLON", "DOT", "AS_ATTR", "GLOBAL", "METHOD", "USE", 
			"CLASS", "FROM", "EXTENDS", "COMPONENT", "STOP", "RETURN", "WHILE", "AS", 
			"IF", "IS", "ELSE", "BOOL", "ID", "STRING", "CHAR", "HEX_LONG", "LONG", 
			"DOUBLE", "INTEGER", "WS", "ESC", "UNICODE", "HEX"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'any'", "'void'", "'callable'", null, null, "'('", "')'", "'{'", 
			"'}'", "'['", "']'", "'**'", "'=='", "'!='", "'&&'", "'||'", "'<='", 
			"'>='", "'++'", "'--'", "'?:'", "'?'", "'->'", "'\\'", "','", "';'", 
			"'='", "'|'", "'&'", "'!'", "'<'", "'>'", "'*'", "'/'", "'+'", "'-'", 
			"':'", "'.'", "'@'", "'global'", "'method'", "'use'", "'class'", "'from'", 
			"'extends'", "'component'", "'stop'", "'return'", "'while'", "'as'", 
			"'if'", "'is'", "'else'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "COMMENT", "LINE_COMMENT", "OPEN", "CLOSE", "OPEN_BRACE", 
			"CLOSE_BRACE", "OPEN_BRACKET", "CLOSE_BRACKET", "POW", "EQUALS", "NOT_EQUALS", 
			"AND_BOOL", "OR_BOOL", "LESS_EQUALS", "LARGER_EQUALS", "UNARY_ADD", "UNARY_MINUS", 
			"NULLABLE_OR", "NULLABLE", "LAMBDA_PREFIX", "TYPE_PREFIX", "COMMA", "SEMICOLON", 
			"ASSIGN", "OR", "AND", "NOT", "LESS", "LARGER", "MULTIPLICATION", "DIVISION", 
			"ADD", "MINUS", "COLON", "DOT", "AS_ATTR", "GLOBAL", "METHOD", "USE", 
			"CLASS", "FROM", "EXTENDS", "COMPONENT", "STOP", "RETURN", "WHILE", "AS", 
			"IF", "IS", "ELSE", "BOOL", "ID", "STRING", "CHAR", "HEX_LONG", "LONG", 
			"DOUBLE", "INTEGER", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2@\u01ae\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\6\5\u009c\n\5\r\5\16"+
		"\5\u009d\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\6\6\u00a9\n\6\r\6\16\6\u00aa"+
		"\3\6\5\6\u00ae\n\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3"+
		"\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3"+
		"\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3"+
		"\26\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3"+
		"\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3"+
		"$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3*\3*"+
		"\3+\3+\3+\3+\3,\3,\3,\3,\3,\3,\3-\3-\3-\3-\3-\3.\3.\3.\3.\3.\3.\3.\3."+
		"\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3\61"+
		"\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\64"+
		"\3\64\3\64\3\65\3\65\3\65\3\66\3\66\3\66\3\66\3\66\3\67\3\67\3\67\3\67"+
		"\3\67\3\67\3\67\3\67\3\67\5\67\u0159\n\67\38\68\u015c\n8\r8\168\u015d"+
		"\39\39\39\79\u0163\n9\f9\169\u0166\139\39\39\3:\3:\3:\5:\u016d\n:\3:\3"+
		":\3;\3;\6;\u0173\n;\r;\16;\u0174\3<\3<\3<\6<\u017a\n<\r<\16<\u017b\5<"+
		"\u017e\n<\3<\3<\3=\3=\3=\7=\u0185\n=\f=\16=\u0188\13=\5=\u018a\n=\3=\3"+
		"=\6=\u018e\n=\r=\16=\u018f\3>\3>\3>\6>\u0195\n>\r>\16>\u0196\5>\u0199"+
		"\n>\3?\6?\u019c\n?\r?\16?\u019d\3?\3?\3@\3@\3@\5@\u01a5\n@\3A\3A\3A\3"+
		"A\3A\3A\3B\3B\4\u009d\u00aa\2C\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13"+
		"\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61"+
		"\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61"+
		"a\62c\63e\64g\65i\66k\67m8o9q:s;u<w=y>{?}@\177\2\u0081\2\u0083\2\3\2\13"+
		"\4\3\f\f\17\17\5\2C\\aac|\4\2$$^^\4\2))^^\3\2\62;\3\2\63;\5\2\13\f\17"+
		"\17\"\"\n\2$$))\61\61^^ddppttvv\4\2\62;Ch\2\u01bb\2\3\3\2\2\2\2\5\3\2"+
		"\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3"+
		"\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2"+
		"\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2"+
		"Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3"+
		"\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2"+
		"\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\3"+
		"\u0085\3\2\2\2\5\u0089\3\2\2\2\7\u008e\3\2\2\2\t\u0097\3\2\2\2\13\u00a4"+
		"\3\2\2\2\r\u00b1\3\2\2\2\17\u00b3\3\2\2\2\21\u00b5\3\2\2\2\23\u00b7\3"+
		"\2\2\2\25\u00b9\3\2\2\2\27\u00bb\3\2\2\2\31\u00bd\3\2\2\2\33\u00c0\3\2"+
		"\2\2\35\u00c3\3\2\2\2\37\u00c6\3\2\2\2!\u00c9\3\2\2\2#\u00cc\3\2\2\2%"+
		"\u00cf\3\2\2\2\'\u00d2\3\2\2\2)\u00d5\3\2\2\2+\u00d8\3\2\2\2-\u00db\3"+
		"\2\2\2/\u00dd\3\2\2\2\61\u00e0\3\2\2\2\63\u00e2\3\2\2\2\65\u00e4\3\2\2"+
		"\2\67\u00e6\3\2\2\29\u00e8\3\2\2\2;\u00ea\3\2\2\2=\u00ec\3\2\2\2?\u00ee"+
		"\3\2\2\2A\u00f0\3\2\2\2C\u00f2\3\2\2\2E\u00f4\3\2\2\2G\u00f6\3\2\2\2I"+
		"\u00f8\3\2\2\2K\u00fa\3\2\2\2M\u00fc\3\2\2\2O\u00fe\3\2\2\2Q\u0100\3\2"+
		"\2\2S\u0107\3\2\2\2U\u010e\3\2\2\2W\u0112\3\2\2\2Y\u0118\3\2\2\2[\u011d"+
		"\3\2\2\2]\u0125\3\2\2\2_\u012f\3\2\2\2a\u0134\3\2\2\2c\u013b\3\2\2\2e"+
		"\u0141\3\2\2\2g\u0144\3\2\2\2i\u0147\3\2\2\2k\u014a\3\2\2\2m\u0158\3\2"+
		"\2\2o\u015b\3\2\2\2q\u015f\3\2\2\2s\u0169\3\2\2\2u\u0170\3\2\2\2w\u017d"+
		"\3\2\2\2y\u0189\3\2\2\2{\u0198\3\2\2\2}\u019b\3\2\2\2\177\u01a1\3\2\2"+
		"\2\u0081\u01a6\3\2\2\2\u0083\u01ac\3\2\2\2\u0085\u0086\7c\2\2\u0086\u0087"+
		"\7p\2\2\u0087\u0088\7{\2\2\u0088\4\3\2\2\2\u0089\u008a\7x\2\2\u008a\u008b"+
		"\7q\2\2\u008b\u008c\7k\2\2\u008c\u008d\7f\2\2\u008d\6\3\2\2\2\u008e\u008f"+
		"\7e\2\2\u008f\u0090\7c\2\2\u0090\u0091\7n\2\2\u0091\u0092\7n\2\2\u0092"+
		"\u0093\7c\2\2\u0093\u0094\7d\2\2\u0094\u0095\7n\2\2\u0095\u0096\7g\2\2"+
		"\u0096\b\3\2\2\2\u0097\u0098\7\61\2\2\u0098\u0099\7,\2\2\u0099\u009b\3"+
		"\2\2\2\u009a\u009c\13\2\2\2\u009b\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d"+
		"\u009e\3\2\2\2\u009d\u009b\3\2\2\2\u009e\u009f\3\2\2\2\u009f\u00a0\7,"+
		"\2\2\u00a0\u00a1\7\61\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3\b\5\2\2\u00a3"+
		"\n\3\2\2\2\u00a4\u00a5\7\61\2\2\u00a5\u00a6\7\61\2\2\u00a6\u00a8\3\2\2"+
		"\2\u00a7\u00a9\13\2\2\2\u00a8\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa"+
		"\u00ab\3\2\2\2\u00aa\u00a8\3\2\2\2\u00ab\u00ad\3\2\2\2\u00ac\u00ae\t\2"+
		"\2\2\u00ad\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b0\b\6\2\2\u00b0"+
		"\f\3\2\2\2\u00b1\u00b2\7*\2\2\u00b2\16\3\2\2\2\u00b3\u00b4\7+\2\2\u00b4"+
		"\20\3\2\2\2\u00b5\u00b6\7}\2\2\u00b6\22\3\2\2\2\u00b7\u00b8\7\177\2\2"+
		"\u00b8\24\3\2\2\2\u00b9\u00ba\7]\2\2\u00ba\26\3\2\2\2\u00bb\u00bc\7_\2"+
		"\2\u00bc\30\3\2\2\2\u00bd\u00be\7,\2\2\u00be\u00bf\7,\2\2\u00bf\32\3\2"+
		"\2\2\u00c0\u00c1\7?\2\2\u00c1\u00c2\7?\2\2\u00c2\34\3\2\2\2\u00c3\u00c4"+
		"\7#\2\2\u00c4\u00c5\7?\2\2\u00c5\36\3\2\2\2\u00c6\u00c7\7(\2\2\u00c7\u00c8"+
		"\7(\2\2\u00c8 \3\2\2\2\u00c9\u00ca\7~\2\2\u00ca\u00cb\7~\2\2\u00cb\"\3"+
		"\2\2\2\u00cc\u00cd\7>\2\2\u00cd\u00ce\7?\2\2\u00ce$\3\2\2\2\u00cf\u00d0"+
		"\7@\2\2\u00d0\u00d1\7?\2\2\u00d1&\3\2\2\2\u00d2\u00d3\7-\2\2\u00d3\u00d4"+
		"\7-\2\2\u00d4(\3\2\2\2\u00d5\u00d6\7/\2\2\u00d6\u00d7\7/\2\2\u00d7*\3"+
		"\2\2\2\u00d8\u00d9\7A\2\2\u00d9\u00da\7<\2\2\u00da,\3\2\2\2\u00db\u00dc"+
		"\7A\2\2\u00dc.\3\2\2\2\u00dd\u00de\7/\2\2\u00de\u00df\7@\2\2\u00df\60"+
		"\3\2\2\2\u00e0\u00e1\7^\2\2\u00e1\62\3\2\2\2\u00e2\u00e3\7.\2\2\u00e3"+
		"\64\3\2\2\2\u00e4\u00e5\7=\2\2\u00e5\66\3\2\2\2\u00e6\u00e7\7?\2\2\u00e7"+
		"8\3\2\2\2\u00e8\u00e9\7~\2\2\u00e9:\3\2\2\2\u00ea\u00eb\7(\2\2\u00eb<"+
		"\3\2\2\2\u00ec\u00ed\7#\2\2\u00ed>\3\2\2\2\u00ee\u00ef\7>\2\2\u00ef@\3"+
		"\2\2\2\u00f0\u00f1\7@\2\2\u00f1B\3\2\2\2\u00f2\u00f3\7,\2\2\u00f3D\3\2"+
		"\2\2\u00f4\u00f5\7\61\2\2\u00f5F\3\2\2\2\u00f6\u00f7\7-\2\2\u00f7H\3\2"+
		"\2\2\u00f8\u00f9\7/\2\2\u00f9J\3\2\2\2\u00fa\u00fb\7<\2\2\u00fbL\3\2\2"+
		"\2\u00fc\u00fd\7\60\2\2\u00fdN\3\2\2\2\u00fe\u00ff\7B\2\2\u00ffP\3\2\2"+
		"\2\u0100\u0101\7i\2\2\u0101\u0102\7n\2\2\u0102\u0103\7q\2\2\u0103\u0104"+
		"\7d\2\2\u0104\u0105\7c\2\2\u0105\u0106\7n\2\2\u0106R\3\2\2\2\u0107\u0108"+
		"\7o\2\2\u0108\u0109\7g\2\2\u0109\u010a\7v\2\2\u010a\u010b\7j\2\2\u010b"+
		"\u010c\7q\2\2\u010c\u010d\7f\2\2\u010dT\3\2\2\2\u010e\u010f\7w\2\2\u010f"+
		"\u0110\7u\2\2\u0110\u0111\7g\2\2\u0111V\3\2\2\2\u0112\u0113\7e\2\2\u0113"+
		"\u0114\7n\2\2\u0114\u0115\7c\2\2\u0115\u0116\7u\2\2\u0116\u0117\7u\2\2"+
		"\u0117X\3\2\2\2\u0118\u0119\7h\2\2\u0119\u011a\7t\2\2\u011a\u011b\7q\2"+
		"\2\u011b\u011c\7o\2\2\u011cZ\3\2\2\2\u011d\u011e\7g\2\2\u011e\u011f\7"+
		"z\2\2\u011f\u0120\7v\2\2\u0120\u0121\7g\2\2\u0121\u0122\7p\2\2\u0122\u0123"+
		"\7f\2\2\u0123\u0124\7u\2\2\u0124\\\3\2\2\2\u0125\u0126\7e\2\2\u0126\u0127"+
		"\7q\2\2\u0127\u0128\7o\2\2\u0128\u0129\7r\2\2\u0129\u012a\7q\2\2\u012a"+
		"\u012b\7p\2\2\u012b\u012c\7g\2\2\u012c\u012d\7p\2\2\u012d\u012e\7v\2\2"+
		"\u012e^\3\2\2\2\u012f\u0130\7u\2\2\u0130\u0131\7v\2\2\u0131\u0132\7q\2"+
		"\2\u0132\u0133\7r\2\2\u0133`\3\2\2\2\u0134\u0135\7t\2\2\u0135\u0136\7"+
		"g\2\2\u0136\u0137\7v\2\2\u0137\u0138\7w\2\2\u0138\u0139\7t\2\2\u0139\u013a"+
		"\7p\2\2\u013ab\3\2\2\2\u013b\u013c\7y\2\2\u013c\u013d\7j\2\2\u013d\u013e"+
		"\7k\2\2\u013e\u013f\7n\2\2\u013f\u0140\7g\2\2\u0140d\3\2\2\2\u0141\u0142"+
		"\7c\2\2\u0142\u0143\7u\2\2\u0143f\3\2\2\2\u0144\u0145\7k\2\2\u0145\u0146"+
		"\7h\2\2\u0146h\3\2\2\2\u0147\u0148\7k\2\2\u0148\u0149\7u\2\2\u0149j\3"+
		"\2\2\2\u014a\u014b\7g\2\2\u014b\u014c\7n\2\2\u014c\u014d\7u\2\2\u014d"+
		"\u014e\7g\2\2\u014el\3\2\2\2\u014f\u0150\7v\2\2\u0150\u0151\7t\2\2\u0151"+
		"\u0152\7w\2\2\u0152\u0159\7g\2\2\u0153\u0154\7h\2\2\u0154\u0155\7c\2\2"+
		"\u0155\u0156\7n\2\2\u0156\u0157\7u\2\2\u0157\u0159\7g\2\2\u0158\u014f"+
		"\3\2\2\2\u0158\u0153\3\2\2\2\u0159n\3\2\2\2\u015a\u015c\t\3\2\2\u015b"+
		"\u015a\3\2\2\2\u015c\u015d\3\2\2\2\u015d\u015b\3\2\2\2\u015d\u015e\3\2"+
		"\2\2\u015ep\3\2\2\2\u015f\u0164\7$\2\2\u0160\u0163\5\177@\2\u0161\u0163"+
		"\n\4\2\2\u0162\u0160\3\2\2\2\u0162\u0161\3\2\2\2\u0163\u0166\3\2\2\2\u0164"+
		"\u0162\3\2\2\2\u0164\u0165\3\2\2\2\u0165\u0167\3\2\2\2\u0166\u0164\3\2"+
		"\2\2\u0167\u0168\7$\2\2\u0168r\3\2\2\2\u0169\u016c\7)\2\2\u016a\u016d"+
		"\5\177@\2\u016b\u016d\n\5\2\2\u016c\u016a\3\2\2\2\u016c\u016b\3\2\2\2"+
		"\u016d\u016e\3\2\2\2\u016e\u016f\7)\2\2\u016ft\3\2\2\2\u0170\u0172\7%"+
		"\2\2\u0171\u0173\5\u0083B\2\u0172\u0171\3\2\2\2\u0173\u0174\3\2\2\2\u0174"+
		"\u0172\3\2\2\2\u0174\u0175\3\2\2\2\u0175v\3\2\2\2\u0176\u017e\t\6\2\2"+
		"\u0177\u0179\t\7\2\2\u0178\u017a\t\6\2\2\u0179\u0178\3\2\2\2\u017a\u017b"+
		"\3\2\2\2\u017b\u0179\3\2\2\2\u017b\u017c\3\2\2\2\u017c\u017e\3\2\2\2\u017d"+
		"\u0176\3\2\2\2\u017d\u0177\3\2\2\2\u017e\u017f\3\2\2\2\u017f\u0180\7N"+
		"\2\2\u0180x\3\2\2\2\u0181\u018a\t\6\2\2\u0182\u0186\t\7\2\2\u0183\u0185"+
		"\t\6\2\2\u0184\u0183\3\2\2\2\u0185\u0188\3\2\2\2\u0186\u0184\3\2\2\2\u0186"+
		"\u0187\3\2\2\2\u0187\u018a\3\2\2\2\u0188\u0186\3\2\2\2\u0189\u0181\3\2"+
		"\2\2\u0189\u0182\3\2\2\2\u018a\u018b\3\2\2\2\u018b\u018d\7\60\2\2\u018c"+
		"\u018e\t\6\2\2\u018d\u018c\3\2\2\2\u018e\u018f\3\2\2\2\u018f\u018d\3\2"+
		"\2\2\u018f\u0190\3\2\2\2\u0190z\3\2\2\2\u0191\u0199\t\6\2\2\u0192\u0194"+
		"\t\7\2\2\u0193\u0195\t\6\2\2\u0194\u0193\3\2\2\2\u0195\u0196\3\2\2\2\u0196"+
		"\u0194\3\2\2\2\u0196\u0197\3\2\2\2\u0197\u0199\3\2\2\2\u0198\u0191\3\2"+
		"\2\2\u0198\u0192\3\2\2\2\u0199|\3\2\2\2\u019a\u019c\t\b\2\2\u019b\u019a"+
		"\3\2\2\2\u019c\u019d\3\2\2\2\u019d\u019b\3\2\2\2\u019d\u019e\3\2\2\2\u019e"+
		"\u019f\3\2\2\2\u019f\u01a0\b?\2\2\u01a0~\3\2\2\2\u01a1\u01a4\7^\2\2\u01a2"+
		"\u01a5\t\t\2\2\u01a3\u01a5\5\u0081A\2\u01a4\u01a2\3\2\2\2\u01a4\u01a3"+
		"\3\2\2\2\u01a5\u0080\3\2\2\2\u01a6\u01a7\7w\2\2\u01a7\u01a8\5\u0083B\2"+
		"\u01a8\u01a9\5\u0083B\2\u01a9\u01aa\5\u0083B\2\u01aa\u01ab\5\u0083B\2"+
		"\u01ab\u0082\3\2\2\2\u01ac\u01ad\t\n\2\2\u01ad\u0084\3\2\2\2\25\2\u009d"+
		"\u00aa\u00ad\u0158\u015d\u0162\u0164\u016c\u0174\u017b\u017d\u0186\u0189"+
		"\u018f\u0196\u0198\u019d\u01a4\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}