//    public void generateQRCode(){        
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
//            String sectionDirectory = directoryPath + section + "\\";
//            String filePath = directoryPath + fileName;
//
//            try {
//                // Create directory if it doesn't exist
//                Path directory = FileSystems.getDefault().getPath(sectionDirectory);
//                Files.createDirectories(directory);
//                
//                //Process of Generate QRCode
//                BitMatrix bm = qc.encode(studentID, BarcodeFormat.QR_CODE, width, height);
//                Path pobj = FileSystems.getDefault().getPath(filePath);
//                MatrixToImageWriter.writeToPath(bm, "PNG", pobj);
//                
//                 // Move the generated QR code to the section directory
//                Path sourcePath = FileSystems.getDefault().getPath(filePath);
//                Path destinationPath = FileSystems.getDefault().getPath(sectionDirectory, fileName);
//                Files.move(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
//                
//            } catch (WriterException | IOException ex) {
//                ex.printStackTrace();
//            }
//        }
//        JOptionPane.showMessageDialog(this, "QR codes generated and saved successfully!");
//    }
//
//import com.google.zxing.BarcodeFormat;
//import com.google.zxing.WriterException;
//import com.google.zxing.client.j2se.MatrixToImageWriter;
//import com.google.zxing.common.BitMatrix;
//import com.google.zxing.qrcode.QRCodeWriter;
//import java.io.IOException;
//import java.nio.file.FileSystems;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.StandardCopyOption;
//import javax.swing.JOptionPane;
//
