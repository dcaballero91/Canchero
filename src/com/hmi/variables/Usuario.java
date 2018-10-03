/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hmi.variables;


public class Usuario {

    public int getIdUserDesk() {
        return idUserDesk;
    }

    public void setIdUserDesk(int idUserDesk) {
        this.idUserDesk = idUserDesk;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public int getiPersonal() {
        return iPersonal;
    }

    public void setiPersonal(int iPersonal) {
        this.iPersonal = iPersonal;
    }

    public String getcUsuId() {
        return cUsuId;
    }

    public void setcUsuId(String cUsuId) {
        this.cUsuId = cUsuId;
    }

    public String getcUsuClave() {
        return cUsuClave;
    }

    public void setcUsuClave(String cUsuClave) {
        this.cUsuClave = cUsuClave;
    }

    public String getcUsuEstado() {
        return cUsuEstado;
    }

    public void setcUsuEstado(String cUsuEstado) {
        this.cUsuEstado = cUsuEstado;
    }

    public int getUseRol() {
        return useRol;
    }

    public void setUseRol(int useRol) {
        this.useRol = useRol;
    }

    private int idUserDesk;
    private int idPerson;
    private int iPersonal;
    private String cUsuId;
    private String cUsuClave;
    private String cUsuEstado;
    private int useRol;
    private String nomPerson;
    private String ip;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
    private String host;

    public Personal getPersonal() {
        return Personal;
    }

    public void setPersonal(Personal Personal) {
        this.Personal = Personal;
    }
    private Personal Personal;

    public String getcPerNombre() {
        return cPerNombre;
    }

    public void setcPerNombre(String cPerNombre) {
        this.cPerNombre = cPerNombre;
    }
    private String cPerNombre;

    

    public String getUsuarioAux() {
        return UsuarioAux;
    }

    public void setUsuarioAux(String UsuarioAux) {
        this.UsuarioAux = UsuarioAux;
    }
    private String UsuarioAux;

    public String getAdmAux() {
        return admAux;
    }

    public void setAdmAux(String admAux) {
        this.admAux = admAux;
    }
    private String admAux;
    public int getIdPaux() {
        return idPaux;
    }

    public void setIdPaux(int idPaux) {
        this.idPaux = idPaux;
    }
    private int idPaux;

    public String getApePerson() {
        return apePerson;
    }

    public void setApePerson(String apePerson) {
        this.apePerson = apePerson;
    }
    private String apePerson;

    public String getNomPerson() {
        return nomPerson;
    }

    public void setNomPerson(String nomPerson) {
        this.nomPerson = nomPerson;
    }
    

    
}