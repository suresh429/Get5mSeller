package com.pivotalsoft.get5mseller.Adapters;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.pivotalsoft.get5mseller.ModelItems.ReviewsItem;
import com.pivotalsoft.get5mseller.R;

import java.util.List;

/**
 * Created by Gangadhar on 9/13/2017.
 */

public class ReviwesAdapter extends RecyclerView.Adapter<ReviwesAdapter.MyViewHolder> {

    private List<ReviewsItem> reviewsItemList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, time, description;
        public RatingBar ratingBar;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.txtName);
            time = (TextView) view.findViewById(R.id.txtTime);
            description = (TextView) view.findViewById(R.id.txtDescription);
            ratingBar =(RatingBar)view.findViewById(R.id.ratingbar);
        }
    }


    public ReviwesAdapter(List<ReviewsItem> reviewsItemList) {
        this.reviewsItemList = reviewsItemList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.reviwes_list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ReviewsItem reviewsItem = reviewsItemList.get(position);
        holder.name.setText(reviewsItem.getName());
        holder.time.setText(reviewsItem.getTime());
        holder.description.setText(reviewsItem.getDescription());
        holder.ratingBar.setRating(Float.parseFloat(reviewsItem.getRating()));
        // rating bar indicater color
        LayerDrawable stars = (LayerDrawable) holder.ratingBar.getProgressDrawable();
        stars.getDrawable(2).setColorFilter(Color.parseColor("#FF4081"), PorterDuff.Mode.SRC_ATOP);
    }

    @Override
    public int getItemCount() {
        return reviewsItemList.size();
    }
}
