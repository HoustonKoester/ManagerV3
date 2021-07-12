

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

import services.GenServiceImpl;

/**
 * Servlet implementation class ManagerReimCheck
 */
@WebServlet("/ManagerReimCheck")
public class ManagerReimCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerReimCheck() {
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
		File myFoo = new File(getServletContext().getRealPath("reinburse.json"));
		FileWriter fooWriter = new FileWriter(myFoo, false); // true to append
		                                                   // false to overwrite.
		fooWriter.write("[\n");
		
		String QUERY = "select * from reim where id=?";
		GenServiceImpl gen = new GenServiceImpl();
		ArrayList<String> result = new ArrayList<String>();
		int a = 0;
	    try (Connection con = ConnectionUtil.getConnection();
	        PreparedStatement stmt = con.prepareStatement(QUERY);
	    		) {
	    	//System.out.println(gen.returnActiveEmp().getEmpNo());
	    	stmt.setInt(1, Integer.parseInt(request.getParameter("userid")));
	    	
  		  ResultSet rs = stmt.executeQuery();
	        while(rs.next()) {
	        	result.add("["+rs.getInt("ID")+","+"\""+rs.getString("empname")+"\""+","+rs.getInt("amount")+","+"\""+rs.getString("status")+"\""+","+"\""+rs.getString("acceptby")+"\""+"]");
	        	
	        }
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    
	   // System.out.println(result);
	    	for(a = 0; a<result.size()-1; a++) {
		    	fooWriter.write(result.get(a) + ",\n");
		    
	    }
	    
	    
	    try {
	    fooWriter.write(result.get(a));
	    fooWriter.write("\n]");
		fooWriter.close();
		RequestDispatcher rd=request.getRequestDispatcher("/ManagersReinbursement.jsp");  
        rd.include(request, response);  
	    }catch(IOException v) {
	    	RequestDispatcher rd=request.getRequestDispatcher("/ManagersReinbursement.jsp");  
	        rd.include(request, response); 
	    }finally {
	    	RequestDispatcher rd=request.getRequestDispatcher("/ManagersReinbursement.jsp");  
	        rd.forward(request, response); 
	        fooWriter.close();
	    }
	}

}
