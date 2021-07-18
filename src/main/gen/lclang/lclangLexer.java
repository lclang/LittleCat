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
		T__17=18, T__18=19, T__19=20, WS=21, METHOD=22, ID=23, STRING=24, LONG=25, 
		INTEGER=26;
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
			"T__17", "T__18", "T__19", "WS", "METHOD", "ID", "STRING", "LONG", "INTEGER"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'\\'", "'('", "','", "')'", "'()'", "'return'", "'['", "']'", 
			"'='", "'.'", "';'", "'{'", "'}'", "'component'", "'class'", "'@'", "':'", 
			"'use'", "'from'", "'global'", null, "'method'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "WS", "METHOD", 
			"ID", "STRING", "LONG", "INTEGER"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\34\u00a2\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f"+
		"\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\23\3"+
		"\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\6\26}"+
		"\n\26\r\26\16\26~\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\6"+
		"\30\u008b\n\30\r\30\16\30\u008c\3\31\3\31\6\31\u0091\n\31\r\31\16\31\u0092"+
		"\3\31\3\31\3\32\6\32\u0098\n\32\r\32\16\32\u0099\3\32\3\32\3\33\6\33\u009f"+
		"\n\33\r\33\16\33\u00a0\3\u0092\2\34\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n"+
		"\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\3\2\5\5\2\13\f\17\17\"\"\3\2C|\3\2\62;\2\u00a6"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\3\67\3\2\2\2\59\3\2\2\2\7;\3"+
		"\2\2\2\t=\3\2\2\2\13?\3\2\2\2\rB\3\2\2\2\17I\3\2\2\2\21K\3\2\2\2\23M\3"+
		"\2\2\2\25O\3\2\2\2\27Q\3\2\2\2\31S\3\2\2\2\33U\3\2\2\2\35W\3\2\2\2\37"+
		"a\3\2\2\2!g\3\2\2\2#i\3\2\2\2%k\3\2\2\2\'o\3\2\2\2)t\3\2\2\2+|\3\2\2\2"+
		"-\u0082\3\2\2\2/\u008a\3\2\2\2\61\u008e\3\2\2\2\63\u0097\3\2\2\2\65\u009e"+
		"\3\2\2\2\678\7^\2\28\4\3\2\2\29:\7*\2\2:\6\3\2\2\2;<\7.\2\2<\b\3\2\2\2"+
		"=>\7+\2\2>\n\3\2\2\2?@\7*\2\2@A\7+\2\2A\f\3\2\2\2BC\7t\2\2CD\7g\2\2DE"+
		"\7v\2\2EF\7w\2\2FG\7t\2\2GH\7p\2\2H\16\3\2\2\2IJ\7]\2\2J\20\3\2\2\2KL"+
		"\7_\2\2L\22\3\2\2\2MN\7?\2\2N\24\3\2\2\2OP\7\60\2\2P\26\3\2\2\2QR\7=\2"+
		"\2R\30\3\2\2\2ST\7}\2\2T\32\3\2\2\2UV\7\177\2\2V\34\3\2\2\2WX\7e\2\2X"+
		"Y\7q\2\2YZ\7o\2\2Z[\7r\2\2[\\\7q\2\2\\]\7p\2\2]^\7g\2\2^_\7p\2\2_`\7v"+
		"\2\2`\36\3\2\2\2ab\7e\2\2bc\7n\2\2cd\7c\2\2de\7u\2\2ef\7u\2\2f \3\2\2"+
		"\2gh\7B\2\2h\"\3\2\2\2ij\7<\2\2j$\3\2\2\2kl\7w\2\2lm\7u\2\2mn\7g\2\2n"+
		"&\3\2\2\2op\7h\2\2pq\7t\2\2qr\7q\2\2rs\7o\2\2s(\3\2\2\2tu\7i\2\2uv\7n"+
		"\2\2vw\7q\2\2wx\7d\2\2xy\7c\2\2yz\7n\2\2z*\3\2\2\2{}\t\2\2\2|{\3\2\2\2"+
		"}~\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177\u0080\3\2\2\2\u0080\u0081\b\26\2"+
		"\2\u0081,\3\2\2\2\u0082\u0083\7o\2\2\u0083\u0084\7g\2\2\u0084\u0085\7"+
		"v\2\2\u0085\u0086\7j\2\2\u0086\u0087\7q\2\2\u0087\u0088\7f\2\2\u0088."+
		"\3\2\2\2\u0089\u008b\t\3\2\2\u008a\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c"+
		"\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\60\3\2\2\2\u008e\u0090\7$\2\2"+
		"\u008f\u0091\13\2\2\2\u0090\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0093"+
		"\3\2\2\2\u0092\u0090\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0095\7$\2\2\u0095"+
		"\62\3\2\2\2\u0096\u0098\t\4\2\2\u0097\u0096\3\2\2\2\u0098\u0099\3\2\2"+
		"\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u009c"+
		"\7N\2\2\u009c\64\3\2\2\2\u009d\u009f\t\4\2\2\u009e\u009d\3\2\2\2\u009f"+
		"\u00a0\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\66\3\2\2"+
		"\2\b\2~\u008c\u0092\u0099\u00a0\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}