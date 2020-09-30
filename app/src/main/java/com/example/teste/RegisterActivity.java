package com.example.teste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText regusername = findViewById(R.id.register_login);
        final EditText regpassword = findViewById(R.id.register_password);
        final EditText regemail = findViewById(R.id.register_email);
        Button exitBtn = findViewById(R.id.exit_btn);
    Button regBtn = findViewById(R.id.registruotis);

        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoLoginActivity = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(gotoLoginActivity);
            }
        });

        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username2 = regusername.getText().toString();
                String password2 = regpassword.getText().toString();
                String email2 = regemail.getText().toString();
                Toast.makeText(RegisterActivity.this, "Username: " + username2 + "\n" + "Password: " + password2 + "\n" + "Email: " + email2, Toast.LENGTH_SHORT).show();
                regusername.setError(null);
                regpassword.setError(null);
                regemail.setError(null);
                if(Validation.isCredentialsValid(username2)&& Validation.isPasswordValid(password2) && Validation.isEmailValid(email2)){
                    Intent gotoLoginActivity = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(gotoLoginActivity);
                }
                else{
                    regusername.setError( getResources().getString(R.string.register_invalid));
                    regpassword.setError( getResources().getString(R.string.register_invalid));
                    regemail.setError( getResources().getString(R.string.register_invalid));
                    regusername.requestFocus();
                    regpassword.requestFocus();
                    regemail.requestFocus();

                }

            }
        });

    }
}
