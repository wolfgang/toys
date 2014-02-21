/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/20/14 at 8:15 PM
 */

package lib;

import lib.OpCodes.OpCode;

public class OpCodeExecutor {
    private final MachineState machineState;
    private final OpCodeRegistry opCodeRegistry;

    public OpCodeExecutor(MachineState machineState, OpCodeRegistry opCodeRegistry) {
        this.machineState = machineState;
        this.opCodeRegistry = opCodeRegistry;
    }

    public void executeNext() throws InvalidOpCode {
        byte hb = machineState.memory.get(machineState.pc);
        byte lb = machineState.memory.get(machineState.pc + 1);
        int code = (0xFF00 & (hb << 8)) | (0x00FF & lb);
        OpCode opCode = opCodeRegistry.getOpCode(code);
        opCode.execute(machineState, code);
    }
}

