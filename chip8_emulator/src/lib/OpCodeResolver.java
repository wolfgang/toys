/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/21/14 at 10:16 AM
 */

package lib;

public class OpCodeResolver {
    public int getOpCodeId(int code) {
        if ((code & 0xD000) == 0xD000)
            return OpCodeIds.OP_DXYN;

        if ((code & 0x1000) == 0x1000)
            return OpCodeIds.OP_1NNN;

        return OpCodeIds.OP_00E0;
    }
}
