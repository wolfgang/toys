/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/21/14 at 10:16 AM
 */

package lib;

public class OpCodeResolver {

    public int getOpCodeId(int code) {
        if (isMask(code, 0xD000))
            return 0xD000;

        if (isMask(code, 0x8003))
            return 0x8003;

        if (isMask(code, 0x8002))
            return 0x8002;

        if (isMask(code, 0x8001))
            return 0x8001;

        if (isMask(code, 0x8000))
            return 0x8000;

        if (isMask(code, 0x7000))
            return 0x7000;

        if (isMask(code, 0x6000))
            return 0x6000;

        if (isMask(code, 0x5000))
            return 0x5000;

        if (isMask(code, 0x4000))
            return 0x4000;

        if (isMask(code, 0x3000))
            return 0x3000;

        if (isMask(code, 0x2000))
            return 0x2000;

        if (isMask(code, 0x1000))
            return 0x1000;

        if (code == 0x00E0)
            return 0x00E0;

        if (code == 0x00EE)
            return 0x00EE;

        return -1;
    }

    private boolean isMask(int code, int mask) {
        return (code & mask) == mask;
    }
}
