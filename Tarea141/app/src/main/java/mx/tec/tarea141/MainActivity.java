package mx.tec.tarea141;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class MainActivity extends AppCompatActivity {
    private static final String PROPERTIES_FILE = "propertiesFile.xml";
    private Properties properties;

    private TextView salutation,
                      greeting;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        salutation=findViewById(R.id.textView);
        greeting=findViewById(R.id.textView2);

        properties = new Properties();
        File file = new File(getFilesDir(),PROPERTIES_FILE);
        if(file.exists()){
            try{
                FileInputStream inputStream = openFileInput (PROPERTIES_FILE);
                properties.loadFromXML(inputStream);
                inputStream.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        else{
            saveToMemory("salutation","¡Adelante,");
            saveToMemory("greet","amigo!");
            saveProperties();
        }
        salutation.setText(properties.get("salutation").toString());
        greeting.setText(properties.get("greet").toString());

    }
    public void saveToMemory(String key, String value){
        properties.put(key,value);
    }
    public void saveProperties(){
        try{
            FileOutputStream outputStream = openFileOutput(PROPERTIES_FILE, Context.MODE_PRIVATE);
            properties.storeToXML(outputStream,null);
            outputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void launchMyHobbies(View v){
        Intent act = new Intent(this,MyHobbies.class);
        startActivity(act);
    }
    public void launchMyFriends(View v){
        Intent act = new Intent(this,MyFriends.class);
        startActivity(act);
    }
}