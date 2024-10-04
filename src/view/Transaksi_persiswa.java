/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import config.KoneksiDB;
import config.UserSession;
import config.sekolahSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author YOGI
 */
public class Transaksi_persiswa extends javax.swing.JFrame {

    /**
     * Creates new form Transaksi_persiswa
     */
    String level = UserSession.get_level();
    String user = UserSession.get_nama();

    public Transaksi_persiswa() {
        initComponents();
        tampiltransaksi();
    }
    Connection con = KoneksiDB.getConnection();
    ResultSet rs;
    DefaultTableModel model;
    DefaultTableModel modeljenis;
    PreparedStatement pst;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tbljenispembayaran = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabeltransaksi = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        nokwitansi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btncetak = new javax.swing.JButton();
        namasiswa = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        kelas = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnrefresh = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        tIDsiswa = new javax.swing.JTextField();

        tbljenispembayaran.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tbljenispembayaran);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Transaksi Siswa");

        tabeltransaksi.setModel(new javax.swing.table.DefaultTableModel(
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
        tabeltransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabeltransaksiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabeltransaksi);

        jPanel2.setBackground(new java.awt.Color(0, 255, 204));

        nokwitansi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nokwitansi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nokwitansiActionPerformed(evt);
            }
        });
        nokwitansi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nokwitansiKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("No Kwitansi   :");

        btncetak.setBackground(new java.awt.Color(102, 0, 255));
        btncetak.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btncetak.setForeground(new java.awt.Color(255, 255, 255));
        btncetak.setText("CETAK");
        btncetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncetakActionPerformed(evt);
            }
        });

        namasiswa.setEditable(false);
        namasiswa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        namasiswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namasiswaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Nama Siswa  :");

        kelas.setEditable(false);
        kelas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        kelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kelasActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Kelas              :");

        btnrefresh.setBackground(new java.awt.Color(102, 0, 255));
        btnrefresh.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnrefresh.setForeground(new java.awt.Color(255, 255, 255));
        btnrefresh.setText("Hapus transaksi");
        btnrefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrefreshActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("ID Siswa        :");

        tIDsiswa.setEditable(false);
        tIDsiswa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tIDsiswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tIDsiswaActionPerformed(evt);
            }
        });
        tIDsiswa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tIDsiswaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(180, 180, 180))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(namasiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(9, 9, 9)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tIDsiswa)
                            .addComponent(nokwitansi, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(btncetak, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kelas, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnrefresh))))
                .addGap(125, 125, 125))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nokwitansi, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tIDsiswa, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(namasiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kelas, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btncetak, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnrefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(116, 116, 116))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(428, 428, 428))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabeltransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabeltransaksiMouseClicked
        int i = tabeltransaksi.getSelectedRow();
        nokwitansi.setText(model.getValueAt(i, 0).toString());
        namasiswa.setText(model.getValueAt(i, 3).toString());
        kelas.setText(model.getValueAt(i, 4).toString());
        tIDsiswa.setText(model.getValueAt(i, 2).toString());
    }//GEN-LAST:event_tabeltransaksiMouseClicked

    private void nokwitansiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nokwitansiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nokwitansiActionPerformed

    private void nokwitansiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nokwitansiKeyReleased
        tampiltransaksi();
    }//GEN-LAST:event_nokwitansiKeyReleased

    private void btncetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncetakActionPerformed
        tampiltotal();
    }//GEN-LAST:event_btncetakActionPerformed

    private void namasiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namasiswaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namasiswaActionPerformed

    private void kelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kelasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kelasActionPerformed

    private void btnrefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrefreshActionPerformed
        String sql = "SELECT * FROM tbl_transaksi WHERE no_faktur='" + nokwitansi.getText() + "'";
        System.out.println(sql);
        try {
            rs = con.createStatement().executeQuery(sql);
            while (rs.next()) {
                String petugas = rs.getString("user");
                System.out.println(petugas);
                System.out.println(user);
                if (petugas.equals(user)) {
                    hapustransaksi();
                } else {
                    JOptionPane.showMessageDialog(null, "Tidak bisa menghapus pembayaran orang lain");

                }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            System.out.println(e);
        }


    }//GEN-LAST:event_btnrefreshActionPerformed

    private void tIDsiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tIDsiswaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tIDsiswaActionPerformed

    private void tIDsiswaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tIDsiswaKeyReleased
        tampiltransaksi();
    }//GEN-LAST:event_tIDsiswaKeyReleased

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
            java.util.logging.Logger.getLogger(Transaksi_persiswa.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transaksi_persiswa.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transaksi_persiswa.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transaksi_persiswa.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transaksi_persiswa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncetak;
    private javax.swing.JButton btnrefresh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField kelas;
    public javax.swing.JTextField namasiswa;
    private javax.swing.JTextField nokwitansi;
    public javax.swing.JTextField tIDsiswa;
    private javax.swing.JTable tabeltransaksi;
    private javax.swing.JTable tbljenispembayaran;
    // End of variables declaration//GEN-END:variables
public void tampiltransaksi() {

        String[] judul = {"No Kwitansi", "Tanggal", "ID Siswa", "Nama Siswa", "Kelas", "Jumlah Bayar", "Petugas"};
        model = new DefaultTableModel(judul, 0);
        tabeltransaksi.setModel(model);

        String sql = "SELECT tbl_siswa.Nama_siswa,tbl_transaksi.*,tbl_kelas.Nama_kelas"
                + " from tbl_transaksi INNER JOIN tbl_siswa Using(Kode_siswa)"
                + " INNER JOIN tbl_kelas Using(Kode_kelas)"
                + " Where Kode_siswa ='" + tIDsiswa.getText() + "'";

        try {
            rs = con.createStatement().executeQuery(sql);
            while (rs.next()) {
                String id = rs.getString("no_faktur");
                String tgl = rs.getString("tanggal");
                String kodesiswa = rs.getString("Kode_siswa");
                String nama = rs.getString("Nama_siswa");
                String kelas = rs.getString("Nama_kelas");
                String jml = rs.getString("Jumlah_bayar");
                String user = rs.getString("user");

                String[] data = {id, tgl, kodesiswa, nama, kelas, jml, user};
                model.addRow(data);

            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void cetaknota(int total) throws Exception {

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
                + " where no_faktur='" + nokwitansi.getText() + "'");
        jd.setQuery(query);

        JasperReport jr = JasperCompileManager.compileReport(jd);
        JasperPrint jp = JasperFillManager.fillReport(jr, param, con);
        JasperViewer.viewReport(jp, false);

    }

    public void tampiltotal() {
        String sql = "select sum(jumlah) as jumlah from tbl_dettransaksi where no_faktur='" + nokwitansi.getText() + "'";
        try {
            rs = con.createStatement().executeQuery(sql);
            while (rs.next()) {
                int jumlah = Integer.parseInt(rs.getString("jumlah"));
                cetaknota(jumlah);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void resetform() {
        nokwitansi.setText("");
        namasiswa.setText("");
        kelas.setText("");
        tIDsiswa.setText("");
    }

    public void hapustransaksi() {

        int keputusan = JOptionPane.showConfirmDialog(this, "Apakah data yang ingin dihapus sudah benar?");
        switch (keputusan) {
            case JOptionPane.YES_OPTION:
                String nokwi = nokwitansi.getText();
                String idsiswa = tIDsiswa.getText();

                String[] judul = {"Kode Bayar", "jumlah"};
                modeljenis = new DefaultTableModel(judul, 0);
                tbljenispembayaran.setModel(modeljenis);

                String sql = "Select * from tbl_dettransaksi where no_faktur='" + nokwi + "'";
                try {

                    rs = con.createStatement().executeQuery(sql);
                    while (rs.next()) {
                        String kodebiaya = rs.getString("kode_biaya");
                        String jmlbayar = rs.getString("jumlah");

                        String[] data = {kodebiaya, jmlbayar};
                        modeljenis.addRow(data);

                    }
                    int jumlahbaris = tbljenispembayaran.getRowCount();

                    int i = 0;
                    while (i < jumlahbaris) {
                        String kodebayar = tbljenispembayaran.getValueAt(i, 0).toString();
                        int jumlahbayar = Integer.parseInt(tbljenispembayaran.getValueAt(i, 1).toString());
                        String slq = "select * from tbl_dettran where kode_siswa='" + idsiswa + "' and Kode_bayar='" + kodebayar + "'";

                        try {
                            rs = con.createStatement().executeQuery(slq);
                            while (rs.next()) {
                                int hutang = Integer.parseInt(rs.getString("Hutang").split("\\.")[0]);
                                int lunas = Integer.parseInt(rs.getString("Lunas").split("\\.")[0]);

                                int updatehtg = hutang + jumlahbayar;
                                int updatelns = lunas - jumlahbayar;

                                con.createStatement().executeUpdate("update tbl_dettran set Hutang='" + updatehtg + "'"
                                        + ", Lunas='" + updatelns + "' where Kode_siswa='" + idsiswa + "' and kode_bayar='" + kodebayar + "'");
                            }
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        i++;
                    }
                    try {
                        con.createStatement().executeUpdate("delete from tbl_dettransaksi where no_faktur='" + nokwi + "'");
                        con.createStatement().executeUpdate("delete from tbl_transaksi where no_faktur='" + nokwi + "'");
                        JOptionPane.showMessageDialog(null, "Hapus Transaksi Berhasil!!");

                        tampiltransaksi();
                        resetform();

                    } catch (Exception e) {
                        System.out.println(e);
                        JOptionPane.showMessageDialog(null, e);

                    }

                } catch (Exception e) {
                    System.out.println(e);
                    JOptionPane.showMessageDialog(null, e);
                }

        }

    }

}
