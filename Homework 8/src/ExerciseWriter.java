import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Utility class for writing exercise data to a file and printing summaries to the console.
 */
public class ExerciseWriter {

    /**
     * Writes a list of exercises to a file in a tab-delimited text format.
     * Each exercise's string representation is written on a new line.
     *
     * @param filename  the name of the file to write the exercises to.
     * @param exercises the list of Exercise objects to write to the file.
     */
    public static void writeToFile(String filename, List<Exercise> exercises) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Exercise exercise : exercises) {
                writer.write(exercise.toString());
                writer.newLine();
            }
            System.out.println("Exercises were successfully written to " + filename);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    /**
     * Prints a tabulated summary of exercises to the console.
     * The summary includes the type, name, date, and calories for each exercise.
     *
     * @param exercises the list of Exercise objects to print in a tabulated format.
     */
    public static void tabulateSummary(List<Exercise> exercises) {
        System.out.println("Type\tName\tDate\tCalories");
        for (Exercise exercise : exercises) {
            System.out.println(exercise.toString());
        }
    }
}
