// Generated from C:/IdeaProjects/LittleCat/src/main/java/lclang\lclang.g4 by ANTLR 4.9.1
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
		COMMENT=1, LINE_COMMENT=2, OPEN=3, CLOSE=4, OPEN_BRACE=5, CLOSE_BRACE=6, 
		OPEN_BRACKET=7, CLOSE_BRACKET=8, POW=9, EQUALS=10, NOT_EQUALS=11, AND_BOOL=12, 
		OR_BOOL=13, LESS_EQUALS=14, LARGER_EQUALS=15, UNARY_ADD=16, UNARY_MINUS=17, 
		NULLABLE_OR=18, NULLABLE=19, TYPE_PREFIX=20, COMMA=21, SEMICOLON=22, ASSIGN=23, 
		OR=24, AND=25, NOT=26, LESS=27, LARGER=28, MULTYPLICATION=29, DIVISION=30, 
		ADD=31, MINUS=32, COLON=33, DOT=34, AS_ATTR=35, GLOBAL=36, METHOD=37, 
		USE=38, CLASS=39, FROM=40, COMPONENT=41, STOP=42, RETURN=43, WHILE=44, 
		IF=45, ELSE=46, NULL=47, BOOL=48, ID=49, STRING=50, CHAR=51, HEX_LONG=52, 
		LONG=53, DOUBLE=54, INTEGER=55, WS=56;
	public static final int
		RULE_file = 0, RULE_type = 1, RULE_methodType = 2, RULE_baseType = 3, 
		RULE_expression = 4, RULE_primitive = 5, RULE_value = 6, RULE_parentnesesExpr = 7, 
		RULE_returnExpr = 8, RULE_typeGet = 9, RULE_access = 10, RULE_array = 11, 
		RULE_arrayAccess = 12, RULE_stop = 13, RULE_variable = 14, RULE_lambda = 15, 
		RULE_container = 16, RULE_ifExpr = 17, RULE_newClass = 18, RULE_operation = 19, 
		RULE_assign = 20, RULE_stmt = 21, RULE_whileStmt = 22, RULE_ifStmt = 23, 
		RULE_block = 24, RULE_component = 25, RULE_classExpr = 26, RULE_field = 27, 
		RULE_arg = 28, RULE_args = 29, RULE_attribute = 30, RULE_method = 31, 
		RULE_use = 32, RULE_global = 33;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "type", "methodType", "baseType", "expression", "primitive", 
			"value", "parentnesesExpr", "returnExpr", "typeGet", "access", "array", 
			"arrayAccess", "stop", "variable", "lambda", "container", "ifExpr", "newClass", 
			"operation", "assign", "stmt", "whileStmt", "ifStmt", "block", "component", 
			"classExpr", "field", "arg", "args", "attribute", "method", "use", "global"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'('", "')'", "'{'", "'}'", "'['", "']'", "'**'", "'=='", 
			"'!='", "'&&'", "'||'", "'<='", "'>='", "'++'", "'--'", "'?:'", "'?'", 
			"'\\'", "','", "';'", "'='", "'|'", "'&'", "'!'", "'<'", "'>'", "'*'", 
			"'/'", "'+'", "'-'", "':'", "'.'", "'@'", "'global'", "'method'", "'use'", 
			"'class'", "'from'", "'component'", "'stop'", "'return'", "'while'", 
			"'if'", "'else'", "'null'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COMMENT", "LINE_COMMENT", "OPEN", "CLOSE", "OPEN_BRACE", "CLOSE_BRACE", 
			"OPEN_BRACKET", "CLOSE_BRACKET", "POW", "EQUALS", "NOT_EQUALS", "AND_BOOL", 
			"OR_BOOL", "LESS_EQUALS", "LARGER_EQUALS", "UNARY_ADD", "UNARY_MINUS", 
			"NULLABLE_OR", "NULLABLE", "TYPE_PREFIX", "COMMA", "SEMICOLON", "ASSIGN", 
			"OR", "AND", "NOT", "LESS", "LARGER", "MULTYPLICATION", "DIVISION", "ADD", 
			"MINUS", "COLON", "DOT", "AS_ATTR", "GLOBAL", "METHOD", "USE", "CLASS", 
			"FROM", "COMPONENT", "STOP", "RETURN", "WHILE", "IF", "ELSE", "NULL", 
			"BOOL", "ID", "STRING", "CHAR", "HEX_LONG", "LONG", "DOUBLE", "INTEGER", 
			"WS"
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
		public TerminalNode EOF() { return getToken(lclangParser.EOF, 0); }
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
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==USE) {
				{
				{
				setState(68);
				use();
				}
				}
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==GLOBAL) {
				{
				{
				setState(74);
				global();
				}
				}
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPEN) | (1L << OPEN_BRACE) | (1L << OPEN_BRACKET) | (1L << NOT) | (1L << MULTYPLICATION) | (1L << MINUS) | (1L << COLON) | (1L << AS_ATTR) | (1L << METHOD) | (1L << CLASS) | (1L << COMPONENT) | (1L << STOP) | (1L << RETURN) | (1L << WHILE) | (1L << IF) | (1L << NULL) | (1L << BOOL) | (1L << ID) | (1L << STRING) | (1L << CHAR) | (1L << HEX_LONG) | (1L << LONG) | (1L << DOUBLE) | (1L << INTEGER))) != 0)) {
				{
				setState(84);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case OPEN:
				case OPEN_BRACE:
				case OPEN_BRACKET:
				case NOT:
				case MULTYPLICATION:
				case MINUS:
				case COLON:
				case STOP:
				case RETURN:
				case WHILE:
				case IF:
				case NULL:
				case BOOL:
				case ID:
				case STRING:
				case CHAR:
				case HEX_LONG:
				case LONG:
				case DOUBLE:
				case INTEGER:
					{
					setState(80);
					stmt();
					}
					break;
				case AS_ATTR:
				case METHOD:
					{
					setState(81);
					method();
					}
					break;
				case COMPONENT:
					{
					setState(82);
					component();
					}
					break;
				case CLASS:
					{
					setState(83);
					classExpr();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(89);
			match(EOF);
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
		public Token nullable;
		public MethodTypeContext methodType() {
			return getRuleContext(MethodTypeContext.class,0);
		}
		public BaseTypeContext baseType() {
			return getRuleContext(BaseTypeContext.class,0);
		}
		public TerminalNode NULLABLE() { return getToken(lclangParser.NULLABLE, 0); }
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
			setState(92);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NULLABLE) {
				{
				setState(91);
				((TypeContext)_localctx).nullable = match(NULLABLE);
				}
			}

			setState(96);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPEN:
				{
				setState(94);
				methodType();
				}
				break;
			case ID:
				{
				setState(95);
				baseType();
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

	public static class MethodTypeContext extends ParserRuleContext {
		public TypeContext returnType;
		public TerminalNode OPEN() { return getToken(lclangParser.OPEN, 0); }
		public TerminalNode CLOSE() { return getToken(lclangParser.CLOSE, 0); }
		public TerminalNode MINUS() { return getToken(lclangParser.MINUS, 0); }
		public TerminalNode LARGER() { return getToken(lclangParser.LARGER, 0); }
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(lclangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(lclangParser.COMMA, i);
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
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(OPEN);
			setState(104);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(99);
					type();
					setState(100);
					match(COMMA);
					}
					} 
				}
				setState(106);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPEN) | (1L << NULLABLE) | (1L << ID))) != 0)) {
				{
				setState(107);
				type();
				}
			}

			setState(110);
			match(CLOSE);
			setState(111);
			match(MINUS);
			setState(112);
			match(LARGER);
			setState(113);
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
		public TerminalNode TYPE_PREFIX() { return getToken(lclangParser.TYPE_PREFIX, 0); }
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(ID);
			setState(118);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(116);
				match(TYPE_PREFIX);
				setState(117);
				baseType();
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

	public static class ExpressionContext extends ParserRuleContext {
		public Token not;
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
		public Token nullableOr;
		public Token unaryPlus;
		public Token unaryMinus;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode NOT() { return getToken(lclangParser.NOT, 0); }
		public PrimitiveContext primitive() {
			return getRuleContext(PrimitiveContext.class,0);
		}
		public List<AccessContext> access() {
			return getRuleContexts(AccessContext.class);
		}
		public AccessContext access(int i) {
			return getRuleContext(AccessContext.class,i);
		}
		public TerminalNode OR_BOOL() { return getToken(lclangParser.OR_BOOL, 0); }
		public TerminalNode AND_BOOL() { return getToken(lclangParser.AND_BOOL, 0); }
		public TerminalNode EQUALS() { return getToken(lclangParser.EQUALS, 0); }
		public TerminalNode NOT_EQUALS() { return getToken(lclangParser.NOT_EQUALS, 0); }
		public TerminalNode LESS() { return getToken(lclangParser.LESS, 0); }
		public TerminalNode LARGER() { return getToken(lclangParser.LARGER, 0); }
		public TerminalNode LARGER_EQUALS() { return getToken(lclangParser.LARGER_EQUALS, 0); }
		public TerminalNode LESS_EQUALS() { return getToken(lclangParser.LESS_EQUALS, 0); }
		public TerminalNode MULTYPLICATION() { return getToken(lclangParser.MULTYPLICATION, 0); }
		public TerminalNode DIVISION() { return getToken(lclangParser.DIVISION, 0); }
		public TerminalNode ADD() { return getToken(lclangParser.ADD, 0); }
		public TerminalNode MINUS() { return getToken(lclangParser.MINUS, 0); }
		public TerminalNode POW() { return getToken(lclangParser.POW, 0); }
		public TerminalNode NULLABLE_OR() { return getToken(lclangParser.NULLABLE_OR, 0); }
		public TerminalNode UNARY_ADD() { return getToken(lclangParser.UNARY_ADD, 0); }
		public TerminalNode UNARY_MINUS() { return getToken(lclangParser.UNARY_MINUS, 0); }
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
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOT:
				{
				setState(121);
				((ExpressionContext)_localctx).not = match(NOT);
				setState(122);
				expression(2);
				}
				break;
			case OPEN:
			case OPEN_BRACE:
			case OPEN_BRACKET:
			case MULTYPLICATION:
			case MINUS:
			case COLON:
			case STOP:
			case RETURN:
			case IF:
			case NULL:
			case BOOL:
			case ID:
			case STRING:
			case CHAR:
			case HEX_LONG:
			case LONG:
			case DOUBLE:
			case INTEGER:
				{
				setState(123);
				primitive();
				setState(127);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(124);
						access();
						}
						} 
					}
					setState(129);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(180);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(178);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(132);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(133);
						((ExpressionContext)_localctx).or = match(OR_BOOL);
						setState(134);
						expression(19);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(135);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(136);
						((ExpressionContext)_localctx).and = match(AND_BOOL);
						setState(137);
						expression(18);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(138);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(139);
						((ExpressionContext)_localctx).equals = match(EQUALS);
						setState(140);
						expression(17);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(141);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(142);
						((ExpressionContext)_localctx).notEquals = match(NOT_EQUALS);
						setState(143);
						expression(16);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(144);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(145);
						((ExpressionContext)_localctx).less = match(LESS);
						setState(146);
						expression(15);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(147);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(148);
						((ExpressionContext)_localctx).larger = match(LARGER);
						setState(149);
						expression(14);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(150);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(151);
						((ExpressionContext)_localctx).largerEquals = match(LARGER_EQUALS);
						setState(152);
						expression(13);
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(153);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(154);
						((ExpressionContext)_localctx).lessEquals = match(LESS_EQUALS);
						setState(155);
						expression(12);
						}
						break;
					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(156);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(157);
						((ExpressionContext)_localctx).multiplication = match(MULTYPLICATION);
						setState(158);
						expression(11);
						}
						break;
					case 10:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(159);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(160);
						((ExpressionContext)_localctx).div = match(DIVISION);
						setState(161);
						expression(10);
						}
						break;
					case 11:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(162);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(163);
						((ExpressionContext)_localctx).add = match(ADD);
						setState(164);
						expression(9);
						}
						break;
					case 12:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(165);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(166);
						((ExpressionContext)_localctx).minus = match(MINUS);
						setState(167);
						expression(8);
						}
						break;
					case 13:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(168);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(169);
						((ExpressionContext)_localctx).pow = match(POW);
						setState(170);
						expression(7);
						}
						break;
					case 14:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(171);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(172);
						((ExpressionContext)_localctx).nullableOr = match(NULLABLE_OR);
						setState(173);
						expression(6);
						}
						break;
					case 15:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(174);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(175);
						((ExpressionContext)_localctx).unaryPlus = match(UNARY_ADD);
						}
						break;
					case 16:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(176);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(177);
						((ExpressionContext)_localctx).unaryMinus = match(UNARY_MINUS);
						}
						break;
					}
					} 
				}
				setState(182);
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
		public Token call;
		public ParentnesesExprContext parentnesesExpr() {
			return getRuleContext(ParentnesesExprContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public StopContext stop() {
			return getRuleContext(StopContext.class,0);
		}
		public IfExprContext ifExpr() {
			return getRuleContext(IfExprContext.class,0);
		}
		public ReturnExprContext returnExpr() {
			return getRuleContext(ReturnExprContext.class,0);
		}
		public NewClassContext newClass() {
			return getRuleContext(NewClassContext.class,0);
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
		public TerminalNode CLOSE() { return getToken(lclangParser.CLOSE, 0); }
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public TerminalNode OPEN() { return getToken(lclangParser.OPEN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(lclangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(lclangParser.COMMA, i);
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
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPEN:
				{
				setState(183);
				parentnesesExpr();
				}
				break;
			case NULL:
			case BOOL:
			case STRING:
			case CHAR:
			case HEX_LONG:
			case LONG:
			case DOUBLE:
			case INTEGER:
				{
				setState(184);
				value();
				}
				break;
			case STOP:
				{
				setState(185);
				stop();
				}
				break;
			case IF:
				{
				setState(186);
				ifExpr();
				}
				break;
			case RETURN:
				{
				setState(187);
				returnExpr();
				}
				break;
			case COLON:
				{
				setState(188);
				newClass();
				}
				break;
			case ID:
				{
				setState(189);
				variable();
				}
				break;
			case OPEN_BRACKET:
				{
				setState(190);
				array();
				}
				break;
			case MULTYPLICATION:
				{
				setState(191);
				typeGet();
				}
				break;
			case MINUS:
				{
				setState(192);
				lambda();
				}
				break;
			case OPEN_BRACE:
				{
				setState(193);
				container();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(199);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(196);
					arrayAccess();
					}
					} 
				}
				setState(201);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			setState(215);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(202);
				((PrimitiveContext)_localctx).call = match(OPEN);
				setState(208);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(203);
						expression(0);
						setState(204);
						match(COMMA);
						}
						} 
					}
					setState(210);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				}
				setState(212);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPEN) | (1L << OPEN_BRACE) | (1L << OPEN_BRACKET) | (1L << NOT) | (1L << MULTYPLICATION) | (1L << MINUS) | (1L << COLON) | (1L << STOP) | (1L << RETURN) | (1L << IF) | (1L << NULL) | (1L << BOOL) | (1L << ID) | (1L << STRING) | (1L << CHAR) | (1L << HEX_LONG) | (1L << LONG) | (1L << DOUBLE) | (1L << INTEGER))) != 0)) {
					{
					setState(211);
					expression(0);
					}
				}

				setState(214);
				match(CLOSE);
				}
				break;
			}
			setState(218);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(217);
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
		public TerminalNode NULL() { return getToken(lclangParser.NULL, 0); }
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
			setState(220);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NULL) | (1L << BOOL) | (1L << STRING) | (1L << CHAR) | (1L << HEX_LONG) | (1L << LONG) | (1L << DOUBLE) | (1L << INTEGER))) != 0)) ) {
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

	public static class ParentnesesExprContext extends ParserRuleContext {
		public TerminalNode OPEN() { return getToken(lclangParser.OPEN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode CLOSE() { return getToken(lclangParser.CLOSE, 0); }
		public ParentnesesExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parentnesesExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).enterParentnesesExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).exitParentnesesExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lclangVisitor ) return ((lclangVisitor<? extends T>)visitor).visitParentnesesExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParentnesesExprContext parentnesesExpr() throws RecognitionException {
		ParentnesesExprContext _localctx = new ParentnesesExprContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_parentnesesExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			match(OPEN);
			setState(223);
			expression(0);
			setState(224);
			match(CLOSE);
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
		public TerminalNode RETURN() { return getToken(lclangParser.RETURN, 0); }
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
		enterRule(_localctx, 16, RULE_returnExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			match(RETURN);
			setState(228);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				setState(227);
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
		public TerminalNode MULTYPLICATION() { return getToken(lclangParser.MULTYPLICATION, 0); }
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
		enterRule(_localctx, 18, RULE_typeGet);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			match(MULTYPLICATION);
			setState(231);
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
		public TerminalNode DOT() { return getToken(lclangParser.DOT, 0); }
		public PrimitiveContext primitive() {
			return getRuleContext(PrimitiveContext.class,0);
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
		enterRule(_localctx, 20, RULE_access);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			match(DOT);
			setState(234);
			primitive();
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
		public TerminalNode OPEN_BRACKET() { return getToken(lclangParser.OPEN_BRACKET, 0); }
		public TerminalNode CLOSE_BRACKET() { return getToken(lclangParser.CLOSE_BRACKET, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(lclangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(lclangParser.COMMA, i);
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
		enterRule(_localctx, 22, RULE_array);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			match(OPEN_BRACKET);
			setState(242);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(237);
					expression(0);
					setState(238);
					match(COMMA);
					}
					} 
				}
				setState(244);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			}
			setState(246);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPEN) | (1L << OPEN_BRACE) | (1L << OPEN_BRACKET) | (1L << NOT) | (1L << MULTYPLICATION) | (1L << MINUS) | (1L << COLON) | (1L << STOP) | (1L << RETURN) | (1L << IF) | (1L << NULL) | (1L << BOOL) | (1L << ID) | (1L << STRING) | (1L << CHAR) | (1L << HEX_LONG) | (1L << LONG) | (1L << DOUBLE) | (1L << INTEGER))) != 0)) {
				{
				setState(245);
				expression(0);
				}
			}

			setState(248);
			match(CLOSE_BRACKET);
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
		public TerminalNode OPEN_BRACKET() { return getToken(lclangParser.OPEN_BRACKET, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode CLOSE_BRACKET() { return getToken(lclangParser.CLOSE_BRACKET, 0); }
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
		enterRule(_localctx, 24, RULE_arrayAccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			match(OPEN_BRACKET);
			setState(251);
			expression(0);
			setState(252);
			match(CLOSE_BRACKET);
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
		public TerminalNode STOP() { return getToken(lclangParser.STOP, 0); }
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
		enterRule(_localctx, 26, RULE_stop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			match(STOP);
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
		enterRule(_localctx, 28, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
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
		public TerminalNode MINUS() { return getToken(lclangParser.MINUS, 0); }
		public TerminalNode LARGER() { return getToken(lclangParser.LARGER, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public TerminalNode COLON() { return getToken(lclangParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
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
		enterRule(_localctx, 30, RULE_lambda);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			match(MINUS);
			setState(259);
			match(LARGER);
			setState(261);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(260);
				args();
				}
				break;
			}
			setState(265);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(263);
				match(COLON);
				setState(264);
				type();
				}
				break;
			}
			setState(267);
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
		public TerminalNode OPEN_BRACE() { return getToken(lclangParser.OPEN_BRACE, 0); }
		public TerminalNode CLOSE_BRACE() { return getToken(lclangParser.CLOSE_BRACE, 0); }
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
		enterRule(_localctx, 32, RULE_container);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			match(OPEN_BRACE);
			setState(273);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPEN) | (1L << OPEN_BRACE) | (1L << OPEN_BRACKET) | (1L << NOT) | (1L << MULTYPLICATION) | (1L << MINUS) | (1L << COLON) | (1L << STOP) | (1L << RETURN) | (1L << WHILE) | (1L << IF) | (1L << NULL) | (1L << BOOL) | (1L << ID) | (1L << STRING) | (1L << CHAR) | (1L << HEX_LONG) | (1L << LONG) | (1L << DOUBLE) | (1L << INTEGER))) != 0)) {
				{
				{
				setState(270);
				stmt();
				}
				}
				setState(275);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(276);
			match(CLOSE_BRACE);
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
		public TerminalNode IF() { return getToken(lclangParser.IF, 0); }
		public TerminalNode COLON() { return getToken(lclangParser.COLON, 0); }
		public TerminalNode ELSE() { return getToken(lclangParser.ELSE, 0); }
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
		enterRule(_localctx, 34, RULE_ifExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			match(IF);
			setState(279);
			((IfExprContext)_localctx).condition = expression(0);
			setState(280);
			match(COLON);
			setState(281);
			((IfExprContext)_localctx).ifT = expression(0);
			setState(282);
			match(ELSE);
			setState(283);
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

	public static class NewClassContext extends ParserRuleContext {
		public BaseTypeContext className;
		public TerminalNode COLON() { return getToken(lclangParser.COLON, 0); }
		public BaseTypeContext baseType() {
			return getRuleContext(BaseTypeContext.class,0);
		}
		public NewClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newClass; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).enterNewClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).exitNewClass(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lclangVisitor ) return ((lclangVisitor<? extends T>)visitor).visitNewClass(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NewClassContext newClass() throws RecognitionException {
		NewClassContext _localctx = new NewClassContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_newClass);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
			match(COLON);
			setState(286);
			((NewClassContext)_localctx).className = baseType();
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
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
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
		enterRule(_localctx, 38, RULE_operation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			assign();
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

	public static class AssignContext extends ParserRuleContext {
		public TerminalNode ASSIGN() { return getToken(lclangParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).exitAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lclangVisitor ) return ((lclangVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(290);
			match(ASSIGN);
			setState(291);
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
		public TerminalNode SEMICOLON() { return getToken(lclangParser.SEMICOLON, 0); }
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
		enterRule(_localctx, 42, RULE_stmt);
		int _la;
		try {
			setState(300);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(293);
				block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(294);
				whileStmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(295);
				ifStmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(296);
				expression(0);
				setState(298);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(297);
					match(SEMICOLON);
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
		public TerminalNode WHILE() { return getToken(lclangParser.WHILE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode COLON() { return getToken(lclangParser.COLON, 0); }
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
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
		enterRule(_localctx, 44, RULE_whileStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302);
			match(WHILE);
			setState(303);
			((WhileStmtContext)_localctx).condition = expression(0);
			setState(306);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(304);
				match(COLON);
				setState(305);
				stmt();
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

	public static class IfStmtContext extends ParserRuleContext {
		public ExpressionContext condition;
		public StmtContext ifT;
		public StmtContext ifF;
		public TerminalNode IF() { return getToken(lclangParser.IF, 0); }
		public TerminalNode COLON() { return getToken(lclangParser.COLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(lclangParser.ELSE, 0); }
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
		enterRule(_localctx, 46, RULE_ifStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			match(IF);
			setState(309);
			((IfStmtContext)_localctx).condition = expression(0);
			setState(310);
			match(COLON);
			setState(311);
			((IfStmtContext)_localctx).ifT = stmt();
			setState(314);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(312);
				match(ELSE);
				setState(313);
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
		public TerminalNode OPEN_BRACE() { return getToken(lclangParser.OPEN_BRACE, 0); }
		public TerminalNode CLOSE_BRACE() { return getToken(lclangParser.CLOSE_BRACE, 0); }
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
		enterRule(_localctx, 48, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(316);
			match(OPEN_BRACE);
			setState(320);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPEN) | (1L << OPEN_BRACE) | (1L << OPEN_BRACKET) | (1L << NOT) | (1L << MULTYPLICATION) | (1L << MINUS) | (1L << COLON) | (1L << STOP) | (1L << RETURN) | (1L << WHILE) | (1L << IF) | (1L << NULL) | (1L << BOOL) | (1L << ID) | (1L << STRING) | (1L << CHAR) | (1L << HEX_LONG) | (1L << LONG) | (1L << DOUBLE) | (1L << INTEGER))) != 0)) {
				{
				{
				setState(317);
				stmt();
				}
				}
				setState(322);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(323);
			match(CLOSE_BRACE);
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
		public TerminalNode COMPONENT() { return getToken(lclangParser.COMPONENT, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode OPEN_BRACE() { return getToken(lclangParser.OPEN_BRACE, 0); }
		public TerminalNode CLOSE_BRACE() { return getToken(lclangParser.CLOSE_BRACE, 0); }
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
		enterRule(_localctx, 50, RULE_component);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(325);
			match(COMPONENT);
			setState(326);
			type();
			setState(327);
			match(OPEN_BRACE);
			setState(331);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==GLOBAL) {
				{
				{
				setState(328);
				global();
				}
				}
				setState(333);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(337);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CLASS) {
				{
				{
				setState(334);
				classExpr();
				}
				}
				setState(339);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(340);
			match(CLOSE_BRACE);
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
		public TerminalNode CLASS() { return getToken(lclangParser.CLASS, 0); }
		public TerminalNode ID() { return getToken(lclangParser.ID, 0); }
		public TerminalNode OPEN_BRACE() { return getToken(lclangParser.OPEN_BRACE, 0); }
		public TerminalNode CLOSE_BRACE() { return getToken(lclangParser.CLOSE_BRACE, 0); }
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
		enterRule(_localctx, 52, RULE_classExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(342);
			match(CLASS);
			setState(343);
			match(ID);
			setState(344);
			match(OPEN_BRACE);
			setState(349);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AS_ATTR) | (1L << METHOD) | (1L << ID))) != 0)) {
				{
				setState(347);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case AS_ATTR:
				case METHOD:
					{
					setState(345);
					method();
					}
					break;
				case ID:
					{
					setState(346);
					field();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(351);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(352);
			match(CLOSE_BRACE);
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
		public TerminalNode ASSIGN() { return getToken(lclangParser.ASSIGN, 0); }
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
		enterRule(_localctx, 54, RULE_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(354);
			match(ID);
			setState(357);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(355);
				match(ASSIGN);
				setState(356);
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
		public TerminalNode COLON() { return getToken(lclangParser.COLON, 0); }
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
		enterRule(_localctx, 56, RULE_arg);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(359);
			match(ID);
			setState(362);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(360);
				match(COLON);
				setState(361);
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
		public TerminalNode OPEN() { return getToken(lclangParser.OPEN, 0); }
		public TerminalNode CLOSE() { return getToken(lclangParser.CLOSE, 0); }
		public List<ArgContext> arg() {
			return getRuleContexts(ArgContext.class);
		}
		public ArgContext arg(int i) {
			return getRuleContext(ArgContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(lclangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(lclangParser.COMMA, i);
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
		enterRule(_localctx, 58, RULE_args);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(364);
			match(OPEN);
			setState(370);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(365);
					arg();
					setState(366);
					match(COMMA);
					}
					} 
				}
				setState(372);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			}
			setState(374);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(373);
				arg();
				}
			}

			setState(376);
			match(CLOSE);
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
		public TerminalNode AS_ATTR() { return getToken(lclangParser.AS_ATTR, 0); }
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
		enterRule(_localctx, 60, RULE_attribute);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(378);
			match(AS_ATTR);
			setState(379);
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
		public TerminalNode COLON() { return getToken(lclangParser.COLON, 0); }
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
		enterRule(_localctx, 62, RULE_method);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(384);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AS_ATTR) {
				{
				{
				setState(381);
				attribute();
				}
				}
				setState(386);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(387);
			match(METHOD);
			setState(388);
			match(ID);
			setState(389);
			args();
			setState(392);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(390);
				match(COLON);
				setState(391);
				type();
				}
			}

			setState(394);
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
		public TerminalNode USE() { return getToken(lclangParser.USE, 0); }
		public BaseTypeContext baseType() {
			return getRuleContext(BaseTypeContext.class,0);
		}
		public TerminalNode FROM() { return getToken(lclangParser.FROM, 0); }
		public TerminalNode STRING() { return getToken(lclangParser.STRING, 0); }
		public TerminalNode GLOBAL() { return getToken(lclangParser.GLOBAL, 0); }
		public TerminalNode SEMICOLON() { return getToken(lclangParser.SEMICOLON, 0); }
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
		enterRule(_localctx, 64, RULE_use);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(396);
			match(USE);
			setState(397);
			((UseContext)_localctx).useGlobal = match(GLOBAL);
			setState(398);
			baseType();
			setState(399);
			match(FROM);
			setState(400);
			match(STRING);
			setState(402);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMICOLON) {
				{
				setState(401);
				match(SEMICOLON);
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
		public TerminalNode GLOBAL() { return getToken(lclangParser.GLOBAL, 0); }
		public TerminalNode ID() { return getToken(lclangParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(lclangParser.ASSIGN, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(lclangParser.SEMICOLON, 0); }
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
		enterRule(_localctx, 66, RULE_global);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(404);
			match(GLOBAL);
			setState(405);
			match(ID);
			setState(406);
			match(ASSIGN);
			setState(407);
			value();
			setState(409);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMICOLON) {
				{
				setState(408);
				match(SEMICOLON);
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
			return precpred(_ctx, 18);
		case 1:
			return precpred(_ctx, 17);
		case 2:
			return precpred(_ctx, 16);
		case 3:
			return precpred(_ctx, 15);
		case 4:
			return precpred(_ctx, 14);
		case 5:
			return precpred(_ctx, 13);
		case 6:
			return precpred(_ctx, 12);
		case 7:
			return precpred(_ctx, 11);
		case 8:
			return precpred(_ctx, 10);
		case 9:
			return precpred(_ctx, 9);
		case 10:
			return precpred(_ctx, 8);
		case 11:
			return precpred(_ctx, 7);
		case 12:
			return precpred(_ctx, 6);
		case 13:
			return precpred(_ctx, 5);
		case 14:
			return precpred(_ctx, 4);
		case 15:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3:\u019e\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\3\2\7\2H\n\2\f\2\16\2K\13\2\3\2\7\2N\n\2\f\2\16\2Q\13"+
		"\2\3\2\3\2\3\2\3\2\7\2W\n\2\f\2\16\2Z\13\2\3\2\3\2\3\3\5\3_\n\3\3\3\3"+
		"\3\5\3c\n\3\3\4\3\4\3\4\3\4\7\4i\n\4\f\4\16\4l\13\4\3\4\5\4o\n\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\5\3\5\3\5\5\5y\n\5\3\6\3\6\3\6\3\6\3\6\7\6\u0080\n\6"+
		"\f\6\16\6\u0083\13\6\5\6\u0085\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\7\6\u00b5\n\6\f\6\16\6\u00b8\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\5\7\u00c5\n\7\3\7\7\7\u00c8\n\7\f\7\16\7\u00cb\13\7\3"+
		"\7\3\7\3\7\3\7\7\7\u00d1\n\7\f\7\16\7\u00d4\13\7\3\7\5\7\u00d7\n\7\3\7"+
		"\5\7\u00da\n\7\3\7\5\7\u00dd\n\7\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\5\n\u00e7"+
		"\n\n\3\13\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\r\7\r\u00f3\n\r\f\r\16\r"+
		"\u00f6\13\r\3\r\5\r\u00f9\n\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3"+
		"\20\3\20\3\21\3\21\3\21\5\21\u0108\n\21\3\21\3\21\5\21\u010c\n\21\3\21"+
		"\3\21\3\22\3\22\7\22\u0112\n\22\f\22\16\22\u0115\13\22\3\22\3\22\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\26\3\26\3\26"+
		"\3\27\3\27\3\27\3\27\3\27\5\27\u012d\n\27\5\27\u012f\n\27\3\30\3\30\3"+
		"\30\3\30\5\30\u0135\n\30\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u013d\n\31"+
		"\3\32\3\32\7\32\u0141\n\32\f\32\16\32\u0144\13\32\3\32\3\32\3\33\3\33"+
		"\3\33\3\33\7\33\u014c\n\33\f\33\16\33\u014f\13\33\3\33\7\33\u0152\n\33"+
		"\f\33\16\33\u0155\13\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\7\34\u015e"+
		"\n\34\f\34\16\34\u0161\13\34\3\34\3\34\3\35\3\35\3\35\5\35\u0168\n\35"+
		"\3\36\3\36\3\36\5\36\u016d\n\36\3\37\3\37\3\37\3\37\7\37\u0173\n\37\f"+
		"\37\16\37\u0176\13\37\3\37\5\37\u0179\n\37\3\37\3\37\3 \3 \3 \3!\7!\u0181"+
		"\n!\f!\16!\u0184\13!\3!\3!\3!\3!\3!\5!\u018b\n!\3!\3!\3\"\3\"\3\"\3\""+
		"\3\"\3\"\5\"\u0195\n\"\3#\3#\3#\3#\3#\5#\u019c\n#\3#\2\3\n$\2\4\6\b\n"+
		"\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BD\2\3\4\2\61\62"+
		"\649\2\u01c0\2I\3\2\2\2\4^\3\2\2\2\6d\3\2\2\2\bu\3\2\2\2\n\u0084\3\2\2"+
		"\2\f\u00c4\3\2\2\2\16\u00de\3\2\2\2\20\u00e0\3\2\2\2\22\u00e4\3\2\2\2"+
		"\24\u00e8\3\2\2\2\26\u00eb\3\2\2\2\30\u00ee\3\2\2\2\32\u00fc\3\2\2\2\34"+
		"\u0100\3\2\2\2\36\u0102\3\2\2\2 \u0104\3\2\2\2\"\u010f\3\2\2\2$\u0118"+
		"\3\2\2\2&\u011f\3\2\2\2(\u0122\3\2\2\2*\u0124\3\2\2\2,\u012e\3\2\2\2."+
		"\u0130\3\2\2\2\60\u0136\3\2\2\2\62\u013e\3\2\2\2\64\u0147\3\2\2\2\66\u0158"+
		"\3\2\2\28\u0164\3\2\2\2:\u0169\3\2\2\2<\u016e\3\2\2\2>\u017c\3\2\2\2@"+
		"\u0182\3\2\2\2B\u018e\3\2\2\2D\u0196\3\2\2\2FH\5B\"\2GF\3\2\2\2HK\3\2"+
		"\2\2IG\3\2\2\2IJ\3\2\2\2JO\3\2\2\2KI\3\2\2\2LN\5D#\2ML\3\2\2\2NQ\3\2\2"+
		"\2OM\3\2\2\2OP\3\2\2\2PX\3\2\2\2QO\3\2\2\2RW\5,\27\2SW\5@!\2TW\5\64\33"+
		"\2UW\5\66\34\2VR\3\2\2\2VS\3\2\2\2VT\3\2\2\2VU\3\2\2\2WZ\3\2\2\2XV\3\2"+
		"\2\2XY\3\2\2\2Y[\3\2\2\2ZX\3\2\2\2[\\\7\2\2\3\\\3\3\2\2\2]_\7\25\2\2^"+
		"]\3\2\2\2^_\3\2\2\2_b\3\2\2\2`c\5\6\4\2ac\5\b\5\2b`\3\2\2\2ba\3\2\2\2"+
		"c\5\3\2\2\2dj\7\5\2\2ef\5\4\3\2fg\7\27\2\2gi\3\2\2\2he\3\2\2\2il\3\2\2"+
		"\2jh\3\2\2\2jk\3\2\2\2kn\3\2\2\2lj\3\2\2\2mo\5\4\3\2nm\3\2\2\2no\3\2\2"+
		"\2op\3\2\2\2pq\7\6\2\2qr\7\"\2\2rs\7\36\2\2st\5\4\3\2t\7\3\2\2\2ux\7\63"+
		"\2\2vw\7\26\2\2wy\5\b\5\2xv\3\2\2\2xy\3\2\2\2y\t\3\2\2\2z{\b\6\1\2{|\7"+
		"\34\2\2|\u0085\5\n\6\4}\u0081\5\f\7\2~\u0080\5\26\f\2\177~\3\2\2\2\u0080"+
		"\u0083\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0085\3\2\2"+
		"\2\u0083\u0081\3\2\2\2\u0084z\3\2\2\2\u0084}\3\2\2\2\u0085\u00b6\3\2\2"+
		"\2\u0086\u0087\f\24\2\2\u0087\u0088\7\17\2\2\u0088\u00b5\5\n\6\25\u0089"+
		"\u008a\f\23\2\2\u008a\u008b\7\16\2\2\u008b\u00b5\5\n\6\24\u008c\u008d"+
		"\f\22\2\2\u008d\u008e\7\f\2\2\u008e\u00b5\5\n\6\23\u008f\u0090\f\21\2"+
		"\2\u0090\u0091\7\r\2\2\u0091\u00b5\5\n\6\22\u0092\u0093\f\20\2\2\u0093"+
		"\u0094\7\35\2\2\u0094\u00b5\5\n\6\21\u0095\u0096\f\17\2\2\u0096\u0097"+
		"\7\36\2\2\u0097\u00b5\5\n\6\20\u0098\u0099\f\16\2\2\u0099\u009a\7\21\2"+
		"\2\u009a\u00b5\5\n\6\17\u009b\u009c\f\r\2\2\u009c\u009d\7\20\2\2\u009d"+
		"\u00b5\5\n\6\16\u009e\u009f\f\f\2\2\u009f\u00a0\7\37\2\2\u00a0\u00b5\5"+
		"\n\6\r\u00a1\u00a2\f\13\2\2\u00a2\u00a3\7 \2\2\u00a3\u00b5\5\n\6\f\u00a4"+
		"\u00a5\f\n\2\2\u00a5\u00a6\7!\2\2\u00a6\u00b5\5\n\6\13\u00a7\u00a8\f\t"+
		"\2\2\u00a8\u00a9\7\"\2\2\u00a9\u00b5\5\n\6\n\u00aa\u00ab\f\b\2\2\u00ab"+
		"\u00ac\7\13\2\2\u00ac\u00b5\5\n\6\t\u00ad\u00ae\f\7\2\2\u00ae\u00af\7"+
		"\24\2\2\u00af\u00b5\5\n\6\b\u00b0\u00b1\f\6\2\2\u00b1\u00b5\7\22\2\2\u00b2"+
		"\u00b3\f\5\2\2\u00b3\u00b5\7\23\2\2\u00b4\u0086\3\2\2\2\u00b4\u0089\3"+
		"\2\2\2\u00b4\u008c\3\2\2\2\u00b4\u008f\3\2\2\2\u00b4\u0092\3\2\2\2\u00b4"+
		"\u0095\3\2\2\2\u00b4\u0098\3\2\2\2\u00b4\u009b\3\2\2\2\u00b4\u009e\3\2"+
		"\2\2\u00b4\u00a1\3\2\2\2\u00b4\u00a4\3\2\2\2\u00b4\u00a7\3\2\2\2\u00b4"+
		"\u00aa\3\2\2\2\u00b4\u00ad\3\2\2\2\u00b4\u00b0\3\2\2\2\u00b4\u00b2\3\2"+
		"\2\2\u00b5\u00b8\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7"+
		"\13\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b9\u00c5\5\20\t\2\u00ba\u00c5\5\16"+
		"\b\2\u00bb\u00c5\5\34\17\2\u00bc\u00c5\5$\23\2\u00bd\u00c5\5\22\n\2\u00be"+
		"\u00c5\5&\24\2\u00bf\u00c5\5\36\20\2\u00c0\u00c5\5\30\r\2\u00c1\u00c5"+
		"\5\24\13\2\u00c2\u00c5\5 \21\2\u00c3\u00c5\5\"\22\2\u00c4\u00b9\3\2\2"+
		"\2\u00c4\u00ba\3\2\2\2\u00c4\u00bb\3\2\2\2\u00c4\u00bc\3\2\2\2\u00c4\u00bd"+
		"\3\2\2\2\u00c4\u00be\3\2\2\2\u00c4\u00bf\3\2\2\2\u00c4\u00c0\3\2\2\2\u00c4"+
		"\u00c1\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c4\u00c3\3\2\2\2\u00c5\u00c9\3\2"+
		"\2\2\u00c6\u00c8\5\32\16\2\u00c7\u00c6\3\2\2\2\u00c8\u00cb\3\2\2\2\u00c9"+
		"\u00c7\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00d9\3\2\2\2\u00cb\u00c9\3\2"+
		"\2\2\u00cc\u00d2\7\5\2\2\u00cd\u00ce\5\n\6\2\u00ce\u00cf\7\27\2\2\u00cf"+
		"\u00d1\3\2\2\2\u00d0\u00cd\3\2\2\2\u00d1\u00d4\3\2\2\2\u00d2\u00d0\3\2"+
		"\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d6\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d5"+
		"\u00d7\5\n\6\2\u00d6\u00d5\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\u00d8\3\2"+
		"\2\2\u00d8\u00da\7\6\2\2\u00d9\u00cc\3\2\2\2\u00d9\u00da\3\2\2\2\u00da"+
		"\u00dc\3\2\2\2\u00db\u00dd\5(\25\2\u00dc\u00db\3\2\2\2\u00dc\u00dd\3\2"+
		"\2\2\u00dd\r\3\2\2\2\u00de\u00df\t\2\2\2\u00df\17\3\2\2\2\u00e0\u00e1"+
		"\7\5\2\2\u00e1\u00e2\5\n\6\2\u00e2\u00e3\7\6\2\2\u00e3\21\3\2\2\2\u00e4"+
		"\u00e6\7-\2\2\u00e5\u00e7\5\n\6\2\u00e6\u00e5\3\2\2\2\u00e6\u00e7\3\2"+
		"\2\2\u00e7\23\3\2\2\2\u00e8\u00e9\7\37\2\2\u00e9\u00ea\5\n\6\2\u00ea\25"+
		"\3\2\2\2\u00eb\u00ec\7$\2\2\u00ec\u00ed\5\f\7\2\u00ed\27\3\2\2\2\u00ee"+
		"\u00f4\7\t\2\2\u00ef\u00f0\5\n\6\2\u00f0\u00f1\7\27\2\2\u00f1\u00f3\3"+
		"\2\2\2\u00f2\u00ef\3\2\2\2\u00f3\u00f6\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f4"+
		"\u00f5\3\2\2\2\u00f5\u00f8\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f7\u00f9\5\n"+
		"\6\2\u00f8\u00f7\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa"+
		"\u00fb\7\n\2\2\u00fb\31\3\2\2\2\u00fc\u00fd\7\t\2\2\u00fd\u00fe\5\n\6"+
		"\2\u00fe\u00ff\7\n\2\2\u00ff\33\3\2\2\2\u0100\u0101\7,\2\2\u0101\35\3"+
		"\2\2\2\u0102\u0103\7\63\2\2\u0103\37\3\2\2\2\u0104\u0105\7\"\2\2\u0105"+
		"\u0107\7\36\2\2\u0106\u0108\5<\37\2\u0107\u0106\3\2\2\2\u0107\u0108\3"+
		"\2\2\2\u0108\u010b\3\2\2\2\u0109\u010a\7#\2\2\u010a\u010c\5\4\3\2\u010b"+
		"\u0109\3\2\2\2\u010b\u010c\3\2\2\2\u010c\u010d\3\2\2\2\u010d\u010e\5\n"+
		"\6\2\u010e!\3\2\2\2\u010f\u0113\7\7\2\2\u0110\u0112\5,\27\2\u0111\u0110"+
		"\3\2\2\2\u0112\u0115\3\2\2\2\u0113\u0111\3\2\2\2\u0113\u0114\3\2\2\2\u0114"+
		"\u0116\3\2\2\2\u0115\u0113\3\2\2\2\u0116\u0117\7\b\2\2\u0117#\3\2\2\2"+
		"\u0118\u0119\7/\2\2\u0119\u011a\5\n\6\2\u011a\u011b\7#\2\2\u011b\u011c"+
		"\5\n\6\2\u011c\u011d\7\60\2\2\u011d\u011e\5\n\6\2\u011e%\3\2\2\2\u011f"+
		"\u0120\7#\2\2\u0120\u0121\5\b\5\2\u0121\'\3\2\2\2\u0122\u0123\5*\26\2"+
		"\u0123)\3\2\2\2\u0124\u0125\7\31\2\2\u0125\u0126\5\n\6\2\u0126+\3\2\2"+
		"\2\u0127\u012f\5\62\32\2\u0128\u012f\5.\30\2\u0129\u012f\5\60\31\2\u012a"+
		"\u012c\5\n\6\2\u012b\u012d\7\30\2\2\u012c\u012b\3\2\2\2\u012c\u012d\3"+
		"\2\2\2\u012d\u012f\3\2\2\2\u012e\u0127\3\2\2\2\u012e\u0128\3\2\2\2\u012e"+
		"\u0129\3\2\2\2\u012e\u012a\3\2\2\2\u012f-\3\2\2\2\u0130\u0131\7.\2\2\u0131"+
		"\u0134\5\n\6\2\u0132\u0133\7#\2\2\u0133\u0135\5,\27\2\u0134\u0132\3\2"+
		"\2\2\u0134\u0135\3\2\2\2\u0135/\3\2\2\2\u0136\u0137\7/\2\2\u0137\u0138"+
		"\5\n\6\2\u0138\u0139\7#\2\2\u0139\u013c\5,\27\2\u013a\u013b\7\60\2\2\u013b"+
		"\u013d\5,\27\2\u013c\u013a\3\2\2\2\u013c\u013d\3\2\2\2\u013d\61\3\2\2"+
		"\2\u013e\u0142\7\7\2\2\u013f\u0141\5,\27\2\u0140\u013f\3\2\2\2\u0141\u0144"+
		"\3\2\2\2\u0142\u0140\3\2\2\2\u0142\u0143\3\2\2\2\u0143\u0145\3\2\2\2\u0144"+
		"\u0142\3\2\2\2\u0145\u0146\7\b\2\2\u0146\63\3\2\2\2\u0147\u0148\7+\2\2"+
		"\u0148\u0149\5\4\3\2\u0149\u014d\7\7\2\2\u014a\u014c\5D#\2\u014b\u014a"+
		"\3\2\2\2\u014c\u014f\3\2\2\2\u014d\u014b\3\2\2\2\u014d\u014e\3\2\2\2\u014e"+
		"\u0153\3\2\2\2\u014f\u014d\3\2\2\2\u0150\u0152\5\66\34\2\u0151\u0150\3"+
		"\2\2\2\u0152\u0155\3\2\2\2\u0153\u0151\3\2\2\2\u0153\u0154\3\2\2\2\u0154"+
		"\u0156\3\2\2\2\u0155\u0153\3\2\2\2\u0156\u0157\7\b\2\2\u0157\65\3\2\2"+
		"\2\u0158\u0159\7)\2\2\u0159\u015a\7\63\2\2\u015a\u015f\7\7\2\2\u015b\u015e"+
		"\5@!\2\u015c\u015e\58\35\2\u015d\u015b\3\2\2\2\u015d\u015c\3\2\2\2\u015e"+
		"\u0161\3\2\2\2\u015f\u015d\3\2\2\2\u015f\u0160\3\2\2\2\u0160\u0162\3\2"+
		"\2\2\u0161\u015f\3\2\2\2\u0162\u0163\7\b\2\2\u0163\67\3\2\2\2\u0164\u0167"+
		"\7\63\2\2\u0165\u0166\7\31\2\2\u0166\u0168\5\n\6\2\u0167\u0165\3\2\2\2"+
		"\u0167\u0168\3\2\2\2\u01689\3\2\2\2\u0169\u016c\7\63\2\2\u016a\u016b\7"+
		"#\2\2\u016b\u016d\5\4\3\2\u016c\u016a\3\2\2\2\u016c\u016d\3\2\2\2\u016d"+
		";\3\2\2\2\u016e\u0174\7\5\2\2\u016f\u0170\5:\36\2\u0170\u0171\7\27\2\2"+
		"\u0171\u0173\3\2\2\2\u0172\u016f\3\2\2\2\u0173\u0176\3\2\2\2\u0174\u0172"+
		"\3\2\2\2\u0174\u0175\3\2\2\2\u0175\u0178\3\2\2\2\u0176\u0174\3\2\2\2\u0177"+
		"\u0179\5:\36\2\u0178\u0177\3\2\2\2\u0178\u0179\3\2\2\2\u0179\u017a\3\2"+
		"\2\2\u017a\u017b\7\6\2\2\u017b=\3\2\2\2\u017c\u017d\7%\2\2\u017d\u017e"+
		"\7\63\2\2\u017e?\3\2\2\2\u017f\u0181\5> \2\u0180\u017f\3\2\2\2\u0181\u0184"+
		"\3\2\2\2\u0182\u0180\3\2\2\2\u0182\u0183\3\2\2\2\u0183\u0185\3\2\2\2\u0184"+
		"\u0182\3\2\2\2\u0185\u0186\7\'\2\2\u0186\u0187\7\63\2\2\u0187\u018a\5"+
		"<\37\2\u0188\u0189\7#\2\2\u0189\u018b\5\4\3\2\u018a\u0188\3\2\2\2\u018a"+
		"\u018b\3\2\2\2\u018b\u018c\3\2\2\2\u018c\u018d\5\62\32\2\u018dA\3\2\2"+
		"\2\u018e\u018f\7(\2\2\u018f\u0190\7&\2\2\u0190\u0191\5\b\5\2\u0191\u0192"+
		"\7*\2\2\u0192\u0194\7\64\2\2\u0193\u0195\7\30\2\2\u0194\u0193\3\2\2\2"+
		"\u0194\u0195\3\2\2\2\u0195C\3\2\2\2\u0196\u0197\7&\2\2\u0197\u0198\7\63"+
		"\2\2\u0198\u0199\7\31\2\2\u0199\u019b\5\16\b\2\u019a\u019c\7\30\2\2\u019b"+
		"\u019a\3\2\2\2\u019b\u019c\3\2\2\2\u019cE\3\2\2\2,IOVX^bjnx\u0081\u0084"+
		"\u00b4\u00b6\u00c4\u00c9\u00d2\u00d6\u00d9\u00dc\u00e6\u00f4\u00f8\u0107"+
		"\u010b\u0113\u012c\u012e\u0134\u013c\u0142\u014d\u0153\u015d\u015f\u0167"+
		"\u016c\u0174\u0178\u0182\u018a\u0194\u019b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}