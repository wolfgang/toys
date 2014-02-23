/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/21/14 at 4:32 PM
 */

package unittests;

import lib.MachineState;
import org.junit.Before;
import org.junit.Test;

import java.util.EmptyStackException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

public class MachineStateStackTest {

    private MachineState machineState;

    @Before
    public void setUp() throws Exception {
        machineState = new MachineState();
    }

    @Test
    public void pushThenPop() throws Exception {
        machineState.pushOntoStack(15);
        assertThat(machineState.popFromStack(), is(15));
    }

    @Test(expected = EmptyStackException.class)
    public void popFromEmptyStackThrowsError() throws Exception {
        machineState.popFromStack();
    }

    @Test
    public void pushingValuesBeyond64ThrowsError() throws Exception {
        for (int i = 0; i < 64; ++i)
            machineState.pushOntoStack(i);

        try {
            machineState.pushOntoStack(100);
            fail("should have thrown StackOverflowError");
        } catch (StackOverflowError e) {

        }
    }
}
