package com.russwilkie.metrostatemobile.adapters;


import android.content.Context;
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

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(vg, parent, false);
        TextView txtId = (TextView) itemView.findViewById(R.id.txtheader);
        TextView txtName = (TextView) itemView.findViewById(R.id.txtsummary);
        TextView txtSex = (TextView) itemView.findViewById(R.id.txtdate);

        try {
            txtId.setText(list.get(position).getString("header"));
            txtName.setText(list.get(position).getString("summary"));
            txtSex.setText(list.get(position).getString("date"));


        } catch (JSONException e) {
            e.printStackTrace();
        }

        return itemView;
    }

}
