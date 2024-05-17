import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.ResultSet;
public class Balance extends JFrame implements ActionListener {
	String pinnumber;
	JButton Check,back;
	JPasswordField pinbox;
	Balance(String pinnumber){
		this.pinnumber=pinnumber;
		       
		
		        //backgrround image
				ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
				Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
				ImageIcon i3=new ImageIcon(i2);
				JLabel image=new JLabel(i3);
				image.setBounds(0,0,900,900);
				add(image);
				
				
				JLabel text=new JLabel("Check Balance");
				text.setBounds(270,220,700,35);
				text.setForeground(Color.white);
				text.setFont(new Font("System",Font.BOLD,18));
				image.add(text);
				
				JLabel pin=new JLabel("Enter Pin");
				pin.setBounds(170,260,100,35);
				pin.setForeground(Color.white);
				pin.setFont(new Font("System",Font.BOLD,18));
				image.add(pin);
				
			    pinbox=new JPasswordField();
			    pinbox.setBounds(330,260,150,35);
			    pinbox.setForeground(Color.black);
				pinbox.setFont(new Font("System",Font.BOLD,18));
				image.add(pinbox);
				
				Check=new JButton("Check");
				Check.setBounds(330,370,150,30);
				Check.setForeground(Color.black);
				Check.setBackground(Color.white);
				Check.setFont(new Font("System",Font.BOLD,18));
				image.add(Check);
				Check.addActionListener(this);
				
				
				back=new JButton("Back");
				back.setBounds(330,410,150,30);
				back.setForeground(Color.black);
				back.setBackground(Color.white);
				back.setFont(new Font("System",Font.BOLD,18));
				image.add(back);
				back.addActionListener(this);
				
	    
	    //Window	
		setSize(900,900);
		//setUndecorated(true);
		setLocation(300,00);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==back){
			setVisible(false);
			new Trasaction(pinnumber).setVisible(true);
		}
		
		
		else if(ae.getSource()==Check) {
			
			
			
			int balance=0;
			try {
				if(pinbox.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Enter pin number");
					return;
				}
				Connection c=new Connection();
				ResultSet rs=c.s.executeQuery("select* from bank where pin='"+pinnumber+"'");
				
				while(rs.next()) {
					if(rs.getString("type").equals("Deposit")) {
						balance+=Integer.parseInt(rs.getString("amount"));
					}else {
						balance-=Integer.parseInt(rs.getString("amount"));
					}
					}
				
			}catch(Exception e) {
				System.out.print(e);
			}
			
			JOptionPane.showMessageDialog(null, "Balance is"+balance);
		
		
	}
	}
public static void main(String args[]) {
	new Balance("");
}
}
