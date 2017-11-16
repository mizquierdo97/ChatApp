package com.example.mizqu.chatapp;

import android.content.Context;
import java.util.ArrayList;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.view.View;
import java.lang.String;
import android.widget.TextView;
import java.util.Date;
import android.widget.BaseAdapter;
import java.util.Calendar;
import com.example.mizqu.chatapp.R;


public class MyAdapter extends BaseAdapter {

    private Context cont;
    private ArrayList<String> messages;

    public MyAdapter(Context context, ArrayList<String> message) {

        this.messages = message;
        this.cont = context;
    }

    public View getView(int position, View conv_view, ViewGroup parent)
    {
        ViewHolder view_holder;

        if(conv_view==null){

            if(getItemViewType(position) == 0)
                conv_view = LayoutInflater.from(cont).inflate(R.layout.whats_local, parent, false);
            if(getItemViewType(position) == 1)
                conv_view = LayoutInflater.from(cont).inflate(R.layout.whats_remote, parent, false);
            if(getItemViewType(position) == 2)
                conv_view = LayoutInflater.from(cont).inflate(R.layout.whats_date, parent, false);

            view_holder = new ViewHolder();
            view_holder.mess  = (TextView) conv_view.findViewById(R.id.text);
            conv_view.setTag(view_holder);
        }

        view_holder = (ViewHolder)conv_view.getTag();

        if(getItemViewType(position) == 0 || getItemViewType(position) == 1) {

            view_holder.mess.setText(messages.get(position));

        }

        if(getItemViewType(position) == 2)
        {
            Date date = new Date();
            view_holder.mess.setText(date.toLocaleString());
        }

        return conv_view;
    }

    public Object getItem(int arg0) {
        return messages.get(arg0);
    }

    public long getItemId(int arg0) {
        return arg0;
    }

    @Override
    public int getItemViewType(int position) {

        return position % 3;
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }

    @Override
    public int getCount() {
        return messages.size();
    }

    private class ViewHolder {
        public TextView mess;
    }
}


