/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.RequestDispatcher;
/**
 *
 * @author my com
 */
public class Serch_1 extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
                String College_Id = request.getParameter("College_Id");
                request.setAttribute("College_Id",College_Id);
                
            String First_Name = request.getParameter("First_Name");
            request.setAttribute("First_Name",First_Name);
            
            String Last_Name = request.getParameter("Last_Name");
            request.setAttribute("Last_Name",Last_Name);
            
            String Contact_No= request.getParameter("Contact_No");
            request.setAttribute("Contact_No",Contact_No);
            
            String City = request.getParameter("City");
            request.setAttribute("City",City);
            
            String Pincode = request.getParameter("Pincode");
            request.setAttribute("Pincode",Pincode);
            
            String Department = request.getParameter("Department");
            request.setAttribute("Department",Department);
            
            String Branch = request.getParameter("Branch");
            request.setAttribute("Branch",Branch);
            
            String Semester = request.getParameter("Semester");
            request.setAttribute("Semester",Semester);
           // Date Birth_Date=Date.valueOf(request.getParameter("Birth_Date"));
           //java.util.Date Birth_Date= new SimpleDateFormat("dd-mm-yyyy").parse(request.getParameter("Birth_Date"));
            String Email_Add = request.getParameter("Email_Add");
            request.setAttribute("Email_Add",Email_Add);
            
            String Address=request.getParameter("Address");     
            request.setAttribute("Address",Address);
          
            
            RequestDispatcher disp=request.getRequestDispatcher("Serch.html");
             disp.forward(request, response);
            
            
         
            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/project3rdsem", "root", "");
            Statement st = cn.createStatement();
            if( First_Name!= ""){
            String q_upd = "update register set First_Name='"+First_Name+"'where College_Id='"+College_Id+"'";
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
