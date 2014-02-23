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
    public void onKeyPressed_VK_0_sets_bit_0() throws Exception {
        keyPressed(KeyEvent.VK_0);
        assertEquals(0x1, machineState.keyboard);
    }

    @Test
    public void onKeyPressed_VK_1_sets_bit_1() throws Exception {
        keyPressed(KeyEvent.VK_1);
        assertEquals(0b10, machineState.keyboard);
    }

    @Test
    public void twoKeysPressed_twoBitsSet() throws Exception {
        keyPressed(KeyEvent.VK_0);
        keyPressed(KeyEvent.VK_1);
        assertEquals(0b11, machineState.keyboard);
    }

    @Test
    public void threeKeysPressed_threeBitsSet() throws Exception {
        keyPressed(KeyEvent.VK_0);
        keyPressed(KeyEvent.VK_1);
        keyPressed(KeyEvent.VK_9);
        assertEquals(0b1000000011, machineState.keyboard);
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
        assertEquals(0b0000001111111111, machineState.keyboard);
    }

    @Test
    public void quertyKeys_set_bits_10_to_15() throws Exception {
        keyPressed(KeyEvent.VK_Q);
        keyPressed(KeyEvent.VK_W);
        keyPressed(KeyEvent.VK_E);
        keyPressed(KeyEvent.VK_R);
        keyPressed(KeyEvent.VK_T);
        keyPressed(KeyEvent.VK_Y);
        assertEquals(0b1111110000000000, machineState.keyboard);
    }

    @Test
    public void keyReleased_VK_0_clears_bit_0() throws Exception {
        machineState.keyboard = 0xFFFF;
        keyReleased(KeyEvent.VK_0);
        assertEquals(0xFFFE, machineState.keyboard);
    }

    @Test
    public void allKeysReleased() throws Exception {
        machineState.keyboard = 0xFFFF;
        keyReleased(KeyEvent.VK_0);
        keyReleased(KeyEvent.VK_1);
        keyReleased(KeyEvent.VK_2);
        keyReleased(KeyEvent.VK_3);
        keyReleased(KeyEvent.VK_4);
        keyReleased(KeyEvent.VK_5);
        keyReleased(KeyEvent.VK_6);
        keyReleased(KeyEvent.VK_7);
        keyReleased(KeyEvent.VK_8);
        keyReleased(KeyEvent.VK_9);
        keyReleased(KeyEvent.VK_Q);
        keyReleased(KeyEvent.VK_W);
        keyReleased(KeyEvent.VK_E);
        keyReleased(KeyEvent.VK_R);
        keyReleased(KeyEvent.VK_T);
        keyReleased(KeyEvent.VK_Y);

        assertEquals(0, machineState.keyboard);
    }


    private void keyPressed(int keyCode) {
        keyboardHandler.keyPressed(keyEvent(keyCode));
    }

    private void keyReleased(int keyCode) {
        keyboardHandler.keyReleased(keyEvent(keyCode));
    }


    private KeyEvent keyEvent(int keyCode) {
        return new KeyEvent(new Canvas(), 0, 0, 0, keyCode, 'x', 0);
    }
}
