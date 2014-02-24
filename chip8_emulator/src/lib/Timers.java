/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/23/14 at 6:33 PM
 */

package lib;

public class Timers {
    private MachineState machineState;
    private int ticks = 0;

    public Timers(MachineState machineState) {
        this.machineState = machineState;
    }

    public void tick() {
        if (++ticks == 16) {
            ticks = 0;
            if (machineState.sound_timer == 1)
                System.out.println("BEEP!");
            if (machineState.delay_timer>0)
            {
                machineState.delay_timer--;
                //System.out.println("Delay timer: " + machineState.delay_timer);
            }
            if (machineState.sound_timer>0) {
                machineState.sound_timer--;
            }
        }

    }
}
