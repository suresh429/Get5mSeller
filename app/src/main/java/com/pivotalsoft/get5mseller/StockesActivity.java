package com.pivotalsoft.get5mseller;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class StockesActivity extends AppCompatActivity {
TextView txt1,txt2,txt3,txt4,txt5,txt6,txt7,txt8,txt9,txt10,txt11,txt12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stockes);

        txt1=(TextView)findViewById(R.id.textView1);
        Typeface face= Typeface.createFromAsset(getAssets(), "fonts/Fabrica.otf");
        txt1.setTypeface(face);

        txt2=(TextView)findViewById(R.id.textView2);
        Typeface face2= Typeface.createFromAsset(getAssets(), "fonts/DroidSans.ttf");
        txt2.setTypeface(face2);

        txt3=(TextView)findViewById(R.id.textView3);
        Typeface face3= Typeface.createFromAsset(getAssets(), "fonts/DroidSerif-Regular.ttf");
        txt3.setTypeface(face3);


        txt4=(TextView)findViewById(R.id.textView4);
        Typeface face4= Typeface.createFromAsset(getAssets(), "fonts/Roboto-Regular.ttf");
        txt2.setTypeface(face4);


        txt5=(TextView)findViewById(R.id.textView5);
        Typeface face5= Typeface.createFromAsset(getAssets(), "fonts/Roboto-Light.ttf");
        txt5.setTypeface(face5);


        txt6=(TextView)findViewById(R.id.textView6);
        Typeface face6= Typeface.createFromAsset(getAssets(), "fonts/Roboto-Medium.ttf");
        txt6.setTypeface(face6);


        txt7=(TextView)findViewById(R.id.textView7);
        Typeface face7= Typeface.createFromAsset(getAssets(), "fonts/Roboto-Thin.ttf");
        txt7.setTypeface(face7);

        txt8=(TextView)findViewById(R.id.textView8);
        Typeface face8= Typeface.createFromAsset(getAssets(), "fonts/Roboto-Condensed.ttf");
        txt8.setTypeface(face8);

       /* txt9=(TextView)findViewById(R.id.textView9);
        Typeface face9= Typeface.createFromAsset(getAssets(), "fonts/DroidSans.ttf");
        txt9.setTypeface(face9);


        txt10=(TextView)findViewById(R.id.textView10);
        Typeface face10= Typeface.createFromAsset(getAssets(), "fonts/DroidSans.ttf");
        txt10.setTypeface(face10);


        txt11=(TextView)findViewById(R.id.textView11);
        Typeface face11= Typeface.createFromAsset(getAssets(), "fonts/DroidSans.ttf");
        txt11.setTypeface(face11);


        txt12=(TextView)findViewById(R.id.textView12);
        Typeface face12= Typeface.createFromAsset(getAssets(), "fonts/DroidSans.ttf");
        txt12.setTypeface(face12);*/




    }
}
