/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DB.BDUser;
import Clases.Producto_Medida;
import Clases.Medida;
import Clases.Producto;
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
@WebServlet(name = "GuardarPro", urlPatterns = {"/guardar"})
public class guardarProducto extends HttpServlet {

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
            out.println("<title>Servlet GuardarPro</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Guardado exitosamente!</h1>");
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
        
        int codigo = Integer.parseInt(request.getParameter("codigoProducto"));
        String nombreP = request.getParameter("nombreProducto");
        double precioV = Double.valueOf(request.getParameter("precioVenta"));
        double precioC = Double.valueOf(request.getParameter("precioCosto"));
        int categoria = Integer.parseInt(request.getParameter("codigoCategoria"));
        String medida = request.getParameter("medida");
        int existencia = Integer.parseInt(request.getParameter("existencia"));
        int idDistribuidor  = Integer.parseInt(request.getParameter("idDistribuidor"));
       
        Producto pro = new Producto();
        
        pro.setIdProducto(codigo);
        pro.setNombreProducto(nombreP);
        pro.setPrecioVenta(precioV);
        pro.setPrecioCosto(precioC);
        pro.setCodigoCategoria(categoria);
                
        Producto_Medida ProMe = new Producto_Medida();
        
        ProMe.setIdProducto(codigo);
        ProMe.setDescripcion(medida);
        ProMe.setExistencia(existencia);
        
        BDUser user = new BDUser();
        
        user.setDataBase();
        user.connectingBD();
        user.insertProductBD(pro, ProMe, idDistribuidor);
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
