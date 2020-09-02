package mx.tec.tarea141;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLInput;
public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_FILE = "MyDatabase.db";
    private static final String TABLE = "people";
    private static final String FIELD_ID = "id";
    private static final String FIELD_NAME = "name";
    private static final String FIELD_HOBBY = "hobby";

    public DBHelper(Context context) {

        // context is a class that is able to request functionality from OS
        super(context, DB_FILE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE + "(" +
                FIELD_ID + " INTEGER PRIMARY KEY, " +
                FIELD_NAME + " TEXT, " +
                FIELD_HOBBY + " INTEGER)";
        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        String query = "DROP TABLE IF EXISTS ?";
        String[] params = {TABLE};
        sqLiteDatabase.execSQL(query, params);
        onCreate(sqLiteDatabase);

    }
    public void save(String name, String hobby){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues valores = new ContentValues();

        valores.put(FIELD_NAME, name);
        valores.put(FIELD_HOBBY, hobby);

        db.insert(TABLE, null, valores);
    }

    public int delete(String name){

        SQLiteDatabase db = getWritableDatabase();
        String clause = FIELD_NAME + " = ?";
        String[] args = {name};

        return db.delete(TABLE, clause, args);

    }

   /* public int find(String name){

        SQLiteDatabase db = getReadableDatabase();
        String clause = FIELD_NAME + " = ?";
        String[] args = {name};

        Cursor c = db.query(TABLE, null, clause, args, null, null, null);
        int result = -1;

        if(c.moveToFirst()){

            result = c.getInt(2);
        }

        *//*
        //Recorrer todos los resultados
        while(c.moveToNext()){

        }

         *//*

        return result;

    }*/
    public String find(String name){

        SQLiteDatabase db = getReadableDatabase();
        String clause = FIELD_NAME + " = ?";
        String[] args = {name};

        Cursor c = db.query(TABLE, null, clause, args, null, null, null);
        String result = "";

        if(c.moveToFirst()){

            result = c.getString(2);
        }

        /*
        //Recorrer todos los resultados
        while(c.moveToNext()){

        }

         */

        return result;

    }
    public String findName(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT name FROM people ", null);
        String result="";
        if (c.moveToFirst()){
            result = c.getString(0);
        }
        c.close();
        db.close();
        return result;
    }


}
