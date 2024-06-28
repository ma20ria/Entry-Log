package com.mariamanuel.entrylog;

import android.content.Intent;
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

public class Logined extends AppCompatActivity {
EditText e1,e2,e3,e4;
AppCompatButton b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_logined);
e1=(EditText) findViewById(R.id.per);
e2=(EditText) findViewById(R.id.ano);
e3=(EditText) findViewById(R.id.depname);
e4=(EditText) findViewById(R.id.sysno);
b1=(AppCompatButton) findViewById(R.id.addbtn);
b2=(AppCompatButton) findViewById(R.id.logoutbtn);
b2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
    }
});
b1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String getName=e1.getText().toString();
        String getAdmno=e2.getText().toString();
        String getDeptname=e3.getText().toString();
        String getSysno=e4.getText().toString();
        Toast.makeText(getApplicationContext(),getName+" "+getAdmno+" "+getDeptname+" "+getSysno , Toast.LENGTH_SHORT).show();
    }
});
    }
}