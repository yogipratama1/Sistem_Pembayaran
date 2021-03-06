/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JOptionPane;
import config.KoneksiDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

/**
 *
 * @author admin
 */
public class CRUDsetTagihan extends javax.swing.JFrame {

    /**
     * Creates new form CRUDsetTagihan
     */
    DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
    DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
    
    public CRUDsetTagihan() {
        initComponents();
        comboperiode2();
        tabelSiswa();
        jmlhutang.setText("Rp. 0");

        //set mata uang
        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        kursIndonesia.setDecimalFormatSymbols(formatRp);
    }
    Statement st;
    Connection con = KoneksiDB.getConnection();
    ResultSet rs;
    PreparedStatement pst;
    DefaultTableModel model;
    
    public void comboperiode2() {
        
        String sql = "SELECT * FROM tbl_periode ";
        
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                tperiode.addItem(rs.getString("Periode"));
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    private void tabelSiswa() {
        String[] judul = {"NAMA SISWA", "KODE SISWA", "NAMA PEMBAYARAN", "KODE BAYAR", "HUTANG"};
        model = new DefaultTableModel(judul, 0);
        tblsiswa.setModel(model);
        String sql = "select *, tbl_siswa.Nama_siswa, tbl_pembayaran.nama_pembayaran from tbl_dettran"
                + " Inner join tbl_siswa Using(Kode_siswa)"
                + " inner join tbl_pembayaran USING(kode_bayar)"
                + " where Kode_siswa='" + tCari.getText() + "'"
                + " and tbl_dettran.Periode='" + tperiode.getSelectedItem() + "'";
        try {
            rs = con.createStatement().executeQuery(sql);
            
            while (rs.next()) {
                String id = rs.getString("Nama_siswa");
                String kk = rs.getString("Kode_siswa");
                String kelas = rs.getString("Nama_pembayaran");
                String kodebayar = rs.getString("kode_bayar");
                String hutang = rs.getString("Hutang");
               
                
                String[] data = {id, kk, kelas, kodebayar, hutang};
                model.addRow(data);
            }
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, e);
            
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tCari = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tIDsiswa = new javax.swing.JTextField();
        kb = new javax.swing.JTextField();
        htng = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        nmpembayaran = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblsiswa = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jmlhutang = new javax.swing.JTextField();
        tperiode = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton4.setBackground(new java.awt.Color(51, 51, 255));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("DASHBOARD");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 180, 50));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("SET TAGIHAN SISWA");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 40, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("CARI ID SISWA");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 150, 160, 40));

        tCari.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tCariActionPerformed(evt);
            }
        });
        getContentPane().add(tCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 150, 290, 40));

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Kode Siswa      :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Kode Bayar      :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Hutang             :");

        tIDsiswa.setEditable(false);
        tIDsiswa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tIDsiswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tIDsiswaActionPerformed(evt);
            }
        });

        kb.setEditable(false);
        kb.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        htng.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jButton1.setBackground(new java.awt.Color(51, 51, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("ubah");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(51, 51, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Refresh Form");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Pembayaran    :");

        nmpembayaran.setEditable(false);
        nmpembayaran.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nmpembayaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nmpembayaranActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(htng, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .addComponent(kb)
                    .addComponent(tIDsiswa)
                    .addComponent(nmpembayaran))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tIDsiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(kb, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(nmpembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(htng, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(185, 185, 185)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 360, 460));

        tblsiswa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblsiswa.setModel(new javax.swing.table.DefaultTableModel(
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
        tblsiswa.setAlignmentY(1.0F);
        tblsiswa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblsiswaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblsiswa);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 210, 730, 390));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Jumlah Kekurangan :");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 610, 230, 30));

        jmlhutang.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jmlhutang.setText("0");
        jmlhutang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmlhutangActionPerformed(evt);
            }
        });
        getContentPane().add(jmlhutang, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 610, 230, 30));

        tperiode.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tperiode.setMaximumRowCount(10);
        tperiode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Periode" }));
        tperiode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tperiodeActionPerformed(evt);
            }
        });
        getContentPane().add(tperiode, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 150, 170, 40));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setText("Cari");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 153, -1, 30));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/bg-CRUD-siswa.png"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tIDsiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tIDsiswaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tIDsiswaActionPerformed

    private void tCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tCariActionPerformed
        //        tabelAlosiswa();
        tabelSiswa();
        totaltagihan();
    }//GEN-LAST:event_tCariActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            con.createStatement().executeUpdate("update tbl_dettran set Hutang='" + htng.getText() + "' where Kode_siswa='" + tIDsiswa.getText() + "'and kode_bayar='" + kb.getText() + "'");
            JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
            tIDsiswa.setText("");
            kb.setText("");
            htng.setText("");
            tabelSiswa();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Masukan Data Dengan Benar !!");
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        tIDsiswa.setText("");
        kb.setText("");
        htng.setText("");
        nmpembayaran.setText("");
        jmlhutang.setText("Rp. 0");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Dashboard dsb = new Dashboard();
        dsb.dashAdmin();
        dsb.setExtendedState(JFrame.MAXIMIZED_BOTH);
        dsb.setVisible(false);
        dispose();;
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tperiodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tperiodeActionPerformed
        
        tabelSiswa();
        totaltagihan();
    }//GEN-LAST:event_tperiodeActionPerformed

    private void tblsiswaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblsiswaMouseClicked
        // TODO add your handling code here:
        int i = tblsiswa.getSelectedRow();
        tIDsiswa.setText(model.getValueAt(i, 1).toString());
        nmpembayaran.setText(model.getValueAt(i, 2).toString());
        kb.setText(model.getValueAt(i, 3).toString());
        htng.setText(model.getValueAt(i, 4).toString());
        tperiode.setSelectedItem(model.getValueAt(i, 0).toString());
        
    }//GEN-LAST:event_tblsiswaMouseClicked

    private void nmpembayaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nmpembayaranActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nmpembayaranActionPerformed

    private void jmlhutangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmlhutangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmlhutangActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
         new tabelsiswasettagihan().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(CRUDsetTagihan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CRUDsetTagihan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CRUDsetTagihan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CRUDsetTagihan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CRUDsetTagihan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JTextField htng;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jmlhutang;
    private javax.swing.JTextField kb;
    private javax.swing.JTextField nmpembayaran;
    public javax.swing.JTextField tCari;
    public javax.swing.JTextField tIDsiswa;
    private javax.swing.JTable tblsiswa;
    private javax.swing.JComboBox<String> tperiode;
    // End of variables declaration//GEN-END:variables

    public void totaltagihan() {
        int total = 0;
        for (int i = 0; i < tblsiswa.getRowCount(); i++) {
            int amount = Integer.parseInt((String) tblsiswa.getValueAt(i, 4));
            total += amount;
        }
        jmlhutang.setText("" + String.valueOf(kursIndonesia.format(total)));
    }
}
