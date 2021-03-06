/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import config.KoneksiDB;
import config.UserSession;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author YOGI
 */
public class CRUDalosiswa extends javax.swing.JFrame {

    /**
     * Creates new form CRUDalsiswa
     */
    String id = UserSession.get_id();
    String username = UserSession.get_username();
    String level = UserSession.get_level();
    
    public CRUDalosiswa() {
        initComponents();
        tabelSiswa();
        comboPeriode();
        combokelas();

//        tabelAlosiswa();
        tnamasiswa.setEnabled(false);
        btnupdate.setEnabled(false);
        btnhapus.setEnabled(false);
        
        tnamasiswa.setText("");
        
    }
    Statement st;
    Connection con = KoneksiDB.getConnection();
    ResultSet rs;
    PreparedStatement pst;
    DefaultComboBoxModel modelc;
    DefaultTableModel modelalosiswa;
    DefaultTableModel model;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        tCari = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblsiswa = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tnamasiswa = new javax.swing.JTextField();
        btnsimpan = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        tperiode = new javax.swing.JComboBox<>();
        tIDsiswa = new javax.swing.JTextField();
        tkelas = new javax.swing.JComboBox<>();
        kodekelas = new javax.swing.JLabel();
        alosiswa = new javax.swing.JLabel();
        BG = new javax.swing.JLabel();
        tgrupkelas = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(51, 51, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Refresh Form");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 563, 150, 50));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setText("CARI SISWA");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 180, 190, 30));

        tCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tCariActionPerformed(evt);
            }
        });
        tCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tCariKeyReleased(evt);
            }
        });
        getContentPane().add(tCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 180, 470, 40));

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
        tblsiswa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblsiswaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblsiswa);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 240, 670, 320));

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

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jButton2.setBackground(new java.awt.Color(102, 102, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Cari");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("PERIODE");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("NAMA");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("KELAS");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("ID SISWA");

        tnamasiswa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tnamasiswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnamasiswaActionPerformed(evt);
            }
        });

        btnsimpan.setBackground(new java.awt.Color(51, 51, 255));
        btnsimpan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnsimpan.setForeground(new java.awt.Color(255, 255, 255));
        btnsimpan.setText("SIMPAN");
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });

        btnupdate.setBackground(new java.awt.Color(255, 102, 51));
        btnupdate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnupdate.setForeground(new java.awt.Color(255, 255, 255));
        btnupdate.setText("UBAH");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });

        btnhapus.setBackground(new java.awt.Color(153, 153, 0));
        btnhapus.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnhapus.setForeground(new java.awt.Color(255, 255, 255));
        btnhapus.setText("HAPUS");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });

        tperiode.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tperiode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Periode" }));
        tperiode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tperiodeActionPerformed(evt);
            }
        });

        tIDsiswa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tIDsiswa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tIDsiswaMouseEntered(evt);
            }
        });
        tIDsiswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tIDsiswaActionPerformed(evt);
            }
        });

        tkelas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tkelas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Kelas" }));
        tkelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tkelasActionPerformed(evt);
            }
        });

        kodekelas.setText("~");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btnupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(73, 73, 73)
                                .addComponent(tnamasiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5))
                                .addGap(54, 54, 54)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(tperiode, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tkelas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(kodekelas, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(14, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(46, 46, 46)
                        .addComponent(tIDsiswa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tIDsiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tnamasiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tkelas, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kodekelas))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tperiode, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(196, 196, 196)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 360, 470));

        alosiswa.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        alosiswa.setForeground(new java.awt.Color(255, 255, 255));
        alosiswa.setText("ALOKASI SISWA");
        getContentPane().add(alosiswa, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 40, 330, 40));

        BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/bg-CRUD-siswa.png"))); // NOI18N
        getContentPane().add(BG, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -20, 1410, 720));

        tgrupkelas.setText("~");
        getContentPane().add(tgrupkelas, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 290, 60, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tnamasiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnamasiswaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tnamasiswaActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        int i = tblsiswa.getSelectedRow();
        
        try {
            
            String kelas = kodekelas.getText();
            String periodetbl = model.getValueAt(i, 3).toString();
            String periodecombo = tperiode.getSelectedItem().toString();
            String id = tIDsiswa.getText();
            
            con.createStatement().executeUpdate("UPDATE tbl_setupkelas set Periode='" + periodecombo + "', Kode_kelas='" + kelas + "'"
                    + " WHERE Kode_siswa ='" + id + "' and Periode='" + periodetbl + "'");
            
            con.createStatement().executeUpdate("update tbl_dettran set Kode_kelas='" + kelas + "',Periode='" + periodecombo + "' "
                    + "Where Kode_siswa='"+id+"' and Periode='"+periodetbl+"'");
            JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
            Resetform();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Masukan Data Dengan Benar !!");
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnupdateActionPerformed

    private void tCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tCariActionPerformed
//        tabelAlosiswa();
        tabelSiswa();
    }//GEN-LAST:event_tCariActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        switch (level) {
                    case "admin":
                    {
                        Dashboard dsb = new Dashboard();
                        dsb.dashAdmin();
                        dsb.setExtendedState(JFrame.MAXIMIZED_BOTH);
                        dsb.setVisible(false);
                        dispose();
                        break;
                    }
                    case "petugas":
                    {
                        Dashboard dsb = new Dashboard();
                        dsb.dashPetugas();
                        dsb.setExtendedState(JFrame.MAXIMIZED_BOTH);
                        dsb.setVisible(false);
                        dispose();
                        break;
                    }
                    default:
                    break;
                }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tCariKeyReleased
        tabelSiswa();
    }//GEN-LAST:event_tCariKeyReleased

    private void tblsiswaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblsiswaMouseClicked
        
        int i = tblsiswa.getSelectedRow();
        tIDsiswa.setText(model.getValueAt(i, 0).toString());
        tnamasiswa.setText(model.getValueAt(i, 1).toString());
        tperiode.setSelectedItem(model.getValueAt(i, 3).toString());
        tkelas.setSelectedItem(model.getValueAt(i, 2).toString());

        //  disabled item on klik row table
        btnsimpan.setEnabled(false);
        btnupdate.setEnabled(true);
        btnhapus.setEnabled(true);
        tIDsiswa.setEnabled(false);
    }//GEN-LAST:event_tblsiswaMouseClicked

    private void tperiodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tperiodeActionPerformed

//        String periode = tperiode.getSelectedItem().toString();
//        String sql = "SELECT * FROM  tbl_tahunajaran where periode='" + periode + "'";
//
//        try {
//            rs = con.createStatement().executeQuery(sql);
//            while (rs.next()) {
//                idTA.setText(rs.getString("id_ta"));
//            }
//
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Data Tidak Dapat Muncul");
//        }

    }//GEN-LAST:event_tperiodeActionPerformed

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
        
        String idsiswa = tIDsiswa.getText();
        String periode = tperiode.getSelectedItem().toString();
        String kelas = kodekelas.getText();
        String GK = tgrupkelas.getText();
//        System.out.println(GK);

        if (idsiswa.length() == 0) {
            JOptionPane.showMessageDialog(null, "Masukan data ID dengan benar!!");
            Resetform();
            
        } else {
            try {
                con.createStatement().executeUpdate("INSERT INTO tbl_setupkelas VALUE('" + periode + "','" + idsiswa + "','" + kelas + "')");
                
                String sql = "Select * from tbl_pembayaran where periode='" + periode + "' and group_kelas='" + GK + "'";
                try {
                    
                    rs = con.createStatement().executeQuery(sql);
                    while (rs.next()) {
                        String kodebayar = rs.getString("Kode_bayar");
                        String biaya = rs.getString("Biaya");
                        String grupkelas = rs.getString("group_kelas");
                        
                        try {
                            con.createStatement().executeUpdate("insert into tbl_dettran value('" + periode + "','" + idsiswa + "',"
                                    + "'" + kelas + "','" + kodebayar + "','" + biaya + "','0','" + grupkelas + "')");
                        } catch (Exception e) {
                            System.out.println("input ke tbl_dettran salah" + e);
                        }
                    }
                } catch (Exception e) {
                    System.out.println("view database salah " + e);
                }
                
                JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
                Resetform();
            } catch (Exception e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "Masukan Data Dengan Benar");
                
            }
        }
        

    }//GEN-LAST:event_btnsimpanActionPerformed

    private void tIDsiswaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tIDsiswaMouseEntered
        isiIDsiswa();
    }//GEN-LAST:event_tIDsiswaMouseEntered

    private void tIDsiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tIDsiswaActionPerformed
        isiIDsiswa();
    }//GEN-LAST:event_tIDsiswaActionPerformed

    private void tkelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tkelasActionPerformed
        String kelas = tkelas.getSelectedItem().toString();
        String sql = "SELECT * FROM  tbl_kelas where Nama_kelas='" + kelas + "'";
        try {
            rs = con.createStatement().executeQuery(sql);
            while (rs.next()) {
                kodekelas.setText(rs.getString("Kode_kelas"));
                tgrupkelas.setText(rs.getString("group_kelas"));
            }
            
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tkelasActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        try {
            String id = tIDsiswa.getText();
            String periode = tperiode.getSelectedItem().toString();
            con.createStatement().executeUpdate("DELETE FROM tbl_setupkelas where Kode_siswa ='" + id + "' and Periode='" + periode + "'");
            con.createStatement().executeUpdate("Delete from tbl_dettran where Kode_siswa='"+id+"' and Periode='"+periode+"'");
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus !!");
            Resetform();
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnhapusActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Resetform();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new tabelalosiswa().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(CRUDalosiswa.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
            
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CRUDalosiswa.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
            
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CRUDalosiswa.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
            
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CRUDalosiswa.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CRUDalosiswa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BG;
    private javax.swing.JLabel alosiswa;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JButton btnupdate;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel kodekelas;
    private javax.swing.JTextField tCari;
    public javax.swing.JTextField tIDsiswa;
    private javax.swing.JTable tblsiswa;
    private javax.swing.JLabel tgrupkelas;
    private javax.swing.JComboBox<String> tkelas;
    public javax.swing.JTextField tnamasiswa;
    private javax.swing.JComboBox<String> tperiode;
    // End of variables declaration//GEN-END:variables

    private void tabelSiswa() {
        String[] judul = {"ID SISWA", "NAMA SISWA", "KELAS", "PERIODE"};
        model = new DefaultTableModel(judul, 0);
        tblsiswa.setModel(model);
        String sql = "SELECT tbl_siswa.Kode_siswa, tbl_siswa.Nama_siswa,tbl_periode.*,tbl_kelas.nama_kelas"
                + " FROM tbl_setupkelas INNER JOIN tbl_siswa USING(Kode_siswa)"
                + " INNER JOIN tbl_periode USING(Periode)"
                + " INNER JOIN tbl_kelas USING(Kode_kelas)"
                + " where Nama_siswa like '%" + tCari.getText() + "%'OR Kode_siswa like '%" + tCari.getText() + "' ORDER BY Kode_siswa ASC";
        
        try {
            rs = con.createStatement().executeQuery(sql);
            
            while (rs.next()) {
                String id = rs.getString("Kode_siswa");
                String nama = rs.getString("Nama_siswa");
                String kelas = rs.getString("Nama_kelas");
                String periode = rs.getString("Periode");
                
                String[] data = {id, nama, kelas, periode};
                model.addRow(data);
            }
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, e);
            
        }
    }
    
    private void isiIDsiswa() {
        String sql = "select * from tbl_siswa where Kode_siswa='" + tIDsiswa.getText() + "'";
        try {
            rs = con.createStatement().executeQuery(sql);
            while (rs.next()) {
                tIDsiswa.setText(rs.getString("Kode_siswa"));
                tnamasiswa.setText(rs.getString("Nama_siswa"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
    }
    
    private void comboPeriode() {
        String sql = "SELECT * FROM tbl_periode";
        
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                tperiode.addItem(rs.getString("Periode"));
                
            }
        } catch (Exception e) {
        }
    }
    
    private void combokelas() {
        
        String sql = "SELECT * FROM tbl_kelas ";
        
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                tkelas.addItem(rs.getString("Nama_kelas"));
                
            }
            
        } catch (Exception e) {
        }
    }

//    public void ID_AUTO() {
//        try {
//            String sql = "Select max(id_alosiswa) as no_idalosiswa from tbl_alosiswa";
//            rs = con.createStatement().executeQuery(sql);
//            while (rs.next()) {
//                if (rs.first() == false) {
//                    tIDalosiswa.setText("1");
//
//                } else {
//                    rs.last();
//                    int autoid = rs.getInt(1) + 1;
//                    String nomor = String.valueOf(autoid);
//
//                    for (int a = 0; a < 3; a++) {
//                        nomor = nomor;
//                    }
//                    tIDalosiswa.setText(nomor);
//                }
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//            JOptionPane.showMessageDialog(null, "Error Pengalokasian");
//        }
//    }
    private void Resetform() {
        tIDsiswa.setText("");
        tnamasiswa.setText("");
        tkelas.setSelectedItem("Pilih Kelas");
        tperiode.setSelectedItem("Pilih Periode");
        kodekelas.setText("~");
        tgrupkelas.setText("~");
        
        tabelSiswa();
        
        btnsimpan.setEnabled(true);
        btnupdate.setEnabled(false);
        tIDsiswa.setEnabled(true);
        btnhapus.setEnabled(false);
        tnamasiswa.setEnabled(false);
        
    }
    
}
