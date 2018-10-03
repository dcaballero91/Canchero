/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hmi.variables;

public class PreAgenda {
    
    

    public PreAgenda() {
    }
    private int nficha;
    private int idagenda;
    private String fecha;
    private String nombre;
    private String apellido;
    private Double temperatura;
    private Double ta;
    private Double peso;

     public int getIdagenda() {
        return idagenda;
    }

    public void setIdagenda(int idagenda) {
        this.idagenda = idagenda;
    }
    
    public String getusuario() {
        return usuario;
    }

    public void setusuario(String usuario) {
        this.usuario = usuario;
    }
    private String usuario;
    
    public String getfecha() {
        return fecha;
    }
    public void setfecha(String fecha) {
        this.fecha = fecha;}
  
    public int getnficha() {
        return nficha;
    }

    public void setnficha(int nficha) {
        this.nficha = nficha;}

   
    
     public String getnombre() {
        return nombre;
     }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }
     public String getapellido() {
        return apellido;
    }

    public void setapellido(String apellido) {
        this.apellido = apellido;
    }
     public Double gettemperatura() {
        return temperatura;
    }

    public void settemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }
    public Double getta() {
        return ta;
    }

    public void setta(Double ta) {
        this.ta = ta;
    }
    public Double getpeso() {
        return peso;
    }

    public void setpeso(Double peso) {
        this.peso = peso;
    }

    public void setcateg(String text) {
        
    }

    public void setid(int parseInt) {
        
    }

    public void setdescr(String text) {
        
    }

       
    

    
    
}
