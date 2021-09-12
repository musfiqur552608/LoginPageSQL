package com.example.loginwithsql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private  static final String DATABASE_NAME = "userdetails.db";
    private  static final String TABLE_NAME = "user_details";
    private  static final String ID = "Id";
    private  static final String NAME = "Name";
    private  static final String EMAIL = "Email";
    private  static final String USERNAME = "Username";
    private  static final String PASSWORD = "Password";
    private  static final int VERSION_NUMBER = 2;
    private Context context;
    private static final String DROP_TABLE = " DROP TABLE IF EXISTS "+TABLE_NAME;

    private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+"("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+NAME+" VARCHAR(255) NOT NULL,"+EMAIL+" TEXT NOT NULL,"+USERNAME+" TEXT NOT NULL,"+PASSWORD+" TEXT NOT NULL)";




    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION_NUMBER);

        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try{
            sqLiteDatabase.execSQL(CREATE_TABLE);
            Toast.makeText(context, "onCreate is called", Toast.LENGTH_LONG).show();
        }catch (Exception e){
            Toast.makeText(context, "Exception : "+e, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        try{
            Toast.makeText(context, "onUpgrade is called", Toast.LENGTH_LONG).show();
            sqLiteDatabase.execSQL(DROP_TABLE);
            onCreate(sqLiteDatabase);
        }catch (Exception e){
            Toast.makeText(context, "Exception : "+e, Toast.LENGTH_LONG).show();
        }
    }
}
