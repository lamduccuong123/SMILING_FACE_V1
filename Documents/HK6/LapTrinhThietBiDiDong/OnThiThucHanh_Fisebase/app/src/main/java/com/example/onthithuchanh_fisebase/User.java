package com.example.onthithuchanh_fisebase;

import java.util.Date;
import java.util.List;

public class User {
    private String email;
    private String HoTen;
    private String ngaySinh;
    private int picture;

    public User() {

    }

    public User(String email, String hoTen, String ngaySinh, int picture) {
        this.email = email;
        HoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.picture = picture;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {

        this.ngaySinh = ngaySinh;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }
}
