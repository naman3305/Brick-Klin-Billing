import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class homepg extends JFrame implements ActionListener
{
   homepg()
   {
        setTitle("Home Page ");
       setSize(1920,1030);
       
       ImageIcon i=new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\Brick Klin\\src\\icons\\klin.jpg");
       Image i1=i.getImage().getScaledInstance(1900, 950, Image.SCALE_DEFAULT);
       ImageIcon ic=new ImageIcon(i1);
       JLabel img=new JLabel(ic);
       add(img);
       
       JMenuBar mb=new JMenuBar();
       JMenu file=new JMenu("Files");
       JMenuItem f1=new JMenuItem("New Customer");
       JMenuItem f2=new JMenuItem("Customer Details");
       JMenuItem f4=new JMenuItem("Add Employee");
       JMenuItem f5=new JMenuItem("Employee Details");
       file.setFont(new Font("Arial",Font.BOLD,20));
       file.setForeground(Color.BLUE);
       
       ImageIcon i2=new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\Brick Klin\\src\\icons\\icon1.png");
       Image img1=i2.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
       f1.setIcon(new ImageIcon(img1));
       f1.setMnemonic('N');
         f1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        f1.setBackground(Color.WHITE);
        
    ImageIcon i3=new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\Brick Klin\\src\\icons\\icon6.png");
       Image img2=i3.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
       f2.setIcon(new ImageIcon(img2));
       f2.setMnemonic('C');
         f2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        f2.setBackground(Color.WHITE);
        
        
        
        ImageIcon i9=new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\Brick Klin\\src\\icons\\icon12.png");
       Image img8=i9.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
       f4.setIcon(new ImageIcon(img8));
       f4.setMnemonic('A');
         f4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        f4.setBackground(Color.WHITE);
        
       f5.setIcon(new ImageIcon(img2));
       f5.setMnemonic('D');
         f5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        f5.setBackground(Color.WHITE);
        
        f1.addActionListener(this);
        f2.addActionListener(this);
        f4.addActionListener(this);
        f5.addActionListener(this);
        
        JMenu user=new JMenu("User");
        JMenuItem u1=new JMenuItem("Calculate Bill");
        JMenuItem u2=new JMenuItem("Last Bill");
       user.setFont(new Font("Arial",Font.BOLD,20));
       user.setForeground(Color.BLUE);  
        
          ImageIcon i5=new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\Brick Klin\\src\\icons\\icon5.png");
       Image img4=i5.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
       u1.setIcon(new ImageIcon(img4));
       u1.setMnemonic('B');
         u1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
        u1.setBackground(Color.WHITE);
        
          ImageIcon i6=new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\Brick Klin\\src\\icons\\icon6.png");
       Image img5=i6.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
       u2.setIcon(new ImageIcon(img5));
       u2.setMnemonic('L');
         u2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        u2.setBackground(Color.WHITE);
        
         u1.addActionListener(this);
        u2.addActionListener(this);
        
        JMenu exit=new JMenu("Exit");
        JMenuItem ex=new JMenuItem("Exit");
        exit.setForeground(Color.RED);
        exit.setFont(new Font("Arial",Font.BOLD,20));
        
         ImageIcon i8=new ImageIcon("C:\\Users\\hp\\Documents\\NetBeansProjects\\Brick Klin\\src\\icons\\icon11.png");
       Image img7=i8.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
       ex.setIcon(new ImageIcon(img7));
       ex.setMnemonic('E');
         ex.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        ex.setBackground(Color.WHITE);
       
        ex.addActionListener(this);
        
        
        file.add(f1);
        file.add(f2);
        file.add(f4);
        file.add(f5);
        
        user.add(u1);
        user.add(u2);
        
        
        exit.add(ex);
        
        mb.add(file);
        mb.add(user);
        mb.add(exit);
        
        setJMenuBar(mb);
        
        setLayout(new FlowLayout());
        
        
        
   }
   @Override
   public void actionPerformed(ActionEvent ae)
   {
         String msg = ae.getActionCommand();
       if(msg.equals("Customer Details"))
        {
           new customer_details().setVisible(true);   
        }
     else if(msg.equals("New Customer"))
        {
            new new_customer().setVisible(true); 
        }
     else if(msg.equals("Add Employee"))
     {
          new add_emp().setVisible(true); 
     }
      else if(msg.equals("Employee Details"))
     {
          new emp_details().setVisible(true); 
     }
     else if(msg.equals("Calculate Bill"))
        {
            new calculate_bill().setVisible(true);  
        }
     else if(msg.equals("Last Bill"))
     {
         new last_bill().setVisible(true);
     }
        else if(msg.equals("Exit"))
        {
            System.exit(0);
        }
   }
   public static void main(String args[])
   {
       new homepg().setVisible(true);
   }
}



