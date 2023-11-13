import java.text.ParseException;

/**
 * The RunWalk class represents a running or walking exercise session.
 * It extends the Exercise class and calculates calories based on the distance covered and duration of the run/walk.
 */
public class RunWalk extends Exercise {
    private double distance; // in miles

    /**
     * Constructs a RunWalk object with specified name, date, duration, and distance.
     *
     * @param name     the name of the run/walk exercise.
     * @param date     the date when the run/walk was performed, in MM/dd/yyyy format.
     * @param duration the duration of the run/walk in minutes.
     * @param distance the distance covered in miles.
     * @throws ParseException if the given date string is not in the expected format.
     */
    public RunWalk(String name, String date, int duration, double distance) throws ParseException {
        super(name, date, duration);
        this.distance = distance;
    }

    /**
     * Gets the exercise type as a string.
     *
     * @return the exercise type, "run/walk".
     */
    @Override
    protected String getExerciseType() {
        return "run/walk";
    }

    /**
     * Calculates and returns the calories burned during the run/walk based on the distance and duration.
     * The calculation uses the formula: (distance / duration) * 9000.
     *
     * @return the number of calories burned.
     */
    @Override
    public double calculateCalories() {
        // Simple calories calculation based on distance
        return (distance / getDuration()) * 9000;
    }
}
