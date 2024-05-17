


	import java.awt.*;
	import java.awt.event.*;
	import java.sql.SQLException;
	import java.util.*;
	import javax.swing.*;

	public class withdraw extends JFrame implements ActionListener {
		JTextField box;
		JButton withdraw,Back;
		String pinnumber;
		withdraw(String pinnumber){
			this.pinnumber=pinnumber;
			//setLayout(null);
			
			//backgrround image
			ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
			Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
			ImageIcon i3=new ImageIcon(i2);
			JLabel image=new JLabel(i3);
			image.setBounds(0,0,900,900);
			add(image);
			
			JLabel text=new JLabel("Enter the amount you want to withdraw");
			text.setBounds(170,220,700,35);
			text.setForeground(Color.white);
			text.setFont(new Font("System",Font.BOLD,18));
			image.add(text);
			
			box=new JTextField();
			box.setBounds(250,260,150,30);
			image.add(box);
			
			
			    withdraw=new JButton("withdraw");
				withdraw.setBounds(340, 385, 150, 30);
				image.add(withdraw);
				withdraw.setForeground(Color.white);
				withdraw.setBackground(Color.black);
			    withdraw.setFont(new Font("System",Font.BOLD,20));
			    withdraw.addActionListener(this);

			    Back=new JButton("Back");
				Back.setBounds(340, 420, 150, 30);
				image.add(Back);
				Back.setForeground(Color.white);
				Back.setBackground(Color.black);
			    Back.setFont(new Font("System",Font.BOLD,20));
				Back.addActionListener(this);
			    
		setSize(900,900);
		//setUndecorated(true);
		setLocation(300,00);
		setVisible(true);
		

		}
		
		public void actionPerformed(ActionEvent a) {
			if(a.getSource()==withdraw) {
				String number=box.getText();
				Date date=new Date();
				if(number.equals("")) {
					System.out.print("Enter amount");
				}else {
					
					try {
						Connection c=new Connection();
						String query="insert into bank values('"+pinnumber+"','"+date+"','Withdraw','"+number+"')";
						c.s.executeUpdate(query);
						JOptionPane.showMessageDialog(null,"Removed Successfully");
						setVisible(false);
						new Trasaction(pinnumber).setVisible(true);
					} catch (Exception e) {
						System.out.print(e);
					}
					
				}
			}else if(a.getSource()==Back) {
				setVisible(false);
				new Trasaction(pinnumber).setVisible(true);
			}
		}
		
		public static void main(String args[]) {
			new withdraw("");
		}
	}


