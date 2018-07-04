package com.pivotalsoft.get5mseller.ProductsActivities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.MenuItem;

import com.pivotalsoft.get5mseller.Adapters.ProductsAdapter;
import com.pivotalsoft.get5mseller.ModelItems.ProductsItem;
import com.pivotalsoft.get5mseller.R;

import java.util.ArrayList;
import java.util.List;

public class ProductsActivity extends AppCompatActivity  {
    private List<ProductsItem> productsItemArrayList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ProductsAdapter mAdapter;

    private GridLayoutManager lLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Category");
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);


        int mNoOfColumns = GridUtility.calculateNoOfColumns(getApplicationContext());
        
        mAdapter = new ProductsAdapter(productsItemArrayList,this);
        lLayout = new GridLayoutManager(ProductsActivity.this, 2);
      //  RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(lLayout);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);




        prepareProductsData();
    }

    private void prepareProductsData() {
        ProductsItem reviewsItem = new ProductsItem("Clothing");
        productsItemArrayList.add(reviewsItem);

        reviewsItem = new ProductsItem("Footwear");
        productsItemArrayList.add(reviewsItem);

        reviewsItem = new ProductsItem("Sarees");
        productsItemArrayList.add(reviewsItem);

        reviewsItem = new ProductsItem("Computers");
        productsItemArrayList.add(reviewsItem);

        reviewsItem = new ProductsItem("Laptops");
        productsItemArrayList.add(reviewsItem);


        reviewsItem = new ProductsItem("mobiles");
        productsItemArrayList.add(reviewsItem);

        reviewsItem = new ProductsItem("Headphone");
        productsItemArrayList.add(reviewsItem);





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
