import java.sql.*;

public class LoginDao {
public static boolean validate(String name,String pass){
boolean status=false;
try{
Class.forName("com.mysql.jdbc.Driver");
 String DB_URL = "jdbc:mysql://bugoverflow.clhuzfls9udn.us-east-1.rds.amazonaws.com:3306/bugoverflow?autoReconnect=true&useSSL=false";

	   //  Database credentials
	    String USER = "root";
	    String PASS = "bugoverflow";
Connection con=DriverManager.getConnection(DB_URL, USER, PASS);

PreparedStatement ps=con.prepareStatement(
"select * from login where username=? and password=?");
ps.setString(1,name);
ps.setString(2,pass);

ResultSet rs=ps.executeQuery();
status=rs.next();

}catch(Exception e){System.out.println(e);}
return status;
}
}