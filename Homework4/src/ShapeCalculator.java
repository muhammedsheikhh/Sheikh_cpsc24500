import java.util.Scanner;

public class ShapeCalculator {

    // Welcome banner function
    public static void printWelcome() {
        System.out.println("*".repeat(60));
        System.out.println(" ".repeat(22) + "Shape Calculator");
        System.out.println("*".repeat(60));
        System.out.println();
    }

    // Menu function
    public static void printMenu() {
        System.out.print("Enter C for Circle, R for Rectangle or T for Triangle: ");
    }

    // Circle calculations
    public static double circleArea(double radius) {
        return 3.14 * radius * radius;
    }

    public static double circleCircumference(double radius) {
        return 2 * 3.14 * radius;
    }

    // Rectangle calculations
    public static double rectangleArea(double length, double width) {
        return length * width;
    }

    public static double rectanglePerimeter(double length, double width) {
        return 2 * (length + width);
    }

    // Triangle calculations
    public static double triangleArea(double side1, double side2, double side3) {
        double semiPerimeter = (side1 + side2 + side3) / 2;
        return Math.sqrt(semiPerimeter * (semiPerimeter - side1) * (semiPerimeter - side2) * (semiPerimeter - side3));
    }

    public static double trianglePerimeter(double side1, double side2, double side3) {
        return side1 + side2 + side3;
    }

    // Main function
    public static void main(String[] args) {
        printWelcome();
        Scanner sc = new Scanner(System.in);

        char choice;
        do {
            printMenu();
            choice = sc.next().toUpperCase().charAt(0);

            if (choice == 'C') {
                System.out.print("Enter the radius: ");
                double radius = sc.nextDouble();
                System.out.printf("The Area of circle is %.2f and the Circumference is %.2f. \n", circleArea(radius), circleCircumference(radius));
            } else if (choice == 'R') {
                System.out.print("Enter the length and width: ");
                double length = sc.nextDouble();
                double width = sc.nextDouble();
                System.out.printf("The Area of rectangle is %.2f and the perimeter is %.2f. \n", rectangleArea(length, width), rectanglePerimeter(length, width));
            } else if (choice == 'T') {
                System.out.print("Enter the lengths of all 3 sides: ");
                double side1 = sc.nextDouble();
                double side2 = sc.nextDouble();
                double side3 = sc.nextDouble();
                System.out.printf("The Area of triangle is %.2f and the perimeter is %.2f. \n", triangleArea(side1, side2, side3), trianglePerimeter(side1, side2, side3));
            } else if (choice == 'Q') {
                System.out.println("Thank you for using Shape Calculator.");
            } else {
                System.out.println("This is not a recognized shape.\n");
            }
        } while (choice != 'Q');
    }
}