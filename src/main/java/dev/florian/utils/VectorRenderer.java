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

    public Vector getDirection(Graphics2D g, Vector p1, Vector p2, double cellSize) {
        if(p1.getX() == p2.getX() && p1.getY() == p2.getY()) return p2;

        Vector d = p2.sub(p1);

        if(d.getX() != 0) {
            double slope = d.getY() / d.getX();
            double c = p1.getY() - slope * p1.getX();
            double p3X = snapToGrid(p2.getX(), d.getX(), cellSize);
            double p3Y = p3X*slope + c;
            Vector p3 = new Vector(p3X, p3Y);
            return p3;
        }

        return p2;
    }

    public double snapToGrid(double pos, double dir, double cellSize) {
        if(dir < 0) return Math.floor(pos / cellSize) * cellSize;
        if(dir > 0) return Math.ceil(pos / cellSize) * cellSize;
        return pos;
    }

    public void drawEachPoints(Graphics2D g, Vector p1, Vector p2, double cellSize) {
        List<Vector> vectors = new ArrayList<>();
        vectors.add(p1);
        vectors.add(p2);
        Vector snappedVector = getDirection(g, p1, p2, cellSize);
        vectors.add(snappedVector);

        for(int i = 0; i < vectors.size(); ++i) {
            drawVector(g, vectors.get(i));
            if (vectors.get(i) == p1) {
                connectVector(g, p1, vectors.get(i + 1));
            } else {
                connectVector(g, vectors.get(i - 1), vectors.get(i));
            }
        }
    }
}
