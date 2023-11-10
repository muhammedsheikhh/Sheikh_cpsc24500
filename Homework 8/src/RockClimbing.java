import java.text.ParseException;

public class RockClimbing extends Exercise {
    private double height;
    private int repetitions;

    public RockClimbing(String name, String dateStr, int duration, double height, int repetitions) throws ParseException {
        super(name, dateStr, duration);
        this.height = height;
        this.repetitions = repetitions;
    }

    @Override
    protected String getExerciseType() {
        return "rock climbing";
    }
    @Override
    public double calculateCalories() {
        // Implementing the provided formula for calories burned during rock climbing
        return (height * repetitions / (double) getDuration()) * 100;
    }

    // Getters for the height and repetitions, if needed outside the class
    public double getHeight() {
        return height;
    }

    public int getRepetitions() {
        return repetitions;
    }
}
