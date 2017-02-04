package action;
import service.UsersDAO;
import service.impl.UserDAOimpl;

import org.apache.struts2.interceptor.validation.SkipValidation;
import org.hibernate.Session;
import org.hibernate.engine.jdbc.spi.ResultSetReturn;
import org.omg.CORBA.PUBLIC_MEMBER;

import com.opensymphony.xwork2.ModelDriven;
import com.sun.org.apache.bcel.internal.classfile.Attribute;

import entity.Users;

public class UsersAction extends SuperAction implements ModelDriven<Users>   {

	private static final long serialVersionUID = 1L;
    private Users user = new Users();
    
    
    public String login()
    {
    	//System.out.println(user.getPassword());
    	
    	UsersDAO uDao = new UserDAOimpl();
    	
    	if(uDao.usersLogin(user)){
    		session.setAttribute("loginUserName", user.getUsername());
    		return "login_success";
    	}
    	else
    	{
    		System.out.println("s");
    	    return "login_failure";	
    	}
    }
    
    @Override
    public void validate()
    {
     	if("".equals(user.getUsername().trim()))
     	{
     		this.addFieldError("usernameError","用户名不能为空");
     	}
     	if(user.getPassword().length()<6)
     	{
     		this.addFieldError("passwordError","密码长度不能小于6");
     	}
     		
     		
    }
    
    @SkipValidation
    public String logout()
    {
    	
    	if(session.getAttribute("loginUsername")!=null)
      {
    		
    		
    		session.removeAttribute("loginUsername");
    		
      }

      
    return "logout_success";
    	
    }
    
  
    
    
	public Users getModel()
	{
		return this.user;
	}
	
	
	
}
