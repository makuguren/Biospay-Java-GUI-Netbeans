package com.zeroone.biospay;

import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class Sections extends javax.swing.JFrame {
        
    ResultSet rs;
    Connection con;
    PreparedStatement pst;
    
    public Sections() {
        initComponents();
        con = SQLConnection.DBConnection();
        LoadSections();
        Fetch();
        ButtonsFields();
    }
    
    public void ButtonsFields(){
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
        btnSave.setEnabled(true);
    }
    
    public void ButtonsEFields(){
        btnUpdate.setEnabled(true);
        btnDelete.setEnabled(true);
        btnSave.setEnabled(false);
    }
    
    public void LoadSections(){
        try {
            pst = con.prepareStatement("SELECT id FROM sections");
            rs = pst.executeQuery();
            cbxSectionID.removeAllItems();
            while(rs.next()){
                cbxSectionID.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Sections.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void Fetch(){
        try {
            int q;
            pst = con.prepareStatement("SELECT * FROM sections");
            rs = pst.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            q = rss.getColumnCount();
            
            DefaultTableModel df = (DefaultTableModel)jTableSections.getModel();
            df.setRowCount(0);
            while(rs.next()){
                Vector v2 = new Vector();
                for(int a=1; a<=q; a++){
                    v2.add(rs.getInt("id"));
                    v2.add(rs.getString("section"));
                }
                df.addRow(v2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Sections.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSections = new javax.swing.JTable();
        txtFieldSearch = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        HeaderJPanel = new javax.swing.JPanel();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        cbxSectionID = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtFieldSectionName = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnClear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SECTIONS | BIOSPAY");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(690, 484));
        jPanel1.setMinimumSize(new java.awt.Dimension(690, 484));
        jPanel1.setPreferredSize(new java.awt.Dimension(690, 484));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableSections.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTableSections.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "SECTION"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableSections.setRowHeight(40);
        jScrollPane1.setViewportView(jTableSections);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 860, 540));

        txtFieldSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFieldSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFieldSearchKeyReleased(evt);
            }
        });
        jPanel1.add(txtFieldSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 330, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(3, 83, 164));
        jLabel6.setText("SEARCH");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 30));

        jButton1.setBackground(new java.awt.Color(3, 83, 164));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("BACK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, 150, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 860, 590));

        HeaderJPanel.setBackground(new java.awt.Color(3, 83, 164));
        HeaderJPanel.setPreferredSize(new java.awt.Dimension(0, 60));
        HeaderJPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SECTIONS | BIOSPAY");
        HeaderJPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 294, 40));

        getContentPane().add(HeaderJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, -1));

        jPanel2.setBackground(new java.awt.Color(3, 83, 164));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(3, 83, 164));
        jPanel3.setForeground(new java.awt.Color(3, 83, 164));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbxSectionID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(cbxSectionID, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 150, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ID");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, -1));

        txtFieldSectionName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel3.add(txtFieldSectionName, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 300, 40));

        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSearch.setText("SEARCH");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        jPanel3.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 140, 40));

        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel3.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 140, 40));

        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSave.setText("SAVE");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel3.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 140, 40));

        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel3.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 140, 40));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("SECTION NAME");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 150, -1));

        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnClear.setText("CLEAR");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel3.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 140, 40));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 300, 570));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 590));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            String sectionName = txtFieldSectionName.getText();
            
            //Checking for Empty Fields
            if (sectionName.isEmpty()){
                JOptionPane.showMessageDialog(null, "Please fill in all fields");
            } else {
                pst = con.prepareStatement("INSERT INTO sections (section) VALUES(?)");
                pst.setString(1, sectionName);
                int k = pst.executeUpdate();

                if(k==1){
                    JOptionPane.showMessageDialog(this,"Section Added Successfully!");

                    txtFieldSectionName.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "Section Failed!");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Sections.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            String sectionName = txtFieldSectionName.getText();
            String sectionId = cbxSectionID.getSelectedItem().toString();
            
            //Checking for Empty Fields
            if (sectionName.isEmpty() || sectionId.isEmpty()){
                JOptionPane.showMessageDialog(null, "Please fill in all fields");
            } else {
                pst = con.prepareStatement("UPDATE sections SET section=? WHERE id = ?");
                pst.setString(1, sectionName);
                pst.setString(2, sectionId);
                int k = pst.executeUpdate();

                if(k==1){
                    JOptionPane.showMessageDialog(this,"Section Updated Successfully!");
                    txtFieldSectionName.setText("");
                    ButtonsFields();
                } else {
                    JOptionPane.showMessageDialog(this, "Section Failed!");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Sections.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            String sectionId = cbxSectionID.getSelectedItem().toString();
            pst = con.prepareStatement("DELETE FROM sections where id = " + sectionId + " ;");
            int k = pst.executeUpdate();
            
            if(k==1){
                JOptionPane.showMessageDialog(this,"Section Deleted Successfully!");    
                txtFieldSectionName.setText("");
                ButtonsFields();
            } else {
                JOptionPane.showMessageDialog(this, "Contribution Failed!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Sections.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        Fetch();
        LoadSections();
    }//GEN-LAST:event_formWindowActivated

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        try {
            String sectionId = cbxSectionID.getSelectedItem().toString();
            pst = con.prepareStatement("SELECT * FROM sections WHERE id = ?");
            pst.setString(1, sectionId);
            rs = pst.executeQuery();
            
            if(rs.next() == true){
                txtFieldSectionName.setText(rs.getString(2));
                ButtonsEFields();
            } else {
                JOptionPane.showMessageDialog(this,"No Sections Found!"); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(Sections.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Dashboard mainmenu = new Dashboard();
        mainmenu.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtFieldSectionName.setText("");
        ButtonsFields();
    }//GEN-LAST:event_btnClearActionPerformed

    private void txtFieldSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldSearchKeyReleased
        String searchText = txtFieldSearch.getText();
        DefaultTableModel model = (DefaultTableModel) jTableSections.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        jTableSections.setRowSorter(sorter);

        RowFilter<DefaultTableModel, Object> rowFilter = RowFilter.regexFilter("(?i)" + searchText);
        sorter.setRowFilter(rowFilter);
    }//GEN-LAST:event_txtFieldSearchKeyReleased

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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sections().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel HeaderJPanel;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbxSectionID;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableSections;
    private javax.swing.JTextField txtFieldSearch;
    private javax.swing.JTextField txtFieldSectionName;
    // End of variables declaration//GEN-END:variables
}
