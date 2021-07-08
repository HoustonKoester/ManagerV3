

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Employee;
import services.GenServiceImpl;

/**
 * Servlet implementation class EmployeeReim
 */
@WebServlet("/EmployeeReim")
public class EmployeeReim extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeReim() {
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
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	          
	    String i=request.getParameter("userID");  
	    String n=request.getParameter("userName");  
	    String a=request.getParameter("amount");  
	    GenServiceImpl gen = new GenServiceImpl();
	    boolean submitted = gen.insertReim(i, n, a);
	          if(submitted) {
	        	  out.print("Await Manager confirmation");  
	        	  RequestDispatcher rd=request.getRequestDispatcher("/Employee.jsp");  
                  rd.include(request, response);  
//	        	  if(attempt.getPosition().equalsIgnoreCase("employee")) {
//	        		  RequestDispatcher rd=request.getRequestDispatcher("/Employee.jsp");  
//	                  rd.forward(request, response);  
//	        	  }else if(attempt.getPosition().equalsIgnoreCase("manager")) {
//	        		  RequestDispatcher rd=request.getRequestDispatcher("/Manager.jsp");  
//	                  rd.forward(request, response);  
//	        	  }
	          } else{  
	              out.print("Sorry request not accepted!");  
	              RequestDispatcher rd=request.getRequestDispatcher("/Employee.jsp");  
	              rd.include(request, response);  
	                            
	              }  
	}

}
