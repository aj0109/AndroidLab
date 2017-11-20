package com.csfinale.aashray.lab2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class draw extends AppCompatActivity {

    String shape, color;
    Canvas canvas;
    Bitmap bitmap;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);
        ImageView imv = (ImageView)findViewById(R.id.img12);
        Bundle b = getIntent().getExtras();
        shape = b.getString("Shape");
        color = b.getString("Color");
        Button btn = (Button)findViewById(R.id.btn1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backpage(v);
            }
        });


        if (shape.equals("Rectangle")) {

            bitmap = Bitmap.createBitmap(400,250,Bitmap.Config.RGB_565);
            canvas = new Canvas(bitmap);
            canvas.drawColor(Color.parseColor(color));
            imv.setImageBitmap(bitmap);
        } else if (shape.equals("Square")) {
            bitmap = Bitmap.createBitmap(250,250,Bitmap.Config.RGB_565);
            canvas = new Canvas(bitmap);
            canvas.drawColor(Color.parseColor(color));
            imv.setImageBitmap(bitmap);
        }
    }
    public void backpage(View v)
    {
        Intent intent = new Intent(draw.this,page_2_shape.class);
        startActivity(intent);
    }
}

