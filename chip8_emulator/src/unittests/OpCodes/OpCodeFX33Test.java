/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/23/14 at 4:39 PM
 */

package unittests.OpCodes;

import lib.OpCodes.OpCodeFX33;
import org.junit.Before;
import org.junit.Test;

public class OpCodeFX33Test extends OpCodeTest {
    // The interpreter takes the decimal value of Vx, and places the hundreds digit in memory at location in I,
    // the tens digit at location I+1,
    // and the ones digit at location I+2.

    @Before
    public void setUp() {
        opCode = new OpCodeFX33(memory);
        givenI(0x100);
    }

    @Test
    public void execute() throws Exception {
        givenV(5, 123);
        executeOpCode(0xF533);
        assertMemory(0x100, 1);
        assertMemory(0x101, 2);
        assertMemory(0x102, 3);
    }

    @Test
    public void execute_first_digit_0() throws Exception {
        givenV(5, 51);
        executeOpCode(0xF533);
        assertMemory(0x100, 0);
        assertMemory(0x101, 5);
        assertMemory(0x102, 1);
    }

    @Test
    public void execute_middle_digit_0() throws Exception {
        givenV(5, 207);
        executeOpCode(0xF533);
        assertMemory(0x100, 2);
        assertMemory(0x101, 0);
        assertMemory(0x102, 7);
    }

    @Test
    public void execute_last_digit_0() throws Exception {
        givenV(5, 210);
        executeOpCode(0xF533);
        assertMemory(0x100, 2);
        assertMemory(0x101, 1);
        assertMemory(0x102, 0);
    }

}
