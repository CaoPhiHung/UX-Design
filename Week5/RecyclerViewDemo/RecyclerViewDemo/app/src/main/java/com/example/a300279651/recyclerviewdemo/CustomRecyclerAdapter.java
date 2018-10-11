package com.example.a300279651.recyclerviewdemo;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class CustomRecyclerAdapter extends RecyclerView.Adapter<CustomRecyclerAdapter.ViewHolder> {

    List<String> itemList;
    List<Integer> itemPicList;
    List<String> itemDirList;

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtViewName;
        TextView txtViewDir;
        ImageView imgView;
        View itemView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtViewName = (TextView)itemView.findViewById(R.id.txtViewItemName);
            imgView = (ImageView)itemView.findViewById(R.id.imgView);
            txtViewDir = (TextView)itemView.findViewById(R.id.txtViewDir);
            this.itemView =itemView;

//            txtViewName.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    //change the color
//                    // get current color if not red change color to red
//                    changeColor();
//                }
//            });

            this.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    changeColor();
                }
            });
        }

        private void changeColor(){
            if(txtViewName.getCurrentTextColor() != Color.RED){
                txtViewName.setTextColor(Color.RED);
                txtViewDir.setTextColor(Color.RED);
                itemView.setBackgroundColor(Color.parseColor("#FDBCB4"));
            } else {
                txtViewName.setTextColor(Color.DKGRAY);
                txtViewDir.setTextColor(Color.DKGRAY);
                itemView.setBackgroundColor(Color.WHITE);
            }
        }
    }

    public CustomRecyclerAdapter(List<String> anyList, List<Integer> anyPicList, List<String> anyDirList)
    {
        this.itemList = anyList;
        this.itemPicList = anyPicList;
        this.itemDirList = anyDirList;
    }

    public void changeItemList(List<String> anyList, List<Integer> anyPicList, List<String> anyDirList)
    {
        this.itemList = anyList;
        this.itemPicList = anyPicList;
        this.itemDirList = anyDirList;
//        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View v = layoutInflater.inflate(R.layout.layout_item,viewGroup,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.txtViewName.setText(itemList.get(i));
        viewHolder.txtViewName.setText(itemDirList.get(i));
        viewHolder.imgView.setImageResource(itemPicList.get(i));
        viewHolder.txtViewDir.setTextColor(Color.DKGRAY);
        viewHolder.txtViewDir.setTextColor(Color.DKGRAY);
        viewHolder.itemView.setBackgroundColor(Color.WHITE);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}
