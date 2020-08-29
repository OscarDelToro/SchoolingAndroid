package com.bd.clase1;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView hey;
    EditText input;
    Button b2;

    final int ACTIVITY2_CODE=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void interaction1(View v){
        Toast.makeText(this,"button pressed",Toast.LENGTH_SHORT).show();



        Intent intentito=new Intent(this, Main2Activity.class);
        intentito.putExtra("nombre", "Oscar");
        intentito.putExtra("apellido","del toro");
        //easy way to start a new activity bc it doesnt expect a return
        // startActivity(intentito);

        //second way: expecting a result
    startActivityForResult(intentito,ACTIVITY2_CODE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(this,"Returning!",Toast.LENGTH_LONG).show();
    }

}
