package bookstore.boundary;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookstore.logic.UserLogic;
import bookstore.object.User;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public HomeServlet() {

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		if (request.getParameter("register") != null) {
			if (registerUser(request, response))
			{
				out.println("<h1>User registered successfully.</h1>");
			}
			else {
				out.println("<h1>Passwords don't match.</h1>");
			}
		}
		
		if (request.getParameter("login") != null) {
			System.out.println("we're here");
			if (login(request, response))
			{
				out.println("<h1>Login successful.</h1>");
			}
			else {
				out.println("<h1>Invalid email or password.</h1>");
			}
		}
	}

	private boolean login(HttpServletRequest request, HttpServletResponse response) {
		String email = request.getParameter("username");
		String pass = request.getParameter("pass");
		
		if(UserLogic.verifyUser(email, pass) == -1) {
			return false;
		}else {
			return true;
		}
	}

	private boolean registerUser(HttpServletRequest request, HttpServletResponse response) {
		int id = 2;
		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		String phoneNumber = request.getParameter("phone");
		String emailAddress = request.getParameter("email");
		String password = request.getParameter("password");
		String passwordConfirm = request.getParameter("password2");
		if (!password.equals(passwordConfirm)) {
			return false;
		}
		int userType = 1;
		
		User user = new User(id, firstName, lastName, phoneNumber, emailAddress, password, userType);
		UserLogic.registerUser(user);
		return true;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
