package dev.florian.game;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import dev.florian.utils.Vector;
import dev.florian.utils.VectorRenderer;

public class CanvasPanel extends JPanel {
    private final int GRID_COLS = 10;
    private final int GRID_ROWS = 10;
    private final VectorRenderer vectorRenderer;
    private final Grid grid;

    public CanvasPanel() {
        this.setBackground(new Color(33, 33, 33));
        this.grid = new Grid(GRID_COLS, GRID_ROWS);
        this.vectorRenderer = new VectorRenderer();
    }

    public void paintComponent(Graphics graph) {
        super.paintComponent(graph);
        // Typecast Graphics into Graphics2D because I need to use double values
        // and Graphics only support int values.
        Graphics2D g = (Graphics2D) graph;
        double width = getWidth();
        double height = getHeight();

        this.grid.drawGrid(g, width, height);
        Vector p1 = new Vector(width/2, height/2);
        Vector p2 = new Vector(500, 600);

        vectorRenderer.drawVector(g, p1);
        vectorRenderer.drawVector(g, p2);
        vectorRenderer.connectVector(g, p1, p2);
    }
}
