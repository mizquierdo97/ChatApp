package com.example.mizqu.chatapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class RemoteMessage extends Message implements Serializable {
    private static final long serialVersionUID = 1L;

    public RemoteMessage(String m, String sender, Date d) {
        content = m;
        userSender = sender;
        date = d;
        //name = n;
    }

    // view ------------------------
	class ViewHolder {
        TextView message, sender, date;
    }

    @Override
    public View newFromResource(Context ctx, ViewGroup parent) {
    	View convertView = LayoutInflater.from(ctx).inflate(R.layout.row_whatsapp_left, parent, false);
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.message = (TextView) convertView.findViewById(R.id.message);
        viewHolder.sender = (TextView) convertView.findViewById(R.id.sender);
        viewHolder.date = (TextView) convertView.findViewById(R.id.date);
        convertView.setTag(viewHolder);
        return convertView;
    }
    
    @Override
    public void updateView(View convertView) {
        ViewHolder viewHolder = (ViewHolder) convertView.getTag();
        viewHolder.message.setText(content);
        viewHolder.sender.setText(userSender);
        viewHolder.date.setText(new SimpleDateFormat("HH:mm").format(date.getTime()));
    }

    @Override
    public int getItemViewType() {
        return 1;
    }
}
