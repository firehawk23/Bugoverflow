import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/servlet1"})

public class FirstServlet extends HttpServlet {
public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    String n=request.getParameter("username");
    String p=request.getParameter("psw");

    if(LoginDao.validate(n, p)){
        
        if(n.equals("admin")){
          
            RequestDispatcher rd=request.getRequestDispatcher("admin");
                    rd.forward(request,response);

        }
        
        else{
             
        RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
        rd.forward(request,response);
        }
        
    }
    else{
        out.print("Sorry username or password error");
        RequestDispatcher rd=request.getRequestDispatcher("login.html");
        rd.include(request,response);
    }

    out.close();
    }
}