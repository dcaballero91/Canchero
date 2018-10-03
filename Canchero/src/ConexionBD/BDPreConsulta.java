/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionBD;

import ComponenteClase.PreConsulta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public abstract class BDPreConsulta {

    public static PreConsulta insertarPreConsulta(PreConsulta pv) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        
        ps = cnn.prepareStatement("insert into PreConsulta (nficha,fecha,nombre,apellido,temperatura,ta,peso,usuario) values (?,?,?,?,?,?,?,?)");
        ps.setInt(1,pv.getnficha());
        ps.setString(2, pv.getfecha());
        ps.setString(3, pv.getnombre());
        ps.setString(4, pv.getapellido());
        ps.setDouble(5, pv.gettemperatura());
        ps.setDouble(6, pv.getta());
        ps.setDouble(7, pv.getpeso());
        ps.setString(8, pv.getusuario());
        ps.executeUpdate();
        
        cnn.close();
        ps.close();
        return pv;
    }

    public static PreConsulta buscarPreConsulta(int codigo) throws SQLException {
        return buscarPreConsulta("select nficha,fecha,nombre,apellido,temperatura,ta,peso,usuario from PreConsulta where nficha=" + codigo, null);
    }

    public static PreConsulta buscarPreConsultaNombre(String nombre) throws SQLException {
        return buscarPreConsulta("select nficha,fecha,nombre,apellido,temperatura,ta,peso,usuario from PreConsulta where nombre='" + nombre + "'", null);
    }

    public static PreConsulta buscarPreConsultaNit(int nit) throws SQLException {
        return buscarPreConsulta("select nficha,fecha,nombre,apellido,temperatura,ta,peso,usuario from PreConsulta where fecha=" + nit, null);
    }

    public static PreConsulta buscarPreConsulta(String sql, PreConsulta pv) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ps = cnn.prepareStatement(sql);
        //ps.setString(1, Ruc);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            if (pv == null) {
                pv = new PreConsulta() {
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
        }
        cnn.close();
        ps.close();
        return pv;
    }

   
    

    public static ArrayList<PreConsulta> mostrarPreConsulta() throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;
        ArrayList<PreConsulta> lista = new ArrayList<PreConsulta>();

        ps = cnn.prepareStatement("select nficha,fecha,nombre,apellido,temperatura,ta,peso,usuario from PreConsulta");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            PreConsulta pv = new PreConsulta() {
            };
            pv.setnficha(rs.getInt(1));
            pv.setfecha(rs.getString(2));
            pv.setnombre(rs.getString(3));
            pv.setapellido(rs.getString(4));
            pv.settemperatura(rs.getDouble(5));
            pv.setta(rs.getDouble(6));
            pv.setpeso(rs.getDouble(7));
            pv.setusuario(rs.getString(8));
            lista.add(pv);
        }
        cnn.close();
        ps.close();
        return lista;
    }

     public static ArrayList<PreConsulta> listarPreConsultaPorNombre(String nombre) {
        return listar("nombrefic", nombre + "%", "like");
    }
    public static ArrayList<PreConsulta> listarPreConsultaPorNit(String nit) {
        return listar("fecha", nit+ "%", "like");
    }
    public static ArrayList<PreConsulta> listarPreConsultaPorCodigo(String codigo) {
        return listar("numerofic", codigo + "%", "like");
    }

    private static ArrayList<PreConsulta> listar(String atributo, String parametro, String comparador) {
        return consultarSQL("select nficha,fecha,nombre,apellido,temperatura,ta,peso,usuario from PreConsulta where " + atributo + " " + comparador + " '" + parametro + "'");
    }


    private static ArrayList<PreConsulta> consultarSQL(String sql) {
        ArrayList<PreConsulta> list = new ArrayList<>();
        Connection cn = BD.getConnection();
        try {
            PreConsulta p;
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                p = new PreConsulta();
                p.setnficha(rs.getInt("nficha"));
                p.setfecha(rs.getString("fecha"));
                p.setnombre(rs.getString("nombre"));
                p.setapellido(rs.getString("apellido"));
                p.settemperatura(rs.getDouble("temperatura"));
                p.setta(rs.getDouble("ta"));
                p.setpeso(rs.getDouble("peso"));
                p.setusuario(rs.getString("usuario"));
                
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