package com.pivotalsoft.get5mseller.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.pivotalsoft.get5mseller.CustomJava.SomeDrawable;
import com.pivotalsoft.get5mseller.ModelItems.EnqiriesItem;
import com.pivotalsoft.get5mseller.R;
import com.pivotalsoft.get5mseller.SummeryActivity;

import java.util.List;

/**
 * Created by Gangadhar on 9/13/2017.
 */

public class EnquiriesAdapter extends RecyclerView.Adapter<EnquiriesAdapter.MyViewHolder> {

    private List<EnqiriesItem> enqiriesItemList;
    private Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, time, description,date,status;
        public LinearLayout enquiriesLayout;


        public MyViewHolder(View view) {
            super(view);
            enquiriesLayout =(LinearLayout)view.findViewById(R.id.enquiriesLayout);
            name = (TextView) view.findViewById(R.id.txtName);
            time = (TextView) view.findViewById(R.id.txtTime);
            description = (TextView) view.findViewById(R.id.txtDescription);
            date =(TextView)view.findViewById(R.id.txtDate);
            status = (TextView)view.findViewById(R.id.txtStatus);


        }
    }


    public EnquiriesAdapter(List<EnqiriesItem> enqiriesItemList, Context context) {
        this.enqiriesItemList = enqiriesItemList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.enquiries_list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        EnqiriesItem enqiriesItem = enqiriesItemList.get(position);
        holder.name.setText(enqiriesItem.getName());
        holder.time.setText(enqiriesItem.getTime());
        holder.description.setText(enqiriesItem.getDiscription());
        holder.status.setText(enqiriesItem.getStatus());

       // dynamic stoke color
        SomeDrawable drawable = new SomeDrawable(Color.parseColor("#ffffff"),Color.parseColor("#ffffff"),Color.parseColor("#ffffff"),3,Color.parseColor("#1cb692"),00);
        holder.status.setBackgroundDrawable(drawable);

        if (enqiriesItem.getDate().equals("")){

           holder.date.setVisibility(View.GONE);
        }
        else {

            holder.date.setVisibility(View.VISIBLE);

            holder.date.setText(enqiriesItem.getDate());
        }

        holder.enquiriesLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context,"bbwdb",Toast.LENGTH_LONG).show();

                Intent intent2 =new Intent(context,SummeryActivity.class);
                intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                context.startActivity(intent2);
            }
        });




    }

    @Override
    public int getItemCount() {
        return enqiriesItemList.size();
    }
}
