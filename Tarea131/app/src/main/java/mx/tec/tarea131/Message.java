package mx.tec.tarea131;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Message extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
    }
    public void sendMessage(View v){
        Toast.makeText(this,"Message sent" , Toast.LENGTH_SHORT).show();
        finish();
    }
}