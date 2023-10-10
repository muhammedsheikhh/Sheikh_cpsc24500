import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;

public class week6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileName;
        System.out.print(" enter file name ");
        fileName = sc.nextLine();
        try {
            Scanner fsc = new Scanner(new File(fileName));
            String line;
            String[] parts;
            String Name;
            double grade1 ,grade2, grade3;
            while (fsc.hasNextLine()) {
                line = fsc.nextLine().trim();
               if (line.length() > 0) {
                    parts = line.split("\t");
                    Name = parts[0];
                    grade1 = Double.parseDouble(parts[1]);
                    grade2 = Double.parseDouble(parts[2]);
                    grade3 = Double.parseDouble(parts[3]);
                    double average = (grade1 + grade2 + grade3) / 3;
                    System.out.printf(" the name is %.2f and average is %.2f  \n. ", Name, average);
               }
            }
            fsc.close();  // Remember to close the scanner to avoid memory leaks
        } catch (Exception ex) {
            System.out.println(" enter file name ");
            ex.printStackTrace();
           
        }

    }
}
