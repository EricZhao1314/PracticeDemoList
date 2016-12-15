package com.example.aoyi.recyclerviewdemo2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by aoyi on 2016/12/11.
 */

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {
    private List<Fruit> mfruitList;

    public FruitAdapter(List<Fruit> fruitList) {
        mfruitList = fruitList;
    }

    @Override
    public FruitAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item,parent,false);
        ViewHolder holder=new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(FruitAdapter.ViewHolder holder, int position) {
        Fruit fruit=mfruitList.get(position);
        holder.fruitImage.setImageResource(fruit.getImageId());
        holder.fruitName.setText(fruit.getName());
    }

    @Override
    public int getItemCount() {
        return mfruitList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView fruitImage;
        TextView  fruitName;
        public ViewHolder(View view) {
            super(view);
            fruitImage= (ImageView) view.findViewById(R.id.fruit_image);
            fruitName= (TextView) view.findViewById(R.id.fruit_name);

        }
    }
}
