import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/servlet2"})

public class SecondServlet extends HttpServlet {
public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String n =request.getParameter("username");
    String p =request.getParameter("psw");
    HttpSession session = request.getSession(true);
    if(LoginDao.validate(n,p)){
//      session.setAttribute("userName",n);
        DelDao.validate(n);
        RequestDispatcher rd=request.getRequestDispatcher("deleted.html");
        rd.forward(request,response);
    }
    else{
        out.print("Sorry username or password is wrong");
//        session.setAttribute("errorMessage","Invalid Credentials");
//        response.sendRedirect("ErrorPage.jsp");
        RequestDispatcher rd=request.getRequestDispatcher("delete-profile.html");
        rd.include(request,response);
    }

    out.close();
    }
}