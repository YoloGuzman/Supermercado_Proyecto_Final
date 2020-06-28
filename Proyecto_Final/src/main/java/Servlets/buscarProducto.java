/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Clases.Producto;
import Clases.ProductoExistencia;
import DB.BDUser;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author reyg6
 */
@WebServlet(name = "BuscarProducto", urlPatterns = {"/buscarP"})
public class buscarProducto extends HttpServlet {

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
        
        ProductoExistencia pro = new ProductoExistencia();
        ArrayList<ProductoExistencia> producto = new ArrayList<ProductoExistencia>();
        BDUser bd = new BDUser();
        
        
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
            out.print("background-color: #dddddd;");
            out.print("}");
            out.print("</style>");
            out.println("<title>BuscarProducto</title>");            
            out.println("</head>");
            
            out.println("<body>");
            out.println("<table border='1'>");
            out.println("<form>");
            out.println("<tr>");
            bd.setDataBase();
            bd.connectingBD();
            producto = bd.requestProducto();
            out.println("<th><label>Nombre del producto</label></th>");
            out.println("</tr>");
            out.println("<td><select name='idProducto'>");
            for(ProductoExistencia proE : producto){
            out.println("<option value='" + proE.getIdProducto() + "'>" + proE.getNombreProducto() + "</option>");
            }
            
            out.println("</select></td>");            
            out.println("</tr>");
            out.println("</table>");
            out.println("<input type='submit' value='Buscar'/>");
            out.println("<br/>");
            out.println("</form>");
            
            out.println("<br/>");
            out.println("<br/>");
            out.println("<br/>");
            int codigoB = Integer.parseInt(request.getParameter("idProducto"));
            int encontrado = -1;
            for(int i = 0; i < producto.size(); i++){
                if(producto.get(i).getIdProducto() == codigoB){
                    encontrado = i;
                }else{
                    continue;
                }
            }
            out.println("<table>");
        out.println("<tr>");
        out.println("<th>Producto ID</th>");
        out.println("<th>Nombre</th>");
        out.println("<th>Precio Venta</th>");
        out.println("<th>Precio Costo</th>");
        out.println("<th>Descripcion</th>");
        out.println("<th>Existencia</th>");
        out.println("</tr>");
        
        out.println("<tr>");
        out.println("<td>" + producto.get(encontrado).getIdProducto() + "</td>");
        out.println("<td>" + producto.get(encontrado).getNombreProducto() + "</td>");
        out.println("<td>" + producto.get(encontrado).getPrecioVenta() + "</td>");
        out.println("<td>" + producto.get(encontrado).getPrecioCosto() + "</td>");
        out.println("<td>" + producto.get(encontrado).getDescripcion() + "</td>");
        out.println("<td>" + producto.get(encontrado).getExistencia() + "</td>");
        out.println("</tr>");
        out.println("</table>");
            
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
