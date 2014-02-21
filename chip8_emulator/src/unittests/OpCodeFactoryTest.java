/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/21/14 at 11:06 AM
 */

package unittests;

import lib.Display;
import lib.Memory;
import lib.OpCodeFactory;
import lib.OpCodeId;
import lib.OpCodes.*;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class OpCodeFactoryTest {

    private OpCodeFactory opCodeFactory;
    private Display display;
    private Memory memory;

    @Before
    public void setUp() throws Exception {
        display = mock(Display.class);
        memory = mock(Memory.class);
        opCodeFactory = new OpCodeFactory(display, memory);
    }

    @Test
    public void create_00E0() throws Exception {
        OpCode00E0 opCode = verifyCreation(OpCodeId.OP_00E0, OpCode00E0.class);
        assertThat(opCode.getDisplay(), is(display));
    }

    @Test
    public void create_DXYN() throws Exception {
        OpCodeDXYN opCode = verifyCreation(OpCodeId.OP_DXYN, OpCodeDXYN.class);
        assertThat(opCode.getDisplay(), is(display));
        assertThat(opCode.getMemory(), is(memory));
    }

    @Test
    public void create_1NNN() throws Exception {
        verifyCreation(OpCodeId.OP_1NNN, OpCode1NNN.class);
    }

    @Test
    public void create_00EE() throws Exception {
        verifyCreation(OpCodeId.OP_00EE, OpCode00EE.class);
    }

    @Test
    public void create_2NNN() throws Exception {
        verifyCreation(OpCodeId.OP_2NNN, OpCode2NNN.class);
    }

    @Test
    public void create_3XNN() throws Exception {
        verifyCreation(OpCodeId.OP_3XNN, OpCode3XNN.class);
    }

    @Test
    public void create_4XNN() throws Exception {
        verifyCreation(OpCodeId.OP_4XNN, OpCode4XNN.class);
    }

    @Test
    public void create_5XY0() throws Exception {
        verifyCreation(OpCodeId.OP_5XY0, OpCode5XY0.class);
    }

    @Test
    public void create_6XNN() throws Exception {
        verifyCreation(OpCodeId.OP_6XNN, OpCode6XNN.class);
    }

    @SuppressWarnings("unchecked")
    private <T extends OpCode> T verifyCreation(OpCodeId id, Class cls) {
        OpCode opCode = opCodeFactory.create(id);
        assertThat(opCode, instanceOf(cls));
        return (T)opCode;
    }

}
