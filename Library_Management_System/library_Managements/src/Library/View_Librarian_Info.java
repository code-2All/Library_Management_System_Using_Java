package Library;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class View_Librarian_Info extends JFrame{
    JTable t;
    String x[] = {"Librarian Name","Librarian Id","Date","Day","Timing"};
    String y[][] = new String[20][5];
    int i=0,j=0;
    Font f;


    View_Librarian_Info()
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
                y[i][j++] = rest.getString("Librarain Name");
                y[i][j++] = rest.getString("Librarian Id");
                y[i][j++] = rest.getString("Date");
                y[i][j++] = rest.getString("Day");
                y[i][j++] = rest.getString("Timing");

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
        new  View_Librarian_Info().setVisible(true);
    }
}


