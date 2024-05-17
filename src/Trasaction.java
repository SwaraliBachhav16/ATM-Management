
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
public class Trasaction extends JFrame implements ActionListener {
	JButton Deposit,WD,FC,MS,PC,BE,Exit;
	String pinnumber;
	Trasaction(String pinnumber){
		this.pinnumber=pinnumber;
		//backgrround image
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		//text on image screen
		JLabel text=new JLabel("Please select your Transaction");
		text.setBounds(210,220,700,35);
		text.setForeground(Color.white);
		text.setFont(new Font("System",Font.BOLD,18));
		image.add(text);
		
		//Deposit
		Deposit=new JButton("Deposit");
		Deposit.setBounds(170, 315, 150, 30);
		image.add(Deposit);
		Deposit.setForeground(Color.white);
		Deposit.setBackground(Color.black);
	    Deposit.setFont(new Font("System",Font.BOLD,16));
	    Deposit.addActionListener(this);
	    //Withdraw
	    WD=new JButton("WithDraw");
		WD.setBounds(340, 315, 150, 30);
		image.add(WD);
		WD.setForeground(Color.white);
		WD.setBackground(Color.black);
	    WD.setFont(new Font("System",Font.BOLD,16));
	    WD.addActionListener(this);
	    //Fast Cash
	    FC=new JButton("Fast Cash");
		FC.setBounds(170, 350, 150, 30);
		image.add(FC);
	    FC.setForeground(Color.white);
		FC.setBackground(Color.black);
	    FC.setFont(new Font("System",Font.BOLD,16));
	    FC.addActionListener(this);
	    //Mini Statement
	    MS=new JButton("Mini Statement");
		MS.setBounds(340, 350, 150, 30);
		image.add(MS);
		MS.setForeground(Color.white);
		MS.setBackground(Color.black);
	    MS.setFont(new Font("System",Font.BOLD,16));
	    MS.addActionListener(this);
	    //Pin Change
	    PC=new JButton("Pin Change");
		PC.setBounds(170, 385, 150, 30);
		image.add(PC);
		PC.setForeground(Color.white);
		PC.setBackground(Color.black);
	    PC.setFont(new Font("System",Font.BOLD,16));
	    PC.addActionListener(this);
	    //balance Enquiry
	    BE=new JButton("Balance Enquiry");
		BE.setBounds(340, 385, 150, 30);
		image.add(BE);
		BE.setForeground(Color.white);
		BE.setBackground(Color.black);
	    BE.setFont(new Font("System",Font.BOLD,14));
	    BE.addActionListener(this);

	    Exit=new JButton("Exit");
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
			System.exit(0);
		}else if(e.getSource()==Deposit) {
			setVisible(false);
			new Deposit(pinnumber).setVisible(true);
		}else if(e.getSource()==WD) {
			setVisible(false);
			new withdraw(pinnumber).setVisible(true);
		}else if(e.getSource()==FC) {
			setVisible(false);
			 new Fast_Cash(pinnumber).setVisible(true);
		}else if(e.getSource()==PC) {
			setVisible(false);
			 new PinChange(pinnumber).setVisible(true);
		}else if(e.getSource()==BE) {
			setVisible(false);
			 new Balance(pinnumber).setVisible(true);
		}
	}
	public static void main(String args[]) {
		new Trasaction("");
	}

}
