/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/15/14 at 11:00 AM
 */

package lib;

public class Chip8Emulator {
    private MachineState machineState;
    private final OpCodeExecutor opCodeExecutor;

    public Chip8Emulator(MachineState machineState, OpCodeExecutor opCodeExecutor) {
        this.machineState = machineState;
        this.opCodeExecutor = opCodeExecutor;
    }

    public void tick() throws InvalidOpCode {
        int oldPC = machineState.pc;
        opCodeExecutor.executeNext();
        if (machineState.pc == oldPC)
            machineState.pc += 2;

        if (machineState.V[15]==1)
            machineState.pixelBuffer.draw();
    }
}
