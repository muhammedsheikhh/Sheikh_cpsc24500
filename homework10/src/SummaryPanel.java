import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import java.util.ArrayList;
import javax.swing.*;

public class SummaryPanel extends JPanel {
    private ArrayList<Exercise> exercises;
    private JTextArea tarSummary;
    private JLabel lblSummary;

    public SummaryPanel(ArrayList<Exercise> exercises) {
        this.exercises = exercises;
        setupGUI();
    }

    public void setupGUI() {
        setLayout(new BorderLayout());
        lblSummary = new JLabel("Exercise Summary");
        add(lblSummary, BorderLayout.NORTH);

        tarSummary = new JTextArea(10, 30);
        tarSummary.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(tarSummary);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void updateList() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Exercise exercise : exercises) {
            stringBuilder.append(exercise.toString()).append("\n");
        }
        tarSummary.setText(stringBuilder.toString());
    }

    public void setSummaryLabel(String text) {
        lblSummary.setText(text);
    }
}