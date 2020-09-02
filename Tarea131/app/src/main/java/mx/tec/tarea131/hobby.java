package mx.tec.tarea131;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class hobby extends AppCompatActivity {
    EditText info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hobby);
        info=findViewById(R.id.hobbyname);
    }

    public void returnToMenu(View v){

        Intent intent = new Intent();
        intent.putExtra("hobby", info.getText().toString());
        // how to actually set information to be "sent" back
        setResult(Activity.RESULT_OK, intent);
        finish();

    }
}