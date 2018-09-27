package com.example.jaiswal.timestable;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView myListView;
    SeekBar seekBar;
    TextView labelTextView;
    private ArrayList<Number> numbers;
    private ArrayAdapter<Number> numbersArrayAdapter;

    public void loadTimeTable(int timeTableNumber){
        labelTextView.setText("Table of "+timeTableNumber);
        getDataList(timeTableNumber);
        numbersArrayAdapter.notifyDataSetChanged();
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            }
        });
    }

    private void getDataList(int timeTableNumber) {
        for (int x=1;x<=10;x++){
            numbers.add(timeTableNumber*x); //table of 1
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myListView = findViewById(R.id.myListView);
        seekBar = findViewById(R.id.seekBar);
        labelTextView = findViewById(R.id.label);

        initializeList();

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (b) {
                    numbers.clear();
                    loadTimeTable(i);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

    }

    private void initializeList() {
        numbers = new ArrayList<>();

        labelTextView.setText("Table of "+1);
        getDataList(1);
        numbersArrayAdapter = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,numbers);
        myListView.setAdapter(numbersArrayAdapter);
    }
}
