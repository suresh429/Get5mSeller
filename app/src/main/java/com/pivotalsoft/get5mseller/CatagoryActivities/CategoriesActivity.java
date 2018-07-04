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

import com.pivotalsoft.get5mseller.Adapters.CategoryAdapter;
import com.pivotalsoft.get5mseller.ModelItems.CategoryItem;
import com.pivotalsoft.get5mseller.R;
import com.pivotalsoft.get5mseller.RecyclerviewUtilities.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class CategoriesActivity extends AppCompatActivity implements View.OnClickListener {
    private List<CategoryItem> categoryItemArrayList = new ArrayList<>();
    private RecyclerView recyclerView;
    private CategoryAdapter mAdapter;
    private FloatingActionButton floatingActionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Category");

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        floatingActionButton =(FloatingActionButton)findViewById(R.id.floatingActionButtoncategory);


        mAdapter = new CategoryAdapter(categoryItemArrayList,this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);

        floatingActionButton.setOnClickListener(this);







        prepareCategoryData();
    }

    private void prepareCategoryData() {
        CategoryItem reviewsItem = new CategoryItem(R.drawable.ic_mail_black_24dp,"Clothing");
        categoryItemArrayList.add(reviewsItem);

        reviewsItem = new CategoryItem(R.drawable.ic_mail_black_24dp,"Accessories");
        categoryItemArrayList.add(reviewsItem);

        reviewsItem = new CategoryItem(R.drawable.ic_mail_black_24dp,"Footwear");
        categoryItemArrayList.add(reviewsItem);

        reviewsItem = new CategoryItem(R.drawable.ic_mail_black_24dp,"Bags");
        categoryItemArrayList.add(reviewsItem);

        reviewsItem = new CategoryItem(R.drawable.ic_mail_black_24dp,"men Clothing");
        categoryItemArrayList.add(reviewsItem);

        reviewsItem = new CategoryItem(R.drawable.ic_mail_black_24dp,"Men FootWear");
        categoryItemArrayList.add(reviewsItem);

        reviewsItem = new CategoryItem(R.drawable.ic_mail_black_24dp,"Men Bags");
        categoryItemArrayList.add(reviewsItem);


        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){


            case R.id.floatingActionButtoncategory:

                Intent intent4 =new Intent(CategoriesActivity.this,AddCategoryActivity.class);
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