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

    public OpCode create(OpCodeId opCodeId) {
        switch (opCodeId) {
            case OP_00E0:
                return new OpCode00E0(display);
            case OP_DXYN:
                return new OpCodeDXYN(display, memory);
            case OP_1NNN:
                return new OpCode1NNN();
            case OP_00EE:
                return new OpCode00EE();
            case OP_2NNN:
                return new OpCode2NNN();
            case OP_3XNN:
                return new OpCode3XNN();
            case OP_4XNN:
                return new OpCode4XNN();
            case OP_5XY0:
                return new OpCode5XY0();
            case OP_6XNN:
                return new OpCode6XNN();
            case OP_7XNN:
                return new OpCode7XNN();

            default:
                throw new InvalidOpCodeId();
        }
    }
}
