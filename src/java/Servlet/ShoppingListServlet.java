package Servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 707114
 */
public class ShoppingListServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        ArrayList<String> items = (ArrayList<String>) session.getAttribute("items");
        String action = request.getParameter("action");
    
        if (session.getAttribute("user") != null)
        {
            if(action.equals("logout"))
            {
                session.removeAttribute("user");
                session.invalidate();
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
                return;
            }
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        }
        else
        {
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }          
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
 HttpSession session = request.getSession();
        String action = request.getParameter("action");
        String item = null;
        
        switch (action)
        {
            case "register":
                String username = request.getParameter("user");
                session.setAttribute("user", username);
                break;
            case "add":
                ArrayList<String> added = (ArrayList<String>) session.getAttribute("items");
                item = request.getParameter("item");
                if(added == null)
                {
                    added = new ArrayList<>();
                }
                added.add(item);
                session.setAttribute("items", added);
                break;
            case "delete":
                item = (String) request.getParameter("radio");
                ((ArrayList<String>) session.getAttribute("items")).remove(item);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
    }
    
}
