package mx.tec.tarea141;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MyHobbies extends AppCompatActivity {
    TextView hobby;
    EditText toUpdate;
    private DBHelper db;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_hobbies);
        toUpdate=findViewById(R.id.valtoupdate);
        hobby=findViewById(R.id.textView3);
        db = new DBHelper(this);
        name=db.findName();//"Oscar";
        hobby.setText(db.find(name));
    }
    public void alPicar(View v){
        db.delete(name);
        db.save(name,toUpdate.getText().toString());
        hobby.setText(db.find(name));
    }

}