package com.tatbigy.androidretrofit;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.tatbigy.androidretrofit.model.LogInResult;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

public class LogInActivity extends AppCompatActivity {

    private android.support.v7.widget.Toolbar toolbar;
    private EditText inputemail;
    private android.support.design.widget.TextInputLayout inputlayoutemail;
    private EditText inputpassword;
    private android.support.design.widget.TextInputLayout inputlayoutpassword;
    private Button btnsignup;
    private TextView singup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        //set toolbar as actionbar
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.singup = (TextView) findViewById(R.id.sing_up);
        this.btnsignup = (Button) findViewById(R.id.btn_signup);
        this.inputlayoutpassword = (TextInputLayout) findViewById(R.id.input_layout_password);
        this.inputpassword = (EditText) findViewById(R.id.input_password);
        this.inputlayoutemail = (TextInputLayout) findViewById(R.id.input_layout_email);
        this.inputemail = (EditText) findViewById(R.id.input_email);

        final Retrofit Retrofitlogin = new Retrofit.Builder().
                baseUrl(getString(R.string.url))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LogIn apiService = Retrofitlogin.create(LogIn.class);
                Call<LogInResult> reg = apiService.login(inputemail.getText().toString(), inputpassword.getText().toString());
                reg.enqueue(new Callback<LogInResult>() {

                    @Override
                    public void onResponse(Response<LogInResult> response, Retrofit retrofit) {
                        if (response.body().getCode() == 0) {
                            Snackbar.make(inputpassword, response.body().getName(), Snackbar.LENGTH_LONG).show();
                            startActivity(new Intent(getApplicationContext(), ProfileActivity.class).putExtra("info", response.body()));

                        } else {
                            Snackbar.make(inputpassword, response.body().getMessage(), Snackbar.LENGTH_INDEFINITE).setAction("اخفاء", null).show();
                        }
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        // Log error here since request failed
                    }
                });
            }
        });
        singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }

    public interface LogIn {
        @FormUrlEncoded
        @POST("login.php")
        Call<LogInResult> login(@Field("name") String email,
                                @Field("password") String password);
    }


}
