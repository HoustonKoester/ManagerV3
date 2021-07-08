

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
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		 response.setContentType("text/html");  
		    PrintWriter out = response.getWriter();  
		          
		    String n=request.getParameter("userName");  
		    String p=request.getParameter("userPass");  
		    String p2=request.getParameter("userPassConfirm");  
		    String email=request.getParameter("Email"); 
		    String city=request.getParameter("City");  
		    String state=request.getParameter("State"); 
		    String position=request.getParameter("position");  
		    
		    
		    System.out.println(n + " : " + p + " : " +p2 + " : " +email + " : " +city + " : " +state + " : " +position);
		    
		    GenServiceImpl gen = new GenServiceImpl();
		    int Id = gen.genNewUserID();
		    //System.out.println(Id);
		    
		    //need to add to double check if user exists in main employee table too, but can worry about that later
		    if(p.equals(p2)) {
		    	gen.addNewUser(Id, n, p, p, city, state, position, email);
		    	out.print("<h1>Await manager approval</h1>");  
		    	RequestDispatcher rd=request.getRequestDispatcher("/index.jsp");  
	              rd.include(request, response);  
		    }else {
		    	 out.print("<h1>Your passwords do not match!</h1>");  
	              RequestDispatcher rd=request.getRequestDispatcher("/register.jsp");  
	              rd.include(request, response);  
		    }
		    
		    
//		          if(attempt.getEmpName() != null) {
//		        	  if(attempt.getPosition().equalsIgnoreCase("employee")) {
//		        		  RequestDispatcher rd=request.getRequestDispatcher("/Employee.jsp");  
//		                  rd.forward(request, response);  
//		        	  }else if(attempt.getPosition().equalsIgnoreCase("manager")) {
//		        		  RequestDispatcher rd=request.getRequestDispatcher("/Manager.jsp");  
//		                  rd.forward(request, response);  
//		        	  }
//		          } else{  
//		              out.print("Sorry UserName or Password Error!");  
//		              RequestDispatcher rd=request.getRequestDispatcher("/index.html");  
//		              rd.include(request, response);  
//		                            
//		              }  
	}

}
