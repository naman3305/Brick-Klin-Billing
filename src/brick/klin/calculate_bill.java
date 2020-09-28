
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class calculate_bill extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JButton b1,b2;
    JTextField t1,t2,t3,t4,t5;
    
    calculate_bill()
    {
         setSize(650,500);
        setLocation(350,220);
        setTitle("BILL");
        
        l1=new JLabel("BILL");
        l2=new JLabel("Date");
       l3=new JLabel("Name");
        l4=new JLabel("Number of Bricks");
        l5=new JLabel("Rate");
        l6=new JLabel("Customer ID");
        
        b1=new JButton("Calculate");
        b2=new JButton("Cancel");
        b2.setBackground(Color.RED);
        b1.setBackground(Color.GREEN);
        
       b1.addActionListener(this);
        b2.addActionListener(this);
       
        
        ImageIcon i=new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\Brick Klin\\src\\icons\\hicon2.jpg");
            Image i2 = i.getImage().getScaledInstance(180,270,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l7 = new JLabel(i3);
         
           l1.setFont(new Font("Senserif",Font.PLAIN,26));
        //Move the label to center
        l1.setHorizontalAlignment(JLabel.CENTER);
        
        JPanel p=new JPanel();
        p.setLayout(new GridLayout(6,2,30,30));
        p.setBackground(Color.WHITE);
        
        t1=new JTextField(15);
        t2=new JTextField(15);
        t3=new JTextField(15);
        t4=new JTextField(15);
        t5=new JTextField(15);
        
        p.add(l2);
        p.add(t1);
        p.add(l3);
        p.add(t2);
        p.add(l4);
        p.add(t3);
        p.add(l5);
        p.add(t4);
        p.add(l6);
        p.add(t5);
        p.add(b1);
        p.add(b2);
        
        setLayout(new BorderLayout(30,30));
        
       add(l1,"North");
        add(p,"Center");
       add(l7,"West");
        
        getContentPane().setBackground(Color.WHITE);
        
        
    }
    @Override
    public void actionPerformed(ActionEvent ae)
    {
       if(ae.getSource()==b1)
        {
            String a=t1.getText();
        String b = t2.getText();
        String c=t3.getText();
        String d=t4.getText();
        String e=t5.getText();
        
        float p2 = Integer.parseInt(c);
        double p3 = Integer.parseInt(d);
        p3=p3*(p2/1000);
        p3=p3+(p3*0.18);
        String s1 = "select * from bill where cust_id = '"+e+"'";
        String q = "INSERT INTO bill(date,name,rate,cust_id,amount)VALUES('"+a+"','"+b+"','"+d+"','"+e+"','"+p3+"')";
        String q1="UPDATE bill SET amount='"+p3+"',date='"+a+"' WHERE cust_id='"+e+"'";
        try
        {
            conn c1 = new conn();
            ResultSet rs  = c1.s.executeQuery(s1);
            if(rs.next())
                c1.s.executeUpdate(q1);
            else
            {
            c1.s.executeUpdate(q);
            }
            JOptionPane.showMessageDialog(null,"Bill Updated");
        }
        catch(Exception aee)
        {
            aee.printStackTrace();
        }
        }
        else if(ae.getSource()==b2)
        {
            this.setVisible(false);
        }
    }
    public static void main(String args[])
    {
       new calculate_bill().setVisible(true);
    }
}
