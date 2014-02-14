/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/14/14 at 8:04 PM
 */

package unittests;

import lib.Chip8Emulator;
import lib.Screen;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class Chip8EmulatorTest {
    @Test
    public void isRunning_returns_true() throws Exception {
        Chip8Emulator emulator = new Chip8Emulator(null);
        assertTrue(emulator.isRunning());
    }


    @Test(expected = RuntimeException.class)
    public void tick_noProgramLoaded_throwException()
    {
        Chip8Emulator emulator = new Chip8Emulator(null);
        emulator.tick();
    }

    @Test
    public void tick_clearScreenOpcodeLoaded_clearScreen() throws Exception {
        Screen mockScreen = mock(Screen.class);
        Chip8Emulator emulator = new Chip8Emulator(mockScreen);
        emulator.loadProgram(new int[] {0x00E0} );
        emulator.tick();
        verify(mockScreen).clear();
    }

}
