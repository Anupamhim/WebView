package com.example.anupam.webview;

/**
 * Created by Anupam on 8/1/2017.
 */
public class History {

    String a,b,total;

    String operator;
    int id;



    public History()
    {

    }

    public History(int id,String a,String b,String op,String res)
    {
        this.id = id;
        this.a = a;
        this.b = b;
        this.operator = op;
        this.total = res;
    }
    public History(String a,String b,String op,String res)
    {
        this.a = a;
        this.b = b;
        this.operator = op;
        this.total = res;
    }
    public History(String a,String b)
    {
        this.a = a;
        this.b = b;
    }

    public void setTotal(String result) {
        this.total = result;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setA(String a)
    {
        this.a = a;
    }
    public void setB(String b)
    {
        this.b = b;
    }
    public void setOperator(String op)
    {
        this.operator = op;
    }

    public int getId()
    {
        return id;
    }

    public String getA()
    {
        return this.a;
    }
    public String getB()
    {
        return this.b;
    }
    public String getOperator()
    {
        return this.operator;
    }

    public String getTotal() {
        return total;
    }
}
