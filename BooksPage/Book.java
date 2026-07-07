package BooksPage;

import Dashboard.Dashboard;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Book {

        public Book() {
                JFrame frame = new JFrame("View Books");
                frame.setSize(700, 900);
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(null);

                // ===================== JScrollPanel ===================== //
                JPanel panel = new JPanel();
                panel.setLayout(null);
                panel.setPreferredSize(new Dimension(1000, 1500));

                JScrollPane scroll = new JScrollPane(panel);

                scroll.setBounds(20, 100, 1300, 900);
                scroll.setVerticalScrollBarPolicy(
                                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                scroll.setHorizontalScrollBarPolicy(
                                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                frame.add(scroll);

                // ===================== METHOD CALL CREATE IMAGE =====================//

                String images[][] = {
                                {
                                                "BooksPage/img1.png",
                                                "BooksPage/img2.jpeg",
                                                "BooksPage/img3.png",
                                                "BooksPage/img4.jpeg",
                                                "BooksPage/img5.jpeg",
                                },

                                {
                                                "BooksPage/img5.jpeg",
                                                "BooksPage/img6.jpeg",
                                                "BooksPage/img7.jpeg",
                                                "BooksPage/img8.jpeg",
                                                "BooksPage/img9.jpeg",
                                },
                                {

                                                "BooksPage/img10.jpeg",
                                                "BooksPage/img11.jpeg",
                                                "BooksPage/img12.jpeg",
                                                "BooksPage/img13.jpeg",
                                },

                                {

                                                "BooksPage/img14.jpeg",
                                                "BooksPage/img11.jpeg",
                                                "BooksPage/img12.jpeg",
                                                "BooksPage/img12.jpeg",
                                                "BooksPage/img12.jpeg",
                                },
                                {

                                                "BooksPage/img14.jpeg",
                                                "BooksPage/img11.jpeg",
                                                "BooksPage/img12.jpeg",
                                                "BooksPage/img12.jpeg",
                                                "BooksPage/img12.jpeg",
                                }
                };

                for (int i = 0; i < images.length; i++) {
                        for (int j = 0; j < images[i].length; j++) {
                                JLabel book = createImage(
                                                images[i][j],
                                                i * 250,
                                                j * 350,
                                                220,
                                                300);
                                panel.add(book);
                        }
                }

                // =============== SEARCH BOOK NAME ==================//

                JTextField searchBook = new JTextField();
                searchBook.setLayout(null);
                searchBook.setBounds(400, 30, 250, 30);
                searchBook.setBackground(Color.GRAY);
                searchBook.setForeground(Color.white);

                // ================= BUTTON FOR SEARCH ===============//
                JButton searchButton = new JButton();
                searchButton.setLayout(null);
                searchButton.setBounds(670, 30, 170, 30);
                searchButton.setBackground(Color.BLUE);
                searchButton.setForeground(Color.black);
                searchButton.setText("Search");
                searchButton.setFont(new Font("Arial", Font.BOLD, 19));
                searchButton.addActionListener(e -> {

                        String BookName = searchBook.getText().trim().toLowerCase();

                        try {
                                Connection conn = DriverManager.getConnection(
                                                "jdbc:mysql://localhost:3306/ONLINE_STORE",
                                                "root",
                                                "ZafranKhan@06");
                                String query = "SELECT book_name as Name , sell_price as Sell_Price, author_name as Author FROM Books where book_name = ?";

                                PreparedStatement ps = conn.prepareStatement(query);
                                ps.setString(1, BookName);
                                ResultSet rs = ps.executeQuery();

                                if (rs.next()) {
                                        String name = rs.getString("Name");
                                        double price = rs.getDouble("Sell_Price");
                                        String author = rs.getString("Author");
                  
                                        JOptionPane.showMessageDialog(
                                                        null,
                                                        "Book Name: " + name +
                                                                        "\nAuthor: " + author +
                                                                        "\nPrice: " + price);
                                                                        
                                } else {
                                        JOptionPane.showMessageDialog(null, "This book not Avialable");
                                        return;
                                }
                                conn.close();
                                ps.close();
                                rs.close();
                        } catch (Exception ex) {
                                ex.getMessage();
                        }
                });

                // ===================== BACK BUTTON ===================== //
                JButton backButton = new JButton("Back");
                backButton.setBounds(870, 30, 170, 30);
                backButton.setBackground(Color.RED);
                backButton.setForeground(Color.BLACK);

                backButton.addActionListener(e -> {
                       new Dashboard();
                        frame.dispose();
                });
                frame.add(backButton);
                frame.add(searchBook);
                frame.add(scroll);
                frame.add(searchButton);

        }

        public static JLabel createImage(String path, int x, int y, int width, int height) {

                ImageIcon icon = new ImageIcon(path);

                Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);

                JLabel label = new JLabel(new ImageIcon(img));

                label.setBounds(x, y, width, height);

                return label;
        }
}
