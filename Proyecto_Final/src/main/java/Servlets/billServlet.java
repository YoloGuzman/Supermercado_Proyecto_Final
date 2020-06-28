/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Clases.Categoria;
import Clases.Detalle;
import Clases.Factura;
import Clases.Producto;
import Clases.ProductoExistencia;
import DB.BDUser;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author reyg6
 */
@WebServlet(name = "billServlet", urlPatterns = {"/bill"})
public class billServlet extends HttpServlet {

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
        bd.setDataBase();
        bd.connectingBD();
        Producto detalleProducto = new Producto();
        double precio = 0.00;
        int codigoP;
        int existencia;
        producto = bd.requestProducto();
        int noFact  = 0;
        int nit =0;
        String nombreC;
        String direccionC;
        double subtotal = 0.00;        
        int cant = 0;    
        
        
        
            response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<style>");
            out.println("table, th, td {");
            out.println("border: 1px solid black;");
            out.println("border-collapse: collapse;");
            out.println("}");
            out.println("th, td {");
            out.println("padding: 5px;");
            out.println("text-align: left;");
            out.println("}");
            out.println("</style>");
            out.println("<title>Caja Registradora</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<center><h1>Supermercado Agua Santa</h1></center>");
            out.println("<center><h4>Kilometro 13.5 carretera a Villa Canales<h4></center>");
            out.println("<center><h4>Guatemala</h4></center>");
            out.println("</br>");
            out.println("</br>");
            out.println("</br>");
            out.println("<form>");
            out.println("<label>Fecha: [YYYY-mm-dd]</label>");
            
            out.println("<input type='text' name='fecha'/>");
            out.println("<label>No. Factura: </label>");
            out.println("<input type='number' name='noFact'/>");
            out.println("</br>");
            out.println("</br>");
            out.println("</br>");
            
            
            out.println("<table style='width:30%'>");
            
            out.println("<tr>");
            out.println("<td><b>NIT: </b></td>");
            out.println("<td><input type='text' name='nit'/></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td><b>Nombre: </b></td>");
            out.println("<td><input type='text' name='nombreConsumer'/></td>");
            
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td><b>Direccion: </b></td>");
            out.println("<td><input type='text' name='direccion'/></td>");
            out.println("</tr>");
            
            out.println("</table>");
            
            
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
            int existente = 0;
        
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
        
                    precio = producto.get(encontrado).getPrecioVenta();
                    codigoP = producto.get(encontrado).getIdProducto();
                    existente = producto.get(encontrado).getExistencia();
                    
                    String fecha = request.getParameter("fecha");
                    nombreC = request.getParameter("nombreConsumer");
                    nit = Integer.parseInt(request.getParameter("nit"));
                    direccionC = request.getParameter("direccion");
                    noFact = Integer.parseInt(request.getParameter("noFact"));
                    
        System.out.println("PRECIO: " + precio);            
        System.out.println("CODIDOG P : " + codigoP);            
        System.out.println("EXISTENCIA: " + existente); 
        System.out.println("FECHA " + fecha);
        System.out.println("NIT " + nit);
        System.out.println("Nombre c" + nombreC);
        System.out.println("Direccion" + direccionC);
        System.out.println("NO FACTURA" + noFact);          
        
        
        out.println("</tr>");
        out.println("</table>");
            
            out.println("</br>");
            out.println("</br>");
            out.println("</br>");
                        
            out.println("<form>");
        out.println("<label>Cuanto articulos desea?</label>");
        out.println("<input type='number' name='ext'/>");
        out.println("<input type='submit' value='Generar'/>");
        
        out.println("</form>");
        
        cant = Integer.getInteger(request.getParameter("ext"));
        System.out.println("PEDIDO: " + cant);
            
            
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
