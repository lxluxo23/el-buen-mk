
package clases;

import java.sql.*;
import com.microsoft.sqlserver.jdbc.*;
import javax.swing.JOptionPane;



public class Conexion {
    public String usuario;
    public String pass;
    Connection cn=null;
    Statement stmt = null;
    ResultSet rs = null;
    
    /*
    protected PreparedStatement ps;
    protected String bd;
    protected Connection cn;
    protected Statement st;
    protected String sql;
    protected ResultSet rs;
    //protected final String urll = "jdbc:sqlserver://192.168.1.77;databasename=ICR_TL;integratedSecurity=true;";
    //String url="jdbc:sqlserver://192.168.1.77:1433;" +"databaseName=ICR_TL;Trusted_Connection = true";
    String url =
                "jdbc:sqlserver://192.168.1.77:1433;"
                        + "database=ICR_TL;"
                        + "user=yourusername@yourserver;"
                        + "password=yourpassword;"
                        + "encrypt=true;"
                        + "trustServerCertificate=false;"
                        + "loginTimeout=30";
  
    public Conexion() {
         this.bd=bd;
         Connection cn=null;
    try{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        System.out.println("Driver Registrado");
        cn=DriverManager.getConnection(url+bd);
        System.out.println("Conexion Establecida");
        st= cn.createStatement();

    }catch(SQLException e1){
        System.out.println("ERROR SQL:"+ e1.getMessage());
    }
    catch(ClassNotFoundException e2){
        System.out.println("ERROR DRIVER:"+ e2.getMessage());
    }
    }
*/
    
    
  

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    
    public Connection conectar(){
        
    
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cn = DriverManager.getConnection("jdbc:sqlserver://192.168.1.77:1433;databaseName=ICR_TL;user=sysmk;password=qT1OVkF7");
            System.out.println("Conexion Exitosa");
            /*
            String SQL = "SELECT * FROM MAEPASSWORD where login='cgonzalezc'";
            		stmt = cn.createStatement();
            		rs = stmt.executeQuery(SQL);
                        ResultSetMetaData rsmd = rs.getMetaData();
                        int columnsNumber = rsmd.getColumnCount();
                        while (rs.next()) {
                            for (int i = 1; i <= columnsNumber; i++) {
                                if (i > 1) System.out.print(",  ");
                                String columnValue = rs.getString(i);
                                System.out.print(columnValue + " " + rsmd.getColumnName(i));
       }
       System.out.println("");

            		}
*/
        } 
        catch (Exception e) {
            //e.printStackTrace();
            System.out.println("ERROR"+e.getMessage());
        }
        return cn;
        
    }
    
    
    public void traer(){
    
        try{
            String SQL = "SELECT * FROM MAEPASSWORD where login='"+usuario+"'";
            System.out.println(""+SQL);
            		stmt = cn.createStatement();
            		rs = stmt.executeQuery(SQL);
                        System.out.println("debug");
                        while (rs.next()) {
                            JOptionPane.showMessageDialog(null,"funciono!!");
                            System.out.println(""+rs.getString(1));
                            
                        }
        
        }
        catch (Exception e) {
            //e.printStackTrace();
            System.out.println("ERROR"+e.getMessage());
            
        }
}
}
