package bookstore.boundary;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bookstore.logic.UserLogic;
import bookstore.object.*;
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
    	currentUser = null;
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
		if (request.getParameter("logout") != null){
			logout(request, response);
		}
		if (request.getParameter("searchBook") != null) {
			searchBook(request, response);
		}
		if (request.getParameter("addtocart") != null) {
			addToCart(request, response);
		}
		if (request.getParameter("mycart") != null) {
			goToCart(request, response);
		}
	}
	
	private void goToCart(HttpServletRequest request, HttpServletResponse response) {
		DefaultObjectWrapperBuilder db = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
		SimpleHash root = new SimpleHash(db.build());
		String templateName;
		if (currentUser == null) {
			templateName = "login.ftl";
			root.put("error", "Please login in order to view your shopping cart.");
			processor.runTemp(templateName, root, request, response);
		} else {
			Vector<Integer> bookNumbers = new Vector<Integer>();
			bookNumbers = UserLogic.getBookNumbers(currentUser.getId());
			for (int i : bookNumbers) {
				System.out.println("this blows");
			}
		}
	}

	private void addToCart(HttpServletRequest request, HttpServletResponse response) {
		String isbn = request.getParameter("addtocart");
		UserLogic.addToCart(currentUser.getId(), 1, Integer.parseInt(isbn));
	}

	private void searchBook(HttpServletRequest request, HttpServletResponse response) {
		String type = request.getParameter("searchType");
		String value = request.getParameter("searchValue");
		boolean loggedin = (currentUser != null);
		if(type != null && value != null) {
			DefaultObjectWrapperBuilder db = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
			SimpleHash root = new SimpleHash(db.build());
			root.put("loggedin", loggedin);
			String templateName = "searchresults.ftl";
			if (type.equals("title")) {
				List<Book> listOfBooks = UserLogic.getBooksByTitle(value);
				root.put("books", listOfBooks);
				processor.runTemp(templateName, root, request, response);
			}else if (type.equals("subject")) {
				List<Book> listOfBooks = UserLogic.getBooksBySubject(value);
				root.put("books", listOfBooks);
				processor.runTemp(templateName, root, request, response);
			}else if (type.equals("author")) {
				List<Book> listOfBooks = UserLogic.getBooksByAuthor(value);
				root.put("books", listOfBooks);
				processor.runTemp(templateName, root, request, response);
			}else if (type.equals("isbn")) {
				List<Book> listOfBooks = UserLogic.getBooksByISBN(value);
				root.put("books", listOfBooks);
				processor.runTemp(templateName, root, request, response);
			}
		}
	}

	//logout
	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		currentUser = null;
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
			UserLogic.setStatus(currentUser, UserStatus.Active);
		}
		DefaultObjectWrapperBuilder db = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
		SimpleHash root = new SimpleHash(db.build());
		String templateName = "login.ftl";
		root.put("error",  "Your account has successfully been verified. You may now log in.");
		processor.runTemp(templateName, root, request, response);
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		}else if (user.getStatus() == UserStatus.Waiting){
			templateName = "login.ftl";
			root.put("error", "Account pending verification. Please verify your account and try logging in again.");
			processor.runTemp(templateName, root, request, response);
		} //TODO: Add conditions for UserStatus.Supsended... ?
		else{
			currentUser = user;
			UserType userType = user.getUserType();
			switch(userType) {
				case Customer:
					templateName = "logged_in.ftl";
					root.put("first", user.getFirstName());
					root.put("last", user.getLastName());
					processor.runTemp(templateName, root, request, response);
					break;
				case Admin:
					templateName = "adminhome.ftl";
					root.put("hello", "Hi there " + user.getFirstName());
					processor.runTemp(templateName, root, request, response);
					break;
				case Manager:
					templateName = "managerhome.ftl";
					root.put("hello", "Hi there " + user.getFirstName());
					processor.runTemp(templateName, root, request, response);
					break;
				case ShipmentEmployee:
					templateName = "shipperhome.ftl";
					root.put("hello", "Hi there " + user.getFirstName());
					processor.runTemp(templateName, root, request, response);
					break;
				case None:
				default:
					// TODO: Display an error or something...
					break;
			}
		}
	}

	private void registerUser(HttpServletRequest request, HttpServletResponse response) {
		int id = 10; // TODO: ...
		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		String phoneNumber = request.getParameter("phone");
		String emailAddress = request.getParameter("email");
		String password = request.getParameter("password");
		String mailingAddress = request.getParameter("address");
		String subscribeForPromo = request.getParameter("subscribe");
		boolean subscribe = (subscribeForPromo.equals("on"));
		UserType userType = UserType.Customer;
		
		// TODO: Validate info: make sure passwords match, check if the submitted email is already used for another account, etc.
		// If not, return to registration page and show error...
		
		User newUser = new User(id, firstName, lastName, phoneNumber, emailAddress, password, userType, mailingAddress, mailingAddress, UserStatus.Waiting, subscribe);
		String verificationCode = getRandomString();
		newUser.setVerificationCode(verificationCode);
		UserLogic.registerUser(newUser);
		String subject = "Verify your New Account";
		String content = "Your verification code is " + verificationCode;
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
