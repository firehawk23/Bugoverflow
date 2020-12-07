import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DelDao {
	  static final String drive="com.mysql.jdbc.Driver";
	  static final String url="jdbc:mysql://bugoverflow.clhuzfls9udn.us-east-1.rds.amazonaws.com:3306/bugoverflow?autoReconnect=true&useSSL=false";
	  static final String user="root";
	  static final String pass="bugoverflow";
	public static boolean validate(String name){
boolean status=false;
try{
Class.forName(drive);
Connection con=DriverManager.getConnection(url,user,pass);

PreparedStatement ps=con.prepareStatement("DELETE from login where username=?");
ps.setString(1,name);
status=ps.execute();


}catch(Exception e){System.out.println(e);}
return status;
}
}