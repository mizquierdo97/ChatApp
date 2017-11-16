package com.example.mizqu.chatapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;

public class activity_aut extends AppCompatActivity {
    private EditText txtName;
    private EditText txtIP;
    private EditText txtPort;
    private Button btnConnect;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aut);


        txtName = (EditText)findViewById(R.id.Name_label);
        txtPort = (EditText)findViewById(R.id.Port_label);
        txtIP = (EditText)findViewById(R.id.IP_lable);
        btnConnect = (Button)findViewById(R.id.Connect_button);

        btnConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el Intent
                Intent intent =
                        new Intent(activity_aut.this, activity_chat.class);

                //Creamos la información a pasar entre actividades
                Bundle b = new Bundle();
                b.putString("Name", txtName.getText().toString());
                b.putString("IP", txtIP.getText().toString());
                b.putString("Port",txtPort.getText().toString());

                //Añadimos la información al intent
                intent.putExtras(b);

                //Iniciamos la nueva actividad
                startActivity(intent);
            }
        });
    }


}
