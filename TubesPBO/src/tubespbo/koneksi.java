package tubespbo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class koneksi extends dashboard{
        public static Connection con;
        public static Connection getKoneksi(){
            String host = "jdbc:mysql://localhost/tubespbo",
                   user = "root",
                   ps   = "";
        try{
            con =(Connection) DriverManager.getConnection(host,user,ps);
            System.out.println("Database dapat digunakan");
       
       }catch(SQLException err){
           JOptionPane.showMessageDialog(null, err.getMessage());
           System.out.println("Gagal");
       }
       return con;
    }

   
}