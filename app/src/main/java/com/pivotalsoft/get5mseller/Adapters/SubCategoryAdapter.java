package com.pivotalsoft.get5mseller.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pivotalsoft.get5mseller.ModelItems.SubCategoryItem;
import com.pivotalsoft.get5mseller.R;

import java.util.List;

/**
 * Created by Gangadhar on 9/16/2017.
 */

public class SubCategoryAdapter extends RecyclerView.Adapter<SubCategoryAdapter.MyViewHolder> {

    private List<SubCategoryItem> subCategoryItemList;
    private Context mContext;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        private LinearLayout subcategoryLayout;


        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.txtSubCategoryName);
            subcategoryLayout =(LinearLayout)view.findViewById(R.id.subcategoryLayout);

        }
    }


    public SubCategoryAdapter(List<SubCategoryItem> subCategoryItemList, Context mContext) {
        this.subCategoryItemList = subCategoryItemList;
        this.mContext = mContext;
    }

    @Override
    public SubCategoryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.subcategory_list_item, parent, false);

        return new SubCategoryAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(SubCategoryAdapter.MyViewHolder holder, int position) {
        SubCategoryItem subCategoryItem = subCategoryItemList.get(position);
        holder.name.setText(subCategoryItem.getSubcategoryName());




    }

    @Override
    public int getItemCount() {
        return subCategoryItemList.size();
    }
}

