/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author YOGI
 */
public class KoneksiDB {

    static Connection con;

    public static Connection getConnection() {

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stm", "root", "");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "koneksi gagal "+e);
            System.exit(0);
        }
        return con;
    }

}
