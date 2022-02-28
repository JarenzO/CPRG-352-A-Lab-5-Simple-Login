
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import services.AccountService;


public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // displays a login form (login.jsp) to the user than can also show messages
        
        // is also responsible for logging out the user. If the parameter "logout" exists, invalidate the session and display a message that the user has successfully logged out.
        
        if(request.getParameter("logout") == "") {
            
            HttpSession session = request.getSession();
            session.invalidate();
            
            request.setAttribute("loggedOut", "");
            request.setAttribute("message", "You have successfully logged out.");
        }
        
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {
            
            getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);  
        } 
        else {
        
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
        
         return;
    } // end of doGet


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // processes the submission of the form from login.jsp. doPost() first validates that user name and password are not empty. 
        // Then, it passes the user name and password parameters to the login() method of a service class called AccountService. If login() returns a non-null value, store the username in a session variable and 'redirect' (not forward)
        // the user to the home url. If the authentication parameters are invalid, display an appropriate error message, keeping the textboxes filled in with what the user had previously entered and forward the user to login.jsp.
        // The URL for LoginServlet is /login
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        HttpSession session = request.getSession();
        
        session.setAttribute("username", username);
        session.setAttribute("password", password);
        
        
        //Check for empty fields
        if (username == null || username.equals("") || 
                password == null || password.equals("") ) {
        
            session.setAttribute("invalid", "");
            session.setAttribute("message", "Missing login entry(s).");
            
            response.sendRedirect("login");
            return;
        } 
        
        
        //Check user login attempt
        User validateUser = new AccountService().login(username, password);
        
        if (validateUser == null) {
            
            session.setAttribute("invalid", "");
            session.setAttribute("message", "Incorrect login details.");
            
            response.sendRedirect("login");
            return;
        } 
        else {
        
            session.removeAttribute("username");
            session.removeAttribute("password");
            
            session.setAttribute("user", validateUser.getUsername());
            response.sendRedirect("home");
            return;
        }
    } // end of doPost
}
