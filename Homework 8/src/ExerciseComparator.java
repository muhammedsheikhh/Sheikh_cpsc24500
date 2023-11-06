import java.util.Comparator;

public class ExerciseComparator implements Comparator<Exercise> {
    @Override
    public int compare(Exercise e1, Exercise e2) {
        return Double.compare(e1.calculateCalories(), e2.calculateCalories());
    }
}

