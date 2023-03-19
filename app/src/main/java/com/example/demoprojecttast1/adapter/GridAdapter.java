package com.example.demoprojecttast1.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.demoprojecttast1.R;
import com.example.demoprojecttast1.models.ApiModel;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class GridAdapter extends BaseAdapter {
    Context context;
    ArrayList<ApiModel> allImages;
    public GridAdapter(Context context, ArrayList<ApiModel> allImages){
        this.context = context;
        this.allImages = allImages;
    }
    LayoutInflater layoutInflater;
    @Override
    public int getCount() {
        return allImages.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View v = layoutInflater.inflate(R.layout.grid_view_layout,viewGroup,false);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        ImageView image = v.findViewById(R.id.image_grid);
        String  img = (allImages.get(position).getUrl().toString());

        Glide.with(context)
                .load(allImages.get(position).getUrl())
                .into(image);
        return v;
    }
}
