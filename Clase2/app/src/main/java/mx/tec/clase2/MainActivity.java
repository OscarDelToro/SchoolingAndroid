package mx.tec.clase2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private DBHelper db;
    private EditText id, name,grade;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //local storage
        //-local db
        // shared prefs
        id =findViewById(R.id.editTextID);
        name=findViewById(R.id.editTextname);
        grade=findViewById(R.id.editTextGrade);
        db = new DBHelper(this);

    }
    public void saveDB(View v){
        db.save(name.getText().toString(),Integer.parseInt(grade.getText().toString()));
        Toast.makeText(this,"SAVED",Toast.LENGTH_SHORT).show();
    }
    public void delete(View v){
        int rows=db.delete(name.getText().toString());
        Toast.makeText(this,rows+"rows deleted",Toast.LENGTH_LONG).show();

    }
    public void find(View v){
        int gradeValue =db.find(name.getText().toString());
        grade.setText(gradeValue+"");

    }
}
