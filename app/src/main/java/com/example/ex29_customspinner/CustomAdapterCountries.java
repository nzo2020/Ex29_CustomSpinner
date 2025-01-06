package com.example.ex29_customspinner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapterCountries extends BaseAdapter {
    private Context context;
    private int[] images;
    private String[] countries;
    private String[] capitalCities;
    private LayoutInflater inflater;

    public CustomAdapterCountries(Context context, int[] images, String[] countries, String[] capitalCities) {
        this.context = context;
        this.images = images;
        this.countries = countries;
        this.capitalCities = capitalCities;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return countries.length;
    }

    @Override
    public Object getItem(int position) {
        return countries[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.custom_spinner, parent, false);
        ImageView img = convertView.findViewById(R.id.countryFlag);
        TextView countryName = convertView.findViewById(R.id.country);
        TextView capitalCity = convertView.findViewById(R.id.capitalCity);

        img.setImageResource(images[position]);
        countryName.setText(countries[position]);
        capitalCity.setText(capitalCities[position]);

        return convertView;
    }
}
