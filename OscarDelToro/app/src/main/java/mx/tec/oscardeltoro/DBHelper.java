package mx.tec.oscardeltoro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLInput;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private static final int VER=1;
    private static final String FILE_NAME="Database.db";
    private static final String TABLE="CATS";
    private static final String ID="ID";
    private static final String NAME="NOMBRE";
    private static final String AGE="EDAD";
    public DBHelper(Context context) {
        super(context, FILE_NAME,null, VER);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE + "(" + ID + " INTEGER PRIMARY KEY, " + NAME + " TEXT, "
                + AGE + " INTEGER)";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String args[]={TABLE};
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS ?", args);
        onCreate(sqLiteDatabase);
    }
    public void saveNew(String name, int age){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(AGE,age);
        values.put(NAME,name);
        db.insert(TABLE,null,values);
    }
    public String[] searchByID(int id){
        SQLiteDatabase db = getReadableDatabase();
        String clause = ID + " = ?";
        String stringID[] = {Integer.toString(id)};
        Cursor c = db.query(TABLE, null, clause,stringID, null, null, null);
        String results[] = new String[2];
        if(c.moveToFirst()){

            results[0] = c.getString(1);
            results[1] = c.getString(2);
        }
        return results;

    }
    public String[] getAll(int index){
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM "+TABLE , null);
        String result[] = new String[3];
        if(c.moveToFirst()){
            result[0] = c.getString(0);
            result[1] = c.getString(1);
            result[2] = c.getString(2);
            for(int i=0;i<index;i++){
                if(c.moveToNext()){
                    result[0] = c.getString(0);
                    result[1] = c.getString(1);
                    result[2] = c.getString(2);
                }
                else{
                    result[0] = "Not found";
                    result[1] = "Not found";
                    result[2] = "Not found";
                }
            }
        }
        return result;

    }
    public String getFirstName(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT "+NAME+" FROM "+TABLE+" ORDER BY " +NAME+" ASC" , null);
        if(c.moveToFirst()){
            return c.getString(0);
        }
        return "";
    }
    public String getOldName(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT "+NAME+", "+AGE+" FROM "+TABLE+" ORDER BY " +AGE+" DESC" , null);
        if(c.moveToFirst()){
            return c.getString(0);
        }
        return "";
    }




}
