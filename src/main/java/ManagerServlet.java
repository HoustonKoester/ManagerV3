

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ConnectionUtil;

import models.Address;
import models.Employee;

/**
 * Servlet implementation class ManagerServlet
 */
@WebServlet("/ManagerServlet")
public class ManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Timed out").append(request.getContextPath());
		RequestDispatcher rd=request.getRequestDispatcher("/Manager.jsp");  
        rd.forward(request, response);  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(getServletContext().getRealPath("reinburse.json"));
		File myFoo = new File(getServletContext().getRealPath("reinburse.json"));
		FileWriter fooWriter = new FileWriter(myFoo, false); // true to append
		               System.out.println("this working?");                                      // false to overwrite.
		fooWriter.write("[\n");
		
		String QUERY = "select * from reim";
		Employee emp = new Employee();
		ArrayList<String> result = new ArrayList<String>();
		int a = 0;
	    try (Connection con = ConnectionUtil.getConnection();
	        PreparedStatement stmt = con.prepareStatement(QUERY);
	    		) {
	    	
  		  ResultSet rs = stmt.executeQuery();
	        while(rs.next()) {
	        	result.add("["+rs.getInt("ID")+","+"\""+rs.getString("empname")+"\""+","+rs.getInt("amount")+","+"\""+rs.getString("status")+"\""+"]");
	        	
	        }
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    for(a = 0; a<result.size()-1; a++) {
	    	fooWriter.write(result.get(a) + ",\n");
	    }
	    fooWriter.write(result.get(a));
	    fooWriter.write("\n]");
		fooWriter.close();
		RequestDispatcher rd=request.getRequestDispatcher("/ManagersReinbursement.jsp");  
        rd.include(request, response);  
		
//		 response.setContentType("text/html");  
//		    PrintWriter out = response.getWriter();  
//		          
//		    String n=request.getParameter("userName");  
//		    out.print("Welcome Manager "+n);  
	}

}
