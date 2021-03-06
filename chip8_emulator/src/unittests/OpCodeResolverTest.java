/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/21/14 at 10:15 AM
 */

package unittests;

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
        verifyResolution(0x00E0, 0x00E0);
    }

    @Test
    public void resolve_DXYN() throws Exception {
        verifyResolution(0xD123, 0xD000);
        verifyResolution(0xD456, 0xD000);
    }

    @Test
    public void resolve_1NNN() throws Exception {
        verifyResolution(0x1600, 0x1000);
        verifyResolution(0x1700, 0x1000);
    }

    @Test
    public void resolve_0x00EE() throws Exception {
        verifyResolution(0x00EE, 0x00EE);
    }

    @Test
    public void resolve_2NNN() throws Exception {
        verifyResolution(0x2600, 0x2000);
        verifyResolution(0x2700, 0x2000);
    }

    @Test
    public void resolve_3XNN() throws Exception {
        verifyResolution(0x3520, 0x3000);
        verifyResolution(0x3630, 0x3000);
    }

    @Test
    public void resolve_4XNN() throws Exception {
        verifyResolution(0x4520, 0x4000);
        verifyResolution(0x4630, 0x4000);
    }

    @Test
    public void resolve_5XY0() throws Exception {
        verifyResolution(0x5520, 0x5000);
        verifyResolution(0x5630, 0x5000);
    }

    @Test
    public void resolve_6XNN() throws Exception {
        verifyResolution(0x6520, 0x6000);
        verifyResolution(0x6630, 0x6000);
    }

    @Test
    public void resolve_7XNN() throws Exception {
        verifyResolution(0x7520, 0x7000);
        verifyResolution(0x7630, 0x7000);
    }

    @Test
    public void resolve_8XY0() throws Exception {
        verifyResolution(0x8520, 0x8000);
        verifyResolution(0x8630, 0x8000);
    }

    @Test
    public void resolve_8XY1() throws Exception {
        verifyResolution(0x8521, 0x8001);
        verifyResolution(0x8631, 0x8001);
    }

    @Test
    public void resolve_8XY2() throws Exception {
        verifyResolution(0x8522, 0x8002);
        verifyResolution(0x8632, 0x8002);
    }

    @Test
    public void resolve_8XY3() throws Exception {
        verifyResolution(0x8523, 0x8003);
        verifyResolution(0x8633, 0x8003);
    }

    @Test
    public void resolve_8XY4() throws Exception {
        verifyResolution(0x8524, 0x8004);
        verifyResolution(0x8634, 0x8004);
    }

    @Test
    public void resolve_8XY5() throws Exception {
        verifyResolution(0x8525, 0x8005);
        verifyResolution(0x8635, 0x8005);
    }

    @Test
    public void resolve_8XY6() throws Exception {
        verifyResolution(0x8526, 0x8006);
        verifyResolution(0x8636, 0x8006);
    }

    @Test
    public void resolve_8XY7() throws Exception {
        verifyResolution(0x8527, 0x8007);
        verifyResolution(0x8637, 0x8007);
    }

    @Test
    public void resolve_8XYE() throws Exception {
        verifyResolution(0x852E, 0x800E);
        verifyResolution(0x863E, 0x800E);
    }

    @Test
    public void resolve_9XY0() throws Exception {
        verifyResolution(0x9520, 0x9000);
        verifyResolution(0x9630, 0x9000);
    }

    @Test
    public void resolve_ANNN() throws Exception {
        verifyResolution(0xA520, 0xA000);
        verifyResolution(0xA630, 0xA000);
    }

    @Test
    public void resolve_BNNN() throws Exception {
        verifyResolution(0xB520, 0xB000);
        verifyResolution(0xB630, 0xB000);
    }

    @Test
    public void resolve_CNNN() throws Exception {
        verifyResolution(0xC521, 0xC000);
        verifyResolution(0xC632, 0xC000);
    }

    @Test
    public void resolve_EX9E() throws Exception {
        verifyResolution(0xE29E, 0xE09E);
        verifyResolution(0xE49E, 0xE09E);
    }

    @Test
    public void resolve_EXA1() throws Exception {
        verifyResolution(0xE2A1, 0xE0A1);
        verifyResolution(0xE4A1, 0xE0A1);
    }


    @Test
    public void resolve_FX07() throws Exception {
        verifyResolution(0xF207, 0xF007);
        verifyResolution(0xF307, 0xF007);
    }

    @Test
    public void resolve_FX15() throws Exception {
        verifyResolution(0xF215, 0xF015);
        verifyResolution(0xF315, 0xF015);
    }

    @Test
    public void resolve_FX18() throws Exception {
        verifyResolution(0xF218, 0xF018);
        verifyResolution(0xF318, 0xF018);
    }

    @Test
    public void resolve_FX1E() throws Exception {
        verifyResolution(0xF21E, 0xF01E);
        verifyResolution(0xF31E, 0xF01E);
    }

    @Test
    public void resolve_FX29() throws Exception {
        verifyResolution(0xF229, 0xF029);
        verifyResolution(0xF329, 0xF029);
    }

    @Test
    public void resolve_FX33() throws Exception {
        verifyResolution(0xF233, 0xF033);
        verifyResolution(0xF333, 0xF033);
    }

    @Test
    public void resolve_FX55() throws Exception {
        verifyResolution(0xF255, 0xF055);
        verifyResolution(0xF355, 0xF055);
    }

    @Test
    public void resolve_FX65() throws Exception {
        verifyResolution(0xF265, 0xF065);
        verifyResolution(0xF365, 0xF065);
    }

    @Test
    public void resolve_F4XA() throws Exception {
        verifyResolution(0xF40A, 0xF00A);
        verifyResolution(0xF40A, 0xF00A);
    }


    @Test
    public void invalidCodeResultsInMinusOne() throws Exception {
        verifyResolution(0x0000, -1);
    }

    private void verifyResolution(int code, int id) {
        assertThat(opCodeResolver.getOpCodeId(code), is(id));
    }

}
