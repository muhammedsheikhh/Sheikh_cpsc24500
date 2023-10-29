import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class EmailApp {
    private static List<Email> emails = new ArrayList<>();

    public static void printWelcome() {
        System.out.println("*" .repeat(75));
        System.out.println(" " .repeat(24) + "  Emailer Version 1.0 ");
        System.out.println("*" .repeat(75));
        System.out.println();
    }

    public static void printMenu() {
        System.out.println("Here are your choices:");
        System.out.println("1. Write email");
        System.out.println("2. List emails");
        System.out.println("3. Send emails");
        System.out.println("4. Save emails to file");
        System.out.println("5. Exit");

        System.out.print("Enter the number of your choice: ");
    }

    public static void main(String[] args) {
        printWelcome();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            printMenu();

            while (!sc.hasNextInt()) {
                System.out.println("You have to enter the number of your choice. You didn't type a number.");
                sc.next();
            }

            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            if (choice == 1) {
                Email newEmail = writeEmail(sc);
                emails.add(newEmail);
            } else if (choice == 2) {
                EmailWriter.writeToScreen(new ArrayList<>(emails));
            } else if (choice == 3) {
                for (Email email : emails) {
                    email.sendEmail();
                }
                System.out.println("All emails sent!");
            } else if (choice == 4) {
                System.out.print("Enter the filename to save to: ");
                String filename = sc.nextLine();
                EmailWriter.writeToFile(new ArrayList<>(emails), filename);
            } else if (choice == 5) {
                System.out.println("Thank you for using this program.");
                sc.close();
                return;
            } else {
                System.out.println("That is not a valid choice.");
            }
        } while (choice != 5);
    }


    private static Email writeEmail(Scanner sc) {
        Email email = new Email();

        System.out.print("Enter recipients' email: ");
        String recipientInput = sc.nextLine();
        String[] recipients = recipientInput.split(",");
        for (String recipient : recipients) {
            email.addRecipient(recipient);
        }

        System.out.print("Enter subject: ");
        email.setSubject(sc.nextLine());

        System.out.print("Enter body: ");
        email.setBody(sc.nextLine());

        return email;
    }
}




