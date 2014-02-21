/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/21/14 at 11:07 AM
 */

package lib;

import lib.OpCodes.*;

public class OpCodeFactory {
    private Display display;
    private final Memory memory;

    public OpCodeFactory(Display display, Memory memory) {
        this.display = display;
        this.memory = memory;
    }

    public OpCodeFactory() {
        this(null, null);
    }


    public OpCode create(int opCodeId) {
        switch (opCodeId) {
            case OpCodeIds.OP_00E0:
                return new OpCode00E0(display);
            case OpCodeIds.OP_DXYN:
                return new OpCodeDXYN(display, memory);
            case OpCodeIds.OP_1NNN:
                return new OpCode1NNN();
            case OpCodeIds.OP_00EE:
                return new OpCode00EE();
            default:
                throw new InvalidOpCodeId();
        }
    }
}
