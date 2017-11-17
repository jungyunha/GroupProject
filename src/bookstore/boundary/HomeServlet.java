package bookstore.boundary;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookstore.logic.UserLogic;
import bookstore.object.User;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapperBuilder;
import freemarker.template.SimpleHash;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private TemplateProcessor processor;
	private String host;
	private String port;
	private String user;
	private String pass;

    public HomeServlet() {
    	super();
    }
    
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        user = context.getInitParameter("user");
        pass = context.getInitParameter("pass");
    	processor = new TemplateProcessor(getServletContext());
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
			login(request, response);
		}
	}

	private void login(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String pass = request.getParameter("pass");
		DefaultObjectWrapperBuilder db = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
		SimpleHash root = new SimpleHash(db.build());
		String templateName;
		User user = UserLogic.verifyUser(username, pass);
		if (user.getId() == 0) {
			templateName = "login.ftl";
			root.put("error", "Invalid email/ID or password. Please try again.");
			processor.runTemp(templateName, root, request, response);
		}else if(user.getUserType() == 1){
			templateName = "logged_in.ftl";
			root.put("first", user.getFirstName());
			root.put("last", user.getLastName());
			processor.runTemp(templateName, root, request, response);
		}else if(user.getUserType() == 2) {
			templateName = "adminloggedin.ftl";
			root.put("hello", "Hi there " + user.getFirstName());
			processor.runTemp(templateName, root, request, response);
		}
		
	}

	private boolean registerUser(HttpServletRequest request, HttpServletResponse response) {
		int id = 15;
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
		
		User newUser = new User(id, firstName, lastName, phoneNumber, emailAddress, password, userType);
		UserLogic.registerUser(newUser);
		String subject = "Verify your New Account";
		String content = "Please verify your new account.";
		
		try {
            EmailUtility.sendEmail(host, port, user, pass, emailAddress, subject, content);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		
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
