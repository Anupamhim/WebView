package com.example.anupam.webview;

/**
 * Created by Anupam on 8/1/2017.
 */
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "calculationManager";

    // Contacts table name
    private static final String TABLE_CALCULATION = "calculation";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_ONE = "valueOne";
    private static final String KEY_TWO = "valueTwo";
    private static final String KEY_THREE = "operator";
    private static final String KEY_FOUR = "result";


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //3rd argument to be passed is CursorFactory instance
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CALCULATION_TABLE = "CREATE TABLE " + TABLE_CALCULATION + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_ONE + " TEXT,"
                + KEY_TWO + " TEXT, " + KEY_THREE + " TEXT, " + KEY_FOUR + " TEXT"+ ")";
        db.execSQL(CREATE_CALCULATION_TABLE);
    }



    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CALCULATION);

        // Create tables again
        onCreate(db);
    }



    // Adding new contact
    public void addCalculation(History history) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ONE, history.getA()); // variable one
        values.put(KEY_TWO, history.getB()); // variable two
        values.put(KEY_THREE, history.getOperator());
        values.put(KEY_FOUR, history.getTotal());

        // Inserting Row
        db.insert(TABLE_CALCULATION, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    public  void deleteDatabase(int o,int n)
    {
        SQLiteDatabase db =  this.getWritableDatabase();
        onUpgrade(db,o,n);

    }
    // Getting All calculation

    public List<History> getAllCalculation()
    {
        List<History> calculationList = new ArrayList<History>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CALCULATION;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                History history = new History();
                history.setId(Integer.parseInt(cursor.getString(0)));
                history.setA(cursor.getString(1));
                history.setB(cursor.getString(2));
                history.setOperator(cursor.getString(3));
                history.setTotal(cursor.getString(4));
                // Adding contact to list
                calculationList.add(history);
            } while (cursor.moveToNext());
        }

        // return contact list
        return calculationList;
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor resCursor = db.rawQuery("select * from "+TABLE_CALCULATION, null);
        return resCursor;
    }

    // Updating single contact
    /*public int updateContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.getName());
        values.put(KEY_PH_NO, contact.getPhoneNumber());

        // updating row
        return db.update(TABLE_CONTACTS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(contact.getID()) });
    }

    // Deleting single contact
    public void deleteContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONTACTS, KEY_ID + " = ?",
                new String[] { String.valueOf(contact.getID()) });
        db.close();
    }

    // Getting contacts Count
    public int getContactsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_CONTACTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }*/


    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    /* // Getting single contact
    Contact getContact(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_CONTACTS, new String[] { KEY_ID,
                        KEY_NAME, KEY_PH_NO }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Contact contact = new Contact(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));
        // return contact
        return contact;
    }*/



}
