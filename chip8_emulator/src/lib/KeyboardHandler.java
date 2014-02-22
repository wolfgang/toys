/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/22/14 at 6:37 PM
 */

package lib;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardHandler extends KeyAdapter {
    private MachineState machineState;

    public KeyboardHandler(MachineState machineState) {
        this.machineState = machineState;
    }

    @Override
    public void keyPressed(KeyEvent event)
    {
        switch (event.getKeyCode())
        {
            case KeyEvent.VK_0:
                machineState.keyboard |= 0x8000;
                break;
            case KeyEvent.VK_1:
                machineState.keyboard |= 0x4000;
                break;
            case KeyEvent.VK_2:
                machineState.keyboard |= 0x2000;
                break;
            case KeyEvent.VK_3:
                machineState.keyboard |= 0x1000;
                break;
            case KeyEvent.VK_4:
                machineState.keyboard |= 0x800;
                break;
            case KeyEvent.VK_5:
                machineState.keyboard |= 0x400;
                break;
            case KeyEvent.VK_6:
                machineState.keyboard |= 0x200;
                break;
            case KeyEvent.VK_7:
                machineState.keyboard |= 0x100;
                break;
            case KeyEvent.VK_8:
                machineState.keyboard |= 0x80;
                break;
            case KeyEvent.VK_9:
                machineState.keyboard |= 0x40;
                break;
            case KeyEvent.VK_Q:
                machineState.keyboard |= 0x20;
                break;
            case KeyEvent.VK_W:
                machineState.keyboard |= 0x10;
                break;
            case KeyEvent.VK_E:
                machineState.keyboard |= 0x8;
                break;
            case KeyEvent.VK_R:
                machineState.keyboard |= 0x4;
                break;
            case KeyEvent.VK_T:
                machineState.keyboard |= 0x2;
                break;
            case KeyEvent.VK_Y:
                machineState.keyboard |= 0x1;
        }
    }
}
