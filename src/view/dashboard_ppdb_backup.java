/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import config.KoneksiDB;
import config.UserSession;
import config.sekolahSession;
import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.security.CodeSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author WINDOWS 10
 */
public class dashboard_ppdb_backup extends javax.swing.JFrame {

    /**
     * Creates new form dashboard_ppdb
     */
    DateFormat df = new SimpleDateFormat("yyy-MM-dd");
    DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
    DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

    String id = UserSession.get_id();
    String username = UserSession.get_username();
    String nama = UserSession.get_nama();
    String level = UserSession.get_level();
    String tahunajaran = UserSession.getTahunajaran();
    String namaSekolah = sekolahSession.getNamaSekolah();
    String alamatSekolah = sekolahSession.getAlamatSekolah();

    public dashboard_ppdb_backup() {
        initComponents();
        comboPeriode();
        try {
            today();
        } catch (ParseException ex) {
            Logger.getLogger(dashboard_ppdb_backup.class.getName()).log(Level.SEVERE, null, ex);
        }

        viewSiswa();
        text_cari_siswa.requestFocus();

        text_level.setText("Admin");
        text_username.setText(username);
        text_nama_sekolah.setText(namaSekolah);
        text_alamat_sekolah.setText(alamatSekolah);
        //set mata uang
        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        kursIndonesia.setDecimalFormatSymbols(formatRp);
//        if (level.equals("adminppdb")) {
//            dashboard.setVisible(false);
//        }

    }

    PreparedStatement pst;
    Statement st;
    Connection con = KoneksiDB.getConnection();
    ResultSet rs;
    DefaultComboBoxModel modelc;
    DefaultTableModel model;

    public void today() throws ParseException {
        Calendar ca = new GregorianCalendar();
        String day = ca.get(Calendar.DAY_OF_MONTH) + "";
        String month = ca.get(Calendar.MONTH) + 1 + "";
        String year = ca.get(Calendar.YEAR) + "";
        int firstDayOfMonth = Integer.parseInt(day) - (Integer.parseInt(day) - 1);

        if (day.length() == 1) {
            day = "0" + day;
        }
        if (month.length() == 1) {
            month = "0" + month;
        }

        String dd = year + "-" + month + "-" + day;
        String firstDay = year + "-" + month + "-" + firstDayOfMonth;

        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dd);
        Date strdate = new SimpleDateFormat("yyyy-MM-dd").parse(firstDay);
        text_tanggal_daftar.setDate(date);
        start_date.setDate(strdate);
        detail_date.setDate(date);
        end_date.setDate(date);
        text_tanggal_lahir_siswa.setDate(date);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        form_tambah_siswa = new javax.swing.JFrame();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        text_nama_siswa = new javax.swing.JTextField();
        text_tempat_lahir_siswa = new javax.swing.JTextField();
        text_tanggal_lahir_siswa = new com.toedter.calendar.JDateChooser();
        text_asal_sekolah_siswa = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        combobox_jenis_pendaftaran = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        combobox_jurusan_dipilih = new javax.swing.JComboBox<>();
        button_simpan_siswa = new javax.swing.JButton();
        button_batal_create_siswa = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        text_alamat_siswa = new javax.swing.JTextField();
        text_telepon_siswa = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        text_tanggal_daftar = new com.toedter.calendar.JDateChooser();
        jLabel26 = new javax.swing.JLabel();
        text_nik_siswa = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        text_nisn_siswa = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        text_alat_transportasi = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        text_hobi = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        combobox_penerima_pip = new javax.swing.JComboBox<>();
        jLabel32 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        combobox_ukuran_seragam = new javax.swing.JComboBox<>();
        combobox_jenis_kelamin_siswa = new javax.swing.JComboBox<>();
        jLabel38 = new javax.swing.JLabel();
        text_agama_siswa = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        text_tinggi_badan = new javax.swing.JTextField();
        text_berat_badan = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        combobox_golongan_darah = new javax.swing.JComboBox<>();
        jLabel48 = new javax.swing.JLabel();
        text_jarak_ke_sekolah = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        text_jam_ke_sekolah = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        text_menit_ke_sekolah = new javax.swing.JTextField();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        text_jumlah_saudara = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        text_referensi = new javax.swing.JTextField();
        jLabel69 = new javax.swing.JLabel();
        text_anak_ke = new javax.swing.JTextField();
        combobox_tinggal_bersama = new javax.swing.JComboBox<>();
        button_batal_update = new javax.swing.JButton();
        button_update_siswa = new javax.swing.JButton();
        text_id_siswa = new javax.swing.JLabel();
        detail_siswa = new javax.swing.JFrame();
        jPanel6 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        text_detail_id_siswa = new javax.swing.JLabel();
        text_detail_nama_siswa = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        detail_tabel_pembayaran = new javax.swing.JTable();
        text_detail_id_pembayaran = new javax.swing.JTextField();
        text_detail_nama_pembayaran = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        text_detail_bayar_tagihan = new javax.swing.JTextField();
        detail_list_tagihan = new javax.swing.JComboBox<>();
        button_detail_simpan = new javax.swing.JButton();
        text_detail_total_kembalian = new javax.swing.JTextField();
        text_detail_bayar_pembayaran = new javax.swing.JTextField();
        text_detail_total_pembayaran = new javax.swing.JTextField();
        jlabel1 = new javax.swing.JLabel();
        jlabel2 = new javax.swing.JLabel();
        jlabel3 = new javax.swing.JLabel();
        jlabel5 = new javax.swing.JLabel();
        jlabel6 = new javax.swing.JLabel();
        jlabel7 = new javax.swing.JLabel();
        text_detail_periode = new javax.swing.JLabel();
        text_detail_tagihan_pembayaran = new javax.swing.JTextField();
        jlabel4 = new javax.swing.JLabel();
        detail_date = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        biodata_orangtua = new javax.swing.JFrame();
        jPanel9 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        text_nama_ayah = new javax.swing.JTextField();
        text_no_telepon_ayah = new javax.swing.JTextField();
        text_pekerjaan_ayah = new javax.swing.JTextField();
        text_tahun_lahir_ayah = new javax.swing.JTextField();
        text_tahun_lahir_ibu = new javax.swing.JTextField();
        text_pekerjaan_ibu = new javax.swing.JTextField();
        text_no_telepon_ibu = new javax.swing.JTextField();
        text_nama_ibu = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        combobox_pendidikan_terakhir_ayah = new javax.swing.JComboBox<>();
        combobox_pendidikan_terakhir_ibu = new javax.swing.JComboBox<>();
        biodata_wali = new javax.swing.JFrame();
        jPanel10 = new javax.swing.JPanel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        text_nama_wali = new javax.swing.JTextField();
        text_no_telepon_wali = new javax.swing.JTextField();
        text_pekerjaan_wali = new javax.swing.JTextField();
        text_tahun_lahir_wali = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        radio_button_ayah = new javax.swing.JRadioButton();
        radio_button_ibu = new javax.swing.JRadioButton();
        combobox_pendidikan_terakhir_wali = new javax.swing.JComboBox<>();
        button_group_wali = new javax.swing.ButtonGroup();
        form_export = new javax.swing.JFrame();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabel_export = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        text_nama_sekolah = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        text_level = new javax.swing.JLabel();
        text_username = new javax.swing.JLabel();
        text_alamat_sekolah = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_siswa_baru = new javax.swing.JTable();
        start_date = new com.toedter.calendar.JDateChooser();
        text_cari_siswa = new javax.swing.JTextField();
        end_date = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        export_button = new javax.swing.JButton();
        text_jurusan = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        text_total_siswa_baru = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        text_tahun_ajaran = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        dashboard = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        form_tambah_siswa.setLocation(new java.awt.Point(250, 45));
        form_tambah_siswa.setMinimumSize(new java.awt.Dimension(915, 636));
        form_tambah_siswa.setUndecorated(true);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel5.setMinimumSize(new java.awt.Dimension(700, 700));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Form Siswa Baru");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Nama Lengkap");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Tempat, Tanggal Lahir");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Alamat");

        text_nama_siswa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        text_tempat_lahir_siswa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        text_tanggal_lahir_siswa.setDateFormatString("yyy-MM-dd");
        text_tanggal_lahir_siswa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        text_asal_sekolah_siswa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Jenis Pendaftaran");

        combobox_jenis_pendaftaran.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        combobox_jenis_pendaftaran.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                combobox_jenis_pendaftaranKeyPressed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Jurusan Dipilih");

        combobox_jurusan_dipilih.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        combobox_jurusan_dipilih.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TKRO", "TBSM", "TKJT", "APHPt", "APHPi" }));
        combobox_jurusan_dipilih.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                combobox_jurusan_dipilihKeyPressed(evt);
            }
        });

        button_simpan_siswa.setBackground(new java.awt.Color(51, 51, 255));
        button_simpan_siswa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        button_simpan_siswa.setText("SIMPAN");
        button_simpan_siswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_simpan_siswaActionPerformed(evt);
            }
        });

        button_batal_create_siswa.setBackground(new java.awt.Color(255, 51, 51));
        button_batal_create_siswa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        button_batal_create_siswa.setText("BATAL");
        button_batal_create_siswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_batal_create_siswaActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Asal Sekolah");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("No Telepon/WA");

        text_alamat_siswa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        text_telepon_siswa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Tanggal Daftar");

        text_tanggal_daftar.setDateFormatString("yyy-MM-dd");
        text_tanggal_daftar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setText("NIK");

        text_nik_siswa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel27.setText("Jenis Kelamin");

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel28.setText("NISN");

        text_nisn_siswa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        text_nisn_siswa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                text_nisn_siswaKeyPressed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel29.setText("Alat Transportasi");

        text_alat_transportasi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel30.setText("Tinggal Bersama");

        text_hobi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel31.setText("Penerima PIP");

        combobox_penerima_pip.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        combobox_penerima_pip.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tidak", "Ya" }));
        combobox_penerima_pip.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                combobox_penerima_pipKeyPressed(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel32.setText("Orang tua/Wali");

        jLabel35.setText("_______________________________________________________________________________________________________________________________________________");

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel36.setText("TB");

        combobox_ukuran_seragam.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        combobox_ukuran_seragam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "S", "M", "L", "XL", "XXL", "XXXL" }));
        combobox_ukuran_seragam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                combobox_ukuran_seragamKeyPressed(evt);
            }
        });

        combobox_jenis_kelamin_siswa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        combobox_jenis_kelamin_siswa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laki-Laki (L)", "Perempuan (P)" }));

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel38.setText("Agama");

        text_agama_siswa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel39.setText("Hobi");

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(51, 51, 255));
        jLabel40.setText("isi data orang tua");
        jLabel40.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel40MouseClicked(evt);
            }
        });

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(51, 51, 255));
        jLabel43.setText("isi data wali");
        jLabel43.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel43MouseClicked(evt);
            }
        });

        text_tinggi_badan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        text_berat_badan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel44.setText("Cm");

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel45.setText("BB");

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel46.setText("Kg");

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel47.setText("Golongan Darah");

        combobox_golongan_darah.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        combobox_golongan_darah.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "AB", "O" }));
        combobox_golongan_darah.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                combobox_golongan_darahKeyPressed(evt);
            }
        });

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel48.setText("Jarak ke sekolah");

        text_jarak_ke_sekolah.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        text_jarak_ke_sekolah.setText("9");

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel49.setText("KM");

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel50.setText("Waktu ke sekolah");

        text_jam_ke_sekolah.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        text_jam_ke_sekolah.setText("00");

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel51.setText("Jam");

        text_menit_ke_sekolah.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        text_menit_ke_sekolah.setText("00");

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel52.setText("Menit");

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel53.setText("Jumlah saudara");

        text_jumlah_saudara.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel54.setText("Ukuran seragam");

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel33.setText("Referensi");

        text_referensi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel69.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel69.setText("Anak Ke");

        text_anak_ke.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        combobox_tinggal_bersama.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        combobox_tinggal_bersama.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Orang Tua", "Wali", "Asrama/Panti Asuhan" }));
        combobox_tinggal_bersama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                combobox_tinggal_bersamaKeyPressed(evt);
            }
        });

        button_batal_update.setBackground(new java.awt.Color(255, 51, 51));
        button_batal_update.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        button_batal_update.setText("BATAL");
        button_batal_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_batal_updateActionPerformed(evt);
            }
        });

        button_update_siswa.setBackground(new java.awt.Color(0, 102, 102));
        button_update_siswa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        button_update_siswa.setText("UPDATE");
        button_update_siswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_update_siswaActionPerformed(evt);
            }
        });

        text_id_siswa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        text_id_siswa.setText("idSiswa");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel8)
                    .addComponent(jLabel29)
                    .addComponent(jLabel28)
                    .addComponent(jLabel38)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel6)
                            .addComponent(jLabel26)
                            .addComponent(jLabel13)
                            .addComponent(jLabel30))
                        .addGap(63, 63, 63)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(text_nama_siswa, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(text_telepon_siswa, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(text_nik_siswa, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(combobox_tinggal_bersama, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(text_tanggal_daftar, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(49, 49, 49)
                                        .addComponent(jLabel5))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(93, 93, 93)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel10)
                                                    .addComponent(jLabel32)
                                                    .addComponent(jLabel31)
                                                    .addComponent(jLabel54))
                                                .addGap(41, 41, 41)
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(combobox_penerima_pip, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(combobox_ukuran_seragam, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(combobox_jurusan_dipilih, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel9)
                                                    .addComponent(jLabel33))
                                                .addGap(31, 31, 31)
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(combobox_jenis_pendaftaran, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(text_referensi, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(jPanel5Layout.createSequentialGroup()
                                                    .addComponent(jLabel36)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(text_tinggi_badan, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(jLabel44)
                                                    .addGap(45, 45, 45)
                                                    .addComponent(jLabel45)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(text_berat_badan, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jLabel46))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel48)
                                                        .addComponent(jLabel47))
                                                    .addGap(41, 41, 41)
                                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(combobox_golongan_darah, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                            .addComponent(text_jarak_ke_sekolah, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                            .addComponent(jLabel49))))
                                                .addComponent(jLabel50, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel53)
                                                        .addComponent(jLabel69))
                                                    .addGap(46, 46, 46)
                                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(text_anak_ke, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(text_jumlah_saudara, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                                            .addComponent(text_jam_ke_sekolah, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                            .addComponent(jLabel51)
                                                            .addGap(18, 18, 18)
                                                            .addComponent(text_menit_ke_sekolah, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(jLabel52)))))
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addComponent(button_simpan_siswa, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(30, 30, 30)
                                                .addComponent(button_batal_create_siswa, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(button_update_siswa, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(button_batal_update, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(jLabel7)
                            .addComponent(jLabel39))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(text_tempat_lahir_siswa, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(text_tanggal_lahir_siswa, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(combobox_jenis_kelamin_siswa, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(text_nisn_siswa, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(text_asal_sekolah_siswa, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(text_agama_siswa, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(text_alamat_siswa, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(text_alat_transportasi, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(text_hobi, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 889, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(text_id_siswa)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel14))
                    .addComponent(text_tanggal_daftar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(text_id_siswa)
                .addGap(3, 3, 3)
                .addComponent(jLabel35)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(text_telepon_siswa, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(combobox_jenis_kelamin_siswa, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(combobox_penerima_pip, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(combobox_jurusan_dipilih, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(combobox_ukuran_seragam, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel54))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel40)
                            .addComponent(jLabel43)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(text_nama_siswa, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(text_nik_siswa, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26))))
                .addGap(6, 6, 6)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(text_tanggal_lahir_siswa, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(text_tempat_lahir_siswa, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28)
                            .addComponent(text_nisn_siswa, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(text_asal_sekolah_siswa, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38)
                            .addComponent(text_agama_siswa, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel8))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(text_alamat_siswa, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(text_alat_transportasi, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(combobox_tinggal_bersama, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel36))
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel46)
                                .addComponent(text_berat_badan, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel45)
                                .addComponent(jLabel44)
                                .addComponent(text_tinggi_badan, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel47)
                            .addComponent(combobox_golongan_darah, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(text_jarak_ke_sekolah, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel49)
                            .addComponent(jLabel48))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel50)
                            .addComponent(text_jam_ke_sekolah, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel51)
                            .addComponent(text_menit_ke_sekolah, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel52))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel53)
                            .addComponent(text_jumlah_saudara, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel69, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(text_anak_ke, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(combobox_jenis_pendaftaran, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(text_hobi, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel39))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel33)
                        .addComponent(text_referensi, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_simpan_siswa, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_batal_create_siswa, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_batal_update, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_update_siswa, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61))
        );

        javax.swing.GroupLayout form_tambah_siswaLayout = new javax.swing.GroupLayout(form_tambah_siswa.getContentPane());
        form_tambah_siswa.getContentPane().setLayout(form_tambah_siswaLayout);
        form_tambah_siswaLayout.setHorizontalGroup(
            form_tambah_siswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(form_tambah_siswaLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        form_tambah_siswaLayout.setVerticalGroup(
            form_tambah_siswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        detail_siswa.setLocation(new java.awt.Point(150, 50));
        detail_siswa.setMinimumSize(new java.awt.Dimension(1112, 568));
        detail_siswa.setUndecorated(true);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton2.setBackground(new java.awt.Color(255, 51, 51));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("BATAL");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        text_detail_id_siswa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        text_detail_id_siswa.setText("id_siswa");

        text_detail_nama_siswa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        text_detail_nama_siswa.setText("Nama Siswa");

        detail_tabel_pembayaran.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        detail_tabel_pembayaran.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        detail_tabel_pembayaran.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Pembayaran", "Nama Pembayaran", "Bayar"
            }
        ));
        detail_tabel_pembayaran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                detail_tabel_pembayaranMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(detail_tabel_pembayaran);

        text_detail_id_pembayaran.setEditable(false);
        text_detail_id_pembayaran.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        text_detail_nama_pembayaran.setEditable(false);
        text_detail_nama_pembayaran.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setText("Tagihan Biswa Baru");

        text_detail_bayar_tagihan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        text_detail_bayar_tagihan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_detail_bayar_tagihanActionPerformed(evt);
            }
        });

        detail_list_tagihan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        detail_list_tagihan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detail_list_tagihanActionPerformed(evt);
            }
        });

        button_detail_simpan.setBackground(new java.awt.Color(51, 51, 255));
        button_detail_simpan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        button_detail_simpan.setForeground(new java.awt.Color(255, 255, 255));
        button_detail_simpan.setText("SIMPAN");
        button_detail_simpan.setToolTipText("");
        button_detail_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_detail_simpanActionPerformed(evt);
            }
        });

        text_detail_total_kembalian.setEditable(false);
        text_detail_total_kembalian.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N

        text_detail_bayar_pembayaran.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        text_detail_bayar_pembayaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_detail_bayar_pembayaranActionPerformed(evt);
            }
        });

        text_detail_total_pembayaran.setEditable(false);
        text_detail_total_pembayaran.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jlabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlabel1.setText("ID Pembayaran");

        jlabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlabel2.setText("Nama Pembayaran");

        jlabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlabel3.setText("Bayar Tagihan");

        jlabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlabel5.setText("Total Pembayaran");

        jlabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlabel6.setText("Bayar");

        jlabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jlabel7.setText("*enter setelah input pembayaran");

        text_detail_periode.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        text_detail_periode.setText("Periode");

        text_detail_tagihan_pembayaran.setEditable(false);
        text_detail_tagihan_pembayaran.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jlabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jlabel4.setText("Tagihan");

        detail_date.setDateFormatString("yyy-MM-dd");
        detail_date.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 255));
        jLabel4.setText("Update");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(text_detail_periode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(detail_list_tagihan, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(225, 225, 225))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(text_detail_id_siswa, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addGap(319, 319, 319)
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(detail_date, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2)
                            .addComponent(text_detail_total_kembalian)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(text_detail_id_pembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlabel1))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(text_detail_nama_pembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlabel2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlabel4)
                                    .addComponent(text_detail_tagihan_pembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlabel3)
                                    .addComponent(text_detail_bayar_tagihan, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel6Layout.createSequentialGroup()
                                            .addComponent(button_detail_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(text_detail_total_pembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jlabel5))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jlabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jlabel7))
                                    .addComponent(text_detail_bayar_pembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(text_detail_nama_siswa, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(35, Short.MAX_VALUE))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(text_detail_id_siswa)
                        .addComponent(jLabel17)
                        .addComponent(jLabel4))
                    .addComponent(detail_date, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(text_detail_nama_siswa)
                .addGap(5, 5, 5)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(detail_list_tagihan, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_detail_periode))
                .addGap(17, 17, 17)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabel1)
                    .addComponent(jlabel2)
                    .addComponent(jlabel3)
                    .addComponent(jlabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text_detail_id_pembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_detail_nama_pembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_detail_bayar_tagihan, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_detail_tagihan_pembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(text_detail_total_kembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabel5)
                    .addComponent(jlabel6)
                    .addComponent(jlabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text_detail_total_pembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_detail_bayar_pembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_detail_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout detail_siswaLayout = new javax.swing.GroupLayout(detail_siswa.getContentPane());
        detail_siswa.getContentPane().setLayout(detail_siswaLayout);
        detail_siswaLayout.setHorizontalGroup(
            detail_siswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        detail_siswaLayout.setVerticalGroup(
            detail_siswaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        biodata_orangtua.setLocation(new java.awt.Point(450, 55));
        biodata_orangtua.setMinimumSize(new java.awt.Dimension(507, 544));
        biodata_orangtua.setUndecorated(true);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel9.setMinimumSize(new java.awt.Dimension(498, 516));

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel34.setText("Nama Ayah");

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel37.setText("No Telepon");

        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel55.setText("Pekerjaan");

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel56.setText("Tahun Lahir");

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel57.setText("Pendidikan Terakhir");

        text_nama_ayah.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        text_nama_ayah.setText("yogi");

        text_no_telepon_ayah.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        text_no_telepon_ayah.setText("123123");

        text_pekerjaan_ayah.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        text_pekerjaan_ayah.setText("programmer");

        text_tahun_lahir_ayah.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        text_tahun_lahir_ayah.setText("2000");

        text_tahun_lahir_ibu.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        text_tahun_lahir_ibu.setText("2000");

        text_pekerjaan_ibu.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        text_pekerjaan_ibu.setText("accounting");

        text_no_telepon_ibu.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        text_no_telepon_ibu.setText("343534");

        text_nama_ibu.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        text_nama_ibu.setText("Oktania Nindi");

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel58.setText("Nama Ibu");

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel59.setText("No Telepon");

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel60.setText("Pekerjaan");

        jLabel61.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel61.setText("Tahun Lahir");

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel62.setText("Pendidikan Terakhir");

        jLabel63.setText("_____________________________________________________________________________");

        jButton5.setBackground(new java.awt.Color(51, 51, 255));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("SIMPAN");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(255, 51, 51));
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("BATAL");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        combobox_pendidikan_terakhir_ayah.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        combobox_pendidikan_terakhir_ayah.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SD", "SLTP", "SMA\\SMK", "S1", "S2", "S3" }));

        combobox_pendidikan_terakhir_ibu.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        combobox_pendidikan_terakhir_ibu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SD", "SLTP", "SMA\\SMK", "S1", "S2", "S3" }));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34)
                            .addComponent(jLabel37)
                            .addComponent(jLabel55)
                            .addComponent(jLabel56)
                            .addComponent(jLabel57))
                        .addGap(57, 57, 57)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(text_tahun_lahir_ayah)
                            .addComponent(text_pekerjaan_ayah)
                            .addComponent(text_no_telepon_ayah)
                            .addComponent(text_nama_ayah)
                            .addComponent(combobox_pendidikan_terakhir_ayah, 0, 281, Short.MAX_VALUE)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel58)
                            .addComponent(jLabel59)
                            .addComponent(jLabel60)
                            .addComponent(jLabel61)
                            .addComponent(jLabel62))
                        .addGap(57, 57, 57)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(text_tahun_lahir_ibu)
                            .addComponent(text_pekerjaan_ibu)
                            .addComponent(text_no_telepon_ibu)
                            .addComponent(text_nama_ibu)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(combobox_pendidikan_terakhir_ibu, 0, 281, Short.MAX_VALUE)))
                    .addComponent(jLabel63))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text_nama_ayah, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_no_telepon_ayah, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_pekerjaan_ayah, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_tahun_lahir_ayah, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combobox_pendidikan_terakhir_ayah, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jLabel63)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text_nama_ibu, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel58))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_no_telepon_ibu, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_pekerjaan_ibu, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_tahun_lahir_ibu, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combobox_pendidikan_terakhir_ibu, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout biodata_orangtuaLayout = new javax.swing.GroupLayout(biodata_orangtua.getContentPane());
        biodata_orangtua.getContentPane().setLayout(biodata_orangtuaLayout);
        biodata_orangtuaLayout.setHorizontalGroup(
            biodata_orangtuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        biodata_orangtuaLayout.setVerticalGroup(
            biodata_orangtuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(biodata_orangtuaLayout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        biodata_wali.setLocation(new java.awt.Point(450, 55));
        biodata_wali.setMinimumSize(new java.awt.Dimension(507, 544));
        biodata_wali.setUndecorated(true);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel10.setMinimumSize(new java.awt.Dimension(498, 516));

        jLabel64.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel64.setText("Nama Wali");

        jLabel65.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel65.setText("No Telepon");

        jLabel66.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel66.setText("Pekerjaan");

        jLabel67.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel67.setText("Tahun Lahir");

        jLabel68.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel68.setText("Pendidikan Terakhir");

        text_nama_wali.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        text_no_telepon_wali.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        text_pekerjaan_wali.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        text_tahun_lahir_wali.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jButton7.setBackground(new java.awt.Color(51, 51, 255));
        jButton7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("SIMPAN");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(255, 51, 51));
        jButton8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("BATAL");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        button_group_wali.add(radio_button_ayah);
        radio_button_ayah.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        radio_button_ayah.setText("Sama dengan Ayah");
        radio_button_ayah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_button_ayahActionPerformed(evt);
            }
        });

        button_group_wali.add(radio_button_ibu);
        radio_button_ibu.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        radio_button_ibu.setText("Sama dengan Ibu");
        radio_button_ibu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radio_button_ibuActionPerformed(evt);
            }
        });

        combobox_pendidikan_terakhir_wali.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        combobox_pendidikan_terakhir_wali.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SD", "SLTP", "SMA\\SMK", "S1", "S2", "S3" }));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel64)
                            .addComponent(jLabel65)
                            .addComponent(jLabel66)
                            .addComponent(jLabel67)
                            .addComponent(jLabel68))
                        .addGap(57, 57, 57)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(text_pekerjaan_wali, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(text_no_telepon_wali, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(text_nama_wali, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(radio_button_ayah)
                                .addGap(18, 18, 18)
                                .addComponent(radio_button_ibu))
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(combobox_pendidikan_terakhir_wali, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(text_tahun_lahir_wali, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)))))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radio_button_ayah)
                    .addComponent(radio_button_ibu))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text_nama_wali, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel64))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_no_telepon_wali, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_pekerjaan_wali, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel67, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_tahun_lahir_wali, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel68, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combobox_pendidikan_terakhir_wali, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(175, 175, 175)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton8))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout biodata_waliLayout = new javax.swing.GroupLayout(biodata_wali.getContentPane());
        biodata_wali.getContentPane().setLayout(biodata_waliLayout);
        biodata_waliLayout.setHorizontalGroup(
            biodata_waliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        biodata_waliLayout.setVerticalGroup(
            biodata_waliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(biodata_waliLayout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        form_export.setMinimumSize(new java.awt.Dimension(1300, 402));

        tabel_export.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tabel_export);

        javax.swing.GroupLayout form_exportLayout = new javax.swing.GroupLayout(form_export.getContentPane());
        form_export.getContentPane().setLayout(form_exportLayout);
        form_exportLayout.setHorizontalGroup(
            form_exportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1300, Short.MAX_VALUE)
        );
        form_exportLayout.setVerticalGroup(
            form_exportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(form_exportLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(51, 51, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DASHBOARD PENDAFTARAN SISWA BARU");

        text_nama_sekolah.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        text_nama_sekolah.setForeground(new java.awt.Color(255, 255, 255));
        text_nama_sekolah.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        text_nama_sekolah.setText("nama_sekolah");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.MatteBorder(null));

        text_level.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        text_level.setText("level");

        text_username.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        text_username.setText("user");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(text_level, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(text_username, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(text_level, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(text_username)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        text_alamat_sekolah.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        text_alamat_sekolah.setForeground(new java.awt.Color(255, 255, 255));
        text_alamat_sekolah.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        text_alamat_sekolah.setText("alamat_sekolah");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tabel_siswa_baru.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabel_siswa_baru.setRequestFocusEnabled(false);
        tabel_siswa_baru.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_siswa_baruMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_siswa_baru);

        start_date.setDateFormatString("yyy-MM-dd");
        start_date.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        start_date.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                start_dateMouseReleased(evt);
            }
        });

        text_cari_siswa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        text_cari_siswa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                text_cari_siswaKeyReleased(evt);
            }
        });

        end_date.setDateFormatString("yyy-MM-dd");
        end_date.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("+ TAMBAH SISWA");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        export_button.setBackground(new java.awt.Color(0, 102, 102));
        export_button.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        export_button.setForeground(new java.awt.Color(255, 255, 255));
        export_button.setText("EXPORT DATA");
        export_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                export_buttonActionPerformed(evt);
            }
        });

        text_jurusan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        text_jurusan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "TKRO", "TBSM", "TKJT", "APHPt", "APHPi" }));
        text_jurusan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_jurusanActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("TOTAL SISWA BARU :");

        text_total_siswa_baru.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        text_total_siswa_baru.setText("0");

        jButton1.setBackground(new java.awt.Color(102, 0, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("CARI");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 2, true));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(text_jurusan, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(start_date, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(end_date, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(text_cari_siswa, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 294, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(export_button, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(26, 26, 26)
                        .addComponent(text_total_siswa_baru, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(start_date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(end_date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(export_button, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2))
                            .addComponent(text_jurusan, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(text_cari_siswa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(text_total_siswa_baru, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(131, 131, 131))
        );

        text_tahun_ajaran.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        text_tahun_ajaran.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        text_tahun_ajaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_tahun_ajaranActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(text_nama_sekolah, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_alamat_sekolah, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_tahun_ajaran, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(text_nama_sekolah)
                        .addGap(1, 1, 1)
                        .addComponent(text_alamat_sekolah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(text_tahun_ajaran, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setText("Menu");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        dashboard.setText("Dashboard");
        dashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboardActionPerformed(evt);
            }
        });
        jMenu1.add(dashboard);

        jMenuItem1.setText("Exit");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        if (text_tahun_ajaran.getSelectedItem().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Pilih tahun ajaran dahulu!");
        } else {
            text_tahun_ajaran.disable();
            text_id_siswa.setVisible(false);
            resetForm();
            text_jam_ke_sekolah.setText("00");
            text_menit_ke_sekolah.setText("00");

            button_simpan_siswa.setVisible(true);
            button_update_siswa.setVisible(false);
            button_batal_create_siswa.setVisible(true);
            button_batal_update.setVisible(false);
//        text_tahun_ajaran.removeAllItems();
            form_tambah_siswa.setVisible(true);
            combobox_jenis_pendaftaran.enable();
//        comboPeriode();
            comboJenisPendaftaran();

            text_nama_siswa.requestFocus();
        }


    }//GEN-LAST:event_jLabel2MouseClicked

    private void button_simpan_siswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_simpan_siswaActionPerformed
        String siswa = "00";
        String idSiswa = ID_AUTO(siswa);

        System.out.println(ID_AUTO(idSiswa));

        String nis = "";
        String nama = text_nama_siswa.getText().toUpperCase();
        String nik = text_nik_siswa.getText();
        String noTelepon = text_telepon_siswa.getText();
        String jenisKelamin = combobox_jenis_kelamin_siswa.getSelectedItem().toString();
        if (jenisKelamin.equals("Laki-Laki (L)")) {
            jenisKelamin = "L";

        } else {
            jenisKelamin = "P";
        }
        String tempatLahir = text_tempat_lahir_siswa.getText();
        String nisn = text_nisn_siswa.getText();
        String asalSekolah = text_asal_sekolah_siswa.getText().toUpperCase();
        String agama = text_agama_siswa.getText();
        String alamat = text_alamat_siswa.getText();
        String alatTranportasi = text_alat_transportasi.getText();
        String tinggalBersama = combobox_tinggal_bersama.getSelectedItem().toString();
        String hobi = text_hobi.getText();
        String penerimaPip = combobox_penerima_pip.getSelectedItem().toString();
        String jurusanDipilih = combobox_jurusan_dipilih.getSelectedItem().toString();
        String ukuranSeragam = combobox_ukuran_seragam.getSelectedItem().toString();
        String dataAyah = text_nama_ayah.getText() + "/" + text_no_telepon_ayah.getText() + "/" + text_pekerjaan_ayah.getText() + "/" + text_tahun_lahir_ayah.getText() + "/" + combobox_pendidikan_terakhir_ayah.getSelectedItem().toString();
        String dataIbu = text_nama_ibu.getText() + "/" + text_no_telepon_ibu.getText() + "/" + text_pekerjaan_ibu.getText() + "/" + text_tahun_lahir_ibu.getText() + "/" + combobox_pendidikan_terakhir_ibu.getSelectedItem().toString();
        String dataWali = text_nama_wali.getText() + "/" + text_no_telepon_wali.getText() + "/" + text_pekerjaan_wali.getText() + "/" + text_tahun_lahir_wali.getText() + "/" + combobox_pendidikan_terakhir_wali.getSelectedItem().toString();

        String tinggiBadan = text_tinggi_badan.getText();
        String beratBadan = text_berat_badan.getText();
        String golonganDarah = combobox_golongan_darah.getSelectedItem().toString();
        String jarakSekolah = text_jarak_ke_sekolah.getText();
        String waktuTempuh = text_jam_ke_sekolah.getText() + "," + text_menit_ke_sekolah.getText();
        String saudaraKandung = text_jumlah_saudara.getText();
        String anakKe = text_anak_ke.getText();
        String referensi = text_referensi.getText();
        String status = "aktif";

        String jenisPendaftaran = combobox_jenis_pendaftaran.getSelectedItem().toString();

        String periode = text_tahun_ajaran.getSelectedItem().toString();
        String tanggalDaftar = df.format(text_tanggal_daftar.getDate());
        String tglLahir = df.format(text_tanggal_lahir_siswa.getDate());
        System.out.println("length tglLahir : " + tglLahir.length());

        if (nama.length() == 0 || df.format(text_tanggal_lahir_siswa.getDate()).length() == 0) {
            System.out.println("tes");
            JOptionPane.showMessageDialog(null, "Nama wajib diisi!");
        } //        else if (text_nama_ayah.getText().length() == 0 || text_nama_ibu.getText().length() == 0 || text_nama_wali.getText().length() == 0) {
        //            JOptionPane.showMessageDialog(null, "Isi data orang tua/wali dengan benar");
        //        } 
        else {
            String tanggalLahir = df.format(text_tanggal_lahir_siswa.getDate());
            try {
                String sql = "Select * from tbl_siswa where Kode_siswa='" + idSiswa + "'";
                rs = con.createStatement().executeQuery(sql);

                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Gagal!! ID siswa sudah ada.");

                } else {
                    System.out.println("INSERT INTO tbl_ppdb VALUE('"
                            + idSiswa + "','" + nik + "','" + jenisKelamin + "','" + tempatLahir + "','"
                            + tanggalLahir + "','" + nisn + "','" + asalSekolah + "','" + agama + "','"
                            + alamat + "','" + alatTranportasi + "','" + tinggalBersama + "','"
                            + hobi + "','" + penerimaPip + "','" + jurusanDipilih + "','"
                            + ukuranSeragam + "','" + dataAyah + "','" + dataIbu + "','"
                            + dataWali + "','" + tinggiBadan + "','" + beratBadan + "','"
                            + golonganDarah + "','" + jarakSekolah + "','" + waktuTempuh + "','"
                            + saudaraKandung + "','" + anakKe + "','" + referensi + "')");
                    con.createStatement().executeUpdate("INSERT INTO tbl_siswa VALUE('"
                            + idSiswa + "','" + nama + "','" + alamat + "','"
                            + noTelepon + "','" + nis + "','" + status + "')");
                    con.createStatement().executeUpdate("INSERT INTO tbl_ppdb VALUE('"
                            + idSiswa + "','" + nik + "','" + jenisKelamin + "','" + tempatLahir + "','"
                            + tanggalLahir + "','" + nisn + "','" + asalSekolah + "','" + agama + "','"
                            + alamat + "','" + alatTranportasi + "','" + tinggalBersama + "','"
                            + hobi + "','" + penerimaPip + "','" + jurusanDipilih + "','"
                            + ukuranSeragam + "','" + dataAyah + "','" + dataIbu + "','"
                            + dataWali + "','" + tinggiBadan + "','" + beratBadan + "','"
                            + golonganDarah + "','" + jarakSekolah + "','" + waktuTempuh + "','"
                            + saudaraKandung + "','" + anakKe + "','" + referensi + "','" + periode + "','" + tanggalDaftar + "','" + jenisPendaftaran + "')");
                    simpanTagihan(idSiswa, jenisPendaftaran, periode);
                    JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
                    resetForm();

                    text_tahun_ajaran.enable();
                    combobox_jenis_pendaftaran.removeAllItems();
                    form_tambah_siswa.dispose();

                }

            } catch (Exception e) {
                System.out.println("" + e);
                JOptionPane.showMessageDialog(null, "Gagal !! Isi Form Dengan Benar ");
            }
        }
        viewSiswa();


    }//GEN-LAST:event_button_simpan_siswaActionPerformed

    private void button_batal_create_siswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_batal_create_siswaActionPerformed
        text_tahun_ajaran.enable();
        combobox_jenis_pendaftaran.removeAllItems();
        form_tambah_siswa.dispose();

        resetForm();
    }//GEN-LAST:event_button_batal_create_siswaActionPerformed

    private void text_cari_siswaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_cari_siswaKeyReleased
        viewSiswa();
    }//GEN-LAST:event_text_cari_siswaKeyReleased

    private void start_dateMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_start_dateMouseReleased
        viewSiswa();        // TODO add your handling code here:
    }//GEN-LAST:event_start_dateMouseReleased

    private void tabel_siswa_baruMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_siswa_baruMouseClicked
        button_simpan_siswa.setVisible(false);
        button_update_siswa.setVisible(true);
        button_batal_create_siswa.setVisible(false);
        button_batal_update.setVisible(true);
        text_tahun_ajaran.disable();
        text_id_siswa.setVisible(true);

        resetForm();
//        comboPeriode();
        comboJenisPendaftaran();

        form_tambah_siswa.setVisible(true);
        int i = tabel_siswa_baru.getSelectedRow();
        text_id_siswa.setText(model.getValueAt(i, 0).toString());
        try {
            String sql1 = "SELECT * FROM tbl_dettran WHERE Kode_siswa='" + model.getValueAt(i, 0) + "' AND Periode='" + text_tahun_ajaran.getSelectedItem() + "' AND Kode_kelas='00' AND Lunas>'0'";
            System.out.println(sql1);
            rs = con.createStatement().executeQuery(sql1);
            while (rs.next()) {

                combobox_jenis_pendaftaran.disable();
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        showSiswaOnFormEdit();

//        int i = tabel_siswa_baru.getSelectedRow();
//        text_detail_id_siswa.setText(model.getValueAt(i, 0).toString());
//        text_detail_nama_siswa.setText(model.getValueAt(i, 1).toString());
//        text_detail_periode.setText(model.getValueAt(i, 7).toString());
//        comboTagihan(model.getValueAt(i, 0).toString(), model.getValueAt(i, 7).toString());
//        text_detail_bayar_tagihan.setEnabled(false);
//        detail_siswa.setVisible(true);

    }//GEN-LAST:event_tabel_siswa_baruMouseClicked

    private void button_detail_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_detail_simpanActionPerformed
        String trx = "00";
        String trxId = TRXID_AUTO(trx);
        System.out.println(trxId);
        simpanpembayaran(trxId);
        System.out.println("simpan pembayaran sukses");
        updatetagihan();
        System.out.println("update tagihan berhasil");
        detail_siswa.dispose();
        try {
            cetaknota(trxId);
        } catch (Exception ex) {
            Logger.getLogger(Transaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
//        btncetak.setEnabled(false);
        DefaultTableModel dataModel = (DefaultTableModel) detail_tabel_pembayaran.getModel();
        if (detail_tabel_pembayaran.getRowCount() > 0) {
            for (int i = detail_tabel_pembayaran.getRowCount() - 1; i > -1; i--) {
                dataModel.removeRow(i);
            }
        }
        resetForm();
        viewSiswa();
        button_detail_simpan.setEnabled(false);
    }//GEN-LAST:event_button_detail_simpanActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        detail_siswa.dispose();
        DefaultTableModel dataModel = (DefaultTableModel) detail_tabel_pembayaran.getModel();
        if (detail_tabel_pembayaran.getRowCount() > 0) {
            for (int i = detail_tabel_pembayaran.getRowCount() - 1; i > -1; i--) {
                dataModel.removeRow(i);
            }
        }
        resetForm();// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void detail_list_tagihanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detail_list_tagihanActionPerformed
        if (detail_list_tagihan.getSelectedItem() == null) {
            System.out.println("Tagihan Aman!");
        } else {
            String[] splitTagihan = detail_list_tagihan.getSelectedItem().toString().split(" - ");
            text_detail_id_pembayaran.setText(splitTagihan[0]);
            text_detail_nama_pembayaran.setText(splitTagihan[1]);
            text_detail_bayar_tagihan.setText(splitTagihan[2]);
            text_detail_tagihan_pembayaran.setText(splitTagihan[2]);
            text_detail_bayar_tagihan.requestFocus();
            text_detail_bayar_tagihan.setEnabled(true);
        }
    }//GEN-LAST:event_detail_list_tagihanActionPerformed

    private void text_detail_bayar_tagihanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_detail_bayar_tagihanActionPerformed
        String idPembayaran = text_detail_id_pembayaran.getText();
        String bayarTagihan = text_detail_bayar_tagihan.getText();
        int tagihan = Integer.parseInt(text_detail_tagihan_pembayaran.getText());

        System.out.println(bayarTagihan.length());
        if (bayarTagihan.length() <= 0 || Integer.parseInt(bayarTagihan) > tagihan) {
            JOptionPane.showMessageDialog(null, "Pembayaran terlalu besar/pembayaran tidak sesuai!!");

        } else {
            double sisaTagihan = tagihan - Integer.parseInt(bayarTagihan);
            if (sisaTagihan < 0) {
                JOptionPane.showMessageDialog(null, "jumlah bayar melebihi tagihan!");
            } else {
                tablearray(idPembayaran, text_detail_nama_pembayaran.getText(), text_detail_bayar_tagihan.getText());
                text_detail_id_pembayaran.setText("");
                text_detail_nama_pembayaran.setText("");
                text_detail_tagihan_pembayaran.setText("");
                text_detail_bayar_tagihan.setText("");
                text_detail_bayar_tagihan.setEnabled(false);
                text_detail_bayar_pembayaran.requestFocus();
            }

        }
    }//GEN-LAST:event_text_detail_bayar_tagihanActionPerformed

    private void text_detail_bayar_pembayaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_detail_bayar_pembayaranActionPerformed
        int total = Integer.parseInt(text_detail_total_pembayaran.getText());
        int jmlbyr = Integer.parseInt(text_detail_bayar_pembayaran.getText());

        int kembalian = jmlbyr - total;

        if (kembalian < 0) {
            JOptionPane.showMessageDialog(null, "Uang masih kurang!!");
        } else {
            text_detail_total_kembalian.setText(String.valueOf("Kembalian = " + kursIndonesia.format(kembalian)));
            button_detail_simpan.setEnabled(true);

        }

    }//GEN-LAST:event_text_detail_bayar_pembayaranActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        detail_siswa.dispose();
        resetForm();
    }//GEN-LAST:event_formMouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked


    }//GEN-LAST:event_jLabel4MouseClicked

    private void detail_tabel_pembayaranMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_detail_tabel_pembayaranMouseClicked
        int confirm = JOptionPane.showConfirmDialog(null, "Apakah ingin menghapus data ini?");
        switch (confirm) {
            case JOptionPane.YES_OPTION:
                DefaultTableModel dataModel = (DefaultTableModel) detail_tabel_pembayaran.getModel();
                int i = detail_tabel_pembayaran.getSelectedRow();
                dataModel.removeRow(i);
                totaltagihan();

        }
    }//GEN-LAST:event_detail_tabel_pembayaranMouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        dispose();
        Login lg = new Login();
        lg.setVisible(true);

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void export_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_export_buttonActionPerformed

        viewExportedData();
//        form_export.setVisible(true);

        try {
            exportData();
        } catch (IOException ex) {
            Logger.getLogger(dashboard_ppdb_backup.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_export_buttonActionPerformed

    private void text_jurusanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_jurusanActionPerformed
        viewSiswa();        // TODO add your handling code here:
    }//GEN-LAST:event_text_jurusanActionPerformed

    private void jLabel40MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel40MouseClicked
        biodata_orangtua.setVisible(true);
        form_tambah_siswa.disable();
        text_nama_ayah.requestFocus();
    }//GEN-LAST:event_jLabel40MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        form_tambah_siswa.enable();
        biodata_orangtua.setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        form_tambah_siswa.enable();
        biodata_orangtua.setVisible(false);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        form_tambah_siswa.enable();
        biodata_wali.setVisible(false);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        form_tambah_siswa.enable();
        biodata_wali.setVisible(false);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void radio_button_ayahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio_button_ayahActionPerformed
        text_nama_wali.setText(text_nama_ayah.getText());
        text_no_telepon_wali.setText(text_no_telepon_ayah.getText());
        text_pekerjaan_wali.setText(text_pekerjaan_ayah.getText());
        text_tahun_lahir_wali.setText(text_tahun_lahir_ayah.getText());
        combobox_pendidikan_terakhir_wali.setSelectedItem(combobox_pendidikan_terakhir_ayah.getSelectedItem());

    }//GEN-LAST:event_radio_button_ayahActionPerformed

    private void radio_button_ibuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radio_button_ibuActionPerformed
        text_nama_wali.setText(text_nama_ibu.getText());
        text_no_telepon_wali.setText(text_no_telepon_ibu.getText());
        text_pekerjaan_wali.setText(text_pekerjaan_ibu.getText());
        text_tahun_lahir_wali.setText(text_tahun_lahir_ibu.getText());
        combobox_pendidikan_terakhir_wali.setSelectedItem(combobox_pendidikan_terakhir_ibu.getSelectedItem());
    }//GEN-LAST:event_radio_button_ibuActionPerformed

    private void jLabel43MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel43MouseClicked
        biodata_wali.setVisible(true);
        form_tambah_siswa.disable();
        button_group_wali.clearSelection();
        text_nama_wali.requestFocus();
    }//GEN-LAST:event_jLabel43MouseClicked

    private void button_batal_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_batal_updateActionPerformed
        combobox_jenis_pendaftaran.removeAllItems();
        text_tahun_ajaran.enable();
        form_tambah_siswa.dispose();
//         text_tahun_ajaran1.removeAllItems();
        combobox_jenis_pendaftaran.enable();

//        comboPeriode();
        resetForm();
    }//GEN-LAST:event_button_batal_updateActionPerformed

    private void button_update_siswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_update_siswaActionPerformed
        int i = tabel_siswa_baru.getSelectedRow();
        String idSiswa = text_id_siswa.getText();
        String nis = "";
        String nama = text_nama_siswa.getText().toUpperCase();
        String nik = text_nik_siswa.getText();
        String noTelepon = text_telepon_siswa.getText();
        String jenisKelamin = combobox_jenis_kelamin_siswa.getSelectedItem().toString();
        if (jenisKelamin.equals("Laki-Laki (L)")) {
            jenisKelamin = "L";

        } else {
            jenisKelamin = "P";
        }
        String tempatLahir = text_tempat_lahir_siswa.getText();
        String nisn = text_nisn_siswa.getText();
        String asalSekolah = text_asal_sekolah_siswa.getText().toUpperCase();
        String agama = text_agama_siswa.getText();
        String alamat = text_alamat_siswa.getText();
        String alatTranportasi = text_alat_transportasi.getText();
        String tinggalBersama = combobox_tinggal_bersama.getSelectedItem().toString();
        String hobi = text_hobi.getText();
        String penerimaPip = combobox_penerima_pip.getSelectedItem().toString();
        String jurusanDipilih = combobox_jurusan_dipilih.getSelectedItem().toString();
        String ukuranSeragam = combobox_ukuran_seragam.getSelectedItem().toString();
        String dataAyah = text_nama_ayah.getText() + "/" + text_no_telepon_ayah.getText() + "/" + text_pekerjaan_ayah.getText() + "/" + text_tahun_lahir_ayah.getText() + "/" + combobox_pendidikan_terakhir_ayah.getSelectedItem().toString();
        String dataIbu = text_nama_ibu.getText() + "/" + text_no_telepon_ibu.getText() + "/" + text_pekerjaan_ibu.getText() + "/" + text_tahun_lahir_ibu.getText() + "/" + combobox_pendidikan_terakhir_ibu.getSelectedItem().toString();
        String dataWali = text_nama_wali.getText() + "/" + text_no_telepon_wali.getText() + "/" + text_pekerjaan_wali.getText() + "/" + text_tahun_lahir_wali.getText() + "/" + combobox_pendidikan_terakhir_wali.getSelectedItem().toString();

        String tinggiBadan = text_tinggi_badan.getText();
        String beratBadan = text_berat_badan.getText();
        String golonganDarah = combobox_golongan_darah.getSelectedItem().toString();
        String jarakSekolah = text_jarak_ke_sekolah.getText();
        String waktuTempuh = text_jam_ke_sekolah.getText() + "," + text_menit_ke_sekolah.getText();
        String saudaraKandung = text_jumlah_saudara.getText();
        String anakKe = text_anak_ke.getText();
        String referensi = text_referensi.getText();
        String status = "aktif";

        String jenisPendaftaran = combobox_jenis_pendaftaran.getSelectedItem().toString();

        String periode = text_tahun_ajaran.getSelectedItem().toString();
        String tanggalDaftar = df.format(text_tanggal_daftar.getDate());

        if (nama.length() == 0 || df.format(text_tanggal_lahir_siswa.getDate()).length() == 0) {
            System.out.println("tes");
            JOptionPane.showMessageDialog(null, "Isi data dengan benar!");

        } else {
            String tanggalLahir = df.format(text_tanggal_lahir_siswa.getDate());
            try {
                System.out.println("test update top update tbl_siswa");
                con.createStatement().executeUpdate("UPDATE tbl_siswa set Nama_siswa='"
                        + nama + "', Alamat='" + alamat + "',No_telepon='"
                        + noTelepon + "',nomor_induk='" + nis + "',Status='" + status + "' WHERE Kode_siswa='" + idSiswa + "'");
                System.out.println("test update bottom update tbl_siswa");
                con.createStatement().executeUpdate("UPDATE tbl_ppdb set nik_siswa='"
                        + nik + "',jenis_kelamin_siswa='" + jenisKelamin + "',tempat_lahir_siswa='" + tempatLahir + "',tanggal_lahir_siswa='"
                        + tanggalLahir + "',nisn_siswa='" + nisn + "',asal_sekolah_siswa='" + asalSekolah + "',agama_siswa='" + agama + "',alamat_siswa='"
                        + alamat + "',alat_transportasi_siswa='" + alatTranportasi + "',tinggal_bersama='" + tinggalBersama + "',hobi_siswa='"
                        + hobi + "',pip='" + penerimaPip + "',jurusan_dipilih='" + jurusanDipilih + "',ukuran_seragam_siswa='"
                        + ukuranSeragam + "',ayah='" + dataAyah + "',ibu='" + dataIbu + "',wali='"
                        + dataWali + "',tinggi_badan_siswa='" + tinggiBadan + "',berat_badan_siswa='" + beratBadan + "',golongan_darah_siswa='"
                        + golonganDarah + "',jarak_sekolah_siswa='" + jarakSekolah + "',waktu_tempuh_siswa='" + waktuTempuh + "',jumlah_saudara_siswa='"
                        + saudaraKandung + "',anak_ke='" + anakKe + "',referensi='" + referensi + "',tahun_ajaran='" + periode + "',jenis_pendaftaran='"
                        + jenisPendaftaran + "' WHERE Kode_siswa='" + idSiswa + "'");
                System.out.println("test update bottom update tbl_ppdb");

                int j = tabel_siswa_baru.getSelectedRow();
                try {
                    String sql1 = "SELECT * FROM tbl_dettran WHERE Kode_siswa='" + model.getValueAt(j, 0) + "' AND Periode='" + text_tahun_ajaran.getSelectedItem() + "' AND Kode_kelas='00' AND Lunas>'0'";
                    System.out.println(sql1);
                    rs = con.createStatement().executeQuery(sql1);
                    if (rs.next()) {

                    } else {
                        con.createStatement().executeUpdate("DELETE from tbl_dettran where Kode_siswa='" + idSiswa + "' AND Periode='" + periode + "' AND Kode_kelas='00' AND lunas='0'");
                        System.out.println("test update bottom delete tagihan");
                        updateTagihan(idSiswa, jenisPendaftaran, periode);
                    }
                } catch (Exception e) {
                }

                JOptionPane.showMessageDialog(null, "Data Berhasil Di Update");
                combobox_jenis_pendaftaran.enable();
                resetForm();
                text_tahun_ajaran.enable();
                combobox_jenis_pendaftaran.removeAllItems();
                form_tambah_siswa.dispose();

            } catch (Exception e) {
                System.out.println("" + e);
                JOptionPane.showMessageDialog(null, "Gagal !! Isi Form Dengan Benar ");
            }
        }
        viewSiswa();
    }//GEN-LAST:event_button_update_siswaActionPerformed

    private void dashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardActionPerformed
        switch (level) {
            case "admin": {
                Dashboard dsb = new Dashboard();
                dsb.dashAdmin();
                dsb.setExtendedState(JFrame.MAXIMIZED_BOTH);
                dsb.setVisible(true);
                dispose();
                break;
            }
            case "petugas": {
                Dashboard dsb = new Dashboard();
                dsb.dashPetugas();
                dsb.setExtendedState(JFrame.MAXIMIZED_BOTH);
                dsb.setVisible(true);
                dispose();
                break;
            }
            default:
                break;
        }
    }//GEN-LAST:event_dashboardActionPerformed

    private void text_nisn_siswaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_nisn_siswaKeyPressed
        if (evt.getKeyCode() == evt.VK_SHIFT) {
            text_asal_sekolah_siswa.requestFocus();
        }
    }//GEN-LAST:event_text_nisn_siswaKeyPressed

    private void combobox_tinggal_bersamaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combobox_tinggal_bersamaKeyPressed
        if (evt.getKeyCode() == evt.VK_SHIFT) {
            text_hobi.requestFocus();
        }
    }//GEN-LAST:event_combobox_tinggal_bersamaKeyPressed

    private void combobox_penerima_pipKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combobox_penerima_pipKeyPressed
        if (evt.getKeyCode() == evt.VK_SHIFT) {
            combobox_jurusan_dipilih.requestFocus();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_combobox_penerima_pipKeyPressed

    private void combobox_jurusan_dipilihKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combobox_jurusan_dipilihKeyPressed
        if (evt.getKeyCode() == evt.VK_SHIFT) {
            combobox_ukuran_seragam.requestFocus();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_combobox_jurusan_dipilihKeyPressed

    private void combobox_ukuran_seragamKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combobox_ukuran_seragamKeyPressed
        if (evt.getKeyCode() == evt.VK_SHIFT) {
            text_tinggi_badan.requestFocus();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_combobox_ukuran_seragamKeyPressed

    private void combobox_golongan_darahKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combobox_golongan_darahKeyPressed
        if (evt.getKeyCode() == evt.VK_SHIFT) {
            text_jarak_ke_sekolah.requestFocus();
        }
    }//GEN-LAST:event_combobox_golongan_darahKeyPressed

    private void combobox_jenis_pendaftaranKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combobox_jenis_pendaftaranKeyPressed
        if (evt.getKeyCode() == evt.VK_SHIFT) {
            text_referensi.requestFocus();
        }
    }//GEN-LAST:event_combobox_jenis_pendaftaranKeyPressed

    private void text_tahun_ajaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_tahun_ajaranActionPerformed
//       combobox_jenis_pendaftaran.removeAllItems();
        viewSiswa();
    }//GEN-LAST:event_text_tahun_ajaranActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        viewSiswa();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(dashboard_ppdb_backup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dashboard_ppdb_backup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dashboard_ppdb_backup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dashboard_ppdb_backup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dashboard_ppdb_backup dp = new dashboard_ppdb_backup();
                dp.setVisible(true);
                dp.setExtendedState(JFrame.MAXIMIZED_BOTH);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame biodata_orangtua;
    private javax.swing.JFrame biodata_wali;
    private javax.swing.JButton button_batal_create_siswa;
    private javax.swing.JButton button_batal_update;
    private javax.swing.JButton button_detail_simpan;
    private javax.swing.ButtonGroup button_group_wali;
    private javax.swing.JButton button_simpan_siswa;
    private javax.swing.JButton button_update_siswa;
    private javax.swing.JComboBox<String> combobox_golongan_darah;
    private javax.swing.JComboBox<String> combobox_jenis_kelamin_siswa;
    private javax.swing.JComboBox<String> combobox_jenis_pendaftaran;
    private javax.swing.JComboBox<String> combobox_jurusan_dipilih;
    private javax.swing.JComboBox<String> combobox_pendidikan_terakhir_ayah;
    private javax.swing.JComboBox<String> combobox_pendidikan_terakhir_ibu;
    private javax.swing.JComboBox<String> combobox_pendidikan_terakhir_wali;
    private javax.swing.JComboBox<String> combobox_penerima_pip;
    private javax.swing.JComboBox<String> combobox_tinggal_bersama;
    private javax.swing.JComboBox<String> combobox_ukuran_seragam;
    public javax.swing.JMenuItem dashboard;
    private com.toedter.calendar.JDateChooser detail_date;
    private javax.swing.JComboBox<String> detail_list_tagihan;
    private javax.swing.JFrame detail_siswa;
    private javax.swing.JTable detail_tabel_pembayaran;
    private com.toedter.calendar.JDateChooser end_date;
    private javax.swing.JButton export_button;
    private javax.swing.JFrame form_export;
    private javax.swing.JFrame form_tambah_siswa;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel jlabel1;
    private javax.swing.JLabel jlabel2;
    private javax.swing.JLabel jlabel3;
    private javax.swing.JLabel jlabel4;
    private javax.swing.JLabel jlabel5;
    private javax.swing.JLabel jlabel6;
    private javax.swing.JLabel jlabel7;
    private javax.swing.JRadioButton radio_button_ayah;
    private javax.swing.JRadioButton radio_button_ibu;
    private com.toedter.calendar.JDateChooser start_date;
    private javax.swing.JTable tabel_export;
    private javax.swing.JTable tabel_siswa_baru;
    private javax.swing.JTextField text_agama_siswa;
    private javax.swing.JLabel text_alamat_sekolah;
    private javax.swing.JTextField text_alamat_siswa;
    private javax.swing.JTextField text_alat_transportasi;
    private javax.swing.JTextField text_anak_ke;
    private javax.swing.JTextField text_asal_sekolah_siswa;
    private javax.swing.JTextField text_berat_badan;
    private javax.swing.JTextField text_cari_siswa;
    private javax.swing.JTextField text_detail_bayar_pembayaran;
    private javax.swing.JTextField text_detail_bayar_tagihan;
    private javax.swing.JTextField text_detail_id_pembayaran;
    private javax.swing.JLabel text_detail_id_siswa;
    private javax.swing.JTextField text_detail_nama_pembayaran;
    private javax.swing.JLabel text_detail_nama_siswa;
    private javax.swing.JLabel text_detail_periode;
    private javax.swing.JTextField text_detail_tagihan_pembayaran;
    private javax.swing.JTextField text_detail_total_kembalian;
    private javax.swing.JTextField text_detail_total_pembayaran;
    private javax.swing.JTextField text_hobi;
    private javax.swing.JLabel text_id_siswa;
    private javax.swing.JTextField text_jam_ke_sekolah;
    private javax.swing.JTextField text_jarak_ke_sekolah;
    private javax.swing.JTextField text_jumlah_saudara;
    private javax.swing.JComboBox<String> text_jurusan;
    private javax.swing.JLabel text_level;
    private javax.swing.JTextField text_menit_ke_sekolah;
    private javax.swing.JTextField text_nama_ayah;
    private javax.swing.JTextField text_nama_ibu;
    private javax.swing.JLabel text_nama_sekolah;
    private javax.swing.JTextField text_nama_siswa;
    private javax.swing.JTextField text_nama_wali;
    private javax.swing.JTextField text_nik_siswa;
    private javax.swing.JTextField text_nisn_siswa;
    private javax.swing.JTextField text_no_telepon_ayah;
    private javax.swing.JTextField text_no_telepon_ibu;
    private javax.swing.JTextField text_no_telepon_wali;
    private javax.swing.JTextField text_pekerjaan_ayah;
    private javax.swing.JTextField text_pekerjaan_ibu;
    private javax.swing.JTextField text_pekerjaan_wali;
    private javax.swing.JTextField text_referensi;
    private javax.swing.JComboBox<String> text_tahun_ajaran;
    private javax.swing.JTextField text_tahun_lahir_ayah;
    private javax.swing.JTextField text_tahun_lahir_ibu;
    private javax.swing.JTextField text_tahun_lahir_wali;
    private com.toedter.calendar.JDateChooser text_tanggal_daftar;
    private com.toedter.calendar.JDateChooser text_tanggal_lahir_siswa;
    private javax.swing.JTextField text_telepon_siswa;
    private javax.swing.JTextField text_tempat_lahir_siswa;
    private javax.swing.JTextField text_tinggi_badan;
    private javax.swing.JTextField text_total_siswa_baru;
    private javax.swing.JLabel text_username;
    // End of variables declaration//GEN-END:variables
 public String ID_AUTO(String idSiswa) {
        try {
            String sql = "Select max(Kode_siswa) from tbl_siswa";
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                if (rs.first() == false) {
                    idSiswa = "1";

                } else {
                    rs.last();
                    int autoid = rs.getInt(1) + 1;
                    String nomor = String.valueOf(autoid);

                    for (int a = 0; a < 1; a++) {
                        nomor = nomor;
                    }
                    idSiswa = nomor;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, e);
        }
        return idSiswa;

    }

    private void comboTagihan(String idSiswa, String periode) {
        String sql = "SELECT *, tbl_pembayaran.Nama_pembayaran from tbl_dettran"
                + " Inner join tbl_pembayaran USING(kode_bayar)"
                + " where Kode_siswa='" + idSiswa + "' and Hutang>'0' and tbl_dettran.Periode='" + periode + "'";

        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String idPembayaran = rs.getString("kode_bayar");
                String namaPembayaran = rs.getString("Nama_pembayaran");
                String hutang = rs.getString("Hutang");
                System.out.println(idPembayaran + " - " + namaPembayaran + " - " + hutang);
                detail_list_tagihan.addItem(idPembayaran + " - " + namaPembayaran + " - " + hutang);

            }
        } catch (Exception e) {
        }
    }

    private void comboPeriode() {

//        text_tahun_ajaran1.removeAllItems();
        String sql = "SELECT * FROM tbl_periode ORDER BY created_at DESC";
        System.out.println(sql);

        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("Periode"));
//                text_tahun_ajaran1.addItem(rs.getString("Periode"));
                text_tahun_ajaran.addItem(rs.getString("Periode"));

            }
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Combo Periode " + e);
        }
    }

    private void resetForm() {

        text_alamat_siswa.setText("");
        text_asal_sekolah_siswa.setText("");
        combobox_jenis_pendaftaran.setSelectedItem("--- Pilih Jenis Pendaftaran ---");
        combobox_jurusan_dipilih.setSelectedItem("--- Pilih Jurusan ---");
        text_nama_siswa.setText("");
//        text_tahun_ajaran.removeAllItems();

        text_tempat_lahir_siswa.setText("");
        text_telepon_siswa.setText("");
        text_detail_id_siswa.setText("id_siswa");
        text_detail_bayar_pembayaran.setText("");
        text_detail_id_pembayaran.setText("");
        text_detail_nama_pembayaran.setText("");
        text_detail_nama_siswa.setText("");
        text_detail_periode.setText("periode");
        text_detail_total_pembayaran.setText("");
        text_detail_total_kembalian.setText("");
        text_detail_tagihan_pembayaran.setText("");
        button_detail_simpan.setEnabled(false);

        DefaultTableModel dataModel = (DefaultTableModel) detail_tabel_pembayaran.getModel();
        if (detail_tabel_pembayaran.getRowCount() > 0) {
            for (int i = detail_tabel_pembayaran.getRowCount() - 1; i > -1; i--) {
                dataModel.removeRow(i);
            }
        }

        detail_list_tagihan.removeAllItems();

        //ppdb
        text_nik_siswa.setText("");
        text_nisn_siswa.setText("");
        text_agama_siswa.setText("");
        text_alat_transportasi.setText("");
        text_hobi.setText("");
        text_tinggi_badan.setText("");
        text_berat_badan.setText("");
        text_jarak_ke_sekolah.setText("");
        text_jam_ke_sekolah.setText("");
        text_menit_ke_sekolah.setText("");
        text_jumlah_saudara.setText("");
        text_anak_ke.setText("");
        text_referensi.setText("");
        text_nama_ayah.setText("");
        text_no_telepon_ayah.setText("");
        text_pekerjaan_ayah.setText("");
        text_tahun_lahir_ayah.setText("");
        text_nama_ibu.setText("");
        text_no_telepon_ibu.setText("");
        text_pekerjaan_ibu.setText("");
        text_tahun_lahir_ibu.setText("");
        text_nama_wali.setText("");
        text_no_telepon_wali.setText("");
        text_pekerjaan_wali.setText("");
        text_tahun_lahir_wali.setText("");

    }

    private void simpanTagihan(String idSiswa, String jenisPendaftaran, String periode) {
        System.out.println("tes 1");
        try {

            con.createStatement().executeUpdate("INSERT INTO tbl_setupkelas VALUE('" + periode + "','" + idSiswa + "','00')");

            String sql = "Select * from tbl_pembayaran where Nama_pembayaran='" + jenisPendaftaran + "' AND periode='" + periode + "' and group_kelas='Kelas 0'";

            System.out.println(sql);
            try {

                rs = con.createStatement().executeQuery(sql);
                while (rs.next()) {
                    String kodebayar = rs.getString("Kode_bayar");
                    String biaya = rs.getString("Biaya");
                    String grupkelas = rs.getString("group_kelas");

                    try {
                        con.createStatement().executeUpdate("insert into tbl_dettran value('" + periode + "','" + idSiswa + "',"
                                + "'00','" + kodebayar + "','" + biaya + "','0','" + grupkelas + "')");
                        System.out.println(kodebayar);
                    } catch (Exception e) {
                        System.out.println("input ke tbl_dettran salah" + e);
                    }
                }
            } catch (Exception e) {
                System.out.println("view database salah " + e);
            }

            resetForm();
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Masukan Data Dengan Benar");

        }

    }

    private void updateTagihan(String idSiswa, String jenisPendaftaran, String periode) {
        System.out.println("tes 1");
        try {

//            con.createStatement().executeUpdate("INSERT INTO tbl_setupkelas VALUE('" + periode + "','" + idSiswa + "','00')");
            String sql = "Select * from tbl_pembayaran where Nama_pembayaran='" + jenisPendaftaran + "' AND periode='" + periode + "' and group_kelas='Kelas 0'";

            System.out.println(sql);
            try {

                rs = con.createStatement().executeQuery(sql);
                while (rs.next()) {
                    String kodebayar = rs.getString("Kode_bayar");
                    String biaya = rs.getString("Biaya");
                    String grupkelas = rs.getString("group_kelas");

                    try {
                        con.createStatement().executeUpdate("insert into tbl_dettran value('" + periode + "','" + idSiswa + "',"
                                + "'00','" + kodebayar + "','" + biaya + "','0','" + grupkelas + "')");
                        System.out.println(kodebayar);
                    } catch (Exception e) {
                        System.out.println("input ke tbl_dettran salah" + e);
                    }
                }
            } catch (Exception e) {
                System.out.println("view database salah " + e);
            }

            resetForm();
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Masukan Data Dengan Benar");

        }
    }

    private void viewSiswa() {
        String startDate = df.format(start_date.getDate());
        String endDate = df.format(end_date.getDate());

        String tahunAjaran = text_tahun_ajaran.getSelectedItem().toString();
        String[] judul = {"ID Siswa", "NAMA SISWA", "ASAL SEKOLAH", "ALAMAT", "NO TELP", "JENIS PENDAFTARAN", "JURUSAN", "TAHUN AJARAN", "TANGGAL DAFTAR"};
        model = new DefaultTableModel(judul, 0);
        tabel_siswa_baru.setModel(model);
        String sql = "SELECT *, tbl_ppdb.* from tbl_siswa INNER JOIN tbl_ppdb using(kode_siswa)"
                + " where tahun_ajaran='" + tahunAjaran + "' AND jurusan_dipilih like'%" + text_jurusan.getSelectedItem().toString() + "%'"
                + " AND tanggal_daftar BETWEEN '" + startDate + "' AND '" + endDate + "'"
                + " AND  (Nama_siswa like '%" + text_cari_siswa.getText() + "%'OR tbl_siswa.Kode_siswa like '%" + text_cari_siswa.getText() + "%')"
                + " ORDER BY tbl_siswa.Kode_siswa DESC";
//        System.out.println(sql);
        lebarkolom();
        try {
            rs = con.createStatement().executeQuery(sql);

            while (rs.next()) {
                String id = rs.getString("Kode_siswa");
                String nama = rs.getString("Nama_siswa");
                String asalSekolah = rs.getString("asal_sekolah_siswa");
                String alamat = rs.getString("Alamat");
                String telp = rs.getString("No_telepon");
                String jenisPendaftaran = rs.getString("jenis_pendaftaran");
                String jurusanDipilih = rs.getString("jurusan_dipilih");
                String periode = rs.getString("tahun_ajaran");
                String tanggalDaftar = rs.getString("tanggal_daftar");
//                String wali = rs.getString("wali");

                String[] data = {id, nama, asalSekolah, alamat, telp, jenisPendaftaran, jurusanDipilih, periode, tanggalDaftar};
                model.addRow(data);

            }
        } catch (Exception e) {
            System.out.println(e);

        }
        text_total_siswa_baru.setText(String.valueOf(tabel_siswa_baru.getRowCount()));
    }

    public void lebarkolom() {
        TableColumn column;
        for (int i = 0; i < 8; i++) {
            column = tabel_siswa_baru.getColumnModel().getColumn(i);
            if (i == 0) {
                column.setPreferredWidth(4);
            }
//            else if (i == 1) {
//                column.setPreferredWidth(30);
//            } else if (i == 2) {
//                column.setPreferredWidth(70);
//            } else if (i == 3) {
//                column.setPreferredWidth(180);
//            } else if (i == 4) {
//                column.setPreferredWidth(100);
//            }
        }
    }

    private void tablearray(String idPembayaran, String namaPembayaran, String bayar) {
        DefaultTableModel dataModel = (DefaultTableModel) detail_tabel_pembayaran.getModel();

        List list = new ArrayList<>();
        detail_tabel_pembayaran.setAutoCreateColumnsFromModel(true);
        list.add(idPembayaran);
        list.add(namaPembayaran);
        list.add(bayar);

        dataModel.addRow(list.toArray());
        totaltagihan();
    }

    private void totaltagihan() {
        int total = 0;
        for (int i = 0; i < detail_tabel_pembayaran.getRowCount(); i++) {
            int amount = Integer.parseInt((String) detail_tabel_pembayaran.getValueAt(i, 2));
            total += amount;
        }
        text_detail_total_kembalian.setText("" + String.valueOf(kursIndonesia.format(total)));
        text_detail_total_pembayaran.setText("" + total);
    }

    private void simpanpembayaran(String trxId) {

        String idsiswa = text_detail_id_siswa.getText();
        String tanggal = df.format(detail_date.getDate());

        String periode = text_detail_periode.getText();
        String totalbayar = text_detail_bayar_pembayaran.getText();
        String user = text_username.getText();
        String idkelas = "00";
        int kembalian = Integer.parseInt(text_detail_bayar_pembayaran.getText()) - Integer.parseInt(text_detail_total_pembayaran.getText());
        System.out.println(kembalian);

        int jumlah_baris = detail_tabel_pembayaran.getRowCount();
        System.out.println("jumlah baris : " + jumlah_baris);
        if (jumlah_baris == 0) {
            JOptionPane.showMessageDialog(null, "Pembayaran Masih Kosong!");
        } else {
            try {
                System.out.println("insert into tbl_transaksi");
                System.out.println("INSERT INTO tbl_transaksi Value('" + trxId + "',"
                        + "'" + tanggal + "','" + periode + "','" + idsiswa + "','" + idkelas + "','" + totalbayar + "','" + user + "','" + kembalian + "')");
                con.createStatement().executeUpdate("INSERT INTO tbl_transaksi Value('" + trxId + "',"
                        + "'" + tanggal + "','" + periode + "','" + idsiswa + "','" + idkelas + "','" + totalbayar + "','" + user + "','" + kembalian + "')");
                System.out.println("insert ke tabel transaksi berhasil");
                try {
                    int i = 0;
                    while (i < jumlah_baris) {
                        System.out.println("i ke " + i);
                        con.createStatement().executeUpdate("insert into tbl_dettransaksi(no_faktur,kode_biaya,jumlah)"
                                + " Values("
                                + "'" + trxId + "','"
                                + "" + detail_tabel_pembayaran.getValueAt(i, 0) + "','"
                                + "" + detail_tabel_pembayaran.getValueAt(i, 2) + "')");
                        i++;

                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Gagal Menyimpan!!" + e);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "input ke tbl_transaksi ada yang salah!!");
                System.out.println(e);
            }

        }
    }

    private void updatetagihan() {
        DefaultTableModel dataModel = (DefaultTableModel) detail_tabel_pembayaran.getModel();
        String idsiswa = text_detail_id_siswa.getText();
        System.out.println("id siswa :" + idsiswa);

        int jumlahbaris = detail_tabel_pembayaran.getRowCount();
        System.out.println("jumlah baris : " + jumlahbaris);
        int i = 0;
        while (i < jumlahbaris) {
            System.out.println("i ke " + i);
            String kodebayar = dataModel.getValueAt(i, 0).toString();
            System.out.println("kode bayar " + kodebayar);
            System.out.println("SELECT * from tbl_dettran where Kode_siswa='" + idsiswa + "' and Kode_bayar='" + kodebayar + "'");
            String sql = "SELECT * from tbl_dettran where Kode_siswa='" + idsiswa + "' and Kode_bayar='" + kodebayar + "'";
            int bayar = Integer.parseInt(dataModel.getValueAt(i, 2).toString());
            System.out.println("bayar tagihan :" + bayar);
            try {
                rs = con.createStatement().executeQuery(sql);
                while (rs.next()) {
                    int hutang = Integer.parseInt(rs.getString("Hutang"));
                    int lunas = Integer.parseInt(rs.getString("Lunas"));

                    int updatehutang = hutang - bayar;
                    int updatelunas = lunas + bayar;
                    System.out.println("update hutang : " + updatehutang);

                    con.createStatement().executeUpdate("Update tbl_dettran set Hutang='" + updatehutang + "',"
                            + " Lunas='" + updatelunas + "' where Kode_siswa='" + idsiswa + "' and Kode_bayar='" + kodebayar + "'");
                    System.out.println("Update tbl_dettran set Hutang='" + updatehutang + "',"
                            + " Lunas='" + updatelunas + "' where Kode_siswa='" + idsiswa + "' and Kode_bayar='" + kodebayar + "'");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
                System.out.println(e);
            }

            i++;
        }
        System.out.println("Test update tagihan");
        JOptionPane.showMessageDialog(null, "Berhasil Menyimpan!!");
    }

    private void cetaknota(String trxId) throws JRException {
        String total = text_detail_total_pembayaran.getText();
        JasperDesign jd = JRXmlLoader.load(getClass().getResourceAsStream("/laporan/notabayar.jrxml"));
        JRDesignQuery query = new JRDesignQuery();
        HashMap param = new HashMap();
        param.put("total", total);
        String namaSekolah = sekolahSession.getNamaSekolah();
        String alamatsekolah = sekolahSession.getAlamatSekolah();
        param.put("namaSekolah", namaSekolah);
        param.put("alamatSekolah", alamatsekolah);
        query.setText("select tbl_siswa.Nama_siswa,tbl_dettransaksi.*,tbl_transaksi.*,"
                + "tbl_pembayaran.Nama_pembayaran,tbl_kelas.Nama_kelas from tbl_transaksi "
                + " inner join tbl_siswa using(Kode_siswa) "
                + " INNER join tbl_dettransaksi USING(no_faktur) "
                + " inner join tbl_pembayaran on tbl_dettransaksi.kode_biaya=tbl_pembayaran.Kode_bayar"
                + " inner join tbl_kelas using(Kode_kelas) "
                + " where no_faktur='" + trxId + "'");
        jd.setQuery(query);

        JasperReport jr = JasperCompileManager.compileReport(jd);
        JasperPrint jp = JasperFillManager.fillReport(jr, param, con);
        JasperViewer.viewReport(jp, false);
    }

    private String TRXID_AUTO(String trx) {
        try {
            String sql = "Select max(right(no_faktur,5)) as no_idtransaksi from tbl_transaksi";
            rs = con.createStatement().executeQuery(sql);
            while (rs.next()) {
                if (rs.first() == false) {
                    trx = "KWI-000001";

                } else {
                    rs.last();
                    int autoid = rs.getInt(1) + 1;
                    if (autoid <= 99) {
                        trx = "Kwi-0000" + autoid;
                    } else if (autoid > 99 && autoid <= 999) {
                        trx = "Kwi-000" + autoid;
                    } else if (autoid > 999) {
                        trx = "Kwi-00" + autoid;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Error No Kwitansi");
        }
        return trx;
    }

//    private void resetFormUpdateSiswa() {
//        text_update_alamat.setText("");
//        text_update_asal_sekolah.setText("");
//        text_update_jenis_pendaftaran.setSelectedItem("--- Pilih Jenis Pendaftaran ---");
//        text_update_jurusan_dipilih.setSelectedItem("--- Pilih Jurusan ---");
//        text_update_nama.setText("");
//        text_update_tahun_ajaran.setSelectedItem("--- Pilih Tahun Ajaran ---");
//        text_update_tempat_lahir.setText("");
//        text_update_telepon.setText("");
//        text_update_tahun_ajaran.removeAllItems();
//    }
    private void laporanSiswa() throws JRException {
//        String startDate = df.format(start_date.getDate());
//        String endDate = df.format(end_date.getDate());
//
//        JasperDesign jd = JRXmlLoader.load(getClass().getResourceAsStream("/laporan/siswa_ppdb.jrxml"));
//        JRDesignQuery query = new JRDesignQuery();
//        HashMap param = new HashMap();
//        String namaSekolah = sekolahSession.getNamaSekolah();
//        String alamatsekolah = sekolahSession.getAlamatSekolah();
//
//        param.put("namaSekolah", namaSekolah);
//        param.put("alamatSekolah", alamatsekolah);
//        System.out.println("SELECT tbl_siswa.*,tbl_kelas.Nama_kelas,tbl_setupkelas.* FROM tbl_setupkelas "
//                + "INNER JOIN tbl_siswa USING(Kode_siswa) INNER JOIN tbl_kelas USING (Kode_Kelas)"
//                + " where jurusan_dipilih like'%" + text_jurusan.getSelectedItem().toString() + "%'  kode_kelas = '00' and Periode='" + text_tahun_ajaran1.getSelectedItem().toString() + "' "
//                + "AND  tanggal_daftar BETWEEN '" + startDate + "' AND '" + endDate + "'");
//
//        query.setText("SELECT tbl_siswa.*,tbl_kelas.Nama_kelas,tbl_setupkelas.* FROM tbl_setupkelas "
//                + "INNER JOIN tbl_siswa USING(Kode_siswa) INNER JOIN tbl_kelas USING (Kode_Kelas)"
//                + " where jurusan_dipilih like'%" + text_jurusan.getSelectedItem().toString() + "%' AND kode_kelas = '00' and Periode='" + text_tahun_ajaran1.getSelectedItem().toString() + "' "
//                + "AND  tanggal_daftar BETWEEN '" + startDate + "' AND '" + endDate + "'");
//        jd.setQuery(query);
//
//        JasperReport jr = JasperCompileManager.compileReport(jd);
//        JasperPrint jp = JasperFillManager.fillReport(jr, param, KoneksiDB.getConnection());
//        JasperViewer.viewReport(jp, false);

    }

    private void comboJenisPendaftaran() {
//        combobox_jenis_pendaftaran.removeAllItems();
//        text_update_jenis_pendaftaran.removeAllItems();
        String sql = "SELECT * FROM tbl_pembayaran WHERE group_kelas='Kelas 0' AND Periode='" + text_tahun_ajaran.getSelectedItem().toString() + "'ORDER BY Kode_bayar ASC";

        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                combobox_jenis_pendaftaran.addItem(rs.getString("Nama_pembayaran"));
//                text_update_jenis_pendaftaran.addItem(rs.getString("Nama_pembayaran"));

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void exportData() throws FileNotFoundException, IOException {
        viewExportedData();
        JFileChooser f = new JFileChooser();
        f.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//        f.showSaveDialog(null);
        String inputFile = System.getProperty("user.dir") + "\\laporan_ppdb.xlsx";
        System.out.println(inputFile);
        String outputFile = String.valueOf(f.getCurrentDirectory());
        try {
            FileInputStream fileInputStream = new FileInputStream(inputFile);
            Workbook workbook = WorkbookFactory.create(fileInputStream);

            Sheet sheet = workbook.getSheetAt(0);

            int lastRowCount = sheet.getLastRowNum();
            DefaultTableModel model = (DefaultTableModel) tabel_export.getModel();
            int countRowCurrent = tabel_siswa_baru.getRowCount();
            for (int i = 0; i < countRowCurrent; i++) {
                System.out.println("tes");
                System.out.println(lastRowCount);
                Row dataRow = sheet.createRow(++lastRowCount);
                dataRow.createCell(0).setCellValue(String.valueOf(model.getValueAt(i, 0)));
                dataRow.createCell(1).setCellValue(String.valueOf(model.getValueAt(i, 1)));
                dataRow.createCell(2).setCellValue(String.valueOf(model.getValueAt(i, 2)));
                dataRow.createCell(3).setCellValue(String.valueOf(model.getValueAt(i, 3)));
                dataRow.createCell(4).setCellValue(String.valueOf(model.getValueAt(i, 4)));
                dataRow.createCell(5).setCellValue(String.valueOf(model.getValueAt(i, 5)));
                dataRow.createCell(6).setCellValue(String.valueOf(model.getValueAt(i, 6)));
                dataRow.createCell(7).setCellValue(String.valueOf(model.getValueAt(i, 7)));
                dataRow.createCell(8).setCellValue(String.valueOf(model.getValueAt(i, 8)));
                dataRow.createCell(9).setCellValue(String.valueOf(model.getValueAt(i, 9)));
                dataRow.createCell(10).setCellValue(String.valueOf(model.getValueAt(i, 10)));
                dataRow.createCell(11).setCellValue(String.valueOf(model.getValueAt(i, 11)));
                dataRow.createCell(12).setCellValue(String.valueOf(model.getValueAt(i, 12)));
                dataRow.createCell(13).setCellValue(String.valueOf(model.getValueAt(i, 13)));
                dataRow.createCell(14).setCellValue(String.valueOf(model.getValueAt(i, 14)));
                dataRow.createCell(15).setCellValue(String.valueOf(model.getValueAt(i, 15)));
                dataRow.createCell(16).setCellValue(String.valueOf(model.getValueAt(i, 16)));
                dataRow.createCell(17).setCellValue(String.valueOf(model.getValueAt(i, 17)));
                dataRow.createCell(18).setCellValue(String.valueOf(model.getValueAt(i, 18)));
                dataRow.createCell(19).setCellValue(String.valueOf(model.getValueAt(i, 19)));
                dataRow.createCell(20).setCellValue(String.valueOf(model.getValueAt(i, 20)));
                dataRow.createCell(21).setCellValue(String.valueOf(model.getValueAt(i, 21)));
                dataRow.createCell(22).setCellValue(String.valueOf(model.getValueAt(i, 22)));
                dataRow.createCell(23).setCellValue(String.valueOf(model.getValueAt(i, 23)));
                dataRow.createCell(24).setCellValue(String.valueOf(model.getValueAt(i, 24)));
                dataRow.createCell(25).setCellValue(String.valueOf(model.getValueAt(i, 25)));
                dataRow.createCell(26).setCellValue(String.valueOf(model.getValueAt(i, 26)));
                dataRow.createCell(27).setCellValue(String.valueOf(model.getValueAt(i, 27)));
                dataRow.createCell(28).setCellValue(String.valueOf(model.getValueAt(i, 28)));
                dataRow.createCell(29).setCellValue(String.valueOf(model.getValueAt(i, 28)));
                dataRow.createCell(30).setCellValue(String.valueOf(model.getValueAt(i, 30)));
                dataRow.createCell(31).setCellValue(String.valueOf(model.getValueAt(i, 31)));
                dataRow.createCell(32).setCellValue(String.valueOf(model.getValueAt(i, 32)));
                dataRow.createCell(33).setCellValue(String.valueOf(model.getValueAt(i, 33)));
                dataRow.createCell(34).setCellValue(String.valueOf(model.getValueAt(i, 34)));
                dataRow.createCell(35).setCellValue(String.valueOf(model.getValueAt(i, 35)));
                dataRow.createCell(36).setCellValue(String.valueOf(model.getValueAt(i, 36)));
                dataRow.createCell(37).setCellValue(String.valueOf(model.getValueAt(i, 37)));
                dataRow.createCell(38).setCellValue(String.valueOf(model.getValueAt(i, 38)));
                dataRow.createCell(39).setCellValue(String.valueOf(model.getValueAt(i, 39)));
            }
            System.out.println("test 1");
            fileInputStream.close();
            System.out.println("tes 2");
            FileOutputStream fileOutputStream = new FileOutputStream(outputFile + "\\laporan_ppdb.xlsx");
            System.out.println(outputFile + "\\laporan_ppdb.xlsx");
            System.out.println("test 3");
            workbook.write(fileOutputStream);
            JOptionPane.showMessageDialog(null, "Export Berhasil! Lihat dokument pada " + outputFile + "\\laporan_ppdb.xlsx");
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private void viewExportedData() {
        String startDate = df.format(start_date.getDate());
        String endDate = df.format(end_date.getDate());

//        String tahunAjaran = text_tahun_ajaran1.getSelectedItem().toString();
        String[] judul = {"ID", "NAMA", "NIK", "TELEPON", "JK", "TTL", "nisn", "ASAL SEKOLAH", "AGAMA", "ALAMAT", "Transportasi", "tinggal",
            "hobi", "pip", "jurusan", "uk. Seragam", "tb", "BB", "GD", "Jarak", "waktu", "saudara", "anak ke", "AYAH", "TELEPON", "PEKERJAAN",
            "LAHIR", "PENDIDIKAN", "IBU", "TELEPON", "PEKERJAAN", "LAHIR", "PENDIDIKAN", "WALI", "TELEPON", "PEKERJAAN", "LAHIR", "PENDIDIKAN",
            "REFERENSI", "JENIS PENDAFTARAN",};
        model = new DefaultTableModel(judul, 0);
        tabel_export.setModel(model);
        String sql = "SELECT *, tbl_ppdb.* from tbl_siswa INNER JOIN tbl_ppdb using(kode_siswa)"
                + " where jurusan_dipilih like'%" + text_jurusan.getSelectedItem().toString() + "%'"
                + " AND tanggal_daftar BETWEEN '" + startDate + "' AND '" + endDate + "'"
                + " AND  (Nama_siswa like '%" + text_cari_siswa.getText() + "%'OR tbl_siswa.Kode_siswa like '%" + text_cari_siswa.getText() + "%')"
                + " ORDER BY tbl_siswa.Kode_siswa DESC";
        System.out.println(sql);
        lebarkolom();
        try {
            rs = con.createStatement().executeQuery(sql);

            while (rs.next()) {
                String id = rs.getString("Kode_siswa");
                String nama = rs.getString("Nama_siswa");
                String nik = rs.getString("nik_siswa");
                String telp = rs.getString("No_telepon");
                String jk = rs.getString("jenis_kelamin_siswa");
                String tempatLahir = rs.getString("tempat_lahir_siswa");
                String tanggalLahir = rs.getString("tanggal_lahir_siswa");
                String ttl = tempatLahir + "," + tanggalLahir;
                String nisn = rs.getString("nisn_siswa");
                String asalSekolah = rs.getString("asal_sekolah_siswa");
                String agama = rs.getString("agama_siswa");
                String alamat = rs.getString("Alamat");
                String alatTransportasi = rs.getString("alat_transportasi_siswa");
                String tinggal = rs.getString("tinggal_bersama");
                String hobi = rs.getString("hobi_siswa");
                String pip = rs.getString("pip");
                String jurusan = rs.getString("jurusan_dipilih");
                String seragam = rs.getString("ukuran_seragam_siswa");
                String tb = rs.getString("tinggi_badan_siswa");
                String bb = rs.getString("berat_badan_siswa");
                String gd = rs.getString("golongan_darah_siswa");
                String jarak = rs.getString("jarak_sekolah_siswa");
                String waktu = rs.getString("waktu_tempuh_siswa");
                String saudara = rs.getString("jumlah_saudara_siswa");
                String anakKe = rs.getString("anak_ke");
                String ayah = rs.getString("ayah").split("/")[0];
                String telponAyah = rs.getString("ayah").split("/")[1];
                String pekerjaanAyah = rs.getString("ayah").split("/")[2];
                String lahirAyah = rs.getString("ayah").split("/")[3];
                String pendidikanAyah = rs.getString("ayah").split("/")[4];
                String ibu = rs.getString("ibu").split("/")[0];
                String telponIbu = rs.getString("ibu").split("/")[1];
                String pekerjaanIbu = rs.getString("ibu").split("/")[2];
                String lahirIbu = rs.getString("ibu").split("/")[3];
                String pendidikanIbu = rs.getString("ibu").split("/")[4];
                String wali = rs.getString("wali").split("/")[0];
                String telponWali = rs.getString("ibu").split("/")[1];
                String pekerjaanWali = rs.getString("ibu").split("/")[2];
                String lahirWali = rs.getString("ibu").split("/")[3];
                String pendidikanWali = rs.getString("ibu").split("/")[4];
                String referensi = rs.getString("referensi");
                String jenisPendaftaran = rs.getString("jenis_pendaftaran");

                String[] data = {id, nama, nik, telp, jk, ttl, nisn, asalSekolah, agama, alamat, alatTransportasi, tinggal, hobi, pip, jurusan, seragam, tb, bb, gd, jarak, waktu, saudara, anakKe, ayah, telponAyah, pekerjaanAyah, lahirAyah, pendidikanAyah, ibu, telponIbu, pekerjaanIbu, lahirIbu, pendidikanIbu, wali, telponWali, pekerjaanWali, lahirWali, pendidikanWali, referensi, jenisPendaftaran};
                model.addRow(data);

            }
        } catch (Exception e) {
            System.out.println(e);

        }

    }

    public void backupData() {
        try {

            /*NOTE: Getting path to the Jar file being executed*/
 /*NOTE: YourImplementingClass-> replace with the class executing the code*/
            CodeSource codeSource = dashboard_ppdb_backup.class.getProtectionDomain().getCodeSource();
            System.out.println(codeSource);
            File jarFile = new File(codeSource.getLocation().toURI().getPath());
            String jarDir = jarFile.getParentFile().getPath();
            System.out.println(jarDir);

            System.out.println("tes 1");


            /*NOTE: Creating Database Constraints*/
            String dbName = "stm";
            String dbUser = "root";
            String dbPass = "12345678";

            /*NOTE: Creating Path Constraints for folder saving*/
 /*NOTE: Here the backup folder is created for saving inside it*/
            String folderPath = jarDir + "\\backup";

            /*NOTE: Creating Folder if it does not exist*/
            File f1 = new File(folderPath);
            f1.mkdir();

            /*NOTE: Creating Path Constraints for backup saving*/
 /*NOTE: Here the backup is saved in a folder called backup with the name backup.sql*/
            String savePath = "\"" + jarDir + "\\backup\\" + "backup.sql\"";
            String mysqlDumbPath = System.getProperty("user.dir");

            /*NOTE: Used to create a cmd command*/
            String executeCmd = mysqlDumbPath + "\\mysqldump -u" + dbUser + " -p" + dbPass + " --add-drop-database -B " + dbName + " -r " + savePath;
            System.out.println(executeCmd);

            /*NOTE: Executing the command here*/
            Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            System.out.println(runtimeProcess);
            int processComplete = runtimeProcess.waitFor();
//            while (processComplete > 0) {
//                System.out.println(processComplete);
//            }

            /*NOTE: processComplete=0 if correctly executed, will contain other values if not*/
            if (processComplete == 0) {
                System.out.println("Backup Complete");
                runtimeProcess.destroy();
            } else {
                System.out.println("Backup Failure");
            }

        } catch (URISyntaxException | IOException | InterruptedException ex) {
            JOptionPane.showMessageDialog(null, "Error at Backuprestore" + ex.getMessage());
            System.out.println(ex.getMessage());
        }

    }

    private void showSiswaOnFormEdit() {
        int i = tabel_siswa_baru.getSelectedRow();
        String sql = "SELECT *, tbl_ppdb.* from tbl_siswa INNER JOIN tbl_ppdb using(kode_siswa) where kode_siswa='" + model.getValueAt(i, 0) + "'";

        try {
            rs = con.createStatement().executeQuery(sql);
            System.out.println(sql);

            while (rs.next()) {
//                text_tahun_ajaran.setSelectedItem(rs.getString("tahun_ajaran"));
                text_nama_siswa.setText(rs.getString("Nama_siswa"));
                text_nik_siswa.setText(rs.getString("nik_siswa"));
                text_telepon_siswa.setText(rs.getString("No_telepon"));
                String jenisKelamin = rs.getString("jenis_kelamin_siswa");
                if (jenisKelamin.equals("L")) {
                    jenisKelamin = "Laki-Laki (L)";
                } else {
                    jenisKelamin = "Perempuan (P)";
                }
                combobox_jenis_kelamin_siswa.setSelectedItem(jenisKelamin);
                text_tempat_lahir_siswa.setText(rs.getString("tempat_lahir_siswa"));

                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("tanggal_lahir_siswa"));
                text_tanggal_lahir_siswa.setDate(date);

                text_nisn_siswa.setText(rs.getString("nisn_siswa"));
                text_asal_sekolah_siswa.setText(rs.getString("asal_sekolah_siswa"));
                text_agama_siswa.setText(rs.getString("agama_siswa"));
                text_alamat_siswa.setText(rs.getString("alamat_siswa"));
                text_alat_transportasi.setText(rs.getString("alat_transportasi_siswa"));
                combobox_tinggal_bersama.setSelectedItem(rs.getString("tinggal_bersama"));
                text_hobi.setText(rs.getString("hobi_siswa"));
                combobox_penerima_pip.setSelectedItem(rs.getString("pip"));
                combobox_jurusan_dipilih.setSelectedItem(rs.getString("jurusan_dipilih"));
                combobox_ukuran_seragam.setSelectedItem(rs.getString("ukuran_seragam_siswa"));
                text_tinggi_badan.setText(rs.getString("tinggi_badan_siswa"));
                text_berat_badan.setText(rs.getString("berat_badan_siswa"));
                combobox_golongan_darah.setSelectedItem(rs.getString("golongan_darah_siswa"));
                text_jarak_ke_sekolah.setText(rs.getString("jarak_sekolah_siswa"));

                text_jam_ke_sekolah.setText(rs.getString("waktu_tempuh_siswa").split(",")[0]);
                text_menit_ke_sekolah.setText(rs.getString("waktu_tempuh_siswa").split(",")[1]);
                text_jumlah_saudara.setText(rs.getString("jumlah_saudara_siswa"));
                text_anak_ke.setText(rs.getString("anak_ke"));
                combobox_jenis_pendaftaran.setSelectedItem(rs.getString("jenis_pendaftaran"));
                text_referensi.setText(rs.getString("referensi"));

                text_nama_ayah.setText(rs.getString("ayah").split("/")[0]);
                text_no_telepon_ayah.setText(rs.getString("ayah").split("/")[1]);
                text_pekerjaan_ayah.setText(rs.getString("ayah").split("/")[2]);
                text_tahun_lahir_ayah.setText(rs.getString("ayah").split("/")[3]);
                combobox_pendidikan_terakhir_ayah.setSelectedItem(rs.getString("ayah").split("/")[4]);
                text_nama_ibu.setText(rs.getString("ibu").split("/")[0]);
                text_no_telepon_ibu.setText(rs.getString("ibu").split("/")[1]);
                text_pekerjaan_ibu.setText(rs.getString("ibu").split("/")[2]);
                text_tahun_lahir_ibu.setText(rs.getString("ibu").split("/")[3]);
                combobox_pendidikan_terakhir_ibu.setSelectedItem(rs.getString("ibu").split("/")[4]);
                text_nama_wali.setText(rs.getString("wali").split("/")[0]);
                text_no_telepon_wali.setText(rs.getString("wali").split("/")[1]);
                text_pekerjaan_wali.setText(rs.getString("wali").split("/")[2]);
                text_tahun_lahir_wali.setText(rs.getString("wali").split("/")[3]);
                combobox_pendidikan_terakhir_wali.setSelectedItem(rs.getString("wali").split("/")[4]);
            }
        } catch (Exception e) {
            System.out.println("error" + e);
        }
    }

}
