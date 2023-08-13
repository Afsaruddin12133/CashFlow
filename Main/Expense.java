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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Expense extends Budget{

    public static JPanel createExpenseInPanel() {
        JPanel panel = new JPanel() {
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
        panel.setLayout(null);
        panel.setBackground(Color.decode("#5534A5"));

        JLabel titleLabel = new JLabel("Expense Money");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(500, 10, 300, 50);

        panel.add(titleLabel);

        JLabel nameLabel = new JLabel("Amount:");
        nameLabel.setForeground(Color.decode("#A85CF9"));
        nameLabel.setFont(new Font("Arial", Font.BOLD, 12));
        panel.add(nameLabel);
        nameLabel.setBounds(350, 100, 80, 30);

        JTextField nameField = new JTextField();
        panel.add(nameField);
        nameField.setBounds(465, 100, 200, 30);
        nameField.setFont(new Font("Arial", Font.BOLD, 12));

        JLabel emailLabel = new JLabel("Expense Categories:");
        emailLabel.setForeground(Color.decode("#A85CF9"));
        emailLabel.setFont(new Font("Arial", Font.BOLD, 12));
        panel.add(emailLabel);
        emailLabel.setBounds(350, 160, 200, 30);

        JTextField emailField = new JTextField();
        panel.add(emailField);
        emailField.setBounds(465, 160, 200, 30);
        emailField.setFont(new Font("Arial", Font.BOLD, 12));

        JLabel passowLabel = new JLabel("Expense Massage: ");
        passowLabel.setFont(new Font("Arial", Font.BOLD, 12));
        passowLabel.setForeground(Color.decode("#A85CF9"));
        passowLabel.setBounds(350, 220, 200, 30);
        panel.add(passowLabel);

        JPasswordField passwordFild = new JPasswordField();
        passwordFild.setBounds(465, 220, 200, 30);
        panel.add(passwordFild);
        passwordFild.setFont(new Font("Arial", Font.BOLD, 12));

        RoundedButton button = new RoundedButton("Expense");
        button.setBounds(465, 320, 200, 30);
        panel.add(button);
        button.setBackground(Color.decode("#FF2689"));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(null, "Expense Success.", "Success",
                        JOptionPane.INFORMATION_MESSAGE);
                nameField.setText("");
                emailField.setText("");
                passwordFild.setText("");

            }
        });
        JLabel dateLabel = new JLabel("Date & Time:");
        dateLabel.setFont(new Font("Arial", Font.BOLD, 12));
        dateLabel.setForeground(Color.decode("#A85CF9"));
        dateLabel.setBounds(350, 270, 200, 30);
        JTextField dateField = new JTextField(getCurrentDateTime());
        dateField.setBounds(465, 270, 200, 30);

        panel.add(dateLabel);
        panel.add(dateField);

        return panel;
    }

    private static String getCurrentDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }

}
