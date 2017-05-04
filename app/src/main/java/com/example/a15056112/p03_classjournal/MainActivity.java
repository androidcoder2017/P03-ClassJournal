package com.example.a15056112.p03_classjournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lvMod;
    ArrayAdapter aa;
    ArrayList<String> al;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMod = (ListView) findViewById(R.id.lvMod);

        al = new ArrayList<String>();
        al.add("C347");


        aa = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, al);
        lvMod.setAdapter(aa);

        lvMod.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MainActivity.this,
                        InfoActivity.class);
                i.putExtra("module", al.get(position));
                startActivity(i);
            }
        });


    }
}
