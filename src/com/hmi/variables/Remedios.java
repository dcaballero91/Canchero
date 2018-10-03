/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hmi.variables;


public class Remedios {
    private int id;
    private String nombre;
    private String categ;
    private String descr;
    private String estado;
    private String receta;
    public String getReceta() {
        return receta;
    }

    public void setReceta(String receta) {
        this.receta = receta;
    }
    
    
    public String getestado(){
    return estado;
    }
    public void setestado(String estado){
    this.estado=estado;
    }

    public String getfecha() {
        return fecha;
    }

    public void setfecha(String fecha) {
        this.fecha = fecha;
    }
    private String fecha;

    public int getid() {
        return id;
    }

    public String getnombre() {
        return nombre;
    }

    public String getcateg() {
        return categ;
    }

    public String getdescr() {
        return descr;
    }

    public void setid(int id) {
        this.id = id;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

    public void setcateg(String categ) {
        this.categ = categ;
    }

    public void setdescr(String descr) {
        this.descr = descr;
    }

    public void setString(int i, String text) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    
}
