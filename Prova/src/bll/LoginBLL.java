package bll;

import dao.LoginDAO;
import entity.Login;

public class  LoginBLL {

        public Object Login(Login objeto) {
		LoginDAO loginDAO = new LoginDAO();
		return  loginDAO.login(objeto);
	}

}