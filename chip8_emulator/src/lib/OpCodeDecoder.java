/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/15/14 at 11:01 AM
 */

package lib;

import lib.OpCodes.OpCode;

public class OpCodeDecoder {
    private final MachineState machineState;
    private final OpCodeFactory opCodeFactory;

    public OpCodeDecoder(MachineState machineState, OpCodeFactory opCodeFactory) {
        this.machineState = machineState;
        this.opCodeFactory = opCodeFactory;
    }

    public OpCode getNext(int pc) throws InvalidOpCode {
        int hb = machineState.memory.get(pc);
        int lb = machineState.memory.get(pc+1);
        return opCodeFactory.getOpCode(hb << 8 | lb);
    }
}
