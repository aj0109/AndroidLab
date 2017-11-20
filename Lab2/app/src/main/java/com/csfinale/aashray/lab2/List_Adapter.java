package com.csfinale.aashray.lab2;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class List_Adapter extends ArrayAdapter<String>{

    private final Activity context;
    private final String[] itemname;
    private final Integer[] imgid;

    public List_Adapter(Activity context, String[] itemname, Integer[] imgid) {
        super(context, R.layout.list_view, itemname);

        this.context=context;
        this.itemname=itemname;
        this.imgid=imgid;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.list_view, null,true);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.ImgBtn);
        TextView extratxt = (TextView) rowView.findViewById(R.id.txtvw);

        imageView.setImageResource(imgid[position]);
        extratxt.setText("Description "+itemname[position]);
        return rowView;

    };
}
