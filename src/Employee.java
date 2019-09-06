
public class Employee {

	private int eno;
	private String ename;
	private int salary;
	private String desg;
	private String dept;
	
	public Employee(int eno, String ename, int salary, String desg, String dept) {
		super();
		this.eno = eno;
		this.ename = ename;
		this.salary = salary;
		this.desg = desg;
		this.dept = dept;
	}
	
	

	@Override
	public String toString() {
		return "Employee [eno=" + eno + ", ename=" + ename + ", salary="
				+ salary + ", desg=" + desg + ", dept=" + dept + "]";
	}



	public int getEno() {
		return eno;
	}

	public void setEno(int eno) {
		this.eno = eno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDesg() {
		return desg;
	}

	public void setDesg(String desg) {
		this.desg = desg;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	
	
	
}
