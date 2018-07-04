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

import com.pivotalsoft.get5mseller.ModelItems.ProductsItem;
import com.pivotalsoft.get5mseller.ProductsActivities.ProductsSubCategoryActivity;
import com.pivotalsoft.get5mseller.R;

import java.util.List;

/**
 * Created by Gangadhar on 9/16/2017.
 */

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.MyViewHolder> {

    private List<ProductsItem> productsItemList;
    private Context mContext;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public ImageView imageView;
        public LinearLayout productsLayout;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.txtProductName);
            imageView = (ImageView) view.findViewById(R.id.imageViewIcon);
            productsLayout=(LinearLayout)view.findViewById(R.id.productsLayout);

        }
    }


    public ProductsAdapter(List<ProductsItem> productsItemList, Context mContext) {
        this.productsItemList = productsItemList;
        this.mContext = mContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ProductsAdapter.MyViewHolder holder, int position) {
        ProductsItem productsItem = productsItemList.get(position);
        holder.name.setText(productsItem.getProductName());
        holder.productsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 =new Intent(mContext,ProductsSubCategoryActivity.class);
                intent4.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                mContext.startActivity(intent4);
            }
        });


    }

    @Override
    public int getItemCount() {
        return productsItemList.size();
    }
}

