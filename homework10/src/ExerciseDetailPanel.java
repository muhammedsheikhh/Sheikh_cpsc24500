import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.*;

/**
 * This class represents a panel for entering and displaying details of an exercise.
 * It contains text fields for name, date, duration, distance, and a text area for comments.
 */
public class ExerciseDetailPanel extends JPanel {
    private JTextField txtName;
    private JTextField txtDate;
    private JTextField txtDuration;
    private JTextField txtDistance;
    private JTextArea tarComment;

    /**
     * Constructor for ExerciseDetailPanel.
     * Calls the method to set up the user interface components.
     */
    public ExerciseDetailPanel() {
        setupGUI();
    }

    /**
     * Sets up the graphical user interface of the panel.
     * This method initializes and arranges the text fields and text area components.
     */
    public void setupGUI() {
        setLayout(new BorderLayout());
        JPanel panNorth = new JPanel();
        panNorth.setLayout(new GridLayout(4, 2)); // Adjusted to 4 rows for 4 details

        panNorth.add(new JLabel("Name"));
        txtName = new JTextField(10);
        panNorth.add(txtName);

        panNorth.add(new JLabel("Date:"));
        txtDate = new JTextField(10);
        panNorth.add(txtDate);

        panNorth.add(new JLabel("Duration:"));
        txtDuration = new JTextField(10);
        panNorth.add(txtDuration);

        panNorth.add(new JLabel("Distance:"));
        txtDistance = new JTextField(10);
        panNorth.add(txtDistance);

        add(panNorth, BorderLayout.NORTH);

        JPanel panComment = new JPanel();
        panComment.setLayout(new BorderLayout());
        panComment.add(new JLabel("Add comment"), BorderLayout.NORTH);
        tarComment = new JTextArea(10, 10);
        JScrollPane scrollPane = new JScrollPane(tarComment); // To allow scrolling
        panComment.add(scrollPane, BorderLayout.CENTER);

        add(panComment, BorderLayout.CENTER);
    }

    /**
     * Retrieves the name entered in the name text field.
     *
     * @return String containing the entered name.
     */
    public String getName() {
        return txtName.getText();
    }

    /**
     * Retrieves the date entered in the date text field.
     *
     * @return String containing the entered date.
     */
    public String getDate() {
        return txtDate.getText();
    }

    /**
     * Retrieves the duration entered in the duration text field.
     * Displays a message dialog if the entered duration is not a valid number.
     *
     * @return The duration as an integer. Returns 0 if the entered value is invalid.
     */
    public int getDuration() {
        try {
            return Integer.parseInt(txtDuration.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number for duration.");
            return 0; // Default or error value
        }
    }

    /**
     * Retrieves the distance entered in the distance text field.
     * Displays a message dialog if the entered distance is not a valid number.
     *
     * @return The distance as a double. Returns 0.0 if the entered value is invalid.
     */
    public double getDistance() {
        try {
            return Double.parseDouble(txtDistance.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number for distance.");
            return 0.0; // Default or error value
        }
    }

    /**
     * Retrieves the comment entered in the comment text area.
     *
     * @return String containing the entered comment.
     */
    public String getComment() {
        return tarComment.getText();
    }

    /**
     * Clears all entries in the text fields and the text area.
     */
    public void clearEntries() {
        txtName.setText("");
        txtDate.setText("");
        txtDuration.setText("");
        txtDistance.setText("");
        tarComment.setText("");
    }

    /**
     * Enables or disables all input components in the panel.
     *
     * @param enabledYN Boolean indicating whether to enable (true) or disable (false) the components.
     */
    public void enableEntries(boolean enabledYN) {
        txtName.setEnabled(enabledYN);
        txtDate.setEnabled(enabledYN);
        txtDuration.setEnabled(enabledYN);
        txtDistance.setEnabled(enabledYN);
        tarComment.setEnabled(enabledYN);
    }
}
