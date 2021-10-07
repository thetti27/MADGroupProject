package com.example.madproject2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


public class interestcalculator extends AppCompatActivity {

    String year;
    int amt;
    double rate;
    double total;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interestcalculator);

        String y[]={"1","2","3","4","5","6","7","8","9","10","11","12"};
        ArrayAdapter adapter=new ArrayAdapter<> (this,R.layout.support_simple_spinner_dropdown_item,y );
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

        Spinner sp=findViewById(R.id.spinner);
        sp.setAdapter(adapter);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                year=adapterView.getItemAtPosition(i).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        Button btnCal=findViewById(R.id.btnCal);
        btnCal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                EditText edAmt=findViewById(R.id.editAmt);
                amt=Integer.parseInt(edAmt.getText().toString());

                EditText edRate=findViewById(R.id.editRate);
                rate=Double.parseDouble(edAmt.getText().toString());

                int y=Integer.parseInt(year);

                double i=(amt*rate/100)*y;
                total=amt+i;

                AlertDialog.Builder builder= new AlertDialog.Builder(interestcalculator.this);
                builder.setTitle("Interest Calculation");
                String msg="Interest = " + i + "\n" + "Total Amount =" + total;

                builder.setMessage(""+msg);

                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog dialog=builder.create();
                dialog.show();
            }

        });
    }
}