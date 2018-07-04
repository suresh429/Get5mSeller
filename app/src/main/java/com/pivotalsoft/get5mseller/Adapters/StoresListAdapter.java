package com.pivotalsoft.get5mseller.Adapters;

import android.content.Context;
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

import com.pivotalsoft.get5mseller.ModelItems.StoresItem;
import com.pivotalsoft.get5mseller.R;

import java.util.List;

/**
 * Created by Gangadhar on 10/25/2017.
 */

public class StoresListAdapter extends RecyclerView.Adapter<StoresListAdapter.MyViewHolder> {

    private List<StoresItem> productsItemList;
    private Context mContext;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView shopName;
        public TextView mobile;
        public TextView email;
        public TextView address;
        public ImageView imageView,overflow;
        public LinearLayout productsLayout;

        public MyViewHolder(View view) {
            super(view);
            shopName = (TextView) view.findViewById(R.id.txtShopName);
            mobile = (TextView) view.findViewById(R.id.txtMobile);
            email = (TextView) view.findViewById(R.id.txtEmail);
            //discountPrice.setPaintFlags(discountPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            address = (TextView) view.findViewById(R.id.txtAddress);
            imageView = (ImageView) view.findViewById(R.id.imageViewProduct);
            productsLayout=(LinearLayout)view.findViewById(R.id.mainLayout);
            overflow=(ImageView)view.findViewById(R.id.overflow);

        }
    }


    public StoresListAdapter(List<StoresItem> productsItemList, Context mContext) {
        this.productsItemList = productsItemList;
        this.mContext = mContext;
    }

    @Override
    public StoresListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.all_stors_list, parent, false);

        return new StoresListAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(StoresListAdapter.MyViewHolder holder, final int position) {
        StoresItem productsItem = productsItemList.get(position);
        holder.shopName.setText(productsItem.getShopName());
        holder.mobile.setText(productsItem.getMobile());
        holder.email.setText(productsItem.getEmail());
        holder.address.setText(productsItem.getAddress());
        holder.imageView.setImageResource(productsItem.getImage());

       /* holder.productsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 =new Intent(mContext,AddStoresActivity.class);
                intent4.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                mContext.startActivity(intent4);
            }
        });*/
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

