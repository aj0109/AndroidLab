package com.csfinale.aashray.lab1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class End_Page extends AppCompatActivity {

    String first,last,gender,status,date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end__page);
        Toast.makeText(this,"On Create - Activity 3",Toast.LENGTH_SHORT).show();
        Log.v("Debug","EndPageOnCreate Invoked");

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        first = extras.getString("EXTRA_FIRST");
        last = extras.getString("EXTRA_LAST");
        gender = extras.getString("EXTRA_GENDER");
        status = extras.getString("EXTRA_STATUS");
        date = extras.getString("EXTRA_DATE");

        TextView tv1 = findViewById(R.id.Thank);
        tv1.setText("Information Entered for the Survey\n\n\nFirst Name\t\t\t: " + first +"\nLast Name\t\t\t: "+last+"\nGender\t\t\t\t\t\t: " + gender + "\nBirthDate\t\t\t\t\t: "+date+"\nMarital Status\t: " + status +"\n\n\n Thank you for Participating in the Survey");

        Button button = findViewById(R.id.end);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                end(v);
            }
        });
    }
    @Override
    protected void onStart()
    {
        super.onStart();
        Toast.makeText(this,"On Start - Activity 3",Toast.LENGTH_SHORT).show();
        Log.v("Debug","EndPageOnStart Invoked");
    }
    @Override
    protected void onResume()
    {
        super.onResume();
        Toast.makeText(this,"On Resume - Activity 3",Toast.LENGTH_SHORT).show();
        Log.v("Debug","EndPageOnResume Invoked");
    }
    @Override
    protected void onPause()
    {
        super.onPause();
        Toast.makeText(this,"On Pause - Activity 3",Toast.LENGTH_SHORT).show();
        Log.v("Debug","EndPageOnPause Invoked");
    }
    @Override
    protected void onRestart()
    {
        super.onRestart();
        Toast.makeText(this,"On Restart - Activity 3",Toast.LENGTH_SHORT).show();
        Log.v("Debug","EndPageOnRestart Invoked");
    }
    @Override
    protected void onStop()
    {
        super.onStop();
        Toast.makeText(this,"On Stop - Activity 3",Toast.LENGTH_SHORT).show();
        Log.v("Debug","EndPageOnStop Invoked");
    }
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Toast.makeText(this,"On Destroy - Activity 3",Toast.LENGTH_SHORT).show();
        Log.v("Debug","EndPageOnDestroy Invoked");
    }
    public void end(View v)
    {
        this.finish();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}