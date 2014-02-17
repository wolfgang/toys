/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/17/14 at 4:46 PM
 */

package unittests;

import lib.Chip8Emulator;
import lib.OpCode;
import lib.OpCodeDecoder;
import lib.Screen;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;

public class Chip8EmulatorTest {

    private Screen screen;
    private OpCodeDecoder opCodeDecoder;
    private OpCode opCode;
    private Chip8Emulator emulator;
    private InOrder order;

    @Before
    public void setUp() throws Exception {
        screen = mock(Screen.class);
        opCodeDecoder = mock(OpCodeDecoder.class);
        opCode = mock(OpCode.class);
        emulator = new Chip8Emulator(screen, opCodeDecoder);
        order = inOrder(opCode, screen);
    }

    @Test
    public void tick_processNextOpcodeAndDrawScreen() throws Exception {
        when(opCodeDecoder.getNext()).thenReturn(opCode);
        emulator.tick();
        order.verify(opCode).execute();
        order.verify(screen).draw();
    }
}
