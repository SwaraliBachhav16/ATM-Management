import java.awt.*;

import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener{
	 String formno;
	 JRadioButton SA,FDA,CA,RDA;
	 JCheckBox c1,c2,c3,c4,c5,c6,c7;
	 JButton Submit,Cancel;
	SignupThree(String formno){
		this.formno=formno;
		setLayout(null);
		//Window
		setSize(850,800);
		setLocation(300,10);
		setVisible(true);
		getContentPane().setBackground(Color.white);
		setTitle("New Account Application form- Page 3");

		//page3
		JLabel accdet =new JLabel("Page 3- Account Details");
		accdet.setBounds(250,30,400,40);
		accdet.setFont(new Font("Railway",Font.BOLD,28));
		add(accdet);
		
		
		//AccountType
		JLabel Accounttype=new JLabel("Account Type:");
		Accounttype.setBounds(120,80,200,40);
		Accounttype.setFont(new Font("Railway",Font.BOLD,22));
		add(Accounttype);
		
		//saving account
		SA=new JRadioButton("Saving Account");
		SA.setBounds(120,130,200,30);
		SA.setBackground(Color.white);
		SA.setFont(new Font("Railway",Font.PLAIN,18));
		add(SA);
		//Fixed Deposit Account
		FDA=new JRadioButton("Fixed Deposit Account");
		FDA.setBounds(350,130,300,30);
		FDA.setBackground(Color.white);
		FDA.setFont(new Font("Railway",Font.PLAIN,18));
		add(FDA);
		//Current Account
		CA=new JRadioButton("Current Account");
		CA.setBounds(120,170,200,30);
		CA.setBackground(Color.white);
		CA.setFont(new Font("Railway",Font.PLAIN,18));
		add(CA);
		//Recurring Deposite Account
		RDA=new JRadioButton("Recurring Deposite Account");
		RDA.setBounds(350,170,300,30);
		RDA.setBackground(Color.white);
		RDA.setFont(new Font("Railway",Font.PLAIN,18));
		add(RDA);
		
		//Cardnumber
		JLabel Cardnumber=new JLabel("Card Number: ");
		Cardnumber.setBounds(120,210,200,50);
		Cardnumber.setFont(new Font("Railway",Font.BOLD,22));
		add(Cardnumber);
		
		JLabel number=new JLabel("XXXX-XXXX-XXXX-4184");
		number.setBounds(350,210,200,50);
		number.setFont(new Font("Railway",Font.PLAIN,18));
		add(number);
		
		//pin
		JLabel pin=new JLabel("PIN : ");
		pin.setBounds(120,260,100,50);
		pin.setFont(new Font("Railway",Font.BOLD,22));
		add(pin);
		
		JLabel num=new JLabel("XXXX");
		num.setBounds(350,260,200,50);
		num.setFont(new Font("Railway",Font.PLAIN,18));
		add(num);
		
		//Services Required
		JLabel sr=new JLabel("Services Required:");
		sr.setBounds(120,330,200,50);
		sr.setFont(new Font("Railway",Font.BOLD,22));
		add(sr);
		//c1-ATM Card
		c1= new JCheckBox("ATM Card");
		c1.setBounds(120,390,200,30);
		c1.setBackground(Color.white);
		c1.setFont(new Font("Railway",Font.PLAIN,18));
		add(c1);
		
		//C2-Internet Banking
		c2= new JCheckBox("Internet Banking");
		c2.setBounds(400,390,200,30);
		c2.setBackground(Color.white);
		c2.setFont(new Font("Railway",Font.PLAIN,18));
		add(c2);
		
		//c3-Mobile Banking
		c3= new JCheckBox("Mobile Banking");
		c3.setBounds(120,430,200,30);
		c3.setBackground(Color.white);
		c3.setFont(new Font("Railway",Font.PLAIN,18));
		add(c3);
		
		//c4-Email&SMS Alert
		c4= new JCheckBox("Email & SMS Alert");
		c4.setBounds(400,430,200,30);
		c4.setBackground(Color.white);
		c4.setFont(new Font("Railway",Font.PLAIN,18));
		add(c4);
		
		//c5-Cheque Book
		c5= new JCheckBox("Cheque Book");
		c5.setBounds(120,470,200,30);
		c5.setBackground(Color.white);
		c5.setFont(new Font("Railway",Font.PLAIN,18));
		add(c5);
		
		//c6-E-statement
		c6= new JCheckBox("E-statement");
		c6.setBounds(400,470,200,30);
		c6.setBackground(Color.white);
		c6.setFont(new Font("Railway",Font.PLAIN,18));
		add(c6);
		
		//c7-warning
		c7= new JCheckBox("I hearby declare that above details are correct");
		c7.setBounds(120,540,700,30);
		c7.setBackground(Color.white);
		c7.setFont(new Font("Railway",Font.PLAIN,18));
		add(c7);
		
		//submit
		Submit=new JButton("Submit");
		Submit.setBackground(Color.black);
		Submit.setForeground(Color.white);
		Submit.setFont(new Font("Railway",Font.BOLD,14));
		Submit.setBounds(220,590,100,30);
		Submit.addActionListener(this);
		add(Submit);
		//cancel
		Cancel=new JButton("Cancel");
		Cancel.setBackground(Color.black);
		Cancel.setForeground(Color.white);
		Cancel.setFont(new Font("Railway",Font.BOLD,14));
		Cancel.setBounds(350,590,100,30);
		Cancel.addActionListener(this);
		add(Cancel);
		
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==Submit) {
			String accounttype=null;
			if(SA.isSelected()) {
				accounttype="Saving Account";
			}else if(FDA.isSelected()) {
				accounttype="Fixed Deposite Account";
			}else if(CA.isSelected()) {
				accounttype="Saving Account";
			}else if(RDA.isSelected()) {
				accounttype="Recurring Deposite Account";
			}
			Random random=new Random();
			String cardnumber=""+Math.abs((random.nextLong()%9000000L)+504094600000L);
			
			String pinnumber=""+Math.abs((random.nextLong()%9000L)+1000L);
			
			String facility="";
			if(c1.isSelected()) {
				facility=facility+"ATM Card";
			}else if(c2.isSelected()) {
				facility=facility+"Internet Banking";
			}else if(c3.isSelected()) {
				facility=facility+"Mobile Banking";
			}else if(c4.isSelected()) {
				facility=facility+"Email & SMS Alert";
			}else if(c5.isSelected()) {
				facility=facility+"Cheque Book";
			}else if(c6.isSelected()) {
				facility=facility+"E-statement";
			}
			try {
				if(accounttype.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Account Type required");
				}else {
					Connection con=new Connection();
					String query="insert into signupthree values('"+formno+"','"+accounttype+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
					con.s.executeUpdate(query);	
					String query1="insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
					con.s.executeUpdate(query1);
					JOptionPane.showMessageDialog(null, "cardnumber: "+cardnumber+"\n Pin: "+pinnumber);
					
					setVisible(false);
					new Deposit(pinnumber).setVisible(true);
				}
				
			}catch(Exception e) {
				System.out.print(e);
			}
		}
		else if(ae.getSource()==Cancel)
		{
			setVisible(false);
			new login().setVisible(true);
		}
	}
	public static void main(String args[]) {
		new SignupThree("");
	}
}
