package dev.florian.game;

import javax.swing.JPanel;

import dev.florian.utils.Vector;

import java.awt.Color;
import java.awt.Graphics;

public class CanvasPanel extends JPanel {
    final int GRID_COLS = 8;
    final int GRID_ROWS = 8;

    public CanvasPanel() {
        this.setBackground(new Color(33, 33, 33));
    }

    private void displayGrid(Graphics g, int cell_width, int cell_height) {
        g.setColor(new Color(200, 200, 200));
        
        for(int x = 0; x < GRID_COLS; ++x) {
            g.drawLine(x*cell_width, 0, x*cell_width, getHeight());
        }
        // Manully draw the last COL because of the division of cell_width
        g.drawLine(getWidth() - 1, 0, getWidth() - 1, getHeight());

        for(int y = 0; y < GRID_ROWS; ++y) {
            g.drawLine(0, y*cell_height, getWidth(), y*cell_height);
        }
        // Manully draw the last ROW because of the division of cell_height
        g.drawLine(0, getHeight() - 1, getWidth(), getHeight() - 1);
    }

    private void generateVector(Graphics g, int cell_width, int cell_height) {
        Vector p1 = new Vector(2, 2);
        g.setColor(Color.CYAN);
        g.fillOval(2*cell_width, 3*cell_height, 20, 20);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int cell_width = getWidth() / GRID_COLS;
        int cell_height = getHeight() / GRID_ROWS;

        displayGrid(g, cell_width, cell_height);
        generateVector(g, cell_width, cell_height);
    }
}
