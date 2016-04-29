package com.example.alumno.mihilo;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.IOException;

/**
 * Created by alumno on 28/04/2016.
 */
public class MiHilo extends Thread {
    Message msg = new Message();
    Handler h;
    HttpManager hm;
    Boolean valor;

    public MiHilo(Handler han,String url,Boolean val){
        this.h=han;
        this.hm= new HttpManager(url);
        this.valor=val;
    }

    @Override
    public void run() {
        try {
            if(valor) {
                msg.arg1=1;
                msg.obj = hm.getStrDataByGET();
            }
            else{
                msg.arg1=2;
                msg.obj=hm.getBytesDataByGET();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        h.sendMessage(msg);

    }

}
