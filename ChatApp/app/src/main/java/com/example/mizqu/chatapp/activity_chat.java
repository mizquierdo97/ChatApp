package com.example.mizqu.chatapp;



import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import java.util.Timer;
import java.util.TimerTask;
import android.os.AsyncTask;
import android.os.Message;
import android.view.View;
import android.util.Log;

import java.util.logging.Logger;
import java.util.ArrayList;

import edu.upc.citm.francesc.dmobchat2.MessageREST;


public class activity_chat extends Activity{

    private ListView conversation;
    private EditText input_text;
    private MyAdapter adapter_wl;
    private ArrayList<String> messages;
    //private boolean align_to_the_right;

    @Override
    protected void onCreate(Bundle icicle)
    {
        super.onCreate(icicle);
        setContentView(R.layout.activity_chat);

        String[] string_array = readArgs();

        TextView nick = (TextView) findViewById(R.id.text_nick);
        nick.setText(string_array[0] + "@" + string_array[1] + ":" + string_array[2]);

        //scrollView = (ScrollView)findViewById(R.id.scrollview);
        conversation = (ListView) findViewById(R.id.conversation);
        messages = new ArrayList<String>();
        adapter_wl = new MyAdapter(this, messages);
        conversation.setAdapter(adapter_wl);
        input_text = (EditText) findViewById(R.id.input);

    }

    String[] readArgs()
    {

        Bundle extra_bundle = getIntent().getExtras();
        String[] ret = extra_bundle.getStringArray("Arguments");

        return ret;
    }

    public void addText(final View view) {

        if(input_text.getEditableText().toString().equals(""))
            return;

        messages.add(input_text.getEditableText().toString());
        input_text.setText("");
        conversation.post(new Runnable() {
            @Override
            public void run() {
                conversation.setSelection(conversation.getCount() - 1);
            }
        });

        //EXECUTE ASYNC TASK
        MyAsyncTask new_task = new MyAsyncTask();
        new_task.execute();

        adapter_wl.notifyDataSetChanged();
    }

    private class MyAsyncTask extends AsyncTask<com.example.mizqu.chatapp.Message,Void,String> {

        @Override
        protected String doInBackground(com.example.mizqu.chatapp.Message ... message) {

        //TODO FIX THIS
          // MessageREST.create("citmalumnes.upc.es","0000",message);
            Timer new_timer = new Timer();
            new_timer.schedule(new TimerTask() {
                @Override
                public void run() {

                    //TODO CALL RETRIEVE DATA
                   // MessageREST.retrieveFromDate()
                }
            },10000);
            return "";
        }
    }
}


