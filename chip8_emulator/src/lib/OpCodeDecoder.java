/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/15/14 at 11:01 AM
 */

package lib;

public class OpCodeDecoder {
    private final Memory memory;
    private final OpCodeFactory opCodeFactory;
    private MachineState machineState;

    public OpCodeDecoder(MachineState machineState, Memory memory, OpCodeFactory opCodeFactory) {
        this.machineState = machineState;
        this.memory = memory;
        this.opCodeFactory = opCodeFactory;
    }

    public OpCode getNext() throws InvalidOpCode {
        int hb = memory.get(machineState.pc);
        int lb = memory.get(machineState.pc+1);
        return opCodeFactory.getOpCode(hb << 8 | lb);
    }
}
