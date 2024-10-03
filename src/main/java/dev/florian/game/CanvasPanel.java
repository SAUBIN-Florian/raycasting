package dev.florian.game;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;

public class CanvasPanel extends JPanel {
    final int GRID_COL = 10;
    final int GRID_ROW = 10;
    double panelX = this.getLocation().getX();
    double panelY = this.getLocation().getY();

    public CanvasPanel() {
        this.setBackground(new Color(33, 33, 33));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // DRAW HERE
    }
}
