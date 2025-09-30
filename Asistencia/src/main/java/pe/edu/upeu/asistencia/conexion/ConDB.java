package pe.edu.upeu.asistencia.conexion;

import pe.edu.upeu.asistencia.modelo.Asistencia;

import java.sql.*;

public class ConDB {
    static Connection conexion;

    public static Connection getConexion(){
        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:data/asistenciadb.db?foreign_keys=on";
            if (conexion==null){
                conexion = DriverManager.getConnection(url);
            }
            System.out.println("conexion exitosa!");
        }catch (ClassNotFoundException | SQLException e ) {
            throw new RuntimeException(e);
        }
        return conexion;

    }
    public static void closeConexion(){
        if (conexion!=null){
            try {
                conexion.close();
            } catch (SQLException e) {}
        }

    }
    public static void main(String[] args) {
        Connection con=getConexion();
        PreparedStatement pst=null;
        ResultSet rs=null;

        try {
            pst=con.prepareStatement("SELECT * FROM participante");
            rs=pst.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString("dni"));
                System.out.println(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
