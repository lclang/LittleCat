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
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, WS=40, METHOD=41, BOOL=42, ID=43, STRING=44, CHAR=45, HEX_LONG=46, 
		LONG=47, DOUBLE=48, INTEGER=49;
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
			"T__33", "T__34", "T__35", "T__36", "T__37", "T__38", "WS", "METHOD", 
			"BOOL", "ID", "STRING", "CHAR", "HEX_LONG", "LONG", "DOUBLE", "INTEGER"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "','", "')'", "'->'", "'\\'", "'||'", "'&&'", "'=='", "'!='", 
			"'<'", "'>'", "'>='", "'<='", "'*'", "'/'", "'+'", "'-'", "'^'", "'()'", 
			"'return'", "'.'", "'[]'", "'['", "']'", "'stop'", "'{'", "'}'", "'if '", 
			"':'", "'else'", "'='", "';'", "'while '", "'component'", "'class'", 
			"'@'", "'use'", "'global'", "'from'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "WS", "METHOD", "BOOL", "ID", "STRING", "CHAR", 
			"HEX_LONG", "LONG", "DOUBLE", "INTEGER"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\63\u0145\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\3\2\3\2\3\3\3"+
		"\3\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\n"+
		"\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\20\3"+
		"\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3"+
		"\32\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3\36\3\37\3"+
		"\37\3\37\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3"+
		"#\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3%\3%\3&\3&\3&\3&\3\'\3\'\3\'\3"+
		"\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3)\3)\3)\3)\6)\u00e9\n)\r)\16)\u00ea\3)"+
		"\3)\3)\3)\3)\6)\u00f2\n)\r)\16)\u00f3\3)\3)\3)\6)\u00f9\n)\r)\16)\u00fa"+
		"\5)\u00fd\n)\3)\3)\3*\3*\3*\3*\3*\3*\3*\5*\u0108\n*\3+\3+\3+\3+\3+\3+"+
		"\3+\3+\3+\5+\u0113\n+\3,\6,\u0116\n,\r,\16,\u0117\3-\3-\6-\u011c\n-\r"+
		"-\16-\u011d\5-\u0120\n-\3-\3-\3.\3.\3.\3.\3/\3/\6/\u012a\n/\r/\16/\u012b"+
		"\3\60\6\60\u012f\n\60\r\60\16\60\u0130\3\60\3\60\3\61\7\61\u0136\n\61"+
		"\f\61\16\61\u0139\13\61\3\61\3\61\6\61\u013d\n\61\r\61\16\61\u013e\3\62"+
		"\6\62\u0142\n\62\r\62\16\62\u0143\5\u00ea\u00f3\u011d\2\63\3\3\5\4\7\5"+
		"\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G"+
		"%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63\3\2\7\4\2\f\f\17\17\5\2\13\f\17"+
		"\17\"\"\4\2C\\c|\4\2\63;CH\3\2\62;\2\u0153\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
		"\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2"+
		"\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2"+
		"\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2"+
		"\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2"+
		"\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2"+
		"\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M"+
		"\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2"+
		"\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\3e\3\2\2\2"+
		"\5g\3\2\2\2\7i\3\2\2\2\tk\3\2\2\2\13n\3\2\2\2\rp\3\2\2\2\17s\3\2\2\2\21"+
		"v\3\2\2\2\23y\3\2\2\2\25|\3\2\2\2\27~\3\2\2\2\31\u0080\3\2\2\2\33\u0083"+
		"\3\2\2\2\35\u0086\3\2\2\2\37\u0088\3\2\2\2!\u008a\3\2\2\2#\u008c\3\2\2"+
		"\2%\u008e\3\2\2\2\'\u0090\3\2\2\2)\u0093\3\2\2\2+\u009a\3\2\2\2-\u009c"+
		"\3\2\2\2/\u009f\3\2\2\2\61\u00a1\3\2\2\2\63\u00a3\3\2\2\2\65\u00a8\3\2"+
		"\2\2\67\u00aa\3\2\2\29\u00ac\3\2\2\2;\u00b0\3\2\2\2=\u00b2\3\2\2\2?\u00b7"+
		"\3\2\2\2A\u00b9\3\2\2\2C\u00bb\3\2\2\2E\u00c2\3\2\2\2G\u00cc\3\2\2\2I"+
		"\u00d2\3\2\2\2K\u00d4\3\2\2\2M\u00d8\3\2\2\2O\u00df\3\2\2\2Q\u00fc\3\2"+
		"\2\2S\u0107\3\2\2\2U\u0112\3\2\2\2W\u0115\3\2\2\2Y\u0119\3\2\2\2[\u0123"+
		"\3\2\2\2]\u0127\3\2\2\2_\u012e\3\2\2\2a\u0137\3\2\2\2c\u0141\3\2\2\2e"+
		"f\7*\2\2f\4\3\2\2\2gh\7.\2\2h\6\3\2\2\2ij\7+\2\2j\b\3\2\2\2kl\7/\2\2l"+
		"m\7@\2\2m\n\3\2\2\2no\7^\2\2o\f\3\2\2\2pq\7~\2\2qr\7~\2\2r\16\3\2\2\2"+
		"st\7(\2\2tu\7(\2\2u\20\3\2\2\2vw\7?\2\2wx\7?\2\2x\22\3\2\2\2yz\7#\2\2"+
		"z{\7?\2\2{\24\3\2\2\2|}\7>\2\2}\26\3\2\2\2~\177\7@\2\2\177\30\3\2\2\2"+
		"\u0080\u0081\7@\2\2\u0081\u0082\7?\2\2\u0082\32\3\2\2\2\u0083\u0084\7"+
		">\2\2\u0084\u0085\7?\2\2\u0085\34\3\2\2\2\u0086\u0087\7,\2\2\u0087\36"+
		"\3\2\2\2\u0088\u0089\7\61\2\2\u0089 \3\2\2\2\u008a\u008b\7-\2\2\u008b"+
		"\"\3\2\2\2\u008c\u008d\7/\2\2\u008d$\3\2\2\2\u008e\u008f\7`\2\2\u008f"+
		"&\3\2\2\2\u0090\u0091\7*\2\2\u0091\u0092\7+\2\2\u0092(\3\2\2\2\u0093\u0094"+
		"\7t\2\2\u0094\u0095\7g\2\2\u0095\u0096\7v\2\2\u0096\u0097\7w\2\2\u0097"+
		"\u0098\7t\2\2\u0098\u0099\7p\2\2\u0099*\3\2\2\2\u009a\u009b\7\60\2\2\u009b"+
		",\3\2\2\2\u009c\u009d\7]\2\2\u009d\u009e\7_\2\2\u009e.\3\2\2\2\u009f\u00a0"+
		"\7]\2\2\u00a0\60\3\2\2\2\u00a1\u00a2\7_\2\2\u00a2\62\3\2\2\2\u00a3\u00a4"+
		"\7u\2\2\u00a4\u00a5\7v\2\2\u00a5\u00a6\7q\2\2\u00a6\u00a7\7r\2\2\u00a7"+
		"\64\3\2\2\2\u00a8\u00a9\7}\2\2\u00a9\66\3\2\2\2\u00aa\u00ab\7\177\2\2"+
		"\u00ab8\3\2\2\2\u00ac\u00ad\7k\2\2\u00ad\u00ae\7h\2\2\u00ae\u00af\7\""+
		"\2\2\u00af:\3\2\2\2\u00b0\u00b1\7<\2\2\u00b1<\3\2\2\2\u00b2\u00b3\7g\2"+
		"\2\u00b3\u00b4\7n\2\2\u00b4\u00b5\7u\2\2\u00b5\u00b6\7g\2\2\u00b6>\3\2"+
		"\2\2\u00b7\u00b8\7?\2\2\u00b8@\3\2\2\2\u00b9\u00ba\7=\2\2\u00baB\3\2\2"+
		"\2\u00bb\u00bc\7y\2\2\u00bc\u00bd\7j\2\2\u00bd\u00be\7k\2\2\u00be\u00bf"+
		"\7n\2\2\u00bf\u00c0\7g\2\2\u00c0\u00c1\7\"\2\2\u00c1D\3\2\2\2\u00c2\u00c3"+
		"\7e\2\2\u00c3\u00c4\7q\2\2\u00c4\u00c5\7o\2\2\u00c5\u00c6\7r\2\2\u00c6"+
		"\u00c7\7q\2\2\u00c7\u00c8\7p\2\2\u00c8\u00c9\7g\2\2\u00c9\u00ca\7p\2\2"+
		"\u00ca\u00cb\7v\2\2\u00cbF\3\2\2\2\u00cc\u00cd\7e\2\2\u00cd\u00ce\7n\2"+
		"\2\u00ce\u00cf\7c\2\2\u00cf\u00d0\7u\2\2\u00d0\u00d1\7u\2\2\u00d1H\3\2"+
		"\2\2\u00d2\u00d3\7B\2\2\u00d3J\3\2\2\2\u00d4\u00d5\7w\2\2\u00d5\u00d6"+
		"\7u\2\2\u00d6\u00d7\7g\2\2\u00d7L\3\2\2\2\u00d8\u00d9\7i\2\2\u00d9\u00da"+
		"\7n\2\2\u00da\u00db\7q\2\2\u00db\u00dc\7d\2\2\u00dc\u00dd\7c\2\2\u00dd"+
		"\u00de\7n\2\2\u00deN\3\2\2\2\u00df\u00e0\7h\2\2\u00e0\u00e1\7t\2\2\u00e1"+
		"\u00e2\7q\2\2\u00e2\u00e3\7o\2\2\u00e3P\3\2\2\2\u00e4\u00e5\7\61\2\2\u00e5"+
		"\u00e6\7\61\2\2\u00e6\u00e8\3\2\2\2\u00e7\u00e9\13\2\2\2\u00e8\u00e7\3"+
		"\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00eb\3\2\2\2\u00ea\u00e8\3\2\2\2\u00eb"+
		"\u00ec\3\2\2\2\u00ec\u00fd\t\2\2\2\u00ed\u00ee\7\61\2\2\u00ee\u00ef\7"+
		",\2\2\u00ef\u00f1\3\2\2\2\u00f0\u00f2\13\2\2\2\u00f1\u00f0\3\2\2\2\u00f2"+
		"\u00f3\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f4\u00f5\3\2"+
		"\2\2\u00f5\u00f6\7,\2\2\u00f6\u00fd\7\61\2\2\u00f7\u00f9\t\3\2\2\u00f8"+
		"\u00f7\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fa\u00fb\3\2"+
		"\2\2\u00fb\u00fd\3\2\2\2\u00fc\u00e4\3\2\2\2\u00fc\u00ed\3\2\2\2\u00fc"+
		"\u00f8\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe\u00ff\b)\2\2\u00ffR\3\2\2\2\u0100"+
		"\u0108\7o\2\2\u0101\u0102\7o\2\2\u0102\u0103\7g\2\2\u0103\u0104\7v\2\2"+
		"\u0104\u0105\7j\2\2\u0105\u0106\7q\2\2\u0106\u0108\7f\2\2\u0107\u0100"+
		"\3\2\2\2\u0107\u0101\3\2\2\2\u0108T\3\2\2\2\u0109\u010a\7v\2\2\u010a\u010b"+
		"\7t\2\2\u010b\u010c\7w\2\2\u010c\u0113\7g\2\2\u010d\u010e\7h\2\2\u010e"+
		"\u010f\7c\2\2\u010f\u0110\7n\2\2\u0110\u0111\7u\2\2\u0111\u0113\7g\2\2"+
		"\u0112\u0109\3\2\2\2\u0112\u010d\3\2\2\2\u0113V\3\2\2\2\u0114\u0116\t"+
		"\4\2\2\u0115\u0114\3\2\2\2\u0116\u0117\3\2\2\2\u0117\u0115\3\2\2\2\u0117"+
		"\u0118\3\2\2\2\u0118X\3\2\2\2\u0119\u011f\7$\2\2\u011a\u011c\13\2\2\2"+
		"\u011b\u011a\3\2\2\2\u011c\u011d\3\2\2\2\u011d\u011e\3\2\2\2\u011d\u011b"+
		"\3\2\2\2\u011e\u0120\3\2\2\2\u011f\u011b\3\2\2\2\u011f\u0120\3\2\2\2\u0120"+
		"\u0121\3\2\2\2\u0121\u0122\7$\2\2\u0122Z\3\2\2\2\u0123\u0124\7)\2\2\u0124"+
		"\u0125\13\2\2\2\u0125\u0126\7)\2\2\u0126\\\3\2\2\2\u0127\u0129\7%\2\2"+
		"\u0128\u012a\t\5\2\2\u0129\u0128\3\2\2\2\u012a\u012b\3\2\2\2\u012b\u0129"+
		"\3\2\2\2\u012b\u012c\3\2\2\2\u012c^\3\2\2\2\u012d\u012f\t\6\2\2\u012e"+
		"\u012d\3\2\2\2\u012f\u0130\3\2\2\2\u0130\u012e\3\2\2\2\u0130\u0131\3\2"+
		"\2\2\u0131\u0132\3\2\2\2\u0132\u0133\7N\2\2\u0133`\3\2\2\2\u0134\u0136"+
		"\t\6\2\2\u0135\u0134\3\2\2\2\u0136\u0139\3\2\2\2\u0137\u0135\3\2\2\2\u0137"+
		"\u0138\3\2\2\2\u0138\u013a\3\2\2\2\u0139\u0137\3\2\2\2\u013a\u013c\7\60"+
		"\2\2\u013b\u013d\t\6\2\2\u013c\u013b\3\2\2\2\u013d\u013e\3\2\2\2\u013e"+
		"\u013c\3\2\2\2\u013e\u013f\3\2\2\2\u013fb\3\2\2\2\u0140\u0142\t\6\2\2"+
		"\u0141\u0140\3\2\2\2\u0142\u0143\3\2\2\2\u0143\u0141\3\2\2\2\u0143\u0144"+
		"\3\2\2\2\u0144d\3\2\2\2\21\2\u00ea\u00f3\u00fa\u00fc\u0107\u0112\u0117"+
		"\u011d\u011f\u012b\u0130\u0137\u013e\u0143\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}