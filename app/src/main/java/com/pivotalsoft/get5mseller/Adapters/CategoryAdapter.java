package com.pivotalsoft.get5mseller.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pivotalsoft.get5mseller.ModelItems.CategoryItem;
import com.pivotalsoft.get5mseller.R;
import com.pivotalsoft.get5mseller.CatagoryActivities.SubCategoryActivity;

import java.util.List;

/**
 * Created by Gangadhar on 9/16/2017.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {

    private List<CategoryItem> categoryItemList;
    private Context mContext;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public ImageView imageView;
        public LinearLayout catagoeryLayout;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.txtCategoryName);
            imageView = (ImageView) view.findViewById(R.id.imageViewIcon);
            catagoeryLayout=(LinearLayout)view.findViewById(R.id.catagoeryLayout);

        }
    }


    public CategoryAdapter(List<CategoryItem> categoryItemList, Context mContext) {
        this.categoryItemList = categoryItemList;
        this.mContext = mContext;
    }

    @Override
    public CategoryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_list_item, parent, false);

        return new CategoryAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CategoryAdapter.MyViewHolder holder, int position) {
        CategoryItem categoryItem = categoryItemList.get(position);
        holder.name.setText(categoryItem.getCategoryName());
        holder.catagoeryLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 =new Intent(mContext,SubCategoryActivity.class);
                intent4.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                mContext.startActivity(intent4);
            }
        });


    }

    @Override
    public int getItemCount() {
        return categoryItemList.size();
    }
}
