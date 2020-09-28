import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class emp_details extends JFrame implements ActionListener{
 
    JTable t1;
    JButton b1;
    String x[] = {"Name","Cust_Id","Address","Email","Phone"};
    String y[][] = new String[20][5];
    int i=0, j=0;
    emp_details(){
        super("Employee Details");
        setSize(1200,650);
        setLocation(200,200);
        
        try{
            conn c1  = new conn();
            String s1 = "select * from emp";
            ResultSet rs  = c1.s.executeQuery(s1);
            while(rs.next()){
                y[i][j++]=rs.getString("name");
                y[i][j++]=rs.getString("empid");
                y[i][j++]=rs.getString("address");
                y[i][j++]=rs.getString("phone_no");
                y[i][j++]=rs.getString("work_type");
                i++;
                j=0;
            }
            t1 = new JTable(y,x);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        b1 = new JButton("Print");
        add(b1,"South");
        JScrollPane sp = new JScrollPane(t1);
        add(sp);
        b1.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae){
        try{
            t1.print();
        }catch(Exception e){}
    }
    
    public static void main(String[] args){
        new emp_details().setVisible(true);
    }
    
}