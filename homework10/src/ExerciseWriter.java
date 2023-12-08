import java.io.*;
import java.util.ArrayList;

/**
 * This class is responsible for writing exercise data to a file.
 * It contains a method to write a list of exercises to a specified file.
 */
public class ExerciseWriter {
    /**
     * Writes the provided list of exercises to the specified file.
     * Each exercise is written on a new line in the file.
     *
     * @param file      The file where the exercises will be written.
     * @param exercises The list of exercises to write to the file.
     * @return boolean  True if the writing operation is successful, false if an IOException occurs.
     */
    public static boolean writeToFile(File file, ArrayList<Exercise> exercises) {
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)))) {
            for (Exercise exercise : exercises) {
                pw.println(exercise);
            }
            return true;
        } catch (IOException ex) {
            return false;
        }
    }
}
