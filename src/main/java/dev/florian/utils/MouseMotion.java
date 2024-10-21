package dev.florian.utils;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseMotion implements MouseMotionListener {
    private RepaintListener repaintListener;
    private Vector cursor;

    public MouseMotion(RepaintListener listener, Vector c) {
        this.repaintListener = listener;
        this.cursor = c;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        throw new UnsupportedOperationException("Unimplemented method 'mouseDragged'");
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        this.cursor.setX(e.getX());
        this.cursor.setY(e.getY());

        this.repaintListener.requestRepaint();
    }

}
