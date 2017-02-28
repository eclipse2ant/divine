package com.apress.gerber.divine;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hiroko on 2017/02/21.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DBNAME = "jogrecord.db";
    private static final int DBVERSION = 1;
    public static final String TABLE_JOGRECORD = "jogrecord";
    public static final String DB_ID = "_id";
    public static final String DB_DATE = "date";
 //   public static final String DB_NAME = "name";
  //  public static final String DB_MALE = "male";
  //  public static final String COLUMN_SPEED = "speed";
  //  public static final String COLUMN_ADDRESS = "address";
    private static final String CREATE_TABLE_SQL =
            "create table" + TABLE_JOGRECORD +""
            + "C" + DB_ID + "integer primary key autoincrement"
            + DB_DATE + "text not null"
    //        + DB_NAME + "text null"
      //      + DB_MALE + "text not null"
            ;

    public DatabaseHelper(Context context){
        super(context,DBNAME,null,DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_TABLE_SQL);
    }

    @Override
    public void  onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
    }
}
