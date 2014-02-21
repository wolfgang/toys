/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/17/14 at 5:40 PM
 */

package lib;

import java.util.EmptyStackException;
import java.util.Stack;

public class MachineState {
    private static final int MaxStackSize = 64;
    public int pc = 0x200;
    public int[] V = new int[16];
    public int I = 0;
    private Stack<Integer> stack = new Stack<>();

    public void pushOntoStack(int value)
    {
        if (stack.size() == MaxStackSize)
            throw new StackOverflowError();
        stack.push(value);
    }

    public int popFromStack()
    {
        if (!stack.empty())
            return stack.pop();
        else
            throw new EmptyStackException();
    }
}
