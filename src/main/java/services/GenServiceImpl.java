package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.Address;
import com.ConnectionUtil;

import models.Employee;

public class GenServiceImpl implements GenService{
/*this.username = username;
		this.password = password;
		this.empNo = empNo;
		this.empName = empName;
		this.address = address;this is a comment
		this.position = position;*/
	
	public Employee loginAttempt(String username, String password) {
		String QUERY = "select * from emp where USERNAME=? and PASSWORD=?";
		Employee emp = new Employee();

	    try (Connection con = ConnectionUtil.getConnection();
	        PreparedStatement stmt = con.prepareStatement(QUERY);) {
	    	//stmt.setInt(1, 1);
	      stmt.setString(1, username);
  		  stmt.setString(2, password);
  		  ResultSet rs = stmt.executeQuery();
	        while(rs.next()) {
	        emp.setUsername(rs.getString("username"));
	        emp.setPassword(rs.getString("password"));
	        emp.setEmpNo(rs.getInt("ID"));
	        emp.setEmpName(rs.getString("empname"));
	        emp.setPosition(rs.getString("position"));
	       // emp.setSalary(rs.getDouble("salary"));
	        Address addr = new Address();
	        addr.setCity(rs.getString("city"));
	        addr.setState(rs.getString("state"));
	        emp.setAddress(addr);
	       // employ.add(emp);
	        }
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
		return emp;
	}


	@Override
	public void updateDatabase(ArrayList<String> information) {
		// TODO Auto-generated method stub
		String QUERY2 = "insert into REIM values(?,?,?,?)";
		String QUERY1 = "truncate table REIM";
		Employee emp = new Employee();

	    try (Connection con = ConnectionUtil.getConnection();
	        PreparedStatement stmt2 = con.prepareStatement(QUERY2);
	        PreparedStatement stmt1 = con.prepareStatement(QUERY1);) {
	    	stmt1.execute();
	    	int row = 0;
	    	
	    	for(int i=0; i < information.size(); i=i+4) {

	    			int empid = Integer.parseInt(information.get(i));
					stmt2.setInt(1, empid);

	    			String empname = information.get(i+1);
					stmt2.setString(2, empname);

	    			int amount = Integer.parseInt(information.get(i+2));
					stmt2.setInt(3, amount);

	    			String status = information.get(i+3);
					stmt2.setString(4, status);
					
	    		
	    	
	    	System.out.println("made it here");
	    	stmt2.executeUpdate();
	    	}
	      
	}catch (SQLException e) {
	      e.printStackTrace();
	    }

	}
	
}
