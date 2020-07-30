import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;  
import java.sql.*;  
    
public class sell extends HttpServlet  
{    
     public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException 
      {  
          PrintWriter out = res.getWriter();  
          res.setContentType("text/html"); 
          String sto=req.getParameter("stock");
          Double stock=Double.parseDouble(sto);
          //String password=req.getParameter("password"); 
          String name="Mobiles";
      String model="Sony Xperia XA1";
      Double pric=14990.0;
          out.println("<html><body>");  
          try 
          {  
             Class.forName("com.mysql.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ooad", "root", "abinaya99");  
             Statement stmt = con.createStatement();  
             ResultSet rs = stmt.executeQuery("select * from catalog");  
             //out.println("<table border=1 width=50% height=50
             //out.println("<tr><th>Email</th><th>password</th><tr>");  
             while (rs.next()) 
             {  
                 String n = rs.getString("product_name");  
                 String nm = rs.getString("product_model");
                 Double price=rs.getDouble("price");
                Double avai=rs.getDouble("stock_available");
                //if(avai>=stock)
                //{
                  //out.println("<h1>Stock Available</h1>"+"\n");
                  out.println("<h3>Bill Generated</h3>"+"\n");
                  out.println("<h3>Product Name : </h3>"+n+"\n");
                  out.println("<h3>Product Model : </h3>"+nm+"\n");
                  out.println("<h3>Price : </h3>"+price+"\n");
                  out.println("<h3>No. of .products : </h3>"+stock+"\n");
                  out.println("<h3>Total : </h3>"+stock*price+"\n");
                  out.println("<button>Proceeed to Payment</button><a href="prod.html"><button>Exit</button></a>");
                  Double d=avai+stock;
                  stmt.executeQuery("update catalog set stock_available='+d+' where product_model='+nm+'");
                
                // int s = rs.getInt("sal");   
                // if(n.equals(email) && nm.equals(password))
                 //{
                  //out.println("Success");
                  //res.sendRedirect("loghome.jsp");
                 //}
                out.println("</body></html>");
                // out.println("<tr><td>" + n + "</td><td>" + nm + "</td></tr>");   
             }   
             con.close();
             }  
             catch (Exception e) 
            {  
             out.println("error");  
         }  
     }  
 }  