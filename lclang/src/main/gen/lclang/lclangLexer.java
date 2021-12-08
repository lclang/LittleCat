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
		COMMENT=1, LINE_COMMENT=2, OPEN=3, CLOSE=4, OPEN_BRACE=5, CLOSE_BRACE=6, 
		OPEN_BRACKET=7, CLOSE_BRACKET=8, POW=9, EQUALS=10, NOT_EQUALS=11, AND_BOOL=12, 
		OR_BOOL=13, LESS_EQUALS=14, LARGER_EQUALS=15, UNARY_ADD=16, UNARY_MINUS=17, 
		NULLABLE_OR=18, NULLABLE=19, LAMBDA_PREFIX=20, TYPE_PREFIX=21, COMMA=22, 
		SEMICOLON=23, ASSIGN=24, OR=25, AND=26, NOT=27, LESS=28, LARGER=29, MULTIPLICATION=30, 
		DIVISION=31, ADD=32, MINUS=33, COLON=34, DOT=35, AS_ATTR=36, GLOBAL=37, 
		METHOD=38, USE=39, CLASS=40, FROM=41, EXTENDS=42, COMPONENT=43, STOP=44, 
		RETURN=45, WHILE=46, AS=47, IF=48, IS=49, ELSE=50, BOOL=51, ID=52, STRING=53, 
		CHAR=54, HEX_LONG=55, LONG=56, DOUBLE=57, INTEGER=58, WS=59;
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
			null, null, null, "'('", "')'", "'{'", "'}'", "'['", "']'", "'**'", "'=='", 
			"'!='", "'&&'", "'||'", "'<='", "'>='", "'++'", "'--'", "'?:'", "'?'", 
			"'->'", "'\\'", "','", "';'", "'='", "'|'", "'&'", "'!'", "'<'", "'>'", 
			"'*'", "'/'", "'+'", "'-'", "':'", "'.'", "'@'", "'global'", "'method'", 
			"'use'", "'class'", "'from'", "'extends'", "'component'", "'stop'", "'return'", 
			"'while'", "'as'", "'if'", "'is'", "'else'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COMMENT", "LINE_COMMENT", "OPEN", "CLOSE", "OPEN_BRACE", "CLOSE_BRACE", 
			"OPEN_BRACKET", "CLOSE_BRACKET", "POW", "EQUALS", "NOT_EQUALS", "AND_BOOL", 
			"OR_BOOL", "LESS_EQUALS", "LARGER_EQUALS", "UNARY_ADD", "UNARY_MINUS", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2=\u0196\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\3\2\3\2\3\2\3\2\6\2\u0084\n\2\r\2\16\2\u0085\3\2\3\2\3\2"+
		"\3\2\3\2\3\3\3\3\3\3\3\3\6\3\u0091\n\3\r\3\16\3\u0092\3\3\5\3\u0096\n"+
		"\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n"+
		"\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17"+
		"\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24"+
		"\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33"+
		"\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3"+
		"#\3$\3$\3%\3%\3&\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3"+
		"(\3(\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3+\3+\3,\3,\3"+
		",\3,\3,\3,\3,\3,\3,\3,\3-\3-\3-\3-\3-\3.\3.\3.\3.\3.\3.\3.\3/\3/\3/\3"+
		"/\3/\3/\3\60\3\60\3\60\3\61\3\61\3\61\3\62\3\62\3\62\3\63\3\63\3\63\3"+
		"\63\3\63\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\3\64\5\64\u0141\n\64"+
		"\3\65\6\65\u0144\n\65\r\65\16\65\u0145\3\66\3\66\3\66\7\66\u014b\n\66"+
		"\f\66\16\66\u014e\13\66\3\66\3\66\3\67\3\67\3\67\5\67\u0155\n\67\3\67"+
		"\3\67\38\38\68\u015b\n8\r8\168\u015c\39\39\39\69\u0162\n9\r9\169\u0163"+
		"\59\u0166\n9\39\39\3:\3:\3:\7:\u016d\n:\f:\16:\u0170\13:\5:\u0172\n:\3"+
		":\3:\6:\u0176\n:\r:\16:\u0177\3;\3;\3;\6;\u017d\n;\r;\16;\u017e\5;\u0181"+
		"\n;\3<\6<\u0184\n<\r<\16<\u0185\3<\3<\3=\3=\3=\5=\u018d\n=\3>\3>\3>\3"+
		">\3>\3>\3?\3?\4\u0085\u0092\2@\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13"+
		"\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61"+
		"\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61"+
		"a\62c\63e\64g\65i\66k\67m8o9q:s;u<w=y\2{\2}\2\3\2\13\4\3\f\f\17\17\5\2"+
		"C\\aac|\4\2$$^^\4\2))^^\3\2\62;\3\2\63;\5\2\13\f\17\17\"\"\n\2$$))\61"+
		"\61^^ddppttvv\4\2\62;Ch\2\u01a3\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2"+
		"\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2"+
		"\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2"+
		"\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2"+
		"\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2"+
		"\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2"+
		"\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O"+
		"\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2"+
		"\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2"+
		"\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u"+
		"\3\2\2\2\2w\3\2\2\2\3\177\3\2\2\2\5\u008c\3\2\2\2\7\u0099\3\2\2\2\t\u009b"+
		"\3\2\2\2\13\u009d\3\2\2\2\r\u009f\3\2\2\2\17\u00a1\3\2\2\2\21\u00a3\3"+
		"\2\2\2\23\u00a5\3\2\2\2\25\u00a8\3\2\2\2\27\u00ab\3\2\2\2\31\u00ae\3\2"+
		"\2\2\33\u00b1\3\2\2\2\35\u00b4\3\2\2\2\37\u00b7\3\2\2\2!\u00ba\3\2\2\2"+
		"#\u00bd\3\2\2\2%\u00c0\3\2\2\2\'\u00c3\3\2\2\2)\u00c5\3\2\2\2+\u00c8\3"+
		"\2\2\2-\u00ca\3\2\2\2/\u00cc\3\2\2\2\61\u00ce\3\2\2\2\63\u00d0\3\2\2\2"+
		"\65\u00d2\3\2\2\2\67\u00d4\3\2\2\29\u00d6\3\2\2\2;\u00d8\3\2\2\2=\u00da"+
		"\3\2\2\2?\u00dc\3\2\2\2A\u00de\3\2\2\2C\u00e0\3\2\2\2E\u00e2\3\2\2\2G"+
		"\u00e4\3\2\2\2I\u00e6\3\2\2\2K\u00e8\3\2\2\2M\u00ef\3\2\2\2O\u00f6\3\2"+
		"\2\2Q\u00fa\3\2\2\2S\u0100\3\2\2\2U\u0105\3\2\2\2W\u010d\3\2\2\2Y\u0117"+
		"\3\2\2\2[\u011c\3\2\2\2]\u0123\3\2\2\2_\u0129\3\2\2\2a\u012c\3\2\2\2c"+
		"\u012f\3\2\2\2e\u0132\3\2\2\2g\u0140\3\2\2\2i\u0143\3\2\2\2k\u0147\3\2"+
		"\2\2m\u0151\3\2\2\2o\u0158\3\2\2\2q\u0165\3\2\2\2s\u0171\3\2\2\2u\u0180"+
		"\3\2\2\2w\u0183\3\2\2\2y\u0189\3\2\2\2{\u018e\3\2\2\2}\u0194\3\2\2\2\177"+
		"\u0080\7\61\2\2\u0080\u0081\7,\2\2\u0081\u0083\3\2\2\2\u0082\u0084\13"+
		"\2\2\2\u0083\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0086\3\2\2\2\u0085"+
		"\u0083\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0088\7,\2\2\u0088\u0089\7\61"+
		"\2\2\u0089\u008a\3\2\2\2\u008a\u008b\b\2\2\2\u008b\4\3\2\2\2\u008c\u008d"+
		"\7\61\2\2\u008d\u008e\7\61\2\2\u008e\u0090\3\2\2\2\u008f\u0091\13\2\2"+
		"\2\u0090\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0093\3\2\2\2\u0092\u0090"+
		"\3\2\2\2\u0093\u0095\3\2\2\2\u0094\u0096\t\2\2\2\u0095\u0094\3\2\2\2\u0096"+
		"\u0097\3\2\2\2\u0097\u0098\b\3\2\2\u0098\6\3\2\2\2\u0099\u009a\7*\2\2"+
		"\u009a\b\3\2\2\2\u009b\u009c\7+\2\2\u009c\n\3\2\2\2\u009d\u009e\7}\2\2"+
		"\u009e\f\3\2\2\2\u009f\u00a0\7\177\2\2\u00a0\16\3\2\2\2\u00a1\u00a2\7"+
		"]\2\2\u00a2\20\3\2\2\2\u00a3\u00a4\7_\2\2\u00a4\22\3\2\2\2\u00a5\u00a6"+
		"\7,\2\2\u00a6\u00a7\7,\2\2\u00a7\24\3\2\2\2\u00a8\u00a9\7?\2\2\u00a9\u00aa"+
		"\7?\2\2\u00aa\26\3\2\2\2\u00ab\u00ac\7#\2\2\u00ac\u00ad\7?\2\2\u00ad\30"+
		"\3\2\2\2\u00ae\u00af\7(\2\2\u00af\u00b0\7(\2\2\u00b0\32\3\2\2\2\u00b1"+
		"\u00b2\7~\2\2\u00b2\u00b3\7~\2\2\u00b3\34\3\2\2\2\u00b4\u00b5\7>\2\2\u00b5"+
		"\u00b6\7?\2\2\u00b6\36\3\2\2\2\u00b7\u00b8\7@\2\2\u00b8\u00b9\7?\2\2\u00b9"+
		" \3\2\2\2\u00ba\u00bb\7-\2\2\u00bb\u00bc\7-\2\2\u00bc\"\3\2\2\2\u00bd"+
		"\u00be\7/\2\2\u00be\u00bf\7/\2\2\u00bf$\3\2\2\2\u00c0\u00c1\7A\2\2\u00c1"+
		"\u00c2\7<\2\2\u00c2&\3\2\2\2\u00c3\u00c4\7A\2\2\u00c4(\3\2\2\2\u00c5\u00c6"+
		"\7/\2\2\u00c6\u00c7\7@\2\2\u00c7*\3\2\2\2\u00c8\u00c9\7^\2\2\u00c9,\3"+
		"\2\2\2\u00ca\u00cb\7.\2\2\u00cb.\3\2\2\2\u00cc\u00cd\7=\2\2\u00cd\60\3"+
		"\2\2\2\u00ce\u00cf\7?\2\2\u00cf\62\3\2\2\2\u00d0\u00d1\7~\2\2\u00d1\64"+
		"\3\2\2\2\u00d2\u00d3\7(\2\2\u00d3\66\3\2\2\2\u00d4\u00d5\7#\2\2\u00d5"+
		"8\3\2\2\2\u00d6\u00d7\7>\2\2\u00d7:\3\2\2\2\u00d8\u00d9\7@\2\2\u00d9<"+
		"\3\2\2\2\u00da\u00db\7,\2\2\u00db>\3\2\2\2\u00dc\u00dd\7\61\2\2\u00dd"+
		"@\3\2\2\2\u00de\u00df\7-\2\2\u00dfB\3\2\2\2\u00e0\u00e1\7/\2\2\u00e1D"+
		"\3\2\2\2\u00e2\u00e3\7<\2\2\u00e3F\3\2\2\2\u00e4\u00e5\7\60\2\2\u00e5"+
		"H\3\2\2\2\u00e6\u00e7\7B\2\2\u00e7J\3\2\2\2\u00e8\u00e9\7i\2\2\u00e9\u00ea"+
		"\7n\2\2\u00ea\u00eb\7q\2\2\u00eb\u00ec\7d\2\2\u00ec\u00ed\7c\2\2\u00ed"+
		"\u00ee\7n\2\2\u00eeL\3\2\2\2\u00ef\u00f0\7o\2\2\u00f0\u00f1\7g\2\2\u00f1"+
		"\u00f2\7v\2\2\u00f2\u00f3\7j\2\2\u00f3\u00f4\7q\2\2\u00f4\u00f5\7f\2\2"+
		"\u00f5N\3\2\2\2\u00f6\u00f7\7w\2\2\u00f7\u00f8\7u\2\2\u00f8\u00f9\7g\2"+
		"\2\u00f9P\3\2\2\2\u00fa\u00fb\7e\2\2\u00fb\u00fc\7n\2\2\u00fc\u00fd\7"+
		"c\2\2\u00fd\u00fe\7u\2\2\u00fe\u00ff\7u\2\2\u00ffR\3\2\2\2\u0100\u0101"+
		"\7h\2\2\u0101\u0102\7t\2\2\u0102\u0103\7q\2\2\u0103\u0104\7o\2\2\u0104"+
		"T\3\2\2\2\u0105\u0106\7g\2\2\u0106\u0107\7z\2\2\u0107\u0108\7v\2\2\u0108"+
		"\u0109\7g\2\2\u0109\u010a\7p\2\2\u010a\u010b\7f\2\2\u010b\u010c\7u\2\2"+
		"\u010cV\3\2\2\2\u010d\u010e\7e\2\2\u010e\u010f\7q\2\2\u010f\u0110\7o\2"+
		"\2\u0110\u0111\7r\2\2\u0111\u0112\7q\2\2\u0112\u0113\7p\2\2\u0113\u0114"+
		"\7g\2\2\u0114\u0115\7p\2\2\u0115\u0116\7v\2\2\u0116X\3\2\2\2\u0117\u0118"+
		"\7u\2\2\u0118\u0119\7v\2\2\u0119\u011a\7q\2\2\u011a\u011b\7r\2\2\u011b"+
		"Z\3\2\2\2\u011c\u011d\7t\2\2\u011d\u011e\7g\2\2\u011e\u011f\7v\2\2\u011f"+
		"\u0120\7w\2\2\u0120\u0121\7t\2\2\u0121\u0122\7p\2\2\u0122\\\3\2\2\2\u0123"+
		"\u0124\7y\2\2\u0124\u0125\7j\2\2\u0125\u0126\7k\2\2\u0126\u0127\7n\2\2"+
		"\u0127\u0128\7g\2\2\u0128^\3\2\2\2\u0129\u012a\7c\2\2\u012a\u012b\7u\2"+
		"\2\u012b`\3\2\2\2\u012c\u012d\7k\2\2\u012d\u012e\7h\2\2\u012eb\3\2\2\2"+
		"\u012f\u0130\7k\2\2\u0130\u0131\7u\2\2\u0131d\3\2\2\2\u0132\u0133\7g\2"+
		"\2\u0133\u0134\7n\2\2\u0134\u0135\7u\2\2\u0135\u0136\7g\2\2\u0136f\3\2"+
		"\2\2\u0137\u0138\7v\2\2\u0138\u0139\7t\2\2\u0139\u013a\7w\2\2\u013a\u0141"+
		"\7g\2\2\u013b\u013c\7h\2\2\u013c\u013d\7c\2\2\u013d\u013e\7n\2\2\u013e"+
		"\u013f\7u\2\2\u013f\u0141\7g\2\2\u0140\u0137\3\2\2\2\u0140\u013b\3\2\2"+
		"\2\u0141h\3\2\2\2\u0142\u0144\t\3\2\2\u0143\u0142\3\2\2\2\u0144\u0145"+
		"\3\2\2\2\u0145\u0143\3\2\2\2\u0145\u0146\3\2\2\2\u0146j\3\2\2\2\u0147"+
		"\u014c\7$\2\2\u0148\u014b\5y=\2\u0149\u014b\n\4\2\2\u014a\u0148\3\2\2"+
		"\2\u014a\u0149\3\2\2\2\u014b\u014e\3\2\2\2\u014c\u014a\3\2\2\2\u014c\u014d"+
		"\3\2\2\2\u014d\u014f\3\2\2\2\u014e\u014c\3\2\2\2\u014f\u0150\7$\2\2\u0150"+
		"l\3\2\2\2\u0151\u0154\7)\2\2\u0152\u0155\5y=\2\u0153\u0155\n\5\2\2\u0154"+
		"\u0152\3\2\2\2\u0154\u0153\3\2\2\2\u0155\u0156\3\2\2\2\u0156\u0157\7)"+
		"\2\2\u0157n\3\2\2\2\u0158\u015a\7%\2\2\u0159\u015b\5}?\2\u015a\u0159\3"+
		"\2\2\2\u015b\u015c\3\2\2\2\u015c\u015a\3\2\2\2\u015c\u015d\3\2\2\2\u015d"+
		"p\3\2\2\2\u015e\u0166\t\6\2\2\u015f\u0161\t\7\2\2\u0160\u0162\t\6\2\2"+
		"\u0161\u0160\3\2\2\2\u0162\u0163\3\2\2\2\u0163\u0161\3\2\2\2\u0163\u0164"+
		"\3\2\2\2\u0164\u0166\3\2\2\2\u0165\u015e\3\2\2\2\u0165\u015f\3\2\2\2\u0166"+
		"\u0167\3\2\2\2\u0167\u0168\7N\2\2\u0168r\3\2\2\2\u0169\u0172\t\6\2\2\u016a"+
		"\u016e\t\7\2\2\u016b\u016d\t\6\2\2\u016c\u016b\3\2\2\2\u016d\u0170\3\2"+
		"\2\2\u016e\u016c\3\2\2\2\u016e\u016f\3\2\2\2\u016f\u0172\3\2\2\2\u0170"+
		"\u016e\3\2\2\2\u0171\u0169\3\2\2\2\u0171\u016a\3\2\2\2\u0172\u0173\3\2"+
		"\2\2\u0173\u0175\7\60\2\2\u0174\u0176\t\6\2\2\u0175\u0174\3\2\2\2\u0176"+
		"\u0177\3\2\2\2\u0177\u0175\3\2\2\2\u0177\u0178\3\2\2\2\u0178t\3\2\2\2"+
		"\u0179\u0181\t\6\2\2\u017a\u017c\t\7\2\2\u017b\u017d\t\6\2\2\u017c\u017b"+
		"\3\2\2\2\u017d\u017e\3\2\2\2\u017e\u017c\3\2\2\2\u017e\u017f\3\2\2\2\u017f"+
		"\u0181\3\2\2\2\u0180\u0179\3\2\2\2\u0180\u017a\3\2\2\2\u0181v\3\2\2\2"+
		"\u0182\u0184\t\b\2\2\u0183\u0182\3\2\2\2\u0184\u0185\3\2\2\2\u0185\u0183"+
		"\3\2\2\2\u0185\u0186\3\2\2\2\u0186\u0187\3\2\2\2\u0187\u0188\b<\2\2\u0188"+
		"x\3\2\2\2\u0189\u018c\7^\2\2\u018a\u018d\t\t\2\2\u018b\u018d\5{>\2\u018c"+
		"\u018a\3\2\2\2\u018c\u018b\3\2\2\2\u018dz\3\2\2\2\u018e\u018f\7w\2\2\u018f"+
		"\u0190\5}?\2\u0190\u0191\5}?\2\u0191\u0192\5}?\2\u0192\u0193\5}?\2\u0193"+
		"|\3\2\2\2\u0194\u0195\t\n\2\2\u0195~\3\2\2\2\25\2\u0085\u0092\u0095\u0140"+
		"\u0145\u014a\u014c\u0154\u015c\u0163\u0165\u016e\u0171\u0177\u017e\u0180"+
		"\u0185\u018c\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}