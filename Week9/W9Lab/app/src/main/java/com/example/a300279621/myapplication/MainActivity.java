package com.example.a300279621.myapplication;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.lang.invoke.ConstantCallSite;

public class MainActivity extends AppCompatActivity {
    ConstraintLayout myLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        myLayout = (ConstraintLayout) findViewById(R.id.overallLayout);
        myLayout.setBackgroundColor(Color.WHITE);

      final  FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ColorDrawable viewColor = (ColorDrawable)myLayout.getBackground();
                int colorId = viewColor.getColor();
                if(colorId != Color.LTGRAY){
                    myLayout.setBackgroundColor(Color.LTGRAY);
                } else{
                    myLayout.setBackgroundColor(Color.WHITE);
                }
                final Snackbar mySnackbar = Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG);
                mySnackbar.setAction("UnDo", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ColorDrawable viewColor = (ColorDrawable)myLayout.getBackground();
                        int colorId= viewColor.getColor();
                        if(colorId != Color.LTGRAY){
                            myLayout.setBackgroundColor(Color.LTGRAY);
                        }else{
                            myLayout.setBackgroundColor(Color.WHITE);

                        }
                        mySnackbar.dismiss();
//                        fab.hide();
                    }
                });
                mySnackbar.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
//        menu.add("My Life");
//        menu.add("My Work");
        menu.add(0,0,103,"My Life");
        menu.add(0,1,104,"My Work");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText(this, "Setting is selected",Toast.LENGTH_LONG).show();
            return true;
        }else if(id == R.id.profile){
            Toast.makeText(this, "Profile is selected",Toast.LENGTH_LONG).show();
        }else if(id == 0){
            Toast.makeText(this, "My Life is selected",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this, "My Work is selected",Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }
}
