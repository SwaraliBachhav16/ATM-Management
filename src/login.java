import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
public class login extends JFrame implements ActionListener{
	
	JButton login,signup,clear;  //global decide
	JTextField  cardfield;
	JPasswordField pinField;
	login(){
		setTitle("ATM machine");
		setLayout(null); //null so that we can do our own customizations
		
		//For image
		ImageIcon il=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));//get image
		Image i2=il.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);//image class import and change image size
		ImageIcon i3=new ImageIcon(i2);//we cannot add image we can add only image icon
		JLabel label=new JLabel(i3); //for image set
		label.setBounds(70,10,100,100); 
		add(label);//add to frame
	
		//for welcome to atm text
		JLabel text=new JLabel("Welcome to ATM");
		text.setFont(new Font("Osward",Font.BOLD,38)); //change font size
		text.setBounds(200,40,400,40);
		add(text);
		
		//for card number
		JLabel card=new JLabel("Card no:");
		card.setFont(new Font("Osward",Font.BOLD,24));
	    card.setBounds(130,150,150,40);
	    add(card);
	    
	    //text box for card
	    cardfield=new JTextField();
	    cardfield.setBounds(300,160,250,30);
	    cardfield.setFont(new Font("Arial",Font.BOLD,14));
	    add(cardfield);
	    
	    
	    //for pin
	    JLabel pin=new JLabel("Pin:");
	    pin.setFont(new Font("Osward",Font.BOLD,24));
	    pin.setBounds(130,220,150,40);
		add(pin);
		
		//text box for pin
		pinField=new JPasswordField();
		pinField.setBounds(300, 230, 250, 30);
		pinField.setFont(new Font("Arial",Font.BOLD,14));
		add(pinField);
		
		//login Button
		login=new JButton("sign in");
		login.setBounds(320,300,100,30);
		login.setBackground(Color.BLACK);
		login.setForeground(Color.white);
		login.addActionListener(this);
		add(login);
		
		
		//Clear button
	   clear=new JButton("Clear");
		clear.setBounds(440,300,100,30);
		clear.setBackground(Color.black);
		clear.setForeground(Color.white);
		clear.addActionListener(this);
		add(clear);
		
		//signup button
		
		signup=new JButton("Signup");
		signup.setBounds(380,350,100,30);
		signup.setBackground(Color.black);
		signup.setForeground(Color.white);
		signup.addActionListener(this);
		add(signup);
		
		
		
		
		getContentPane().setBackground(Color.white);
		
		
		setSize(800,480); //frame size
		setVisible(true); //make frame visible
		setLocation(350,200); //location
		
	}
	
	public void actionPerformed(ActionEvent e) {
		//what to do after button is click
		
		if(e.getSource()==clear) { //make them empty
			cardfield.setText("");  //"if we write something in it then it will occur in textbox"
			pinField.setText("");
			
			
		}else if(e.getSource()==login) {
			Connection c=new Connection();
			String cardnumber= cardfield.getText();
			String pinnumber=pinField.getText();
			String query="Select * from login where Cardnumber='"+cardnumber+"' and pin ='"+pinnumber+"'";
			try {
				ResultSet rs=c.s.executeQuery(query);
			   if(rs.next()) {
				   setVisible(false);
				   new Trasaction(pinnumber).setVisible(true);
			   }else {
				   JOptionPane.showMessageDialog(null, "Incoorect cardnumber or pin");
			   }
			}catch(Exception e1) {
				System.out.print(e1);
			}
			
			
		}else if(e.getSource()==signup) {
			setVisible(false);//set visibility of current page off
			new SignupOne().setVisible(true); //make next page vibility on by creating its object	
		}
		
		
	}
	
	public static void main(String args[]) {
		new login();
	}
}
