package service.impl;

import java.nio.channels.ScatteringByteChannel;
import java.util.List;

import org.apache.struts2.components.Else;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.hql.internal.ast.tree.SelectExpression;

import db.MyHibernateSessionFactory;
import entity.Students;
import service.StudentsDAO;

public class StudentDAOimpl implements StudentsDAO {
	public  StudentDAOimpl() {
		// TODO Auto-generated constructor stub
	}
@Override
 public List<Students> queryAllStudents()
 {
	 Transaction  tx = null;
	 List<Students> list = null;
	 String hql = "";
	 try 
	 {
		 Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
		 tx = session.beginTransaction();
		 hql = "from Students";
		 Query query = session.createQuery(hql);
		 list = query.list();
		 tx.commit();
		 //session.close();
		 return list;
		 
	 }
	 catch(Exception ex)
	 {
		 ex.printStackTrace();
		 tx.commit();
		 return list;
		
	 }
	 finally 
	 {
		 if(tx!= null )
		 {
			 tx = null;
			 System.out.println(" ¬ŒÒ÷√ø’");
		   }
		 
	 }
	 
 }
 public Students queryStudentsbySid(String sid )
 {
	 Transaction  tx = null;
	 Students s = null;
	 try 
	 {
		 Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
		 tx = session.beginTransaction();
		 s = (Students)session.get(Students.class,sid);
		 tx.commit();	 
		 return s;
	 }
	 catch(Exception ex)
	 {
		 ex.printStackTrace();
		 tx.commit();
		 return s;
	 }
	 finally 
	 {
		 if(tx!= null )
		 {
			 tx = null;
		 }
	 }
 }
 public  boolean updateStudents(Students s)
 {
	 Transaction tx = null;
	 //Students s2 = null;
	 try {
		 Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
		 tx = session.beginTransaction();
		 session.update(s);
		 tx.commit();
		 return true;
	} catch (Exception ex) {
		// TODO: handle exception
		ex.printStackTrace();
		tx.commit();
	    return false;
	}
	 finally
	 {
		 if(tx!=null)
		 {
			 tx = null;
		 }
		 
	 }	 
 }
 public  boolean addStudents(Students s)
 {
	 s.setSid(getNewSid());
	 Transaction tx = null;
	 try {
		 Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
		 tx = session.beginTransaction();
		 session.save(s);
		 tx.commit();
		 return true;
	} catch (Exception ex) {
		// TODO: handle exception
		ex.printStackTrace();
		return false;
	}
	finally
	{
		if(tx !=null ) tx=null;
		
		
	}
 }
 public  boolean deleteStudents(String sid)
 {
	 Transaction tx2 =null;
	 
   try {
	   Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
	   tx2 = session.beginTransaction();
	   Students s = (Students)session.get(Students.class,sid);
	   session.delete(s);
	   tx2.commit();
	   //session.close();
	   return true;
	
    }
   catch (Exception ex) {
	// TODO: handle exception
	ex.printStackTrace();
	//tx.commit();
	
	return false;
	
	   
  }
   finally
   {
	   if(tx2!=null)
		   tx2 = null; 
	   System.out.println("4");
   }
	
 }
 public String getNewSid()
{
	Transaction tx = null;
	String hql = "";
	String sid = null;
	try {
		Session session = MyHibernateSessionFactory.getSessionFactory().getCurrentSession();
		tx = session.beginTransaction();
		hql = "select max(sid) from Students";
		Query query = session.createQuery(hql);
		sid = (String)query.uniqueResult();
		if(sid == null || "".equals(sid))
		{
		    sid = "S0000001";	
		}
		else
		{
			String temp = sid.substring(1);
			System.out.println(temp);
			int i =Integer.parseInt(temp);
			i++;
			temp = String.valueOf(i);
			int len = temp.length();
			for(int j =0;j<7-len;j++)
			{
				temp = "0"+temp;		
			}
			sid ="S"+temp;
			
		}
		tx.commit();
		return sid;
	} catch (Exception ex) {
		// TODO: handle exception
	    ex.printStackTrace();
	    tx.commit();
	    return sid;
	}
	finally{
		if(tx!= null) tx = null;
		
	}
}
}