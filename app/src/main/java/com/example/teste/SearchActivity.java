package com.example.teste;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.HashMap;

public class SearchActivity extends AppCompatActivity {

    private static final String INSERT_URL = "http://androidoapsas.epizy.com/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Button sukurti = findViewById(R.id.createbtn);
        final CheckBox pirm = findViewById(R.id.pirmas);
        final CheckBox antr = findViewById(R.id.antras);
        final CheckBox trec = findViewById(R.id.trecias);
        final CheckBox ketvirt = findViewById(R.id.ketvirtas);
//        final RadioButton deliveryes = findViewById(R.id.deliveryyes);
//        final RadioButton deliverno = findViewById(R.id.deliveryno);
        final RadioGroup delivery = findViewById(R.id.new_entry_delivery_group);
        final EditText price = findViewById(R.id.kaina);
        final Spinner spinneris1 = findViewById(R.id.spinner1);
        final Spinner spinneris2 = findViewById(R.id.spinner2);

        sukurti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kaciumaistas = "";
                if (pirm.isChecked()) {
                    kaciumaistas = kaciumaistas + pirm.getText().toString() + " ";
                }
                if (antr.isChecked()) {
                    kaciumaistas = kaciumaistas + antr.getText().toString() + " ";
                }
                if (trec.isChecked()) {
                    kaciumaistas = kaciumaistas + trec.getText().toString() + " ";
                }
                if (ketvirt.isChecked()) {
                    kaciumaistas = kaciumaistas + ketvirt.getText().toString() + " ";
                }
                int selectedDeliveryType = delivery.getCheckedRadioButtonId();
                RadioButton deliveryType = findViewById(selectedDeliveryType);
                String selectedDeliveryTypeBtnName = deliveryType.getText().toString();
                double kaina = Double.parseDouble(price.getText().toString());
                String payment = String.valueOf(spinneris1.getSelectedItemId());
                String rusis = String.valueOf(spinneris2.getSelectedItemId());

                //    public Kate(String kaciumaistas, String pristatymas, double kaina, String atsiskaitymas, String veisle){
                Kate kate = new Kate(kaciumaistas, selectedDeliveryTypeBtnName, kaina, payment, rusis );
                databaseInsert(kate);
                Toast.makeText(SearchActivity.this,
                "kaciumaistas" + kate.getKaciumaistas() + "\n" +
                        "pristatymas" + kate.getPristatymas() + "\n" +
                          "KAINA" + kate.getKaina() + "\n" +
                               "pristatymnas" + kate.getPristatymas() + "\n" +
                                  "Veisle" + kate.getVeisle() + "\n",
                Toast.LENGTH_SHORT).show();
                Intent gotoLoginActivity = new Intent(SearchActivity.this, LoginActivity.class);
                startActivity(gotoLoginActivity);
            }
        });



    }

    private void databaseInsert(Kate kate) {
        class NewEntry extends AsyncTask<String, Void, String> {

            ProgressDialog loading;
            DB db = new DB();

//            @Override
            protected void onPreExecuted() {
                super.onPreExecute();
                loading = ProgressDialog.show(SearchActivity.this,
                        getResources().getString(R.string.new_entry_database_info),
                        null, true, true);
            }

            @Override
            protected String doInBackground(String... strings) {
                HashMap<String, String> kate = new HashMap<String, String>();
                kate.put("kaciumaistas", strings[0]);
                kate.put("pristatymas", strings[1]);
                kate.put("KAINA", strings[2]);
                kate.put("atsiskaitymas", strings[3]);
                kate.put("veisle", strings[4]);
                kate.put("action", "insert");

                String result = db.sendPostRequest(INSERT_URL, kate);

                return result;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                Toast.makeText(SearchActivity.this, s,
                        Toast.LENGTH_SHORT).show();
                Intent gotoSearchActivity = new Intent(SearchActivity.this,
                        SearchActivity.class);
                startActivity(gotoSearchActivity);
            }

        }
        NewEntry newEntry = new NewEntry();
        newEntry.execute(
                kate.getKaciumaistas(),
                kate.getPristatymas(),
                Double.toString(kate.getKaina()) ,
                kate.getAtsiskaitymas(),
                kate.getVeisle()
        );
    }

}
