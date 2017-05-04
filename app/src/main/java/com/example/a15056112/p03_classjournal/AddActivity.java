package com.example.a15056112.p03_classjournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class AddActivity extends AppCompatActivity {

    TextView tvWeeks;
    RadioGroup rg;
    ImageView iv;
    Button btnSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Intent i = getIntent();

        final Information info = (Information) i.getSerializableExtra("add");

        tvWeeks = (TextView)findViewById(R.id.textViewWeeks);

        iv = (ImageView) findViewById(R.id.imageView);
        btnSubmit = (Button)findViewById(R.id.buttonSubmit);

        tvWeeks.setText(info.getWeek());

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rg = (RadioGroup)findViewById(R.id.radioGroup1);
                int selected = rg.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton) findViewById(selected);

                rb.setText(info.getGrade());

                String grade = rb.getText().toString();




            }
        });

    }
}
