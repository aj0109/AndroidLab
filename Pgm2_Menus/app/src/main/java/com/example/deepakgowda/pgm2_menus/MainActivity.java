package com.example.deepakgowda.pgm2_menus;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b;

    Button b2;

    Button b3;

    Button b4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //context button
        b = (Button) findViewById(R.id.button);
        registerForContextMenu(b);

        //alert dialog
        onButtonCickListener();

        //progress bar
        final ProgressDialog progressDialog= new ProgressDialog(this);
        progressDialog.setProgressStyle(progressDialog.STYLE_HORIZONTAL);//STYLE_SPINNER
        progressDialog.setMessage("Progress dailog");
        progressDialog.setIndeterminate(false); //true for spinner
        progressDialog.setCancelable(true);


        b3=(Button)findViewById(R.id.button3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.setProgress(0);
                progressDialog.show();

                final int max = 100;
                final Thread t = new Thread() {
                    @Override
                    public void run() {
                        int time = 0;
                        while (time < max) {
                            try {
                                sleep(500);
                                time += 5;
                                progressDialog.setProgress(time);

                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        if(time==100){
                            progressDialog.cancel();
                        }
                    }

                };
                t.start();
            }});


        //list view
        b4=(Button)findViewById(R.id.button4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,ListviewActivity.class);
                startActivity(i);
            }
        });

        }

    public void onButtonCickListener(){
        b2=(Button)findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Do you want to close this app ?").setCancelable(false);

                builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       finish();

                   }
               });

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();

                    }
                });

                AlertDialog alert=builder.create();
                alert.setTitle("Alert Dialog");
                alert.show();
            }
        });
    }


    //OPTIONS MENU
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.my_menu, menu);
        return true;
        //return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem){
        switch(menuItem.getItemId()){
            case R.id.op1:
                Toast.makeText(MainActivity.this,"OptionsMenu, Option 1 Selected",Toast.LENGTH_LONG).show();
                break;
            case R.id.op2:
                Toast.makeText(MainActivity.this,"OptionsMenu, Option 2 Selected",Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }


    //CONTEXT MENU
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu,view,menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.context_menu,menu);


    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        int id=menuItem.getItemId();
        if(id==R.id.cop1){
            Toast.makeText(MainActivity.this,"ContextMenu, Option 1 Selected",Toast.LENGTH_LONG).show();
        }
        if(id==R.id.cop2){
            Toast.makeText(MainActivity.this,"ContextMenu, Option 2 Selected",Toast.LENGTH_LONG).show();
        }
        return true;
    }
}



