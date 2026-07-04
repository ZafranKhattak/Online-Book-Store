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
        firstName.setBorder(new LineBorder(new Color(80, 80, 80), 3, true));

        // ========= FUNCITON ==============
        firstName.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (firstName.getText().equals("First Name")) {
                    firstName.setText("");
                }
            }

            public void focusLost(FocusEvent e) {
                if (firstName.getText().trim().isEmpty()) {
                    firstName.setText("First Name");
                    firstName.setForeground(Color.GRAY);
                }
            }
        });

        // =================== Middle Name ===============

        JTextField middleName = new JTextField();
        middleName.setBounds(80, 120, 180, 30);
        middleName.setText("Middle Name");
        middleName.setBackground(new Color(45, 45, 45));
        middleName.setForeground(Color.WHITE);
        middleName.setCaretColor(Color.WHITE);
        middleName.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        middleName.setBorder(new LineBorder(new Color(80, 80, 80), 3, true));

        middleName.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (middleName.getText().equals("middleName")) {
                    middleName.setText("");
                }
            }

            public void focusLost(FocusEvent e) {
                if (middleName.getText().trim().isEmpty()) {
                    middleName.setText("Middle Name");
                    middleName.setBackground(Color.GRAY);
                }
            }
        });

        // ============== LAST NAME ================= //

        JTextField lastName = new JTextField();
        lastName.setBounds(80, 160, 180, 30);
        lastName.setText("Last Name");
        lastName.setBackground(new Color(45, 45, 45));
        lastName.setForeground(Color.WHITE);
        lastName.setCaretColor(Color.WHITE);
        lastName.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lastName.setBorder(new LineBorder(new Color(80, 80, 80), 3, true));

        lastName.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (lastName.getText().equals("Last Name")) {
                    lastName.setText("");
                }
            }

            public void focusLost(FocusEvent e) {
                if (lastName.getText().trim().isEmpty()) {
                    lastName.setText("Last Name");
                    lastName.setBackground(Color.GRAY);
                }
            }
        });


        // =============== EMAIL  ============= //

        JTextField email = new JTextField();
        email.setText("Email");
        email.setBounds(80 , 200 , 180 , 30);
        email.setForeground(Color.WHITE);
        email.setCaretColor(Color.WHITE);
        email.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        email.setBorder(new LineBorder(new Color(80, 80, 80), 3, true));

        email.addFocusListener(new FocusAdapter() {
            
                public void focusGained(FocusEvent e) 
                {
                if (email.getText().equals("Email"))
                {
                    email.setText("");
                }
            }

            public void focusLost(FocusEvent e)
            {
                if (email.getText().trim().isEmpty())
                {
                    email.setText("Email");
                    email.setBackground(Color.gray);

                }
            }
            
        });





        panel.add(label);
        panel.add(firstName);
        panel.add(middleName);
        panel.add(lastName);
        panel.add(email);

        frame.add(panel);
        // =========== Add panel ON the background =========== //
        background.add(panel);

        // =========== Make background the content pane =========== //
        frame.setContentPane(background);

        frame.setVisible(true);
    }
}