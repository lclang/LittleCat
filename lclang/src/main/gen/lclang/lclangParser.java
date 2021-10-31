// Generated from C:/IdeaProjects/LittleCat/lclang/src/main/java/lclang\lclang.g4 by ANTLR 4.9.1
package lclang;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

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
		NULLABLE_OR=18, NULLABLE=19, LAMBDA_PREFIX=20, TYPE_PREFIX=21, COMMA=22, 
		SEMICOLON=23, ASSIGN=24, OR=25, AND=26, NOT=27, LESS=28, LARGER=29, MULTIPLICATION=30, 
		DIVISION=31, ADD=32, MINUS=33, COLON=34, DOT=35, AS_ATTR=36, GLOBAL=37, 
		METHOD=38, USE=39, CLASS=40, FROM=41, EXTENDS=42, COMPONENT=43, STOP=44, 
		RETURN=45, WHILE=46, IF=47, IS=48, ELSE=49, NULL=50, BOOL=51, ID=52, STRING=53, 
		CHAR=54, HEX_LONG=55, LONG=56, DOUBLE=57, INTEGER=58, WS=59;
	public static final int
		RULE_file = 0, RULE_type = 1, RULE_methodType = 2, RULE_namedType = 3, 
		RULE_expression = 4, RULE_primitive = 5, RULE_value = 6, RULE_parentnesesExpr = 7, 
		RULE_returnExpr = 8, RULE_typeGet = 9, RULE_array = 10, RULE_stop = 11, 
		RULE_variable = 12, RULE_lambda = 13, RULE_container = 14, RULE_ifExpr = 15, 
		RULE_newClass = 16, RULE_stmt = 17, RULE_whileStmt = 18, RULE_ifStmt = 19, 
		RULE_block = 20, RULE_component = 21, RULE_classExpr = 22, RULE_arg = 23, 
		RULE_attribute = 24, RULE_method = 25, RULE_use = 26, RULE_global = 27;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "type", "methodType", "namedType", "expression", "primitive", 
			"value", "parentnesesExpr", "returnExpr", "typeGet", "array", "stop", 
			"variable", "lambda", "container", "ifExpr", "newClass", "stmt", "whileStmt", 
			"ifStmt", "block", "component", "classExpr", "arg", "attribute", "method", 
			"use", "global"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'('", "')'", "'{'", "'}'", "'['", "']'", "'**'", "'=='", 
			"'!='", "'&&'", "'||'", "'<='", "'>='", "'++'", "'--'", "'?:'", "'?'", 
			"'->'", "'\\'", "','", "';'", "'='", "'|'", "'&'", "'!'", "'<'", "'>'", 
			"'*'", "'/'", "'+'", "'-'", "':'", "'.'", "'@'", "'global'", "'method'", 
			"'use'", "'class'", "'from'", "'extends'", "'component'", "'stop'", "'return'", 
			"'while'", "'if'", "'is'", "'else'", "'null'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "COMMENT", "LINE_COMMENT", "OPEN", "CLOSE", "OPEN_BRACE", "CLOSE_BRACE", 
			"OPEN_BRACKET", "CLOSE_BRACKET", "POW", "EQUALS", "NOT_EQUALS", "AND_BOOL", 
			"OR_BOOL", "LESS_EQUALS", "LARGER_EQUALS", "UNARY_ADD", "UNARY_MINUS", 
			"NULLABLE_OR", "NULLABLE", "LAMBDA_PREFIX", "TYPE_PREFIX", "COMMA", "SEMICOLON", 
			"ASSIGN", "OR", "AND", "NOT", "LESS", "LARGER", "MULTIPLICATION", "DIVISION", 
			"ADD", "MINUS", "COLON", "DOT", "AS_ATTR", "GLOBAL", "METHOD", "USE", 
			"CLASS", "FROM", "EXTENDS", "COMPONENT", "STOP", "RETURN", "WHILE", "IF", 
			"IS", "ELSE", "NULL", "BOOL", "ID", "STRING", "CHAR", "HEX_LONG", "LONG", 
			"DOUBLE", "INTEGER", "WS"
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
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==USE) {
				{
				{
				setState(56);
				use();
				}
				}
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==GLOBAL) {
				{
				{
				setState(62);
				global();
				}
				}
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPEN) | (1L << OPEN_BRACE) | (1L << OPEN_BRACKET) | (1L << LAMBDA_PREFIX) | (1L << NOT) | (1L << MULTIPLICATION) | (1L << COLON) | (1L << AS_ATTR) | (1L << METHOD) | (1L << CLASS) | (1L << COMPONENT) | (1L << STOP) | (1L << RETURN) | (1L << WHILE) | (1L << IF) | (1L << NULL) | (1L << BOOL) | (1L << ID) | (1L << STRING) | (1L << CHAR) | (1L << HEX_LONG) | (1L << LONG) | (1L << DOUBLE) | (1L << INTEGER))) != 0)) {
				{
				setState(72);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case OPEN:
				case OPEN_BRACE:
				case OPEN_BRACKET:
				case LAMBDA_PREFIX:
				case NOT:
				case MULTIPLICATION:
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
					setState(68);
					stmt();
					}
					break;
				case AS_ATTR:
				case METHOD:
					{
					setState(69);
					method();
					}
					break;
				case COMPONENT:
					{
					setState(70);
					component();
					}
					break;
				case CLASS:
					{
					setState(71);
					classExpr();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(76);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(77);
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
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NULLABLE) {
				{
				setState(79);
				((TypeContext)_localctx).nullable = match(NULLABLE);
				}
			}

			setState(84);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPEN:
				{
				setState(82);
				methodType();
				}
				break;
			case ID:
				{
				setState(83);
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
			setState(86);
			match(OPEN);
			setState(92);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(87);
					type();
					setState(88);
					match(COMMA);
					}
					} 
				}
				setState(94);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPEN) | (1L << NULLABLE) | (1L << ID))) != 0)) {
				{
				setState(95);
				type();
				}
			}

			setState(98);
			match(CLOSE);
			setState(99);
			match(LAMBDA_PREFIX);
			setState(100);
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
			setState(102);
			match(ID);
			setState(105);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(103);
				match(TYPE_PREFIX);
				setState(104);
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
		public Token assign;
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
		public List<TerminalNode> NOT() { return getTokens(lclangParser.NOT); }
		public TerminalNode NOT(int i) {
			return getToken(lclangParser.NOT, i);
		}
		public PrimitiveContext primitive() {
			return getRuleContext(PrimitiveContext.class,0);
		}
		public TerminalNode OR_BOOL() { return getToken(lclangParser.OR_BOOL, 0); }
		public TerminalNode AND_BOOL() { return getToken(lclangParser.AND_BOOL, 0); }
		public TerminalNode EQUALS() { return getToken(lclangParser.EQUALS, 0); }
		public TerminalNode NOT_EQUALS() { return getToken(lclangParser.NOT_EQUALS, 0); }
		public TerminalNode LESS() { return getToken(lclangParser.LESS, 0); }
		public TerminalNode LARGER() { return getToken(lclangParser.LARGER, 0); }
		public TerminalNode LARGER_EQUALS() { return getToken(lclangParser.LARGER_EQUALS, 0); }
		public TerminalNode LESS_EQUALS() { return getToken(lclangParser.LESS_EQUALS, 0); }
		public TerminalNode MULTIPLICATION() { return getToken(lclangParser.MULTIPLICATION, 0); }
		public TerminalNode DIVISION() { return getToken(lclangParser.DIVISION, 0); }
		public TerminalNode ADD() { return getToken(lclangParser.ADD, 0); }
		public TerminalNode MINUS() { return getToken(lclangParser.MINUS, 0); }
		public TerminalNode POW() { return getToken(lclangParser.POW, 0); }
		public TerminalNode ASSIGN() { return getToken(lclangParser.ASSIGN, 0); }
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
			setState(111);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOT:
				{
				setState(108);
				((ExpressionContext)_localctx).not = match(NOT);
				setState(109);
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
				setState(110);
				primitive();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(212);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(210);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(113);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(114);
						((ExpressionContext)_localctx).or = match(OR_BOOL);
						setState(115);
						expression(26);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(116);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(117);
						((ExpressionContext)_localctx).and = match(AND_BOOL);
						setState(118);
						expression(25);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(119);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(120);
						((ExpressionContext)_localctx).equals = match(EQUALS);
						setState(121);
						expression(24);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(122);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(123);
						((ExpressionContext)_localctx).notEquals = match(NOT_EQUALS);
						setState(124);
						expression(23);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(125);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(126);
						((ExpressionContext)_localctx).less = match(LESS);
						setState(127);
						expression(22);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(128);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(129);
						((ExpressionContext)_localctx).larger = match(LARGER);
						setState(130);
						expression(21);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(131);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(132);
						((ExpressionContext)_localctx).largerEquals = match(LARGER_EQUALS);
						setState(133);
						expression(20);
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(134);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(135);
						((ExpressionContext)_localctx).lessEquals = match(LESS_EQUALS);
						setState(136);
						expression(19);
						}
						break;
					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(137);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(138);
						((ExpressionContext)_localctx).multiplication = match(MULTIPLICATION);
						setState(139);
						expression(18);
						}
						break;
					case 10:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(140);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(141);
						((ExpressionContext)_localctx).div = match(DIVISION);
						setState(142);
						expression(17);
						}
						break;
					case 11:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(143);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(144);
						((ExpressionContext)_localctx).add = match(ADD);
						setState(145);
						expression(16);
						}
						break;
					case 12:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(146);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(147);
						((ExpressionContext)_localctx).minus = match(MINUS);
						setState(148);
						expression(15);
						}
						break;
					case 13:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(149);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(150);
						((ExpressionContext)_localctx).pow = match(POW);
						setState(151);
						expression(14);
						}
						break;
					case 14:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(152);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(153);
						((ExpressionContext)_localctx).assign = match(ASSIGN);
						setState(154);
						expression(13);
						}
						break;
					case 15:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(155);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(156);
						((ExpressionContext)_localctx).add = match(ADD);
						setState(157);
						((ExpressionContext)_localctx).assign = match(ASSIGN);
						setState(158);
						expression(12);
						}
						break;
					case 16:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(159);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(160);
						((ExpressionContext)_localctx).minus = match(ADD);
						setState(161);
						((ExpressionContext)_localctx).assign = match(ASSIGN);
						setState(162);
						expression(11);
						}
						break;
					case 17:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(163);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(164);
						((ExpressionContext)_localctx).div = match(DIVISION);
						setState(165);
						((ExpressionContext)_localctx).assign = match(ASSIGN);
						setState(166);
						expression(10);
						}
						break;
					case 18:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(167);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(168);
						((ExpressionContext)_localctx).multiplication = match(MULTIPLICATION);
						setState(169);
						((ExpressionContext)_localctx).assign = match(ASSIGN);
						setState(170);
						expression(9);
						}
						break;
					case 19:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(171);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(172);
						((ExpressionContext)_localctx).pow = match(POW);
						setState(173);
						((ExpressionContext)_localctx).assign = match(ASSIGN);
						setState(174);
						expression(8);
						}
						break;
					case 20:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(175);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(176);
						((ExpressionContext)_localctx).nullableOr = match(NULLABLE_OR);
						setState(177);
						expression(7);
						}
						break;
					case 21:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(178);
						if (!(precpred(_ctx, 29))) throw new FailedPredicateException(this, "precpred(_ctx, 29)");
						setState(179);
						((ExpressionContext)_localctx).arrayAccess = match(OPEN_BRACKET);
						setState(180);
						expression(0);
						setState(181);
						match(CLOSE_BRACKET);
						}
						break;
					case 22:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(183);
						if (!(precpred(_ctx, 28))) throw new FailedPredicateException(this, "precpred(_ctx, 28)");
						setState(184);
						((ExpressionContext)_localctx).is = match(IS);
						setState(185);
						type();
						}
						break;
					case 23:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(186);
						if (!(precpred(_ctx, 27))) throw new FailedPredicateException(this, "precpred(_ctx, 27)");
						setState(187);
						((ExpressionContext)_localctx).access = match(DOT);
						setState(188);
						variable();
						}
						break;
					case 24:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(189);
						if (!(precpred(_ctx, 26))) throw new FailedPredicateException(this, "precpred(_ctx, 26)");
						setState(190);
						((ExpressionContext)_localctx).call = match(OPEN);
						setState(196);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(191);
								expression(0);
								setState(192);
								match(COMMA);
								}
								} 
							}
							setState(198);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
						}
						setState(200);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPEN) | (1L << OPEN_BRACE) | (1L << OPEN_BRACKET) | (1L << LAMBDA_PREFIX) | (1L << NOT) | (1L << MULTIPLICATION) | (1L << COLON) | (1L << STOP) | (1L << RETURN) | (1L << IF) | (1L << NULL) | (1L << BOOL) | (1L << ID) | (1L << STRING) | (1L << CHAR) | (1L << HEX_LONG) | (1L << LONG) | (1L << DOUBLE) | (1L << INTEGER))) != 0)) {
							{
							setState(199);
							expression(0);
							}
						}

						setState(202);
						match(CLOSE);
						}
						break;
					case 25:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(203);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(204);
						((ExpressionContext)_localctx).throwNull = match(NOT);
						setState(205);
						match(NOT);
						}
						break;
					case 26:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(206);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(207);
						((ExpressionContext)_localctx).unaryPlus = match(UNARY_ADD);
						}
						break;
					case 27:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(208);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(209);
						((ExpressionContext)_localctx).unaryMinus = match(UNARY_MINUS);
						}
						break;
					}
					} 
				}
				setState(214);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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
			setState(226);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPEN:
				{
				setState(215);
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
				setState(216);
				value();
				}
				break;
			case STOP:
				{
				setState(217);
				stop();
				}
				break;
			case IF:
				{
				setState(218);
				ifExpr();
				}
				break;
			case RETURN:
				{
				setState(219);
				returnExpr();
				}
				break;
			case COLON:
				{
				setState(220);
				newClass();
				}
				break;
			case ID:
				{
				setState(221);
				variable();
				}
				break;
			case OPEN_BRACKET:
				{
				setState(222);
				array();
				}
				break;
			case MULTIPLICATION:
				{
				setState(223);
				typeGet();
				}
				break;
			case LAMBDA_PREFIX:
				{
				setState(224);
				lambda();
				}
				break;
			case OPEN_BRACE:
				{
				setState(225);
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
			setState(228);
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
			setState(230);
			match(OPEN);
			setState(231);
			expression(0);
			setState(232);
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
			setState(234);
			match(RETURN);
			setState(236);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(235);
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
			setState(238);
			match(MULTIPLICATION);
			setState(239);
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
			setState(241);
			match(OPEN_BRACKET);
			setState(247);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(242);
					expression(0);
					setState(243);
					match(COMMA);
					}
					} 
				}
				setState(249);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			setState(251);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPEN) | (1L << OPEN_BRACE) | (1L << OPEN_BRACKET) | (1L << LAMBDA_PREFIX) | (1L << NOT) | (1L << MULTIPLICATION) | (1L << COLON) | (1L << STOP) | (1L << RETURN) | (1L << IF) | (1L << NULL) | (1L << BOOL) | (1L << ID) | (1L << STRING) | (1L << CHAR) | (1L << HEX_LONG) | (1L << LONG) | (1L << DOUBLE) | (1L << INTEGER))) != 0)) {
				{
				setState(250);
				expression(0);
				}
			}

			setState(253);
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
			setState(255);
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
			setState(257);
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
			setState(259);
			match(LAMBDA_PREFIX);
			setState(273);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(260);
				match(OPEN);
				setState(266);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(261);
						arg();
						setState(262);
						match(COMMA);
						}
						} 
					}
					setState(268);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
				}
				setState(270);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(269);
					arg();
					}
				}

				setState(272);
				match(CLOSE);
				}
				break;
			}
			setState(277);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(275);
				match(COLON);
				setState(276);
				type();
				}
				break;
			}
			setState(279);
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
			setState(281);
			match(OPEN_BRACE);
			setState(285);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPEN) | (1L << OPEN_BRACE) | (1L << OPEN_BRACKET) | (1L << LAMBDA_PREFIX) | (1L << NOT) | (1L << MULTIPLICATION) | (1L << COLON) | (1L << STOP) | (1L << RETURN) | (1L << WHILE) | (1L << IF) | (1L << NULL) | (1L << BOOL) | (1L << ID) | (1L << STRING) | (1L << CHAR) | (1L << HEX_LONG) | (1L << LONG) | (1L << DOUBLE) | (1L << INTEGER))) != 0)) {
				{
				{
				setState(282);
				stmt();
				}
				}
				setState(287);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(288);
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
			setState(290);
			match(IF);
			setState(291);
			((IfExprContext)_localctx).condition = expression(0);
			setState(292);
			match(COLON);
			setState(293);
			((IfExprContext)_localctx).ifT = expression(0);
			setState(294);
			match(ELSE);
			setState(295);
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
			setState(297);
			match(COLON);
			setState(298);
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
			setState(307);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(300);
				block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(301);
				whileStmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(302);
				ifStmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(303);
				expression(0);
				setState(305);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(304);
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
			setState(309);
			match(WHILE);
			setState(310);
			((WhileStmtContext)_localctx).condition = expression(0);
			setState(313);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				{
				setState(311);
				match(COLON);
				setState(312);
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
			setState(315);
			match(IF);
			setState(316);
			((IfStmtContext)_localctx).condition = expression(0);
			setState(317);
			match(COLON);
			setState(318);
			((IfStmtContext)_localctx).ifT = stmt();
			setState(321);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				setState(319);
				match(ELSE);
				setState(320);
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
			setState(323);
			match(OPEN_BRACE);
			setState(327);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPEN) | (1L << OPEN_BRACE) | (1L << OPEN_BRACKET) | (1L << LAMBDA_PREFIX) | (1L << NOT) | (1L << MULTIPLICATION) | (1L << COLON) | (1L << STOP) | (1L << RETURN) | (1L << WHILE) | (1L << IF) | (1L << NULL) | (1L << BOOL) | (1L << ID) | (1L << STRING) | (1L << CHAR) | (1L << HEX_LONG) | (1L << LONG) | (1L << DOUBLE) | (1L << INTEGER))) != 0)) {
				{
				{
				setState(324);
				stmt();
				}
				}
				setState(329);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(330);
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
			setState(332);
			match(COMPONENT);
			setState(333);
			type();
			setState(334);
			match(OPEN_BRACE);
			setState(338);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==GLOBAL) {
				{
				{
				setState(335);
				global();
				}
				}
				setState(340);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(344);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CLASS) {
				{
				{
				setState(341);
				classExpr();
				}
				}
				setState(346);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(347);
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
		public Token classExtends;
		public TerminalNode CLASS() { return getToken(lclangParser.CLASS, 0); }
		public List<TerminalNode> ID() { return getTokens(lclangParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(lclangParser.ID, i);
		}
		public TerminalNode OPEN() { return getToken(lclangParser.OPEN, 0); }
		public TerminalNode CLOSE() { return getToken(lclangParser.CLOSE, 0); }
		public TerminalNode EXTENDS() { return getToken(lclangParser.EXTENDS, 0); }
		public TerminalNode OPEN_BRACE() { return getToken(lclangParser.OPEN_BRACE, 0); }
		public TerminalNode CLOSE_BRACE() { return getToken(lclangParser.CLOSE_BRACE, 0); }
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
			setState(349);
			match(CLASS);
			setState(350);
			((ClassExprContext)_localctx).name = match(ID);
			setState(364);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(351);
				match(OPEN);
				setState(357);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(352);
						arg();
						setState(353);
						match(COMMA);
						}
						} 
					}
					setState(359);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
				}
				setState(361);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(360);
					arg();
					}
				}

				setState(363);
				match(CLOSE);
				}
				break;
			}
			setState(368);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(366);
				match(EXTENDS);
				setState(367);
				((ClassExprContext)_localctx).classExtends = match(ID);
				}
			}

			setState(379);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				{
				setState(370);
				match(OPEN_BRACE);
				setState(375);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPEN) | (1L << OPEN_BRACE) | (1L << OPEN_BRACKET) | (1L << LAMBDA_PREFIX) | (1L << NOT) | (1L << MULTIPLICATION) | (1L << COLON) | (1L << AS_ATTR) | (1L << METHOD) | (1L << STOP) | (1L << RETURN) | (1L << WHILE) | (1L << IF) | (1L << NULL) | (1L << BOOL) | (1L << ID) | (1L << STRING) | (1L << CHAR) | (1L << HEX_LONG) | (1L << LONG) | (1L << DOUBLE) | (1L << INTEGER))) != 0)) {
					{
					setState(373);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case AS_ATTR:
					case METHOD:
						{
						setState(371);
						method();
						}
						break;
					case OPEN:
					case OPEN_BRACE:
					case OPEN_BRACKET:
					case LAMBDA_PREFIX:
					case NOT:
					case MULTIPLICATION:
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
						setState(372);
						stmt();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(377);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(378);
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
		enterRule(_localctx, 46, RULE_arg);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(381);
			match(ID);
			setState(384);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(382);
				match(COLON);
				setState(383);
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
		enterRule(_localctx, 48, RULE_attribute);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(386);
			match(AS_ATTR);
			setState(387);
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
		enterRule(_localctx, 50, RULE_method);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(392);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AS_ATTR) {
				{
				{
				setState(389);
				attribute();
				}
				}
				setState(394);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(395);
			match(METHOD);
			setState(396);
			match(ID);
			setState(397);
			match(OPEN);
			setState(403);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(398);
					arg();
					setState(399);
					match(COMMA);
					}
					} 
				}
				setState(405);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			}
			setState(407);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(406);
				arg();
				}
			}

			setState(409);
			match(CLOSE);
			setState(412);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(410);
				match(COLON);
				setState(411);
				((MethodContext)_localctx).returnType = type();
				}
			}

			setState(417);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPEN_BRACE:
				{
				setState(414);
				block();
				}
				break;
			case ASSIGN:
				{
				setState(415);
				match(ASSIGN);
				setState(416);
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
		public Token useGlobal;
		public TerminalNode USE() { return getToken(lclangParser.USE, 0); }
		public NamedTypeContext namedType() {
			return getRuleContext(NamedTypeContext.class,0);
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
		enterRule(_localctx, 52, RULE_use);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(419);
			match(USE);
			setState(420);
			((UseContext)_localctx).useGlobal = match(GLOBAL);
			setState(421);
			namedType();
			setState(422);
			match(FROM);
			setState(423);
			match(STRING);
			setState(425);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMICOLON) {
				{
				setState(424);
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
		enterRule(_localctx, 54, RULE_global);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(427);
			match(GLOBAL);
			setState(428);
			match(ID);
			setState(429);
			match(ASSIGN);
			setState(430);
			value();
			setState(432);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMICOLON) {
				{
				setState(431);
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
			return precpred(_ctx, 25);
		case 1:
			return precpred(_ctx, 24);
		case 2:
			return precpred(_ctx, 23);
		case 3:
			return precpred(_ctx, 22);
		case 4:
			return precpred(_ctx, 21);
		case 5:
			return precpred(_ctx, 20);
		case 6:
			return precpred(_ctx, 19);
		case 7:
			return precpred(_ctx, 18);
		case 8:
			return precpred(_ctx, 17);
		case 9:
			return precpred(_ctx, 16);
		case 10:
			return precpred(_ctx, 15);
		case 11:
			return precpred(_ctx, 14);
		case 12:
			return precpred(_ctx, 13);
		case 13:
			return precpred(_ctx, 12);
		case 14:
			return precpred(_ctx, 11);
		case 15:
			return precpred(_ctx, 10);
		case 16:
			return precpred(_ctx, 9);
		case 17:
			return precpred(_ctx, 8);
		case 18:
			return precpred(_ctx, 7);
		case 19:
			return precpred(_ctx, 6);
		case 20:
			return precpred(_ctx, 29);
		case 21:
			return precpred(_ctx, 28);
		case 22:
			return precpred(_ctx, 27);
		case 23:
			return precpred(_ctx, 26);
		case 24:
			return precpred(_ctx, 5);
		case 25:
			return precpred(_ctx, 4);
		case 26:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3=\u01b5\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\7\2<\n\2\f\2\16\2?\13\2\3"+
		"\2\7\2B\n\2\f\2\16\2E\13\2\3\2\3\2\3\2\3\2\7\2K\n\2\f\2\16\2N\13\2\3\2"+
		"\3\2\3\3\5\3S\n\3\3\3\3\3\5\3W\n\3\3\4\3\4\3\4\3\4\7\4]\n\4\f\4\16\4`"+
		"\13\4\3\4\5\4c\n\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\5\5l\n\5\3\6\3\6\3\6\3"+
		"\6\5\6r\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6\u00c5\n\6"+
		"\f\6\16\6\u00c8\13\6\3\6\5\6\u00cb\n\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\7\6\u00d5\n\6\f\6\16\6\u00d8\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\5\7\u00e5\n\7\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\5\n\u00ef\n\n\3"+
		"\13\3\13\3\13\3\f\3\f\3\f\3\f\7\f\u00f8\n\f\f\f\16\f\u00fb\13\f\3\f\5"+
		"\f\u00fe\n\f\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\17\3\17\7\17\u010b"+
		"\n\17\f\17\16\17\u010e\13\17\3\17\5\17\u0111\n\17\3\17\5\17\u0114\n\17"+
		"\3\17\3\17\5\17\u0118\n\17\3\17\3\17\3\20\3\20\7\20\u011e\n\20\f\20\16"+
		"\20\u0121\13\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22"+
		"\3\22\3\23\3\23\3\23\3\23\3\23\5\23\u0134\n\23\5\23\u0136\n\23\3\24\3"+
		"\24\3\24\3\24\5\24\u013c\n\24\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u0144"+
		"\n\25\3\26\3\26\7\26\u0148\n\26\f\26\16\26\u014b\13\26\3\26\3\26\3\27"+
		"\3\27\3\27\3\27\7\27\u0153\n\27\f\27\16\27\u0156\13\27\3\27\7\27\u0159"+
		"\n\27\f\27\16\27\u015c\13\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\7"+
		"\30\u0166\n\30\f\30\16\30\u0169\13\30\3\30\5\30\u016c\n\30\3\30\5\30\u016f"+
		"\n\30\3\30\3\30\5\30\u0173\n\30\3\30\3\30\3\30\7\30\u0178\n\30\f\30\16"+
		"\30\u017b\13\30\3\30\5\30\u017e\n\30\3\31\3\31\3\31\5\31\u0183\n\31\3"+
		"\32\3\32\3\32\3\33\7\33\u0189\n\33\f\33\16\33\u018c\13\33\3\33\3\33\3"+
		"\33\3\33\3\33\3\33\7\33\u0194\n\33\f\33\16\33\u0197\13\33\3\33\5\33\u019a"+
		"\n\33\3\33\3\33\3\33\5\33\u019f\n\33\3\33\3\33\3\33\5\33\u01a4\n\33\3"+
		"\34\3\34\3\34\3\34\3\34\3\34\5\34\u01ac\n\34\3\35\3\35\3\35\3\35\3\35"+
		"\5\35\u01b3\n\35\3\35\2\3\n\36\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
		" \"$&(*,.\60\62\64\668\2\3\4\2\64\65\67<\2\u01eb\2=\3\2\2\2\4R\3\2\2\2"+
		"\6X\3\2\2\2\bh\3\2\2\2\nq\3\2\2\2\f\u00e4\3\2\2\2\16\u00e6\3\2\2\2\20"+
		"\u00e8\3\2\2\2\22\u00ec\3\2\2\2\24\u00f0\3\2\2\2\26\u00f3\3\2\2\2\30\u0101"+
		"\3\2\2\2\32\u0103\3\2\2\2\34\u0105\3\2\2\2\36\u011b\3\2\2\2 \u0124\3\2"+
		"\2\2\"\u012b\3\2\2\2$\u0135\3\2\2\2&\u0137\3\2\2\2(\u013d\3\2\2\2*\u0145"+
		"\3\2\2\2,\u014e\3\2\2\2.\u015f\3\2\2\2\60\u017f\3\2\2\2\62\u0184\3\2\2"+
		"\2\64\u018a\3\2\2\2\66\u01a5\3\2\2\28\u01ad\3\2\2\2:<\5\66\34\2;:\3\2"+
		"\2\2<?\3\2\2\2=;\3\2\2\2=>\3\2\2\2>C\3\2\2\2?=\3\2\2\2@B\58\35\2A@\3\2"+
		"\2\2BE\3\2\2\2CA\3\2\2\2CD\3\2\2\2DL\3\2\2\2EC\3\2\2\2FK\5$\23\2GK\5\64"+
		"\33\2HK\5,\27\2IK\5.\30\2JF\3\2\2\2JG\3\2\2\2JH\3\2\2\2JI\3\2\2\2KN\3"+
		"\2\2\2LJ\3\2\2\2LM\3\2\2\2MO\3\2\2\2NL\3\2\2\2OP\7\2\2\3P\3\3\2\2\2QS"+
		"\7\25\2\2RQ\3\2\2\2RS\3\2\2\2SV\3\2\2\2TW\5\6\4\2UW\5\b\5\2VT\3\2\2\2"+
		"VU\3\2\2\2W\5\3\2\2\2X^\7\5\2\2YZ\5\4\3\2Z[\7\30\2\2[]\3\2\2\2\\Y\3\2"+
		"\2\2]`\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_b\3\2\2\2`^\3\2\2\2ac\5\4\3\2ba\3"+
		"\2\2\2bc\3\2\2\2cd\3\2\2\2de\7\6\2\2ef\7\26\2\2fg\5\4\3\2g\7\3\2\2\2h"+
		"k\7\66\2\2ij\7\27\2\2jl\5\b\5\2ki\3\2\2\2kl\3\2\2\2l\t\3\2\2\2mn\b\6\1"+
		"\2no\7\35\2\2or\5\n\6\4pr\5\f\7\2qm\3\2\2\2qp\3\2\2\2r\u00d6\3\2\2\2s"+
		"t\f\33\2\2tu\7\17\2\2u\u00d5\5\n\6\34vw\f\32\2\2wx\7\16\2\2x\u00d5\5\n"+
		"\6\33yz\f\31\2\2z{\7\f\2\2{\u00d5\5\n\6\32|}\f\30\2\2}~\7\r\2\2~\u00d5"+
		"\5\n\6\31\177\u0080\f\27\2\2\u0080\u0081\7\36\2\2\u0081\u00d5\5\n\6\30"+
		"\u0082\u0083\f\26\2\2\u0083\u0084\7\37\2\2\u0084\u00d5\5\n\6\27\u0085"+
		"\u0086\f\25\2\2\u0086\u0087\7\21\2\2\u0087\u00d5\5\n\6\26\u0088\u0089"+
		"\f\24\2\2\u0089\u008a\7\20\2\2\u008a\u00d5\5\n\6\25\u008b\u008c\f\23\2"+
		"\2\u008c\u008d\7 \2\2\u008d\u00d5\5\n\6\24\u008e\u008f\f\22\2\2\u008f"+
		"\u0090\7!\2\2\u0090\u00d5\5\n\6\23\u0091\u0092\f\21\2\2\u0092\u0093\7"+
		"\"\2\2\u0093\u00d5\5\n\6\22\u0094\u0095\f\20\2\2\u0095\u0096\7#\2\2\u0096"+
		"\u00d5\5\n\6\21\u0097\u0098\f\17\2\2\u0098\u0099\7\13\2\2\u0099\u00d5"+
		"\5\n\6\20\u009a\u009b\f\16\2\2\u009b\u009c\7\32\2\2\u009c\u00d5\5\n\6"+
		"\17\u009d\u009e\f\r\2\2\u009e\u009f\7\"\2\2\u009f\u00a0\7\32\2\2\u00a0"+
		"\u00d5\5\n\6\16\u00a1\u00a2\f\f\2\2\u00a2\u00a3\7\"\2\2\u00a3\u00a4\7"+
		"\32\2\2\u00a4\u00d5\5\n\6\r\u00a5\u00a6\f\13\2\2\u00a6\u00a7\7!\2\2\u00a7"+
		"\u00a8\7\32\2\2\u00a8\u00d5\5\n\6\f\u00a9\u00aa\f\n\2\2\u00aa\u00ab\7"+
		" \2\2\u00ab\u00ac\7\32\2\2\u00ac\u00d5\5\n\6\13\u00ad\u00ae\f\t\2\2\u00ae"+
		"\u00af\7\13\2\2\u00af\u00b0\7\32\2\2\u00b0\u00d5\5\n\6\n\u00b1\u00b2\f"+
		"\b\2\2\u00b2\u00b3\7\24\2\2\u00b3\u00d5\5\n\6\t\u00b4\u00b5\f\37\2\2\u00b5"+
		"\u00b6\7\t\2\2\u00b6\u00b7\5\n\6\2\u00b7\u00b8\7\n\2\2\u00b8\u00d5\3\2"+
		"\2\2\u00b9\u00ba\f\36\2\2\u00ba\u00bb\7\62\2\2\u00bb\u00d5\5\4\3\2\u00bc"+
		"\u00bd\f\35\2\2\u00bd\u00be\7%\2\2\u00be\u00d5\5\32\16\2\u00bf\u00c0\f"+
		"\34\2\2\u00c0\u00c6\7\5\2\2\u00c1\u00c2\5\n\6\2\u00c2\u00c3\7\30\2\2\u00c3"+
		"\u00c5\3\2\2\2\u00c4\u00c1\3\2\2\2\u00c5\u00c8\3\2\2\2\u00c6\u00c4\3\2"+
		"\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00ca\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c9"+
		"\u00cb\5\n\6\2\u00ca\u00c9\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00cc\3\2"+
		"\2\2\u00cc\u00d5\7\6\2\2\u00cd\u00ce\f\7\2\2\u00ce\u00cf\7\35\2\2\u00cf"+
		"\u00d5\7\35\2\2\u00d0\u00d1\f\6\2\2\u00d1\u00d5\7\22\2\2\u00d2\u00d3\f"+
		"\5\2\2\u00d3\u00d5\7\23\2\2\u00d4s\3\2\2\2\u00d4v\3\2\2\2\u00d4y\3\2\2"+
		"\2\u00d4|\3\2\2\2\u00d4\177\3\2\2\2\u00d4\u0082\3\2\2\2\u00d4\u0085\3"+
		"\2\2\2\u00d4\u0088\3\2\2\2\u00d4\u008b\3\2\2\2\u00d4\u008e\3\2\2\2\u00d4"+
		"\u0091\3\2\2\2\u00d4\u0094\3\2\2\2\u00d4\u0097\3\2\2\2\u00d4\u009a\3\2"+
		"\2\2\u00d4\u009d\3\2\2\2\u00d4\u00a1\3\2\2\2\u00d4\u00a5\3\2\2\2\u00d4"+
		"\u00a9\3\2\2\2\u00d4\u00ad\3\2\2\2\u00d4\u00b1\3\2\2\2\u00d4\u00b4\3\2"+
		"\2\2\u00d4\u00b9\3\2\2\2\u00d4\u00bc\3\2\2\2\u00d4\u00bf\3\2\2\2\u00d4"+
		"\u00cd\3\2\2\2\u00d4\u00d0\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d5\u00d8\3\2"+
		"\2\2\u00d6\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\13\3\2\2\2\u00d8\u00d6"+
		"\3\2\2\2\u00d9\u00e5\5\20\t\2\u00da\u00e5\5\16\b\2\u00db\u00e5\5\30\r"+
		"\2\u00dc\u00e5\5 \21\2\u00dd\u00e5\5\22\n\2\u00de\u00e5\5\"\22\2\u00df"+
		"\u00e5\5\32\16\2\u00e0\u00e5\5\26\f\2\u00e1\u00e5\5\24\13\2\u00e2\u00e5"+
		"\5\34\17\2\u00e3\u00e5\5\36\20\2\u00e4\u00d9\3\2\2\2\u00e4\u00da\3\2\2"+
		"\2\u00e4\u00db\3\2\2\2\u00e4\u00dc\3\2\2\2\u00e4\u00dd\3\2\2\2\u00e4\u00de"+
		"\3\2\2\2\u00e4\u00df\3\2\2\2\u00e4\u00e0\3\2\2\2\u00e4\u00e1\3\2\2\2\u00e4"+
		"\u00e2\3\2\2\2\u00e4\u00e3\3\2\2\2\u00e5\r\3\2\2\2\u00e6\u00e7\t\2\2\2"+
		"\u00e7\17\3\2\2\2\u00e8\u00e9\7\5\2\2\u00e9\u00ea\5\n\6\2\u00ea\u00eb"+
		"\7\6\2\2\u00eb\21\3\2\2\2\u00ec\u00ee\7/\2\2\u00ed\u00ef\5\n\6\2\u00ee"+
		"\u00ed\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\23\3\2\2\2\u00f0\u00f1\7 \2\2"+
		"\u00f1\u00f2\5\n\6\2\u00f2\25\3\2\2\2\u00f3\u00f9\7\t\2\2\u00f4\u00f5"+
		"\5\n\6\2\u00f5\u00f6\7\30\2\2\u00f6\u00f8\3\2\2\2\u00f7\u00f4\3\2\2\2"+
		"\u00f8\u00fb\3\2\2\2\u00f9\u00f7\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa\u00fd"+
		"\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fc\u00fe\5\n\6\2\u00fd\u00fc\3\2\2\2\u00fd"+
		"\u00fe\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0100\7\n\2\2\u0100\27\3\2\2"+
		"\2\u0101\u0102\7.\2\2\u0102\31\3\2\2\2\u0103\u0104\7\66\2\2\u0104\33\3"+
		"\2\2\2\u0105\u0113\7\26\2\2\u0106\u010c\7\5\2\2\u0107\u0108\5\60\31\2"+
		"\u0108\u0109\7\30\2\2\u0109\u010b\3\2\2\2\u010a\u0107\3\2\2\2\u010b\u010e"+
		"\3\2\2\2\u010c\u010a\3\2\2\2\u010c\u010d\3\2\2\2\u010d\u0110\3\2\2\2\u010e"+
		"\u010c\3\2\2\2\u010f\u0111\5\60\31\2\u0110\u010f\3\2\2\2\u0110\u0111\3"+
		"\2\2\2\u0111\u0112\3\2\2\2\u0112\u0114\7\6\2\2\u0113\u0106\3\2\2\2\u0113"+
		"\u0114\3\2\2\2\u0114\u0117\3\2\2\2\u0115\u0116\7$\2\2\u0116\u0118\5\4"+
		"\3\2\u0117\u0115\3\2\2\2\u0117\u0118\3\2\2\2\u0118\u0119\3\2\2\2\u0119"+
		"\u011a\5\n\6\2\u011a\35\3\2\2\2\u011b\u011f\7\7\2\2\u011c\u011e\5$\23"+
		"\2\u011d\u011c\3\2\2\2\u011e\u0121\3\2\2\2\u011f\u011d\3\2\2\2\u011f\u0120"+
		"\3\2\2\2\u0120\u0122\3\2\2\2\u0121\u011f\3\2\2\2\u0122\u0123\7\b\2\2\u0123"+
		"\37\3\2\2\2\u0124\u0125\7\61\2\2\u0125\u0126\5\n\6\2\u0126\u0127\7$\2"+
		"\2\u0127\u0128\5\n\6\2\u0128\u0129\7\63\2\2\u0129\u012a\5\n\6\2\u012a"+
		"!\3\2\2\2\u012b\u012c\7$\2\2\u012c\u012d\5\b\5\2\u012d#\3\2\2\2\u012e"+
		"\u0136\5*\26\2\u012f\u0136\5&\24\2\u0130\u0136\5(\25\2\u0131\u0133\5\n"+
		"\6\2\u0132\u0134\7\31\2\2\u0133\u0132\3\2\2\2\u0133\u0134\3\2\2\2\u0134"+
		"\u0136\3\2\2\2\u0135\u012e\3\2\2\2\u0135\u012f\3\2\2\2\u0135\u0130\3\2"+
		"\2\2\u0135\u0131\3\2\2\2\u0136%\3\2\2\2\u0137\u0138\7\60\2\2\u0138\u013b"+
		"\5\n\6\2\u0139\u013a\7$\2\2\u013a\u013c\5$\23\2\u013b\u0139\3\2\2\2\u013b"+
		"\u013c\3\2\2\2\u013c\'\3\2\2\2\u013d\u013e\7\61\2\2\u013e\u013f\5\n\6"+
		"\2\u013f\u0140\7$\2\2\u0140\u0143\5$\23\2\u0141\u0142\7\63\2\2\u0142\u0144"+
		"\5$\23\2\u0143\u0141\3\2\2\2\u0143\u0144\3\2\2\2\u0144)\3\2\2\2\u0145"+
		"\u0149\7\7\2\2\u0146\u0148\5$\23\2\u0147\u0146\3\2\2\2\u0148\u014b\3\2"+
		"\2\2\u0149\u0147\3\2\2\2\u0149\u014a\3\2\2\2\u014a\u014c\3\2\2\2\u014b"+
		"\u0149\3\2\2\2\u014c\u014d\7\b\2\2\u014d+\3\2\2\2\u014e\u014f\7-\2\2\u014f"+
		"\u0150\5\4\3\2\u0150\u0154\7\7\2\2\u0151\u0153\58\35\2\u0152\u0151\3\2"+
		"\2\2\u0153\u0156\3\2\2\2\u0154\u0152\3\2\2\2\u0154\u0155\3\2\2\2\u0155"+
		"\u015a\3\2\2\2\u0156\u0154\3\2\2\2\u0157\u0159\5.\30\2\u0158\u0157\3\2"+
		"\2\2\u0159\u015c\3\2\2\2\u015a\u0158\3\2\2\2\u015a\u015b\3\2\2\2\u015b"+
		"\u015d\3\2\2\2\u015c\u015a\3\2\2\2\u015d\u015e\7\b\2\2\u015e-\3\2\2\2"+
		"\u015f\u0160\7*\2\2\u0160\u016e\7\66\2\2\u0161\u0167\7\5\2\2\u0162\u0163"+
		"\5\60\31\2\u0163\u0164\7\30\2\2\u0164\u0166\3\2\2\2\u0165\u0162\3\2\2"+
		"\2\u0166\u0169\3\2\2\2\u0167\u0165\3\2\2\2\u0167\u0168\3\2\2\2\u0168\u016b"+
		"\3\2\2\2\u0169\u0167\3\2\2\2\u016a\u016c\5\60\31\2\u016b\u016a\3\2\2\2"+
		"\u016b\u016c\3\2\2\2\u016c\u016d\3\2\2\2\u016d\u016f\7\6\2\2\u016e\u0161"+
		"\3\2\2\2\u016e\u016f\3\2\2\2\u016f\u0172\3\2\2\2\u0170\u0171\7,\2\2\u0171"+
		"\u0173\7\66\2\2\u0172\u0170\3\2\2\2\u0172\u0173\3\2\2\2\u0173\u017d\3"+
		"\2\2\2\u0174\u0179\7\7\2\2\u0175\u0178\5\64\33\2\u0176\u0178\5$\23\2\u0177"+
		"\u0175\3\2\2\2\u0177\u0176\3\2\2\2\u0178\u017b\3\2\2\2\u0179\u0177\3\2"+
		"\2\2\u0179\u017a\3\2\2\2\u017a\u017c\3\2\2\2\u017b\u0179\3\2\2\2\u017c"+
		"\u017e\7\b\2\2\u017d\u0174\3\2\2\2\u017d\u017e\3\2\2\2\u017e/\3\2\2\2"+
		"\u017f\u0182\7\66\2\2\u0180\u0181\7$\2\2\u0181\u0183\5\4\3\2\u0182\u0180"+
		"\3\2\2\2\u0182\u0183\3\2\2\2\u0183\61\3\2\2\2\u0184\u0185\7&\2\2\u0185"+
		"\u0186\7\66\2\2\u0186\63\3\2\2\2\u0187\u0189\5\62\32\2\u0188\u0187\3\2"+
		"\2\2\u0189\u018c\3\2\2\2\u018a\u0188\3\2\2\2\u018a\u018b\3\2\2\2\u018b"+
		"\u018d\3\2\2\2\u018c\u018a\3\2\2\2\u018d\u018e\7(\2\2\u018e\u018f\7\66"+
		"\2\2\u018f\u0195\7\5\2\2\u0190\u0191\5\60\31\2\u0191\u0192\7\30\2\2\u0192"+
		"\u0194\3\2\2\2\u0193\u0190\3\2\2\2\u0194\u0197\3\2\2\2\u0195\u0193\3\2"+
		"\2\2\u0195\u0196\3\2\2\2\u0196\u0199\3\2\2\2\u0197\u0195\3\2\2\2\u0198"+
		"\u019a\5\60\31\2\u0199\u0198\3\2\2\2\u0199\u019a\3\2\2\2\u019a\u019b\3"+
		"\2\2\2\u019b\u019e\7\6\2\2\u019c\u019d\7$\2\2\u019d\u019f\5\4\3\2\u019e"+
		"\u019c\3\2\2\2\u019e\u019f\3\2\2\2\u019f\u01a3\3\2\2\2\u01a0\u01a4\5*"+
		"\26\2\u01a1\u01a2\7\32\2\2\u01a2\u01a4\5\n\6\2\u01a3\u01a0\3\2\2\2\u01a3"+
		"\u01a1\3\2\2\2\u01a4\65\3\2\2\2\u01a5\u01a6\7)\2\2\u01a6\u01a7\7\'\2\2"+
		"\u01a7\u01a8\5\b\5\2\u01a8\u01a9\7+\2\2\u01a9\u01ab\7\67\2\2\u01aa\u01ac"+
		"\7\31\2\2\u01ab\u01aa\3\2\2\2\u01ab\u01ac\3\2\2\2\u01ac\67\3\2\2\2\u01ad"+
		"\u01ae\7\'\2\2\u01ae\u01af\7\66\2\2\u01af\u01b0\7\32\2\2\u01b0\u01b2\5"+
		"\16\b\2\u01b1\u01b3\7\31\2\2\u01b2\u01b1\3\2\2\2\u01b2\u01b3\3\2\2\2\u01b3"+
		"9\3\2\2\2/=CJLRV^bkq\u00c6\u00ca\u00d4\u00d6\u00e4\u00ee\u00f9\u00fd\u010c"+
		"\u0110\u0113\u0117\u011f\u0133\u0135\u013b\u0143\u0149\u0154\u015a\u0167"+
		"\u016b\u016e\u0172\u0177\u0179\u017d\u0182\u018a\u0195\u0199\u019e\u01a3"+
		"\u01ab\u01b2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}