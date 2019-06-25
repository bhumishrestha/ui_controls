package com.example.ui_controls;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AndroidException;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.security.cert.Extension;

public class MainActivity extends AppCompatActivity {
Spinner spin;
    String[] medicine = {"citapher", "citamol", "Metaphin", "Betadin", "Homide eye", "Metaspray", " Diapride", "Digene"};
    String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

    //autocompletetextview
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spin = findViewById(R.id.spinr);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, medicine);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, medicine);
        AutoCompleteTextView atc = findViewById(R.id.autotext);
        AutoCompleteTextView atc1 = findViewById(R.id.autotext1);

        atc.setThreshold(1);
        atc1.setThreshold(1);
        atc.setAdapter(adapter);
        atc1.setAdapter(adapter1);

        atc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "selected medicine" + parent.getSelectedItem(), Toast.LENGTH_LONG).show();
            }

        });
        //Spinner
        ArrayAdapter<String> spinr = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, days);
        spinr.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spin.setAdapter(spinr);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Select day " + days[position], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        RadioButton f, m;
        m = findViewById(R.id.male);
        f = findViewById(R.id.female);

        //ToggleButton
        final ToggleButton tb = findViewById(R.id.toggleButton);
        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    tb.setTextOn("ON");
                    Toast.makeText(getApplicationContext(), "ON", Toast.LENGTH_SHORT).show();
                } else {
                    tb.setTextOff("OFF");
                    Toast.makeText(getApplicationContext(), "OFF", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }

//Radiobutton


//    public void onRadioButtonClick(View view) {
//        boolean checked = ((RadioButton) view).isChecked();
//        String str = "";
//        switch (view.getId()) {
//            case R.id.m:
//                if (checked)
//                    str = "MALE";
//                break;
//            case R.id.f:
//                if (checked)
//                    str = "FEMALE";
//                break;
//        }
//        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
//    }

}

