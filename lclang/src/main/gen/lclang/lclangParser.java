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
		T__0=1, T__1=2, T__2=3, COMMENT=4, LINE_COMMENT=5, OPEN=6, CLOSE=7, OPEN_BRACE=8, 
		CLOSE_BRACE=9, OPEN_BRACKET=10, CLOSE_BRACKET=11, POW=12, EQUALS=13, NOT_EQUALS=14, 
		AND_BOOL=15, OR_BOOL=16, LESS_EQUALS=17, LARGER_EQUALS=18, UNARY_ADD=19, 
		UNARY_MINUS=20, NULLABLE_OR=21, NULLABLE=22, LAMBDA_PREFIX=23, TYPE_PREFIX=24, 
		COMMA=25, SEMICOLON=26, ASSIGN=27, OR=28, AND=29, NOT=30, LESS=31, LARGER=32, 
		MULTIPLICATION=33, DIVISION=34, ADD=35, MINUS=36, COLON=37, DOT=38, AS_ATTR=39, 
		GLOBAL=40, METHOD=41, USE=42, CLASS=43, FROM=44, EXTENDS=45, COMPONENT=46, 
		STOP=47, RETURN=48, WHILE=49, AS=50, IF=51, IS=52, ELSE=53, BOOL=54, ID=55, 
		STRING=56, CHAR=57, HEX_LONG=58, LONG=59, DOUBLE=60, INTEGER=61, WS=62;
	public static final int
		RULE_file = 0, RULE_type = 1, RULE_methodType = 2, RULE_magicType = 3, 
		RULE_namedType = 4, RULE_expression = 5, RULE_primitive = 6, RULE_value = 7, 
		RULE_parentnesesExpr = 8, RULE_returnExpr = 9, RULE_typeGet = 10, RULE_array = 11, 
		RULE_stop = 12, RULE_variable = 13, RULE_lambda = 14, RULE_container = 15, 
		RULE_ifExpr = 16, RULE_newClass = 17, RULE_stmt = 18, RULE_whileStmt = 19, 
		RULE_ifStmt = 20, RULE_block = 21, RULE_component = 22, RULE_classExpr = 23, 
		RULE_extendsArgs = 24, RULE_arg = 25, RULE_attribute = 26, RULE_method = 27, 
		RULE_use = 28, RULE_global = 29;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "type", "methodType", "magicType", "namedType", "expression", 
			"primitive", "value", "parentnesesExpr", "returnExpr", "typeGet", "array", 
			"stop", "variable", "lambda", "container", "ifExpr", "newClass", "stmt", 
			"whileStmt", "ifStmt", "block", "component", "classExpr", "extendsArgs", 
			"arg", "attribute", "method", "use", "global"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'any'", "'void'", "'callable'", null, null, "'('", "')'", "'{'", 
			"'}'", "'['", "']'", "'**'", "'=='", "'!='", "'&&'", "'||'", "'<='", 
			"'>='", "'++'", "'--'", "'?:'", "'?'", "'->'", "'\\'", "','", "';'", 
			"'='", "'|'", "'&'", "'!'", "'<'", "'>'", "'*'", "'/'", "'+'", "'-'", 
			"':'", "'.'", "'@'", "'global'", "'method'", "'use'", "'class'", "'from'", 
			"'extends'", "'component'", "'stop'", "'return'", "'while'", "'as'", 
			"'if'", "'is'", "'else'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "COMMENT", "LINE_COMMENT", "OPEN", "CLOSE", "OPEN_BRACE", 
			"CLOSE_BRACE", "OPEN_BRACKET", "CLOSE_BRACKET", "POW", "EQUALS", "NOT_EQUALS", 
			"AND_BOOL", "OR_BOOL", "LESS_EQUALS", "LARGER_EQUALS", "UNARY_ADD", "UNARY_MINUS", 
			"NULLABLE_OR", "NULLABLE", "LAMBDA_PREFIX", "TYPE_PREFIX", "COMMA", "SEMICOLON", 
			"ASSIGN", "OR", "AND", "NOT", "LESS", "LARGER", "MULTIPLICATION", "DIVISION", 
			"ADD", "MINUS", "COLON", "DOT", "AS_ATTR", "GLOBAL", "METHOD", "USE", 
			"CLASS", "FROM", "EXTENDS", "COMPONENT", "STOP", "RETURN", "WHILE", "AS", 
			"IF", "IS", "ELSE", "BOOL", "ID", "STRING", "CHAR", "HEX_LONG", "LONG", 
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
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==USE) {
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
			while (_la==GLOBAL) {
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
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPEN) | (1L << OPEN_BRACE) | (1L << OPEN_BRACKET) | (1L << LAMBDA_PREFIX) | (1L << NOT) | (1L << MULTIPLICATION) | (1L << COLON) | (1L << AS_ATTR) | (1L << METHOD) | (1L << CLASS) | (1L << COMPONENT) | (1L << STOP) | (1L << RETURN) | (1L << WHILE) | (1L << IF) | (1L << BOOL) | (1L << ID) | (1L << STRING) | (1L << CHAR) | (1L << HEX_LONG) | (1L << LONG) | (1L << DOUBLE) | (1L << INTEGER))) != 0)) {
				{
				setState(76);
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
				case AS_ATTR:
				case METHOD:
					{
					setState(73);
					method();
					}
					break;
				case COMPONENT:
					{
					setState(74);
					component();
					}
					break;
				case CLASS:
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
			setState(81);
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
		public MagicTypeContext magicType() {
			return getRuleContext(MagicTypeContext.class,0);
		}
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
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NULLABLE) {
				{
				setState(83);
				((TypeContext)_localctx).nullable = match(NULLABLE);
				}
			}

			setState(89);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__1:
			case T__2:
				{
				setState(86);
				magicType();
				}
				break;
			case OPEN:
				{
				setState(87);
				methodType();
				}
				break;
			case ID:
				{
				setState(88);
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
			setState(91);
			match(OPEN);
			setState(97);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(92);
					((MethodTypeContext)_localctx).args = type();
					setState(93);
					match(COMMA);
					}
					} 
				}
				setState(99);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << OPEN) | (1L << NULLABLE) | (1L << ID))) != 0)) {
				{
				setState(100);
				((MethodTypeContext)_localctx).args = type();
				}
			}

			setState(103);
			match(CLOSE);
			setState(104);
			match(LAMBDA_PREFIX);
			setState(105);
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

	public static class MagicTypeContext extends ParserRuleContext {
		public MagicTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_magicType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).enterMagicType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof lclangListener ) ((lclangListener)listener).exitMagicType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof lclangVisitor ) return ((lclangVisitor<? extends T>)visitor).visitMagicType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MagicTypeContext magicType() throws RecognitionException {
		MagicTypeContext _localctx = new MagicTypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_magicType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2))) != 0)) ) {
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
		enterRule(_localctx, 8, RULE_namedType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(ID);
			setState(112);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(110);
				match(TYPE_PREFIX);
				setState(111);
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
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOT:
				{
				setState(115);
				((ExpressionContext)_localctx).not = match(NOT);
				setState(116);
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
				setState(117);
				primitive();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(220);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(218);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(120);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(121);
						((ExpressionContext)_localctx).or = match(OR_BOOL);
						setState(122);
						expression(26);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(123);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(124);
						((ExpressionContext)_localctx).and = match(AND_BOOL);
						setState(125);
						expression(25);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(126);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(127);
						((ExpressionContext)_localctx).equals = match(EQUALS);
						setState(128);
						expression(24);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(129);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(130);
						((ExpressionContext)_localctx).notEquals = match(NOT_EQUALS);
						setState(131);
						expression(23);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(132);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(133);
						((ExpressionContext)_localctx).less = match(LESS);
						setState(134);
						expression(22);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(135);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(136);
						((ExpressionContext)_localctx).larger = match(LARGER);
						setState(137);
						expression(21);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(138);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(139);
						((ExpressionContext)_localctx).largerEquals = match(LARGER_EQUALS);
						setState(140);
						expression(20);
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(141);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(142);
						((ExpressionContext)_localctx).lessEquals = match(LESS_EQUALS);
						setState(143);
						expression(19);
						}
						break;
					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(144);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(145);
						((ExpressionContext)_localctx).multiplication = match(MULTIPLICATION);
						setState(146);
						expression(18);
						}
						break;
					case 10:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(147);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(148);
						((ExpressionContext)_localctx).div = match(DIVISION);
						setState(149);
						expression(17);
						}
						break;
					case 11:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(150);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(151);
						((ExpressionContext)_localctx).add = match(ADD);
						setState(152);
						expression(16);
						}
						break;
					case 12:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(153);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(154);
						((ExpressionContext)_localctx).minus = match(MINUS);
						setState(155);
						expression(15);
						}
						break;
					case 13:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(156);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(157);
						((ExpressionContext)_localctx).pow = match(POW);
						setState(158);
						expression(14);
						}
						break;
					case 14:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(159);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(160);
						((ExpressionContext)_localctx).assign = match(ASSIGN);
						setState(161);
						expression(13);
						}
						break;
					case 15:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(162);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(163);
						((ExpressionContext)_localctx).add = match(ADD);
						setState(164);
						((ExpressionContext)_localctx).assign = match(ASSIGN);
						setState(165);
						expression(12);
						}
						break;
					case 16:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(166);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(167);
						((ExpressionContext)_localctx).minus = match(ADD);
						setState(168);
						((ExpressionContext)_localctx).assign = match(ASSIGN);
						setState(169);
						expression(11);
						}
						break;
					case 17:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(170);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(171);
						((ExpressionContext)_localctx).div = match(DIVISION);
						setState(172);
						((ExpressionContext)_localctx).assign = match(ASSIGN);
						setState(173);
						expression(10);
						}
						break;
					case 18:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(174);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(175);
						((ExpressionContext)_localctx).multiplication = match(MULTIPLICATION);
						setState(176);
						((ExpressionContext)_localctx).assign = match(ASSIGN);
						setState(177);
						expression(9);
						}
						break;
					case 19:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(178);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(179);
						((ExpressionContext)_localctx).pow = match(POW);
						setState(180);
						((ExpressionContext)_localctx).assign = match(ASSIGN);
						setState(181);
						expression(8);
						}
						break;
					case 20:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(182);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(183);
						((ExpressionContext)_localctx).nullableOr = match(NULLABLE_OR);
						setState(184);
						expression(7);
						}
						break;
					case 21:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(185);
						if (!(precpred(_ctx, 29))) throw new FailedPredicateException(this, "precpred(_ctx, 29)");
						setState(186);
						((ExpressionContext)_localctx).arrayAccess = match(OPEN_BRACKET);
						setState(188);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPEN) | (1L << OPEN_BRACE) | (1L << OPEN_BRACKET) | (1L << LAMBDA_PREFIX) | (1L << NOT) | (1L << MULTIPLICATION) | (1L << COLON) | (1L << STOP) | (1L << RETURN) | (1L << IF) | (1L << BOOL) | (1L << ID) | (1L << STRING) | (1L << CHAR) | (1L << HEX_LONG) | (1L << LONG) | (1L << DOUBLE) | (1L << INTEGER))) != 0)) {
							{
							setState(187);
							expression(0);
							}
						}

						setState(190);
						match(CLOSE_BRACKET);
						}
						break;
					case 22:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(191);
						if (!(precpred(_ctx, 28))) throw new FailedPredicateException(this, "precpred(_ctx, 28)");
						setState(192);
						((ExpressionContext)_localctx).is = match(IS);
						setState(193);
						type();
						}
						break;
					case 23:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(194);
						if (!(precpred(_ctx, 27))) throw new FailedPredicateException(this, "precpred(_ctx, 27)");
						setState(195);
						((ExpressionContext)_localctx).access = match(DOT);
						setState(196);
						variable();
						}
						break;
					case 24:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(197);
						if (!(precpred(_ctx, 26))) throw new FailedPredicateException(this, "precpred(_ctx, 26)");
						setState(198);
						((ExpressionContext)_localctx).call = match(OPEN);
						setState(204);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(199);
								expression(0);
								setState(200);
								match(COMMA);
								}
								} 
							}
							setState(206);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
						}
						setState(208);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPEN) | (1L << OPEN_BRACE) | (1L << OPEN_BRACKET) | (1L << LAMBDA_PREFIX) | (1L << NOT) | (1L << MULTIPLICATION) | (1L << COLON) | (1L << STOP) | (1L << RETURN) | (1L << IF) | (1L << BOOL) | (1L << ID) | (1L << STRING) | (1L << CHAR) | (1L << HEX_LONG) | (1L << LONG) | (1L << DOUBLE) | (1L << INTEGER))) != 0)) {
							{
							setState(207);
							expression(0);
							}
						}

						setState(210);
						match(CLOSE);
						}
						break;
					case 25:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(211);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(212);
						((ExpressionContext)_localctx).throwNull = match(NOT);
						setState(213);
						match(NOT);
						}
						break;
					case 26:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(214);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(215);
						((ExpressionContext)_localctx).unaryPlus = match(UNARY_ADD);
						}
						break;
					case 27:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(216);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(217);
						((ExpressionContext)_localctx).unaryMinus = match(UNARY_MINUS);
						}
						break;
					}
					} 
				}
				setState(222);
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
		enterRule(_localctx, 12, RULE_primitive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPEN:
				{
				setState(223);
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
				setState(224);
				value();
				}
				break;
			case STOP:
				{
				setState(225);
				stop();
				}
				break;
			case IF:
				{
				setState(226);
				ifExpr();
				}
				break;
			case RETURN:
				{
				setState(227);
				returnExpr();
				}
				break;
			case COLON:
				{
				setState(228);
				newClass();
				}
				break;
			case ID:
				{
				setState(229);
				variable();
				}
				break;
			case OPEN_BRACKET:
				{
				setState(230);
				array();
				}
				break;
			case MULTIPLICATION:
				{
				setState(231);
				typeGet();
				}
				break;
			case LAMBDA_PREFIX:
				{
				setState(232);
				lambda();
				}
				break;
			case OPEN_BRACE:
				{
				setState(233);
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
		enterRule(_localctx, 14, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
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
		enterRule(_localctx, 16, RULE_parentnesesExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			match(OPEN);
			setState(239);
			expression(0);
			setState(240);
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
		enterRule(_localctx, 18, RULE_returnExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			match(RETURN);
			setState(244);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(243);
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
		enterRule(_localctx, 20, RULE_typeGet);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			match(MULTIPLICATION);
			setState(247);
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
		enterRule(_localctx, 22, RULE_array);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(249);
			match(OPEN_BRACKET);
			setState(255);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(250);
					expression(0);
					setState(251);
					match(COMMA);
					}
					} 
				}
				setState(257);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			setState(259);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPEN) | (1L << OPEN_BRACE) | (1L << OPEN_BRACKET) | (1L << LAMBDA_PREFIX) | (1L << NOT) | (1L << MULTIPLICATION) | (1L << COLON) | (1L << STOP) | (1L << RETURN) | (1L << IF) | (1L << BOOL) | (1L << ID) | (1L << STRING) | (1L << CHAR) | (1L << HEX_LONG) | (1L << LONG) | (1L << DOUBLE) | (1L << INTEGER))) != 0)) {
				{
				setState(258);
				expression(0);
				}
			}

			setState(261);
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
		enterRule(_localctx, 24, RULE_stop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
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
		enterRule(_localctx, 26, RULE_variable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
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
		enterRule(_localctx, 28, RULE_lambda);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			match(LAMBDA_PREFIX);
			setState(281);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(268);
				match(OPEN);
				setState(274);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(269);
						arg();
						setState(270);
						match(COMMA);
						}
						} 
					}
					setState(276);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
				}
				setState(278);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(277);
					arg();
					}
				}

				setState(280);
				match(CLOSE);
				}
				break;
			}
			setState(285);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(283);
				match(COLON);
				setState(284);
				type();
				}
				break;
			}
			setState(287);
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
		enterRule(_localctx, 30, RULE_container);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(289);
			match(OPEN_BRACE);
			setState(293);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPEN) | (1L << OPEN_BRACE) | (1L << OPEN_BRACKET) | (1L << LAMBDA_PREFIX) | (1L << NOT) | (1L << MULTIPLICATION) | (1L << COLON) | (1L << STOP) | (1L << RETURN) | (1L << WHILE) | (1L << IF) | (1L << BOOL) | (1L << ID) | (1L << STRING) | (1L << CHAR) | (1L << HEX_LONG) | (1L << LONG) | (1L << DOUBLE) | (1L << INTEGER))) != 0)) {
				{
				{
				setState(290);
				stmt();
				}
				}
				setState(295);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(296);
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
		enterRule(_localctx, 32, RULE_ifExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(298);
			match(IF);
			setState(299);
			((IfExprContext)_localctx).condition = expression(0);
			setState(300);
			match(COLON);
			setState(301);
			((IfExprContext)_localctx).ifT = expression(0);
			setState(302);
			match(ELSE);
			setState(303);
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
		enterRule(_localctx, 34, RULE_newClass);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
			match(COLON);
			setState(306);
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
		enterRule(_localctx, 36, RULE_stmt);
		int _la;
		try {
			setState(315);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(308);
				block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(309);
				whileStmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(310);
				ifStmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(311);
				expression(0);
				setState(313);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(312);
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
		enterRule(_localctx, 38, RULE_whileStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(317);
			match(WHILE);
			setState(318);
			((WhileStmtContext)_localctx).condition = expression(0);
			setState(321);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				setState(319);
				match(COLON);
				setState(320);
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
		enterRule(_localctx, 40, RULE_ifStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(323);
			match(IF);
			setState(324);
			((IfStmtContext)_localctx).condition = expression(0);
			setState(325);
			match(COLON);
			setState(326);
			((IfStmtContext)_localctx).ifT = stmt();
			setState(329);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(327);
				match(ELSE);
				setState(328);
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
		enterRule(_localctx, 42, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(331);
			match(OPEN_BRACE);
			setState(335);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPEN) | (1L << OPEN_BRACE) | (1L << OPEN_BRACKET) | (1L << LAMBDA_PREFIX) | (1L << NOT) | (1L << MULTIPLICATION) | (1L << COLON) | (1L << STOP) | (1L << RETURN) | (1L << WHILE) | (1L << IF) | (1L << BOOL) | (1L << ID) | (1L << STRING) | (1L << CHAR) | (1L << HEX_LONG) | (1L << LONG) | (1L << DOUBLE) | (1L << INTEGER))) != 0)) {
				{
				{
				setState(332);
				stmt();
				}
				}
				setState(337);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(338);
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
		enterRule(_localctx, 44, RULE_component);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(340);
			match(COMPONENT);
			setState(341);
			type();
			setState(342);
			match(OPEN_BRACE);
			setState(346);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==GLOBAL) {
				{
				{
				setState(343);
				global();
				}
				}
				setState(348);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(352);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CLASS) {
				{
				{
				setState(349);
				classExpr();
				}
				}
				setState(354);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(355);
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
		enterRule(_localctx, 46, RULE_classExpr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(357);
			match(CLASS);
			setState(358);
			((ClassExprContext)_localctx).name = match(ID);
			setState(372);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				{
				setState(359);
				match(OPEN);
				setState(365);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(360);
						arg();
						setState(361);
						match(COMMA);
						}
						} 
					}
					setState(367);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
				}
				setState(369);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(368);
					arg();
					}
				}

				setState(371);
				match(CLOSE);
				}
				break;
			}
			setState(382);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(374);
				match(EXTENDS);
				setState(375);
				((ClassExprContext)_localctx).classExtends = namedType();
				setState(380);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
				case 1:
					{
					setState(376);
					match(OPEN);
					setState(377);
					extendsArgs();
					setState(378);
					match(CLOSE);
					}
					break;
				}
				}
			}

			setState(393);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				{
				setState(384);
				match(OPEN_BRACE);
				setState(389);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPEN) | (1L << OPEN_BRACE) | (1L << OPEN_BRACKET) | (1L << LAMBDA_PREFIX) | (1L << NOT) | (1L << MULTIPLICATION) | (1L << COLON) | (1L << AS_ATTR) | (1L << METHOD) | (1L << STOP) | (1L << RETURN) | (1L << WHILE) | (1L << IF) | (1L << BOOL) | (1L << ID) | (1L << STRING) | (1L << CHAR) | (1L << HEX_LONG) | (1L << LONG) | (1L << DOUBLE) | (1L << INTEGER))) != 0)) {
					{
					setState(387);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case AS_ATTR:
					case METHOD:
						{
						setState(385);
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
					case BOOL:
					case ID:
					case STRING:
					case CHAR:
					case HEX_LONG:
					case LONG:
					case DOUBLE:
					case INTEGER:
						{
						setState(386);
						stmt();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(391);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(392);
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
		enterRule(_localctx, 48, RULE_extendsArgs);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(400);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(395);
					expression(0);
					setState(396);
					match(COMMA);
					}
					} 
				}
				setState(402);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			}
			setState(404);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OPEN) | (1L << OPEN_BRACE) | (1L << OPEN_BRACKET) | (1L << LAMBDA_PREFIX) | (1L << NOT) | (1L << MULTIPLICATION) | (1L << COLON) | (1L << STOP) | (1L << RETURN) | (1L << IF) | (1L << BOOL) | (1L << ID) | (1L << STRING) | (1L << CHAR) | (1L << HEX_LONG) | (1L << LONG) | (1L << DOUBLE) | (1L << INTEGER))) != 0)) {
				{
				setState(403);
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
		enterRule(_localctx, 50, RULE_arg);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(406);
			match(ID);
			setState(409);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(407);
				match(COLON);
				setState(408);
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
		enterRule(_localctx, 52, RULE_attribute);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(411);
			match(AS_ATTR);
			setState(412);
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
		enterRule(_localctx, 54, RULE_method);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(417);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AS_ATTR) {
				{
				{
				setState(414);
				attribute();
				}
				}
				setState(419);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(420);
			match(METHOD);
			setState(421);
			match(ID);
			setState(422);
			match(OPEN);
			setState(428);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(423);
					arg();
					setState(424);
					match(COMMA);
					}
					} 
				}
				setState(430);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
			}
			setState(432);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(431);
				arg();
				}
			}

			setState(434);
			match(CLOSE);
			setState(437);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(435);
				match(COLON);
				setState(436);
				((MethodContext)_localctx).returnType = type();
				}
			}

			setState(442);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OPEN_BRACE:
				{
				setState(439);
				block();
				}
				break;
			case ASSIGN:
				{
				setState(440);
				match(ASSIGN);
				setState(441);
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
		enterRule(_localctx, 56, RULE_use);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(444);
			match(USE);
			setState(446);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==GLOBAL) {
				{
				setState(445);
				match(GLOBAL);
				}
			}

			setState(448);
			((UseContext)_localctx).name = match(ID);
			{
			setState(449);
			match(AS);
			setState(450);
			((UseContext)_localctx).alias = match(ID);
			}
			setState(452);
			match(FROM);
			setState(455);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				{
				setState(453);
				((UseContext)_localctx).fromPackage = match(ID);
				}
				break;
			case STRING:
				{
				setState(454);
				((UseContext)_localctx).fromFile = match(STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(458);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMICOLON) {
				{
				setState(457);
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
		enterRule(_localctx, 58, RULE_global);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(460);
			match(GLOBAL);
			setState(461);
			match(ID);
			setState(462);
			match(ASSIGN);
			setState(463);
			value();
			setState(465);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMICOLON) {
				{
				setState(464);
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
		case 5:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3@\u01d6\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\3\2\7\2@"+
		"\n\2\f\2\16\2C\13\2\3\2\7\2F\n\2\f\2\16\2I\13\2\3\2\3\2\3\2\3\2\7\2O\n"+
		"\2\f\2\16\2R\13\2\3\2\3\2\3\3\5\3W\n\3\3\3\3\3\3\3\5\3\\\n\3\3\4\3\4\3"+
		"\4\3\4\7\4b\n\4\f\4\16\4e\13\4\3\4\5\4h\n\4\3\4\3\4\3\4\3\4\3\5\3\5\3"+
		"\6\3\6\3\6\5\6s\n\6\3\7\3\7\3\7\3\7\5\7y\n\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u00bf\n\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u00cd\n\7\f\7\16\7\u00d0\13\7\3\7\5\7"+
		"\u00d3\n\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7\u00dd\n\7\f\7\16\7\u00e0"+
		"\13\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00ed\n\b\3\t\3"+
		"\t\3\n\3\n\3\n\3\n\3\13\3\13\5\13\u00f7\n\13\3\f\3\f\3\f\3\r\3\r\3\r\3"+
		"\r\7\r\u0100\n\r\f\r\16\r\u0103\13\r\3\r\5\r\u0106\n\r\3\r\3\r\3\16\3"+
		"\16\3\17\3\17\3\20\3\20\3\20\3\20\3\20\7\20\u0113\n\20\f\20\16\20\u0116"+
		"\13\20\3\20\5\20\u0119\n\20\3\20\5\20\u011c\n\20\3\20\3\20\5\20\u0120"+
		"\n\20\3\20\3\20\3\21\3\21\7\21\u0126\n\21\f\21\16\21\u0129\13\21\3\21"+
		"\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24"+
		"\3\24\3\24\5\24\u013c\n\24\5\24\u013e\n\24\3\25\3\25\3\25\3\25\5\25\u0144"+
		"\n\25\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u014c\n\26\3\27\3\27\7\27\u0150"+
		"\n\27\f\27\16\27\u0153\13\27\3\27\3\27\3\30\3\30\3\30\3\30\7\30\u015b"+
		"\n\30\f\30\16\30\u015e\13\30\3\30\7\30\u0161\n\30\f\30\16\30\u0164\13"+
		"\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\7\31\u016e\n\31\f\31\16\31"+
		"\u0171\13\31\3\31\5\31\u0174\n\31\3\31\5\31\u0177\n\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\5\31\u017f\n\31\5\31\u0181\n\31\3\31\3\31\3\31\7\31\u0186"+
		"\n\31\f\31\16\31\u0189\13\31\3\31\5\31\u018c\n\31\3\32\3\32\3\32\7\32"+
		"\u0191\n\32\f\32\16\32\u0194\13\32\3\32\5\32\u0197\n\32\3\33\3\33\3\33"+
		"\5\33\u019c\n\33\3\34\3\34\3\34\3\35\7\35\u01a2\n\35\f\35\16\35\u01a5"+
		"\13\35\3\35\3\35\3\35\3\35\3\35\3\35\7\35\u01ad\n\35\f\35\16\35\u01b0"+
		"\13\35\3\35\5\35\u01b3\n\35\3\35\3\35\3\35\5\35\u01b8\n\35\3\35\3\35\3"+
		"\35\5\35\u01bd\n\35\3\36\3\36\5\36\u01c1\n\36\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\5\36\u01ca\n\36\3\36\5\36\u01cd\n\36\3\37\3\37\3\37\3\37\3"+
		"\37\5\37\u01d4\n\37\3\37\2\3\f \2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
		" \"$&(*,.\60\62\64\668:<\2\4\3\2\3\5\4\288:?\2\u0211\2A\3\2\2\2\4V\3\2"+
		"\2\2\6]\3\2\2\2\bm\3\2\2\2\no\3\2\2\2\fx\3\2\2\2\16\u00ec\3\2\2\2\20\u00ee"+
		"\3\2\2\2\22\u00f0\3\2\2\2\24\u00f4\3\2\2\2\26\u00f8\3\2\2\2\30\u00fb\3"+
		"\2\2\2\32\u0109\3\2\2\2\34\u010b\3\2\2\2\36\u010d\3\2\2\2 \u0123\3\2\2"+
		"\2\"\u012c\3\2\2\2$\u0133\3\2\2\2&\u013d\3\2\2\2(\u013f\3\2\2\2*\u0145"+
		"\3\2\2\2,\u014d\3\2\2\2.\u0156\3\2\2\2\60\u0167\3\2\2\2\62\u0192\3\2\2"+
		"\2\64\u0198\3\2\2\2\66\u019d\3\2\2\28\u01a3\3\2\2\2:\u01be\3\2\2\2<\u01ce"+
		"\3\2\2\2>@\5:\36\2?>\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2BG\3\2\2\2C"+
		"A\3\2\2\2DF\5<\37\2ED\3\2\2\2FI\3\2\2\2GE\3\2\2\2GH\3\2\2\2HP\3\2\2\2"+
		"IG\3\2\2\2JO\5&\24\2KO\58\35\2LO\5.\30\2MO\5\60\31\2NJ\3\2\2\2NK\3\2\2"+
		"\2NL\3\2\2\2NM\3\2\2\2OR\3\2\2\2PN\3\2\2\2PQ\3\2\2\2QS\3\2\2\2RP\3\2\2"+
		"\2ST\7\2\2\3T\3\3\2\2\2UW\7\30\2\2VU\3\2\2\2VW\3\2\2\2W[\3\2\2\2X\\\5"+
		"\b\5\2Y\\\5\6\4\2Z\\\5\n\6\2[X\3\2\2\2[Y\3\2\2\2[Z\3\2\2\2\\\5\3\2\2\2"+
		"]c\7\b\2\2^_\5\4\3\2_`\7\33\2\2`b\3\2\2\2a^\3\2\2\2be\3\2\2\2ca\3\2\2"+
		"\2cd\3\2\2\2dg\3\2\2\2ec\3\2\2\2fh\5\4\3\2gf\3\2\2\2gh\3\2\2\2hi\3\2\2"+
		"\2ij\7\t\2\2jk\7\31\2\2kl\5\4\3\2l\7\3\2\2\2mn\t\2\2\2n\t\3\2\2\2or\7"+
		"9\2\2pq\7\32\2\2qs\5\n\6\2rp\3\2\2\2rs\3\2\2\2s\13\3\2\2\2tu\b\7\1\2u"+
		"v\7 \2\2vy\5\f\7\4wy\5\16\b\2xt\3\2\2\2xw\3\2\2\2y\u00de\3\2\2\2z{\f\33"+
		"\2\2{|\7\22\2\2|\u00dd\5\f\7\34}~\f\32\2\2~\177\7\21\2\2\177\u00dd\5\f"+
		"\7\33\u0080\u0081\f\31\2\2\u0081\u0082\7\17\2\2\u0082\u00dd\5\f\7\32\u0083"+
		"\u0084\f\30\2\2\u0084\u0085\7\20\2\2\u0085\u00dd\5\f\7\31\u0086\u0087"+
		"\f\27\2\2\u0087\u0088\7!\2\2\u0088\u00dd\5\f\7\30\u0089\u008a\f\26\2\2"+
		"\u008a\u008b\7\"\2\2\u008b\u00dd\5\f\7\27\u008c\u008d\f\25\2\2\u008d\u008e"+
		"\7\24\2\2\u008e\u00dd\5\f\7\26\u008f\u0090\f\24\2\2\u0090\u0091\7\23\2"+
		"\2\u0091\u00dd\5\f\7\25\u0092\u0093\f\23\2\2\u0093\u0094\7#\2\2\u0094"+
		"\u00dd\5\f\7\24\u0095\u0096\f\22\2\2\u0096\u0097\7$\2\2\u0097\u00dd\5"+
		"\f\7\23\u0098\u0099\f\21\2\2\u0099\u009a\7%\2\2\u009a\u00dd\5\f\7\22\u009b"+
		"\u009c\f\20\2\2\u009c\u009d\7&\2\2\u009d\u00dd\5\f\7\21\u009e\u009f\f"+
		"\17\2\2\u009f\u00a0\7\16\2\2\u00a0\u00dd\5\f\7\20\u00a1\u00a2\f\16\2\2"+
		"\u00a2\u00a3\7\35\2\2\u00a3\u00dd\5\f\7\17\u00a4\u00a5\f\r\2\2\u00a5\u00a6"+
		"\7%\2\2\u00a6\u00a7\7\35\2\2\u00a7\u00dd\5\f\7\16\u00a8\u00a9\f\f\2\2"+
		"\u00a9\u00aa\7%\2\2\u00aa\u00ab\7\35\2\2\u00ab\u00dd\5\f\7\r\u00ac\u00ad"+
		"\f\13\2\2\u00ad\u00ae\7$\2\2\u00ae\u00af\7\35\2\2\u00af\u00dd\5\f\7\f"+
		"\u00b0\u00b1\f\n\2\2\u00b1\u00b2\7#\2\2\u00b2\u00b3\7\35\2\2\u00b3\u00dd"+
		"\5\f\7\13\u00b4\u00b5\f\t\2\2\u00b5\u00b6\7\16\2\2\u00b6\u00b7\7\35\2"+
		"\2\u00b7\u00dd\5\f\7\n\u00b8\u00b9\f\b\2\2\u00b9\u00ba\7\27\2\2\u00ba"+
		"\u00dd\5\f\7\t\u00bb\u00bc\f\37\2\2\u00bc\u00be\7\f\2\2\u00bd\u00bf\5"+
		"\f\7\2\u00be\u00bd\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0"+
		"\u00dd\7\r\2\2\u00c1\u00c2\f\36\2\2\u00c2\u00c3\7\66\2\2\u00c3\u00dd\5"+
		"\4\3\2\u00c4\u00c5\f\35\2\2\u00c5\u00c6\7(\2\2\u00c6\u00dd\5\34\17\2\u00c7"+
		"\u00c8\f\34\2\2\u00c8\u00ce\7\b\2\2\u00c9\u00ca\5\f\7\2\u00ca\u00cb\7"+
		"\33\2\2\u00cb\u00cd\3\2\2\2\u00cc\u00c9\3\2\2\2\u00cd\u00d0\3\2\2\2\u00ce"+
		"\u00cc\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf\u00d2\3\2\2\2\u00d0\u00ce\3\2"+
		"\2\2\u00d1\u00d3\5\f\7\2\u00d2\u00d1\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3"+
		"\u00d4\3\2\2\2\u00d4\u00dd\7\t\2\2\u00d5\u00d6\f\7\2\2\u00d6\u00d7\7 "+
		"\2\2\u00d7\u00dd\7 \2\2\u00d8\u00d9\f\6\2\2\u00d9\u00dd\7\25\2\2\u00da"+
		"\u00db\f\5\2\2\u00db\u00dd\7\26\2\2\u00dcz\3\2\2\2\u00dc}\3\2\2\2\u00dc"+
		"\u0080\3\2\2\2\u00dc\u0083\3\2\2\2\u00dc\u0086\3\2\2\2\u00dc\u0089\3\2"+
		"\2\2\u00dc\u008c\3\2\2\2\u00dc\u008f\3\2\2\2\u00dc\u0092\3\2\2\2\u00dc"+
		"\u0095\3\2\2\2\u00dc\u0098\3\2\2\2\u00dc\u009b\3\2\2\2\u00dc\u009e\3\2"+
		"\2\2\u00dc\u00a1\3\2\2\2\u00dc\u00a4\3\2\2\2\u00dc\u00a8\3\2\2\2\u00dc"+
		"\u00ac\3\2\2\2\u00dc\u00b0\3\2\2\2\u00dc\u00b4\3\2\2\2\u00dc\u00b8\3\2"+
		"\2\2\u00dc\u00bb\3\2\2\2\u00dc\u00c1\3\2\2\2\u00dc\u00c4\3\2\2\2\u00dc"+
		"\u00c7\3\2\2\2\u00dc\u00d5\3\2\2\2\u00dc\u00d8\3\2\2\2\u00dc\u00da\3\2"+
		"\2\2\u00dd\u00e0\3\2\2\2\u00de\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df"+
		"\r\3\2\2\2\u00e0\u00de\3\2\2\2\u00e1\u00ed\5\22\n\2\u00e2\u00ed\5\20\t"+
		"\2\u00e3\u00ed\5\32\16\2\u00e4\u00ed\5\"\22\2\u00e5\u00ed\5\24\13\2\u00e6"+
		"\u00ed\5$\23\2\u00e7\u00ed\5\34\17\2\u00e8\u00ed\5\30\r\2\u00e9\u00ed"+
		"\5\26\f\2\u00ea\u00ed\5\36\20\2\u00eb\u00ed\5 \21\2\u00ec\u00e1\3\2\2"+
		"\2\u00ec\u00e2\3\2\2\2\u00ec\u00e3\3\2\2\2\u00ec\u00e4\3\2\2\2\u00ec\u00e5"+
		"\3\2\2\2\u00ec\u00e6\3\2\2\2\u00ec\u00e7\3\2\2\2\u00ec\u00e8\3\2\2\2\u00ec"+
		"\u00e9\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ec\u00eb\3\2\2\2\u00ed\17\3\2\2"+
		"\2\u00ee\u00ef\t\3\2\2\u00ef\21\3\2\2\2\u00f0\u00f1\7\b\2\2\u00f1\u00f2"+
		"\5\f\7\2\u00f2\u00f3\7\t\2\2\u00f3\23\3\2\2\2\u00f4\u00f6\7\62\2\2\u00f5"+
		"\u00f7\5\f\7\2\u00f6\u00f5\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\25\3\2\2"+
		"\2\u00f8\u00f9\7#\2\2\u00f9\u00fa\5\f\7\2\u00fa\27\3\2\2\2\u00fb\u0101"+
		"\7\f\2\2\u00fc\u00fd\5\f\7\2\u00fd\u00fe\7\33\2\2\u00fe\u0100\3\2\2\2"+
		"\u00ff\u00fc\3\2\2\2\u0100\u0103\3\2\2\2\u0101\u00ff\3\2\2\2\u0101\u0102"+
		"\3\2\2\2\u0102\u0105\3\2\2\2\u0103\u0101\3\2\2\2\u0104\u0106\5\f\7\2\u0105"+
		"\u0104\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0108\7\r"+
		"\2\2\u0108\31\3\2\2\2\u0109\u010a\7\61\2\2\u010a\33\3\2\2\2\u010b\u010c"+
		"\79\2\2\u010c\35\3\2\2\2\u010d\u011b\7\31\2\2\u010e\u0114\7\b\2\2\u010f"+
		"\u0110\5\64\33\2\u0110\u0111\7\33\2\2\u0111\u0113\3\2\2\2\u0112\u010f"+
		"\3\2\2\2\u0113\u0116\3\2\2\2\u0114\u0112\3\2\2\2\u0114\u0115\3\2\2\2\u0115"+
		"\u0118\3\2\2\2\u0116\u0114\3\2\2\2\u0117\u0119\5\64\33\2\u0118\u0117\3"+
		"\2\2\2\u0118\u0119\3\2\2\2\u0119\u011a\3\2\2\2\u011a\u011c\7\t\2\2\u011b"+
		"\u010e\3\2\2\2\u011b\u011c\3\2\2\2\u011c\u011f\3\2\2\2\u011d\u011e\7\'"+
		"\2\2\u011e\u0120\5\4\3\2\u011f\u011d\3\2\2\2\u011f\u0120\3\2\2\2\u0120"+
		"\u0121\3\2\2\2\u0121\u0122\5\f\7\2\u0122\37\3\2\2\2\u0123\u0127\7\n\2"+
		"\2\u0124\u0126\5&\24\2\u0125\u0124\3\2\2\2\u0126\u0129\3\2\2\2\u0127\u0125"+
		"\3\2\2\2\u0127\u0128\3\2\2\2\u0128\u012a\3\2\2\2\u0129\u0127\3\2\2\2\u012a"+
		"\u012b\7\13\2\2\u012b!\3\2\2\2\u012c\u012d\7\65\2\2\u012d\u012e\5\f\7"+
		"\2\u012e\u012f\7\'\2\2\u012f\u0130\5\f\7\2\u0130\u0131\7\67\2\2\u0131"+
		"\u0132\5\f\7\2\u0132#\3\2\2\2\u0133\u0134\7\'\2\2\u0134\u0135\5\n\6\2"+
		"\u0135%\3\2\2\2\u0136\u013e\5,\27\2\u0137\u013e\5(\25\2\u0138\u013e\5"+
		"*\26\2\u0139\u013b\5\f\7\2\u013a\u013c\7\34\2\2\u013b\u013a\3\2\2\2\u013b"+
		"\u013c\3\2\2\2\u013c\u013e\3\2\2\2\u013d\u0136\3\2\2\2\u013d\u0137\3\2"+
		"\2\2\u013d\u0138\3\2\2\2\u013d\u0139\3\2\2\2\u013e\'\3\2\2\2\u013f\u0140"+
		"\7\63\2\2\u0140\u0143\5\f\7\2\u0141\u0142\7\'\2\2\u0142\u0144\5&\24\2"+
		"\u0143\u0141\3\2\2\2\u0143\u0144\3\2\2\2\u0144)\3\2\2\2\u0145\u0146\7"+
		"\65\2\2\u0146\u0147\5\f\7\2\u0147\u0148\7\'\2\2\u0148\u014b\5&\24\2\u0149"+
		"\u014a\7\67\2\2\u014a\u014c\5&\24\2\u014b\u0149\3\2\2\2\u014b\u014c\3"+
		"\2\2\2\u014c+\3\2\2\2\u014d\u0151\7\n\2\2\u014e\u0150\5&\24\2\u014f\u014e"+
		"\3\2\2\2\u0150\u0153\3\2\2\2\u0151\u014f\3\2\2\2\u0151\u0152\3\2\2\2\u0152"+
		"\u0154\3\2\2\2\u0153\u0151\3\2\2\2\u0154\u0155\7\13\2\2\u0155-\3\2\2\2"+
		"\u0156\u0157\7\60\2\2\u0157\u0158\5\4\3\2\u0158\u015c\7\n\2\2\u0159\u015b"+
		"\5<\37\2\u015a\u0159\3\2\2\2\u015b\u015e\3\2\2\2\u015c\u015a\3\2\2\2\u015c"+
		"\u015d\3\2\2\2\u015d\u0162\3\2\2\2\u015e\u015c\3\2\2\2\u015f\u0161\5\60"+
		"\31\2\u0160\u015f\3\2\2\2\u0161\u0164\3\2\2\2\u0162\u0160\3\2\2\2\u0162"+
		"\u0163\3\2\2\2\u0163\u0165\3\2\2\2\u0164\u0162\3\2\2\2\u0165\u0166\7\13"+
		"\2\2\u0166/\3\2\2\2\u0167\u0168\7-\2\2\u0168\u0176\79\2\2\u0169\u016f"+
		"\7\b\2\2\u016a\u016b\5\64\33\2\u016b\u016c\7\33\2\2\u016c\u016e\3\2\2"+
		"\2\u016d\u016a\3\2\2\2\u016e\u0171\3\2\2\2\u016f\u016d\3\2\2\2\u016f\u0170"+
		"\3\2\2\2\u0170\u0173\3\2\2\2\u0171\u016f\3\2\2\2\u0172\u0174\5\64\33\2"+
		"\u0173\u0172\3\2\2\2\u0173\u0174\3\2\2\2\u0174\u0175\3\2\2\2\u0175\u0177"+
		"\7\t\2\2\u0176\u0169\3\2\2\2\u0176\u0177\3\2\2\2\u0177\u0180\3\2\2\2\u0178"+
		"\u0179\7/\2\2\u0179\u017e\5\n\6\2\u017a\u017b\7\b\2\2\u017b\u017c\5\62"+
		"\32\2\u017c\u017d\7\t\2\2\u017d\u017f\3\2\2\2\u017e\u017a\3\2\2\2\u017e"+
		"\u017f\3\2\2\2\u017f\u0181\3\2\2\2\u0180\u0178\3\2\2\2\u0180\u0181\3\2"+
		"\2\2\u0181\u018b\3\2\2\2\u0182\u0187\7\n\2\2\u0183\u0186\58\35\2\u0184"+
		"\u0186\5&\24\2\u0185\u0183\3\2\2\2\u0185\u0184\3\2\2\2\u0186\u0189\3\2"+
		"\2\2\u0187\u0185\3\2\2\2\u0187\u0188\3\2\2\2\u0188\u018a\3\2\2\2\u0189"+
		"\u0187\3\2\2\2\u018a\u018c\7\13\2\2\u018b\u0182\3\2\2\2\u018b\u018c\3"+
		"\2\2\2\u018c\61\3\2\2\2\u018d\u018e\5\f\7\2\u018e\u018f\7\33\2\2\u018f"+
		"\u0191\3\2\2\2\u0190\u018d\3\2\2\2\u0191\u0194\3\2\2\2\u0192\u0190\3\2"+
		"\2\2\u0192\u0193\3\2\2\2\u0193\u0196\3\2\2\2\u0194\u0192\3\2\2\2\u0195"+
		"\u0197\5\f\7\2\u0196\u0195\3\2\2\2\u0196\u0197\3\2\2\2\u0197\63\3\2\2"+
		"\2\u0198\u019b\79\2\2\u0199\u019a\7\'\2\2\u019a\u019c\5\4\3\2\u019b\u0199"+
		"\3\2\2\2\u019b\u019c\3\2\2\2\u019c\65\3\2\2\2\u019d\u019e\7)\2\2\u019e"+
		"\u019f\79\2\2\u019f\67\3\2\2\2\u01a0\u01a2\5\66\34\2\u01a1\u01a0\3\2\2"+
		"\2\u01a2\u01a5\3\2\2\2\u01a3\u01a1\3\2\2\2\u01a3\u01a4\3\2\2\2\u01a4\u01a6"+
		"\3\2\2\2\u01a5\u01a3\3\2\2\2\u01a6\u01a7\7+\2\2\u01a7\u01a8\79\2\2\u01a8"+
		"\u01ae\7\b\2\2\u01a9\u01aa\5\64\33\2\u01aa\u01ab\7\33\2\2\u01ab\u01ad"+
		"\3\2\2\2\u01ac\u01a9\3\2\2\2\u01ad\u01b0\3\2\2\2\u01ae\u01ac\3\2\2\2\u01ae"+
		"\u01af\3\2\2\2\u01af\u01b2\3\2\2\2\u01b0\u01ae\3\2\2\2\u01b1\u01b3\5\64"+
		"\33\2\u01b2\u01b1\3\2\2\2\u01b2\u01b3\3\2\2\2\u01b3\u01b4\3\2\2\2\u01b4"+
		"\u01b7\7\t\2\2\u01b5\u01b6\7\'\2\2\u01b6\u01b8\5\4\3\2\u01b7\u01b5\3\2"+
		"\2\2\u01b7\u01b8\3\2\2\2\u01b8\u01bc\3\2\2\2\u01b9\u01bd\5,\27\2\u01ba"+
		"\u01bb\7\35\2\2\u01bb\u01bd\5\f\7\2\u01bc\u01b9\3\2\2\2\u01bc\u01ba\3"+
		"\2\2\2\u01bd9\3\2\2\2\u01be\u01c0\7,\2\2\u01bf\u01c1\7*\2\2\u01c0\u01bf"+
		"\3\2\2\2\u01c0\u01c1\3\2\2\2\u01c1\u01c2\3\2\2\2\u01c2\u01c3\79\2\2\u01c3"+
		"\u01c4\7\64\2\2\u01c4\u01c5\79\2\2\u01c5\u01c6\3\2\2\2\u01c6\u01c9\7."+
		"\2\2\u01c7\u01ca\79\2\2\u01c8\u01ca\7:\2\2\u01c9\u01c7\3\2\2\2\u01c9\u01c8"+
		"\3\2\2\2\u01ca\u01cc\3\2\2\2\u01cb\u01cd\7\34\2\2\u01cc\u01cb\3\2\2\2"+
		"\u01cc\u01cd\3\2\2\2\u01cd;\3\2\2\2\u01ce\u01cf\7*\2\2\u01cf\u01d0\79"+
		"\2\2\u01d0\u01d1\7\35\2\2\u01d1\u01d3\5\20\t\2\u01d2\u01d4\7\34\2\2\u01d3"+
		"\u01d2\3\2\2\2\u01d3\u01d4\3\2\2\2\u01d4=\3\2\2\2\65AGNPV[cgrx\u00be\u00ce"+
		"\u00d2\u00dc\u00de\u00ec\u00f6\u0101\u0105\u0114\u0118\u011b\u011f\u0127"+
		"\u013b\u013d\u0143\u014b\u0151\u015c\u0162\u016f\u0173\u0176\u017e\u0180"+
		"\u0185\u0187\u018b\u0192\u0196\u019b\u01a3\u01ae\u01b2\u01b7\u01bc\u01c0"+
		"\u01c9\u01cc\u01d3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}