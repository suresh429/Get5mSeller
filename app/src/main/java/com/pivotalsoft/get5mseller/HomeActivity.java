package com.pivotalsoft.get5mseller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;

import com.pivotalsoft.get5mseller.CatagoryActivities.CategoriesActivity;
import com.pivotalsoft.get5mseller.ProductsActivities.ProductsActivity;
import com.pivotalsoft.get5mseller.ServicesActivities.ServicesActivity;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    ImageView imgProfile,imgEnquiries,imgStores,imgCatagoeries,imgProdcts,imgServices,imgOffers,imgStocks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Sri Divya Jyothi Enterprises");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View hView =  navigationView.getHeaderView(0);

        RatingBar ratingBar =(RatingBar)hView.findViewById(R.id.ratingbar);
        RelativeLayout reviewsLayout =(RelativeLayout)hView.findViewById(R.id.reviewsLayout);


        imgProfile =(ImageView)findViewById(R.id.imgProfile);
        imgEnquiries = (ImageView)findViewById(R.id.imgEnquiries);
        imgStores =(ImageView)findViewById(R.id.imgStores);
        imgCatagoeries =(ImageView)findViewById(R.id.imgCategoeries);
        imgProdcts =(ImageView)findViewById(R.id.imgProducts);
        imgServices =(ImageView)findViewById(R.id.imgServices);
        imgOffers =(ImageView)findViewById(R.id.imgOffers);
        imgStocks =(ImageView)findViewById(R.id.imgStocks);


        imgEnquiries.setOnClickListener(this);
        imgProfile.setOnClickListener(this);
        imgStores.setOnClickListener(this);
        imgCatagoeries.setOnClickListener(this);
        imgProdcts.setOnClickListener(this);
        imgServices.setOnClickListener(this);
        imgOffers.setOnClickListener(this);
        imgStocks.setOnClickListener(this);
        reviewsLayout.setOnClickListener(this);



    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_orders) {

        } else if (id == R.id.nav_catalogue) {

        } else if (id == R.id.nav_payments) {

        } else if (id == R.id.nav_returns) {

        } else if (id == R.id.nav_support) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.imgProfile:

                Intent intent =new Intent(HomeActivity.this,BusinessProfileActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

                break;

            case R.id.reviewsLayout:

                Intent intent1 =new Intent(HomeActivity.this,ReviwsActivity.class);
                intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent1);

                break;

            case R.id.imgEnquiries:

                Intent intent2 =new Intent(HomeActivity.this,EnquiriesActivity.class);
                intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent2);

                break;

            case R.id.imgStores:

                Intent intent3 =new Intent(HomeActivity.this,StoresListActivity.class);
                intent3.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent3);

                break;

            case R.id.imgCategoeries:

                Intent intent4 =new Intent(HomeActivity.this,CategoriesActivity.class);
                intent4.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent4);

                break;

            case R.id.imgProducts:

                Intent intent5=new Intent(HomeActivity.this,ProductsActivity.class);
                intent5.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent5);

                break;

            case R.id.imgServices:

                Intent intent6=new Intent(HomeActivity.this,ServicesActivity.class);
                intent6.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent6);

                break;

            case R.id.imgOffers:

                Intent intent7=new Intent(HomeActivity.this,OffersActivity.class);
                intent7.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent7);

                break;

            case R.id.imgStocks:

                Intent intent8=new Intent(HomeActivity.this,StockesActivity.class);
                intent8.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent8);

                break;
        }
    }
}
