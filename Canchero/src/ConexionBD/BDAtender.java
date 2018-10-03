/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionBD;

import ComponenteClase.Atender;
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
        
        ps = cnn.prepareStatement("insert into Atender (nficha,fecha,nombre,apellido,temperatura,ta,peso,usuario,sintomas,diagnosticos) values (?,?,?,?,?,?,?,?,?,?)");
        ps.setInt(1,pv.getnficha());
        ps.setString(2, pv.getfecha());
        ps.setString(3, pv.getnombre());
        ps.setString(4, pv.getapellido());
        ps.setDouble(5, pv.gettemperatura());
        ps.setDouble(6, pv.getta());
        ps.setDouble(7, pv.getpeso());
        ps.setString(8, pv.getusuario());
        ps.setString(9, pv.getsintomas());
        ps.setString(10, pv.getdiagnosticos());
        ps.executeUpdate();
        
        cnn.close();
        ps.close();
        return pv;
    }

    public static Atender buscarAtender(int codigo) throws SQLException {
        return buscarAtender("select nficha,fecha,nombre,apellido,temperatura,ta,peso,usuario,sintomas,diagnosticos from Atender where nficha=" + codigo, null);
    }

    public static Atender buscarAtenderNombre(String nombre) throws SQLException {
        return buscarAtender("select nficha,fecha,nombre,apellido,temperatura,ta,peso,usuario,sintomas,diagnosticos from Atender where nombre='" + nombre + "'", null);
    }

    public static Atender buscarAtenderNit(int nit) throws SQLException {
        return buscarAtender("select nficha,fecha,nombre,apellido,temperatura,ta,peso,usuario,sintomas,diagnosticos from Atender where fecha=" + nit, null);
    }

    public static Atender buscarAtender(String sql, Atender pv) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement(sql);
        //ps.setString(1, Ruc);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (pv == null) {
                pv = new Atender() {
                };
            }
            pv.setnficha(rs.getInt("nficha"));
            pv.setfecha(rs.getString("fecha"));
            pv.setnombre(rs.getString("nombre"));
            pv.setapellido(rs.getString("apellido"));
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

        ps = cnn.prepareStatement("select nficha,fecha,nombre,apellido,temperatura,ta,peso,usuario,sintomas,diagnosticos from Atender");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Atender pv = new Atender() {
            };
            pv.setnficha(rs.getInt(1));
            pv.setfecha(rs.getString(2));
            pv.setnombre(rs.getString(3));
            pv.setapellido(rs.getString(4));
            pv.settemperatura(rs.getDouble(5));
            pv.setta(rs.getDouble(6));
            pv.setpeso(rs.getDouble(7));
            pv.setusuario(rs.getString(8));
            pv.setsintomas(rs.getString(9));
            pv.setdiagnosticos(rs.getString(10));
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
        return consultarSQL("select nficha,fecha,nombre,apellido,temperatura,ta,peso,usuario,sintomas,diagnosticos from Atender where " + atributo + " " + comparador + " '" + parametro + "'");
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
                p.setapellido(rs.getString("apellido"));
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

    
}