package Auth;

import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class SignUp {

    public SignUp() {

        JFrame frame = new JFrame("Sign Up");
        frame.setSize(900, 700);
        frame.getContentPane().setBackground(new Color(18, 18, 18));
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // =========== Scale image =========== //
        ImageIcon icon = new ImageIcon("Auth/images.jpeg");
        Image img = icon.getImage().getScaledInstance(
                1300, 700, Image.SCALE_SMOOTH);

        JLabel background = new JLabel(new ImageIcon(img));
        background.setBounds(0, 0, 800, 700);
        background.setLayout(null);

        // =========== Panel =========== //
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(450, 80, 450, 550);
        panel.setBackground(new Color(30, 30, 30));

        // =========== Label CREATE ACCOUNT =========== //
        JLabel label = new JLabel("Create Account");
        label.setBounds(100, 20, 180, 60);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Segoe UI", Font.BOLD, 20));

        // =========== firstName FOR NAME =========== //
        JTextField firstName = new JTextField();
        firstName.setBounds(80, 80, 180, 30);
        firstName.setText("First Name");
        firstName.setBackground(new Color(45, 45, 45));
        firstName.setForeground(Color.WHITE);
        firstName.setCaretColor(Color.WHITE);
        firstName.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        firstName.setBorder(new LineBorder(new Color(80,80,80), 3 , true));
        firstName.addFocusListener(new FocusAdapter() {
        public void focusGained(FocusEvent e) {
        if (firstName.getText().equals("First Name")) {
        firstName.setText("");
        }
        }

        public void focusLost(FocusEvent e)
        {
            if(firstName.getText().trim().isEmpty())
            {
                firstName.setText("First Name");
                firstName.setForeground(Color.GRAY);
            }
        }
        });

        panel.add(label);
        panel.add(firstName);
        frame.add(panel);
        // =========== Add panel ON the background =========== //
        background.add(panel);

        // =========== Make background the content pane =========== //
        frame.setContentPane(background);

        frame.setVisible(true);
    }
}