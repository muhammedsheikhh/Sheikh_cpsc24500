import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import java.util.ArrayList;
import javax.swing.*;

/**
 * This class represents a panel that displays a summary of exercises.
 * It includes a label and a text area within a scroll pane for showing the exercise details.
 */
public class SummaryPanel extends JPanel {
    private ArrayList<Exercise> exercises;
    private JTextArea tarSummary;
    private JLabel lblSummary;

    /**
     * Constructs a SummaryPanel with a list of exercises.
     * Initializes the user interface components.
     *
     * @param exercises The list of exercises to be summarized in this panel.
     */
    public SummaryPanel(ArrayList<Exercise> exercises) {
        this.exercises = exercises;
        setupGUI();
    }

    /**
     * Sets up the graphical user interface of the panel.
     * This method initializes and arranges the label and text area components.
     */
    public void setupGUI() {
        setLayout(new BorderLayout());
        lblSummary = new JLabel("Exercise Summary");
        add(lblSummary, BorderLayout.NORTH);

        tarSummary = new JTextArea(10, 30);
        tarSummary.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(tarSummary);
        add(scrollPane, BorderLayout.CENTER);
    }

    /**
     * Updates the text area with the current list of exercises.
     * This method constructs a summary of exercises and sets it as the text of the text area.
     */
    public void updateList() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Exercise exercise : exercises) {
            stringBuilder.append(exercise.toString()).append("\n");
        }
        tarSummary.setText(stringBuilder.toString());
    }

    /**
     * Sets the text of the summary label.
     *
     * @param text The text to be set on the summary label.
     */
    public void setSummaryLabel(String text) {
        lblSummary.setText(text);
    }
}