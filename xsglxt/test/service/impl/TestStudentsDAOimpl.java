package service.impl;

import org.junit.Assert;
import org.junit.Test;

import entity.Students;
import service.StudentsDAO;
import service.impl.StudentDAOimpl;

import java.util.Date;
import java.util.List;
public class TestStudentsDAOimpl {

   /*@Test
  public void testQueryAllStudents()
  {
	   StudentsDAO sdao = new StudentDAOimpl();
	   List<Students> list = sdao.queryAllStudents();
       for(int i= 0;i<list.size();i++)
       {
    	   System.out.println(list.get(i));
    	   
       }
  }
  */
   @Test
   public void testaddStudents()
   {
 	   Students s = new Students();
 	   s.setSname("张三丰啊");
       s.setAddress("大街上");
       s.setBirthday(new Date());
       s.setGender("人妖");
       StudentsDAO sdao = new StudentDAOimpl();
       Assert.assertEquals(true,sdao.addStudents(s));   
       
   }
   @Test
   public void testGetNewSid()
   {
	   StudentDAOimpl sdao = new StudentDAOimpl();
	   System.out.println(sdao.getNewSid());
   }
  
}
