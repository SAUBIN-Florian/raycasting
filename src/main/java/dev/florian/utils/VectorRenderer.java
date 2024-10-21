package dev.florian.utils;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;


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
        if(p1.getX() == p2.getX() && p1.getY() == p2.getY()) return p2;
        double dirX = p2.getX() - p1.getX();
        double dirY = p2.getY() - p1.getY();
        double length = Math.sqrt(dirX*dirX + dirY*dirY);

        Vector directionVector = new Vector(dirX / length, dirY / length);
        return p2.add(directionVector.scale(80));
    }
}
