package com.russwilkie.metrostatemobile.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.russwilkie.metrostatemobile.*;
import com.russwilkie.metrostatemobile.activities.MainActivity;
import com.russwilkie.metrostatemobile.activities.WebViewerActivity;

public class ImageAdapter extends ArrayAdapter
{
    Activity context;
    String[] items;
    String[] arrows;
    boolean[] isHeader;
    int layoutId;
    int textId;
    int imageId;

    public ImageAdapter(Activity context, int layoutId, int textId, int imageId, String[] items, String[] arrows, boolean[] isHeader)
    {
        super(context, layoutId, items);

        this.context = context;
        this.items = items;
        this.arrows = arrows;
        this.layoutId = layoutId;
        this.textId = textId;
        this.imageId = imageId;
        this.isHeader = isHeader;
    }

    public View getView(int pos, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater=context.getLayoutInflater();
        ViewHolder holder = null;

        if(convertView == null) {
            holder = new ViewHolder();
            if (isHeader[pos]) {
                convertView = inflater.inflate(R.layout.list_header, null);
            } else {
                if (arrows[pos] != null) {
                    convertView = inflater.inflate(layoutId, null);
                    ImageView icon = (ImageView) convertView.findViewById(imageId);

                    icon.setImageResource(getImageId(context, arrows[pos]));
                } else {
                    convertView = inflater.inflate(R.layout.list_item, null);
                }
            }
            TextView label = (TextView) convertView.findViewById(textId);
            label.setText(items[pos]);

            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
        }

        return convertView;
    }


    public static int getImageId(Context con, String imageName) {
        return con.getResources().getIdentifier("drawable/" + imageName, null, con.getPackageName());
    }

    public static class ViewHolder {
        public TextView textView;
    }
}
