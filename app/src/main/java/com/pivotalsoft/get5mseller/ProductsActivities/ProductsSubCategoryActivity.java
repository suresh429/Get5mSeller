package com.pivotalsoft.get5mseller.ProductsActivities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.MenuItem;

import com.pivotalsoft.get5mseller.Adapters.ProductSubAdapter;
import com.pivotalsoft.get5mseller.ModelItems.ProductSubItem;
import com.pivotalsoft.get5mseller.R;

import java.util.ArrayList;
import java.util.List;

public class ProductsSubCategoryActivity extends AppCompatActivity  {
    private List<ProductSubItem> productsItemArrayList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ProductSubAdapter mAdapter;
    private GridLayoutManager lLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_sub_category);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Sub Category");

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);

        int mNoOfColumns = ProductsActivity.GridUtility.calculateNoOfColumns(getApplicationContext());

        mAdapter = new ProductSubAdapter(productsItemArrayList,this);
        lLayout = new GridLayoutManager(this, 2);
        //  RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(lLayout);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);




        prepareProductsData();
    }

    private void prepareProductsData() {
        ProductSubItem reviewsItem = new ProductSubItem("Jeans");
        productsItemArrayList.add(reviewsItem);

        reviewsItem = new ProductSubItem("T-Shirts");
        productsItemArrayList.add(reviewsItem);

        reviewsItem = new ProductSubItem("Casuals");
        productsItemArrayList.add(reviewsItem);

        reviewsItem = new ProductSubItem("Traks");
        productsItemArrayList.add(reviewsItem);

        reviewsItem = new ProductSubItem("Formal Shirts");
        productsItemArrayList.add(reviewsItem);


        reviewsItem = new ProductSubItem("Casual Shirts");
        productsItemArrayList.add(reviewsItem);

        reviewsItem = new ProductSubItem("Printed Shirts");
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

