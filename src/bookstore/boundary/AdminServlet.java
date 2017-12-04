package bookstore.boundary;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookstore.logic.UserLogic;
import bookstore.object.Book;
import bookstore.object.User;
import bookstore.object.UserStatus;
import bookstore.object.UserType;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapperBuilder;
import freemarker.template.SimpleHash;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private User currentUser;
	private TemplateProcessor processor;
	private String host;
	private String port;
	private String user;
	private String pass;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		DefaultObjectWrapperBuilder db = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
		SimpleHash root = new SimpleHash(db.build());
		String templateName;
		String action = request.getParameter("action");
		if (action != null) {
			if (action.equals("addbook")) {
				templateName = "addbook.ftl";
				processor.runTemp(templateName, root, request, response);
			}else if (action.equals("updatebook")) {
				templateName = "updatebook.ftl";
				processor.runTemp(templateName, root, request, response);
			}else if (action.equals("createpromo")) {
				templateName = "createpromo.ftl";
				processor.runTemp(templateName, root, request, response);
			}else if (action.equals("addemployee")) {
				templateName = "addemployee.ftl";
				processor.runTemp(templateName, root, request, response);
			}else if (action.equals("deletebook")){
				templateName = "deletebook.ftl";
				processor.runTemp(templateName, root, request, response);
			}else if (action.equals("suspendacct")) {
				templateName = "suspendaccount.ftl";
				processor.runTemp(templateName, root, request, response);
			}else if (action.equals("manageuser")) {
				templateName = "manageusers.ftl";
				processor.runTemp(templateName, root, request, response);
			}else if (action.equals("managesupplier")) {
				templateName = "managesupplier.ftl";
				processor.runTemp(templateName, root, request, response);
			}else if (action.equals("manageshipper")) {
				//templateName = "adminaddbook.ftl";
				//processor.runTemp(templateName, root, request, response);
			}else if (action.equals("viewsales")) {
				templateName = "salesreport.ftl";
				processor.runTemp(templateName, root, request, response);
			}else if (action.equals("viewinventory")) {
				templateName = "inventoryreport.ftl";
				processor.runTemp(templateName, root, request, response);
			}else if (action.equals("viewpublisher")) {
				templateName = "publisherreport.ftl";
				processor.runTemp(templateName, root, request, response);
			}
		}
		if (request.getParameter("promosubmit") != null) {
			createPromotion(request, response);
		}
		if (request.getParameter("addemployee") != null) {
			addEmployee(request, response);
		}
		if(request.getParameter("addbook") != null){
			addBook(request, response);
		}
		if(request.getParameter("updatebook") != null){
			updateBook(request, response);
		}
		if(request.getParameter("deletebook") != null){
			deleteBook(request, response);
		}
	}
	
	private void deleteBook(HttpServletRequest request, HttpServletResponse response){
		int iSBN = Integer.parseInt(request.getParameter("iSBN"));
		UserLogic.deleteBook(iSBN);
		DefaultObjectWrapperBuilder db = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
		SimpleHash root = new SimpleHash(db.build());
		String templateName = "adminhome.ftl";
		root.put("hello","Book deleted successfully!");
		processor.runTemp(templateName, root, request, response);	
	}
	
	private void updateBook(HttpServletRequest request, HttpServletResponse response){
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		int iSBN = Integer.parseInt(request.getParameter("iSBN"));
		int iSBN2 = Integer.parseInt(request.getParameter("iSBN2"));
		String category = request.getParameter("category");
		String price = request.getParameter("price");
		String coverphoto = request.getParameter("coverphoto");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		String description = request.getParameter("description");
		int thresholdLimit = Integer.parseInt(request.getParameter("thresholdLimit"));
		int rating = Integer.parseInt(request.getParameter("rating"));
		Book newBook = new Book();
		newBook.setAuthor(title);
		newBook.setCategory(category);
		newBook.setQuantity(quantity);
		newBook.setDescription(coverphoto);
		newBook.setCoverphoto(description);
		newBook.setThresholdLimit(thresholdLimit);
		newBook.setRating(rating);
		newBook.setISBN(iSBN2);
		newBook.setISBN(iSBN);
		newBook.setAuthor(author);
		newBook.setCategory(category);
		newBook.setPrice(Float.parseFloat(price));
		UserLogic.updateBook(iSBN, title, price, quantity, coverphoto, category,
				 description, thresholdLimit,  rating, author,iSBN2);
		 
		DefaultObjectWrapperBuilder db = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
		SimpleHash root = new SimpleHash(db.build());
		String templateName = "adminhome.ftl";
		root.put("hello","Updated book successfully!");
		processor.runTemp(templateName, root, request, response); 
	}


	
	private void addEmployee(HttpServletRequest request, HttpServletResponse response) {
		String firstName = request.getParameter("fName");
		String lastName = request.getParameter("lName");
		int id = Integer.parseInt(request.getParameter("employeeID"));
		String email = request.getParameter("emailAddress");
		String password = request.getParameter("employeePassword");
		String phoneNumber = request.getParameter("employeePhone");
		String type = request.getParameter("employeeType");
		User newEmployee = new User();
		newEmployee.setFirstName(firstName);
		newEmployee.setLastName(lastName);
		newEmployee.setId(id);
		newEmployee.setEmail(email);
		newEmployee.setPassword(password);
		newEmployee.setPhoneNumber(phoneNumber);
		if (type.equals("admin")) {
			newEmployee.setUserType(UserType.Admin);
		} else if (type.equals("manager")) {
			newEmployee.setUserType(UserType.Manager);
		} else {
			newEmployee.setUserType(UserType.ShipmentEmployee);
		}
		newEmployee.setShippingAddress(" ");
		newEmployee.setBillingAddress(" ");
		newEmployee.setStatus(UserStatus.Active);
		newEmployee.setSuscribed(false);
		newEmployee.setVerificationCode(" ");
		UserLogic.registerUser(newEmployee);
		DefaultObjectWrapperBuilder db = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
		SimpleHash root = new SimpleHash(db.build());
		String templateName = "adminhome.ftl";
		root.put("hello", "Employee was created successfully.");
		processor.runTemp(templateName, root, request, response);
	}

	private void createPromotion(HttpServletRequest request, HttpServletResponse response) {
		String promocode = request.getParameter("promocode");
		int percentage = Integer.parseInt(request.getParameter("promopercent"));
		UserLogic.addPromotion(promocode, percentage);
		List<User> listOfSubscribedUsers = UserLogic.getSubscribedUsers();
		String subject = "New Promotion!";
		String content = "There is a new promotion available! In order to get " + percentage + "% off of your next order, enter the promo code " + promocode + " at checkout. Happy shopping!";
		for(User x : listOfSubscribedUsers) {
			try {
	            EmailUtility.sendEmail(host, port, user, pass, x.getEmail(), subject, content);
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
		}
		DefaultObjectWrapperBuilder db = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
		SimpleHash root = new SimpleHash(db.build());
		String templateName = "adminhome.ftl";
		root.put("hello", "Promotion was created successfully. All subcribed users have been notified via email.");
		processor.runTemp(templateName, root, request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
