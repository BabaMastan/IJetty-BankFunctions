package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import beans.CustomerInfo;
import beans.LoginBean;


public class LoginDao {
	public String getCredentialsrole(String username,String password)
	{
		Session session = null;
		LoginBean loginbean= new LoginBean();
		try 
		{
			// This step will read hibernate.cfg.xml and prepare hibernate for
			// use
			SessionFactory sessionFactory = new Configuration().configure()
					.buildSessionFactory();
			session = sessionFactory.openSession();
			//Criteria Query Example
			
			Criteria crit = session.createCriteria(LoginBean.class);
			crit.add(Restrictions.like("username",username));
			crit.add(Restrictions.like("password", password));
			//crit.setMaxResults(20); //Restricts the max rows to 5
			
			//List<Employee> list=session.createCriteria(Employee.class).list();
			List<LoginBean> list=crit.list();
			for(int i=0;i<list.size();i++)
			{
			loginbean=list.get(i);
			}
			session.close();
		} catch (Exception e){
			System.out.println(e.getMessage());
		} finally {
		}	
		return loginbean.getRole();
	}
	public void addcustomer(LoginBean loginbean)
	{
		Session session = null;
		try 
		{
			Transaction transaction = null;
			// This step will read hibernate.cfg.xml and prepare hibernate for
			// use
			SessionFactory sessionFactory = new Configuration().configure()
					.buildSessionFactory();
			session = sessionFactory.openSession();
			//Criteria Query Example
			transaction = session.beginTransaction();
			session.save(loginbean);
			transaction.commit();
		} catch (Exception e){
			System.out.println(e.getMessage());
		} finally {
			session.flush();
			session.close();
			
		}
}
}
