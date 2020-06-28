package Clases;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author reyg6
 */
public class Distribuidor {

int idDistribuidor;
String nombreDistribuidor;
String telefonoDistribuidor;
String direccionDistribuidor;
String emailDistribuidor;

    public Distribuidor() {
    }

    public Distribuidor(int idDistribuidor, String nombreDistribuidor) {
        this.idDistribuidor = idDistribuidor;
        this.nombreDistribuidor = nombreDistribuidor;
    }
    
    public int getIdDistribuidor() {
        return idDistribuidor;
    }

    public void setIdDistribuidor(int idDistribuidor) {
        this.idDistribuidor = idDistribuidor;
    }

    public String getNombreDistribuidor() {
        return nombreDistribuidor;
    }

    public void setNombreDistribuidor(String nombreDistribuidor) {
        this.nombreDistribuidor = nombreDistribuidor;
    }

    public String getTelefonoDistribuidor() {
        return telefonoDistribuidor;
    }

    public void setTelefonoDistribuidor(String telefonoDistribuidor) {
        this.telefonoDistribuidor = telefonoDistribuidor;
    }

    public String getDireccionDistribuidor() {
        return direccionDistribuidor;
    }

    public void setDireccionDistribuidor(String direccionDistribuidor) {
        this.direccionDistribuidor = direccionDistribuidor;
    }

    public String getEmailDistribuidor() {
        return emailDistribuidor;
    }

    public void setEmailDistribuidor(String emailDistribuidor) {
        this.emailDistribuidor = emailDistribuidor;
    }


    
}
