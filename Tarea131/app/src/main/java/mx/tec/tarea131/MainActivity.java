package mx.tec.tarea131;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText name;

    private static final int MENU_CODE = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.personName);

    }
    public void launchMenu(View v){
        Intent menu = new Intent(this, MenuActivity.class);

        menu.putExtra("name",name.getText().toString());

        startActivityForResult(menu,MENU_CODE);

    }

}