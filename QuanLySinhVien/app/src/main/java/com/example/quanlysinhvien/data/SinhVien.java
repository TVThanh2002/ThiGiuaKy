package com.example.quanlysinhvien.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity()
public class SinhVien {
    @PrimaryKey(autoGenerate = true)
    public int id = 0;
    @ColumnInfo
    public String fullName;
    @ColumnInfo
    public String email;
    @ColumnInfo
    public String Contact;
    @ColumnInfo
    public String Address;

    public SinhVien() {
    }

    public SinhVien(String fullName, String email, String contact, String address) {
        this.fullName = fullName;
        this.email = email;
        Contact = contact;
        Address = address;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
