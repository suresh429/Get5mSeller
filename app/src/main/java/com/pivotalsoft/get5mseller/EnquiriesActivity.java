package com.pivotalsoft.get5mseller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.pivotalsoft.get5mseller.Adapters.EnquiriesAdapter;
import com.pivotalsoft.get5mseller.ModelItems.EnqiriesItem;

import java.util.ArrayList;
import java.util.List;

public class EnquiriesActivity extends AppCompatActivity {
    private List<EnqiriesItem> enqiriesItemList = new ArrayList<>();
    private RecyclerView recyclerView;
    private EnquiriesAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enquiries);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Enquiries");

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view_enquiries);

        mAdapter = new EnquiriesAdapter(enqiriesItemList,EnquiriesActivity.this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(EnquiriesActivity.this, LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
       // recyclerView.addItemDecoration(new DividerItemDecoration(EnquiriesActivity.this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);


        prepareEnquriesData();
    }

    private void prepareEnquriesData() {
        EnqiriesItem reviewsItem = new EnqiriesItem("11 Sep 2017", "Srikar", "needs web desigining training","06:15 PM","In Progress");
        enqiriesItemList.add(reviewsItem);

         reviewsItem = new EnqiriesItem("", "Naidu", "needs web desigining training","06:15 PM","New");
        enqiriesItemList.add(reviewsItem);

         reviewsItem = new EnqiriesItem("", "Uday", "needs web desigining training","06:15 PM","In Progress");
        enqiriesItemList.add(reviewsItem);

        reviewsItem = new EnqiriesItem("08 sep 2017", "JayaKrishna", "needs web desigining training","06:15 PM","In Progress");
        enqiriesItemList.add(reviewsItem);

        reviewsItem = new EnqiriesItem("", "Suresh", "needs web desigining training","06:15 PM","Completed");
        enqiriesItemList.add(reviewsItem);

        reviewsItem = new EnqiriesItem("", "Mahesh", "needs web desigining training","06:15 PM","In Progress");
        enqiriesItemList.add(reviewsItem);

        mAdapter.notifyDataSetChanged();
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
