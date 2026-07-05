package Auth;

import Dashboard.Dashboard;
import java.sql.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class SignIn {
    public SignIn() {

        JFrame frame = new JFrame();
        frame.setTitle("Online Store");
        frame.setSize(900, 700);

        // ===== BACKGROUND COLOR OF FRAME ========== //
        frame.getContentPane().setBackground(new Color(18, 18, 18));

        // ============ IMAGE BACKGROUND ============== //

        ImageIcon icon = new ImageIcon("Auth/b.jpg");
        Image img = icon.getImage().getScaledInstance(
                1300, 700, Image.SCALE_SMOOTH);

        JLabel background = new JLabel(new ImageIcon(img));
        background.setBounds(0, 0, 900, 600);
        background.setLayout(null);

        // =============== JPANEL LOGIC =============== //
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(450, 120, 400, 450);
        panel.setBackground(new Color(30, 30, 30));

        // ============ LABEL 2 LOGIN =================//
        JLabel label2 = new JLabel();
        label2.setText("<html><u>Log In</u></html>");
        label2.setForeground(Color.WHITE);
        label2.setBounds(150, 10, 90, 25);
        label2.setFont(new Font("Arial", Font.BOLD, 25));
        label2.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // ============ LABEL 3 CREDENTIAL ============== //
        JLabel label3 = new JLabel();
        label3.setText("Log in to your account by adding your credential");
        label3.setForeground(Color.white);
        label3.setFont(new Font("Arial", Font.ITALIC, 15));
        label3.setBounds(30, 50, 350, 45);

        // =============== JTEXTFEILD NAME LOGIC =============== //

        JTextField email = new JTextField();
        email.setText("Enter your name");

        email.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (email.getText().equals("Enter your name")) {
                    email.setText("");
                }
            }

            public void focusLost(FocusEvent e) {
                if (email.getText().trim().isEmpty()) {
                    email.setText("Enter your name");
                    email.setForeground(Color.GRAY);
                }
            }
        });
        email.setBounds(30, 120, 350, 40);
        email.setBackground(new Color(45, 45, 45));
        email.setForeground(Color.WHITE);
        email.setCaretColor(Color.WHITE);
        email.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        email.setBorder(new LineBorder(new Color(80, 80, 80), 3, true));

        // ============== PASSWORD LOGIC ================ //
        JPasswordField password = new JPasswordField();
        password.setBounds(30, 180, 350, 40);
        password.setBackground(new Color(45, 45, 45));
        password.setForeground(Color.GRAY);
        password.setText("Enter your password");
        password.setEchoChar((char) 0); // Show placeholder text
        password.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (String.valueOf(password.getPassword()).equals("Enter your password")) {
                    password.setText("");
                    password.setEchoChar('•'); // Hide typed characters
                }
            }

            public void focusLost(FocusEvent e) {
                if (password.getPassword().length == 0) {
                    password.setEchoChar((char) 0);
                    password.setText("Enter your password");
                    password.setForeground(Color.gray);
                }
            }
        });
        password.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        password.setBorder(new LineBorder(new Color(80, 80, 80), 3, true));

        // =============== SIGN IN BUTTON ============== //
        JButton button = new JButton();
        button.setBounds(30, 250, 350, 45);
        button.setBackground(Color.BLUE);
        button.setText("Sign In");
        button.setForeground(Color.WHITE);

        button.addActionListener(e -> {

            String userEmail = email.getText().trim();
            String userPassword = String.valueOf(password.getPassword());

            if (userPassword.length() < 8) {
                JOptionPane.showMessageDialog(null, "Password must be at least 8 characters.");
                return;
            }

            try {
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ONLINE_STORE",
                        "root",
                        "ZafranKhan@06");

                String query = "SELECT * FROM USERS WHERE EMAIL = ? AND PASSWORD = ?";

                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, userEmail);
                statement.setString(2, userPassword);

                ResultSet rs = statement.executeQuery();

                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Login Successful");
                    new Dashboard();
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Email or Password");
                    return;
                }

                rs.close();
                statement.close();
                connection.close();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        });
        // =========== IF NOT SIGN IN THEN SIGN UP USING LINK

        JLabel label4 = new JLabel();
        label4.setLayout(null);
        label4.setBounds(30, 300, 350, 30);
        label4.setForeground(Color.WHITE);
        label4.setText("<html>Do not have Account ? <font color = 'blue'><u> Sign Up </u> </font><html>");

        label4.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                new SignUp();
                frame.dispose();
            }
        });
        label4.setCursor(new Cursor(Cursor.HAND_CURSOR));

        panel.add(button);
        panel.add(email);
        panel.add(password);
        panel.add(label2);
        panel.add(label3);
        panel.add(label4);
        frame.add(panel);

        // ========= Add panel ON the background ========== //

        background.add(panel);

        // ======== Make background the content pane =========== //

        frame.setContentPane(background);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}