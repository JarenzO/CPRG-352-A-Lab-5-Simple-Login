
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // shows a welcome message (home.jsp) to the user including their username. 
        //The JSP home.jsp also knows a Logout hyperlink which makes a get request to take the user back to URL login and displays the 
        // message "You have successfully logged out."
        
        HttpSession session = request.getSession();
        
        if(session.getAttribute("user") != null) {
            
            getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);   
        } 
        else {
        
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
        
        return;
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
    }

}
