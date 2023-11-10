import java.text.ParseException;

public class WeightLifting extends Exercise {
    private int weight; // in pounds

    public WeightLifting(String name, String date, int duration, int weight) throws ParseException {
        super(name, date, duration);
        this.weight = weight;
    }

    @Override
    protected String getExerciseType() {
        return "weightlifting";
    }
    // Specific implementation of calculateCalories for WeightLifting
    @Override
    public double calculateCalories() {
        // Assume a simple calorie calculation based on weight and duration
        return weight * getDuration() * 0.5;
    }

    // Getter method for weight
    public int getWeight() {
        return weight;
    }
}

