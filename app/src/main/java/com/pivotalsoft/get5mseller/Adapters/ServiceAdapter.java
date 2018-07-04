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

import com.pivotalsoft.get5mseller.ModelItems.ServiceGridItem;
import com.pivotalsoft.get5mseller.R;
import com.pivotalsoft.get5mseller.ServicesActivities.ServiceSubActivity;

import java.util.List;

/**
 * Created by Gangadhar on 9/18/2017.
 */

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.MyViewHolder> {

    private List<ServiceGridItem> serviceGridItems;
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


    public ServiceAdapter(List<ServiceGridItem> serviceGridItems, Context mContext) {
        this.serviceGridItems = serviceGridItems;
        this.mContext = mContext;
    }

    @Override
    public ServiceAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.product_list_item, parent, false);

        return new ServiceAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ServiceAdapter.MyViewHolder holder, int position) {
        ServiceGridItem productsItem = serviceGridItems.get(position);
        holder.name.setText(productsItem.getServiceName());
        holder.productsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 =new Intent(mContext,ServiceSubActivity.class);
                intent4.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                mContext.startActivity(intent4);
            }
        });


    }

    @Override
    public int getItemCount() {
        return serviceGridItems.size();
    }
}