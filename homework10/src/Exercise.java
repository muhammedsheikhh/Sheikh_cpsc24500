import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Abstract class representing a generic exercise.
 * It serves as a superclass for specific types of exercises.
 */
// Default constructor


public abstract class Exercise implements Comparable<Exercise> {
    private String name;
    private Date date;
    private int duration;
    private String comment;

    private static final SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

    /**
     * Constructs an Exercise object with specified name, date, and duration.
     *
     * @param name       the name of the exercise.
     * @param dateString the date when the exercise was performed, in MM/dd/yyyy format.
     * @param duration   the duration of the exercise in minutes.
     * @throws ParseException if the given date string is not in the expected format.
     */
    public Exercise(String name, String dateString, int duration) throws ParseException {
        this.name = name;
        this.date = sdf.parse(dateString);
        this.duration = duration;
        this.comment = "";
    }

    /**
     * Gets the name of the exercise.
     *
     * @return the name of the exercise.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the date of the exercise.
     *
     * @return the date when the exercise was performed.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Gets the duration of the exercise.
     *
     * @return the duration of the exercise in minutes.
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Abstract method to be implemented by subclasses to define the type of exercise.
     *
     * @return a string representing the specific type of exercise.
     */
    protected abstract String getExerciseType();
    /**
     * Sets a comment for the exercise.
     *
     * @param comment a string containing comments about the exercise.
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Gets the comment associated with the exercise.
     *
     * @return a string containing comments about the exercise.
     */
    public String getComment() {
        return comment;
    }

    /**
     * Abstract method to calculate the calories burned during the exercise.
     * To be implemented by subclasses based on specific exercise types.
     *
     * @return the number of calories burned.
     */
    public abstract double calculateCalories();

    /**
     * Compares this exercise with another exercise based on the date.
     *
     * @param other the exercise to compare to.
     * @return a negative integer, zero, or a positive integer as this exercise
     *         is less than, equal to, or greater than the specified exercise.
     */
    @Override
    public int compareTo(Exercise other) {
        return this.date.compareTo(other.date);
    }

    /**
     * Returns a string representation of the exercise in a tab-delimited format,
     * including the type, name, date, and calories burned.
     *
     * @return a string representation of the exercise.
     */


    @Override
    public String toString() {
        return String.format("%s     %s     %s      %s ",
                getName(), getExerciseType(), sdf.format(getDate()), calculateCalories());
    }
}

