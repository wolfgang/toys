/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/22/14 at 4:38 PM
 */

package unittests.OpCodes;

import lib.OpCodes.OpCodeCXNN;
import org.junit.Test;

import java.util.Random;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OpCodeCXNNTest extends OpCodeTest {
    @Test
    public void sets_vx_to_random_and_NN() throws Exception {
        Random random = mock(Random.class);
        opCode = new OpCodeCXNN(random);
        when(random.nextInt()).thenReturn(0xFF12CC56);
        givenV(5, 0);
        executeOpCode(0xC512);
        assertVX(5, 0x00000056 & 0x12);
    }
}
