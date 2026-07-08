package Dashboard;

import javax.swing.*;
import Auth.SignIn;
import BooksPage.Book;
import java.awt.*;

public class Dashboard {

    public Dashboard() {
        JFrame frame = new JFrame("DASHBOARD");
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

        JLabel label = new JLabel();
        label.setText("<html> <u><u>Welcome to Dashboard</u></html>");
        label.setBounds(100, 60, 400, 30);
        label.setForeground(Color.red);
        label.setFont(new Font("Arail", Font.BOLD, 20));

        // ============= BUTTON ADD BOOK =============== //
        JButton buttonAddBook = new JButton();
        buttonAddBook.setText("Add Book");
        buttonAddBook.setBounds(60 , 100 , 300 , 40);
        buttonAddBook.setBackground(Color.BLUE);
        buttonAddBook.setForeground(Color.BLACK);
        buttonAddBook.setFont(new Font("Arial" , Font.BOLD, 15));

        buttonAddBook.addActionListener(e->{
            new AddBook();

            frame.dispose();
        });


        // ================ UPDATE BOOK BUTTON ===============//
        JButton buttonUpdateButton = new JButton();
        buttonUpdateButton.setText("Update Book");
        buttonUpdateButton.setBounds(60 , 200 , 300 , 40);
        buttonUpdateButton.setBackground(Color.BLUE);
        buttonUpdateButton.setForeground(Color.BLACK);
        buttonUpdateButton.setFont(new Font("Arial" , Font.BOLD, 15));
        buttonUpdateButton.addActionListener(e->{
            new UpdateBook();
        });

        // ================ Delete BOOK BUTTON ===============//
        JButton buttonViewButton = new JButton();
        buttonViewButton.setText("Delete Book");
        buttonViewButton.setBounds(60 , 150 , 300 , 40);
        buttonViewButton.setBackground(Color.BLUE);
        buttonViewButton.setForeground(Color.BLACK);
        buttonViewButton.setFont(new Font("Arial" , Font.BOLD, 15));
        buttonViewButton.addActionListener(e->
            {
                new DeleteBook();
            }
        );
        // ==============  SELL BOOK BUTTON ================ //

        JButton buttonSellButton = new JButton();
        buttonSellButton.setText("Sell Book");
        buttonSellButton.setBounds(60 , 250 , 300 , 40);
        buttonSellButton.setBackground(Color.BLUE);
        buttonSellButton.setForeground(Color.BLACK);
        buttonSellButton.setFont(new Font("Arial" , Font.BOLD, 15));

        // ============== Today Sell Button ================
        
        JButton buttonTodayButton = new JButton();
        buttonTodayButton.setText("Today Sell");
        buttonTodayButton.setBounds(60 , 300 , 300 , 40);
        buttonTodayButton.setBackground(Color.BLUE);
        buttonTodayButton.setForeground(Color.BLACK);
        buttonTodayButton.setFont(new Font("Arial" , Font.BOLD, 15));

        // ===================== VIEW BOOKS BUTTON ======================//
        JButton viewButton = new JButton("View Books");
        viewButton.setBounds(60 , 350 , 300 , 40);
        viewButton.setBackground(Color.BLUE);
        viewButton.setForeground(Color.BLACK);
        viewButton.setFont(new Font("Arial" , Font.BOLD, 15));
        viewButton.addActionListener(e->{
            new Book();
        });
        // ===================== BACK BUTTON ===================== //

        JButton backButton = new JButton("Back");
        backButton.setBounds(60 ,430 , 300 , 40);
        backButton.setBackground(Color.RED);
        backButton.setForeground(Color.BLACK);

        backButton.addActionListener(e ->{
            new SignIn();
            frame.dispose();
        });
        frame.add(panel);
        panel.add(label);
        panel.add(buttonAddBook);
        panel.add(buttonViewButton);
        panel.add(buttonUpdateButton);
        panel.add(buttonSellButton);
        panel.add(buttonTodayButton);
        panel.add(viewButton);
        panel.add(backButton);
    }
}
