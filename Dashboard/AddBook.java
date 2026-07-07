package Dashboard;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class AddBook {

    public AddBook() {
        JFrame frame = new JFrame();
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setSize(900, 700);
        frame.setTitle("Add Book Detail");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // =============== JPanel ================//
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(450, 100, 400, 550);
        panel.setBackground(Color.WHITE);

        // =============== JLabel ================//

        JLabel label = new JLabel();
        label.setText("<html> <u><u>Add About Book</u></html>");
        label.setBounds(120, 20, 200, 30);
        label.setForeground(Color.red);
        label.setFont(new Font("Arail", Font.BOLD, 20));

        // ================ Book Name ==============//
        JLabel bn = new JLabel();
        bn.setBounds(50, 60, 100, 30);
        bn.setText("Book Name");
        bn.setBackground(Color.BLACK);
        bn.setFont(new Font("Arial", Font.BOLD, 15));
        JTextField field = new JTextField();
        field.setBounds(50, 90, 300, 30);
        field.setBackground(Color.DARK_GRAY);
        field.setForeground(Color.WHITE);

        // =============== BOOK AUTHOR ================ //
        JLabel ba = new JLabel();
        ba.setText("Author Name");
        ba.setBounds(50, 130, 100, 30);
        ba.setForeground(Color.BLACK);
        ba.setFont(new Font("Arial", Font.BOLD, 15));
        JTextField field2 = new JTextField();
        field2.setBounds(50, 160, 300, 30);
        field2.setBackground(Color.DARK_GRAY);
        field2.setForeground(Color.WHITE);

        // ================ QUANTITY OF BOOK =========== //
        JLabel qa = new JLabel();
        qa.setText("Total Quantity");
        qa.setForeground(Color.black);
        qa.setBounds(50, 200, 200, 30);
        qa.setFont(new Font("Arial", Font.BOLD, 15));
        JTextField field3 = new JTextField();
        field3.setBounds(50, 230, 300, 30);
        field3.setBackground(Color.DARK_GRAY);
        field3.setForeground(Color.white);

        // ================= PURCHASE PRICE ============= //

        JLabel pp = new JLabel();
        pp.setText("Purchase Price");
        pp.setForeground(Color.BLACK);
        pp.setFont(new Font("ARIAL", Font.BOLD, 15));
        pp.setBounds(50, 270, 200, 30);
        JTextField field4 = new JTextField();
        field4.setBackground(Color.DARK_GRAY);
        field4.setBounds(50, 300, 300, 30);
        field4.setForeground(Color.WHITE);

        // ============= SELL PRICE ================ //
        JLabel pP = new JLabel();
        pP.setText("Sell Price");
        pP.setForeground(Color.BLACK);
        pP.setFont(new Font("ARIAL", Font.BOLD, 15));
        pP.setBounds(50, 340, 200, 30);
        JTextField field5 = new JTextField();
        field5.setBackground(Color.DARK_GRAY);
        field5.setBounds(50, 370, 300, 30);
        field5.setForeground(Color.WHITE);

        // ================== DATABASE PLUS BUTTON ===============//

        JButton btn = new JButton();
        btn.setBounds(50, 410, 300, 50);
        btn.setBackground(Color.BLUE);
        btn.setForeground(Color.BLACK);
        btn.setText("Save");
        btn.setFont(new Font("Arial", Font.BOLD, 15));

        btn.addActionListener(e -> {

            String bookName = field.getText().trim().toLowerCase();
            String authorName = field2.getText().trim().toLowerCase();

            double qty = Double.parseDouble(field3.getText().trim());
            double purchasePrice = Double.parseDouble(field4.getText().trim());
            double sellPrice = Double.parseDouble(field5.getText().trim());

            if (qty < 1) {
                JOptionPane.showMessageDialog(null, "Enter valid quantity");
                return;
            }

            else if (purchasePrice < 1) {
                JOptionPane.showMessageDialog(null, "Enter valid purchase price");
                return;
            }

            else if (sellPrice < purchasePrice) {
                JOptionPane.showMessageDialog(null, "Enter valid sell price. Should greater than purchase price ");
                return;
            }

            else if (bookName.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Write Book Name");
                return;
            } else if (authorName.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Write Author Name");
                return;
            } else {
                JOptionPane.showMessageDialog(null, "Please enter a valid number.");
            }
            try {
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ONLINE_STORE",
                        "root",
                        "ZafranKhan@06");

                String query = "INSERT INTO Books(author_name , book_name , book_qty , purchase_price , sell_price) VALUES(? , ? , ? , ? , ?) ";
                PreparedStatement statement = conn.prepareStatement(query);
                statement.setString(1, authorName);
                statement.setString(2, bookName);
                statement.setDouble(3, qty);
                statement.setDouble(4, purchasePrice);
                statement.setDouble(5, sellPrice);

                int affectedRows = statement.executeUpdate();
                if (affectedRows > 0) {
                    JOptionPane.showMessageDialog(null, "Book Added Successfully");
                    return;
                } else {
                    JOptionPane.showMessageDialog(null, "Book Not added");
                }
                conn.close();
                statement.close();

            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, e1.getMessage());
            }
        });

        // ===================== BACK BUTTON ===================== //

        JButton backButton = new JButton("Back");
        backButton.setBounds(50, 470, 300, 50);
        backButton.setBackground(Color.RED);
        backButton.setForeground(Color.BLACK);

        backButton.addActionListener(e -> {
            new Dashboard();
            frame.dispose();
        });
        // ==================== ADD TO FRAME ====================//
        frame.add(panel);
        panel.add(label);
        panel.add(field);
        panel.add(field3);
        panel.add(field2);
        panel.add(field4);
        panel.add(field5);
        panel.add(btn);
        panel.add(backButton);
        panel.add(bn);
        panel.add(ba);
        panel.add(qa);
        panel.add(pp);
        panel.add(pP);

    }
}
