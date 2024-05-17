import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class PinChange  extends JFrame implements ActionListener{
	String pinnumber;
	JButton Change,back;
	JPasswordField pinbox,repinbox;
	PinChange(String pinnumber){
		this.pinnumber=pinnumber;
		
		//backgrround image
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel image=new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		JLabel text=new JLabel("Change pin");
		text.setBounds(270,220,700,35);
		text.setForeground(Color.white);
		text.setFont(new Font("System",Font.BOLD,18));
		image.add(text);
		
		//pin 
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
		
		
		JLabel repin=new JLabel("Re-enter pin");
		repin.setBounds(170,300,150,35);
		repin.setForeground(Color.white);
		repin.setFont(new Font("System",Font.BOLD,18));
		image.add(repin);
		
	    repinbox=new JPasswordField();
	    repinbox.setBounds(330,300,150,35);
		repinbox.setForeground(Color.black);
		repinbox.setFont(new Font("System",Font.BOLD,18));
		image.add(repinbox);
		
		Change=new JButton("Change");
		Change.setBounds(330,370,150,30);
		Change.setForeground(Color.black);
		Change.setBackground(Color.white);
		Change.setFont(new Font("System",Font.BOLD,18));
		image.add(Change);
		Change.addActionListener(this);
		
		
		back=new JButton("Back");
		back.setBounds(330,410,150,30);
		back.setForeground(Color.black);
		back.setBackground(Color.white);
		back.setFont(new Font("System",Font.BOLD,18));
		image.add(back);
		back.addActionListener(this);
		
		setSize(900,900);
		//setUndecorated(true);
		setLocation(300,00);
		setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==back) {
			setVisible(false);
			new Trasaction(pinnumber).setVisible(true);
			
		}else if(e.getSource()==Change) {
			try {
				String npin=pinbox.getText();
				String rpin=repinbox.getText();
				if(!npin.equals(rpin)) {
					JOptionPane.showMessageDialog(null, "Pin not match");
					return;
				}
				if(npin.equals("")) {
					JOptionPane.showMessageDialog(null, "Enter pin");
					return;
				}
				if(rpin.equals("")) {
					JOptionPane.showMessageDialog(null, "Re-Enter pin");
					return;
				}
				
				Connection c=new Connection();
				String query1="update bank set pin='"+rpin+"'where pin='"+pinnumber+"'";
				String query2="update signupthree set pin='"+rpin+"'where pin='"+pinnumber+"'";
				String query3="update login set pin='"+rpin+"'where pin='"+pinnumber+"'";

				c.s.executeUpdate(query1);
				c.s.executeUpdate(query2);
				c.s.executeUpdate(query3);
				
				JOptionPane.showMessageDialog(null, "Pin change Successfully");
				new Trasaction(rpin).setVisible(true);
				
			}catch(Exception e1) {
				System.out.println(e1);
			}
		}
	}
	
	public static void main(String args[]) {
		 new PinChange("");
	}
}
