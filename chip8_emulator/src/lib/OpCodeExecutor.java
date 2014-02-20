/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/20/14 at 8:15 PM
 */

package lib;

import lib.OpCodes.OpCode;

public class OpCodeExecutor {
    private final MachineState machineState;
    private final OpCodeFactory opCodeFactory;

    public OpCodeExecutor(MachineState machineState, OpCodeFactory opCodeFactory) {
        this.machineState = machineState;
        this.opCodeFactory = opCodeFactory;
    }

    public void executeNext() throws InvalidOpCode {
        int hb = machineState.memory.get(machineState.pc);
        int lb = machineState.memory.get(machineState.pc + 1);
        int code = hb << 8 | lb;
        OpCode opCode = opCodeFactory.getOpCode(code);
        opCode.execute(machineState, code);
    }
}

