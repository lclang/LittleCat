package postvm.exceptions;

public class LCLangLexerException extends RuntimeException {
    public LCLangLexerException(String name, String message, String file, int line) {
        super(name+": "+message+" in "+file+":"+line);
    }
}
