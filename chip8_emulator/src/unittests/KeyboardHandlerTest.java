/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/22/14 at 6:36 PM
 */

package unittests;

import lib.KeyboardHandler;
import lib.MachineState;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

import static junit.framework.TestCase.assertEquals;

public class KeyboardHandlerTest {

    private MachineState machineState;
    private KeyboardHandler keyboardHandler;

    @Before
    public void setUp() throws Exception {
        machineState = new MachineState();
        keyboardHandler = new KeyboardHandler(machineState);
    }

    @Test
    public void onKeyPressed_VK_0_sets_bit_16() throws Exception {
        keyPressed(KeyEvent.VK_0);
        assertEquals(0x8000, machineState.keyboard);
    }

    @Test
    public void onKeyPressed_VK_1_sets_bit_15() throws Exception {
        keyPressed(KeyEvent.VK_1);
        assertEquals(0b0100000000000000, machineState.keyboard);
    }

    @Test
    public void twoKeysPressed_twoBitsSet() throws Exception {
        keyPressed(KeyEvent.VK_0);
        keyPressed(KeyEvent.VK_1);
        assertEquals(0b1100000000000000, machineState.keyboard);
    }

    @Test
    public void threeKeysPressed_threeBitsSet() throws Exception {
        keyPressed(KeyEvent.VK_0);
        keyPressed(KeyEvent.VK_1);
        keyPressed(KeyEvent.VK_9);
        assertEquals(0b1100000001000000, machineState.keyboard);
    }

    @Test
    public void allNumberKeysPressed() throws Exception {
        keyPressed(KeyEvent.VK_0);
        keyPressed(KeyEvent.VK_1);
        keyPressed(KeyEvent.VK_2);
        keyPressed(KeyEvent.VK_3);
        keyPressed(KeyEvent.VK_4);
        keyPressed(KeyEvent.VK_5);
        keyPressed(KeyEvent.VK_6);
        keyPressed(KeyEvent.VK_7);
        keyPressed(KeyEvent.VK_8);
        keyPressed(KeyEvent.VK_9);
        assertEquals(0b1111111111000000, machineState.keyboard);
    }

    @Test
    public void quertyKeys_set_bits_11_to_16() throws Exception {
        keyPressed(KeyEvent.VK_Q);
        keyPressed(KeyEvent.VK_W);
        keyPressed(KeyEvent.VK_E);
        keyPressed(KeyEvent.VK_R);
        keyPressed(KeyEvent.VK_T);
        keyPressed(KeyEvent.VK_Y);
        assertEquals(0b0000000000111111, machineState.keyboard);
    }



    private void keyPressed(int keyCode) {
        keyboardHandler.keyPressed(new KeyEvent(new Canvas(), 0, 0, 0, keyCode, 'x', 0));
    }
}
