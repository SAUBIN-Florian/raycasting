package dev.florian.utils;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

public class VectorRenderer {
    private int radius = 8;

    public VectorRenderer() {}

    public void drawVector(Graphics2D g, Vector point) {
        g.setColor(Color.CYAN);
        Ellipse2D.Double circle = new Ellipse2D.Double(
            point.getX() - radius, 
            point.getY() - radius, 
            2 * radius, 
            2 * radius
        );
        g.fill(circle);
    }

    public void connectVector(Graphics2D g, Vector p1, Vector p2) {
        g.setColor(Color.CYAN);
        g.setStroke(new BasicStroke(0.02f));
        Line2D.Double line = new Line2D.Double(p1.getX(), p1.getY(), p2.getX(), p2.getY());
        g.draw(line);
    }

    public Vector getDirection(Vector p1, Vector p2) {
        Double dirX = p2.getX() - p1.getX();
        Double dirY = p2.getY() - p1.getY();
        Double norm = Math.sqrt(dirX * dirX + dirY * dirY);

        return new Vector(dirX / norm, dirY / norm);
    }

    public List<Vector> traceLineThroughGrid(Vector p1, Vector p2, double cellWidth, double cellHeight, int GRID_COLS, int GRID_ROWS) {
        List<Vector> snappedPoints = new ArrayList<>();
        Vector direction = getDirection(p1, p2);
        Vector currentPoint = new Vector(p1.getX(), p1.getY());
        snappedPoints.add(currentPoint);

        while (currentPoint.getX() >= 0 && currentPoint.getX() <= GRID_COLS * cellWidth
                && currentPoint.getY() >= 0 && currentPoint.getY() <= GRID_ROWS * cellHeight) {

            double nextX = currentPoint.getX() + direction.getX() * cellWidth;
            double nextY = currentPoint.getY() + direction.getY() * cellHeight;

            currentPoint = new Vector(nextX, nextY);

            double snappedX = Math.round(currentPoint.getX() / cellWidth) * cellWidth;
            double snappedY = Math.round(currentPoint.getY() / cellHeight) * cellHeight;
            
            snappedPoints.add(new Vector(snappedX, snappedY));
        }

        return snappedPoints;
    }

    public void drawSnappedLine(Graphics2D g, Vector p1, Vector p2, double cellWidth, double cellHeight, int GRID_COLS, int GRID_ROWS) {
        List<Vector> snappedPoints = traceLineThroughGrid(p1, p2, cellWidth, cellHeight, GRID_COLS, GRID_ROWS);
    
        for (int i = 0; i < snappedPoints.size() - 1; i++) {
            Vector start = snappedPoints.get(i);
            Vector end = snappedPoints.get(i + 1);
    
           connectVector(g, start, end);
        }
    }
}
