package dev.florian.game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class Grid {
    private int cols, rows;
    private double cellWidth, cellHeight;

    public Grid(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
    }

    public void drawGrid(Graphics2D g, double width, double height) {
        this.cellWidth = width / (double) this.cols;
        this.cellHeight = height / (double) this.rows;

        g.setColor(new Color(200, 200, 200));
        g.setStroke(new BasicStroke(0.02f));

        for (int x = 0; x <= cols; x++) {
            Line2D.Double col = new Line2D.Double(x * cellWidth, 0, x * cellWidth, height);
            g.draw(col);
        }

        for (int y = 0; y <= rows; y++) {
            Line2D.Double row = new Line2D.Double(0, y * cellHeight, width, y * cellHeight);
            g.draw(row);
        }
    }

    public double getCellWidth() { 
        return cellWidth; 
    }

    public double getCellHeight() { 
        return cellHeight; 
    }
}
