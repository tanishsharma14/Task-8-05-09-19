import java.util.Scanner;
import java.sql.*;

public class Main {

	public static void main(String[] args) throws Exception {

		Scanner sc=new Scanner(System.in);
		DBOperation dboperation=new DBOperation();
		int input;
		
		do
		{
			System.out.println("------------Menu--------------");
			System.out.println("Enter your choice");
			System.out.println("Enter 1 for add employee");
			System.out.println("Enter 2 for showing all employees");
			System.out.println("Enter 3 for removing employee");
			System.out.println("Enter 4 for clearing all employees data");
			System.out.println("Enter 5 for change salary");
			System.out.println("Enter 6 for search employee");
			System.out.println("Enter 7 for view department wise list");
			System.out.println("Enter 10 for exit");
			System.out.println();
			input=sc.nextInt();
			
			
			
			
			
			switch(input)
			{
				case 1:
					{
						System.out.println("Enter employee number");
						int eno=sc.nextInt();
						System.out.println("Enter employee name");
						String ename=sc.next();
						System.out.println("Enter salary");
						int salary=sc.nextInt();
						System.out.println("Enter designation");
						String desg=sc.next();
						System.out.println("Enter department");
						String dept=sc.next();
						
						Employee emp=new Employee(eno,ename,salary,desg,dept);
						int res=dboperation.addEmployee(emp);
						
						if(res==1)
								System.out.println("Record nserted successfully");
						else
								System.out.println("Record not inserted");
						
						break;
					}
				case 2:
					{
						ResultSet rs=dboperation.showEmployee();
						while(rs.next())
							{
								System.out.println(rs.getInt(1)+"    "+rs.getString(2)+"    "+rs.getInt(3)+"    "+rs.getString(4)+"   "+rs.getString(5));
							}
						
						break;
					}
					
				case 3:
					{
						System.out.println("Enter employee number");
						int eno=sc.nextInt();
						int res=dboperation.removeEmployee(eno);
						
						if(res==1)
								System.out.println("Employee removed successfully");
						else
								System.out.println("Employee not found");
						
						break;
					}
					
				case 4:
					{
						boolean flag=dboperation.clearData();
						
						if(flag==true)
								System.out.println("Data removed successfully");
						else
								System.out.println("No data found in database");
						
						break;
					}
				case 5:
					{
						System.out.println("Enter employee number");
						int eno=sc.nextInt();
						System.out.println("Enter new salary");
						int salary=sc.nextInt();
						
						int res=dboperation.updateSalary(eno, salary);
						if(res==1)
								System.out.println("Emplloyee updated successfully");
						else
								System.out.println("Employee not found");
						
						break;
					}
					
				case 6:
					{
						System.out.println("Enter employee number");
						int eno=sc.nextInt();
						ResultSet rs=dboperation.searchEmployee(eno);
						
						while(rs.next())
						{
							System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"   "+rs.getInt(3)+"  "+rs.getString(4)+"  "+rs.getString(5));
						}
						
						break;
						
					}
				case 7:
					{
						System.out.println("Enter department name");
						String dept=sc.next();
						ResultSet rs =dboperation.deptWise(dept);
						
						while(rs.next())
						{
							System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"   "+rs.getInt(3)+"  "+rs.getString(4)+"  "+rs.getString(5));
						}
					}
			}	
		}while(input!=10);

	}

}
