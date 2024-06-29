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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Logined extends AppCompatActivity {
EditText e1,e2,e3,e4;
AppCompatButton b1,b2;
String apiurl="http://10.0.4.16:3000/api/students";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_logined);
        e1 = (EditText) findViewById(R.id.per);
        e2 = (EditText) findViewById(R.id.ano);
        e3 = (EditText) findViewById(R.id.depname);
        e4 = (EditText) findViewById(R.id.sysno);
        b1 = (AppCompatButton) findViewById(R.id.addbtn);
        b2 = (AppCompatButton) findViewById(R.id.logoutbtn);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences preference = getSharedPreferences("Logapp", MODE_PRIVATE);
                SharedPreferences.Editor editor = preference.edit();
                editor.clear();
                editor.apply();
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //value reading
                String getName = e1.getText().toString();
                String getAdmno = e2.getText().toString();
                String getDeptname = e3.getText().toString();
                String getSysno = e4.getText().toString();

//JSON object creation
                JSONObject student = new JSONObject();
                try {
                    student.put("name", getName);
                    student.put("admission_number", getAdmno);
                    student.put("department", getDeptname);
                    student.put("system_number", getSysno);
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
                //JSON object request creation

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                        Request.Method.POST,
                        apiurl,
                        student,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                Toast.makeText(getApplicationContext(), "Added", Toast.LENGTH_LONG).show();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_LONG).show();
                            }
                        }

                );
                //Request queue
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                requestQueue.add(jsonObjectRequest);
            }
        });


    }
}

