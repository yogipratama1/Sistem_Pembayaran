/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author YOGI
 */
public class KoneksiDB {

    static Connection con;

    public static Connection getConnection() {

        try {
//            String path = System.getProperty("user.dir") + "\\src\\config\\ip.txt";
//            List<String> content = Files.readAllLines(Paths.get(path));
//            System.out.println(content.get(1));

//            con = DriverManager.getConnection("jdbc:mysql://" + content.get(0) + ":3306/stm", "root", ""+content.get(1)+"");
            System.out.println("a");
            con = DriverManager.getConnection("jdbc:mysql://192.168.0.1:3306/stm", "root", "12345678");
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/stm", "root", "");

            //pass Bissmillah12
            System.out.println(con);

        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "koneksi gagal " + e);
            System.exit(0);
        }
        return con;
    }

}
