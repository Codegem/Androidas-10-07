package com.example.teste;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {

    private static final String INSERT_URL = "http://androidoapsas.epizy.com/register.php/";

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

    private void databaseInsert(Regist regist) {
        class NewEntry extends AsyncTask<String, Void, String> {

            ProgressDialog loading;
            DB db = new DB();

            //            @Override
            protected void onPreExecuted() {
                super.onPreExecute();
                loading = ProgressDialog.show(RegisterActivity.this,
                        getResources().getString(R.string.new_entry_database_info),
                        null, true, true);
            }

            @Override
            protected String doInBackground(String... strings) {
                HashMap<String, String> regist = new HashMap<String, String>();
                regist.put("regusername", strings[0]);
                regist.put("regpassword", strings[1]);
                regist.put("regemail", strings[2]);
                regist.put("action", "insert");

                String registras = db.sendPostRequest(INSERT_URL, regist);

                return registras;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                Toast.makeText(RegisterActivity.this, s,
                        Toast.LENGTH_SHORT).show();
                Intent gotoLoginActivity = new Intent(RegisterActivity.this,
                        LoginActivity.class);
                startActivity(gotoLoginActivity);
            }

        }
        NewEntry newEntry = new NewEntry();
        newEntry.execute(
                regist.getRegusername(),
                regist.getRegpassword(),
                regist.getRegemaile()
        );
    }
}
