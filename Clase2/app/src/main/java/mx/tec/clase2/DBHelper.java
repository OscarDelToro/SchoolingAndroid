package mx.tec.clase2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//sqlite is a dbms
//it is relational
//Stored locally in files

//The language you use is SQL

public class DBHelper extends SQLiteOpenHelper {
    //constants we will use
    private static final String DB_FILE = "MyDatabase.db";
    private static final String TABLE = "Students";
    private static final  String FIELD_ID = "id";
    private static final String FIELD_NAME = "name";
    private static final String FIELD_GRADE = "grade";

    public DBHelper(Context context){
        super(context, DB_FILE, null, 1);



    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE "+ TABLE + "(" +
                FIELD_ID + "INTEGER PRIMARY KEY, " +
                FIELD_NAME + "TEXT, "+
                FIELD_GRADE + "INTEGER)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query="DROP TABLE IF EXISTS ?";
        String[] params={TABLE};
        db.execSQL(query,params);
        onCreate(db);
    }

    public void save(String name, int grade){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(FIELD_NAME,name);
        valores.put(FIELD_GRADE,grade);
        db.insert(TABLE,null,valores);
    }
    public int delete(String name){
        SQLiteDatabase db = getWritableDatabase();
        String clause = FIELD_NAME+" = ?";
        String[] args = {name};

        return db.delete(TABLE,clause,args);
    }
    public int find(String name){
        SQLiteDatabase db = getReadableDatabase();
        String clause = FIELD_NAME + " = ?";
        String[] args ={name};
        Cursor c=db.query(TABLE,null,clause,args,null,null,null);
        int result =-1;

        if(c.moveToFirst()){
            result =c.getInt(2);
        }

        /*Recorrer todos los resultados
        while(c.moveToNext()){

        }
         */
        return result;

    }
}
