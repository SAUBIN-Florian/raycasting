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

    public double length() {
        return Math.sqrt(this.getX()*this.getX() + this.getY()*this.getY());
    }

    public Vector norm() {
        double l = length();
        return new Vector(this.getX() / l, this.getY() / l);
    }

    public Vector scale(double scalar) {
        return new Vector(this.getX() * scalar, this.getY() * scalar);
    }

    public Vector add(Vector that) {
        return new Vector(this.getX()+that.getX(), this.getY()+that.getY());
    }

    public Vector sub(Vector that) {
        return new Vector(this.getX() - that.getX(), this.getY() - that.getY());
    }
    
    public Vector multiply(Vector that) {
        return new Vector(this.getX()*that.getX(), this.getY()*that.getY());
    }

    public Vector divide(Vector that) {
        return new Vector(this.getX()/that.getX(), this.getY()/that.getY());
    }
}
