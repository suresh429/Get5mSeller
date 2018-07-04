package com.pivotalsoft.get5mseller;

import android.app.TimePickerDialog;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class BusinessHoursActivity extends AppCompatActivity {
    int i = 0;
    int j = 0;
    int k = 0;
    int l = 0;
    int m = 0;
    int n = 0;
    int p = 0;

    Button MbuttonSun, MbuttonMon, MbuttonTue, MbuttonWed, MbuttonThu, MbuttonFri, MbuttonSat;
    EditText etFromTime1,etToTime1,etToTime2,etFromTime2;
    TextView MtxtSunday,MtxtMonday,MtxtTuesday,MtxtWednsday,MtxtThursday,MtxtFriday,MtxtSaturday;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_hours);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Business Hours");

        //  roundend Morning Buttons
        MbuttonSun =(Button)findViewById(R.id.MsunText);
        MbuttonMon =(Button)findViewById(R.id.MmonText);
        MbuttonTue =(Button)findViewById(R.id.MtueText);
        MbuttonWed =(Button)findViewById(R.id.MwedText);
        MbuttonThu =(Button)findViewById(R.id.MthuText);
        MbuttonFri =(Button)findViewById(R.id.MfriText);
        MbuttonSat =(Button)findViewById(R.id.MsatText);


        // Morning textviews
        MtxtSunday=(TextView)findViewById(R.id.Msunday);
        MtxtMonday=(TextView)findViewById(R.id.Mmonday);
        MtxtTuesday=(TextView)findViewById(R.id.Mthuseday);
        MtxtWednsday=(TextView)findViewById(R.id.Mwednesday);
        MtxtThursday=(TextView)findViewById(R.id.Mthursday);
        MtxtFriday=(TextView)findViewById(R.id.Mfriday);
        MtxtSaturday=(TextView)findViewById(R.id.Msaturday);

        final LinearLayout timeLayout = (LinearLayout)findViewById(R.id.timeLayout);

        Switch aSwitch =(Switch)findViewById(R.id.switch1);
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked){

                    timeLayout.setVisibility(View.GONE);

                }else {

                    timeLayout.setVisibility(View.VISIBLE);
                }
            }
        });

        // MORNING BUTTONS
        MbuttonSun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                i++;
                Handler handler = new Handler();
                Runnable r = new Runnable() {

                    @Override
                    public void run() {
                        i = 0;
                    }
                };

                if (i == 1) {
                    //Single click
                    MbuttonSun.setBackgroundResource(R.drawable.rounded_circle1);
                    MtxtSunday.setText("Sun");
                    Log.e("sunday123",""+MtxtSunday);

                } else if (i == 2) {
                    //Double click
                    i = 0;
                    MbuttonSun.setBackgroundResource(R.drawable.rounded_circle);
                    MtxtSunday.setText(null);
                    Log.e("sunday123456",""+MtxtSunday);

                }


            }
        });

        MbuttonMon.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                j++;
                Handler handler = new Handler();
                Runnable r = new Runnable() {

                    @Override
                    public void run() {
                        j = 0;
                    }
                };

                if (j == 1) {
                    //Single click
                    MbuttonMon.setBackgroundResource(R.drawable.rounded_circle1);
                    MtxtMonday.setText("Mon");
                    Log.e("monday123",""+MtxtMonday);

                } else if (j == 2) {
                    //Double click
                    j = 0;
                    MbuttonMon.setBackgroundResource(R.drawable.rounded_circle);
                    MtxtMonday.setText(null);
                    Log.e("monday123456",""+MtxtMonday);

                }


            }
        });

        MbuttonTue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                k++;
                Handler handler = new Handler();
                Runnable r = new Runnable() {

                    @Override
                    public void run() {
                        k = 0;
                    }
                };

                if (k == 1) {
                    //Single click
                    MbuttonTue.setBackgroundResource(R.drawable.rounded_circle1);
                    MtxtTuesday.setText("Tue");
                    Log.e("Tuesday123",""+MtxtTuesday);

                } else if (k == 2) {
                    //Double click
                    k = 0;
                    MbuttonTue.setBackgroundResource(R.drawable.rounded_circle);
                    MtxtTuesday.setText(null);
                    Log.e("txtTuesday123456",""+MtxtTuesday);

                }


            }
        });

        MbuttonWed.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                l++;
                Handler handler = new Handler();
                Runnable r = new Runnable() {

                    @Override
                    public void run() {
                        l = 0;
                    }
                };

                if (l == 1) {
                    //Single click
                    MbuttonWed.setBackgroundResource(R.drawable.rounded_circle1);
                    MtxtWednsday.setText("Wed");
                    Log.e("wed123",""+MtxtTuesday);

                } else if (l == 2) {
                    //Double click
                    l = 0;
                    MbuttonWed.setBackgroundResource(R.drawable.rounded_circle);
                    MtxtWednsday.setText(null);
                    Log.e("wed123456",""+MtxtWednsday);
                    // ShowDailog();
                }


            }
        });

        MbuttonThu.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                m++;
                Handler handler = new Handler();
                Runnable r = new Runnable() {

                    @Override
                    public void run() {
                        m = 0;
                    }
                };

                if (m == 1) {
                    //Single click
                    MbuttonThu.setBackgroundResource(R.drawable.rounded_circle1);
                    MtxtThursday.setText("Thu");
                    Log.e("Tuesday123",""+MtxtTuesday);

                } else if (m == 2) {
                    //Double click
                    m = 0;
                    MbuttonThu.setBackgroundResource(R.drawable.rounded_circle);
                    MtxtThursday.setText(null);
                    Log.e("thursday123456",""+MtxtTuesday);
                }


            }
        });

        MbuttonFri.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                n++;
                Handler handler = new Handler();
                Runnable r = new Runnable() {

                    @Override
                    public void run() {
                        n = 0;
                    }
                };

                if (n == 1) {
                    //Single click
                    MbuttonFri.setBackgroundResource(R.drawable.rounded_circle1);
                    MtxtFriday.setText("Fri");
                    Log.e("friday123",""+MtxtFriday);

                } else if (n == 2) {
                    //Double click
                    n = 0;
                    MbuttonFri.setBackgroundResource(R.drawable.rounded_circle);
                    MtxtFriday.setText(null);
                    Log.e("friday123456",""+MtxtFriday);

                }


            }
        });

        MbuttonSat.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                p++;
                Handler handler = new Handler();
                Runnable r = new Runnable() {

                    @Override
                    public void run() {
                        p = 0;
                    }
                };

                if (p == 1) {
                    //Single click
                    MbuttonSat.setBackgroundResource(R.drawable.rounded_circle1);
                    MtxtSaturday.setText("Sat");
                    Log.e("sat123",""+MtxtSaturday);

                } else if (p == 2) {
                    //Double click
                    p = 0;
                    MbuttonSat.setBackgroundResource(R.drawable.rounded_circle);
                    MtxtSaturday.setText(null);
                    Log.e("sat123456",""+MtxtSaturday);

                }


            }
        });


        // etFromTime1 Format

        etFromTime1 =(EditText)findViewById(R.id.etTime1);
        etFromTime1.setInputType(InputType.TYPE_NULL);
        etFromTime1.requestFocus();
        etFromTime1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR);
                int minute = mcurrentTime.get(Calendar.MINUTE);

                TimePickerDialog mTimePicker;

                mTimePicker = new TimePickerDialog(BusinessHoursActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {

                        if(selectedHour < 12 && selectedHour >= 0)
                        {
                            etFromTime1.setText(selectedHour + ":" + selectedMinute + " " + " AM");
                        }
                        else {
                            selectedHour -= 12;
                            if(selectedHour == 0)
                            {
                                selectedHour = 12;
                            }
                            etFromTime1.setText(selectedHour + ":" + selectedMinute + " "  + " PM");
                        }

                    }
                }, hour, minute,false);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
            }
        });

        // time picker 2
        etToTime1 =(EditText)findViewById(R.id.etTime2);
        etToTime1.setInputType(InputType.TYPE_NULL);
        etToTime1.requestFocus();
        etToTime1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR);
                int minute = mcurrentTime.get(Calendar.MINUTE);

                TimePickerDialog mTimePicker;

                mTimePicker = new TimePickerDialog(BusinessHoursActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {

                        if(selectedHour < 12 && selectedHour >= 0)
                        {
                            etToTime1.setText(selectedHour + ":" + selectedMinute + " " + " AM");
                        }
                        else {
                            selectedHour -= 12;
                            if(selectedHour == 0)
                            {
                                selectedHour = 12;
                            }
                            etToTime1.setText(selectedHour + ":" + selectedMinute + " "  + " PM");
                        }

                    }
                }, hour, minute,false);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
            }
        });

        // time picker 3
        etFromTime2 =(EditText)findViewById(R.id.etTime3);
        etFromTime2.setInputType(InputType.TYPE_NULL);
        etFromTime2.requestFocus();
        etFromTime2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR);
                int minute = mcurrentTime.get(Calendar.MINUTE);

                TimePickerDialog mTimePicker;

                mTimePicker = new TimePickerDialog(BusinessHoursActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {

                        if(selectedHour < 12 && selectedHour >= 0)
                        {
                            etFromTime2.setText(selectedHour + ":" + selectedMinute + " " + " AM");
                        }
                        else {
                            selectedHour -= 12;
                            if(selectedHour == 0)
                            {
                                selectedHour = 12;
                            }
                            etFromTime2.setText(selectedHour + ":" + selectedMinute + " "  + " PM");
                        }

                    }
                }, hour, minute,false);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
            }
        });
        // time picker 4
        etToTime2 =(EditText)findViewById(R.id.etTime4);
        etToTime2.setInputType(InputType.TYPE_NULL);
        etToTime2.requestFocus();
        etToTime2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR);
                int minute = mcurrentTime.get(Calendar.MINUTE);

                TimePickerDialog mTimePicker;

                mTimePicker = new TimePickerDialog(BusinessHoursActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {

                        if(selectedHour < 12 && selectedHour >= 0)
                        {
                            etToTime2.setText(selectedHour + ":" + selectedMinute + " " + " AM");
                        }
                        else {
                            selectedHour -= 12;
                            if(selectedHour == 0)
                            {
                                selectedHour = 12;
                            }
                            etToTime2.setText(selectedHour + ":" + selectedMinute + " "  + " PM");
                        }

                    }
                }, hour, minute,false);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_socilainform, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.action_done:

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
