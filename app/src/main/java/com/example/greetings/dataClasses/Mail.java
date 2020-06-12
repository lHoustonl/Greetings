package com.example.greetings.dataClasses;

import java.io.Serializable;
import java.util.Calendar;

public class Mail implements Serializable {
    long dateInMS;
    String title, sender, message, recipient;
    boolean checked;

    public Mail(){
    }

    public Mail(String title, String message, String sender, String recipient){
        this.dateInMS = Calendar.getInstance().getTimeInMillis();
        this.title = title;
        this.message = message;
        this.checked = false;
        this.recipient = recipient;
    }

    public long getDateInMS() {return dateInMS;}

    public String getTitle() {return title;}

    public String getSender() {return sender;}

    public String getMessage() {return message;}

    public boolean isChecked() {return checked;}

    public String getRecipient() {return recipient;}
}
