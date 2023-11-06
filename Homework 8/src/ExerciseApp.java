import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;

public class ExerciseApp {
    public static void main(String[] args) {
        try {
            Exercise runWalk = new RunWalk("Morning Run", "11/06/2023", 30, 3.5);
            Exercise weightLifting = new WeightLifting("Gym Session", "11/07/2023", 45, 150);

            ArrayList<Exercise> exercises = new ArrayList<>();
            exercises.add(runWalk);
            exercises.add(weightLifting);

            System.out.println("Before sorting by calories:");
            for (Exercise ex : exercises) {
                System.out.println(ex);
            }

            Collections.sort(exercises, new ExerciseComparator());

            System.out.println("\nAfter sorting by calories:");
            for (Exercise ex : exercises) {
                System.out.println(ex);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
