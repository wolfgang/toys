/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/21/14 at 10:15 AM
 */

package unittests;

import lib.OpCodeId;
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
        verifyResolution(0x00E0, OpCodeId.OP_00E0);
    }

    @Test
    public void resolve_DXYN() throws Exception {
        verifyResolution(0xD123, OpCodeId.OP_DXYN);
        verifyResolution(0xD456, OpCodeId.OP_DXYN);
    }

    @Test
    public void resolve_1NNN() throws Exception {
        verifyResolution(0x1600, OpCodeId.OP_1NNN);
        verifyResolution(0x1700, OpCodeId.OP_1NNN);
    }

    @Test
    public void resolve_0x00EE() throws Exception {
        verifyResolution(0x00EE, OpCodeId.OP_00EE);
    }

    @Test
    public void resolve_2NNN() throws Exception {
        verifyResolution(0x2600, OpCodeId.OP_2NNN);
        verifyResolution(0x2700, OpCodeId.OP_2NNN);
    }

    @Test
    public void resolve_3XNN() throws Exception {
        verifyResolution(0x3520, OpCodeId.OP_3XNN);
        verifyResolution(0x3630, OpCodeId.OP_3XNN);
    }

    @Test
    public void resolve_4XNN() throws Exception {
        verifyResolution(0x4520, OpCodeId.OP_4XNN);
        verifyResolution(0x4630, OpCodeId.OP_4XNN);
    }

    @Test
    public void resolve_5XY0() throws Exception {
        verifyResolution(0x5520, OpCodeId.OP_5XY0);
        verifyResolution(0x5630, OpCodeId.OP_5XY0);
    }


    @Test
    public void invalidCodeResultsInInvalidId() throws Exception {
        verifyResolution(0x0000, OpCodeId.OP_INVALID);
    }

    private void verifyResolution(int code, OpCodeId id) {
        assertThat(opCodeResolver.getOpCodeId(code), is(id));
    }
}
