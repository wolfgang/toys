/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/23/14 at 4:54 PM
 */

package unittests.OpCodes;

import lib.OpCodes.OpCodeFX55;
import org.junit.Test;

public class OpCodeFX55Test extends OpCodeTest {
    // Stores V0 to VX in memory starting at address I.
    @Test
    public void execute() throws Exception {
        opCode = new OpCodeFX55(memory);
        givenI(0x100);
        givenV(0, 0x10);
        givenV(1, 0x20);
        givenV(2, 0x30);
        executeOpCode(0xF255);

        assertMemory(0x100, 0x10);
        assertMemory(0x101, 0x20);
        assertMemory(0x102, 0x30);
    }
}
