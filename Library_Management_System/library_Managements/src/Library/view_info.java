package Library;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class view_info extends JFrame{
    JTable t;
    String x[] = {"Book_No","Book_Name","Author","Publisher","Quantity"};
    String y[][] = new String[20][5];
    int i=0,j=0;
    Font f;


    view_info()
    {
        super("All Book Details");
        setSize(1300,400);
        setLocation(0,10);
        f = new Font("Arial",Font.BOLD,16);
        try
        {

            ConnectionClass obj = new ConnectionClass();
            String  q = "Select * from Add_Book";
            ResultSet rest = obj.sta.executeQuery(q);
            while(rest.next())
            {
                y[i][j++] = rest.getString("BookNo");
                y[i][j++] = rest.getString("BookName");
                y[i][j++] = rest.getString("Author");
                y[i][j++] = rest.getString("Publisher");
                y[i][j++] = rest.getString("Quantity");

                i++;
                j=0;
            }
            t=new JTable(y,x);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        t.setFont(f);
        t.setBackground(Color.BLACK);
        t.setForeground(Color.WHITE);
        JScrollPane js = new JScrollPane(t);
        add(js);
    }
    public static void main(String args[])
    {
        new  view_info().setVisible(true);
    }
}

