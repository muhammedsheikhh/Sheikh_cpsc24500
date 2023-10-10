import java.util.Random;
import java.util.Scanner;

public class arrays {
    public static void printWelcome(){
        System.out.println("'" .repeat(60));
        System.out.println(" " .repeat(22) + "fun with numbers");
        System.out.println("," .repeat(60));
        System.out.println();
    }
    public static void printMenu(){
        System.out.println("Choose an options ");
        System.out.println("1. the mean ");
        System.out.println("2. min ");
        System.out.println("3. max ");
        System.out.println("5. show your numbers ");
        System.out.println(" Enter Number ");
    }

    public static void print(int[] nums) {
            for (int num : nums){
            System.out.println(num);
            }
        }
        public static int calculateMin(int[] nums) {
            int min = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < min){
                    min = nums[i];
                }
            }
            return min;
        }
    
        public static int calculateMax(int[] nums) {
            int max = nums[0];
            for (int i = 1; i < nums.length; i++) {
             if (nums[i] > max){
                    max = nums[i];
                }
            }
            return max;
        }
    
        // Rectangle calculations
        public static double calculateMean(int[] nums) {
            double total = 0;
            for (int num : nums) {
                total = total + num;
        //        total += num;
            }
            double result = total / nums.length;
            return result;
        }
   
    public static void main(String[] args) {
        Random rnd = new Random();
        int[] numbers = new int[10];
        for (int i = 0; i < numbers.length; i++){
            numbers[i] = rnd.nextInt(100);
        }
        printWelcome();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            printMenu();
            choice = sc.nextInt();
            if (choice > 5){
                System.out.printf(" Valid choice ");
            }else if (choice == 1){
                int theMin = calculateMin(numbers);
                System.out.printf(" the diff of %.2f  \n. ", theMin);
            }else if (choice == 2){
                int theMax = calculateMax(numbers);
                System.out.printf(" the Prod of %.2f  \n. ", theMax);
            }else if (choice == 3){
                double theMean = calculateMean(numbers);
                System.out.printf(" the quort of %.2f  \n. ", theMean);
            }
        }while (choice != 5);
    }
}

