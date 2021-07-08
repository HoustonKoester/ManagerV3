

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ConnectionUtil;

import models.Employee;

/**
 * Servlet implementation class LoadPending
 */
@WebServlet("/LoadPending")
public class LoadPending extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadPending() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		File myFoo = new File(getServletContext().getRealPath("pending.json"));
		FileWriter fooWriter = new FileWriter(myFoo, false); // true to append
		               System.out.println("this working?");                                      // false to overwrite.
		fooWriter.write("[\n");
		
		String QUERY = "select * from pending";
		Employee emp = new Employee();
		ArrayList<String> result = new ArrayList<String>();
		int a = 0;
	    try (Connection con = ConnectionUtil.getConnection();
	        PreparedStatement stmt = con.prepareStatement(QUERY);
	    		) {
	    	
  		  ResultSet rs = stmt.executeQuery();
	        while(rs.next()) {
	        	result.add("["+rs.getInt("ID")+","+"\""+rs.getString("username")+"\""+","+"\""+rs.getString("password")+"\""+","+"\""+rs.getString("empname")+"\""+","+"\""+rs.getString("empcity")+"\""+","+"\""+rs.getString("empstate")+"\""+","+"\""+rs.getString("email")+"\""+","+"\""+rs.getString("position")+"\""+"]");
	        	
	        }
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    for(a = 0; a<result.size()-1; a++) {
	    	fooWriter.write(result.get(a) + ",\n");
	    }
	    try {
	    fooWriter.write(result.get(a));
	    fooWriter.write("\n]");
		fooWriter.close();
		RequestDispatcher rd=request.getRequestDispatcher("/NewEmployee.jsp");  
        rd.forward(request, response);  
	    }finally {
	    	RequestDispatcher rd=request.getRequestDispatcher("/NewEmployee.jsp");  
	        rd.forward(request, response);  
	        fooWriter.close();
	    }
	    
	}

}
