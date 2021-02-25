package com.example.sqlitedatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterDisplayContactList extends RecyclerView.Adapter<AdapterDisplayContactList.MyHolder> {

    private Context context;
    private List<Contact> contacts ;
    private  DatabaseHandler db;

    public AdapterDisplayContactList(Context context,List<Contact> contacts){
        this.context = context;
        this.contacts = contacts;

    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_display_contactlist,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

        holder.txtname.setText(contacts.get(position).getContact_name());
        holder.txtemail.setText(contacts.get(position).getContact_email());
        holder.txtmobileNo.setText(contacts.get(position).getContact_mobileNo());
        holder.txtpassword.setText(contacts.get(position).getContact_password());

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                db = new DatabaseHandler(context);
                db.deleteContact(contacts.get(position));
                Toast.makeText(context,"you deleted: "+contacts.get(position).getContact_name(),Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        TextView txtname;
        TextView txtemail;
        TextView txtpassword;
        TextView txtmobileNo;
        Button btnDelete;


        public MyHolder(@NonNull View itemView) {
            super(itemView);

            txtname = itemView.findViewById(R.id.txtname);
            txtemail = itemView.findViewById(R.id.txtemail);
            txtpassword = itemView.findViewById(R.id.txtpassword);
            txtmobileNo = itemView.findViewById(R.id.txtmobileno);
            btnDelete = itemView.findViewById(R.id.btn_delete);

        }
    }
}
