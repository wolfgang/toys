package lib;

import _main.DoubleBufferedWindow;

import java.awt.*;

/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 2/14/14 at 8:27 PM
 */
public class Screen {
    private DoubleBufferedWindow window;

    public Screen(DoubleBufferedWindow window)
    {

        this.window = window;
    }
    public void clear()
    {
        window.clear(Color.black);
    }
}
