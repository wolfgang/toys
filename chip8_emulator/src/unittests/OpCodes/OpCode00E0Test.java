/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/17/14 at 5:04 PM
 */

package unittests.OpCodes;

import lib.Display;
import lib.OpCodes.OpCode00E0;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class OpCode00E0Test extends OpCodeTest{

    private Display display;

    @Before
    public void setUp() throws Exception {
        display = mock(Display.class);
        opCode = new OpCode00E0(display);
    }

    @Test
    public void execute_clearsTheScreen() throws Exception {
        opCode.execute(machineState, 0);
        verify(display).clear();
    }
}
