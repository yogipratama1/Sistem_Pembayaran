/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

/**
 *
 * @author YOGI
 */
public class UserSession {
    public static String id;
    public static String nama;
    public static String username;
    public static String level;
    public static String tahunajaran;

    public static String get_level() {
        return level;
    }

    public static void set_level(String level) {
        UserSession.level = level;
    }

    public static String get_id() {
        return id;
    }

    public static void set_id(String id) {
        UserSession.id = id;
    }

    public static String get_nama() {
        return nama;
    }

    public static void set_nama(String nama) {
        UserSession.nama = nama;
    }

    public static String get_username() {
        return username;
    }

    public static void set_username(String username) {
        UserSession.username = username;
    }

    public static String getTahunajaran() {
        return tahunajaran;
    }

    public static void setTahunajaran(String tahunajaran) {
        UserSession.tahunajaran = tahunajaran;
    }

    
}
