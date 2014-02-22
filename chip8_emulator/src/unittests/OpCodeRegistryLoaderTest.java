/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/21/14 at 5:13 PM
 */

package unittests;

import lib.OpCodeFactory;
import lib.OpCodeId;
import lib.OpCodeRegistry;
import lib.OpCodeRegistryLoader;
import lib.OpCodes.OpCode;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class OpCodeRegistryLoaderTest {

    private OpCodeRegistry opCodeRegistry;
    private OpCodeFactory opCodeFactory;
    private OpCodeRegistryLoader initializer;
    private OpCode opCode00E0;
    private OpCode opCode00EE;
    private OpCode opCodeDXYN;
    private OpCode opCode1NNN;

    @Before
    public void setUp() throws Exception {
        opCodeRegistry = mock(OpCodeRegistry.class);
        opCodeFactory = mock(OpCodeFactory.class);
        initializer = new OpCodeRegistryLoader(opCodeRegistry, opCodeFactory, null, null);
        opCode00E0 = mock(OpCode.class, "OpCode00E0");
        opCode00EE = mock(OpCode.class, "OpCode00EE");
        opCodeDXYN = mock(OpCode.class, "OpCodeDXYN");
        opCode1NNN = mock(OpCode.class, "OpCode1NNN");
    }

    @Test
    public void registerKnownOPpCodes() throws Exception {
        factoryCreates(OpCodeId.OP_00E0, opCode00E0);
        factoryCreates(OpCodeId.OP_00EE, opCode00EE);
        factoryCreates(OpCodeId.OP_DXYN, opCodeDXYN);
        factoryCreates(OpCodeId.OP_1NNN, opCode1NNN);

        initializer.registerKnownOpCodes();

        registryRegisters(OpCodeId.OP_00E0, opCode00E0);
        registryRegisters(OpCodeId.OP_00EE, opCode00EE);
        registryRegisters(OpCodeId.OP_DXYN, opCodeDXYN);
        registryRegisters(OpCodeId.OP_1NNN, opCode1NNN);
    }

    private void registryRegisters(OpCodeId id, OpCode opCode) {
        verify(opCodeRegistry).registerOpCode(id, opCode);
    }

    private void factoryCreates(OpCodeId id, OpCode opCode) {
        when(opCodeFactory.create(id)).thenReturn(opCode);
    }
}