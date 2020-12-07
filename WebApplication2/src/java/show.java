import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
import javax.servlet.annotation.WebServlet;

  @WebServlet(urlPatterns = {"/show"})
  
public class show extends HttpServlet {  
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
  
response.setContentType("text/html"); 

PrintWriter out = response.getWriter();  
          
String n=request.getParameter("title");  
String p=request.getParameter("lang");  
String e=request.getParameter("content");  
String drive = "com.mysql.jdbc.Driver";  
Connection conn=null;

          
	/*
	String drive = "com.mysql.jdbc.Driver";  
	String url = "jdbc:mysql://127.0.0.1:3306/world?characterEncoding=latin1";
//  Database credentials
	String user = "root";
	String pass = "sai";
	Connection conn=null;
	
	*/

String url="jdbc:mysql://bugoverflow.clhuzfls9udn.us-east-1.rds.amazonaws.com:3306/bugoverflow?autoReconnect=true&useSSL=false";
String user="root";
String pass="bugoverflow";
	
	try {
	  
	  Class.forName(drive);
		System.out.println("Connecting to DB....");
		conn=DriverManager.getConnection(url,user,pass);
		System.out.println("Connection successful.... \n"); 
		

  
PreparedStatement ps=conn.prepareStatement(  
"select * from post");  
//out.println("<body style='background-color:#d3d3d3;'>");
String cssTag="<link rel='stylesheet' type='text/css' href='style_1.css'>";
String cssTag2="<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css'>";
String csstag3="<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\r\n"
		+ "  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>";
out.println("<html>");
out.println("<head><title>Title Name</title>"+cssTag2);
out.println("<br>");
out.println(cssTag+csstag3);
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
                "  background-size: 1000% 1000%;\n" +
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
                "      <div class=\"cube\"></div>\n" );

//out.print("<div class='panel-heading'><b><h4>BUG OVERFLOW</b></h4></div>");
out.print("<table class='center' width=50% border=1 style='background-color:lightblue' >");
out.print("<h1  style='background-color:lightyellow' >Your content has been posted !</h1>");  

out.print("<button style='background-color: #4CAF50;color: white;margin:auto;display:block;'  onclick=\"window.location.href='home.jsp'\">Home</button>");  

out.print("<h1 style='background-color:lightyellow'>All Posts:</h1>");  

  
ResultSet rs=ps.executeQuery();  
/* Printing column names */  
ResultSetMetaData rsmd=rs.getMetaData();  
int total=rsmd.getColumnCount();  
out.print("<tr>");  
/*
for(int i=1;i<=total;i++)  
{  
out.print("<th>"+rsmd.getColumnName(i)+"</th>");  
}  
*/

out.print("<th>"+"Title"+"</th>");
out.print("<th>"+"Language"+"</th>");
out.print("<th>"+"Content"+"</th>");

out.print("</tr>");  
              
/* Printing result */  
  
while(rs.next())  
{  
out.print("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+
"</td><td>"+rs.getString(3)+"</td>");  
                  
}  
  
out.print("</table>");  
out.print("</body>");
              

/*  
ps.setString(1,n);  
ps.setString(2,p);  
ps.setString(3,e);  
//ps.setString(4,c);  
ps.executeUpdate("use bugoverflow;");
          
int i=ps.executeUpdate();  
if(i>0)  
out.print("You are successfully posted...");  */
      
          
}catch (Exception e2) {System.out.println(e2);}  
          
out.close();  
}  
  
}  