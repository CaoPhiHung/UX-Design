package com.example.a300279621.viewdemo;

import android.graphics.Color;
import android.graphics.SumPathEffect;
import android.support.annotation.Dimension;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button changeText = (Button) findViewById(R.id.btnChangeText);
        changeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final TextView text = (TextView) findViewById(R.id.txtViewSample);
                text.setText("Hello Henry \nHow are you today \n this is a tr\nasdasdasdasd");
                text.setPadding(16,16,16,16);
                text.setCompoundDrawablePadding(8);
                text.setBackgroundColor(Color.BLACK);
                text.setGravity(Gravity.LEFT|Gravity.BOTTOM);
                text.setMaxLines(2);

                text.setTextColor(Color.WHITE);
                text.setTextSize(Dimension.SP, 18);
                text.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        if(text.getText().toString().equals("")){
                            text.setText("");
                        }else{
                            text.setText("");
                        }
                        return true;
                    }
                });
            }
        });

        final Button changeImage = (Button) findViewById(R.id.btnImageChange);
        changeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ImageView img = (ImageView) findViewById(R.id.imageView);
            }
        });

    }
}
