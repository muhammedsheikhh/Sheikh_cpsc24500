import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import java.awt.Container;
import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.Dimension;



public class LoginForm extends JDialog {
    private JTextField txtUsername;
    private boolean loggedIn; // Flag to indicate if the user is logged in
    private String password; // The password to check against
    private JPasswordField txtPassword; // Field where user enters the password


    public LoginForm(JFrame owner) {
        super(owner, "Login", true); // Call to super, setting the dialog as modal
        setupGUI();
        password = "exercise"; // The correct password, replace with your desired password
        loggedIn = false; // Initially, the user is not logged in
    }

    private void setupGUI() {
        // Set the title of the dialog
        setTitle("Please log in");

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(getParent()); // Center the dialog relative to the parent frame

        Container c = getContentPane();
        c.setLayout(new BorderLayout(10, 10)); // Add some spacing between components

        // Using GridLayout for input fields
        JPanel inputPanel = new JPanel(new GridLayout(2, 1, 5, 5)); // 2 rows, 1 column, 5px padding
        inputPanel.add(new JLabel("Username"));
        txtUsername = new JTextField(10);
        inputPanel.add(txtUsername);
        inputPanel.add(new JLabel("Password"));
        txtPassword = new JPasswordField(10);
        inputPanel.add(txtPassword);
        c.add(inputPanel, BorderLayout.CENTER);

        // Using BoxLayout for buttons to stack them vertically
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
        JButton btnOK = new JButton("Log In");
        JButton btnCancel = new JButton("Cancel");

        // Create some space between the buttons and align them in the center
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(btnOK);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 0))); // Space between buttons
        buttonPanel.add(btnCancel);
        buttonPanel.add(Box.createHorizontalGlue());

        c.add(buttonPanel, BorderLayout.SOUTH);

        // Add action listeners
        btnOK.addActionListener(e -> attemptLogin());
        btnCancel.addActionListener(e -> cancelLogin());

        pack(); // Size the dialog to fit the preferred sizes of its components
        setResizable(false); // Prevent resizing
    }


    private void attemptLogin() {
        if (checkPassword()) {
            loggedIn = true;
            setVisible(false); // Hide the dialog if the login is successful
        } else {
            JOptionPane.showMessageDialog(this, "You entered an incorrect password.", "Error", JOptionPane.ERROR_MESSAGE);
            txtPassword.setText(""); // Clear the password field
            loggedIn = false;
        }
    }

    private void cancelLogin() {
        loggedIn = false;
        setVisible(false); // Hide the dialog if the user cancels
    }

    private boolean checkPassword() {
        String enteredUsername = txtUsername.getText();
        String enteredPassword = new String(txtPassword.getPassword());
        return enteredUsername.equals("test") && enteredPassword.equals(password);
    }
    public boolean isLoggedIn() {
        return loggedIn;
    }


}
