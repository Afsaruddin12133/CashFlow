package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Suggestion extends Deposit {

    public static JPanel createSuggestonInPanel() {
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
        JLabel label = new JLabel("<html><center><h1>Suggestion - CashFlow</h1></center><br><br>"
                + "<p>No suggestion are available</p></html>");

        label.setFont(new Font("Arial", Font.PLAIN, 14));
        label.setBounds(50, 10, 1000, 200);
        signInPanel.add(label);
        signInPanel.setLayout(null);
        signInPanel.setBackground(Color.decode("#5534A5"));
        label.setForeground(Color.WHITE);

        return signInPanel;
    }

}
