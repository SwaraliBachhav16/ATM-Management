
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class SignupTwo extends JFrame implements ActionListener {
	
	   JComboBox reli,reg,Inc,Education,occ;
	   JTextField Panbox,Adharbox;
	   JRadioButton yes,no,yes1,no1;
	   JButton next;
	   String formno;
	SignupTwo(String formno){
		this.formno=formno;
		setTitle("New Account Application form- Page 2");
		setLayout(null);
		//window
				setSize(850,800);
				setLocation(350,10);
				setVisible(true);
				getContentPane().setBackground(Color.white);
				
		//Addition details
				JLabel additiondetails =new JLabel("Page 2- Addition Details");
				additiondetails.setBounds(250,30,400,40);
				additiondetails.setFont(new Font("Railway",Font.BOLD,28));
				add(additiondetails);
				
	    //Religion
				JLabel religion = new JLabel("Religion: ");
				religion.setBounds(120,80,100,40);
				religion.setFont(new Font("Railway",Font.BOLD,20));
				add(religion);
				//for dropdown use-Jcombo
				String[] valReligion={"Hindu","Muslim","Sikh","Christrian","Other"};
				reli=new JComboBox(valReligion);
				reli.setBounds(300,80,300,30);
				reli.setBackground(Color.white);
				add(reli);
				
				
		
		//Category
				JLabel Category= new JLabel("Category: ");
				Category.setBounds(120,130,100,40);
				Category.setFont(new Font("Railways",Font.BOLD,20));
				add(Category);
				String[] valGeneral={"General","OBC","NT-a","NT-c","Sc","Other"};
			    reg=new JComboBox(valGeneral);
				reg.setBounds(300,130,300,30);
				reg.setBackground(Color.white);
				add(reg);
				
		//Income
				JLabel Income=new JLabel("Income: ");
				Income.setBounds(120,180,100,40);
				Income.setFont(new Font("Railway",Font.BOLD,20));
				add(Income);
				String[] valIncome={"Null","0-20k","20k-60k","60k-100k","above 100K","Other"};
				Inc=new JComboBox(valIncome);
				Inc.setBounds(300,180,300,30);
				Inc.setBackground(Color.white);
				add(Inc);
				
				
		//Education Qualification
				JLabel Ed=new JLabel("Education Qualification: ");
				Ed.setBounds(120,230,250,40);
				Ed.setFont(new Font("Railway",Font.BOLD,20));
				add(Ed);
				
				String[] valEdu={"UnderGraduate","Non-Graduate","Post-Graduate","Master","Other"};
				Education=new JComboBox(valEdu);
				Education.setBounds(400,230,200,30);
				Education.setBackground(Color.white);
				add(Education);
				
		//Occupation
				JLabel occupation=new JLabel("Occupation: ");
				occupation.setBounds(120,280,200,40);
				occupation.setFont(new Font("Railway",Font.BOLD,20));
				add(occupation);

				String[] valOccu={"Salaried","Farmer","Teacher","Doctor","Other"};
				occ=new JComboBox(valOccu);
				occ.setBounds(300,280,300,30);
				occ.setBackground(Color.white);
				add(occ);
				
		//PAN number
				JLabel PAN=new JLabel("PAN number: ");
				PAN.setBounds(120,330,150,40);
				PAN.setFont(new Font("Railway",Font.BOLD,20));
				add(PAN);
				//Panbox
				  Panbox=new JTextField();
					Panbox.setBounds(300,340,300,30);
					Panbox.setFont(new Font("Railway",Font.PLAIN,20));
					add(Panbox);
				
				
		
		//Adhar number
				JLabel An=new JLabel("Aadhar number: ");
				An.setBounds(120,380,200,40);
				An.setFont(new Font("Railway",Font.BOLD,20));
				add(An);
				
			//Adhar number
				    Adharbox=new JTextField();
					Adharbox.setBounds(300,390,300,30);
					Adharbox.setFont(new Font("Railway",Font.PLAIN,20));
					add(Adharbox);
				
				
		//Senior Citizen
				JLabel SC=new JLabel("Senior Citizen: ");
				SC.setBounds(120,430,200,40);
				SC.setFont(new Font("Railway",Font.BOLD,20));
				add(SC);
				
				 yes=new JRadioButton("Yes");
				yes.setBounds(350,440,60,30);
				add(yes);
				yes.setBackground(Color.white);
				 no=new JRadioButton("No");
				no.setBounds(500,440,60, 30);
				no.setBackground(Color.white);
				add(no);
				
		        //Exisiting Account
				JLabel EA=new JLabel("Exisitng Account: ");
				EA.setBounds(120,480,200,40);
				EA.setFont(new Font("Railway",Font.BOLD,20));
				add(EA);
				 yes1=new JRadioButton("Yes");
				yes1.setBounds(350,490,60,30);
				add(yes1);
				yes1.setBackground(Color.white);
				 no1=new JRadioButton("No");
				no1.setBounds(500,490,60, 30);
				no1.setBackground(Color.white);
				add(no1);
				
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
					String religi=(String)reli.getSelectedItem();
					String category=(String) reg.getSelectedItem();
					String Incom=(String)Inc.getSelectedItem();
					String edu=(String) Education.getSelectedItem();
					String occup=(String)occ.getSelectedItem();	
					
					String seniorCiti=null;
					if(yes.isSelected()) {
						seniorCiti="Yes";
					}else if(no.isSelected()) {
						seniorCiti="No";
					}
					
					String Exsiacc=null;
					if(yes1.isSelected()) {
						Exsiacc="Yes";
					}else if(no1.isSelected()) {
						Exsiacc="No";
					}
					
					String span= Panbox.getText();
					String sAdh=Adharbox.getText();
					try {
						Connection c=new Connection();
						String query="insert into signuptwo values('"+formno+"','"+religi+"','"+category+"','"+Incom+"','"+edu+"','"+occup+"','"+span+"','"+sAdh+"','"+seniorCiti+"','"+Exsiacc+"')";
						c.s.executeUpdate(query);
						setVisible(false);
						new SignupThree(formno).setVisible(true);
					}catch(Exception e) {
						System.out.println(e);
					}
	         }
				
	
	
	public static void main(String args[]) {
		new SignupTwo("");
	}
}
