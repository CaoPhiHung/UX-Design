package com.example.a300279621.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class MyCustomAdapter extends RecyclerView.Adapter<MyCustomAdapter.ViewHolder> {
    List<String> itemList;
    List<Integer> picList;
    List<String> dirList;

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtViewName;
        TextView txtViewDir;
        ImageView imgView;
        public ViewHolder(View itemView){
            super(itemView);
            txtViewName = (TextView) itemView.findViewById(R.id.textViewItemName);
            imgView = (ImageView) itemView.findViewById(R.id.imgView);
            txtViewDir = (TextView) itemView.findViewById(R.id.textViewDir);
        }
    }

    public MyCustomAdapter(List<String> anyList,
                           List<Integer> anyPicList,
                           List<String> anyDirList){
        itemList = anyList;
        picList = anyPicList;
        dirList = anyDirList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        //create new view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.layout_item, parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.txtViewName.setText(itemList.get(position));
        viewHolder.txtViewDir.setText(dirList.get(position));
        viewHolder.imgView.setImageResource(picList.get(position));
    }


    @Override
    public int getItemCount() {
        return 0;
    }

    public void changeItemList(List<String> anyList,
                               List<Integer> anyPicList,
                               List<String> anyDirList){
        itemList = anyList;
        picList = anyPicList;
        dirList = anyDirList;
    }
}
