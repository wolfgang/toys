/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/21/14 at 5:13 PM
 */

package unittests;

import lib.OpCodes.OpCodeFX65;
import lib.*;
import lib.OpCodes.*;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;

public class OpCodeRegistryLoaderTest {

    private OpCodeRegistry opCodeRegistry;
    private Display display;
    private Memory memory;

    @Before
    public void setUp() throws Exception {
        opCodeRegistry = new OpCodeRegistry(new OpCodeResolver());
        display = mock(Display.class);
        memory = mock(Memory.class);
        OpCodeRegistryLoader loader = new OpCodeRegistryLoader(opCodeRegistry, memory, display);
        loader.registerKnownOpCodes();
    }

    @Test
    public void registersOpCode00E0() throws Exception {
        OpCode00E0 opCode = registersOpCode(0x00E0, OpCode00E0.class);
        assertThat(opCode.getDisplay(), is(display));
    }

    @Test
    public void registersOpCodeDXYN() throws Exception {
        OpCodeDXYN opCode = registersOpCode(0xD000, OpCodeDXYN.class);
        assertThat(opCode.getDisplay(), is(display));
        assertThat(opCode.getMemory(), is(memory));
    }

    @Test
    public void registersOpCodeFX33() throws Exception {
        OpCodeFX33 opCode = registersOpCode(0xF033, OpCodeFX33.class);
        assertThat(opCode.getMemory(), is(memory));
    }

    @Test
    public void registersOpCodeFX55() throws Exception {
        OpCodeFX55 opCode = registersOpCode(0xF055, OpCodeFX55.class);
        assertThat(opCode.getMemory(), is(memory));
    }

    @Test
    public void registersOpCodeFX65() throws Exception {
        OpCodeFX65 opCode = registersOpCode(0xF065, OpCodeFX65.class);
        assertThat(opCode.getMemory(), is(memory));
    }

    @Test
    public void registersSimpleOpCodes() throws Exception {
        registersOpCode(0x00EE, OpCode00EE.class);
        registersOpCode(0x1000, OpCode1NNN.class);
        registersOpCode(0x2000, OpCode2NNN.class);
        registersOpCode(0x3000, OpCode3XNN.class);
        registersOpCode(0x4000, OpCode4XNN.class);
        registersOpCode(0x5000, OpCode5XY0.class);
        registersOpCode(0x6000, OpCode6XNN.class);
        registersOpCode(0x7000, OpCode7XNN.class);
        registersOpCode(0x8000, OpCode8XY0.class);
        registersOpCode(0x8001, OpCode8XY1.class);
        registersOpCode(0x8002, OpCode8XY2.class);
        registersOpCode(0x8003, OpCode8XY3.class);
        registersOpCode(0x8004, OpCode8XY4.class);
        registersOpCode(0x8005, OpCode8XY5.class);
        registersOpCode(0x8006, OpCode8XY6.class);
        registersOpCode(0x8007, OpCode8XY7.class);
        registersOpCode(0x800E, OpCode8XYE.class);
        registersOpCode(0x9000, OpCode9XY0.class);
        registersOpCode(0xA000, OpCodeANNN.class);
        registersOpCode(0xB000, OpCodeBNNN.class);
        registersOpCode(0xC000, OpCodeCXNN.class);
        registersOpCode(0xE09E, OpCodeEX9E.class);
        registersOpCode(0xE0A1, OpCodeEXA1.class);
        registersOpCode(0xF007, OpCodeFX07.class);
        registersOpCode(0xF015, OpCodeFX15.class);
        registersOpCode(0xF018, OpCodeFX18.class);
        registersOpCode(0xF01E, OpCodeFX1E.class);
        registersOpCode(0xF029, OpCodeFX29.class);
        registersOpCode(0xF00A, OpCodeFX0A.class);
    }

    @SuppressWarnings("unchecked")
    private <T extends OpCode> T registersOpCode(int code, Class<T> cls) throws InvalidOpCode {
        OpCode opCode = opCodeRegistry.getOpCode(code);
        assertThat(opCode, instanceOf(cls));
        return (T) opCode;
    }
}

