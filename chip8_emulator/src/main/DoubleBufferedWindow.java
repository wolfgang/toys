/**
 * (c) 2013 Wolfgang Deutsch
 * Created on 1/30/14 at 9:13 AM
 */

package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class DoubleBufferedWindow extends JFrame {
    private Canvas canvas;

    public DoubleBufferedWindow(String title, int x, int y, int width, int height) {
        super(title);
        setupFrame(x, y, width, height);
        setupDoubleBuffering();
        setVisible(true);
    }

    private void setupFrame(int x, int y, int width, int height) {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setPreferredSize(new Dimension(width, height));
        setLocation(x, y);
        pack();
    }

    private void setupDoubleBuffering() {
        canvas = new Canvas();
        add(canvas);
        canvas.createBufferStrategy(2);
    }

    public void addKeyListener(KeyListener listener)
    {
        super.addKeyListener(listener);
        canvas.addKeyListener(listener);
    }

    public void addMouseListener(MouseListener listener)
    {
        super.addMouseListener(listener);
        canvas.addMouseListener(listener);

    }

    public void addMouseMotionListener(MouseMotionListener listener)
    {
        super.addMouseMotionListener(listener);
        canvas.addMouseMotionListener(listener);
    }

    public Graphics getDrawGraphics() {
        return canvas.getBufferStrategy().getDrawGraphics();
    }


    public int getDrawWidth() {
        return canvas.getWidth();
    }

    public int getDrawHeight() {
        return canvas.getHeight();
    }

    public void showBuffer() {
        canvas.getBufferStrategy().show();
    }

    public void clear(Color color) {
        Graphics g = getDrawGraphics();
        g.setColor(color);
        g.fillRect(0, 0, getDrawWidth(), getDrawHeight());
    }

    @SuppressWarnings("UnusedDeclaration")
    public Dimension getScreenSize() {
        return new Dimension(canvas.getWidth(), canvas.getHeight());
    }
}

