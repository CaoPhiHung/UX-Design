package com.example.a300279621.viewdemo;

import android.graphics.Color;
import android.graphics.SumPathEffect;
import android.graphics.drawable.Drawable;
import android.provider.SyncStateContract;
import android.support.annotation.Dimension;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Constraints;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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
                text.setText("Hello Henry \nHow are you today");
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
                        if(text.getText().toString().equals("Hello Henry \nHow are you today")){
                            text.setText("Changed Long Click Text");
                        }else{
                            text.setText("New Line");
                        }
                        return true;
                    }
                });

//                ConstraintLayout.LayoutParams lp = new ConstraintLayout.LayoutParams(400, 600);
//                text.setLayoutParams(lp);
                text.getLayoutParams().height = 400;
                text.getLayoutParams().width = 600;

            }
        });

               final ImageView img = (ImageView) findViewById(R.id.imageView);
                img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (img.getDrawable().getConstantState().equals(
                                getResources().getDrawable(R.drawable.puppy).getConstantState())) {
                            img.setImageResource(R.drawable.darkbg2);
                            Toast.makeText(MainActivity.this, "Changed", Toast.LENGTH_LONG).show();
                        }else if(img.getDrawable().getConstantState().equals(
                                getResources().getDrawable(R.drawable.darkbg2).getConstantState())){
                            img.setImageResource(R.drawable.puppy);
                        }
                    }
                });

                final Button changeImage = (Button) findViewById(R.id.btnImageChange);
                changeImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(img.getScaleType() == ImageView.ScaleType.FIT_XY){
                            img.setScaleType(ImageView.ScaleType.FIT_CENTER);

                        }else{
                            img.setScaleType(ImageView.ScaleType.FIT_XY);
                        }
                    }
                });

    }
}
