package bookstore.boundary;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookstore.object.User;
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
				//templateName = "adminaddbook.ftl";
				//processor.runTemp(templateName, root, request, response);
			}else if (action.equals("createpromo")) {
				templateName = "createpromo.ftl";
				processor.runTemp(templateName, root, request, response);
			}else if (action.equals("addemployee")) {
				templateName = "addemployee.ftl";
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
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
