/**
 * Author: Joseph Babilu Karippai
 * PointFactory.java - Assignment 2
 */

// Enum for Quadrant
enum Quadrant {
    Q1, 
    Q2, 
    Q3, 
    Q4; 
}

interface GridQuadrant {
    Quadrant getQuadrant(); 
}

interface CompareQuadrant {
    boolean isInSameQuadrant(Point point); 
}

class Point implements GridQuadrant, CompareQuadrant {
    private double x; 
    private double y; 

    // Constructors
    public Point(double x, double y) {
        setX(x);
        setY(y);
    }

    // getters
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    // setters
    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    // Method to determine the quadrant
    public Quadrant getQuadrant() {
        if (this.x > 0 && this.y > 0) {
            return Quadrant.Q1;
        } else if (this.x < 0 && this.y > 0) {
            return Quadrant.Q2;
        } else if (this.x < 0 && this.y < 0) {
            return Quadrant.Q3;
        } else if (this.x > 0 && this.y < 0) {
            return Quadrant.Q4;
        } else {
            return null;
        }
    }

    // Method to check if two points are in the same quadrant
    public boolean isInSameQuadrant(Point point) {
        return this.getQuadrant() == point.getQuadrant();
    }
}

interface PointMaker {
    // Factory method to create a point
    Point makePoint(double x, double y); // returns point with given x,y
    int countPointsCreated(); 
}

class PointFactory implements PointMaker {
    // Private field to track the number of points 
    private int pointsCreated = 0;

    // Factory method to create a point
    public Point makePoint(double x, double y) {
        pointsCreated++;
        return new Point(x, y);
    }

    public int countPointsCreated() {
        return pointsCreated;
    }

    public static void main(String args[]) {
        PointFactory pointFactory = new PointFactory();

        // Creating points using the factory
        Point unit0 = pointFactory.makePoint(0, 0);
        Point unit1 = pointFactory.makePoint(1, 1);
        Point unit2 = pointFactory.makePoint(-2, 2);
        Point unit3 = pointFactory.makePoint(-3, -3);
        Point unit4 = pointFactory.makePoint(4, -4);
        Point unit5 = pointFactory.makePoint(1, 1);

        // Printing information about the points
        System.out.println(unit0.getQuadrant());
        System.out.println(unit2.getQuadrant());
        System.out.println(unit1.isInSameQuadrant(unit3));
        System.out.println(unit1.isInSameQuadrant(unit5));
        System.out.println(pointFactory.countPointsCreated());
    }
}
