package com.alejandrobarrero.practica4;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;


public class Hotels extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotels);

        TextView t2 = (TextView) findViewById(R.id.linkterrazas);
        t2.setMovementMethod(LinkMovementMethod.getInstance());
    }

}
