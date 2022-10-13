package com.example.onthithuchanh_fisebase;

public class Picture {
    private String ten;
    private String tacGia;
    private int picture;

    public Picture() {
    }

    public Picture(String ten, String tacGia, int picture) {
        this.ten = ten;
        this.tacGia = tacGia;
        this.picture = picture;
    }


    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }
}
