/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hmi.conexiones;


import com.hmi.variables.Mobile;
import com.hmi.variables.SMS;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public abstract class BDSMS {

    public static void insertarSMS(SMS s) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("insert into smsdesk (numCel,text,fecha_int) values (?,?,CURDATE())");
        ps.setString(1, s.getNumCel());
        ps.setString(2, s.getTexto());
        
       
        ps.executeUpdate();
        cnn.close();
        ps.close();
    }
    
    public static SMS buscarSMSCodigo(int codigo) throws SQLException {
        return buscarSMSCodigo("select idsms, numCel, text, fecha_int from smsdesk where=" + codigo, null);
    }
    
    
    
 
    public static SMS buscarSMSCodigo(String sql, SMS s) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (s == null) {
                s = new SMS() {
                };
            }
            s.setIdsms(rs.getInt("idsms"));
            s.setNumCel(rs.getString("numCel"));
            s.setTexto(rs.getString("text"));
            s.setFecha_int(rs.getString("fecha_int"));
            
            
        }
        cnn.close();
        ps.close();
        return s;
    }

 
 
    
  
    
    

    

    public static ArrayList<SMS> mostrarSMS() throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ArrayList<SMS> lista = new ArrayList<SMS>();

        ps = cnn.prepareStatement("select idsms, numCel, text, fecha_int from smsdesk");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            SMS s= new SMS() {
            };
            s.setIdsms(rs.getInt("idsms"));
            s.setNumCel(rs.getString("numCel"));
            s.setTexto(rs.getString("text"));
            s.setFecha_int(rs.getString("fecha_int"));
            lista.add(s);
        }
        cnn.close();
        ps.close();
        return lista;
    }

    public static ArrayList<SMS> listarSMSporNumero(String numero) {
        return listar("numCel", numero + "%", "like");
    }

    public static ArrayList<SMS> listarSMSPorFecha(String fecha) {
        return listar("fecha_int", fecha + "%", "like");
    }

    private static ArrayList<SMS> listar(String atributo, String parametro, String comparador) {
        return consultarSQL("select idsms, numCel, text, fecha_int from smsdesk where " + atributo + " " + comparador + " '" + parametro + "'");
    }

    private static ArrayList<SMS> consultarSQL(String sql) {
        ArrayList<SMS> list = new ArrayList<SMS>();
        Connection cn = BD.getConnection();
        try {
            SMS s;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
            s = new SMS();
            s.setIdsms(rs.getInt("idsms"));
            s.setNumCel(rs.getString("numCel"));
            s.setTexto(rs.getString("text"));
            s.setFecha_int(rs.getString("fecha_int"));
            
                
                list.add(s);
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
        return list;
    }
}