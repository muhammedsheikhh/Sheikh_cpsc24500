import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;

/**
 * Utility class for writing emails to the screen or to a file.
 */
public class EmailWriter {

    /**
     * Prints the details of a list of emails to the console.
     *
     * @param emails List of emails to be printed to the console
     */
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

    /**
     * Writes a list of emails to a file.
     *
     * @param emails List of emails to be written to the file
     * @param fname Name of the file to which the emails will be written
     * @return true if the emails were successfully written to the file, false otherwise
     */
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



