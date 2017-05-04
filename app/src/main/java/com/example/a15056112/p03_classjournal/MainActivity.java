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
    ArrayList<Module> al;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMod = (ListView) findViewById(R.id.lvMod);

        al = new ArrayList<>();
        al.add(new Module("C346", "Android Programming"));
        al.add(new Module("C347", "Android Programming II"));


        aa = new MainAdaptor(this, R.layout.row_main, al);
        lvMod.setAdapter(aa);

        lvMod.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MainActivity.this,
                        InfoActivity.class);
                i.putExtra("module", al.get(position).getCode());
                startActivity(i);
            }
        });


    }
}
