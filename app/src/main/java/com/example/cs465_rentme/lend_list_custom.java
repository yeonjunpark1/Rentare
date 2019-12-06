package com.example.cs465_rentme;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class lend_list_custom extends ArrayAdapter<String> {
    private String[] items;
    private String[] price;
    private String[] availability;
    private Uri[] images;
    private Activity context;
    public lend_list_custom(Activity context, ArrayList<String> items, ArrayList<String> price, ArrayList<String> availability, ArrayList<Uri> images) {
        super(context, R.layout.listview_layout, items);
        this.context = context;
        this.price = new String[price.size()];
        this.availability = new String[availability.size()];
        this.images = new Uri[images.size()];
        this.items = new String[items.size()];
        price.toArray(this.price);
        availability.toArray(this.availability);
        images.toArray(this.images);
        items.toArray(this.items);
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
        viewHolder.ivw.setImageURI(images[position]);
        viewHolder.tvw1.setText(items[position]);
        viewHolder.tvw2.setText(price[position]);
        viewHolder.tvw3.setText(availability[position]);
        return r;
    }
    class ViewHolder {
        TextView tvw1;
        TextView tvw2;
        TextView tvw3;
        ImageView ivw;
        ViewHolder(View v) {
            tvw1= (TextView) v.findViewById(R.id.tvitems);
            tvw2= (TextView) v.findViewById(R.id.tvprice);
            tvw3= (TextView) v.findViewById(R.id.tvavailability);
            ivw= (ImageView) v.findViewById(R.id.ivimages);

        }

    }
}
