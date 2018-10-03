/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hmi.conexiones;

import com.hmi.variables.Fichas;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public abstract class BDFichas {

    /**
     *
     * @param pv
     * @return
     * @throws SQLException
     * @throws FileNotFoundException
     */
    public static Fichas insertarFichas(Fichas pv ) throws SQLException, FileNotFoundException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("insert into Fichas (nficha,idPerson,seguro,idpadre,idmadre) values (?,?,?,?,?)");
        ps.setInt(1, pv.getNficha());
        ps.setInt(2, pv.getIdperson());
        ps.setString(3, pv.getSeguro());
        ps.setInt(4, pv.getIdpadre());
        ps.setInt(5, pv.getIdmadre());
       
        ps.executeUpdate();
        PreparedStatement ps2 = cnn.prepareStatement("select max(idficha) from Fichas");
        ResultSet r = ps2.executeQuery();
        if (r.next()) {
            int lastID = r.getInt(1);
            pv.setIdficha(lastID);
        }
        ps2.close();
        cnn.close();
        ps.close();
        return pv;
    }
    
 
    

    public static Fichas buscarFichas(int codigo) throws SQLException {
        return buscarFichas("select pa.dirPerson,fi.idficha,fi.nficha,pa.fechaNac, pa.idPerson, pa.nomPerson, pa.apePerson, pa.ciPersona, pa.nacionalidad,fi.seguro, pa.numPerson, pa.sexo, fi.idpadre,fi.idmadre, fi.observ from persona as pa inner join Fichas as fi on pa.idperson=fi.idPerson where fi.nficha=" + codigo, null);
    }

    public static Fichas buscarFichasNombre(String nombre) throws SQLException {
        return buscarFichas("select pa.dirPerson,fi.nficha,pa.fechaNac, pa.idPerson, pa.nomPerson, pa.apePerson, pa.ciPersona, pa.nacionalidad,fi.seguro, pa.numPerson, pa.sexo, fi.idpadre,fi.idmadre from persona as pa inner join Fichas as fi on pa.idperson=fi.idPerson where pa.nomPerson='" + nombre + "'", null);
    }

    public static Fichas buscarFichasNit(int nit) throws SQLException {
        return buscarFichas("select pa.dirPerson,fi.nficha,pa.fechaNac, pa.idPerson, pa.nomPerson, pa.apePerson, pa.ciPersona, pa.nacionalidad,fi.seguro, pa.numPerson, pa.sexo, fi.idpadre,fi.idmadre,fi.observ from persona as pa inner join Fichas as fi on pa.idperson=fi.idPerson where pa.ciPersona=" + nit, null);
    }
    
    public static Fichas buscar(String npadres) throws SQLException {
        return buscarFichas("select pa.dirPerson,fi.nficha,pa.fechaNac, pa.idPerson, pa.nomPerson, pa.apePerson, pa.ciPersona, pa.nacionalidad,fi.seguro, pa.numPerson, pa.sexo, fi.idpadre,fi.idmadre from persona as pa inner join Fichas as fi on pa.idperson=fi.idPerson where pa.ciPersona=" + npadres, null);
    }
    

    public static Fichas buscarFichas(String sql, Fichas pv) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement(sql);
        //ps.setString(1, Ruc);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (pv == null) {
                pv = new Fichas() {
                };
            }
            pv.setDirecc(rs.getString("dirPerson"));
            pv.setIdficha(rs.getInt("idficha"));
            pv.setNficha(rs.getInt("nficha"));
            pv.setFechanac(rs.getString("fechaNac"));
            pv.setIdperson(rs.getInt("idPerson"));
            pv.setNombre(rs.getString("nomPerson"));
            pv.setApellido(rs.getString("apePerson"));
            pv.setCi(rs.getString("ciPersona"));
            pv.setNac(rs.getString("nacionalidad"));
            pv.setSeguro(rs.getString("seguro"));
            pv.setTelefono(rs.getString("numPerson"));
            pv.setSexo(rs.getString("sexo"));
            pv.setNpadre(rs.getInt("idpadre"));
            pv.setNmadre(rs.getInt("idmadre"));
            pv.setObserv(rs.getString("observ"));
        }
        cnn.close();
        ps.close();
        return pv;
    }

   
    public static boolean actualizarFichas(Fichas pv) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;

        ps = cnn.prepareStatement("update Fichas set nficha=?,idPerson=?,seguro=?,idpadre=?,idmadre=?, observ=? where idPerson=" + pv.getIdperson());
       
        ps.setInt(1, pv.getNficha());
        ps.setInt(2, pv.getIdperson());
        ps.setString(3, pv.getSeguro());
        ps.setInt(4, pv.getIdpadre());
        ps.setInt(5, pv.getIdmadre());
        ps.setString(6, pv.getObserv());
        int rowsUpdated = ps.executeUpdate();
        cnn.close();
        ps.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }

   /* public static ArrayList<Fichas> mostrarFichas() throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ArrayList<Fichas> lista = new ArrayList<Fichas>();

        ps = cnn.prepareStatement("select numerofic,fechafic,nombrefic,apellidofic,dnific,direccfic,nacific,segurofic, teleffic,sexofic,obsfic,padreficha from Fichas");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Fichas pv = new Fichas() {
            };
            pv.setnumerofic(rs.getInt(1));
            pv.setfechafic(rs.getDate(2));
            pv.setnombrefic(rs.getString(3));
            pv.setapellidofic(rs.getString(4));
            pv.setdnific(rs.getInt(5));
            pv.setdireccfic(rs.getString(6));
            pv.setnacific(rs.getString(7));
            pv.setsegurofic(rs.getString(8));
            pv.setteleffic(rs.getString(9));
            pv.setsexofic(rs.getString(10));
            pv.setobsfic(rs.getString(11));
            pv.setpadreficha(rs.getString(12));
            lista.add(pv);
        }
        cnn.close();
        ps.close();
        return lista;
    } */

    public static ArrayList<Fichas> listarFichasPorNombre(String nombre) {
        return listar("nomPerson", nombre + "%", "like");
    }
    public static ArrayList<Fichas> listarFichasPorNit(String nit) {
        return listar("ciPersona", nit+ "%", "like");
    }
    public static ArrayList<Fichas> listarFichasPorCodigo(String codigo) {
        return listar("nficha", codigo + "%", "like");
    }

    private static ArrayList<Fichas> listar(String atributo, String parametro, String comparador) {
        return consultarSQL("select fi.nficha,pa.fechaNac, pa.idPerson, pa.nomPerson, pa.apePerson, pa.ciPersona, pa.nacionalidad,fi.seguro, pa.numPerson, pa.sexo, fi.idpadre,fi.idmadre from persona as pa inner join Fichas as fi on pa.idperson=fi.idPerson where " + atributo + " " + comparador + " '" + parametro + "'");
    }

    private static ArrayList<Fichas> consultarSQL(String sql) {
        ArrayList<Fichas> list = new ArrayList<>();
        Connection cn = BD.getConnection();
        try {
            Fichas p;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                p = new Fichas();
                p.setNficha(rs.getInt("nficha"));
                p.setFechanac(rs.getString("fechaNac"));
                p.setIdperson(rs.getInt("idPerson"));
                p.setNombre(rs.getString("nomPerson"));
                p.setApellido(rs.getString("apePerson"));
                p.setCi(rs.getString("ciPersona"));
                p.setNac(rs.getString("nacionalidad"));
                p.setSeguro(rs.getString("seguro"));
                p.setTelefono(rs.getString("numPerson"));
                p.setSexo(rs.getString("sexo"));
                p.setNpadre(rs.getInt("idpadre"));
                p.setNmadre(rs.getInt("idmadre"));
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