package Main;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Route extends SignIn {

    private static JPanel functionalityPanel;

    public static JPanel getFunctionalityPanel(String route) {
        JPanel routePanel = new JPanel();
        routePanel.setLayout(null);
        routePanel.setBackground(Color.WHITE);
        routePanel.setBounds(0, 0, 1621, 830);

        switch (route) {
            case "Home":
                JPanel homeInPanel = createHomeInPanel();
                homeInPanel.setBounds(50, 0, 1015, 510);
                routePanel.add(homeInPanel);
                break;
            case "Dashboard":
                // Create and customize the functionality panel for the Dashboard route
                routePanel.setBackground(Color.YELLOW);
                JLabel dashboardLabel = new JLabel("Dashboard Functionality");
                routePanel.add(dashboardLabel);
                break;
            case "Expense":
                JPanel expenseInPanel = createExpenseInPanel();
                expenseInPanel.setBounds(50, 0, 1015, 510);
                routePanel.add(expenseInPanel);
                break;
            case "Deposit":
                JPanel depositInPanel = createDepositInPanel();
                depositInPanel.setBounds(50, 0, 1015, 510);
                routePanel.add(depositInPanel);
                break;
        case "Budgets":
                JPanel budgetsInPanel = createBudgetInPanel();
                budgetsInPanel.setBounds(50, 0, 1015, 510);
                routePanel.add(budgetsInPanel);
                break;
            case "Goal":
                JPanel goalInPanel = createGoalInPanel();
                goalInPanel.setBounds(50, 0, 1015, 510);
                routePanel.add(goalInPanel);
                break;

            case "SignUp":
                JPanel signInPanel = createSignInPanel();
                signInPanel.setBounds(50, 0, 1015, 510);
                routePanel.add(signInPanel);
                break;
            case "Suggestions":
                JPanel suggestionInPanel = createSuggestonInPanel();
                suggestionInPanel.setBounds(50, 0, 1015, 510);
                routePanel.add(suggestionInPanel);
                break;
            case "AboutUs":
                JPanel aboutInPanel = createAboutInPanel();
                aboutInPanel.setBounds(50, 0, 1015, 510);
                routePanel.add(aboutInPanel);
                break;
            default:
                JLabel defaultLabel = new JLabel("Functionality not implemented yet");
                routePanel.add(defaultLabel);
                break;
        }

        return routePanel;
    }
}
