/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/21/14 at 10:16 AM
 */

package lib;

public class OpCodeResolver {
    private int[] masks = {
            0xF007,
            0xE0A1,
            0xE09E,
            0xD000,
            0xC000,
            0xB000,
            0xA000,
            0x9000,
            0x800E,
            0x8007,
            0x8006,
            0x8005,
            0x8004,
            0x8003,
            0x8002,
            0x8001,
            0x8000,
            0x7000,
            0x6000,
            0x5000,
            0x4000,
            0x3000,
            0x2000,
            0x1000,
            0x00EE,
            0x00E0,
    };


    public int getOpCodeId(int code) {
        for (int mask : masks) {
            if ((code & mask) == mask)
                return mask;
        }
        return -1;
    }

}
