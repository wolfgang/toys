/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/21/14 at 4:55 PM
 */

package unittests;

import lib.InvalidOpCode;
import lib.OpCodeRegistry;
import lib.OpCodeResolver;
import lib.OpCodes.OpCode;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OpCodeRegistryRegisterOpCodesTest {

    private OpCodeResolver opCodeResolver;
    private OpCodeRegistry opCodeRegistry;

    @Before
    public void setUp() throws Exception {
        opCodeResolver = mock(OpCodeResolver.class);
        opCodeRegistry = new OpCodeRegistry(opCodeResolver);
    }

    @Test
    public void registerOpCode() throws Exception {

        OpCode opCode1 = mock(OpCode.class, "OpCode 1");
        OpCode opCode2 = mock(OpCode.class, "OpCode 2");

        opCodeRegistry.registerOpCode2(0x1000, opCode1);
        opCodeRegistry.registerOpCode2(0x2000, opCode2);

        when(opCodeResolver.getOpCodeId2(0x1111)).thenReturn(0x1000);
        when(opCodeResolver.getOpCodeId2(0x2222)).thenReturn(0x2000);

        assertThat(opCodeRegistry.getOpCode2(0x1111), is(opCode1));
        assertThat(opCodeRegistry.getOpCode2(0x2222), is(opCode2));
    }

    @Test(expected = InvalidOpCode.class)
    public void invalidOpCodeFromResolverThrowsException() throws Exception {
        when(opCodeResolver.getOpCodeId2(1111)).thenReturn(-1);
        opCodeRegistry.getOpCode2(1111);
    }

}
