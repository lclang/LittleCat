// Generated from D:/IdeaProjects/LittleCat/src/main/java/lclang\lclang.g4 by ANTLR 4.9.1
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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, WS=35, METHOD=36, BOOL=37, ID=38, STRING=39, 
		CHAR=40, HEX_LONG=41, LONG=42, DOUBLE=43, INTEGER=44;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
			"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "T__32", 
			"T__33", "WS", "METHOD", "BOOL", "ID", "STRING", "CHAR", "HEX_LONG", 
			"LONG", "DOUBLE", "INTEGER"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'\\'", "'('", "')'", "'||'", "'&&'", "'=='", "'!='", "'*'", "'/'", 
			"'+'", "'-'", "'^'", "','", "'()'", "'return'", "'['", "']'", "'[]'", 
			"'fixed'", "'if '", "':'", "'else'", "'='", "'.'", "';'", "'while '", 
			"'{'", "'}'", "'component'", "'class'", "'@'", "'use'", "'from'", "'global'", 
			null, "'method'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, "WS", 
			"METHOD", "BOOL", "ID", "STRING", "CHAR", "HEX_LONG", "LONG", "DOUBLE", 
			"INTEGER"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2.\u012b\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7"+
		"\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17"+
		"\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\23"+
		"\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26"+
		"\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3!\3!\3!\3!\3"+
		"\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\6$\u00d3\n$\r$\16"+
		"$\u00d4\3$\3$\3$\3$\3$\6$\u00dc\n$\r$\16$\u00dd\3$\3$\3$\6$\u00e3\n$\r"+
		"$\16$\u00e4\5$\u00e7\n$\3$\3$\3%\3%\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3"+
		"&\3&\3&\5&\u00fb\n&\3\'\6\'\u00fe\n\'\r\'\16\'\u00ff\3(\3(\6(\u0104\n"+
		"(\r(\16(\u0105\3(\3(\3)\3)\3)\3)\3*\3*\6*\u0110\n*\r*\16*\u0111\3+\6+"+
		"\u0115\n+\r+\16+\u0116\3+\3+\3,\7,\u011c\n,\f,\16,\u011f\13,\3,\3,\6,"+
		"\u0123\n,\r,\16,\u0124\3-\6-\u0128\n-\r-\16-\u0129\5\u00d4\u00dd\u0105"+
		"\2.\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.\3\2\7\4\2\f\f\17\17\5\2\13\f\17\17"+
		"\"\"\5\2//C\\c|\4\2\63;CH\3\2\62;\2\u0137\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
		"\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2"+
		"\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2"+
		"\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2"+
		"\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2"+
		"\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2"+
		"\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M"+
		"\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2"+
		"\2\2\3[\3\2\2\2\5]\3\2\2\2\7_\3\2\2\2\ta\3\2\2\2\13d\3\2\2\2\rg\3\2\2"+
		"\2\17j\3\2\2\2\21m\3\2\2\2\23o\3\2\2\2\25q\3\2\2\2\27s\3\2\2\2\31u\3\2"+
		"\2\2\33w\3\2\2\2\35y\3\2\2\2\37|\3\2\2\2!\u0083\3\2\2\2#\u0085\3\2\2\2"+
		"%\u0087\3\2\2\2\'\u008a\3\2\2\2)\u0090\3\2\2\2+\u0094\3\2\2\2-\u0096\3"+
		"\2\2\2/\u009b\3\2\2\2\61\u009d\3\2\2\2\63\u009f\3\2\2\2\65\u00a1\3\2\2"+
		"\2\67\u00a8\3\2\2\29\u00aa\3\2\2\2;\u00ac\3\2\2\2=\u00b6\3\2\2\2?\u00bc"+
		"\3\2\2\2A\u00be\3\2\2\2C\u00c2\3\2\2\2E\u00c7\3\2\2\2G\u00e6\3\2\2\2I"+
		"\u00ea\3\2\2\2K\u00fa\3\2\2\2M\u00fd\3\2\2\2O\u0101\3\2\2\2Q\u0109\3\2"+
		"\2\2S\u010d\3\2\2\2U\u0114\3\2\2\2W\u011d\3\2\2\2Y\u0127\3\2\2\2[\\\7"+
		"^\2\2\\\4\3\2\2\2]^\7*\2\2^\6\3\2\2\2_`\7+\2\2`\b\3\2\2\2ab\7~\2\2bc\7"+
		"~\2\2c\n\3\2\2\2de\7(\2\2ef\7(\2\2f\f\3\2\2\2gh\7?\2\2hi\7?\2\2i\16\3"+
		"\2\2\2jk\7#\2\2kl\7?\2\2l\20\3\2\2\2mn\7,\2\2n\22\3\2\2\2op\7\61\2\2p"+
		"\24\3\2\2\2qr\7-\2\2r\26\3\2\2\2st\7/\2\2t\30\3\2\2\2uv\7`\2\2v\32\3\2"+
		"\2\2wx\7.\2\2x\34\3\2\2\2yz\7*\2\2z{\7+\2\2{\36\3\2\2\2|}\7t\2\2}~\7g"+
		"\2\2~\177\7v\2\2\177\u0080\7w\2\2\u0080\u0081\7t\2\2\u0081\u0082\7p\2"+
		"\2\u0082 \3\2\2\2\u0083\u0084\7]\2\2\u0084\"\3\2\2\2\u0085\u0086\7_\2"+
		"\2\u0086$\3\2\2\2\u0087\u0088\7]\2\2\u0088\u0089\7_\2\2\u0089&\3\2\2\2"+
		"\u008a\u008b\7h\2\2\u008b\u008c\7k\2\2\u008c\u008d\7z\2\2\u008d\u008e"+
		"\7g\2\2\u008e\u008f\7f\2\2\u008f(\3\2\2\2\u0090\u0091\7k\2\2\u0091\u0092"+
		"\7h\2\2\u0092\u0093\7\"\2\2\u0093*\3\2\2\2\u0094\u0095\7<\2\2\u0095,\3"+
		"\2\2\2\u0096\u0097\7g\2\2\u0097\u0098\7n\2\2\u0098\u0099\7u\2\2\u0099"+
		"\u009a\7g\2\2\u009a.\3\2\2\2\u009b\u009c\7?\2\2\u009c\60\3\2\2\2\u009d"+
		"\u009e\7\60\2\2\u009e\62\3\2\2\2\u009f\u00a0\7=\2\2\u00a0\64\3\2\2\2\u00a1"+
		"\u00a2\7y\2\2\u00a2\u00a3\7j\2\2\u00a3\u00a4\7k\2\2\u00a4\u00a5\7n\2\2"+
		"\u00a5\u00a6\7g\2\2\u00a6\u00a7\7\"\2\2\u00a7\66\3\2\2\2\u00a8\u00a9\7"+
		"}\2\2\u00a98\3\2\2\2\u00aa\u00ab\7\177\2\2\u00ab:\3\2\2\2\u00ac\u00ad"+
		"\7e\2\2\u00ad\u00ae\7q\2\2\u00ae\u00af\7o\2\2\u00af\u00b0\7r\2\2\u00b0"+
		"\u00b1\7q\2\2\u00b1\u00b2\7p\2\2\u00b2\u00b3\7g\2\2\u00b3\u00b4\7p\2\2"+
		"\u00b4\u00b5\7v\2\2\u00b5<\3\2\2\2\u00b6\u00b7\7e\2\2\u00b7\u00b8\7n\2"+
		"\2\u00b8\u00b9\7c\2\2\u00b9\u00ba\7u\2\2\u00ba\u00bb\7u\2\2\u00bb>\3\2"+
		"\2\2\u00bc\u00bd\7B\2\2\u00bd@\3\2\2\2\u00be\u00bf\7w\2\2\u00bf\u00c0"+
		"\7u\2\2\u00c0\u00c1\7g\2\2\u00c1B\3\2\2\2\u00c2\u00c3\7h\2\2\u00c3\u00c4"+
		"\7t\2\2\u00c4\u00c5\7q\2\2\u00c5\u00c6\7o\2\2\u00c6D\3\2\2\2\u00c7\u00c8"+
		"\7i\2\2\u00c8\u00c9\7n\2\2\u00c9\u00ca\7q\2\2\u00ca\u00cb\7d\2\2\u00cb"+
		"\u00cc\7c\2\2\u00cc\u00cd\7n\2\2\u00cdF\3\2\2\2\u00ce\u00cf\7\61\2\2\u00cf"+
		"\u00d0\7\61\2\2\u00d0\u00d2\3\2\2\2\u00d1\u00d3\13\2\2\2\u00d2\u00d1\3"+
		"\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d5"+
		"\u00d6\3\2\2\2\u00d6\u00e7\t\2\2\2\u00d7\u00d8\7\61\2\2\u00d8\u00d9\7"+
		",\2\2\u00d9\u00db\3\2\2\2\u00da\u00dc\13\2\2\2\u00db\u00da\3\2\2\2\u00dc"+
		"\u00dd\3\2\2\2\u00dd\u00de\3\2\2\2\u00dd\u00db\3\2\2\2\u00de\u00df\3\2"+
		"\2\2\u00df\u00e0\7,\2\2\u00e0\u00e7\7\61\2\2\u00e1\u00e3\t\3\2\2\u00e2"+
		"\u00e1\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e5\3\2"+
		"\2\2\u00e5\u00e7\3\2\2\2\u00e6\u00ce\3\2\2\2\u00e6\u00d7\3\2\2\2\u00e6"+
		"\u00e2\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00e9\b$\2\2\u00e9H\3\2\2\2\u00ea"+
		"\u00eb\7o\2\2\u00eb\u00ec\7g\2\2\u00ec\u00ed\7v\2\2\u00ed\u00ee\7j\2\2"+
		"\u00ee\u00ef\7q\2\2\u00ef\u00f0\7f\2\2\u00f0J\3\2\2\2\u00f1\u00f2\7v\2"+
		"\2\u00f2\u00f3\7t\2\2\u00f3\u00f4\7w\2\2\u00f4\u00fb\7g\2\2\u00f5\u00f6"+
		"\7h\2\2\u00f6\u00f7\7c\2\2\u00f7\u00f8\7n\2\2\u00f8\u00f9\7u\2\2\u00f9"+
		"\u00fb\7g\2\2\u00fa\u00f1\3\2\2\2\u00fa\u00f5\3\2\2\2\u00fbL\3\2\2\2\u00fc"+
		"\u00fe\t\4\2\2\u00fd\u00fc\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u00fd\3\2"+
		"\2\2\u00ff\u0100\3\2\2\2\u0100N\3\2\2\2\u0101\u0103\7$\2\2\u0102\u0104"+
		"\13\2\2\2\u0103\u0102\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u0106\3\2\2\2"+
		"\u0105\u0103\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0108\7$\2\2\u0108P\3\2"+
		"\2\2\u0109\u010a\7)\2\2\u010a\u010b\13\2\2\2\u010b\u010c\7)\2\2\u010c"+
		"R\3\2\2\2\u010d\u010f\7%\2\2\u010e\u0110\t\5\2\2\u010f\u010e\3\2\2\2\u0110"+
		"\u0111\3\2\2\2\u0111\u010f\3\2\2\2\u0111\u0112\3\2\2\2\u0112T\3\2\2\2"+
		"\u0113\u0115\t\6\2\2\u0114\u0113\3\2\2\2\u0115\u0116\3\2\2\2\u0116\u0114"+
		"\3\2\2\2\u0116\u0117\3\2\2\2\u0117\u0118\3\2\2\2\u0118\u0119\7N\2\2\u0119"+
		"V\3\2\2\2\u011a\u011c\t\6\2\2\u011b\u011a\3\2\2\2\u011c\u011f\3\2\2\2"+
		"\u011d\u011b\3\2\2\2\u011d\u011e\3\2\2\2\u011e\u0120\3\2\2\2\u011f\u011d"+
		"\3\2\2\2\u0120\u0122\7\60\2\2\u0121\u0123\t\6\2\2\u0122\u0121\3\2\2\2"+
		"\u0123\u0124\3\2\2\2\u0124\u0122\3\2\2\2\u0124\u0125\3\2\2\2\u0125X\3"+
		"\2\2\2\u0126\u0128\t\6\2\2\u0127\u0126\3\2\2\2\u0128\u0129\3\2\2\2\u0129"+
		"\u0127\3\2\2\2\u0129\u012a\3\2\2\2\u012aZ\3\2\2\2\17\2\u00d4\u00dd\u00e4"+
		"\u00e6\u00fa\u00ff\u0105\u0111\u0116\u011d\u0124\u0129\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}