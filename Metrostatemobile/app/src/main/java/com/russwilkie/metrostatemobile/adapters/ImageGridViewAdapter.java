package com.russwilkie.metrostatemobile.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.russwilkie.metrostatemobile.ImageIcons;
import com.russwilkie.metrostatemobile.R;
import com.russwilkie.metrostatemobile.activities.MainActivity;

import java.util.ArrayList;

public class ImageGridViewAdapter extends BaseAdapter {
    Context context;
    ArrayList<ImageIcons> imageIcons;

    public ImageGridViewAdapter(Context context , ArrayList<ImageIcons> icons) {
        this.context = context;
        this.imageIcons = icons;
    }

    @Override
    public int getCount() {
        return imageIcons.size();
    }

    @Override
    public Object getItem(int i) {
        return imageIcons.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public View getView(int pos, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null){
            convertView = inflater.inflate(R.layout.grid_view_image_module, parent, false);
        }

        ImageView imageView = (ImageView) convertView.findViewById(R.id.moduleImageView);
        TextView textView = (TextView) convertView.findViewById(R.id.moduleTextView);

        imageView.setImageResource(imageIcons.get(pos).getImage());
        textView.setText(imageIcons.get(pos).getName());


//        imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
//        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//        imageView.setPadding(8, 8, 8, 8);

        return convertView;
    }
}
