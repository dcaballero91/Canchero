/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hmi.conexiones;


import com.hmi.variables.Agenda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public abstract class BDAgenda {

    public static Agenda insertarAgenda(Agenda a) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        
        ps = cnn.prepareStatement("insert into Agenda (idperson,nficha,fechAgenda,estado,tipoCons,Doc,nroAgenda) values (?,?,?,?,?,?,?)");
        ps.setInt(1, a.getIdperson());
        ps.setInt(2,a.getNficha());
        ps.setString(3, a.getFechAgenda());
        ps.setString(4, a.getEstado());
        ps.setString(5, a.getTipoCons());
        ps.setInt(6, a.getDoc());
        ps.setInt(7, a.getIdagenda());
       
        ps.executeUpdate();
        
        cnn.close();
        ps.close();
        return a;
    }

    public static Agenda buscarAgenda(int codigo) throws SQLException {
        return buscarAgenda("select ag.tipoCons,ag.Doc,ag.idagenda,ag.estado,ag.nficha,ag.idperson, pa.nomPerson,pa.apePerson,pa.ciPersona,ag.fechAgenda, pa.sexo, pa.nacionalidad from Agenda as ag inner join persona as pa on ag.idperson=pa.idperson where ag.idagenda=" + codigo, null);
    }

    public static Agenda buscarAgendaFicha(String nficha) throws SQLException {
        return buscarAgenda("select ag.tipoCons,ag.Doc,ag.idagenda,ag.estado,ag.nficha,ag.idperson, pa.nomPerson,pa.apePerson,pa.ciPersona,ag.fechAgenda, pa.sexo, pa.nacionalidad from Agenda as ag inner join persona as pa on ag.idperson=pa.idperson where fi.nficha='" + nficha + "'", null);
    }

    public static Agenda buscarAgendaCI(int ci) throws SQLException {
        return buscarAgenda("select ag.tipoCons,ag.Doc,ag.idagenda,ag.estado,ag.nficha,ag.idperson, pa.nomPerson,pa.apePerson,pa.ciPersona,ag.fechAgenda, pa.sexo, pa.nacionalidad from Agenda as ag inner join persona as pa on ag.idperson=pa.idperson where pa.ciPersona=" + ci, null);
    }
    
    public static boolean actualizarAgenda(Agenda a) throws SQLException {
        Connection cnn = BD.getConnection();
        
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("update Agenda set idperson=?,nficha=?,fechAgenda=?, estado=?,tipoCons=?,Doc=? where idagenda=" + a.getIdagenda());
        ps.setInt(1, a.getIdperson());
        ps.setInt(2, a.getNficha());
        ps.setString(3, a.getFechAgenda());
        ps.setString(4, a.getEstado());
        ps.setString(5, a.getTipoCons());
        ps.setInt(6, a.getDoc());
        int rowsUpdated = ps.executeUpdate();
        cnn.close();
        ps.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }
    
    
    public static boolean actualizarEstado(Agenda a) throws SQLException {
        Connection cnn = BD.getConnection();
        
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("update  Agenda  set estado='C' where nficha=" + a.getNficha());
        System.out.println(ps);
        int rowsUpdated = ps.executeUpdate();
        cnn.close();
        ps.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }
    
   

    public static Agenda buscarAgenda(String sql, Agenda a) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement(sql);
       
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (a == null) {
                a = new Agenda() {
                };
            }
                a.setIdagenda(rs.getInt("idagenda"));
                System.out.println(rs.getInt("idagenda"));
                a.setNficha(rs.getInt("nficha"));
                System.out.println(rs.getInt("nficha"));
                System.out.println(rs.getInt("idperson"));
                a.setIdperson(rs.getInt("idperson"));
                a.setNombre(rs.getString("nomPerson"));
                System.out.println(rs.getString("nomPerson"));
                a.setApellido(rs.getString("apePerson"));
                System.out.println(rs.getString("apePerson"));
                a.setFechAgenda(rs.getString("fechAgenda"));
                System.out.println(rs.getString("fechAgenda"));
                a.setCi(rs.getString("ciPersona"));
                System.out.println(rs.getString("ciPersona"));
                a.setEstado(rs.getString("estado"));
                System.out.println(rs.getString("estado"));
                a.setTipoCons(rs.getString("tipoCons"));
                System.out.println(rs.getString("tipoCons"));
                a.setDoc(rs.getInt("Doc"));
                System.out.println(rs.getString("Doc"));
                
            
        }
        cnn.close();
        ps.close();
        return a;
    }

   
    

    public static ArrayList<Agenda> mostrarAgenda() throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ArrayList<Agenda> lista = new ArrayList<Agenda>();

        ps = cnn.prepareStatement("select ag.nficha,ag.idperson, pa.nomPerson,pa.apePerson,pa.ciPersona,ag.fechAgenda, pa.sexo, pa.nacionalidad from Agenda as ag inner join persona as pa on ag.idperson=pa.idperson");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Agenda a = new Agenda() {
            };
            a.setNficha(rs.getInt(1));
            a.setIdperson(rs.getInt(2));
            a.setNombre(rs.getString(3));
            a.setApellido(rs.getString(4));
            a.setCi(rs.getString(5));
            a.setFechAgenda(rs.getString(6));
            a.setEstado(rs.getString(7));
            
            lista.add(a);
        }
        cnn.close();
        ps.close();
        return lista; 
    }

     public static ArrayList<Agenda> listarAgendaPorNficha(String nficha) {
        return listar("nficha", nficha + "%", "like");
    }
    public static ArrayList<Agenda> listarAgendaPorNit(String nit) {
        return listar("fechAgenda", nit+ "%", "like");
    }
    public static ArrayList<Agenda> listarAgendaPorCodigo(String codigo) {
        return listar("ciPersona", codigo + "%", "like");
    }
    
     public static ArrayList<Agenda> listarAgendaPorNombre(String nombre) {
        return listar("nomPerson", nombre + "%", "like");
    }
    
    
    public static ArrayList<Agenda> listarAgendaPorEstado(String estado) {
        return listar("estado", estado + "%", "like");
    }

    private static ArrayList<Agenda> listar(String atributo, String parametro, String comparador) {
        return consultarSQL("select ag.tipoCons,ag.Doc,ag.idagenda,ag.estado,ag.nficha,ag.idperson, pa.nomPerson,pa.apePerson,pa.ciPersona,ag.fechAgenda, pa.sexo, pa.nacionalidad from Agenda as ag inner join persona as pa on ag.idperson=pa.idperson where " + atributo + " " + comparador + " '" + parametro + "' and estado = 'P'");
    }

    private static ArrayList<Agenda> consultarSQL(String sql) {
        ArrayList<Agenda> list = new ArrayList<>();
        Connection cn = BD.getConnection();
        try {
            Agenda a;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                a = new Agenda();
                
                a.setIdagenda(rs.getInt("idagenda"));
                System.out.println(rs.getInt("idagenda"));
                a.setNficha(rs.getInt("nficha"));
                System.out.println(rs.getInt("nficha"));
                System.out.println(rs.getInt("idperson"));
                a.setIdperson(rs.getInt("idperson"));
                a.setNombre(rs.getString("nomPerson"));
                System.out.println(rs.getString("nomPerson"));
                a.setApellido(rs.getString("apePerson"));
                System.out.println(rs.getString("apePerson"));
                a.setFechAgenda(rs.getString("fechAgenda"));
                System.out.println(rs.getString("fechAgenda"));
                a.setCi(rs.getString("ciPersona"));
                System.out.println(rs.getString("ciPersona"));
                a.setEstado(rs.getString("estado"));
                System.out.println(rs.getString("estado"));
                a.setTipoCons(rs.getString("tipoCons"));
                System.out.println(rs.getString("tipoCons"));
                a.setDoc(rs.getInt("Doc"));
                System.out.println(rs.getString("Doc"));
                
                
                list.add(a);
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
        return list;
    }

    
}