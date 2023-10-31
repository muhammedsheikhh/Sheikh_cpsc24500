import java.util.ArrayList;

/**
 * Represents an email with recipients, subject, body, and status.
 */
public class Email {
    private ArrayList<String> recipients;
    private String subject;
    private String body;
    private String status;

    /**
     * Creates a new Email instance with default values.
     */
    public Email() {
        this.recipients = new ArrayList<String>();
        this.subject = "";
        this.body = "";
        this.status = "not sent";
    }

    /**
     * Creates a new Email instance with the provided recipients, subject, body, and status.
     *
     * @param recipients List of recipients of the email
     * @param subject Subject of the email
     * @param body Body of the email
     * @param status Status of the email
     */
    public Email(ArrayList<String> recipients, String subject, String body, String status) {
        this.recipients = recipients;
        this.subject = subject;
        this.body = body;
        this.status = status;
    }

    /**
     * Returns the list of recipients of the email.
     *
     * @return List of recipients
     */
    public ArrayList<String> getRecipients() {
        return recipients;
    }

    /**
     * Adds a recipient to the email.
     *
     * @param recipient Email address of the recipient
     */
    public void addRecipient(String recipient) {
        recipients.add(recipient);
    }

    /**
     * Returns the subject of the email.
     *
     * @return Subject of the email
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Sets the subject of the email.
     *
     * @param subject Subject of the email
     */

    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * Returns the body of the email.
     *
     * @return Body of the email
     */
    public String getBody() {
        return body;
    }

    /**
     * Sets the body of the email.
     *
     * @param body Body of the email
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * Returns the status of the email.
     *
     * @return Status of the email
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of the email.
     *
     * @param status Status of the email
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Returns a string representation of the email.
     *
     * @return String representation of the email
     */
    @Override
    public String toString() {
        return String.join(",", recipients) + "\t" + subject + "\t" + body + "\t" + status;
    }

    /**
     * Sends the email by setting the status to "sent".
     */
    public void sendEmail() {
        status = "sent";
    }
}



