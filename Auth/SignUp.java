package Auth;
import java.awt.*;
import javax.swing.*;

public class SignUp {

    public SignUp() {

        JFrame frame = new JFrame("Sign Up");
        frame.setSize(900, 700);
        frame.getContentPane().setBackground(new Color(18,18,18));
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
        label.setBounds(100, 20, 180, 30);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Segoe UI", Font.BOLD, 20));

        // =========== TextField FOR NAME =========== //
        JTextField textField = new JTextField();
        textField.setBounds(80, 80, 180, 35);

        panel.add(label);
        panel.add(textField);

        // =========== Add panel ON the background =========== //
        background.add(panel);

        // =========== Make background the content pane =========== //
        frame.setContentPane(background);

        frame.setVisible(true);
    }
}