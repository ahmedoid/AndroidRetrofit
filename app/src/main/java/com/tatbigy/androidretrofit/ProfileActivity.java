package com.tatbigy.androidretrofit;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.tatbigy.androidretrofit.model.LogInResult;

public class ProfileActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private FloatingActionButton upload;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        final LogInResult info = getIntent().getExtras().getParcelable("info");

        this.upload = (FloatingActionButton) findViewById(R.id.upload);
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (info != null) {
                    startActivity(new Intent(getApplicationContext(), UploadImageActivity.class).putExtra("id",info.getId_user()));
                }
            }
        });
        toolbar.setTitle(info != null ? info.getName() : "Empty");
        toolbar.setSubtitle(info != null ? info.getEmail() : "Empty");
    }
}
