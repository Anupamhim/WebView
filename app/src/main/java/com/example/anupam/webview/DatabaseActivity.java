package com.example.anupam.webview;

import android.content.Intent;
import android.database.Cursor;
import java.nio.Buffer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class DatabaseActivity extends AppCompatActivity {

    DatabaseHandler db;
    TextView dataShow,back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);
        dataShow = (TextView)findViewById(R.id.dataShow) ;

        back = (TextView)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                Intent intent = new Intent(getApplicationContext(),Main4Activity.class);
                startActivity(intent);
                finish();
            }
        });

        db = new DatabaseHandler(this);
        Cursor resCursor = db.getAllData();
        if(resCursor.getCount() == 0)
        {
            Toast.makeText(getApplicationContext(), "Database is Empty", Toast.LENGTH_SHORT).show();
            dataShow.setText("Database is Empty");
            return;
        }
        StringBuffer sb = new StringBuffer();
        while(resCursor.moveToNext()){
            sb.append("  "+resCursor.getString(0)+"       "+resCursor.getString(1)+" "+  "      " +resCursor.getString(3)+" "+  "      "+resCursor.getString(2)+"         "+resCursor.getString(4)+"\n");
        }
        dataShow.setText(sb.toString());



    }
}
