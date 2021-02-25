package com.example.sqlitedatabase;

public class Contact {

//    private String id;
    private String contact_name;
    private String contact_email;
    private String contact_password;
    private String contact_mobileNo;


    Contact(){

    }

    public Contact( String contact_name) {
//        this.id = id;
        this.contact_name = contact_name;
    }

    public Contact(String contact_name,String contact_email, String contact_password, String contact_mobileNo) {
        this.contact_name = contact_name;
        this.contact_email = contact_email;
        this.contact_password = contact_password;
        this.contact_mobileNo = contact_mobileNo;
    }
    //    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }


    public String getContact_email() {
        return contact_email;
    }

    public void setContact_email(String contact_email) {
        this.contact_email = contact_email;
    }

    public String getContact_password() {
        return contact_password;
    }

    public void setContact_password(String contact_password) {
        this.contact_password = contact_password;
    }

    public String getContact_mobileNo() {
        return contact_mobileNo;
    }

    public void setContact_mobileNo(String contact_mobileNo) {
        this.contact_mobileNo = contact_mobileNo;
    }

    public String getContact_name() {
        return contact_name;
    }

    public void setContact_name(String contact_name) {
        this.contact_name = contact_name;
    }
}
