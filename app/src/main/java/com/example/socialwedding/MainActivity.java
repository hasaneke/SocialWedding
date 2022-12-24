package com.example.socialwedding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

        String loginMessage;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)  {
                progress();
                pb.setVisibility(View.VISIBLE);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        Intent intent = new Intent(MainActivity.this,
                                HomeActivity.class);
                        MainActivity.this.startActivity(intent);

                        if(emailEditText.getText().toString().equals(dummyEmail) && dummyPassword.equals(passwordEditText.getText().toString())){
                            showToastMessage(LOGINSTATUS.LOGIN_SUCCESS);


                        }else {
                            showToastMessage(LOGINSTATUS.LOGIN_FAILED);
                        }
                    }

                }, 5000);

            }

        });
    }

   public void progress()   {

        final Timer t=new Timer();
        TimerTask tt=new TimerTask() {
            @Override
            public void run() {
                counter+=2;
                pb.setProgress(counter);
                if(counter== 100){
                    t.cancel();
                }
            }
        };
        t.schedule(tt,0,100);
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