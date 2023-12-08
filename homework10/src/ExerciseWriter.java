import java.io.*;
import java.util.ArrayList;

public class ExerciseWriter {
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
