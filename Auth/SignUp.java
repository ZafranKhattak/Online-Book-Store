package Auth;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.*;


public class SignUp
{
    public SignUp()
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
       
        // =============== JTEXTFEILD AREA LOGIC =============== //
        


        panel.add(label2);
        panel.add(label3);
        frame.add(label);
        frame.add(panel);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}