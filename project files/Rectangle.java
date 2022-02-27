/*
 * Classes and objects
 * This class creates a rectangle with 2 given points and provides methods to calculate width, height and area and to print the rectangle.
 * Author: Isabella Kainer
 * Last Change: 02/12/2021
 */

public class Rectangle {
    private Point cornerPoint1;
    private Point cornerPoint2;
    static int rectangleCount = 0;
    private int width;
    private int height;
    private int area;


    //constructor
    Rectangle(Point p1, Point p2) {
        cornerPoint1 = p1;
        cornerPoint2 = p2;
        rectangleCount++;
        calculateWidth();
        calculateHeight();
        calculateArea();
    }

    //calculate the width of the rectangle
    int calculateWidth() {
        width = Math.abs(cornerPoint1.getX() - cornerPoint2.getX());
        return width;
    }

    //calculate the height of the rectangle
    int calculateHeight() {
        height = Math.abs(cornerPoint1.getY() - cornerPoint2.getY());
        return height;
    }

    //calculate the area of the rectangle
    int calculateArea() {
        area = width * height;
        return area;
    }

    //draw the rectangle
    void drawRectangle() {
        //if the width or the height are zero, then draw no rectangle
        if (width == 0 || height == 0) {
            return;
        }

        //draw the upper part of the rectangle (width)
        System.out.print("   ");
        for (int i = 0; i < 2 * width; i++) {
            System.out.print("-");
        }
        System.out.println();

        //draw the middle part of the rectangle (height)
        for (int j = 0; j < height; j++) {
            System.out.print("  ");
            System.out.print("|");
            for (int m = 0; m < 2 * width; m++) {
                System.out.print(" ");
            }
            System.out.println("|");
        }

        //draw the lower part of the rectangle (width)
        System.out.print("   ");
        for (int i = 0; i < 2 * width; i++) {
            System.out.print("-");
        }
        System.out.println();

    }


}
