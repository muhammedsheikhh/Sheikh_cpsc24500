import java.util.Comparator;

/**
 * Comparator for Exercise objects that compares them based on the calories burned.
 */
public class ExerciseComparator implements Comparator<Exercise> {

    /**
     * Compares two exercises based on the calories burned.
     *
     * @param ex1 the first Exercise to be compared.
     * @param ex2 the second Exercise to be compared.
     * @return a negative integer, zero, or a positive integer as the first Exercise
     *         has burned fewer, equal to, or greater calories than the second Exercise.
     */
    @Override
    public int compare(Exercise ex1, Exercise ex2) {
        return Double.compare(ex1.calculateCalories(), ex2.calculateCalories());
    }
}
