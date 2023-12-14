package com.zeroone.biospay;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class qrcode {
    private static final String outputQr = "D:\\outputqrcode.png";
    private static void generateQRcode(String text, int width, int height, String filePath) throws WriterException{
        try {
            QRCodeWriter qc = new QRCodeWriter();
            BitMatrix bm = qc.encode(text,BarcodeFormat.QR_CODE,width, height);
            Path pobj = FileSystems.getDefault().getPath(filePath);
            MatrixToImageWriter.writeToPath(bm, "PNG", pobj);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(qrcode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) throws WriterException{
        generateQRcode("Hello World", 1250, 1250, outputQr);
    }
}

// public void generateQRCode(){
//        int rowCount = jTableUsers.getRowCount();
//        
//        String directoryPath = "D:\\qrcodes\\";
//        int width = 1250;
//        int height = 1250;
//
//        QRCodeWriter qc = new QRCodeWriter();
//        for (int i = 0; i < rowCount; i++) {
//            String studentID = jTableUsers.getValueAt(i, 0).toString();
//            String name = jTableUsers.getValueAt(i, 1).toString();
//            String section = jTableUsers.getValueAt(i, 2).toString();
//            String fileName = studentID + " - " +  section + " - " + name + ".png";
//            String filePath = directoryPath + fileName;
//
//            try {
//                BitMatrix bm = qc.encode(studentID, BarcodeFormat.QR_CODE, width, height);
//                Path pobj = FileSystems.getDefault().getPath(filePath);
//                MatrixToImageWriter.writeToPath(bm, "PNG", pobj);
//            } catch (WriterException | IOException ex) {
//                ex.printStackTrace();
//            }
//        }
//        JOptionPane.showMessageDialog(this, "QR codes generated and saved successfully!");
//    }