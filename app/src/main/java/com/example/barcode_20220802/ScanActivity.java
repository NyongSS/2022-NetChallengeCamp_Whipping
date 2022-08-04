package com.example.barcode_20220802;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;

public class ScanActivity extends AppCompatActivity {

    /* QR code scanner 객체 */
    private IntentIntegrator qrScan;
//    private static final int ZXING_CAMERA = 101; //ZXING 카메라 권한요청 ID
//    private StandardObject standardObj = null;

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
         String barcode;
         String typ;

         barcode = scanResult.getContents();
         typ = scanResult.getFormatName();

         TextView etBarcode = (TextView) findViewById(R.id.etBarcode);
         TextView etTyp = (TextView) findViewById(R.id.etTyp);

         etBarcode.setText(barcode);
         etTyp.setText(typ);
         CreateBarcode barcodeImg = new CreateBarcode();
         barcodeImg.createBarcode(this.toString(),typ,barcode);


         //이 안에 인텐트를 만들어서 typ를 create barcode에 보내기.
            //바코드 만든 곳에서는 내가 만든 이미지를 넣어주기.
        }
    }
        //        /* QR code Scanner Setting */
//        qrScan = new IntentIntegrator(this);
//        qrScan.setPrompt("아래 띄울 문구");
//        qrScan.initiateScan();
//        qrScan.setCaptureActivity(EmptyActivity.class);
//    }
//
//    /* Getting the Scan Results */
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//
//        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
//
//        if (result != null) {
//            if (result.getContents() == null) {
//                Log.v("qrcode :::::::::::", "no contents");
//            } else { //QR코드, 내용 존재
//                try {
//                    /* QR 코드 내용*/
//                    String temp = result.getContents();
//
//                    /* 로직
//                     *
//                     * 로직 끝 */
//
//                    Log.v("qrcode Contents :::::::::::", temp);
//                    Toast.makeText(getApplicationContext(), result.getContents(), Toast.LENGTH_LONG).show();
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    Log.v("Exception :::::::::::::", "QR code fail");
//
//                }
//            }
//        } else {
//            super.onActivityResult(requestCode, resultCode, data);
//        }
//    }

}