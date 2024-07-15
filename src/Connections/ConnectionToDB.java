/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connections;

/**
 *
 * @author Black Code
 */
import java.sql.*;
import javax.swing.JOptionPane;
public class ConnectionToDB {
    Connection conn = null;
    public static Connection ConnectToDB(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn  = DriverManager.getConnection("jdbc:mysql://localhost/voting_system","root","");
            return conn;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}
 