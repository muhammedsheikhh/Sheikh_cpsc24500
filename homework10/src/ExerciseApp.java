import java.util.ArrayList;

public class ExerciseApp {
    public static void main(String[] args) {
        ArrayList<Exercise> exercises = new ArrayList<>();
        MainFrame frame = new MainFrame(exercises);
        frame.setVisible(true);
    }
}
