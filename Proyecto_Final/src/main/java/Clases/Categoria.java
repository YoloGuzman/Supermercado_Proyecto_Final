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
public class Categoria {
    int codigoCategoria;
    String nombreCategoria;
    String despripcion;

    public Categoria(int codigoCategoria, String nombreCategoria) {
        this.codigoCategoria = codigoCategoria;
        this.nombreCategoria = nombreCategoria;
    }

    public Categoria() {
    }

    public int getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(int codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public String getDespripcion() {
        return despripcion;
    }

    public void setDespripcion(String despripcion) {
        this.despripcion = despripcion;
    }
    
    
}
