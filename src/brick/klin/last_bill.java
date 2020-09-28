import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class last_bill extends JFrame implements ActionListener{
    JLabel l1;
    JTextArea t1;
    JButton b1;
    JTextField c1;
    JPanel p1;
    last_bill(){
        setSize(500,900);
        setLayout(new BorderLayout());
        
        p1 = new JPanel();
        
        l1 = new JLabel("Generate Bill");
        
        c1=new JTextField(15);
        
        t1 = new JTextArea(50,15);
        JScrollPane jsp = new JScrollPane(t1);
        t1.setFont(new Font("Senserif",Font.ITALIC,18));
        
        b1 = new JButton("Show Details");
        
        p1.add(l1);
        p1.add(c1);
        add(p1,"North");
        
        add(jsp,"Center");
        add(b1,"South");
        
        b1.addActionListener(this);
        
        setLocation(350,40);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        try{
            conn c = new conn();

            ResultSet rs = c.s.executeQuery("select * from customer where cust_id="+c1.getText());
            
            if(rs.next()){
                t1.append("\n    Customer Name:"+rs.getString("name"));
                t1.append("\n    Customer ID:  "+rs.getString("cust_id"));
                t1.append("\n    Address:            "+rs.getString("address"));
                t1.append("\n    Email:                "+rs.getString("email"));
                t1.append("\n    Phone Number  "+rs.getString("phone"));
                t1.append("\n-------------------------------------------------------------");
                t1.append("\n");
            }

            t1.append("Details of the Last Bills\n\n\n");
            
            rs = c.s.executeQuery("select * from bill where cust_id="+c1.getText());
            
            while(rs.next()){
                t1.append("       "+ rs.getString("date") + "           " +rs.getString("amount") + "\n");
            }
            
            
            
            
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        new last_bill().setVisible(true);
    }
}
