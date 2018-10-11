package com.example.a300279651.recyclerviewdemo;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> allItemList = new ArrayList<>();
    List<Integer> allPicList = new ArrayList<>();
    List<String> allDirList = new ArrayList<>();

    List<String> movieList = new ArrayList<>();
    List<Integer> moviePicList = new ArrayList<>();
    List<String> movieDirList = new ArrayList<>();

    List<String> tvList = new ArrayList<>();
    List<Integer> tvPicList = new ArrayList<>();
    List<String> tvDirList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declare
        final TabLayout myTabLayout = (TabLayout)findViewById(R.id.tabLayout);
        final RecyclerView myCyclerView = (RecyclerView)findViewById(R.id.recyclerViewTab);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        myCyclerView.setLayoutManager(layoutManager);

        //Create Data
        addAllItems();

        //Create Adapter íntance
        final CustomRecyclerAdapter myAdapter = new CustomRecyclerAdapter(allItemList, allPicList, allDirList);

        //set adapter to RecyclerView
        myCyclerView.setAdapter(myAdapter);

        myTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch(myTabLayout.getSelectedTabPosition())
                {
                    case 0:
                        Toast.makeText(MainActivity.this, "Clicked on all Tab", Toast.LENGTH_SHORT).show();
                        myAdapter.changeItemList(allItemList, allPicList, allDirList);
                        break;
                    case 1:
                        myAdapter.changeItemList(movieList, moviePicList, movieDirList);
                        break;
                    case 2:
                        myAdapter.changeItemList(tvList, tvPicList, tvDirList);
                        break;
                    default:
                        myAdapter.changeItemList(allItemList, allPicList, allDirList);
                }

                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                Toast.makeText(MainActivity.this,"Clicked again", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void addAllItems()
    {
        // All items
        allItemList.add("Big Short");
        allItemList.add("Game of Thrones");
        allItemList.add("Star Wars");

        allDirList.add("Adam McKay");
        allDirList.add("Alan Taylor");
        allDirList.add("Rian Johnson");

        allPicList.add(R.drawable.bigshort);
        allPicList.add(R.drawable.gameofthrones);
        allPicList.add(R.drawable.starwars);

        // Movie
        movieList.add("Big Short");
        movieList.add("Star Wars");
        moviePicList.add(R.drawable.starwars);
        moviePicList.add(R.drawable.bigshort);
        movieDirList.add("Adam McKay");
        movieDirList.add("Rian Johnson");

        //TV
        tvList.add("Game of Thrones");
        tvPicList.add(R.drawable.gameofthrones);
        tvDirList.add("Alan Taylor");
    }

}
