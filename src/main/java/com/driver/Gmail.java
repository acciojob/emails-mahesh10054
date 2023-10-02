package com.driver;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Gmail extends Email {

    int inboxCapacity; //maximum number of mails inbox can store
    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)
    public Gmail(String emailId, int inboxCapacity) {
        super(emailId);
        this.inboxCapacity = inboxCapacity;
    }
    ArrayList<StoreMassage> inbox = new ArrayList<>();
    ArrayList<StoreMassage> trash = new ArrayList<>();
    public void receiveMail(Date date, String sender, String message){
        int n = inbox.size();
        if(n < inboxCapacity)
        {
            inbox.add(new StoreMassage(date,sender,message));
        }
        else {
            StoreMassage storeMessage = inbox.remove(0);
            trash.add(storeMessage);
            inbox.add(new StoreMassage(date,sender,message));
        }
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.

    }

    public void deleteMail(String message){
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing
        int count = 0;
        int index = -1;
        for (StoreMassage storeMassage: inbox)
        {
            if(storeMassage.getMessage().equals(message))
            {
                index = count;
                trash.add(storeMassage);
            }
            count++;
        }
        if(index != -1)
        {
            inbox.remove(index);
        }
    }

    public String findLatestMessage(){
        // If the inbox is empty, return null
        int n = inbox.size();
        if(n == 0) return null;

        // Else, return the message of the latest mail present in the inbox

        return inbox.get(n-1).getMessage();
    }

    public String findOldestMessage(){
        // If the inbox is empty, return null
        int n = inbox.size();
        if(n == 0) return null;

        // Else, return the message of the oldest mail present in the inbox
        return inbox.get(0).getMessage();
    }

    public int findMailsBetweenDates(Date start, Date end){
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date
        int count = 0;
        String str1 = start.toString();
        String[] starts = str1.split("/");

        String str2 = start.toString();
        String[] ends = str2.split("/");

        for (StoreMassage storeMassage:inbox) {
            Date date = storeMassage.getDate();
            String str = date.toString();
            String[] dates = str.split("/");
            

        }
        return count;
    }

    public int getInboxSize(){
        // Return number of mails in inbox
        return inbox.size();
    }

    public int getTrashSize(){
        // Return number of mails in Trash
        return trash.size();
    }

    public void emptyTrash(){
        // clear all mails in the trash
        trash.clear();
    }

    public int getInboxCapacity() {
        // Return the maximum number of mails that can be stored in the inbox
        return inboxCapacity;
    }
}
