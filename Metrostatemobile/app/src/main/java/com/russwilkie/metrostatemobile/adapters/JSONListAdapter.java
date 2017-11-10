package com.russwilkie.metrostatemobile.adapters;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.russwilkie.metrostatemobile.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JSONListAdapter extends ArrayAdapter<JSONObject> {

    int vg;

    ArrayList<JSONObject> list;

    Context context;

    public JSONListAdapter(Context context, int vg, int id, ArrayList<JSONObject> list) {
        super(context, vg, id, list);

        this.context = context;
        this.vg = vg;
        this.list = list;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(vg, parent, false);
        TextView txtId = (TextView) itemView.findViewById(R.id.txtheader);
        TextView txtName = (TextView) itemView.findViewById(R.id.txtsummary);
        TextView txtSex = (TextView) itemView.findViewById(R.id.txtdate);

        try {
            txtId.setText(list.get(position).getString("header"));
            txtName.setText(list.get(position).getString("summary"));
            txtSex.setText(list.get(position).getString("date"));

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View convertView) {
                    try {
                        Uri uri = Uri.parse(list.get(position).getString("link"));
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        context.startActivity(intent);
                    }
                    catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return itemView;
    }

}
