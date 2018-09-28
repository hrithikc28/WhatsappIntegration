package com.example.hritikchauhan.whatsappintegration;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {

    String mobileNumber;
    EditText mobileNumberEditText;
    EditText messageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mobileNumberEditText = (EditText) findViewById(R.id.mobile_number);


        messageEditText = (EditText) findViewById(R.id.message);


        Button send = (Button) findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //String toNumber = "+91 98765 43210"; // contains spaces.
                //toNumber = toNumber.replace("+", "").replace(" ", "");
               // String no = "91"+mobileNumber;


                /*Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);*/


                //String smsNumber = "919900000000";//Intended user`s mobile number with country code & with out '+'

                PackageManager packageManager = getPackageManager();
                Intent i = new Intent(Intent.ACTION_VIEW);
                mobileNumber = mobileNumberEditText.getText().toString();
                String message = messageEditText.getText().toString();
                

                try {
                    String url = "https://api.whatsapp.com/send?phone=+91"+mobileNumber+"&text=" + URLEncoder.encode(message, "UTF-8");
                    i.setPackage("com.whatsapp");
                    i.setData(Uri.parse(url));
                    if (i.resolveActivity(packageManager) != null) {
                        startActivity(i);
                    }
                } catch (Exception e){
                    e.printStackTrace();
                }



                /*try {

                    PackageManager packageManager = getPackageManager();
                    Intent i = new Intent(Intent.ACTION_VIEW);

                    String url = "https://api.whatsapp.com/send?phone="+ no +"&text=" + URLEncoder.encode(message, "UTF-8");
                    i.setPackage("com.whatsapp");
                    i.setData(Uri.parse(url));
                    if (i.resolveActivity(packageManager) != null) {
                        startActivity(i);
                    }
                } catch (Exception e){
                    e.printStackTrace();
                }*/


                /*Intent sendIntent = new Intent("android.intent.action.MAIN");
                sendIntent.putExtra("jid", no + "@s.whatsapp.net");
                sendIntent.putExtra(Intent.EXTRA_TEXT, message);
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.setPackage("com.whatsapp");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);*/


                /*Uri uri = Uri.parse("smsto:" + mobileNumber);
                Intent sendIntent = new Intent(Intent.ACTION_SENDTO, uri);
                sendIntent.putExtra(Intent.EXTRA_TEXT, message);
                sendIntent.setType("text/plain");
                sendIntent.setPackage("com.whatsapp");
                startActivity(sendIntent);*/

            }
        });
    }
}
