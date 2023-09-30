import java.util.Random;
import java.util.Scanner;

public class payDay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random randy = new Random();

        System.out.println("**********************************************************");
        System.out.println("                      " + "Payday V1.0");
        System.out.println("**********************************************************");
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter hours worked:  ");
        double hoursWorked = sc.nextDouble();
        System.out.print("Enter hourly pay rate: ");
        double hourlyPayRate = sc.nextDouble();
        System.out.print("Are you a union member (y or n)? ");
        String unionMember = sc.next().trim();
        System.out.print("What percentage do you want to withould for your medical savings account? ");
        double medicalWithould = sc.nextDouble();

        //  Calculation
        double grossPay = hoursWorked * hourlyPayRate;
        double unionDues;
        if (unionMember.equals("y")) {
            unionDues = (grossPay / 100) * 5;
            double medDeduction = (grossPay / 100) * medicalWithould;
            // Random number for Incident Pay
            int incidentPay = randy.nextInt(401) - 200;

            double adjustedGrossPay = grossPay - unionDues - medDeduction + incidentPay;

            double taxRate;
            if (adjustedGrossPay >= 2500) {
                taxRate = 0.25;
            } else if (adjustedGrossPay >= 1500) {
                taxRate = 0.15;
            } else if (adjustedGrossPay >= 500) {
                taxRate = 0.10;
            } else {
                taxRate = 0.05;
            }
            double taxes = adjustedGrossPay * taxRate;

            double netPay = adjustedGrossPay - taxes;

            // Output
            System.out.println("---------PAYCHECK---------");
            System.out.printf("%-14s $ %7.2f%n", "Gross Pay", grossPay);
            System.out.printf("%-14s $ %7.2f%n", "Union Dues", unionDues);
            System.out.printf("%-14s $ %7.2f%n", "Med Deduction", medDeduction);
            System.out.printf("%-14s $ %7.2f%n", "Incident Pay", (double) incidentPay);
            System.out.printf("%-14s $ %7.2f%n", "Taxes", taxes);
            System.out.printf("%-14s $ %7.2f%n", "Net Pay", netPay);
            System.out.println("--------------------------");
            System.out.println("Prepared for " + name);
            System.out.println("Thank you for using this program");

        }
    }
}
