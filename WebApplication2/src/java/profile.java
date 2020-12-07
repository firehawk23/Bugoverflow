

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.* ;


@WebServlet(urlPatterns = {"/profile"})
public class profile extends HttpServlet {
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://bugoverflow.clhuzfls9udn.us-east-1.rds.amazonaws.com:3306/bugoverflow?autoReconnect=true&useSSL=false";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "bugoverflow";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Connection conn = null;
		   Statement stmt = null;
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            String username = request.getParameter("uname");
	String password = request.getParameter("pw");
        String newpass = request.getParameter("npw");
	String email = request.getParameter("eid");
       String phone = request.getParameter("mno");
              		 
            Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      out.println("Connecting to database...");
              

       conn = DriverManager.getConnection(DB_URL, USER, PASS);
       

       stmt = conn.createStatement();
       PreparedStatement ps=conn.prepareStatement("select * from profile where username=?");
       ps.setString(1,username);
       ResultSet rs = ps.executeQuery();
        rs.next();
	String pw=rs.getString("password");
        String sql=null;
        if(password.equals(pw)){
            
            if(newpass.equals(""))
            {
		      sql = "UPDATE profile SET email = '"+email+"', phone= '"+phone+"' WHERE username = '"+username+"';";
                      stmt.executeUpdate(sql); 
	
            }
            else{
                 sql = "UPDATE profile SET password = '"+newpass+"',email = '"+email+"', phone= '"+phone+"' WHERE username = '"+username+"';";
                 stmt.executeUpdate(sql); 
                 sql = "UPDATE login SET password = '"+newpass+"' WHERE username = '"+username+"';";
                 stmt.executeUpdate(sql);
            }
		      
            }
                      response.sendRedirect(request.getContextPath() + "/home.jsp");
                      

        }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
