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
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        tvWeeks = (TextView)findViewById(R.id.textViewWeeks);
        btnSubmit = (Button)findViewById(R.id.buttonSubmit);

        Intent i = getIntent();
        int info = (int) i.getSerializableExtra("add");

        tvWeeks.setText("Week " + info);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rg = (RadioGroup)findViewById(R.id.radioGroup1);
                int selected = rg.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton) findViewById(selected);

                String grade = rb.getText().toString();

                Intent i = new Intent();
                i.putExtra("grade", grade);
                i.putExtra("week", tvWeeks.getText().toString());

                setResult(RESULT_OK, i);
                finish();

            }
        });

    }
}
