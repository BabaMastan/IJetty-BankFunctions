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



public class CustomerInfoDAO {
	public ArrayList<CustomerInfo> addcustomer(CustomerInfo customerinfo)
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
			session.save(customerinfo);
			transaction.commit();
		} catch (Exception e){
			System.out.println(e.getMessage());
		} finally {
			session.flush();
			session.close();
			
		}	
		
		return selectallcustomers();
	}
		
		public ArrayList<CustomerInfo> selectallcustomers()
		{
			Session session = null;
			CustomerInfo Customerinfo= new CustomerInfo();
			ArrayList<CustomerInfo> customers= new ArrayList<CustomerInfo>();
			try 
			{
				// This step will read hibernate.cfg.xml and prepare hibernate for
				// use
				SessionFactory sessionFactory = new Configuration().configure()
						.buildSessionFactory();
				session = sessionFactory.openSession();
				//Criteria Query Example
				
				Criteria crit = session.createCriteria(CustomerInfo.class);
				crit.setMaxResults(100); //Restricts the max rows to 5
				
				//List<Employee> list=session.createCriteria(Employee.class).list();
				List<CustomerInfo> list=crit.list();
				for(int i=0;i<list.size();i++)
				{
				Customerinfo=list.get(i);
				customers.add(Customerinfo);
				}
				session.close();
			} catch (Exception e){
				System.out.println(e.getMessage());
			} finally {
			}	
			return customers;
		}
	public CustomerInfo getInfo(String username)
	{
		Session session = null;
		CustomerInfo Customerinfo= new CustomerInfo();
		try 
		{
			// This step will read hibernate.cfg.xml and prepare hibernate for
			// use
			SessionFactory sessionFactory = new Configuration().configure()
					.buildSessionFactory();
			session = sessionFactory.openSession();
			//Criteria Query Example
			
			Criteria crit = session.createCriteria(CustomerInfo.class);
			crit.add(Restrictions.like("username",username));
			crit.setMaxResults(20); //Restricts the max rows to 5
			
			//List<Employee> list=session.createCriteria(Employee.class).list();
			List<CustomerInfo> list=crit.list();
			for(int i=0;i<list.size();i++)
			{
			Customerinfo=list.get(i);
			System.out.println(Customerinfo.getUsername()+" "+Customerinfo.getBalance());
			}
			session.close();
		} catch (Exception e){
			System.out.println(e.getMessage());
		} finally {
		}	
		return Customerinfo;
	}
	public double getBalance(int accno)
	{
		Session session = null;
		CustomerInfo b=new CustomerInfo();
		try 
		{
			// This step will read hibernate.cfg.xml and prepare hibernate for
			// use
			SessionFactory sessionFactory = new Configuration().configure()
					.buildSessionFactory();
			session = sessionFactory.openSession();
			//Criteria Query Example
			Criteria crit = session.createCriteria(CustomerInfo.class);
			crit.add(Restrictions.like("accno", accno));
			crit.setMaxResults(20); //Restricts the max rows to 5
			
			//List<Employee> list=session.createCriteria(Employee.class).list();
			List<CustomerInfo> list=crit.list();
			for(int i=0;i<list.size();i++)
			{
				 b=list.get(i);	
			}
			session.close();
		} catch (Exception e){
			System.out.println(e.getMessage());
		} finally {
		}	
		double bal= Double.parseDouble(b.getBalance());
		return bal;
	}
	public CustomerInfo deposit(int accno, double depositamount)
	{
		
		if(depositamount < 0)
		{
			CustomerInfo empty=new CustomerInfo();
			return empty;
		}
		
		return depositwithdraw(accno, depositamount);
	}
	
	public CustomerInfo withdraw(int accno, double withdrawamount)
		{
			if(withdrawamount < 0)
			{
				CustomerInfo empty=new CustomerInfo();
				return empty;
			}
		return depositwithdraw(accno, -1*withdrawamount);
		}
	
		private CustomerInfo depositwithdraw(int accno, double depositamount)
		{
			Session session = null;
			Transaction transaction= null; 
			CustomerInfo b=new CustomerInfo();
			
			try 
			{
				// This step will read hibernate.cfg.xml and prepare hibernate for
				// use
				SessionFactory sessionFactory = new Configuration().configure()
						.buildSessionFactory();
				session = sessionFactory.openSession();
				//Criteria Query Example
				Criteria crit = session.createCriteria(CustomerInfo.class);
				crit.add(Restrictions.like("accno", accno));
				//crit.setMaxResults(20); //Restricts the max rows to 5
				//List<Employee> list=session.createCriteria(Employee.class).list();
				List<CustomerInfo> list=crit.list();
				transaction=session.beginTransaction();
				for(int i=0;i<list.size();i++)
				{
					
					
					b=list.get(i);
					double bal=Double.parseDouble(b.getBalance());
					double newbal=bal+depositamount;
					b.setBalance(newbal+"");
					session.update(b);		
				}
				transaction.commit();
				session.flush();
				session.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
			}
			CustomerInfo newc= new CustomerInfo();
			 newc=getInfo(b.getUsername());
			return newc;
		}
		
		public CustomerInfo transferamount(int fromaccno1,int toaccno2,double transferamount)
		{
			Session session = null;
			Transaction transaction= null; 
			CustomerInfo bi=new CustomerInfo();
			try 
			{
				// This step will read hibernate.cfg.xml and prepare hibernate for
				// use
				SessionFactory sessionFactory = new Configuration().configure()
						.buildSessionFactory();
				session = sessionFactory.openSession();
				//Criteria Query Example
				Criteria crit = session.createCriteria(CustomerInfo.class);
				crit.add(Restrictions.like("accno", fromaccno1));
				//crit.setMaxResults(20); //Restricts the max rows to 5
				
				//List<Employee> list=session.createCriteria(Employee.class).list();
				List<CustomerInfo> list=crit.list();
				transaction=session.beginTransaction();
				for(int i=0;i<list.size();i++)
				{
					
					CustomerInfo b=new CustomerInfo();
					b=list.get(i);
					double bal=Double.parseDouble(b.getBalance());
					double newbal=bal-transferamount;
					b.setBalance(newbal+"");
					session.update(b);	
				
			
					
				}
				Criteria crit1 = session.createCriteria(CustomerInfo.class);
				crit1.add(Restrictions.like("accno", toaccno2));
				List<CustomerInfo> list1=crit1.list();
				transaction=session.beginTransaction();
				for(int i=0;i<list.size();i++)
				{
					
					
					bi=list.get(i);
					double bal=Double.parseDouble(bi.getBalance());
					double newbal=bal+transferamount;
					System.out.println(newbal);
					bi.setBalance(newbal+"");
					System.out.println(bi.getBalance());
					session.update(bi);
					
				}
				transaction.commit();
				
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				session.flush();
			session.close();
			}	
			CustomerInfo newc= new CustomerInfo();
			 newc=getInfo(bi.getUsername());
			return newc;
		}
		
}
