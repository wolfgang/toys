/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/20/14 at 8:15 PM
 */

package lib;

import lib.OpCodes.OpCode;

public class OpCodeExecutor {
    private final OpCodeRegistry opCodeRegistry;
    private Memory memory;

    public OpCodeExecutor(OpCodeRegistry opCodeRegistry, Memory memory) {
        this.opCodeRegistry = opCodeRegistry;
        this.memory = memory;
    }

    public void executeNext(MachineState machineState) throws InvalidOpCode {
        byte hb = memory.get(machineState.pc);
        byte lb = memory.get(machineState.pc + 1);
        int code = (0xFF00 & (hb << 8)) | (0x00FF & lb);
        OpCode opCode = opCodeRegistry.getOpCode2(code);
        opCode.execute(machineState, code);
    }
}

