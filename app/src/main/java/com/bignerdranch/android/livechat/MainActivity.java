package com.bignerdranch.android.livechat;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference dr = db.getReference();
    private FirebaseListAdapter<ChatMessage> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText input = (EditText)findViewById(R.id.edit_text_input);
                String message = input.getText().toString();
                dr.push().setValue(new ChatMessage(message,"Anonymous"));
                input.setText("");

            }
        });
        displayChatMessage();
    }
    private void displayChatMessage()
    {
        ListView list_messages = (ListView)findViewById(R.id.list_messages);
        adapter = new FirebaseListAdapter<ChatMessage>(this,ChatMessage.class,R.layout.message,dr) {
            @Override
            protected void populateView(View v, ChatMessage model, int position) {
                TextView message_text = (TextView)v.findViewById(R.id.message_text);
                TextView message_user = (TextView)v.findViewById(R.id.message_user);
                TextView message_time = (TextView) v.findViewById(R.id.message_time);
                message_text.setText(model.getMessageText());
                message_user.setText(model.getMessageUser());
                message_time.setText(DateFormat.format("dd-MM-yyyy (HH:mm:ss)",
                        model.getMessageTime()));
            }
        };
        list_messages.setAdapter(adapter);
    }
}
