/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author reyg6
 */
@WebServlet(name = "distribuidorServlet", urlPatterns = {"/distribuidor"})
public class distribuidorServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<style>");
            out.print("table {");
            out.print("font-family: arial, sans-serif;");
            out.print("border-collapse: collapse;");
            out.print("width: 100%;");
            out.print("}");

            out.print("td, th {");
            out.print("border: 1px solid #dddddd;");
            out.print("text-align: left;");
            out.print("padding: 8px;");
            out.print("}");

            out.print("tr:nth-child(even) {");
            out.print("background-color: SlateBlue;");
            out.print("}");
            out.print("</style>");
            
            out.println("<title>Ingreso Distribuidor</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<body>");
            out.println("<h1>Ingresar Distribuidor</h1>");
            out.println("<table border='1'>");
            out.println("<form action='guardarDi' method='post'>");
            out.println("<tr>");
             out.println("<th>" + "<label>Id Distribuidor</label>" + "</th>");
             out.println("<th>" + "<label>Nombre Distribuidor</label>"+ "</th>");
             out.println("<th>" + "<label>Telefono Distribuidor</label>" + "</th>");
             out.println("<th>" + "<label>Direccion Distribuidor</label>" + "</th>");
             out.println("<th>" + "<label>Email Distribuidor</label>" + "</th>");
             
             out.println("</tr>");
             
             out.println("<tr>");
            
            out.println("<td>"+"<input type='number' name ='idDistribuidor'/>" + "</td>");
            out.println("<td>" + "<input type='text' name ='nombreDistribuidor'/>"  + "</td>");
            out.println("<td>" + "<input type='text' name ='telefonoDistribuidor'/>"  + "</td>");
            out.println("<td>" + "<input type='text' name ='direccionDistribuidor'/>"  + "</td>");
            out.println("<td>" + "<input type='text' name ='emailDistribuidor'/>"  + "</td>");
            
            out.println("</tr>");
            out.println("</table>");
            out.println("<input type='submit' value='Guardar'/>");
            out.println("<br/>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
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
