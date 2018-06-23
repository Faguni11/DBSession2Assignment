package com.example.dell.dbsession2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="contacts.db";
    private static final String TABLE_NAME="contacts";
    private static final String COLUMN_ID="id";
    private static final String COLUMN_EMAIL="email";
    private static final String COLUMN_PHONE="phone";
    private static final String COLUMN_PASSWORD="password";
    private static final String COLUMN_TYPE="type";
    SQLiteDatabase db;
    String[] columns ={"email", "phone","password","type"};

 private static final String query="Create table IF NOT EXISTS "+ TABLE_NAME+" ("+ COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_EMAIL+ " TEXT, " + COLUMN_PHONE+ " TEXT, " +COLUMN_PASSWORD+ " TEXT, " +COLUMN_TYPE+ " TEXT);";



    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL(query);
    this.db=db;

    }
    public void insertContact(Contact con){

    db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(COLUMN_EMAIL,con.getEmail());
        values.put(COLUMN_PHONE,con.getPhone());
        values.put(COLUMN_PASSWORD,con.getPassword());
        values.put(COLUMN_TYPE,con.getType());
        db.insert(TABLE_NAME,null,values);
    }
    public int updateData(String email1,String password1){
        db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        //contentValues.put(COLUMN_ID,id1);
        //contentValues.put(COLUMN_EMAIL,email1);
        //contentValues.put(COLUMN_PHONE,phone1);
        contentValues.put(COLUMN_PASSWORD,password1);
        //contentValues.put(COLUMN_TYPE,type1);
        db.update(TABLE_NAME,contentValues, "email = ?",new String[]{email1 });

        return 1;
    }
    public int deleteData(String mail){
        db=this.getWritableDatabase();
        return db.delete(TABLE_NAME, "email = ?",new String[] {mail});

    }

    public Cursor viewData(String t){
        db=this.getReadableDatabase();
       /* String query="Select * from "+TABLE_NAME;
        Cursor cursor=db.rawQuery(query,null);
        */
        String[] params = new String[]{ t };
        Cursor c = db.query("contacts", null,
                "type = ?", params,
                null, null, null);
        return c;
    }

    public String searchPass(String uname){
        db=this.getReadableDatabase();
        String qu="select email, password from "+TABLE_NAME;
        Cursor cursor=db.rawQuery(qu,null);
        String a,b;
        b="not found";
        if(cursor.moveToFirst()){
            do{
                a=cursor.getString(0);

                if(a.equals(uname)){
                    b=cursor.getString(1);
                    break;
                }

            }while (cursor.moveToNext());
        }
        return b;
    }
    public String searchType(String uname){

        db=this.getReadableDatabase();
        String qu="select email, type from "+TABLE_NAME;
        Cursor cursor=db.rawQuery(qu,null);
        String a,b;
        b="not found";
        if(cursor.moveToFirst()){
            do{
                a=cursor.getString(0);

                if(a.equals(uname)){
                    b=cursor.getString(1);
                    break;
                }

            }while (cursor.moveToNext());
        }
        return b;
    }
    public String searchPhone(String uname){

        db=this.getReadableDatabase();
        String qu="select email, phone from "+TABLE_NAME;
        Cursor cursor=db.rawQuery(qu,null);
        String a,b;
        b="not found";
        if(cursor.moveToFirst()){
            do{
                a=cursor.getString(0);

                if(a.equals(uname)){
                    b=cursor.getString(1);
                    break;
                }

            }while (cursor.moveToNext());
        }
        return b;
    }

    public String searchId(String uname){

        db=this.getReadableDatabase();
        String qu="select email, id from "+TABLE_NAME;
        Cursor cursor=db.rawQuery(qu,null);
        String a,b;
        b="not found";
        if(cursor.moveToFirst()){
            do{
                a=cursor.getString(0);

                if(a.equals(uname)){
                    b=cursor.getString(1);
                    break;
                }

            }while (cursor.moveToNext());
        }
        return b;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    String q= "DROP TABLE IF EXISTS "+TABLE_NAME;
    db.execSQL(q);
    this.onCreate(db);
    }

}
