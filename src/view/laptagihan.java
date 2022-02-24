/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import config.KoneksiDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
 * @author admin
 */
public class laptagihan extends javax.swing.JFrame {

    /**
     * Creates new form laptagihan
     */
    public laptagihan() {
        initComponents();
        combokelaspilih();
        comboPeriode();
        btnlaporan.setEnabled(false);

    }

    Statement st;
    Connection con = KoneksiDB.getConnection();
    ResultSet rs;
    PreparedStatement pst;

    public void combokelaspilih() {

        String sql = "SELECT * FROM tbl_kelas ";

        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                pilihkelas.addItem(rs.getString("nama_Kelas"));
            }

        } catch (Exception e) {
        }
    }

    public void laporanPembayaran() throws Exception {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        JasperDesign jd = JRXmlLoader.load(getClass().getResourceAsStream("/laporan/Raporttagihan.jrxml"));
        JRDesignQuery query = new JRDesignQuery();

        if (id.isSelected()) {
            query.setText("SELECT tbl_dettran.*,tbl_kelas.Nama_kelas,"
                    + "tbl_pembayaran.Nama_pembayaran,"
                    + " tbl_siswa.Nama_siswa FROM tbl_dettran "
                    + " INNER JOIN tbl_kelas USING(Kode_kelas) "
                    + " INNER JOIN tbl_pembayaran USING(kode_bayar)"
                    + " INNER join tbl_siswa USING(Kode_siswa) "
                    + "WHERE Hutang>0 AND Kode_siswa='" + idsiswa.getText() + "'");
            jd.setQuery(query);
        } else if (kelas.isSelected()) {
            query.setText("SELECT tbl_dettran.*,tbl_kelas.Nama_kelas,"
                    + "tbl_pembayaran.Nama_pembayaran,"
                    + " tbl_siswa.Nama_siswa FROM tbl_dettran "
                    + " INNER JOIN tbl_kelas USING(Kode_kelas) "
                    + " INNER JOIN tbl_pembayaran USING(kode_bayar)"
                    + " INNER join tbl_siswa USING(Kode_siswa)"
                    + " WHERE Hutang>0 AND Nama_kelas='" + pilihkelas.getSelectedItem() + "' "
                            + " and tbl_dettran.Periode='"+cbperiode.getSelectedItem()+"'"
                                    + " ORDER BY Kode_siswa ASC");
            jd.setQuery(query);
        }
        JasperReport jr = JasperCompileManager.compileReport(jd);
        JasperPrint jp = JasperFillManager.fillReport(jr, null, KoneksiDB.getConnection());
        JasperViewer.viewReport(jp, false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        kelas = new javax.swing.JRadioButton();
        idsiswa = new javax.swing.JTextField();
        id = new javax.swing.JRadioButton();
        pilihkelas = new javax.swing.JComboBox<>();
        btnlaporan = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        cbperiode = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        buttonGroup1.add(kelas);
        kelas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        kelas.setText("Berdasarkan Kelas");
        kelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kelasActionPerformed(evt);
            }
        });

        buttonGroup1.add(id);
        id.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        id.setText("Berdasarkan ID Siswa");
        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });

        btnlaporan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnlaporan.setText("Lihat Laporan");
        btnlaporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlaporanActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Laporan Kekurangan Pembayaran Siswa");

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("Cari Siswa");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        cbperiode.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbperiode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Periode" }));
        cbperiode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbperiodeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnlaporan)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(id)
                            .addComponent(kelas))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(idsiswa)
                            .addComponent(pilihkelas, 0, 150, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(cbperiode, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(126, 126, 126))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idsiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(id)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pilihkelas, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kelas)
                    .addComponent(cbperiode, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(btnlaporan, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnlaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlaporanActionPerformed
        // TODO add your handling code here:
        try {
            laporanPembayaran();
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_btnlaporanActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new tabelsiswa2().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        btnlaporan.setEnabled(true);
    }//GEN-LAST:event_idActionPerformed

    private void kelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kelasActionPerformed
        btnlaporan.setEnabled(true);
    }//GEN-LAST:event_kelasActionPerformed

    private void cbperiodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbperiodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbperiodeActionPerformed

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
            java.util.logging.Logger.getLogger(laptagihan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(laptagihan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(laptagihan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(laptagihan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new laptagihan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnlaporan;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbperiode;
    private javax.swing.JRadioButton id;
    public javax.swing.JTextField idsiswa;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton kelas;
    private javax.swing.JComboBox<String> pilihkelas;
    // End of variables declaration//GEN-END:variables
 private void comboPeriode() {

        String sql = "SELECT * FROM tbl_periode ";

        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                cbperiode.addItem(rs.getString("Periode"));

            }
        } catch (Exception e) {
        }
    }

}