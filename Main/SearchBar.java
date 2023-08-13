package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchBar extends JFrame {

    private JTextField searchField;

    public SearchBar() {
        setTitle("Search Bar Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Create the search field
        searchField = new JTextField(20);
        searchField.setFont(new Font("Arial", Font.PLAIN, 14));
        searchField.setPreferredSize(new Dimension(200, 30));

        // Create the search button
        JButton searchButton = new JButton("Search");
        searchButton.setFont(new Font("Arial", Font.BOLD, 14));
        searchButton.setPreferredSize(new Dimension(100, 30));

        // Add action listener to the search button
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchText = searchField.getText();
                // Perform the search operation here
                // ...
                JOptionPane.showMessageDialog(SearchBar.this, "Searching for: " + searchText);
            }
        });

        // Add components to the frame
        add(searchField);
        add(searchButton);

        pack();
        setLocationRelativeTo(null);
    }
}