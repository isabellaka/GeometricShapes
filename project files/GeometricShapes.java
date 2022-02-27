/*
 * Classes and objects
 * This class prints a menu to show valid commands. Then the program creates, according to the entered command, a rectangle or a circle and prints the result of different calculations and the geometric shape itself. Therefore it uses other classes. If the user enters "quit", the program finishes.
 * Author: Isabella Kainer
 * Last Change: 02/12/2021
 */

import java.util.Locale;
import java.util.Scanner;

public class GeometricShapes {
    static Scanner scanner = new Scanner(System.in);

    //print the separator line with 80 -s
    static void printSeparatorLine() {
        for (int i = 0; i < 80; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    //print the menu with the available commands
    static void printMenu() {
        printSeparatorLine();
        System.out.println("Available commands:");
        System.out.println("  \"New rectangle\" - create new rectangle");
        System.out.println("  \"New circle\" - create new circle");
        System.out.println("  \"Quit\" - quit program");
        printSeparatorLine();
        System.out.print("> ");

    }

    //take the user input for the commands until a valid command is entered
    static String userInput() {
        String input = "";

        while (true) {
            printMenu();
            input = scanner.nextLine().toLowerCase(); //toLowerCase() in order to check in a way that is not case sensitive
            if (input.equals("new rectangle") | input.equals("new circle") | input.equals("quit")) {
                return input;
            }
        }

    }

    //get integer input from the user
    static int getIntInput(String text) {
        int input = 0;
        boolean repeat = true;

        do {
            System.out.print(text);
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();

                if (scanner.nextLine().isEmpty()) {
                    repeat = false;
                }

            } else {
                scanner.nextLine();
            }
        } while (repeat);
        return input;
    }

    //takes the input for the rectangle, creates the rectangle and prints the output
    static void rectangleInput() {
        System.out.printf("Rectangle #%d:\n", Rectangle.rectangleCount + 1); //print rectangleCount + 1 because the rectangleCount is not updated until the Rectangle is created
        int x1 = getIntInput("  First point:  x coordinate: ");
        int y1 = getIntInput("  First point:  y coordinate: ");
        int x2 = getIntInput("  Second point: x coordinate: ");
        int y2 = getIntInput("  Second point: y coordinate: ");

        Point point1 = new Point(x1, y1);
        Point point2 = new Point(x2, y2);
        Rectangle rectangle = new Rectangle(point1, point2);
        System.out.printf("  Width:  %d\n", rectangle.calculateWidth());
        System.out.printf("  Height: %d\n", rectangle.calculateHeight());
        System.out.printf("  Area:   %d\n", rectangle.calculateArea());
        rectangle.drawRectangle();
    }

    //takes the input for the circle, creates the circle and prints the output
    static void circleInput() {
        System.out.printf("Circle #%d:\n", Circle.circleCount + 1); //print circleCount + 1 because the circleCount is not updated until the circle is created
        int x = getIntInput("  Center: x coordinate: ");
        int y = getIntInput("  Center: y coordinate: ");
        int radius;
        do {
            radius = getIntInput("  Radius: ");
        } while (radius < 0);

        Point center = new Point(x, y);
        Circle circle = new Circle(center, radius);
        System.out.printf("  Center: (%d,%d)\n", x, y);
        System.out.printf("  Radius: %d\n", radius);
        System.out.printf("  Area:   %.2f\n", circle.calculateArea());
        circle.drawCircle();
    }

    public static void main(String[] args) {
        Locale.setDefault(new java.util.Locale("en", "US"));
        boolean repeat = true;

        while (repeat) {
            String command = userInput();
            if (command.equals("new rectangle")) {
                rectangleInput();
            } else if (command.equals("new circle")) {
                circleInput();
            } else if (command.equals("quit")) {
                scanner.close();
                repeat = false;
            }
        }

    }
}
