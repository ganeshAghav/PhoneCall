package com.everestadvanced.phonecall;

/**
 * Created by Administrator on 23-11-2017.
 */
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.webkit.WebView;
import android.widget.Toast;

public class MyPhoneStateListener extends PhoneStateListener {

    public Context context;
    public static Boolean phoneRinging = false;

    MyPhoneStateListener(Context coxt)
    {
        this.context=coxt;
    }

    public void onCallStateChanged(int state, String incomingNumber) {

        switch (state)
        {
            case TelephonyManager.CALL_STATE_IDLE:
                Log.e("DEBUG", "IDLE");
                Toast.makeText(context,"IDLE",Toast.LENGTH_LONG).show();

                Intent svc5=new Intent(context, Sound.class);
                context.stopService(svc5);

                phoneRinging = false;
                break;
            case TelephonyManager.CALL_STATE_OFFHOOK:
                Log.e("DEBUG", "OFFHOOK");

                Intent svc4=new Intent(context, Sound.class);
                context.startService(svc4);

                Toast.makeText(context,"OFFHOOK",Toast.LENGTH_LONG).show();
                phoneRinging = false;
                break;
            case TelephonyManager.CALL_STATE_RINGING:
                Log.e("DEBUG", "RINGING");
                Toast.makeText(context,"RINGING",Toast.LENGTH_LONG).show();
                phoneRinging = true;

                break;
        }
    }

}