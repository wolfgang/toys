/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/23/14 at 6:33 PM
 */

package lib.OpCodes;

import lib.MachineState;

public class Timers {
    private long lastTick;
    private MachineState machineState;

    public Timers(MachineState machineState) {
        this.machineState = machineState;
        lastTick = System.currentTimeMillis();
    }

    public void tick() {
        long now = System.currentTimeMillis();
        if (now - lastTick>16) {
            lastTick += 16;
            if (machineState.sound_timer == 1)
                System.out.println("BEEP!");
            if (machineState.delay_timer>0)
                machineState.delay_timer--;
            if (machineState.sound_timer>0) {
                machineState.sound_timer--;
            }
        }

    }
}
