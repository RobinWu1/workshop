package com.example.workshop;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;


import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

import com.example.workshop.R;

import com.example.workshop.ui.utils.DateDialog;


public class MainActivity extends AppCompatActivity {

    EditText chooseDate;
    Calendar calendar;
    DatePickerDialog datePickerDialog;
    int currentDayOfMonth;
    int currentMonth;
    int currentYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_fun)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        setContentView(R.layout.fragment_fun);
        chooseDate = (EditText) findViewById(R.id.date_of_birth_edit_text);


        chooseDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                calendar = Calendar.getInstance();
                currentYear = calendar.get(Calendar.YEAR);
                currentMonth = calendar.get(Calendar.MONTH);
                currentDayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);


                datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {

                        chooseDate.setText(String.format("%02d/%02d/%04d", month, dayOfMonth, year));
                    }
                }, 1994, 9, 26);
                datePickerDialog.show();
            }
        });



    }



}









