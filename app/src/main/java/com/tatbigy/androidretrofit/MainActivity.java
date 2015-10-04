package com.tatbigy.androidretrofit;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

public class MainActivity extends AppCompatActivity {
    EditText name,
            email,
            password;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //replace actionbar with toolbar
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        name = (EditText) findViewById(R.id.input_name);
        email = (EditText) findViewById(R.id.input_email);
        password = (EditText) findViewById(R.id.input_password);
        submit = (Button) findViewById(R.id.btn_signup);

        final Retrofit registration = new Retrofit.Builder().
                baseUrl("http://10.0.3.2:8888/android_retrofit/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
           submit.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   Registration apiService = registration.create(Registration.class);
                   Call<Results> reg = apiService.postRegestraion(name.getText().toString(), email.getText().toString(), password.getText().toString());
                   reg.enqueue(new Callback<Results>() {

                       @Override
                       public void onResponse(Response<Results> response, Retrofit retrofit) {
                           Snackbar.make(name, response.body().getMessage(), Snackbar.LENGTH_LONG).show();
                       }

                       @Override
                       public void onFailure(Throwable t) {
                           // Log error here since request failed
                       }
                   });
               }
           });

    }


    public interface Registration {
        @FormUrlEncoded
        @POST("singup.php")
        Call<Results> postRegestraion(@Field("name") String name,
                                      @Field("email") String email,
                                      @Field("password") String password);
    }


}
