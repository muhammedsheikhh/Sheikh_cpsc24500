import java.util.Scanner;

public class ShapeCalculator {
    public static void printWelcome() {
        System.out.println("*".repeat(60));
        System.out.println(" ".repeat(22) + "Shape Calculator");
        System.out.println("*".repeat(60));
        System.out.println();
    }
    public static void printMenu() {
        System.out.print("Enter C for Circle, R for Rectangle or T for Triangle: ");
    }

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
                double circleArea = 3.14 * radius * radius;
                double circleCircumference = 2 * 3.14 * radius;
                System.out.printf("The Area of circle is %.2f and the Circumference is %.2f. \n", circleArea, circleCircumference);
            } else if (choice == 'R') {
                double length, width;
                System.out.print("Enter the length and width: ");
                length = sc.nextDouble();
                width = sc.nextDouble();
                double rectangleArea = length * width;
                double rectanglePerimeter = 2 * (length + width);
                System.out.printf("The Area of rectangle is %.2f and the perimeter is %.2f. \n",rectangleArea, rectanglePerimeter);
            } else if (choice == 'T') {
                System.out.print("Enter the lengths of all 3 sides: ");
                double side1 = sc.nextDouble();
                double side2 = sc.nextDouble();
                double side3 = sc.nextDouble();
                double semiPerimeter = (side1 + side2 + side3) / 2;
                double triangleArea = Math.sqrt(semiPerimeter * (semiPerimeter - side1) * (semiPerimeter - side2) * (semiPerimeter - side3));
                double trianglePerimeter = side1 + side2 + side3;
                System.out.printf("The Area of triangle is %.2f and the perimeter is %.2f. \n", triangleArea, trianglePerimeter);
            } else if (choice == 'Q') {
                System.out.println("Thank you for using Shape Calculator.");
            } else {
                System.out.println("This is not a recognized shape.\n");
            }
        } while (choice != 'Q');
    }
}
