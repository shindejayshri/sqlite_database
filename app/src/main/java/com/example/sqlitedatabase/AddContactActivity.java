package com.example.sqlitedatabase;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import org.w3c.dom.Text;

public class AddContactActivity extends Activity {

    private EditText editText,edt_email,edt_password,edt_mobile;
    private Button btn_submit;
    private DatabaseHandler db = new DatabaseHandler(this);
//    private TextView textView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contacts);

        //init();

        editText = findViewById(R.id.edtname);
        edt_email = findViewById(R.id.edtemail);
        edt_password = findViewById(R.id.edtpassword);
        edt_mobile = findViewById(R.id.edtemail);

        btn_submit = findViewById(R.id.BtnSubmit);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (editText.getText().toString().trim().isEmpty()) {
                    editText.setError("enter name");
                    editText.requestFocus();
                }else if (edt_email.getText().toString().trim().isEmpty()){
                    edt_email.setError("Email");
                    edt_email.requestFocus();
                }
                else if(edt_mobile.getText().toString().trim().isEmpty()){
                    edt_mobile.setError("mobileNo");
                    edt_mobile.requestFocus();
                }
                else if(edt_password.getText().toString().trim().isEmpty()) {
                    edt_password.setError("password");
                    edt_password.requestFocus();
                }
                else {
                    String name = editText.getText().toString();
                    String email = edt_email.getText().toString();
                    String password = edt_password.getText().toString();
                    String mobileNo = edt_mobile.getText().toString();

                    Contact contact1 = new Contact();
                    contact1.setContact_name(name);
                    contact1.setContact_email(email);
                    contact1.setContact_mobileNo(mobileNo);
                    contact1.setContact_password(password);

                   db.addContact(contact1);

                    Toast.makeText(AddContactActivity.this, "contact added", Toast.LENGTH_SHORT).show();
                    editText.setText("");
                    edt_email.setText("");
                    edt_password.setText("");
                    edt_mobile.setText("");


                }


            }
        });
//        textView = findViewById(R.id.txtset);

//        textView.setText(editText.getText().toString());

//    }
//
//       private void init() {
//
//           Toast.makeText(this,"contact added",Toast.LENGTH_LONG).show();
//       }
    }

}
