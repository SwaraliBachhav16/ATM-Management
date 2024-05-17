import java.sql.*;

public class Connection {
	
	
     java.sql.Connection c;
     Statement s;
	public Connection() {	
		try {
			//register driver
			
			//connect
			c=DriverManager.getConnection("jdbc:mysql:///BankManagmentSystem","root","Swara@164");
			//Create statement
			s=c.createStatement();
		}catch(Exception e) {
			System.out.print(e);		}
	}
	
}
