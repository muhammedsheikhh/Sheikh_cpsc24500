import java.text.ParseException;

/**
 * The WeightLifting class represents a weightlifting exercise session.
 * It extends the Exercise class and calculates calories based on the weight lifted and duration of the exercise.
 */
public class WeightLifting extends Exercise {
    private int weight;

    /**
     * Constructs a WeightLifting object with specified name, date, duration, and weight lifted.
     *
     * @param name     the name of the weightlifting exercise.
     * @param date     the date when the weightlifting was performed, in MM/dd/yyyy format.
     * @param duration the duration of the weightlifting in minutes.
     * @param weight   the total weight lifted in pounds.
     * @throws ParseException if the given date string is not in the expected format.
     */
    public WeightLifting(String name, String date, int duration, int weight) throws ParseException {
        super(name, date, duration);
        this.weight = weight;
    }

    /**
     * Gets the exercise type as a string.
     *
     * @return the exercise type, "weightlifting".
     */
    @Override
    protected String getExerciseType() {
        return "weightlifting";
    }

    /**
     * Calculates and returns the calories burned during the weightlifting session.
     * The calculation assumes a simple formula based on weight and duration.
     *
     * @return the number of calories burned, using the formula (weight / duration) * 50.
     */
    @Override
    public double calculateCalories() {
        return (weight / (double) getDuration()) * 50;
    }

    /**
     * Gets the weight lifted in the weightlifting exercise.
     *
     * @return the weight lifted in pounds.
     */
    public int getWeight() {
        return weight;
    }
}
