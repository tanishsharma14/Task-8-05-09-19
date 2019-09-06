import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class DBOperation 
{
	DBConnection dbconnection=new DBConnection();
	
	public int addEmployee(Employee e) throws Exception
	{
		Connection con=dbconnection.getConnection();
		PreparedStatement psmt=con.prepareStatement("insert into emp values(?,?,?,?,?)");
		psmt.setInt(1,e.getEno());
		psmt.setString(2,e.getEname());
		psmt.setInt(3,e.getSalary());
		psmt.setString(4,e.getDesg());
		psmt.setString(5,e.getDept());
		
		int res=psmt.executeUpdate();
		
		
		return res;
		
	}
	
	public ResultSet showEmployee() throws Exception
	{
		Connection con=dbconnection.getConnection();
		CallableStatement smt=con.prepareCall("{call showemp()}");
		
		ResultSet rs=smt.executeQuery();
		
		
		return rs;
		
		
	}
	
	public int removeEmployee(int eno) throws Exception
	{
		Connection con=dbconnection.getConnection();
		PreparedStatement psmt=con.prepareStatement("delete from emp where eno="+eno);
		int res=psmt.executeUpdate();
		return res;
	}
	
	public boolean clearData() throws Exception
	{
		Connection con=dbconnection.getConnection();
		Statement smt=con.createStatement();
		boolean flag=smt.execute("delete from emnp");
		
		return flag;
	}
	
	public int updateSalary(int eno,int salary) throws Exception
	{
		Connection con=dbconnection.getConnection();
		Statement smt=con.createStatement();
		int res=smt.executeUpdate("update emp set salary="+salary+" where eno="+eno);
		return res;
		
	}
	
	public ResultSet searchEmployee(int eno) throws Exception
	{
		Connection con=dbconnection.getConnection();
		Statement smt=con.createStatement();
		ResultSet rs=smt.executeQuery("select *from emp where eno="+eno);
		return rs;
	}
	
	public ResultSet deptWise(String dept) throws Exception
	{
		Connection con=dbconnection.getConnection();
		Statement smt=con.createStatement();
		ResultSet rs=smt.executeQuery("select *from emp where dept='"+dept+"'");
		return rs;
	}
}

















