package com.example.anupam.webview;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main2Activity extends AppCompatActivity {

    Double a,b,res;
    boolean add,sub,mul,div;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);

        Intent i =  getIntent();

        Bundle bun =i.getExtras();

        a = bun.getDouble("a");
        b = bun.getDouble("b");

        add = bun.getBoolean("add");
        sub = bun.getBoolean("sub");
        mul = bun.getBoolean("mul");
        div = bun.getBoolean("div");


        calculation();


        Intent resultIntent = new Intent();
        Bundle bc = new Bundle();

        bc.putDouble("res",res);

        resultIntent.putExtras(bc);
        setResult(Activity.RESULT_OK, resultIntent);
        finish();


        /*Intent returnIntent = new Intent();
        returnIntent.putExtra("result", result);
        setResult(Activity.RESULT_OK, returnIntent);
        finish();

       Intent newIn = new Intent(getApplicationContext(),MainActivity.class);
        Bundle newBun = new Bundle();
        newBun.putDouble("res",res);
        newBun.putBoolean("add",add);
        newBun.putBoolean("sub",sub);
        newBun.putBoolean("mul",mul);
        newBun.putBoolean("div",div);
        newIn.putExtras(newBun);
        startActivity(newIn);*/

    }



    private void calculation()
    {
        if (add == true)
        {

            res = a + b;
            add=false;
        }

        if (sub == true)
        {

            res = a - b;
            sub=false;
        }

        if (mul == true)
        {

            res = a * b;
            mul=false;
        }

        if (div == true)
        {

            res = a / b;
            div=false;
        }
    }
}
