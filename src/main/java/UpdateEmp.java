

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
 * Servlet implementation class UpdateEmp
 */
@WebServlet("/UpdateEmp")
public class UpdateEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmp() {
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
		    String[] col = {"0","1","2","3","4","5","6","7"};
		    int i = 0;
		    for(String ids: td) {
		    	for(String column: col) {
		    		String val = request.getParameter("id"+ids+column);
		    		System.out.println(val);
				    information.add(val);
				    i++;
		    	}
		    }  
		    
		  //  gen.updateDatabase(information);
		    gen.updateEmp(information);
		    out.print("<h1>Information updated! Login with new information to continue.</h1>");  
		    RequestDispatcher rd=request.getRequestDispatcher("/index.jsp");  
	        rd.include(request, response);  
	}

}
