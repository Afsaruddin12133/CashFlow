package Main;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignIn extends Home {

    public static JPanel createSignInPanel() {
        JPanel signInPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getBackground());
                g2.fill(getShape());
                g2.dispose();
            }

            @Override
            public boolean isOpaque() {
                return false;
            }

            private Shape getShape() {
                int width = getWidth();
                int height = getHeight();
                int arc = 15; // Border radius
                return new RoundRectangle2D.Double(0, 0, width - 1, height - 1, arc, arc);
            }
        };

        signInPanel.setLayout(null);
        signInPanel.setBackground(Color.decode("#5534A5"));
        // signInPanel.setBounds(350, 350, 1470, 630);

        JLabel titleLabel = new JLabel("Sign Up");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(500, 10, 100, 50);

        signInPanel.add(titleLabel);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setForeground(Color.decode("#A85CF9"));
        nameLabel.setFont(new Font("Arial", Font.BOLD, 12));
        signInPanel.add(nameLabel);
        nameLabel.setBounds(400, 100, 80, 30);

        JTextField nameField = new JTextField();
        signInPanel.add(nameField);
        nameField.setBounds(465, 100, 200, 30);
        nameField.setFont(new Font("Arial", Font.BOLD, 12));

        JLabel emailLabel = new JLabel("Email ID:");
        emailLabel.setForeground(Color.decode("#A85CF9"));
        emailLabel.setFont(new Font("Arial", Font.BOLD, 12));
        signInPanel.add(emailLabel);
        emailLabel.setBounds(400, 160, 80, 30);

        JTextField emailField = new JTextField();
        signInPanel.add(emailField);
        emailField.setBounds(465, 160, 200, 30);
        emailField.setFont(new Font("Arial", Font.BOLD, 12));

        JLabel passowLabel = new JLabel("Password: ");
        passowLabel.setFont(new Font("Arial", Font.BOLD, 12));
        passowLabel.setForeground(Color.decode("#A85CF9"));
        passowLabel.setBounds(400, 220, 80, 30);
        signInPanel.add(passowLabel);

        JPasswordField passwordFild = new JPasswordField();
        passwordFild.setBounds(465, 220, 200, 30);
        signInPanel.add(passwordFild);
        passwordFild.setFont(new Font("Arial", Font.BOLD, 12));

        RoundedButton button = new RoundedButton("Sign Up");
        button.setBounds(465, 280, 200, 30);
        signInPanel.add(button);
        button.setBackground(Color.decode("#4200FF"));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get user input
                String name = nameField.getText();
                String email = emailField.getText();
                String password = new String(passwordFild.getPassword());

                // Perform sign-up logic using file-based authentication
                try {
                    // Create a File object for the credentials file
                    File credentialsFile = new File("credentials.txt");

                    // Check if the file exists
                    if (!credentialsFile.exists()) {
                        credentialsFile.createNewFile();
                    }

                    // Check if the user already exists in the file
                    if (isUserExists(credentialsFile, email)) {
                        JOptionPane.showMessageDialog(null, "User already exists. Just Sing In", "Error",
                                JOptionPane.ERROR_MESSAGE);
                        return; // Exit the method if the user exists
                    }

                    // Append the new user's credentials to the file
                    BufferedWriter writer = new BufferedWriter(new FileWriter(credentialsFile, true));
                    writer.write(email + "," + password + "," + name + "\n");
                    writer.close();

                    // User signed up successfully
                    JOptionPane.showMessageDialog(null, "User signed up successfully.", "Success",
                            JOptionPane.INFORMATION_MESSAGE);

                    // Clear input fields after sign-up
                    nameField.setText("");
                    emailField.setText("");
                    passwordFild.setText("");

                } catch (IOException ex) {
                    // An error occurred during sign-up
                    JOptionPane.showMessageDialog(null, "Sign-up error: " + ex.getMessage(), "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        ImageIcon facebookIcon = new ImageIcon("/home/student_user/Desktop/CashFlow/Example/icon/facebook.png");
        RoundedButton facebookButton = new RoundedButton("Facebook");
        facebookButton.setBounds(465, 330, 200, 30);
        signInPanel.add(facebookButton);
        facebookButton.setIcon(facebookIcon);
        facebookButton.setBackground(Color.decode("#3b5998"));
        facebookButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        facebookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("From FaceBook");

                // Implement Facebook authentication logic here

                // Clear input fields after sign-in

            }
        });

        ImageIcon GoogleIcon = new ImageIcon("/home/student_user/Desktop/CashFlow/Example/icon/google.png");
        RoundedButton googlebButton = new RoundedButton("Google");
        googlebButton.setBounds(465, 380, 200, 30);
        signInPanel.add(googlebButton);
        googlebButton.setIcon(GoogleIcon);
        googlebButton.setBackground(Color.decode("#0F9D58"));
        googlebButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        googlebButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("From Google");

                // Implement Google authentication logic here

                // Clear input fields after sign-in

            }
        });

        JLabel singLabel = new JLabel("Already have an account?");
        singLabel.setForeground(Color.WHITE);
        singLabel.setFont(new Font("Arial", Font.BOLD, 16));
        singLabel.setBounds(465, 410, 200, 50);

        signInPanel.add(singLabel);

        RoundedButton singinButton = new RoundedButton("Sign In");
        singinButton.setBounds(465, 460, 200, 30);
        signInPanel.add(singinButton);
        singinButton.setBackground(Color.decode("#4200FF"));
        singinButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return signInPanel;
    }

    // Helper method to check if a user already exists in the credentials file
    private static boolean isUserExists(File credentialsFile, String email) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(credentialsFile));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] credentials = line.split(",");
            if (credentials.length == 3 && credentials[0].equals(email)) {
                reader.close();
                return true; // User exists
            }
        }
        reader.close();
        return false; // User does not exist
    }

}
