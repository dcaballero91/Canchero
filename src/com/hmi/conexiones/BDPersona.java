/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hmi.conexiones;

import com.hmi.variables.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public abstract class BDPersona {

    public static Persona insertarPersona(Persona p) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("insert into persona (nomPerson,apePerson,ciPersona,dirPerson,tipTelefP,numPerson,sexo,nacionalidad, fechaNac) values (?,?,?,?,?,?,?,?,?)");
        ps.setString(1, p.getNomPerson());
        ps.setString(2, p.getApePerson());
        ps.setString(3, p.getCiPersona());
        ps.setString(4, p.getDirPerson());
        ps.setString(5, p.getTipTelefP());
        ps.setString(6, p.getNumPerson());
        ps.setString(7, p.getPersexo());
        ps.executeUpdate();
        PreparedStatement ps2 = cnn.prepareStatement("select max(idPerson) from persona");
        ResultSet r = ps2.executeQuery();
        if (r.next()) {
            int lastID = r.getInt(1);
            p.setIdPerson(lastID);
        }
        ps2.close();
        cnn.close();
        ps.close();
        return p;
    }

    public static Persona buscarPersonaCodigo(int codigo) throws SQLException {
        return buscarPersona("select idPerson,nomPerson,apePerson,ciPersona,dirPerson,tipTelefP,numPerson,sexo,nacionalidad, fechaNac from persona  where idPerson=" + codigo, null);
    }

    public static Persona buscarPersonaCodigoUsiaro(int codigo) throws SQLException {
        return buscarPersona("select idPerson,nomPerson,apePerson,ciPersona,dirPerson,tipTelefP,numPerson,sexo,nacionalidad, fechaNac from persona  where idPerson=" + codigo, null);
    }

    public static Persona buscarPersonaNombre(String nombre) throws SQLException {
        return buscarPersona("select idPerson,nomPerson, apePerson, ciPersona, dirPerson, tipTelefP, numPerson,sexo,nacionalidad, fechaNac from persona where nomPerson='" + nombre + "'", null);
    }

    public static Persona buscarPersonaEstado(String estado) throws SQLException {
        return buscarPersona("select idPerson,nomPerson, apePerson, ciPersona, dirPerson, tipTelefP, numPerson,sexo,nacionalidad, fechaNac from persona inner join usuarioDesk on usuarioDesk.idPerson=persona.idPerson where cUsuEstadoo='" + estado + "'", null);
    }

    public static Persona buscarPersona(String sql, Persona p) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (p == null) {
                p = new Persona() {
                };
            }

            p.setIdPerson(rs.getInt("idPerson"));
            p.setNomPerson(rs.getString("nomPerson"));
            p.setApePerson(rs.getString("apePerson"));
            p.setCiPersona(rs.getString("ciPersona"));
            p.setDirPerson(rs.getString("dirPerson"));
            p.setTipTelefP(rs.getString("tipTelefP"));
            p.setNumPerson(rs.getString("numPerson"));
            p.setPersexo(rs.getString("sexo"));
            p.setNacionalidad(rs.getString("nacionalidad"));
            p.setFechNac(rs.getString("fechaNac"));

        }
        cnn.close();
        ps.close();
        return p;
    }

    public static boolean actualizarPersona(Persona p) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;

        ps = cnn.prepareStatement("update persona set nomPerson=?, apePerson=?, ciPersona=?, dirPerson=?, tipTelefP=?, numPerson=?, sexo=?,nacionalidad=?, fechaNac=? where idPerson=" + p.getIdPerson());
        ps.setString(1, p.getNomPerson());
        ps.setString(2, p.getApePerson());
        ps.setString(3, p.getCiPersona());
        ps.setString(4, p.getDirPerson());
        ps.setString(5, p.getTipTelefP());
        ps.setString(6, p.getNumPerson());
        ps.setString(7, p.getPersexo());
        ps.setString(8, p.getNacionalidad());
        ps.setString(9, p.getFechNac());
        int rowsUpdated = ps.executeUpdate();
        cnn.close();
        ps.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static ArrayList<Persona> mostrarPersona() throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ArrayList<Persona> lista = new ArrayList<Persona>();
        ps = cnn.prepareStatement("select idPerson, nomPerson, apePerson, ciPersona, dirPerson, tipTelefP, numPerson,sexo,nacionalidad, fechaNac from persona;");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Persona p = new Persona() {
            };
            p.setIdPerson(rs.getInt("idPerson"));
            p.setNomPerson(rs.getString("nomPerson"));
            p.setApePerson(rs.getString("apePerson"));
            p.setCiPersona(rs.getString("ciPersona"));
            p.setDirPerson(rs.getString("dirPerson"));
            p.setTipTelefP(rs.getString("tipTelefP"));
            p.setNumPerson(rs.getString("numPerson"));
            p.setPersexo(rs.getString("sexo"));
            p.setNacionalidad(rs.getString("nacionalidad"));
            p.setFechNac(rs.getString("fechaNac"));
            lista.add(p);
        }
        cnn.close();
        ps.close();
        return lista;
    }

    public static ArrayList<Persona> listarPersonaPorNombre(String nombre) {
        return listar("nomPerson", nombre + "%", "like");
    }

    public static ArrayList<Persona> listarPersonaPorCi(String ci) {
        return listar("ciPersona", ci + "%", "like");
    }

    private static ArrayList<Persona> listar(String atributo, String parametro, String comparador) {
        return consultarSQL("select idPerson, nomPerson, apePerson, ciPersona, dirPerson, tipTelefP, numPerson,sexo, nacionalidad, fechaNac from persona where " + atributo + " " + comparador + " '" + parametro + "'");
    }

    private static ArrayList<Persona> consultarSQL(String sql) {
        ArrayList<Persona> list = new ArrayList<Persona>();
        Connection cn = BD.getConnection();
        try {
            Persona p;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                p = new Persona();
                p.setIdPerson(rs.getInt("idPerson"));
                p.setNomPerson(rs.getString("nomPerson"));
                p.setApePerson(rs.getString("apePerson"));
                p.setCiPersona(rs.getString("ciPersona"));
                p.setDirPerson(rs.getString("dirPerson"));
                p.setTipTelefP(rs.getString("tipTelefP"));
                p.setNumPerson(rs.getString("numPerson"));
                p.setPersexo(rs.getString("sexo"));
                p.setNacionalidad(rs.getString("nacionalidad"));
                p.setFechNac(rs.getString("fechaNac"));
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
