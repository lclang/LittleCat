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
		T__38=39, WS=40, METHOD=41, BOOL=42, ID=43, STRING=44, CHAR=45, HEX_LONG=46, 
		LONG=47, DOUBLE=48, INTEGER=49;
	public static final int
		RULE_file = 0, RULE_type = 1, RULE_expression = 2, RULE_primitive = 3, 
		RULE_value = 4, RULE_call = 5, RULE_returnExpr = 6, RULE_typeGet = 7, 
		RULE_array = 8, RULE_arrayAccess = 9, RULE_stop = 10, RULE_variable = 11, 
		RULE_fixedVariable = 12, RULE_ifExpr = 13, RULE_operation = 14, RULE_set = 15, 
		RULE_access = 16, RULE_stmt = 17, RULE_whileStmt = 18, RULE_ifStmt = 19, 
		RULE_block = 20, RULE_component = 21, RULE_classExpr = 22, RULE_field = 23, 
		RULE_arg = 24, RULE_args = 25, RULE_attribute = 26, RULE_method = 27, 
		RULE_use = 28, RULE_global = 29;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "type", "expression", "primitive", "value", "call", "returnExpr", 
			"typeGet", "array", "arrayAccess", "stop", "variable", "fixedVariable", 
			"ifExpr", "operation", "set", "access", "stmt", "whileStmt", "ifStmt", 
			"block", "component", "classExpr", "field", "arg", "args", "attribute", 
			"method", "use", "global"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'\\'", "'('", "')'", "'||'", "'&&'", "'=='", "'!='", "'<'", "'>'", 
			"'>='", "'<='", "'*'", "'/'", "'+'", "'-'", "'^'", "','", "'()'", "'return'", 
			"'['", "']'", "'[]'", "'stop'", "'fixed'", "'if '", "':'", "'else'", 
			"'='", "'.'", "';'", "'while '", "'{'", "'}'", "'component'", "'class'", 
			"'@'", "'use'", "'from'", "'global'", null, "'method'"
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
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__36) {
				{
				{
				setState(60);
				use();
				}
				}
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__38) {
				{
				{
				setState(66);
				global();
				}
				}
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__11) | (1L << T__18) | (1L << T__19) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__30) | (1L << T__31) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << METHOD) | (1L << BOOL) | (1L << ID) | (1L << STRING) | (1L << CHAR) | (1L << HEX_LONG) | (1L << LONG) | (1L << DOUBLE) | (1L << INTEGER))) != 0)) {
				{
				setState(76);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__1:
				case T__11:
				case T__18:
				case T__19:
				case T__21:
				case T__22:
				case T__23:
				case T__24:
				case T__30:
				case T__31:
				case BOOL:
				case ID:
				case STRING:
				case CHAR:
				case HEX_LONG:
				case LONG:
				case DOUBLE:
				case INTEGER:
					{
					setState(72);
					stmt();
					}
					break;
				case T__35:
				case METHOD:
					{
					setState(73);
					method();
					}
					break;
				case T__33:
					{
					setState(74);
					component();
					}
					break;
				case T__34:
					{
					setState(75);
					classExpr();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(80);
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
		public List<TerminalNode> ID() { return getTokens(lclangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(lclangParser.ID, i);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			match(ID);
			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(82);
				match(T__0);
				setState(83);
				match(ID);
				}
				}
				setState(88);
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

	public static class ExpressionContext extends ParserRuleContext {
		public Token or;
		public Token and;
		public Token equals;
		public Token notEquals;
		public Token less;
		public Token larger;
		public Token lessEquals;
		public Token largerEquals;
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
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				setState(90);
				match(T__1);
				setState(91);
				expression(0);
				setState(92);
				match(T__2);
				}
				break;
			case T__11:
			case T__18:
			case T__19:
			case T__21:
			case T__22:
			case T__23:
			case T__24:
			case BOOL:
			case ID:
			case STRING:
			case CHAR:
			case HEX_LONG:
			case LONG:
			case DOUBLE:
			case INTEGER:
				{
				setState(94);
				primitive();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(138);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(136);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(97);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(98);
						((ExpressionContext)_localctx).or = match(T__3);
						setState(99);
						expression(15);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(100);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(101);
						((ExpressionContext)_localctx).and = match(T__4);
						setState(102);
						expression(14);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(103);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(104);
						((ExpressionContext)_localctx).equals = match(T__5);
						setState(105);
						expression(13);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(106);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(107);
						((ExpressionContext)_localctx).notEquals = match(T__6);
						setState(108);
						expression(12);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(109);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(110);
						((ExpressionContext)_localctx).less = match(T__7);
						setState(111);
						expression(11);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(112);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(113);
						((ExpressionContext)_localctx).larger = match(T__8);
						setState(114);
						expression(10);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(115);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(116);
						((ExpressionContext)_localctx).lessEquals = match(T__9);
						setState(117);
						expression(9);
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(118);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(119);
						((ExpressionContext)_localctx).largerEquals = match(T__10);
						setState(120);
						expression(8);
						}
						break;
					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(121);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(122);
						((ExpressionContext)_localctx).multiplication = match(T__11);
						setState(123);
						expression(7);
						}
						break;
					case 10:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(124);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(125);
						((ExpressionContext)_localctx).div = match(T__12);
						setState(126);
						expression(6);
						}
						break;
					case 11:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(127);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(128);
						((ExpressionContext)_localctx).add = match(T__13);
						setState(129);
						expression(5);
						}
						break;
					case 12:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(130);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(131);
						((ExpressionContext)_localctx).minus = match(T__14);
						setState(132);
						expression(4);
						}
						break;
					case 13:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(133);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(134);
						((ExpressionContext)_localctx).pow = match(T__15);
						setState(135);
						expression(3);
						}
						break;
					}
					} 
				}
				setState(140);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
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
		enterRule(_localctx, 6, RULE_primitive);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(141);
				ifExpr();
				}
				break;
			case 2:
				{
				setState(142);
				returnExpr();
				}
				break;
			case 3:
				{
				setState(143);
				call();
				}
				break;
			case 4:
				{
				setState(144);
				fixedVariable();
				}
				break;
			case 5:
				{
				setState(145);
				stop();
				}
				break;
			case 6:
				{
				setState(146);
				value();
				}
				break;
			case 7:
				{
				setState(147);
				variable();
				}
				break;
			case 8:
				{
				setState(148);
				array();
				}
				break;
			case 9:
				{
				setState(149);
				typeGet();
				}
				break;
			}
			setState(155);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(152);
					arrayAccess();
					}
					} 
				}
				setState(157);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			setState(159);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(158);
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
		enterRule(_localctx, 8, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
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

	public static class CallContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public CallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).enterCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).exitCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lclangVisitor ) return ((lclangVisitor<? extends T>)visitor).visitCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallContext call() throws RecognitionException {
		CallContext _localctx = new CallContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			type();
			setState(176);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				{
				setState(164);
				match(T__1);
				setState(165);
				expression(0);
				setState(170);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__16) {
					{
					{
					setState(166);
					match(T__16);
					setState(167);
					expression(0);
					}
					}
					setState(172);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(173);
				match(T__2);
				}
				break;
			case T__17:
				{
				setState(175);
				match(T__17);
				}
				break;
			default:
				throw new NoViableAltException(this);
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
		enterRule(_localctx, 12, RULE_returnExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			match(T__18);
			setState(180);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(179);
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
		enterRule(_localctx, 14, RULE_typeGet);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			match(T__11);
			setState(183);
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
		enterRule(_localctx, 16, RULE_array);
		int _la;
		try {
			setState(197);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__19:
				enterOuterAlt(_localctx, 1);
				{
				setState(185);
				match(T__19);
				setState(186);
				expression(0);
				setState(191);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__16) {
					{
					{
					setState(187);
					match(T__16);
					setState(188);
					expression(0);
					}
					}
					setState(193);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(194);
				match(T__20);
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 2);
				{
				setState(196);
				match(T__21);
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
		enterRule(_localctx, 18, RULE_arrayAccess);
		try {
			setState(204);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__19:
				enterOuterAlt(_localctx, 1);
				{
				setState(199);
				match(T__19);
				setState(200);
				expression(0);
				setState(201);
				match(T__20);
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 2);
				{
				setState(203);
				match(T__21);
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
		enterRule(_localctx, 20, RULE_stop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			match(T__22);
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
		enterRule(_localctx, 22, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
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
		enterRule(_localctx, 24, RULE_fixedVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			match(T__23);
			setState(211);
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
		enterRule(_localctx, 26, RULE_ifExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			match(T__24);
			setState(214);
			((IfExprContext)_localctx).condition = expression(0);
			setState(215);
			match(T__25);
			setState(216);
			((IfExprContext)_localctx).ifT = expression(0);
			setState(217);
			match(T__26);
			setState(218);
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
		enterRule(_localctx, 28, RULE_operation);
		try {
			setState(222);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__28:
				enterOuterAlt(_localctx, 1);
				{
				setState(220);
				access();
				}
				break;
			case T__27:
				enterOuterAlt(_localctx, 2);
				{
				setState(221);
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
		enterRule(_localctx, 30, RULE_set);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			match(T__27);
			setState(225);
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
		enterRule(_localctx, 32, RULE_access);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			match(T__28);
			setState(228);
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
		enterRule(_localctx, 34, RULE_stmt);
		try {
			setState(236);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(230);
				block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(231);
				whileStmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(232);
				ifStmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(233);
				expression(0);
				setState(234);
				match(T__29);
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
		enterRule(_localctx, 36, RULE_whileStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			match(T__30);
			setState(239);
			((WhileStmtContext)_localctx).condition = expression(0);
			setState(240);
			match(T__25);
			setState(241);
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
		enterRule(_localctx, 38, RULE_ifStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			match(T__24);
			setState(244);
			((IfStmtContext)_localctx).condition = expression(0);
			setState(245);
			match(T__25);
			setState(246);
			((IfStmtContext)_localctx).ifT = stmt();
			setState(249);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(247);
				match(T__26);
				setState(248);
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
		enterRule(_localctx, 40, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251);
			match(T__31);
			setState(255);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__11) | (1L << T__18) | (1L << T__19) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__30) | (1L << T__31) | (1L << BOOL) | (1L << ID) | (1L << STRING) | (1L << CHAR) | (1L << HEX_LONG) | (1L << LONG) | (1L << DOUBLE) | (1L << INTEGER))) != 0)) {
				{
				{
				setState(252);
				stmt();
				}
				}
				setState(257);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(258);
			match(T__32);
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
		public List<MethodContext> method() {
			return getRuleContexts(MethodContext.class);
		}
		public MethodContext method(int i) {
			return getRuleContext(MethodContext.class,i);
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
		enterRule(_localctx, 42, RULE_component);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			match(T__33);
			setState(261);
			type();
			setState(262);
			match(T__31);
			setState(267);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__34) | (1L << T__35) | (1L << METHOD))) != 0)) {
				{
				setState(265);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__35:
				case METHOD:
					{
					setState(263);
					method();
					}
					break;
				case T__34:
					{
					setState(264);
					classExpr();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(269);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(270);
			match(T__32);
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
		enterRule(_localctx, 44, RULE_classExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			match(T__34);
			setState(273);
			match(ID);
			setState(274);
			match(T__31);
			setState(279);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__35) | (1L << METHOD) | (1L << ID))) != 0)) {
				{
				setState(277);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__35:
				case METHOD:
					{
					setState(275);
					method();
					}
					break;
				case ID:
					{
					setState(276);
					field();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(281);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(282);
			match(T__32);
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
		enterRule(_localctx, 46, RULE_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			match(ID);
			setState(287);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__27) {
				{
				setState(285);
				match(T__27);
				setState(286);
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
		enterRule(_localctx, 48, RULE_arg);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(290);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				setState(289);
				type();
				}
				break;
			}
			setState(292);
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
		enterRule(_localctx, 50, RULE_args);
		int _la;
		try {
			setState(306);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				setState(294);
				match(T__1);
				setState(295);
				arg();
				setState(300);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__16) {
					{
					{
					setState(296);
					match(T__16);
					setState(297);
					arg();
					}
					}
					setState(302);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(303);
				match(T__2);
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 2);
				{
				setState(305);
				match(T__17);
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
		enterRule(_localctx, 52, RULE_attribute);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			match(T__35);
			setState(309);
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
		enterRule(_localctx, 54, RULE_method);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(314);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__35) {
				{
				{
				setState(311);
				attribute();
				}
				}
				setState(316);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(317);
			match(METHOD);
			setState(318);
			match(ID);
			setState(319);
			args();
			setState(322);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__25) {
				{
				setState(320);
				match(T__25);
				setState(321);
				type();
				}
			}

			setState(324);
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
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
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
		enterRule(_localctx, 56, RULE_use);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326);
			match(T__36);
			setState(327);
			type();
			setState(330);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__37) {
				{
				setState(328);
				match(T__37);
				setState(329);
				match(STRING);
				}
			}

			setState(332);
			match(T__29);
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
		enterRule(_localctx, 58, RULE_global);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(334);
			match(T__38);
			setState(335);
			match(ID);
			setState(336);
			match(T__27);
			setState(337);
			value();
			setState(338);
			match(T__29);
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
		case 2:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 14);
		case 1:
			return precpred(_ctx, 13);
		case 2:
			return precpred(_ctx, 12);
		case 3:
			return precpred(_ctx, 11);
		case 4:
			return precpred(_ctx, 10);
		case 5:
			return precpred(_ctx, 9);
		case 6:
			return precpred(_ctx, 8);
		case 7:
			return precpred(_ctx, 7);
		case 8:
			return precpred(_ctx, 6);
		case 9:
			return precpred(_ctx, 5);
		case 10:
			return precpred(_ctx, 4);
		case 11:
			return precpred(_ctx, 3);
		case 12:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\63\u0157\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\3\2\7\2@"+
		"\n\2\f\2\16\2C\13\2\3\2\7\2F\n\2\f\2\16\2I\13\2\3\2\3\2\3\2\3\2\7\2O\n"+
		"\2\f\2\16\2R\13\2\3\3\3\3\3\3\7\3W\n\3\f\3\16\3Z\13\3\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\5\4b\n\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4\u008b\n\4\f\4\16\4\u008e\13\4\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\u0099\n\5\3\5\7\5\u009c\n\5\f\5"+
		"\16\5\u009f\13\5\3\5\5\5\u00a2\n\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\7\7\u00ab"+
		"\n\7\f\7\16\7\u00ae\13\7\3\7\3\7\3\7\5\7\u00b3\n\7\3\b\3\b\5\b\u00b7\n"+
		"\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\7\n\u00c0\n\n\f\n\16\n\u00c3\13\n\3\n\3"+
		"\n\3\n\5\n\u00c8\n\n\3\13\3\13\3\13\3\13\3\13\5\13\u00cf\n\13\3\f\3\f"+
		"\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\5"+
		"\20\u00e1\n\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\5\23\u00ef\n\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\5\25\u00fc\n\25\3\26\3\26\7\26\u0100\n\26\f\26\16\26\u0103\13\26"+
		"\3\26\3\26\3\27\3\27\3\27\3\27\3\27\7\27\u010c\n\27\f\27\16\27\u010f\13"+
		"\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\7\30\u0118\n\30\f\30\16\30\u011b"+
		"\13\30\3\30\3\30\3\31\3\31\3\31\5\31\u0122\n\31\3\32\5\32\u0125\n\32\3"+
		"\32\3\32\3\33\3\33\3\33\3\33\7\33\u012d\n\33\f\33\16\33\u0130\13\33\3"+
		"\33\3\33\3\33\5\33\u0135\n\33\3\34\3\34\3\34\3\35\7\35\u013b\n\35\f\35"+
		"\16\35\u013e\13\35\3\35\3\35\3\35\3\35\3\35\5\35\u0145\n\35\3\35\3\35"+
		"\3\36\3\36\3\36\3\36\5\36\u014d\n\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\2\3\6 \2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62"+
		"\64\668:<\2\3\4\2,,.\63\2\u016e\2A\3\2\2\2\4S\3\2\2\2\6a\3\2\2\2\b\u0098"+
		"\3\2\2\2\n\u00a3\3\2\2\2\f\u00a5\3\2\2\2\16\u00b4\3\2\2\2\20\u00b8\3\2"+
		"\2\2\22\u00c7\3\2\2\2\24\u00ce\3\2\2\2\26\u00d0\3\2\2\2\30\u00d2\3\2\2"+
		"\2\32\u00d4\3\2\2\2\34\u00d7\3\2\2\2\36\u00e0\3\2\2\2 \u00e2\3\2\2\2\""+
		"\u00e5\3\2\2\2$\u00ee\3\2\2\2&\u00f0\3\2\2\2(\u00f5\3\2\2\2*\u00fd\3\2"+
		"\2\2,\u0106\3\2\2\2.\u0112\3\2\2\2\60\u011e\3\2\2\2\62\u0124\3\2\2\2\64"+
		"\u0134\3\2\2\2\66\u0136\3\2\2\28\u013c\3\2\2\2:\u0148\3\2\2\2<\u0150\3"+
		"\2\2\2>@\5:\36\2?>\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2BG\3\2\2\2CA\3"+
		"\2\2\2DF\5<\37\2ED\3\2\2\2FI\3\2\2\2GE\3\2\2\2GH\3\2\2\2HP\3\2\2\2IG\3"+
		"\2\2\2JO\5$\23\2KO\58\35\2LO\5,\27\2MO\5.\30\2NJ\3\2\2\2NK\3\2\2\2NL\3"+
		"\2\2\2NM\3\2\2\2OR\3\2\2\2PN\3\2\2\2PQ\3\2\2\2Q\3\3\2\2\2RP\3\2\2\2SX"+
		"\7-\2\2TU\7\3\2\2UW\7-\2\2VT\3\2\2\2WZ\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y\5"+
		"\3\2\2\2ZX\3\2\2\2[\\\b\4\1\2\\]\7\4\2\2]^\5\6\4\2^_\7\5\2\2_b\3\2\2\2"+
		"`b\5\b\5\2a[\3\2\2\2a`\3\2\2\2b\u008c\3\2\2\2cd\f\20\2\2de\7\6\2\2e\u008b"+
		"\5\6\4\21fg\f\17\2\2gh\7\7\2\2h\u008b\5\6\4\20ij\f\16\2\2jk\7\b\2\2k\u008b"+
		"\5\6\4\17lm\f\r\2\2mn\7\t\2\2n\u008b\5\6\4\16op\f\f\2\2pq\7\n\2\2q\u008b"+
		"\5\6\4\rrs\f\13\2\2st\7\13\2\2t\u008b\5\6\4\fuv\f\n\2\2vw\7\f\2\2w\u008b"+
		"\5\6\4\13xy\f\t\2\2yz\7\r\2\2z\u008b\5\6\4\n{|\f\b\2\2|}\7\16\2\2}\u008b"+
		"\5\6\4\t~\177\f\7\2\2\177\u0080\7\17\2\2\u0080\u008b\5\6\4\b\u0081\u0082"+
		"\f\6\2\2\u0082\u0083\7\20\2\2\u0083\u008b\5\6\4\7\u0084\u0085\f\5\2\2"+
		"\u0085\u0086\7\21\2\2\u0086\u008b\5\6\4\6\u0087\u0088\f\4\2\2\u0088\u0089"+
		"\7\22\2\2\u0089\u008b\5\6\4\5\u008ac\3\2\2\2\u008af\3\2\2\2\u008ai\3\2"+
		"\2\2\u008al\3\2\2\2\u008ao\3\2\2\2\u008ar\3\2\2\2\u008au\3\2\2\2\u008a"+
		"x\3\2\2\2\u008a{\3\2\2\2\u008a~\3\2\2\2\u008a\u0081\3\2\2\2\u008a\u0084"+
		"\3\2\2\2\u008a\u0087\3\2\2\2\u008b\u008e\3\2\2\2\u008c\u008a\3\2\2\2\u008c"+
		"\u008d\3\2\2\2\u008d\7\3\2\2\2\u008e\u008c\3\2\2\2\u008f\u0099\5\34\17"+
		"\2\u0090\u0099\5\16\b\2\u0091\u0099\5\f\7\2\u0092\u0099\5\32\16\2\u0093"+
		"\u0099\5\26\f\2\u0094\u0099\5\n\6\2\u0095\u0099\5\30\r\2\u0096\u0099\5"+
		"\22\n\2\u0097\u0099\5\20\t\2\u0098\u008f\3\2\2\2\u0098\u0090\3\2\2\2\u0098"+
		"\u0091\3\2\2\2\u0098\u0092\3\2\2\2\u0098\u0093\3\2\2\2\u0098\u0094\3\2"+
		"\2\2\u0098\u0095\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0097\3\2\2\2\u0099"+
		"\u009d\3\2\2\2\u009a\u009c\5\24\13\2\u009b\u009a\3\2\2\2\u009c\u009f\3"+
		"\2\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u00a1\3\2\2\2\u009f"+
		"\u009d\3\2\2\2\u00a0\u00a2\5\36\20\2\u00a1\u00a0\3\2\2\2\u00a1\u00a2\3"+
		"\2\2\2\u00a2\t\3\2\2\2\u00a3\u00a4\t\2\2\2\u00a4\13\3\2\2\2\u00a5\u00b2"+
		"\5\4\3\2\u00a6\u00a7\7\4\2\2\u00a7\u00ac\5\6\4\2\u00a8\u00a9\7\23\2\2"+
		"\u00a9\u00ab\5\6\4\2\u00aa\u00a8\3\2\2\2\u00ab\u00ae\3\2\2\2\u00ac\u00aa"+
		"\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00af\3\2\2\2\u00ae\u00ac\3\2\2\2\u00af"+
		"\u00b0\7\5\2\2\u00b0\u00b3\3\2\2\2\u00b1\u00b3\7\24\2\2\u00b2\u00a6\3"+
		"\2\2\2\u00b2\u00b1\3\2\2\2\u00b3\r\3\2\2\2\u00b4\u00b6\7\25\2\2\u00b5"+
		"\u00b7\5\6\4\2\u00b6\u00b5\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\17\3\2\2"+
		"\2\u00b8\u00b9\7\16\2\2\u00b9\u00ba\5\6\4\2\u00ba\21\3\2\2\2\u00bb\u00bc"+
		"\7\26\2\2\u00bc\u00c1\5\6\4\2\u00bd\u00be\7\23\2\2\u00be\u00c0\5\6\4\2"+
		"\u00bf\u00bd\3\2\2\2\u00c0\u00c3\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1\u00c2"+
		"\3\2\2\2\u00c2\u00c4\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c4\u00c5\7\27\2\2"+
		"\u00c5\u00c8\3\2\2\2\u00c6\u00c8\7\30\2\2\u00c7\u00bb\3\2\2\2\u00c7\u00c6"+
		"\3\2\2\2\u00c8\23\3\2\2\2\u00c9\u00ca\7\26\2\2\u00ca\u00cb\5\6\4\2\u00cb"+
		"\u00cc\7\27\2\2\u00cc\u00cf\3\2\2\2\u00cd\u00cf\7\30\2\2\u00ce\u00c9\3"+
		"\2\2\2\u00ce\u00cd\3\2\2\2\u00cf\25\3\2\2\2\u00d0\u00d1\7\31\2\2\u00d1"+
		"\27\3\2\2\2\u00d2\u00d3\7-\2\2\u00d3\31\3\2\2\2\u00d4\u00d5\7\32\2\2\u00d5"+
		"\u00d6\7-\2\2\u00d6\33\3\2\2\2\u00d7\u00d8\7\33\2\2\u00d8\u00d9\5\6\4"+
		"\2\u00d9\u00da\7\34\2\2\u00da\u00db\5\6\4\2\u00db\u00dc\7\35\2\2\u00dc"+
		"\u00dd\5\6\4\2\u00dd\35\3\2\2\2\u00de\u00e1\5\"\22\2\u00df\u00e1\5 \21"+
		"\2\u00e0\u00de\3\2\2\2\u00e0\u00df\3\2\2\2\u00e1\37\3\2\2\2\u00e2\u00e3"+
		"\7\36\2\2\u00e3\u00e4\5\6\4\2\u00e4!\3\2\2\2\u00e5\u00e6\7\37\2\2\u00e6"+
		"\u00e7\5\6\4\2\u00e7#\3\2\2\2\u00e8\u00ef\5*\26\2\u00e9\u00ef\5&\24\2"+
		"\u00ea\u00ef\5(\25\2\u00eb\u00ec\5\6\4\2\u00ec\u00ed\7 \2\2\u00ed\u00ef"+
		"\3\2\2\2\u00ee\u00e8\3\2\2\2\u00ee\u00e9\3\2\2\2\u00ee\u00ea\3\2\2\2\u00ee"+
		"\u00eb\3\2\2\2\u00ef%\3\2\2\2\u00f0\u00f1\7!\2\2\u00f1\u00f2\5\6\4\2\u00f2"+
		"\u00f3\7\34\2\2\u00f3\u00f4\5$\23\2\u00f4\'\3\2\2\2\u00f5\u00f6\7\33\2"+
		"\2\u00f6\u00f7\5\6\4\2\u00f7\u00f8\7\34\2\2\u00f8\u00fb\5$\23\2\u00f9"+
		"\u00fa\7\35\2\2\u00fa\u00fc\5$\23\2\u00fb\u00f9\3\2\2\2\u00fb\u00fc\3"+
		"\2\2\2\u00fc)\3\2\2\2\u00fd\u0101\7\"\2\2\u00fe\u0100\5$\23\2\u00ff\u00fe"+
		"\3\2\2\2\u0100\u0103\3\2\2\2\u0101\u00ff\3\2\2\2\u0101\u0102\3\2\2\2\u0102"+
		"\u0104\3\2\2\2\u0103\u0101\3\2\2\2\u0104\u0105\7#\2\2\u0105+\3\2\2\2\u0106"+
		"\u0107\7$\2\2\u0107\u0108\5\4\3\2\u0108\u010d\7\"\2\2\u0109\u010c\58\35"+
		"\2\u010a\u010c\5.\30\2\u010b\u0109\3\2\2\2\u010b\u010a\3\2\2\2\u010c\u010f"+
		"\3\2\2\2\u010d\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u0110\3\2\2\2\u010f"+
		"\u010d\3\2\2\2\u0110\u0111\7#\2\2\u0111-\3\2\2\2\u0112\u0113\7%\2\2\u0113"+
		"\u0114\7-\2\2\u0114\u0119\7\"\2\2\u0115\u0118\58\35\2\u0116\u0118\5\60"+
		"\31\2\u0117\u0115\3\2\2\2\u0117\u0116\3\2\2\2\u0118\u011b\3\2\2\2\u0119"+
		"\u0117\3\2\2\2\u0119\u011a\3\2\2\2\u011a\u011c\3\2\2\2\u011b\u0119\3\2"+
		"\2\2\u011c\u011d\7#\2\2\u011d/\3\2\2\2\u011e\u0121\7-\2\2\u011f\u0120"+
		"\7\36\2\2\u0120\u0122\5\6\4\2\u0121\u011f\3\2\2\2\u0121\u0122\3\2\2\2"+
		"\u0122\61\3\2\2\2\u0123\u0125\5\4\3\2\u0124\u0123\3\2\2\2\u0124\u0125"+
		"\3\2\2\2\u0125\u0126\3\2\2\2\u0126\u0127\7-\2\2\u0127\63\3\2\2\2\u0128"+
		"\u0129\7\4\2\2\u0129\u012e\5\62\32\2\u012a\u012b\7\23\2\2\u012b\u012d"+
		"\5\62\32\2\u012c\u012a\3\2\2\2\u012d\u0130\3\2\2\2\u012e\u012c\3\2\2\2"+
		"\u012e\u012f\3\2\2\2\u012f\u0131\3\2\2\2\u0130\u012e\3\2\2\2\u0131\u0132"+
		"\7\5\2\2\u0132\u0135\3\2\2\2\u0133\u0135\7\24\2\2\u0134\u0128\3\2\2\2"+
		"\u0134\u0133\3\2\2\2\u0135\65\3\2\2\2\u0136\u0137\7&\2\2\u0137\u0138\7"+
		"-\2\2\u0138\67\3\2\2\2\u0139\u013b\5\66\34\2\u013a\u0139\3\2\2\2\u013b"+
		"\u013e\3\2\2\2\u013c\u013a\3\2\2\2\u013c\u013d\3\2\2\2\u013d\u013f\3\2"+
		"\2\2\u013e\u013c\3\2\2\2\u013f\u0140\7+\2\2\u0140\u0141\7-\2\2\u0141\u0144"+
		"\5\64\33\2\u0142\u0143\7\34\2\2\u0143\u0145\5\4\3\2\u0144\u0142\3\2\2"+
		"\2\u0144\u0145\3\2\2\2\u0145\u0146\3\2\2\2\u0146\u0147\5*\26\2\u01479"+
		"\3\2\2\2\u0148\u0149\7\'\2\2\u0149\u014c\5\4\3\2\u014a\u014b\7(\2\2\u014b"+
		"\u014d\7.\2\2\u014c\u014a\3\2\2\2\u014c\u014d\3\2\2\2\u014d\u014e\3\2"+
		"\2\2\u014e\u014f\7 \2\2\u014f;\3\2\2\2\u0150\u0151\7)\2\2\u0151\u0152"+
		"\7-\2\2\u0152\u0153\7\36\2\2\u0153\u0154\5\n\6\2\u0154\u0155\7 \2\2\u0155"+
		"=\3\2\2\2\"AGNPXa\u008a\u008c\u0098\u009d\u00a1\u00ac\u00b2\u00b6\u00c1"+
		"\u00c7\u00ce\u00e0\u00ee\u00fb\u0101\u010b\u010d\u0117\u0119\u0121\u0124"+
		"\u012e\u0134\u013c\u0144\u014c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}