package com.example.projecttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText cardName,cardNumber,month,year,ccv;
    private RadioButton radioButton1,radioButton2;
    private RadioGroup radioGroup;
    private Button saveButton;
    private DbHandler dbHandler;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHandler=new DbHandler(getApplicationContext());



        cardName=findViewById(R.id.edit_card_name);
        cardNumber=findViewById(R.id.edit_card_number);
        month=findViewById(R.id.edit_month);
        year=findViewById(R.id.edit_year);
        ccv=findViewById(R.id.edit_ccv);
        radioButton1=findViewById(R.id.radio_button_2check);
        radioButton2=findViewById(R.id.radio_button_payhere);
        saveButton=findViewById(R.id.save_button);



        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHandler.insertData(new Data("visa",1111111111111111L,12,2022,471));
                if(error()){
                    Toast.makeText(MainActivity.this, "Data save successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), Activity2.class);
                    startActivity(intent);

                }
            }
        });

    }





    private boolean error(){
        if(cardName.getText().toString().length() ==0){

            Toast.makeText(MainActivity.this, "Enter Card Name", Toast.LENGTH_LONG).show();
            return false;
        }
        if(cardNumber.getText().toString().length()==0){
            Toast.makeText(MainActivity.this, "Please fill card number", Toast.LENGTH_LONG).show();
            return false;
        }
        if(cardNumber.getText().toString().length() !=16){
            Toast.makeText(MainActivity.this, "Please enter valid card number", Toast.LENGTH_LONG).show();
            return false;
        }
        if(month.getText().toString().length()==0){
            Toast.makeText(MainActivity.this, "Please fill date", Toast.LENGTH_LONG).show();
            return false;
        }
        if(month.getText().toString().length() !=2){
            Toast.makeText(MainActivity.this, "Please enter valid date", Toast.LENGTH_LONG).show();
            return false;
        }
        if(year.getText().toString().length()==0) {
            Toast.makeText(MainActivity.this, "Please fill year", Toast.LENGTH_LONG).show();
            return false;
        }
        if(year.getText().toString().length() !=4){
            Toast.makeText(MainActivity.this, "Please enter valid year", Toast.LENGTH_LONG).show();
            return false;
        }
        if(ccv.getText().toString().length()==0) {
            Toast.makeText(MainActivity.this, "Please fill ccv", Toast.LENGTH_LONG).show();
            return false;
        }
        if(ccv.getText().toString().length() !=3) {
            Toast.makeText(MainActivity.this, "Please enter valid ccv", Toast.LENGTH_LONG).show();
            return false;
        }
        if(!radioButton1.isChecked() && !radioButton2.isChecked()){
            Toast.makeText(MainActivity.this, "Please select payment method", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }


}