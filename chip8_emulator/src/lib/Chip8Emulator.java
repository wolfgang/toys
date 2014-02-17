/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/15/14 at 11:00 AM
 */

package lib;

import lib.OpCodes.OpCode;

public class Chip8Emulator {
    private MachineState machineState;
    private final Display display;
    private final OpCodeDecoder opCodeDecoder;

    public Chip8Emulator(MachineState machineState, Display display, OpCodeDecoder opCodeDecoder) {
        this.machineState = machineState;
        this.display = display;
        this.opCodeDecoder = opCodeDecoder;
    }

    public void tick() throws InvalidOpCode {
        OpCode opCode = opCodeDecoder.getNext(machineState.pc);
        int oldPC = machineState.pc;
        opCode.execute(machineState);
        if (machineState.pc == oldPC)
            machineState.pc += 2;
        display.draw();
    }
}
