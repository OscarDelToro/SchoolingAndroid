package mx.tec.oscardeltoro;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DBActivity extends AppCompatActivity {
    private TextView salut;
    private EditText id,nombre,edad;
    private DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d_b);
        salut = findViewById(R.id.salutation);
        id = findViewById(R.id.id);
        nombre = findViewById(R.id.nombre);
        edad = findViewById(R.id.edad);
        db = new DBHelper(this);
        String dat[]=db.getAll(0);
        id.setText(dat[0]);
        nombre.setText(dat[1]);
        edad.setText(dat[2]);
        Intent parent = getIntent();
        salut.setText(parent.getStringExtra("Salutation"));
    }

    public void save(View v){
        db.saveNew(nombre.getText().toString(),Integer.parseInt(edad.getText().toString()));
        Toast.makeText(this,"Guardado!",
                Toast.LENGTH_SHORT).show();
    }
    public void search(View v){
        if(id.getText().toString().equals("")){
            Toast.makeText(this,"Deberías ingresar un valor en el id para poder buscar",
                    Toast.LENGTH_LONG).show();
        }
        else{
            String result[]=db.searchByID(Integer.parseInt(id.getText().toString()));
            nombre.setText(result[0]);
            edad.setText(result[1]);

        }

    }
    public void regresar(View v){
        Intent info = new Intent();
        info.putExtra("id",id.getText().toString());
        setResult(Activity.RESULT_OK,info);
        finish();
    }
}