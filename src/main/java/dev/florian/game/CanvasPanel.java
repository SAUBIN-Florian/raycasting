package dev.florian.game;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import dev.florian.utils.MouseMotion;
import dev.florian.utils.RepaintListener;
import dev.florian.utils.Vector;
import dev.florian.utils.VectorRenderer;

public class CanvasPanel extends JPanel implements RepaintListener {
    private final int GRID_COLS = 10;
    private final int GRID_ROWS = 10;
    private final VectorRenderer vectorRenderer;
    private final MouseMotion mouseMotion;
    private final MiniMap minimap;

    // TODO: Find a way to optimize the generation of all vectors (p1, p2, p3...)
    Vector cursor = new Vector(500, 600);

    public CanvasPanel() {
        this.setBackground(new Color(33, 33, 33));
        this.minimap = new MiniMap(GRID_COLS, GRID_ROWS);
        this.vectorRenderer = new VectorRenderer();

        this.mouseMotion = new MouseMotion(this, cursor);
        addMouseMotionListener(this.mouseMotion);
    }

    public void paintComponent(Graphics graph) {
        super.paintComponent(graph);
        // Typecast Graphics into Graphics2D because I need to use double values
        // and Graphics only support int values.
        Graphics2D g = (Graphics2D) graph;
        double width = getWidth();
        double height = getHeight();

        this.minimap.drawGrid(g, width, height);

        Vector p1 = new Vector(getWidth()/2, getHeight()/2);
        vectorRenderer.drawVector(g, p1);
        vectorRenderer.drawVector(g, cursor);
        vectorRenderer.connectVector(g, p1, cursor);
        vectorRenderer.drawSnappedLine(g, p1, cursor, width, height, GRID_COLS, GRID_ROWS);
    }

    @Override
    public void requestRepaint() {
        repaint();
    }
}
