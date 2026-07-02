package Auth;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class SignIn
{
    public SignIn()
    {

        JFrame frame = new JFrame();
        frame.setTitle("Online Store");
        frame.setSize(400 , 400);

        // ===== BACKGROUND COLOR OF FRAME ========== //
        frame.getContentPane().setBackground(new Color(18, 18, 18));

        // ===== BACKGROUND TEXT OF FRAME ========== //

        JLabel label = new JLabel();
        label.setText("Welcome Dear");
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial" , Font.BOLD , 20));
        label.setBounds(575 , 70 , 250 , 50);
        label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));       
        

        //  =============== JPANEL LOGIC =============== //
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(450 , 120 , 400 , 450);
        panel.setBackground(new Color(30, 30, 30));

        // ============ LABEL 2 LOGIN =================//
        JLabel label2 = new JLabel();
        label2.setText("Log In");
        label2.setForeground(Color.WHITE);
        label2.setBounds(150 , 10 , 90 , 25);
        label2.setFont(new Font("Arial" , Font.BOLD , 25 ));

        // ============ LABEL 3 CREDENTIAL ============== //
        JLabel label3 = new JLabel();
        label3.setText("Log in to your account by adding your credential");
        label3.setForeground(Color.white);
        label3.setFont(new Font("Arial" , Font.ITALIC , 15));
        label3.setBounds(30 , 50 , 350 , 45);
       
        // =============== JTEXTFEILD LOGIC =============== //
        
        JTextField email = new JTextField();
        email.setBounds(30 , 120 , 350 , 40);
        email.setBackground(new Color(45, 45, 45));
        email.setForeground(Color.WHITE);
        email.setText("Enter your email");
        email.setCaretColor(Color.WHITE);
        email.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        email.setBorder(BorderFactory.createLineBorder(new Color(80, 80, 80)));
        email.setBorder(new LineBorder(new Color(80,80,80), 1 , true));

        //  ============== PasswordField  ================ //
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(30, 180, 350, 40);
        passwordField.setBackground(new Color(45, 45, 45));
        passwordField.setForeground(Color.WHITE);
        passwordField.setCaretColor(Color.WHITE);
        passwordField.setText("Enter your password");
        passwordField.setEchoChar('#');
        JButton eye = new JButton("👁");
        passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        passwordField.setBorder(BorderFactory.createLineBorder(new Color(80, 80, 80), 1));
        passwordField.setBorder(new LineBorder(new Color(80,80,80), 1, true));

        // =============== SIGN IN BUTTON ============== //
        JButton button = new JButton();
        button.setBounds(30 , 250 , 350 , 45);
        button.setBackground(new Color(45,45,45));
        button.setText("Sign In");
        button.setForeground(Color.WHITE);




        panel.add(eye);
        panel.add(button);
        panel.add(email);
        panel.add(passwordField);
        panel.add(label2);
        panel.add(label3);
        frame.add(label);
        frame.add(panel);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}