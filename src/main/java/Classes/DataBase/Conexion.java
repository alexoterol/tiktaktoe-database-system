/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes.DataBase;

/**
 *
 * @author alexo
 */
public class Conexion {

    String usuario = "root";
    String pswrd = "87654321";
    String bd = "tiktaktoe";
    String ip = "localhost";
    String puerto = "3306";
    String url = "jdbc:mysql://"+ip+":"+puerto+"/"+bd;
    String driver = "com.mysql.cj.jdbc.Driver";
//    Connection cx; // ME ESTÁ TROLEANDO EL NETBEANS
//
//    public Conexion() {
//    }
//    
//    public static Connection conectar(){
//        Connection conexion= null;
//        try {
//            Class.forName(driver);
//            cx = DriverManager.getConnection(url+bd, usuario, pswrd);
//            System.out.println("Se conectó a "+ bd);
//        } catch (Exception e) {
//            System.out.println("No se conectó a "+ bd);
//        }   
//        
//        return conexion;
//    }
//    
//    public void desconectar(){
//        cx.close;
//    }
    
    
}
