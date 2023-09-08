/*
 * Muhammed Sheikh
 * CPSC 24500
 * 9/8/23
 * Purpose: Calculate the amount of paint and primer needed to paint 8 units in a apartment complex.
 */

public class Program {

    public static void main(String[] args){

        // Givens
        double longWall = 32.75;
        double narrowWall = 25.62;
        double wallHeight = 10.0;
        double windowWidth = 14.4;
        double windowHeight = 5.5;
        double doorWidth = 3.25;
        double doorHeight = 8.0;
        double paintCoverage = 400.0;
        double primerCoverage = 300.0;
        double paintCost = 34.99;
        double primerCost = 24.49;
        int units = 8;

        // Calculate room area for one unit
        double totalWallArea = 2 * (longWall + narrowWall);
        double wallArea = (totalWallArea * wallHeight) - (windowWidth * windowHeight + doorWidth * doorHeight);
        double ceilingArea = longWall * narrowWall;

        // Calculate total area for all units
        double totalArea = units * (wallArea + ceilingArea);

        // Calculate total cost
        double paintGallons = Math.ceil(totalArea / paintCoverage);
        double primerGallons = Math.ceil(totalArea / primerCoverage);
        double totalPaintCost = paintGallons * paintCost;
        double totalPrimerCost = primerGallons * primerCost;
        double totalCost = totalPaintCost + totalPrimerCost;

        // Print the results
        System.out.println("**********************************************************");
        System.out.printf("Wall area per unit %10.2f%n", wallArea);
        System.out.printf("Ceiling area per unit %9.2f%n", ceilingArea);
        System.out.printf("Total area to paint and prime %10.2f%n", totalArea);
        System.out.println();
        System.out.printf("You must purchase %d gallons of paint for $%.2f.%n", (int)paintGallons, totalPaintCost);
        System.out.printf("You must purchase %d gallons of primer for $%.2f.%n", (int)primerGallons, totalPrimerCost);
        System.out.println();
        System.out.printf("Your total cost to paint and prime all units is $%.2f.%n", totalCost );
        System.out.println("**********************************************************");

    }

}
