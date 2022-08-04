package com.example.barcode_20220802;

import android.graphics.Bitmap;
import android.util.Log;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.util.Hashtable;

public class CreateBarcode {


    public Bitmap createBarcode(String context, String barcodeImg, String barcodeNum){

        Bitmap bitmap = null ;

        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try {
            /* Encode to utf-8 */
            Hashtable hints = new Hashtable();
            hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
            Log.d("힌트",context);
            BitMatrix bitMatrix = multiFormatWriter.encode(context, BarcodeFormat.valueOf(barcodeImg),300,300, hints);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            bitmap = barcodeEncoder.createBitmap(bitMatrix);

        } catch (WriterException e) {
            e.printStackTrace();
        }

        return bitmap;
    }
}
