package com.easysqlitewithunittesting;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;

import com.easysqlitewithunittesting.db.DBContract.Student;
import com.easysqlitewithunittesting.db.DBHelper;

/**
 * Created by waleed on 27/07/2014.
 */
public class DBTesting extends AndroidTestCase{

    private static String mStudentName;
    private static int mStudentAge;
    private static int mStudentRollNumber;
    private static long mStudentDBAssignId;



    public void testDropDB(){
        assertTrue(mContext.deleteDatabase(DBHelper.DATABASE_NAME));
        Utilities.Log("testDropDB Pass");
    }

    public void testCreateDB(){
        DBHelper dbHelper = new DBHelper(mContext);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        assertTrue(db.isOpen());
        db.close();
        Utilities.Log("testCreateDB Pass");
    }

    public void testInsertData(){
        DBHelper dbHelper = new DBHelper(mContext);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        mStudentName = "Micheal";
        mStudentAge = 9;
        mStudentRollNumber = 1001;

        ContentValues contentValues = new ContentValues();
        contentValues.put(Student.COLUMN_NAME, mStudentName);
        contentValues.put(Student.COLUMN_AGE, mStudentAge);
        contentValues.put(Student.COLUMN_ROLL_NO, mStudentRollNumber);

        mStudentDBAssignId = db.insert(Student.TABLE_NAME, null, contentValues);
        assertTrue(mStudentDBAssignId != -1);
        Utilities.Log("testInsertData Pass - ID: "+ mStudentDBAssignId);
    }


    public void testIsDataCorrectInDB(){
        DBHelper dbHelper = new DBHelper(mContext);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query(Student.TABLE_NAME,null,null,null,null,null,null);
        assertTrue(cursor.moveToFirst());

        int idColumnIndex = cursor.getColumnIndex(Student._ID);
        int dbId = cursor.getInt(idColumnIndex);

        int nameColumnIndex = cursor.getColumnIndex(Student.COLUMN_NAME);
        String dbName = cursor.getString(nameColumnIndex);

        int ageColumnIndex = cursor.getColumnIndex(Student.COLUMN_AGE);
        int dbAge = cursor.getInt(ageColumnIndex);

        int rollNoColumnIndex = cursor.getColumnIndex(Student.COLUMN_ROLL_NO);
        int dbRollNo = cursor.getInt(rollNoColumnIndex);

        assertEquals(mStudentDBAssignId, dbId);
        assertEquals(mStudentName, dbName);
        assertEquals(mStudentAge, dbAge);
        assertEquals(mStudentRollNumber, dbRollNo);

        Utilities.Log("testIsDataCorrect Pass");
    }
}
