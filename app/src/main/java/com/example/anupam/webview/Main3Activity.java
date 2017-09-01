package com.example.anupam.webview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Date;

public class Main3Activity extends AppCompatActivity {
    TextView back;
    TextView tx,Dtime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        Intent i = getIntent();
        tx = (TextView)findViewById(R.id.historyText);
        Dtime = (TextView)findViewById(R.id.time);


        try {
            FileInputStream inputStream = openFileInput("myfile");
            BufferedReader r = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder total = new StringBuilder();
            String line;
            while ((line = r.readLine()) != null) {
                total.append(line);
            }
            r.close();
            inputStream.close();

            tx.setText(total+"");

            String tme = DateFormat.getTimeFormat(getApplicationContext()).format(new Date());


            Dtime.setText(tme);



            Log.d("File", "File contents: " + total);
        } catch (Exception e) {
            e.printStackTrace();
        }


        back = (TextView)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                Intent intent = new Intent(getApplicationContext(),Main4Activity.class);
                startActivity(intent);
                finish();
            }
        });


    }
}

