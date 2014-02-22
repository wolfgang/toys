/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/22/14 at 6:37 PM
 */

package lib;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.concurrent.ConcurrentHashMap;

public class KeyboardHandler extends KeyAdapter {
    private MachineState machineState;

    private ConcurrentHashMap<Integer, Integer> keyCodeBitIndex = new ConcurrentHashMap<>();

    public KeyboardHandler(MachineState machineState) {
        this.machineState = machineState;
        configureKeyCodes();
    }

    private void configureKeyCodes() {
        keyCodeBitIndex.put(KeyEvent.VK_0, 16);
        keyCodeBitIndex.put(KeyEvent.VK_1, 15);
        keyCodeBitIndex.put(KeyEvent.VK_2, 14);
        keyCodeBitIndex.put(KeyEvent.VK_3, 13);
        keyCodeBitIndex.put(KeyEvent.VK_4, 12);
        keyCodeBitIndex.put(KeyEvent.VK_5, 11);
        keyCodeBitIndex.put(KeyEvent.VK_6, 10);
        keyCodeBitIndex.put(KeyEvent.VK_7, 9);
        keyCodeBitIndex.put(KeyEvent.VK_8, 8);
        keyCodeBitIndex.put(KeyEvent.VK_9, 7);
        keyCodeBitIndex.put(KeyEvent.VK_Q, 6);
        keyCodeBitIndex.put(KeyEvent.VK_W, 5);
        keyCodeBitIndex.put(KeyEvent.VK_E, 4);
        keyCodeBitIndex.put(KeyEvent.VK_R, 3);
        keyCodeBitIndex.put(KeyEvent.VK_T, 2);
        keyCodeBitIndex.put(KeyEvent.VK_Y, 1);
    }

    @Override
    public void keyPressed(KeyEvent event) {
        int index = getBitIndex(event);
        if ((index != -1))
            machineState.keyboard |= (1 << (index - 1));
    }

    @Override
    public void keyReleased(KeyEvent event) {
        int index = getBitIndex(event);
        if ((index != -1))
            machineState.keyboard &= 0xFFFF & ~(1 << (index - 1));
    }

    private int getBitIndex(KeyEvent event) {
        if (keyCodeBitIndex.containsKey(event.getKeyCode()))
            return keyCodeBitIndex.get(event.getKeyCode());
        return -1;
    }
}