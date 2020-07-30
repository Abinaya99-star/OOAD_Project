import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

// Extend HttpServlet class
public class addwish1 extends HttpServlet {
 
   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      response.setContentType("text/html");

      PrintWriter out = response.getWriter();
      String docType =
         "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
      String name="Mobiles";
      String model="Sony Xperia XA1";
      Double pric=14990.0;
      String title=" ";
      try
      {
         Class.forName("com.mysql.jdbc.Driver");
         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ooad", "root", "abinaya99");
         PreparedStatement pst = con.prepareStatement("insert into product values(?,?,?)");
         pst.setString(1,name);
         pst.setString(2,model);
         pst.setDouble(3,pric);
         int i = pst.executeUpdate();
         if(i!=0){
            title="Record has been inserted to wishlist";
         }
         else{
            title="failed to insert the data";
         }
out.println(title);
response.sendRedirect("wishlist.jsp");
      }
      catch(Exception e)
      {
         out.println(e);
      }
   }
}