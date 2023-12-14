package com.zeroone.biospay;

import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class Contributions extends javax.swing.JFrame {
        
    ResultSet rs;
    Connection con;
    PreparedStatement pst;
    
    public Contributions() {
        initComponents();
        con = SQLConnection.DBConnection();
        LoadContributions();
        Fetch();
        ButtonsFields();
    }
    
    public void LoadContributions(){
        try {
            pst = con.prepareStatement("SELECT id FROM contributions");
            rs = pst.executeQuery();
            cbxContriID.removeAllItems();
            while(rs.next()){
                cbxContriID.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Contributions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void Fetch(){
        try {
            int q;
            pst = con.prepareStatement("SELECT * FROM contributions");
            rs = pst.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            q = rss.getColumnCount();
            
            DefaultTableModel df = (DefaultTableModel)jTableContri.getModel();
            df.setRowCount(0);
            while(rs.next()){
                Vector v2 = new Vector();
                for(int a=1; a<=q; a++){
                    v2.add(rs.getInt("id"));
                    v2.add(rs.getString("contribution_name"));
                    v2.add(rs.getString("price"));
                }
                df.addRow(v2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Contributions.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableContri = new javax.swing.JTable();
        txtFieldSearch = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        HeaderJPanel = new javax.swing.JPanel();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txtOldColName = new javax.swing.JLabel();
        cbxContriID = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtFieldContriName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtFieldPrice = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CONTRIBUTIONS | BIOSPAY");
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

        jTableContri.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTableContri.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CONTRIBUTION NAME", "PRICE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableContri.setRowHeight(40);
        jScrollPane1.setViewportView(jTableContri);

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
        jLabel1.setText("CONTRIBUTIONS | BIOSPAY");
        HeaderJPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 294, 40));

        getContentPane().add(HeaderJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, -1));

        jPanel2.setBackground(new java.awt.Color(3, 83, 164));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(3, 83, 164));
        jPanel3.setForeground(new java.awt.Color(3, 83, 164));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtOldColName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtOldColName.setForeground(new java.awt.Color(255, 255, 255));
        txtOldColName.setText("OLD COLUMN NAME");
        jPanel3.add(txtOldColName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 150, -1));

        cbxContriID.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(cbxContriID, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 150, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ID");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, -1));

        txtFieldContriName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel3.add(txtFieldContriName, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 300, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("CONTRIBUTION NAME");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 300, -1));

        txtFieldPrice.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel3.add(txtFieldPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 300, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("PRICE");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 300, -1));

        btnSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSearch.setText("SEARCH");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        jPanel3.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 140, 40));

        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnClear.setText("CLEAR");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        jPanel3.add(btnClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 140, 40));

        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSave.setText("SAVE");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel3.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 140, 40));

        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnUpdate.setText("UPDATE");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel3.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 140, 40));

        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDelete.setText("DELETE");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel3.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 140, 40));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 300, 570));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 340, 590));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            String contriContName = txtFieldContriName.getText();
            String contriPrice = txtFieldPrice.getText();
            String conriColName = contriContName.replaceAll("\\s", "_");
            
            //Checking for Empty Fields
            if (contriContName.isEmpty() || contriPrice.isEmpty()){
                JOptionPane.showMessageDialog(null, "Please fill in all fields");
            } else {
                pst = con.prepareStatement("INSERT INTO contributions (contribution_name,column_name,price) VALUES(?,?,?)");
                pst.setString(1, contriContName);
                pst.setString(2, conriColName);
                pst.setString(3, contriPrice);
                pst.executeUpdate();

                pst = con.prepareStatement("ALTER TABLE payments ADD COLUMN " + conriColName + " varchar(250) DEFAULT 'NOT PAYED';");
                int k = pst.executeUpdate();
                if(k==0){
                    JOptionPane.showMessageDialog(this,"Contribution Added Successfully!");

                    txtFieldContriName.setText("");
                    txtFieldPrice.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "Contribution Failed!");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Contributions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            String oldColName = txtOldColName.getText();
            String contriContName = txtFieldContriName.getText();
            String contriPrice = txtFieldPrice.getText();
            String contriColName = contriContName.replaceAll("\\s", "_");
            String contriID = cbxContriID.getSelectedItem().toString();
            
            //Checking for Empty Fields
            if (contriContName.isEmpty() || contriContName.isEmpty() || contriPrice.isEmpty() || contriID.isEmpty()){
                JOptionPane.showMessageDialog(null, "Please fill in all fields");
            } else {
                pst = con.prepareStatement("UPDATE contributions SET column_name=?,contribution_name=?,price=? WHERE id = ?");
                pst.setString(1, contriColName);
                pst.setString(2, contriContName);
                pst.setString(3, contriPrice);
                pst.setString(4, contriID);
                pst.executeUpdate();

                pst = con.prepareStatement("ALTER TABLE payments CHANGE " + oldColName +  " " + contriColName + " varchar(250);");
                int k = pst.executeUpdate();

                if(k==0){
                    JOptionPane.showMessageDialog(this,"Contribution Updated Successfully!");

                    txtFieldContriName.setText("");
                    txtFieldPrice.setText("");
                    txtOldColName.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(this, "Contribution Failed!");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Contributions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtFieldContriName.setText("");
        txtFieldPrice.setText("");
        ButtonsFields();
    }//GEN-LAST:event_btnClearActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        Fetch();
        LoadContributions();
        txtOldColName.setVisible(false);
    }//GEN-LAST:event_formWindowActivated

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        try {
            String contriID = cbxContriID.getSelectedItem().toString();
            pst = con.prepareStatement("SELECT * FROM contributions WHERE id = ?");
            pst.setString(1, contriID);
            rs = pst.executeQuery();
            
            if(rs.next() == true){
                txtOldColName.setText(rs.getString(2));
                txtFieldContriName.setText(rs.getString(3));
                txtFieldPrice.setText(rs.getString(4));
                ButtonsEFields();
                
                txtOldColName.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this,"No User Found!"); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(Contributions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Dashboard mainmenu = new Dashboard();
        mainmenu.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            String contriID = cbxContriID.getSelectedItem().toString();
            String oldColName = txtOldColName.getText();
            pst = con.prepareStatement("DELETE FROM contributions where id = " + contriID + " ;");
            pst.executeUpdate();
            
            pst = con.prepareStatement("ALTER TABLE payments DROP COLUMN " + oldColName + " ;");
            int k = pst.executeUpdate();
            
            if(k==0){
                JOptionPane.showMessageDialog(this,"Contribution Deleted Successfully!");
                
                txtFieldContriName.setText("");
                txtFieldPrice.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Contribution Failed!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Contributions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void txtFieldSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldSearchKeyReleased
        String searchText = txtFieldSearch.getText();
        DefaultTableModel model = (DefaultTableModel) jTableContri.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        jTableContri.setRowSorter(sorter);

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
                new Contributions().setVisible(true);
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
    private javax.swing.JComboBox<String> cbxContriID;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableContri;
    private javax.swing.JTextField txtFieldContriName;
    private javax.swing.JTextField txtFieldPrice;
    private javax.swing.JTextField txtFieldSearch;
    private javax.swing.JLabel txtOldColName;
    // End of variables declaration//GEN-END:variables
}
