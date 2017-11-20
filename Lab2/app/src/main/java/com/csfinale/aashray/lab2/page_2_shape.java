package com.csfinale.aashray.lab2;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class page_2_shape extends AppCompatActivity {

    EditText et,et1;
    private ProgressDialog progress;

    int x,y,j=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_2_shape);

        et = findViewById(R.id.tw2);
        et1 = findViewById(R.id.tw3);

        registerForContextMenu(et);
        registerForContextMenu(et1);

        Button btn1 = findViewById(R.id.button3);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back(v);
            }
        });
        Button btn = findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert(v);
            }
        });
    }
    public void back(View v)
    {
        Intent intent = new Intent(page_2_shape.this,MainActivity.class);
        startActivity(intent);
    }
    public void alert(View v)
    {
        int i =0;
        AlertDialog.Builder builder1 = new AlertDialog.Builder(page_2_shape.this);
        builder1.setMessage("Selected Options Correct?");
        builder1.setCancelable(true);
        

        builder1.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {


                        progress=new ProgressDialog(page_2_shape.this);
                        progress.setMessage("Creating....");
                        progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                        progress.setIndeterminate(true);
                        //progress.setProgress(0);
                        progress.show();
                        progress.setMax(100);
                        progress.setProgress(50);




                        new Timer().schedule(new TimerTask() {
                            @Override
                            public void run() {
                                progress.dismiss();
                                Intent intent = new Intent(page_2_shape.this,draw.class);
                                Bundle b = new Bundle();
                                b.putString("Shape",et.getText().toString());
                                b.putString("Color",et1.getText().toString());
                                intent.putExtras(b);
                                startActivity(intent);
                            }
                        }, 2000);
                    }
                });

        builder1.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu,v,menuInfo);
        if(v.getId() == R.id.tw2)
        {
            menu.setHeaderTitle("Select Shape");
            menu.add(0,v.getId(),0,"Square");
            menu.add(0,v.getId(),0,"Rectangle");
        }
        else if(v.getId() == R.id.tw3)
        {
            menu.setHeaderTitle("Select Color");
            menu.add(0,v.getId(),0,"Black");
            menu.add(0,v.getId(),0,"Blue");
            menu.add(0,v.getId(),0,"Green");
            menu.add(0,v.getId(),0,"Yellow");
            menu.add(0,v.getId(),0,"Red");
        }
    }
    @Override
    public boolean onContextItemSelected(MenuItem item)
    {
        if(item.getTitle()=="Square")
        {
            et.setText("Square", TextView.BufferType.EDITABLE);
        }
        else if(item.getTitle() == "Rectangle")
        {
            et.setText("Rectangle", TextView.BufferType.EDITABLE);
        }

        else if(item.getTitle() == "Black")
        {
            et1.setText("Black");
        }
        else if(item.getTitle() == "Blue")
        {
            et1.setText("Blue");
        }
        else if(item.getTitle() == "Green")
        {
            et1.setText("Green");
        }
        else if(item.getTitle() == "Yellow")
        {
            et1.setText("Yellow");
        }
        else if(item.getTitle() == "Red")
        {
            et1.setText("Red");
        }
        else
        {
            return false;
        }
        return true;
    }

}