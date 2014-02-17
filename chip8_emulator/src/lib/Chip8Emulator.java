/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/15/14 at 11:00 AM
 */

package lib;

public class Chip8Emulator {
    private MachineState machineState;
    private final Screen screen;
    private final OpCodeDecoder opCodeDecoder;

    public Chip8Emulator(MachineState machineState, Screen screen, OpCodeDecoder opCodeDecoder) {
        this.machineState = machineState;
        this.screen = screen;
        this.opCodeDecoder = opCodeDecoder;
    }

    public void tick() throws InvalidOpCode {
        OpCode opCode = opCodeDecoder.getNext();
        int oldPC = machineState.pc;
        opCode.execute(machineState);
        if (machineState.pc == oldPC)
            machineState.pc += 2;
        screen.draw();
    }
}
