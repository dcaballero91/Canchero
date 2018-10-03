/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionBD;

import ComponenteClase.Remedios;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public abstract class BDRemedios {

    /**
     *
     * @param pv
     * @return
     * @throws SQLException
     * @throws FileNotFoundException
     */
    public static Remedios insertarRemedios(Remedios pv ) throws SQLException, FileNotFoundException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("insert into Remedios (nombre,categ,descr,estado) values (?,?,?,?)");
        ps.setString(1, pv.getnombre());
        ps.setString(2, pv.getcateg());
        ps.setString(3, pv.getdescr());
        ps.setString(4, pv.getestado());
        ps.executeUpdate();
        PreparedStatement ps2 = cnn.prepareStatement("select max(id) from Remedios");
        ResultSet r = ps2.executeQuery();
        if (r.next()) {
            int lastID = r.getInt(1);
            pv.setid(lastID);
        }
        ps2.close();
        cnn.close();
        ps.close();
        return pv;
    }
    
 
    

    public static Remedios buscarRemedios(int codigo) throws SQLException {
        return buscarRemedios("select id,nombre,categ,descr,estado from Remedios where id=" + codigo, null);
    }

    public static Remedios buscarRemediosNombre(String nombre) throws SQLException {
        return buscarRemedios("select id,nombre,categ,descr,estado from Remedios where nombre='" + nombre + "'", null);
    }

    public static Remedios buscarRemediosNit(int nit) throws SQLException {
        return buscarRemedios("select id,nombre,categ,descr,estado from Remedios where categ=" + nit, null);
    }

    public static Remedios buscarRemedios(String sql, Remedios pv) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement(sql);
        //ps.setString(1, Ruc);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (pv == null) {
                pv = new Remedios() {
                };
            }
            pv.setid(rs.getInt("id"));
            pv.setnombre(rs.getString("nombre"));
            pv.setcateg(rs.getString("categ"));
            pv.setdescr(rs.getString("descr"));
            pv.setestado(rs.getString("estado"));
        }
        cnn.close();
        ps.close();
        return pv;
    }

   
    public static boolean actualizarRemedios(Remedios p) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;

        ps = cnn.prepareStatement("update Remedios set nombre=?,categ=?,descr=?,estado=? where id=" + p.getid());
        ps.setString(1, p.getnombre());
        ps.setString(2, p.getcateg());
        ps.setString(3, p.getdescr());
        ps.setString(4, p.getestado());
        int rowsUpdated = ps.executeUpdate();
        cnn.close();
        ps.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static ArrayList<Remedios> mostrarRemedios() throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ArrayList<Remedios> lista = new ArrayList<Remedios>();

        ps = cnn.prepareStatement("select id,nombre,categ,descr,estado from Remedios");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Remedios pv = new Remedios() {
            };
            pv.setid(rs.getInt(1));
            pv.setnombre(rs.getString(2));
            pv.setcateg(rs.getString(3));
            pv.setdescr(rs.getString(4));
            pv.setestado(rs.getString(5));
            lista.add(pv);
        }
        cnn.close();
        ps.close();
        return lista;
    }

    public static ArrayList<Remedios> listarRemediosPorNombre(String nombre) {
        return listar("nombre", nombre + "%", "like");
    }
    public static ArrayList<Remedios> listarRemediosPorNit(String nit) {
        return listar("categ", nit+ "%", "like");
    }
    public static ArrayList<Remedios> listarRemediosPorCodigo(String codigo) {
        return listar("id", codigo + "%", "like");
    }

    private static ArrayList<Remedios> listar(String atributo, String parametro, String comparador) {
        return consultarSQL("select id,nombre,categ,descr,estado from Remedios where " + atributo + " " + comparador + " '" + parametro + "'");
    }

    private static ArrayList<Remedios> consultarSQL(String sql) {
        ArrayList<Remedios> list = new ArrayList<>();
        Connection cn = BD.getConnection();
        try {
            Remedios p;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                p = new Remedios();
                p.setid(rs.getInt("id"));
                p.setnombre(rs.getString("nombre"));
                p.setcateg(rs.getString("categ"));
                p.setdescr(rs.getString("descr"));
                p.setestado(rs.getString("estado"));
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