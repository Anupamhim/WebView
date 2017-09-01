package com.example.anupam.webview;

import android.content.Intent;
import android.content.Context;
import android.content.SharedPreferences;
import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;
import java.util.jar.JarEntry;
import android.util.Log;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {

    public static final String PREFS_NAME = "MyPrefsFile";
    SharedPreferences myPref;
    DatabaseHandler db;
    ListView LV;


    Bundle bun;

    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bplus,bminus,bmul,bdiv,bpoint,bequal,bac,mem,mPlus,mMinus,history,dBase,dBaseClear,bc;
    EditText etx;
    TextView textView;
    String s= "",reslt = "";
    String sv = "";
    Double  a  ,b,res;
    int o = 1,n = 2 ;
    String Result;
    File file;
    String filename = "myfile";
    //String res;

    boolean add,sub,mul,div;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        db = new DatabaseHandler(this);
        init();

    }


    private void init()
    {
        etx = (EditText) findViewById(R.id.editText) ;
        textView = (TextView) findViewById(R.id.textView);
        LV  = (ListView) findViewById(R.id.list_view);

        //tx.setText("Enter Your Number Please", TextView.BufferType.EDITABLE);






        b1 = (Button)findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                etx.setText(etx.getText()+"1");
                textView.setText(s+""+etx.getText());
            }
        });

        b2 = (Button)findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                etx.setText(etx.getText()+"2");
                textView.setText(s+""+etx.getText());
            }
        });

        b3 = (Button)findViewById(R.id.b3);
        b3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                etx.setText(etx.getText()+"3");
                textView.setText(s+""+etx.getText());
            }
        });

        b4 = (Button)findViewById(R.id.b4);
        b4.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                etx.setText(etx.getText()+"1");
                textView.setText(s+""+etx.getText());
            }
        });

        b5 = (Button)findViewById(R.id.b5);
        b5.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                etx.setText(etx.getText()+"5");
                textView.setText(s+""+etx.getText());
            }
        });

        b6 = (Button)findViewById(R.id.b6);
        b6.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                etx.setText(etx.getText()+"6");
                textView.setText(s+""+etx.getText());
            }
        });

        b7 = (Button)findViewById(R.id.b7);
        b7.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                etx.setText(etx.getText()+"7");
                textView.setText(s+""+etx.getText());
            }
        });

        b8 = (Button)findViewById(R.id.b8);
        b8.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                etx.setText(etx.getText()+"8");
                textView.setText(s+""+etx.getText());
            }
        });

        b9 = (Button)findViewById(R.id.b9);
        b9.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                etx.setText(etx.getText()+"9");
                textView.setText(s+""+etx.getText());
            }
        });

        b0 = (Button)findViewById(R.id.b0);
        b0.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                etx.setText(etx.getText()+"0");
                textView.setText(s+""+etx.getText());
            }
        });


        bplus = (Button)findViewById(R.id.bplus);
        bplus.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                if (etx == null)
                {
                    etx.setText("");

                }
                else
                {
                    try
                    {
                        a = Double.parseDouble(etx.getText() +"");
                        add = true;
                        textView.setText(etx.getText()+"+");
                        s = textView.getText().toString();
                        etx.setText(null);

                    }
                    catch (NumberFormatException e)
                    {

                    }
                }


            }
        });

        bminus = (Button)findViewById(R.id.bminus);
        bminus.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                if (etx == null)
                {
                    etx.setText("");

                }
                else
                {
                    try
                    {
                        a = Double.parseDouble(etx.getText() +"");
                        sub = true;
                        textView.setText(etx.getText()+"-");
                        s = textView.getText().toString();
                        etx.setText(null);
                    }
                    catch (NumberFormatException e)
                    {
                    }
                }


            }
        });


        bmul = (Button)findViewById(R.id.bmul);
        bmul.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                if (etx == null)
                {
                    etx.setText("");
                }
                else
                {
                    try
                    {
                        a = Double.parseDouble(etx.getText() +"");
                        mul = true;
                        textView.setText(etx.getText()+"*");
                        s = textView.getText().toString();
                        etx.setText(null);

                    }
                    catch (NumberFormatException e)
                    {


                    }

                }


            }
        });

        bdiv = (Button)findViewById(R.id.bdiv);
        bdiv.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                if (etx == null)
                {
                    etx.setText("");


                }
                else
                {
                    try
                    {
                        a = Double.parseDouble(etx.getText() +"");
                        div = true;
                        textView.setText(etx.getText()+"/");
                        s = textView.getText().toString();
                        etx.setText(null);


                    }
                    catch (NumberFormatException e)
                    {


                    }

                }


            }
        });

        bpoint = (Button)findViewById(R.id.bpoint);
        bpoint.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                etx.setText(etx.getText()+".");
                textView.setText(s+""+etx.getText());
            }
        });

        bac = (Button)findViewById(R.id.bac);
        bac.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                etx.setText("");
                textView.setText("");
                a = 0.0;
                b = 0.0;
                s = "";
                add = false;
                sub = false;
                mul = false;
                div = false;
            }
        });


        mPlus  = (Button)findViewById(R.id.mPlus);
        mPlus.setOnClickListener(new View.OnClickListener()
        {

            public void onClick(View arg0) {
                // TODO Auto-generated method stub


                myPref = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
                String s = myPref.getString("stor","");
                try
                {
                    res = Double.parseDouble(s+"");
                    etx.setText(res+1+"");
                    res = res + 1;
                    textView.setText(etx.getText()+"");
                    SharedPreferences.Editor editor = myPref.edit();

                    editor.putString("stor",res.toString());
                    editor.commit();
                    //saveInfo();


                }
                catch(NumberFormatException e)
                {

                }
            }
        });

        mMinus  = (Button)findViewById(R.id.mMinus);
        mMinus.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                myPref = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

                String s = myPref.getString("stor","");
                try
                {
                    res = Double.parseDouble(s+"");
                    etx.setText(res-1+"");
                    res = res-1;
                    textView.setText(etx.getText()+"");
                    SharedPreferences.Editor editor = myPref.edit();
                    Result = res.toString();

                    editor.putString("stor",Result);
                    editor.commit();
                    //saveInfo();

                }
                catch(NumberFormatException e)
                {

                }

            }
        });

        mem  = (Button)findViewById(R.id.memory);
        mem.setOnClickListener(new View.OnClickListener()
        {

            public void onClick(View arg0)
            {
                // TODO Auto-generated method stub

                try
                {
                    myPref = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

                    // String sting =  etx.getText().toString();
                    SharedPreferences.Editor editor = myPref.edit();
                    Result = res.toString();
                    editor.putString("stor",Result);
                    editor.commit();
                    String str = myPref.getString("stor","no" );

                    etx.setText(str);
                    textView.setText(str);
                }

                catch(NumberFormatException e)
                {

                }
            }
        });

        bequal = (Button)findViewById(R.id.bequal);
        bequal.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                // TODO Auto-generated method stub


                try
                {
                    b = Double.parseDouble(etx.getText().toString());


                    if(a != null)
                    {
                        Intent i = new Intent(getApplicationContext(),Main2Activity.class);
                        bun = new Bundle();
                        bun.putDouble("a",a);
                        bun.putDouble("b",b);
                        bun.putBoolean("add",add);
                        bun.putBoolean("sub",sub);
                        bun.putBoolean("mul",mul);
                        bun.putBoolean("div",div);
                        i.putExtras(bun);
                        startActivityForResult(i,1);
                    }
                    else
                    {
                        etx.setText(etx.getText());
                        textView.setText(etx.getText());
                    }
                }
                catch (NumberFormatException e)
                {
                }
            }
        });


        dBase = (Button)findViewById(R.id.dataBase);
        dBase.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                Intent intent = new Intent(getApplicationContext(),DatabaseActivity.class);
                startActivity(intent);
                finish();
            }


        });

        dBaseClear = (Button)findViewById(R.id.dataClear);
        dBaseClear.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                db.deleteDatabase(o,n);
                Toast.makeText(getApplicationContext(), "Database is Deleted Now", Toast.LENGTH_SHORT).show();
                o++;
                n++;
            }


        });

        history  = (Button)findViewById(R.id.memCl);
        history.setOnClickListener(new View.OnClickListener()
        {

            public void onClick(View arg0)
            {
                // TODO Auto-generated method stub

                Intent intent = new Intent(getApplicationContext(),Main3Activity.class);
                startActivity(intent);
                finish();
            }
        });

        bc = (Button)findViewById(R.id.bc);
        bc.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                // TODO Auto-generated method stub

                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        });





    }

    public  void wirteFile()
    {

        String operand = (textView.getText()+"");


        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(operand.getBytes());
            String op = " = ";
            outputStream.write(op.getBytes());
            outputStream.write(reslt.getBytes());
            outputStream.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    @Override
    public void onActivityResult(int requestCode,int resultCode, Intent data)
    {
        Bundle k = new Bundle();
        k = data.getExtras();
        res = k.getDouble("res");
        reslt = res.toString();
        etx.setText(res+"");
        wirteFile();
        dataBaseInput();

        add = false;
        sub = false;
        mul = false;
        div = false;
        // textView.setText(etx.getText());
    }



    public void dataBaseInput()
    {



        /**
         * CRUD Operations
         * */
        // Inserting Contacts
        //Log.d("Insert: ", "Inserting ..");
        String op1,op2,sign,fol;
        fol = res.toString();

        op1 = a.toString();
        op2 = b.toString();
        sign = "";

        if(add)
        {
            sign = "+";
        }
        else if(sub)
        {
            sign = "-";
        }
        else if(div)
        {
            sign = "/";
        }
        else if(mul)
        {
            sign = "*";
        }
        db.addCalculation(new History(op1,op2,sign,fol));
    }



}

