/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/22/14 at 4:39 PM
 */

package lib.OpCodes;

import lib.MachineState;

import java.util.Random;

public class OpCodeCXNN extends OpCodeVXNN {
    private Random random;

    public OpCodeCXNN() {
        this(new Random());
    }

    public OpCodeCXNN(Random random) {
        this.random = random;
    }

    @Override
    protected void execute(MachineState mc, int myCode, int vX, int NN) {
        int randomInt = random.nextInt();
        mc.V[vX] = (0x000000FF & randomInt) & NN;
    }
}
