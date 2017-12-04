package bookstore.boundary;

import java.io.IOException;

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
 * Servlet implementation class ShipperServlet
 */
@WebServlet("/ShipperServlet")
public class ShipperServlet extends HttpServlet {
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
    public ShipperServlet() {
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
		String shipperAction = request.getParameter("ShipperAction");
		if (shipperAction != null) {
			if (shipperAction.equals("updateorder")) {
				templateName = "updateorderstatus.ftl";
				processor.runTemp(templateName, root, request, response);
			}
		}
		if (request.getParameter("updateStatus") != null) {
			updateStatus(request, response);
		}
	}

	private void updateStatus(HttpServletRequest request, HttpServletResponse response) {
		DefaultObjectWrapperBuilder db = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
		SimpleHash root = new SimpleHash(db.build());
		String templateName = "shipperhome.ftl";
		int transactionID = Integer.parseInt(request.getParameter("transactionid"));
		String statusInput = request.getParameter("orderstatus");
		String status = "";
		if (statusInput.equals("notyet")) {
			status = "Not yet shipped";
		}else if (statusInput.equals("shipped")) {
			status = "Shipped";
		}else if (statusInput.equals("delivered")) {
			status = "Delivered";
			String subject = "Order Update";
			String content = "Your order has been delivered! ";
			int userID = UserLogic.getUserIDFromTransactionID(transactionID);
			String emailAddress = UserLogic.getEmailWithUserID(userID);
			try {
	            EmailUtility.sendEmail(host, port, user, pass, emailAddress, subject, content);
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
		}
		UserLogic.updateOrderStatus(transactionID, status);
		
		root.put("hello",  "Order Updated Successfully!");
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
