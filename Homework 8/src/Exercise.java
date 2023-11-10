import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Exercise implements Comparable<Exercise> {
    private String name;
    private Date date;
    private int duration; // Duration in minutes
    private String comment; // New field for comment

    private static final SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

    public Exercise(String name, String dateString, int duration) throws ParseException {
        this.name = name;
        this.date = sdf.parse(dateString);
        this.duration = duration;
        this.comment = ""; // Initialize comment as empty
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public int getDuration() {
        return duration;
    }

    protected abstract String getExerciseType();

    public void setComment(String comment) {
        this.comment = comment; // Setter for comment
    }

    public String getComment() {
        return comment; // Getter for comment
    }

    public abstract double calculateCalories();

    @Override
    public int compareTo(Exercise other) {
        return this.date.compareTo(other.date);
    }

    @Override
    public String toString() {
        // Use getExerciseType() to get the type for the toString representation.
        return String.format("%s     %s     %s      %s ",
                getExerciseType(), getName(), sdf.format(getDate()), calculateCalories());
    }
}
