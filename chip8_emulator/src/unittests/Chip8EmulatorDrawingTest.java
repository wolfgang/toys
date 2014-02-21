/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/20/14 at 7:34 PM
 */

package unittests;

import lib.Chip8Emulator;
import lib.MachineState;
import lib.OpCodeExecutor;
import lib.Display;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class Chip8EmulatorDrawingTest {

    private MachineState machineState;
    private Chip8Emulator emulator;
    private Display display;

    @Before
    public void setUp() throws Exception {
        display = mock(Display.class);
        machineState = new MachineState();
        OpCodeExecutor opCodeExecutor = mock(OpCodeExecutor.class);
        emulator = new Chip8Emulator(machineState, opCodeExecutor, display);
    }

    @Test
    public void drawIfVFIsSet() throws Exception {
        machineState.V[15] = 1;
        emulator.tick();
        verify(display).draw();
    }

    @Test
    public void dontDrawIfVFIsNotSet() throws Exception {
        machineState.V[15] = 0;
        emulator.tick();
        verify(display, never()).draw();
    }

}
