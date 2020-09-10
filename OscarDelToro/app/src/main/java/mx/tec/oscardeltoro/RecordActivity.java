package mx.tec.oscardeltoro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class RecordActivity extends AppCompatActivity {
    TextView viejo,nombre;
    DBHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        db= new DBHelper(this);

        viejo=findViewById(R.id.mas_viejo);
        nombre=findViewById(R.id.primer_nombre);
        String old=db.getOldName();
        String name=db.getFirstName();
        old=old.equals("")?"db vacía":"Más viejo: "+old;
        name=name.equals("")?"db vacía":"Primer nombre: "+name;
        viejo.setText(old);
        nombre.setText(name);
    }

}