/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionBD;

import ComponenteClase.Viaticos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public abstract class BDViaticos {

    public static Viaticos insertarViaticos(Viaticos pv) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement("insert into viaticos (idvia,fecha,numero,nombre,observacion,destino,inicio,fin,movil,acom) values (?,?,?,?,?,?,?,?,?,?)");

        ps.setInt(1, pv.getidvia());
        ps.setString(2, pv.getfecha());
        ps.setInt(3, pv.getnumero());
        ps.setString(4, pv.getnombre());
        ps.setString(5, pv.getobservacion());
        ps.setString(6, pv.getdestino());
        ps.setString(7, pv.getinicio());
        ps.setString(8, pv.getfin());
        ps.setString(9, pv.getmovil());
        ps.setString(10,pv.getacom());
        ps.executeUpdate();
        PreparedStatement ps2 = cnn.prepareStatement("select max(idvia) from viaticos");
        ResultSet r = ps2.executeQuery();
        if (r.next()) {
            int lastID = r.getInt(1);
            pv.setidvia(lastID);
        }
        ps2.close();
        cnn.close();
        ps.close();
        return pv;
    }

    public static Viaticos buscarViaticos(int codigo) throws SQLException {
        return buscarViaticos("select idvia,fecha,numero,nombre,observacion,destino,inicio,fin,movil,acom from viaticos where idvia=" + codigo, null);
    }

    public static Viaticos buscarViaticosNombre(String nombre) throws SQLException {
        return buscarViaticos("select idvia,fecha,numero,nombre,observacion,destino,inicio,fin,movil,acom from viaticos where nombre='" + nombre + "'", null);
    }

    public static Viaticos buscarViaticosNit(int nit) throws SQLException {
        return buscarViaticos("select idvia,fecha,numero,nombre,observacion,destino,inicio,fin,movil,acom from viaticos where numero=" + nit, null);
    }

    public static Viaticos buscarViaticos(String sql, Viaticos pv) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement(sql);
        //ps.setString(1, Ruc);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (pv == null) {
                pv = new Viaticos() {
                };
            }
            pv.setidvia(rs.getInt("idvia"));
            pv.setfecha(rs.getString("fecha"));
            pv.setnumero(rs.getInt("numero"));
            pv.setnombre(rs.getString("nombre"));
            pv.setobservacion(rs.getString("observacion"));
            pv.setdestino(rs.getString("destino"));
            pv.setinicio(rs.getString("inicio"));
            pv.setfin(rs.getString("fin"));
            pv.setmovil(rs.getString("movil"));
            pv.setacom(rs.getString("acom"));
        }
        cnn.close();
        ps.close();
        return pv;
    }

   
    public static boolean actualizarViaticos(Viaticos p) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;

        ps = cnn.prepareStatement("update viaticos set idvia=?,fecha=?,numero=?,nombre=?,observacion=?,destino=?,inicio=?,fin=?,movil=?,acom=? where idvia=" + p.getidvia());
        ps.setInt(1, p.getidvia());
        ps.setString(2, p.getfecha());
        ps.setInt(3, p.getnumero());
        ps.setString(4, p.getnombre());
        ps.setString(5, p.getobservacion());
        ps.setString(6, p.getdestino());
        ps.setString(7, p.getinicio());
        ps.setString(8, p.getfin());
        ps.setString(9, p.getmovil());
        ps.setString(10, p.getacom());
        int rowsUpdated = ps.executeUpdate();
        cnn.close();
        ps.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static ArrayList<Viaticos> mostrarViaticos() throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ArrayList<Viaticos> lista = new ArrayList<>();

        ps = cnn.prepareStatement("select idvia,fecha,numero,nombre,observacion,destino, inicio,fin,movil,acom from viaticos");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Viaticos pv = new Viaticos() {
            };
            pv.setidvia(rs.getInt(1));
            pv.setfecha(rs.getString(2));
            pv.setnumero(rs.getInt(3));
            pv.setnombre(rs.getString(4));
            pv.setobservacion(rs.getString(5));
            pv.setdestino(rs.getString(6));
            pv.setinicio(rs.getString(7));
            pv.setfin(rs.getString(8));
            pv.setacom(rs.getString(9));
            lista.add(pv);
        }
        cnn.close();
        ps.close();
        return lista;
    }

    public static ArrayList<Viaticos> listarViaticosPorNombre(String nombre) {
        return listar("nombre", nombre + "%", "like");
    }
    public static ArrayList<Viaticos> listarViaticosPorNit(String nit) {
        return listar("numero", nit+ "%", "like");
    }
    public static ArrayList<Viaticos> listarViaticosPorCodigo(String codigo) {
        return listar("idvia", codigo + "%", "like");
    }

    private static ArrayList<Viaticos> listar(String atributo, String parametro, String comparador) {
        return consultarSQL("select idvia,fecha,numero,nombre,observacion,destino,inicio,fin,movil,acom from viaticos where " + atributo + " " + comparador + " '" + parametro + "'");
    }

    private static ArrayList<Viaticos> consultarSQL(String sql) {
        ArrayList<Viaticos> list = new ArrayList<>();
        Connection cn = BD.getConnection();
        try {
            Viaticos p;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                p = new Viaticos();
                p.setidvia(rs.getInt("idvia"));
                p.setfecha(rs.getString("fecha"));
                p.setnumero(rs.getInt("numero"));
                p.setnombre(rs.getString("nombre"));
                p.setobservacion(rs.getString("observacion"));
                p.setdestino(rs.getString("destino"));
                p.setinicio(rs.getString("inicio"));
                p.setfin(rs.getString("fin"));
                p.setmovil(rs.getString("movil"));
                p.setacom(rs.getString("acom"));
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