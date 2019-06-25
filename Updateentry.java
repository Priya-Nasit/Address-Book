/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.annotation.WebServlet;
/**
 *
 * @author my com
 */
@WebServlet(urlPatterns = {"/Updateentry"})
public class Updateentry extends HttpServlet {

    
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
            //Date Birth_Date=Date.valueOf(request.getParameter("Birth_Date"));
           //java.util.Date Birth_Date= new SimpleDateFormat("dd-mm-yyyy").parse(request.getParameter("Birth_Date"));
            String Email_Add = request.getParameter("Email_Add");
            String Address=request.getParameter("Address");        
          
         
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project3rdsem", "root", "");
            Statement st = cn.createStatement();
            if( First_Name!= ""){
            String q_upd = "update register set First_Name ='"+First_Name+"'where College_Id='"+College_Id+"'";
            st.execute(q_upd);
            }
 
            if(Last_Name!= ""){
            String q_upd = "update register set Last_Name ='"+Last_Name+"'where College_Id='"+College_Id+"'";
            st.execute(q_upd);
            }
            
            if(Contact_No != ""){
            String q_upd = "update register set Contact_No='"+Contact_No+"'where College_Id='"+College_Id+"'";
            st.execute(q_upd);
            }
            
            if(City != ""){
            String q_upd = "update register set City='"+City+"'where College_Id='"+College_Id+"'";
            st.execute(q_upd);
            }
            
            if(Pincode!= ""){
            String q_upd = "update register set Pincode='"+Pincode+"'where College_Id='"+College_Id+"'";
            st.execute(q_upd);
            }
            
            if(Department != ""){
            String q_upd = "update register set Department='"+Department+"'where College_Id='"+College_Id+"'";
            st.execute(q_upd);
            }
            
            if(Branch!= ""){
                
            String q_upd = "update register set Branch='"+Branch+"'where College_Id='"+College_Id+"'";
            st.execute(q_upd);
            }
            
            if(Email_Add != ""){
            String q_upd = "update register set Email_Add='"+Email_Add+"'where College_Id='"+College_Id+"'";
            st.execute(q_upd);
            }
            
            if(Address != ""){
            String q_upd = "update register set Address='"+Address+"'where College_Id='"+College_Id+"'";
            st.execute(q_upd);
            }
            
            response.sendRedirect("Update.html");

        
        } 
        catch(Exception e){
            out.print("exc"+e);
        }
        finally {            
            out.close();
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
    }// </editor-fold>
}
