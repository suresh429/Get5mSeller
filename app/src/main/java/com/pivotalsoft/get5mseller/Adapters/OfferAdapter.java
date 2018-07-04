package com.pivotalsoft.get5mseller.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.pivotalsoft.get5mseller.ModelItems.OfferItme;
import com.pivotalsoft.get5mseller.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by Gangadhar on 10/13/2017.
 */

public class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.MyViewHolder> {
    String url;
    private Context mContext;
    private List<OfferItme> coursesItemList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView offerName,offerCode,day,month;
        public ImageView thumbnail,overflow;
        public LinearLayout parentLayout;


        public MyViewHolder(View view) {
            super(view);
            offerName = (TextView) view.findViewById(R.id.offerName);
            offerCode = (TextView) view.findViewById(R.id.offerCode);
            day = (TextView) view.findViewById(R.id.day);
            month = (TextView) view.findViewById(R.id.month);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            parentLayout =(LinearLayout)view.findViewById(R.id.parentLayout);
            overflow =(ImageView)view.findViewById(R.id.overflow);

        }
    }


    public OfferAdapter(Context mContext, List<OfferItme> coursesItemList) {
        this.mContext = mContext;
        this.coursesItemList = coursesItemList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.offer_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final OfferItme album = coursesItemList.get(position);
        holder.offerName.setText(album.getOfferName());
        holder.offerCode.setText(album.getOffercode() );

       /* String startDate = formateDateFromstring("yyyy-MM-dd", "dd,MMM,yyyy", album.getStartDate());
        Log.e("startDateformat",""+startDate);

        StringTokenizer tokens = new StringTokenizer(startDate, ",");
        String day = tokens.nextToken();
        String month = tokens.nextToken();// this will contain " they taste good"
        String year = tokens.nextToken();// this will contain "Fruit"

        Log.e("startDatetoken",""+day+"\n"+month);*/

        holder.day.setText(album.getDay());
        holder.month.setText(album.getMonth());
        // loading album cover using Glide library
        /*try {
            Glide.with(mContext).load(album.getCourseimage()).into(holder.thumbnail);
        } catch (Exception e) {
            e.printStackTrace();
        }*/




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



                               // Toast.makeText(mContext,"Postion"+position,Toast.LENGTH_LONG).show();
                                return true;

                            case R.id.action_delete:

                                /*url = Apis.COURSES_URL+"/"+album.getOfferId();
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
        return coursesItemList.size();
    }

    // convert date format

    public static String formateDateFromstring(String inputFormat, String outputFormat, String inputDate){

        Date parsed = null;
        String outputDate = "";

        SimpleDateFormat df_input = new SimpleDateFormat(inputFormat, java.util.Locale.getDefault());
        SimpleDateFormat df_output = new SimpleDateFormat(outputFormat, java.util.Locale.getDefault());

        try {
            parsed = df_input.parse(inputDate);
            outputDate = df_output.format(parsed);

        } catch (ParseException e) {
            // LOGE(TAG, "ParseException - dateFormat");
        }

        return outputDate;

    }

    /*private void delete(){

        StringRequest dr = new StringRequest(Request.Method.DELETE, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        // response
                       // Toast.makeText(mContext, response, Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error.

                    }
                }
        );
        RequestQueue queue = Volley.newRequestQueue(mContext);
        queue.add(dr);
    }*/
}

