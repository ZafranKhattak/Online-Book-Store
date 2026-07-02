package Auth;
import Auth.SignUp;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.tools.JavaCompiler;

public class SignIn
{
    public SignIn()
    {

        JFrame frame = new JFrame();
        frame.setTitle("Online Store");
        frame.setSize(400 , 400);

        // ===== BACKGROUND COLOR OF FRAME ========== //
        frame.getContentPane().setBackground(new Color(18, 18, 18));

        // ============ IMAGE BACKGROUND ============== //

         ImageIcon icon = new ImageIcon("Auth/signin.jpeg");
         Image img = icon.getImage().getScaledInstance(
                1300, 700, Image.SCALE_SMOOTH);

        JLabel background = new JLabel(new ImageIcon(img));
        background.setBounds(0, 0, 900, 600);
        background.setLayout(null);      
        

        //  =============== JPANEL LOGIC =============== //
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(450 , 120 , 400 , 450);
        panel.setBackground(new Color(30, 30, 30));

        // ============ LABEL 2 LOGIN =================//
        JLabel label2 = new JLabel();
        label2.setText("<html><u>Log In</u></html>");
        label2.setForeground(Color.WHITE);
        label2.setBounds(150 , 10 , 90 , 25);
        label2.setFont(new Font("Arial" , Font.BOLD , 25 ));
        label2.setCursor(new Cursor(Cursor.HAND_CURSOR));

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
        email.setBorder(new LineBorder(new Color(80,80,80), 3 , true));

        //  ============== PasswordField  ================ //
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(30, 180, 350, 40);
        passwordField.setBackground(new Color(45, 45, 45));
        passwordField.setForeground(Color.WHITE);
        passwordField.setCaretColor(Color.WHITE);
        passwordField.setText("Enter your password");
        passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        passwordField.setBorder(BorderFactory.createLineBorder(new Color(80, 80, 80), 1));
        passwordField.setBorder(new LineBorder(new Color(80,80,80), 3, true));

        // =============== SIGN IN BUTTON ============== //
        JButton button = new JButton();
        button.setBounds(30 , 250 , 350 , 45);
        button.setBackground(Color.BLUE);
        button.setText("Sign In");
        button.setForeground(Color.WHITE);

        // =========== IF NOT SIGN IN THEN SIGN UP USING LINK

        JLabel label4 = new JLabel();
        label4.setLayout(null);
        label4.setBounds(30 , 300 , 350 , 30);
        label4.setForeground(Color.WHITE);
        label4.setText("<html>Do not have Account ? <font color = 'blue'><u> Sign Up </u> </font><html>");   

        label4.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e)
            {
                new SignUp();
                frame.dispose();
            }
        });
        label4.setCursor(new Cursor(Cursor.HAND_CURSOR));


        panel.add(button);
        panel.add(email);
        panel.add(passwordField);
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