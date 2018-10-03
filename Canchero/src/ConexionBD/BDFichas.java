/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionBD;

import ComponenteClase.Fichas;
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
        ps = cnn.prepareStatement("insert into Fichas (fechafic,nombrefic,apellidofic,dnific,direccfic,nacific,segurofic,teleffic,sexofic,obsfic,padreficha) values (?,?,?,?,?,?,?,?,?,?,?)");
        ps.setDate(1, new java.sql.Date(pv.getfechafic().getTime()));
        ps.setString(2, pv.getnombrefic());
        ps.setString(3, pv.getapellidofic());
        ps.setInt(4, pv.getdnific());
        ps.setString(5, pv.getdireccfic());
        ps.setString(6, pv.getnacific());
        ps.setString(7, pv.getsegurofic());
        ps.setString(8, pv.getteleffic());
        ps.setString(9, pv.getsexofic());
        ps.setString(10, pv.getobsfic());
        ps.setString(11,pv.getpadreficha());
        ps.executeUpdate();
        PreparedStatement ps2 = cnn.prepareStatement("select max(numerofic) from Fichas");
        ResultSet r = ps2.executeQuery();
        if (r.next()) {
            int lastID = r.getInt(1);
            pv.setnumerofic(lastID);
        }
        ps2.close();
        cnn.close();
        ps.close();
        return pv;
    }
    
 
    

    public static Fichas buscarFichas(int codigo) throws SQLException {
        return buscarFichas("select numerofic,fechafic,nombrefic,apellidofic,dnific,direccfic,nacific,segurofic,teleffic,sexofic,obsfic,padreficha from Fichas where numerofic=" + codigo, null);
    }

    public static Fichas buscarFichasNombre(String nombre) throws SQLException {
        return buscarFichas("select numerofic,fechafic,nombrefic,apellidofic,dnific,direccfic,nacific,segurofic,teleffic,sexofic,obsfic,padreficha from Fichas where nombrefic='" + nombre + "'", null);
    }

    public static Fichas buscarFichasNit(int nit) throws SQLException {
        return buscarFichas("select numerofic,fechafic,nombrefic,apellidofic,dnific,direccfic,nacific,segurofic,teleffic,sexofic,obsfic,padreficha from Fichas where fechafic=" + nit, null);
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
            pv.setnumerofic(rs.getInt("numerofic"));
            pv.setfechafic(rs.getDate("fechafic"));
            pv.setnombrefic(rs.getString("nombrefic"));
            pv.setapellidofic(rs.getString("apellidofic"));
            pv.setdnific(rs.getInt("dnific"));
            pv.setdireccfic(rs.getString("direccfic"));
            pv.setnacific(rs.getString("nacific"));
            pv.setsegurofic(rs.getString("segurofic"));
            pv.setteleffic(rs.getString("teleffic"));
            pv.setsexofic(rs.getString("sexofic"));
            pv.setobsfic(rs.getString("obsfic"));
            pv.setpadreficha(rs.getString("padreficha"));;
        }
        cnn.close();
        ps.close();
        return pv;
    }

   
    public static boolean actualizarFichas(Fichas p) throws SQLException {
        Connection cnn = BD.getConnection();
        PreparedStatement ps = null;

        ps = cnn.prepareStatement("update Fichas set fechafic=?,nombrefic=?,apellidofic=?,dnific=?,direccfic=?,nacific=?,segurofic=?,teleffic=?,sexofic=?,obsfic=?,padreficha=? where numerofic=" + p.getnumerofic());
        //ps.setDate(1, p.getfechafic());
        ps.setString(2, p.getnombrefic());
        ps.setString(3, p.getapellidofic());
        ps.setInt(4, p.getdnific());
        ps.setString(5, p.getdireccfic());
        ps.setString(6, p.getnacific());
        ps.setString(7, p.getsegurofic());
        ps.setString(8, p.getteleffic());
        ps.setString(9, p.getsexofic());
        ps.setString(10, p.getobsfic());
        ps.setString(11,p.getpadreficha());
        int rowsUpdated = ps.executeUpdate();
        cnn.close();
        ps.close();
        if (rowsUpdated > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static ArrayList<Fichas> mostrarFichas() throws SQLException {
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
    }

    public static ArrayList<Fichas> listarFichasPorNombre(String nombre) {
        return listar("nombrefic", nombre + "%", "like");
    }
    public static ArrayList<Fichas> listarFichasPorNit(String nit) {
        return listar("fechafic", nit+ "%", "like");
    }
    public static ArrayList<Fichas> listarFichasPorCodigo(String codigo) {
        return listar("numerofic", codigo + "%", "like");
    }

    private static ArrayList<Fichas> listar(String atributo, String parametro, String comparador) {
        return consultarSQL("select numerofic,fechafic,nombrefic,apellidofic,dnific,direccfic,nacific,segurofic,teleffic,sexofic,obsfic,padreficha from Fichas where " + atributo + " " + comparador + " '" + parametro + "'");
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
                p.setnumerofic(rs.getInt("numerofic"));
                p.setfechafic(rs.getDate("fechafic"));
                p.setnombrefic(rs.getString("nombrefic"));
                p.setapellidofic(rs.getString("apellidofic"));
                p.setdnific(rs.getInt("dnific"));
                p.setdireccfic(rs.getString("direccfic"));
                p.setnacific(rs.getString("nacific"));
                p.setsegurofic(rs.getString("segurofic"));
                p.setteleffic(rs.getString("teleffic"));
                p.setsexofic(rs.getString("sexofic"));
                p.setobsfic(rs.getString("obsfic"));
                p.setpadreficha(rs.getString("padreficha"));
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