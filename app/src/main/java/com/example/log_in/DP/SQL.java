package com.example.log_in.DP;

import android.graphics.Bitmap;

public class SQL {
    private String Name;
    private String Email;
    private String Gender;
    private String Passward;
    private Bitmap B;
    private int ID = -1;

    public int getID() {
        return ID;
    }

    public SQL(String email, String name, String gender, String passward, Bitmap b) {
        Name = name;
        Email = email;
        Gender = gender;
        Passward = passward;
        B = b;
    }

    public SQL(String email, String name, String gender, String passward,int ID) {
        Name = name;
        Email = email;
        Gender = gender;
        Passward = passward;
        this.ID = ID;
    }

    public SQL(String email, String name, String gender, String passward) {
        Name = name;
        Email = email;
        Gender = gender;
        Passward = passward;
    }

    public SQL(String email, String name, String gender) {
        Name = name;
        Email = email;
        Gender = gender;
    }

    public String getName() {
        return Name;
    }

    public String getEmail() {
        return Email;
    }

    public String getGender() {
        return Gender;
    }

    public String getPassward() {
        return Passward;
    }

    public void setPassward(String passward) {
        Passward = passward;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public void setB(Bitmap b) {
        B = b;
    }

    public Bitmap getB() {
        return B;
    }

}
