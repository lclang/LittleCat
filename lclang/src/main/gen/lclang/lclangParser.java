// Generated from C:/IdeaProjects/LittleCat/lclang/src/main/java/lclang\lclang.g4 by ANTLR 4.9.1
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
		LEFT_SHIFT=18, RIGHT_SHIFT=19, NULLABLE_OR=20, NULLABLE=21, LAMBDA_PREFIX=22, 
		TYPE_PREFIX=23, COMMA=24, SEMICOLON=25, ASSIGN=26, XOR=27, OR=28, AND=29, 
		COMPLIMENT=30, NOT=31, LESS=32, LARGER=33, MULTIPLICATION=34, DIVISION=35, 
		ADD=36, MINUS=37, COLON=38, DOT=39, AS_ATTR=40, GLOBAL=41, METHOD=42, 
		USE=43, CLASS=44, FROM=45, EXTENDS=46, COMPONENT=47, STOP=48, RETURN=49, 
		WHILE=50, AS=51, IF=52, IS=53, ELSE=54, BOOL=55, ID=56, STRING=57, CHAR=58, 
		HEX_LONG=59, LONG=60, DOUBLE=61, INTEGER=62, WS=63;
	public static final int
		RULE_file = 0, RULE_type = 1, RULE_methodType = 2, RULE_namedType = 3, 
		RULE_expression = 4, RULE_primitive = 5, RULE_value = 6, RULE_parentnesesExpr = 7, 
		RULE_returnExpr = 8, RULE_typeGet = 9, RULE_array = 10, RULE_stop = 11, 
		RULE_variable = 12, RULE_lambda = 13, RULE_container = 14, RULE_ifExpr = 15, 
		RULE_newClass = 16, RULE_stmt = 17, RULE_whileStmt = 18, RULE_ifStmt = 19, 
		RULE_block = 20, RULE_component = 21, RULE_classExpr = 22, RULE_extendsArgs = 23, 
		RULE_arg = 24, RULE_attribute = 25, RULE_method = 26, RULE_use = 27, RULE_global = 28;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "type", "methodType", "namedType", "expression", "primitive", 
			"value", "parentnesesExpr", "returnExpr", "typeGet", "array", "stop", 
			"variable", "lambda", "container", "ifExpr", "newClass", "stmt", "whileStmt", 
			"ifStmt", "block", "component", "classExpr", "extendsArgs", "arg", "attribute", 
			"method", "use", "global"
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
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==USE) {
				{
				{
				setState(58);
				use();
				}
				}
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==GLOBAL) {
				{
				{
				setState(64);
				global();
				}
				}
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(76);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPEN) | (1L << OPEN_BRACE) | (1L << OPEN_BRACKET) | (1L << LAMBDA_PREFIX) | (1L << COMPLIMENT) | (1L << NOT) | (1L << MULTIPLICATION) | (1L << COLON) | (1L << AS_ATTR) | (1L << METHOD) | (1L << CLASS) | (1L << COMPONENT) | (1L << STOP) | (1L << RETURN) | (1L << WHILE) | (1L << IF) | (1L << BOOL) | (1L << ID) | (1L << STRING) | (1L << CHAR) | (1L << HEX_LONG) | (1L << LONG) | (1L << DOUBLE) | (1L << INTEGER))) != 0)) {
				{
				setState(74);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case OPEN:
				case OPEN_BRACE:
				case OPEN_BRACKET:
				case LAMBDA_PREFIX:
				case COMPLIMENT:
				case NOT:
				case MULTIPLICATION:
				case COLON:
				case STOP:
				case RETURN:
				case WHILE:
				case IF:
				case BOOL:
				case ID:
				case STRING:
				case CHAR:
				case HEX_LONG:
				case LONG:
				case DOUBLE:
				case INTEGER:
					{
					setState(70);
					stmt();
					}
					break;
				case AS_ATTR:
				case METHOD:
					{
					setState(71);
					method();
					}
					break;
				case COMPONENT:
					{
					setState(72);
					component();
					}
					break;
				case CLASS:
					{
					setState(73);
					classExpr();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(78);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(79);
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
		public NamedTypeContext namedType() {
			return getRuleContext(NamedTypeContext.class,0);
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
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NULLABLE) {
				{
				setState(81);
				((TypeContext)_localctx).nullable = match(NULLABLE);
				}
			}

			setState(86);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPEN:
				{
				setState(84);
				methodType();
				}
				break;
			case ID:
				{
				setState(85);
				namedType();
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
		public TypeContext args;
		public TypeContext returnType;
		public TerminalNode OPEN() { return getToken(lclangParser.OPEN, 0); }
		public TerminalNode CLOSE() { return getToken(lclangParser.CLOSE, 0); }
		public TerminalNode LAMBDA_PREFIX() { return getToken(lclangParser.LAMBDA_PREFIX, 0); }
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
			setState(88);
			match(OPEN);
			setState(94);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(89);
					((MethodTypeContext)_localctx).args = type();
					setState(90);
					match(COMMA);
					}
					} 
				}
				setState(96);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPEN) | (1L << NULLABLE) | (1L << ID))) != 0)) {
				{
				setState(97);
				((MethodTypeContext)_localctx).args = type();
				}
			}

			setState(100);
			match(CLOSE);
			setState(101);
			match(LAMBDA_PREFIX);
			setState(102);
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

	public static class NamedTypeContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(lclangParser.ID, 0); }
		public TerminalNode TYPE_PREFIX() { return getToken(lclangParser.TYPE_PREFIX, 0); }
		public NamedTypeContext namedType() {
			return getRuleContext(NamedTypeContext.class,0);
		}
		public NamedTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namedType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).enterNamedType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).exitNamedType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lclangVisitor ) return ((lclangVisitor<? extends T>)visitor).visitNamedType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NamedTypeContext namedType() throws RecognitionException {
		NamedTypeContext _localctx = new NamedTypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_namedType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(ID);
			setState(107);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(105);
				match(TYPE_PREFIX);
				setState(106);
				namedType();
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
		public Token compliment;
		public Token not;
		public Token less;
		public Token larger;
		public Token largerEquals;
		public Token lessEquals;
		public Token equals;
		public Token notEquals;
		public Token or;
		public Token and;
		public Token assign;
		public Token multiplication;
		public Token div;
		public Token pow;
		public Token andBin;
		public Token orBin;
		public Token xor;
		public Token leftShift;
		public Token rightShift;
		public Token minus;
		public Token add;
		public Token nullableOr;
		public Token arrayAccess;
		public Token is;
		public Token access;
		public Token call;
		public Token throwNull;
		public Token unaryPlus;
		public Token unaryMinus;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode COMPLIMENT() { return getToken(lclangParser.COMPLIMENT, 0); }
		public List<TerminalNode> NOT() { return getTokens(lclangParser.NOT); }
		public TerminalNode NOT(int i) {
			return getToken(lclangParser.NOT, i);
		}
		public PrimitiveContext primitive() {
			return getRuleContext(PrimitiveContext.class,0);
		}
		public TerminalNode LESS() { return getToken(lclangParser.LESS, 0); }
		public TerminalNode LARGER() { return getToken(lclangParser.LARGER, 0); }
		public TerminalNode LARGER_EQUALS() { return getToken(lclangParser.LARGER_EQUALS, 0); }
		public TerminalNode LESS_EQUALS() { return getToken(lclangParser.LESS_EQUALS, 0); }
		public TerminalNode EQUALS() { return getToken(lclangParser.EQUALS, 0); }
		public TerminalNode NOT_EQUALS() { return getToken(lclangParser.NOT_EQUALS, 0); }
		public TerminalNode OR_BOOL() { return getToken(lclangParser.OR_BOOL, 0); }
		public TerminalNode AND_BOOL() { return getToken(lclangParser.AND_BOOL, 0); }
		public TerminalNode ASSIGN() { return getToken(lclangParser.ASSIGN, 0); }
		public TerminalNode MULTIPLICATION() { return getToken(lclangParser.MULTIPLICATION, 0); }
		public TerminalNode DIVISION() { return getToken(lclangParser.DIVISION, 0); }
		public TerminalNode POW() { return getToken(lclangParser.POW, 0); }
		public TerminalNode AND() { return getToken(lclangParser.AND, 0); }
		public TerminalNode OR() { return getToken(lclangParser.OR, 0); }
		public TerminalNode XOR() { return getToken(lclangParser.XOR, 0); }
		public TerminalNode LEFT_SHIFT() { return getToken(lclangParser.LEFT_SHIFT, 0); }
		public TerminalNode RIGHT_SHIFT() { return getToken(lclangParser.RIGHT_SHIFT, 0); }
		public TerminalNode MINUS() { return getToken(lclangParser.MINUS, 0); }
		public TerminalNode ADD() { return getToken(lclangParser.ADD, 0); }
		public TerminalNode NULLABLE_OR() { return getToken(lclangParser.NULLABLE_OR, 0); }
		public TerminalNode CLOSE_BRACKET() { return getToken(lclangParser.CLOSE_BRACKET, 0); }
		public TerminalNode OPEN_BRACKET() { return getToken(lclangParser.OPEN_BRACKET, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode IS() { return getToken(lclangParser.IS, 0); }
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public TerminalNode DOT() { return getToken(lclangParser.DOT, 0); }
		public TerminalNode CLOSE() { return getToken(lclangParser.CLOSE, 0); }
		public TerminalNode OPEN() { return getToken(lclangParser.OPEN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(lclangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(lclangParser.COMMA, i);
		}
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
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case COMPLIMENT:
				{
				setState(110);
				((ExpressionContext)_localctx).compliment = match(COMPLIMENT);
				setState(111);
				expression(3);
				}
				break;
			case NOT:
				{
				setState(112);
				((ExpressionContext)_localctx).not = match(NOT);
				setState(113);
				expression(2);
				}
				break;
			case OPEN:
			case OPEN_BRACE:
			case OPEN_BRACKET:
			case LAMBDA_PREFIX:
			case MULTIPLICATION:
			case COLON:
			case STOP:
			case RETURN:
			case IF:
			case BOOL:
			case ID:
			case STRING:
			case CHAR:
			case HEX_LONG:
			case LONG:
			case DOUBLE:
			case INTEGER:
				{
				setState(114);
				primitive();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(232);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(230);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(117);
						if (!(precpred(_ctx, 31))) throw new FailedPredicateException(this, "precpred(_ctx, 31)");
						setState(118);
						((ExpressionContext)_localctx).less = match(LESS);
						setState(119);
						expression(32);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(120);
						if (!(precpred(_ctx, 30))) throw new FailedPredicateException(this, "precpred(_ctx, 30)");
						setState(121);
						((ExpressionContext)_localctx).larger = match(LARGER);
						setState(122);
						expression(31);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(123);
						if (!(precpred(_ctx, 29))) throw new FailedPredicateException(this, "precpred(_ctx, 29)");
						setState(124);
						((ExpressionContext)_localctx).largerEquals = match(LARGER_EQUALS);
						setState(125);
						expression(30);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(126);
						if (!(precpred(_ctx, 28))) throw new FailedPredicateException(this, "precpred(_ctx, 28)");
						setState(127);
						((ExpressionContext)_localctx).lessEquals = match(LESS_EQUALS);
						setState(128);
						expression(29);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(129);
						if (!(precpred(_ctx, 27))) throw new FailedPredicateException(this, "precpred(_ctx, 27)");
						setState(130);
						((ExpressionContext)_localctx).equals = match(EQUALS);
						setState(131);
						expression(28);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(132);
						if (!(precpred(_ctx, 26))) throw new FailedPredicateException(this, "precpred(_ctx, 26)");
						setState(133);
						((ExpressionContext)_localctx).notEquals = match(NOT_EQUALS);
						setState(134);
						expression(27);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(135);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(136);
						((ExpressionContext)_localctx).or = match(OR_BOOL);
						setState(137);
						expression(26);
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(138);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(139);
						((ExpressionContext)_localctx).and = match(AND_BOOL);
						setState(140);
						expression(25);
						}
						break;
					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(141);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(142);
						((ExpressionContext)_localctx).assign = match(ASSIGN);
						setState(143);
						expression(24);
						}
						break;
					case 10:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(144);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(145);
						((ExpressionContext)_localctx).multiplication = match(MULTIPLICATION);
						setState(146);
						expression(23);
						}
						break;
					case 11:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(147);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(148);
						((ExpressionContext)_localctx).div = match(DIVISION);
						setState(149);
						expression(22);
						}
						break;
					case 12:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(150);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(151);
						((ExpressionContext)_localctx).pow = match(POW);
						setState(152);
						expression(21);
						}
						break;
					case 13:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(153);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(154);
						((ExpressionContext)_localctx).andBin = match(AND);
						setState(155);
						expression(20);
						}
						break;
					case 14:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(156);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(157);
						((ExpressionContext)_localctx).orBin = match(OR);
						setState(158);
						expression(19);
						}
						break;
					case 15:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(159);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(160);
						((ExpressionContext)_localctx).xor = match(XOR);
						setState(161);
						expression(18);
						}
						break;
					case 16:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(162);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(163);
						((ExpressionContext)_localctx).leftShift = match(LEFT_SHIFT);
						setState(164);
						expression(17);
						}
						break;
					case 17:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(165);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(166);
						((ExpressionContext)_localctx).rightShift = match(RIGHT_SHIFT);
						setState(167);
						expression(16);
						}
						break;
					case 18:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(168);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(169);
						((ExpressionContext)_localctx).minus = match(MINUS);
						setState(170);
						expression(15);
						}
						break;
					case 19:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(171);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(172);
						((ExpressionContext)_localctx).add = match(ADD);
						setState(173);
						expression(14);
						}
						break;
					case 20:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(174);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(175);
						((ExpressionContext)_localctx).add = match(ADD);
						setState(176);
						((ExpressionContext)_localctx).assign = match(ASSIGN);
						setState(177);
						expression(13);
						}
						break;
					case 21:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(178);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(179);
						((ExpressionContext)_localctx).minus = match(ADD);
						setState(180);
						((ExpressionContext)_localctx).assign = match(ASSIGN);
						setState(181);
						expression(12);
						}
						break;
					case 22:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(182);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(183);
						((ExpressionContext)_localctx).div = match(DIVISION);
						setState(184);
						((ExpressionContext)_localctx).assign = match(ASSIGN);
						setState(185);
						expression(11);
						}
						break;
					case 23:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(186);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(187);
						((ExpressionContext)_localctx).multiplication = match(MULTIPLICATION);
						setState(188);
						((ExpressionContext)_localctx).assign = match(ASSIGN);
						setState(189);
						expression(10);
						}
						break;
					case 24:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(190);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(191);
						((ExpressionContext)_localctx).pow = match(POW);
						setState(192);
						((ExpressionContext)_localctx).assign = match(ASSIGN);
						setState(193);
						expression(9);
						}
						break;
					case 25:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(194);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(195);
						((ExpressionContext)_localctx).nullableOr = match(NULLABLE_OR);
						setState(196);
						expression(8);
						}
						break;
					case 26:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(197);
						if (!(precpred(_ctx, 35))) throw new FailedPredicateException(this, "precpred(_ctx, 35)");
						setState(198);
						((ExpressionContext)_localctx).arrayAccess = match(OPEN_BRACKET);
						setState(200);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPEN) | (1L << OPEN_BRACE) | (1L << OPEN_BRACKET) | (1L << LAMBDA_PREFIX) | (1L << COMPLIMENT) | (1L << NOT) | (1L << MULTIPLICATION) | (1L << COLON) | (1L << STOP) | (1L << RETURN) | (1L << IF) | (1L << BOOL) | (1L << ID) | (1L << STRING) | (1L << CHAR) | (1L << HEX_LONG) | (1L << LONG) | (1L << DOUBLE) | (1L << INTEGER))) != 0)) {
							{
							setState(199);
							expression(0);
							}
						}

						setState(202);
						match(CLOSE_BRACKET);
						}
						break;
					case 27:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(203);
						if (!(precpred(_ctx, 34))) throw new FailedPredicateException(this, "precpred(_ctx, 34)");
						setState(204);
						((ExpressionContext)_localctx).is = match(IS);
						setState(205);
						type();
						}
						break;
					case 28:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(206);
						if (!(precpred(_ctx, 33))) throw new FailedPredicateException(this, "precpred(_ctx, 33)");
						setState(207);
						((ExpressionContext)_localctx).access = match(DOT);
						setState(208);
						variable();
						}
						break;
					case 29:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(209);
						if (!(precpred(_ctx, 32))) throw new FailedPredicateException(this, "precpred(_ctx, 32)");
						setState(210);
						((ExpressionContext)_localctx).call = match(OPEN);
						setState(216);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(211);
								expression(0);
								setState(212);
								match(COMMA);
								}
								} 
							}
							setState(218);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
						}
						setState(220);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPEN) | (1L << OPEN_BRACE) | (1L << OPEN_BRACKET) | (1L << LAMBDA_PREFIX) | (1L << COMPLIMENT) | (1L << NOT) | (1L << MULTIPLICATION) | (1L << COLON) | (1L << STOP) | (1L << RETURN) | (1L << IF) | (1L << BOOL) | (1L << ID) | (1L << STRING) | (1L << CHAR) | (1L << HEX_LONG) | (1L << LONG) | (1L << DOUBLE) | (1L << INTEGER))) != 0)) {
							{
							setState(219);
							expression(0);
							}
						}

						setState(222);
						match(CLOSE);
						}
						break;
					case 30:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(223);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(224);
						((ExpressionContext)_localctx).throwNull = match(NOT);
						setState(225);
						match(NOT);
						}
						break;
					case 31:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(226);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(227);
						((ExpressionContext)_localctx).unaryPlus = match(UNARY_ADD);
						}
						break;
					case 32:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(228);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(229);
						((ExpressionContext)_localctx).unaryMinus = match(UNARY_MINUS);
						}
						break;
					}
					} 
				}
				setState(234);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPEN:
				{
				setState(235);
				parentnesesExpr();
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
				setState(236);
				value();
				}
				break;
			case STOP:
				{
				setState(237);
				stop();
				}
				break;
			case IF:
				{
				setState(238);
				ifExpr();
				}
				break;
			case RETURN:
				{
				setState(239);
				returnExpr();
				}
				break;
			case COLON:
				{
				setState(240);
				newClass();
				}
				break;
			case ID:
				{
				setState(241);
				variable();
				}
				break;
			case OPEN_BRACKET:
				{
				setState(242);
				array();
				}
				break;
			case MULTIPLICATION:
				{
				setState(243);
				typeGet();
				}
				break;
			case LAMBDA_PREFIX:
				{
				setState(244);
				lambda();
				}
				break;
			case OPEN_BRACE:
				{
				setState(245);
				container();
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
			setState(248);
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
			setState(250);
			match(OPEN);
			setState(251);
			expression(0);
			setState(252);
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
			setState(254);
			match(RETURN);
			setState(256);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(255);
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
		public TerminalNode MULTIPLICATION() { return getToken(lclangParser.MULTIPLICATION, 0); }
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
			setState(258);
			match(MULTIPLICATION);
			setState(259);
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
		enterRule(_localctx, 20, RULE_array);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			match(OPEN_BRACKET);
			setState(267);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(262);
					expression(0);
					setState(263);
					match(COMMA);
					}
					} 
				}
				setState(269);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			setState(271);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPEN) | (1L << OPEN_BRACE) | (1L << OPEN_BRACKET) | (1L << LAMBDA_PREFIX) | (1L << COMPLIMENT) | (1L << NOT) | (1L << MULTIPLICATION) | (1L << COLON) | (1L << STOP) | (1L << RETURN) | (1L << IF) | (1L << BOOL) | (1L << ID) | (1L << STRING) | (1L << CHAR) | (1L << HEX_LONG) | (1L << LONG) | (1L << DOUBLE) | (1L << INTEGER))) != 0)) {
				{
				setState(270);
				expression(0);
				}
			}

			setState(273);
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
		enterRule(_localctx, 22, RULE_stop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
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
		enterRule(_localctx, 24, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
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
		public TerminalNode LAMBDA_PREFIX() { return getToken(lclangParser.LAMBDA_PREFIX, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode OPEN() { return getToken(lclangParser.OPEN, 0); }
		public TerminalNode CLOSE() { return getToken(lclangParser.CLOSE, 0); }
		public TerminalNode COLON() { return getToken(lclangParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
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
		enterRule(_localctx, 26, RULE_lambda);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(279);
			match(LAMBDA_PREFIX);
			setState(293);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(280);
				match(OPEN);
				setState(286);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(281);
						arg();
						setState(282);
						match(COMMA);
						}
						} 
					}
					setState(288);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
				}
				setState(290);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(289);
					arg();
					}
				}

				setState(292);
				match(CLOSE);
				}
				break;
			}
			setState(297);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(295);
				match(COLON);
				setState(296);
				type();
				}
				break;
			}
			setState(299);
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
		enterRule(_localctx, 28, RULE_container);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(301);
			match(OPEN_BRACE);
			setState(305);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPEN) | (1L << OPEN_BRACE) | (1L << OPEN_BRACKET) | (1L << LAMBDA_PREFIX) | (1L << COMPLIMENT) | (1L << NOT) | (1L << MULTIPLICATION) | (1L << COLON) | (1L << STOP) | (1L << RETURN) | (1L << WHILE) | (1L << IF) | (1L << BOOL) | (1L << ID) | (1L << STRING) | (1L << CHAR) | (1L << HEX_LONG) | (1L << LONG) | (1L << DOUBLE) | (1L << INTEGER))) != 0)) {
				{
				{
				setState(302);
				stmt();
				}
				}
				setState(307);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(308);
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
		enterRule(_localctx, 30, RULE_ifExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(310);
			match(IF);
			setState(311);
			((IfExprContext)_localctx).condition = expression(0);
			setState(312);
			match(COLON);
			setState(313);
			((IfExprContext)_localctx).ifT = expression(0);
			setState(314);
			match(ELSE);
			setState(315);
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
		public NamedTypeContext className;
		public TerminalNode COLON() { return getToken(lclangParser.COLON, 0); }
		public NamedTypeContext namedType() {
			return getRuleContext(NamedTypeContext.class,0);
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
		enterRule(_localctx, 32, RULE_newClass);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(317);
			match(COLON);
			setState(318);
			((NewClassContext)_localctx).className = namedType();
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
		enterRule(_localctx, 34, RULE_stmt);
		int _la;
		try {
			setState(327);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(320);
				block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(321);
				whileStmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(322);
				ifStmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(323);
				expression(0);
				setState(325);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(324);
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
		enterRule(_localctx, 36, RULE_whileStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(329);
			match(WHILE);
			setState(330);
			((WhileStmtContext)_localctx).condition = expression(0);
			setState(333);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				setState(331);
				match(COLON);
				setState(332);
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
		enterRule(_localctx, 38, RULE_ifStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(335);
			match(IF);
			setState(336);
			((IfStmtContext)_localctx).condition = expression(0);
			setState(337);
			match(COLON);
			setState(338);
			((IfStmtContext)_localctx).ifT = stmt();
			setState(341);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(339);
				match(ELSE);
				setState(340);
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
		enterRule(_localctx, 40, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(343);
			match(OPEN_BRACE);
			setState(347);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPEN) | (1L << OPEN_BRACE) | (1L << OPEN_BRACKET) | (1L << LAMBDA_PREFIX) | (1L << COMPLIMENT) | (1L << NOT) | (1L << MULTIPLICATION) | (1L << COLON) | (1L << STOP) | (1L << RETURN) | (1L << WHILE) | (1L << IF) | (1L << BOOL) | (1L << ID) | (1L << STRING) | (1L << CHAR) | (1L << HEX_LONG) | (1L << LONG) | (1L << DOUBLE) | (1L << INTEGER))) != 0)) {
				{
				{
				setState(344);
				stmt();
				}
				}
				setState(349);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(350);
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
		enterRule(_localctx, 42, RULE_component);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(352);
			match(COMPONENT);
			setState(353);
			type();
			setState(354);
			match(OPEN_BRACE);
			setState(358);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==GLOBAL) {
				{
				{
				setState(355);
				global();
				}
				}
				setState(360);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(364);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CLASS) {
				{
				{
				setState(361);
				classExpr();
				}
				}
				setState(366);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(367);
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
		public Token name;
		public NamedTypeContext classExtends;
		public TerminalNode CLASS() { return getToken(lclangParser.CLASS, 0); }
		public TerminalNode ID() { return getToken(lclangParser.ID, 0); }
		public List<TerminalNode> OPEN() { return getTokens(lclangParser.OPEN); }
		public TerminalNode OPEN(int i) {
			return getToken(lclangParser.OPEN, i);
		}
		public List<TerminalNode> CLOSE() { return getTokens(lclangParser.CLOSE); }
		public TerminalNode CLOSE(int i) {
			return getToken(lclangParser.CLOSE, i);
		}
		public TerminalNode EXTENDS() { return getToken(lclangParser.EXTENDS, 0); }
		public TerminalNode OPEN_BRACE() { return getToken(lclangParser.OPEN_BRACE, 0); }
		public TerminalNode CLOSE_BRACE() { return getToken(lclangParser.CLOSE_BRACE, 0); }
		public NamedTypeContext namedType() {
			return getRuleContext(NamedTypeContext.class,0);
		}
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
		public ExtendsArgsContext extendsArgs() {
			return getRuleContext(ExtendsArgsContext.class,0);
		}
		public List<MethodContext> method() {
			return getRuleContexts(MethodContext.class);
		}
		public MethodContext method(int i) {
			return getRuleContext(MethodContext.class,i);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
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
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(369);
			match(CLASS);
			setState(370);
			((ClassExprContext)_localctx).name = match(ID);
			setState(384);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				{
				setState(371);
				match(OPEN);
				setState(377);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(372);
						arg();
						setState(373);
						match(COMMA);
						}
						} 
					}
					setState(379);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
				}
				setState(381);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(380);
					arg();
					}
				}

				setState(383);
				match(CLOSE);
				}
				break;
			}
			setState(394);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(386);
				match(EXTENDS);
				setState(387);
				((ClassExprContext)_localctx).classExtends = namedType();
				setState(392);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
				case 1:
					{
					setState(388);
					match(OPEN);
					setState(389);
					extendsArgs();
					setState(390);
					match(CLOSE);
					}
					break;
				}
				}
			}

			setState(405);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				{
				setState(396);
				match(OPEN_BRACE);
				setState(401);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPEN) | (1L << OPEN_BRACE) | (1L << OPEN_BRACKET) | (1L << LAMBDA_PREFIX) | (1L << COMPLIMENT) | (1L << NOT) | (1L << MULTIPLICATION) | (1L << COLON) | (1L << AS_ATTR) | (1L << METHOD) | (1L << STOP) | (1L << RETURN) | (1L << WHILE) | (1L << IF) | (1L << BOOL) | (1L << ID) | (1L << STRING) | (1L << CHAR) | (1L << HEX_LONG) | (1L << LONG) | (1L << DOUBLE) | (1L << INTEGER))) != 0)) {
					{
					setState(399);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case AS_ATTR:
					case METHOD:
						{
						setState(397);
						method();
						}
						break;
					case OPEN:
					case OPEN_BRACE:
					case OPEN_BRACKET:
					case LAMBDA_PREFIX:
					case COMPLIMENT:
					case NOT:
					case MULTIPLICATION:
					case COLON:
					case STOP:
					case RETURN:
					case WHILE:
					case IF:
					case BOOL:
					case ID:
					case STRING:
					case CHAR:
					case HEX_LONG:
					case LONG:
					case DOUBLE:
					case INTEGER:
						{
						setState(398);
						stmt();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(403);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(404);
				match(CLOSE_BRACE);
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

	public static class ExtendsArgsContext extends ParserRuleContext {
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
		public ExtendsArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extendsArgs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).enterExtendsArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).exitExtendsArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lclangVisitor ) return ((lclangVisitor<? extends T>)visitor).visitExtendsArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExtendsArgsContext extendsArgs() throws RecognitionException {
		ExtendsArgsContext _localctx = new ExtendsArgsContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_extendsArgs);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(412);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(407);
					expression(0);
					setState(408);
					match(COMMA);
					}
					} 
				}
				setState(414);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			}
			setState(416);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPEN) | (1L << OPEN_BRACE) | (1L << OPEN_BRACKET) | (1L << LAMBDA_PREFIX) | (1L << COMPLIMENT) | (1L << NOT) | (1L << MULTIPLICATION) | (1L << COLON) | (1L << STOP) | (1L << RETURN) | (1L << IF) | (1L << BOOL) | (1L << ID) | (1L << STRING) | (1L << CHAR) | (1L << HEX_LONG) | (1L << LONG) | (1L << DOUBLE) | (1L << INTEGER))) != 0)) {
				{
				setState(415);
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
		enterRule(_localctx, 48, RULE_arg);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(418);
			match(ID);
			setState(421);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(419);
				match(COLON);
				setState(420);
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
		enterRule(_localctx, 50, RULE_attribute);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(423);
			match(AS_ATTR);
			setState(424);
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
		public TypeContext returnType;
		public TerminalNode METHOD() { return getToken(lclangParser.METHOD, 0); }
		public TerminalNode ID() { return getToken(lclangParser.ID, 0); }
		public TerminalNode OPEN() { return getToken(lclangParser.OPEN, 0); }
		public TerminalNode CLOSE() { return getToken(lclangParser.CLOSE, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(lclangParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
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
		enterRule(_localctx, 52, RULE_method);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(429);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AS_ATTR) {
				{
				{
				setState(426);
				attribute();
				}
				}
				setState(431);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(432);
			match(METHOD);
			setState(433);
			match(ID);
			setState(434);
			match(OPEN);
			setState(440);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(435);
					arg();
					setState(436);
					match(COMMA);
					}
					} 
				}
				setState(442);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
			}
			setState(444);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(443);
				arg();
				}
			}

			setState(446);
			match(CLOSE);
			setState(449);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(447);
				match(COLON);
				setState(448);
				((MethodContext)_localctx).returnType = type();
				}
			}

			setState(454);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPEN_BRACE:
				{
				setState(451);
				block();
				}
				break;
			case ASSIGN:
				{
				setState(452);
				match(ASSIGN);
				setState(453);
				expression(0);
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

	public static class UseContext extends ParserRuleContext {
		public Token name;
		public Token alias;
		public Token fromPackage;
		public Token fromFile;
		public TerminalNode USE() { return getToken(lclangParser.USE, 0); }
		public TerminalNode FROM() { return getToken(lclangParser.FROM, 0); }
		public List<TerminalNode> ID() { return getTokens(lclangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(lclangParser.ID, i);
		}
		public TerminalNode AS() { return getToken(lclangParser.AS, 0); }
		public TerminalNode GLOBAL() { return getToken(lclangParser.GLOBAL, 0); }
		public TerminalNode STRING() { return getToken(lclangParser.STRING, 0); }
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
		enterRule(_localctx, 54, RULE_use);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(456);
			match(USE);
			setState(458);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==GLOBAL) {
				{
				setState(457);
				match(GLOBAL);
				}
			}

			setState(460);
			((UseContext)_localctx).name = match(ID);
			{
			setState(461);
			match(AS);
			setState(462);
			((UseContext)_localctx).alias = match(ID);
			}
			setState(464);
			match(FROM);
			setState(467);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(465);
				((UseContext)_localctx).fromPackage = match(ID);
				}
				break;
			case STRING:
				{
				setState(466);
				((UseContext)_localctx).fromFile = match(STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(470);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMICOLON) {
				{
				setState(469);
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
		enterRule(_localctx, 56, RULE_global);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(472);
			match(GLOBAL);
			setState(473);
			match(ID);
			setState(474);
			match(ASSIGN);
			setState(475);
			value();
			setState(477);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMICOLON) {
				{
				setState(476);
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
			return precpred(_ctx, 31);
		case 1:
			return precpred(_ctx, 30);
		case 2:
			return precpred(_ctx, 29);
		case 3:
			return precpred(_ctx, 28);
		case 4:
			return precpred(_ctx, 27);
		case 5:
			return precpred(_ctx, 26);
		case 6:
			return precpred(_ctx, 25);
		case 7:
			return precpred(_ctx, 24);
		case 8:
			return precpred(_ctx, 23);
		case 9:
			return precpred(_ctx, 22);
		case 10:
			return precpred(_ctx, 21);
		case 11:
			return precpred(_ctx, 20);
		case 12:
			return precpred(_ctx, 19);
		case 13:
			return precpred(_ctx, 18);
		case 14:
			return precpred(_ctx, 17);
		case 15:
			return precpred(_ctx, 16);
		case 16:
			return precpred(_ctx, 15);
		case 17:
			return precpred(_ctx, 14);
		case 18:
			return precpred(_ctx, 13);
		case 19:
			return precpred(_ctx, 12);
		case 20:
			return precpred(_ctx, 11);
		case 21:
			return precpred(_ctx, 10);
		case 22:
			return precpred(_ctx, 9);
		case 23:
			return precpred(_ctx, 8);
		case 24:
			return precpred(_ctx, 7);
		case 25:
			return precpred(_ctx, 35);
		case 26:
			return precpred(_ctx, 34);
		case 27:
			return precpred(_ctx, 33);
		case 28:
			return precpred(_ctx, 32);
		case 29:
			return precpred(_ctx, 6);
		case 30:
			return precpred(_ctx, 5);
		case 31:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3A\u01e2\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\7\2>\n\2\f\2\16"+
		"\2A\13\2\3\2\7\2D\n\2\f\2\16\2G\13\2\3\2\3\2\3\2\3\2\7\2M\n\2\f\2\16\2"+
		"P\13\2\3\2\3\2\3\3\5\3U\n\3\3\3\3\3\5\3Y\n\3\3\4\3\4\3\4\3\4\7\4_\n\4"+
		"\f\4\16\4b\13\4\3\4\5\4e\n\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\5\5n\n\5\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\5\6v\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\5\6\u00cb\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\7\6\u00d9\n\6\f\6\16\6\u00dc\13\6\3\6\5\6\u00df\n\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\7\6\u00e9\n\6\f\6\16\6\u00ec\13\6\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u00f9\n\7\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3"+
		"\n\5\n\u0103\n\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\7\f\u010c\n\f\f\f\16\f"+
		"\u010f\13\f\3\f\5\f\u0112\n\f\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17"+
		"\3\17\3\17\7\17\u011f\n\17\f\17\16\17\u0122\13\17\3\17\5\17\u0125\n\17"+
		"\3\17\5\17\u0128\n\17\3\17\3\17\5\17\u012c\n\17\3\17\3\17\3\20\3\20\7"+
		"\20\u0132\n\20\f\20\16\20\u0135\13\20\3\20\3\20\3\21\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\5\23\u0148\n\23"+
		"\5\23\u014a\n\23\3\24\3\24\3\24\3\24\5\24\u0150\n\24\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\5\25\u0158\n\25\3\26\3\26\7\26\u015c\n\26\f\26\16\26\u015f"+
		"\13\26\3\26\3\26\3\27\3\27\3\27\3\27\7\27\u0167\n\27\f\27\16\27\u016a"+
		"\13\27\3\27\7\27\u016d\n\27\f\27\16\27\u0170\13\27\3\27\3\27\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\7\30\u017a\n\30\f\30\16\30\u017d\13\30\3\30\5\30"+
		"\u0180\n\30\3\30\5\30\u0183\n\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u018b"+
		"\n\30\5\30\u018d\n\30\3\30\3\30\3\30\7\30\u0192\n\30\f\30\16\30\u0195"+
		"\13\30\3\30\5\30\u0198\n\30\3\31\3\31\3\31\7\31\u019d\n\31\f\31\16\31"+
		"\u01a0\13\31\3\31\5\31\u01a3\n\31\3\32\3\32\3\32\5\32\u01a8\n\32\3\33"+
		"\3\33\3\33\3\34\7\34\u01ae\n\34\f\34\16\34\u01b1\13\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\7\34\u01b9\n\34\f\34\16\34\u01bc\13\34\3\34\5\34\u01bf"+
		"\n\34\3\34\3\34\3\34\5\34\u01c4\n\34\3\34\3\34\3\34\5\34\u01c9\n\34\3"+
		"\35\3\35\5\35\u01cd\n\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\5\35\u01d6"+
		"\n\35\3\35\5\35\u01d9\n\35\3\36\3\36\3\36\3\36\3\36\5\36\u01e0\n\36\3"+
		"\36\2\3\n\37\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64"+
		"\668:\2\3\4\299;@\2\u0223\2?\3\2\2\2\4T\3\2\2\2\6Z\3\2\2\2\bj\3\2\2\2"+
		"\nu\3\2\2\2\f\u00f8\3\2\2\2\16\u00fa\3\2\2\2\20\u00fc\3\2\2\2\22\u0100"+
		"\3\2\2\2\24\u0104\3\2\2\2\26\u0107\3\2\2\2\30\u0115\3\2\2\2\32\u0117\3"+
		"\2\2\2\34\u0119\3\2\2\2\36\u012f\3\2\2\2 \u0138\3\2\2\2\"\u013f\3\2\2"+
		"\2$\u0149\3\2\2\2&\u014b\3\2\2\2(\u0151\3\2\2\2*\u0159\3\2\2\2,\u0162"+
		"\3\2\2\2.\u0173\3\2\2\2\60\u019e\3\2\2\2\62\u01a4\3\2\2\2\64\u01a9\3\2"+
		"\2\2\66\u01af\3\2\2\28\u01ca\3\2\2\2:\u01da\3\2\2\2<>\58\35\2=<\3\2\2"+
		"\2>A\3\2\2\2?=\3\2\2\2?@\3\2\2\2@E\3\2\2\2A?\3\2\2\2BD\5:\36\2CB\3\2\2"+
		"\2DG\3\2\2\2EC\3\2\2\2EF\3\2\2\2FN\3\2\2\2GE\3\2\2\2HM\5$\23\2IM\5\66"+
		"\34\2JM\5,\27\2KM\5.\30\2LH\3\2\2\2LI\3\2\2\2LJ\3\2\2\2LK\3\2\2\2MP\3"+
		"\2\2\2NL\3\2\2\2NO\3\2\2\2OQ\3\2\2\2PN\3\2\2\2QR\7\2\2\3R\3\3\2\2\2SU"+
		"\7\27\2\2TS\3\2\2\2TU\3\2\2\2UX\3\2\2\2VY\5\6\4\2WY\5\b\5\2XV\3\2\2\2"+
		"XW\3\2\2\2Y\5\3\2\2\2Z`\7\5\2\2[\\\5\4\3\2\\]\7\32\2\2]_\3\2\2\2^[\3\2"+
		"\2\2_b\3\2\2\2`^\3\2\2\2`a\3\2\2\2ad\3\2\2\2b`\3\2\2\2ce\5\4\3\2dc\3\2"+
		"\2\2de\3\2\2\2ef\3\2\2\2fg\7\6\2\2gh\7\30\2\2hi\5\4\3\2i\7\3\2\2\2jm\7"+
		":\2\2kl\7\31\2\2ln\5\b\5\2mk\3\2\2\2mn\3\2\2\2n\t\3\2\2\2op\b\6\1\2pq"+
		"\7 \2\2qv\5\n\6\5rs\7!\2\2sv\5\n\6\4tv\5\f\7\2uo\3\2\2\2ur\3\2\2\2ut\3"+
		"\2\2\2v\u00ea\3\2\2\2wx\f!\2\2xy\7\"\2\2y\u00e9\5\n\6\"z{\f \2\2{|\7#"+
		"\2\2|\u00e9\5\n\6!}~\f\37\2\2~\177\7\21\2\2\177\u00e9\5\n\6 \u0080\u0081"+
		"\f\36\2\2\u0081\u0082\7\20\2\2\u0082\u00e9\5\n\6\37\u0083\u0084\f\35\2"+
		"\2\u0084\u0085\7\f\2\2\u0085\u00e9\5\n\6\36\u0086\u0087\f\34\2\2\u0087"+
		"\u0088\7\r\2\2\u0088\u00e9\5\n\6\35\u0089\u008a\f\33\2\2\u008a\u008b\7"+
		"\17\2\2\u008b\u00e9\5\n\6\34\u008c\u008d\f\32\2\2\u008d\u008e\7\16\2\2"+
		"\u008e\u00e9\5\n\6\33\u008f\u0090\f\31\2\2\u0090\u0091\7\34\2\2\u0091"+
		"\u00e9\5\n\6\32\u0092\u0093\f\30\2\2\u0093\u0094\7$\2\2\u0094\u00e9\5"+
		"\n\6\31\u0095\u0096\f\27\2\2\u0096\u0097\7%\2\2\u0097\u00e9\5\n\6\30\u0098"+
		"\u0099\f\26\2\2\u0099\u009a\7\13\2\2\u009a\u00e9\5\n\6\27\u009b\u009c"+
		"\f\25\2\2\u009c\u009d\7\37\2\2\u009d\u00e9\5\n\6\26\u009e\u009f\f\24\2"+
		"\2\u009f\u00a0\7\36\2\2\u00a0\u00e9\5\n\6\25\u00a1\u00a2\f\23\2\2\u00a2"+
		"\u00a3\7\35\2\2\u00a3\u00e9\5\n\6\24\u00a4\u00a5\f\22\2\2\u00a5\u00a6"+
		"\7\24\2\2\u00a6\u00e9\5\n\6\23\u00a7\u00a8\f\21\2\2\u00a8\u00a9\7\25\2"+
		"\2\u00a9\u00e9\5\n\6\22\u00aa\u00ab\f\20\2\2\u00ab\u00ac\7\'\2\2\u00ac"+
		"\u00e9\5\n\6\21\u00ad\u00ae\f\17\2\2\u00ae\u00af\7&\2\2\u00af\u00e9\5"+
		"\n\6\20\u00b0\u00b1\f\16\2\2\u00b1\u00b2\7&\2\2\u00b2\u00b3\7\34\2\2\u00b3"+
		"\u00e9\5\n\6\17\u00b4\u00b5\f\r\2\2\u00b5\u00b6\7&\2\2\u00b6\u00b7\7\34"+
		"\2\2\u00b7\u00e9\5\n\6\16\u00b8\u00b9\f\f\2\2\u00b9\u00ba\7%\2\2\u00ba"+
		"\u00bb\7\34\2\2\u00bb\u00e9\5\n\6\r\u00bc\u00bd\f\13\2\2\u00bd\u00be\7"+
		"$\2\2\u00be\u00bf\7\34\2\2\u00bf\u00e9\5\n\6\f\u00c0\u00c1\f\n\2\2\u00c1"+
		"\u00c2\7\13\2\2\u00c2\u00c3\7\34\2\2\u00c3\u00e9\5\n\6\13\u00c4\u00c5"+
		"\f\t\2\2\u00c5\u00c6\7\26\2\2\u00c6\u00e9\5\n\6\n\u00c7\u00c8\f%\2\2\u00c8"+
		"\u00ca\7\t\2\2\u00c9\u00cb\5\n\6\2\u00ca\u00c9\3\2\2\2\u00ca\u00cb\3\2"+
		"\2\2\u00cb\u00cc\3\2\2\2\u00cc\u00e9\7\n\2\2\u00cd\u00ce\f$\2\2\u00ce"+
		"\u00cf\7\67\2\2\u00cf\u00e9\5\4\3\2\u00d0\u00d1\f#\2\2\u00d1\u00d2\7)"+
		"\2\2\u00d2\u00e9\5\32\16\2\u00d3\u00d4\f\"\2\2\u00d4\u00da\7\5\2\2\u00d5"+
		"\u00d6\5\n\6\2\u00d6\u00d7\7\32\2\2\u00d7\u00d9\3\2\2\2\u00d8\u00d5\3"+
		"\2\2\2\u00d9\u00dc\3\2\2\2\u00da\u00d8\3\2\2\2\u00da\u00db\3\2\2\2\u00db"+
		"\u00de\3\2\2\2\u00dc\u00da\3\2\2\2\u00dd\u00df\5\n\6\2\u00de\u00dd\3\2"+
		"\2\2\u00de\u00df\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00e9\7\6\2\2\u00e1"+
		"\u00e2\f\b\2\2\u00e2\u00e3\7!\2\2\u00e3\u00e9\7!\2\2\u00e4\u00e5\f\7\2"+
		"\2\u00e5\u00e9\7\22\2\2\u00e6\u00e7\f\6\2\2\u00e7\u00e9\7\23\2\2\u00e8"+
		"w\3\2\2\2\u00e8z\3\2\2\2\u00e8}\3\2\2\2\u00e8\u0080\3\2\2\2\u00e8\u0083"+
		"\3\2\2\2\u00e8\u0086\3\2\2\2\u00e8\u0089\3\2\2\2\u00e8\u008c\3\2\2\2\u00e8"+
		"\u008f\3\2\2\2\u00e8\u0092\3\2\2\2\u00e8\u0095\3\2\2\2\u00e8\u0098\3\2"+
		"\2\2\u00e8\u009b\3\2\2\2\u00e8\u009e\3\2\2\2\u00e8\u00a1\3\2\2\2\u00e8"+
		"\u00a4\3\2\2\2\u00e8\u00a7\3\2\2\2\u00e8\u00aa\3\2\2\2\u00e8\u00ad\3\2"+
		"\2\2\u00e8\u00b0\3\2\2\2\u00e8\u00b4\3\2\2\2\u00e8\u00b8\3\2\2\2\u00e8"+
		"\u00bc\3\2\2\2\u00e8\u00c0\3\2\2\2\u00e8\u00c4\3\2\2\2\u00e8\u00c7\3\2"+
		"\2\2\u00e8\u00cd\3\2\2\2\u00e8\u00d0\3\2\2\2\u00e8\u00d3\3\2\2\2\u00e8"+
		"\u00e1\3\2\2\2\u00e8\u00e4\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e9\u00ec\3\2"+
		"\2\2\u00ea\u00e8\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\13\3\2\2\2\u00ec\u00ea"+
		"\3\2\2\2\u00ed\u00f9\5\20\t\2\u00ee\u00f9\5\16\b\2\u00ef\u00f9\5\30\r"+
		"\2\u00f0\u00f9\5 \21\2\u00f1\u00f9\5\22\n\2\u00f2\u00f9\5\"\22\2\u00f3"+
		"\u00f9\5\32\16\2\u00f4\u00f9\5\26\f\2\u00f5\u00f9\5\24\13\2\u00f6\u00f9"+
		"\5\34\17\2\u00f7\u00f9\5\36\20\2\u00f8\u00ed\3\2\2\2\u00f8\u00ee\3\2\2"+
		"\2\u00f8\u00ef\3\2\2\2\u00f8\u00f0\3\2\2\2\u00f8\u00f1\3\2\2\2\u00f8\u00f2"+
		"\3\2\2\2\u00f8\u00f3\3\2\2\2\u00f8\u00f4\3\2\2\2\u00f8\u00f5\3\2\2\2\u00f8"+
		"\u00f6\3\2\2\2\u00f8\u00f7\3\2\2\2\u00f9\r\3\2\2\2\u00fa\u00fb\t\2\2\2"+
		"\u00fb\17\3\2\2\2\u00fc\u00fd\7\5\2\2\u00fd\u00fe\5\n\6\2\u00fe\u00ff"+
		"\7\6\2\2\u00ff\21\3\2\2\2\u0100\u0102\7\63\2\2\u0101\u0103\5\n\6\2\u0102"+
		"\u0101\3\2\2\2\u0102\u0103\3\2\2\2\u0103\23\3\2\2\2\u0104\u0105\7$\2\2"+
		"\u0105\u0106\5\n\6\2\u0106\25\3\2\2\2\u0107\u010d\7\t\2\2\u0108\u0109"+
		"\5\n\6\2\u0109\u010a\7\32\2\2\u010a\u010c\3\2\2\2\u010b\u0108\3\2\2\2"+
		"\u010c\u010f\3\2\2\2\u010d\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u0111"+
		"\3\2\2\2\u010f\u010d\3\2\2\2\u0110\u0112\5\n\6\2\u0111\u0110\3\2\2\2\u0111"+
		"\u0112\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u0114\7\n\2\2\u0114\27\3\2\2"+
		"\2\u0115\u0116\7\62\2\2\u0116\31\3\2\2\2\u0117\u0118\7:\2\2\u0118\33\3"+
		"\2\2\2\u0119\u0127\7\30\2\2\u011a\u0120\7\5\2\2\u011b\u011c\5\62\32\2"+
		"\u011c\u011d\7\32\2\2\u011d\u011f\3\2\2\2\u011e\u011b\3\2\2\2\u011f\u0122"+
		"\3\2\2\2\u0120\u011e\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u0124\3\2\2\2\u0122"+
		"\u0120\3\2\2\2\u0123\u0125\5\62\32\2\u0124\u0123\3\2\2\2\u0124\u0125\3"+
		"\2\2\2\u0125\u0126\3\2\2\2\u0126\u0128\7\6\2\2\u0127\u011a\3\2\2\2\u0127"+
		"\u0128\3\2\2\2\u0128\u012b\3\2\2\2\u0129\u012a\7(\2\2\u012a\u012c\5\4"+
		"\3\2\u012b\u0129\3\2\2\2\u012b\u012c\3\2\2\2\u012c\u012d\3\2\2\2\u012d"+
		"\u012e\5\n\6\2\u012e\35\3\2\2\2\u012f\u0133\7\7\2\2\u0130\u0132\5$\23"+
		"\2\u0131\u0130\3\2\2\2\u0132\u0135\3\2\2\2\u0133\u0131\3\2\2\2\u0133\u0134"+
		"\3\2\2\2\u0134\u0136\3\2\2\2\u0135\u0133\3\2\2\2\u0136\u0137\7\b\2\2\u0137"+
		"\37\3\2\2\2\u0138\u0139\7\66\2\2\u0139\u013a\5\n\6\2\u013a\u013b\7(\2"+
		"\2\u013b\u013c\5\n\6\2\u013c\u013d\78\2\2\u013d\u013e\5\n\6\2\u013e!\3"+
		"\2\2\2\u013f\u0140\7(\2\2\u0140\u0141\5\b\5\2\u0141#\3\2\2\2\u0142\u014a"+
		"\5*\26\2\u0143\u014a\5&\24\2\u0144\u014a\5(\25\2\u0145\u0147\5\n\6\2\u0146"+
		"\u0148\7\33\2\2\u0147\u0146\3\2\2\2\u0147\u0148\3\2\2\2\u0148\u014a\3"+
		"\2\2\2\u0149\u0142\3\2\2\2\u0149\u0143\3\2\2\2\u0149\u0144\3\2\2\2\u0149"+
		"\u0145\3\2\2\2\u014a%\3\2\2\2\u014b\u014c\7\64\2\2\u014c\u014f\5\n\6\2"+
		"\u014d\u014e\7(\2\2\u014e\u0150\5$\23\2\u014f\u014d\3\2\2\2\u014f\u0150"+
		"\3\2\2\2\u0150\'\3\2\2\2\u0151\u0152\7\66\2\2\u0152\u0153\5\n\6\2\u0153"+
		"\u0154\7(\2\2\u0154\u0157\5$\23\2\u0155\u0156\78\2\2\u0156\u0158\5$\23"+
		"\2\u0157\u0155\3\2\2\2\u0157\u0158\3\2\2\2\u0158)\3\2\2\2\u0159\u015d"+
		"\7\7\2\2\u015a\u015c\5$\23\2\u015b\u015a\3\2\2\2\u015c\u015f\3\2\2\2\u015d"+
		"\u015b\3\2\2\2\u015d\u015e\3\2\2\2\u015e\u0160\3\2\2\2\u015f\u015d\3\2"+
		"\2\2\u0160\u0161\7\b\2\2\u0161+\3\2\2\2\u0162\u0163\7\61\2\2\u0163\u0164"+
		"\5\4\3\2\u0164\u0168\7\7\2\2\u0165\u0167\5:\36\2\u0166\u0165\3\2\2\2\u0167"+
		"\u016a\3\2\2\2\u0168\u0166\3\2\2\2\u0168\u0169\3\2\2\2\u0169\u016e\3\2"+
		"\2\2\u016a\u0168\3\2\2\2\u016b\u016d\5.\30\2\u016c\u016b\3\2\2\2\u016d"+
		"\u0170\3\2\2\2\u016e\u016c\3\2\2\2\u016e\u016f\3\2\2\2\u016f\u0171\3\2"+
		"\2\2\u0170\u016e\3\2\2\2\u0171\u0172\7\b\2\2\u0172-\3\2\2\2\u0173\u0174"+
		"\7.\2\2\u0174\u0182\7:\2\2\u0175\u017b\7\5\2\2\u0176\u0177\5\62\32\2\u0177"+
		"\u0178\7\32\2\2\u0178\u017a\3\2\2\2\u0179\u0176\3\2\2\2\u017a\u017d\3"+
		"\2\2\2\u017b\u0179\3\2\2\2\u017b\u017c\3\2\2\2\u017c\u017f\3\2\2\2\u017d"+
		"\u017b\3\2\2\2\u017e\u0180\5\62\32\2\u017f\u017e\3\2\2\2\u017f\u0180\3"+
		"\2\2\2\u0180\u0181\3\2\2\2\u0181\u0183\7\6\2\2\u0182\u0175\3\2\2\2\u0182"+
		"\u0183\3\2\2\2\u0183\u018c\3\2\2\2\u0184\u0185\7\60\2\2\u0185\u018a\5"+
		"\b\5\2\u0186\u0187\7\5\2\2\u0187\u0188\5\60\31\2\u0188\u0189\7\6\2\2\u0189"+
		"\u018b\3\2\2\2\u018a\u0186\3\2\2\2\u018a\u018b\3\2\2\2\u018b\u018d\3\2"+
		"\2\2\u018c\u0184\3\2\2\2\u018c\u018d\3\2\2\2\u018d\u0197\3\2\2\2\u018e"+
		"\u0193\7\7\2\2\u018f\u0192\5\66\34\2\u0190\u0192\5$\23\2\u0191\u018f\3"+
		"\2\2\2\u0191\u0190\3\2\2\2\u0192\u0195\3\2\2\2\u0193\u0191\3\2\2\2\u0193"+
		"\u0194\3\2\2\2\u0194\u0196\3\2\2\2\u0195\u0193\3\2\2\2\u0196\u0198\7\b"+
		"\2\2\u0197\u018e\3\2\2\2\u0197\u0198\3\2\2\2\u0198/\3\2\2\2\u0199\u019a"+
		"\5\n\6\2\u019a\u019b\7\32\2\2\u019b\u019d\3\2\2\2\u019c\u0199\3\2\2\2"+
		"\u019d\u01a0\3\2\2\2\u019e\u019c\3\2\2\2\u019e\u019f\3\2\2\2\u019f\u01a2"+
		"\3\2\2\2\u01a0\u019e\3\2\2\2\u01a1\u01a3\5\n\6\2\u01a2\u01a1\3\2\2\2\u01a2"+
		"\u01a3\3\2\2\2\u01a3\61\3\2\2\2\u01a4\u01a7\7:\2\2\u01a5\u01a6\7(\2\2"+
		"\u01a6\u01a8\5\4\3\2\u01a7\u01a5\3\2\2\2\u01a7\u01a8\3\2\2\2\u01a8\63"+
		"\3\2\2\2\u01a9\u01aa\7*\2\2\u01aa\u01ab\7:\2\2\u01ab\65\3\2\2\2\u01ac"+
		"\u01ae\5\64\33\2\u01ad\u01ac\3\2\2\2\u01ae\u01b1\3\2\2\2\u01af\u01ad\3"+
		"\2\2\2\u01af\u01b0\3\2\2\2\u01b0\u01b2\3\2\2\2\u01b1\u01af\3\2\2\2\u01b2"+
		"\u01b3\7,\2\2\u01b3\u01b4\7:\2\2\u01b4\u01ba\7\5\2\2\u01b5\u01b6\5\62"+
		"\32\2\u01b6\u01b7\7\32\2\2\u01b7\u01b9\3\2\2\2\u01b8\u01b5\3\2\2\2\u01b9"+
		"\u01bc\3\2\2\2\u01ba\u01b8\3\2\2\2\u01ba\u01bb\3\2\2\2\u01bb\u01be\3\2"+
		"\2\2\u01bc\u01ba\3\2\2\2\u01bd\u01bf\5\62\32\2\u01be\u01bd\3\2\2\2\u01be"+
		"\u01bf\3\2\2\2\u01bf\u01c0\3\2\2\2\u01c0\u01c3\7\6\2\2\u01c1\u01c2\7("+
		"\2\2\u01c2\u01c4\5\4\3\2\u01c3\u01c1\3\2\2\2\u01c3\u01c4\3\2\2\2\u01c4"+
		"\u01c8\3\2\2\2\u01c5\u01c9\5*\26\2\u01c6\u01c7\7\34\2\2\u01c7\u01c9\5"+
		"\n\6\2\u01c8\u01c5\3\2\2\2\u01c8\u01c6\3\2\2\2\u01c9\67\3\2\2\2\u01ca"+
		"\u01cc\7-\2\2\u01cb\u01cd\7+\2\2\u01cc\u01cb\3\2\2\2\u01cc\u01cd\3\2\2"+
		"\2\u01cd\u01ce\3\2\2\2\u01ce\u01cf\7:\2\2\u01cf\u01d0\7\65\2\2\u01d0\u01d1"+
		"\7:\2\2\u01d1\u01d2\3\2\2\2\u01d2\u01d5\7/\2\2\u01d3\u01d6\7:\2\2\u01d4"+
		"\u01d6\7;\2\2\u01d5\u01d3\3\2\2\2\u01d5\u01d4\3\2\2\2\u01d6\u01d8\3\2"+
		"\2\2\u01d7\u01d9\7\33\2\2\u01d8\u01d7\3\2\2\2\u01d8\u01d9\3\2\2\2\u01d9"+
		"9\3\2\2\2\u01da\u01db\7+\2\2\u01db\u01dc\7:\2\2\u01dc\u01dd\7\34\2\2\u01dd"+
		"\u01df\5\16\b\2\u01de\u01e0\7\33\2\2\u01df\u01de\3\2\2\2\u01df\u01e0\3"+
		"\2\2\2\u01e0;\3\2\2\2\65?ELNTX`dmu\u00ca\u00da\u00de\u00e8\u00ea\u00f8"+
		"\u0102\u010d\u0111\u0120\u0124\u0127\u012b\u0133\u0147\u0149\u014f\u0157"+
		"\u015d\u0168\u016e\u017b\u017f\u0182\u018a\u018c\u0191\u0193\u0197\u019e"+
		"\u01a2\u01a7\u01af\u01ba\u01be\u01c3\u01c8\u01cc\u01d5\u01d8\u01df";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}