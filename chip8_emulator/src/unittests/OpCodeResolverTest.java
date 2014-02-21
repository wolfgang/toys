/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/21/14 at 10:15 AM
 */

package unittests;

import lib.OpCodeIds;
import lib.OpCodeResolver;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class OpCodeResolverTest {

    private OpCodeResolver opCodeResolver;

    @Before
    public void setUp() throws Exception {
        opCodeResolver = new OpCodeResolver();
    }

    @Test
    public void resolve_0x00E0() throws Exception {
        verifyResolution(0x00E0, OpCodeIds.OP_00E0);
    }

    @Test
    public void resolve_DXYN() throws Exception {
        verifyResolution(0xD123, OpCodeIds.OP_DXYN);
        verifyResolution(0xD456, OpCodeIds.OP_DXYN);
    }

    @Test
    public void resolve_1NNN() throws Exception {
        verifyResolution(0x1600, OpCodeIds.OP_1NNN);
        verifyResolution(0x1700, OpCodeIds.OP_1NNN);
    }

    private void verifyResolution(int code, int id) {
        assertThat(opCodeResolver.getOpCodeId(code), is(id));
    }
}
