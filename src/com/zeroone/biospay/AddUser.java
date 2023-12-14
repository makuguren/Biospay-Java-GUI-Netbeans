package com.zeroone.biospay;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AddUser extends javax.swing.JFrame {
    
    ResultSet rs;
    Connection con;
    PreparedStatement pst;
    
    public AddUser() {
        initComponents();
        con = SQLConnection.DBConnection();
        FetchSection();
    }
        
    public void FetchSection(){
        try {
            pst = con.prepareStatement("SELECT section FROM sections");
            rs = pst.executeQuery();
            cbxSection.removeAllItems();
            while(rs.next()){
                cbxSection.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtFieldStudentID = new javax.swing.JTextField();
        txtFieldName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbxSection = new javax.swing.JComboBox<>();
        txtFieldEmail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtFieldPassword = new javax.swing.JPasswordField();
        btnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ADD USER | BIOSPAY");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(3, 83, 164));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ADD USER | BIOSPAY");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 50));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("STUDENT ID");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 30));

        txtFieldStudentID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel3.add(txtFieldStudentID, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 730, 35));

        txtFieldName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel3.add(txtFieldName, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 730, 35));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("NAME");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 730, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("SECTION");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 730, 30));

        cbxSection.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbxSection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BSIT 3A", "BSIT 3B", "BSIT 3C" }));
        jPanel3.add(cbxSection, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 730, 35));

        txtFieldEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel3.add(txtFieldEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 730, 35));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("EMAIL");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 730, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("PASSWORD");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 730, 30));
        jPanel3.add(txtFieldPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 730, 35));

        btnSave.setBackground(new java.awt.Color(3, 83, 164));
        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("SAVE");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel3.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 360, 150, 40));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 730, 410));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 850, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            String studentID = txtFieldStudentID.getText();
            String fullName = txtFieldName.getText();
            String section = cbxSection.getSelectedItem().toString();
            String email = txtFieldEmail.getText();
            String password = txtFieldPassword.getText();
            
            //Checking for Empty Fields
            if (studentID.isEmpty() || fullName.isEmpty() || section.isEmpty() || email.isEmpty() || password.isEmpty()){
                JOptionPane.showMessageDialog(null, "Please fill in all fields");
            } else {
                //Check for Duplication
                pst = con.prepareStatement("SELECT * FROM users WHERE student_id = ?");
                pst.setString(1, studentID);
                rs = pst.executeQuery();
                
                if (rs.next()){
                    JOptionPane.showMessageDialog(null, "Account has already exists!");
                } else {
                    pst = con.prepareStatement("INSERT INTO users (student_id,name,section,email,password)VALUES(?,?,?,?,?)");
                    pst.setString(1, studentID);
                    pst.setString(2, fullName);
                    pst.setString(3, section);
                    pst.setString(4, email);
                    pst.setString(5, password);
                    int k = pst.executeUpdate();

                    //Adding Payments list also
                    pst = con.prepareStatement("INSERT INTO payments (student_id)VALUES(?)");
                    pst.setString(1, studentID);
                    pst.executeUpdate();

                    if(k==1){
                        JOptionPane.showMessageDialog(this,"User Added Successfully!"); 
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(this, "User Failed!");
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSaveActionPerformed

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
            java.util.logging.Logger.getLogger(AddUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cbxSection;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txtFieldEmail;
    private javax.swing.JTextField txtFieldName;
    private javax.swing.JPasswordField txtFieldPassword;
    private javax.swing.JTextField txtFieldStudentID;
    // End of variables declaration//GEN-END:variables
}
