package com.example.cs465_rentme;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class lend_list_custom extends ArrayAdapter<String> {
    private String[] items;
    private String[] description;
    private Integer[] images;
    private Activity context;
    public lend_list_custom(Activity context, String[] items, String[] description, Integer[] images) {
        super(context, R.layout.listview_layout, items);
        this.context = context;
        this.description = description;
        this.images = images;
        this.items = items;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r=convertView;
        ViewHolder viewHolder= null;
        if(r == null){
            LayoutInflater layoutInflater = context.getLayoutInflater();
            r = layoutInflater.inflate(R.layout.listview_layout, null, true);
            viewHolder = new ViewHolder(r);
            r.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) r.getTag();
        }
        viewHolder.ivw.setImageResource(images[position]);
        viewHolder.tvw1.setText(items[position]);
        viewHolder.tvw2.setText(description[position]);
        return r;
    }
    class ViewHolder {
        TextView tvw1;
        TextView tvw2;
        ImageView ivw;
        ViewHolder(View v) {
            tvw1= (TextView) v.findViewById(R.id.tvitems);
            tvw2= (TextView) v.findViewById(R.id.tvdescription);
            ivw= (ImageView) v.findViewById(R.id.ivimages);

        }

    }
}
