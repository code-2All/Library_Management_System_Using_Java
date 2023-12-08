package Library;

import java.sql.ResultSet;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Delete_Info extends JFrame implements ActionListener{

    JLabel l1,l2,l3;
    JButton bt1,bt2;
    JPanel p1,p2;
    Font f,f1;

    JTextField tf1;

    JPasswordField tf2;

    Delete_Info ()
    {

        super("Return Book");
        setLocation(450,350);
        setSize(500,200);


        f  = new Font("Arial",Font.BOLD,25);
        f1 = new Font ("Arial",Font.BOLD,20);

        l1 = new JLabel("Return Book");
        l2 = new JLabel("Book_No");
        l3 = new JLabel("Student Name");


        bt1 = new JButton("Return Book");
        bt2 = new JButton("Cancel");

        bt1.addActionListener(this);
        bt2.addActionListener(this);

        tf1 = new JTextField();
        tf2 = new JPasswordField();

        l1.setFont(f);
        l2.setFont(f1);
        l3.setFont(f1);
        bt1.setFont(f1);
        bt2.setFont(f1);
        tf1.setFont(f1);
        tf2.setFont(f1);

        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setForeground(Color.WHITE);

        p1=new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);
        p1.setBackground(Color.BLUE);

        p2=new JPanel();
        p2.setLayout(new GridLayout(3,2,10,10));
        p2.add(l2);
        p2.add(tf1);
        p2.add(l3);
        p2.add(tf2);
        p2.add(bt1);
        p2.add(bt2);

        setLayout(new BorderLayout(10,10));
        add(p1,"North");
//        add(p2,"West");
        add(p2,"Center");


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String Book_No = tf1.getText();
        String Name = tf2.getText();

        if(e.getSource()==bt1)
        {
            try{
                ConnectionClass obj = new ConnectionClass();
                String s =  "Select * From View_Book_Issue where Book_No=' "+Book_No+" ' and Name=' "+Name+" ' ";
                ResultSet rest = obj.sta.executeQuery(s);

                if(rest.next())
                {
                    System.out.println("Home Paage");
//                    new  AdminSection().setVisisble(true);
//
                    this.setVisible(false);
                }
                else {
                    JOptionPane.showMessageDialog(null,"Wrong Book_No And Name");
                    this.setVisible(false);
                    this.setVisible(true);
                }
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }

        if(e.getSource()==bt2)
        {
            this.setVisible(false);
        }

    }
    public static void main(String args[])
    {

        new Return_Book().setVisible(true);

    }
}


