/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/21/14 at 5:13 PM
 */

package unittests;

import lib.OpCodeFactory;
import lib.OpCodeIds;
import lib.OpCodeRegistry;
import lib.OpCodeRegistryInitializer;
import lib.OpCodes.OpCode;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class OpCodeRegistryInitializerTest {

    private OpCodeRegistry opCodeRegistry;
    private OpCodeFactory opCodeFactory;
    private OpCodeRegistryInitializer initializer;
    private OpCode opCode00E0;
    private OpCode opCode00EE;
    private OpCode opCodeDXYN;
    private OpCode opCode1NNN;

    @Before
    public void setUp() throws Exception {
        opCodeRegistry = mock(OpCodeRegistry.class);
        opCodeFactory = mock(OpCodeFactory.class);
        initializer = new OpCodeRegistryInitializer(opCodeRegistry, opCodeFactory);
        opCode00E0 = mock(OpCode.class, "OpCode00E0");
        opCode00EE = mock(OpCode.class, "OpCode00EE");
        opCodeDXYN = mock(OpCode.class, "OpCodeDXYN");
        opCode1NNN = mock(OpCode.class, "OpCode1NNN");
    }

    @Test
    public void registerKnownOPpCodes() throws Exception {
        factoryCreates(OpCodeIds.OP_00E0, opCode00E0);
        factoryCreates(OpCodeIds.OP_00EE, opCode00EE);
        factoryCreates(OpCodeIds.OP_DXYN, opCodeDXYN);
        factoryCreates(OpCodeIds.OP_1NNN, opCode1NNN);

        initializer.registerKnownOpCodes();

        registryRegisters(OpCodeIds.OP_00E0, opCode00E0);
        registryRegisters(OpCodeIds.OP_00EE, opCode00EE);
        registryRegisters(OpCodeIds.OP_DXYN, opCodeDXYN);
        registryRegisters(OpCodeIds.OP_1NNN, opCode1NNN);
    }

    private void registryRegisters(int id, OpCode opCode) {
        verify(opCodeRegistry).registerOpCode(id, opCode);
    }

    private void factoryCreates(int id, OpCode opCode) {
        when(opCodeFactory.create(id)).thenReturn(opCode);
    }
}
