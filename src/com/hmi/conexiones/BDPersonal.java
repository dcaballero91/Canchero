/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hmi.conexiones;

import com.hmi.variables.Personal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public abstract class BDPersonal {

    public static Personal insertarPersonal(Personal p) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("insert into personal (nPerCodigo,idPerson,tipoPerson) values (?,?,?)");
        ps.setString(1, p.getnPerCodigo());
        ps.setInt(2, p.getIdPerson());
        ps.setString(3, p.getTipoPerson());
        ps.executeUpdate();
        PreparedStatement ps2 = cnn.prepareStatement("select max(iPersonal) from personal");
        ResultSet r = ps2.executeQuery();
        if (r.next()) {
            int lastID = r.getInt(1);
            p.setiPersonal(lastID);
        }
        ps2.close();
        cnn.close();
        ps.close();
        return p;
    }

    public static Personal buscarPersonalCodigo(int codigo) throws SQLException {
        return buscarPersonal("select pa.idPerson,ps.iPersonal,nomPerson, ciPersona, apePerson, dirPerson, tipTelefP, numPerson,ps.tipoPerson,nPerCodigo from persona as pa inner join personal as ps on pa.idPerson=ps.idPerson where ps.iPersonal=" + codigo, null);
    }
    
    

    public static Personal buscarPersonalNombre(String nombre) throws SQLException {
        return buscarPersonal("select iPersonal,nomPerson, ciPersona, apePerson, dirPerson, tipTelefP, numPerson,ps.tipoPerson,nPerCodigo from persona as pa inner join personal as ps on pa.idPerson=ps.idPerson where pa.nomPerson='" + nombre+"'", null);
    }

    public static Personal buscarPersonalEstado(String estado) throws SQLException {
        return buscarPersonal("select iPersonal,nomPerson, ciPersona, apePerson, tipTelefP, numPerson,tipoPerson,nPerCodigo from personal inner join usuarioDesk on personal.idperson=usuarioDesk.idPerson where cUsuEstado='" + estado+"'", null);
    }

    
     public static Personal buscarPersonaUsuario(int codigo) throws SQLException {
        return buscarPersonalUsuario("select idPerson,nomPerson,apePerson,ciPersona,dirPerson,tipTelefP,numPerson,sexo from persona where idPerson=" + codigo, null);
    }
    public static Personal buscarPersonal(String sql, Personal p) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement(sql);
        
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (p == null) {
                p = new Personal() {
                };
            }
            p.setIdPerson(rs.getInt("idPerson"));
            p.setiPersonal(rs.getInt("iPersonal"));
            p.setNomPerson(rs.getString("nomPerson"));
            p.setCiPersonal(rs.getString("ciPersona"));
            p.setApePerson(rs.getString("apePerson"));
            p.setPerCodigo(rs.getString("nPerCodigo"));
            p.setTipoPerson(rs.getString("TipoPerson"));
            p.setcPerNombre(rs.getString("nomPerson"));
            
        }
        cnn.close();
        ps.close();
        return p;
    }
    
    public static Personal buscarPersonalUsuario(String sql, Personal p) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement(sql);
        
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (p == null) {
                p = new Personal() {
                };
            }
            p.setIdPerson(rs.getInt("idPerson"));
            p.setNomPerson(rs.getString("nomPerson"));
            p.setCiPersonal(rs.getString("ciPersona"));
            p.setApePerson(rs.getString("apePerson"));
       
            
        }
        cnn.close();
        ps.close();
        return p;
    }

   
    public static boolean actualizarPersonal(Personal p) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;

        ps = cnn.prepareStatement("update personal set nPerCodigo=?, idPerson=?, tipoPerson=? where iPersonal=" + p.getiPersonal());
        ps.setString(1, p.getnPerCodigo());
        ps.setInt(2, p.getIdPerson());
        ps.setString(3, p.getTipoPerson());
        int rowsUpdated = ps.executeUpdate();
        cnn.close();
        ps.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static ArrayList<Personal> mostrarPersonal() throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ArrayList<Personal> lista = new ArrayList<Personal>();
        ps = cnn.prepareStatement("select ps.iPersonal,nomPerson, ciPersona, apePerson, dirPerson, tipTelefP, numPerson,tipoPerson,nPerCodigo from persona as pa inner join personal as ps on pa.idPerson=ps.idPerson;");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Personal p = new Personal() {
            };
            p.setiPersonal(rs.getInt("iPersonal"));
            p.setNomPerson(rs.getString("nomPerson"));
            p.setApePerson(rs.getString("apePerson"));
            p.setCiPersonal(rs.getString("ciPersona"));
            p.setPerCodigo(rs.getString("nPerCodigo"));
            p.setTipoPerson(rs.getString("tipoPerson"));
            lista.add(p);
        }
        cnn.close();
        ps.close();
        return lista;
    }

    public static ArrayList<Personal> listarPersonalPorNombre(String nombre) {
        return listar("nomPerson", nombre + "%", "like");
    }

    public static ArrayList<Personal> listarPersonalPorCi(String ci) {
        return listar("ciPersona", ci + "%", "like");
    }

    private static ArrayList<Personal> listar(String atributo, String parametro, String comparador) {
        return consultarSQL("select ps.iPersonal,nomPerson, ciPersona, apePerson, dirPerson, tipTelefP, numPerson,tipoPerson,nPerCodigo from persona as pa inner join personal as ps on pa.idPerson=ps.idPerson where " + atributo + " " + comparador + " '" + parametro + "'");
    }

    private static ArrayList<Personal> consultarSQL(String sql) {
        ArrayList<Personal> list = new ArrayList<Personal>();
        Connection cn = BD.getConnection();
        try {
            Personal p;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                p = new Personal();
                p.setiPersonal(rs.getInt("iPersonal"));
                p.setNomPerson(rs.getString("nomPerson"));
                p.setApePerson(rs.getString("apePerson"));
                p.setCiPersonal(rs.getString("ciPersona"));
                p.setPerCodigo(rs.getString("nPerCodigo"));
                p.setTipoPerson(rs.getString("tipoPerson"));
           
                list.add(p);
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
        return list;
    }
}