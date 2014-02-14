/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/14/14 at 8:04 PM
 */

package unittests;

import lib.Chip8Emulator;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;


public class Chip8EmulatorTest {
    @Test
    public void isRunning_returns_true() throws Exception {
        Chip8Emulator emulator = new Chip8Emulator(null);
        assertTrue(emulator.isRunning());
    }
}
