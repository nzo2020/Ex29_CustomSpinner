package com.example.ex29_customspinner;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spin_countries;
    String[] capitalCities;
    String[] countries;
    String[] populationSizes;
    int[] images;
    TextView details;
    CustomAdapterCountries customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spin_countries = findViewById(R.id.spinner_countries);
        details = findViewById(R.id.details);

        capitalCities = getResources().getStringArray(R.array.CapitalCities);
        countries = getResources().getStringArray(R.array.Countries);
        populationSizes = getResources().getStringArray(R.array.PopulationSizes);


        images = new int[]{R.drawable.white, R.drawable.china, R.drawable.france, R.drawable.germany,
                R.drawable.greece, R.drawable.israel, R.drawable.japan, R.drawable.usa};

        customAdapter = new CustomAdapterCountries(this, images, countries, capitalCities);
        spin_countries.setAdapter(customAdapter);
        spin_countries.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (position == 0) {
            details.setText("");
            return;
        }
        details.setText("Country name: " + countries[position] + "\nCapital City: " + capitalCities[position] +  "\nPopulation size: " + populationSizes[position]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}