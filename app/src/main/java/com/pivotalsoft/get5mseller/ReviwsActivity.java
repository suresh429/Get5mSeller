package com.pivotalsoft.get5mseller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.pivotalsoft.get5mseller.Adapters.ReviwesAdapter;
import com.pivotalsoft.get5mseller.ModelItems.ReviewsItem;
import com.pivotalsoft.get5mseller.RecyclerviewUtilities.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class ReviwsActivity extends AppCompatActivity {
    private List<ReviewsItem> reviewsItemList = new ArrayList<>();
    private RecyclerView recyclerView;
    private ReviwesAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviws);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Reviews");

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);

        mAdapter = new ReviwesAdapter(reviewsItemList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);


        prepareReviewsData();
    }

    private void prepareReviewsData() {
        ReviewsItem reviewsItem = new ReviewsItem("RaniUv", "20 hours ago", "3.0","did Hadoop with great experience faculty hasmore than 12 years ");
        reviewsItemList.add(reviewsItem);

        reviewsItem = new ReviewsItem("RaniUv", "14 hours ago", "3.0","did Hadoop with great experience faculty hasmore than 12 years ");
        reviewsItemList.add(reviewsItem);

        reviewsItem = new ReviewsItem("Usha", "14 hours ago", "3.0","did Hadoop with great experience faculty hasmore than 12 years ");
        reviewsItemList.add(reviewsItem);

        reviewsItem = new ReviewsItem("Suresh", "12 hours ago", "3.0","did Hadoop with great experience faculty hasmore than 12 years ");
        reviewsItemList.add(reviewsItem);

        reviewsItem = new ReviewsItem("Venkatesh", "10 hours ago", "3.0","did Hadoop with great experience faculty hasmore than 12 years ");
        reviewsItemList.add(reviewsItem);

        reviewsItem = new ReviewsItem("Sudha", "9 hours ago", "3.0","did Hadoop with great experience faculty hasmore than 12 years ");
        reviewsItemList.add(reviewsItem);

        reviewsItem = new ReviewsItem("Mahesh", "7 hours ago", "3.0","did Hadoop with great experience faculty hasmore than 12 years ");
        reviewsItemList.add(reviewsItem);

        reviewsItem = new ReviewsItem("Rajesh", "8 hours ago", "3.0","did Hadoop with great experience faculty hasmore than 12 years ");
        reviewsItemList.add(reviewsItem);

        reviewsItem = new ReviewsItem("Manoj", "8 hours ago", "4.0","did Hadoop with great experience faculty hasmore than 12 years ");
        reviewsItemList.add(reviewsItem);

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
