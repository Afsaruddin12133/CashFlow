package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Aboutus extends Suggestion {

    public static JPanel createAboutInPanel() {
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
        JLabel label = new JLabel("<html><center><h1>About Us - CashFlow</h1></center><br><br>"
                + "<p>CashFlow is a powerful money management app that helps you take control of your finances. "
                + "Our mission is to provide you with the tools and insights you need to make informed financial decisions "
                + "and achieve your financial goals.</p>"
                + "<p>With CashFlow, you can easily track your income and expenses, create budgets, set savings goals, "
                + "and analyze your spending patterns. Our intuitive interface and comprehensive features make it simple "
                + "and convenient to manage your money effectively.</p>"
                + "<p>Whether you're an individual, a small business owner, or a budget-conscious family, CashFlow is "
                + "designed to meet your unique financial needs. Join thousands of satisfied users who have transformed "
                + "their financial lives with CashFlow.</p>"
                + "<p>Start your journey to financial success today with CashFlow!</p></html>");

        label.setFont(new Font("Arial", Font.PLAIN, 14));
        label.setBounds(50, 10, 1000, 500);
        signInPanel.add(label);
        signInPanel.setLayout(null);
        signInPanel.setBackground(Color.decode("#5534A5"));
        label.setForeground(Color.WHITE);

        return signInPanel;
    }

}
