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

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Home extends Aboutus {

    public static JPanel createHomeInPanel() {
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

        JLabel titleLabel = new JLabel("Welcome Afsar !");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBounds(50, 10, 200, 50);

        signInPanel.add(titleLabel);

        signInPanel.setLayout(null);
        signInPanel.setBackground(Color.decode("#5534A5"));

        JLabel subLabel = new JLabel("CashFlow Will");
        subLabel.setForeground(Color.WHITE);
        subLabel.setFont(new Font("Arial", Font.BOLD, 16));
        subLabel.setBounds(50, 50, 150, 50);

        signInPanel.add(subLabel);

        JLabel Label = new JLabel("save your money !");
        Label.setForeground(Color.decode("#FFF800"));
        Label.setFont(new Font("Arial", Font.BOLD, 16));
        Label.setBounds(165, 50, 150, 50);

        signInPanel.add(Label);

        JLabel label = new JLabel("Money management is the art of balancing ");
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 16));
        label.setBounds(50, 200, 330, 50);

        signInPanel.add(label);

        JLabel label1 = new JLabel("your desires with your means, and finding harmony in both. ");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("Arial", Font.BOLD, 16));
        label1.setBounds(50, 240, 500, 50);

        signInPanel.add(label1);

        RoundedButton button = new RoundedButton("Deposit Now");
        button.setBounds(50, 410, 200, 30);
        signInPanel.add(button);
        button.setBackground(Color.decode("#4200FF"));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // set deposit
            }
        });

        ImageIcon HomeIcon = new ImageIcon("/home/student_user/Desktop/CashFlow/Example/icon/Money.png");
        JLabel homeImage = new JLabel(HomeIcon);
        homeImage.setBounds(700, 30, 300, 300);
        signInPanel.add(homeImage);

        return signInPanel;
    }

}
