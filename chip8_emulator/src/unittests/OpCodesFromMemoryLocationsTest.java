/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/21/14 at 1:46 PM
 */

package unittests;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class OpCodesFromMemoryLocationsTest {
    @Test
    public void get0x00E0() throws Exception {
        int b1 = (byte) 0x00;
        int b2 = (byte) 0xE0;
        assertThat((0xFF00 & b1) | (0x00FF & b2), is(0x00E0));
    }
}
