package com.example.socialwedding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.socialwedding.database.DBAdapter;

public class RegisterPage extends AppCompatActivity {
    EditText emailEditText,passwordEditText;
    Button registerButton;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
        emailEditText=(EditText) findViewById(R.id.id_email);
        passwordEditText=(EditText) findViewById(R.id.id_password);
        registerButton = (Button) findViewById(R.id.sign_in);
        DBAdapter dbAdapter = new DBAdapter(getApplicationContext());
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(emailEditText.getText().toString().matches("") || passwordEditText.getText().toString().matches("")){Toast.makeText(RegisterPage.this,"Please enter both fields",Toast.LENGTH_SHORT).show();

                }else{
                    dbAdapter.open();
                    dbAdapter.insertUser(emailEditText.getText().toString(), passwordEditText.getText().toString());
                    Intent intent = new Intent(RegisterPage.this,MainActivity.class);
                    startActivity(intent);
                }

            }
        });
    }
}