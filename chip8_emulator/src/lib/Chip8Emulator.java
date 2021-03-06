/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/15/14 at 11:00 AM
 */

package lib;

public class Chip8Emulator {
    private MachineState machineState;
    private final OpCodeExecutor opCodeExecutor;
    private Display display;

    public Chip8Emulator(MachineState machineState, OpCodeExecutor opCodeExecutor, Display display) {
        this.machineState = machineState;
        this.opCodeExecutor = opCodeExecutor;
        this.display = display;
    }

    public void tick() throws InvalidOpCode {
        int oldPC = machineState.pc;
        opCodeExecutor.executeNext(machineState);
        if (!machineState.wait && machineState.pc == oldPC)
            machineState.pc += 2;

        if (machineState.draw)
        {
            display.draw();
            machineState.draw = false;
        }

    }
}
