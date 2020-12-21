package com.cdac.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdac.dao.LoginDao;
import com.cdac.dao.RegisterDao;
import com.cdac.model.LoginBean;
import com.cdac.model.Register;

@WebServlet("/login123")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private LoginDao loginDao;

    public void init() {
        loginDao = new LoginDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

   
        String username = request.getParameter("username");
        String password = request.getParameter("password");
       

        LoginBean login = new LoginBean();
    
        login.setUsername(username);
        login.setPassword(password);
      
        try {
            boolean result= loginDao.validate(login);
            if(result) {
            	response.sendRedirect("user-form.jsp");
            }
            else {
            	 response.sendRedirect("login.jsp");
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
     
       
    }
}






