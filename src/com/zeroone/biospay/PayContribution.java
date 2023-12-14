package com.zeroone.biospay;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class PayContribution extends javax.swing.JFrame {
    
    ResultSet rs;
    Connection con;
    PreparedStatement pst;
    
    public PayContribution() {
        initComponents();
        con = SQLConnection.DBConnection();
        DefaultConfig();
        fetchContributions();
    }
    
    public void Connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/paymentms","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PayContribution.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PayContribution.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void DefaultConfig(){
        txtFieldName.setEnabled(false);
        txtFieldSection.setEnabled(false);
        cbxSelectPayment.setEnabled(false);
        btnPay.setEnabled(false);
        
        txtFieldName.setText("");
        txtFieldSection.setText("");
    }
    
    public void fetchContributions(){
        try {
            pst = con.prepareStatement("SELECT contribution_name FROM contributions");
            rs = pst.executeQuery();
            cbxSelectPayment.removeAllItems();
            while(rs.next()){
                cbxSelectPayment.addItem(rs.getString(1).toUpperCase());
            }
        } catch (SQLException ex) {
            Logger.getLogger(PayContribution.class.getName()).log(Level.SEVERE, null, ex);
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
        txtFieldSection = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnPay = new javax.swing.JButton();
        txtFieldName = new javax.swing.JTextField();
        cbxSelectPayment = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PAY CONTRIBUTION | BIOSPAY");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(3, 83, 164));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PAY CONTRIBUTION | BIOSPAY");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 50));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("ENTER STUDENT ID");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 30));

        txtFieldStudentID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFieldStudentID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldStudentIDActionPerformed(evt);
            }
        });
        jPanel3.add(txtFieldStudentID, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 730, 35));

        txtFieldSection.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel3.add(txtFieldSection, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 730, 35));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("NAME");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 730, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("SECTION");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 730, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("SELECT PAYMENT");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 730, 30));

        btnPay.setBackground(new java.awt.Color(3, 83, 164));
        btnPay.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPay.setForeground(new java.awt.Color(255, 255, 255));
        btnPay.setText("PAY");
        btnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayActionPerformed(evt);
            }
        });
        jPanel3.add(btnPay, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 360, 150, 40));

        txtFieldName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel3.add(txtFieldName, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 730, 35));

        cbxSelectPayment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(cbxSelectPayment, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 240, 720, 35));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 730, 410));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 850, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayActionPerformed
        try {
            String contributionName = cbxSelectPayment.getSelectedItem().toString();
            String studentID = txtFieldStudentID.getText();
            
            pst = con.prepareStatement("SELECT column_name FROM contributions WHERE contribution_name LIKE \'%" + contributionName + "%\'");
            rs = pst.executeQuery();
            
            if(rs.next()){
                String columnName = (rs.getString(1));
                
                //Check if the User is Already Payed the Contribution
                pst = con.prepareStatement("SELECT * FROM payments WHERE " + columnName + " = 'PAYED'");
                rs = pst.executeQuery();
                if(rs.next()){
                    JOptionPane.showMessageDialog(this, "You Have already Payed this Contribution!");
                } else {
                    
                    //Set Contribution as "PAYED"
                    pst = con.prepareStatement("UPDATE payments SET " + columnName + " = 'PAYED' WHERE student_id = \"" + studentID + "\"");
                    int k = pst.executeUpdate();
                    if(k==1){
                        JOptionPane.showMessageDialog(this, "Payment Updated Successfully");
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(this, "Payment Failed");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Failed to Fetch columnName");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PayContribution.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnPayActionPerformed

    private void txtFieldStudentIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldStudentIDActionPerformed
        cbxSelectPayment.setEnabled(true);
        btnPay.setEnabled(true);
        
        try {
            String studentID = txtFieldStudentID.getText();
            pst = con.prepareStatement("SELECT * FROM users WHERE student_id = ?");
            pst.setString(1, studentID);
            rs = pst.executeQuery();
            
            if(rs.next() == true){
                txtFieldName.setText(rs.getString(2));
                txtFieldSection.setText(rs.getString(3));
            } else {
                JOptionPane.showMessageDialog(this,"No User Found!");
                DefaultConfig();
            }
        } catch (SQLException ex) {
            Logger.getLogger(PayContribution.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtFieldStudentIDActionPerformed

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
                new PayContribution().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPay;
    private javax.swing.JComboBox<String> cbxSelectPayment;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txtFieldName;
    private javax.swing.JTextField txtFieldSection;
    private javax.swing.JTextField txtFieldStudentID;
    // End of variables declaration//GEN-END:variables
}
