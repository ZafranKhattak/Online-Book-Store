package BooksPage;

import javax.swing.*;
import java.awt.*;

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

        scroll.setBounds(0, 0, 1300, 900);
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
                },
                {
                        "BooksPage/img3.png",
                        "BooksPage/img4.jpeg",
                },
                {
                        "BooksPage/img5.jpeg",
                        "BooksPage/img6.jpeg",
                },
                {
                        "BooksPage/img7.jpeg",
                        "BooksPage/img8.jpeg",
                },
                {
                        "BooksPage/img9.jpeg",
                        "BooksPage/img10.jpeg",
                },
                {
                        "BooksPage/img11.jpeg",
                        "BooksPage/img12.jpeg",
                },
                {
                        "BooksPage/img13.jpeg",
                        "BooksPage/img14.jpeg",
                }
        };

        for (int i = 0; i < images.length; i++) {
            for (int j = 0; j <images[i].length; j++) {
                JLabel book = createImage(
                        images[i][j],
                        i * 250,
                        j * 350,
                        220,
                        300);
                panel.add(book);
            }
        }
        // JLabel b1 = createImage("BooksPage/img1.png", 0, 10, 300, 400);
        // JLabel b2 = createImage("BooksPage/img2.jpeg",320, 10,300, 400 );
        // JLabel b3 = createImage("BooksPage/img3.png",640, 10,300, 400 );
        // JLabel b4 = createImage("BooksPage/img4.jpeg",960, 10,300, 400 );
        // JLabel b5 = createImage("BooksPage/img5.jpeg",0, 430,300, 400 );

        // ===================== ADD TO FRAME ==========================

        // panel.add(b1);
        // panel.add(b2);
        // panel.add(b3);
        // panel.add(b4);
        // panel.add(b5);
        frame.add(scroll);
    }

    public static JLabel createImage(String path, int x, int y, int width, int height) {

        ImageIcon icon = new ImageIcon(path);

        Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);

        JLabel label = new JLabel(new ImageIcon(img));

        label.setBounds(x, y, width, height);

        return label;
    }
}