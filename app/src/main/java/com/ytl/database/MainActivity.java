package com.ytl.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        try {

            SQLiteDatabase myDatabase = this.openOrCreateDatabase("theNewUsers", MODE_PRIVATE, null);
            myDatabase.execSQL("CREATE TABLE IF NOT EXISTS theNewUsers (name VARCHAR, age INT(3), id INTEGER PRIMARY KEY)");



            //create a table named "user" with name in string and age in int
            //myDatabase.execSQL("CREATE TABLE IF NOT EXISTS users (name VARCHAR, age INT(3))");

            //insert data into database
            myDatabase.execSQL("INSERT INTO theNewUsers (name, age) VALUES ('Richard', 28)");

            myDatabase.execSQL("INSERT INTO theNewUsers (name, age) VALUES ('JOHN', 33)");

            //delete from database
            //myDatabase.execSQL("DELETE FROM users WHERE name = 'Dave'");

            //SQL query
            Cursor c = myDatabase.rawQuery("SELECT * FROM theNewUsers", null);

            int nameIndex = c.getColumnIndex("name");
            int ageIndex = c.getColumnIndex("age");
            int idIndex = c.getColumnIndex("id");

            //move to the first row
            c.moveToFirst();

            while (c != null) {
                Log.i("YTL name", c.getString(nameIndex));
                Log.i("YTL age", Integer.toString(c.getInt(ageIndex)));
                Log.i("YTL id", Integer.toString(c.getInt(idIndex)));

                c.moveToNext();
            }
        } catch (Exception e){
            e.printStackTrace();
        }


    }
}
