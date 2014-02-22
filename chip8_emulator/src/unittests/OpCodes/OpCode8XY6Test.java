/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/22/14 at 2:04 PM
 */

package unittests.OpCodes;

import lib.OpCodes.OpCode8XY6;
import org.junit.Before;
import org.junit.Test;

//Shifts VX right by one. VF is set to the value of the least significant bit of VX before the shift

public class OpCode8XY6Test extends OpCodeTest {
    @Before
    public void createOpCode() {
        opCode = new OpCode8XY6();
    }

    @Test
    public void execute_lsb_is_1() throws Exception {
        givenVX(10, 0b1011);
        givenVF(0);
        executeOpCode(0x8A06);
        assertVX(10, 0b0101);
        assertVF(1);
    }

    @Test
    public void execute_lsb_is_0() throws Exception {
        givenVX(10, 0b1110);
        givenVF(1);
        executeOpCode(0x8A06);
        assertVX(10, 0b0111);
        assertVF(0);
    }
}
