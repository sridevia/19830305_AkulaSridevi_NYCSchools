package com.example.sridevi.a19830305_srideviakula_nycschools.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.sridevi.a19830305_srideviakula_nycschools.R;
import com.example.sridevi.a19830305_srideviakula_nycschools.constants.Constants;


public class SchoolDetailsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.school_details_layout);
        initializeViews();
    }

    /**
     * Initializing Views
     */
    private void initializeViews() {

        Intent intent = getIntent();

        TextView textViewSchoolName = findViewById(R.id.school_name);
        textViewSchoolName.setText(getResources().getString(R.string.school_name) + intent.getStringExtra(Constants.SCHOOL_NAME));

        TextView textViewCity = findViewById(R.id.city);
        textViewCity.setText(getResources().getString(R.string.city) + intent.getStringExtra(Constants.CITY));

        TextView textViewPhone = findViewById(R.id.phone);
        textViewPhone.setText(getResources().getString(R.string.phone) + intent.getStringExtra(Constants.PHONE));

        TextView textViewEmail = findViewById(R.id.email);
        textViewEmail.setText(getResources().getString(R.string.email) + intent.getStringExtra(Constants.SCHOOL_EMAIL));

    }

}
