package c.sakshi.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static String usernameKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameKey = "username";

        SharedPreferences sharedPreferences = getSharedPreferences("c.sakshi.lab5",Context.MODE_PRIVATE);

        if (!sharedPreferences.getString(usernameKey,"").equals("")) {
            //TextView myView = findViewById(R.id.myTextView);
            //myView.setText(sharedPreferences.getString(usernameKey,""));
            Intent intent = new Intent(MainActivity.this,NotesActivity.class);
            startActivity(intent);
        }else {
            setContentView(R.layout.activity_main);
        }
    }

    public void onClick(View v) {
        EditText myText = findViewById(R.id.nameInput);
        String str = myText.getText().toString();
        SharedPreferences sharedPreferences = getSharedPreferences("c.sakshi.lab5", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("username",str).apply();
        goToActivity2(str);
    }

    public void goToActivity2(String s) {
        Intent intent = new Intent(MainActivity.this,NotesActivity.class);
        startActivity(intent);
    }
}
