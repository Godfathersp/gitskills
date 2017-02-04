package service;

import entity.Users;
import javax.servlet.*;

public interface UsersDAO {

	public boolean usersLogin(Users u);
}
