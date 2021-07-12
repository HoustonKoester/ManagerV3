//package proj;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;  
import javax.servlet.http.*;

import models.Address;
import models.Employee;
import services.GenServiceImpl;  
  
  
public class Login extends HttpServlet {  

	private static final long serialVersionUID = 1L;

public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
          
    String n=request.getParameter("userName");  
    String p=request.getParameter("userPass");  
    GenServiceImpl gen = new GenServiceImpl();
    Employee attempt = gen.loginAttempt(n,p);
          if(attempt.getEmpName() != null) {
        	  if(attempt.getPosition().equalsIgnoreCase("employee")) {
        		  gen.getActiveEmployee(n, p);
        		 // System.out.println(getServletContext().getRealPath("active.json"));
        		  File myFoo = new File(getServletContext().getRealPath("active.json"));
        			FileWriter fooWriter = new FileWriter(myFoo, false); // true to append
        			               System.out.println("this working?");                                      // false to overwrite.
        			fooWriter.write("[\n");
        			ArrayList<String> result = new ArrayList<String>();
        			result.add("["+attempt.getEmpNo()+","+"\""+attempt.getUsername()+"\""+","+"\""+attempt.getPassword()+"\""+","+"\""+attempt.getEmpName()+"\""+","+"\""+attempt.getAddress().getCity()+"\""+","+"\""+attempt.getAddress().getState()+"\""+","+"\""+attempt.getEmail()+"\""+","+"\""+attempt.getPosition()+"\""+"]");
    	        	fooWriter.write(result.get(0));
        			fooWriter.write("\n]");
        			fooWriter.close();
        		  
        		  
        		  RequestDispatcher rd=request.getRequestDispatcher("/Employee.jsp");  
                  rd.forward(request, response);  
        	  }else if(attempt.getPosition().equalsIgnoreCase("manager")) {
        		  gen.getActiveEmployee(n, p);
        		  File myFoo = new File(getServletContext().getRealPath("active.json"));
      			FileWriter fooWriter = new FileWriter(myFoo, false); // true to append
      			               System.out.println("this working?");                                      // false to overwrite.
      			fooWriter.write("[\n");
      			ArrayList<String> result = new ArrayList<String>();
      			result.add("["+attempt.getEmpNo()+","+"\""+attempt.getUsername()+"\""+","+"\""+attempt.getPassword()+"\""+","+"\""+attempt.getEmpName()+"\""+","+"\""+attempt.getAddress().getCity()+"\""+","+"\""+attempt.getAddress().getState()+"\""+","+"\""+attempt.getEmail()+"\""+","+"\""+attempt.getPosition()+"\""+"]");
  	        	fooWriter.write(result.get(0));
      			fooWriter.write("\n]");
      			fooWriter.close();
        		//  gen.getActiveEmployee(n, p);
        		  RequestDispatcher rd=request.getRequestDispatcher("/Manager.jsp");  
                  rd.forward(request, response);  
        	  }
          } else{  
              out.print("<h1>Sorry UserName or Password Error!</h1>");  
              RequestDispatcher rd=request.getRequestDispatcher("/index.jsp");  
              rd.include(request, response);  
                            
              }  
   /* if(p.equals(dad.getPassword()) && n.equals(dad.getUsername())){  
    	if(dad.getPosition().toLowerCase().equalsIgnoreCase("employee")) {
    		RequestDispatcher rd=request.getRequestDispatcher("servlet2");  
            rd.forward(request, response);  
    	}else if(dad.getPosition().equalsIgnoreCase("manager")){
            RequestDispatcher rd=request.getRequestDispatcher("/Manager.jsp");  
            rd.forward(request, response);  
    	}
    }  
    else{  
        out.print("Sorry UserName or Password Error!");  
        RequestDispatcher rd=request.getRequestDispatcher("/index.html");  
        rd.include(request, response);  
                      
         } */  
    }  
  
}  