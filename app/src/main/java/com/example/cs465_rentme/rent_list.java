package com.example.cs465_rentme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;


public class rent_list extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener{
    GridView gridView;
    String[] item_name_b = {"Weber Grill", "Golf Clubs", "Phantom 4 Drone Set", "12 Person Tent"};
    String[] item_price_b = {"$20 per day", "$30 per day", "$45 per day", "$50 per day"};
    String[] item_availability_b = {"Available", "Rented Until 12-13-2019", "Available", "Available",};
    Integer[] item_image_b = {R.drawable.grill, R.drawable.golf_clubs, R.drawable.drone, R.drawable.tent,};
    Integer[] item_stars_b = {R.drawable.three_half_stars_, R.drawable.three_half_stars_, R.drawable.three_half_stars_, R.drawable.three_half_stars_};
    String[] item_rating_b = {"32", "87", "19", "26"};
    ArrayList<String> item_name_list = new ArrayList<String>(Arrays.asList(item_name_b));
    ArrayList<String> item_price_list = new ArrayList<String>(Arrays.asList(item_price_b));
    ArrayList<String> item_availability_list = new ArrayList<String>(Arrays.asList(item_availability_b));
    ArrayList<Integer> item_image_list = new ArrayList<Integer>(Arrays.asList(item_image_b));
    ArrayList<Integer> item_stars_list = new ArrayList<Integer>(Arrays.asList(item_stars_b));
    ArrayList<String> item_rating_list = new ArrayList<String>(Arrays.asList(item_rating_b));
    int count = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rent_list);

        gridView = findViewById(R.id.gridview);

        CustomAdapter customAdapter = new CustomAdapter();
        gridView.setAdapter(customAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                String[] item_name = item_name_list.toArray(new String[item_name_list.size()]);
                String[] item_price = item_price_list.toArray(new String[item_price_list.size()]);
                Integer[] item_image = item_image_list.toArray(new Integer[item_image_list.size()]);
                String[] item_rating = item_rating_list.toArray(new String[item_rating_list.size()]);
                Intent intent = new Intent(getApplicationContext(), RentPageOne.class);
                intent.putExtra("item_name", item_name[i]);
                intent.putExtra("item_price", item_price[i]);
                intent.putExtra("item_image", item_image[i]);
                intent.putExtra("item_rating", item_rating[i]);
                startActivity(intent);
            }
        });


        Button map2Button = findViewById(R.id.map2_button);
        map2Button.setOnClickListener(this);

//        Spinner spinner = findViewById(R.id.category_spinner);
        Spinner sort_spin = findViewById(R.id.sort_spinner);

//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.category_choices,android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter_sort = ArrayAdapter.createFromResource(this, R.array.sort_choices,android.R.layout.simple_spinner_item);


//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter_sort.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sort_spin.setAdapter(adapter_sort);
//        spinner.setAdapter(adapter);

//        spinner.setOnItemSelectedListener(this);
        sort_spin.setOnItemSelectedListener(this);


        ImageView map_photo = findViewById(R.id.map_icon);
        map_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(rent_list.this, Map.class);
                startActivity(intent);
            }
        });

    }
    private class CustomAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return count;
        }
        @Override
        public Object getItem(int i){
            return null;
        }
        @Override
        public long getItemId(int i){
            return 0;
        }
        @Override
        public View getView(int i, View view, ViewGroup viewGroup){
            String[] item_name = item_name_list.toArray(new String[item_name_list.size()]);
            String[] item_price = item_price_list.toArray(new String[item_price_list.size()]);
            String[] item_availability = item_availability_list.toArray(new String[item_availability_list.size()]);
            Integer[] item_image = item_image_list.toArray(new Integer[item_image_list.size()]);
            Integer[] item_stars = item_stars_list.toArray(new Integer[item_stars_list.size()]);
            String[] item_rating = item_rating_list.toArray(new String[item_rating_list.size()]);
            View view1 = getLayoutInflater().inflate(R.layout.row_data, null);
            TextView a_item_name = view1.findViewById(R.id.item_name);
            TextView a_item_price = view1.findViewById(R.id.item_price);
            TextView a_item_availability = view1.findViewById(R.id.item_availability);
            ImageView a_item_image = view1.findViewById(R.id.item_image);
            ImageView a_item_stars = view1.findViewById(R.id.item_stars);
            TextView a_item_rating = view1.findViewById(R.id.item_rating);
            a_item_price.setText(item_price[i]);
            a_item_name.setText(item_name[i]);
            a_item_availability.setText(item_availability[i]);
            a_item_rating.setText(item_rating[i]);
            a_item_image.setImageResource(item_image[i]);
            a_item_stars.setImageResource(item_stars[i]);
            return view1;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        if(text.equals("Ratings High to Low")) {
            String[] item_name_c = {"Golf Clubs", "Weber Grill", "12 Person Tent", "Phantom 4 Drone Set"};
            String[] item_price_c = {"$30 per day", "$20 per day", "$50 per day", "$45 per day"};
            String[] item_availability_c = {"Rented Until 12-13-2019", "Available", "Available", "Available"};
            Integer[] item_image_c = {R.drawable.golf_clubs, R.drawable.grill, R.drawable.tent, R.drawable.drone};
            Integer[] item_stars_c = {R.drawable.three_half_stars_, R.drawable.three_half_stars_, R.drawable.three_half_stars_, R.drawable.three_half_stars_};
            String[] item_rating_c = {"87", "32", "26", "19"};
            item_name_list = new ArrayList<String>(Arrays.asList(item_name_c));
            item_price_list = new ArrayList<String>(Arrays.asList(item_price_c));
            item_availability_list = new ArrayList<String>(Arrays.asList(item_availability_c));
            item_image_list = new ArrayList<Integer>(Arrays.asList(item_image_c));
            item_stars_list = new ArrayList<Integer>(Arrays.asList(item_stars_c));
            item_rating_list = new ArrayList<String>(Arrays.asList(item_rating_c));
            count = 4;
            CustomAdapter customAdapter = new CustomAdapter();
            gridView.setAdapter(customAdapter);
        } else if(text.equals("Price Low to High")) {
            String[] item_name_c = {"Weber Grill", "Golf Clubs", "Phantom 4 Drone Set", "12 Person Tent"};
            String[] item_price_c = {"$20 per day", "$30 per day", "$45 per day", "$50 per day"};
            String[] item_availability_c = {"Available", "Rented Until 12-13-2019", "Available", "Available",};
            Integer[] item_image_c = {R.drawable.grill, R.drawable.golf_clubs, R.drawable.drone, R.drawable.tent,};
            Integer[] item_stars_c = {R.drawable.three_half_stars_, R.drawable.three_half_stars_, R.drawable.three_half_stars_, R.drawable.three_half_stars_};
            String[] item_rating_c = {"32", "87", "19", "26"};
            item_name_list = new ArrayList<String>(Arrays.asList(item_name_c));
            item_price_list = new ArrayList<String>(Arrays.asList(item_price_c));
            item_availability_list = new ArrayList<String>(Arrays.asList(item_availability_c));
            item_image_list = new ArrayList<Integer>(Arrays.asList(item_image_c));
            item_stars_list = new ArrayList<Integer>(Arrays.asList(item_stars_c));
            item_rating_list = new ArrayList<String>(Arrays.asList(item_rating_c));
            count = 4;
            CustomAdapter customAdapter = new CustomAdapter();
            gridView.setAdapter(customAdapter);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void onClick(View v) {
        Intent intent = null;
        if (v.getId() == R.id.map2_button) intent = new Intent(rent_list.this, Map.class);
        startActivity(intent);
    }
}
