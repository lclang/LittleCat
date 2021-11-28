package lclang.exceptions;

public class LCLangLexerException extends Exception {
    public LCLangLexerException(String name, String message, String file, int line) {
        super(name+": "+message+" in "+file+":"+line);
    }
}
