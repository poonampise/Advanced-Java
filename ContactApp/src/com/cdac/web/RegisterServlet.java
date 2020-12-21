package com.cdac.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdac.dao.RegisterDao;
import com.cdac.model.Register;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private RegisterDao registerDao;

    public void init() {
        registerDao = new RegisterDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String contact = request.getParameter("contact");

        Register register = new Register();
        register.setFirstName(firstName);
        register.setLastName(lastName);
        register.setUsername(username);
        register.setPassword(password);
        register.setContact(contact);
        register.setAddress(address);

        try {
            registerDao.registerRegister(register);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        response.sendRedirect("login.jsp");
    }
}






