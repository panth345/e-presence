package com.official.g2s.epresence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHelper";

    private static final String DATABASE_NAME = "epresence";

    private static final String STUDENT_TABLE = "student_table";
    private static final String TEACHER_TABLE = "teacher_table";
    //private static final String SUBJECT_TABLE = "subject_table";

    private static final String StudentColumn0 = "RollNo";
    private static final String StudentColumn1 = "Name";
    private static final String StudentColumn2 = "Email";
    private static final String StudentColumn3 = "PhoneNo";
    private static final String StudentColumn4 = "Batch";
    private static final String StudentColumn5 = "Trade";
    private static final String StudentColumn6 = "Gender";
    private static final String StudentColumn7 = "Password";

    private static final String TeacherColumn1 = "Name";
    private static final String TeacherColumn2 = "Email";
    private static final String TeacherColumn3 = "PhoneNo";
    private static final String TeacherColumn4 = "Gender";
    private static final String TeacherColumn5 = "Department";
    private static final String TeacherColumn6 = "Password";

    private static final String SubjectColumn = "Subject";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + STUDENT_TABLE + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                StudentColumn0 + " TEXT, "+
                StudentColumn1 + " TEXT, "+
                StudentColumn2 + " TEXT, "+
                StudentColumn3 + " TEXT, "+
                StudentColumn4 + " TEXT, "+
                StudentColumn5 + " TEXT, "+
                StudentColumn6 + " TEXT, "+
                StudentColumn7 + " TEXT)";

        db.execSQL(createTable);

        String createTeacherTable = "CREATE TABLE " + TEACHER_TABLE + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TeacherColumn1 + " TEXT, "+
                TeacherColumn2 + " TEXT, "+
                TeacherColumn3 + " TEXT, "+
                TeacherColumn4 + " TEXT, "+
                TeacherColumn5 + " TEXT, "+
                TeacherColumn6 + " TEXT)";

        db.execSQL(createTeacherTable);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public boolean addData(String item0,String item1,String item2,String item3,String item4,String item5,String item6,String item7){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(StudentColumn0, item0);
        contentValues.put(StudentColumn1, item1);
        contentValues.put(StudentColumn2, item2);
        contentValues.put(StudentColumn3, item3);
        contentValues.put(StudentColumn4, item4);
        contentValues.put(StudentColumn5, item5);
        contentValues.put(StudentColumn6, item6);
        contentValues.put(StudentColumn7, item7);
        Log.d(TAG, "addData: Adding " +" "+item0+" "+ item1 + " "+item2+" "+item3+" "+item4+" "+item5+" "+" "+item6+" "+" "+item7+" "+" to " + STUDENT_TABLE);
        long result = db.insert(STUDENT_TABLE, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }


    public boolean addTeacherData(String item1,String item2,String item3,String item4,String item5,String item6){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(TeacherColumn1, item1);
        contentValues.put(TeacherColumn2, item2);
        contentValues.put(TeacherColumn3, item3);
        contentValues.put(TeacherColumn4, item4);
        contentValues.put(TeacherColumn5, item5);
        contentValues.put(TeacherColumn6, item6);
        Log.d(TAG, "addData: Adding " +" "+ item1 + " "+item2+" "+item3+" "+item4+" "+item5+" "+" "+item6+" "+" to " + TEACHER_TABLE);
        long result = db.insert(TEACHER_TABLE, null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }


    public Cursor getData(String usr) {
        SQLiteDatabase db = this.getWritableDatabase();

        String Query = "SELECT "+StudentColumn1+","+StudentColumn7+" FROM " + STUDENT_TABLE+" WHERE "+StudentColumn1+"="+usr;
        Cursor data = db.rawQuery(Query, null);
        return data;
    }

    public Cursor getData() {
        //SQLiteDatabase db = this.getWritableDatabase();
        SQLiteDatabase db = this.getReadableDatabase();

        String Query = "SELECT * FROM " + TEACHER_TABLE;
        Cursor data = db.rawQuery(Query, null);
        return data;
    }

    public Cursor getTeacherData() {
        SQLiteDatabase db = this.getWritableDatabase();

        String Query = "SELECT * FROM " + TEACHER_TABLE;
        Cursor data = db.rawQuery(Query, null);
        return data;
    }
}