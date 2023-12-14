package com.zeroone.biospay;

import java.sql.*;
import javax.swing.JOptionPane;

public class SQLConnection {
    public static Connection DBConnection(){ 
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/paymentms","root","");
            return con;
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        
        return null;
    }
    public static void main(String[] args) {
        // TODO code application logic here
    }
}
