package bookstore.boundary;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
import bookstore.object.Transaction;
import bookstore.object.User;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapperBuilder;
import freemarker.template.SimpleHash;

/**
 * Servlet implementation class ManagerServlet
 */
@WebServlet("/ManagerServlet")
public class ManagerServlet extends HttpServlet {
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
    public ManagerServlet() {
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
		String managerAction = request.getParameter("ManagerAction");
		if (managerAction != null) {
			if (managerAction.equals("viewinventory")) {
				viewManagerInventory(request, response);
			} else if (managerAction.equals("viewsales")) {
				viewManagerCurrentDaySales(request, response);
			} else if (managerAction.equals("totalsales")) {
				viewManagerTotalSales(request, response);
			} else if (managerAction.equals("managerhome")) {
				templateName = "managerhome.ftl";
				root.put("hello", "Welcome back to the Manager Home Page.");
				processor.runTemp(templateName, root, request, response);
			}
		}
	}

	private void viewManagerTotalSales(HttpServletRequest request, HttpServletResponse response) {
		DefaultObjectWrapperBuilder db = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
		SimpleHash root = new SimpleHash(db.build());
		String templateName = "managertotalsales.ftl";
		List<Transaction> allTransactions = UserLogic.getTotalSales();
		root.put("transactions", allTransactions);
		processor.runTemp(templateName, root, request, response);
	}

	private void viewManagerCurrentDaySales(HttpServletRequest request, HttpServletResponse response) {
		DefaultObjectWrapperBuilder db = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
		SimpleHash root = new SimpleHash(db.build());
		String templateName = "managersalesreport.ftl";
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date d1 = new Date();
		Date d2 = new Date();
		Calendar c = Calendar.getInstance(); 
		c.setTime(d2); 
		c.add(Calendar.DATE, 1);
		d2 = c.getTime();
		String today = dateFormat.format(d1);
		String tomorrow = dateFormat.format(d2);
		List<Transaction> transactions = UserLogic.getCurrentDaySales(today, tomorrow);
		root.put("transactions",  transactions);
		processor.runTemp(templateName, root, request, response);
	}

	private void viewManagerInventory(HttpServletRequest request, HttpServletResponse response) {
		DefaultObjectWrapperBuilder db = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
		SimpleHash root = new SimpleHash(db.build());
		String templateName = "managerinventoryreport.ftl";
		List<Book> allBooks = UserLogic.getBookQuantities();
		root.put("books", allBooks);
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
