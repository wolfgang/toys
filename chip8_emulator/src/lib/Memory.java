/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/17/14 at 5:21 PM
 */

package lib;

public class Memory {
    byte values[] = new byte[4096];

    public byte get(int address) {
        return values[address];
    }

    public void set(int address, int value) {
        values[address] = (byte) value;
    }
}
