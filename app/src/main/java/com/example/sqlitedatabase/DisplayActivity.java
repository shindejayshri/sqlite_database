package com.example.sqlitedatabase;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DisplayActivity extends Activity {

    DatabaseHandler db = new DatabaseHandler(this);
    private AdapterDisplayContactList adapterDisplayContactList;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_activity);

        recyclerView = findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        List<Contact> contacts = db.getAllContact();

        adapterDisplayContactList = new AdapterDisplayContactList(DisplayActivity.this,contacts);
        recyclerView.setAdapter(adapterDisplayContactList);


        for (Contact cn : contacts){
            String log =  "name:" +cn.getContact_name() +"Mob: "+cn.getContact_email() +"pass: "+cn.getContact_password() +"email: "+cn.getContact_email();

            Log.e("name:",log);
        }

    }
}
