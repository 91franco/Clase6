package com.example.alumno.mihilo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;

import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import java.net.HttpURLConnection;
import java.net.URL;


public class MainActivity extends AppCompatActivity implements android.os.Handler.Callback {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Handler h = new Handler(this);
        MiHilo miHilo = new MiHilo(h,"http://192.168.2.130:8080/android/clase6.xml",true);
        MiHilo miHilo2 = new MiHilo(h,"http://192.168.2.130:8080/android/koala.png",false);

        miHilo.start();


    }
    @Override
    public boolean handleMessage(Message msg) {
// Aca se reciben los mensajes
        //String text = (String) msg.obj;
        Log.d("prueba", msg.obj.toString());
        if(msg.arg1==1){
            TextView text = (TextView) findViewById(R.id.textView);
            text.setText(msg.obj.toString());
        }
        if(msg.arg1==2){
            Log.d("IMG","imagn");
            byte[] bytes = (byte[]) msg.obj;
            ImageView image = (ImageView) findViewById(R.id.image1);
            image.setImageBitmap(BitmapFactory.decodeByteArray(bytes,0,bytes.length));
        }


        return true;
    }


}
