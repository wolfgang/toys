/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/22/14 at 2:21 PM
 */

package unittests.OpCodes;

import lib.OpCodes.OpCode8XYE;
import org.junit.Test;

// Shifts VX left by one. VF is set to the value of the most significant bit of VX before the shift
public class OpCode8XYETest extends OpCodeTest {
    @Test
    public void execute_msb_1() throws Exception {
        opCode = new OpCode8XYE();
        givenV(10, 0xF000);
        givenVF(0);
        executeOpCode(0x8A0E);
        assertVX(10, 2*0xF000);
        assertVF(1);
    }

    @Test
    public void execute_msb_0() throws Exception {
        opCode = new OpCode8XYE();
        givenV(10, 0x1000);
        givenVF(0);
        executeOpCode(0x8A0E);
        assertVX(10, 0x2000);
        assertVF(0);
    }

}
