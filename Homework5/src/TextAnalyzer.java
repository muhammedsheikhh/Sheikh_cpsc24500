import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class TextAnalyzer {
    public static void printWelcome() {
        System.out.println("*" .repeat(75));
        System.out.println(" " .repeat(22) + " Welcome to TextAnalyzer V1.0");
        System.out.println("*" .repeat(75));
        System.out.println();
    }

    public static void printMenu() {
        System.out.println("Choose an option:");
        System.out.println("1. Count the number of vowels ");
        System.out.println("2. Count the number of consonants ");
        System.out.println("3. Count the number of words ");
        System.out.println("4. Print the summary to file ");
        System.out.println("5. Quit ");
        System.out.print("Enter the number of your choice:");
    }
    public static String readFile(String fname) {
        try {
            String result = "";
            Scanner fsc = new Scanner(new File(fname));
            while (fsc.hasNextLine()) {
                result += fsc.nextLine() + "\n";
            }
            fsc.close();
            return result.trim();
        } catch (Exception ex) {
            return null;
        }
    }

    public static int countVowels(String text) {
        int total = 0;
        String vowels = "aeiouAEIOU";
        for (int i = 0; i < text.length(); i++) {
            char a = text.charAt(i);
            if (vowels.indexOf(a) != -1) {
                total++;
            }
        }
        return total;
    }

    public static int countConsonants(String text) {
        int total = 0;
        String consonants = "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ";
        for (int i = 0; i < text.length(); i++) {
            char a = text.charAt(i);
            if (consonants.indexOf(a) != -1) {
                total++;
            }
        }
        return total;
    }

    public static int countWords(String text) {
        return text.split("\\s+").length;
    }

    public static boolean writeSummaryToFile(String fileName, String text) {
        try (PrintWriter out = new PrintWriter(fileName)) {
            out.println("Vowels: " + countVowels(text));
            out.println("Consonants: " + countConsonants(text));
            out.println("Words: " + countWords(text));
            return true;
        } catch (Exception ex) {
            System.out.println("An error occurred while writing to the file: " + ex.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        printWelcome();
        Scanner sc = new Scanner(System.in);
        System.out.print("What text file would you like to analyze? ");
        String fname = sc.nextLine();
        String allTogether = readFile(fname);

        if (allTogether == null) {
            System.out.println("Couldn't read the file.");
            return;
        }
        int choice;
        do {
            printMenu();
            while (!sc.hasNextInt()) {
                System.out.println("You have to enter the number of your choice. You didn't type a number.");
                sc.next();
            }
            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.println("Vowels: " + countVowels(allTogether));
            } else if (choice == 2) {
                System.out.println("Consonants: " + countConsonants(allTogether));
            } else if (choice == 3) {
                System.out.println("Words: " + countWords(allTogether));
            } else if (choice == 4) {
                System.out.print("Enter the summary filename: ");
                String summaryFileName = sc.nextLine();
                if (writeSummaryToFile(summaryFileName, allTogether)) {
                    System.out.println("File written successfully.");
                } else {
                    System.out.println("Error writing file.");
                }
            } else if (choice == 5) {
                System.out.println("Thank you for using this program.");
            } else {
                System.out.println("That is not a valid choice.");
            }
        } while (choice != 5);
        sc.close();
    }
}
