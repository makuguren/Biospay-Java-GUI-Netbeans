package com.zeroone.biospay;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {
    
    public Login() {
        initComponents();
        resizeLogo();
    }
    
    public void resizeLogo(){
        Icon imgLogos = lblLogo.getIcon();
        ImageIcon logo = (ImageIcon)imgLogos;
        Image imgLogo = logo.getImage().getScaledInstance(lblLogo.getWidth(),lblLogo.getHeight(),Image.SCALE_SMOOTH);
        lblLogo.setIcon(new ImageIcon(imgLogo));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        UserPasswordPanel = new javax.swing.JPanel();
        javax.swing.JLabel lblUsername1 = new javax.swing.JLabel();
        txtFieldUsername = new javax.swing.JTextField();
        javax.swing.JLabel lblPassword = new javax.swing.JLabel();
        jButtonLogin = new javax.swing.JButton();
        txtFieldPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOGIN | BIOSPAY");
        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(java.awt.Color.white);
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(3, 83, 164));
        jPanel2.setMaximumSize(new java.awt.Dimension(684, 478));
        jPanel2.setMinimumSize(new java.awt.Dimension(684, 478));
        jPanel2.setPreferredSize(new java.awt.Dimension(684, 478));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("BIOSPAY ALL RIGHTS RESERVED");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 410, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("THIS SYSTEM IS CREATED BY: MARK GLEN");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, 410, -1));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/zeroone/biospay/images/logo.png"))); // NOI18N
        lblLogo.setText("jLabel4");
        jPanel2.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 370, 340));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 23)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(3, 83, 164));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("BIOSPAY LOGIN");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 589, 80));

        UserPasswordPanel.setBackground(new java.awt.Color(255, 255, 255));
        UserPasswordPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUsername1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblUsername1.setText("USERNAME");
        UserPasswordPanel.add(lblUsername1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 503, -1));

        txtFieldUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldUsernameActionPerformed(evt);
            }
        });
        UserPasswordPanel.add(txtFieldUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 500, 43));

        lblPassword.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPassword.setText("PASSWORD");
        UserPasswordPanel.add(lblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 474, -1));

        jButtonLogin.setBackground(new java.awt.Color(3, 83, 164));
        jButtonLogin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonLogin.setForeground(new java.awt.Color(255, 255, 255));
        jButtonLogin.setText("LOGIN");
        jButtonLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });
        UserPasswordPanel.add(jButtonLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 480, 49));

        txtFieldPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldPasswordActionPerformed(evt);
            }
        });
        UserPasswordPanel.add(txtFieldPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 500, 43));

        jPanel1.add(UserPasswordPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 132, 504, 280));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed
        String username = txtFieldUsername.getText();
        String password = txtFieldPassword.getText();

        String defaultUser = "admin";
        String defaultPass = "admin";
        
        if(username.equals(defaultUser) && password.equals(defaultPass)){
            Dashboard mainmenu = new Dashboard();
            mainmenu.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect Password! Please Try Again.", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButtonLoginActionPerformed

    private void txtFieldUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFieldUsernameActionPerformed

    private void txtFieldPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFieldPasswordActionPerformed
        String username = txtFieldUsername.getText();
        String password = txtFieldPassword.getText();

        String defaultUser = "admin";
        String defaultPass = "admin";
        
        if(username.equals(defaultUser) && password.equals(defaultPass)){
            Dashboard mainmenu = new Dashboard();
            mainmenu.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect Password! Please Try Again.", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_txtFieldPasswordActionPerformed

    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel UserPasswordPanel;
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JPasswordField txtFieldPassword;
    private javax.swing.JTextField txtFieldUsername;
    // End of variables declaration//GEN-END:variables
}
