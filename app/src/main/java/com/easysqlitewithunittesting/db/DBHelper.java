package com.easysqlitewithunittesting.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.easysqlitewithunittesting.Utilities;
import com.easysqlitewithunittesting.db.DBContract.Student;

/**
 * Created by waleed on 27/07/2014.
 */
public class DBHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "school.db";
    private static final int DATABASE_VERSION = 1;
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_FOR_STUDENT_TABLE = "CREATE TABLE "+Student.TABLE_NAME+"("+
                Student._ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"+
                Student.COLUMN_NAME+" TEXT NOT NULL,"+
                Student.COLUMN_AGE+" INTEGER NOT NULL,"+
                Student.COLUMN_ROLL_NO+" INTEGER NOT NULL);";

        Utilities.Log(SQL_FOR_STUDENT_TABLE);
        db.execSQL(SQL_FOR_STUDENT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+Student.TABLE_NAME);
        Utilities.Log("Table "+Student.TABLE_NAME+" Drop successfully");
    }
}
