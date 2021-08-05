// Generated from D:/IdeaProjects/LittleCat/src/main/java/lclang\lclang.g4 by ANTLR 4.9.1
package lclang;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class lclangParser extends Parser {
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
	public static final int
		RULE_file = 0, RULE_type = 1, RULE_methodType = 2, RULE_baseType = 3, 
		RULE_expression = 4, RULE_primitive = 5, RULE_value = 6, RULE_returnExpr = 7, 
		RULE_typeGet = 8, RULE_array = 9, RULE_arrayAccess = 10, RULE_stop = 11, 
		RULE_variable = 12, RULE_fixedVariable = 13, RULE_lambda = 14, RULE_container = 15, 
		RULE_ifExpr = 16, RULE_operation = 17, RULE_set = 18, RULE_access = 19, 
		RULE_stmt = 20, RULE_whileStmt = 21, RULE_ifStmt = 22, RULE_block = 23, 
		RULE_component = 24, RULE_classExpr = 25, RULE_field = 26, RULE_arg = 27, 
		RULE_args = 28, RULE_attribute = 29, RULE_method = 30, RULE_use = 31, 
		RULE_global = 32;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "type", "methodType", "baseType", "expression", "primitive", 
			"value", "returnExpr", "typeGet", "array", "arrayAccess", "stop", "variable", 
			"fixedVariable", "lambda", "container", "ifExpr", "operation", "set", 
			"access", "stmt", "whileStmt", "ifStmt", "block", "component", "classExpr", 
			"field", "arg", "args", "attribute", "method", "use", "global"
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

	@Override
	public String getGrammarFileName() { return "lclang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public lclangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class FileContext extends ParserRuleContext {
		public List<UseContext> use() {
			return getRuleContexts(UseContext.class);
		}
		public UseContext use(int i) {
			return getRuleContext(UseContext.class,i);
		}
		public List<GlobalContext> global() {
			return getRuleContexts(GlobalContext.class);
		}
		public GlobalContext global(int i) {
			return getRuleContext(GlobalContext.class,i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public List<MethodContext> method() {
			return getRuleContexts(MethodContext.class);
		}
		public MethodContext method(int i) {
			return getRuleContext(MethodContext.class,i);
		}
		public List<ComponentContext> component() {
			return getRuleContexts(ComponentContext.class);
		}
		public ComponentContext component(int i) {
			return getRuleContext(ComponentContext.class,i);
		}
		public List<ClassExprContext> classExpr() {
			return getRuleContexts(ClassExprContext.class);
		}
		public ClassExprContext classExpr(int i) {
			return getRuleContext(ClassExprContext.class,i);
		}
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).enterFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).exitFile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lclangVisitor ) return ((lclangVisitor<? extends T>)visitor).visitFile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__38) {
				{
				{
				setState(66);
				use();
				}
				}
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__39) {
				{
				{
				setState(72);
				global();
				}
				}
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__4) | (1L << T__14) | (1L << T__19) | (1L << T__20) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__27) | (1L << T__28) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << METHOD) | (1L << BOOL) | (1L << ID) | (1L << STRING) | (1L << CHAR) | (1L << HEX_LONG) | (1L << LONG) | (1L << DOUBLE) | (1L << INTEGER))) != 0)) {
				{
				setState(82);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
				case T__4:
				case T__14:
				case T__19:
				case T__20:
				case T__22:
				case T__23:
				case T__24:
				case T__25:
				case T__27:
				case T__28:
				case T__34:
				case BOOL:
				case ID:
				case STRING:
				case CHAR:
				case HEX_LONG:
				case LONG:
				case DOUBLE:
				case INTEGER:
					{
					setState(78);
					stmt();
					}
					break;
				case T__37:
				case METHOD:
					{
					setState(79);
					method();
					}
					break;
				case T__35:
					{
					setState(80);
					component();
					}
					break;
				case T__36:
					{
					setState(81);
					classExpr();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public MethodTypeContext methodType() {
			return getRuleContext(MethodTypeContext.class,0);
		}
		public BaseTypeContext baseType() {
			return getRuleContext(BaseTypeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lclangVisitor ) return ((lclangVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_type);
		try {
			setState(90);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
			case T__2:
			case T__25:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case T__0:
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(88);
				methodType();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 3);
				{
				setState(89);
				baseType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodTypeContext extends ParserRuleContext {
		public TypeContext returnType;
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public MethodTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).enterMethodType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).exitMethodType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lclangVisitor ) return ((lclangVisitor<? extends T>)visitor).visitMethodType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodTypeContext methodType() throws RecognitionException {
		MethodTypeContext _localctx = new MethodTypeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_methodType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				{
				setState(92);
				match(T__0);
				setState(93);
				type();
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(94);
					match(T__1);
					setState(95);
					type();
					}
					}
					setState(100);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(101);
				match(T__2);
				}
				break;
			case T__3:
				{
				setState(103);
				match(T__3);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(106);
			match(T__4);
			setState(107);
			((MethodTypeContext)_localctx).returnType = type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BaseTypeContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(lclangParser.ID, 0); }
		public BaseTypeContext baseType() {
			return getRuleContext(BaseTypeContext.class,0);
		}
		public BaseTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_baseType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).enterBaseType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).exitBaseType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lclangVisitor ) return ((lclangVisitor<? extends T>)visitor).visitBaseType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BaseTypeContext baseType() throws RecognitionException {
		BaseTypeContext _localctx = new BaseTypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_baseType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(ID);
			setState(112);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(110);
				match(T__5);
				setState(111);
				baseType();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public Token call;
		public Token or;
		public Token and;
		public Token equals;
		public Token notEquals;
		public Token less;
		public Token larger;
		public Token largerEquals;
		public Token lessEquals;
		public Token multiplication;
		public Token div;
		public Token add;
		public Token minus;
		public Token pow;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public PrimitiveContext primitive() {
			return getRuleContext(PrimitiveContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lclangVisitor ) return ((lclangVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(115);
				match(T__0);
				setState(116);
				expression(0);
				setState(117);
				match(T__2);
				}
				break;
			case 2:
				{
				setState(119);
				primitive();
				setState(132);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
					{
					setState(120);
					((ExpressionContext)_localctx).call = match(T__0);
					setState(121);
					expression(0);
					setState(126);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__1) {
						{
						{
						setState(122);
						match(T__1);
						setState(123);
						expression(0);
						}
						}
						setState(128);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(129);
					match(T__2);
					}
					break;
				case T__3:
					{
					setState(131);
					((ExpressionContext)_localctx).call = match(T__3);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 3:
				{
				setState(134);
				primitive();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(178);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(176);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(137);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(138);
						((ExpressionContext)_localctx).or = match(T__6);
						setState(139);
						expression(16);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(140);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(141);
						((ExpressionContext)_localctx).and = match(T__7);
						setState(142);
						expression(15);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(143);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(144);
						((ExpressionContext)_localctx).equals = match(T__8);
						setState(145);
						expression(14);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(146);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(147);
						((ExpressionContext)_localctx).notEquals = match(T__9);
						setState(148);
						expression(13);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(149);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(150);
						((ExpressionContext)_localctx).less = match(T__10);
						setState(151);
						expression(12);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(152);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(153);
						((ExpressionContext)_localctx).larger = match(T__11);
						setState(154);
						expression(11);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(155);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(156);
						((ExpressionContext)_localctx).largerEquals = match(T__12);
						setState(157);
						expression(10);
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(158);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(159);
						((ExpressionContext)_localctx).lessEquals = match(T__13);
						setState(160);
						expression(9);
						}
						break;
					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(161);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(162);
						((ExpressionContext)_localctx).multiplication = match(T__14);
						setState(163);
						expression(8);
						}
						break;
					case 10:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(164);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(165);
						((ExpressionContext)_localctx).div = match(T__15);
						setState(166);
						expression(7);
						}
						break;
					case 11:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(167);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(168);
						((ExpressionContext)_localctx).add = match(T__16);
						setState(169);
						expression(6);
						}
						break;
					case 12:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(170);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(171);
						((ExpressionContext)_localctx).minus = match(T__17);
						setState(172);
						expression(5);
						}
						break;
					case 13:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(173);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(174);
						((ExpressionContext)_localctx).pow = match(T__18);
						setState(175);
						expression(4);
						}
						break;
					}
					} 
				}
				setState(180);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PrimitiveContext extends ParserRuleContext {
		public IfExprContext ifExpr() {
			return getRuleContext(IfExprContext.class,0);
		}
		public ReturnExprContext returnExpr() {
			return getRuleContext(ReturnExprContext.class,0);
		}
		public FixedVariableContext fixedVariable() {
			return getRuleContext(FixedVariableContext.class,0);
		}
		public StopContext stop() {
			return getRuleContext(StopContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public ArrayContext array() {
			return getRuleContext(ArrayContext.class,0);
		}
		public TypeGetContext typeGet() {
			return getRuleContext(TypeGetContext.class,0);
		}
		public LambdaContext lambda() {
			return getRuleContext(LambdaContext.class,0);
		}
		public ContainerContext container() {
			return getRuleContext(ContainerContext.class,0);
		}
		public List<ArrayAccessContext> arrayAccess() {
			return getRuleContexts(ArrayAccessContext.class);
		}
		public ArrayAccessContext arrayAccess(int i) {
			return getRuleContext(ArrayAccessContext.class,i);
		}
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public PrimitiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitive; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).enterPrimitive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).exitPrimitive(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lclangVisitor ) return ((lclangVisitor<? extends T>)visitor).visitPrimitive(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimitiveContext primitive() throws RecognitionException {
		PrimitiveContext _localctx = new PrimitiveContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_primitive);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__28:
				{
				setState(181);
				ifExpr();
				}
				break;
			case T__19:
				{
				setState(182);
				returnExpr();
				}
				break;
			case T__24:
				{
				setState(183);
				fixedVariable();
				}
				break;
			case T__23:
				{
				setState(184);
				stop();
				}
				break;
			case BOOL:
			case STRING:
			case CHAR:
			case HEX_LONG:
			case LONG:
			case DOUBLE:
			case INTEGER:
				{
				setState(185);
				value();
				}
				break;
			case ID:
				{
				setState(186);
				variable();
				}
				break;
			case T__20:
			case T__22:
				{
				setState(187);
				array();
				}
				break;
			case T__14:
				{
				setState(188);
				typeGet();
				}
				break;
			case T__4:
				{
				setState(189);
				lambda();
				}
				break;
			case T__25:
			case T__27:
				{
				setState(190);
				container();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(196);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(193);
					arrayAccess();
					}
					} 
				}
				setState(198);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			setState(200);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(199);
				operation();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode HEX_LONG() { return getToken(lclangParser.HEX_LONG, 0); }
		public TerminalNode BOOL() { return getToken(lclangParser.BOOL, 0); }
		public TerminalNode STRING() { return getToken(lclangParser.STRING, 0); }
		public TerminalNode CHAR() { return getToken(lclangParser.CHAR, 0); }
		public TerminalNode DOUBLE() { return getToken(lclangParser.DOUBLE, 0); }
		public TerminalNode LONG() { return getToken(lclangParser.LONG, 0); }
		public TerminalNode INTEGER() { return getToken(lclangParser.INTEGER, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lclangVisitor ) return ((lclangVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << STRING) | (1L << CHAR) | (1L << HEX_LONG) | (1L << LONG) | (1L << DOUBLE) | (1L << INTEGER))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnExprContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).enterReturnExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).exitReturnExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lclangVisitor ) return ((lclangVisitor<? extends T>)visitor).visitReturnExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnExprContext returnExpr() throws RecognitionException {
		ReturnExprContext _localctx = new ReturnExprContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_returnExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			match(T__19);
			setState(206);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(205);
				expression(0);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeGetContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TypeGetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeGet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).enterTypeGet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).exitTypeGet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lclangVisitor ) return ((lclangVisitor<? extends T>)visitor).visitTypeGet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeGetContext typeGet() throws RecognitionException {
		TypeGetContext _localctx = new TypeGetContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_typeGet);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			match(T__14);
			setState(209);
			expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).enterArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).exitArray(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lclangVisitor ) return ((lclangVisitor<? extends T>)visitor).visitArray(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayContext array() throws RecognitionException {
		ArrayContext _localctx = new ArrayContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_array);
		int _la;
		try {
			setState(223);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__20:
				enterOuterAlt(_localctx, 1);
				{
				setState(211);
				match(T__20);
				setState(212);
				expression(0);
				setState(217);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(213);
					match(T__1);
					setState(214);
					expression(0);
					}
					}
					setState(219);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(220);
				match(T__21);
				}
				break;
			case T__22:
				enterOuterAlt(_localctx, 2);
				{
				setState(222);
				match(T__22);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayAccessContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArrayAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayAccess; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).enterArrayAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).exitArrayAccess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lclangVisitor ) return ((lclangVisitor<? extends T>)visitor).visitArrayAccess(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayAccessContext arrayAccess() throws RecognitionException {
		ArrayAccessContext _localctx = new ArrayAccessContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_arrayAccess);
		try {
			setState(230);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__20:
				enterOuterAlt(_localctx, 1);
				{
				setState(225);
				match(T__20);
				setState(226);
				expression(0);
				setState(227);
				match(T__21);
				}
				break;
			case T__22:
				enterOuterAlt(_localctx, 2);
				{
				setState(229);
				match(T__22);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StopContext extends ParserRuleContext {
		public StopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).enterStop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).exitStop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lclangVisitor ) return ((lclangVisitor<? extends T>)visitor).visitStop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StopContext stop() throws RecognitionException {
		StopContext _localctx = new StopContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_stop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			match(T__23);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(lclangParser.ID, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lclangVisitor ) return ((lclangVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FixedVariableContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(lclangParser.ID, 0); }
		public FixedVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fixedVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).enterFixedVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).exitFixedVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lclangVisitor ) return ((lclangVisitor<? extends T>)visitor).visitFixedVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FixedVariableContext fixedVariable() throws RecognitionException {
		FixedVariableContext _localctx = new FixedVariableContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_fixedVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			match(T__24);
			setState(237);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LambdaContext extends ParserRuleContext {
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LambdaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambda; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).enterLambda(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).exitLambda(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lclangVisitor ) return ((lclangVisitor<? extends T>)visitor).visitLambda(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LambdaContext lambda() throws RecognitionException {
		LambdaContext _localctx = new LambdaContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_lambda);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			match(T__4);
			setState(240);
			args();
			setState(241);
			expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ContainerContext extends ParserRuleContext {
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public ContainerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_container; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).enterContainer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).exitContainer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lclangVisitor ) return ((lclangVisitor<? extends T>)visitor).visitContainer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ContainerContext container() throws RecognitionException {
		ContainerContext _localctx = new ContainerContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_container);
		int _la;
		try {
			setState(252);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__25:
				enterOuterAlt(_localctx, 1);
				{
				setState(243);
				match(T__25);
				setState(247);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__4) | (1L << T__14) | (1L << T__19) | (1L << T__20) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__27) | (1L << T__28) | (1L << T__34) | (1L << BOOL) | (1L << ID) | (1L << STRING) | (1L << CHAR) | (1L << HEX_LONG) | (1L << LONG) | (1L << DOUBLE) | (1L << INTEGER))) != 0)) {
					{
					{
					setState(244);
					stmt();
					}
					}
					setState(249);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(250);
				match(T__26);
				}
				break;
			case T__27:
				enterOuterAlt(_localctx, 2);
				{
				setState(251);
				match(T__27);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfExprContext extends ParserRuleContext {
		public ExpressionContext condition;
		public ExpressionContext ifT;
		public ExpressionContext ifF;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public IfExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).enterIfExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).exitIfExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lclangVisitor ) return ((lclangVisitor<? extends T>)visitor).visitIfExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfExprContext ifExpr() throws RecognitionException {
		IfExprContext _localctx = new IfExprContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_ifExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			match(T__28);
			setState(255);
			((IfExprContext)_localctx).condition = expression(0);
			setState(256);
			match(T__29);
			setState(257);
			((IfExprContext)_localctx).ifT = expression(0);
			setState(258);
			match(T__30);
			setState(259);
			((IfExprContext)_localctx).ifF = expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperationContext extends ParserRuleContext {
		public AccessContext access() {
			return getRuleContext(AccessContext.class,0);
		}
		public SetContext set() {
			return getRuleContext(SetContext.class,0);
		}
		public OperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).enterOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).exitOperation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lclangVisitor ) return ((lclangVisitor<? extends T>)visitor).visitOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperationContext operation() throws RecognitionException {
		OperationContext _localctx = new OperationContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_operation);
		try {
			setState(263);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__32:
				enterOuterAlt(_localctx, 1);
				{
				setState(261);
				access();
				}
				break;
			case T__31:
				enterOuterAlt(_localctx, 2);
				{
				setState(262);
				set();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SetContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).enterSet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).exitSet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lclangVisitor ) return ((lclangVisitor<? extends T>)visitor).visitSet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetContext set() throws RecognitionException {
		SetContext _localctx = new SetContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_set);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			match(T__31);
			setState(266);
			expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AccessContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_access; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).enterAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).exitAccess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lclangVisitor ) return ((lclangVisitor<? extends T>)visitor).visitAccess(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AccessContext access() throws RecognitionException {
		AccessContext _localctx = new AccessContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_access);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			match(T__32);
			setState(269);
			expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public WhileStmtContext whileStmt() {
			return getRuleContext(WhileStmtContext.class,0);
		}
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).exitStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lclangVisitor ) return ((lclangVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_stmt);
		int _la;
		try {
			setState(278);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(271);
				block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(272);
				whileStmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(273);
				ifStmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(274);
				expression(0);
				setState(276);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__33) {
					{
					setState(275);
					match(T__33);
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhileStmtContext extends ParserRuleContext {
		public ExpressionContext condition;
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public WhileStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).enterWhileStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).exitWhileStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lclangVisitor ) return ((lclangVisitor<? extends T>)visitor).visitWhileStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStmtContext whileStmt() throws RecognitionException {
		WhileStmtContext _localctx = new WhileStmtContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_whileStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			match(T__34);
			setState(281);
			((WhileStmtContext)_localctx).condition = expression(0);
			setState(282);
			match(T__29);
			setState(283);
			stmt();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IfStmtContext extends ParserRuleContext {
		public ExpressionContext condition;
		public StmtContext ifT;
		public StmtContext ifF;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).enterIfStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).exitIfStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lclangVisitor ) return ((lclangVisitor<? extends T>)visitor).visitIfStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_ifStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
			match(T__28);
			setState(286);
			((IfStmtContext)_localctx).condition = expression(0);
			setState(287);
			match(T__29);
			setState(288);
			((IfStmtContext)_localctx).ifT = stmt();
			setState(291);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				{
				setState(289);
				match(T__30);
				setState(290);
				((IfStmtContext)_localctx).ifF = stmt();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lclangVisitor ) return ((lclangVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			match(T__25);
			setState(297);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__4) | (1L << T__14) | (1L << T__19) | (1L << T__20) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__27) | (1L << T__28) | (1L << T__34) | (1L << BOOL) | (1L << ID) | (1L << STRING) | (1L << CHAR) | (1L << HEX_LONG) | (1L << LONG) | (1L << DOUBLE) | (1L << INTEGER))) != 0)) {
				{
				{
				setState(294);
				stmt();
				}
				}
				setState(299);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(300);
			match(T__26);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ComponentContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<GlobalContext> global() {
			return getRuleContexts(GlobalContext.class);
		}
		public GlobalContext global(int i) {
			return getRuleContext(GlobalContext.class,i);
		}
		public List<ClassExprContext> classExpr() {
			return getRuleContexts(ClassExprContext.class);
		}
		public ClassExprContext classExpr(int i) {
			return getRuleContext(ClassExprContext.class,i);
		}
		public ComponentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_component; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).enterComponent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).exitComponent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lclangVisitor ) return ((lclangVisitor<? extends T>)visitor).visitComponent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComponentContext component() throws RecognitionException {
		ComponentContext _localctx = new ComponentContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_component);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			match(T__35);
			setState(303);
			type();
			setState(304);
			match(T__25);
			setState(308);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__39) {
				{
				{
				setState(305);
				global();
				}
				}
				setState(310);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(314);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__36) {
				{
				{
				setState(311);
				classExpr();
				}
				}
				setState(316);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(317);
			match(T__26);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassExprContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(lclangParser.ID, 0); }
		public List<MethodContext> method() {
			return getRuleContexts(MethodContext.class);
		}
		public MethodContext method(int i) {
			return getRuleContext(MethodContext.class,i);
		}
		public List<FieldContext> field() {
			return getRuleContexts(FieldContext.class);
		}
		public FieldContext field(int i) {
			return getRuleContext(FieldContext.class,i);
		}
		public ClassExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).enterClassExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).exitClassExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lclangVisitor ) return ((lclangVisitor<? extends T>)visitor).visitClassExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassExprContext classExpr() throws RecognitionException {
		ClassExprContext _localctx = new ClassExprContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_classExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(319);
			match(T__36);
			setState(320);
			match(ID);
			setState(321);
			match(T__25);
			setState(326);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__37) | (1L << METHOD) | (1L << ID))) != 0)) {
				{
				setState(324);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__37:
				case METHOD:
					{
					setState(322);
					method();
					}
					break;
				case ID:
					{
					setState(323);
					field();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(328);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(329);
			match(T__26);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(lclangParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).enterField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).exitField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lclangVisitor ) return ((lclangVisitor<? extends T>)visitor).visitField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(331);
			match(ID);
			setState(334);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__31) {
				{
				setState(332);
				match(T__31);
				setState(333);
				expression(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(lclangParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).enterArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).exitArg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lclangVisitor ) return ((lclangVisitor<? extends T>)visitor).visitArg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgContext arg() throws RecognitionException {
		ArgContext _localctx = new ArgContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_arg);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(336);
			match(ID);
			setState(339);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__29) {
				{
				setState(337);
				match(T__29);
				setState(338);
				type();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgsContext extends ParserRuleContext {
		public List<ArgContext> arg() {
			return getRuleContexts(ArgContext.class);
		}
		public ArgContext arg(int i) {
			return getRuleContext(ArgContext.class,i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).enterArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).exitArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lclangVisitor ) return ((lclangVisitor<? extends T>)visitor).visitArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_args);
		int _la;
		try {
			setState(353);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(341);
				match(T__0);
				setState(342);
				arg();
				setState(347);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(343);
					match(T__1);
					setState(344);
					arg();
					}
					}
					setState(349);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(350);
				match(T__2);
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(352);
				match(T__3);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributeContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(lclangParser.ID, 0); }
		public AttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).enterAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).exitAttribute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lclangVisitor ) return ((lclangVisitor<? extends T>)visitor).visitAttribute(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_attribute);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(355);
			match(T__37);
			setState(356);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MethodContext extends ParserRuleContext {
		public TerminalNode METHOD() { return getToken(lclangParser.METHOD, 0); }
		public TerminalNode ID() { return getToken(lclangParser.ID, 0); }
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public MethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).enterMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).exitMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lclangVisitor ) return ((lclangVisitor<? extends T>)visitor).visitMethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodContext method() throws RecognitionException {
		MethodContext _localctx = new MethodContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_method);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(361);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__37) {
				{
				{
				setState(358);
				attribute();
				}
				}
				setState(363);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(364);
			match(METHOD);
			setState(365);
			match(ID);
			setState(366);
			args();
			setState(369);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__29) {
				{
				setState(367);
				match(T__29);
				setState(368);
				type();
				}
			}

			setState(371);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UseContext extends ParserRuleContext {
		public Token useGlobal;
		public BaseTypeContext baseType() {
			return getRuleContext(BaseTypeContext.class,0);
		}
		public TerminalNode STRING() { return getToken(lclangParser.STRING, 0); }
		public UseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_use; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).enterUse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).exitUse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lclangVisitor ) return ((lclangVisitor<? extends T>)visitor).visitUse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UseContext use() throws RecognitionException {
		UseContext _localctx = new UseContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_use);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(373);
			match(T__38);
			setState(374);
			((UseContext)_localctx).useGlobal = match(T__39);
			setState(375);
			baseType();
			setState(376);
			match(T__40);
			setState(377);
			match(STRING);
			setState(379);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__33) {
				{
				setState(378);
				match(T__33);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GlobalContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(lclangParser.ID, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public GlobalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_global; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).enterGlobal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).exitGlobal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lclangVisitor ) return ((lclangVisitor<? extends T>)visitor).visitGlobal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GlobalContext global() throws RecognitionException {
		GlobalContext _localctx = new GlobalContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_global);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(381);
			match(T__39);
			setState(382);
			match(ID);
			setState(383);
			match(T__31);
			setState(384);
			value();
			setState(386);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__33) {
				{
				setState(385);
				match(T__33);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 15);
		case 1:
			return precpred(_ctx, 14);
		case 2:
			return precpred(_ctx, 13);
		case 3:
			return precpred(_ctx, 12);
		case 4:
			return precpred(_ctx, 11);
		case 5:
			return precpred(_ctx, 10);
		case 6:
			return precpred(_ctx, 9);
		case 7:
			return precpred(_ctx, 8);
		case 8:
			return precpred(_ctx, 7);
		case 9:
			return precpred(_ctx, 6);
		case 10:
			return precpred(_ctx, 5);
		case 11:
			return precpred(_ctx, 4);
		case 12:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\65\u0187\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\3\2\7\2F\n\2\f\2\16\2I\13\2\3\2\7\2L\n\2\f\2\16\2O\13\2\3"+
		"\2\3\2\3\2\3\2\7\2U\n\2\f\2\16\2X\13\2\3\3\3\3\3\3\5\3]\n\3\3\4\3\4\3"+
		"\4\3\4\7\4c\n\4\f\4\16\4f\13\4\3\4\3\4\3\4\5\4k\n\4\3\4\3\4\3\4\3\5\3"+
		"\5\3\5\5\5s\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\177\n\6\f"+
		"\6\16\6\u0082\13\6\3\6\3\6\3\6\5\6\u0087\n\6\3\6\5\6\u008a\n\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\7\6\u00b3\n\6\f\6\16\6\u00b6\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\5\7\u00c2\n\7\3\7\7\7\u00c5\n\7\f\7\16\7\u00c8\13\7\3\7\5"+
		"\7\u00cb\n\7\3\b\3\b\3\t\3\t\5\t\u00d1\n\t\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\7\13\u00da\n\13\f\13\16\13\u00dd\13\13\3\13\3\13\3\13\5\13\u00e2"+
		"\n\13\3\f\3\f\3\f\3\f\3\f\5\f\u00e9\n\f\3\r\3\r\3\16\3\16\3\17\3\17\3"+
		"\17\3\20\3\20\3\20\3\20\3\21\3\21\7\21\u00f8\n\21\f\21\16\21\u00fb\13"+
		"\21\3\21\3\21\5\21\u00ff\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23"+
		"\3\23\5\23\u010a\n\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\26"+
		"\3\26\5\26\u0117\n\26\5\26\u0119\n\26\3\27\3\27\3\27\3\27\3\27\3\30\3"+
		"\30\3\30\3\30\3\30\3\30\5\30\u0126\n\30\3\31\3\31\7\31\u012a\n\31\f\31"+
		"\16\31\u012d\13\31\3\31\3\31\3\32\3\32\3\32\3\32\7\32\u0135\n\32\f\32"+
		"\16\32\u0138\13\32\3\32\7\32\u013b\n\32\f\32\16\32\u013e\13\32\3\32\3"+
		"\32\3\33\3\33\3\33\3\33\3\33\7\33\u0147\n\33\f\33\16\33\u014a\13\33\3"+
		"\33\3\33\3\34\3\34\3\34\5\34\u0151\n\34\3\35\3\35\3\35\5\35\u0156\n\35"+
		"\3\36\3\36\3\36\3\36\7\36\u015c\n\36\f\36\16\36\u015f\13\36\3\36\3\36"+
		"\3\36\5\36\u0164\n\36\3\37\3\37\3\37\3 \7 \u016a\n \f \16 \u016d\13 \3"+
		" \3 \3 \3 \3 \5 \u0174\n \3 \3 \3!\3!\3!\3!\3!\3!\5!\u017e\n!\3\"\3\""+
		"\3\"\3\"\3\"\5\"\u0185\n\"\3\"\2\3\n#\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&(*,.\60\62\64\668:<>@B\2\3\4\2..\60\65\2\u01a5\2G\3\2\2\2\4"+
		"\\\3\2\2\2\6j\3\2\2\2\bo\3\2\2\2\n\u0089\3\2\2\2\f\u00c1\3\2\2\2\16\u00cc"+
		"\3\2\2\2\20\u00ce\3\2\2\2\22\u00d2\3\2\2\2\24\u00e1\3\2\2\2\26\u00e8\3"+
		"\2\2\2\30\u00ea\3\2\2\2\32\u00ec\3\2\2\2\34\u00ee\3\2\2\2\36\u00f1\3\2"+
		"\2\2 \u00fe\3\2\2\2\"\u0100\3\2\2\2$\u0109\3\2\2\2&\u010b\3\2\2\2(\u010e"+
		"\3\2\2\2*\u0118\3\2\2\2,\u011a\3\2\2\2.\u011f\3\2\2\2\60\u0127\3\2\2\2"+
		"\62\u0130\3\2\2\2\64\u0141\3\2\2\2\66\u014d\3\2\2\28\u0152\3\2\2\2:\u0163"+
		"\3\2\2\2<\u0165\3\2\2\2>\u016b\3\2\2\2@\u0177\3\2\2\2B\u017f\3\2\2\2D"+
		"F\5@!\2ED\3\2\2\2FI\3\2\2\2GE\3\2\2\2GH\3\2\2\2HM\3\2\2\2IG\3\2\2\2JL"+
		"\5B\"\2KJ\3\2\2\2LO\3\2\2\2MK\3\2\2\2MN\3\2\2\2NV\3\2\2\2OM\3\2\2\2PU"+
		"\5*\26\2QU\5> \2RU\5\62\32\2SU\5\64\33\2TP\3\2\2\2TQ\3\2\2\2TR\3\2\2\2"+
		"TS\3\2\2\2UX\3\2\2\2VT\3\2\2\2VW\3\2\2\2W\3\3\2\2\2XV\3\2\2\2Y]\3\2\2"+
		"\2Z]\5\6\4\2[]\5\b\5\2\\Y\3\2\2\2\\Z\3\2\2\2\\[\3\2\2\2]\5\3\2\2\2^_\7"+
		"\3\2\2_d\5\4\3\2`a\7\4\2\2ac\5\4\3\2b`\3\2\2\2cf\3\2\2\2db\3\2\2\2de\3"+
		"\2\2\2eg\3\2\2\2fd\3\2\2\2gh\7\5\2\2hk\3\2\2\2ik\7\6\2\2j^\3\2\2\2ji\3"+
		"\2\2\2kl\3\2\2\2lm\7\7\2\2mn\5\4\3\2n\7\3\2\2\2or\7/\2\2pq\7\b\2\2qs\5"+
		"\b\5\2rp\3\2\2\2rs\3\2\2\2s\t\3\2\2\2tu\b\6\1\2uv\7\3\2\2vw\5\n\6\2wx"+
		"\7\5\2\2x\u008a\3\2\2\2y\u0086\5\f\7\2z{\7\3\2\2{\u0080\5\n\6\2|}\7\4"+
		"\2\2}\177\5\n\6\2~|\3\2\2\2\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0080\u0081"+
		"\3\2\2\2\u0081\u0083\3\2\2\2\u0082\u0080\3\2\2\2\u0083\u0084\7\5\2\2\u0084"+
		"\u0087\3\2\2\2\u0085\u0087\7\6\2\2\u0086z\3\2\2\2\u0086\u0085\3\2\2\2"+
		"\u0087\u008a\3\2\2\2\u0088\u008a\5\f\7\2\u0089t\3\2\2\2\u0089y\3\2\2\2"+
		"\u0089\u0088\3\2\2\2\u008a\u00b4\3\2\2\2\u008b\u008c\f\21\2\2\u008c\u008d"+
		"\7\t\2\2\u008d\u00b3\5\n\6\22\u008e\u008f\f\20\2\2\u008f\u0090\7\n\2\2"+
		"\u0090\u00b3\5\n\6\21\u0091\u0092\f\17\2\2\u0092\u0093\7\13\2\2\u0093"+
		"\u00b3\5\n\6\20\u0094\u0095\f\16\2\2\u0095\u0096\7\f\2\2\u0096\u00b3\5"+
		"\n\6\17\u0097\u0098\f\r\2\2\u0098\u0099\7\r\2\2\u0099\u00b3\5\n\6\16\u009a"+
		"\u009b\f\f\2\2\u009b\u009c\7\16\2\2\u009c\u00b3\5\n\6\r\u009d\u009e\f"+
		"\13\2\2\u009e\u009f\7\17\2\2\u009f\u00b3\5\n\6\f\u00a0\u00a1\f\n\2\2\u00a1"+
		"\u00a2\7\20\2\2\u00a2\u00b3\5\n\6\13\u00a3\u00a4\f\t\2\2\u00a4\u00a5\7"+
		"\21\2\2\u00a5\u00b3\5\n\6\n\u00a6\u00a7\f\b\2\2\u00a7\u00a8\7\22\2\2\u00a8"+
		"\u00b3\5\n\6\t\u00a9\u00aa\f\7\2\2\u00aa\u00ab\7\23\2\2\u00ab\u00b3\5"+
		"\n\6\b\u00ac\u00ad\f\6\2\2\u00ad\u00ae\7\24\2\2\u00ae\u00b3\5\n\6\7\u00af"+
		"\u00b0\f\5\2\2\u00b0\u00b1\7\25\2\2\u00b1\u00b3\5\n\6\6\u00b2\u008b\3"+
		"\2\2\2\u00b2\u008e\3\2\2\2\u00b2\u0091\3\2\2\2\u00b2\u0094\3\2\2\2\u00b2"+
		"\u0097\3\2\2\2\u00b2\u009a\3\2\2\2\u00b2\u009d\3\2\2\2\u00b2\u00a0\3\2"+
		"\2\2\u00b2\u00a3\3\2\2\2\u00b2\u00a6\3\2\2\2\u00b2\u00a9\3\2\2\2\u00b2"+
		"\u00ac\3\2\2\2\u00b2\u00af\3\2\2\2\u00b3\u00b6\3\2\2\2\u00b4\u00b2\3\2"+
		"\2\2\u00b4\u00b5\3\2\2\2\u00b5\13\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b7\u00c2"+
		"\5\"\22\2\u00b8\u00c2\5\20\t\2\u00b9\u00c2\5\34\17\2\u00ba\u00c2\5\30"+
		"\r\2\u00bb\u00c2\5\16\b\2\u00bc\u00c2\5\32\16\2\u00bd\u00c2\5\24\13\2"+
		"\u00be\u00c2\5\22\n\2\u00bf\u00c2\5\36\20\2\u00c0\u00c2\5 \21\2\u00c1"+
		"\u00b7\3\2\2\2\u00c1\u00b8\3\2\2\2\u00c1\u00b9\3\2\2\2\u00c1\u00ba\3\2"+
		"\2\2\u00c1\u00bb\3\2\2\2\u00c1\u00bc\3\2\2\2\u00c1\u00bd\3\2\2\2\u00c1"+
		"\u00be\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1\u00c0\3\2\2\2\u00c2\u00c6\3\2"+
		"\2\2\u00c3\u00c5\5\26\f\2\u00c4\u00c3\3\2\2\2\u00c5\u00c8\3\2\2\2\u00c6"+
		"\u00c4\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00ca\3\2\2\2\u00c8\u00c6\3\2"+
		"\2\2\u00c9\u00cb\5$\23\2\u00ca\u00c9\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb"+
		"\r\3\2\2\2\u00cc\u00cd\t\2\2\2\u00cd\17\3\2\2\2\u00ce\u00d0\7\26\2\2\u00cf"+
		"\u00d1\5\n\6\2\u00d0\u00cf\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\21\3\2\2"+
		"\2\u00d2\u00d3\7\21\2\2\u00d3\u00d4\5\n\6\2\u00d4\23\3\2\2\2\u00d5\u00d6"+
		"\7\27\2\2\u00d6\u00db\5\n\6\2\u00d7\u00d8\7\4\2\2\u00d8\u00da\5\n\6\2"+
		"\u00d9\u00d7\3\2\2\2\u00da\u00dd\3\2\2\2\u00db\u00d9\3\2\2\2\u00db\u00dc"+
		"\3\2\2\2\u00dc\u00de\3\2\2\2\u00dd\u00db\3\2\2\2\u00de\u00df\7\30\2\2"+
		"\u00df\u00e2\3\2\2\2\u00e0\u00e2\7\31\2\2\u00e1\u00d5\3\2\2\2\u00e1\u00e0"+
		"\3\2\2\2\u00e2\25\3\2\2\2\u00e3\u00e4\7\27\2\2\u00e4\u00e5\5\n\6\2\u00e5"+
		"\u00e6\7\30\2\2\u00e6\u00e9\3\2\2\2\u00e7\u00e9\7\31\2\2\u00e8\u00e3\3"+
		"\2\2\2\u00e8\u00e7\3\2\2\2\u00e9\27\3\2\2\2\u00ea\u00eb\7\32\2\2\u00eb"+
		"\31\3\2\2\2\u00ec\u00ed\7/\2\2\u00ed\33\3\2\2\2\u00ee\u00ef\7\33\2\2\u00ef"+
		"\u00f0\7/\2\2\u00f0\35\3\2\2\2\u00f1\u00f2\7\7\2\2\u00f2\u00f3\5:\36\2"+
		"\u00f3\u00f4\5\n\6\2\u00f4\37\3\2\2\2\u00f5\u00f9\7\34\2\2\u00f6\u00f8"+
		"\5*\26\2\u00f7\u00f6\3\2\2\2\u00f8\u00fb\3\2\2\2\u00f9\u00f7\3\2\2\2\u00f9"+
		"\u00fa\3\2\2\2\u00fa\u00fc\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fc\u00ff\7\35"+
		"\2\2\u00fd\u00ff\7\36\2\2\u00fe\u00f5\3\2\2\2\u00fe\u00fd\3\2\2\2\u00ff"+
		"!\3\2\2\2\u0100\u0101\7\37\2\2\u0101\u0102\5\n\6\2\u0102\u0103\7 \2\2"+
		"\u0103\u0104\5\n\6\2\u0104\u0105\7!\2\2\u0105\u0106\5\n\6\2\u0106#\3\2"+
		"\2\2\u0107\u010a\5(\25\2\u0108\u010a\5&\24\2\u0109\u0107\3\2\2\2\u0109"+
		"\u0108\3\2\2\2\u010a%\3\2\2\2\u010b\u010c\7\"\2\2\u010c\u010d\5\n\6\2"+
		"\u010d\'\3\2\2\2\u010e\u010f\7#\2\2\u010f\u0110\5\n\6\2\u0110)\3\2\2\2"+
		"\u0111\u0119\5\60\31\2\u0112\u0119\5,\27\2\u0113\u0119\5.\30\2\u0114\u0116"+
		"\5\n\6\2\u0115\u0117\7$\2\2\u0116\u0115\3\2\2\2\u0116\u0117\3\2\2\2\u0117"+
		"\u0119\3\2\2\2\u0118\u0111\3\2\2\2\u0118\u0112\3\2\2\2\u0118\u0113\3\2"+
		"\2\2\u0118\u0114\3\2\2\2\u0119+\3\2\2\2\u011a\u011b\7%\2\2\u011b\u011c"+
		"\5\n\6\2\u011c\u011d\7 \2\2\u011d\u011e\5*\26\2\u011e-\3\2\2\2\u011f\u0120"+
		"\7\37\2\2\u0120\u0121\5\n\6\2\u0121\u0122\7 \2\2\u0122\u0125\5*\26\2\u0123"+
		"\u0124\7!\2\2\u0124\u0126\5*\26\2\u0125\u0123\3\2\2\2\u0125\u0126\3\2"+
		"\2\2\u0126/\3\2\2\2\u0127\u012b\7\34\2\2\u0128\u012a\5*\26\2\u0129\u0128"+
		"\3\2\2\2\u012a\u012d\3\2\2\2\u012b\u0129\3\2\2\2\u012b\u012c\3\2\2\2\u012c"+
		"\u012e\3\2\2\2\u012d\u012b\3\2\2\2\u012e\u012f\7\35\2\2\u012f\61\3\2\2"+
		"\2\u0130\u0131\7&\2\2\u0131\u0132\5\4\3\2\u0132\u0136\7\34\2\2\u0133\u0135"+
		"\5B\"\2\u0134\u0133\3\2\2\2\u0135\u0138\3\2\2\2\u0136\u0134\3\2\2\2\u0136"+
		"\u0137\3\2\2\2\u0137\u013c\3\2\2\2\u0138\u0136\3\2\2\2\u0139\u013b\5\64"+
		"\33\2\u013a\u0139\3\2\2\2\u013b\u013e\3\2\2\2\u013c\u013a\3\2\2\2\u013c"+
		"\u013d\3\2\2\2\u013d\u013f\3\2\2\2\u013e\u013c\3\2\2\2\u013f\u0140\7\35"+
		"\2\2\u0140\63\3\2\2\2\u0141\u0142\7\'\2\2\u0142\u0143\7/\2\2\u0143\u0148"+
		"\7\34\2\2\u0144\u0147\5> \2\u0145\u0147\5\66\34\2\u0146\u0144\3\2\2\2"+
		"\u0146\u0145\3\2\2\2\u0147\u014a\3\2\2\2\u0148\u0146\3\2\2\2\u0148\u0149"+
		"\3\2\2\2\u0149\u014b\3\2\2\2\u014a\u0148\3\2\2\2\u014b\u014c\7\35\2\2"+
		"\u014c\65\3\2\2\2\u014d\u0150\7/\2\2\u014e\u014f\7\"\2\2\u014f\u0151\5"+
		"\n\6\2\u0150\u014e\3\2\2\2\u0150\u0151\3\2\2\2\u0151\67\3\2\2\2\u0152"+
		"\u0155\7/\2\2\u0153\u0154\7 \2\2\u0154\u0156\5\4\3\2\u0155\u0153\3\2\2"+
		"\2\u0155\u0156\3\2\2\2\u01569\3\2\2\2\u0157\u0158\7\3\2\2\u0158\u015d"+
		"\58\35\2\u0159\u015a\7\4\2\2\u015a\u015c\58\35\2\u015b\u0159\3\2\2\2\u015c"+
		"\u015f\3\2\2\2\u015d\u015b\3\2\2\2\u015d\u015e\3\2\2\2\u015e\u0160\3\2"+
		"\2\2\u015f\u015d\3\2\2\2\u0160\u0161\7\5\2\2\u0161\u0164\3\2\2\2\u0162"+
		"\u0164\7\6\2\2\u0163\u0157\3\2\2\2\u0163\u0162\3\2\2\2\u0164;\3\2\2\2"+
		"\u0165\u0166\7(\2\2\u0166\u0167\7/\2\2\u0167=\3\2\2\2\u0168\u016a\5<\37"+
		"\2\u0169\u0168\3\2\2\2\u016a\u016d\3\2\2\2\u016b\u0169\3\2\2\2\u016b\u016c"+
		"\3\2\2\2\u016c\u016e\3\2\2\2\u016d\u016b\3\2\2\2\u016e\u016f\7-\2\2\u016f"+
		"\u0170\7/\2\2\u0170\u0173\5:\36\2\u0171\u0172\7 \2\2\u0172\u0174\5\4\3"+
		"\2\u0173\u0171\3\2\2\2\u0173\u0174\3\2\2\2\u0174\u0175\3\2\2\2\u0175\u0176"+
		"\5\60\31\2\u0176?\3\2\2\2\u0177\u0178\7)\2\2\u0178\u0179\7*\2\2\u0179"+
		"\u017a\5\b\5\2\u017a\u017b\7+\2\2\u017b\u017d\7\60\2\2\u017c\u017e\7$"+
		"\2\2\u017d\u017c\3\2\2\2\u017d\u017e\3\2\2\2\u017eA\3\2\2\2\u017f\u0180"+
		"\7*\2\2\u0180\u0181\7/\2\2\u0181\u0182\7\"\2\2\u0182\u0184\5\16\b\2\u0183"+
		"\u0185\7$\2\2\u0184\u0183\3\2\2\2\u0184\u0185\3\2\2\2\u0185C\3\2\2\2)"+
		"GMTV\\djr\u0080\u0086\u0089\u00b2\u00b4\u00c1\u00c6\u00ca\u00d0\u00db"+
		"\u00e1\u00e8\u00f9\u00fe\u0109\u0116\u0118\u0125\u012b\u0136\u013c\u0146"+
		"\u0148\u0150\u0155\u015d\u0163\u016b\u0173\u017d\u0184";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}