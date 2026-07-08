package Dashboard;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DeleteBook
{
    public DeleteBook()
    {
        JFrame frame = new JFrame("UPDATE WINDOW");
        frame.setSize(600, 700);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.BLACK);

        // ============== JPanel ===================

        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        panel.setBounds(450, 70 , 400, 550);

        // =================== JLabel ================
        JLabel label = new JLabel();
        label.setText("Update Section");
        label.setLayout(null);
        label.setBounds(140 , 20 , 170 , 30);
        label.setFont(new Font("Arial" , Font.BOLD, 19));
        panel.add(label);

        // ================== JTextField Search =================

        JTextField searchField = new JTextField();
        searchField.setLayout(null);
        searchField.setBackground(Color.gray);
        searchField.setFont(new Font("ARIAL" , Font.PLAIN, 18));
        panel.add(searchField);
        searchField.setBounds(40 , 60 , 170 , 30);
    

    // ================ Button Search ================== // 

    JButton searchButton = new JButton();
    searchButton.setLayout(null);
    searchButton.setBounds(230, 60 , 100,30);
    searchButton.setBackground(Color.BLUE);
    searchButton.setText("Search");
    searchButton.addActionListener(e->
        {
            String authorName = searchField.getText().trim().toLowerCase();
            String bookName = searchField.getText().trim().toLowerCase();

            try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ONLINE_STORE",
                        "root",
                        "ZafranKhan@06");

            String query = "SELECT author_name as Author , book_name as BookName , sell_price as Sell_Price from Books where author_name  = ? and book_name = ?";

            PreparedStatement ps = conn.prepareStatement(query);

            ps.setString(1,     authorName);
            ps.setString(2,     bookName);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                              String name = rs.getString("Author");
                              double price = rs.getDouble("BookName");
                              String author = rs.getString("Sell_Price");
                  
                             JOptionPane.showMessageDialog(
                                                        null,
                                                        "Book Name: " + name +
                                                                        "\nAuthor: " + author +
                                                                        "\nPrice: " + price);
                                                                        
                                } else {
                                        JOptionPane.showMessageDialog(null, "No Book Found!");
                                        return;
                                }
                                conn.close();
                                ps.close();
                                rs.close();
            }
            catch(Exception ex)
            {
                ex.getMessage();
            }
            
        }
    );
    panel.add(searchButton);


    // ================== JLabel Book Name =================
    JLabel bookField = new JLabel();
    bookField.setBounds(40, 100 , 150, 50);
    bookField.setText("Book Name:");
    bookField.setFont(new Font("Arial" , Font.BOLD , 15));
    panel.add(bookField);
    

    // ================== JTextField Search Book Name =================

        JTextField searchName = new JTextField();
        searchName.setLayout(null);
        searchName.setBackground(Color.gray);
        searchName.setFont(new Font("ARIAL" , Font.PLAIN, 18));
        panel.add(searchName);
        searchName.setBounds(40 , 140 , 170 , 30);

    // =============== JLabel Author Name ================
    
    JLabel bookAuthor = new JLabel();
    bookAuthor.setBounds(40, 180 , 150, 50);
    bookAuthor.setText("Author Name:");
    bookAuthor.setFont(new Font("Arial" , Font.BOLD , 15));
    panel.add(bookAuthor);
    
     // ================== JTextField Search Author Name =================

        JTextField searchAuthor = new JTextField();
        searchAuthor.setLayout(null);
        searchAuthor.setBackground(Color.gray);
        searchAuthor.setFont(new Font("ARIAL" , Font.PLAIN, 18));
        panel.add(searchAuthor);
        searchAuthor.setBounds(40 , 220 , 170 , 30);
    // =============== JLabel Upadte price ================
    
       JLabel updatePrice = new JLabel();
       updatePrice.setBounds(40, 260 , 150, 50);
       updatePrice.setText("Update Price:");
       updatePrice.setFont(new Font("Arial" , Font.BOLD , 15));
       panel.add(updatePrice);

    // ================== JTextField Search Update Price =================

        JTextField searchUpdate = new JTextField();
        searchUpdate.setLayout(null);
        searchUpdate.setBackground(Color.gray);
        searchUpdate.setFont(new Font("ARIAL" , Font.PLAIN, 18));
        panel.add(searchUpdate);
        searchUpdate.setBounds(40 , 300 , 170 , 30);

    
        // ================== Save Changes Button =================

        JButton saveButton = new JButton();
        saveButton.setLayout(null);
        saveButton.setBounds(140, 360 , 160,30);
        saveButton.setBackground(Color.GREEN);
        saveButton.setText("Save");
        panel.add(saveButton);

        saveButton.addActionListener(e->
            {
                String authorName = bookField.getText().trim().toUpperCase();
                String bookName = bookAuthor.getText().trim().toUpperCase();
                double updatedPrice = Double.parseDouble(updatePrice.getText().trim());

                if (authorName.isEmpty())
                {
                    JOptionPane.showMessageDialog(null , "Enter AuthorName");
                    return;
                }
                try {
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ONLINE_STORE",
                        "root",
                        "ZafranKhan@06");

                        String query = "DELETE FROM Books where book_name = ? and author_name = ?";

                        PreparedStatement ps = conn.prepareStatement(query);
                        ps.setString(1 , bookName);
                        ps.setString(2, authorName);
                        ps.setDouble(3, updatedPrice);
                        int affectedRows = ps.executeUpdate ();

                        if (affectedRows >0)
                        {
                            JOptionPane.showMessageDialog(null, "Price Updated Successfully");
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null , "Price not updated");
                            return;
                        }

                        conn.close();
                        ps.close();

                } catch (Exception ex) {
                   ex.getMessage();
                }
            }
        );

         // ================== Back Button =================

        JButton backButton = new JButton();
        backButton.setLayout(null);
        backButton.setBounds(140, 400 , 160,30);
        backButton.setBackground(Color.RED);
        backButton.setText("Back");
        panel.add(backButton);

        backButton.addActionListener(e->
            {
                new Dashboard();
                frame.dispose();
            }
        );
    }
}