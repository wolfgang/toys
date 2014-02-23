/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/22/14 at 2:38 PM
 */

package unittests.OpCodes;

import lib.OpCodes.OpCode9XY0;
import org.junit.Test;

// Skips the next instruction if VX doesn't equal VY.
public class OpCode9XY0Test extends OpCodeTest {
    @Test
    public void execute_skip_next_instruction() throws Exception {
        opCode = new OpCode9XY0();
        givenV(10, 0x20);
        givenV(12, 0x21);
        givenPC(0x300);
        executeOpCode(0x9AC0);
        assertPC(0x304);
    }

    @Test
    public void execute_dont_skip_next_instruction() throws Exception {
        opCode = new OpCode9XY0();
        givenV(10, 0x20);
        givenV(12, 0x20);
        givenPC(0x300);
        executeOpCode(0x9AC0);
        assertPC(0x300);
    }
}
