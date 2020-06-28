/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.ArrayList;

/**
 *
 * @author reyg6
 */
public class Factura {
int noFactura;
String fecha;
User usuario;
ArrayList<Detalle>  contenido;
double total;
int nit;

    public Factura(int noFactura, String fecha, User usuario, ArrayList<Detalle> contenido, double total, int nit) {
        this.noFactura = noFactura;
        this.fecha = fecha;
        this.usuario = usuario;
        this.contenido = contenido;
        this.total = total;
        this.nit = nit;
    }


    

    public Factura() {
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    
    public int getNoFactura() {
        return noFactura;
    }

    public void setNoFactura(int noFactura) {
        this.noFactura = noFactura;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public ArrayList<Detalle> getContenido() {
        return contenido;
    }

    public void setContenido(ArrayList<Detalle> contenido) {
        this.contenido = contenido;
    }

    

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }


}
