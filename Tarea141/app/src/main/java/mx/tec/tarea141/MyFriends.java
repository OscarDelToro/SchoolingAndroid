package mx.tec.tarea141;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MyFriends extends AppCompatActivity {
    private EditText name,
                     hobby;
    private DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_friends);
        name=findViewById(R.id.editTextTextPersonName2);
        hobby=findViewById(R.id.editTextTextHobby);
        db = new DBHelper(this);
    }

    public void search(View v){
        String hobbyValue = db.find(name.getText().toString());
        hobby.setText(hobbyValue);

    }
    public void save(View v){
        db.save(name.getText().toString(), hobby.getText().toString());
        Toast.makeText(this, "SAVED!", Toast.LENGTH_SHORT).show();
    }

    public void delete(View v){
        int rows = db.delete(name.getText().toString());
        Toast.makeText(this, rows + "ROWS AFFECTED.", Toast.LENGTH_SHORT).show();
    }

}