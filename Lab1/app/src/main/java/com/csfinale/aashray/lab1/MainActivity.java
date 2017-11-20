package com.csfinale.aashray.lab1;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this,"On Create - Activity 1",Toast.LENGTH_SHORT).show();
        Log.v("Debug","MainActivityOnCreate Invoked");
        Button button = findViewById(R.id.SubmitButton);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                new_page(v);
            }
        });
    }
    @Override
    protected void onStart()
    {
        super.onStart();
        Toast.makeText(this,"On Start - Activity 1",Toast.LENGTH_SHORT).show();
        Log.v("Debug","MainActivityOnStart Invoked");
    }
    @Override
    protected void onResume()
    {
        super.onResume();
        Toast.makeText(this,"On Resume - Activity 1",Toast.LENGTH_SHORT).show();
        Log.v("Debug","MainActivityOnResume Invoked");
    }
    @Override
    protected void onPause()
    {
        super.onPause();
        Toast.makeText(this,"On Pause - Activity 1",Toast.LENGTH_SHORT).show();
        Log.v("Debug","MainActivityOnPause Invoked");
    }
    @Override
    protected void onRestart()
    {
        super.onRestart();
        Toast.makeText(this,"On Restart - Activity 1",Toast.LENGTH_SHORT).show();
        Log.v("Debug","MainActivityOnRestart Invoked");
    }
    @Override
    protected void onStop()
    {
        super.onStop();
        Toast.makeText(this,"On Stop - Activity 1",Toast.LENGTH_SHORT).show();
        Log.v("Debug","MainActivityOnStop Invoked");
    }
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Toast.makeText(this,"On Destroy - Activity 1",Toast.LENGTH_SHORT).show();
        Log.v("Debug","MainActivityOnDestroy Invoked");
    }
    public void new_page(View v)
    {
        Intent intent = new Intent(this,Intro.class);
        EditText et = findViewById(R.id.Edit1);
        EditText et1 = findViewById(R.id.Edit2);
        String fn = et.getText().toString();
        String ln = et1.getText().toString();
        Bundle b = new Bundle();
        b.putString("EXTRA_FIRST",fn);
        b.putString("EXTRA_LAST",ln);
        intent.putExtras(b);
        startActivity(intent);
    }
}