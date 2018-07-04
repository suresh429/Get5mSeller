package com.pivotalsoft.get5mseller.ServicesActivities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.MenuItem;

import com.pivotalsoft.get5mseller.Adapters.ServiceAdapter;
import com.pivotalsoft.get5mseller.ModelItems.ServiceGridItem;
import com.pivotalsoft.get5mseller.ProductsActivities.ProductsActivity;
import com.pivotalsoft.get5mseller.R;

import java.util.ArrayList;
import java.util.List;

public class ServicesActivity extends AppCompatActivity  {
    private List<ServiceGridItem> serviceGridItemArrayList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ServiceAdapter mAdapter;

    private GridLayoutManager lLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Category");

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);


        int mNoOfColumns = ProductsActivity.GridUtility.calculateNoOfColumns(getApplicationContext());

        mAdapter = new ServiceAdapter(serviceGridItemArrayList,this);
        lLayout = new GridLayoutManager(ServicesActivity.this, 2);
        //  RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(lLayout);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);




        prepareProductsData();
    }

    private void prepareProductsData() {
        ServiceGridItem reviewsItem = new ServiceGridItem("Clothing");
        serviceGridItemArrayList.add(reviewsItem);

        reviewsItem = new ServiceGridItem("Footwear");
        serviceGridItemArrayList.add(reviewsItem);

        reviewsItem = new ServiceGridItem("Sarees");
        serviceGridItemArrayList.add(reviewsItem);

        reviewsItem = new ServiceGridItem("Computers");
        serviceGridItemArrayList.add(reviewsItem);

        reviewsItem = new ServiceGridItem("Laptops");
        serviceGridItemArrayList.add(reviewsItem);


        reviewsItem = new ServiceGridItem("mobiles");
        serviceGridItemArrayList.add(reviewsItem);

        reviewsItem = new ServiceGridItem("Headphone");
        serviceGridItemArrayList.add(reviewsItem);





        mAdapter.notifyDataSetChanged();
    }


    public static class GridUtility {
        public static int calculateNoOfColumns(Context context) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
            int noOfColumns = (int) (dpWidth / 180);
            return noOfColumns;
        }
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
