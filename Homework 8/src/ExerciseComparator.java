import java.util.Comparator;

public class ExerciseComparator implements Comparator<Exercise> {
    @Override
    public int compare(Exercise ex1, Exercise ex2) {
        return Double.compare(ex1.calculateCalories(), ex2.calculateCalories());
    }
}

