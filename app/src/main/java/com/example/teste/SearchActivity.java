package com.example.teste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity {

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

                Toast.makeText(SearchActivity.this,
                "KaciuMaistas" + kate.getKaciumaistas() + "\n" +
                        "pristatymas" + kate.getPristatymas() + "\n" +
                          "kaina" + kate.getKaina() + "\n" +
                               "pristatymnas" + kate.getPristatymas() + "\n" +
                                  "Veisle" + kate.getVeisle() + "\n",
                Toast.LENGTH_SHORT).show();
                Intent gotoLoginActivity = new Intent(SearchActivity.this, LoginActivity.class);
                startActivity(gotoLoginActivity);
            }
        });



    }
}
