package com.pivotalsoft.get5mseller.ProductsActivities;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;

import com.pivotalsoft.get5mseller.Adapters.ProductsListAdapter;
import com.pivotalsoft.get5mseller.ModelItems.ProductsListItem;
import com.pivotalsoft.get5mseller.R;

import java.util.ArrayList;
import java.util.List;

public class ProductsListActivity extends AppCompatActivity implements View.OnClickListener {
    private FloatingActionButton floatingActionButton;
    private List<ProductsListItem> productsItemArrayList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ProductsListAdapter mAdapter;

    private GridLayoutManager lLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Products");

        floatingActionButton =(FloatingActionButton)findViewById(R.id.fabAddProduct);
        floatingActionButton.setOnClickListener(this);

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);



        int mNoOfColumns = GridUtility.calculateNoOfColumns(getApplicationContext());

        mAdapter = new ProductsListAdapter(productsItemArrayList,this);
        lLayout = new GridLayoutManager(this, 1);
        //  RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(lLayout);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);




        prepareProductsData();
    }

    private void prepareProductsData() {
        ProductsListItem reviewsItem = new ProductsListItem(R.drawable.ghee_gober_diya,"Ghee Gober Lamp","150 Rs","20 Rs","Avalible");
        productsItemArrayList.add(reviewsItem);

        reviewsItem =  new ProductsListItem(R.drawable.gober_diya,"Gober Lamp","350 Rs","20 Rs","Avalible");
        productsItemArrayList.add(reviewsItem);

        reviewsItem =  new ProductsListItem(R.drawable.gober_cake,"Gober Cake","450 Rs","20 Rs","Sold Out");
        productsItemArrayList.add(reviewsItem);

        reviewsItem =  new ProductsListItem(R.drawable.cow_ghee,"Cow Ghee","150 Rs","20 Rs","Avalible");
        productsItemArrayList.add(reviewsItem);

      /*  reviewsItem =  new ProductsListItem(R.drawable.layerbackground,"Buffelleo","850 Rs","20 Rs","Sold Out");
        productsItemArrayList.add(reviewsItem);


        reviewsItem =  new ProductsListItem(R.drawable.ic_vector_products,"Reebok","150 Rs","20 Rs","Sold Out");
        productsItemArrayList.add(reviewsItem);

        reviewsItem =  new ProductsListItem(R.drawable.layerbackground,"Spark","1500 Rs","20 Rs","Avalible");
        productsItemArrayList.add(reviewsItem);*/





        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){


            case R.id.fabAddProduct:

                Intent intent4 =new Intent(this,AddProductActivity.class);
                intent4.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent4);

                break;

        }
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
