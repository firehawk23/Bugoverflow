import java.io.*;  
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;  
import java.sql.*;
  

@WebServlet("/newstd")


public class newstudent extends HttpServlet
{    
public void doPost(HttpServletRequest req, HttpServletResponse res)  
{
       try
		{  
       	PrintWriter out = res.getWriter();           
           
       	String firstname=req.getParameter("fname");
       	String un=req.getParameter("uname");
       	String pas=req.getParameter("pass");
       	String ob=req.getParameter("obj");
		String lastname=req.getParameter("lname");
		String fathername=req.getParameter("fathername");
		String se=req.getParameter("sex");
		String add=req.getParameter("Address");
		String em=req.getParameter("emailid");
		String db=req.getParameter("dob");
		Long  phoneno=Long.parseLong(req.getParameter("mobileno"));
       	//out.print("insert into register values ('"+fn+"','"+ln+"','"+reg+"','"+usern+"','"+passw+"','"+passw+"','"+dob+"','"+phno+"','"+lia+"')");
       	Class.forName("com.mysql.jdbc.Driver");

           Connection con=DriverManager.getConnection("jdbc:mysql://bugoverflow.clhuzfls9udn.us-east-1.rds.amazonaws.com:3306/bugoverflow?autoReconnect=true&useSSL=false","root","bugoverflow");

           Statement stmt=con.createStatement();
           stmt.executeUpdate("use bugoverflow;");
           String sql1 = "insert into user values ('"+firstname+"','"+un+"','"+pas+"','"+ob+"','"+lastname+"','"+fathername+"','"+se+"','"+add+"','"+em+"','"+db+"','"+phoneno+"')";
           
           stmt.executeUpdate(sql1);
           String sql2= "insert into login values ('"+un+"','"+pas+"')";
           
           stmt.executeUpdate(sql2);
           
           String sql3= "insert into profile values ('"+un+"','"+pas+"','"+em+"','"+phoneno+"')";
           
           stmt.executeUpdate(sql3);
           
         System.out.println("inserted");
         res.sendRedirect(req.getContextPath() + "/login.html");
           con.close();

       
       }
		catch(Exception e)
		{
			System.out.println(e);
		}  
}   
 
}

