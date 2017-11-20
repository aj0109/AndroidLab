package com.csfinale.aashray.lab2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class imagepage extends AppCompatActivity {

    Integer image[] = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5, R.drawable.image6};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagepage);

        Bundle b = this.getIntent().getExtras();
        int c = b.getInt("Name");
        ImageView img = (ImageView) findViewById(R.id.img);
        img.setImageResource(image[c]);

        Button btn = (Button)findViewById(R.id.btn1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backpage1(v);
            }
        });
    }
    public void backpage1(View v)
    {
        Intent intent = new Intent(imagepage.this,page_2_image.class);
        startActivity(intent);
    }
}
