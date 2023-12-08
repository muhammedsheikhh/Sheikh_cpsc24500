import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JFileChooser;
import java.io.*;
import java.text.ParseException;

/**
 * This class represents the main frame of the Exercise Tracker application.
 * It includes menu items, detail panels, and controls for managing exercises.
 */
public class MainFrame extends JFrame implements ActionListener {
    private ArrayList<Exercise> exercises;
    private JMenuItem miAbout;
    private JMenuItem miLogin;
    private JMenuItem miLogout;
    private JMenuItem miSave;
    private JMenuItem miExit;
    private ExerciseDetailPanel exerciseDetailPanel;
    private SummaryPanel summaryPanel;
    private JButton btnAddExercise;

    /**
     * Constructor for MainFrame.
     * Initializes the frame with a list of exercises and sets up the GUI and menu.
     *
     * @param exercises An ArrayList of Exercise objects to be managed.
     */
    public MainFrame(ArrayList<Exercise> exercises) {
        this.exercises = exercises;
        setupGUI();
        setupMenu();
    }

    /**
     * Sets up the menu bar with various menu items.
     */
    private void setupMenu() {
        JMenuBar mbar = new JMenuBar();
        setJMenuBar(mbar);
        JMenu mnuFile = new JMenu("File");
        mbar.add(mnuFile);
        miAbout = new JMenuItem("About");
        miLogin = new JMenuItem("Log in");
        miLogout = new JMenuItem("Log out");
        miSave = new JMenuItem("Save");
        miExit = new JMenuItem("Exit");

        miAbout.addActionListener(this);
        miLogin.addActionListener(this);
        miLogout.addActionListener(this);
        miSave.addActionListener(this);
        miExit.addActionListener(this);

        mnuFile.add(miLogin);
        mnuFile.add(miLogout);
        mnuFile.add(miSave);
        mnuFile.add(miExit);

        JMenu mnuHelp = new JMenu("Help");
        mbar.add(mnuHelp);
        JMenuItem miAbout = new JMenuItem("About");
        miAbout.addActionListener(this);
        mnuHelp.add(miAbout);

    }

    /**
     * Sets up the graphical user interface of the main frame.
     * This method initializes the layout, panels, and buttons.
     */
    private void setupGUI() {
        setBounds(100,100,700,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Exercise Tracker V2.0");
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        exerciseDetailPanel = new ExerciseDetailPanel();
        summaryPanel = new SummaryPanel(exercises);
        c.add(exerciseDetailPanel, BorderLayout.WEST);
        c.add(summaryPanel, BorderLayout.EAST);

        JPanel panSouth = new JPanel();
        btnAddExercise = new JButton("Add Exercise");
        btnAddExercise.addActionListener(this);
        panSouth.setLayout(new FlowLayout());
        panSouth.add(btnAddExercise);
        c.add(panSouth, BorderLayout.SOUTH);

        setupMenu();
        enableEntries(false); // disables all the entries at the start
    }

    /**
     * Handles action events triggered by menu items and buttons.
     * Overrides the actionPerformed method from the ActionListener interface.
     *
     * @param e The ActionEvent object containing details about the event.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == miAbout) {
            JOptionPane.showMessageDialog(this, "ExerciseTracker V2.0 - CPSC 24500 Fall 2023", "About", JOptionPane.INFORMATION_MESSAGE);
        } else if(e.getSource() == miLogin) {
            performLogin();
        } else if (e.getSource() == miLogout) {
            performLogout();
        } else if (e.getSource() == miSave) {
            performSave();
        } else if (e.getSource() == miExit) {
            System.exit(0);
        } else if (e.getSource() == btnAddExercise) {
            addNewExercise();
        }
    }

    /**
     * Performs actions related to the login process.
     * Opens the login form and enables entries if login is successful.
     */
    private void performLogin() {
        LoginForm loginForm = new LoginForm(this);
        loginForm.setVisible(true);
        if (loginForm.isLoggedIn()) {
            enableEntries(true);
            miLogin.setEnabled(false);
            miLogout.setEnabled(true);
        }
    }

    /**
     * Performs actions related to the logout process.
     * Disables entries and updates the menu item states.
     */
    private void performLogout() {
        enableEntries(false);
        miLogin.setEnabled(true);
        miLogout.setEnabled(false);
    }

    /**
     * Performs actions to save the current state of exercises to a file.
     * Opens a file chooser and writes data using ExerciseWriter.
     */
    private void performSave() {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            if (ExerciseWriter.writeToFile(file, exercises)) {
                JOptionPane.showMessageDialog(this, "Exercises saved successfully to " + file.getPath());
            } else {
                JOptionPane.showMessageDialog(this, "Error: Could not save the exercises.", "Save Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Adds a new exercise to the list based on the inputs from the detail panel.
     * Validates inputs and updates the summary panel.
     */
    private void addNewExercise() {
        try {
            String name = exerciseDetailPanel.getName();
            String date = exerciseDetailPanel.getDate(); // Ensure this date string is in "MM/dd/yyyy" format
            int duration = exerciseDetailPanel.getDuration();
            double distance = exerciseDetailPanel.getDistance(); // Get the distance
            String comment = exerciseDetailPanel.getComment();

            Exercise newExercise = new RunWalk(name, date, duration, distance);
            newExercise.setComment(comment);
            exercises.add(newExercise);
            summaryPanel.updateList();
        } catch (ParseException pe) {
            JOptionPane.showMessageDialog(this, "Invalid date format. Please enter date in MM/dd/yyyy format.", "Date Format Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Enables or disables input fields and the add exercise button.
     *
     * @param enableYN Boolean indicating whether to enable (true) or disable (false) the components.
     */
    private void enableEntries(boolean enableYN) {
        exerciseDetailPanel.enableEntries(enableYN);
        btnAddExercise.setEnabled(enableYN);
    }


}
