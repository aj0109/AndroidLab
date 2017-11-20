package com.csfinale.aashray.lab2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class page_2_background extends AppCompatActivity {

    ListView list;
    String colors[] = {"Red","Cyan","Green","White","Yellow","Gray"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_2_background);

        list = (ListView)findViewById(R.id.lv);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.lists,R.id.txt,colors);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                View v = (View) findViewById(R.id.view);
                if(position == 0)
                {
                    v.setBackgroundColor(Color.RED);
                }
                else if(position == 1)
                {
                    v.setBackgroundColor(Color.CYAN);
                }
                else if(position == 2)
                {
                    v.setBackgroundColor(Color.GREEN);
                }
                else if(position == 3)
                {
                    v.setBackgroundColor(Color.WHITE);
                }
                else if(position == 4)
                {
                    v.setBackgroundColor(Color.YELLOW);
                }
                else if(position == 5)
                {
                    v.setBackgroundColor(Color.GRAY);
                }
            }
        });
    }
    public void previous(View v){

        Intent intent = new Intent(page_2_background.this,MainActivity.class);
        startActivity(intent);
    }
}
