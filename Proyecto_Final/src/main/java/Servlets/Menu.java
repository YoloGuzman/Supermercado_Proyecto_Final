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
@WebServlet(name = "AuthenticationCasher", urlPatterns = {"/AuthenticationCa"})
public class Menu extends HttpServlet {

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
            out.println("<font color='black' face='Courier New,arial'>");
            out.println("<head>");
            out.println("<style>");
            out.print("table {");
            out.print("font-family: arial, sans-serif;");
            out.print("border-collapse: collapse;");
            out.print("width: 100%;");
            out.print("}");

            out.print("td, th {");
            out.print("border: 1px solid Gray;");
            out.print("text-align: left;");
            out.print("padding: 8px;");
            out.print("}");

            out.print("tr:nth-child(even) {");
            out.print("background-color: LightGreen;");
            out.print("}");
            out.print("</style>");
            
            out.println("<title>Supermercado Agua Santa</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Welcome: " + request.getParameter("user")+ "</h1>");
            
            out.println("</body>");
            out.println("<table>");
            out.println("<tr><center><h1>Que te gustaria hacer hoy?</h1></center></tr>");
            out.println("<tr>");
            out.println("<td><h2>" + "<a href='inventario'>Ingresar Producto Nuevo</a>" + "</h2></td>");
            out.println("<td><h2>" + "<a href='buscarP'>Buscar Producto</a>" + "</h2></td>");
            out.println("<td><h2>" + "<a href='agregarP'>Agregar Existencia</a>" + "</h2></td>");
            out.println("<td><h2>" + "<a href='categoria'>Ingresar Categoria</a>" + "</h2></td>");
            out.println("<td><h2>" + "<a href='distribuidor'>Ingresar Distribuidor</a>" + "</h2></td>");
            out.println("<td><h2>" + "<a href='medida'>Ingresar Medida</a>" + "</h2></td>");
            out.println("<td><h2>" + "<a href='inventa'>Ver todo inventario</a>" + "</h2></td>");
            out.println("<td><h2>" + "<a href='bill'>Facturar</a>" + "</h2></td>");

            out.println("</tr>");
            
            
            out.println("</table>");
            out.println("</font>");
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
        
        String nombre = request.getParameter("user");
        
        request.getSession().setAttribute("user", nombre);
        request.getSession().setMaxInactiveInterval(2*60);
        
        response.sendRedirect("AuthenticationCa");
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
