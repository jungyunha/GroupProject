package bookstore.boundary;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	
	private User currentUser;
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
		
		if (request.getParameter("register") != null) {
			registerUser(request, response);
		}
		
		if (request.getParameter("login") != null) {
			login(request, response);
		}
		
		if (request.getParameter("verify") != null) {
			verifyUser(request, response);
		}
		if (request.getParameter("logout") !=null){
			logout(request, response);
		}
	}
	//logout
	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        request.getRequestDispatcher("index.html").include(request, response);  
          
        HttpSession session=request.getSession();  
        session.invalidate();  
          
        out.print("You are successfully logged out!");  
          
        out.close(); 
	}
	
	private void verifyUser(HttpServletRequest request, HttpServletResponse response) {
		String verificationCode = request.getParameter("code");
		if (verificationCode.equals(currentUser.getVerificationCode())) {
			System.out.println(verificationCode);
			UserLogic.setStatus(currentUser, "Active");
		}
		DefaultObjectWrapperBuilder db = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
		SimpleHash root = new SimpleHash(db.build());
		String templateName = "login.ftl";
		root.put("error",  "Your account has successfully been verified. You may now log in.");
		processor.runTemp(templateName, root, request, response);
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
		}else if (user.getStatus().equals("Waiting")){
			templateName = "login.ftl";
			root.put("error", "Account pending verification. Please verify your account and try logging in again.");
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
		}else if(user.getUserType() == 3) {
			templateName = "managerloggedin.ftl";
			root.put("hello", "Hi there " + user.getFirstName());
			processor.runTemp(templateName, root, request, response);
		}else if(user.getUserType() == 4) {
			templateName = "shipperloggedin.ftl";
			root.put("hello", "Hi there " + user.getFirstName());
			processor.runTemp(templateName, root, request, response);
		}
		
	}

	private void registerUser(HttpServletRequest request, HttpServletResponse response) {
		int id = 15;
		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		String phoneNumber = request.getParameter("phone");
		String emailAddress = request.getParameter("email");
		String password = request.getParameter("password");
		String mailingAddress = request.getParameter("address");
		int userType = 1;
		
		User newUser = new User(id, firstName, lastName, phoneNumber, emailAddress, password, userType, mailingAddress, mailingAddress, "Waiting");
		UserLogic.registerUser(newUser);
		String verificationCode = getRandomString();
		String subject = "Verify your New Account";
		String content = "Your verification code is " + verificationCode;
		UserLogic.setVerificationCode(newUser, verificationCode);
		newUser.setVerificationCode(verificationCode);
		currentUser = newUser;
		
		try {
            EmailUtility.sendEmail(host, port, user, pass, emailAddress, subject, content);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		DefaultObjectWrapperBuilder db = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
		SimpleHash root = new SimpleHash(db.build());
		String templateName = "verify.ftl";
		root.put("name", newUser.getFirstName());
		processor.runTemp(templateName, root, request, response);
	}
	
	protected String getRandomString() {
        String allChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder str = new StringBuilder();
        Random rnd = new Random();
        while (str.length() < 6) { // length of the random string.
            int index = (int) (rnd.nextFloat() * allChars.length());
            str.append(allChars.charAt(index));
        }
        String randomString = str.toString();
        return randomString;

    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
