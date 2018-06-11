package com.example.dell.filestorage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class show_details extends AppCompatActivity {
    TextView textView,textView2,textView3,textView4,textView5;
    String FILENAME="myFileHello.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);
        textView2=(TextView)findViewById(R.id.tv2);
        textView3=(TextView)findViewById(R.id.tv3);
        textView=(TextView)findViewById(R.id.tv1);
        textView4=(TextView)findViewById(R.id.tv4);
        textView5=(TextView)findViewById(R.id.tv5);

        try {
            FileInputStream fileInputStream=openFileInput(FILENAME);
            InputStreamReader inputReader=new InputStreamReader(fileInputStream);
            char [] inputText=new char[100];
            String finalFileText="";
            int charCount;
            while((charCount=inputReader.read(inputText))>0){
                finalFileText=finalFileText+String.copyValueOf(inputText);

            }
            inputReader.close();
            if(finalFileText.length()>0) {
                String dataArg[] = finalFileText.split(",");
                textView.setText("Name ="+dataArg[0]);
                textView2.setText("Password ="+dataArg[1]);
                textView3.setText("Email ="+dataArg[2]);
                textView4.setText("State ="+dataArg[3]);
                textView5.setText("City ="+dataArg[4]);
            }
           // textView.setVisibility(TextView.VISIBLE);
            //Toast.makeText(show_details.this,"FETCHED",Toast.LENGTH_SHORT).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
