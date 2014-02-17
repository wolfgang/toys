/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/17/14 at 6:03 PM
 */

package unittests;

import lib.*;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class OpCodeFactoryTest {

    private OpCodeFactory opCodeFactory;
    private Screen screen;

    @Before
    public void setUp() throws Exception {
        screen = mock(Screen.class);
        opCodeFactory = new OpCodeFactory(screen);
    }

    @Test
    public void getOpCode_1NNN_600() throws Exception {
        OpCode opCode = opCodeFactory.getOpCode(0x1600);
        assertIs1NNN(opCode, 0x600);
    }

    @Test
    public void getOpCode_1NNN_700() throws Exception {
        OpCode opCode = opCodeFactory.getOpCode(0x1700);
        assertIs1NNN(opCode, 0x700);
    }

    @Test
    public void getOpCode_00E0() throws Exception {
        OpCode opCode = opCodeFactory.getOpCode(0x00E0);
        assertIs00E0(opCode);
    }

    private void assertIs1NNN(OpCode opCode, int destination) {
        assertThat(opCode, instanceOf(OpCode1NNN.class));
        assertThat(((OpCode1NNN)opCode).getDestination(), is(destination));
    }

    private void assertIs00E0(OpCode opCode) {
        assertThat(opCode, instanceOf(OpCode00E0.class));
        assertThat(((OpCode00E0)opCode).getScreen(), is(screen));
    }
}
