/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hmi.conexiones;


import com.hmi.variables.Mobile;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public abstract class BDMobile {

    public static void insertarUsuario(Mobile u) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("insert into usermobile (ci,idperson,pass,estado) values (?,?,?,?)");
        ps.setString(1, u.getCi());
        ps.setInt(2, u.getIdPerson());
        ps.setString(3, u.getPass());
        ps.setString(4, u.getEstado());
       
        ps.executeUpdate();
        cnn.close();
        ps.close();
    }
    
    public static Mobile buscarUsuario(int codigo) throws SQLException {
        return buscarUsuario("select pa.idperson, pa.nomPerson, pa.apePerson, pa.ciPersona, mo.estado, mo.pass from persona as pa inner join usermobile as mo on pa.idperson=mo.idPerson where pa.idperson=" + codigo, null);
    }
    
 
    public static Mobile buscarUsuario(String sql, Mobile u) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (u == null) {
                u = new Mobile() {
                };
            }
            u.setIdPerson(rs.getInt("idperson"));
            u.setNomPerson(rs.getString("nomPerson"));
            u.setApePerson(rs.getString("apePerson"));
            u.setCi(rs.getString("ciPersona"));
            u.setEstado(rs.getString("estado"));
            u.setPass(rs.getString("pass"));
            
        }
        cnn.close();
        ps.close();
        return u;
    }

 
    public static boolean actualizarUsuario(Mobile u) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("update usermobile set ci=?,idPerson=?,pass=?,estado=? where idPerson=" + u.getIdPerson());
        
        ps.setString(1, u.getCi());
        ps.setInt(2, u.getIdPerson());
        ps.setString(3, u.getPass());
        ps.setString(4, u.getEstado());
        int rowsUpdated = ps.executeUpdate();
        cnn.close();
        ps.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }
    
  
    
    

    public static Mobile realizarbusqueda(Mobile u, String sql) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (u == null) {
                u = new Mobile(){};
            }
            //u.setIdUserDesk(rs.getInt("idUserDesk"));
            //u.setcUsuId(rs.getString("cUsuId"));
            //u.setcUsuClave(rs.getString("cUsuClave"));
            //u.setPersonal(BDPersonal.buscarPersonaUsuario(rs.getInt("idPerson")));
            
        }
        cnn.close();
        ps.close();
        return u;
    }

    public static ArrayList<Mobile> mostrarUsuario() throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ArrayList<Mobile> lista = new ArrayList<Mobile>();

        ps = cnn.prepareStatement("select idmobile, ci, idPerson, pass, estado, pass from usermobile;");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Mobile u= new Mobile() {
            };
            u.setIdmobile(rs.getInt("idmobile"));
            u.setCi(rs.getString("ciPersona"));
            u.setIdPerson(rs.getInt("idPerson"));
            u.setNomPerson(rs.getString("nomPerson"));
            u.setApePerson(rs.getString("apePerson"));
            u.setEstado(rs.getString("estado"));
            u.setPass(rs.getString("pass"));
            lista.add(u);
        }
        cnn.close();
        ps.close();
        return lista;
    }

    public static ArrayList<Mobile> listarMobilePorCi(String cedula) {
        return listar("ci", cedula + "%", "like");
    }

    public static ArrayList<Mobile> listarMobilePorNombre(String nombre) {
        return listar("nomPerson", nombre + "%", "like");
    }

    private static ArrayList<Mobile> listar(String atributo, String parametro, String comparador) {
        return consultarSQL("select mo.idmobile,pa.idPerson,pa.nomPerson, pa.apePerson, pa.ciPersona, mo.estado,mo.pass from persona as pa inner join usermobile as mo on pa.idperson=mo.idPerson where " + atributo + " " + comparador + " '" + parametro + "'");
    }

    private static ArrayList<Mobile> consultarSQL(String sql) {
        ArrayList<Mobile> list = new ArrayList<Mobile>();
        Connection cn = BD.getConnection();
        try {
            Mobile u;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                u = new Mobile();
               u.setIdmobile(rs.getInt("idmobile"));
            u.setCi(rs.getString("ciPersona"));
            u.setIdPerson(rs.getInt("idPerson"));
            u.setNomPerson(rs.getString("nomPerson"));
            u.setApePerson(rs.getString("apePerson"));
            u.setEstado(rs.getString("estado"));
            u.setPass(rs.getString("pass"));
                
                list.add(u);
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
        return list;
    }
}