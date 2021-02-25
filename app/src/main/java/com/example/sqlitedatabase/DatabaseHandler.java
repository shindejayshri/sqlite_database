package com.example.sqlitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "contact manager";
    private static final String CONTACT_TABLE = "contact";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_MOBILE_NO = "mobileNo";

    public DatabaseHandler( Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        //String CREATE_CONTACTS_TABLE = "CREATE TABLE "+CONTACT_TABLE+ "( "+KEY_ID+" INTEGER_PRIMARY_KEY,"+KEY_NAME+" TEXT"+")" ;

        String CREATE_CONTACTS_TABLE = "CREATE TABLE "+CONTACT_TABLE+ "( "+KEY_ID+" INTEGER_PRIMARY_KEY,"+KEY_NAME+" TEXT ,"
                +KEY_EMAIL+" TEXT ," +KEY_PASSWORD+ " TEXT ," +KEY_MOBILE_NO+ " TEXT"+ ")" ;



        db.execSQL(CREATE_CONTACTS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(" DROP TABLE IF EXISTS " +CONTACT_TABLE);

        onCreate(db);

    }

    //ADD NEW CONTACT

   public void addContact(Contact contact){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME,contact.getContact_name());
        values.put(KEY_EMAIL,contact.getContact_email());
        values.put(KEY_MOBILE_NO,contact.getContact_mobileNo());
        values.put(KEY_PASSWORD,contact.getContact_password());


        // insert row
        db.insert(CONTACT_TABLE,null,values);

        //close database
        db.close();
    }
    //code to get single contact

//    Contact getContact(int id){
//
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        Cursor cursor = db.query(CONTACT_TABLE,new String[] {
//                KEY_ID,KEY_NAME},KEY_ID+ "=?",
//                new String[] { String.valueOf(id)},null,null,null,null);
//
//        if (cursor!=null){
//            cursor.moveToFirst();
//        }
////
////      Contact contact =  new Contact(Integer.parseIntent(cursor.getString(0)),
////              cursor.getString(1));
//
////        Contact contact = new Contact(Integer.parseInt(cursor.getString(0)),
////                cursor.getString(1));
//        return contact;
//
//
//
//    }



    public void deleteContact(Contact contact){

         SQLiteDatabase db = this.getWritableDatabase();

          db.delete(CONTACT_TABLE,KEY_NAME +"=?",new String[] {String.valueOf(contact.getContact_name())});
          db.close();


    }

    //code to get all contact

    public List<Contact> getAllContact(){

        List<Contact> contactList = new ArrayList<Contact>();

        String selectQuery = " SELECT * FROM " +CONTACT_TABLE;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery,null);

        if(cursor.moveToFirst()){


            do {
                Contact contact = new Contact();
//                contact.setId(Integer.valueOf(cursor.getString(0)));
                contact.setContact_name(cursor.getString(1));
                contact.setContact_email(cursor.getString(2));
                contact.setContact_password(cursor.getString(3));
                contact.setContact_mobileNo(cursor.getString(4));

                contactList.add(contact);

            }while (cursor.moveToNext());

        }
            return contactList;
        }
    }


