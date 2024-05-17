import java.awt.Color;


import com.toedter.calendar.JDateChooser;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
public class SignupOne extends JFrame implements ActionListener {
	long random;
	JTextField namebox,ft,s, emailbox,AddressBox,Citybox,statebox,pinbox;
	JRadioButton male,female,single,Married,other;
	JDateChooser datechooser;
	JButton next;
	
	
	SignupOne(){
		setLayout(null);
		Random no=new Random();
		//first taxt
		random=Math.abs(no.nextLong()%9000L+1000L);
		
		JLabel formno=new JLabel("Application form no: "+random);
		formno.setFont(new Font("Railway",Font.BOLD,38));
		formno.setBounds(160,20,600,40);
		add(formno);
		
		//Page no 1:-personal details
		
		JLabel personalDetails=new JLabel("Page 1:Personal Details");
		personalDetails.setBounds(270,70,400,40);
		personalDetails.setFont(new Font("Railway",Font.PLAIN,24));
		add(personalDetails);
		
		//Name 
		JLabel Name=new JLabel("Name: ");
		Name.setBounds(120,150,100,30);
		Name.setFont(new Font("Railway",Font.PLAIN,20));
		add(Name);
		//Name box 
		 namebox=new JTextField();
		namebox.setBounds(300,150,300,30);
		namebox.setFont(new Font("Railway",Font.PLAIN,20));
		add(namebox);
		
		//father name
		JLabel fathername=new JLabel("Fathers Name:");
		fathername.setBounds(120,190,200,30);
		fathername.setFont(new Font("Railway",Font.PLAIN,20));
		add(fathername);
		//father textaread
		ft=new JTextField();
		ft.setBounds(300,190,300,30);
		ft.setFont(new Font("Railway",Font.PLAIN,20));
		add(ft);
		
		//surname
		JLabel surname=new JLabel("Surname: ");
		surname.setBounds(120,230,100,30);
		surname.setFont(new Font("Railway",Font.PLAIN,20));
		add(surname);
		//surname textbox
		 s=new JTextField();
		s.setBounds(300,230,300,30);
		s.setFont(new Font("Railway",Font.PLAIN,20));
		add(s);
		
		
		//Date of birth
		JLabel dob=new JLabel("Date of Birth:");
		dob.setBounds(120,270,200,30);
		dob.setFont(new Font("Railway",Font.PLAIN,20));
		add(dob);
		//date Chooser
		 datechooser=new JDateChooser();
		datechooser.setBounds(300, 270, 200, 30);
		add(datechooser);
		
		
		//gender
		JLabel gender=new JLabel("Gender:");
		gender.setBounds(120,310,100,30);
		gender.setFont(new Font("Railway",Font.PLAIN,20));
		add(gender);
		//radio button for gender
	    male=new JRadioButton("Male");
		male.setBounds(300,310,60,30);
		male.setBackground(Color.white);
		add(male);
	    female=new JRadioButton("Female");
		female.setBounds(400,310,80,30);
		female.setBackground(Color.white);
		add(female);
		
		
		//email
		JLabel mail=new JLabel("Email:");
		mail.setBounds(120,350,100,30);
		mail.setFont(new Font("Railway",Font.PLAIN,20));
		add(mail);
		//email box
		emailbox=new JTextField();
		emailbox.setBounds(300,350,300,30);
		emailbox.setFont(new Font("Railway",Font.PLAIN,20));
		add(emailbox);
		
		//marital Status
		JLabel ms=new JLabel("Marital Status: ");
		ms.setBounds(120,390,200,30);
		ms.setFont(new Font("Railway",Font.PLAIN,20));
		add(ms);
		//checkbox for marital status
		  single=new JRadioButton("Single");
		single.setBounds(300,390,80,30);
		single.setBackground(Color.white);
		add(single);
		 Married=new JRadioButton("Married");
		Married.setBounds(400,390,80,30);
		Married.setBackground(Color.white);
		add(Married);
		  other=new JRadioButton("Other");
		other.setBounds(500,390,80,30);
		other.setBackground(Color.white);
		add(other);
		
		
		 
		//Address
		JLabel add=new JLabel("Address: ");
		add.setBounds(120,430,100,30);
		add.setFont(new Font("Railway",Font.PLAIN,20));
		add(add);
		//AddressBox
		 AddressBox=new JTextField();
		AddressBox.setBounds(300,430,300,30);
		AddressBox.setFont(new Font("Railway",Font.PLAIN,20));
		add(AddressBox);
		
		//city
		JLabel city=new JLabel("City:");
		city.setBounds(120,470,100,30);
		city.setFont(new Font("Railway",Font.PLAIN,20));
		add(city);
		//city box
		 Citybox=new JTextField();
		Citybox.setBounds(300,470,300,30);
		Citybox.setFont(new Font("Railway",Font.PLAIN,20));
		add(Citybox);
		
		//State
		JLabel State=new JLabel("State:");
		State.setBounds(120,510,100,30);
		State.setFont(new Font("Railway",Font.PLAIN,20));
		add(State);
		//state box
	   statebox=new JTextField();
		statebox.setBounds(300,510,300,30);
		statebox.setFont(new Font("Railway",Font.PLAIN,20));
		add(statebox);
		
		//Pincode
		JLabel Pincode=new JLabel("Pincode:");
		Pincode.setBounds(120,550,100,30);
		Pincode.setFont(new Font("Railway",Font.PLAIN,20));
		add(Pincode);
		//Pincodebox
		 pinbox=new JTextField();
		pinbox.setBounds(300,550,300,30);
		pinbox.setFont(new Font("Railway",Font.PLAIN,20));
		add(pinbox);

		
		
		
		//window
		setSize(850,800);
		setLocation(350,10);
		setVisible(true);
		getContentPane().setBackground(Color.white);
		
		//next button
				 next=new JButton("Next");
				next.setBackground(Color.black);
				next.setForeground(Color.white);
				next.setBounds(500,590,100,30);
				next.addActionListener(this);
				add(next);
				
				next.setFont(new Font("Railway",Font.BOLD,18));
	}

	public void actionPerformed(ActionEvent ae) {
		String formno=""+random;
		String name=namebox.getText();	
		String  fname=ft.getText();
		String dob=((JTextField) datechooser.getDateEditor().getUiComponent()).getText();
		String gender=null;
		if(male.isSelected()) {
			gender="Male";
		}else if(female.isSelected()) {
			gender="Female";
		}
		String email=emailbox.getText();
		String marital=null;
		if(single.isSelected()) {
			marital="Single";
		}else if(Married.isSelected()) {
			marital="Married";
		}else if(other.isSelected()) {
			marital="Other";
		}
		String address=AddressBox.getText();
		String city=Citybox.getText();
		String state=statebox.getText();
		String pincode=pinbox.getText();
		
		try {
			if(name.equals("")) {
				JOptionPane.showMessageDialog(null,"Name is requied");
			}else {
				Connection c=new Connection();
				String query="insert into signupp values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
				c.s.executeUpdate(query);
				setVisible(false);
				new SignupTwo(formno).setVisible(true);
			}
			
		}catch(Exception e) {
			System.out.print(e);
		}
		
	}
	public static void main(String args[] ){
		new SignupOne();
	}
	
}
