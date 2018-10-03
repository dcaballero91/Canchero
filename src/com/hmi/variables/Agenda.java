/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hmi.variables;

/**
 *
 * @author dcaballe
 */
public class Agenda {

    private int idagenda;
    private int nficha;
    private String fechAgenda;
    private String estado;
    private String nombre;
    private String apellido;
    private String ci;
    private String tipoCons;
    private int Doc;
    private int idagaux;
    private String tipoconsulta;

    public int getNroAgenda() {
        return nroAgenda;
    }

    public void setNroAgenda(int nroAgenda) {
        this.nroAgenda = nroAgenda;
    }
    private int nroAgenda;

    public String getTipoconsulta() {
        return tipoconsulta;
    }

    public void setTipoconsulta(String tipoconsulta) {
        this.tipoconsulta = tipoconsulta;
    }
    
    public int getIdagaux() {
        return idagaux;
    }

    public void setIdagaux(int idagaux) {
        this.idagaux = idagaux;
    }
    

    public String getTipoCons() {
        return tipoCons;
    }

    public void setTipoCons(String tipoCons) {
        this.tipoCons = tipoCons;
    }

    public int getDoc() {
        return Doc;
    }

    public void setDoc(int Doc) {
        this.Doc = Doc;
    }
    

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }
    
    public int getIdagenda() {
        return idagenda;
    }

    public void setIdagenda(int idagenda) {
        this.idagenda = idagenda;
    }

    public int getNficha() {
        return nficha;
    }

    public void setNficha(int nficha) {
        this.nficha = nficha;
    }

    public String getFechAgenda() {
        return fechAgenda;
    }

    public void setFechAgenda(String fechAgenda) {
        this.fechAgenda = fechAgenda;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    

    public int getIdperson() {
        return idperson;
    }

    public void setIdperson(int idperson) {
        this.idperson = idperson;
    }
    private int idperson;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    
}
