import java.util.Scanner;
import java.io.File;

public class Read {
    public static String readfile(String fname) {
        try {
            String result = "";
            Scanner fsc = new Scanner(new File(fname));
            String line;
            while (fsc.hasNextLine()) {
                line = fsc.nextLine();
                result = result + line + "\n";  // Added newline character for readability
            }
            fsc.close();  // Remember to close the scanner to avoid memory leaks
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public static void main(String[] args) {
        System.out.print(" enter file name ");
        Scanner sc = new Scanner(System.in);
        String fname;
        fname = sc.nextLine();
/*
        try {D
            Scanner fsc = new Scanner(new File(fname));
            String line;
            String alltogether = "";
            while(fsc.hasNextLine()) {
                line = fsc.nextLine();
                alltogether = alltogether + line + "";
            }
        } catch (Exception ex){
            System.out.println(" You had to add a number ");
        }
        */
        String alltogether = readfile(fname);
        if (alltogether == null){
            System.out.println(" could not read the file ");
        }else{
            System.out.println(alltogether);
        }
    }
}
