package com.example.mizqu.chatapp;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class activity_auth extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        ((Button) findViewById(R.id.connect_button)).setOnClickListener(this);

    }

    public void onClick(View act_view)
    {
        if(act_view == findViewById(R.id.connect_button))
        {
            String[] args = null;

            args = new String[3];

            EditText nick = (EditText)findViewById(R.id.input_nick);
            EditText port = (EditText)findViewById(R.id.input_port);
            EditText server = (EditText)findViewById(R.id.input_server);

            args[0] = nick.getText().toString();
            args[1] = port.getText().toString();
            args[2] = server.getText().toString();

            startActivity(activity_chat.class, args);
        }
    }

    public void startActivity(Class<?> next, String[] args)
    {
        Bundle arguments = new Bundle();
        arguments.putStringArray("Arguments", args);

        Intent act_intent = new Intent(this, next);
        act_intent.putExtras(arguments);

        startActivity(act_intent);
    }
}