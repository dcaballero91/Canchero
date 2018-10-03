/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hmi.variables;


public class Mobile {

    public int getIdmobile() {
        return idmobile;
    }

    public void setIdmobile(int idmobile) {
        this.idmobile = idmobile;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    private int idmobile;

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }
    private int idPerson;
    private String ci;
    private String pass;
    private String estado;

    public String getCiAux() {
        return ciAux;
    }

    public void setCiAux(String ciAux) {
        this.ciAux = ciAux;
    }
    private String ciAux;

    public String getNomPerson() {
        return nomPerson;
    }

    public void setNomPerson(String nomPerson) {
        this.nomPerson = nomPerson;
    }

    public String getApePerson() {
        return apePerson;
    }

    public void setApePerson(String apePerson) {
        this.apePerson = apePerson;
    }
    private String nomPerson;
    private String apePerson;
    

    
}