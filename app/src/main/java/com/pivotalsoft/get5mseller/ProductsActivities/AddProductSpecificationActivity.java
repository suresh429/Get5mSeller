package com.pivotalsoft.get5mseller.ProductsActivities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.pivotalsoft.get5mseller.R;

import java.util.ArrayList;
import java.util.List;

public class AddProductSpecificationActivity extends AppCompatActivity {
CheckBox checkBoxCategory;
    LinearLayout specificationLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product_specification);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Add Products Specification");

        checkBoxCategory =(CheckBox)findViewById(R.id.checkBoxCatagoery);
        specificationLayout =(LinearLayout)findViewById(R.id.specificationLayout);

        checkBoxCategory.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked){
                    specificationLayout.setVisibility(View.GONE);
                }
                else {

                    specificationLayout.setVisibility(View.VISIBLE);
                }
            }
        });

        // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.spinnerCategoryType);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Category Type");
        categories.add("Warranty");
        categories.add("In the box");
        categories.add("General");
        categories.add("Camera");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

        // Spinner click listener
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // On selecting a spinner item
                String item = parent.getItemAtPosition(position).toString();

                // Showing selected spinner item
                Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
