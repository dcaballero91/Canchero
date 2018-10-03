/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hmi.conexiones;

import com.hmi.variables.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public abstract class BDUsuario {

    public static void insertarUsuario(Usuario u) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("insert into usuarioDesk (idPerson,cUsuId,cUsuClave,cUsuEstado,useRol) values (?,?,?,?,?)");
        ps.setInt(1, u.getIdPerson());
        ps.setString(2, u.getcUsuId());
        ps.setString(3, u.getcUsuClave());
        ps.setString(4, u.getcUsuEstado());
        ps.setInt(5, u.getUseRol());
        ps.executeUpdate();
        cnn.close();
        ps.close();
    }
    
    
    public static void insertarLogin(Usuario u) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("insert into sessionDesk (cUsuId,idPerson,ip,host,fecha,hora) values (?,?,?,?,CURDATE(),CURTIME())");
        ps.setString(1, u.getcUsuId());
        ps.setInt(2, u.getIdPerson());
        ps.setString(3, u.getIp());
        ps.setString(4, u.getHost());
        
        ps.executeUpdate();
        cnn.close();
        ps.close();
    }
    public static Usuario buscarUsuario(int codigo) throws SQLException {
        return buscarUsuario("select idUserDesk,ud.idPerson, ud.cUsuId, ud.cUsuEstado, ud.useRol,pa.nomPerson,pa.apePerson,ud.cUsuClave from usuarioDesk as ud inner join persona as pa on ud.idPerson=pa.idPerson where idUserDesk=" + codigo, null);
    }
    
    public static Usuario buscarUsuarioCi(String ci) throws SQLException {
        return buscarUsuario("select  idUserDesk,idPerson,cUsuClave,cUsuEstado,useRol from usuarioDesk where cUsuId=" + ci, null);
    }
    
    public static Usuario buscarUsuarioNombre(String nombre) throws SQLException {
        return buscarUsuario("select  idUserDesk,idPerson,cUsuClave,cUsuEstado,useRol from usuarioDesk where cUsuId=" + nombre, null);
    }

    public static Usuario buscarUsuario(String sql, Usuario u) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (u == null) {
                u = new Usuario() {
                };
            }
            u.setIdPerson(rs.getInt("idPerson"));
            u.setIdUserDesk(rs.getInt("idUserDesk"));
            u.setcUsuId(rs.getString("cUsuId"));
            u.setcUsuClave(rs.getString("cUsuClave"));
            u.setcUsuEstado(rs.getString("cUsuEstado"));
            u.setUseRol(rs.getInt("useRol"));
            u.setNomPerson(rs.getString("nomPerson"));
            u.setApePerson(rs.getString("apePerson"));
            u.setPersonal(BDPersonal.buscarPersonaUsuario(rs.getInt("idPerson")));
        }
        cnn.close();
        ps.close();
        return u;
    }

 
    public static boolean actualizarUsuario(Usuario u) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("update usuarioDesk set idPerson=?,cUsuId=?,cUsuClave=?,cUsuEstado=?,useRol=?,cUsuClave=? where idUserDesk=" + u.getIdUserDesk());
        ps.setInt(1, u.getIdPerson());
        ps.setString(2, u.getcUsuId());
        ps.setString(3, u.getcUsuClave());
        ps.setString(4, u.getcUsuEstado());
        ps.setInt(5, u.getUseRol());
        ps.setString(6, u.getcUsuClave());
        int rowsUpdated = ps.executeUpdate();
        cnn.close();
        ps.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public static Usuario login(String usuario, String encriptMD5) throws SQLException {
        return realizarbusqueda(null,"select idUserDesk,idPerson,cUsuId,cUsuClave,cUsuEstado,useRol from usuarioDesk where cUsuId='"+usuario+"' and cUsuClave='"+encriptMD5+"'");
    }
    
    

    public static Usuario realizarbusqueda(Usuario u, String sql) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (u == null) {
                u = new Usuario(){};
            }
            u.setIdUserDesk(rs.getInt("idUserDesk"));
            u.setcUsuId(rs.getString("cUsuId"));
            u.setcUsuClave(rs.getString("cUsuClave"));
            u.setPersonal(BDPersonal.buscarPersonaUsuario(rs.getInt("idPerson")));
            
        }
        cnn.close();
        ps.close();
        return u;
    }

    public static ArrayList<Usuario> mostrarUsuario() throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ArrayList<Usuario> lista = new ArrayList<Usuario>();

        ps = cnn.prepareStatement("select idUserDesk idPerson,cUsuId,cUsuClave,cUsuEstado,useRol from usuarioDesk;");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Usuario u = new Usuario() {
            };
            u.setIdUserDesk(rs.getInt("idUserDesk"));
            u.setIdPerson(rs.getInt("idPerson"));
            u.setcUsuId(rs.getString("cUsuId"));
            u.setcUsuClave(rs.getString("cUsuClave"));
            u.setcUsuEstado(rs.getString("cUsuEstado"));
            u.setUseRol(rs.getInt("useRol"));
            lista.add(u);
        }
        cnn.close();
        ps.close();
        return lista;
    }

    public static ArrayList<Usuario> listarUsuarioPorCi(String cedula) {
        return listar("ciPersona", cedula + "%", "like");
    }

    public static ArrayList<Usuario> listarUsuarioPorNombre(String nombre) {
        return listar("nomPerson", nombre + "%", "like");
    }

    private static ArrayList<Usuario> listar(String atributo, String parametro, String comparador) {
        return consultarSQL("select idUserDesk,ud.idPerson, ud.cUsuId, ud.cUsuEstado, ud.useRol,pa.nomPerson,pa.apePerson from usuarioDesk as ud inner join persona as pa on ud.idPerson=pa.idPerson where " + atributo + " " + comparador + " '" + parametro + "'");
    }

    private static ArrayList<Usuario> consultarSQL(String sql) {
        ArrayList<Usuario> list = new ArrayList<Usuario>();
        Connection cn = BD.getConnection();
        try {
            Usuario u;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                u = new Usuario();
                u.setIdPerson(rs.getInt("idPerson"));
                u.setIdUserDesk(rs.getInt("idUserDesk"));
                u.setcUsuId(rs.getString("cUsuId"));
                u.setcUsuEstado(rs.getString("cUsuEstado"));
                u.setUseRol(rs.getInt("useRol"));
                u.setNomPerson(rs.getString("nomPerson"));
                u.setApePerson(rs.getString("apePerson"));
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