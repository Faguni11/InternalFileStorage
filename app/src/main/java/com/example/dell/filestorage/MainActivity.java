package com.example.dell.filestorage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    EditText editText,editText2,editText3,editText5;
    Button save,fetch;
String FILENAME="myFileHello.txt";
    int p1;
    String text="";
    String[] stateArr={
            "Delhi",
            "MP",
            "UP"
    };
    Spinner stateSpinner;
    ArrayAdapter<String> stateAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=(EditText)findViewById(R.id.et1);
        editText2=(EditText)findViewById(R.id.et2);
        editText3=(EditText)findViewById(R.id.et3);
        editText5=(EditText)findViewById(R.id.et5);


        save=(Button)findViewById(R.id.saveBtn);
        fetch=(Button)findViewById(R.id.fetchBtn);
        stateSpinner=(Spinner)findViewById(R.id.StateSpinner);
        stateAdapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_item,stateArr);
        stateSpinner.setAdapter( stateAdapter);
        stateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                p1 = stateSpinner.getSelectedItemPosition();
                text=stateSpinner.getItemAtPosition(p1).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            try{
                FileOutputStream fileOutputStream=openFileOutput(FILENAME,MODE_PRIVATE);
                OutputStreamWriter outputStreamWriter=new OutputStreamWriter(fileOutputStream);
                outputStreamWriter.write(editText.getText().toString()+","+editText2.getText().toString()+","+editText3.getText().toString()+","+text+","+editText5.getText().toString());
                outputStreamWriter.close();
                Toast.makeText(MainActivity.this,"SAVED",Toast.LENGTH_SHORT).show();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            }
        });
        fetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(MainActivity.this,show_details.class);
                startActivity(it);


            }
        });


    }
}
