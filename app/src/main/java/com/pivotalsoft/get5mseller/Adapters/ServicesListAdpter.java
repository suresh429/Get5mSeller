package com.pivotalsoft.get5mseller.Adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.pivotalsoft.get5mseller.ModelItems.ServiceListItem;
import com.pivotalsoft.get5mseller.R;
import com.pivotalsoft.get5mseller.ServicesActivities.ServiceDetailsActivity;

import java.util.List;

/**
 * Created by Gangadhar on 9/19/2017.
 */

public class ServicesListAdpter extends RecyclerView.Adapter<ServicesListAdpter.MyViewHolder> {

    private List<ServiceListItem> productsItemList;
    private Context mContext;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView productName;
        public TextView price;
        public TextView discountPrice;
        public TextView status;
        public ImageView imageView,overflow;;
        public LinearLayout productsLayout;

        public MyViewHolder(View view) {
            super(view);
            productName = (TextView) view.findViewById(R.id.txtProductName);
            price = (TextView) view.findViewById(R.id.txtPrice);
            discountPrice = (TextView) view.findViewById(R.id.txtDiscountPrice);
            discountPrice.setPaintFlags(discountPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            status = (TextView) view.findViewById(R.id.txtStatus);
            imageView = (ImageView) view.findViewById(R.id.imageViewProduct);
            productsLayout=(LinearLayout)view.findViewById(R.id.mainLayout);
            overflow=(ImageView)view.findViewById(R.id.overflow);

        }
    }


    public ServicesListAdpter(List<ServiceListItem> productsItemList, Context mContext) {
        this.productsItemList = productsItemList;
        this.mContext = mContext;
    }

    @Override
    public ServicesListAdpter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.all_product_list_item, parent, false);

        return new ServicesListAdpter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ServicesListAdpter.MyViewHolder holder, final int position) {
        ServiceListItem productsItem = productsItemList.get(position);
        holder.productName.setText(productsItem.getProductName());
        holder.price.setText(productsItem.getPrice());
        holder.discountPrice.setText(productsItem.getDiscountPrice());
        holder.status.setText(productsItem.getStatus());
        holder.imageView.setImageResource(productsItem.getImage());

        holder.productsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 =new Intent(mContext,ServiceDetailsActivity.class);
                intent4.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                mContext.startActivity(intent4);
            }
        });

        holder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // inflate menu
                PopupMenu popup = new PopupMenu(mContext, v);
                MenuInflater inflater = popup.getMenuInflater();
                inflater.inflate(R.menu.menu_overflow, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        switch (item.getItemId()) {

                            case R.id.action_edit:

                                Toast.makeText(mContext,"Postion"+position,Toast.LENGTH_LONG).show();
                                return true;

                            case R.id.action_delete:

                               /* url = Apis.COURSES_URL+"/"+album.getCourseid();
                                Log.e("URL:",""+url);
                                delete();
                                coursesItemList.remove(position);
                                notifyDataSetChanged();*/
                                return true;

                            default:
                        }


                        return false;
                    }
                });
                popup.show();


            }
        });


    }

    @Override
    public int getItemCount() {
        return productsItemList.size();
    }
}


