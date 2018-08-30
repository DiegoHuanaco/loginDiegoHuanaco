package com.example.diego.logindiegohuanaco.activities;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.diego.logindiegohuanaco.R;
import com.example.diego.logindiegohuanaco.adapters.MyAdapter;
import com.example.diego.logindiegohuanaco.models.Empleados;

import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

public class Login extends AppCompatActivity {


    private Button btnLogin;
    private EditText rut;
    private EditText pass;



    private RealmResults<Empleados> empleado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Realm.init(getApplicationContext());
        btnLogin = (Button) findViewById(R.id.buttonLogin);
        rut = (EditText) findViewById(R.id.editTextRut);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rut.equals(""))
                {
                    Toast.makeText(Login.this, "No ingreso datos", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    Intent intent = new Intent(Login.this, Muestra.class);
                    startActivity(intent);
                }
            }
        });


    }


}
