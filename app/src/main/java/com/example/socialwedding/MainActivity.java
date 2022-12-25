package com.example.socialwedding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.socialwedding.activities.HomeActivity;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    EditText emailEditText;
    EditText passwordEditText;
    Button button;

    String dummyEmail = "abc@gmail.com";
    String dummyPassword = "123456";
    String loginSuccessCode = "login-success";
    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME="mypref";
    private static final String KEY_NAME ="email";
    private static final String KEY_EMAIL ="password";

    ProgressBar pb;
    int counter=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailEditText =  (EditText) findViewById(R.id.id_email);
        passwordEditText = (EditText) findViewById(R.id.id_password);
        button = (Button) findViewById(R.id.login);
        pb=(ProgressBar)findViewById(R.id.main_activity_progress_bar);

        sharedPreferences=getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        String name=sharedPreferences.getString(KEY_NAME,null);
        if(name != null){
            Intent intent = new Intent(MainActivity.this,HomeActivity.class);
            startActivity(intent);
        }

        String loginMessage;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)  {
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString(KEY_NAME,emailEditText.getText().toString());
                editor.putString(KEY_EMAIL,passwordEditText.getText().toString());
                editor.apply();
                //Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                //startActivity(intent);
                //Toast.makeText(MainActivity.this,"login succes",Toast.LENGTH_SHORT).show();

               progress();
                pb.setVisibility(View.VISIBLE);
                button.setVisibility(View.INVISIBLE);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        Intent intent = new Intent(MainActivity.this,
                                HomeActivity.class);
                        MainActivity.this.startActivity(intent);
                        Toast.makeText(MainActivity.this,"login succes",Toast.LENGTH_SHORT).show();

                       /* if(emailEditText.getText().toString().equals(dummyEmail) && dummyPassword.equals(passwordEditText.getText().toString())){
                            showToastMessage(LOGINSTATUS.LOGIN_SUCCESS);
                        }else {
                            showToastMessage(LOGINSTATUS.LOGIN_FAILED);
                        }*/
                    }

                }, 2000);


            }
        });
    }

   public void progress()   {
        final Timer t=new Timer();
        TimerTask tt=new TimerTask() {
            @Override
            public void run() {
                counter+=8;
                pb.setProgress(counter);
                if(counter > 100){
                    t.cancel();
                }
            }
        };
        t.schedule(tt,0,50);
    }
     void showToastMessage(LOGINSTATUS loginstatus) {
       switch (loginstatus){
           case LOGIN_SUCCESS:
               generateToastMessage("Login Success");
               return;
           case LOGIN_FAILED:
               generateToastMessage("Login Failed");
               return;
           default:
               generateToastMessage("Unknown error");
       }
    }
     private void generateToastMessage(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
enum LOGINSTATUS {
    LOGIN_SUCCESS, LOGIN_FAILED
}