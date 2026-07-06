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

        // ===================== METHO CASLL CREATE IMAGE =====================//

        JLabel b1 = createImage("BooksPage/img1.png", 0, 10, 300, 500);
        JLabel b2 = createImage("BooksPage/img2.jpeg",310, 10,300, 500 );
        JLabel b3 = createImage("BooksPage/img3.png",630, 10,300, 500 );
        JLabel b4 = createImage("BooksPage/img2.jpeg",940, 10,300, 500 );
        // JLabel b5 = createImage("BooksPage/img2.jpeg",340, 10,300, 500 );
        
        // ===================== ADD TO FRAME ==========================

        frame.add(b1);
        frame.add(b2);
        frame.add(b3);
        frame.add(b4);
    }

    public static JLabel createImage(String path, int x, int y, int width, int height) {

        ImageIcon icon = new ImageIcon(path);

        Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);

        JLabel label = new JLabel(new ImageIcon(img));

        label.setBounds(x, y, width, height);

        return label;
    }
}