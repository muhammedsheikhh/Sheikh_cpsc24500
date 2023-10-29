import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;

// View Class
public class EmailWriter {
    public static void writeToScreen(ArrayList<Email> emails) {
        System.out.println("Here are your emails:");
        for (Email email : emails) {
            System.out.print("To: ");
            System.out.println(email.getRecipients().toString().replace("[", "").replace("]", ""));
            System.out.println("Subject: " + email.getSubject());
            System.out.println("Status: " + email.getStatus());
            System.out.print("Body: ");
            System.out.println(email.getBody());
            System.out.println();
        }
    }

    public static boolean writeToFile(ArrayList<Email> emails, String fname) {
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File(fname))));
            for (Email email : emails) {
                pw.println(email);
            }
            pw.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}



