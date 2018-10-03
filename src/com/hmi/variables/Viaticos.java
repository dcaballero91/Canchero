/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hmi.variables;

public class Viaticos {

    private String fecha;
    private int numero;
    private int idvia;
    private String nombre;
    private String observacion;
    private String destino;
    private String inicio;
    private String fin;
    private String movil;
    private String acom;

    public int getidvia() {
        return idvia;
    }

    public void setidvia(int idvia) {
        this.idvia = idvia;
    }
   

    public String getinicio() {
        return inicio;
    }

    public void setinicio(String inicio) {
        this.inicio = inicio;
    }

    public String getnombre() {
        return nombre;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

    public String getobservacion() {
        return observacion;
    }

    public void setobservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getmovil() {
        return movil;
    }

    public void setmovil(String movil) {
        this.movil = movil;
    }

    public String getdestino() {
        return destino;
    }

    public void setdestino(String destino) {
        this.destino = destino;
    }

    public String getfin() {
        return fin;
    }

    public void setfin(String fin) {
        this.fin = fin;
    }

    public String getfecha() {
        return fecha;
    }

    public void setfecha(String fecha) {
        this.fecha = fecha;
    }

    public int getnumero() {
        return numero;
    }

    public void setnumero(int numero) {
        this.numero = numero;
    }

    public String getacom() {
        return acom;
    }

    public void setacom(String acom) {
        this.acom = acom;
    }
}