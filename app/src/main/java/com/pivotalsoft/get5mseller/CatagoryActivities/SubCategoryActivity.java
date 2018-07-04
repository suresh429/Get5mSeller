package com.pivotalsoft.get5mseller.CatagoryActivities;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;

import com.pivotalsoft.get5mseller.Adapters.SubCategoryAdapter;
import com.pivotalsoft.get5mseller.ModelItems.SubCategoryItem;
import com.pivotalsoft.get5mseller.R;
import com.pivotalsoft.get5mseller.RecyclerviewUtilities.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class SubCategoryActivity extends AppCompatActivity implements View.OnClickListener {
    private List<SubCategoryItem> subCategoryItemArrayList = new ArrayList<>();
    private RecyclerView recyclerView;
    private SubCategoryAdapter mAdapter;
    private FloatingActionButton floatingActionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_category);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Sub Category");
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        floatingActionButton =(FloatingActionButton)findViewById(R.id.floatingActionButtonSub);


        mAdapter = new SubCategoryAdapter(subCategoryItemArrayList,this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);

        floatingActionButton.setOnClickListener(this);


        prepareSubCategoryData();
    }

    private void prepareSubCategoryData() {
        SubCategoryItem reviewsItem = new SubCategoryItem("Dresses");
        subCategoryItemArrayList.add(reviewsItem);

        reviewsItem = new SubCategoryItem("Tops");
        subCategoryItemArrayList.add(reviewsItem);

        reviewsItem = new SubCategoryItem("Tees");
        subCategoryItemArrayList.add(reviewsItem);

        reviewsItem = new SubCategoryItem("Sarees");
        subCategoryItemArrayList.add(reviewsItem);

        reviewsItem = new SubCategoryItem("Salwar Kameez");
        subCategoryItemArrayList.add(reviewsItem);

        reviewsItem = new SubCategoryItem("Others");
        subCategoryItemArrayList.add(reviewsItem);



        mAdapter.notifyDataSetChanged();
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){


            case R.id.floatingActionButtonSub:

                Intent intent4 =new Intent(SubCategoryActivity.this,AddSubCategoryActivity.class);
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
