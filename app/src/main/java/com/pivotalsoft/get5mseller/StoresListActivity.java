package com.pivotalsoft.get5mseller;

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

import com.pivotalsoft.get5mseller.Adapters.StoresListAdapter;
import com.pivotalsoft.get5mseller.ModelItems.StoresItem;

import java.util.ArrayList;
import java.util.List;

public class StoresListActivity extends AppCompatActivity implements View.OnClickListener {
    private FloatingActionButton floatingActionButton;
    private List<StoresItem> productsItemArrayList = new ArrayList<>();
    private RecyclerView recyclerView;
    private StoresListAdapter mAdapter;

    private GridLayoutManager lLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stores_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Stores");

        floatingActionButton =(FloatingActionButton)findViewById(R.id.fabAddProduct);
        floatingActionButton.setOnClickListener(this);

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);



        int mNoOfColumns = StoresListActivity.GridUtility.calculateNoOfColumns(getApplicationContext());

        mAdapter = new StoresListAdapter(productsItemArrayList,this);
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
        StoresItem reviewsItem = new StoresItem(R.drawable.ic_vector_store,"Super Store","89850810803","super@gmail.com","ramatakies,vizag");
        productsItemArrayList.add(reviewsItem);

        reviewsItem =  new StoresItem(R.drawable.ic_vector_store,"Retailer Store","89850810803","Retailer@gmail.com","ramatakies,vizag");
        productsItemArrayList.add(reviewsItem);

        reviewsItem =  new StoresItem(R.drawable.ic_vector_store,"Spark","89850810803","Spark@gmail.com","ramatakies,vizag");
        productsItemArrayList.add(reviewsItem);


        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){


            case R.id.fabAddProduct:

                Intent intent4 =new Intent(this,AddStoresActivity.class);
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

