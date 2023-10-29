import java.util.ArrayList;

// Model Class
public class Email {
    private ArrayList<String> recipients;
    private String subject;
    private String body;
    private String status;

    public Email() {
        this.recipients = new ArrayList<String>();
        this.subject = "";
        this.body = "";
        this.status = "not sent";
    }

    public Email(ArrayList<String> recipients, String subject, String body, String status) {
        this.recipients = recipients;
        this.subject = subject;
        this.body = body;
        this.status = status;
    }

    public ArrayList<String> getRecipients() {
        return recipients;
    }

    public void addRecipient(String recipient) {
        recipients.add(recipient);
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.join(",", recipients) + "\t" + subject + "\t" + body + "\t" + status;
    }
    public void sendEmail() {
        status = "sent";
    }
}



