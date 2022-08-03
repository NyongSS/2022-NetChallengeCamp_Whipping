//package com.example.barcode_20220802;
//
//import android.graphics.Bitmap;
//
//import com.google.zxing.BarcodeFormat;
//import com.google.zxing.EncodeHintType;
//import com.google.zxing.MultiFormatWriter;
//import com.google.zxing.WriterException;
//import com.google.zxing.common.BitMatrix;
//
//import java.util.Hashtable;
//
//public class CreateQRCode {
//
//    public Bitmap createQRCode(String context){
//
//        Bitmap bitmap = null ;
//
//        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
//        try {
//            /* Encode to utf-8 */
//            Hashtable hints = new Hashtable();
//            hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
//
//            BitMatrix bitMatrix = multiFormatWriter.encode(context, BarcodeFormat.QR_CODE,300,300, hints);
//            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
//            bitmap = barcodeEncoder.createBitmap(bitMatrix);
//
//        } catch (WriterException e) {
//            e.printStackTrace();
//        }
//
//        return bitmap;
//    }
//}
