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
		LEFT_SHIFT=18, RIGHT_SHIFT=19, NULLABLE_OR=20, NULLABLE=21, LAMBDA_PREFIX=22, 
		TYPE_PREFIX=23, COMMA=24, SEMICOLON=25, ASSIGN=26, XOR=27, OR=28, AND=29, 
		COMPLIMENT=30, NOT=31, LESS=32, LARGER=33, MULTIPLICATION=34, DIVISION=35, 
		ADD=36, MINUS=37, COLON=38, DOT=39, AS_ATTR=40, GLOBAL=41, METHOD=42, 
		USE=43, CLASS=44, FROM=45, EXTENDS=46, COMPONENT=47, STOP=48, RETURN=49, 
		WHILE=50, AS=51, IF=52, IS=53, ELSE=54, BOOL=55, ID=56, STRING=57, CHAR=58, 
		HEX_LONG=59, LONG=60, DOUBLE=61, INTEGER=62, WS=63;
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
			"EXTENDS", "COMPONENT", "STOP", "RETURN", "WHILE", "AS", "IF", "IS", 
			"ELSE", "BOOL", "ID", "STRING", "CHAR", "HEX_LONG", "LONG", "DOUBLE", 
			"INTEGER", "WS", "ESC", "UNICODE", "HEX"
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
			"'component'", "'stop'", "'return'", "'while'", "'as'", "'if'", "'is'", 
			"'else'"
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
			"EXTENDS", "COMPONENT", "STOP", "RETURN", "WHILE", "AS", "IF", "IS", 
			"ELSE", "BOOL", "ID", "STRING", "CHAR", "HEX_LONG", "LONG", "DOUBLE", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2A\u01a8\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\3\2\3\2\3\2\3\2\6\2\u008c\n\2\r\2"+
		"\16\2\u008d\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\6\3\u0099\n\3\r\3\16\3"+
		"\u009a\3\3\5\3\u009e\n\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3"+
		"\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16"+
		"\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23"+
		"\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\30"+
		"\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37"+
		"\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)"+
		"\3*\3*\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3+\3,\3,\3,\3,\3-\3-\3-\3-\3-"+
		"\3-\3.\3.\3.\3.\3.\3/\3/\3/\3/\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\60\3"+
		"\60\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3"+
		"\62\3\62\3\62\3\63\3\63\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3\65\3\65\3"+
		"\65\3\66\3\66\3\66\3\67\3\67\3\67\3\67\3\67\38\38\38\38\38\38\38\38\3"+
		"8\58\u0153\n8\39\69\u0156\n9\r9\169\u0157\3:\3:\3:\7:\u015d\n:\f:\16:"+
		"\u0160\13:\3:\3:\3;\3;\3;\5;\u0167\n;\3;\3;\3<\3<\6<\u016d\n<\r<\16<\u016e"+
		"\3=\3=\3=\6=\u0174\n=\r=\16=\u0175\5=\u0178\n=\3=\3=\3>\3>\3>\7>\u017f"+
		"\n>\f>\16>\u0182\13>\5>\u0184\n>\3>\3>\6>\u0188\n>\r>\16>\u0189\3?\3?"+
		"\3?\6?\u018f\n?\r?\16?\u0190\5?\u0193\n?\3@\6@\u0196\n@\r@\16@\u0197\3"+
		"@\3@\3A\3A\3A\5A\u019f\nA\3B\3B\3B\3B\3B\3B\3C\3C\4\u008d\u009a\2D\3\3"+
		"\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!"+
		"A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s"+
		";u<w=y>{?}@\177A\u0081\2\u0083\2\u0085\2\3\2\13\4\3\f\f\17\17\5\2C\\a"+
		"ac|\4\2$$^^\4\2))^^\3\2\62;\3\2\63;\5\2\13\f\17\17\"\"\n\2$$))\61\61^"+
		"^ddppttvv\4\2\62;Ch\2\u01b5\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2"+
		"\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37"+
		"\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3"+
		"\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2"+
		"\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C"+
		"\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2"+
		"\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2"+
		"\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i"+
		"\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2"+
		"\2\2\2w\3\2\2\2\2y\3\2\2\2\2{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\3\u0087"+
		"\3\2\2\2\5\u0094\3\2\2\2\7\u00a1\3\2\2\2\t\u00a3\3\2\2\2\13\u00a5\3\2"+
		"\2\2\r\u00a7\3\2\2\2\17\u00a9\3\2\2\2\21\u00ab\3\2\2\2\23\u00ad\3\2\2"+
		"\2\25\u00b0\3\2\2\2\27\u00b3\3\2\2\2\31\u00b6\3\2\2\2\33\u00b9\3\2\2\2"+
		"\35\u00bc\3\2\2\2\37\u00bf\3\2\2\2!\u00c2\3\2\2\2#\u00c5\3\2\2\2%\u00c8"+
		"\3\2\2\2\'\u00cb\3\2\2\2)\u00ce\3\2\2\2+\u00d1\3\2\2\2-\u00d3\3\2\2\2"+
		"/\u00d6\3\2\2\2\61\u00d8\3\2\2\2\63\u00da\3\2\2\2\65\u00dc\3\2\2\2\67"+
		"\u00de\3\2\2\29\u00e0\3\2\2\2;\u00e2\3\2\2\2=\u00e4\3\2\2\2?\u00e6\3\2"+
		"\2\2A\u00e8\3\2\2\2C\u00ea\3\2\2\2E\u00ec\3\2\2\2G\u00ee\3\2\2\2I\u00f0"+
		"\3\2\2\2K\u00f2\3\2\2\2M\u00f4\3\2\2\2O\u00f6\3\2\2\2Q\u00f8\3\2\2\2S"+
		"\u00fa\3\2\2\2U\u0101\3\2\2\2W\u0108\3\2\2\2Y\u010c\3\2\2\2[\u0112\3\2"+
		"\2\2]\u0117\3\2\2\2_\u011f\3\2\2\2a\u0129\3\2\2\2c\u012e\3\2\2\2e\u0135"+
		"\3\2\2\2g\u013b\3\2\2\2i\u013e\3\2\2\2k\u0141\3\2\2\2m\u0144\3\2\2\2o"+
		"\u0152\3\2\2\2q\u0155\3\2\2\2s\u0159\3\2\2\2u\u0163\3\2\2\2w\u016a\3\2"+
		"\2\2y\u0177\3\2\2\2{\u0183\3\2\2\2}\u0192\3\2\2\2\177\u0195\3\2\2\2\u0081"+
		"\u019b\3\2\2\2\u0083\u01a0\3\2\2\2\u0085\u01a6\3\2\2\2\u0087\u0088\7\61"+
		"\2\2\u0088\u0089\7,\2\2\u0089\u008b\3\2\2\2\u008a\u008c\13\2\2\2\u008b"+
		"\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008e\3\2\2\2\u008d\u008b\3\2"+
		"\2\2\u008e\u008f\3\2\2\2\u008f\u0090\7,\2\2\u0090\u0091\7\61\2\2\u0091"+
		"\u0092\3\2\2\2\u0092\u0093\b\2\2\2\u0093\4\3\2\2\2\u0094\u0095\7\61\2"+
		"\2\u0095\u0096\7\61\2\2\u0096\u0098\3\2\2\2\u0097\u0099\13\2\2\2\u0098"+
		"\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009b\3\2\2\2\u009a\u0098\3\2"+
		"\2\2\u009b\u009d\3\2\2\2\u009c\u009e\t\2\2\2\u009d\u009c\3\2\2\2\u009e"+
		"\u009f\3\2\2\2\u009f\u00a0\b\3\2\2\u00a0\6\3\2\2\2\u00a1\u00a2\7*\2\2"+
		"\u00a2\b\3\2\2\2\u00a3\u00a4\7+\2\2\u00a4\n\3\2\2\2\u00a5\u00a6\7}\2\2"+
		"\u00a6\f\3\2\2\2\u00a7\u00a8\7\177\2\2\u00a8\16\3\2\2\2\u00a9\u00aa\7"+
		"]\2\2\u00aa\20\3\2\2\2\u00ab\u00ac\7_\2\2\u00ac\22\3\2\2\2\u00ad\u00ae"+
		"\7,\2\2\u00ae\u00af\7,\2\2\u00af\24\3\2\2\2\u00b0\u00b1\7?\2\2\u00b1\u00b2"+
		"\7?\2\2\u00b2\26\3\2\2\2\u00b3\u00b4\7#\2\2\u00b4\u00b5\7?\2\2\u00b5\30"+
		"\3\2\2\2\u00b6\u00b7\7(\2\2\u00b7\u00b8\7(\2\2\u00b8\32\3\2\2\2\u00b9"+
		"\u00ba\7~\2\2\u00ba\u00bb\7~\2\2\u00bb\34\3\2\2\2\u00bc\u00bd\7>\2\2\u00bd"+
		"\u00be\7?\2\2\u00be\36\3\2\2\2\u00bf\u00c0\7@\2\2\u00c0\u00c1\7?\2\2\u00c1"+
		" \3\2\2\2\u00c2\u00c3\7-\2\2\u00c3\u00c4\7-\2\2\u00c4\"\3\2\2\2\u00c5"+
		"\u00c6\7/\2\2\u00c6\u00c7\7/\2\2\u00c7$\3\2\2\2\u00c8\u00c9\7>\2\2\u00c9"+
		"\u00ca\7>\2\2\u00ca&\3\2\2\2\u00cb\u00cc\7@\2\2\u00cc\u00cd\7@\2\2\u00cd"+
		"(\3\2\2\2\u00ce\u00cf\7A\2\2\u00cf\u00d0\7<\2\2\u00d0*\3\2\2\2\u00d1\u00d2"+
		"\7A\2\2\u00d2,\3\2\2\2\u00d3\u00d4\7/\2\2\u00d4\u00d5\7@\2\2\u00d5.\3"+
		"\2\2\2\u00d6\u00d7\7^\2\2\u00d7\60\3\2\2\2\u00d8\u00d9\7.\2\2\u00d9\62"+
		"\3\2\2\2\u00da\u00db\7=\2\2\u00db\64\3\2\2\2\u00dc\u00dd\7?\2\2\u00dd"+
		"\66\3\2\2\2\u00de\u00df\7`\2\2\u00df8\3\2\2\2\u00e0\u00e1\7~\2\2\u00e1"+
		":\3\2\2\2\u00e2\u00e3\7(\2\2\u00e3<\3\2\2\2\u00e4\u00e5\7\u0080\2\2\u00e5"+
		">\3\2\2\2\u00e6\u00e7\7#\2\2\u00e7@\3\2\2\2\u00e8\u00e9\7>\2\2\u00e9B"+
		"\3\2\2\2\u00ea\u00eb\7@\2\2\u00ebD\3\2\2\2\u00ec\u00ed\7,\2\2\u00edF\3"+
		"\2\2\2\u00ee\u00ef\7\61\2\2\u00efH\3\2\2\2\u00f0\u00f1\7-\2\2\u00f1J\3"+
		"\2\2\2\u00f2\u00f3\7/\2\2\u00f3L\3\2\2\2\u00f4\u00f5\7<\2\2\u00f5N\3\2"+
		"\2\2\u00f6\u00f7\7\60\2\2\u00f7P\3\2\2\2\u00f8\u00f9\7B\2\2\u00f9R\3\2"+
		"\2\2\u00fa\u00fb\7i\2\2\u00fb\u00fc\7n\2\2\u00fc\u00fd\7q\2\2\u00fd\u00fe"+
		"\7d\2\2\u00fe\u00ff\7c\2\2\u00ff\u0100\7n\2\2\u0100T\3\2\2\2\u0101\u0102"+
		"\7o\2\2\u0102\u0103\7g\2\2\u0103\u0104\7v\2\2\u0104\u0105\7j\2\2\u0105"+
		"\u0106\7q\2\2\u0106\u0107\7f\2\2\u0107V\3\2\2\2\u0108\u0109\7w\2\2\u0109"+
		"\u010a\7u\2\2\u010a\u010b\7g\2\2\u010bX\3\2\2\2\u010c\u010d\7e\2\2\u010d"+
		"\u010e\7n\2\2\u010e\u010f\7c\2\2\u010f\u0110\7u\2\2\u0110\u0111\7u\2\2"+
		"\u0111Z\3\2\2\2\u0112\u0113\7h\2\2\u0113\u0114\7t\2\2\u0114\u0115\7q\2"+
		"\2\u0115\u0116\7o\2\2\u0116\\\3\2\2\2\u0117\u0118\7g\2\2\u0118\u0119\7"+
		"z\2\2\u0119\u011a\7v\2\2\u011a\u011b\7g\2\2\u011b\u011c\7p\2\2\u011c\u011d"+
		"\7f\2\2\u011d\u011e\7u\2\2\u011e^\3\2\2\2\u011f\u0120\7e\2\2\u0120\u0121"+
		"\7q\2\2\u0121\u0122\7o\2\2\u0122\u0123\7r\2\2\u0123\u0124\7q\2\2\u0124"+
		"\u0125\7p\2\2\u0125\u0126\7g\2\2\u0126\u0127\7p\2\2\u0127\u0128\7v\2\2"+
		"\u0128`\3\2\2\2\u0129\u012a\7u\2\2\u012a\u012b\7v\2\2\u012b\u012c\7q\2"+
		"\2\u012c\u012d\7r\2\2\u012db\3\2\2\2\u012e\u012f\7t\2\2\u012f\u0130\7"+
		"g\2\2\u0130\u0131\7v\2\2\u0131\u0132\7w\2\2\u0132\u0133\7t\2\2\u0133\u0134"+
		"\7p\2\2\u0134d\3\2\2\2\u0135\u0136\7y\2\2\u0136\u0137\7j\2\2\u0137\u0138"+
		"\7k\2\2\u0138\u0139\7n\2\2\u0139\u013a\7g\2\2\u013af\3\2\2\2\u013b\u013c"+
		"\7c\2\2\u013c\u013d\7u\2\2\u013dh\3\2\2\2\u013e\u013f\7k\2\2\u013f\u0140"+
		"\7h\2\2\u0140j\3\2\2\2\u0141\u0142\7k\2\2\u0142\u0143\7u\2\2\u0143l\3"+
		"\2\2\2\u0144\u0145\7g\2\2\u0145\u0146\7n\2\2\u0146\u0147\7u\2\2\u0147"+
		"\u0148\7g\2\2\u0148n\3\2\2\2\u0149\u014a\7v\2\2\u014a\u014b\7t\2\2\u014b"+
		"\u014c\7w\2\2\u014c\u0153\7g\2\2\u014d\u014e\7h\2\2\u014e\u014f\7c\2\2"+
		"\u014f\u0150\7n\2\2\u0150\u0151\7u\2\2\u0151\u0153\7g\2\2\u0152\u0149"+
		"\3\2\2\2\u0152\u014d\3\2\2\2\u0153p\3\2\2\2\u0154\u0156\t\3\2\2\u0155"+
		"\u0154\3\2\2\2\u0156\u0157\3\2\2\2\u0157\u0155\3\2\2\2\u0157\u0158\3\2"+
		"\2\2\u0158r\3\2\2\2\u0159\u015e\7$\2\2\u015a\u015d\5\u0081A\2\u015b\u015d"+
		"\n\4\2\2\u015c\u015a\3\2\2\2\u015c\u015b\3\2\2\2\u015d\u0160\3\2\2\2\u015e"+
		"\u015c\3\2\2\2\u015e\u015f\3\2\2\2\u015f\u0161\3\2\2\2\u0160\u015e\3\2"+
		"\2\2\u0161\u0162\7$\2\2\u0162t\3\2\2\2\u0163\u0166\7)\2\2\u0164\u0167"+
		"\5\u0081A\2\u0165\u0167\n\5\2\2\u0166\u0164\3\2\2\2\u0166\u0165\3\2\2"+
		"\2\u0167\u0168\3\2\2\2\u0168\u0169\7)\2\2\u0169v\3\2\2\2\u016a\u016c\7"+
		"%\2\2\u016b\u016d\5\u0085C\2\u016c\u016b\3\2\2\2\u016d\u016e\3\2\2\2\u016e"+
		"\u016c\3\2\2\2\u016e\u016f\3\2\2\2\u016fx\3\2\2\2\u0170\u0178\t\6\2\2"+
		"\u0171\u0173\t\7\2\2\u0172\u0174\t\6\2\2\u0173\u0172\3\2\2\2\u0174\u0175"+
		"\3\2\2\2\u0175\u0173\3\2\2\2\u0175\u0176\3\2\2\2\u0176\u0178\3\2\2\2\u0177"+
		"\u0170\3\2\2\2\u0177\u0171\3\2\2\2\u0178\u0179\3\2\2\2\u0179\u017a\7N"+
		"\2\2\u017az\3\2\2\2\u017b\u0184\t\6\2\2\u017c\u0180\t\7\2\2\u017d\u017f"+
		"\t\6\2\2\u017e\u017d\3\2\2\2\u017f\u0182\3\2\2\2\u0180\u017e\3\2\2\2\u0180"+
		"\u0181\3\2\2\2\u0181\u0184\3\2\2\2\u0182\u0180\3\2\2\2\u0183\u017b\3\2"+
		"\2\2\u0183\u017c\3\2\2\2\u0184\u0185\3\2\2\2\u0185\u0187\7\60\2\2\u0186"+
		"\u0188\t\6\2\2\u0187\u0186\3\2\2\2\u0188\u0189\3\2\2\2\u0189\u0187\3\2"+
		"\2\2\u0189\u018a\3\2\2\2\u018a|\3\2\2\2\u018b\u0193\t\6\2\2\u018c\u018e"+
		"\t\7\2\2\u018d\u018f\t\6\2\2\u018e\u018d\3\2\2\2\u018f\u0190\3\2\2\2\u0190"+
		"\u018e\3\2\2\2\u0190\u0191\3\2\2\2\u0191\u0193\3\2\2\2\u0192\u018b\3\2"+
		"\2\2\u0192\u018c\3\2\2\2\u0193~\3\2\2\2\u0194\u0196\t\b\2\2\u0195\u0194"+
		"\3\2\2\2\u0196\u0197\3\2\2\2\u0197\u0195\3\2\2\2\u0197\u0198\3\2\2\2\u0198"+
		"\u0199\3\2\2\2\u0199\u019a\b@\2\2\u019a\u0080\3\2\2\2\u019b\u019e\7^\2"+
		"\2\u019c\u019f\t\t\2\2\u019d\u019f\5\u0083B\2\u019e\u019c\3\2\2\2\u019e"+
		"\u019d\3\2\2\2\u019f\u0082\3\2\2\2\u01a0\u01a1\7w\2\2\u01a1\u01a2\5\u0085"+
		"C\2\u01a2\u01a3\5\u0085C\2\u01a3\u01a4\5\u0085C\2\u01a4\u01a5\5\u0085"+
		"C\2\u01a5\u0084\3\2\2\2\u01a6\u01a7\t\n\2\2\u01a7\u0086\3\2\2\2\25\2\u008d"+
		"\u009a\u009d\u0152\u0157\u015c\u015e\u0166\u016e\u0175\u0177\u0180\u0183"+
		"\u0189\u0190\u0192\u0197\u019e\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}