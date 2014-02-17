/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/17/14 at 5:04 PM
 */

package unittests;

import lib.OpCode00E0;
import lib.Screen;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class OpCode00E0Test {
    @Test
    public void execute_clearsTheScreen() throws Exception {
        Screen screen = mock(Screen.class);
        OpCode00E0 opCode = new OpCode00E0(screen);
        opCode.execute();
        verify(screen).clear();
    }
}
