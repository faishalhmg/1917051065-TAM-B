package com.fhmg.myintentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MoveWithDataActivity extends AppCompatActivity {
    public static String EXRA_AGE = "extra_age";
    public static String EXTRA_NAME = "extra_name";
    private TextView tvDataRecived;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_data);
        tvDataRecived = (TextView) findViewById(R.id.tv_data_recived);
        String name = getIntent().getStringExtra(EXTRA_NAME);
        int age = getIntent().getIntExtra(EXRA_AGE, 0);
        String text = "Name : "+name+", Your Age : "+age;
        tvDataRecived.setText(text);
    }
}