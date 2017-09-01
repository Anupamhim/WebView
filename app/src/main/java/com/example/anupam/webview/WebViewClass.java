package com.example.anupam.webview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

@SuppressLint("JavascriptInterface")
public class WebViewClass extends AppCompatActivity {

    private WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_class);

        web = (WebView)findViewById(R.id.webView);

        String url = "file:///android_asset/index.html";
        web.getSettings().setJavaScriptEnabled(true);
        web.addJavascriptInterface(new WebAppInterface(this), "Android");
        web.loadUrl(url);



    }

    public class WebAppInterface
    {
        Context mContext;
        String data;
        double myNumber2;
        double myNumber1;
        int sign;
        int signForPoint;

        WebAppInterface(Context ctx)
        {
            this.mContext=ctx;
            this.myNumber1=0;
            this.myNumber2=0;
            this.signForPoint=0;
        }

        String opr;

        @JavascriptInterface
        public String addNum(String num)
        {
            if(signForPoint==1){
                myNumber2= myNumber2+(Double.parseDouble(num)/10);
                signForPoint=0;
            }
            else{
                if(num.equals(".")){
                    signForPoint=1;
                }
                else {
                    myNumber2=Double.parseDouble(num);
                }
            }

            return num;
        }

        public String addOperator(String opr)
        {
            if(opr.equals("+")){
                sign=1;
                myNumber1=myNumber2;
            }
            else if (opr.equals("-")){
                sign=2;
                myNumber1=myNumber2;
            }
            else if (opr.equals("*")){
                sign=3;
                myNumber1=myNumber2;
            }
            else if (opr.equals("/")){
                sign=4;
                myNumber1=myNumber2;
            }

            return opr;
        }


        public String getResult()
        {
            double res = 0;

            if(sign==1){
                res=myNumber1+myNumber2;
            }
            else if(sign==2){
                res=myNumber1-myNumber2;
            }
            else if(sign==3){
                res=myNumber1*myNumber2;
            }
            else if(sign==4){

                res=myNumber1/myNumber2;
            }

            sign=0;
            myNumber1=0;
            myNumber2=0;
            return String.valueOf(res);
        }
    }


}


