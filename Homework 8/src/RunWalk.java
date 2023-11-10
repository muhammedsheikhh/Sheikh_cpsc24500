import java.text.ParseException;


public class RunWalk extends Exercise {
    private double distance; // in miles

    public RunWalk(String name, String date, int duration, double distance) throws ParseException {
        super(name, date, duration);
        this.distance = distance;
    }

    @Override
    protected String getExerciseType() {
        return "run/walk";
    }

    @Override
    public double calculateCalories() {
        // Simple calories calculation based on distance
        return distance * 100;
    }
}
