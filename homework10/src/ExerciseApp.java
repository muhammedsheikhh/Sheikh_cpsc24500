import java.util.ArrayList;

/**
 * This class represents an application that manages exercises.
 * It initializes and displays the main frame of the application.
 */
public class ExerciseApp {
    /**
     * The main method that serves as the entry point of the application.
     * It creates a list of exercises and initializes the main frame.
     *
     * @param args Command line arguments passed to the application (not used in this application).
     */
    public static void main(String[] args) {
        ArrayList<Exercise> exercises = new ArrayList<>();
        MainFrame frame = new MainFrame(exercises);
        frame.setVisible(true);
    }
}
