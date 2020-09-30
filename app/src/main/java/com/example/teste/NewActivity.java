package com.example.teste;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;

import java.util.HashMap;

public class NewActivity extends AppCompatActivity {

    private static final String INSERT_URL = "http://185.27.134.10/db_structure.php?db=b10_26852782_octopopscat";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_entry);
        public void onClick(View v){

            Kate kate = new Kate(kaciumaistas, selectedDeliveryTypeBtnName, kaina, payment, rusis );

            Toast.makeText(NewActivity.this,
                    databaseInsert(kate);
        }
    }

    private void databaseInsert(Kate kate) {
        class NewEntry extends AsyncTask<String, Void, String> {

            ProgressDialog loading;
            DB db = new DB();

            @Override
            protected void onPreExecuted() {
                super.onPreExecute();
                loading = ProgressDialog.show(NewActivity.this,
                        getResources().getString(R.string.new_entry_database_info),
                        null, true, true);
            }

            @Override
            protected String doInBackground(String... strings) {
                HashMap<String, String> kate = new HashMap<String, String>();
                kate.put("kaciumaistas", strings[0]);
                kate.put("pristatymas", strings[1]);
                kate.put("kaina", strings[2]);
                kate.put("atsiskaitymas", strings[3]);
                kate.put("veisle", strings[4]);
                kate.put("action", "insert");

                String result = db.sendPostRequest(INSERT_URL, kate);

                return result;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                Toast.makeText(NewActivity.this, s,
                        Toast.LENGTH_SHORT).show();
                Intent gotoSearchActivity = new Intent(NewActivity.this,
                        SearchActivity.class);
                startActivity(gotoSearchActivity);
            }

            public void execute(String kaciumaistas, String pristatymas, double kaina, String atsiskaitymas, String veisle) {
            }
        }
        NewEntry newEntry = new NewEntry();
        newEntry.execute(
                kate.getKaciumaistas(),
                kate.getPristatymas(),
                kate.getKaina(),
                kate.getAtsiskaitymas(),
                kate.getVeisle()
       );
    }
}