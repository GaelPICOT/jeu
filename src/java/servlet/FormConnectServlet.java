package servlet;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Anthony
 */
public class FormConnectServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FormServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FormServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
        doPost(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            //        processRequest(request, response);
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();


        out.println("<HTML>\n<BODY>\n" +
                                "<H1>Recapitulatif des informations</H1>\n" +
                                "<UL>\n" +			   
                "  <LI>Prénom: "
                                + request.getParameter("firstName") + "\n" +
                                "  <LI>Nom: "
                                + request.getParameter("lastName") + "\n" +
                                "  <LI>email: "
                                + request.getParameter("email") + "\n" +
                                "</UL>\n" +				
                "</BODY></HTML>");  

        Connection con=null;
        String url ="jdbc:mysql://localhost:3306/";
        String dbName="ecom";
//        String driver = "com.mysql.jdbc.Driver";
        String username = "root";
        String password = "ecom";
        Statement stmt;
        ResultSet rs;

                    
                    
        try {
            con = DriverManager.getConnection(url + dbName, username,
                    password);

            out.println("Connected to database");
//            String query1= "insert into student values  name='"
//             +name +"',gender='"+gender+ "',skills='"+skill + "',addname='" 
//             +addr +"',country='" +country +"'";
            String query1 = "select count(*) from `appliuser` where mail='" + request.getParameter("email") 
                    + "' and hashpassword='" + request.getParameter("password") + "';";

            out.print("<br>");
            out.println(query1);
            out.print("<br>");
            stmt =con.createStatement();
            rs = stmt.executeQuery(query1);
            out.print("requete traitee<br>");
            // rs directly renders com.mysql.jdbc.JDBC4ResultSet@36079bca
            out.print("resultat requete: " + rs + "<br>");
            out.print("resultat requete: " + rs.getInt(1) + "<br>");
//            response.sendRedirect("std.jsp");
            con.close();
            System.out.print("Disconnected from DB");
        } catch (SQLException ex) {
            Logger.getLogger(FormConnectServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
