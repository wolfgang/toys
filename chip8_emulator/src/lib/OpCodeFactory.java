/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/17/14 at 5:21 PM
 */

package lib;

import lib.OpCodes.OpCode;
import lib.OpCodes.OpCode00E0;
import lib.OpCodes.OpCode1NNN;
import lib.OpCodes.OpCodeDXYN;

public class OpCodeFactory {

    public OpCodeFactory() {
    }

    public OpCode getOpCode(int code) throws InvalidOpCode {
        if ((code & 0xD000) == 0xD000)
            return new OpCodeDXYN(code);

        if ((code & 0x1000) == 0x1000)
            return new OpCode1NNN(code);

        if (code == 0x00E0)
            return new OpCode00E0();


        throw new InvalidOpCode(code);
    }
}
