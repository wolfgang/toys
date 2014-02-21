/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/21/14 at 10:16 AM
 */

package lib;

public class OpCodeResolver {
    public OpCodeId getOpCodeId(int code) {
        if ((code & 0xD000) == 0xD000)
            return OpCodeId.OP_DXYN;

        if ((code & 0x1000) == 0x1000)
            return OpCodeId.OP_1NNN;

        if ((code & 0x2000) == 0x2000)
            return OpCodeId.OP_2NNN;

        if (code == 0x00E0)
            return OpCodeId.OP_00E0;

        if (code == 0x00EE)
            return OpCodeId.OP_00EE;

        return OpCodeId.OP_INVALID;
    }
}
