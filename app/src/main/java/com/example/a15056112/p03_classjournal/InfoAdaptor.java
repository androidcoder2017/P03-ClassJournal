package com.example.a15056112.p03_classjournal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 15004543 on 4/5/2017.
 */

public class InfoAdaptor extends ArrayAdapter<Information> {
    private ArrayList<Information> info;
    private Context context;
    private TextView tvWeek, tvGrade;

    public InfoAdaptor(Context context, int resource, ArrayList<Information> objects){
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        info = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        tvWeek = (TextView) rowView.findViewById(R.id.tvWeek);
        tvGrade = (TextView)rowView.findViewById(R.id.tvGrade);


        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        Information currentInformation = info.get(position);
        // Set the TextView to show the food

        tvWeek.setText(currentInformation.getWeek());
        tvGrade.setText(currentInformation.getGrade());

        // Return the nicely done up View to the ListView
        return rowView;
    }
}
