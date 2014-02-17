/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/15/14 at 11:01 AM
 */

package lib;

import lib.OpCodes.OpCode;

public class OpCodeDecoder {
    private final Memory memory;
    private final OpCodeFactory opCodeFactory;

    public OpCodeDecoder(Memory memory, OpCodeFactory opCodeFactory) {
        this.memory = memory;
        this.opCodeFactory = opCodeFactory;
    }

    public OpCode getNext(int pc) throws InvalidOpCode {
        int hb = memory.get(pc);
        int lb = memory.get(pc+1);
        return opCodeFactory.getOpCode(hb << 8 | lb);
    }
}
