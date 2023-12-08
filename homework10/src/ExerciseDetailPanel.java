import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.*;

/*
 * This is the panel that occupies the west side of our frame
 * entries for Name, Date, Duration, Distance and comment
 */
public class ExerciseDetailPanel extends JPanel {
    private JTextField txtName;
    private JTextField txtDate;
    private JTextField txtDuration;
    private JTextField txtDistance;
    private JTextArea tarComment;

    public ExerciseDetailPanel() {
        setupGUI();
    }

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

    public String getName() {
        return txtName.getText();
    }

    public String getDate() {
        return txtDate.getText();
    }

    public int getDuration() {
        try {
            return Integer.parseInt(txtDuration.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number for duration.");
            return 0; // Default or error value
        }
    }

    public double getDistance() {
        try {
            return Double.parseDouble(txtDistance.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number for distance.");
            return 0.0; // Default or error value
        }
    }

    public String getComment() {
        return tarComment.getText();
    }

    public void clearEntries() {
        txtName.setText("");
        txtDate.setText("");
        txtDuration.setText("");
        txtDistance.setText("");
        tarComment.setText("");
    }

    public void enableEntries(boolean enabledYN) {
        txtName.setEnabled(enabledYN);
        txtDate.setEnabled(enabledYN);
        txtDuration.setEnabled(enabledYN);
        txtDistance.setEnabled(enabledYN);
        tarComment.setEnabled(enabledYN);
    }
}
