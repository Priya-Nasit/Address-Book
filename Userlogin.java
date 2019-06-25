
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/Userlogin"})
public class Userlogin extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         PrintWriter out = response.getWriter();
        try {
            String College_Id = request.getParameter("College_Id");
            String First_Name = request.getParameter("First_Name");
            String Last_Name = request.getParameter("Last_Name");
            String Contact_No= request.getParameter("Contact_No");
            String City = request.getParameter("City");
            String Pincode = request.getParameter("Pincode");
            String Department = request.getParameter("Department");
            String Branch = request.getParameter("Branch");
            //String Semester = request.getParameter("Semester");
            Date Birth_Date=Date.valueOf(request.getParameter("Birth_Date"));
           // java.util.Date Birth_Date= new SimpleDateFormat("dd-mm-yyyy").parse(request.getParameter("Birth_Date"));
            String Email_Add = request.getParameter("Email_Add");
            String Address=request.getParameter("Address");

            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project3rdsem", "root", "");
            Statement st = cn.createStatement();
            String q_ins = "insert into register (College_Id,First_Name,Last_Name,Contact_No,City,Pincode,Department,Branch,Birth_Date,Email_Add,Address) values('" + College_Id + "','" + First_Name + "','" + Last_Name + "','" + Contact_No + "','" + City + "','"+Pincode+"','"+Department+"','"+Branch+"','"+Birth_Date+"','"+Email_Add+"','"+Address+"')";
            //String q_ins = "insert into register (College_Id,First_Name,Last_Name,Contact_No,City,Pincode,Department,Branch,Email_Add,Address) values('" + College_Id + "','" + First_Name + "','" + Last_Name + "','" + Contact_No + "','" + City + "','"+Pincode+"','"+Department+"','"+Branch+"','"+Email_Add+"','"+Address+"')";
           out.print("q:"+q_ins);
            st.execute(q_ins);

            response.sendRedirect("home.html");
        }
    catch (Exception e) {
            out.print("exception:"+e);
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
