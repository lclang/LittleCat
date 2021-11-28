package lclang.libs;

import lclang.types.Types;

public class TestLibrary extends Library {
    public final StringBuilder output;

    public TestLibrary(StringBuilder output) {
        super("test");
        this.output = output;
        globals.put("print", voidMethod((caller, args) ->
                output.append(args.get(0).toString(caller)), Types.ANY).asValue());
        globals.put("println", voidMethod((caller, args) ->
                output.append(args.get(0).toString(caller)).append("\r\n"), Types.ANY).asValue());
    }
}
