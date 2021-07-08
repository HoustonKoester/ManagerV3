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
	        emp.setAddress(new Address(rs.getString("empcity"),rs.getString("empstate")));
	        emp.setEmail(rs.getString("email"));
	        }
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
		return emp;
	}


	@Override
	public boolean updateDatabase(ArrayList<String> information) {
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
	      return false;
	    }
	    return true;
	}


	@Override
	public boolean insertReim(String id, String name, String amounts) {
		// TODO Auto-generated method stub
		String QUERY2 = "insert into REIM values(?,?,?,?)";

	    try (Connection con = ConnectionUtil.getConnection();
	        PreparedStatement stmt2 = con.prepareStatement(QUERY2);) {
	    	

	    			int empid = Integer.parseInt(id);
					stmt2.setInt(1, empid);

	    			String empname = name;
					stmt2.setString(2, empname);

	    			int amount = Integer.parseInt(amounts);
					stmt2.setInt(3, amount);

	    			String status = "Pending";
					stmt2.setString(4, status);
					
	    		
	    	
	    	//System.out.println("made it here");
	    	stmt2.executeUpdate();
	    	
	      
	}catch (SQLException e) {
	      e.printStackTrace();
	      return false;
	    }
	    return true;
	}


	@Override
	public int genNewUserID() {
		int newID = 0;
		String QUERY = "select * from emp order by ID desc";
		String QUERY2 = "select * from pending order by ID desc";
			    try (Connection con = ConnectionUtil.getConnection();
	        PreparedStatement stmt = con.prepareStatement(QUERY);
			PreparedStatement stmt2 = con.prepareStatement(QUERY2);) {

  		  ResultSet rs = stmt.executeQuery();
  		ResultSet rs2 = stmt2.executeQuery();
  		  rs.next();
  		  rs2.next();
  		  try {
  		  if(rs.getInt("ID") > rs2.getInt("ID")) {
  			 newID = rs.getInt("ID") + 1;
  		  }else if(rs.getInt("ID") < rs2.getInt("ID")){
  			newID = rs2.getInt("ID") + 1;
  		  }
  		  }finally {
  		//	newID = rs.getInt("ID") + 1;
  		  }
  		  
	    } catch (SQLException e) {
	     // e.printStackTrace();
	      
	    }
		return newID;
	}


	@Override
	public boolean addNewUser(int id, String name, String password, String empname, String empcity, String empstate,
			String position, String email) {
		String QUERY2 = "insert into PENDING values(?,?,?,?,?,?,?,?,?)";

	    try (Connection con = ConnectionUtil.getConnection();
	        PreparedStatement stmt2 = con.prepareStatement(QUERY2);) {
					stmt2.setInt(1, id);
					stmt2.setString(2, name);
					stmt2.setString(3, password);
					stmt2.setString(4, empname);
					stmt2.setString(5, empcity);
					stmt2.setString(6, empstate);
					stmt2.setString(7, position);
					stmt2.setString(8, email);
					stmt2.setString(9, "invalid");
	    		
	    	
	    	//System.out.println("made it here");
	    	stmt2.executeUpdate();
	    	
	      
	}catch (SQLException e) {
	      e.printStackTrace();
	      return false;
	    }
	    return true;
	}


	@Override
	public boolean addPendingEmployee(ArrayList<String> information) {
		String QUERY2 = "insert into emp values(?,?,?,?,?,?,?,?,?)";
		String QUERY1 = "delete from pending where ID = ?";
		Employee emp = new Employee();

	    try (Connection con = ConnectionUtil.getConnection();
	        PreparedStatement stmt2 = con.prepareStatement(QUERY2);
	        PreparedStatement stmt1 = con.prepareStatement(QUERY1);) {
	    	//stmt1.execute();
	    	int row = 0;
	    	
	    	for(int i=0; i < information.size(); i=i+8) {
	    			
	    			int empid = Integer.parseInt(information.get(i));
	    			System.out.println("made it to emp:" + empid);
					stmt2.setInt(1, empid);
					stmt1.setInt(1, empid);
					
	    			String username = information.get(i+1);
					stmt2.setString(2, username);

	    			String password = information.get(i+2);
					stmt2.setString(3, password);

	    			String empname = information.get(i+3);
					stmt2.setString(4, empname);
					
					String empcity = information.get(i+4);
					stmt2.setString(5, empcity);

	    			String empstate = information.get(i+5);
					stmt2.setString(6, empstate);
					
					
	    			String position = information.get(i+7);
	    			System.out.println(position);
					stmt2.setString(7, position);
					
					String email = information.get(i+6);
					stmt2.setString(8, email);

	    			String amount = "valid";
					stmt2.setString(9, amount);

	    	System.out.println("made it here");
	    	stmt2.executeUpdate();
	    	stmt1.executeUpdate();
	    	}
	      
	}catch (SQLException e) {
	      e.printStackTrace();
	      return false;
	    }
	    return true;
	}


	@Override
	public boolean deletePendingEmployee(ArrayList<String> information) {
		String QUERY2 = "insert into emp values(?,?,?,?,?,?,?,?,?)";
		String QUERY1 = "delete from pending where ID = ?";
		
		
	    try (Connection con = ConnectionUtil.getConnection();
	    		PreparedStatement stmt1 = con.prepareStatement(QUERY1);
	        PreparedStatement stmt2 = con.prepareStatement(QUERY2);) {
	    	for(int i=0; i < information.size(); i=i+8) {

    			int empid = Integer.parseInt(information.get(i));
				stmt1.setInt(1, empid);
				stmt1.executeUpdate();
	    	}    
	}catch (SQLException e) {
	      e.printStackTrace();
	      return false;
	    }
	    return true;
	}


	@Override
	public boolean getActiveEmployee(String username, String password) {
		String QUERY = "select * from emp where USERNAME=? and PASSWORD=?";
		String QUERY2 = "insert into active values(?,?,?,?,?,?,?,?,?)";
		String QUERY3 = "truncate table active";
		Employee emp = new Employee();

	    try (Connection con = ConnectionUtil.getConnection();
	        PreparedStatement stmt = con.prepareStatement(QUERY);
	    	PreparedStatement stmt2 = con.prepareStatement(QUERY2);
	    	PreparedStatement stmt3 = con.prepareStatement(QUERY3);) {
	    	//stmt.setInt(1, 1);
	      stmt.setString(1, username);
  		  stmt.setString(2, password);
  		  ResultSet rs = stmt.executeQuery();
  		  stmt3.execute();
  		  System.out.println("trial");
	        while(rs.next()) {
	        	stmt2.setInt(1, rs.getInt("ID"));
				
				stmt2.setString(2, rs.getString("username"));

				stmt2.setString(3, rs.getString("password"));

				stmt2.setString(4, rs.getString("empname"));
				
				stmt2.setString(5, rs.getString("empcity"));

				stmt2.setString(6,  rs.getString("empstate"));
				
				stmt2.setString(7,  rs.getString("position"));
		
				stmt2.setString(8,  rs.getString("email"));

				stmt2.setString(9,  rs.getString("valid"));
	        	stmt2.executeUpdate();
	        }
	    } catch (SQLException e) {
	      e.printStackTrace();
	      return false;
	    }
		return true;
	}


	@Override
	public boolean updateEmp(ArrayList<String> information) {
		String QUERY = "update emp set username=?,password=?,empname=?,empcity=?,empstate=?,email=? where ID =?";
		Employee emp = new Employee();

	    try (Connection con = ConnectionUtil.getConnection();
	        PreparedStatement stmt = con.prepareStatement(QUERY);) {
	    	//stmt.setInt(1, 1);

	        	stmt.setString(1, information.get(1));
	        	stmt.setString(2, information.get(2));
	        	stmt.setString(3, information.get(3));
	        	stmt.setString(4, information.get(4));
	        	stmt.setString(5, information.get(5));
	        	stmt.setString(6, information.get(6));
	        	stmt.setString(7, information.get(0));
	        
	        	stmt.executeUpdate();
	    } catch (SQLException e) {
	      e.printStackTrace();
	      return false;
	    }
		return true;
	}
	
}
