package com.telran;

public class RemotePoints implements Comparable<RemotePoints> {
    private double X;
    private double Y;

    public RemotePoints(double X, double Y) {
        this.X = X;
        this.Y = Y;

    }

    public double getX() {
        return X;
    }

    public double getY() {
        return Y;
    }

    public void setX(double x) {
        X = x;
    }

    public void setY(double y) {
        Y = y;
    }


    public double getDistanceToPoint() {
        return Math.sqrt((X * X) + (Y * Y));
    }

    public double getArctanOffTheCorner() {
        if (X == 0 && Y > 0) return 90;
        else if (X == 0 && Y < 0) return 270;
        else if (Y == 0 && X < 0) return 180;
        else if (Y < 0) {
            if (X > 0) return 360 + Math.atan(Y / X) * 180 / Math.PI;
            else return 180 + Math.atan(Y / X) * 180 / Math.PI;
        } else if (X < 0 && Y > 0) return 180 + Math.atan(Y / X) * 180 / Math.PI;
        else return Math.atan(Y / X) * 180 / Math.PI;
    }

    @Override
    public int compareTo(RemotePoints o) {
        double thisPoint = Math.sqrt((X*X) + (Y*Y));
        double otherPoint = Math.sqrt((o.X*o.X) + (o.Y*o.Y));
        if (thisPoint >= otherPoint) return 1;
        else return -1;

    }

    @Override
    public String toString() {
        return "RemotePoints{" +
                "X=" + X +
                ", Y=" + Y +
                '}';
    }
}