import java.text.ParseException;

/**
 * The RockClimbing class represents a rock climbing exercise session.
 * It extends the Exercise class and calculates calories based on the height climbed and the number of repetitions.
 */
public class RockClimbing extends Exercise {
    private double height;
    private int repetitions;

    /**
     * Constructs a RockClimbing object with specified name, date, duration, height, and repetitions.
     *
     * @param name        the name of the rock climbing exercise.
     * @param dateStr     the date when the rock climbing was performed, in MM/dd/yyyy format.
     * @param duration    the duration of the rock climbing in minutes.
     * @param height      the height climbed in feet.
     * @param repetitions the number of times the height was climbed.
     * @throws ParseException if the given date string is not in the expected format.
     */
    public RockClimbing(String name, String dateStr, int duration, double height, int repetitions) throws ParseException {
        super(name, dateStr, duration);
        this.height = height;
        this.repetitions = repetitions;
    }

    /**
     * Gets the exercise type as a string.
     *
     * @return the exercise type, "rock climbing".
     */
    @Override
    protected String getExerciseType() {
        return "rock climbing";
    }

    /**
     * Calculates and returns the calories burned during the rock climbing session.
     * The calculation uses the provided formula: (height * repetitions / duration) * 100.
     *
     * @return the number of calories burned.
     */
    @Override
    public double calculateCalories() {
        return (height * repetitions / (double) getDuration()) * 100;
    }

    /**
     * Gets the height climbed in the rock climbing exercise.
     *
     * @return the height climbed in feet.
     */
    public double getHeight() {
        return height;
    }

    /**
     * Gets the number of repetitions in the rock climbing exercise.
     *
     * @return the number of times the height was climbed.
     */
    public int getRepetitions() {
        return repetitions;
    }
}
