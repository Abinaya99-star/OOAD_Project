import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  
import java.sql.*;  
import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 
public class login7 extends HttpServlet  
{    
     public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
      {  
          PrintWriter out = res.getWriter();  
          res.setContentType("text/html"); 
          String email=req.getParameter("mail");
          String password=req.getParameter("password"); 
          out.println("<html><body>");  
          try 
          {  
             Class.forName("com.mysql.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ooad", "root", "abinaya99");  
             Statement stmt = con.createStatement();  
             ResultSet rs = stmt.executeQuery("select * from trade");  
             //out.println("<table border=1 width=50% height=50  
             //out.println("<tr><th>Email</th><th>password</th><tr>");  
             while (rs.next()) 
             {  
                 String n = rs.getString("email");  
                 String nm = rs.getString("password");  
                // int s = rs.getInt("sal");   
                 if(n.equals(email) && nm.equals(password))
                 {
                  //out.println("Success");
                  res.sendRedirect("loghome.jsp");
                 }
              else
              {
                JOptionPane.showMessageDialog(null, "Invalid Username or password",  
                                   "ERROR", JOptionPane.ERROR_MESSAGE); 
                // out.println("<tr><td>" + n + "</td><td>" + nm + "</td></tr>");   
              }
             }  
             out.println("</table>");  
             out.println("</html></body>");  
             con.close();
             }  
             catch (Exception e) 
            {  
             out.println("error");  
         }  
     }  
 }  
