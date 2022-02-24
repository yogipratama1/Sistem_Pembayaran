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

/**
 *
 * @author YOGI
 */
public class CRUDkelas extends javax.swing.JFrame {

    /**
     * Creates new form CRUDkelas
     */
    String level = UserSession.get_level();
    public CRUDkelas() {
        initComponents();
        tabelKelas();
        tIDkelas.setEnabled(false);
        btnupdate.setEnabled(false);
        tIDkelas.setText("Auto fill");
    }
    Statement st;
    Connection con = KoneksiDB.getConnection();
    ResultSet rs;
    DefaultComboBoxModel modelc;
    DefaultTableModel model;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnfrefresh = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        tCari = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblkelas = new javax.swing.JTable();
        btnkembali = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tIDkelas = new javax.swing.JTextField();
        tNamakelas = new javax.swing.JTextField();
        btnsimpan = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        btnhapus = new javax.swing.JButton();
        tgrupkelas = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnfrefresh.setBackground(new java.awt.Color(51, 51, 255));
        btnfrefresh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnfrefresh.setForeground(new java.awt.Color(255, 255, 255));
        btnfrefresh.setText("Refresh Form");
        btnfrefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfrefreshActionPerformed(evt);
            }
        });
        getContentPane().add(btnfrefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 580, 170, 48));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("CARI KELAS");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 184, 190, 30));

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
        getContentPane().add(tCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 180, 470, 40));

        tblkelas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tblkelas.setModel(new javax.swing.table.DefaultTableModel(
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
        tblkelas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblkelasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblkelas);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 240, 670, 320));

        btnkembali.setBackground(new java.awt.Color(51, 51, 255));
        btnkembali.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnkembali.setForeground(new java.awt.Color(255, 255, 255));
        btnkembali.setText("DASHBOARD");
        btnkembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkembaliActionPerformed(evt);
            }
        });
        getContentPane().add(btnkembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 170, 50));

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("KODE KELAS");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("KELAS");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("NAMA KELAS");

        tIDkelas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tIDkelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tIDkelasActionPerformed(evt);
            }
        });

        tNamakelas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tNamakelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tNamakelasActionPerformed(evt);
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

        tgrupkelas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tgrupkelas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kelas 1", "Kelas 2", "Kelas 3" }));
        tgrupkelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tgrupkelasActionPerformed(evt);
            }
        });

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(btnhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tNamakelas)
                            .addComponent(tIDkelas)
                            .addComponent(tgrupkelas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tIDkelas, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tNamakelas, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tgrupkelas, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 360, 420));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("KELOLA DATA KELAS");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 50, 460, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/bg-CRUD_1.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tIDkelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tIDkelasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tIDkelasActionPerformed

    private void tNamakelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tNamakelasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tNamakelasActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        try {

            String nama = tNamakelas.getText();
            String grup = tgrupkelas.getSelectedItem().toString();

            con.createStatement().executeUpdate("update tbl_kelas set Nama_kelas='" + nama + "',group_kelas='" + grup + "' "
                    + "where Kode_kelas ='" + model.getValueAt(tblkelas.getSelectedRow(), 0) + "'");
            JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
            Resetform();
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnupdateActionPerformed

    private void tCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tCariActionPerformed
        tabelKelas();
    }//GEN-LAST:event_tCariActionPerformed

    private void btnkembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkembaliActionPerformed
       switch (level) {
                    case "admin":
                    {
                        Dashboard dsb = new Dashboard();
                        dsb.dashAdmin();
                        dsb.setExtendedState(JFrame.MAXIMIZED_BOTH);
                        dsb.setVisible(true);
                        dispose();
                        break;
                    }
                    case "petugas":
                    {
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
    }//GEN-LAST:event_btnkembaliActionPerformed

    private void tCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tCariKeyReleased
        tabelKelas();
    }//GEN-LAST:event_tCariKeyReleased

    private void tblkelasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblkelasMouseClicked
        int i = tblkelas.getSelectedRow();
        tIDkelas.setText(model.getValueAt(i, 0).toString());
        tNamakelas.setText(model.getValueAt(i, 1).toString());
        tgrupkelas.setSelectedItem(model.getValueAt(i, 2).toString());

        //  disabled item on klik row table
        btnsimpan.setEnabled(false);
        btnupdate.setEnabled(true);
        tIDkelas.setEnabled(false);
        btnhapus.setEnabled(true);
    }//GEN-LAST:event_tblkelasMouseClicked

    private void btnfrefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfrefreshActionPerformed
        Resetform();
        btnupdate.setEnabled(false);
    }//GEN-LAST:event_btnfrefreshActionPerformed

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
        String nama = tNamakelas.getText();
        String grup = tgrupkelas.getSelectedItem().toString();

        
            if (nama.length() == 0) {
                JOptionPane.showMessageDialog(null, "Masukan Data Dengan Benar!!");
                btnupdate.setEnabled(false);
                btnhapus.setEnabled(false);

            } else {
                try {
                    ID_AUTO();
                    String id = tIDkelas.getText();
                    con.createStatement().executeUpdate("INSERT INTO tbl_kelas VALUE('"+id+"','" + nama + "','" + grup + "')");
                    JOptionPane.showMessageDialog(null, "Data Berhasil Ditambahkan");
                    Resetform();
                } catch (Exception ex) {
                    System.out.println("" + ex);
                    JOptionPane.showMessageDialog(null, "Gagal !!");
                }
            }

       

    }//GEN-LAST:event_btnsimpanActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        try {
            con.createStatement().executeUpdate("delete from tbl_kelas where Kode_kelas = '" + model.getValueAt(tblkelas.getSelectedRow(), 0) + "'");
            JOptionPane.showMessageDialog(null, "Berhasil");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal !!!");

        }
        Resetform();
    }//GEN-LAST:event_btnhapusActionPerformed

    private void tgrupkelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tgrupkelasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tgrupkelasActionPerformed

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
            java.util.logging.Logger.getLogger(CRUDkelas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CRUDkelas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CRUDkelas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CRUDkelas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CRUDkelas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnfrefresh;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnkembali;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JButton btnupdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tCari;
    private javax.swing.JTextField tIDkelas;
    private javax.swing.JTextField tNamakelas;
    private javax.swing.JTable tblkelas;
    private javax.swing.JComboBox<String> tgrupkelas;
    // End of variables declaration//GEN-END:variables

    private void tabelKelas() {
        String[] judul = {"Kode Kelas", "Nama Kelas", "Grup Kelas"};
        model = new DefaultTableModel(judul, 0);
        tblkelas.setModel(model);
        String sql = "SELECT * FROM tbl_kelas where Nama_kelas like '%" + tCari.getText() + "%'OR group_kelas like '%" + tCari.getText() + "%'";

        try {
            rs = con.createStatement().executeQuery(sql);

            while (rs.next()) {
                String id = rs.getString("Kode_kelas");
                String nama = rs.getString("Nama_kelas");
                String gk = rs.getString("group_kelas");

                String[] data = {id, nama, gk};
                model.addRow(data);
            }
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    private void Resetform() {
        tIDkelas.setText("");
        tNamakelas.setText("");

        tgrupkelas.setSelectedItem("Pilih Level");
        tabelKelas();

        btnsimpan.setEnabled(true);
        btnupdate.setEnabled(false);
        tIDkelas.setEnabled(true);
        tIDkelas.setEnabled(false);
        tIDkelas.setText("Auto Fill");

    }

    public void ID_AUTO() {
        try {
            String sql = "Select max(right(Kode_kelas,2)) as no_idkelas from tbl_kelas";
            rs = con.createStatement().executeQuery(sql);
            while (rs.next()) {
                if (rs.first() == false) {
                    tIDkelas.setText("KLS-01");

                } else {
                    rs.last();
                    int autoid = rs.getInt(1) + 1;
                    String nomor = String.valueOf(autoid);

                    for (int a = 0; a < 1; a++) {
                        nomor = nomor;
                    }
                    tIDkelas.setText("KLS-" + nomor);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "masukan data dengan benar!!");
        }
    }
}
