package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String[] fakultetai = {"FMF - Fundamentinių mokslų fakultetas", "KIF - Kūrybinių industrijų fakultetas"};
    private AutoCompleteTextView autoTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        autoTextView = (AutoCompleteTextView) findViewById(R.id.autoC);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.select_dialog_item, fakultetai);
        autoTextView.setThreshold(1);
        autoTextView.setAdapter(adapter);
    }

    public void saugoti(View w) {
        TextView pavadinimas = (TextView) findViewById(R.id.editName);
        AutoCompleteTextView fakultetas = (AutoCompleteTextView) findViewById(R.id.autoC);
        RatingBar sudetingumas = (RatingBar) findViewById(R.id.ratingBar);
        Spinner dienos = (Spinner) findViewById(R.id.days);
        TimePicker laikas = (TimePicker) findViewById(R.id.time);
        Switch registruotis = (Switch) findViewById(R.id.reg);
        Toast.makeText(this,
                String.format("%s%s%s%s%s%s%s", pavadinimas.getText().toString(), fakultetas.getText().toString(), sudetingumas.getRating(), dienos.getSelectedItem().toString(), laikas.getCurrentHour().toString(), laikas.getCurrentMinute().toString(), registruotis.isChecked()),
                Toast.LENGTH_SHORT).show();
    }
}