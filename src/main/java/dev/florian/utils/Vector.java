package dev.florian.utils;

public class Vector {
    private double x;
    private double y;

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double[] getPos() {
        double[] pos = {this.x, this.y};
        return pos;
    }

    public Vector divide(Vector that) {
        return new Vector(this.x/that.x, this.y/that.y);
    }

    public Vector multiply(Vector that) {
        return new Vector(this.x*that.x, this.y*that.y);
    }
}
