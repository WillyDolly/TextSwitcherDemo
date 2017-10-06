package com.popland.pop.textswitcherdemo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {
TextSwitcher textSwitcher;
    Button btnNext;
    String[] MangSo = {"1","67","654","5675","6"};
    int index = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textSwitcher = (TextSwitcher)findViewById(R.id.textSwitcher);
        btnNext = (Button)findViewById(R.id.btnNext);

        //setAnimation
//        Animation in = AnimationUtils.makeInAnimation(this,false);
//        Animation out = AnimationUtils.makeOutAnimation(this,false);
        Animation in = AnimationUtils.loadAnimation(this,android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this,android.R.anim.slide_out_right);
        textSwitcher.setInAnimation(in);
        textSwitcher.setOutAnimation(out);

        //setFactory
        textSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView mytext = new TextView(MainActivity.this);
                mytext.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL);
                mytext.setTextColor(Color.WHITE);
                return mytext;
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index++;
                if(index==MangSo.length){
                    index = 0;
                }
                textSwitcher.setText(MangSo[index]);
            }
        });

    }
}
