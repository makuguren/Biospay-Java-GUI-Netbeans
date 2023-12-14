package com.zeroone.biospay;

//QRCode and Camera
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import javax.swing.JOptionPane;

//MYSQL
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.JDialog;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

//Sound Effects
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.LineEvent;

public class Attendance extends javax.swing.JFrame implements Runnable, ThreadFactory {
    
    ResultSet rs;
    Connection con;
    PreparedStatement pst;
    
    private WebcamPanel panel = null;
    private Webcam webcam = null;
    
    private static final long serialVersionUID = 6441489157408381878L;
    private Executor executor = Executors.newSingleThreadExecutor(this);

    public Attendance() {
        initComponents();
        initWebcam();
        con = SQLConnection.DBConnection();
        fetchAttendance();
        displayClock();
    }
    
    public void soundEffectsAttendance(){
       try {
            File soundFile = new File("sound/attendance_done.wav");
            if (!soundFile.exists()) {
                System.out.println("File not found: " + "sound/attendance_done.wav");
                return;
            }

            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);

            // Add a LineListener to handle events asynchronously
            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    try {
                        clip.close();
                        audioInputStream.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Attendance.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println("Error playing sound: " + e.getMessage());
        }
    }
    
    public void displayClock(){
        Timer timer = new Timer(1000, e -> {
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            Date currentTime = new Date();
            lbltimer.setText(dateFormat.format(currentTime));
        });
        
        if (lbltimer.getText().equals("23:03:00")){
            System.out.println("Hello World");
        }
        
        timer.start();
    }
    
//    public void clearNameSection(){
//        Timer timer = new Timer(10000, e -> {
//            lblName.setText("");
//            lblSection.setText("");
//        });
//        timer.start();
//    }
    
    public void fetchAttendance(){
        try {
            int q;
            pst = con.prepareStatement("SELECT attendance.student_id, users.name, users.section, users.email, attendance.date, attendance.time FROM attendance INNER JOIN users ON users.student_id = attendance.student_id ORDER BY attendance.time DESC");
            rs = pst.executeQuery();
            
            ResultSetMetaData rss = rs.getMetaData();
            q = rss.getColumnCount();
            DefaultTableModel df = (DefaultTableModel)JTableDetails.getModel();
            df.setRowCount(0);
            while(rs.next()){
                Vector v2 = new Vector();
                for(int a=1; a<=q; a++){
                    v2.add(rs.getString("student_id"));
                    v2.add(rs.getString("name"));
                    v2.add(rs.getString("section"));
                    v2.add(rs.getString("time"));
                    v2.add(rs.getString("date"));
                }
                df.addRow(v2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Attendance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lblName = new javax.swing.JLabel();
        lblSection = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblStudentID = new javax.swing.JLabel();
        txtStudentID = new javax.swing.JTextField();
        lblCamera = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTableDetails = new javax.swing.JTable();
        lbltimer = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        HeaderJPanel = new javax.swing.JPanel();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ATTENDANCE | BIOSPAY");
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

        jPanel4.setBackground(new java.awt.Color(204, 0, 0));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblName.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        lblName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        lblSection.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        lblSection.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(lblSection, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 23)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("WELCOME");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 160));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblStudentID.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblStudentID.setText("ENTER YOUR STUDENT ID:");
        jPanel2.add(lblStudentID, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        txtStudentID.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        txtStudentID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStudentIDActionPerformed(evt);
            }
        });
        jPanel2.add(txtStudentID, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 740, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 820, 110));

        lblCamera.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(lblCamera, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 20, 340, 250));

        JTableDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STUDENT ID", "NAME", "SECTION", "TIME", "DATE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTableDetails.setRowHeight(30);
        jScrollPane2.setViewportView(JTableDetails);
        if (JTableDetails.getColumnModel().getColumnCount() > 0) {
            JTableDetails.getColumnModel().getColumn(0).setResizable(false);
            JTableDetails.getColumnModel().getColumn(1).setResizable(false);
            JTableDetails.getColumnModel().getColumn(2).setResizable(false);
            JTableDetails.getColumnModel().getColumn(3).setResizable(false);
            JTableDetails.getColumnModel().getColumn(4).setResizable(false);
        }
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 820, 320));

        lbltimer.setBackground(new java.awt.Color(255, 255, 255));
        lbltimer.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        lbltimer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbltimer.setText("00:00:00");
        jPanel1.add(lbltimer, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 280, 340, 50));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setBackground(new java.awt.Color(3, 83, 164));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("VIEW ATTENDANCE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 40));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 340, 340, 50));

        btnBack.setBackground(new java.awt.Color(3, 83, 164));
        btnBack.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("BACK");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel1.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 540, 150, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1200, 590));

        HeaderJPanel.setBackground(new java.awt.Color(3, 83, 164));
        HeaderJPanel.setPreferredSize(new java.awt.Dimension(0, 60));
        HeaderJPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ATTENDANCE | BIOSPAY");
        HeaderJPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 294, 40));

        getContentPane().add(HeaderJPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtStudentIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStudentIDActionPerformed
        SwingUtilities.invokeLater(() -> {
            JOptionPane optionPane = new JOptionPane("The Attendance is Processing.. Please Wait!", JOptionPane.INFORMATION_MESSAGE);
            JDialog dialog = optionPane.createDialog("");
            dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
            dialog.setResizable(false);
            
            Timer timer = new Timer(2000, e -> {
                try {
                    //Check if the User Attendance is Already exists
                    pst = con.prepareStatement("SELECT student_id FROM attendance WHERE student_id = ?");
                    pst.setString(1, txtStudentID.getText());
                    rs = pst.executeQuery();
                    
                    if(rs.next()){
                        lblName.setText("ATTENDANCE HAS ALREADY EXISTS!");
                        txtStudentID.setText("");
                        lblSection.setText("");
                    } else {
                        Date currentDate = new Date();
                        // Create formats for date and time
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

                        // Format date and time
                        String formattedDate = dateFormat.format(currentDate);
                        String formattedTime = timeFormat.format(currentDate);

                        //Push result into Database
                        pst = con.prepareStatement("INSERT INTO attendance (student_id,date,time) VALUES (?,?,?)");
                        pst.setString(1, txtStudentID.getText());
                        pst.setString(2, formattedDate);
                        pst.setString(3, formattedTime);
                        int k = pst.executeUpdate();

                        if (k == 1) {
                            //Getting Details to Show User Details
                            pst = con.prepareStatement("SELECT attendance.student_id, users.name, users.section, users.email, attendance.date, attendance.time FROM attendance INNER JOIN users ON users.student_id = attendance.student_id WHERE attendance.student_id = \"" + txtStudentID.getText() + "\"");
                            rs = pst.executeQuery();

                            if (rs.next()){
                                lblName.setText(rs.getString(2));
                                lblSection.setText(rs.getString(3));
                                //JOptionPane.showMessageDialog(null, "Welcome to: " + rs.getString(2) + "!");
                                fetchAttendance();
                                soundEffectsAttendance();
                                txtStudentID.setText("");
                            }

                        } else {
                            JOptionPane.showMessageDialog(this, "Failed to Attendance!");
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Attendance.class.getName()).log(Level.SEVERE, null, ex);
                }
                dialog.dispose();
            });  
            timer.setRepeats(false);
            timer.start();
            dialog.setVisible(true);
            dialog.pack();
        });
    }//GEN-LAST:event_txtStudentIDActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ViewAttendance viewatt = new ViewAttendance();
        viewatt.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        fetchAttendance();
    }//GEN-LAST:event_formWindowActivated

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        Dashboard mainmenu = new Dashboard();
        mainmenu.setVisible(true);
        dispose();
        
        if (webcam != null) {
            webcam.close();
            panel.stop(); // Stop the webcam panel
        }
    }//GEN-LAST:event_btnBackActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> {
            new Attendance().setVisible(true);
        });
    }
    
    private void initWebcam() {
        Dimension size = WebcamResolution.QVGA.getSize();
        webcam = Webcam.getWebcams().get(0); //0 is default webcam
        webcam.setViewSize(size);

        panel = new WebcamPanel(webcam);
        panel.setPreferredSize(size);
        panel.setFPSDisplayed(true);

        lblCamera.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, 250));

        executor.execute(this);
    }
    
    @Override
    public void run() {
        do {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Result result = null;
            BufferedImage image = null;

            if (webcam.isOpen()) {
                if ((image = webcam.getImage()) == null) {
                    continue;
                }
            }

            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

            try {
                result = new MultiFormatReader().decode(bitmap);
            } catch (NotFoundException e) {
                //No result...
            }
            
            Result finalResult = result;
            
            if (result != null) {
                JOptionPane optionPane = new JOptionPane("The Attendance is Processing.. Please Wait!", JOptionPane.INFORMATION_MESSAGE);
                JDialog dialog = optionPane.createDialog("");

                Timer timer = new Timer(2000, e -> {
                    try {
                        //Check if the User Attendance is Already exists
                        pst = con.prepareStatement("SELECT student_id FROM attendance WHERE student_id = ?");
                        pst.setString(1, finalResult.getText());
                        rs = pst.executeQuery();

                        if(rs.next()){
                            lblName.setText("ATTENDANCE HAS ALREADY EXISTS!");
                            txtStudentID.setText("");
                            lblSection.setText("");
                        } else {
                            Date currentDate = new Date();
                            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

                            String formattedDate = dateFormat.format(currentDate);
                            String formattedTime = timeFormat.format(currentDate);

                            pst = con.prepareStatement("INSERT INTO attendance (student_id,date,time) VALUES (?,?,?)");
                            pst.setString(1, finalResult.getText());
                            pst.setString(2, formattedDate);
                            pst.setString(3, formattedTime);
                            int k = pst.executeUpdate();

                            if (k == 1) {
                                pst = con.prepareStatement("SELECT attendance.student_id, users.name, users.section, users.email, attendance.date, attendance.time FROM attendance INNER JOIN users ON users.student_id = attendance.student_id WHERE attendance.student_id = ?");
                                pst.setString(1, finalResult.getText());
                                rs = pst.executeQuery();

                                if (rs.next()) {
                                    lblName.setText(rs.getString(2));
                                    lblSection.setText(rs.getString(3));
                                    soundEffectsAttendance();
                                    fetchAttendance();

                                }
                            } else {
                                JOptionPane.showMessageDialog(this, "Failed to Attendance!");
                            }   
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Attendance.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    dialog.dispose();
                });
                
                timer.setRepeats(false);
                timer.start();

                dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
                dialog.setResizable(false);

                dialog.setVisible(true);
                dialog.pack();
            }
        } while (true);
    }
    
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "My Thread");
        t.setDaemon(true);
        return t;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel HeaderJPanel;
    private javax.swing.JTable JTableDetails;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel lblCamera;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblSection;
    private javax.swing.JLabel lblStudentID;
    private javax.swing.JLabel lbltimer;
    private javax.swing.JTextField txtStudentID;
    // End of variables declaration//GEN-END:variables
}
