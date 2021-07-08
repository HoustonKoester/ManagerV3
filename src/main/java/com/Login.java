package com;
//package proj;

import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;

import models.Address;
import models.Employee;  
  
  
public class Login extends HttpServlet {  

	private static final long serialVersionUID = 1L;

public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
	Employee dad = new Employee("Glenn", "dad", 1, "Glenn", new Address("Chino Valley","Arizona"), "manager", null);
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
          
    String n=request.getParameter("userName");  
    String p=request.getParameter("userPass");  
          
    if(p.equals(dad.getPassword()) && n.equals(dad.getUsername())){  
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
                      
        }  
    }  
  
}  