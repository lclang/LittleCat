// Generated from /mnt/sdb9/IdeaProjects/lclang-java/lclang/src/main/java/lclang/lclang.g4 by ANTLR 4.9.2
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
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COMMENT=1, LINE_COMMENT=2, OPEN=3, CLOSE=4, OPEN_BRACE=5, CLOSE_BRACE=6, 
		OPEN_BRACKET=7, CLOSE_BRACKET=8, POW=9, EQUALS=10, NOT_EQUALS=11, AND_BOOL=12, 
		OR_BOOL=13, LESS_EQUALS=14, LARGER_EQUALS=15, UNARY_ADD=16, UNARY_MINUS=17, 
		LEFT_SHIFT=18, RIGHT_SHIFT=19, NULLABLE_OR=20, NULLABLE=21, LAMBDA_PREFIX=22, 
		TYPE_PREFIX=23, COMMA=24, SEMICOLON=25, ASSIGN=26, XOR=27, OR=28, AND=29, 
		COMPLIMENT=30, NOT=31, LESS=32, LARGER=33, MULTIPLICATION=34, DIVISION=35, 
		ADD=36, MINUS=37, COLON=38, DOT=39, AS_ATTR=40, GLOBAL=41, METHOD=42, 
		USE=43, CLASS=44, FROM=45, EXTENDS=46, COMPONENT=47, STOP=48, RETURN=49, 
		WHILE=50, LOOP=51, AS=52, IF=53, IS=54, ELSE=55, VOIDABLE=56, BOOL=57, 
		ID=58, STRING=59, CHAR=60, HEX_LONG=61, LONG=62, DOUBLE=63, INTEGER=64, 
		WS=65;
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
			"LEFT_SHIFT", "RIGHT_SHIFT", "NULLABLE_OR", "NULLABLE", "LAMBDA_PREFIX", 
			"TYPE_PREFIX", "COMMA", "SEMICOLON", "ASSIGN", "XOR", "OR", "AND", "COMPLIMENT", 
			"NOT", "LESS", "LARGER", "MULTIPLICATION", "DIVISION", "ADD", "MINUS", 
			"COLON", "DOT", "AS_ATTR", "GLOBAL", "METHOD", "USE", "CLASS", "FROM", 
			"EXTENDS", "COMPONENT", "STOP", "RETURN", "WHILE", "LOOP", "AS", "IF", 
			"IS", "ELSE", "VOIDABLE", "BOOL", "ID", "STRING", "CHAR", "HEX_LONG", 
			"LONG", "DOUBLE", "INTEGER", "WS", "ESC", "UNICODE", "HEX"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'('", "')'", "'{'", "'}'", "'['", "']'", "'**'", "'=='", 
			"'!='", "'&&'", "'||'", "'<='", "'>='", "'++'", "'--'", "'<<'", "'>>'", 
			"'?:'", "'?'", "'->'", "'\\'", "','", "';'", "'='", "'^'", "'|'", "'&'", 
			"'~'", "'!'", "'<'", "'>'", "'*'", "'/'", "'+'", "'-'", "':'", "'.'", 
			"'@'", "'global'", "'method'", "'use'", "'class'", "'from'", "'extends'", 
			"'component'", "'stop'", "'return'", "'while'", "'loop'", "'as'", "'if'", 
			"'is'", "'else'", "'voidable'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COMMENT", "LINE_COMMENT", "OPEN", "CLOSE", "OPEN_BRACE", "CLOSE_BRACE", 
			"OPEN_BRACKET", "CLOSE_BRACKET", "POW", "EQUALS", "NOT_EQUALS", "AND_BOOL", 
			"OR_BOOL", "LESS_EQUALS", "LARGER_EQUALS", "UNARY_ADD", "UNARY_MINUS", 
			"LEFT_SHIFT", "RIGHT_SHIFT", "NULLABLE_OR", "NULLABLE", "LAMBDA_PREFIX", 
			"TYPE_PREFIX", "COMMA", "SEMICOLON", "ASSIGN", "XOR", "OR", "AND", "COMPLIMENT", 
			"NOT", "LESS", "LARGER", "MULTIPLICATION", "DIVISION", "ADD", "MINUS", 
			"COLON", "DOT", "AS_ATTR", "GLOBAL", "METHOD", "USE", "CLASS", "FROM", 
			"EXTENDS", "COMPONENT", "STOP", "RETURN", "WHILE", "LOOP", "AS", "IF", 
			"IS", "ELSE", "VOIDABLE", "BOOL", "ID", "STRING", "CHAR", "HEX_LONG", 
			"LONG", "DOUBLE", "INTEGER", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2C\u01ba\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\3\2\3\2\3\2\3\2\6\2\u0090"+
		"\n\2\r\2\16\2\u0091\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\6\3\u009d\n\3"+
		"\r\3\16\3\u009e\3\3\5\3\u00a2\n\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7"+
		"\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3"+
		"\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3"+
		"\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\27\3"+
		"\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3"+
		"\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'"+
		"\3(\3(\3)\3)\3*\3*\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3+\3,\3,\3,\3,\3-"+
		"\3-\3-\3-\3-\3-\3.\3.\3.\3.\3.\3/\3/\3/\3/\3/\3/\3/\3/\3\60\3\60\3\60"+
		"\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\61\3\61\3\62\3\62"+
		"\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\63\3\63\3\63\3\64\3\64\3\64"+
		"\3\64\3\64\3\65\3\65\3\65\3\66\3\66\3\66\3\67\3\67\3\67\38\38\38\38\3"+
		"8\39\39\39\39\39\39\39\39\39\3:\3:\3:\3:\3:\3:\3:\3:\3:\5:\u0165\n:\3"+
		";\6;\u0168\n;\r;\16;\u0169\3<\3<\3<\7<\u016f\n<\f<\16<\u0172\13<\3<\3"+
		"<\3=\3=\3=\5=\u0179\n=\3=\3=\3>\3>\6>\u017f\n>\r>\16>\u0180\3?\3?\3?\6"+
		"?\u0186\n?\r?\16?\u0187\5?\u018a\n?\3?\3?\3@\3@\3@\7@\u0191\n@\f@\16@"+
		"\u0194\13@\5@\u0196\n@\3@\3@\6@\u019a\n@\r@\16@\u019b\3A\3A\3A\6A\u01a1"+
		"\nA\rA\16A\u01a2\5A\u01a5\nA\3B\6B\u01a8\nB\rB\16B\u01a9\3B\3B\3C\3C\3"+
		"C\5C\u01b1\nC\3D\3D\3D\3D\3D\3D\3E\3E\4\u0091\u009e\2F\3\3\5\4\7\5\t\6"+
		"\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24"+
		"\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K"+
		"\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s;u<w=y>{?}@\177"+
		"A\u0081B\u0083C\u0085\2\u0087\2\u0089\2\3\2\13\4\3\f\f\17\17\5\2C\\aa"+
		"c|\4\2$$^^\4\2))^^\3\2\62;\3\2\63;\5\2\13\f\17\17\"\"\n\2$$))\61\61^^"+
		"ddppttvv\4\2\62;Ch\2\u01c7\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2"+
		"\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2"+
		"\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3"+
		"\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2"+
		"\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67"+
		"\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2"+
		"\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2"+
		"\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]"+
		"\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2"+
		"\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2"+
		"\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2"+
		"\2\2\2\u0083\3\2\2\2\3\u008b\3\2\2\2\5\u0098\3\2\2\2\7\u00a5\3\2\2\2\t"+
		"\u00a7\3\2\2\2\13\u00a9\3\2\2\2\r\u00ab\3\2\2\2\17\u00ad\3\2\2\2\21\u00af"+
		"\3\2\2\2\23\u00b1\3\2\2\2\25\u00b4\3\2\2\2\27\u00b7\3\2\2\2\31\u00ba\3"+
		"\2\2\2\33\u00bd\3\2\2\2\35\u00c0\3\2\2\2\37\u00c3\3\2\2\2!\u00c6\3\2\2"+
		"\2#\u00c9\3\2\2\2%\u00cc\3\2\2\2\'\u00cf\3\2\2\2)\u00d2\3\2\2\2+\u00d5"+
		"\3\2\2\2-\u00d7\3\2\2\2/\u00da\3\2\2\2\61\u00dc\3\2\2\2\63\u00de\3\2\2"+
		"\2\65\u00e0\3\2\2\2\67\u00e2\3\2\2\29\u00e4\3\2\2\2;\u00e6\3\2\2\2=\u00e8"+
		"\3\2\2\2?\u00ea\3\2\2\2A\u00ec\3\2\2\2C\u00ee\3\2\2\2E\u00f0\3\2\2\2G"+
		"\u00f2\3\2\2\2I\u00f4\3\2\2\2K\u00f6\3\2\2\2M\u00f8\3\2\2\2O\u00fa\3\2"+
		"\2\2Q\u00fc\3\2\2\2S\u00fe\3\2\2\2U\u0105\3\2\2\2W\u010c\3\2\2\2Y\u0110"+
		"\3\2\2\2[\u0116\3\2\2\2]\u011b\3\2\2\2_\u0123\3\2\2\2a\u012d\3\2\2\2c"+
		"\u0132\3\2\2\2e\u0139\3\2\2\2g\u013f\3\2\2\2i\u0144\3\2\2\2k\u0147\3\2"+
		"\2\2m\u014a\3\2\2\2o\u014d\3\2\2\2q\u0152\3\2\2\2s\u0164\3\2\2\2u\u0167"+
		"\3\2\2\2w\u016b\3\2\2\2y\u0175\3\2\2\2{\u017c\3\2\2\2}\u0189\3\2\2\2\177"+
		"\u0195\3\2\2\2\u0081\u01a4\3\2\2\2\u0083\u01a7\3\2\2\2\u0085\u01ad\3\2"+
		"\2\2\u0087\u01b2\3\2\2\2\u0089\u01b8\3\2\2\2\u008b\u008c\7\61\2\2\u008c"+
		"\u008d\7,\2\2\u008d\u008f\3\2\2\2\u008e\u0090\13\2\2\2\u008f\u008e\3\2"+
		"\2\2\u0090\u0091\3\2\2\2\u0091\u0092\3\2\2\2\u0091\u008f\3\2\2\2\u0092"+
		"\u0093\3\2\2\2\u0093\u0094\7,\2\2\u0094\u0095\7\61\2\2\u0095\u0096\3\2"+
		"\2\2\u0096\u0097\b\2\2\2\u0097\4\3\2\2\2\u0098\u0099\7\61\2\2\u0099\u009a"+
		"\7\61\2\2\u009a\u009c\3\2\2\2\u009b\u009d\13\2\2\2\u009c\u009b\3\2\2\2"+
		"\u009d\u009e\3\2\2\2\u009e\u009f\3\2\2\2\u009e\u009c\3\2\2\2\u009f\u00a1"+
		"\3\2\2\2\u00a0\u00a2\t\2\2\2\u00a1\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3"+
		"\u00a4\b\3\2\2\u00a4\6\3\2\2\2\u00a5\u00a6\7*\2\2\u00a6\b\3\2\2\2\u00a7"+
		"\u00a8\7+\2\2\u00a8\n\3\2\2\2\u00a9\u00aa\7}\2\2\u00aa\f\3\2\2\2\u00ab"+
		"\u00ac\7\177\2\2\u00ac\16\3\2\2\2\u00ad\u00ae\7]\2\2\u00ae\20\3\2\2\2"+
		"\u00af\u00b0\7_\2\2\u00b0\22\3\2\2\2\u00b1\u00b2\7,\2\2\u00b2\u00b3\7"+
		",\2\2\u00b3\24\3\2\2\2\u00b4\u00b5\7?\2\2\u00b5\u00b6\7?\2\2\u00b6\26"+
		"\3\2\2\2\u00b7\u00b8\7#\2\2\u00b8\u00b9\7?\2\2\u00b9\30\3\2\2\2\u00ba"+
		"\u00bb\7(\2\2\u00bb\u00bc\7(\2\2\u00bc\32\3\2\2\2\u00bd\u00be\7~\2\2\u00be"+
		"\u00bf\7~\2\2\u00bf\34\3\2\2\2\u00c0\u00c1\7>\2\2\u00c1\u00c2\7?\2\2\u00c2"+
		"\36\3\2\2\2\u00c3\u00c4\7@\2\2\u00c4\u00c5\7?\2\2\u00c5 \3\2\2\2\u00c6"+
		"\u00c7\7-\2\2\u00c7\u00c8\7-\2\2\u00c8\"\3\2\2\2\u00c9\u00ca\7/\2\2\u00ca"+
		"\u00cb\7/\2\2\u00cb$\3\2\2\2\u00cc\u00cd\7>\2\2\u00cd\u00ce\7>\2\2\u00ce"+
		"&\3\2\2\2\u00cf\u00d0\7@\2\2\u00d0\u00d1\7@\2\2\u00d1(\3\2\2\2\u00d2\u00d3"+
		"\7A\2\2\u00d3\u00d4\7<\2\2\u00d4*\3\2\2\2\u00d5\u00d6\7A\2\2\u00d6,\3"+
		"\2\2\2\u00d7\u00d8\7/\2\2\u00d8\u00d9\7@\2\2\u00d9.\3\2\2\2\u00da\u00db"+
		"\7^\2\2\u00db\60\3\2\2\2\u00dc\u00dd\7.\2\2\u00dd\62\3\2\2\2\u00de\u00df"+
		"\7=\2\2\u00df\64\3\2\2\2\u00e0\u00e1\7?\2\2\u00e1\66\3\2\2\2\u00e2\u00e3"+
		"\7`\2\2\u00e38\3\2\2\2\u00e4\u00e5\7~\2\2\u00e5:\3\2\2\2\u00e6\u00e7\7"+
		"(\2\2\u00e7<\3\2\2\2\u00e8\u00e9\7\u0080\2\2\u00e9>\3\2\2\2\u00ea\u00eb"+
		"\7#\2\2\u00eb@\3\2\2\2\u00ec\u00ed\7>\2\2\u00edB\3\2\2\2\u00ee\u00ef\7"+
		"@\2\2\u00efD\3\2\2\2\u00f0\u00f1\7,\2\2\u00f1F\3\2\2\2\u00f2\u00f3\7\61"+
		"\2\2\u00f3H\3\2\2\2\u00f4\u00f5\7-\2\2\u00f5J\3\2\2\2\u00f6\u00f7\7/\2"+
		"\2\u00f7L\3\2\2\2\u00f8\u00f9\7<\2\2\u00f9N\3\2\2\2\u00fa\u00fb\7\60\2"+
		"\2\u00fbP\3\2\2\2\u00fc\u00fd\7B\2\2\u00fdR\3\2\2\2\u00fe\u00ff\7i\2\2"+
		"\u00ff\u0100\7n\2\2\u0100\u0101\7q\2\2\u0101\u0102\7d\2\2\u0102\u0103"+
		"\7c\2\2\u0103\u0104\7n\2\2\u0104T\3\2\2\2\u0105\u0106\7o\2\2\u0106\u0107"+
		"\7g\2\2\u0107\u0108\7v\2\2\u0108\u0109\7j\2\2\u0109\u010a\7q\2\2\u010a"+
		"\u010b\7f\2\2\u010bV\3\2\2\2\u010c\u010d\7w\2\2\u010d\u010e\7u\2\2\u010e"+
		"\u010f\7g\2\2\u010fX\3\2\2\2\u0110\u0111\7e\2\2\u0111\u0112\7n\2\2\u0112"+
		"\u0113\7c\2\2\u0113\u0114\7u\2\2\u0114\u0115\7u\2\2\u0115Z\3\2\2\2\u0116"+
		"\u0117\7h\2\2\u0117\u0118\7t\2\2\u0118\u0119\7q\2\2\u0119\u011a\7o\2\2"+
		"\u011a\\\3\2\2\2\u011b\u011c\7g\2\2\u011c\u011d\7z\2\2\u011d\u011e\7v"+
		"\2\2\u011e\u011f\7g\2\2\u011f\u0120\7p\2\2\u0120\u0121\7f\2\2\u0121\u0122"+
		"\7u\2\2\u0122^\3\2\2\2\u0123\u0124\7e\2\2\u0124\u0125\7q\2\2\u0125\u0126"+
		"\7o\2\2\u0126\u0127\7r\2\2\u0127\u0128\7q\2\2\u0128\u0129\7p\2\2\u0129"+
		"\u012a\7g\2\2\u012a\u012b\7p\2\2\u012b\u012c\7v\2\2\u012c`\3\2\2\2\u012d"+
		"\u012e\7u\2\2\u012e\u012f\7v\2\2\u012f\u0130\7q\2\2\u0130\u0131\7r\2\2"+
		"\u0131b\3\2\2\2\u0132\u0133\7t\2\2\u0133\u0134\7g\2\2\u0134\u0135\7v\2"+
		"\2\u0135\u0136\7w\2\2\u0136\u0137\7t\2\2\u0137\u0138\7p\2\2\u0138d\3\2"+
		"\2\2\u0139\u013a\7y\2\2\u013a\u013b\7j\2\2\u013b\u013c\7k\2\2\u013c\u013d"+
		"\7n\2\2\u013d\u013e\7g\2\2\u013ef\3\2\2\2\u013f\u0140\7n\2\2\u0140\u0141"+
		"\7q\2\2\u0141\u0142\7q\2\2\u0142\u0143\7r\2\2\u0143h\3\2\2\2\u0144\u0145"+
		"\7c\2\2\u0145\u0146\7u\2\2\u0146j\3\2\2\2\u0147\u0148\7k\2\2\u0148\u0149"+
		"\7h\2\2\u0149l\3\2\2\2\u014a\u014b\7k\2\2\u014b\u014c\7u\2\2\u014cn\3"+
		"\2\2\2\u014d\u014e\7g\2\2\u014e\u014f\7n\2\2\u014f\u0150\7u\2\2\u0150"+
		"\u0151\7g\2\2\u0151p\3\2\2\2\u0152\u0153\7x\2\2\u0153\u0154\7q\2\2\u0154"+
		"\u0155\7k\2\2\u0155\u0156\7f\2\2\u0156\u0157\7c\2\2\u0157\u0158\7d\2\2"+
		"\u0158\u0159\7n\2\2\u0159\u015a\7g\2\2\u015ar\3\2\2\2\u015b\u015c\7v\2"+
		"\2\u015c\u015d\7t\2\2\u015d\u015e\7w\2\2\u015e\u0165\7g\2\2\u015f\u0160"+
		"\7h\2\2\u0160\u0161\7c\2\2\u0161\u0162\7n\2\2\u0162\u0163\7u\2\2\u0163"+
		"\u0165\7g\2\2\u0164\u015b\3\2\2\2\u0164\u015f\3\2\2\2\u0165t\3\2\2\2\u0166"+
		"\u0168\t\3\2\2\u0167\u0166\3\2\2\2\u0168\u0169\3\2\2\2\u0169\u0167\3\2"+
		"\2\2\u0169\u016a\3\2\2\2\u016av\3\2\2\2\u016b\u0170\7$\2\2\u016c\u016f"+
		"\5\u0085C\2\u016d\u016f\n\4\2\2\u016e\u016c\3\2\2\2\u016e\u016d\3\2\2"+
		"\2\u016f\u0172\3\2\2\2\u0170\u016e\3\2\2\2\u0170\u0171\3\2\2\2\u0171\u0173"+
		"\3\2\2\2\u0172\u0170\3\2\2\2\u0173\u0174\7$\2\2\u0174x\3\2\2\2\u0175\u0178"+
		"\7)\2\2\u0176\u0179\5\u0085C\2\u0177\u0179\n\5\2\2\u0178\u0176\3\2\2\2"+
		"\u0178\u0177\3\2\2\2\u0179\u017a\3\2\2\2\u017a\u017b\7)\2\2\u017bz\3\2"+
		"\2\2\u017c\u017e\7%\2\2\u017d\u017f\5\u0089E\2\u017e\u017d\3\2\2\2\u017f"+
		"\u0180\3\2\2\2\u0180\u017e\3\2\2\2\u0180\u0181\3\2\2\2\u0181|\3\2\2\2"+
		"\u0182\u018a\t\6\2\2\u0183\u0185\t\7\2\2\u0184\u0186\t\6\2\2\u0185\u0184"+
		"\3\2\2\2\u0186\u0187\3\2\2\2\u0187\u0185\3\2\2\2\u0187\u0188\3\2\2\2\u0188"+
		"\u018a\3\2\2\2\u0189\u0182\3\2\2\2\u0189\u0183\3\2\2\2\u018a\u018b\3\2"+
		"\2\2\u018b\u018c\7N\2\2\u018c~\3\2\2\2\u018d\u0196\t\6\2\2\u018e\u0192"+
		"\t\7\2\2\u018f\u0191\t\6\2\2\u0190\u018f\3\2\2\2\u0191\u0194\3\2\2\2\u0192"+
		"\u0190\3\2\2\2\u0192\u0193\3\2\2\2\u0193\u0196\3\2\2\2\u0194\u0192\3\2"+
		"\2\2\u0195\u018d\3\2\2\2\u0195\u018e\3\2\2\2\u0196\u0197\3\2\2\2\u0197"+
		"\u0199\7\60\2\2\u0198\u019a\t\6\2\2\u0199\u0198\3\2\2\2\u019a\u019b\3"+
		"\2\2\2\u019b\u0199\3\2\2\2\u019b\u019c\3\2\2\2\u019c\u0080\3\2\2\2\u019d"+
		"\u01a5\t\6\2\2\u019e\u01a0\t\7\2\2\u019f\u01a1\t\6\2\2\u01a0\u019f\3\2"+
		"\2\2\u01a1\u01a2\3\2\2\2\u01a2\u01a0\3\2\2\2\u01a2\u01a3\3\2\2\2\u01a3"+
		"\u01a5\3\2\2\2\u01a4\u019d\3\2\2\2\u01a4\u019e\3\2\2\2\u01a5\u0082\3\2"+
		"\2\2\u01a6\u01a8\t\b\2\2\u01a7\u01a6\3\2\2\2\u01a8\u01a9\3\2\2\2\u01a9"+
		"\u01a7\3\2\2\2\u01a9\u01aa\3\2\2\2\u01aa\u01ab\3\2\2\2\u01ab\u01ac\bB"+
		"\2\2\u01ac\u0084\3\2\2\2\u01ad\u01b0\7^\2\2\u01ae\u01b1\t\t\2\2\u01af"+
		"\u01b1\5\u0087D\2\u01b0\u01ae\3\2\2\2\u01b0\u01af\3\2\2\2\u01b1\u0086"+
		"\3\2\2\2\u01b2\u01b3\7w\2\2\u01b3\u01b4\5\u0089E\2\u01b4\u01b5\5\u0089"+
		"E\2\u01b5\u01b6\5\u0089E\2\u01b6\u01b7\5\u0089E\2\u01b7\u0088\3\2\2\2"+
		"\u01b8\u01b9\t\n\2\2\u01b9\u008a\3\2\2\2\25\2\u0091\u009e\u00a1\u0164"+
		"\u0169\u016e\u0170\u0178\u0180\u0187\u0189\u0192\u0195\u019b\u01a2\u01a4"+
		"\u01a9\u01b0\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}