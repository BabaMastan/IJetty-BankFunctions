package controller;


import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.CustomerInfo;
import beans.LoginBean;
import dao.CustomerInfoDAO;
import dao.LoginDao;

/**
 * Servlet implementation class BankFunctionServlet
 */
@WebServlet("/BankFunctionServlet")
public class BankFunctionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BankFunctionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String value=request.getParameter("function");
		if (value.equals("addcustomer"))
		{
			try {
			String accno= request.getParameter("accno");
			String username= request.getParameter("username");
			String balance= request.getParameter("balance");
			String password= request.getParameter("password");
			String role=request.getParameter("role");
			String lastvisiteddate= request.getParameter("lastvisiteddate");
			LoginBean l=new LoginBean();
			CustomerInfo c= new CustomerInfo();
			l.setUsername(username);
			l.setPassword(password);
			l.setRole(role);
			LoginDao ld= new LoginDao();
			ld.addcustomer(l);
			CustomerInfoDAO cd= new CustomerInfoDAO();
			c.setAccno(Integer.parseInt(accno));
			c.setUsername(username);
			c.setBalance(balance);
			System.out.println(lastvisiteddate);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
			java.util.Date dat = sdf.parse(lastvisiteddate);
			java.sql.Date date= new java.sql.Date(dat.getTime());;
			c.setLastvisiteddate(date);
			System.out.println(c.getAccno()+" "+c.getLastvisiteddate());
			ArrayList<CustomerInfo> customers= new ArrayList<CustomerInfo>();
			customers=cd.addcustomer(c);
			request.setAttribute("key", customers);
			RequestDispatcher rd= request.getRequestDispatcher("/views/manager.jsp");
			rd.forward(request, response);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(value.equals("withdraw")|| value.equals("managerwithdraw"))
		{
			String accno= request.getParameter("accno");
			String amount= request.getParameter("amount");
			int acno=Integer.parseInt(accno);
			double amt= Double.parseDouble(amount);
			CustomerInfoDAO c= new CustomerInfoDAO();
			CustomerInfo ci=c.withdraw(acno, amt);
			if(value.equals("withdraw"))
			{
			c.getInfo(ci.getUsername());
			request.setAttribute("xyz", ci);
			RequestDispatcher rd= request.getRequestDispatcher("/views/customer.jsp");
			rd.forward(request, response);
			}
			else if(value.equals("managerwithdraw"))
			{
				ArrayList<CustomerInfo> customers= new ArrayList<CustomerInfo>();
				customers=c.selectallcustomers();
				request.setAttribute("key", customers);
				RequestDispatcher rd= request.getRequestDispatcher("/views/manager.jsp");
				rd.forward(request, response);
			}

		}
		else if(value.equals("deposit")|| value.equals("managerdeposit"))
		{
			String accno= request.getParameter("accno");
			String amount= request.getParameter("amount");
			int acno=Integer.parseInt(accno);
			double amt= Double.parseDouble(amount);
			CustomerInfoDAO c= new CustomerInfoDAO();
			CustomerInfo ci=c.deposit(acno, amt);
			if(value.equals("deposit"))
			{
			c.getInfo(ci.getUsername());
			request.setAttribute("xyz", ci);
			RequestDispatcher rd= request.getRequestDispatcher("/views/customer.jsp");
			rd.forward(request, response);
			}
			else if(value.equals("managerdeposit"))
			{
				ArrayList<CustomerInfo> customers= new ArrayList<CustomerInfo>();
				customers=c.selectallcustomers();
				request.setAttribute("key", customers);
				RequestDispatcher rd= request.getRequestDispatcher("/views/manager.jsp");
				rd.forward(request, response);
			}
			
		}
		else if(value.equals("transfer")|| value.equals("managertransfer"))
		{
			String accnoto= request.getParameter("accnoto");
			String accnofrom= request.getParameter("accnofrom");
			String amount= request.getParameter("amount");
			int acnoto=Integer.parseInt(accnoto);
			int acnofrom=Integer.parseInt(accnofrom);
			double amt= Double.parseDouble(amount);
			CustomerInfoDAO c= new CustomerInfoDAO();
			CustomerInfo ci=c.transferamount(acnofrom,acnoto, amt);
			if(value.equals("transfer"))
			{
			c.getInfo(ci.getUsername());
			request.setAttribute("xyz", ci);
			RequestDispatcher rd= request.getRequestDispatcher("/views/customer.jsp");
			rd.forward(request, response);
			}
			else if(value.equals("managertransfer"))
			{
				ArrayList<CustomerInfo> customers= new ArrayList<CustomerInfo>();
				customers=c.selectallcustomers();
				request.setAttribute("key", customers);
				RequestDispatcher rd= request.getRequestDispatcher("/views/manager.jsp");
				rd.forward(request, response);
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
