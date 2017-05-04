package com.example.a15056112.p03_classjournal;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class InfoActivity extends AppCompatActivity {
    int requestCodes = 1;
    Button btnRP;
    Button btnAdd;
    Button btnEmail;

    ListView lv;
    ArrayAdapter aa;
    ArrayList<Information> info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        btnRP = (Button) findViewById(R.id.btnInfo);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnEmail = (Button) findViewById(R.id.btnEmail);

        lv = (ListView) this.findViewById(R.id.lvDG);
        info = new ArrayList<>();
        aa = new InfoAdaptor(this, R.layout.row, info);
        lv.setAdapter(aa);

        btnRP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // Intent to display data
                Intent rpIntent = new Intent(Intent.ACTION_VIEW);
                // Set the URL to be used.
                rpIntent.setData(Uri.parse("http://www.rp.edu.sg/Diploma_in_Mobile_Software_Development_(R47).aspx"));
                startActivity(rpIntent);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addIntent = new Intent(getApplicationContext(),AddActivity.class);
                addIntent.putExtra("add", info.size() + 1);
                startActivityForResult(addIntent, requestCodes);
            }
        });



    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            if (data != null) {
                // Get data passed back from 2nd activity
                String grade = data.getStringExtra("grade");
                String week = data.getStringExtra("week");

                if(requestCode == requestCodes){
                    info.add(new Information(week, grade));
                    aa.notifyDataSetChanged();
                }



            }
        }
    }

}
