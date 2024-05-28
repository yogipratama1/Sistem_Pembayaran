/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

/**
 *
 * @author WINDOWS 10
 */
public class sekolahSession {
    
    public static String namaSekolah;
    public static String alamatSekolah;

    public static String getNamaSekolah() {
        return namaSekolah;
    }

    public static void setNamaSekolah(String namaSekolah) {
        sekolahSession.namaSekolah = namaSekolah;
    }

    public static String getAlamatSekolah() {
        return alamatSekolah;
    }

    public static void setAlamatSekolah(String alamatSekolah) {
        sekolahSession.alamatSekolah = alamatSekolah;
    }
    
}
