package action;
import service.StudentsDAO;
import service.impl.StudentDAOimpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import entity.Students;
public class StudentsAction extends SuperAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	public String query()
	{
		StudentsDAO sdao = new StudentDAOimpl();
		
		List<Students> list =sdao.queryAllStudents();
		
		   session.setAttribute("students_list", list);
	
	  return "query_success";	
	}
    public String  delete()
    {
    	
    	StudentsDAO sdao= new StudentDAOimpl();
    	String sid = request.getParameter("sid");
    	sdao.deleteStudents(sid);
    	return "delete_success";
    	
    }

    public String modify()
	{
    	String sid = request.getParameter("sid");
		StudentsDAO sdao = new StudentDAOimpl();
		Students s = sdao.queryStudentsbySid(sid);
		//在会话SESSION中保存
		session.setAttribute("modify_students", s);
		return "modify_success";
	}
    public String add () throws Exception
	{
    	Students s = new Students();
    	s.setSname(request.getParameter("sname"));
    	s.setGender(request.getParameter("gender"));
    	s.setAddress(request.getParameter("address"));
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	s.setBirthday(sdf.parse(request.getParameter("birthday")));
	   StudentsDAO sdao = new StudentDAOimpl();
	   sdao.addStudents(s);
	   return "add_success";
	}
    public String save() throws Exception
	{
    	Students s = new Students();
    	s.setSid(request.getParameter("sid"));
    	s.setSname(request.getParameter("sname"));
    	s.setGender(request.getParameter("gender"));
    	s.setAddress(request.getParameter("address"));
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	s.setBirthday(sdf.parse(request.getParameter("birthday")));
	   StudentsDAO sdao = new StudentDAOimpl();
	   sdao.updateStudents(s);
	   return "save_success";
	}
}
