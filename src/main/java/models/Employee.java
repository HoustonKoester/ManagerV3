package models;

public class Employee {
	private String username;
	private String password;
	private int empNo;
	private String empName;
	private Address address;
	private String position;

	public Employee(String username, String password, int empNo, String empName, Address address, String position) {
		super();
		this.username = username;
		this.password = password;
		this.empNo = empNo;
		this.empName = empName;
		this.address = address;
		this.position = position;
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	
	
}
