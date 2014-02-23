/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/20/14 at 7:34 PM
 */

package unittests;

import lib.Chip8Emulator;
import lib.Display;
import lib.MachineState;
import lib.OpCodeExecutor;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
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
    public void drawIfMachineStateDrawIsTrue_thenSetItToFalse() throws Exception {
        machineState.draw = true;
        emulator.tick();
        verify(display).draw();
        assertFalse(machineState.draw);
    }

    @Test
    public void dontDrawIfMachineStateDrawIsFalse() throws Exception {
        machineState.draw = false;
        emulator.tick();
        verify(display, never()).draw();
    }

}
