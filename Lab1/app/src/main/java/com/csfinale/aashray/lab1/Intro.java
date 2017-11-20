package com.csfinale.aashray.lab1;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Locale;

public class Intro extends AppCompatActivity implements OnClickListener {

    private EditText Date;
    private DatePickerDialog DatePick;
    private SimpleDateFormat dateFormat;

    private RadioGroup rg;
    private RadioButton rb;

    String ch,ch1,x;
    String fn,ln;
    int select;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        Toast.makeText(this,"On Create - Activity 2",Toast.LENGTH_SHORT).show();
        Log.v("Debug","IntroOnCreate Invoked");

        //Intent intent = getIntent();
        Bundle b = getIntent().getExtras();
        fn = b.getString("EXTRA_FIRST");
        ln = b.getString("EXTRA_LAST");
        TextView tv =  findViewById(R.id.Page2Welcome);
        tv.setText("Welcome " + fn + " " + ln);

        Button button = findViewById(R.id.Submit1);
        button.setOnClickListener(new OnClickListener(){
            public void onClick (View v){
                end_page(v);
            }
        });
        Button btn = findViewById(R.id.Return);
        btn.setOnClickListener(new OnClickListener(){
            public void onClick (View v){
                previous_page(v);
            }
        });


        date();

    }
    @Override
    protected void onStart()
    {
        super.onStart();
        Toast.makeText(this,"On Start - Activity 2",Toast.LENGTH_SHORT).show();
        Log.v("Debug","IntroOnStart Invoked");
    }
    @Override
    protected void onResume()
    {
        super.onResume();
        Toast.makeText(this,"On Resume - Activity 2",Toast.LENGTH_SHORT).show();
        Log.v("Debug","IntroOnResume Invoked");
    }
    @Override
    protected void onPause()
    {
        super.onPause();
        Toast.makeText(this,"On Pause - Activity 2",Toast.LENGTH_SHORT).show();
        Log.v("Debug","IntroOnPause Invoked");
    }
    @Override
    protected void onRestart()
    {
        super.onRestart();
        Toast.makeText(this,"On Restart - Activity 2",Toast.LENGTH_SHORT).show();
        Log.v("Debug","IntroOnRestart Invoked");
    }
    @Override
    protected void onStop()
    {
        super.onStop();
        Toast.makeText(this,"On Stop - Activity 2",Toast.LENGTH_SHORT).show();
        Log.v("Debug","IntroOnStop Invoked");
    }
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Toast.makeText(this,"On Destroy - Activity 2",Toast.LENGTH_SHORT).show();
        Log.v("Debug","IntroOnDestroy Invoked");
    }
    public void previous_page(View v)
    {
        Intent in = new Intent(this,MainActivity.class);
        startActivity(in);
    }
    public void end_page(View v)
    {
        radio();
        radio1();
        x = Date.getText().toString();
        //Toast.makeText(getApplicationContext(),"Submitting",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Intro.this,End_Page.class);
        Bundle extras = new Bundle();
        extras.putString("EXTRA_FIRST",fn);
        extras.putString("EXTRA_LAST",ln);
        extras.putString("EXTRA_GENDER",ch);
        extras.putString("EXTRA_STATUS",ch1);
        extras.putString("EXTRA_DATE",x);
        intent.putExtras(extras);
        startActivity(intent);
    }
    public void radio()
    {
        rg = findViewById(R.id.radio);
        select = rg.getCheckedRadioButtonId();
        rb = findViewById(select);
        ch = (String)rb.getText();
    }
    public void radio1()
    {
        rg = findViewById(R.id.radio1);
        select = rg.getCheckedRadioButtonId();
        rb = findViewById(select);
        ch1 = (String)rb.getText();
    }
    @SuppressLint("NewApi")
    public void date()
    {
        dateFormat = new SimpleDateFormat("dd / MM / yyyy", Locale.US);

        Date = findViewById(R.id.BdayEdit);
        Date.setInputType(InputType.TYPE_NULL);
        Date.requestFocus();

        Date.setOnClickListener(this);

        Calendar newCalendar = Calendar.getInstance();
        DatePick = new DatePickerDialog(this, new OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                Date.setText(dateFormat.format(newDate.getTime()));
            }
        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

    }
    @Override
    public void onClick(View v) {
        DatePick.show();
    }
}