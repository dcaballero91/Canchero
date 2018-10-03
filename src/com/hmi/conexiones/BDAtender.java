/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hmi.conexiones;

import com.hmi.variables.Atender;
import com.hmi.variables.PreConsulta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public abstract class BDAtender {

    public static Atender insertarAtender(Atender pv) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        
        ps = cnn.prepareStatement("insert into Atender (nficha,fecha,usuario,sintomas,diagnosticos,tipoconsulta) values (?,?,?,?,?,?)");
        ps.setInt(1,pv.getnficha());
        ps.setString(2, pv.getfecha());
        ps.setString(3, pv.getusuario());
        ps.setString(4, pv.getsintomas());
        ps.setString(5, pv.getdiagnosticos());
        ps.setString(6, pv.getTipoconsulta());
        ps.executeUpdate();
        
        cnn.close();
        ps.close();
        return pv;
    }

    public static Atender buscarAtender(int codigo) throws SQLException {
        return buscarAtender("select nficha,fecha,nombre,temperatura,ta,peso,usuario,sintomas,diagnosticos from Atender where nficha=" + codigo, null);
    }

    public static Atender buscarAtenderNombre(String nombre) throws SQLException {
        return buscarAtender("select nficha,fecha,nombre,temperatura,ta,peso,usuario,sintomas,diagnosticos from Atender where nombre='" + nombre + "'", null);
    }

    public static Atender buscarAtenderNit(int nit) throws SQLException {
        return buscarAtender("select nficha,fecha,nombre,temperatura,ta,peso,usuario,sintomas,diagnosticos from Atender where fecha=" + nit, null);
    }

    public static Atender buscarAtender(String sql, Atender pv) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement(sql);
        
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (pv == null) {
                pv = new Atender() {
                };
            }
            pv.setnficha(rs.getInt("nficha"));
            pv.setfecha(rs.getString("fecha"));
            pv.setnombre(rs.getString("nombre"));
            
            pv.settemperatura(rs.getDouble("temperatura"));
            pv.setta(rs.getDouble("ta"));
            pv.setpeso(rs.getDouble("peso"));
            pv.setusuario(rs.getString("usuario"));
            pv.setsintomas(rs.getString("sintomas")); 
            pv.setdiagnosticos(rs.getString("diagnosticos"));
        }
        cnn.close();
        ps.close();
        return pv;
    }

   
    

    public static ArrayList<Atender> mostrarAtender() throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ArrayList<Atender> lista = new ArrayList<Atender>();

        ps = cnn.prepareStatement("select nficha,fecha,nombre,temperatura,ta,peso,usuario,sintomas,diagnosticos from Atender");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Atender pv = new Atender() {
            };
            pv.setnficha(rs.getInt(1));
            pv.setfecha(rs.getString(2));
            pv.setnombre(rs.getString(3));
            
            pv.settemperatura(rs.getDouble(4));
            pv.setta(rs.getDouble(5));
            pv.setpeso(rs.getDouble(6));
            pv.setusuario(rs.getString(7));
            pv.setsintomas(rs.getString(8));
            pv.setdiagnosticos(rs.getString(9));
            lista.add(pv);
        }
        cnn.close();
        ps.close();
        return lista;
    }

    public static ArrayList<Atender> listarAtenderPorNombre(String nombre) {
        return listar("nombre", nombre + "%", "like");
    }
    public static ArrayList<Atender> listarAtenderPorNit(String nit) {
        return listar("fecha", nit+ "%", "like");
    }
    public static ArrayList<Atender> listarAtenderPorCodigo(String codigo) {
        return listar("nficha", codigo + "%", "like");
    }

    private static ArrayList<Atender> listar(String atributo, String parametro, String comparador) {
        return consultarSQL("select nficha,fecha,nombre,temperatura,ta,peso,usuario,sintomas,diagnosticos from Atender where " + atributo + " " + comparador + " '" + parametro + "'");
    }

    private static ArrayList<Atender> consultarSQL(String sql) {
        ArrayList<Atender> list = new ArrayList<>();
        Connection cn = BD.getConnection();
        try {
            Atender p;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                p = new Atender();
                p.setnficha(rs.getInt("nficha"));
                p.setfecha(rs.getString("fecha"));
                p.setnombre(rs.getString("nombre"));
                
                p.settemperatura(rs.getDouble("temperatura"));
                p.setta(rs.getDouble("ta"));
                p.setpeso(rs.getDouble("peso"));
                p.setusuario(rs.getString("usuario"));
                p.setsintomas(rs.getString("sintomas"));
                p.setdiagnosticos(rs.getString("diagnosticos"));
                
                
                list.add(p);
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return null;
        }
        return list;
    }
    
     public static ArrayList<PreConsulta> mostrarPreConsulta() throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ArrayList<PreConsulta> lista = new ArrayList<PreConsulta>();

        ps = cnn.prepareStatement("select  nficha,idagenda ,fecha, nombre, temperatura, ta, peso, usuario,tipoconsulta from PreConsulta");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            PreConsulta pv = new PreConsulta() {
            };
            pv.setnficha(rs.getInt(1));
            pv.setIdagenda(rs.getInt(2));
            pv.setfecha(rs.getString(3));
            pv.setnombre(rs.getString(4));            
            pv.settemperatura(rs.getDouble(5));
            pv.setta(rs.getDouble(6));
            pv.setpeso(rs.getDouble(7));
            pv.setusuario(rs.getString(8));
            pv.setTipoconsulta(rs.getString(9));
            lista.add(pv);
        }
        cnn.close();
        ps.close();
        return lista;
    }

    public static ArrayList<PreConsulta> listarPreConsultaPorTipo(String dato) {
        System.out.println("recivido para select   :" + dato);
        return listarc("tipoconsulta", dato+ "%", "like");
    }
    public static ArrayList<PreConsulta> listarPreConsultaPorNit(String nit) {
        return listarc("fecha", nit+ "%", "like");
    }
    public static ArrayList<PreConsulta> listarPreConsultaPorCodigo(String codigo) {
        return listarc("nficha", codigo + "%", "like");
    }

    private static ArrayList<PreConsulta> listarc(String atributoc, String parametroc, String comparadorc) {
        
        return consultarSQLC("select idprecons, idagenda, nficha,fecha, nombre,  temperatura, ta, peso,usuario, tipoconsulta from PreConsulta where " + atributoc + " " + comparadorc + " '" + parametroc + "' and estado = 'C'");
    }


    private static ArrayList<PreConsulta> consultarSQLC(String sql) {
        ArrayList<PreConsulta> list = new ArrayList<>();
        Connection cn = BD.getConnection();
        try {
            PreConsulta p;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                p = new PreConsulta();
                p.setnficha(rs.getInt("nficha"));
                p.setIdagenda(rs.getInt("idagenda"));
                p.setfecha(rs.getString("fecha"));
                p.setnombre(rs.getString("nombre"));
                p.settemperatura(rs.getDouble("temperatura"));
                p.setta(rs.getDouble("ta"));
                p.setpeso(rs.getDouble("peso"));
                p.setusuario(rs.getString("usuario"));
                p.setTipoconsulta(rs.getString("tipoconsulta"));
                
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