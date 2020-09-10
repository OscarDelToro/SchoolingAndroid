package mx.tec.oscardeltoro;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText text;

    private static final int DB_CODE=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text=findViewById(R.id.editTextTextPersonName);
    }
    protected void onActivityResult(int Code, int resultCode, @Nullable Intent data){
        super.onActivityResult(Code,resultCode,data);
        if(DB_CODE == Code && Activity.RESULT_OK == resultCode){
            //hacer algo con el result
            Toast.makeText(this,"ID: "+data.getStringExtra("id"),Toast.LENGTH_LONG).show();

        }
    }




    public void launchDB(View v){
        Intent db = new Intent(this,DBActivity.class);
        db.putExtra("Salutation",text.getText().toString());
        startActivityForResult(db,DB_CODE);
    }
    public void launchRecord(View v){
        Intent n = new Intent(this,RecordActivity.class);
        startActivity(n);
    }

}