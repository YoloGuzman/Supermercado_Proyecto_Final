/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import Clases.Producto_Medida;
import Clases.Categoria;
import Clases.Detalle;
import Clases.Medida;
import Clases.Distribuidor;
import Clases.Factura;

import Clases.Producto;
import Clases.ProductoExistencia;
import Clases.User;
import java.util.Scanner;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/**
 *
 * @author reyg6
 */
public class BDUser {

static Connection connection = null;
static Statement stmt = null;
static ResultSet resultSet = null;
static Scanner reader = new Scanner(System.in);
static Statement stmtInsertar = null;
static String answerInsert = null;


public void setDataBase(){
    try{
        Class.forName("com.mysql.jdbc.Driver");
    }catch(Exception ex){
        System.out.println("| " + ex);
    }
}


    public void connectingBD(){

        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectosuper", "root", "Rate462wart");
            System.out.println("Connected!!");
        }catch(SQLException ex){
            System.out.println("SQL_Exception: " + ex.getMessage());
            System.out.println("SQL_State: " + ex.getSQLState());
            System.out.println("Vendor_Error: " + ex.getErrorCode());
        }
    }
    
    
    public void reviewQueries() {

        try {

            stmt = connection.createStatement();
            resultSet = stmt.executeQuery("SELECT usuarioEmpleado, passwordEmpleado, nombreEmpleado from empleado");

            
                
                String usuario = resultSet.getString("carne");
                String password = resultSet.getString("nombre");
                String nombre = resultSet.getString("edad");

               // User user = new User(usuario, password, nombre);
                
                //return user;
            

        } catch (SQLException ex) {
            
            System.out.println("SQLExceotion: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }


        finally {
            if (resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException sqlEx) {}
                resultSet = null;
            }
        }

        if (stmt == null) {
            try {
                stmt.close();
            } catch (SQLException sqlEX) {
            }
            stmt = null;
        }
      
    }
    

public void insertProductBD(Producto pro, Producto_Medida prome, int idDistro){
        try {
            stmt = connection.createStatement();

                stmtInsertar = connection.prepareStatement("insert into producto(idProducto, nombreProducto, "
                        + "precioVenta, precioCosto, codigoCategoria) " +
                        "values (?,?,?,?,?)");
                ((PreparedStatement) stmtInsertar).setInt(1, pro.getIdProducto());
                ((PreparedStatement) stmtInsertar).setString(2, pro.getNombreProducto());
                ((PreparedStatement) stmtInsertar).setDouble(3, pro.getPrecioVenta());
                ((PreparedStatement) stmtInsertar).setDouble(4, pro.getPrecioCosto());
                ((PreparedStatement) stmtInsertar).setInt(5, pro.getCodigoCategoria());

                ((PreparedStatement) stmtInsertar).executeUpdate();
            
                
                stmtInsertar = connection.prepareStatement("insert into producto_medida(idProducto, descripcion, existencia) " +
                        "values (?,?,?)");
               
                ((PreparedStatement) stmtInsertar).setInt(1, prome.getIdProducto());
                ((PreparedStatement) stmtInsertar).setString(2, prome.getDescripcion());
                ((PreparedStatement) stmtInsertar).setInt(3, prome.getExistencia());
               
                ((PreparedStatement) stmtInsertar).executeUpdate();
            
                stmtInsertar = connection.prepareStatement("insert into producto_distribuidor(idProducto, idDistribuidor) " +
                        "values (?,?)");
               
                ((PreparedStatement) stmtInsertar).setInt(1, pro.getIdProducto());
                ((PreparedStatement) stmtInsertar).setInt(2, idDistro);
                
                ((PreparedStatement) stmtInsertar).executeUpdate();
        } catch (SQLException ex){
            System.out.println("SQL_Exception: " + ex.getMessage());
            System.out.println("SQL_State: " + ex.getSQLState());
            System.out.println("VendprError: " + ex.getErrorCode());
        }

        finally {
            if (resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException sqlEx) {}
                resultSet = null;
            }
        }

        if (stmt == null) {
            try {
                stmt.close();
            } catch (SQLException sqlEX) {
            }
            stmt = null;
        }
    }

public void insertUsuario(User usuario){
        try {
            stmt = connection.createStatement();

                stmtInsertar = connection.prepareStatement("insert into usuario (nit, nombreUsuario, direccion)" + 
                        "values (?,?,?)");
                ((PreparedStatement) stmtInsertar).setInt(1, usuario.getNit());
                ((PreparedStatement) stmtInsertar).setString(2, usuario.getNombre());
                ((PreparedStatement) stmtInsertar).setString(3, usuario.getDireccion());
                
                ((PreparedStatement) stmtInsertar).executeUpdate();
                            
        } catch (SQLException ex){
            System.out.println("SQL_Exception: " + ex.getMessage());
            System.out.println("SQL_State: " + ex.getSQLState());
            System.out.println("VendprError: " + ex.getErrorCode());
        }

        finally {
            if (resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException sqlEx) {}
                resultSet = null;
            }
        }

        if (stmt == null) {
            try {
                stmt.close();
            } catch (SQLException sqlEX) {
            }
            stmt = null;
        }
    }

public void insertFact(Factura fact){
        try {
            stmt = connection.createStatement();

                stmtInsertar = connection.prepareStatement("insert into factura (noFactura, fecha, nit, total)" + 
                        "values (?,?,?,?)");
                ((PreparedStatement) stmtInsertar).setInt(1, fact.getNoFactura());
                ((PreparedStatement) stmtInsertar).setString(2, fact.getFecha());
                ((PreparedStatement) stmtInsertar).setInt(3, fact.getNit());
                ((PreparedStatement) stmtInsertar).setDouble(4, fact.getTotal());
                
                
                ((PreparedStatement) stmtInsertar).executeUpdate();
                            
        } catch (SQLException ex){
            System.out.println("SQL_Exception: " + ex.getMessage());
            System.out.println("SQL_State: " + ex.getSQLState());
            System.out.println("VendprError: " + ex.getErrorCode());
        }

        finally {
            if (resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException sqlEx) {}
                resultSet = null;
            }
        }

        if (stmt == null) {
            try {
                stmt.close();
            } catch (SQLException sqlEX) {
            }
            stmt = null;
        }
    }

public void insertDetalle(Detalle det, int existente){
        
        try {
            stmt = connection.createStatement();

                stmtInsertar = connection.prepareStatement("insert into detalle (cantidad, subtotal, idProducto, noFactura)" + 
                        "values (?,?,?,?,?)");
                
                
                ((PreparedStatement) stmtInsertar).setInt(1, det.getCantidad());
                ((PreparedStatement) stmtInsertar).setDouble(2, det.getSubtotal());
                ((PreparedStatement) stmtInsertar).setInt(5, det.getIdProducto());
                ((PreparedStatement) stmtInsertar).setInt(6, det.getNoFactura());
                
                ((PreparedStatement) stmtInsertar).executeUpdate();
                            
                
             
            // update producto set nombreProducto = "Mango" where idProducto = 9401;
            int nuevaCantidad = existente - det.getCantidad();
            String sql = "update producto set existencia=? where idProducto=?";
            PreparedStatement statment =  connection.prepareStatement(sql);
            statment.setInt(1, nuevaCantidad);
            statment.setInt(2, det.getIdProducto());
                 
            statment.executeUpdate();
                
        } catch (SQLException ex){
            System.out.println("SQL_Exception: " + ex.getMessage());
            System.out.println("SQL_State: " + ex.getSQLState());
            System.out.println("VendprError: " + ex.getErrorCode());
        }

        finally {
            if (resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException sqlEx) {}
                resultSet = null;
            }
        }

        if (stmt == null) {
            try {
                stmt.close();
            } catch (SQLException sqlEX) {
            }
            stmt = null;
        }
    }



public void insertMedida(Medida med){
        try {
            stmt = connection.createStatement();

                
                stmtInsertar = connection.prepareStatement("insert into medida(descripcion) " +
                        "values (?)");
                ((PreparedStatement) stmtInsertar).setString(1, med.getDescripcion());
                ((PreparedStatement) stmtInsertar).executeUpdate();
                
                
        } catch (SQLException ex){
            System.out.println("SQL_Exception: " + ex.getMessage());
            System.out.println("SQL_State: " + ex.getSQLState());
            System.out.println("VendprError: " + ex.getErrorCode());
        }

        finally {
            if (resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException sqlEx) {}
                resultSet = null;
            }
        }

        if (stmt == null) {
            try {
                stmt.close();
            } catch (SQLException sqlEX) {
            }
            stmt = null;
        }
    }


public void insertCategoryBD(Categoria cat){
        try {
            stmt = connection.createStatement();

                stmtInsertar = connection.prepareStatement("insert into categoria(codigoCategoria, nombreCategoria, descripcion) " +
                        "values (?,?,?)");
                ((PreparedStatement) stmtInsertar).setInt(1, cat.getCodigoCategoria());
                ((PreparedStatement) stmtInsertar).setString(2, cat.getNombreCategoria());
                ((PreparedStatement) stmtInsertar).setString(3, cat.getDespripcion());
                

                ((PreparedStatement) stmtInsertar).executeUpdate();
            

        } catch (SQLException ex){
            System.out.println("SQL_Exception: " + ex.getMessage());
            System.out.println("SQL_State: " + ex.getSQLState());
            System.out.println("VendprError: " + ex.getErrorCode());
        }

        finally {
            if (resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException sqlEx) {}
                resultSet = null;
            }
        }

        if (stmt == null) {
            try {
                stmt.close();
            } catch (SQLException sqlEX) {
            }
            stmt = null;
        }
    }
public void insertDistribuidorBD(Distribuidor dis){
        try {
            stmt = connection.createStatement();

                stmtInsertar = connection.prepareStatement("insert into distribuidor (idDistribuidor, nombreDistribuidor, telefonoDistribuidor, direccionDistribuidor, emailDistribuidor)" +
                        "values (?,?,?,?,?)");
                ((PreparedStatement) stmtInsertar).setInt(1, dis.getIdDistribuidor());
                ((PreparedStatement) stmtInsertar).setString(2, dis.getNombreDistribuidor());
                ((PreparedStatement) stmtInsertar).setString(3, dis.getTelefonoDistribuidor());
                ((PreparedStatement) stmtInsertar).setString(4, dis.getDireccionDistribuidor());
                ((PreparedStatement) stmtInsertar).setString(5, dis.getEmailDistribuidor());
                

                ((PreparedStatement) stmtInsertar).executeUpdate();
            

        } catch (SQLException ex){
            System.out.println("SQL_Exception: " + ex.getMessage());
            System.out.println("SQL_State: " + ex.getSQLState());
            System.out.println("VendprError: " + ex.getErrorCode());
        }

        finally {
            if (resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException sqlEx) {}
                resultSet = null;
            }
        }

        if (stmt == null) {
            try {
                stmt.close();
            } catch (SQLException sqlEX) {
            }
            stmt = null;
        }
    }

    
    public ArrayList<Distribuidor> requestDistro(){
            Distribuidor distro = new Distribuidor();
            ArrayList<Distribuidor> distribuidorList  = new ArrayList<Distribuidor>();
            
        try {

            stmt = connection.createStatement();
            resultSet = stmt.executeQuery("select idDistribuidor, nombreDistribuidor from distribuidor");

            while(resultSet.next()){
                
                distro.setIdDistribuidor(resultSet.getInt("idDistribuidor"));
                distro.setNombreDistribuidor(resultSet.getString("nombreDistribuidor"));
                distribuidorList.add(new Distribuidor(distro.getIdDistribuidor(), distro.getNombreDistribuidor()));
                }
            
        } catch (SQLException ex) {
            System.out.println("SQLExceotion: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }


        finally {
            if (resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException sqlEx) {}
                resultSet = null;
            }
        }

        if (stmt == null) {
            try {
                stmt.close();
            } catch (SQLException sqlEX) {
            }
            stmt = null;
        }

        return distribuidorList;
    }

    public ArrayList<Categoria> requestCategoria(){
            Categoria cat = new Categoria();
            ArrayList<Categoria> categoriaList  = new ArrayList<Categoria>();
            
        try {

            stmt = connection.createStatement();
            resultSet = stmt.executeQuery("select codigoCategoria, nombreCategoria, descripcion from categoria");

            while(resultSet.next()){
                
                cat.setCodigoCategoria(resultSet.getInt("codigoCategoria"));
                cat.setNombreCategoria(resultSet.getString("nombreCategoria"));
                
                categoriaList.add(new Categoria(cat.getCodigoCategoria(), cat.getNombreCategoria()));
                }
            
            
        } catch (SQLException ex) {
            System.out.println("SQLExceotion: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }


        finally {
            if (resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException sqlEx) {}
                resultSet = null;
            }
        }

        if (stmt == null) {
            try {
                stmt.close();
            } catch (SQLException sqlEX) {
            }
            stmt = null;
        }

        return categoriaList;
    }
    
    public ArrayList<Medida> requestMedida(){
            Medida med = new Medida();
            ArrayList<Medida> medidaList  = new ArrayList<Medida>();
            
        try {

            stmt = connection.createStatement();
            resultSet = stmt.executeQuery("select descripcion from medida");

            while(resultSet.next()){
                
                med.setDescripcion(resultSet.getString("descripcion"));
                medidaList.add(new Medida(med.getDescripcion()));
                
                }
            
            
        } catch (SQLException ex) {
            System.out.println("SQLExceotion: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }


        finally {
            if (resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException sqlEx) {}
                resultSet = null;
            }
        }

        if (stmt == null) {
            try {
                stmt.close();
            } catch (SQLException sqlEX) {
            }
            stmt = null;
        }

        return medidaList;
    }
    
    public ArrayList<ProductoExistencia> requestProducto(){
            ProductoExistencia pro = new ProductoExistencia();
            ArrayList<ProductoExistencia> productoList  = new ArrayList<ProductoExistencia>();
            
        try {

            stmt = connection.createStatement();
            resultSet = stmt.executeQuery("select * from producto inner join producto_medida "
                    + "on producto.idProducto = producto_medida.idProducto");

            while(resultSet.next()){
                
                    pro.setIdProducto(resultSet.getInt("idProducto"));
                    pro.setNombreProducto(resultSet.getString("nombreProducto"));
                    pro.setPrecioVenta(resultSet.getDouble("precioVenta"));
                    pro.setPrecioCosto(resultSet.getDouble("precioCosto"));
                    pro.setDescripcion(resultSet.getString("descripcion"));
                    pro.setExistencia(resultSet.getInt("existencia"));
                    pro.setCodigoCategoria(resultSet.getInt("codigoCategoria"));
                productoList.add(new ProductoExistencia(pro.getIdProducto(), pro.getNombreProducto(), 
                        pro.getPrecioVenta(), pro.getPrecioCosto(), 
                        pro.getDescripcion(), pro.getExistencia(), pro.getCodigoCategoria()));
                
                }
            
            
        } catch (SQLException ex) {
            System.out.println("SQLExceotion: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }


        finally {
            if (resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException sqlEx) {}
                resultSet = null;
            }
        }

        if (stmt == null) {
            try {
                stmt.close();
            } catch (SQLException sqlEX) {
            }
            stmt = null;
        }
        

        return productoList;
    }
    
    
    public void updateProducto(int existencia, int idProducto){
                        
        try {

             stmt = connection.createStatement();
            // update producto set nombreProducto = "Mango" where idProducto = 9401;
            String sql = "update producto_medida set existencia=? where idProducto=?";
            PreparedStatement statment =  connection.prepareStatement(sql);
            statment.setInt(1, existencia);
            statment.setInt(2, idProducto);
                 
            statment.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("SQLExceotion: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }


        finally {
            if (resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException sqlEx) {}
                resultSet = null;
            }
        }

        if (stmt == null) {
            try {
                stmt.close();
            } catch (SQLException sqlEX) {
            }
            stmt = null;
        }

        
    }
}
