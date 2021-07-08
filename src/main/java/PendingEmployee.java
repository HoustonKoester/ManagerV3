

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.GenServiceImpl;

/**
 * Servlet implementation class PendingEmployee
 */
@WebServlet("/PendingEmployee")
public class PendingEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PendingEmployee() {
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
		 GenServiceImpl gen = new GenServiceImpl();
		    PrintWriter out = response.getWriter();
		    //System.out.println("Made it to the servlet2");
		    
		    String td[] = request.getParameterValues("id");
		    ArrayList<String> information = new ArrayList<String>();
		    ArrayList<String> delete = new ArrayList<String>();
		    ArrayList<String> accept = new ArrayList<String>();
		    
		    
		    String[] col = {"0","1","2","3","4","5","6","7"};
		    int i = 0;
		    for(String ids: td) {
		    	String decision = request.getParameter("decision"+ids);
		    	if(decision.equals("Accepted")) {
		    	for(String column: col) {
		    		String val = request.getParameter("id"+ids+column);
		    		accept.add(val);
				    i++;
				   
		    	}
		    	}else {
		    		for(String column: col) {
			    		String val = request.getParameter("id"+ids+column);
			    		delete.add(val);
					    i++;
					    
			    	}
		    	}
		    }
		    System.out.println(delete);
	    	System.out.println(accept);
	    	gen.addPendingEmployee(accept);
	    	gen.deletePendingEmployee(delete);
	    	//gen.addPendingEmployee(i, getServletName(), getServletInfo(), getServletInfo(), getServletInfo(), getServletInfo(), getServletName(), getServletInfo())
		    //gen.updateDatabase(information);
		    RequestDispatcher rd=request.getRequestDispatcher("/Manager.jsp");  
	        rd.include(request, response);  
	}

}
