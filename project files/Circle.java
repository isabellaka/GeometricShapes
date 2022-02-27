/*
 * Classes and objects
 * This class creates a circle with a given point and a certain radius. It also provides methods to calculate the area and to print the circle.
 * Author: Isabella Kainer
 * Last Change: 02/12/2021
 */

public class Circle {
    private Point centerPoint;
    private int radius;
    static int circleCount = 0;

    //constructor
    Circle(Point p, int rad) {
        centerPoint = p;
        radius = rad;
        circleCount++;
    }

    //calculate the area of the circle
    double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    //draw a horizontal line
    void drawHorizontalLine() {
        for (int i = 0; i < 2 * radius + 3; i++) { //+3 to have the right indentation of the line
            System.out.print(" ");
        }
        System.out.println("--");
    }

    //draw the empty lines (amount = radius)
    void drawEmptyLines() {
        for (int i = 0; i < radius; i++) {
            System.out.println();
        }
    }

    //draw the vertical lines and the center point
    void drawVerticalLine() {
        System.out.print("  |");
        for (int i = 0; i < 2 * radius; i++) {
            System.out.print(" ");
        }
        System.out.print("::");
        for (int i = 0; i < 2 * radius; i++) {
            System.out.print(" ");
        }
        System.out.println("|");
    }

    //draw the circle
    void drawCircle() {
        //if the radius is zero, then draw no circle
        if (radius == 0) {
            return;
        }

        drawHorizontalLine();
        drawEmptyLines();
        drawVerticalLine();
        drawEmptyLines();
        drawHorizontalLine();

    }
}
