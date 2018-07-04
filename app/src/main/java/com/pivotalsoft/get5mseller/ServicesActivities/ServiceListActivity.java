package com.pivotalsoft.get5mseller.ServicesActivities;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;

import com.pivotalsoft.get5mseller.Adapters.ServicesListAdpter;
import com.pivotalsoft.get5mseller.ModelItems.ServiceListItem;
import com.pivotalsoft.get5mseller.R;

import java.util.ArrayList;
import java.util.List;

public class ServiceListActivity extends AppCompatActivity implements View.OnClickListener {
    private FloatingActionButton floatingActionButton;
    private List<ServiceListItem> productsItemArrayList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ServicesListAdpter mAdapter;

    private GridLayoutManager lLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Services");

        floatingActionButton =(FloatingActionButton)findViewById(R.id.fabAddService);
        floatingActionButton.setOnClickListener(this);

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);



       // int mNoOfColumns = ServiceListActivity.GridUtility.calculateNoOfColumns(getApplicationContext());

        mAdapter = new ServicesListAdpter(productsItemArrayList,this);
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
        ServiceListItem reviewsItem = new ServiceListItem(R.drawable.ic_vector_services,"Lee","150 Rs","20 Rs","Avalible");
        productsItemArrayList.add(reviewsItem);

        reviewsItem =  new ServiceListItem(R.drawable.ic_vector_services,"Reebok","350 Rs","20 Rs","Avalible");
        productsItemArrayList.add(reviewsItem);

        reviewsItem =  new ServiceListItem(R.drawable.layerbackground,"Spark","450 Rs","20 Rs","Sold Out");
        productsItemArrayList.add(reviewsItem);

        reviewsItem =  new ServiceListItem(R.drawable.ic_vector_services,"Jaken Jones","150 Rs","20 Rs","Avalible");
        productsItemArrayList.add(reviewsItem);

        reviewsItem =  new ServiceListItem(R.drawable.layerbackground,"Buffelleo","850 Rs","20 Rs","Sold Out");
        productsItemArrayList.add(reviewsItem);


        reviewsItem =  new ServiceListItem(R.drawable.ic_vector_services,"Reebok","150 Rs","20 Rs","Sold Out");
        productsItemArrayList.add(reviewsItem);

        reviewsItem =  new ServiceListItem(R.drawable.layerbackground,"Spark","1500 Rs","20 Rs","Avalible");
        productsItemArrayList.add(reviewsItem);





        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){


            case R.id.fabAddService:

                Intent intent4 =new Intent(this,AddServiceActivity.class);
                intent4.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent4);

                break;

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
