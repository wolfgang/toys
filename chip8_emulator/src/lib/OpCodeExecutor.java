/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/20/14 at 8:15 PM
 */

package lib;

import lib.OpCodes.OpCode;

public class OpCodeExecutor {
    private final OpCodeRegistry opCodeRegistry;

    public OpCodeExecutor(OpCodeRegistry opCodeRegistry) {
        this.opCodeRegistry = opCodeRegistry;
    }

    public void executeNext(MachineState machineState) throws InvalidOpCode {
        byte hb = machineState.memory.get(machineState.pc);
        byte lb = machineState.memory.get(machineState.pc + 1);
        int code = (0xFF00 & (hb << 8)) | (0x00FF & lb);
        OpCode opCode = opCodeRegistry.getOpCode(code);
        opCode.execute(machineState, code);
    }
}

