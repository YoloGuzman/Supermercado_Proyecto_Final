/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DB.BDUser;
import Clases.Distribuidor;
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
@WebServlet(name = "guardarDistribuidor", urlPatterns = {"/guardarDi"})
public class guardarDistribuidor extends HttpServlet {

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
            out.println("<title>Distribuidor</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Guardado Exitosamente!</h1>");
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
        
        int idDistribuidor = Integer.parseInt(request.getParameter("idDistribuidor"));
        String nombreD = request.getParameter("nombreDistribuidor");
        String telefonoD = request.getParameter("telefonoDistribuidor");
        String direccionD = request.getParameter("direccionDistribuidor");
        String emailD = request.getParameter("emailDistribuidor");
        
        Distribuidor dis = new Distribuidor();
        
        dis.setIdDistribuidor(idDistribuidor);
        dis.setNombreDistribuidor(nombreD);
        dis.setTelefonoDistribuidor(telefonoD);
        dis.setDireccionDistribuidor(direccionD);
        dis.setEmailDistribuidor(emailD);
        
        
        BDUser user = new BDUser();
        
        user.setDataBase();
        user.connectingBD();
        user.insertDistribuidorBD(dis);
        
     
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
