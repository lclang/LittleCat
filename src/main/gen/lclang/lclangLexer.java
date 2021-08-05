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
		T__38=39, T__39=40, T__40=41, WS=42, METHOD=43, BOOL=44, ID=45, STRING=46, 
		CHAR=47, HEX_LONG=48, LONG=49, DOUBLE=50, INTEGER=51;
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
			"T__33", "T__34", "T__35", "T__36", "T__37", "T__38", "T__39", "T__40", 
			"WS", "METHOD", "BOOL", "ID", "STRING", "CHAR", "HEX_LONG", "LONG", "DOUBLE", 
			"INTEGER"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "','", "')'", "'()'", "'->'", "'\\'", "'||'", "'&&'", "'=='", 
			"'!='", "'<'", "'>'", "'>='", "'<='", "'*'", "'/'", "'+'", "'-'", "'^'", 
			"'return'", "'['", "']'", "'[]'", "'stop'", "'fixed'", "'{'", "'}'", 
			"'{}'", "'if '", "':'", "'else'", "'='", "'.'", "';'", "'while '", "'component'", 
			"'class'", "'@'", "'use'", "'global'", "'from'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "WS", "METHOD", "BOOL", "ID", "STRING", 
			"CHAR", "HEX_LONG", "LONG", "DOUBLE", "INTEGER"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\65\u0152\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\b\3\b"+
		"\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16"+
		"\3\16\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\30"+
		"\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\34"+
		"\3\34\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\37\3\37\3 \3 \3 \3 \3 \3!\3"+
		"!\3\"\3\"\3#\3#\3$\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3&"+
		"\3&\3&\3&\3&\3&\3\'\3\'\3(\3(\3(\3(\3)\3)\3)\3)\3)\3)\3)\3*\3*\3*\3*\3"+
		"*\3+\3+\3+\3+\6+\u00f6\n+\r+\16+\u00f7\3+\3+\3+\3+\3+\6+\u00ff\n+\r+\16"+
		"+\u0100\3+\3+\3+\6+\u0106\n+\r+\16+\u0107\5+\u010a\n+\3+\3+\3,\3,\3,\3"+
		",\3,\3,\3,\5,\u0115\n,\3-\3-\3-\3-\3-\3-\3-\3-\3-\5-\u0120\n-\3.\6.\u0123"+
		"\n.\r.\16.\u0124\3/\3/\6/\u0129\n/\r/\16/\u012a\5/\u012d\n/\3/\3/\3\60"+
		"\3\60\3\60\3\60\3\61\3\61\6\61\u0137\n\61\r\61\16\61\u0138\3\62\6\62\u013c"+
		"\n\62\r\62\16\62\u013d\3\62\3\62\3\63\7\63\u0143\n\63\f\63\16\63\u0146"+
		"\13\63\3\63\3\63\6\63\u014a\n\63\r\63\16\63\u014b\3\64\6\64\u014f\n\64"+
		"\r\64\16\64\u0150\5\u00f7\u0100\u012a\2\65\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+"+
		"\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+"+
		"U,W-Y.[/]\60_\61a\62c\63e\64g\65\3\2\7\4\2\f\f\17\17\5\2\13\f\17\17\""+
		"\"\4\2C\\c|\4\2\63;CH\3\2\62;\2\u0160\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2"+
		"\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2"+
		"\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3"+
		"\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3"+
		"\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65"+
		"\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3"+
		"\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2"+
		"\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2"+
		"[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3"+
		"\2\2\2\3i\3\2\2\2\5k\3\2\2\2\7m\3\2\2\2\to\3\2\2\2\13r\3\2\2\2\ru\3\2"+
		"\2\2\17w\3\2\2\2\21z\3\2\2\2\23}\3\2\2\2\25\u0080\3\2\2\2\27\u0083\3\2"+
		"\2\2\31\u0085\3\2\2\2\33\u0087\3\2\2\2\35\u008a\3\2\2\2\37\u008d\3\2\2"+
		"\2!\u008f\3\2\2\2#\u0091\3\2\2\2%\u0093\3\2\2\2\'\u0095\3\2\2\2)\u0097"+
		"\3\2\2\2+\u009e\3\2\2\2-\u00a0\3\2\2\2/\u00a2\3\2\2\2\61\u00a5\3\2\2\2"+
		"\63\u00aa\3\2\2\2\65\u00b0\3\2\2\2\67\u00b2\3\2\2\29\u00b4\3\2\2\2;\u00b7"+
		"\3\2\2\2=\u00bb\3\2\2\2?\u00bd\3\2\2\2A\u00c2\3\2\2\2C\u00c4\3\2\2\2E"+
		"\u00c6\3\2\2\2G\u00c8\3\2\2\2I\u00cf\3\2\2\2K\u00d9\3\2\2\2M\u00df\3\2"+
		"\2\2O\u00e1\3\2\2\2Q\u00e5\3\2\2\2S\u00ec\3\2\2\2U\u0109\3\2\2\2W\u0114"+
		"\3\2\2\2Y\u011f\3\2\2\2[\u0122\3\2\2\2]\u0126\3\2\2\2_\u0130\3\2\2\2a"+
		"\u0134\3\2\2\2c\u013b\3\2\2\2e\u0144\3\2\2\2g\u014e\3\2\2\2ij\7*\2\2j"+
		"\4\3\2\2\2kl\7.\2\2l\6\3\2\2\2mn\7+\2\2n\b\3\2\2\2op\7*\2\2pq\7+\2\2q"+
		"\n\3\2\2\2rs\7/\2\2st\7@\2\2t\f\3\2\2\2uv\7^\2\2v\16\3\2\2\2wx\7~\2\2"+
		"xy\7~\2\2y\20\3\2\2\2z{\7(\2\2{|\7(\2\2|\22\3\2\2\2}~\7?\2\2~\177\7?\2"+
		"\2\177\24\3\2\2\2\u0080\u0081\7#\2\2\u0081\u0082\7?\2\2\u0082\26\3\2\2"+
		"\2\u0083\u0084\7>\2\2\u0084\30\3\2\2\2\u0085\u0086\7@\2\2\u0086\32\3\2"+
		"\2\2\u0087\u0088\7@\2\2\u0088\u0089\7?\2\2\u0089\34\3\2\2\2\u008a\u008b"+
		"\7>\2\2\u008b\u008c\7?\2\2\u008c\36\3\2\2\2\u008d\u008e\7,\2\2\u008e "+
		"\3\2\2\2\u008f\u0090\7\61\2\2\u0090\"\3\2\2\2\u0091\u0092\7-\2\2\u0092"+
		"$\3\2\2\2\u0093\u0094\7/\2\2\u0094&\3\2\2\2\u0095\u0096\7`\2\2\u0096("+
		"\3\2\2\2\u0097\u0098\7t\2\2\u0098\u0099\7g\2\2\u0099\u009a\7v\2\2\u009a"+
		"\u009b\7w\2\2\u009b\u009c\7t\2\2\u009c\u009d\7p\2\2\u009d*\3\2\2\2\u009e"+
		"\u009f\7]\2\2\u009f,\3\2\2\2\u00a0\u00a1\7_\2\2\u00a1.\3\2\2\2\u00a2\u00a3"+
		"\7]\2\2\u00a3\u00a4\7_\2\2\u00a4\60\3\2\2\2\u00a5\u00a6\7u\2\2\u00a6\u00a7"+
		"\7v\2\2\u00a7\u00a8\7q\2\2\u00a8\u00a9\7r\2\2\u00a9\62\3\2\2\2\u00aa\u00ab"+
		"\7h\2\2\u00ab\u00ac\7k\2\2\u00ac\u00ad\7z\2\2\u00ad\u00ae\7g\2\2\u00ae"+
		"\u00af\7f\2\2\u00af\64\3\2\2\2\u00b0\u00b1\7}\2\2\u00b1\66\3\2\2\2\u00b2"+
		"\u00b3\7\177\2\2\u00b38\3\2\2\2\u00b4\u00b5\7}\2\2\u00b5\u00b6\7\177\2"+
		"\2\u00b6:\3\2\2\2\u00b7\u00b8\7k\2\2\u00b8\u00b9\7h\2\2\u00b9\u00ba\7"+
		"\"\2\2\u00ba<\3\2\2\2\u00bb\u00bc\7<\2\2\u00bc>\3\2\2\2\u00bd\u00be\7"+
		"g\2\2\u00be\u00bf\7n\2\2\u00bf\u00c0\7u\2\2\u00c0\u00c1\7g\2\2\u00c1@"+
		"\3\2\2\2\u00c2\u00c3\7?\2\2\u00c3B\3\2\2\2\u00c4\u00c5\7\60\2\2\u00c5"+
		"D\3\2\2\2\u00c6\u00c7\7=\2\2\u00c7F\3\2\2\2\u00c8\u00c9\7y\2\2\u00c9\u00ca"+
		"\7j\2\2\u00ca\u00cb\7k\2\2\u00cb\u00cc\7n\2\2\u00cc\u00cd\7g\2\2\u00cd"+
		"\u00ce\7\"\2\2\u00ceH\3\2\2\2\u00cf\u00d0\7e\2\2\u00d0\u00d1\7q\2\2\u00d1"+
		"\u00d2\7o\2\2\u00d2\u00d3\7r\2\2\u00d3\u00d4\7q\2\2\u00d4\u00d5\7p\2\2"+
		"\u00d5\u00d6\7g\2\2\u00d6\u00d7\7p\2\2\u00d7\u00d8\7v\2\2\u00d8J\3\2\2"+
		"\2\u00d9\u00da\7e\2\2\u00da\u00db\7n\2\2\u00db\u00dc\7c\2\2\u00dc\u00dd"+
		"\7u\2\2\u00dd\u00de\7u\2\2\u00deL\3\2\2\2\u00df\u00e0\7B\2\2\u00e0N\3"+
		"\2\2\2\u00e1\u00e2\7w\2\2\u00e2\u00e3\7u\2\2\u00e3\u00e4\7g\2\2\u00e4"+
		"P\3\2\2\2\u00e5\u00e6\7i\2\2\u00e6\u00e7\7n\2\2\u00e7\u00e8\7q\2\2\u00e8"+
		"\u00e9\7d\2\2\u00e9\u00ea\7c\2\2\u00ea\u00eb\7n\2\2\u00ebR\3\2\2\2\u00ec"+
		"\u00ed\7h\2\2\u00ed\u00ee\7t\2\2\u00ee\u00ef\7q\2\2\u00ef\u00f0\7o\2\2"+
		"\u00f0T\3\2\2\2\u00f1\u00f2\7\61\2\2\u00f2\u00f3\7\61\2\2\u00f3\u00f5"+
		"\3\2\2\2\u00f4\u00f6\13\2\2\2\u00f5\u00f4\3\2\2\2\u00f6\u00f7\3\2\2\2"+
		"\u00f7\u00f8\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u010a"+
		"\t\2\2\2\u00fa\u00fb\7\61\2\2\u00fb\u00fc\7,\2\2\u00fc\u00fe\3\2\2\2\u00fd"+
		"\u00ff\13\2\2\2\u00fe\u00fd\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0101\3"+
		"\2\2\2\u0100\u00fe\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0103\7,\2\2\u0103"+
		"\u010a\7\61\2\2\u0104\u0106\t\3\2\2\u0105\u0104\3\2\2\2\u0106\u0107\3"+
		"\2\2\2\u0107\u0105\3\2\2\2\u0107\u0108\3\2\2\2\u0108\u010a\3\2\2\2\u0109"+
		"\u00f1\3\2\2\2\u0109\u00fa\3\2\2\2\u0109\u0105\3\2\2\2\u010a\u010b\3\2"+
		"\2\2\u010b\u010c\b+\2\2\u010cV\3\2\2\2\u010d\u0115\7o\2\2\u010e\u010f"+
		"\7o\2\2\u010f\u0110\7g\2\2\u0110\u0111\7v\2\2\u0111\u0112\7j\2\2\u0112"+
		"\u0113\7q\2\2\u0113\u0115\7f\2\2\u0114\u010d\3\2\2\2\u0114\u010e\3\2\2"+
		"\2\u0115X\3\2\2\2\u0116\u0117\7v\2\2\u0117\u0118\7t\2\2\u0118\u0119\7"+
		"w\2\2\u0119\u0120\7g\2\2\u011a\u011b\7h\2\2\u011b\u011c\7c\2\2\u011c\u011d"+
		"\7n\2\2\u011d\u011e\7u\2\2\u011e\u0120\7g\2\2\u011f\u0116\3\2\2\2\u011f"+
		"\u011a\3\2\2\2\u0120Z\3\2\2\2\u0121\u0123\t\4\2\2\u0122\u0121\3\2\2\2"+
		"\u0123\u0124\3\2\2\2\u0124\u0122\3\2\2\2\u0124\u0125\3\2\2\2\u0125\\\3"+
		"\2\2\2\u0126\u012c\7$\2\2\u0127\u0129\13\2\2\2\u0128\u0127\3\2\2\2\u0129"+
		"\u012a\3\2\2\2\u012a\u012b\3\2\2\2\u012a\u0128\3\2\2\2\u012b\u012d\3\2"+
		"\2\2\u012c\u0128\3\2\2\2\u012c\u012d\3\2\2\2\u012d\u012e\3\2\2\2\u012e"+
		"\u012f\7$\2\2\u012f^\3\2\2\2\u0130\u0131\7)\2\2\u0131\u0132\13\2\2\2\u0132"+
		"\u0133\7)\2\2\u0133`\3\2\2\2\u0134\u0136\7%\2\2\u0135\u0137\t\5\2\2\u0136"+
		"\u0135\3\2\2\2\u0137\u0138\3\2\2\2\u0138\u0136\3\2\2\2\u0138\u0139\3\2"+
		"\2\2\u0139b\3\2\2\2\u013a\u013c\t\6\2\2\u013b\u013a\3\2\2\2\u013c\u013d"+
		"\3\2\2\2\u013d\u013b\3\2\2\2\u013d\u013e\3\2\2\2\u013e\u013f\3\2\2\2\u013f"+
		"\u0140\7N\2\2\u0140d\3\2\2\2\u0141\u0143\t\6\2\2\u0142\u0141\3\2\2\2\u0143"+
		"\u0146\3\2\2\2\u0144\u0142\3\2\2\2\u0144\u0145\3\2\2\2\u0145\u0147\3\2"+
		"\2\2\u0146\u0144\3\2\2\2\u0147\u0149\7\60\2\2\u0148\u014a\t\6\2\2\u0149"+
		"\u0148\3\2\2\2\u014a\u014b\3\2\2\2\u014b\u0149\3\2\2\2\u014b\u014c\3\2"+
		"\2\2\u014cf\3\2\2\2\u014d\u014f\t\6\2\2\u014e\u014d\3\2\2\2\u014f\u0150"+
		"\3\2\2\2\u0150\u014e\3\2\2\2\u0150\u0151\3\2\2\2\u0151h\3\2\2\2\21\2\u00f7"+
		"\u0100\u0107\u0109\u0114\u011f\u0124\u012a\u012c\u0138\u013d\u0144\u014b"+
		"\u0150\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}