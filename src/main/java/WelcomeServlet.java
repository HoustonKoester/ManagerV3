//package proj;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.*;  
import javax.servlet.http.*;

import services.GenServiceImpl;  
  
public class WelcomeServlet extends HttpServlet {  

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
		 response.setContentType("text/html");  
		 GenServiceImpl gen = new GenServiceImpl();
		    PrintWriter out = response.getWriter();
		    //System.out.println("Made it to the servlet2");
		    
		    String td[] = request.getParameterValues("id");
		    ArrayList<String> information = new ArrayList<String>();
		    String[] col = {"0","1","2","3"};
		    int i = 0;
		    for(String ids: td) {
		    	for(String column: col) {
		    		String val = request.getParameter("id"+ids+column);
				    information.add(val);
				    i++;
		    	}
		    }
//		    for(int t=0; t<information.size(); t++) {
//		    	System.out.println( information.get(t));
//		    }
		    gen.updateDatabase(information);
		    //for(String id: td) {
		    	//String trial = request.getParameter("id03");
		    	//System.out.println(trial);
		  //  }
	}
	
}
