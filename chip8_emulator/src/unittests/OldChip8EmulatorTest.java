/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/14/14 at 8:04 PM
 */

package unittests;

import lib.OldChip8Emulator;
import lib.Screen;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class OldChip8EmulatorTest {
    @Test
    public void isRunning_returns_true() throws Exception {
        OldChip8Emulator emulator = new OldChip8Emulator(null);
        assertTrue(emulator.isRunning());
    }


    @Test(expected = RuntimeException.class)
    public void tick_noProgramLoaded_throwException()
    {
        OldChip8Emulator emulator = new OldChip8Emulator(null);
        emulator.tick();
    }

    @Test
    public void tick_clearScreenOpcodeLoaded_clearScreen() throws Exception {
        Screen mockScreen = mock(Screen.class);
        OldChip8Emulator emulator = new OldChip8Emulator(mockScreen);
        emulator.loadProgram(new int[] {0x00E0} );
        emulator.tick();
        verify(mockScreen).clear();
    }

}
