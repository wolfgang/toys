/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/17/14 at 6:17 PM
 */

package unittests;

import lib.Memory;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MemoryTest {

    private Memory memory;

    @Before
    public void setUp() throws Exception {
        memory = new Memory();
    }

    @Test
    public void get_initially_0() throws Exception {
        assertThat(memory.get(0x200), is((byte)0));
    }

    @Test
    public void set_then_get() throws Exception {
        memory.set(0x200, 123);
        assertThat(memory.get(0x200), is((byte)123));
    }
}
