package com.zeroone.biospay;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Dashboard extends javax.swing.JFrame {
    
    ResultSet rs;
    Connection con;
    PreparedStatement pst;

    public Dashboard() {
        con = SQLConnection.DBConnection();
        initComponents();
        FetchDashboard();
    }
    
    public void FetchDashboard(){            
        try {                        
            //Fetch Count of Users
            pst = con.prepareStatement("SELECT COUNT(*) AS users_count FROM users");
            rs = pst.executeQuery();
            
            if(rs.next()){
                String users = rs.getString("users_count");
                numUsers.setText(users);
            }
            
            //Fetch Count of Payments
            // Getting Contribution DB ColumnName to Generate Query Automatically
            pst = con.prepareStatement("SELECT column_name from contributions;");
            rs = pst.executeQuery();

            StringBuilder columnData = new StringBuilder();
            while (rs.next()) {
                String columnName = rs.getString("column_name");
                columnData.append(columnName).append(" = 'PAYED' AND ");
            }
            
            String paymentQuery = columnData.toString();
            if (paymentQuery.endsWith(" AND ")) {
                paymentQuery = paymentQuery.substring(0, paymentQuery.length() - 5);
            } else {
                return; // HandleError
            }
            
            pst = con.prepareStatement("SELECT COUNT(*) AS payment_count FROM payments WHERE " + paymentQuery);
            rs = pst.executeQuery();
            
            if(rs.next()){
                String payment = rs.getString("payment_count");
                numCompletePay.setText(payment);
            }
            
            //Fetch Count of Contributions
            pst = con.prepareStatement("SELECT COUNT(*) AS contributions_count FROM contributions");
            rs = pst.executeQuery();
            
            if(rs.next()){
                String contributions = rs.getString("contributions_count");
                numContributions.setText(contributions);
            }
            
            //Fetch Count of Attendance
            pst = con.prepareStatement("SELECT COUNT(*) AS attendance_count FROM attendance");
            rs = pst.executeQuery();
            
            if(rs.next()){
                String attendance = rs.getString("attendance_count");
                numAttendance.setText(attendance);
            }
                        
        } catch (SQLException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        numUsers = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        numCompletePay = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        numContributions = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        numAttendance = new javax.swing.JLabel();
        HeaderJPanel = new javax.swing.JPanel();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnContributions = new javax.swing.JButton();
        btnUsers = new javax.swing.JButton();
        btnSections = new javax.swing.JButton();
        btnPayments = new javax.swing.JButton();
        btnAttendance = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DASHBOARD | BIOSPAY");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(690, 484));
        jPanel1.setMinimumSize(new java.awt.Dimension(690, 484));
        jPanel1.setPreferredSize(new java.awt.Dimension(690, 484));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(3, 83, 164));
        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("TOTAL USERS");

        numUsers.setFont(new java.awt.Font("Segoe UI", 1, 45)); // NOI18N
        numUsers.setForeground(new java.awt.Color(255, 255, 255));
        numUsers.setText("0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 118, Short.MAX_VALUE))
                    .addComponent(numUsers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(numUsers)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 220, 110));

        jPanel5.setBackground(new java.awt.Color(3, 83, 164));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("COMPLETED PAYMENTS");

        numCompletePay.setFont(new java.awt.Font("Segoe UI", 1, 45)); // NOI18N
        numCompletePay.setForeground(new java.awt.Color(255, 255, 255));
        numCompletePay.setText("0");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 48, Short.MAX_VALUE))
                    .addComponent(numCompletePay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(numCompletePay)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 220, 110));

        jPanel6.setBackground(new java.awt.Color(3, 83, 164));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("CONTRIBUTIONS");

        numContributions.setFont(new java.awt.Font("Segoe UI", 1, 45)); // NOI18N
        numContributions.setForeground(new java.awt.Color(255, 255, 255));
        numContributions.setText("0");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 95, Short.MAX_VALUE))
                    .addComponent(numContributions, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(numContributions)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, 220, 110));

        jPanel7.setBackground(new java.awt.Color(3, 83, 164));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ATTENDANCE");

        numAttendance.setFont(new java.awt.Font("Segoe UI", 1, 45)); // NOI18N
        numAttendance.setForeground(new java.awt.Color(255, 255, 255));
        numAttendance.setText("0");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 117, Short.MAX_VALUE))
                    .addComponent(numAttendance, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(numAttendance)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 20, 220, 110));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 970, 590));

        HeaderJPanel.setBackground(new java.awt.Color(3, 83, 164));
        HeaderJPanel.setPreferredSize(new java.awt.Dimension(0, 60));
        HeaderJPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("WELCOME! ADMINISTRATOR");
        HeaderJPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 294, 40));

        getContentPane().add(HeaderJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, -1));

        jPanel2.setBackground(new java.awt.Color(3, 83, 164));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(3, 83, 164));
        jPanel3.setForeground(new java.awt.Color(3, 83, 164));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnContributions.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnContributions.setForeground(new java.awt.Color(3, 83, 164));
        btnContributions.setText("CONTRIBUTIONS");
        btnContributions.setToolTipText("");
        btnContributions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContributionsActionPerformed(evt);
            }
        });
        jPanel3.add(btnContributions, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 210, 46));

        btnUsers.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnUsers.setForeground(new java.awt.Color(3, 83, 164));
        btnUsers.setText("USERS");
        btnUsers.setToolTipText("");
        btnUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsersActionPerformed(evt);
            }
        });
        jPanel3.add(btnUsers, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 210, 43));

        btnSections.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnSections.setForeground(new java.awt.Color(3, 83, 164));
        btnSections.setText("SECTIONS");
        btnSections.setToolTipText("");
        btnSections.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSectionsActionPerformed(evt);
            }
        });
        jPanel3.add(btnSections, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 210, 43));

        btnPayments.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnPayments.setForeground(new java.awt.Color(3, 83, 164));
        btnPayments.setText("PAYMENTS");
        btnPayments.setToolTipText("");
        btnPayments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaymentsActionPerformed(evt);
            }
        });
        jPanel3.add(btnPayments, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 210, 43));

        btnAttendance.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnAttendance.setForeground(new java.awt.Color(3, 83, 164));
        btnAttendance.setText("ATTENDANCE");
        btnAttendance.setToolTipText("");
        btnAttendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAttendanceActionPerformed(evt);
            }
        });
        jPanel3.add(btnAttendance, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 210, 43));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, -10, 210, 450));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 230, 590));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsersActionPerformed
        Users users = new Users();
        users.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnUsersActionPerformed

    private void btnContributionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContributionsActionPerformed
        Contributions contri = new Contributions();
        contri.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnContributionsActionPerformed

    private void btnSectionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSectionsActionPerformed
        Sections sections = new Sections();
        sections.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnSectionsActionPerformed

    private void btnPaymentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaymentsActionPerformed
        Payments payment = new Payments();
        payment.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnPaymentsActionPerformed

    private void btnAttendanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAttendanceActionPerformed
        Attendance attendance = new Attendance();
        attendance.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnAttendanceActionPerformed

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
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel HeaderJPanel;
    private javax.swing.JButton btnAttendance;
    private javax.swing.JButton btnContributions;
    private javax.swing.JButton btnPayments;
    private javax.swing.JButton btnSections;
    private javax.swing.JButton btnUsers;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel numAttendance;
    private javax.swing.JLabel numCompletePay;
    private javax.swing.JLabel numContributions;
    private javax.swing.JLabel numUsers;
    // End of variables declaration//GEN-END:variables
}
