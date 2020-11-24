import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class new_customer extends JFrame implements ActionListener
{
   JLabel l1,l2,l3,l4,l5,l6;
   JButton b1,b2;
   JTextField t1,t2,t3,t4,t5;
    new_customer()
    {
        setBounds(350,200,650,600);
        setTitle("New Customer");
        
        JPanel p=new JPanel();
        p.setLayout(new GridLayout(6,2,10,10));//layout of panel
        
        p.setBackground(Color.WHITE);
        
        l1 = new JLabel("Name");
        t1 = new JTextField();
        p.add(l1);
        p.add(t1);
        
         l6 = new JLabel("Customer ID");
        t5 = new JTextField();
        p.add(l6);
        p.add(t5);
        
        l2=new JLabel("Address");
        t2=new JTextField();
        p.add(l2);
        p.add(t2);
        
        l3=new JLabel("Phone Number");
        t3=new JTextField();
        p.add(l3);
        p.add(t3);
        
        l4=new JLabel("Email");
        t4=new JTextField();
        p.add(l4);
        p.add(t4);
        
        b1=new JButton("Add");
        b2=new JButton("Cancel");
        
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
         b2.setBackground(Color.RED);
         
        p.add(b1);
        p.add(b2);
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        setLayout(new BorderLayout());//layout of JFrame..
        
        add(p,"Center");
        
        ImageIcon i=new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\Brick Klin\\src\\icons\\hicon1.jpg");
        Image img=i.getImage().getScaledInstance(150,300,Image.SCALE_DEFAULT);
        l5=new JLabel(new ImageIcon(img));
        
        add(l5,"West");
        
        getContentPane().setBackground(Color.WHITE);//for making backgound of whole page white...
    }
    
   @Override
    public void actionPerformed(ActionEvent ae)
    {
       if(ae.getSource()==b1)
       {
         String a = t1.getText();
        String c = t5.getText();
        String d = t2.getText();
        String e = t4.getText();
        String f=t3.getText();
        
        String q1 = "insert into customer values('"+a+"','"+c+"','"+d+"','"+e+"','"+f+"')";
        
        try
        {
            conn c1 = new conn();
            c1.s.executeUpdate(q1);
            JOptionPane.showMessageDialog(null,"Customer Created");
            this.setVisible(false);   
        }
        catch(Exception ex)
        {
             ex.printStackTrace();
        }   
       }
       else if(ae.getSource()==b2)
       {
           this.setVisible(false);
       }
    }
    public static void main(String args[])
    {
        new new_customer().setVisible(true);
    }
            
}
