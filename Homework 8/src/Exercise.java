import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Exercise implements Comparable<Exercise> {
    private String name;
    private Date date;
    private int duration; // Duration in minutes

    private static final SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

    public Exercise(String name, String dateString, int duration) throws ParseException {
        this.name = name;
        this.date = sdf.parse(dateString);
        this.duration = duration;

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

    public abstract double calculateCalories();


    @Override
    public int compareTo(Exercise other) {
        return this.date.compareTo(other.date);
    }

    @Override
    public String toString() {
        return String.format("%s on %s for %d minutes", name, sdf.format(date), duration);
    }


}
