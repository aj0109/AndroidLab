package com.example.deepakgowda.pgm2_menus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListviewActivity extends AppCompatActivity {
    String[] items = { "item1","item2","item3","item4","item5","item6","item7","item8","item9","item10","item11","item12"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);


        ListView listView=(ListView)findViewById(R.id.list);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,R.layout.items_list,items);
        listView.setAdapter(arrayAdapter);

        onClickListener();

    }

    public void onClickListener(){
        ListView listView=(ListView)findViewById(R.id.list);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView txt = (TextView)view;
                String msg = "You clicked on "+txt.getText().toString();
                Toast.makeText(ListviewActivity.this,msg,Toast.LENGTH_LONG).show();
            }
        });
    }
}
