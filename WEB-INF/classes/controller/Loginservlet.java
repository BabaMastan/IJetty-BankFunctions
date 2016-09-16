package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.CustomerInfo;
import dao.CustomerInfoDAO;
import dao.LoginDao;

/**
 * Servlet implementation class Loginservlet
 */
@WebServlet("/Loginservlet")
public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loginservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//response.getWriter().append("Served at: ").append(request.getContextPath());
		String username= request.getParameter("username");
		String password=request.getParameter("password");
		LoginDao login= new LoginDao();
		String role=login.getCredentialsrole(username, password);
		System.out.println(role);
		if(role.equals("manager"))
		{
			CustomerInfoDAO c= new CustomerInfoDAO();
			ArrayList<CustomerInfo> customers= new ArrayList<CustomerInfo>();
			customers=c.selectallcustomers();
			request.setAttribute("key", customers);
			RequestDispatcher rd= request.getRequestDispatcher("/views/manager.jsp");
			rd.forward(request, response);
		}
		else if(role.equals("customer"))
		{
			CustomerInfoDAO c= new CustomerInfoDAO();
			CustomerInfo ci=c.getInfo(username);
			request.setAttribute("xyz", ci);
			RequestDispatcher rd= request.getRequestDispatcher("/views/customer.jsp");
			rd.forward(request, response);
			
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
