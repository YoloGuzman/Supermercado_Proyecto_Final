/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author reyg6
 */
public class Producto {
    int idProducto;
    String nombreProducto;
    double precioVenta;
    double precioCosto;
    int codigoCategoria;

    public Producto(int idProducto, String nombreProducto, double precioVenta, double precioCosto, int codigoCategoria) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.precioVenta = precioVenta;
        this.precioCosto = precioCosto;
        this.codigoCategoria = codigoCategoria;
    }

    
    
    public Producto(){}
    
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public double getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(double precioCosto) {
        this.precioCosto = precioCosto;
    }

    public int getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(int codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }
    
    
    
}
