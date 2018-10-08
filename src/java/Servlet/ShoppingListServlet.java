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

        forEver(request,response);
          
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        forEver(request,response);

    }
    private void forEver (HttpServletRequest request, HttpServletResponse response)
            throws SecurityException, IOException, ServletException{
        
            HttpSession session = request.getSession(false);
  
            String action = request.getParameter("action");
               if (action == null){
                   action = "";
                   
               }
//        ArrayList<list>  al = new ArrayList<list>;
        String username = (String) session.getAttribute("username");
            if(action.equals("register") ){
                session = request.getSession();
                username = request.getParameter("user");
                session.setAttribute("user", username);

            }
            if (username == null){
             getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);    
             return;
            }        
            if (action.equals("logout")){
                session.invalidate();
                request.setAttribute("f", "Successfully logout");
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
                return;
            }
            
            
            ArrayList<String> list;
            list = (ArrayList<String>)session.getAttribute("list");
            
            if(list == null)
                list = new ArrayList();
            
            if (action.equals("Add"))
                list.add(request.getParameter("add"));
            
            if (action.equals("delete")) {
                try{
                    int index = Integer.parseInt(request.getParameter("index"));
                    list.remove(index);
               
                }
                catch(Exception e) {
                }
            }
        session.setAttribute("listitem", list);
        getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        
    }
    
}
