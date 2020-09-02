package mx.tec.tarea131;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    TextView greet;
    TextView hob;
    private static final int HOBBY_CODE=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        greet=findViewById(R.id.textView);
        hob=findViewById(R.id.textView2);
        Intent seed=getIntent();
        String name=seed.getStringExtra("name");

        greet.setText("Hi, "+name);
    }
    public void LaunchHobbies(View v){
        Intent menu = new Intent(this, hobby.class);
        startActivityForResult(menu,HOBBY_CODE);
    }
    public void LaunchFriends(View v){
        Intent friend= new Intent(this, MyFriends.class);
        startActivity(friend);
    }
    public void LaunchMessage(View v){
        Intent friend= new Intent(this, Message.class);
        startActivity(friend);
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == HOBBY_CODE && resultCode == Activity.RESULT_OK){
            hob.setText(data.getStringExtra("hobby"));
        }
    }
}