package com.example.teste;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import java.util.HashMap;

public class NewActivity extends AppCompatActivity {

    private static final String INSERT_URL = "http://androidoapsas.epizy.com/mobile/dbconnect.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_entry);
    }

}