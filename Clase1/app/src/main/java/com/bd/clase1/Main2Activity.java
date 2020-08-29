package com.bd.clase1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    private EditText name, grade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //retrieve the intent used to open up this activity
        Intent intentote=getIntent();
        String nombre=intentote.getStringExtra("nombre");
        String apellido=intentote.getStringExtra("apellido");

        Toast.makeText(this,nombre+" "+apellido,Toast.LENGTH_SHORT).show();

        name=findViewById(R.id.editTextName);
        name=findViewById(R.id.editTextGrade);
    }
    public void returnToActivity(View v){
        Intent intent = new Intent();
        intent.putExtra("name",name.getText().toString());
        intent.putExtra("grade",grade.getText().toString());

        setResult(Activity.RESULT_OK,intent);
        finish();
    }
}
