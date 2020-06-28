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
public class Detalle {
    int noDetalle;
    double subtotal;
    int cantidad;
    Producto producto;
    int idProducto;
    int noFactura;
    
    public Detalle() {
    }

    public Detalle(double subtotal, int cantidad, Producto producto, int idProducto, int noFactura) {
        
        this.subtotal = subtotal;
        this.cantidad = cantidad;
        this.producto = producto;
        this.idProducto = idProducto;
        this.noFactura = noFactura;
    }

    public int getNoFactura() {
        return noFactura;
    }

    public void setNoFactura(int noFactura) {
        this.noFactura = noFactura;
    }
    
    

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    
    

    public int getNoDetalle() {
        return noDetalle;
    }

    public void setNoDetalle(int noDetalle) {
        this.noDetalle = noDetalle;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    
    
}
