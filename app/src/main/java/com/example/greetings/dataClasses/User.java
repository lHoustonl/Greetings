package com.example.greetings.dataClasses;

import com.example.greetings.MainActivity;
import com.example.greetings.Utils;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;

public class User {
    private String username, email, password, phone;

    public User() { }

    public String getUsername()
    {
        return username;
    }

    public String getEmail()
    {
        return email;
    }

    public String getPassword()
    {
        return password;
    }

    public String getPhone()
    {
        return phone;
    }

    @Exclude
    public DatabaseReference getReference(){
        return
                MainActivity.firebaseDatabase
                .getReference()
                .child("user")
                .child(Utils.md5Custom(email));
    }

    public void RegisterNewUserInDatabase(String username, String email, String password, String phone,
                                          OnSuccessListener<Void> slistener,
                                          OnFailureListener flistener){
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone = phone;

        getReference()
                .setValue(this)
                .addOnSuccessListener(slistener)
                .addOnFailureListener(flistener);
    }
}
