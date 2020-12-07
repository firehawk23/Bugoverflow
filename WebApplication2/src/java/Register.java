import java.io.*;  
import java.sql.*;  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;  
  
@WebServlet(urlPatterns = {"/Register"})

public class Register extends HttpServlet {  
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
"insert into post values(?,?,?)");  
  
ps.setString(1,n);  
ps.setString(2,p);  
ps.setString(3,e);  
//ps.setString(4,c);  
ps.executeUpdate("use bugoverflow;");
          
int i=ps.executeUpdate();  
if(i>0)  
out.print("You have posted successfully..."); 

response.setContentType("text/html");

PrintWriter out1 = response.getWriter();
//out1.println("Included HTML block:");
request.getRequestDispatcher("show").include(request, response); 
out1.close();


          
}catch (Exception e2) {System.out.println(e2);}  
          
out.close();  
}  
  
}  