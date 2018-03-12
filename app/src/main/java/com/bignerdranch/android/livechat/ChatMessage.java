package com.bignerdranch.android.livechat;

import java.util.Date;

/**
 * Created by sarthak on 10-03-2018.
 */

public class ChatMessage {
    private String mMessageText;
    private String mMessageUser;
    private long mMessageTime;

    public ChatMessage()
    {

    }

    public ChatMessage(String text,String user)
    {
        mMessageText = text;
        mMessageUser = user;
        mMessageTime = new Date().getTime();
    }

    public String getMessageText() {
        return mMessageText;
    }

    public void setMessageText(String messageText) {
        mMessageText = messageText;
    }

    public String getMessageUser() {
        return mMessageUser;
    }

    public void setMessageUser(String messageUser) {
        mMessageUser = messageUser;
    }

    public long getMessageTime() {
        return mMessageTime;
    }

}
