package webapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Browser sends Http Request to Web Server
 * 
 * Code in Web Server => Input:HttpRequest, Output: HttpResponse
 * JEE with Servlets
 * 
 * Web Server responds with Http Response
 */

//Java Platform, Enterprise Edition (Java EE) JEE6

//Servlet is a Java programming language class 
//used to extend the capabilities of servers 
//that host applications accessed by means of 
//a request-response programming model.

//1. extends javax.servlet.http.HttpServlet
//2. @WebServlet(urlPatterns = "/login.do")
//3. doGet(HttpServletRequest request, HttpServletResponse response)
//4. How is the response created?

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// PrintWriter out = response.getWriter();

		// Following is the code for servelet

		/*
		 * out.println("<html>"); out.println("<head>");
		 * out.println("<title>Mahesh</title>"); out.println("</head>");
		 * out.println("<body>"); out.
		 * println(" <font color=\"red\"> My First Servlet ... ha ha ha ...</font>"
		 * );
		 * 
		 * out.println("</body>"); out.println("</html>");
		 */

		String name = request.getParameter("name");
		System.out.println(name);
		request.setAttribute("name", name);

		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);

		/*
		 * request.setAttribute("name", request.getAttribute("name")); String
		 * password = request.getParameter("password");
		 * 
		 * request.setAttribute("password", request.getAttribute("password"));
		 * if (password.equals("123")) {
		 * request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(
		 * request, response); } else { System.out.println("invalid pasword"); }
		 */

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		request.setAttribute("name", name);
		String password = request.getParameter("password");

		// request.setAttribute("password", request.getAttribute("password"));
		UsrerValidationService s = new UsrerValidationService();
		if (s.isUserValid(name, password)) {
			request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);
		} else {
			request.setAttribute("errorMessage", "Invalid credentials; try again"); 
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		}
	}

}
