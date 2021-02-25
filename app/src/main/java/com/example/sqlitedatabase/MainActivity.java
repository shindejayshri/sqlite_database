package com.example.sqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btn_Display_list,btn_add_contact,btn_display;
    DatabaseHandler db = new DatabaseHandler(this);

    private String URL ="https://jsonplaceholder.typicode.com/posts";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_Display_list = findViewById(R.id.btn_display);

        btn_add_contact = findViewById(R.id.btnAddcontact);
        btn_display = findViewById(R.id.btn_display);


        btn_add_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,AddContactActivity.class);
                startActivity(intent);
              //AddContact();
            }
        });

        btn_display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(MainActivity.this,DisplayActivity.class);
                startActivity(intent);
                DisplayList();
            }
        });

//        btn_Display_list.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                DisplayList();
//            }
//        });


    }



    private void AddContact() {

        Log.e("insert:","inserting");


//        db.addContact(new Contact("nishad"));
//        db.addContact(new Contact("nisha"));

        Log.d("reading:" ,"reading all data");

    }

  private void DisplayList() {



    }


}