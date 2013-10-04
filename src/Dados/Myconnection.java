/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author Pereiras
 */ 
public class Myconnection{

    private static Connection connection = null;
    
    public static Statement getStatement() throws SQLException{
        
        if(connection == null){
            String url = "jdbc:mysql://localhost:3307/galeteria";
            try{
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(url, "root","root");
            } 
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e.toString()+" FALHA NA CONEXÃO"); 
            }
        }
        return connection.createStatement();
    }
    
    public Connection getConnection(){  
       try{  
          Class.forName("com.mysql.jdbc.Driver").newInstance();  
          String driver = "jdbc:mysql://localhost:3307/galeteria";  
          Connection con = DriverManager.getConnection(driver,"root","root");   
          return con;  
        }  
        catch(Exception e){  
            e.printStackTrace();  
        }  
        return null;  
    }  
    
}
