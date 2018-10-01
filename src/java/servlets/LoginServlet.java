/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import domain.User;
import domain.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 687159
 */
public class LoginServlet extends HttpServlet 
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        if(request.getParameter("logout") !=null)
        {
            Cookie c =new Cookie("username","");  
            c.setMaxAge(0);  
            response.addCookie(c);
            request.setAttribute("logM", "You have been successfully logged out.");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }        
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rem      = request.getParameter("rem");
        
        User user = new User(username, password);
        
        UserService us = new UserService();
        
        user = us.login(username, password);
        
        HttpSession session  = request.getSession();
        
        if(user != null)
        {
            Cookie c = new Cookie("username", username);
            response.addCookie(c);
            
            session.setAttribute("user", user);
            getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
            return;
        }
        else
        {
            request.setAttribute( "errorM", "Please enter the correct username and password");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }
    }
}
