package com.mariamanuel.entrylog;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
EditText e1,e2;
AppCompatButton b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        SharedPreferences preference=getSharedPreferences("Logapp",MODE_PRIVATE);
        String username=preference.getString("user",null);
        if(username!=null)
        {
            Intent i=new Intent(getApplicationContext(),Logined.class);
            startActivity(i);
        }
e1=(EditText) findViewById(R.id.uname);
e2=(EditText) findViewById(R.id.pass);
b1=(AppCompatButton) findViewById(R.id.lobtn);
b1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String getUsername=e1.getText().toString();
        String getPassword=e2.getText().toString();
        if(getUsername.equals("admin")&&getPassword.equals("12345"))
        {
            SharedPreferences preference=getSharedPreferences("Logapp",MODE_PRIVATE);
            SharedPreferences.Editor editor=preference.edit();
         editor.putString("user","admin");
            editor.apply();
          Intent i=new Intent(getApplicationContext(),Logined.class);
          startActivity(i);
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Invalid Credentials", Toast.LENGTH_SHORT).show();
        }
        }
});
    }
}