/*
Conectar
*/
package clases;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ruben
 */
public class Conectar {
    private static Connection conn;
    private static final String driver = "com.mysql.jdbc.Driver";


    public Conectar()
    {
        conn=null;
        try{
            Class.forName(driver);
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda", "root", "");
            if(conn!=null){
            System.out.println("Conexion establecida...");
            }
        }catch(ClassNotFoundException | SQLException e){
        System.out.println("Error");     
        }
        
        

    }
    
    
    
    public Connection getConnection(){
        return conn;
    }
    
    
    public void desconectar(){
        conn=null;
        if(conn == null)
        {
           System.out.println("Conexion Terminada");
        }
    }
    
    
    public Connection Subir(String clave, String producto, String numero, String marca) throws SQLException
    {
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("INSERT INTO productos VALUES('"+clave+"','"+producto+"','"+numero+"','"+marca+"')");
        return null;
    }
    
        public Connection Borrar(String clave) throws SQLException
    {
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("DELETE FROM productos WHERE Clave='"+clave+"'");
        return null;
    }
}
