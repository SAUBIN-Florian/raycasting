package dev.florian.game;

import javax.swing.JPanel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

import dev.florian.utils.Vector;

public class CanvasPanel extends JPanel {
    final int GRID_COLS = 10;
    final int GRID_ROWS = 10;

    public CanvasPanel() {
        this.setBackground(new Color(33, 33, 33));
    }

    private void displayGrid(Graphics2D g, double cell_width, double cell_height) {
        g.setColor(new Color(200, 200, 200));
        g.setStroke(new BasicStroke(0.02f));
        
        for(int x = 0; x <= GRID_COLS; ++x) {
            Line2D.Double col = new Line2D.Double(x*cell_width, 0, x*cell_width, getHeight());
            g.draw(col);
        }

        for(int y = 0; y <= GRID_ROWS; ++y) {
            Line2D.Double row = new Line2D.Double(0, y*cell_width, getWidth(), y*cell_width);
            g.draw(row);
        }
    }

    private void generateVector(Graphics2D g, double x, double y, double cell_width, double cell_height) {
        Vector p1 = new Vector(x, y);
        g.setColor(Color.CYAN);
        Ellipse2D.Double circle = new Ellipse2D.Double(p1.getX()*cell_width, p1.getY()*cell_height, 0.2*cell_height, 0.2*cell_height);
        g.fill(circle);
    }

    public void paintComponent(Graphics graph) {
        super.paintComponent(graph);
        // Typecast Graphics into Graphics2D because I need to use double values
        // and Graphics only support int values.
        Graphics2D g = (Graphics2D) graph;
        double cell_width = getWidth() / GRID_COLS;
        double cell_height = getHeight() / GRID_ROWS;

        displayGrid(g, cell_width, cell_height);
        generateVector(g, 0.5, 0.5, cell_width, cell_height);
        generateVector(g, 2, 2.25, cell_width, cell_height);

    }
}
