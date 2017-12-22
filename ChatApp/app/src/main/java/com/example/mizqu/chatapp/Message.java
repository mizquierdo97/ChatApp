package com.example.mizqu.chatapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by francesc on 02/10/16.
 */
public abstract class Message implements Serializable {
    private static final long serialVersionUID = 1L;

    protected Integer id;
    protected String content;
    protected String userSender;
    protected Date date;

    // view ------------------------
    abstract View newFromResource(Context ctx, ViewGroup parent);
    abstract void updateView(View v);
    abstract int getItemViewType();
    
    public View getView(Context ctx, View convertView, ViewGroup parent) {
    	if (convertView == null)
    		convertView = newFromResource(ctx, parent);
    	updateView(convertView);
    	return convertView;
    }

    // pojo ------------------------
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserSender() {
        return userSender;
    }

    public void setUserSender(String userSender) {
        this.userSender = userSender;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Message)) {
            return false;
        }
        Message other = (Message) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "practica2.Message[ id=" + id + " ]";
    }
}
