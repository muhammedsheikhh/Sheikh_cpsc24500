import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;

public class Grades {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String fileName;
		System.out.print("Enter the name of the grades file: ");
		fileName = sc.nextLine();
		System.out.print("Enter the name of the final averages file: ");
		String outputFileName = sc.nextLine();
		try {
			Scanner fsc = new Scanner(new File(fileName));
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File(outputFileName))));
			String line;
			String[] parts;
			String name;
			double total;
			double average;
			while (fsc.hasNextLine()) {
				line = fsc.nextLine().trim();
				if (line.length() > 0) {   // skip blank lines
					total = 0;  // resetting the point total for this new person
					parts = line.split("\t");
					name = parts[0];
					for (int i = 1; i < parts.length; i++) {
						total = total + Double.parseDouble(parts[i]);
					}
					average = total / (parts.length - 1);
					pw.printf("%-15s%10.2f\n", name,average);
				}
			}
			fsc.close();
			pw.close();
		} catch (Exception ex) {
			System.out.println("A problem occurred while reading the file.");
//			ex.printStackTrace();
		}
	}
}