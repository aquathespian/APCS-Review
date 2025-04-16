public class Feeder
{
    public Feeder() {
        System.out.println(simulateManyDays(10, 5));
    }
    /**
     * The amount of food, in grams, currently in the bird feeder; initialized in the constructor and
     * always greater than or equal to zero
     */
    private int currentFood = 250;

    /**
     * Simulates one day with numBirds birds or possibly a bear at the bird feeder,
     * as described in part (a)
     * Precondition: numBirds > 0;
     */
    public void simulateOneDay(int numBirds)
    {
        double conditions = (Math.random());
        if (conditions < 0.05) currentFood = 0;
        if (conditions >= 0.05) {
            int foodConsumed = (int)(Math.random()*50);
            while (foodConsumed < 10) foodConsumed = (int)(Math.random()*50);
            currentFood = currentFood - (foodConsumed * numBirds);
        }
        if(currentFood < 0) currentFood = 0;

    }

    /**
     * Returns the number of days birds or a bear found food to eat at the feeder in this simulation,
     * as described in part (b)
     * Preconditions: numBirds > 0, numDays > 0
     */
    public int simulateManyDays(int numBirds, int numDays)
    {
        int successes = 0;
        for (int i=0; i<numDays; i++) {
            simulateOneDay(numBirds);
            if (currentFood > 0) successes++;
        }
        return successes;
    }

    public static void main(String[] args) {
        new Feeder();
    }
}
