package com.example.barcode_20220802;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class ScanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);
    }
    public void onClick(View V){
        IntentIntegrator integrator = new IntentIntegrator(this);
        integrator.initiateScan();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanResult != null) {
         String barcodenum;
         String barcodetype;

         barcodenum = scanResult.getContents();
         barcodetype = scanResult.getFormatName();

         TextView etBarcode = (TextView) findViewById(R.id.etBarcode);
         TextView etTyp = (TextView) findViewById(R.id.etTyp);
         etBarcode.setText(barcodenum);
         etTyp.setText(barcodetype);

         ImageView img_barcode;
         img_barcode = (ImageView)findViewById(R.id.img_barcode);

         MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
         final int WIDTH = 360;
         final int HEIGHT = 180;

         try {

             BitMatrix bitMatrix = multiFormatWriter.encode(barcodenum, BarcodeFormat.valueOf(barcodetype), WIDTH, HEIGHT);
             BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
             Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
             img_barcode.setImageBitmap(bitmap);

         } catch (Exception e) {
         }


        }
    }


}