

import java.io.PrintWriter;
import java.lang.*;

import java.sql.*;
import java.sql.DriverManager;

import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet(urlPatterns = {"/ContactServlet"})
public class ContactServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>CONTACT US</title>");
        out.println("</head>");
        out.println("<style type=\"text/css\">\n" +
                "body {\n" +
                "  font-family: 'Josefin Sans', sans-serif;\n" +
                "  box-sizing: border-box;\n" +
                "}\n" +
                ".container-fluid{\n" +
                "  height: 100%;\n" +
                "  margin: 0;\n" +
                "  padding: 0;\n" +
                "  width: 100%;\n" +
                "  background: #FFF;\n" +
                "}\n" +
                ".background {\n" +
                "  background: linear-gradient(132deg,#FA8072, #FC415A, #591BC5, #212335);\n" +
                "  background-size: 400% 400%;\n" +
                "  animation: Gradient 15s ease infinite;\n" +
                "  position: relative;\n" +
                "  height: 100vh;\n" +
                "  width: 100%;\n" +
                "  overflow: hidden;\n" +
                "  padding:0;\n" +
                "  margin:0px;\n" +
                "}\n" +
                ".cube {\n" +
                "  position: absolute;\n" +
                "  top: 80vh;\n" +
                "  left: 45vw;\n" +
                "  width: 10px;\n" +
                "  height: 10px;\n" +
                "  border: solid 1px #D7D4E4;\n" +
                "  transform-origin: top left;\n" +
                "  transform: scale(0) rotate(0deg) translate(-50%, -50%);\n" +
                "  animation: cube 12s ease-in forwards infinite;\n" +
                "}\n" +
                ".cube:nth-child(2n) {\n" +
                "  border-color: #FFF ;\n" +
                "}\n" +
                ".cube:nth-child(2) {\n" +
                "  animation-delay: 2s;\n" +
                "  left: 25vw;\n" +
                "  top: 40vh;\n" +
                "}\n" +
                ".cube:nth-child(3) {\n" +
                "  animation-delay: 4s;\n" +
                "  left: 75vw;\n" +
                "  top: 50vh;\n" +
                "}\n" +
                ".cube:nth-child(4) {\n" +
                "  animation-delay: 6s;\n" +
                "  left: 90vw;\n" +
                "  top: 10vh;\n" +
                "}\n" +
                ".cube:nth-child(5) {\n" +
                "  animation-delay: 8s;\n" +
                "  left: 10vw;\n" +
                "  top: 85vh;\n" +
                "}\n" +
                ".cube:nth-child(6) {\n" +
                "  animation-delay: 10s;\n" +
                "  left: 50vw;\n" +
                "  top: 10vh;\n" +
                "}\n" +
                "/* ================= Header ============ */\n" +
                "header{\n" +
                "  position: absolute;\n" +
                "  top:0%;\n" +
                "  left: 0%;\n" +
                "  width:100%;\n" +
                "  margin: 0;\n" +
                "  padding: 0;\n" +
                "}\n" +
                "/* navbar */\n" +
                "\n" +
                "/* Logo */\n" +
                ".logo{\n" +
                "  width: 40px;\n" +
                "  height: 40px;\n" +
                "  background: #EFEEF5;\n" +
                "  margin: 40px 63px;\n" +
                "  float: left;\n" +
                "  transform: rotate(-30deg);\n" +
                "}\n" +
                ".logo span{\n" +
                "  color: #591BC5;\n" +
                "  font-size: 2em;\n" +
                "  line-height: 1.4;\n" +
                "  padding-left: 5px;\n" +
                "  font-weight: bold;\n" +
                "}\n" +
                "/* Header content & title & button*/\n" +
                ".header-content{\n" +
                "  margin-top:8%;\n" +
                "  text-align: center;\n" +
                "  color:  #EFEEF5;\n" +
                "}\n" +
                ".header-content h1{\n" +
                "  text-transform: uppercase;\n" +
                "  font-size: 3em;\n" +
                "  letter-spacing: 1px;\n" +
                "}\n" +
                ".header-content p {\n" +
                "  font-size: 20px;\n" +
                "  line-height: 1.5;\n" +
                "  margin: 20px auto;\n" +
                "}\n" +
                ".header-content button{\n" +
                "  width: 140px;\n" +
                "  margin:20px 10px;\n" +
                "  color: #591BC5;\n" +
                "  font-size: 17px;\n" +
                "  border:1px solid #EFEEF5;\n" +
                "  font-weight: 500;\n" +
                "  background: #EFEEF5;\n" +
                "  border-radius: 20px;\n" +
                "  padding: 10px;\n" +
                "  cursor:pointer;\n" +
                "  transition: .3s;\n" +
                "}\n" +
                ".header-content button:hover{\n" +
                "  border-radius: 0;\n" +
                "}\n" +
                "/* Animate Background*/\n" +
                "@keyframes Gradient {\n" +
                "  0% {\n" +
                "    background-position: 0% 50%;\n" +
                "  }\n" +
                "  50% {\n" +
                "    background-position: 100% 50%;\n" +
                "  }\n" +
                "  100% {\n" +
                "    background-position: 0% 50%;\n" +
                "  }\n" +
                "}\n" +
                "@keyframes cube {\n" +
                "  from {\n" +
                "    transform: scale(0) rotate(0deg) translate(-50%, -50%);\n" +
                "    opacity: 1;\n" +
                "  }\n" +
                "  to {\n" +
                "    transform: scale(20) rotate(960deg) translate(-50%, -50%);\n" +
                "    opacity: 0;\n" +
                "  }\n" +
                "}\n" +
                "\n" +
                "</style>\n" +
                "<body>\n" +
                "<link href=\"https://fonts.googleapis.com/css?family=Josefin+Sans\" rel=\"stylesheet\">\n" +
                "\n" +
                "  <div class=\"container-fluid\">\n" +
                "    <div class=\"background\">\n" +
                "       <div class=\"cube\"></div>\n" +
                "       <div class=\"cube\"></div>\n" +
                "       <div class=\"cube\"></div>\n" +
                "       <div class=\"cube\"></div>\n" +
                "      <div class=\"cube\"></div>\n" +
                "    </div>\n" +
                "   <header>\n" +
                "      <div class=\"logo\"><span><img src=\"logo.png\" width=\"35px\" height=\"40px\"></span></div>\n" +
                "      <section class=\"header-content\">");
        out.println("<center><h1>" + "ACKNOWLEDGEMENT" + "</h1></center>");


        out.println("");

        String name=request.getParameter("Name");
        String email=request.getParameter("EMail");
        String mobile=request.getParameter("Mobile");
        String subject=request.getParameter("Subject");
        String other="";
        String comment=request.getParameter("Comment");
        LocalDate myObj = LocalDate.now();


        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String token = salt.toString();

        out.println("Token: "+token+"<br>"+ "<br>");
        out.println("Name: "+name+ "<br>"+ "<br>");
        out.println("Email: "+email+ "<br>"+ "<br>");
        out.println("Mobile: "+mobile+ "<br>"+ "<br>");
        out.println("Subject: "+subject+ "<br>"+ "<br>");
        if(subject.equals("Other")){
            other=request.getParameter("car");
            out.println("Other: "+other+ "<br>"+ "<br>");
        }
        out.println("Comment: "+comment+ "<br>"+ "<br>");


        String drive="com.mysql.jdbc.Driver";
        String url="jdbc:mysql://bugoverflow.clhuzfls9udn.us-east-1.rds.amazonaws.com:3306/bugoverflow?autoReconnect=true&useSSL=false";
        String user="root";
        String pass="bugoverflow";

        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        String sql="";
        String db="";



        try {
            Class.forName(drive);

            conn=DriverManager.getConnection(url,user,pass);

            stmt=conn.createStatement();

            db="use bugoverflow;";

            stmt.executeUpdate(db);

            sql="insert into contactus values(" + "'" + token + "'" + "," + "'" + name + "'" + "," + "'" + email + "'" + "," + "'" + mobile + "'" + "," + "'" + subject + "'" + "," + "'" + other + "'" + "," + "'" + comment + "'" + "," + "'" + myObj + "'" +")";
            stmt.executeUpdate(sql);


            conn.close();




        } catch (Exception e) {
            out.println(e);
        }
        out.println("</section>\n" +
                "  </header>\n" +
                "</div>\n" +
                "</body>");
        out.println("</html>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}