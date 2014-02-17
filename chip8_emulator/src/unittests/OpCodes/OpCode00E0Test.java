/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/17/14 at 5:04 PM
 */

package unittests.OpCodes;

import lib.OpCodes.OpCode00E0;
import lib.Display;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class OpCode00E0Test {
    @Test
    public void execute_clearsTheScreen() throws Exception {
        Display display = mock(Display.class);
        OpCode00E0 opCode = new OpCode00E0(display);
        opCode.execute(null);
        verify(display).clear();
    }
}
