package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Gui extends Route {
    private JTextField searchField;

    Gui() {
        JFrame frame = new JFrame("CashFlow");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1921, 1080);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setPreferredSize(new Dimension(1921, 1080));
        mainPanel.setBackground(Color.WHITE);
        frame.getContentPane().add(mainPanel);

        // Create the navigation panel
        JPanel navigationPanel = new JPanel(new GridBagLayout());
        navigationPanel.setBackground(new Color(85, 52, 165));
        mainPanel.add(navigationPanel, BorderLayout.WEST);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(15, 0, 0, 0); // Add 10-pixel margin below each button

        ImageIcon logoIcon = new ImageIcon("/home/student_user/Desktop/CashFlow/Example/images/logo.png");
        JLabel logoLabel = new JLabel(logoIcon);
        logoLabel.setPreferredSize(new Dimension(200, 100));
        // logoLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        navigationPanel.add(logoLabel, gbc);

        String[] routes = { "Home", "Dashboard", "Deposit", "Expense", "Budgets", "Goal", "Report", "Analytics",
                "SignUp", "Suggestions", "AboutUs" };

        JPanel functionalityPanel = new JPanel(new BorderLayout());
        functionalityPanel.setBackground(Color.GREEN);
        mainPanel.add(functionalityPanel, BorderLayout.CENTER);

        // Create the top panel
        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(1921, 150));
        topPanel.setLayout(null);
        topPanel.setBackground(Color.decode("#A85CF9"));
        mainPanel.add(topPanel, BorderLayout.NORTH);

        searchField = new JTextField(20);
        searchField.setFont(new Font("Arial", Font.PLAIN, 14));
        searchField.setBounds(300, 30, 500, 35);

        // Create the search button
        JButton searchButton = new JButton("Search");
        searchButton.setFont(new Font("Arial", Font.BOLD, 14));
        searchButton.setBounds(800, 30, 100, 35);

        ImageIcon notifiImageIcon = new ImageIcon(
                "/home/student_user/Desktop/CashFlow/Example/icon/notification.png");
        JButton notificationLabel = new JButton(notifiImageIcon);
        notificationLabel.setBounds(1100, 30, 50, 35);

        // Helper method to read the contents of the credentials file

        JLabel userName = new JLabel("Md.Afsar Uddin");
        userName.setBounds(1180, 30, 120, 35);
        userName.setFont(new Font("Arial", Font.BOLD, 14));

        ImageIcon accountIcon = new ImageIcon("/home/student_user/Desktop/CashFlow/Example/icon/user.png");
        JLabel accountLabel = new JLabel(accountIcon);
        accountLabel.setBounds(1300, 30, 35, 35);

        // Add action listener to the search button
        searchButton.addActionListener(e -> {
            String searchText = searchField.getText();
            // Perform the search operation here
            // ...
            System.out.println(searchText);
            searchField.setText("");
        });

        JPanel logo = new JPanel(new GridBagLayout());
        logo.setBounds(0, 0, 250, 200);
        // logo.setBackground(Color.decode("#000000"));
        logo.setBackground(new Color(85, 52, 165));
        logo.add(logoLabel, gbc);

        topPanel.add(searchField);
        topPanel.add(searchButton);
        topPanel.add(notificationLabel);
        topPanel.add(userName);
        topPanel.add(accountLabel);
        topPanel.add(logo);

        for (String route : routes) {
            JButton routeButton = new JButton(route);
            routeButton.setPreferredSize(new Dimension(250, 40));

            routeButton.setForeground(Color.WHITE);
            routeButton.setBackground(new Color(85, 52, 165));
            routeButton.setFocusPainted(false);
            routeButton.setFocusable(true);
            routeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

            // Set icon for each button
            ImageIcon icon = new ImageIcon(
                    "/home/student_user/Desktop/CashFlow/Example/icon/" + route.toLowerCase() + ".png");
            if (icon != null) {
                Image scaledIcon = icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
                routeButton.setIcon(new ImageIcon(scaledIcon));
            }

            routeButton.addActionListener(e -> displayFunctionality(route, functionalityPanel));

            navigationPanel.add(routeButton, gbc);

            // Select the "SignUp" button by default
            if (route.equals("SignUp")) {
                routeButton.setSelected(true);
                displayFunctionality(route, functionalityPanel);
            }
        }

        frame.setVisible(true);
    }

    private static void displayFunctionality(String route, JPanel functionalityPanel) {
        functionalityPanel.removeAll();
        functionalityPanel.setLayout(new BorderLayout());

        // Create the specific functionality panel for the route
        JPanel routeFunctionalityPanel = getFunctionalityPanel(route);
        routeFunctionalityPanel.setBackground(Color.decode("#A85CF9"));
        routeFunctionalityPanel.setLayout(null);

        functionalityPanel.add(routeFunctionalityPanel, BorderLayout.CENTER);
        functionalityPanel.revalidate();
        functionalityPanel.repaint();
    }
}
