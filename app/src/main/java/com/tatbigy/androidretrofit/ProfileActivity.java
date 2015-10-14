package com.tatbigy.androidretrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    private TextView username;
    private TextView email;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.email = (TextView) findViewById(R.id.email);
        this.username = (TextView) findViewById(R.id.user_name);
        LogInResult info = getIntent().getExtras().getParcelable("info");
        username.setText(info != null ? info.getName() : "Empty");
        email.setText(info != null ? info.getEmail() : "Empty");
    }
}
