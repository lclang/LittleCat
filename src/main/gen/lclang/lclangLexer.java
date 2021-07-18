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
		T__17=18, T__18=19, T__19=20, WS=21, FUNCTION=22, ID=23, STRING=24, NUMBER=25;
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
			"T__17", "T__18", "T__19", "WS", "FUNCTION", "ID", "STRING", "NUMBER"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'\\'", "'('", "','", "')'", "'()'", "'return'", "'['", "']'", 
			"'='", "'.'", "';'", "'{'", "'}'", "'component'", "'class'", "'@'", "':'", 
			"'use'", "'from'", "'global'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "WS", "FUNCTION", 
			"ID", "STRING", "NUMBER"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\33\u009b\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3"+
		"\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\23\3\24\3\24\3"+
		"\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\6\26{\n\26\r\26"+
		"\16\26|\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u0088\n\27\3"+
		"\30\6\30\u008b\n\30\r\30\16\30\u008c\3\31\3\31\6\31\u0091\n\31\r\31\16"+
		"\31\u0092\3\31\3\31\3\32\6\32\u0098\n\32\r\32\16\32\u0099\3\u0092\2\33"+
		"\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20"+
		"\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\3\2\5\5\2\13\f\17"+
		"\17\"\"\3\2C|\3\2\62;\2\u009f\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t"+
		"\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2"+
		"\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2"+
		"\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2"+
		"+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\3\65\3\2\2\2"+
		"\5\67\3\2\2\2\79\3\2\2\2\t;\3\2\2\2\13=\3\2\2\2\r@\3\2\2\2\17G\3\2\2\2"+
		"\21I\3\2\2\2\23K\3\2\2\2\25M\3\2\2\2\27O\3\2\2\2\31Q\3\2\2\2\33S\3\2\2"+
		"\2\35U\3\2\2\2\37_\3\2\2\2!e\3\2\2\2#g\3\2\2\2%i\3\2\2\2\'m\3\2\2\2)r"+
		"\3\2\2\2+z\3\2\2\2-\u0087\3\2\2\2/\u008a\3\2\2\2\61\u008e\3\2\2\2\63\u0097"+
		"\3\2\2\2\65\66\7^\2\2\66\4\3\2\2\2\678\7*\2\28\6\3\2\2\29:\7.\2\2:\b\3"+
		"\2\2\2;<\7+\2\2<\n\3\2\2\2=>\7*\2\2>?\7+\2\2?\f\3\2\2\2@A\7t\2\2AB\7g"+
		"\2\2BC\7v\2\2CD\7w\2\2DE\7t\2\2EF\7p\2\2F\16\3\2\2\2GH\7]\2\2H\20\3\2"+
		"\2\2IJ\7_\2\2J\22\3\2\2\2KL\7?\2\2L\24\3\2\2\2MN\7\60\2\2N\26\3\2\2\2"+
		"OP\7=\2\2P\30\3\2\2\2QR\7}\2\2R\32\3\2\2\2ST\7\177\2\2T\34\3\2\2\2UV\7"+
		"e\2\2VW\7q\2\2WX\7o\2\2XY\7r\2\2YZ\7q\2\2Z[\7p\2\2[\\\7g\2\2\\]\7p\2\2"+
		"]^\7v\2\2^\36\3\2\2\2_`\7e\2\2`a\7n\2\2ab\7c\2\2bc\7u\2\2cd\7u\2\2d \3"+
		"\2\2\2ef\7B\2\2f\"\3\2\2\2gh\7<\2\2h$\3\2\2\2ij\7w\2\2jk\7u\2\2kl\7g\2"+
		"\2l&\3\2\2\2mn\7h\2\2no\7t\2\2op\7q\2\2pq\7o\2\2q(\3\2\2\2rs\7i\2\2st"+
		"\7n\2\2tu\7q\2\2uv\7d\2\2vw\7c\2\2wx\7n\2\2x*\3\2\2\2y{\t\2\2\2zy\3\2"+
		"\2\2{|\3\2\2\2|z\3\2\2\2|}\3\2\2\2}~\3\2\2\2~\177\b\26\2\2\177,\3\2\2"+
		"\2\u0080\u0088\7<\2\2\u0081\u0082\7o\2\2\u0082\u0083\7g\2\2\u0083\u0084"+
		"\7v\2\2\u0084\u0085\7j\2\2\u0085\u0086\7q\2\2\u0086\u0088\7f\2\2\u0087"+
		"\u0080\3\2\2\2\u0087\u0081\3\2\2\2\u0088.\3\2\2\2\u0089\u008b\t\3\2\2"+
		"\u008a\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008d"+
		"\3\2\2\2\u008d\60\3\2\2\2\u008e\u0090\7$\2\2\u008f\u0091\13\2\2\2\u0090"+
		"\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0093\3\2\2\2\u0092\u0090\3\2"+
		"\2\2\u0093\u0094\3\2\2\2\u0094\u0095\7$\2\2\u0095\62\3\2\2\2\u0096\u0098"+
		"\t\4\2\2\u0097\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u0097\3\2\2\2\u0099"+
		"\u009a\3\2\2\2\u009a\64\3\2\2\2\b\2|\u0087\u008c\u0092\u0099\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}