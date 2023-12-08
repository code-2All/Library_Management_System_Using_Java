package Library;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Admin_Portal extends JFrame implements ActionListener {
    JLabel l1, l2;
    Font f, f1, f2;

    Admin_Portal() {


        super("Portal Admin Home Page");
        setLocation(0, 0);
        setSize(1550, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f = new Font("Lucida Fax", Font.BOLD, 20);
        f2 = new Font("Gadugi", Font.BOLD, 35);
        f1 = new Font("MS UI Gothic", Font.BOLD, 18);
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Library/Image/library-management-system.jpg"));
        Image i1 = img.getImage().getScaledInstance(1550, 800, Image.SCALE_SMOOTH);
        ImageIcon img2 = new ImageIcon(i1);
        l1 = new JLabel(img2);


        JMenuBar m1 = new JMenuBar();
        JMenu men1 = new JMenu("Add Info");
        JMenuItem ment1 = new JMenuItem("Book_Info");

        men1.add(ment1);

        m1.add(men1);


        JMenu men2 = new JMenu("view Info");
        JMenuItem ment3 = new JMenuItem("View Info");
        men2.add(ment3);
        m1.add(men2);

        JMenu men3 = new JMenu("Issue Info");
        JMenuItem ment5 = new JMenuItem("Issue_Book_Info");

        men3.add(ment5);

        m1.add(men3);

        JMenu men4 = new JMenu("Return ");
        JMenuItem ment7 = new JMenuItem("Return_Book");

        men4.add(ment7);

        m1.add(men4);

        JMenu men5 = new JMenu("Exit");
        JMenuItem ment9 = new JMenuItem("Cancel");

        men5.add(ment9);

        m1.add(men5);




        men1.setFont(f);
        men2.setFont(f);

        men3.setFont(f);

        men4.setFont(f);

        men5.setFont(f);



        ment1.setFont(f1);

        ment3.setFont(f1);
        ment5.setFont(f1);

        ment7.setFont(f1);

        ment9.setFont(f1);


        m1.setBackground(new java.awt.Color(4, 1, 54));

        men1.setForeground(Color.GRAY);
        men2.setForeground(Color.GRAY);
        men3.setForeground(Color.GRAY);
        men4.setForeground(Color.GRAY);
        men5.setForeground(Color.GRAY);



        ment1.setForeground(Color.YELLOW);

        ment3.setForeground(Color.YELLOW);
        ment5.setForeground(Color.YELLOW);

        ment7.setForeground(Color.YELLOW);

        ment9.setForeground(Color.YELLOW);


        ment1.setBackground(Color.BLACK);

        ment3.setBackground(Color.BLACK);
        ment5.setBackground(Color.BLACK);

        ment7.setBackground(Color.BLACK);

        ment9.setBackground(Color.BLACK);



        ment1.addActionListener(this);

        ment3.addActionListener(this);


        ment5.addActionListener(this);

        ment7.addActionListener(this);

        ment9.addActionListener(this);


        setJMenuBar(m1);
        add(l1);
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("Book_Info")) {
            new Book_Info();
        } else if (cmd.equals("View Info")) {
            new view_info().setVisible(true);
        }
        else if(cmd.equals("Issue_Book_Info"))
        {
            new Issue_Book_Information().setVisible(true);
        }
        else if (cmd.equals("Return_Book")) {
            new Return_Book().setVisible(true);

        }
        else if (cmd.equals("Cancel")) {
            System.exit(0);
        }
    }
    public static void main(String args[])
    {
        new  Admin_Portal().setVisible(true);
    }


}


