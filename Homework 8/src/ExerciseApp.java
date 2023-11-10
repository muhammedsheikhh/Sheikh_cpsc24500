import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ExerciseApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Exercise> exercises = new ArrayList<>();

    public static void printWelcome() {
        System.out.println("*" .repeat(75));
        System.out.println(" " .repeat(24) + "  EXERCISE TRACKER V1.0 ");
        System.out.println("*" .repeat(75));
        System.out.println();
    }

    public static void printMenu() {
        System.out.println("These are your choices:");
        System.out.println("1. Add an exercise");
        System.out.println("2. Print exercises to file");
        System.out.println("3. List sorted by date");
        System.out.println("4. List sorted by calories burned");
        System.out.println("5. Exit");
        System.out.print("Enter the number of your choice: ");
    }

    public static void main(String[] args) {
        printWelcome();
        int choice;

        do {
            printMenu();

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addExercise();
                    break;
                case 2:
                    printExercisesToFile();
                    break;
                case 3:
                    listExercisesSortedByDate();
                    break;
                case 4:
                    listExercisesSortedByCalories();
                    break;
                case 5:
                    System.out.println("Thank you for using the exercise tracker!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 5);

        scanner.close();
    }

    private static void addExercise() {
        System.out.println("Describe your workout:");
        System.out.print("Enter R for run/walk, W for weightlifting, or C for rock climbing: ");
        char type = scanner.next().charAt(0);
        scanner.nextLine(); // Consume the newline

        // Set a default name based on the type of exercise if none is provided
        String defaultName = "";
        switch (Character.toUpperCase(type)) {
            case 'R':
                defaultName = "run/walk";
                break;
            case 'W':
                defaultName = "weightlifting";
                break;
            case 'C':
                defaultName = "rock climbing";
                break;
            default:
                System.out.println("Invalid exercise type entered. Please try again.");
                return; // Exit the method early since an invalid type was entered
        }

        System.out.print("Enter a name for the workout:");
        String name = scanner.nextLine();
        if (name.isEmpty()) {
            name = defaultName; // If no description is provided, use the default based on exercise type
        }

        System.out.print("Enter a date for the workout (MM/dd/yyyy): ");
        String dateStr = scanner.nextLine();

        System.out.print("How long did you work out in minutes: ");
        int duration = scanner.nextInt();
        scanner.nextLine(); // Consume the newline after integer input

        Exercise exercise = null;

        try {
            if (Character.toUpperCase(type) == 'R') {
                System.out.print("Enter distance you ran or walked in miles: ");
                double distance = scanner.nextDouble();
                scanner.nextLine(); // Consume the newline
                exercise = new RunWalk(name, dateStr, duration, distance);
            } else if (Character.toUpperCase(type) == 'W') {
                System.out.print("Enter total weight lifted in pounds: ");
                int weight = scanner.nextInt();
                scanner.nextLine(); // Consume the newline
                exercise = new WeightLifting(name, dateStr, duration, weight);
            } else if (Character.toUpperCase(type) == 'C') {
                System.out.print("Enter the height of the wall in feet: ");
                double height = scanner.nextDouble();
                System.out.print("Enter number of times you climbed it: ");
                int repetitions = scanner.nextInt();
                scanner.nextLine(); // Consume the newline
                exercise = new RockClimbing(name, dateStr, duration, height, repetitions);
            }

            System.out.println("Enter a comment about the workout:");
            String comment = scanner.nextLine().trim();
            exercise.setComment(comment);

            if (exercise != null) {
                exercises.add(exercise);
                System.out.println("Exercise added successfully!\n");
            }
        } catch (ParseException e) {
            System.out.println("There was an error parsing the date. Please try again.");
        }
    }

    private static void printExercisesToFile() {
        System.out.print("Enter the name of the file to save: ");
        String filename = scanner.nextLine();

        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(filename)))) {
            for (Exercise exercise : exercises) {
                out.println(exercise);
            }
            System.out.println("Exercises saved to file.");
        } catch (Exception e) {
            System.out.println("An error occurred while writing to the file.");
        }
    }

    private static void listExercisesSortedByDate() {
        // Sort the exercises by date
        Collections.sort(exercises);
        System.out.println("Here are the exercises sorted by date:");
        for (Exercise ex : exercises) {
            System.out.println(ex.toString()); // Use the Exercise's overridden toString() method
        }
    }

    private static void listExercisesSortedByCalories() {
        // Sort the exercises by calories using ExerciseComparator
        exercises.sort(new ExerciseComparator());

        // Output the sorted list
        System.out.println("Here are the exercises sorted by calories burned:");
        for (Exercise ex : exercises) {
            System.out.println(ex); // This uses the toString method of the Exercise object
        }
    }

}
