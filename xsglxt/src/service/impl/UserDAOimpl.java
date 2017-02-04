package service.impl;
import service.UsersDAO;


import java.util.List;
import org.apache.catalina.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import db.MyHibernateSessionFactory;
import service.UsersDAO;
import entity.Users;
import javax.servlet.*;
public class UserDAOimpl implements UsersDAO{
	@Override
	public boolean usersLogin(Users u)
	{
       //事务对象
		Transaction tx = null;		
		String hql = "";
  try {
	   Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
       tx = session.beginTransaction();
	   hql =  "from Users where username=? AND password=? ";
      Query query = session.createQuery(hql);
      query.setParameter(0, u.getUsername());
    //  System.out.println(u.getUsername());
      query.setParameter(1, u.getPassword());
     // System.out.println(u.getPassword());
      List list = query.list();
      tx.commit();
      if(list.size()>0)
      {
    	  System.out.println("1");
    	  return true;
      }
      else
      {
    	  System.out.println("2");
    	  return false;  
      }
  } catch (Exception ex) {
	  
	  ex.printStackTrace();
	  return false;
  }
  finally
  {
	  if(tx!= null)
	  {
		  tx = null;
		  System.out.println("3");
	  }	  
  }
       
	}
}
