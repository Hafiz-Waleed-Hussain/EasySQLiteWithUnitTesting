package com.easysqlitewithunittesting.db;

import android.provider.BaseColumns;

/**
 * Created by waleed on 27/07/2014.
 */
public class DBContract {

    public static final class Student implements BaseColumns{

        public static final String TABLE_NAME= "students";

        public static final String COLUMN_NAME = "student_name";
        public static final String COLUMN_AGE = "student_age";
        public static final String COLUMN_ROLL_NO = "student_roll_no";


    }
}
