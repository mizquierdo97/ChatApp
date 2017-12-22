package com.example.mizqu.chatapp;

import android.content.Context;
//import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.Serializable;
import java.text.SimpleDateFormat;
//import java.util.Calendar;
import java.util.Date;

public class LocalMessage extends Message implements Serializable {
    private static final long serialVersionUID = 1L;

    public LocalMessage(String m, String sender, Date d) {
        content = m;
        userSender = sender;
        date = d;
    }

    // view ------------------------
    class ViewHolder {
        TextView date, message;
    }

    @Override
    public View newFromResource(Context ctx, ViewGroup parent) {
    	View convertView = LayoutInflater.from(ctx).inflate(R.layout.row_whatsapp_right, parent, false);
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.date = (TextView) convertView.findViewById(R.id.date);
        viewHolder.message = (TextView) convertView.findViewById(R.id.message);
        convertView.setTag(viewHolder);

        return convertView;
    }

    @Override
    public void updateView(View convertView) {
        ViewHolder viewHolder = (ViewHolder) convertView.getTag();
        viewHolder.message.setText(content);
        viewHolder.date.setText(new SimpleDateFormat("HH:mm").format(date.getTime()));
    }

    @Override
    public int getItemViewType() {
        return 0;
    }
}
