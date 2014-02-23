/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/23/14 at 5:01 PM
 */

package unittests.OpCodes;

import lib.OpCodes.OpCodeFX65;
import org.junit.Test;

public class OpCodeFX65Test extends OpCodeTest {
    // Fills V0 to VX with values from memory starting at address I.
    @Test
    public void execute() throws Exception {
        opCode = new OpCodeFX65(memory);
        givenI(0x100);
        givenV(0, 0);
        givenV(1, 0);
        givenV(2, 0);
        givenMemory(0x100, 0x10);
        givenMemory(0x101, 0x20);
        givenMemory(0x102, 0x30);

        executeOpCode(0xF265);

        assertV(0, 0x10);
        assertV(1, 0x20);
        assertV(2, 0x30);
    }

}
