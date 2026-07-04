package Auth;

import java.sql.*;
import java.awt.*;
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
        ImageIcon icon = new ImageIcon("Auth/a.jpg");
        Image img = icon.getImage().getScaledInstance(
                1300, 700, Image.SCALE_SMOOTH);

        JLabel background = new JLabel(new ImageIcon(img));
        background.setBounds(0, 0, 800, 700);
        background.setLayout(null);

        // =========== Panel =========== //
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(450, 45, 450, 600);
        panel.setBackground(new Color(30, 30, 30));

        // =========== Label CREATE ACCOUNT =========== //
        JLabel label = new JLabel();
        label.setText("Create Account");
        label.setBounds(150, 20, 180, 60);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Segoe UI", Font.BOLD, 20));

        // =========== firstName FOR NAME =========== //
        JLabel l1 = new JLabel();
        l1.setText("First Name:");
        l1.setBounds(80 , 70 , 100 , 30);
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Arial", Font.BOLD, 15));
        JTextField firstName = new JTextField();
        firstName.setBounds(80, 100, 280, 35);
        firstName.setBackground(new Color(45, 45, 45));
        firstName.setForeground(Color.WHITE);
        firstName.setCaretColor(Color.WHITE);
        firstName.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        firstName.setBorder(new LineBorder(new Color(80, 80, 80), 3, true));

        // =================== Middle Name ===============
        JLabel l2 = new JLabel();
        l2.setText("Middle Name");
        l2.setBounds(80 , 130 , 100 , 30);
        l2.setForeground(Color.white);
        l2.setFont(new Font("Arial" , Font.BOLD , 15));
        JTextField middleName = new JTextField();
        middleName.setBounds(80, 160,  280, 35);
        middleName.setBackground(new Color(45, 45, 45));
        middleName.setForeground(Color.WHITE);
        middleName.setCaretColor(Color.WHITE);
        middleName.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        middleName.setBorder(new LineBorder(new Color(80, 80, 80), 3, true));

        // ============== LAST NAME ================= //
        JLabel l3 = new JLabel();
        l3.setText("Last Name");
        l3.setBounds(80 , 190 , 100 , 30);
        l3.setForeground(Color.white);
        l3.setFont(new Font("Arial" , Font.BOLD , 15));
        JTextField lastName = new JTextField();
        lastName.setBounds(80, 220,  280, 35);
        lastName.setBackground(new Color(45, 45, 45));
        lastName.setForeground(Color.WHITE);
        lastName.setCaretColor(Color.WHITE);
        lastName.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        lastName.setBorder(new LineBorder(new Color(80, 80, 80), 3, true));

        // =============== EMAIL ============= //

        JLabel l4 = new JLabel();
        l4.setText("Email:");
        l4.setBounds(80 , 260 , 100 , 30);
        l4.setForeground(Color.WHITE);
        l4.setFont(new Font("Arial" , Font.BOLD , 15));
        JTextField email = new JTextField();
        email.setBounds(80, 290,  280, 35);
        email.setBackground(new Color(45, 45, 45));
        email.setForeground(Color.WHITE);
        email.setCaretColor(Color.WHITE);
        email.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        email.setBorder(new LineBorder(new Color(80, 80, 80), 3, true));

        // =============== PASSWORD =========== //
        JLabel l5 = new JLabel();
        l5.setText("Password:");
        l5.setBounds(80,320 , 100 , 30);
        l5.setForeground(Color.WHITE);
        l5.setFont(new Font("Arial" , Font.BOLD , 15));
        JPasswordField password = new JPasswordField();
        password.setBounds(80, 350,  280, 35);
        password.setBackground(new Color(45, 45, 45));
        password.setForeground(Color.WHITE);
        password.setCaretColor(Color.WHITE);
        password.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        password.setBorder(new LineBorder(new Color(80, 80, 80), 3, true));

        // ================= CONFIRM PASSWORD ============== //
        JLabel l6 = new JLabel();
        l6.setText("Confirm Password:");
        l6.setBounds(80 , 380 , 170 , 30);
        l6.setForeground(Color.WHITE);
        l6.setFont(new Font("Arial" , Font.BOLD , 15));
        JPasswordField confirmPass = new JPasswordField();
        confirmPass.setBounds(80, 410,  280, 35);
        confirmPass.setBackground(new Color(45, 45, 45));
        confirmPass.setForeground(Color.WHITE);
        confirmPass.setCaretColor(Color.WHITE);
        confirmPass.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        confirmPass.setBorder(new LineBorder(new Color(80, 80, 80), 3, true));

        // ================== BUTTON LISTENER ===================== //

        JButton button = new JButton();
        button.setText("Sign Up");
        button.setBounds(80, 470, 300, 45);
        button.setBackground(Color.blue);
        button.setFont(new Font("Arial", Font.BOLD, 15));
        button.setForeground(Color.white);

        button.addActionListener(e -> {

            String userFirstName = firstName.getText().trim();
            String userMiddleName = middleName.getText().trim();
            String userLastName = lastName.getText().trim();
            String userEmail = email.getText().trim();
            String userPassword = String.valueOf(password.getPassword());
            String confirmPassword = String.valueOf(confirmPass.getPassword());

            if (userFirstName.isEmpty())
            {
                JOptionPane.showMessageDialog(null , "First Name is required");
                return;
            }

            if (userLastName.isEmpty())
            {
                JOptionPane.showMessageDialog(null , "Last Name is required");
                return;
            }

            if (!userEmail.contains("@gmail.com"))
            {
                JOptionPane.showMessageDialog(null , "Please enter a valid Gmail address");
                return;
            }
            if (userEmail.isEmpty())
            {
                JOptionPane.showMessageDialog(null , "Email is required");
                return;
            }

            if (userPassword.isEmpty())
            {
                JOptionPane.showMessageDialog(null , "password is required");
                return;
            }
            if (userPassword.length() < 8) {
                JOptionPane.showMessageDialog(null, "password must at least 8 characters");
                return;
            }
            if (!confirmPassword.equals(userPassword))
            {
                JOptionPane.showMessageDialog(null , "password does not match");
                return;
            }

            try {

                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ONLINE_STORE",
                        "root",
                        "ZafranKhan@06");

                String query = "INSERT INTO Users(first_name, middle_name, last_name, email, password) VALUES (?, ?, ?, ?, ?)";

                PreparedStatement statement = connection.prepareStatement(query);

                statement.setString(1, userFirstName);
                statement.setString(2, userMiddleName);
                statement.setString(3, userLastName);
                statement.setString(4, userEmail);
                statement.setString(5, userPassword);

                int rows = statement.executeUpdate();

                if (rows > 0) {
                    JOptionPane.showMessageDialog(null, "Account Created Successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to Create Account");
                }

                statement.close();
                connection.close();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

        });

        //  ================== LINK TO SIGN IN ================ 

        JButton btn = new JButton();
        btn.setText("Sign In");
        btn.setBounds(80, 520, 300, 45);
        btn.setBackground(Color.red);
        btn.setFont(new Font("Arial", Font.BOLD, 15));
        btn.setForeground(Color.black);
        btn.addActionListener(e ->
            {
               new SignIn();
               frame.dispose();
            }
        );




        //================================================================================//
        panel.add(label);
        panel.add(l1);
        panel.add(l2);
        panel.add(l3);
        panel.add(l4);
        panel.add(l5);
        panel.add(l6);
        panel.add(firstName);
        panel.add(middleName);
        panel.add(lastName);
        panel.add(email);
        panel.add(password);
        panel.add(confirmPass);
        panel.add(button);
        panel.add(btn);
        frame.add(panel);
        // =========== Add panel ON the background =========== //
        background.add(panel);

        // =========== Make background the content pane =========== //
        frame.setContentPane(background);

        frame.setVisible(true);
    }
}