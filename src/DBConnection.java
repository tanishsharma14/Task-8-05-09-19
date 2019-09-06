import java.sql.*;


public class DBConnection {

	
	public Connection getConnection() throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wp","root","root");
		return con;
	}
}
