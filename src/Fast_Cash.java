

import java.util.Date;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class Fast_Cash extends JFrame implements ActionListener {
	JButton Deposit,WD,FC,MS,PC,BE,Exit;
	String pinnumber;
	Fast_Cash(String pinnumber){
		this.pinnumber=pinnumber;
		//backgrround image
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		//text on image screen
		JLabel text=new JLabel("Select amount you want to withdraw");
		text.setBounds(180,220,700,35);
		text.setForeground(Color.white);
		text.setFont(new Font("System",Font.BOLD,18));
		image.add(text);
		
		//Deposit
		Deposit=new JButton("RS.100");
		Deposit.setBounds(170, 315, 150, 30);
		image.add(Deposit);
		Deposit.setForeground(Color.white);
		Deposit.setBackground(Color.black);
	    Deposit.setFont(new Font("System",Font.BOLD,16));
	    Deposit.addActionListener(this);
	    //Withdraw
	    WD=new JButton("Rs.200");
		WD.setBounds(340, 315, 150, 30);
		image.add(WD);
		WD.setForeground(Color.white);
		WD.setBackground(Color.black);
	    WD.setFont(new Font("System",Font.BOLD,16));
	    WD.addActionListener(this);
	    //Fast Cash
	    FC=new JButton("Rs.500");
		FC.setBounds(170, 350, 150, 30);
		image.add(FC);
	    FC.setForeground(Color.white);
		FC.setBackground(Color.black);
	    FC.setFont(new Font("System",Font.BOLD,16));
	    FC.addActionListener(this);
	    //Mini Statement
	    MS=new JButton("Rs.1000");
		MS.setBounds(340, 350, 150, 30);
		image.add(MS);
		MS.setForeground(Color.white);
		MS.setBackground(Color.black);
	    MS.setFont(new Font("System",Font.BOLD,16));
	    MS.addActionListener(this);
	    //Pin Change
	    PC=new JButton("Rs.2000");
		PC.setBounds(170, 385, 150, 30);
		image.add(PC);
		PC.setForeground(Color.white);
		PC.setBackground(Color.black);
	    PC.setFont(new Font("System",Font.BOLD,16));
	    PC.addActionListener(this);
	    //balance Enquiry
	    BE=new JButton("Rs.10000");
		BE.setBounds(340, 385, 150, 30);
		image.add(BE);
		BE.setForeground(Color.white);
		BE.setBackground(Color.black);
	    BE.setFont(new Font("System",Font.BOLD,14));
	    BE.addActionListener(this);

	    Exit=new JButton("Back");
		Exit.setBounds(340, 420, 150, 30);
		image.add(Exit);
		Exit.setForeground(Color.white);
		Exit.setBackground(Color.black);
	    Exit.setFont(new Font("System",Font.BOLD,20));
		Exit.addActionListener(this);
	  
		
		setSize(900,900);
		//setUndecorated(true);
		setLocation(300,00);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==Exit) {
			setVisible(false);
			new Trasaction(pinnumber).setVisible(true);
		}else {
			String amount=((JButton) e.getSource()).getText().substring(3);
			Connection c=new Connection();
		try {
			ResultSet rs=c.s.executeQuery("select* from bank where pin='"+pinnumber+"'");
			int balance=0;
			while(rs.next()) {
				if(rs.getString("type").equals("Deposit")) {
					balance+=Integer.parseInt(rs.getString("amount"));
				}else {
					balance-=Integer.parseInt(rs.getString("amount"));
				}
			}
			if(e.getSource()!=Exit && balance<Integer.parseInt(amount)) {
				JOptionPane.showMessageDialog(null, "Insufficient balance");
				return;
			}
			Date date=new Date();
			String query="insert into bank values('"+pinnumber+"','"+date+"','Withdraw','"+amount+"')";
			c.s.executeUpdate(query);
			JOptionPane.showMessageDialog(null,"Rs"+amount+"Debited Succesfully");
			setVisible(false);
			new Trasaction(pinnumber).setVisible(true);
		}catch(Exception e1) {
			System.out.print(e1);
		}
		}
	}
	public static void main(String args[]) {
		new Fast_Cash("");
	}

}


