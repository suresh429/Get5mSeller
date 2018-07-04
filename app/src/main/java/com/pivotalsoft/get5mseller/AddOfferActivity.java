package com.pivotalsoft.get5mseller;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class AddOfferActivity extends AppCompatActivity implements View.OnClickListener {
    private ProgressDialog pDialog;
    private DatePickerDialog tentDatePickerDialog,startDatePickerDialog;
    private SimpleDateFormat dateFormatter;
    Button btnSave;
    EditText etOfferCode,etEndDate,etStartDate,etOfferName,etDescription,etIsReferal;
    String offerCode,endDate,startDate,offerName,description,isreferal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_offer);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setTitle("Add Offer");

        // Progress dialog
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);


        dateFormatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

        etOfferCode=(EditText)findViewById(R.id.etOfferCode);
        etEndDate=(EditText)findViewById(R.id.etEndDate);
        etEndDate.setInputType(InputType.TYPE_NULL);
        etEndDate.requestFocus();
        etEndDate.setOnClickListener(this);

        etStartDate=(EditText) findViewById(R.id.etStartDate);
        etStartDate.setInputType(InputType.TYPE_NULL);
        etStartDate.requestFocus();
        etStartDate.setOnClickListener(this);

        etOfferName=(EditText)findViewById(R.id.etOfferName);
        etDescription=(EditText)findViewById(R.id.etDescription);
        etIsReferal=(EditText)findViewById(R.id.etIsRefferal);


        btnSave=(Button)findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);

        setDateTimeField();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSave:
                saveDate();
                break;

            case R.id.etEndDate:

                tentDatePickerDialog.show();
                break;

            case R.id.etStartDate:

                startDatePickerDialog.show();
                break;


        }
    }

    private void setDateTimeField(){

        Calendar newCalendar = Calendar.getInstance();
        tentDatePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                etEndDate.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        startDatePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                etStartDate.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
    }

    private void saveDate(){

        offerCode =etOfferCode.getText().toString().trim();
        endDate =etEndDate.getText().toString().trim();
        startDate =etStartDate.getText().toString().trim();
        offerName =etOfferName.getText().toString().trim();
        description =etDescription.getText().toString().trim();
        isreferal =etIsReferal.getText().toString().trim();


        if (!offerCode.isEmpty() && !endDate.isEmpty() && !startDate.isEmpty() && !offerName.isEmpty()  && !description.isEmpty() && !isreferal.isEmpty()) {

            //addAdds();

        } else {
            Toast.makeText(getApplicationContext(), "Please enter your details!", Toast.LENGTH_LONG).show();
        }
    }


   /* private void addAdds(){

        pDialog.setMessage("Loading ...");
        showDialog();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, Apis.OFFERS_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.e("RESPONSE : ",""+response);
                        hideDialog();

                        Intent pivotal = new Intent(AddOfferActivity.this, OffersActivity.class);
                        pivotal.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(pivotal);
                        Toast.makeText(AddOfferActivity.this,"Offer Added Successfully",Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("RESPONSE_ERROR: ",""+error);
                        hideDialog();
                        // Toast.makeText(AddAddsActivity.this,"Email Already Exist",Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String,String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();

                params.put("offercode",offerCode);
                params.put("offername",offerName);
                params.put("startdate", startDate);
                params.put("enddate",endDate);
                params.put("description", description);
                params.put("isreferal", isreferal);
                Log.e("RESPONSE_Parasms: ",""+offerCode+"\n"+offerName+"\n"+endDate+"\n"+startDate);
                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }*/





    private void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return true;
    }


}

