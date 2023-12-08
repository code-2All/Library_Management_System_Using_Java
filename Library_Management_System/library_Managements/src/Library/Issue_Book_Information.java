

package Library;

        import javax.swing.*;
        import javax.swing.event.AncestorListener;
        import java.awt.event.*;
        import java.awt.*;
        import java.sql.*;
public class Issue_Book_Information extends JFrame implements ActionListener {

    JButton bt1, bt2;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12;
    JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9, tf10;
    JFrame f;

    Issue_Book_Information() {
        f = new JFrame("Add_Issue_Book_Information");
        f.setBackground(Color.WHITE);
        f.setLayout(null);


        l1 = new JLabel();
        l1.setBounds(0, 0, 900, 600);
        l1.setLayout(null);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Library/image/library-management-system.jpg"));
        Image i1 = img.getImage().getScaledInstance(900, 600, Image.SCALE_SMOOTH);
        ImageIcon img2 = new ImageIcon(i1);
        l1.setIcon(img2);

        l2 = new JLabel("Student Id");
        l2.setBounds(50, 150, 150, 30);
        l2.setFont(new Font("Arial", Font.BOLD, 20));
        l2.setForeground(Color.BLACK);
        l1.add(l2);
        f.add(l1);


        l3 = new JLabel("WelCome To Library ");
        l3.setBounds(250, 30, 550, 50);
        l3.setFont(new Font("Arial", Font.BOLD, 40));
        l3.setForeground(Color.BLACK);
        l1.add(l3);

        tf1 = new JTextField();
        tf1.setBounds(200, 150, 150, 30);
        l1.add(tf1);

        l4 = new JLabel("StudentName");
        l4.setBounds(450, 150, 200, 30);
        l4.setFont(new Font("Arial", Font.BOLD, 20));
        l4.setForeground(Color.BLACK);
        l1.add(l4);

        tf2 = new JTextField();
        tf2.setBounds(600, 150, 150, 30);
        l1.add(tf2);

        l5 = new JLabel("StudentContact");
        l5.setBounds(50, 200, 100, 30);
        l5.setFont(new Font("Arial", Font.BOLD, 20));
        l5.setForeground(Color.BLACK);
        l1.add(l5);

        tf3 = new JTextField();
        tf3.setBounds(200, 200, 150, 30);
        l1.add(tf3);

        l6 = new JLabel("BookName");
        l6.setBounds(450, 200, 200, 30);
        l6.setFont(new Font("Arial", Font.BOLD, 20));
        l6.setForeground(Color.BLACK);
        l1.add(l6);

        tf4 = new JTextField();
        tf4.setBounds(600, 200, 150, 30);
        l1.add(tf4);

        l7 = new JLabel("Author");
        l7.setBounds(50, 250, 100, 30);
        l7.setFont(new Font("Arial", Font.BOLD, 20));
        l7.setForeground(Color.BLACK);
        l1.add(l7);

        tf5 = new JTextField();
        tf5.setBounds(200, 250, 150, 30);
        l1.add(tf5);

        l8 = new JLabel("Date");
        l8.setBounds(450, 250, 100, 30);
        l8.setFont(new Font("Arial", Font.BOLD, 20));
        l8.setForeground(Color.BLACK);
        l1.add(l8);

        tf6 = new JTextField();
        tf6.setBounds(600, 250, 150, 30);
        l1.add(tf6);

        bt1 = new JButton("Issue Book");
        bt1.setBackground(Color.BLACK);
        bt1.setForeground(Color.WHITE);
        bt1.setBounds(250, 500, 150, 40);
        l1.add(bt1);


        bt2 = new JButton("Close");
        bt2.setBackground(Color.RED);
        bt2.setForeground(Color.WHITE);
        bt2.setBounds(450, 500, 150, 40);
        l1.add(bt2);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(900, 600);
        f.setLocation(300, 100);
        f.setVisible(true);

        bt1.addActionListener(this);
        bt2.addActionListener(this);
    }


//        bt1.addActionListener(new ActionListener() {


    public void actionPerformed(ActionEvent ex) {
        if (ex.getSource() == bt1)
            try {

                ConnectionClass conn = new ConnectionClass();


                String StudentId = tf2.getText();
                String StudentName = tf3.getText();
                String BookNo = tf4.getText();
                String BookName = tf5.getText();
                String Author = tf6.getText();


                PreparedStatement pst = conn.conn.prepareStatement("INSERT INTO  Issue_Book_Info(StudentId,StudentName,BookName, BookNo,Author,Date) values(?,?,?,?,?)");


                pst.setString(5, StudentId);
                pst.setString(6, StudentName);
                pst.setString(2, BookNo);

                pst.setString(3, BookName);

                pst.setString(4, Author);



                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data added successfully");

                f.setVisible(false);

            } catch (Exception e1) {
                e1.printStackTrace();
            }

        if (ex.getSource() == bt2) {
            JOptionPane.showMessageDialog(null, "Are U Sure");
//                  new Home_Page();
            f.setVisible(false);
        }
    }


    public static void main(String args[]) {
        new  Issue_Book_Information ();
    }
}




