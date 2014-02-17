/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/15/14 at 11:01 AM
 */

package lib;

public class OpCodeDecoder {
    private final Memory memory;
    private final OpCodeFactory opCodeFactory;
    private int pc;

    public OpCodeDecoder(Memory memory, OpCodeFactory opCodeFactory) {
        pc = 0x200;
        this.memory = memory;
        this.opCodeFactory = opCodeFactory;
    }

    public OpCode getNext() {
        int hb = memory.get(pc);
        int lb = memory.get(pc+1);
        pc += 2;
        return opCodeFactory.getOpCode(hb << 8 | lb);
    }
}
