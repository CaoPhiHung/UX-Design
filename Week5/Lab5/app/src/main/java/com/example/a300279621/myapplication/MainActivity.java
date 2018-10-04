package com.example.a300279621.myapplication;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> AllItemList = new ArrayList<String>();
    List<Integer> AllPicList = new ArrayList<Integer>();
    List<String> AllDirList = new ArrayList<String>();
    List<String> MovieList = new ArrayList<String>();
    List<Integer> MoviePicList = new ArrayList<Integer>();
    List<String> MovieDirList = new ArrayList<String>();
    List<String> TVList = new ArrayList<String>();
    List<Integer> TVPicList = new ArrayList<Integer>();
    List<String> TVDirList = new ArrayList<String>();

    private void addAllItem() {
        AllItemList.add("Big Short");
        AllItemList.add("Game Of Thrones");
        AllItemList.add("Star Wars");

        AllDirList.add("Adam McKay");
        AllDirList.add("Alan Taylor");
        AllDirList.add("Rian Johnson");

        MovieList.add("Big Short");
        MovieList.add("Star Wars");
        MoviePicList.add(R.drawable.bigshort);
        MoviePicList.add(R.drawable.gameofthrones);
        MovieDirList.add("Alan Taylor");
        MovieDirList.add("Rian Johnson");


        TVList.add("Game Of Thrones");
        TVPicList.add(R.drawable.gameofthrones);
        TVDirList.add("Alan Taylor");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TabLayout myTabLayout= (TabLayout) findViewById(R.id.tabLayout);
        final RecyclerView myRecycleView = (RecyclerView) findViewById(R.id.recycleView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        myRecycleView.setLayoutManager(layoutManager);

        //Create Data
        addAllItem();
        //Create Adapter Instance
        final MyCustomAdapter myadapter = new MyCustomAdapter(AllItemList, AllPicList, AllDirList);

        //Set adapter to Recycle View
        myRecycleView.setAdapter(myadapter);

        myTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (myTabLayout.getSelectedTabPosition()){
                    case 0:
                        Toast.makeText(MainActivity.this, "Clicked on all", Toast.LENGTH_LONG).show();
                        myadapter.changeItemList(AllItemList, AllPicList, AllDirList);
                        break;
                    case 1:
                        Toast.makeText(MainActivity.this, "Clicked on all", Toast.LENGTH_LONG).show();
                        myadapter.changeItemList(MovieList, MoviePicList, MovieDirList);
                        break;
                    case 2:
                        Toast.makeText(MainActivity.this, "Clicked on all", Toast.LENGTH_LONG).show();
                        myadapter.changeItemList(TVList, TVPicList, TVDirList);
                        break;

                }
                myadapter.notifyDataSetChanged();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
